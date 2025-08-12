package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class UnaryExp extends ASTList implements Expression {
  private final String operator;


  public UnaryExp(List<ASTree> expr, String operator) {
    super(expr);
    this.operator = operator;
  }

  public String getOperator() {
    return operator;
  }

  public ASTree getExpr() {
    return child(0);
  }

  @Override
  public String toString() {
    return "(" + operator + " " + getExpr() + ")";
  }

  @Override
  public String toAstString() {
    return "(" + operator + " " + getExpr() + ")";
  }

  @Override
  public String toClgString() {
    return "(" + operator + " " + getExpr() + ")";
  }


  @Override
  public Type getType() {
    return child(0).getType();
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visitUnaryExpContext(this);
  }

  @Override
  public ASTree clone() {
    List<ASTree> clonedChild = new ArrayList<>();
    clonedChild.add(this.getExpr().clone()); // 只有一個子節點

    return new UnaryExp(clonedChild, this.operator);
  }
}
