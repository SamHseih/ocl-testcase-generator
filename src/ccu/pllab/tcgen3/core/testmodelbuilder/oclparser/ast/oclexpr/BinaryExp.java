package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.SymbolTableBuilder;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

/**
 * Binary expression node for abstract tree
 * for example: 2 + 3
 */
public class BinaryExp extends ASTList implements Expression{
	enum OpGroup { LOGICAL, RELATIONAL, ADDITIVE, MULTIPLICATIVE }
	private final String operator;
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
	
    public String getOperator() { return operator; }
    public OpGroup getGroup()   { return opGroup; }
    public ASTree left()  { return child(0); }
    public ASTree right() { return child(1); }
    //@Override public String toString() { return "(" + left() + " " + operator + " " + right() + ")"; }

	@Override
	public Type getType() {
		if(opGroup == OpGroup.ADDITIVE || opGroup == OpGroup.MULTIPLICATIVE) {
			return child(0).getType();
		} else if(opGroup == OpGroup.LOGICAL || opGroup == OpGroup.RELATIONAL){
			return SymbolTableBuilder.Boolean;
		} else return new InvalidType();
	}
	
	@Override
	public String toString() {
		return this.getOperator();
	}




}
