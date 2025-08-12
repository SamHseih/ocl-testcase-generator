package ccu.pllab.tcgen3.core.testmodelbuilder.nouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.type.PrimitiveTypeSymbol;
import ccu.pllab.tcgen3.symboltable.type.Type;

/** for static Multi Dimension Array */
public class StaticArrayClassSymbol extends ClassSymbol {

  private final int dimension;
  /** int[2][3][4] -> [2,3,4] */
  private final int[] dimensionSizes;
  /** int[2][3][4] -> int */
  private Type elementType;

  private int[] elements;

  public StaticArrayClassSymbol(String umlName, String umlID, Type elementType) {
    super(umlName, umlID);
    this.elementType = elementType;
    dimensionSizes = parseArrayType(umlName);
    this.dimension = dimensionSizes.length;
  }

  private int[] parseArrayType(String umlDatatype) {
    Pattern p = Pattern.compile("^(\\w+)((\\[\\d+])+)$"); // 例：int[2][3][4]
    Matcher m = p.matcher(umlDatatype);
    if (!m.matches())
      throw new IllegalArgumentException("格式不合法：" + umlDatatype);

    String base = m.group(1); // int
    String dims = m.group(2); // [2][3][4]

    // 取出每一個 [n]
    Matcher d = Pattern.compile("\\[(\\d+)]").matcher(dims);
    List<Integer> sizes = new ArrayList<>();
    while (d.find())
      sizes.add(Integer.parseInt(d.group(1)));

    return sizes.stream().mapToInt(Integer::intValue).toArray();
  }

  @Override
  public String getTypeName() {
    return this.name;
  }

  @Override
  public int getTypeIndex() {
    // TODO Auto-generated method stub
    return 0;
  }

  public int getDimension() {
    return dimension;
  }

  public int[] getDimensionSizes() {
    return dimensionSizes;
  }

  public Type getElementType() {
    return elementType;
  }

  public static void main(String[] args) {
    PrimitiveTypeSymbol intType = new PrimitiveTypeSymbol("int", "1231@#$%^&*(");
    StaticArrayClassSymbol array = new StaticArrayClassSymbol("int[2][3][4][4]", "umlID", intType);
    System.out.println(Arrays.toString(array.dimensionSizes));
    System.out.println(array.getTypeName());
  }
}
