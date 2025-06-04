package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;
import ccu.pllab.tcgen3.symboltable.type.VoidType;

/** AST Root*/
public class PackageDeclAST extends ASTList {
	String packageName;
	Scope umldefinitionScope;	
	
	public PackageDeclAST(List<ASTree> children, String packageName) {
		super(children);
		this.packageName = packageName;

	}

	@Override
	public Type getType() {
		if(numChildren()>1) {
			for(int i = 0; i<numChildren(); i++) {
				if(!(child(i).getType() instanceof VoidType)) {
					return new InvalidType();
				}
			}
			return new VoidType();
		} else if (!(child(0).getType() instanceof VoidType)) {
			return new InvalidType();
		}
	return new 	VoidType();
		
	}
	
	
	public String getPackagename() {
		return packageName;
	}
	
	public String getClassName() {
		StringBuilder sb = new StringBuilder();
		if(child(0) instanceof ContextDeclAST c) {
			if(c.getContextDecl() instanceof ClassifierContextDeclAST clazz) {
				sb.append(clazz.toString());
			}
		} else {
			sb.append("There hasn't Class.");
		}
		return sb.toString();
	}
	
	public String getMethodName() {
		StringBuilder sb = new StringBuilder();
		if(child(0) instanceof ContextDeclAST c) {
			if(c.getContextDecl() instanceof OperationContextDeclAST clazz){
				sb.append(clazz.getPathName()).append("_");
				sb.append(clazz.getMethodName());
			}
		} else {
			sb.append("There hasn't Method.");
		}
		return sb.toString();
	}

	
	@Override
	public String toString() {
		return "PackageName: "+this.packageName;
	}
	
	@Override
	public String toAstString() {
		return "PackageName: "+this.packageName;
	}
	
	@Override
	public String toClgString() {
		return "PackageName: "+this.packageName;
	}
	
	@Override
	public <R> R accept(CLGAstVisitor<R> visitor) {
		return visitor.visitPackageDeclASTContext(this);
	}
	
	@Override
	public ASTree clone() {
	    List<ASTree> clonedChildren = new ArrayList<>();
	    for (ASTree child : this.children) {
	        clonedChildren.add(child.clone());
	    }

	    PackageDeclAST clone = new PackageDeclAST(clonedChildren, this.packageName);
	    
	    // �`�N�GumldefinitionScope �w�]�� null�C�p�G�A���ӻݭn�A�]�i��� set �i clone ���C
	    // �Ҧp�G
	    // clone.umldefinitionScope = this.umldefinitionScope;

	    return clone;
	}
}
