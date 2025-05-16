package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;


/** Type need Dinamic Setting*/
public class IfExp extends ASTList implements Expression {
	Type returnType;
	
	public IfExp(List<ASTree> children) {
        super(children);
    }
	
	ASTree condition()  { return  child(0); }
	ASTree thenBranch() { return  child(1); }
	ASTree elseBranch() { return  child(2); }

	@Override
	public Type getType() {
		if(returnType == null)
		{return new InvalidType();}
        return returnType;
	}
	
	public void setreturnType(Type type) {
		this.returnType = type;
	}

}
