package ccu.pllab.tcgen3.symboltable.type;

import ccu.pllab.tcgen3.symboltable.BaseSymbol;

public class InvalidType extends BaseSymbol implements Type {

  public InvalidType() {
    super("INVALID", "INVALID");
    // TODO Auto-generated constructor stub
  }

  @Override
  public String getTypeName() {
    return "INVALID";
  }

  @Override
  public String getTypeID() {
    return "INVALID";
  }

  @Override
  public int getTypeIndex() {
    return -1;
  }

}
