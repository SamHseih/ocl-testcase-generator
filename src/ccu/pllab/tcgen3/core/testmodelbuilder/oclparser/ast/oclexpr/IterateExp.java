package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
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

}
