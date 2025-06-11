package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

public class IndexVariableExp extends VariableExp{
	// IndexVariableExp is a leaf node in the abstract syntax tree
	// It represents an indexed variable in the OCL expression
	// For example: x[0], y[1], etc.
	
	//private int index ;

	/** 
	* This only used for indexed variable , 
	* at visitIterateExpContextr{@code DcCLGBuilderVisitor} 
	*/
	public IndexVariableExp(String name) {
		super(name, false, null);
		//index = 0;
	}
/*
	public int getIndex() {
		return index;
	}
	
	public void nextIndex() {
		// Increment the index for the next iteration
		this.index++;
	}*/

	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public String toClgString() {
		return this.getName(); //+ " = " + index;
	}
}
