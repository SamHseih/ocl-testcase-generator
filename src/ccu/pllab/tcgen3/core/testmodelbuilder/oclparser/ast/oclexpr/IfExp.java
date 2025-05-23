package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.SymbolTableBuilder;
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

	@Override  //always boolean   ****not perfect!***
	public Type getType() {

        return SymbolTableBuilder.Boolean;
	}

	@Override
	public String toString() {
		return "IfExp ConditionNode:("+child(0).id()+") thenNode: ("+child(1).id()+") elseNode: ("+child(2).id()+")";
	}

}
