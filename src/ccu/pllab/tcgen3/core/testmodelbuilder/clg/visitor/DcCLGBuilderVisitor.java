package ccu.pllab.tcgen3.core.testmodelbuilder.clg.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTLeaf;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.CLGAstVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ClassifierContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextExpAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ExceptionAST;
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
import ccu.pllab.tcgen3.symboltable.scope.LocalScope;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.util.ASTutil;

public class DcCLGBuilderVisitor<T> implements CLGAstVisitor<CLGGraph> {
	private List<String> CLGtransferMessege = new ArrayList<>();
	private ContextDeclAST ClassiferContextDecl; //to repeat construct InvCLG for graphAnd
	private Scope globolsymboltable;
	private LocalScope localScope;
	
	public DcCLGBuilderVisitor(Scope globolsymboltable) {
		this.globolsymboltable= globolsymboltable;
	}

	@Override
	public CLGGraph visitPackageDeclASTContext(PackageDeclAST node) {
		String mes="visitPackageDeclASTContext nothing to do";
		CLGtransferMessege.add(mes);
		return null;
	}

	@Override
	public CLGGraph visitContextDeclAST(ContextDeclAST node) {
		List<CLGGraph> notpreclgs = new ArrayList<>();
		List<CLGGraph> preclgs= new ArrayList<>();
		List<CLGGraph> postclgs= new ArrayList<>();
		CLGGraph excepclg = new CLGGraph( new ExceptionAST());
		if(node.getContextDecl() instanceof OperationContextDeclAST) {
			for(int i = 1 ; i < node.numChildren();i++) {
				if(node.child(i) instanceof ContextExpAST ctx) {
					//pre condition
					if(ctx.getKeyWord().equals("pre")) {
						notpreclgs.add(processNegatePreCLG(ctx));
						preclgs.add(visitContextExp(ctx));
					//post condition
					} else {
						postclgs.add(visitContextExp(ctx));
					}
				}
			}
		}else if(node.getContextDecl() instanceof ClassifierContextDeclAST) {
			//inv:.. ⋀ inv:...  ⋀ inv:.. ⋀ ...
			ClassiferContextDecl = node;
			List<CLGGraph> g = new ArrayList<>();
			for(int i = 1 ; i < node.numChildren();i++) {
				g.add( visitContextExp((ContextExpAST) node.child(i)) );
			}
			CLGGraph invfirst = null;
			if (!g.isEmpty()) {
			    Iterator<CLGGraph> inv = g.iterator();
			    	invfirst = inv.next();
			    while(inv.hasNext()) {
			    	invfirst.graphAnd(inv.next());
			    }
			    invfirst.validate();
			    return invfirst;
			}else {CLGtransferMessege.add("Inv Context Err.");}
		}
		CLGGraph npfirst = null;
		CLGGraph pfirst = null;
		CLGGraph pofirst = postclgs.get(0);
		//Not pre condition CLG
		if(!notpreclgs.isEmpty()) {
			Iterator<CLGGraph> np = notpreclgs.iterator();
			npfirst = np.next();
			while(np.hasNext()) {
				npfirst.graphAnd(np.next());
			} 
			npfirst.graphAnd(excepclg);
		}
		//pre condition CLG
		if(!preclgs.isEmpty()) {
			Iterator<CLGGraph> p = preclgs.iterator();
			pfirst = p.next();
			while(p.hasNext()) {
				pfirst.graphAnd(p.next());
			} 
		}
		//post condition CLG
		if(!preclgs.isEmpty()) {
			Iterator<CLGGraph> po = postclgs.iterator();
			pofirst = po.next();
			while(po.hasNext()) {
				pofirst.graphAnd(po.next());
			}
			pofirst.validate();
		}
		if(pfirst != null) {
			/* Has Pre & Post Condition Context*/
			//System.out.println(ClgVisualization.toGraphvizDot(pofirst));
			pfirst.graphAnd(pofirst);
			//System.out.println(ClgVisualization.toGraphvizDot(pfirst));

			if(ClassiferContextDecl != null) {
				CLGGraph invclg = genInvCLG(ClassiferContextDecl);
				pfirst.graphAnd(invclg);
				pfirst.validate();
				}
			pfirst.graphOr(npfirst);
			pfirst.validate();
			return pfirst;
		}else {
			/* Only Has Post Conditions Context*/
			if(ClassiferContextDecl != null) {
			CLGGraph invclg = genInvCLG(ClassiferContextDecl);
			pofirst.graphAnd(invclg);
			}
			pofirst.validate();
			return pofirst;
		}
	}

	@Override
	public CLGGraph visitClassifierContext(ClassifierContextDeclAST node) {
		String mes="ClassifierContextDeclAST nothing to do";
		CLGtransferMessege.add(mes);
		return null;
	}

	@Override
	public CLGGraph visitOperationContext(OperationContextDeclAST node) {
		String mes="visitPackageDeclASTContext nothing to do";
		CLGtransferMessege.add(mes);
		return null;
	}

	@Override
	public CLGGraph visitContextExp(ContextExpAST node) {
		return node.getConstraint().accept(this);
	}

	@Override
	public CLGGraph visitInvalidASTContext(InvalidAST node) {
		CLGtransferMessege.add("Error !! There has a InvalidAST in AST.");
		return null;
	}

	@Override
	public CLGGraph visitBinaryExpContext(BinaryExp node) {
		CLGGraph leftclg = null;
		CLGGraph rightclg = null;
		if(node.left() instanceof IfExp||node.left() instanceof IterateExp) {
			leftclg = node.left().accept(this);
		}
		if(node.right() instanceof IfExp ||node.right() instanceof IterateExp) {
			rightclg = node.right().accept(this);
		}
			
		if(node.getGroup().equals(BinaryExp.OpGroup.LOGICAL)) {
			if(node.getOperator().equals("and")|| node.getOperator().equals("or")) {
				if(leftclg == null && rightclg == null) {
					return new CLGGraph(node);
				} else if(leftclg == null && rightclg != null) {
					leftclg = new CLGGraph(node);
					if(node.getOperator().equals("and")) {
						leftclg.graphAnd(rightclg);
					} else {
						leftclg.graphOr(rightclg);
					}
					leftclg.validate();
					return leftclg;
				} else if(leftclg != null && rightclg == null) {
					rightclg = new CLGGraph(node);
					if(node.getOperator().equals("and")) {
						rightclg.graphAnd(leftclg);
					} else {
						rightclg.graphOr(leftclg);
					}
					rightclg.validate();
					return rightclg;
				} else if(leftclg != null && rightclg != null) {
					if(node.getOperator().equals("and")) {
						leftclg.graphAnd(rightclg);
					} else {
						leftclg.graphOr(rightclg);
					}
					leftclg.validate();
					return leftclg;
				} else {
					CLGtransferMessege.add("BinaryExp Error! There isn't appropriate AST to CLG.");
					return null;
				}
		        
			} else if(node.getOperator().equals("implies")){
				//not A or B ..
				CLGtransferMessege.add("Not yet support implies operator.");
				return null;
			} else if(node.getOperator().equals("xor")){
				//A xor B
				CLGtransferMessege.add("Not yet support xor operator.");
				return null;
			} else {
				CLGtransferMessege.add("BinaryExp Error! There isn't appropriate AST to CLG.");
				return null;
			}
		} else {
			return new CLGGraph(node);
		}
	}

	@Override
	public CLGGraph visitIfExpContext(IfExp node) {
		CLGGraph condclg = node.getCondition().accept(this);
		CLGGraph thenclg = node.getThenBranch().accept(this);
		CLGGraph negatecondclg = ASTutil.DeMorgan(node.getCondition()).accept(this);
		CLGGraph elseclg = node.getElseBranch().accept(this);
			
        condclg.graphAnd(thenclg);
        negatecondclg.graphAnd(elseclg);
        
        condclg.graphOr(negatecondclg);
        condclg.validate();
        return condclg;
	}

	@Override
	public CLGGraph visitVariableExpContext(VariableExp node) {
		return new CLGGraph(node);
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
		return new CLGGraph(node);
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
		return new CLGGraph(node);
	}

	@Override
	public CLGGraph visitIterateExpContext(IterateExp node) { 
		//collection size n 
		CLGGraph sourceclg = node.getSource().accept(this);
		//System.out.println("iteratorclg: \n"+ClgVisualization.toGraphvizDot(sourceclg));

		// Ex. Loop Variable: it
		CLGGraph iteratorclg = node.getIteratorDecl().accept(this);
		//System.out.println("iteratorclg: \n"+ClgVisualization.toGraphvizDot(iteratorclg));

		//Accumulator = <Expr>
		CLGGraph resultclg = node.getResultDecl().accept(this);
		//System.out.println("resultclg: \n"+ClgVisualization.toGraphvizDot(resultclg));

		sourceclg.graphAnd(iteratorclg);
		//System.out.println("sourceclg: \n"+ClgVisualization.toGraphvizDot(sourceclg));

		sourceclg.graphAnd(resultclg);
		//System.out.println("sourceclg: \n"+ClgVisualization.toGraphvizDot(sourceclg));

		CLGGraph bodyclg = node.getBody().accept(this);
		//System.out.println("bodyclg: \n"+ClgVisualization.toGraphvizDot(bodyclg));
		bodyclg.graphClosure(node);
		//System.out.println("bodyclg: \n"+ClgVisualization.toGraphvizDot(bodyclg));
		sourceclg.graphAnd(bodyclg);
		//System.out.println("Iterate CLG: \n"+ClgVisualization.toGraphvizDot(sourceclg));

		return sourceclg;
	}

	@Override
	public CLGGraph visitLetExpContext(LetExp node) {
		List<ASTree> decls = node.getVariabledecls();
		List<CLGGraph> declclgs = new ArrayList<>() ;
		CLGGraph declclgfirst = null;
		for(ASTree decl: decls) {
			declclgs.add(decl.accept(this));
		}
		if (!declclgs.isEmpty()) {
		    Iterator<CLGGraph> declclg = declclgs.iterator();
		     declclgfirst = declclg.next();
		    while(declclg.hasNext()) {
		    	declclgfirst.graphAnd(declclg.next());
		    }
		    declclgfirst.validate();
		}else {CLGtransferMessege.add("Inv Context Err.");}
		
		CLGGraph bodyclg = node.getOclExpression().accept(this);
		
		declclgfirst.graphAnd(bodyclg);
		return declclgfirst;
		
	}

	@Override
	public CLGGraph visitUnaryExpContext(UnaryExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLGGraph visitVariableDeclExpContext(VariableDeclExp node) {
		if(node.numChildren() == 0 ) {
			return new CLGGraph(node);
		}else {
			// acc:Boolean = true||0 ..  or acc:Integer = arr[0] or acc:Integer = acc.size()
			if(node.child(0) instanceof ASTLeaf 
					|| node.child(0) instanceof OperationCallExp 
					|| node.child(0) instanceof ArrayRefExp
					|| node.child(0) instanceof PropertyCallExp) {
				return new CLGGraph(node);
			} else {
				CLGGraph vardecl = new CLGGraph(node);
				CLGGraph init = node.child(0).accept(this);
				vardecl.graphAnd(init);
				return vardecl;
			}
		}
		
	}
	
	public List<String> getErrorMesg(){
		return this.CLGtransferMessege;
	}

    /* =====================================================
     *  H E L P E R – genInvCLG / processNegatePreCLG 
     * ===================================================== */
	private CLGGraph genInvCLG(ContextDeclAST node) {
		return node.accept(this);
	} 
	//不符合前置條件的CLG
	private CLGGraph processNegatePreCLG(ContextExpAST ctx) {
		if(ctx.getConstraint() instanceof BinaryExp b) {
			BinaryExp astclone = (BinaryExp) ASTutil.DeMorgan(b);
			return visitBinaryExpContext(astclone);
		} else if(ctx.getConstraint() instanceof IterateExp i) {
			IterateExp astclone = (IterateExp) ASTutil.DeMorgan(i);
			return visitIterateExpContext(astclone);
		} else if(ctx.getConstraint() instanceof IfExp i) {
			IterateExp astclone = (IterateExp) ASTutil.DeMorgan(i);
			return visitIterateExpContext(astclone);
		} else if(ctx.getConstraint() instanceof LetExp i) {
			IterateExp astclone = (IterateExp) ASTutil.DeMorgan(i);
			return visitIterateExpContext(astclone);
		} else if(ctx.getConstraint() instanceof UnaryExp i) {
			IterateExp astclone = (IterateExp) ASTutil.DeMorgan(i);
			return visitIterateExpContext(astclone);
		} 
		CLGtransferMessege.add("processNegatePreCLG Err.");
		return null;
		}
}
