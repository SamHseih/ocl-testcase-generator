package ccu.pllab.tcgen3.core.testmodelbuilder.clg.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTLeaf;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ClassifierContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextExpAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ExceptionAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.InvalidAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.OperationContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.PackageDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.AccumulatorExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.ArrayRefExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BooleanLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionItem;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionPart;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionRange;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.FeatureCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IndexVariableExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IntegerLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.LetExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.OperationCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.PropertyCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.StringLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.UnaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableDeclExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.SymbolTableBuilder;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.scope.LocalScope;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.MultiplicityListType;
import ccu.pllab.tcgen3.symboltable.type.Type;
import ccu.pllab.tcgen3.util.AstUtil;
import ccu.pllab.tcgen3.visualization.ClgVisualization;

public class DcCLGBuilder<T> implements AstVisitor<CLGGraph> {
	private List<String> CLGtransferMessege = new ArrayList<>();
	private ContextDeclAST ClassiferContextDecl; //to repeat construct InvCLG for graphAnd
	private Scope globolsymboltable;
	private LocalScope localScope;
	private int nth_ITERATE = 0; //for IterateExp, to generate unique index variable name
	
	public DcCLGBuilder(Scope globolsymboltable) {
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
		// If the context is an OperationContextDeclAST, we need to generate the pre and post condition CLG
		if(node.getContextDecl() instanceof OperationContextDeclAST) {
			for(int i = 1 ; i < node.numChildren();i++) {
				if(node.child(i) instanceof ContextExpAST ctx) {
					//pre condition
					if(ctx.getKeyWord().equals("pre")) {
						//notpreclgs.add(processNegatePreCLG(ctx));
						notpreclgs.add(AstUtil.DeMorgan(ctx.getConstraint()).accept(this));
						preclgs.add(visitContextExp(ctx));
					//post condition
					} else {
						postclgs.add(visitContextExp(ctx));
					}
				}
			}
		// If the context is a ClassifierContextDeclAST, we need to generate the invariant CLG
		}else if(node.getContextDecl() instanceof ClassifierContextDeclAST) {
			//inv:.. ?? inv:...  ?? inv:.. ?? ...
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
			CLGGraph invclg = null;
			if(ClassiferContextDecl != null) {
				invclg = genInvCLG(ClassiferContextDecl);
				invclg.graphAnd(pfirst);
				}
			if(invclg != null) { 
				invclg.graphOr(npfirst);
				return invclg;
			} else {
				pfirst.graphOr(npfirst);
				return pfirst;
			}
		}else {
			/* Only Has Post Conditions Context*/
			CLGGraph invclg = null;
			if(ClassiferContextDecl != null) {
				invclg = genInvCLG(ClassiferContextDecl);
				invclg.graphAnd(pofirst);
			}
			if(invclg != null) return invclg;
			else return pofirst;
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
		if(node.left() instanceof IfExp||node.left() instanceof IterateExp ) {
			leftclg = node.left().accept(this);
		}
		if(node.right() instanceof IfExp                    
				|| node.right() instanceof IterateExp 
				|| node.left() instanceof AccumulatorExp//Special Case : acc = <OclExpr>
				) {
			rightclg = node.right().accept(this);
		}
			
		if(node.getGroup().equals(BinaryExp.OpGroup.LOGICAL)) {
			if(node.getOperator().equals("and")|| node.getOperator().equals("or")) {
				// ASTLeft op AStLeft
				if(leftclg == null && rightclg == null) {
					return new CLGGraph(node);
				// ASTLeft op AStList
				} else if(leftclg == null && rightclg != null) {
					leftclg = new CLGGraph(node);
					if(node.getOperator().equals("and")) {
						leftclg.graphAnd(rightclg);
					} else {
						leftclg.graphOr(rightclg);
					}
					leftclg.validate();
			        //System.out.println(ClgVisualization.toGraphvizDot(leftclg));
					return leftclg;
				// ASTList op ASTLeft
				} else if(leftclg != null && rightclg == null) {
					rightclg = new CLGGraph(node);
					if(node.getOperator().equals("and")) {
						rightclg.graphAnd(leftclg);
					} else {
						rightclg.graphOr(leftclg);
					}
					rightclg.validate();
					return rightclg;
				// ASTList op ASTList
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
			//Special Case: AccumulatorExp  ....
		} else if(node.left() instanceof AccumulatorExp) {
			//loop acc = Expr .
			return rightclg;

		}else {
			return new CLGGraph(node);
		}
	}

	@Override
	public CLGGraph visitIfExpContext(IfExp node) {
		CLGGraph condclg = node.getCondition().accept(this);
		CLGGraph thenclg = node.getThenBranch().accept(this);
		CLGGraph negatecondclg = AstUtil.DeMorgan(node.getCondition()).accept(this);
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
		
		/* Init  */
		
		IndexVariableExp Index = new IndexVariableExp("idx"+nth_ITERATE++,(Symbol) SymbolTableBuilder.IntType);
		//OCL && ECLiPSe index init from 1
		BinaryExp initIndex = new BinaryExp(List.of(Index,new IntegerLiteralExp(1,SymbolTableBuilder.IntType)),"=");

		CLGGraph indexclg = new CLGGraph(initIndex);
		//Accumulator = <initExpr>?
		CLGGraph resultinitclg = node.getResultDecl().accept(this);
		resultinitclg.graphAnd(indexclg);
		//System.out.println("Init: \n"+ClgVisualization.toGraphvizDot(resultinitclg));
		/* Init End */
		
		CLGGraph truecondclg = null;
		CLGGraph falsecondclg = null;
		if(node.getSource() instanceof CollectionPart c ) {
			//collection size n from CollectionPart Method size()  ,  CollectionRange/CollectionItem extends CollectionPart
			VariableExp sizeVar = new VariableExp(c.size(),false,null);
			BinaryExp truecondexp = new BinaryExp(List.of(Index,sizeVar),">");
			BinaryExp falsecondexp = new BinaryExp(List.of(Index,sizeVar),"<=");
			truecondclg = truecondexp.accept(this);
			falsecondclg = falsecondexp.accept(this);
		}
		if(node.getSource() instanceof VariableExp v) {
			if(v.getType() instanceof MultiplicityListType) {
			//collection size n 
			VariableExp sizeVar = new VariableExp(v.getName(),false,null);
			BinaryExp truecondexp = new BinaryExp(List.of(Index,sizeVar),">");
			BinaryExp falsecondexp = new BinaryExp(List.of(Index,sizeVar),"<=");
			truecondclg = truecondexp.accept(this);
			falsecondclg = falsecondexp.accept(this);
			} else {
				CLGtransferMessege.add("IterateExp Error! The source is not a ArrayType.");
				return null;
			}
		}
		if(node.getSource() instanceof FeatureCallExp f) {
			//collection size n 
			if(f.getType() instanceof MultiplicityListType) {
				//collection size n 
				VariableExp sizeVar = new VariableExp(f.getFeatureName(),false,null);
				BinaryExp truecondexp = new BinaryExp(List.of(Index,sizeVar),">");
				BinaryExp falsecondexp = new BinaryExp(List.of(Index,sizeVar),"<=");
				truecondclg = truecondexp.accept(this);
				falsecondclg = falsecondexp.accept(this);
				} else {
					CLGtransferMessege.add("IterateExp Error! The source is not a ArrayType.");
					return null;
				}
		}
		
		if(truecondclg != null && falsecondclg != null) {
			/*In Loop */		
			// Ex. Loop Variable: it
			BinaryExp element = new BinaryExp(List.of( node.getIteratorDecl(),node.getSource()),"=");
			CLGGraph elementclg = element.accept(this);
			//System.out.println("elementclg: \n"+ClgVisualization.toGraphvizDot(elementclg));
			
			String accVar =null;
			Type accType = null;
			if(node.getResultDecl() instanceof VariableDeclExp v) {
				accVar = v.getVarname();
				accType = v.getType();
			} else if(node.getResultDecl() instanceof BinaryExp b) {
				if(b.child(0) instanceof VariableDeclExp v) {
					accVar = v.getVarname();
					accType = v.getType();
				}
			}
			AccumulatorExp acc  = new AccumulatorExp(accVar+"_loopBody",accType);
			BinaryExp loopaccast = new BinaryExp(List.of( acc,node.getBody()),"=");
			CLGGraph bodyclg = loopaccast.accept(this);
			//System.out.println("bodyclg: \n"+ClgVisualization.toGraphvizDot(bodyclg));
			
			BinaryExp nextIndex = new BinaryExp(List.of(Index,new IntegerLiteralExp(1,SymbolTableBuilder.IntType)),"+");
			BinaryExp next = new BinaryExp(List.of(Index,nextIndex),"=");
			CLGGraph nextIndexclg = next.accept(this);
			
			falsecondclg.graphAnd(elementclg);
			falsecondclg.graphAnd(bodyclg);
			falsecondclg.graphAnd(nextIndexclg);
			falsecondclg.graphClosure(); 
			//System.out.println("bodyclg: \n"+ClgVisualization.toGraphvizDot(falsecondclg));
			
			/*Loop End*/	
			
			/*Result  尚未決定是否要用*/
			//VariableDeclExp resultVar  = new VariableDeclExp(accVar+"_loopEnd",accType);
			//BinaryExp resultast = new BinaryExp(List.of( resultVar,acc),"=");
			//CLGGraph resultclg = resultast.accept(this);
			//System.out.println("resultclg: \n"+ClgVisualization.toGraphvizDot(resultclg));
			//truecondclg.graphAnd(resultclg);
			//System.out.println("Result: \n"+ClgVisualization.toGraphvizDot(truecondclg));

			/*Result  End*/
			
			falsecondclg.graphAnd(truecondclg);
			//System.out.println("And: \n"+ClgVisualization.toGraphvizDot(falsecondclg));

			resultinitclg.graphAnd(falsecondclg);
			//System.out.println("Final: \n"+ClgVisualization.toGraphvizDot(resultinitclg));

			return resultinitclg;
		} else {
			CLGtransferMessege.add("IterateExp Error! There isn't appropriate AST to CLG.");
			return null;
		}
		
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
				//CLGGraph init = node.child(0).accept(this);
				//vardecl.graphAnd(init);
				return vardecl;
			}
		}
		
	}
	
	public List<String> getErrorMesg(){
		return this.CLGtransferMessege;
	}

    /* =====================================================
     *  H E L P E R  genInvCLG / processNegatePreCLG 
     * ===================================================== */
	private CLGGraph genInvCLG(ContextDeclAST node) {
		return node.accept(this);
	}

	@Override
	public CLGGraph visitExceptionASTContext(ExceptionAST node) {
		// TODO Auto-generated method stub
		return null;
	} 

	public void reset_iterate() {
		this.nth_ITERATE = 0;
	}
}
