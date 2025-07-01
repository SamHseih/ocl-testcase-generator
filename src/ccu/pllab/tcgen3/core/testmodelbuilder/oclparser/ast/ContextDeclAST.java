package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.PrimitiveTypeSymbol;
import ccu.pllab.tcgen3.symboltable.type.Type;
import ccu.pllab.tcgen3.symboltable.type.VoidType;

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

	@Override
	public Type getType() {
		if(numChildren()>2) {
			for(int i = 2; i<numChildren(); i++) {
				if(!child(i-1).getType().getTypeName().equals(child(i).getType().getTypeName())) {
					return new InvalidType();
				} else if(!(child(i-1).getType() instanceof PrimitiveTypeSymbol)) {
					return new InvalidType();
				}
			}
			
			return new VoidType();
		} else {
			
			return new VoidType();
		}
	}
	
	public int getPreNum() {
		int rt=0;
		for(int i = 1; i<numChildren(); i++) {
			if(child(i) instanceof ContextExpAST c) {
				if(c.getKeyWord().equals("pre")) {
					rt++;
				}
			}
		}
		return rt;
	}
	
	public int getPostNum() {
		int rt=0;
		for(int i = 1; i<numChildren(); i++) {
			if(child(i) instanceof ContextExpAST c) {
				if(c.getKeyWord().equals("post")) {
					rt++;
				}
			}
		}
		return rt;
	}
	
	
	@Override
 	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("ContextDecl: ");
		sb.append(child(0)).append(" ");
		sb.append("\nContext:\n \t");
		for (int i = 1; i < numChildren(); i++) {
			sb.append(child(i));
			if (i < numChildren() - 1) {
				sb.append(",\n ");
			}
		}
		
		return sb.toString();
	}
	
	@Override
 	public String toAstString(){
		StringBuilder sb = new StringBuilder();
		sb.append("ContextDecl: node(");
		sb.append(child(0).id()).append(") ");
		sb.append("Context: ");
		for (int i = 1; i < numChildren(); i++) {
			sb.append("node (");
			sb.append(child(i).id());
			sb.append(")");
			if (i < numChildren() - 1) {
				sb.append(", ");
			}
		}
		
		return sb.toString();
	}
	
	@Override
 	public String toClgString(){
		StringBuilder sb = new StringBuilder();
		sb.append("ContextDecl: ");
		sb.append(child(0)).append(" ");
		sb.append("\nContext:\n \t");
		for (int i = 1; i < numChildren(); i++) {
			sb.append(child(i));
			if (i < numChildren() - 1) {
				sb.append(",\n ");
			}
		}
		
		return sb.toString();
	}
	
	public String getFilename() {
		StringBuilder sb = new StringBuilder();
			if(child(0) instanceof ClassifierContextDeclAST clazz) {
				sb.append(clazz.toString());
			}else if(child(0) instanceof OperationContextDeclAST clazz){
				sb.append(clazz.getPathName()).append("_");
				sb.append(clazz.getMethodName());
			}
			return sb.toString();
	}
	
	public String getClassname() {
		StringBuilder sb = new StringBuilder();
		if(child(0) instanceof ClassifierContextDeclAST clazz) {
			sb.append(clazz.toString());
		}else if(child(0) instanceof OperationContextDeclAST clazz){
			sb.append(clazz.getPathName());
		}
		return sb.toString();
	}
	
	public String getMethodName() {
		StringBuilder sb = new StringBuilder();
		if(child(0) instanceof OperationContextDeclAST opctx){
			sb.append(opctx.getMethodName());
		}
		return sb.toString();
	}
	
	@Override
 	public <R> R accept(AstVisitor<R> visitor) {
		return visitor.visitContextDeclAST(this);
	}

	@Override
	public ASTree clone() {
	    ASTree contextDeclClone = getContextDecl().clone(); // child(0)
	    
	    List<ASTree> clonedContexts = new ArrayList<>();
	    for (ASTree context : getContexts()) {
	        clonedContexts.add(context.clone());
	    }

	    return new ContextDeclAST(contextDeclClone, clonedContexts);
	}
}
