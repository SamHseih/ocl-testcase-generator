package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.List;

import ccu.pllab.tcgen3.symboltable.type.PrimitiveTypeSymbol;
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

	/* default Boolean for ASTree **not perfect!**  */
	@Override
	public Type getType() {
		Type defaultt = new PrimitiveTypeSymbol("","");
		return defaultt;
	}
}


