package ccu.pllab.tcgen3.symboltable;

/** A method symbol is a function that lives within an aggregate/class and has a slot number. */
public class MethodSymbol extends FunctionSymbol implements MemberSymbol {
	protected int slot = -1;


	public MethodSymbol(String name, String umlID) {
		super(name, umlID);
	}

	@Override
	public int getSlotNumber() { return slot; }
	

}
