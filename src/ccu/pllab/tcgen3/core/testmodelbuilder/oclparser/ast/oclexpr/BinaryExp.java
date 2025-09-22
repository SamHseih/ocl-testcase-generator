package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.SymbolTableBuilder;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

/**
 * Binary expression node for abstract tree for example: 2 + 3
 */
public class BinaryExp extends ASTList implements Expression {
  public enum OpGroup {
    LOGICAL, RELATIONAL, ADDITIVE, MULTIPLICATIVE
  }

  private String operator;
  private final OpGroup opGroup;

  public BinaryExp(List<ASTree> operands, String op) {
    super(operands);
    if (operands.size() != 2) {
      throw new IllegalArgumentException("BinaryExp must have exactly 2 operands");
    }
    this.operator = op;
    this.opGroup = classify(op);

  }

  private static OpGroup classify(String op) {
    return switch (op) {
      case "and", "or", "xor", "implies" -> OpGroup.LOGICAL;
      case "=", "<>", "<", "<=", ">", ">=" -> OpGroup.RELATIONAL;
      case "+", "-" -> OpGroup.ADDITIVE;
      case "*", "/" -> OpGroup.MULTIPLICATIVE;
      default -> throw new IllegalArgumentException("Unknown Binary Operator: " + op);
    };
  }

  public String getOperator() {
    return operator;
  }

  public OpGroup getGroup() {
    return opGroup;
  }

  public void setOperator(String bdop) {
    this.operator = bdop;
  } // for boundary analysis

  public ASTree left() {
    return child(0);
  }

  public ASTree right() {
    return child(1);
  }
  // @Override public String toString() { return "(" + left() + " " + operator + " " + right() +
  // ")"; }

  @Override
  public Type getType() {
    if (opGroup == OpGroup.ADDITIVE || opGroup == OpGroup.MULTIPLICATIVE) {
      return child(0).getType();
    } else if (opGroup == OpGroup.LOGICAL || opGroup == OpGroup.RELATIONAL) {
      return SymbolTableBuilder.BooleanType;
    } else
      return new InvalidType();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    pretty(sb, this, 0, true);
    return sb.toString();
  }

  private void pretty(StringBuilder sb, ASTree node, int depth, boolean isTop) {
    // 1. �Y���O BinaryExp�A���� append
    if (!(node instanceof BinaryExp bin)) {
      sb.append(node.toClgString());
      return;
    }

    // 2. �w�� "and" ���i���ô���
    if (OpGroup.LOGICAL.equals(bin.getGroup())) {

      // ����
      pretty(sb, bin.left(), depth, false);
      sb.append(" " + bin.getOperator()).append(System.lineSeparator());

      // �k��G�Y�٬O and�A�N���j�]�P�h�Y�ơ^�F�_�h���`�C�L
      if (bin.right() instanceof BinaryExp rightBin
          && OpGroup.LOGICAL.equals(rightBin.getGroup())) {
        pretty(sb, rightBin, depth, false); // ���t�~�Y��
      } else {
        pretty(sb, bin.right(), depth, false);
      }

      // �̥~�h�~�b���ݸɴ���A�קK�h�l�ťզ�
      if (isTop)
        sb.append(System.lineSeparator());
      return;
    }

    // 3. �䥦�B��l�G������� Ex. self.number >= 0
    pretty(sb, bin.left(), depth, false);
    sb.append(' ').append(bin.getOperator()).append(' ');
    pretty(sb, bin.right(), depth, false);

    // if (isTop) sb.append(System.lineSeparator());

  }

  @Override
  public String toAstString() {
    return this.getOperator();
  }

  @Override
  public String toClgString() {
    StringBuilder sb = new StringBuilder();
    pretty(sb, this, 0, true);
    return sb.toString();
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visitBinaryExpContext(this);
  }

  @Override
  public ASTree clone() {
    List<ASTree> clonedOperands = new ArrayList<>();
    for (ASTree operand : this.children) {
      clonedOperands.add(operand.clone());
    }
    return new BinaryExp(clonedOperands, this.operator);
  }


}
