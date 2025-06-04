package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * nonLeaf node for abstract syntax tree
 * Created by yangruihan on 2016/11/21.
 */
public abstract class ASTList extends ASTree{
	protected List<ASTree> children;

	public ASTList(List<ASTree> children) {
    	super();
    	this.children = children;
    }

	@Override
	public ASTree child(int i) {
		return children.get(i);
	}

	@Override
	public int numChildren() {
		return children.size();
	}

	@Override
	public Iterator<ASTree> children() {
		return children.iterator();
	}

	@Override
	public String location() {
		for(ASTree t : children) {
			String s = t.location();
			if (s != null) {
				return s;
			}
		}
		return null;
	}
	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        String sep = "";
        for (ASTree t : children) {
            builder.append(sep);
            sep = " ";
            builder.append(t.toString());
        }
        return builder.append(")").toString();
    }
}
