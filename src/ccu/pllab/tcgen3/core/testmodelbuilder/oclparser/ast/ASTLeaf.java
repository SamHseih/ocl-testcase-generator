package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.ArrayList;
import java.util.Iterator;

import ccu.pllab.tcgen3.symboltable.scope.Scope;

public abstract class ASTLeaf extends ASTree{

	private static ArrayList<ASTree> empty = new ArrayList<>();
	private Scope scope;
    
    public void setScope(Scope scope) {
		this.scope = scope;
	}
    
    public Scope getScope() {
		return scope;
	}

    @Override
    public ASTree child(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int numChildren() {
        return 0;
    }

    @Override
    public Iterator<ASTree> children() {
        return empty.iterator();
    }

    @Override
    public String toString() {
    	return "Leaf#"+ id() + " @" + scope.getName();
    }

    @Override
    public String location() {
        return "at Scope "+ scope.getName();
    }
    

	
}
