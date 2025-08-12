package ccu.pllab.tcgen3.core.testcasegen;

import java.util.List;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ClassifierContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextExpAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ExceptionAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.InvalidAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.OperationContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.PackageDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.ArrayRefExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp.OpGroup;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BooleanLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionItem;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionRange;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IntegerLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.LetExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.OperationCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.PropertyCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.StringLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.UnaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableDeclExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableExp;

public class BoundaryInteriorVisitor<T> implements AstVisitor<ASTree> {

  @Override
  public ASTree visitPackageDeclASTContext(PackageDeclAST node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitContextDeclAST(ContextDeclAST node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitClassifierContext(ClassifierContextDeclAST node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitOperationContext(OperationContextDeclAST node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitContextExp(ContextExpAST node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitInvalidASTContext(InvalidAST node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitBinaryExpContext(BinaryExp node) {
    ASTree leftast = null;
    ASTree rightast = null;
    String op = node.getOperator();
    if (op.equals(">=")) {
      node.setOperator(">");
    } else if (op.equals("<=")) {
      node.setOperator("<");
    }

    if (leftast == null) {
      leftast = node.left().accept(this);
    }

    if (rightast == null) {
      rightast = node.right().accept(this);
    }

    return node;
  }

  @Override
  public ASTree visitIfExpContext(IfExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitVariableExpContext(VariableExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitPropertyCallExpContext(PropertyCallExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitOperationCallExpContext(OperationCallExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitIntegerLiteralExpContext(IntegerLiteralExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitStringLiteralExpContext(StringLiteralExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitArrayRefExpContext(ArrayRefExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitBooleanLiteralExpContext(BooleanLiteralExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitCollectionItemContext(CollectionItem node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitCollectionLiteralExpContext(CollectionLiteralExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitCollectionRangeContext(CollectionRange node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitIterateExpContext(IterateExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitLetExpContext(LetExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitUnaryExpContext(UnaryExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitVariableDeclExpContext(VariableDeclExp node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ASTree visitExceptionASTContext(ExceptionAST node) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<String> getErrorMesg() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void reset_iterate() {
    // TODO Auto-generated method stub

  }

}
