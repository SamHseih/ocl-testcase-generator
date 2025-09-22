package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.SymbolTableBuilder;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;


/** Type need Dinamic Setting */
public class IfExp extends ASTList implements Expression {
  Type returnType;

  public IfExp(List<ASTree> children) {
    super(children);
  }

  public ASTree getCondition() {
    return child(0);
  }

  public ASTree getThenBranch() {
    return child(1);
  }

  public ASTree getElseBranch() {
    return child(2);
  }

  @Override // always boolean ****not perfect! a little bit cheat~***
  public Type getType() {
    if (!(child(0).getType().getTypeName().equals("Boolean")))
      return new InvalidType();

    return SymbolTableBuilder.BooleanType;
  }

  @Override
  public String toString() {
    return "IfExp ConditionNode:(" + child(0).id() + ") thenNode: (" + child(1).id()
        + ") elseNode: (" + child(2).id() + ")";
  }

  @Override
  public String toAstString() {
    return "IfExp ConditionNode:(" + child(0).id() + ") thenNode: (" + child(1).id()
        + ") elseNode: (" + child(2).id() + ")";
  }

  @Override
  public String toClgString() {
    return "IfExp ConditionNode:(" + child(0).id() + ") thenNode: (" + child(1).id()
        + ") elseNode: (" + child(2).id() + ")";
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visitIfExpContext(this);
  }

  @Override
  public ASTree clone() {
    // 1. �`�h�ƻs�T�Ӥl�`�I�]condition�BthenBranch�BelseBranch�^
    List<ASTree> clonedChildren = new ArrayList<>();
    for (ASTree child : this.children) {
      clonedChildren.add(child.clone());
    }

    // 2. �ϥνƻs�᪺�l�`�I�إ߷s IfExp
    IfExp clone = new IfExp(clonedChildren);

    // 3. �ƻs returnType�]Type ���i�ܡA�i�w���@�Ρ^
    clone.returnType = this.returnType;

    return clone;
  }
}
