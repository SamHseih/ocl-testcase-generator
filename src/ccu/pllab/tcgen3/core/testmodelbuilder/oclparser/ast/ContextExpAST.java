package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.symboltable.type.Type;

public class ContextExpAST extends ASTList {

	private final String contextKeyword;
	private final String contextlabel;
	
	public ContextExpAST(List<ASTree> oclexpression, String contextKeyword, String contextlabel) {
		super(oclexpression);
		this.contextKeyword = contextKeyword;
		this.contextlabel = contextlabel;
	}

	@Override
	public Type getType() {
		return child(0).getType();
	}
	
	public String getKeyWord() {
		return this.contextKeyword;
	}
	
	public String getContextlabel() {
		return this.contextlabel;
	}
	
	public ASTree getConstraint() {
		return child(0);
	}
	
	@Override
	public String toAstString(){
		return contextlabel +" "+ contextKeyword + ":";
	}
	
	@Override
	public String toClgString(){
		return contextlabel +" "+ contextKeyword + ":";
	}
	
	@Override
	public String toString(){
		return contextlabel +" "+ contextKeyword + ":";
	}
	

	@Override
	public <R> R accept(AstVisitor<R> visitor) {
		return visitor.visitContextExp(this);
	}

	@Override
	public ASTree clone() {
	    List<ASTree> clonedChildren = new ArrayList<>();
	    for (ASTree child : children) {
	        clonedChildren.add(child.clone());
	    }
	    return new ContextExpAST(clonedChildren, contextKeyword, contextlabel);
	}
	
}
