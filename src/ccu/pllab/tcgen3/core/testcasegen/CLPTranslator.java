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
import ccu.pllab.tcgen3.symboltable.type.PrimitiveTypeSymbol;
import ccu.pllab.tcgen3.util.ClgUtil;
import ccu.pllab.tcgen3.util.StringTool;

public class CLPTranslator {
  private List<CLGNode> constraintnodes;// Collect ConstraintNode && IterateNode
  private Scope currentScope; // Current CLG Scpope
  AstVisitor<ClpCode> visitor;// gen CLP code from path AST nodes

  // collect for Array type declaration, ex. decl_Array(ArrayName, [2,3,4]) or decl_Array(ArrayName,
  // [dim1,dim2,dim3])
  private StringBuilder arrayDecl = new StringBuilder();

  // collect Array type dimension variable for labeling_Dim, ex.
  // Self_dimensionSizes、Arg_dimensionSizes、Result_dimensionSizes
  private List<String> arraydimVar = new ArrayList<>();

  // collect Array type variable for labeling_Arrays, ex. Self_data、Arg_data、Result_data
  private List<String> arrayTypeVar = new ArrayList<>();

  // collect PrimitiveType variable for labeling, ex. Self_number、Arg_number、Result_number
  private List<String> intTypeVar = new ArrayList<>();

  private List<String> errMessage = new ArrayList<>();
  private String requestterm;


  private boolean isVarArray;

  private boolean isConstructor;
  private boolean isException;
  private String filename;

  public CLPTranslator(List<CLGEdge> clgEdge, Scope currentScope, boolean isConstructor,
      String filename) {
    constraintnodes = ClgUtil.collectExprNodes(clgEdge);
    this.currentScope = currentScope;
    this.visitor = new ASTtoCLP<String>(currentScope);
    this.isConstructor = isConstructor;
    this.filename = filename;
    this.isException = false;
    this.isVarArray = false;

  }

  public List<String> getErrorMesg() {
    return errMessage;
  }

  public String translate() {
    // Need first gen , cause path info Ex. exception
    String body = this.genPathCLP();
    isException = ((ASTtoCLP<String>) this.visitor).isException();

    // define Self, Arg, Result, ArrayDecl, and DimensionSizes
    String decl = this.gendeclCLP(isException);


    String head = this.genHead(isException); // need final exe for DimensionSizes
    String labeling = this.genlabelingCLP();// using arrayTypeVar, intTypeVar, arraydimVar
    // combine all parts
    StringBuilder sb = new StringBuilder();
    sb.append(this.genlibCLP()).append("\n");
    sb.append(head).append("\n");
    sb.append(decl).append("\n");
    sb.append(body).append("\n");
    sb.append(labeling).append("\n");
    return sb.toString();
  }

  public String getRequestTerm() {
    return requestterm;
  }

  public boolean getisVarArray() {
    return isVarArray;
  }

  public boolean getisConstructor() {
    return isConstructor;
  }

  public boolean getisException() {
    return isException;
  }

  private String genHead(boolean isException) {
    StringBuilder sb = new StringBuilder();
    sb.append(StringTool.todecapitalizeFirstLetter(filename)).append("(");
    List<ParameterSymbol> args = null;

    // Classifier inv or OCL OperationContextDecl has no args
    if (currentScope instanceof ClassSymbol) {
      sb.append("Self)");
    }
    // Operation pre or post or getters constext
    else if (currentScope instanceof MethodSymbol m) {
      if (!(isException && isConstructor))
        sb.append("Self");
      args = m.getParameters();
      if (!args.isEmpty() && sb.toString().contains("Self"))
        sb.append(",");
      Iterator<ParameterSymbol> it = args.iterator();
      while (it.hasNext()) {
        sb.append(StringTool.tocapitalizeFirstLetter(it.next().getName())); // 加入目前元素
        if (it.hasNext()) {
          sb.append(","); // 還有下一個 → 加逗號
        }
      }
      // for OCL getters context
      if (sb.toString().charAt(sb.toString().length() - 1) == '(') {
        sb.append("Result)");
      } // for OCL OperationContextDecl has Return Value
      else if (m.getType() != null) {
        sb.append(",Result)");
      } // for OCL has Exception Context
      else if (isException) {
        if (!sb.toString().contains("Result"))
          sb.append(",Result)");
      } else
        sb.append(")");
    }

    requestterm = sb.toString();

    sb.append(":-\n");

    return sb.toString();
  }

  private String genlibCLP() {
    StringBuilder libStringBuilder = new StringBuilder();
    libStringBuilder
        .append(":- lib(ic).\n" + ":- lib(listut).\n" + ":- lib(random).\n" + ":- lib(timeout).\n");
    return libStringBuilder.toString();
  }

  private String gendeclCLP(boolean isException) {
    StringBuilder declBuilder = new StringBuilder();
    declBuilder.append("% Class and attribute combined as Class_Attr.\n");
    declBuilder.append("% dim/3 is called if the attribute is an array type.\n");

    /* Deal with Self ,means test Spec Obj instance */
    declBuilder.append(genSelfClass());

    // for OperationContextDecl: pre、post
    if (!(this.currentScope instanceof ClassSymbol)) {
      // Arg
      if (this.currentScope instanceof MethodSymbol m) {
        if (m.getNumberOfParameters() > 0) {
          declBuilder.append(genArgClass());
        }
      }
      // TestCase OperationContextDecl Has Result
      if (!this.currentScope.getName().equals(currentScope.getEnclosingScope().getName()))
        if (this.currentScope instanceof MethodSymbol m)
          // isException set from genPathCLP()
          if (m.getType() != null && !isException)
            declBuilder.append(genResultClass()).append("\n");
    }

    declBuilder.append(arrayDecl.toString()).append("\n");

    return declBuilder.toString();
  }

  private Object genDimensionlabeling() {
    StringBuilder sb = new StringBuilder();
    if (!arraydimVar.isEmpty()) {
      for (String s : arraydimVar) {
        sb.append("labeling_Dim(").append(s).append("),\n");
      }
    }
    return sb.toString();
  }

  // gen CLPBody from "a Path"
  private String genPathCLP() {
    StringBuilder pathconstraint = new StringBuilder();
    pathconstraint.append("%CLG Path Constrints");

    for (CLGNode node : constraintnodes) {
      if (node.getType() == CLGNodeType.CONSTRAINT) {
        ClpCode constraint = node.getExpr().accept(visitor);
        if (constraint == null) {
          continue; // 忽略無效的約束
        } else {
          // next constraint
          if (pathconstraint.length() > 0) {
            pathconstraint.append(",\n");
          }
          pathconstraint.append(constraint.toString());
        }
      } else if (node.getType() == CLGNodeType.ITERATE) {

      }
    }
    if (pathconstraint.length() > 0) {
      pathconstraint.append(",\n");
    }
    // System.out.println("蒐集到的 int 變數集合\n `intVars: "+((ASTtoCLP<String>)
    // visitor).getIntVars().keySet()+"`");
    // System.out.println("蒐集到的 Array 變數集合\n `ArrayVars: "+((ASTtoCLP<String>)
    // visitor).getArrayVars().keySet()+"`");
    return pathconstraint.toString();
  }

  private String genlabelingCLP() {
    StringBuilder labelingBuilder = new StringBuilder();
    if (isVarArray) {
      labelingBuilder.append("%DimensionSizes Labeling Parts\n");
      labelingBuilder.append(genDimensionlabeling());
    }
    labelingBuilder.append("%TypeVar Labeling Parts\n");
    if (!arrayTypeVar.isEmpty()) {
      labelingBuilder.append("labeling_Arrays(");
      labelingBuilder.append(arrayTypeVar.toString());
      if (intTypeVar.isEmpty())
        labelingBuilder.append(").");
      else
        labelingBuilder.append("),");
    }

    if (!intTypeVar.isEmpty()) {
      labelingBuilder.append("labeling_int(");
      labelingBuilder.append(intTypeVar.toString());
      labelingBuilder.append(").");
    }

    return labelingBuilder.toString();
  }

  private String genSelfClass() {
    StringBuilder selfClass = new StringBuilder();

    // test case for OCL OperationContext
    if (this.currentScope.getEnclosingScope() instanceof ClassSymbol c) {
      // collect all fields of the class
      String arrayTypeDimensionDecl = "";
      Iterator<? extends FieldSymbol> i = c.getFields().iterator();
      FieldSymbol currentAttr = null;
      if (i.hasNext()) {
        currentAttr = i.next();
        if (!currentAttr.getName().equals("self"))
          selfClass.append("Self=[");
      }
      while (currentAttr != null) {
        if (currentAttr.getName().equals("self"))
          break;
        else {
          // attribute flatten
          String classattr = "Self_" + currentAttr.getName();
          selfClass.append(classattr);
          // PrimitiveType type variable collect
          if (currentAttr.getType().getTypeName().equals("int"))
            intTypeVar.add(classattr);
          // ArrayType variable collect
          if (currentAttr.getType() instanceof ArrayTypeClassSymbol a) {
            selfClass.append(",Self_dimensionSizes");
            if (!isConstructor)
              arrayTypeVar.add(classattr);
            // Code : decl_Array(Self_data,Self_dimensionSizes),
            arrayDecl.append("decl_Array(").append(classattr).append(",")
                .append("Self_dimensionSizes)").append(",\n");
            arraydimVar.add("Self_dimensionSizes");
            arrayTypeDimensionDecl = dimensionProcess(a, arrayTypeDimensionDecl, "Self");
          }

        }
        if (i.hasNext()) {
          currentAttr = i.next();
          if (currentAttr.getName().equals("self")) {
            selfClass.append("],");
            break;
          } else
            selfClass.append(",");
        }
      }
      if (!arrayTypeDimensionDecl.isEmpty())
        selfClass.append("Self_dimensionSizes = ")
            .append(StringTool.capitalizeElements(arrayTypeDimensionDecl)).append(",\n");

      return selfClass.toString();

      // testcase for Classifier inv
    } else if (currentScope instanceof ClassSymbol c) {
      // collect all fields of the class
      String arrayTypeDimensionDecl = "";
      FieldSymbol currentAttr = null;
      Iterator<? extends FieldSymbol> i = c.getFields().iterator();
      if (i.hasNext()) {
        currentAttr = i.next();
        if (!currentAttr.getName().equals("self"))
          selfClass.append("Self=[");
      }
      while (currentAttr != null) {
        if (currentAttr.getName().equals("self"))
          break;
        else {
          // attribute flatten
          String classattr = "Self_" + currentAttr.getName();
          selfClass.append(classattr);
          // PrimitiveType Var collect
          if (currentAttr.getType().getTypeName().equals("int"))
            intTypeVar.add(classattr);
          // ArrayType Var collect
          if (currentAttr.getType() instanceof ArrayTypeClassSymbol a) {
            selfClass.append(",Self_dimensionSizes");
            arrayTypeVar.add(classattr);
            // Code : decl_Array(Self_data,Self_dimensionSizes),
            arrayDecl.append("decl_Array(").append(classattr).append(",")
                .append("Self_dimensionSizes)").append(",\n");
            arraydimVar.add("Self_dimensionSizes");
            arrayTypeDimensionDecl = dimensionProcess(a, arrayTypeDimensionDecl, "Self");
          }
        }
        if (i.hasNext()) {
          currentAttr = i.next();
          if (currentAttr.getName().equals("self")) {
            selfClass.append("],");
            break;
          } else
            selfClass.append(",");
        }
      }
      if (!arrayTypeDimensionDecl.isEmpty())
        selfClass.append("Self_dimensionSizes = ")
            .append(StringTool.capitalizeElements(arrayTypeDimensionDecl)).append(",\n");

      return selfClass.toString();
    }
    errMessage.add("Error! The currentScope is not ClassSymbol.");
    return "Wrong genSelfClass";
  }


  private String genArgClass() {
    StringBuilder argClass = new StringBuilder();
    String argname = "";
    // collect for Array dimensionSizesEx. [2,3,4] or [dim1,dim2,dim3] <-from UML default value
    String arrayTypeDimensionDecl = "";

    // collect all Parameter of the MethodSymbol
    List<ParameterSymbol> args = null;
    if (currentScope instanceof MethodSymbol m) {
      args = m.getParameters();
    }
    if (args == null)
      return null;

    // for each of Parameter flatten || obj decl
    for (ParameterSymbol p : args) {
      argname = StringTool.tocapitalizeFirstLetter(p.getName());

      // Case 1 OCL args Type is ArrayTypeClassSymbol
      // Ex: context VarArray::VarArray(inputArray:int[dim])
      if (p.getType() instanceof ArrayTypeClassSymbol ac) {
        arrayTypeVar.add(argname);
        arrayDecl.append("decl_Array(").append(argname).append(",")
            .append(argname + "_dimensionSizes),\n");
        arraydimVar.add(argname + "_dimensionSizes");
        arrayTypeDimensionDecl = dimensionProcess(ac, arrayTypeDimensionDecl, argname);
      }

      // Case 2 OCL args Type is UserDefinedType need to class flatten or obj decl
      // Ex: context VarArray::add(arg:VarArray):VarArray
      else if (p.getType() instanceof ClassSymbol c) {
        FieldSymbol currentAttri = null;
        Iterator<? extends FieldSymbol> i = c.getFields().iterator();
        if (i.hasNext()) {
          currentAttri = i.next();
          if (!currentAttri.getName().equals("self"))
            argClass.append(argname + "=[");
        }
        while (currentAttri != null) {
          if (currentAttri.getName().equals("self"))
            break;
          else {
            // attribute flatten
            String argattr = argname + "_" + currentAttri.getName();
            argClass.append(argattr);
            // Attribute's PrimitiveType Var collect
            if (currentAttri.getType().getTypeName().equals("int"))
              intTypeVar.add(argattr);
            // Attribute's ArrayType Var collect
            if (currentAttri.getType() instanceof ArrayTypeClassSymbol a) {
              argClass.append(",").append(argname).append("_dimensionSizes");
              arrayTypeVar.add(argattr);
              arrayDecl.append("decl_Array(").append(argattr).append(",")
                  .append(argname + "_dimensionSizes),\n");
              arraydimVar.add(argname + "_dimensionSizes");
              arrayTypeDimensionDecl = dimensionProcess(a, arrayTypeDimensionDecl, argname);
            }
          }
          if (i.hasNext()) {
            currentAttri = i.next();
            if (currentAttri.getName().equals("self")) {
              argClass.append("],");
              break;
            } else
              argClass.append(",");
          }
        }
        // for collect primitive Type Var
        if (p.getType() instanceof PrimitiveTypeSymbol ptype)
          if (ptype.getTypeName().equals("int"))
            intTypeVar.add(argname);
      } else
        argClass.append("]");
    }
    if (!arrayTypeDimensionDecl.isEmpty())
      argClass.append(argname).append("_dimensionSizes = ")
          .append(StringTool.capitalizeElements(arrayTypeDimensionDecl)).append(",\n");


    return argClass.toString();
  }


  private String genResultClass() {
    StringBuilder resultClass = new StringBuilder();
    String arrayTypeDimensionDecl = "";
    if (currentScope instanceof MethodSymbol m) {
      if (m.getType() == null) {
        errMessage.add("Error! The MethodSymbol doesn't have return Type.");
        return null;
      }

      else if (m.getType() instanceof ClassSymbol c) {
        // result:int[1][2][3] or result:int[dim]
        if (c.getName().contains("[")) {
          // Nothing to do. Ex. getData()
        } else {
          FieldSymbol classAttrSym = null;
          // result:Cube or result:ClassSymbol
          Iterator<? extends FieldSymbol> i = c.getFields().iterator();
          if (i.hasNext()) {
            classAttrSym = i.next();
            if (!classAttrSym.getName().equals("self"))
              resultClass.append("Result = [");
          }
          while (classAttrSym != null) {
            if (classAttrSym.getName().equals("self"))
              break;
            else {
              // attribute flatten
              String classattr = "Result_" + classAttrSym.getName();
              resultClass.append(classattr);

              // PrimitiveType Var flatten
              // if(classAttrSym.getType().getTypeName().equals("int")) intTypeVar.add(classattr);
              // ArrayType Var flatten
              if (classAttrSym.getType() instanceof ArrayTypeClassSymbol a) {
                // arrayType.add("Result_"+current.getName());
                resultClass.append(",Result_dimensionSizes");
                arrayDecl.append("decl_Array(" + classattr).append(",")
                    .append("Result_dimensionSizes),");
                arrayTypeDimensionDecl = dimensionProcess(a, arrayTypeDimensionDecl, "Result");
              }
            }
            // next run
            if (i.hasNext()) {
              classAttrSym = i.next();
              if (classAttrSym.getName().equals("self")) {
                resultClass.append("],");
                break;
              } else
                resultClass.append(",");
            }
          }
        }
      } else {
        errMessage.add("Error! The ReturnType is not ClassSymbol.");
        return null;
      }
    } else {
      errMessage.add("Error! The currentScope is not MethodSymbol.");
      return null;
    }
    if (!arrayTypeDimensionDecl.isEmpty())
      resultClass.append("Result_dimensionSizes = ")
          .append(StringTool.capitalizeElements(arrayTypeDimensionDecl)).append(",\n");
    return resultClass.toString();
  }


  private String dimensionProcess(ArrayTypeClassSymbol acsym, String arrayTypeDimensionDecl,
      String argname) {
    for (FieldSymbol f : acsym.getFields()) {
      if (f.getName().equals("dimensionSizes")) {
        if (!(f.getDefaultValue().isEmpty()) && f.getDefaultValue().contains("[")) {
          if (!StringTool.isPureIntegerList(f.getDefaultValue())) {
            arrayTypeDimensionDecl = StringTool.addPrefix(f.getDefaultValue(), argname);
            isVarArray = true;
          } else
            arrayTypeDimensionDecl = f.getDefaultValue();
        } else {
          System.out.println("CLPTranslator Error, UML dimensionSize Default Value Wrong.");
        }
      }
    }
    return arrayTypeDimensionDecl;
  }



}
