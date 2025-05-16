package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.ArrayList;
import java.util.List;

public class ContextDeclAST extends ASTList {
	
	/** ContextDeclAST 
	 * ¢u¢w¢w child(0) is ContexDecl 
	 * ¢u¢w¢w child(1) is inv/pre/post ...
	 * ¢u¢w¢w child(2) is inv/pre/post ...
	 *  */
	public ContextDeclAST(ASTree contextDecl, List<ASTree> contexts) {
		super(merge(contextDecl, contexts));
	}
	
	private static List<ASTree> merge(ASTree source, List<ASTree> args) {
    	List<ASTree> list = new ArrayList<>();
        if (source != null) {
        	list.add(source);
        	}
        list.addAll(args);
        return list;
	}
	
	public ASTree getContextDecl() {
		return child(0);
	}
	
	public List<ASTree> getContexts() {
		return children.subList(1, children.size());
	}
	
	
}
