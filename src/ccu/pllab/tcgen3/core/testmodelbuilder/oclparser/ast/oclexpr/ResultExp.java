package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.symboltable.VariableSymbol;

/**
 * for "result" obj in OCL
 * */
public class ResultExp extends VariableExp {
	public ResultExp(VariableSymbol sym) {
		super("result", false, sym);
	    }
	
}
