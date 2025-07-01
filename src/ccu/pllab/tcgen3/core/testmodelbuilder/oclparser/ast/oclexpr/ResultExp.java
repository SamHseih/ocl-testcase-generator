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
	    // varname�BisMarkedPre �����i�ܫ��O�Fsymbol �̬��w�i�w���@��
	    return new ResultExp(this.getSymbol() );
	}
}
