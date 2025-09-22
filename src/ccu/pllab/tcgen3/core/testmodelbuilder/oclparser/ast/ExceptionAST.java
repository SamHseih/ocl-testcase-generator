package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

// Only for CLG Exception Node
public class ExceptionAST extends ASTLeaf {
  String name;


  public ExceptionAST() {
    super();
    name = "Result = 'Exception'";
  }

  public ExceptionAST(String name) {
    super();
    this.name = "Result = " + "'" + name + "'";
  }


  @Override
  public String toString() {
    return name;
  }

  @Override
  public Type getType() {
    return new InvalidType();
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
    return visitor.visitExceptionASTContext(this);
  }

  @Override
  public ASTree clone() {
    ExceptionAST clone = new ExceptionAST();
    clone.name = this.name; // ���M name �O�`�ơA���O�d�����]�w
    return clone;
  }

}
