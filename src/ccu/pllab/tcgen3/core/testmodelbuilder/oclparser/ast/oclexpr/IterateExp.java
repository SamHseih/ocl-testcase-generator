package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;


public class IterateExp extends LoopExp {

	/** OCL «iterate»  
	 * collection->iterate(elem: Type; acc: Type = expression | expression-with-elem-and-acc) <br>
	 * IterateExp<br>
	 * ├── ASTree child(0)		 :  source <br>
	 * ├── VariableDecl child(1) :  iteratorDecl<br>
	 * ├── VariableDecl child(2) :  AccumulatorDecl<br>
	 * ├── ASTree child(3) 		 :  body
	 *  */
	public IterateExp(List<ASTree> children, boolean isPre) {
		super(children, isPre);
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("IterateExp: ").append(getSource()).append("\n");
		sb.append("IteratorDecl: ").append(getIteratorDecl()).append("\n");
		sb.append("ResultDecl: ").append(getResultDecl()).append("\n");
		sb.append("Body: ").append(getBody()).append("\n");
		return sb.toString();
	}

}
