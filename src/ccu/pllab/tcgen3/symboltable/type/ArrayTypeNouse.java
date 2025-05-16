package ccu.pllab.tcgen3.symboltable.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ccu.pllab.tcgen3.symboltable.BaseSymbol;

/** 
 * Represents an array type in the symbol table.
 * This class extends BaseSymbol and implements the Type interface.
 * It contains information about the element type, dimensions, and number of elements in the array.
 * 
 * @author Sam Hsieh
 * @version 1.0
 * @since 2025-04-02
 */
public class ArrayTypeNouse<T> extends BaseSymbol implements Type{
	
	private final int dimension;
	private List<Integer> dimensionSizeList;//Constraint Solver will use this to determine the size of the array
	private final T elementType;
	
	public ArrayTypeNouse(int dimension, T elementType) {
		super("ArrayType");
		 if (dimension <= 0) {
	            throw new IllegalArgumentException("Dimension must be > 0");
	        }
        this.dimension = dimension;
        this.elementType = elementType;
	}
	
	// Constructor for ArrayType with UML ID
	public ArrayTypeNouse(int dimension, T elementType, String umlID) {
		super("ArrayType",umlID);
        this.dimension = dimension;
        this.elementType = elementType;
	}
	
	public void setDimensionList(List<Integer> dimensionList) {
		if (dimensionList.size() != this.dimension) {
            throw new IllegalArgumentException("Dimension list size does not match declared dimension");
        }
        this.dimensionSizeList = new ArrayList<>(dimensionList);
	}
	
	public int getDimension() {
		return this.dimension;
	}
	
	public int getDim(int index) {
		if (dimensionSizeList == null || dimensionSizeList.isEmpty()) {
            throw new IllegalStateException("Dimension size list not initialized");
        }
        return dimensionSizeList.get(index);
	}
	
	public List<Integer> getDimensionSizeList() {
		if (dimensionSizeList == null || dimensionSizeList.isEmpty()) {
			throw new IllegalStateException("Dimension size list not initialized");
		}
        return dimensionSizeList;
    }
	
	public int length() {
		int totalSize = this.dimensionSizeList.stream().reduce(1, (a, b) -> a * b);
		return totalSize;
	}
	
	@Override
	public String getTypeName() {
		StringBuilder sb = new StringBuilder();
		if (dimension==0) {
			sb.append("ArrayType: dimensions is null. Please set dimensions first.");
			return sb.toString();
		}
		for (int i = 0; i <= dimension; i++) {
			if (i == 1) {
				sb.append(this.elementType.getTypeName());sb.append("[]");
			} else if (i > 1) {
				sb.append("[]");
			}
		}
		return sb.toString();
	}
	
	@Override
	public String getTypeID() {
		return umlId;
	};

	@Override
	public int getTypeIndex() {
		return -1;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (dimensionSizeList == null) {
			sb.append("ArrayType: dimensions is null. Please set dimensions first.");
			return sb.toString();
		}
		sb.append("ArrayType: \n");
		sb.append("Element Type: " + this.elementType.getTypeName() + "\n");
		sb.append("Dimensions: " + dimensionSizeList + "\n");
		sb.append("Number of elements: " + this.length() + "\n");
		sb.append("UML ID: " + this.getTypeID() + "\n");
		return sb.toString();
	}
	
	//testmain
	public static void main(String[] args) {
		PrimitiveTypeSymbol IntType = new PrimitiveTypeSymbol("int","_iOnJ4OnaEe-T_te4-ZDSjw");
		ArrayTypeNouse ThreeDimArray = new ArrayTypeNouse(3,IntType,"_CgSrIOkjEe-mT49qQirICQ");
		System.out.println(ThreeDimArray);
		
		List<Integer> dims = new ArrayList<>();
		dims.add(4);
		dims.add(5);
		dims.add(2);
		
		ThreeDimArray.setDimensionList(dims);
		System.out.println(ThreeDimArray);
		System.out.println("Dimension 0: " + ThreeDimArray.getDim(0));
		System.out.println("Dimension 1: " + ThreeDimArray.getDim(1));
		System.out.println("Dimension 2: " + ThreeDimArray.getDim(2));
		//System.out.println("Dimension 3: " + ThreeDimArray.getDim(3)); // out of bounds
	}
	

}
