package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.BaseSymbol;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.type.ArrayTypeClassSymbol;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.MultiplicityListType;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class ArrayRefExp extends FeatureCallExp {
  private final String arrayName;

  /**
   * New OCL Extends «ArrayRef» ArrayRefExp Ex. x = self.a[2][4][5]<br>
   * ├── ASTree child(0) : source = self <br>
   * ├── ASTree child(1) : index = 5 ├── ASTree child(2) : index = 4 └── ASTree child(3) : index = 2
   */
  public ArrayRefExp(List<ASTree> children, boolean isPre, Symbol sym, String arrayName) {
    super(children, isPre, sym);
    this.arrayName = arrayName;

  }

  public List<ASTree> getIndex() {
    List<ASTree> indexList = new ArrayList<>();
    if (numChildren() == 0) {
      return indexList;
    }
    for (int i = 1; i < numChildren(); i++) {
      ASTree child = child(i);
      indexList.add(child);
    }
    return indexList;
  }

  @Override
  public ASTree getSource() {
    return child(0);
  }

  @Override
  public String getFeatureName() {
    return arrayName;
  }

  @Override
  public Type getType() {
    if (sym instanceof BaseSymbol) {
      Type arrayType = ((BaseSymbol) sym).getType();
      if (arrayType instanceof MultiplicityListType a) {
        if (numChildren() > 1) {
          return a.getElementType();
        } else
          return a;
      }
      // for uml array
      if (arrayType instanceof ArrayTypeClassSymbol a) {
        Symbol arrsym = a.resolve("elements");
        // elements is fieldsymbol
        if (arrsym instanceof BaseSymbol arr) {
          Type multiplicityType = arr.getType();
          if (multiplicityType instanceof MultiplicityListType b) {
            // result.datas[index][index][index]
            if (numChildren() > 1) {
              return b.getElementType();
            } else
              return a;
          }
        }
      }

    }
    // for 1..* array
    else if (sym instanceof ClassSymbol c) {
      if (c instanceof MultiplicityListType a) {
        if (numChildren() > 1) {
          return a.getElementType();
        } else
          return a;
      }
      // for uml array
      if (c instanceof ArrayTypeClassSymbol a) {
        Symbol arrsym = a.resolve("elements");
        // elements is fieldsymbol
        if (arrsym instanceof BaseSymbol arr) {
          Type multiplicityType = arr.getType();
          if (multiplicityType instanceof MultiplicityListType b) {
            if (numChildren() > 1) {
              return b.getElementType();
            } else
              return a;
          }
        }
      }
    }
    return new InvalidType();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getSource().toString()).append(".").append(arrayName);
    for (ASTree index : getIndex()) {
      // self.datas[node 233][node 234][node 235]
      // sb.append("[node ").append(index.id()).append("]");
      // self.datas[it][it1][it3]
      if (index instanceof BinaryExp b) {
        sb.append("[");
        sb.append(b.toString());
        sb.append("]");
      } else {
        sb.append("[");
        sb.append(index.toString());
        sb.append("]");
      }
    }
    if (isMarkedPre()) {
      sb.append("@pre");
    }
    return sb.toString();

  }

  @Override
  public String toClgString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getSource().toString()).append(".").append(arrayName);
    for (ASTree index : getIndex()) {
      // self.datas[node 233][node 234][node 235]
      // sb.append("[node ").append(index.id()).append("]");
      // self.datas[it][it1][it3]
      if (index instanceof BinaryExp b) {
        sb.append("[");
        sb.append(b.toClgString());
        sb.append("]");
      } else {
        sb.append("[");
        sb.append(index.toClgString());
        sb.append("]");
      }
    }
    if (isMarkedPre()) {
      sb.append("@pre");
    }
    return sb.toString();
  }

  @Override
  public String toAstString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getSource().toString()).append(".").append(arrayName);
    for (ASTree index : getIndex()) {
      // self.datas[node 233][node 234][node 235]
      // sb.append("[node ").append(index.id()).append("]");
      // self.datas[it][it1][it3]
      if (index instanceof BinaryExp b) {
        sb.append("[");
        sb.append(b.toAstString());
        sb.append("]");
      } else {
        sb.append("[");
        sb.append(index.toAstString());
        sb.append("]");
      }
    }
    if (isMarkedPre()) {
      sb.append("@pre");
    }
    return sb.toString();

  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visitArrayRefExpContext(this);
  }

  @Override
  public ASTree clone() {
    List<ASTree> clonedChildren = new ArrayList<>();
    for (ASTree child : this.children) {
      clonedChildren.add(child.clone());
    }

    return new ArrayRefExp(clonedChildren, this.isMarkedPre(), this.sym, this.arrayName);
  }

}
