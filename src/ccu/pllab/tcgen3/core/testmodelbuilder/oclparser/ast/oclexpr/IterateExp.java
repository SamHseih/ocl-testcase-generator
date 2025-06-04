package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.CLGAstVisitor;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.type.Type;


public class IterateExp extends LoopExp {

	/** OCL «iterate»  
	 * collection->iterate(elem: Type; acc: Type = expression | expression-with-elem-and-acc) <br>
	 * IterateExp<br>
	 * ├── ASTree child(0)		 :  source <br>
	 * ├── VariableDecl child(1) :  iteratorDecl<br>
	 * ├── VariableDecl child(2) :  AccumulatorDecl<br>
	 * ├── ASTree child(3) 		 :  body
	 *  */
	public IterateExp(List<ASTree> children, boolean isPre, Symbol sourcesym) {
		super(children, isPre,sourcesym);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ASTree getSource() {
		return this.child(0);
	}
	
	//Only for Sequence{..}
	public String getSourceSize() {
		if(getSource() instanceof CollectionRange c) {
			return c.toString();
		}else if(getSource() instanceof CollectionItem c) {
			return c.getSize();
		}
		return getSource().toString();
	}

	@Override
	public String getName() {
		return "iterate";
	}
	
	public ASTree getIteratorDecl() {
		return this.child(1);
	}
	public ASTree getResultDecl() {
		return this.child(2);
	}
	public ASTree getBody() {
		return this.child(3);
	}

	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("IterateExp");
		return sb.toString();
	}
	
	//for CLG visualization Info
	public String toClgString(){
		StringBuilder sb = new StringBuilder();
		sb.append("i = 1\n");
		sb.append("i<").append(getSourceSize()).append("\n");
		sb.append("Accumulator: ").append(getResultDecl()).append("\n");
		sb.append("Loop Var: ").append(getIteratorDecl());
		return sb.toString();
	}
	
	@Override
	public String toAstString(){
		StringBuilder sb = new StringBuilder();
		sb.append("IterateExp\n");
		sb.append("source=node(").append(getSource().id()).append(") ");
		sb.append("Iterator=node(").append(getIteratorDecl().id()).append(")\n");
		sb.append("Result=node(").append(getResultDecl().id()).append(") ");
		sb.append("Body=node(").append(getBody().id()).append(")");
		return sb.toString();
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return child(2).getType();
	}
	
	@Override
	public <R> R accept(CLGAstVisitor<R> visitor) {
		return visitor.visitIterateExpContext(this);
	}
	
	@Override
	public ASTree clone() {
	    // 1️⃣ 深層複製四個子節點
	    List<ASTree> clonedChildren = new ArrayList<>();
	    for (ASTree ch : this.children) {
	        clonedChildren.add(ch.clone());
	    }

	    // 2️⃣ 建立新實例
	    IterateExp clone = new IterateExp(
	        clonedChildren,
	        this.isMarkedPre(),   // 來自 FeatureCallExp
	        this.sym              // Symbol 不可變 → 直接共用
	    );

	    return clone;
	}
}
