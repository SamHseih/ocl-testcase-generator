package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.List;

import ccu.pllab.tcgen3.symboltable.type.Type;

public class OperationContextDeclAST extends ASTList {
	
	private final String  pathName;
	private final String  methodName;
	private Type returnType;
	
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
	
	public Type getReturnType() {
		return returnType;
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
		sb.append(pathName).append("::").append(methodName).append("(");
		
		for (int i = 0; i < numChildren(); i++) {
			sb.append(children.get(i));
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
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
}


