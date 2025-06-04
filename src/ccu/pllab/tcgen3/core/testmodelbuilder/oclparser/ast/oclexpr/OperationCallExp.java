package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.CLGAstVisitor;
import ccu.pllab.tcgen3.symboltable.Symbol;
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
							boolean isPre, String methodName, String op ,Symbol sym) {
		super(merge(source, args), isPre,sym);   // 交給 ASTList 儲存
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
    
	public List<ASTree> getArgs() { 
    	int start = (getSource() != null) ? 1 : 0;
    	return children.subList(start, numChildren());
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
	
	@Override
	public String toAstString() {
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
	
	@Override
	public String toClgString() {
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
	
	@Override
	public <R> R accept(CLGAstVisitor<R> visitor) {
		return visitor.visitOperationCallExpContext(this);
	}

	@Override
	public ASTree clone() {
	    // 1️ 複製 source（可能為 null）
	    ASTree clonedSource = (this.getSource() != null)
	                          ? this.getSource().clone()
	                          : null;

	    // 2️ 複製 args
	    java.util.List<ASTree> clonedArgs = new java.util.ArrayList<>();
	    for (ASTree arg : this.getArgs()) {
	        clonedArgs.add(arg.clone());
	    }

	    // 3️ 建立新 OperationCallExp
	    return new OperationCallExp(
	        clonedSource,          // source
	        clonedArgs,            // args
	        this.returnType,       // 回傳型別 (Type)
	        this.isMarkedPre(),    // @pre 標記
	        this.name,             // 方法名稱
	        this.op,               // "." 或 "->"
	        this.sym               // Symbol
	    );
	}
 }
