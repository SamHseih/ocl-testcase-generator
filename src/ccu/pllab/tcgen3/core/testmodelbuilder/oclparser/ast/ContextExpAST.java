package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.List;

import ccu.pllab.tcgen3.symboltable.type.Type;

public class ContextExpAST extends ASTList {

	String contextKeyword;
	String contextlabel;
	
	public ContextExpAST(List<ASTree> oclexpression, String contextKeyword, String contextlabel) {
		super(oclexpression);
		this.contextKeyword = contextKeyword;
		this.contextlabel = contextlabel;
	}

	@Override
	public Type getType() {
		return child(0).getType();
	}
	
	@Override
	public String toString(){
		return contextlabel +" "+ contextKeyword + ":";
	}
}
