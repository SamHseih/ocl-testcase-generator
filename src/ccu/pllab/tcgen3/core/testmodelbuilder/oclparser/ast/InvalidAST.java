package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

// for AST Error Node
public class InvalidAST extends ASTLeaf {
  String name = "ErrorNode";

  @Override
  public Type getType() {
    return new InvalidType();
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public String toAstString() {
    return name;
  }

  @Override
  public String toClgString() {
    return name;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visitInvalidASTContext(this);
  }

  @Override
  public ASTree clone() {
    InvalidAST clone = new InvalidAST();
    clone.name = this.name; // 雖然 name 是常數，仍保留對應設定
    return clone;
  }
}
