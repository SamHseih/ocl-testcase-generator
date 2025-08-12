package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class CollectionRange extends CollectionPart {

  /**
   * CollectionRangeExp ¢u¢w¢w child(0) : lowerValue ¢u¢w¢w child(1) : uperValue
   */
  public CollectionRange(List<ASTree> children) {
    super(children);
  }

  public ASTree getLowerValue() {
    return child(0);
  }

  public ASTree getUpperValue() {
    return child(1);
  }

  @Override
  public String size() {
    return child(1) + " - " + child(0) + "+ 1";
  }

  @Override
  public Type getType() {
    if (child(0).getType().equals(child(1).getType())) {
      return child(0).getType();
    } else
      return new InvalidType();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Sequence{");
    String sep = "..";
    sb.append(children.get(0).toString());
    sb.append(sep);
    sb.append(children.get(1).toString());
    sb.append("}");
    return sb.toString();
  }

  @Override
  public String toAstString() {
    return "Sequence{ node(" + child(0).id() + ") .. node(" + child(1).id() + ") }";
  }

  @Override
  public String toClgString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Sequence{");
    String sep = "..";
    sb.append(children.get(0).toClgString());
    sb.append(sep);
    sb.append(children.get(1).toClgString());
    sb.append("}");
    return sb.toString();
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visitCollectionRangeContext(this);
  }

  @Override
  public ASTree clone() {
    List<ASTree> clonedChildren = new ArrayList<>();
    for (ASTree child : this.children) {
      clonedChildren.add(child.clone());
    }
    return new CollectionRange(clonedChildren);
  }
}
