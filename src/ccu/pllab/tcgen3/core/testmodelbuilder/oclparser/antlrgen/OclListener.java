// Generated from C:/Users/Sam/Desktop/workspace/2024_eclipcse_myReasearch/workspace20241216/workspace/tcgen3/src/ccu/pllab/tcgen3/core/testmodelbuilder/oclparser/Ocl.g4 by ANTLR 4.13.2
 
package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen; 

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OclParser}.
 */
public interface OclListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OclParser#packageDeclarationCS}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclarationCS(OclParser.PackageDeclarationCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#packageDeclarationCS}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclarationCS(OclParser.PackageDeclarationCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#contextDecl}.
	 * @param ctx the parse tree
	 */
	void enterContextDecl(OclParser.ContextDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#contextDecl}.
	 * @param ctx the parse tree
	 */
	void exitContextDecl(OclParser.ContextDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#classifierContextDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassifierContextDecl(OclParser.ClassifierContextDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#classifierContextDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassifierContextDecl(OclParser.ClassifierContextDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoRturnTypeAlt}
	 * labeled alternative in {@link OclParser#operationContextDecl}.
	 * @param ctx the parse tree
	 */
	void enterNoRturnTypeAlt(OclParser.NoRturnTypeAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoRturnTypeAlt}
	 * labeled alternative in {@link OclParser#operationContextDecl}.
	 * @param ctx the parse tree
	 */
	void exitNoRturnTypeAlt(OclParser.NoRturnTypeAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HasRturnTypeAlt}
	 * labeled alternative in {@link OclParser#operationContextDecl}.
	 * @param ctx the parse tree
	 */
	void enterHasRturnTypeAlt(OclParser.HasRturnTypeAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HasRturnTypeAlt}
	 * labeled alternative in {@link OclParser#operationContextDecl}.
	 * @param ctx the parse tree
	 */
	void exitHasRturnTypeAlt(OclParser.HasRturnTypeAltContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#context}.
	 * @param ctx the parse tree
	 */
	void enterContext(OclParser.ContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#context}.
	 * @param ctx the parse tree
	 */
	void exitContext(OclParser.ContextContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#variableDecls}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecls(OclParser.VariableDeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#variableDecls}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecls(OclParser.VariableDeclsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclAlt}
	 * labeled alternative in {@link OclParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclAlt(OclParser.VariableDeclAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclAlt}
	 * labeled alternative in {@link OclParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclAlt(OclParser.VariableDeclAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CollectionDeclAlt}
	 * labeled alternative in {@link OclParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterCollectionDeclAlt(OclParser.CollectionDeclAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CollectionDeclAlt}
	 * labeled alternative in {@link OclParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitCollectionDeclAlt(OclParser.CollectionDeclAltContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#pathNameCS}.
	 * @param ctx the parse tree
	 */
	void enterPathNameCS(OclParser.PathNameCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#pathNameCS}.
	 * @param ctx the parse tree
	 */
	void exitPathNameCS(OclParser.PathNameCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(OclParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(OclParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#basetype}.
	 * @param ctx the parse tree
	 */
	void enterBasetype(OclParser.BasetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#basetype}.
	 * @param ctx the parse tree
	 */
	void exitBasetype(OclParser.BasetypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NonSizeDeclArray}
	 * labeled alternative in {@link OclParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterNonSizeDeclArray(OclParser.NonSizeDeclArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NonSizeDeclArray}
	 * labeled alternative in {@link OclParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitNonSizeDeclArray(OclParser.NonSizeDeclArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SizeDeclArray}
	 * labeled alternative in {@link OclParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterSizeDeclArray(OclParser.SizeDeclArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SizeDeclArray}
	 * labeled alternative in {@link OclParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitSizeDeclArray(OclParser.SizeDeclArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#arrayListType}.
	 * @param ctx the parse tree
	 */
	void enterArrayListType(OclParser.ArrayListTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#arrayListType}.
	 * @param ctx the parse tree
	 */
	void exitArrayListType(OclParser.ArrayListTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(OclParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(OclParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#collectionTypeIdentifierCS}.
	 * @param ctx the parse tree
	 */
	void enterCollectionTypeIdentifierCS(OclParser.CollectionTypeIdentifierCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#collectionTypeIdentifierCS}.
	 * @param ctx the parse tree
	 */
	void exitCollectionTypeIdentifierCS(OclParser.CollectionTypeIdentifierCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#userClassType}.
	 * @param ctx the parse tree
	 */
	void enterUserClassType(OclParser.UserClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#userClassType}.
	 * @param ctx the parse tree
	 */
	void exitUserClassType(OclParser.UserClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#oclExpressionCS}.
	 * @param ctx the parse tree
	 */
	void enterOclExpressionCS(OclParser.OclExpressionCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#oclExpressionCS}.
	 * @param ctx the parse tree
	 */
	void exitOclExpressionCS(OclParser.OclExpressionCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(OclParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(OclParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(OclParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(OclParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(OclParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(OclParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(OclParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(OclParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(OclParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(OclParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(OclParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(OclParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NonCallExp}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterNonCallExp(OclParser.NonCallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NonCallExp}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitNonCallExp(OclParser.NonCallExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarFeatureCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterVarFeatureCallAlt(OclParser.VarFeatureCallAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarFeatureCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitVarFeatureCallAlt(OclParser.VarFeatureCallAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IterateCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterIterateCallAlt(OclParser.IterateCallAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IterateCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitIterateCallAlt(OclParser.IterateCallAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImpliciteOpCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterImpliciteOpCallAlt(OclParser.ImpliciteOpCallAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImpliciteOpCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitImpliciteOpCallAlt(OclParser.ImpliciteOpCallAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassFeatureCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassFeatureCallAlt(OclParser.ClassFeatureCallAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassFeatureCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassFeatureCallAlt(OclParser.ClassFeatureCallAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ResultFeatureCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterResultFeatureCallAlt(OclParser.ResultFeatureCallAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ResultFeatureCallAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitResultFeatureCallAlt(OclParser.ResultFeatureCallAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarArrayAccessAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterVarArrayAccessAlt(OclParser.VarArrayAccessAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarArrayAccessAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitVarArrayAccessAlt(OclParser.VarArrayAccessAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassArrayAccessAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassArrayAccessAlt(OclParser.ClassArrayAccessAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassArrayAccessAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassArrayAccessAlt(OclParser.ClassArrayAccessAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ResultArrayAccessAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterResultArrayAccessAlt(OclParser.ResultArrayAccessAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ResultArrayAccessAlt}
	 * labeled alternative in {@link OclParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitResultArrayAccessAlt(OclParser.ResultArrayAccessAltContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(OclParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(OclParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#ifExpCS}.
	 * @param ctx the parse tree
	 */
	void enterIfExpCS(OclParser.IfExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#ifExpCS}.
	 * @param ctx the parse tree
	 */
	void exitIfExpCS(OclParser.IfExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#letExprCS}.
	 * @param ctx the parse tree
	 */
	void enterLetExprCS(OclParser.LetExprCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#letExprCS}.
	 * @param ctx the parse tree
	 */
	void exitLetExprCS(OclParser.LetExprCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#variableExpCS}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpCS(OclParser.VariableExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#variableExpCS}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpCS(OclParser.VariableExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#literalExpCS}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpCS(OclParser.LiteralExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#literalExpCS}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpCS(OclParser.LiteralExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#arrayLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralExpCS(OclParser.ArrayLiteralExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#arrayLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralExpCS(OclParser.ArrayLiteralExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#arrayListLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterArrayListLiteralExpCS(OclParser.ArrayListLiteralExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#arrayListLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitArrayListLiteralExpCS(OclParser.ArrayListLiteralExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#arrayLiteralPartsCS}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralPartsCS(OclParser.ArrayLiteralPartsCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#arrayLiteralPartsCS}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralPartsCS(OclParser.ArrayLiteralPartsCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#untypedCollectionLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterUntypedCollectionLiteralExpCS(OclParser.UntypedCollectionLiteralExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#untypedCollectionLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitUntypedCollectionLiteralExpCS(OclParser.UntypedCollectionLiteralExpCSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormoalSequenceLiteral}
	 * labeled alternative in {@link OclParser#collectionLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterNormoalSequenceLiteral(OclParser.NormoalSequenceLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormoalSequenceLiteral}
	 * labeled alternative in {@link OclParser#collectionLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitNormoalSequenceLiteral(OclParser.NormoalSequenceLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RangeSequenceLiteral}
	 * labeled alternative in {@link OclParser#collectionLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterRangeSequenceLiteral(OclParser.RangeSequenceLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RangeSequenceLiteral}
	 * labeled alternative in {@link OclParser#collectionLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitRangeSequenceLiteral(OclParser.RangeSequenceLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#collectionLiteralPartsCS}.
	 * @param ctx the parse tree
	 */
	void enterCollectionLiteralPartsCS(OclParser.CollectionLiteralPartsCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#collectionLiteralPartsCS}.
	 * @param ctx the parse tree
	 */
	void exitCollectionLiteralPartsCS(OclParser.CollectionLiteralPartsCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#collectionRangeCS}.
	 * @param ctx the parse tree
	 */
	void enterCollectionRangeCS(OclParser.CollectionRangeCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#collectionRangeCS}.
	 * @param ctx the parse tree
	 */
	void exitCollectionRangeCS(OclParser.CollectionRangeCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#primitiveLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveLiteralExpCS(OclParser.PrimitiveLiteralExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#primitiveLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveLiteralExpCS(OclParser.PrimitiveLiteralExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#integerLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteralExpCS(OclParser.IntegerLiteralExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#integerLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteralExpCS(OclParser.IntegerLiteralExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#realLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterRealLiteralExpCS(OclParser.RealLiteralExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#realLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitRealLiteralExpCS(OclParser.RealLiteralExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#stringLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralExpCS(OclParser.StringLiteralExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#stringLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralExpCS(OclParser.StringLiteralExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#booleanLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteralExpCS(OclParser.BooleanLiteralExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#booleanLiteralExpCS}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteralExpCS(OclParser.BooleanLiteralExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#arrayAccessCS}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessCS(OclParser.ArrayAccessCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#arrayAccessCS}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessCS(OclParser.ArrayAccessCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#callExpCS}.
	 * @param ctx the parse tree
	 */
	void enterCallExpCS(OclParser.CallExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#callExpCS}.
	 * @param ctx the parse tree
	 */
	void exitCallExpCS(OclParser.CallExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#featureCallExpCS}.
	 * @param ctx the parse tree
	 */
	void enterFeatureCallExpCS(OclParser.FeatureCallExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#featureCallExpCS}.
	 * @param ctx the parse tree
	 */
	void exitFeatureCallExpCS(OclParser.FeatureCallExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#propertyCallExpCS}.
	 * @param ctx the parse tree
	 */
	void enterPropertyCallExpCS(OclParser.PropertyCallExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#propertyCallExpCS}.
	 * @param ctx the parse tree
	 */
	void exitPropertyCallExpCS(OclParser.PropertyCallExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#operationCallExpCS}.
	 * @param ctx the parse tree
	 */
	void enterOperationCallExpCS(OclParser.OperationCallExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#operationCallExpCS}.
	 * @param ctx the parse tree
	 */
	void exitOperationCallExpCS(OclParser.OperationCallExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#argumentsCS}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsCS(OclParser.ArgumentsCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#argumentsCS}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsCS(OclParser.ArgumentsCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#loopExpCS}.
	 * @param ctx the parse tree
	 */
	void enterLoopExpCS(OclParser.LoopExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#loopExpCS}.
	 * @param ctx the parse tree
	 */
	void exitLoopExpCS(OclParser.LoopExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#iterateExpCS}.
	 * @param ctx the parse tree
	 */
	void enterIterateExpCS(OclParser.IterateExpCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#iterateExpCS}.
	 * @param ctx the parse tree
	 */
	void exitIterateExpCS(OclParser.IterateExpCSContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(OclParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(OclParser.LogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#relationalOperator}.
	 * @param ctx the parse tree
	 */
	void enterRelationalOperator(OclParser.RelationalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#relationalOperator}.
	 * @param ctx the parse tree
	 */
	void exitRelationalOperator(OclParser.RelationalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveOperator(OclParser.AdditiveOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveOperator(OclParser.AdditiveOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeOperator(OclParser.MultiplicativeOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeOperator(OclParser.MultiplicativeOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(OclParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(OclParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OclParser#isMarkedPreCS}.
	 * @param ctx the parse tree
	 */
	void enterIsMarkedPreCS(OclParser.IsMarkedPreCSContext ctx);
	/**
	 * Exit a parse tree produced by {@link OclParser#isMarkedPreCS}.
	 * @param ctx the parse tree
	 */
	void exitIsMarkedPreCS(OclParser.IsMarkedPreCSContext ctx);
}