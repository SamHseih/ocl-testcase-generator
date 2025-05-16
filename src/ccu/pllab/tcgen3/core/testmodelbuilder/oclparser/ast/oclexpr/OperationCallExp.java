package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class OperationCallExp extends FeatureCallExp{
	
	private ASTree source; //source 可能為 null
	private String name;
	private String op; //arrow"->" or dot "."
	private Type returnType;

	
	/** OperationCallExp
	 * ├── child(0) : source (可為 null ⇒ 無顯式 source 時不放)
	 * ├── child(1) : arg1
	 * ├── child(2) : arg2
	 *  */
	public OperationCallExp(ASTree source, List<ASTree> args, Type returnType,
							boolean isPre, String methodName, String op) {
		super(merge(source, args), isPre);   // 交給 ASTList 儲存
		this.name = methodName;
		this.op = op;
		this.returnType= returnType;
		this.source = source;
	}

    private static List<ASTree> merge(ASTree source, List<ASTree> args) {
    	List<ASTree> list = new ArrayList<>();
        if (source != null) {
        	list.add(source);
        	}
        list.addAll(args);
        return list;
	}
    
	@SuppressWarnings("unchecked")
	public List<ASTree> getArgs() { 
    	int start = (getSource() != null) ? 1 : 0;
    	return ((List<ASTree>) children()).subList(start, numChildren());
    }
	
    @Override
    public ASTree getSource()  { 
    	return source; 
    	
    }
    
    @Override
    public String getName()      { 
    	return name; 
    	
    }
    public String getOp()       { 
		return op; 
		
	}
    
	@Override
	public Type getType() {
		return returnType;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (source != null) {
			sb.append(source.toString());
			sb.append(op);
		}
		sb.append(name);
		sb.append("(");
		if (numChildren() > 1) {
			for (int i = 1; i < numChildren(); i++) {
				if (i > 2) {
					sb.append(", ");
				}
				sb.append(child(i).toString());
			}
		}
		sb.append(")");

		return sb.toString();
	}
	

 }
