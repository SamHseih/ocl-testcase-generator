package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.type.Type;

public abstract class LoopExp extends FeatureCallExp {

	public LoopExp(List<ASTree> children, boolean isPre, Symbol sourcesym) {
		super(children, isPre,sourcesym);
	}



}
