grammar Galaxy;

options {
    language = Java;
    output   = AST;
}

tokens {
    PLUS  = '+';
    MINUS = '-';
    FUNCTION;
    FIELD;
    TYPED_ID;
    VARIABLE;
    BLOCK;
    PARAMETERS;
    EXPRESSION;
    OROR = '||';
    ANDAND = '&&';
    OR = '|';
    AND = '&';
    XOR = '^';
}

@header {
package org.zhjh.galaxykit.parser;
}

@members {
private List<RecognitionException> errors;

@Override
public void reportError(RecognitionException e) {
	super.reportError(e);
	if (errors == null) {
		errors = new ArrayList<RecognitionException>();
		;
	}
	errors.add(e);
}

public List<RecognitionException> getErrors() {
	return errors;
}

public void clearErrors() {
	if (errors != null) {
		errors.clear();
	}
	errors = null;
}
}

@lexer::members {
private List<RecognitionException> errors;

@Override
public void reportError(RecognitionException e) {
	super.reportError(e);
	if (errors == null) {
		errors = new ArrayList<RecognitionException>();
		;
	}
	errors.add(e);
}

public List<RecognitionException> getErrors() {
	return errors;
}

public void clearErrors() {
	if (errors != null) {
		errors.clear();
	}
	errors = null;
}
}

@lexer::header {
package org.zhjh.galaxykit.parser;
}

program
    : declaration+ EOF!
    ;

declaration
    : include_declaration
    | struct_declaration
    | variable_declaration
    | constant_declaration
    | native_declaration
    | function_declaration
    ;

include_declaration
    : INCLUDE STRING
        ->
        ^(INCLUDE STRING)
    ;
struct_declaration
    : STRUCT IDENTIFIER '{' field_declaration* '}' ';'
        ->
        ^(STRUCT IDENTIFIER field_declaration)
    ;
field_declaration
    : type IDENTIFIER ';'
        ->
        ^(TYPED_ID type IDENTIFIER)
    ;
variable_declaration
    : type IDENTIFIER ( '=' expression )? ';'
        ->
        ^(VARIABLE ^(TYPED_ID type IDENTIFIER))
    ;

constant_declaration
    : CONST type IDENTIFIER ( '=' expression )? ';'
        ->
        ^(CONST ^(TYPED_ID type IDENTIFIER))
    ;

native_declaration
    : NATIVE result_type IDENTIFIER '(' parameter_list ')' ';'
        ->
        ^(NATIVE IDENTIFIER result_type parameter_list)
    ;

function_declaration
    : result_type IDENTIFIER '(' parameter_list ')' function_body
        ->
        ^(FUNCTION IDENTIFIER result_type parameter_list function_body)
    ;

function_body
    : '{' variable_declaration!* statement!* '}'
    ;

type
    : IDENTIFIER^ ('[' INTEGER ']')*
    ;

result_type
    : type
    | VOID^
    ;

parameter
    : type IDENTIFIER
        ->
        ^(TYPED_ID type IDENTIFIER)
    ;

parameter_list :
    (parameter ( ',' parameter )*)?
        -> ^(PARAMETERS parameter*)
    ;

block :
    '{' statement* '}'
    ;

statement
    : if_statement
    | while_statement
    | break_statement
    | continue_statement
    | return_statement
    | ( left_hand_side_expression assignment_operator ) => assignment_statement
    | empty_statement
    | expression_statement
    ;

if_statement
    : IF '(' expression ')' block ( ELSE (if_statement | block) )?
    ;

while_statement :
    WHILE '(' expression ')' block
    ;

break_statement :
    BREAK ';'
    ;

continue_statement :
    CONTINUE ';'
    ;

return_statement :
    RETURN expression? ';'
    ;

assignment_statement :
    left_hand_side_expression assignment_operator expression ';'
    ;

assignment_operator :
    '='
    | '+='
    | '-='
    | '*='
    | '/='
    | '%='
    | '&='
    | '|='
    | '^='
    | '&&='
    | '||='
    ;

empty_statement :
    ';'
    ;

expression_statement :
    expression ';'
    ;

expression
    : logicalOR_expression
    ;

primary_expression
    : STRING
    | INTEGER
    | FIXED
    | TRUE
    | FALSE
    | NULL
    | IDENTIFIER ('[' expression ']')*
    | '(' expression ')'
    | call_expression
    | '*' IDENTIFIER
    ;

call_expression :
    IDENTIFIER '(' argument_list? ')'
    ;

unary_expression :
    (
        '+'
        | '-'
        | '!'
        | '~'
    )*
    primary_expression
    ;

argument_list
    : expression ( ',' expression )*
    ;

member_expression :
    unary_expression
    (
        (
            '.'
            | '->'
        )
        IDENTIFIER
    )*
    ;

left_hand_side_expression :
    member_expression
    ;

multiplicative_expression :
    member_expression
    (
        (
            '*'
            | '/'
            | '%'
        )
        member_expression
    )*
    ;

additive_expression :
    multiplicative_expression
    (
        (
            '+'
            | '-'
        )
        multiplicative_expression
    )*
    ;

relation_expression :
    additive_expression
    (
        (
            '<'
            | '<='
            | '>'
            | '>='
        )
        additive_expression
    )*
    ;

equality_expression
    : relation_expression ( equality_operator relation_expression )*
    ;
equality_operator
    : '=='
    | '!='
    ;

bitwiseAND_expression
    : equality_expression ( '&' equality_expression )*
    ;

bitwiseXOR_expression
    : bitwiseAND_expression ( '^' bitwiseAND_expression )*
    ;

bitwiseOR_expression
    : bitwiseXOR_expression ( '|' bitwiseXOR_expression )*
    ;

logicalAND_expression
    : bitwiseOR_expression ( '&&' bitwiseOR_expression )*
    ;

logicalOR_expression
    : logicalAND_expression ( '||' logicalAND_expression )*
    ;

WHITESPACE :
    (
        ' '
        | '\t'
        | '\r'
        | '\n'
        | '\f'
    )+
    
      {
       $channel = HIDDEN;
      }
    ;

SINGLE_LINE_COMMENT :
    '//'
    ~(
        '\r'
        | '\n'
     )*
    
      {
       $channel = HIDDEN;
      }
    ;

MULTI_LINE_COMMENT
options {
    greedy = false;
} :
    '/*' .* '*/' 
      {
       $channel = HIDDEN;
      }
    ;

IF :
    'if'
    ;

ELSE :
    'else'
    ;

WHILE :
    'while'
    ;

BREAK :
    'break'
    ;

CONTINUE :
    'continue'
    ;

RETURN :
    'return'
    ;

VOID :
    'void'
    ;

STRUCT :
    'struct'
    ;

NATIVE :
    'native'
    ;

INCLUDE :
    'include'
    ;

TRUE :
    'true'
    ;

FALSE :
    'false'
    ;

NULL :
    'null'
    ;

CONST :
    'const'
    ;

IDENTIFIER :
    IDENTIFIER_START IDENTIFIER_PART*
    ;

fragment IDENTIFIER_START :
    LETTER
    | '_'
    ;

fragment LETTER :
    'a'..'z'
    | 'A'..'Z'
    ;

fragment IDENTIFIER_PART :
    IDENTIFIER_START
    | DIGIT
    ;

INTEGER :
    DECIMAL_INTEGER
    | OCTAL_INTEGER
    | HEXADECIMAL_INTEGER
    ;

fragment DECIMAL_INTEGER :
    '0'
    | NON_ZERO_DIGIT DIGIT*
    ;

fragment HEXADECIMAL_INTEGER :
    '0x' HEXADECIMAL_DIGIT+
    ;

fragment HEXADECIMAL_DIGIT :
    DIGIT
    | 'a'..'f'
    | 'A'..'F'
    ;

fragment OCTAL_INTEGER :
    '0' DIGIT+
    ;

fragment DIGIT :
    '0'..'9'
    ;

fragment NON_ZERO_DIGIT :
    '1'..'9'
    ;

FIXED :
    DECIMAL_INTEGER '.' DIGIT+
    ;

STRING :
    '"'
    (
        ~(
            '\\'
            | '"'
            | '\r'
            | '\n'
         )
        | '\\' .
    )*
    '"'
    ;
