package ccu.pllab.tcgen3.symboltable.type;

import ccu.pllab.tcgen3.symboltable.ClassSymbol;

public class PrimitiveTypeSymbol extends ClassSymbol {

  public PrimitiveTypeSymbol(String name, String umlID) {
    super(name, umlID);
  }

  @Override
  public int getTypeIndex() {
    // TODO Auto-generated method stub
    return 0;
  }

  // Not used in TCGen3,
  public void setTypeIndex(int typeIndex) {
    this.typeIndex = typeIndex;
  }

  @Override
  public String getTypeName() {
    return this.name;
  }

  @Override
  public String toString() {
    return this.umlID;
  }



}
