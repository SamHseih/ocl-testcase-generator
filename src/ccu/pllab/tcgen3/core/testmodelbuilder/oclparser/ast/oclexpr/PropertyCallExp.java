package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.type.Type;
/**In OCL spec 2.4 ch9.3.34 FeatureCallExpCS:<br>
 * A FeatureCallExp expression may have three different productions. Which one is chosen depends on the disambiguating
 * rules defined in each of the alternatives.<br>
 * [A] FeatureCallExpCS ::= OperationCallExpCS <br>
 * [B] FeatureCallExpCS ::= PropertyCallExpCS<br>
 * [C] FeatureCallExpCS ::= NavigationCallExpCS<br>
 * */
public class PropertyCallExp extends FeatureCallExp  {
	
	//Ex. self.datas.dimension
	private Type type;//type = intType
	private String name;//name = dimension
						//sym = fieldSymbol

	public PropertyCallExp(List<ASTree> source,String name, Type type, boolean isPre,Symbol sym) {
		super(source, isPre,sym);
        this.name = name;
        this.type = type;

    }

	@Override
    public ASTree getSource() { 
		if (numChildren() > 0) {
			return child(0); 
			} else {
				return null;
			}
		}
	
	@Override
    public Type getType() { return type; }

	@Override
	public String getFeatureName() {
		return name;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (numChildren() > 0) {
			sb.append(getSource().toString());
			sb.append(".");
		}
		sb.append(name);
		return sb.toString();
	}
	
	@Override
	public String toAstString() {
		StringBuilder sb = new StringBuilder();
		if (numChildren() > 0) {
			sb.append(getSource().toAstString());
			sb.append(".");
		}
		sb.append(name);
		return sb.toString();
	}
	
	@Override
	public String toClgString() {
		StringBuilder sb = new StringBuilder();
		if (numChildren() > 0) {
			sb.append(getSource().toClgString());
			sb.append(".");
		}
		sb.append(name);
		return sb.toString();
	}
	
	@Override
	public <R> R accept(AstVisitor<R> visitor) {
		return visitor.visitPropertyCallExpContext(this);
	}
	
	@Override
	public ASTree clone() {
	    // 1️ 複製 source（若存在）
	    java.util.List<ASTree> clonedSource = new java.util.ArrayList<>();
	    for (ASTree ch : this.children) {
	        clonedSource.add(ch.clone());
	    }

	    // 2 建立新節點
	    return new PropertyCallExp(
	        clonedSource,          // List<ASTree> source
	        this.name,             // property 名
	        this.type,             // Type 直接共用
	        this.isMarkedPre(),    // @pre 標記
	        this.sym               // Symbol 直接共用
	    );
	}
}
