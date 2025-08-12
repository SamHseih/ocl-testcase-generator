package ccu.pllab.tcgen3.symboltable;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ccu.pllab.tcgen3.symboltable.type.Type;

/**
 * A symbol representing a collection of data like a struct or class. Each member has a slot number
 * indexed from 0 and we track data fields and methods with different slot sequences. A
 * DataAggregateSymbol can also be a member of an aggregate itself (nested structs, ...).
 */
public abstract class DataAggregateSymbol extends SymbolWithScope implements MemberSymbol, Type {
  protected ParserRuleContext defNode;
  protected int nextFreeFieldSlot = 0; // next slot to allocate
  protected int typeIndex;

  public DataAggregateSymbol(String name, String umlID) {
    super(name, umlID);
  }

  public void setDegNode(ParserRuleContext defNode) {
    this.defNode = defNode;
  }

  public ParserRuleContext getDefNode() {
    return defNode;
  }

  @Override
  public void define(Symbol sym) throws IllegalArgumentException {
    if (!(sym instanceof MemberSymbol)) {
      throw new IllegalArgumentException(
          "sym is " + sym.getClass().getSimpleName() + " not MemberSymbol");
    }
    super.define(sym);
    setSlotNumber(sym);
  }


  /**
   * Look up name within this scope only. Return any kind of MemberSymbol found or null if nothing
   * with this name found as MemberSymbol.
   */
  public Symbol resolveMember(String name) {
    Symbol s = symbols.get(name);
    if (s instanceof MemberSymbol) {
      return s;
    }
    return null;
  }

  /**
   * Look for a field with this name in this scope only. Return null if no field found.
   */
  public Symbol resolveField(String name) {
    Symbol s = resolveMember(name);
    if (s instanceof FieldSymbol) {
      return s;
    }
    return null;
  }

  /** get the number of fields defined specifically in this class */
  public int getNumberOfDefinedFields() {
    int n = 0;
    List<? extends Symbol> symbols = getSymbols();
    for (Symbol s : symbols) {
      if (s instanceof FieldSymbol) {
        n++;
      }
    }
    return n;
  }

  /** Get the total number of fields visible to this class */
  public int getNumberOfFields() {
    return getNumberOfDefinedFields();
  }

  /** Return the list of fields in this specific aggregate */
  public List<? extends FieldSymbol> getDefinedFields() {
    List<FieldSymbol> fields = new ArrayList<>();
    List<? extends Symbol> symbols = getSymbols();
    for (Symbol s : symbols) {
      if (s instanceof FieldSymbol f) {
        fields.add(f);
      }
    }
    return fields;
  }

  public List<? extends FieldSymbol> getFields() {
    return getDefinedFields();
  }

  public void setSlotNumber(Symbol sym) {
    if (sym instanceof FieldSymbol) {
      FieldSymbol fsym = (FieldSymbol) sym;
      fsym.slot = nextFreeFieldSlot++;
    }
  }

  @Override
  public int getSlotNumber() {
    return -1; // class definitions do not yield either field or method slots; they are just nested
  }

  @Override
  public int getTypeIndex() {
    return typeIndex;
  }

  public void setTypeIndex(int typeIndex) {
    this.typeIndex = typeIndex;
  }



}

