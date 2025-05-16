package ccu.pllab.tcgen3.symboltable.type;

import ccu.pllab.tcgen3.symboltable.BaseSymbol;

/** Set this Type from UML multiplicity 0..1, 0..* */
public class MultiplicityListType extends BaseSymbol implements Type{
	private int size;
	private final Type elementType;
	
	public MultiplicityListType(Type elementType, String umlID) {
		super("MultiplicityListType",umlID);
		this.elementType = elementType;

	}
	
	public MultiplicityListType(String name,Type elementType) {
		super(name+"MultiplicityListType");
		this.elementType = elementType;
	}
	
	public MultiplicityListType(String name,Type elementType,String umlID) {
		super(name+"MultiplicityListType",umlID);
		this.elementType = elementType;
	}

	@Override
	public String getTypeName() {	
		return  this.name;
	}
	
	@Override
	public String getTypeID() {
		return umlId;
	};

	@Override
	public int getTypeIndex() {
		return -1;
	}
	
	/* for static array set when parsing UML CD ex. int[2][3][4]*/
	public void setSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	
	
}
