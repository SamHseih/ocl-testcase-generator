package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.symboltable.type.Type;
import ccu.pllab.tcgen3.symboltable.type.VoidType;

public class OperationContextDeclAST extends ASTList {
	
	private final String  pathName;
	private final String  methodName;
	private Type returnType;//null is OK!
	
	public OperationContextDeclAST(List<ASTree> parameters, String methodName, String pathName) {
		super(parameters);
		this.pathName = pathName;
		this.methodName = methodName;
		returnType = null;
	}
	
	public List<ASTree> getParameters() {
		return children;
	}
	
	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}
	
 
	public String getPathName() {
		return pathName;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(pathName).append("::").append(methodName);
		 sb.append("(");
		
		for (int i = 0; i < numChildren(); i++) {

			sb.append(child(i));

			if (i < numChildren() - 1) {
				sb.append(", ");
			}
		}
		sb.append(")"); 
		if (returnType != null) {
			sb.append(" : ").append(returnType.getTypeName());
		}
		
		return sb.toString();
		
	}
	
	@Override
	public String toAstString() {
		StringBuilder sb = new StringBuilder();
		sb.append(pathName).append("::").append(methodName);
		 sb.append("(");
		
		for (int i = 0; i < numChildren(); i++) {
			sb.append("node (");
			sb.append(child(i).id());
			sb.append(")");
			if (i < numChildren() - 1) {
				sb.append(", ");
			}
		}
		sb.append(")"); 
		if (returnType != null) {
			sb.append(" : ").append(returnType.getTypeName());
		}
		
		return sb.toString();
		
	}
	
	@Override
	public String toClgString() {
		StringBuilder sb = new StringBuilder();
		sb.append(pathName).append("::").append(methodName);
		 sb.append("(");
		
		for (int i = 0; i < numChildren(); i++) {

			sb.append(child(i));

			if (i < numChildren() - 1) {
				sb.append(", ");
			}
		}
		sb.append(")"); 
		if (returnType != null) {
			sb.append(" : ").append(returnType.getTypeName());
		}
		
		return sb.toString();
	}

	/* default Boolean for ASTree **not perfect!**  */
	@Override
	public Type getType() {
		return new VoidType();
	}

	@Override
	public <R> R accept(CLGAstVisitor<R> visitor) {
		return visitor.visitOperationContext(this);
	}
	
	/**
	 * Type is considered immutable and can be safely shared among AST nodes.
	 */
	@Override
	public ASTree clone() {
	    List<ASTree> clonedChildren = new ArrayList<>();
	    for (ASTree child : children) {
	        clonedChildren.add(child.clone());
	    }

	    OperationContextDeclAST clone = new OperationContextDeclAST(clonedChildren, methodName, pathName);
	    
	    if (this.returnType != null) {
	        // 假設 Type 是 immutable 或 clone-safe，可直接指派
	        clone.setReturnType(this.returnType);
	    }

	    return clone;
	}
}


