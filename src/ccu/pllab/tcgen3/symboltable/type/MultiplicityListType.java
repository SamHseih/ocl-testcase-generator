package ccu.pllab.tcgen3.symboltable.type;

/** Set this Type from UML multiplicity 0..1, 0..* */
public class MultiplicityListType extends ArrayTypeClassSymbol{
	private int size;
	private final Type elementType;
	
//	public MultiplicityListType(Type elementType, String umlID) {
//		super("MultiplicityListType",umlID);
//		this.elementType = elementType;
//	}
//	
//	public MultiplicityListType(String name,Type elementType) {
//		super(name, name+"MultiplicityListType");
//		this.elementType = elementType;
//	}
	
	//For UML Builded  name = ClassName::attributeName
	//umlID is UML upperValue ID
	public MultiplicityListType(String name,Type elementType,String umlID) {
		super(name,umlID);
		this.elementType = elementType;
	}

	@Override
	public String getTypeName() {	
		return  this.name;
	}
	
	@Override
	public String getTypeID() {
		return this.umlID;
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
	
	public Type getElementType() {
		return this.elementType;
	}
	
	@Override
	public String toString() {
		return this.umlID;
	}
	
	
}
