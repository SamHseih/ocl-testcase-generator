package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.List;

public class ContextExpAST extends ASTList {

	String contextKeyword;
	String contextlabel;
	
	public ContextExpAST(List<ASTree> oclexpression, String contextKeyword, String contextlabel) {
		super(oclexpression);
		this.contextKeyword = contextKeyword;
		this.contextlabel = contextlabel;
	}
	
}
