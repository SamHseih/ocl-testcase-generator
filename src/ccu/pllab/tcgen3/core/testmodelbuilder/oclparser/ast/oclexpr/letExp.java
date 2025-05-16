package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class letExp extends ASTList implements Expression{
	
	/**	vaiabledecls = child(0)
	 *  oclExpression = child(1)
	 * */
	public letExp(List<ASTree> children) {
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
		return ((Expression) child(1)).getType();
	}
}
