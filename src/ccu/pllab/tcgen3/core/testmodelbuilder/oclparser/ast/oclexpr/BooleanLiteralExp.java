package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class BooleanLiteralExp extends LiteralExp<Boolean> {
  // BooleanLiteralExp is a leaf node in the abstract syntax tree
  // It represents a boolean literal in the OCL expression
  // For example: true, false etc.

  public BooleanLiteralExp(boolean value, Type type) {
    super(value, type);
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visitBooleanLiteralExpContext(this);
  }

  @Override
  public BooleanLiteralExp clone() {
    return new BooleanLiteralExp(this.getValue(), this.getType());
  }
}
