package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.Symbol;

/**
 * for "result" obj in OCL
 * */
public class ResultExp extends VariableExp {
	public ResultExp(Symbol sym) {
		super("result", false, sym);
	    }
	@Override
	public ASTree clone() {
	    // varname、isMarkedPre 為不可變型別；symbol 依約定可安全共用
	    return new ResultExp(this.getSymbol() );
	}
}
