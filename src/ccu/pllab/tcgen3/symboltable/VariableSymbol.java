package ccu.pllab.tcgen3.symboltable;

public class VariableSymbol extends BaseSymbol{
	
	public VariableSymbol(String name) {
		super(name);
	}
	
	public VariableSymbol(String name, String umlID) {
		super(name, umlID);
	}

	@Override
	public String toString() {
		return this.umlId;
	}
}
