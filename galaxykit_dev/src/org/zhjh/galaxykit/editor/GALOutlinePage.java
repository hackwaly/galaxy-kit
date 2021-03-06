package org.zhjh.galaxykit.editor;

import java.util.ArrayList;

import org.antlr.runtime.tree.Tree;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.zhjh.galaxykit.parser.GalaxyParser;

public class GALOutlinePage extends ContentOutlinePage {

	private GALOutlinePageContentProvider contentProvider;
	private GALOutlinePageLabelProvider labelProvider;
	private Tree content;

	GALOutlinePage() {
		super();
		contentProvider = new GALOutlinePageContentProvider();
		labelProvider = new GALOutlinePageLabelProvider();
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		final TreeViewer viewer = getTreeViewer();
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(labelProvider);
		update();
	}

	@Override
	public void dispose() {
		if (contentProvider != null) {
			contentProvider.dispose();
			contentProvider = null;
		}
		if (labelProvider != null) {
			labelProvider.dispose();
			labelProvider = null;
		}
		super.dispose();
	}

	public void setInput(Tree ast) {
		final TreeViewer viewer = getTreeViewer();
		content = ast;
		if (viewer != null) {
			viewer.setInput(ast);
		}
		update();
	}

	public void update() {
		final TreeViewer viewer = getTreeViewer();
		if (viewer != null) {
			final Control control = viewer.getControl();
			if (control != null && !control.isDisposed()) {
				control.setRedraw(false);
				if (content != null) {
					viewer.refresh(content, true);
				}
				control.setRedraw(true);
			}
		}
	}

	private class GALOutlinePageContentProvider implements IContentProvider,
			ITreeContentProvider {

		private Tree ast;

		@Override
		public void dispose() {
			ast = null;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			ArrayList<Tree> children = new ArrayList<Tree>();
			if (parentElement instanceof Tree) {
				final Tree parent = (Tree) parentElement;
				if (parent.getChildCount() > 0) {
					for (int i = 0; i < parent.getChildCount(); i++) {
						final Tree node = parent.getChild(i);
						if (node.getType() == GalaxyParser.FUNCTION) {
							children.add(node);
						}
					}
				}
			}
			return children.toArray();
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof Tree) {
				return ((Tree) element).getParent();
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return getChildren(element) != null
					&& getChildren(element).length != 0;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(ast);
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput instanceof Tree) {
				ast = (Tree) newInput;
			}
		}
	}

	private class GALOutlinePageLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof Tree) {
				final Tree node = (Tree)element;
				if (node.getType() == GalaxyParser.FUNCTION) {
					String name = node.getChild(0).getText();
					String type = node.getChild(1).getText();
					return type.equals("void") ? name : name + " : " + type;
				}
			}
			return null;
		}

		@Override
		public Image getImage(Object element) {
			// TODO Auto-generated method stub
			return super.getImage(element);
		}

	}

}
