package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import ccu.pllab.tcgen3.symboltable.type.Type;
import ccu.pllab.tcgen3.symboltable.type.VoidType;

public class ClassifierContextDeclAST extends ASTLeaf {
  String pathName;

  public ClassifierContextDeclAST(String pathName) {
    this.pathName = pathName;
  }

  @Override
  public String toString() {
    return pathName;
  }

  @Override
  public String toAstString() {
    return pathName;
  }

  @Override
  public String toClgString() {
    return pathName;
  }

  // Not Important
  @Override
  public Type getType() {
    return new VoidType();
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visitClassifierContext(this);
  }

  @Override
  public ASTree clone() {
    return new ClassifierContextDeclAST("pathName");
  }
}
