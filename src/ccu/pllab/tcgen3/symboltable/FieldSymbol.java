package ccu.pllab.tcgen3.symboltable;

/** A field symbol is just a variable that lives inside an aggregate like a
 *  class or struct.
 */
public class FieldSymbol extends VariableSymbol implements MemberSymbol {
	protected int slot;
	protected String lowerValue;
	protected String upperValue;
	protected String defaultValue;
	

	
	public FieldSymbol(String name, String umlID) {
		super(name, umlID);
	}

	@Override
	public int getSlotNumber() { return slot; }
	
	public void setMultiplicity(String lowerValue, String upperValue) {
		this.lowerValue = lowerValue;
		this.upperValue = upperValue;
	}
	
	public String getMultiplicity() {
		return lowerValue + ".." + upperValue;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	
	
}
