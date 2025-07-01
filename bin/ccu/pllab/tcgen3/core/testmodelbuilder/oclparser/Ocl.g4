grammar Ocl	;

@header { 
package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen; 
}

/**------------------------------------------------------------------
 * OCL EXPRESSIONS - Top-level package declaration
 *------------------------------------------------------------------*/
packageDeclarationCS
	: 'package' pathNameCS contextDecl* 'endpackage' 
	;

/** Each context declaration (classifier, operation). */
contextDecl 
	: classifierContextDecl  context*
	| operationContextDecl context*
	;

/** Class Level*/
classifierContextDecl 
	: 'context' pathNameCS
	;

/** Method Level*/
operationContextDecl  
	: 'context' pathNameCS '::' ID '(' variableDecls? ')'  # NoReturnTypeAlt
	| 'context' pathNameCS '::' ID '(' variableDecls? ')' ':' type # HasRturnTypeAlt
	;

context
	: 'inv'  ID? ':' oclExpressionCS 
	| 'pre'  ID? ':' oclExpressionCS 
	| 'post' ID?  ':' oclExpressionCS 
	;

variableDecls
	: variableDecl (',' variableDecl)*
	;

/** A variable declaration inside an expression or parameter list. Note: CollectionDeclAlt not handled yet! */
variableDecl
	: ID ':' type  ( '=' oclExpressionCS )? # VariableDeclAlt
	| collectionTypeIdentifierCS  '(' type ')' # CollectionDeclAlt
	;
	
pathNameCS 
	: ID('::' ID)*
	;

/**------------------------------------------------------------------
 * OCL EXPRESSIONS - Type
 *------------------------------------------------------------------*/
type
	: arrayType 
	| arrayListType 
	| basetype 
	;

basetype
	: primitiveType
	| userClassType
	| collectionTypeIdentifierCS
	;

arrayType
	: basetype (BRACKETS)+ #NonSizeDeclArray
	| basetype ('[' INTEGER ']')+ #StaticFixSizeArray
	| basetype ('[' ID ']')+ #DynamicFixSizeArray
	;

arrayListType
	: 'ArrayList' '<' type '>'
	;

/** In ArrayTypeAltNode can use ctx.BRACKETS().size() */
BRACKETS: '[]' 	;

primitiveType 
	: 'int'
	| 'String'
	| 'Boolean'
	;

collectionTypeIdentifierCS 
	: 'Set' 
	| 'Bag' 
	| 'Sequence' 
	| 'OrderedSet'  
	| 'Collection' 
	;

userClassType
	: ID
	;

/**------------------------------------------------------------------
 * OCL EXPRESSIONS - BinaryExp 
 *------------------------------------------------------------------*/
 
oclExpressionCS 
	: expression
 	;

expression 
	: logicalExpression
	;

logicalExpression 
	: relationalExpression (logicalOperator relationalExpression)*
	;

relationalExpression 
	: additiveExpression (relationalOperator additiveExpression)*
	;

additiveExpression 
	: multiplicativeExpression ( additiveOperator multiplicativeExpression )*
	;

multiplicativeExpression 
	: unaryExpression ( multiplicativeOperator unaryExpression )*
	;

unaryExpression 
	: unaryOperator? postfixExpression   
	;
/**------------------------------------------------------------------
 * OCL EXPRESSIONS -PostfixExpression Some Call Expression
 *------------------------------------------------------------------*/
postfixExpression
	: primaryExpression 		 	 				 #NonCallExp
	| variableExpCS (callExpCS)+ 	 				 #VarFeatureCallAlt
	| literalExpCS isMarkedPreCS? (callExpCS)+		 #IterateCallAlt
	| callExpCS  					 				 #ImpliciteOpCallAlt
	| SELF isMarkedPreCS? (callExpCS)+ 				 #ClassFeatureCallAlt
	| RESULT (callExpCS)* 						     #ResultFeatureCallAlt
//Special Casses Ex. self[1][2]  or  result[2][3] or datas[2][3][4]
	| variableExpCS indexExpCS+ 					 #VarArrayAccessAlt
	| SELF isMarkedPreCS? indexExpCS+				 #ClassArrayAccessAlt
	| RESULT indexExpCS+							 #ResultArrayAccessAlt
	;

/**------------------------------------------------------------------
 * OCL EXPRESSIONS - PrimaryExpr
 *------------------------------------------------------------------*/
primaryExpression
	: ifExpCS
	| letExprCS
	| variableExpCS
	| literalExpCS
	| '(' expression ')'
	;

ifExpCS
	: 'if' '(' expression')' 'then' expression 'else' expression 'endif'
	;

letExprCS
	: 'let' variableDecls 'in' oclExpressionCS
	;

variableExpCS 
    : ID isMarkedPreCS?        
	;
/**------------------------------------------------------------------
 * OCL EXPRESSIONS - PrimaryExpr - literalExpCS
 * Collection Prohibit Empty !!!
 *------------------------------------------------------------------*/
literalExpCS
	: arrayLiteralExpCS 
	| arrayListLiteralExpCS 
	| collectionLiteralExpCS 
	| primitiveLiteralExpCS 
	| arrayLiteralPartsCS 
	;

/** e.g. int[][][]{ {{1,2},{1,2}}, {{1,2},{1,2}} }*/
arrayLiteralExpCS
	: arrayType  arrayLiteralPartsCS
	;

/** e.g. ArrayList<int>{1,2,3}*/
arrayListLiteralExpCS
	: arrayListType arrayLiteralPartsCS
	;

arrayLiteralPartsCS
	: '{' collectionitem '}'
	;
	
collectionLiteralExpCS 
	:  basetype '{' collectionLiteralPartsCS '}' 
	;

collectionLiteralPartsCS
	: collectionitem
	| collectionRangeCS
	;

collectionitem
	:literalExpCS (',' literalExpCS )* 
	;

collectionRangeCS
	: expression  '..' expression
	;
	
primitiveLiteralExpCS
	: integerLiteralExpCS
	| realLiteralExpCS //Not yet Support
	| stringLiteralExpCS
	| booleanLiteralExpCS
	;

integerLiteralExpCS : INTEGER 				;
realLiteralExpCS 	: INTEGER '.' INTEGER 	; //Not yet Support
stringLiteralExpCS 	: STRING_LITERAL		;
booleanLiteralExpCS : 'true'|'false' 		;
/**------------------------------------------------------------------
 * OCL EXPRESSIONS - CallExpCS
 *------------------------------------------------------------------*/
callExpCS
    : featureCallExpCS
	| loopExpCS
    ;
 
featureCallExpCS
	: propertyCallExpCS
	| operationCallExpCS
	| arrayAccessCS
	;
	
propertyCallExpCS
    : DOT variableExpCS 
    ;		
	
/**------------------------------------------------------------------
 * OCL EXPRESSIONS - OperationCallExpCS
 *------------------------------------------------------------------
[A] OperationCallExpCS ::= OclExpressionCS[1] simpleNameCS OclExpressionCS[2]  
	this production deal with by "logicalExpression->relationalExpression->....unaryExpression" 
[B] OperationCallExpCS ::= OclExpressionCS '->' simpleNameCS '(' argumentsCS? ')'
[C] OperationCallExpCS ::= OclExpressionCS '.' simpleNameCS '(' argumentsCS? ')'
[D] OperationCallExpCS ::= simpleNameCS '(' argumentsCS? ')'
[E] oclExpressionCS '.' simpleNameCS isMarkedPreCS? '(' argumentsCS? ')'
[F] OperationCallExpCS ::= simpleNameCS isMarkedPreCS '(' argumentsCS? ')' 
[G] OperationCallExpCS ::= pathNameCS '(' argumentsCS? ')' 
[H] OperationCallExpCS ::= simpleNameCS OclExpressionCS   = unaryExpression
[I] OperationCallExpCS ::= OclExpressionCS '.' pathNameCS '::' simpleNameCS '(' argumentsCS? ')' 
[J] OperationCallExpCS ::= OclExpressionCS '.' pathNameCS '::' simpleNameCS isMarkedPreCS '(' argumentsCS? ')'
*/
operationCallExpCS
	: ARROW variableExpCS '(' argumentsCS? ')'              // # ArrowCallAlt          // [B]
    | DOT variableExpCS '(' argumentsCS? ')'                 //# DotCallAlt            // [C]+[E]
    | variableExpCS '(' argumentsCS? ')'                     //# SelfSourceCallAlt // [D]+[F]
    //| DOT pathNameCS '::' ID isMarkedPreCS? '(' argumentsCS? ')' # StaticCallAlt       // [I]+[J] No support
    //| pathNameCS '(' argumentsCS? ')'                            # StaticGlobalCallAlt // [G] No support
    ;

/** Argument list inside "(...)" or "[...]". */
argumentsCS
	: oclExpressionCS (',' argumentsCS )?
	;
	
/**------------------------------------------------------------------
 * OCL EXPRESSIONS - PrimaryExpr - arrayAccessCS
 *------------------------------------------------------------------*/	
 
arrayAccessCS 
	: DOT variableExpCS indexExpCS+
	;
	
indexExpCS
	: '[' expression ']'
	;
	
/**------------------------------------------------------------------
 * OCL EXPRESSIONS - loopExpCS
 *------------------------------------------------------------------*/ 
loopExpCS
	: iterateExpCS
	//| iteratorExp No suoport
	;

/** e.g. collection->iterate(elem: Type; acc: Type=<expression> | expression-with-elem-and-acc) */
iterateExpCS
	: ARROW 'iterate' '(' variableDecl ';' variableDecl '|' expression ')'
	;


/**------------------------------------------------------------------
 * OCL OP priority  lowest->highest
 *------------------------------------------------------------------*/
logicalOperator 
	: 'and'|'or'|'xor'|'implies'
	;

relationalOperator 
	: '='|'>'|'<'|'>='|'<='|'<>'
	;

additiveOperator 
	: '+'|'-'
	;

multiplicativeOperator 
	: '*'|'/'
	;

unaryOperator 
	: '-'|'not'
	;

isMarkedPreCS : '@' 'pre' 	;

SELF:'self';
RESULT:'result';
DOT:'.';
ARROW:'->';

ID :
	[\p{L}_$]([\p{L}0-9_])*
	;

INTEGER :
	[0-9]([0-9])*
	;

STRING_LITERAL 
	: '\'' (StringChar | EscapeSequence)* '\'' (WHITESPACE '\'' (StringChar | EscapeSequence)* '\'')*
    ;
	
fragment StringChar
    : ~['\\] | '\n' | '\r'  
    ;
	
fragment EscapeSequence
	: '\\' [btnfr"'\\]
    | '\\' ([0-3]? [0-7])? [0-7]
    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;

fragment HexDigit
    : [0-9a-fA-F]
    ;
	
/**------------------------------------------------------------------
 * OCL Comments / whitespace
 *------------------------------------------------------------------*/
LINE_COMMENT : '--' ~[\r\n]* -> skip;

PARA_COMMENT : '/*' .*? '*/' -> skip;

WHITESPACE :[ \t\r\n]+ -> skip;