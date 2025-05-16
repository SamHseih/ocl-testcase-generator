package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.BaseSymbol;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class ArrayRefExp extends FeatureCallExp  {
	private final String arrayName;
	private Symbol sym;
	
	/** New OCL Extends «ArrayRef»  
	 * ArrayRefExp Ex. x = self.a[2][4][5]<br> 
	 * ├── ASTree child(0)		 :  source = self <br>
	 * ├── ASTree child(1) 		 :  index = 5
	 * ├── ASTree child(2) 		 :  index = 4
	 * └── ASTree child(3) 		 :  index = 2
	 *  */
	public ArrayRefExp(List<ASTree> children, boolean isPre, String arrayName) {
		super(children, isPre);
		this.arrayName = arrayName;
		
	}
	
	public void setSymbol(Symbol symbol) {
		this.sym = symbol;
	}
	
	public List<ASTree> getIndex() {
		List<ASTree> indexList = new ArrayList<>();
		if (numChildren() == 0) {
			return indexList;
		}
		for (int i = 1; i < numChildren(); i++) {
			ASTree child = child(i);
			indexList.add(child);
		}
		return indexList;
	}

	@Override
	public ASTree getSource() {
		return child(0);
	}

	@Override
	public String getName() {
		return arrayName;
	}

	@Override
	public Type getType() {
		if (sym instanceof BaseSymbol) {
			return ((BaseSymbol) sym).getType();
		}
		else if (sym instanceof ClassSymbol) {
			Type tp = (Type) this.sym;
			return tp;
		}else return null;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getSource().toString()).append(".").append(arrayName);
		for (ASTree index : getIndex()) {
			sb.append("[").append(index.toString()).append("]");
		}
		if (isPre()) {
			sb.append("@pre");
		}
		return sb.toString();
		
	}

}
