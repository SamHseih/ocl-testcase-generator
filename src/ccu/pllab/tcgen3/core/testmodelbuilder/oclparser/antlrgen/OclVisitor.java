// Generated from
// C:/Users/Sam/Desktop/workspace/2024_eclipcse_myReasearch/workspace20241216/workspace/tcgen3/src/ccu/pllab/tcgen3/core/testmodelbuilder/oclparser/Ocl.g4
// by ANTLR 4.13.2

package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link OclParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *        type.
 */
public interface OclVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link OclParser#packageDeclarationCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPackageDeclarationCS(OclParser.PackageDeclarationCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#contextDecl}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitContextDecl(OclParser.ContextDeclContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#classifierContextDecl}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassifierContextDecl(OclParser.ClassifierContextDeclContext ctx);

  /**
   * Visit a parse tree produced by the {@code NoReturnTypeAlt} labeled alternative in
   * {@link OclParser#operationContextDecl}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNoReturnTypeAlt(OclParser.NoReturnTypeAltContext ctx);

  /**
   * Visit a parse tree produced by the {@code HasRturnTypeAlt} labeled alternative in
   * {@link OclParser#operationContextDecl}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHasRturnTypeAlt(OclParser.HasRturnTypeAltContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#context}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitContext(OclParser.ContextContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#variableDecls}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVariableDecls(OclParser.VariableDeclsContext ctx);

  /**
   * Visit a parse tree produced by the {@code VariableDeclAlt} labeled alternative in
   * {@link OclParser#variableDecl}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVariableDeclAlt(OclParser.VariableDeclAltContext ctx);

  /**
   * Visit a parse tree produced by the {@code CollectionDeclAlt} labeled alternative in
   * {@link OclParser#variableDecl}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCollectionDeclAlt(OclParser.CollectionDeclAltContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#pathNameCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPathNameCS(OclParser.PathNameCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#type}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType(OclParser.TypeContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#basetype}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBasetype(OclParser.BasetypeContext ctx);

  /**
   * Visit a parse tree produced by the {@code NonSizeDeclArray} labeled alternative in
   * {@link OclParser#arrayType}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNonSizeDeclArray(OclParser.NonSizeDeclArrayContext ctx);

  /**
   * Visit a parse tree produced by the {@code StaticFixSizeArray} labeled alternative in
   * {@link OclParser#arrayType}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStaticFixSizeArray(OclParser.StaticFixSizeArrayContext ctx);

  /**
   * Visit a parse tree produced by the {@code DynamicFixSizeArray} labeled alternative in
   * {@link OclParser#arrayType}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDynamicFixSizeArray(OclParser.DynamicFixSizeArrayContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#arrayListType}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrayListType(OclParser.ArrayListTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#primitiveType}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimitiveType(OclParser.PrimitiveTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#collectionTypeIdentifierCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCollectionTypeIdentifierCS(OclParser.CollectionTypeIdentifierCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#userClassType}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUserClassType(OclParser.UserClassTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#oclExpressionCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOclExpressionCS(OclParser.OclExpressionCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#expression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpression(OclParser.ExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#logicalExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLogicalExpression(OclParser.LogicalExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#relationalExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRelationalExpression(OclParser.RelationalExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#additiveExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAdditiveExpression(OclParser.AdditiveExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#multiplicativeExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiplicativeExpression(OclParser.MultiplicativeExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#unaryExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnaryExpression(OclParser.UnaryExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code NonCallExp} labeled alternative in
   * {@link OclParser#postfixExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNonCallExp(OclParser.NonCallExpContext ctx);

  /**
   * Visit a parse tree produced by the {@code VarFeatureCallAlt} labeled alternative in
   * {@link OclParser#postfixExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVarFeatureCallAlt(OclParser.VarFeatureCallAltContext ctx);

  /**
   * Visit a parse tree produced by the {@code IterateCallAlt} labeled alternative in
   * {@link OclParser#postfixExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIterateCallAlt(OclParser.IterateCallAltContext ctx);

  /**
   * Visit a parse tree produced by the {@code ImpliciteOpCallAlt} labeled alternative in
   * {@link OclParser#postfixExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImpliciteOpCallAlt(OclParser.ImpliciteOpCallAltContext ctx);

  /**
   * Visit a parse tree produced by the {@code ClassFeatureCallAlt} labeled alternative in
   * {@link OclParser#postfixExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassFeatureCallAlt(OclParser.ClassFeatureCallAltContext ctx);

  /**
   * Visit a parse tree produced by the {@code ResultFeatureCallAlt} labeled alternative in
   * {@link OclParser#postfixExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitResultFeatureCallAlt(OclParser.ResultFeatureCallAltContext ctx);

  /**
   * Visit a parse tree produced by the {@code VarArrayAccessAlt} labeled alternative in
   * {@link OclParser#postfixExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVarArrayAccessAlt(OclParser.VarArrayAccessAltContext ctx);

  /**
   * Visit a parse tree produced by the {@code ClassArrayAccessAlt} labeled alternative in
   * {@link OclParser#postfixExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassArrayAccessAlt(OclParser.ClassArrayAccessAltContext ctx);

  /**
   * Visit a parse tree produced by the {@code ResultArrayAccessAlt} labeled alternative in
   * {@link OclParser#postfixExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitResultArrayAccessAlt(OclParser.ResultArrayAccessAltContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#primaryExpression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimaryExpression(OclParser.PrimaryExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#ifExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIfExpCS(OclParser.IfExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#letExprCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLetExprCS(OclParser.LetExprCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#variableExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVariableExpCS(OclParser.VariableExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#literalExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteralExpCS(OclParser.LiteralExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#arrayLiteralExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrayLiteralExpCS(OclParser.ArrayLiteralExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#arrayListLiteralExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrayListLiteralExpCS(OclParser.ArrayListLiteralExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#arrayLiteralPartsCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrayLiteralPartsCS(OclParser.ArrayLiteralPartsCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#collectionLiteralExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCollectionLiteralExpCS(OclParser.CollectionLiteralExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#collectionLiteralPartsCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCollectionLiteralPartsCS(OclParser.CollectionLiteralPartsCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#collectionitem}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCollectionitem(OclParser.CollectionitemContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#collectionRangeCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCollectionRangeCS(OclParser.CollectionRangeCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#primitiveLiteralExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimitiveLiteralExpCS(OclParser.PrimitiveLiteralExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#integerLiteralExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIntegerLiteralExpCS(OclParser.IntegerLiteralExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#realLiteralExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRealLiteralExpCS(OclParser.RealLiteralExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#stringLiteralExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStringLiteralExpCS(OclParser.StringLiteralExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#booleanLiteralExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBooleanLiteralExpCS(OclParser.BooleanLiteralExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#callExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCallExpCS(OclParser.CallExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#featureCallExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFeatureCallExpCS(OclParser.FeatureCallExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#propertyCallExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPropertyCallExpCS(OclParser.PropertyCallExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#operationCallExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOperationCallExpCS(OclParser.OperationCallExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#argumentsCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgumentsCS(OclParser.ArgumentsCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#arrayAccessCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrayAccessCS(OclParser.ArrayAccessCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#indexExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIndexExpCS(OclParser.IndexExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#loopExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLoopExpCS(OclParser.LoopExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#iterateExpCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIterateExpCS(OclParser.IterateExpCSContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#logicalOperator}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLogicalOperator(OclParser.LogicalOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#relationalOperator}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRelationalOperator(OclParser.RelationalOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#additiveOperator}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAdditiveOperator(OclParser.AdditiveOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#multiplicativeOperator}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiplicativeOperator(OclParser.MultiplicativeOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#unaryOperator}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnaryOperator(OclParser.UnaryOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link OclParser#isMarkedPreCS}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIsMarkedPreCS(OclParser.IsMarkedPreCSContext ctx);
}
