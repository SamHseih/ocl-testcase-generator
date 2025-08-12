package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class CollectionItem extends CollectionPart {

  // prohibit empty collection !!!
  /*
   * {1,2,3,4} child(0) = IntegerLiteralExp.getValue = 1 child(1) = IntegerLiteralExp.getValue = 2
   * child(2) = IntegerLiteralExp.getValue = 3 child(3) = IntegerLiteralExp.getValue = 4
   */
  public CollectionItem(List<ASTree> children) {
    super(children);
  }

  @Override
  public Type getType() {
    return child(0).getType();
  }

  @Override
  public String size() {
    return String.valueOf(numChildren());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Sequence {");
    for (int i = 0; i < numChildren(); i++) {
      sb.append(children.get(i).toString());
      if (i < children.size() - 1) {
        sb.append(", ");
      }
    }
    sb.append("}");
    return sb.toString();
  }

  @Override
  public String toAstString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Sequence {");
    for (int i = 0; i < numChildren(); i++) {
      sb.append(children.get(i).toAstString());
      if (i < children.size() - 1) {
        sb.append(", ");
      }
    }
    sb.append("}");
    return sb.toString();
  }

  @Override
  public String toClgString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Sequence {");
    for (int i = 0; i < numChildren(); i++) {
      sb.append(children.get(i).toClgString());
      if (i < children.size() - 1) {
        sb.append(", ");
      }
    }
    sb.append("}");
    return sb.toString();
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visitCollectionItemContext(this);
  }

  @Override
  public ASTree clone() {
    List<ASTree> clonedChildren = new ArrayList<>();
    for (ASTree child : this.children) {
      clonedChildren.add(child.clone());
    }
    return new CollectionItem(clonedChildren);
  }
}
