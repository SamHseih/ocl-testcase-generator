package ccu.pllab.tcgen3.core.testcasegen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
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
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.FeatureCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IndexVariableExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IntegerLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.LetExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.OperationCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.PropertyCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.ResultExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.SelfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.StringLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.UnaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableDeclExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.SymbolTableBuilder;
import ccu.pllab.tcgen3.symboltable.FieldSymbol;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.ArrayTypeClassSymbol;
import ccu.pllab.tcgen3.symboltable.type.PrimitiveTypeSymbol;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class ASTtoCLP<T> implements AstVisitor<ClpCode> {
	
	private List<String> CLPtransferErrMessege = new ArrayList<>();
	private Scope currentScope;
	
	//collect int and array variables
	private Map<String, Integer> intVars = new LinkedHashMap<>();
	private Map<String, Integer> arrayVars = new LinkedHashMap<>();
	private Map<String, Integer> iterateVars = new LinkedHashMap<>();
	private boolean isloop = false;
	private boolean def = false; 

	private Deque<IndexVariableExp> iteratestack = new ArrayDeque<>();
	
	public ASTtoCLP(Scope symboltable) {
		this.currentScope = symboltable;
		
	}

	@Override
	public ClpCode visitPackageDeclASTContext(PackageDeclAST node) {
		CLPtransferErrMessege.add("CLPTranslator is not supposed to reach this point : " + node);
		return null;
	}

	@Override
	public ClpCode visitContextDeclAST(ContextDeclAST node) {
		CLPtransferErrMessege.add("CLPTranslator is not supposed to reach this point : " + node);
		return null;
	}

	@Override
	public ClpCode visitClassifierContext(ClassifierContextDeclAST node) {
		CLPtransferErrMessege.add("CLPTranslator is not supposed to reach this point : " + node);
		return null;
	}

	@Override
	public ClpCode visitOperationContext(OperationContextDeclAST node) {
		CLPtransferErrMessege.add("CLPTranslator is not supposed to reach this point : " + node);
		return null;
	}

	@Override
	public ClpCode visitContextExp(ContextExpAST node) {
		CLPtransferErrMessege.add("CLPTranslator is not supposed to reach this point : " + node);
		return null;
	}

	@Override
	public ClpCode visitInvalidASTContext(InvalidAST node) {
		CLPtransferErrMessege.add("CLPTranslator is not supposed to reach this point : " + node);
		return null;
	}

	@Override
	public ClpCode visitBinaryExpContext(BinaryExp node) {
		ClpCode left  = null;
		ClpCode right  = null;

	    //RHS
	    //Special Case 
		if(node.left() instanceof ResultExp) {
			left  = new ClpCode ("Result",""); // 處理 ResultExp 的情況
			right = node.right().accept(this);
			if(right == null ) {
				CLPtransferErrMessege.add("ResultExp without right expression: " + node);
			}	
		}
		//Normal Case
		if(right == null) right = node.right().accept(this);
		
		//OP
		String newop = switch(node.getOperator()) {
    	case "=" -> {
    		if(node.left() instanceof VariableDeclExp 
    				|| node.right().getType().getTypeName().equals("String")) {
    			def = true;
    			yield " = ";
    		}else if(node.left().getType() instanceof PrimitiveTypeSymbol) {
    			def = true;
    			yield " #= ";
    		} else {
    			def = true;
    			yield " = ";
    			}
    		
    	}
    	case "<>" -> " #\\= ";
    	case "<" -> " #< ";
    	case ">" -> {
    		if(node.left() instanceof IndexVariableExp) {
    			if(!iteratestack.isEmpty())iteratestack.pop();
    			isloop = false;
    			}
    		yield " #> ";
    	}
    	
    	case "<=" -> {
    		if(node.left() instanceof IndexVariableExp idx) {
    			iteratestack.push(idx);
    			isloop = true;
    			}
    		yield " #=< ";
    		}
    	case ">=" -> " #>= " ;
    	case "and" -> ",\n";
    	case "or" -> " ; ";
    	default -> node.getOperator();
	    }; 
		
	    //LHS
	    //Normal Case
	    if(left == null) left  = node.left().accept(this);
	    def = false;
	    
		String finalmethod = right.methodString() + left.methodString();
		String finalreturn = null;
		/*if(right.toString().equals("true")) {
			finalreturn = "(_"+left.returnString() + newop + right.returnString()+")";
	    } else finalreturn = "("+left.returnString() + newop + right.returnString()+")";
	    */
		finalreturn = "("+left.returnString() + newop + right.returnString()+")";
	    
		return new ClpCode(finalreturn,finalmethod);
	}

	@Override
	public ClpCode visitIfExpContext(IfExp node) {
		CLPtransferErrMessege.add("CLPTranslator is not supposed to reach this point : " + node);
		return null;
	}

	@Override
	public ClpCode visitVariableExpContext(VariableExp node) {
		Symbol symbol = currentScope.resolve(node.getName());
		boolean isPre = node.isMarkedPre();
		String varName = node.getName();
		
		if(symbol instanceof FieldSymbol && !(node instanceof SelfExp) ) {
			StringBuilder sb = new StringBuilder();
			sb.append("Self_");
			sb.append(varName);
			if (isPre) {
				sb.append("_pre");
			}
			if(def) {
				varName = defVar( tocapitalizeFirstLetter(sb.toString()),node.getType());
			}else {
				varName = readVar( tocapitalizeFirstLetter(sb.toString()),node.getType() );
			}
			// collect int and array variables
			return new ClpCode(tocapitalizeFirstLetter(sb.toString()),"");
		}
		
		if(node instanceof IndexVariableExp) {
			StringBuilder sb = new StringBuilder();
			sb.append(varName);
			if(def) {
				varName = defVar( tocapitalizeFirstLetter(sb.toString()),node.getType());
			}else {
				varName = readVar( tocapitalizeFirstLetter(sb.toString()),node.getType() );
			}
			return new ClpCode(tocapitalizeFirstLetter(varName),"");
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(varName);
		if (isPre) {
			sb.append("_pre");
		}
		//if(isloop) {	
			if(def) {
				varName = defVar( tocapitalizeFirstLetter(sb.toString()),node.getType());
			}else {
				varName = readVar( tocapitalizeFirstLetter(sb.toString()),node.getType() );
			}
		//}
		return new ClpCode(tocapitalizeFirstLetter(varName),"");
	}

	@Override
	public ClpCode visitPropertyCallExpContext(PropertyCallExp node) {
		//ClpCode source = node.getSource() != null ? node.getSource().accept(this) : null;
		Deque<String> sourcenames = new ArrayDeque<>();
		ASTree current = node.getSource();
		while(current != null) {
			if(current instanceof FeatureCallExp f) {
				sourcenames.push(f.getFeatureName());
				current = f.getSource();
			} else if(current instanceof VariableExp v) {
				sourcenames.push(v.getName());
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!sourcenames.isEmpty()) {
			sb.append(sourcenames.poll());
			sb.append("_");
		}
		
		sb.append(node.getFeatureName());
		String proName ;
		if(def) {
			proName = defVar( tocapitalizeFirstLetter(sb.toString()),node.getType());
		}else {
			proName = readVar( tocapitalizeFirstLetter(sb.toString()),node.getType() );
		}
		
		return new ClpCode(proName,"");
	}

	@Override
	public ClpCode visitOperationCallExpContext(OperationCallExp node) {
		Deque<String> sourcenames = new ArrayDeque<>();
		ASTree current = node.getSource();
		while(current != null) {
			if(current instanceof FeatureCallExp f) {
				sourcenames.push(f.getFeatureName());
				current = f.getSource();
			} else if(current instanceof VariableExp v) {
				sourcenames.push(v.getName());
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!sourcenames.isEmpty()) {
			sb.append(sourcenames.poll());
			if(sourcenames.isEmpty()) {
			break;
			}
			sb.append("_");
			
		}
		String sourcename = sb.toString(); 
		
		ClpCode predifinedOp = switch(node.getFeatureName()) {
			case "getDimension", "getDimensionSizes", "getElements", "Size" -> predefinedfunc(node,sourcename);
		    default -> null;
		};
		if(predifinedOp != null) {
			return predifinedOp;
			}
		//others
		CLPtransferErrMessege.add("OperationCall not support: " + node);
		return null;
	}

	private ClpCode predefinedfunc(OperationCallExp node,String source) {
		String funcName = node.getFeatureName(); // e.g. getDimension
		String sourceStr = readVar( tocapitalizeFirstLetter(source),node.getSource().getType() );
		
		String ssaVar ;
		if(def) {
			ssaVar = defVar( toEclipseVar(node),node.getType());
		}else {
			ssaVar = readVar( toEclipseVar(node),node.getType() );
		}
		
		List<ASTree> args = node.getArgs();
		String method = switch(funcName) {
	        case "getDimension" -> "getDimension(" + sourceStr + ", " + ssaVar + "),\n";
	        case "getDimensionSizes" -> {
	            if (args.isEmpty()) {
	            	yield "getDimensionSizes(" + sourceStr + ", " + ssaVar + "),\n";
	            } else if (args.size() == 1) {
	            	if(args.get(0)  instanceof IntegerLiteralExp i) {
	            		int index = i.getValue(); //CLP index from 1
	            		yield "getDimensionSizes(" + sourceStr + ", " + index + ", " + ssaVar + "),\n";
	            	} else {
	            		String indexStr = args.get(0).toClgString(); // 動態索引
	                    String idxExpr  = "(" + indexStr + ")";   // 明確表達 +1
	                    yield "getDimensionSizes(" + sourceStr + ", " + idxExpr + ", " + ssaVar + "),\n";
	            	}
	            } else {
	            	yield "% Error: getDimensionSizes with more than 1 argument not supported.";
	            }
	        }

	        case "getElements" -> "getElements(" + sourceStr + ", " + ssaVar + "),\n";
	        

	        case "Size" -> "Size(" + sourceStr + ", " + ssaVar + "),\n"; // 假設 Size
	        

	        default -> {
	        	CLPtransferErrMessege.add("Unknown predefined function: " + funcName);
	        	yield "% Error: Unknown predefined function: " + funcName;
	        }
		};
		
		return new ClpCode(ssaVar,method);
	
	}

	@Override
	public ClpCode visitIntegerLiteralExpContext(IntegerLiteralExp node) {
		return new ClpCode(String.valueOf(node.getValue()),"");
	}

	@Override
	public ClpCode visitStringLiteralExpContext(StringLiteralExp node) {
		StringBuilder sb = new StringBuilder();
		sb.append("\'");
		sb.append(tocapitalizeFirstLetter(node.getValue()));
		sb.append("\'");
		return new ClpCode( sb.toString(),"");
	}

	@Override
	public ClpCode visitArrayRefExpContext(ArrayRefExp node) {
		Deque<String> sourcenames = new ArrayDeque<>();
		ASTree current = node.getSource();
		while(current != null) {
			if(current instanceof FeatureCallExp f) {
				sourcenames.push(f.getFeatureName());
				current = f.getSource();
			} else if(current instanceof VariableExp v) {
				sourcenames.push(v.getName());
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!sourcenames.isEmpty()) {
			sb.append(sourcenames.poll());
			if(sourcenames.isEmpty()) {
			break;
			}
			sb.append("_");
			
		}
		sb.append("_").append(node.getFeatureName());
		String sourcename = readVar( tocapitalizeFirstLetter(sb.toString()),node.getSource().getType());
		String returnstr = defVar(toEclipseVar(node),SymbolTableBuilder.IntType) ;
		
		StringBuilder func = new StringBuilder();
		func.append("(");
		String funcstr = defVar(returnstr, node.getType()) + " is " + sourcename+"[";
		
		func.append(funcstr);
		for(int i = 1 ; i < node.numChildren() ; i++) {
				//arr[it,it2,it3]  it must be int
				func.append( readVar( tocapitalizeFirstLetter( node.child(i).toString()) ,SymbolTableBuilder.IntType) );
			if(i ==  node.numChildren()-1 ) {func.append("]");}
			else func.append(",");			
		}
		func.append("),");
		
		/*
		func.append("getElem(");
		func.append(sourcename).append(",");
		func.append("[");
		for(int i = 1 ; i < node.numChildren() ; i++) {
				//arr[it,it2,it3]  it must be int
				func.append( readVar( tocapitalizeFirstLetter( node.child(i).toString()) ,SymbolTableBuilder.IntType) );
			if(i ==  node.numChildren()-1 ) {func.append("]");}
			else func.append(",");			
		}
		func.append(",").append(returnstr).append("),");*/
		
		

		return new ClpCode(readVar(returnstr, node.getType()),func.toString());
	}

	/** In ECLiPSe 'true' instance of Atom = true */
	@Override
	public ClpCode visitBooleanLiteralExpContext(BooleanLiteralExp node) {
		return new ClpCode(node.getValue().toString(),"");
	}

	@Override
	public ClpCode visitCollectionItemContext(CollectionItem node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClpCode visitCollectionLiteralExpContext(CollectionLiteralExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override  
	public ClpCode visitCollectionRangeContext(CollectionRange node) {
		String Min = tocapitalizeFirstLetter(node.getLowerValue().toString());
		String Max = tocapitalizeFirstLetter(node.getUpperValue().toString());
		String listVar = this.readVar(toEclipseList(node),node.getType());
		String Var = this.defVar(toEclipseVar(node),node.getType());
		String Index = this.readVar( tocapitalizeFirstLetter(iteratestack.peek().toString()),   node.getType() );
		
		//Transform to numlist/3  ECLiPSe Builde-in func + Delay Expr.
		String Sequence = "sueuencetolist("+ Min +","+ Max +","+ listVar+"),";
		String getnth= "nth1("+ Index +","+ listVar +","+ Var +"),";
		return new ClpCode(Var,Sequence+getnth);
	}

	@Override
	public ClpCode visitIterateExpContext(IterateExp node) {
		return new ClpCode("true","");
	}

	@Override
	public ClpCode visitLetExpContext(LetExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClpCode visitUnaryExpContext(UnaryExp node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClpCode visitVariableDeclExpContext(VariableDeclExp node) {
		String vardecl = tocapitalizeFirstLetter(node.getVarname());
		
		if(def && isloop) {
			vardecl = this.defVar(vardecl, node.getType());
		}
		return new ClpCode(vardecl,"");
	}
	
	@Override
	public ClpCode visitExceptionASTContext(ExceptionAST node) {
		return new ClpCode(node.toString(),"");
	}
	
	@Override
	public List<String> getErrorMesg(){
		return this.CLPtransferErrMessege;
	}

	public Map<String, Integer> getIntVars() {
		return intVars;
	}
	
	public Map<String, Integer> getArrayVars() {
		return arrayVars;
	}
	
	public void popiterate() {iteratestack.pop();}
	
	@Override
	public void reset_iterate() {
		// TODO Auto-generated method stub
	}

	private String tocapitalizeFirstLetter(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}
	
	private String toEclipseVar(ASTree node) { 
		// 範例：hashcode 當變數名
	        return "Var_" + node.hashCode(); // fallback: 用 hashcode 避免重名
	}
	private String toEclipseList(ASTree node) { 
		// 範例：hashcode 當變數名
	        return "List_" + node.hashCode(); // fallback: 用 hashcode 避免重名
	}

	/* Private Helper*/

	public String defVar(String name,Type type) {            // 賦值點：版本 +1
		if(type instanceof PrimitiveTypeSymbol) {
			int idx = intVars.compute(name, (k, v) -> (v == null) ? 0 : v + 1);
			return (idx == 0) ? name : name + "_" + idx;
		} else if(type instanceof ArrayTypeClassSymbol){
			int idx = arrayVars.compute(name, (k, v) -> (v == null) ? 0 : v + 1);
			return (idx == 0) ? name : name + "_" + idx;
		} else {
			int idx = iterateVars.compute(name, (k, v) -> (v == null) ? 0 : v + 1);
			return (idx == 0) ? name : name + "_" + idx;
		}
	    
	}
	
	public String readVar(String name,Type type) {            
		if(type instanceof PrimitiveTypeSymbol) {
			int idx = intVars.getOrDefault(name, 0);
			return (idx == 0) ? name : name + "_" + idx;
		} else if(type instanceof ArrayTypeClassSymbol){
			int idx = arrayVars.getOrDefault(name, 0);
			return (idx == 0) ? name : name + "_" + idx;
		} else {
			int idx = iterateVars.getOrDefault(name, 0);
			return (idx == 0) ? name : name + "_" + idx;
		}
	    
	}
	
}
