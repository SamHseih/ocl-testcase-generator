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
    // 1. 深層複製三個子節點（condition、thenBranch、elseBranch）
    List<ASTree> clonedChildren = new ArrayList<>();
    for (ASTree child : this.children) {
      clonedChildren.add(child.clone());
    }

    // 2. 使用複製後的子節點建立新 IfExp
    IfExp clone = new IfExp(clonedChildren);

    // 3. 複製 returnType（Type 不可變，可安全共用）
    clone.returnType = this.returnType;

    return clone;
  }
}
