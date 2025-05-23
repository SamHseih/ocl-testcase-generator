package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class LetExp extends ASTList implements Expression{
	
	/**	letExp
	 *  ¢u¢w¢w child(0): VariableDeclExp
	 *  ¢u¢w¢w child(1): oclExpression
	 * */
	public LetExp(List<ASTree> children) {
		super(children);
	}
	
	public ASTree variabledecls() {
		return child(0);
	}
	public ASTree oclExpression() {
		return child(1);
	}

	@Override
	public Type getType() {
		return child(1).getType();
	}
	
	@Override
	public String toString(){
		return "LetExp \nLet node(" + child(0).id()+") in node("+child(1).id()+")";
	}
}
