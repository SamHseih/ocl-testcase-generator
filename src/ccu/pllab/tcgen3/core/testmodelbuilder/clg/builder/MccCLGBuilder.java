package ccu.pllab.tcgen3.core.testmodelbuilder.clg.builder;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ClassifierContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextExpAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.InvalidAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.OperationContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.PackageDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.ArrayRefExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BooleanLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionItem;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionRange;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IntegerLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.LetExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.OperationCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.PropertyCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.StringLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.UnaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableDeclExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableExp;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class MccCLGBuilder<T> implements AstVisitor<CLGGraph> {

	private Scope globolsymboltable;
	private List<CLGGraph> clgs;
	
	public MccCLGBuilder(Scope globolsymboltable2) {
		this.globolsymboltable= globolsymboltable;
	}

	@Override
	public CLGGraph visitPackageDeclASTContext(PackageDeclAST node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitContextDeclAST(ContextDeclAST node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitClassifierContext(ClassifierContextDeclAST node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitOperationContext(OperationContextDeclAST node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitContextExp(ContextExpAST node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitInvalidASTContext(InvalidAST node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitBinaryExpContext(BinaryExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitIfExpContext(IfExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitVariableExpContext(VariableExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitPropertyCallExpContext(PropertyCallExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitOperationCallExpContext(OperationCallExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitIntegerLiteralExpContext(IntegerLiteralExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitStringLiteralExpContext(StringLiteralExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitArrayRefExpContext(ArrayRefExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitBooleanLiteralExpContext(BooleanLiteralExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitCollectionItemContext(CollectionItem node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitCollectionLiteralExpContext(CollectionLiteralExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitCollectionRangeContext(CollectionRange node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitIterateExpContext(IterateExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitLetExpContext(LetExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitUnaryExpContext(UnaryExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitVariableDeclExpContext(VariableDeclExp node) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<CLGGraph> getClgs(){
		return clgs;
	}
}
