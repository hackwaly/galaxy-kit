/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.zhjh.galaxykit.utils;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.core.runtime.Assert;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;


/**
 * A <code>Reader</code> that reads from an <code>IDocument</code>.
 * The reader ensures that its content is the same as the document
 * content when the stream was created.
 * <p>
 * Note that {@link #close()} must be called to release any acquired
 * resources.
 * </p>
 *
 * @since 3.1
 */
public
class DocumentReader extends Reader {

    /**
     * Document based character sequence.
     */
    private static class DocumentCharSequence implements CharSequence {

        /** Document */
        private IDocument fDocument;

        /**
         * Initialize with the sequence of characters in the given
         * document.
         *
         * @param document the document
         */
        public DocumentCharSequence(IDocument document) {
            fDocument= document;
        }

        /*
         * @see java.lang.CharSequence#length()
         */
        public int length() {
            return fDocument.getLength();
        }

        /*
         * @see java.lang.CharSequence#charAt(int)
         */
        public char charAt(int index) {
            try {
                return fDocument.getChar(index);
            } catch (BadLocationException x) {
                throw new IndexOutOfBoundsException(x.getLocalizedMessage());
            }
        }

        /*
         * @see java.lang.CharSequence#subSequence(int, int)
         */
        public CharSequence subSequence(int start, int end) {
            try {
                return fDocument.get(start, end - start);
            } catch (BadLocationException x) {
                throw new IndexOutOfBoundsException(x.getLocalizedMessage());
            }
        }
    }

    /**
     * Internal document listener.
     */
    private class InternalDocumentListener implements IDocumentListener {

        /*
         * @see org.eclipse.jface.text.IDocumentListener#documentAboutToBeChanged(org.eclipse.jface.text.DocumentEvent)
         */
        public void documentAboutToBeChanged(DocumentEvent event) {
            handleDocumentAboutToBeChanged();
        }

        /*
         * @see org.eclipse.jface.text.IDocumentListener#documentChanged(org.eclipse.jface.text.DocumentEvent)
         */
        public void documentChanged(DocumentEvent event) {
        }
    }

    /** The character sequence. */
    private volatile CharSequence fCharSequence;

    /** Document length. */
    private int fLength;

    /** The current offset. */
    private int fOffset= 0;

    /** The document. */
    private IDocument fDocument;

    /** The document listener. */
    private IDocumentListener fDocumentListener= new InternalDocumentListener();

    /**
     * Creates a new document input stream and initializes
     * the stream to read from the given document.
     *
     * @param document the document
     */
    public DocumentReader(IDocument document) {
        Assert.isNotNull(document);
        fDocument= document;
        fCharSequence= new DocumentCharSequence(fDocument);
        // avoid the event circle.
        fDocument.addDocumentListener(fDocumentListener);
        fLength= fCharSequence.length();
    }

    public DocumentReader(IDocument document, int offset, int length) {
	this(document);
	fOffset = offset;
	fLength = offset + length;
    }
    
    /*
     * @see java.io.InputStream#close()
     */
    public void close() throws IOException {
        synchronized (this) {
            fCharSequence= null;
        }
        releaseDocument();
    }

    /**
     * Copies the document prior to modification and removes the document listener.
     */
    private void handleDocumentAboutToBeChanged() {
        IDocument document= fDocument;
        if (fCharSequence == null || document == null)
            return;
        String content= document.get();
        synchronized (this) {
            if (fCharSequence == null)
                return;
            fCharSequence= content;
        }
        releaseDocument();
    }

    /**
     * Removes the document listener.
     */
    private synchronized void releaseDocument() {
        if (fDocument != null)
            fDocument.removeDocumentListener(fDocumentListener);
        fDocument= null;
        fDocumentListener= null;
    }

    /*
     * @see java.io.Reader#read(char[], int, int)
     * @since 3.1
     */
    public int read(char[] cbuf, int off, int len) throws IOException {
        int i= 0;
        try {
            for (; i < len && fOffset < fLength; i++)
                cbuf[off + i]=  fCharSequence.charAt(fOffset++);
            if (i > 0)
                return i;

            return -1;
        } catch (NullPointerException x) {
            throw new IOException(x);
        } catch (IndexOutOfBoundsException x) {
            return i-1;
        }
    }
}
