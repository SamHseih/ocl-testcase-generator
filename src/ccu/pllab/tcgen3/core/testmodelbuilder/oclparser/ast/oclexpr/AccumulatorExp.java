package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.symboltable.type.Type;

public class AccumulatorExp extends VariableDeclExp {

	/** 
	* This only used for Acc variable , 
	* at visitIterateExpContextr{@code DcCLGBuilderVisitor} 
	*/
	public AccumulatorExp(String name,Type type) {
		super(name,type);
		// TODO Auto-generated constructor stub
	}

}
