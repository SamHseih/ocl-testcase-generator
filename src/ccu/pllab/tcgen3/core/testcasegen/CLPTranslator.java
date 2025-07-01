package ccu.pllab.tcgen3.core.testcasegen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNodeType;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.FieldSymbol;
import ccu.pllab.tcgen3.symboltable.MethodSymbol;
import ccu.pllab.tcgen3.symboltable.ParameterSymbol;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.ArrayTypeClassSymbol;
import ccu.pllab.tcgen3.symboltable.type.MultiplicityListType;
import ccu.pllab.tcgen3.util.ClgUtil;
import ccu.pllab.tcgen3.util.StringTool;

public class CLPTranslator {
	private  List<CLGNode> constraintnodes;//Collect ConstraintNode && IterateNode
	private Scope currentScope; //Current CLG Scpope
	private StringBuilder arrayTypeDecl = new StringBuilder();
	private List<String> arrayType = new ArrayList<>();
	private List<String> intType =  new ArrayList<>();
	
	private List<String> errMessage =  new ArrayList<>();
	private String requestterm;
	private int pathnum ;
	private boolean isVarArray =false;
	
	public CLPTranslator(List<CLGEdge> clgEdge, Scope currentScope,int num) {
		constraintnodes = ClgUtil.collectExprNodes(clgEdge);
		this.currentScope = currentScope;
		this.pathnum = num;
	}
	
	public String translate() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.genlibCLP()).append("\n").append("\n");
		String decl = this.gendeclCLP();
		String body = this.genBodyCLP();
		String labeling = this.genlabelingCLP();
		String head = this.genHead(); //need final exe for DimensionSizes
		sb.append(head).append("\n");
		sb.append(decl).append("\n");
		sb.append(body).append("\n");
		sb.append(labeling).append("\n");
		
		return sb.toString(); 
	}

	public String getRequestTerm() {
		 return requestterm;
	}
									
	public boolean isVarArray() {
		return isVarArray;
	}
	
	private String genHead() {
		StringBuilder sb = new StringBuilder();
		sb.append("solving_Path_").append(pathnum).append("(Self");
		List<ParameterSymbol>  args =null;
		if(currentScope instanceof MethodSymbol m) {
			args = m.getParameters();
			if(!args.isEmpty())sb.append(",");
			Iterator<ParameterSymbol> it = args.iterator();
			while (it.hasNext()) {
			    sb.append(tocapitalizeFirstLetter(it.next().getName()));      // 加入目前元素
			    if (it.hasNext()) {
			        sb.append(",");        // 還有下一個 → 加逗號
			    } 
			}
			if(isVarArray)sb.append(",DimensionSizes"); 
				
				
			if(m.getType() != null) {
				sb.append(",Result)");
			} else sb.append(")");
			
			
		}
		requestterm = sb.toString();
		sb.append(":-\n");
		
		return sb.toString();
	}

	private String genlibCLP() {
		StringBuilder libStringBuilder = new StringBuilder();
		libStringBuilder.append(":- lib(ic).\n"
				+ ":- lib(listut).\n"
				+ ":- lib(random).\n"
				+ ":- lib(random).\n");
		return libStringBuilder.toString();
	}
	
	private String gendeclCLP() {
		StringBuilder declBuilder = new StringBuilder();
		declBuilder.append("% Class and attribute combined as Class_Attr.\n");
		declBuilder.append("% dim/3 is called if the attribute is an array type.\n");
		declBuilder.append(genSelfClass());

		//Class Operation TestCase No Result
		if(!this.currentScope.getName().equals(currentScope.getEnclosingScope().getName()))
		declBuilder.append(genArgClass());
		//Operation TestCase Has Result
		if(!this.currentScope.getName().equals(currentScope.getEnclosingScope().getName()))
			if(this.currentScope instanceof MethodSymbol m)
				if(m.getType() != null)
					declBuilder.append(genResultClass()).append("\n");
		
		if(isVarArray)declBuilder.append(genDimensionlabeling());
		declBuilder.append(arrayTypeDecl.toString()).append("\n");
		return declBuilder.toString();
	}
	
	private Object genDimensionlabeling() {
		StringBuilder sb = new StringBuilder();
		if(this.currentScope.getEnclosingScope() instanceof ClassSymbol c) {
			Iterator<? extends FieldSymbol> i = c.getFields().iterator();
			if(i.hasNext()) {
				FieldSymbol current = i.next();
					while(current != null) {
						if(current.getName().equals("self"))break;
						else if(current.getType() instanceof ArrayTypeClassSymbol a) {
							for(FieldSymbol f:a.getFields()) {
								if(f.getName().equals("dimensionSizes")) {
									if(!StringTool.isPureIntegerList(f.getDefaultValue())) {
										List<String> vars = StringTool.toCapitalizedList(f.getDefaultValue());
										for(String s :vars) {
											sb.append(s);
											sb.append("#> 0 ,");
										}
										sb.append("labeling_Dim(").append(StringTool.capitalizeElements(f.getDefaultValue())).append("),");
										sb.append("DimensionSizes = ").append(StringTool.capitalizeElements(f.getDefaultValue())).append(",");
									} 
								}
							}
						}
						if(i.hasNext()) 
							current = i.next();
					}
				}
			}
			sb.append("\n");
			return sb.toString();
		}
	

	private String genBodyCLP() {
		StringBuilder pathconstraint = new StringBuilder();
		pathconstraint.append("%CLG Path Constrints");
		AstVisitor<ClpCode> visitor = new ASTtoCLP<String>(currentScope);
		
		for(CLGNode node : constraintnodes) {
			if(node.getType()== CLGNodeType.CONSTRAINT) {
				ClpCode constraint = node.getExpr().accept(visitor);
				if(constraint == null ) {
					continue; // 忽略無效的約束
				}else {
					// next constraint
					if(pathconstraint.length() > 0) {
						pathconstraint.append(",\n");
					}
					pathconstraint.append(constraint.toString());
				}
			} else if(node.getType()== CLGNodeType.ITERATE) {

			}
		}
		if(pathconstraint.length() > 0) {
			pathconstraint.append(",\n");
		}
		 //System.out.println("蒐集到的 int 變數集合\n `intVars: "+((ASTtoCLP<String>) visitor).getIntVars().keySet()+"`");
		 //System.out.println("蒐集到的 Array 變數集合\n `ArrayVars: "+((ASTtoCLP<String>) visitor).getArrayVars().keySet()+"`");
		return pathconstraint.toString();
	}
	
	private String genlabelingCLP() {
		StringBuilder labelingBuilder = new StringBuilder();
		labelingBuilder.append("%Labeling Parts\n");
		if(!arrayType.isEmpty()) {
		labelingBuilder.append("labeling_Arrays(");
		labelingBuilder.append(arrayType.toString());
		
		if(intType.isEmpty()) labelingBuilder.append(").");
		else labelingBuilder.append("),");
		}
		
		if( !intType.isEmpty()) {
			labelingBuilder.append("labeling(");
			labelingBuilder.append(intType.toString());
			labelingBuilder.append(").");
		}
		
		return labelingBuilder.toString();
	}
	
	private String genSelfClass() {
		StringBuilder selfClass = new StringBuilder();
		if(this.currentScope.getEnclosingScope() instanceof ClassSymbol c) {
			selfClass.append("Self=[");
			
			Iterator<? extends FieldSymbol> i = c.getFields().iterator();
			if(i.hasNext()) {
			FieldSymbol current = i.next();
				while(current != null) {
					if(current.getName().equals("self"))break;
					else {
						selfClass.append("Self_").append(current.getName());
						if(current.getType().getTypeName().equals("int")) intType.add("Self_"+current.getName());
						if(current.getType() instanceof ArrayTypeClassSymbol a) {
							arrayType.add("Self_"+current.getName());
							arrayTypeDecl.append("dim(");
							arrayTypeDecl.append("Self_").append(current.getName()).append(",");
							for(FieldSymbol f:a.getFields()) {
								if(f.getName().equals("dimensionSizes")) {
									if(!(f.getDefaultValue().isEmpty()) && f.getDefaultValue().contains("[") ) {
										if(StringTool.isPureIntegerList(f.getDefaultValue()))
											arrayTypeDecl.append(f.getDefaultValue()).append("),");
											else {
												arrayTypeDecl.append( StringTool.capitalizeElements(f.getDefaultValue())).append("),");
												isVarArray =true;
											}
									}
									else {System.out.println("CLPTranslator Error, UML dimensionSize Default Value Wrong. Use\"[\" \"]\" ");}
								}
							}
						}
					}
					if(i.hasNext()) {
						current = i.next();
						if(current.getName().equals("self")) {selfClass.append("],"); break;}
						else selfClass.append(",");
					}
				}
			}else {
			selfClass.append("],");
			}
			
		}
		return selfClass.toString();
	}
	
	private String genArgClass() {
		StringBuilder argClass = new StringBuilder();
		
		List<ParameterSymbol>  args =null;
		if(currentScope instanceof MethodSymbol m) {
			args = m.getParameters();
		} 
		if(args == null) return null;
		
		
		for(ParameterSymbol p : args) {
			String argname = this.tocapitalizeFirstLetter(p.getName());
			argClass.append(argname).append("=[");
			if(p.getType() instanceof ClassSymbol c) {
				Iterator<? extends FieldSymbol> i = c.getFields().iterator();
				if(i.hasNext()) {
				FieldSymbol current = i.next();
					while(current != null) {
						if(current.getName().equals("self"))break;
						else {
							argClass.append(argname);
							argClass.append("_").append(current.getName());
							if(current.getType().getTypeName().equals("int")) intType.add(argname+"_"+current.getName());
							if(current.getType() instanceof ArrayTypeClassSymbol a) {
								arrayType.add(argname+"_"+current.getName());
								arrayTypeDecl.append("dim(").append(argname);
								arrayTypeDecl.append("_").append(current.getName()).append(",");
								for(FieldSymbol f:a.getFields()) {
									if(f.getName().equals("dimensionSizes")) {
										if(!(f.getDefaultValue().isEmpty())) {
											if(StringTool.isPureIntegerList(f.getDefaultValue()))
												arrayTypeDecl.append(f.getDefaultValue()).append("),");
												else {
													arrayTypeDecl.append( StringTool.capitalizeElements(f.getDefaultValue())).append("),");
													isVarArray =true;
												}
										}
										else {System.out.println("CLPTranslator Error, UML dimensionSize Default Value Wrong.");}
									}
								}
							}
						}
						
						
						if(i.hasNext()) {
							current = i.next();
							if(current.getName().equals("self")) {argClass.append("],"); break;}
							else argClass.append(",");
						}
					}
				}else {
					argClass.append("],");
				}
			} else argClass.append("]");
		}
		return argClass.toString();
	}

	private String genResultClass() {
		StringBuilder resultClass = new StringBuilder();
		
		if(currentScope instanceof MethodSymbol m){
			if(m.getType() == null) {errMessage.add("Error! The MethodSymbol doesn't have return Type.");return null;}
			
			
			else if(m.getType() instanceof ClassSymbol c){
				//result:int[1][2][3] or result:int[dim]
				if(c.getName().contains("[")) {
					//Nothing to do.  Ex. getData()
				}else {
					//result:Cube or result:ClassSymbol
					Iterator<? extends FieldSymbol> i = c.getFields().iterator();
					if(i.hasNext()) {
					resultClass.append("Result = [");
					FieldSymbol classAttrSym = i.next();
						while(classAttrSym != null) {
							if(classAttrSym.getName().equals("self"))break;
							else {
								resultClass.append("Result_").append(classAttrSym.getName());
								if(classAttrSym.getType() instanceof ArrayTypeClassSymbol a) {
									//arrayType.add("Result_"+current.getName());
									arrayTypeDecl.append("dim(");
									arrayTypeDecl.append("Result_").append(classAttrSym.getName()).append(",");
									for(FieldSymbol f:a.getFields()) {
										if(f.getName().equals("dimensionSizes")) {
											if(!(f.getDefaultValue().isEmpty())) {
											if(StringTool.isPureIntegerList(f.getDefaultValue()))
											arrayTypeDecl.append(f.getDefaultValue()).append("),");
											else {
												arrayTypeDecl.append( StringTool.capitalizeElements(f.getDefaultValue())).append("),");
												isVarArray =true;
											}
											}
											else {System.out.println("CLPTranslator Error, UML dimensionSize Default Value Wrong.");}
										}
									}
								} 
							}
							//next run
							if(i.hasNext()) {
								classAttrSym = i.next();
								if(classAttrSym.getName().equals("self")) {resultClass.append("],"); break;}
								else resultClass.append(",");
							} 
						}
					}
				}
			} else {
				errMessage.add("Error! The ReturnType is not ClassSymbol.");
				return null;
			}
		}else {
			errMessage.add("Error! The currentScope is not MethodSymbol.");
			return null;}
		return resultClass.toString();
	}

	private String tocapitalizeFirstLetter(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}
	
	
	
}
