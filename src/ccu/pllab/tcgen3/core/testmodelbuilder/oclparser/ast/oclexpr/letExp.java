package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class LetExp extends ASTList implements Expression{
	
	/**	letExp
	 *  ¢u¢w¢w child(0): VariableDeclExp
	 *  ¢u¢w¢w child(1): VariableDeclExp
	 *  ...
	 *  ¢u¢w¢w child(n): oclExpression
	 * */
	public LetExp(List<ASTree> children) {
		super(children);
	}
	
	public List<ASTree> getVariabledecls() {
		List<ASTree> variableDecls = new ArrayList<>();
		for (int i = 0; i < numChildren() - 1; i++) {
			variableDecls.add(child(i));
		}
		return variableDecls;
	}
	public ASTree getOclExpression() {
		return child(numChildren()-1);
	}

	@Override
	public Type getType() {
		return child(numChildren()-1).getType();
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("LetExp \nLet ");
		for(int i=0;i<numChildren();i++) {
			sb.append("node(" + child(i).id()+")");
			if(i==numChildren()-1) {
				sb.append(" in node("+child(i).id()+")");
				break;
			} else {
				sb.append(", ");
			}
			
		}
		
		return sb.toString();
	}
	
	@Override
	public String toAstString(){
		StringBuilder sb = new StringBuilder();
		sb.append("LetExp \nLet ");
		for(int i=0;i<numChildren();i++) {
			sb.append("node(" + child(i).id()+")");
			if(i==numChildren()-1) {
				sb.append(" in node("+child(i).id()+")");
				break;
			} else {
				sb.append(", ");
			}
			
		}
		
		return sb.toString();
	}
	
	@Override
	public String toClgString(){
		StringBuilder sb = new StringBuilder();
		sb.append("LetExp \nLet ");
		for(int i=0;i<numChildren();i++) {
			sb.append("node(" + child(i).id()+")");
			if(i==numChildren()-1) {
				sb.append(" in node("+child(i).id()+")");
				break;
			} else {
				sb.append(", ");
			}
			
		}
		
		return sb.toString();
	}
	
	@Override
	public <R> R accept(AstVisitor<R> visitor) {
		return visitor.visitLetExpContext(this);
	}
	
	@Override
	public ASTree clone() {
	    List<ASTree> clonedChildren = new ArrayList<>();
	    for (ASTree ch : this.children) {
	        clonedChildren.add(ch.clone());
	    }
	    return new LetExp(clonedChildren);
	}
}
