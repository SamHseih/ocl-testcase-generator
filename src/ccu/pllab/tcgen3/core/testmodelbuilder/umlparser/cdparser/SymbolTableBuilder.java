package ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.FieldSymbol;
import ccu.pllab.tcgen3.symboltable.MethodSymbol;
import ccu.pllab.tcgen3.symboltable.ParameterSymbol;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.scope.GlobalScope;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.ArrayListTypeClassSymbol;
import ccu.pllab.tcgen3.symboltable.type.ArrayTypeClassSymbol;
import ccu.pllab.tcgen3.symboltable.type.MultiplicityListType;
import ccu.pllab.tcgen3.symboltable.type.PrimitiveTypeSymbol;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class SymbolTableBuilder {
  private GlobalScope globalsymbolTable;
  private Document document;
  public static Type BooleanType;
  public static Type StringType;
  public static Type IntType;
  public List<String> errorMessages = new ArrayList<>();

  public SymbolTableBuilder(Document document) {
    if (document == null) {
      errorMessages.add("Error: Document cannot be null.");
      throw new IllegalArgumentException("Document cannot be null");
    }
    this.document = document;
  }

  public List<String> getErrorMessages() {
    return errorMessages;
  }

  public Scope build() {
    globalsymbolTable = new GlobalScope(null);
    buildPrimitiveTypes(document, globalsymbolTable);
    bulidReferenceTypes(document, globalsymbolTable);
    buildClasses(document, globalsymbolTable);
    return globalsymbolTable;
  }

  public Scope getSymbolTable() {
    if (globalsymbolTable == null) {
      errorMessages.add("Error: Symbol table has not been built. Call build() first.");
      throw new IllegalStateException("Symbol table has not been built. Call build() first.");
    }
    return globalsymbolTable;
  }

  private void buildPrimitiveTypes(Document doc, GlobalScope symbolTable) {
    NodeList packagedElements = doc.getElementsByTagName("packagedElement");
    for (int i = 0; i < packagedElements.getLength(); i++) {
      Node node = packagedElements.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        String xmiType = element.getAttribute("xmi:type");
        String name = element.getAttribute("name");
        String id = element.getAttribute("xmi:id");
        if ("uml:PrimitiveType".equals(xmiType) && "int".equals(name)) {
          PrimitiveTypeSymbol intType = new PrimitiveTypeSymbol(name, id);
          IntType = intType;

          /* predefine fun. : mod() */
          MethodSymbol modSymbol = new MethodSymbol("mod", "predefined");
          ParameterSymbol paramSymbol = new ParameterSymbol("value", "predefined");
          paramSymbol.setType(intType);
          paramSymbol.setScope(modSymbol);
          modSymbol.define(paramSymbol);
          modSymbol.setType(intType);
          modSymbol.setScope((ClassSymbol) intType);
          ((ClassSymbol) intType).define(modSymbol);
          /* predefine fun. End */

          symbolTable.define(intType);
          symbolTable.defineByClassSymTypeId(intType);


        } else if ("uml:PrimitiveType".equals(xmiType) && "Boolean".equals(name)) {
          PrimitiveTypeSymbol primitiveType = new PrimitiveTypeSymbol(name, id);
          symbolTable.define(primitiveType);
          symbolTable.defineByClassSymTypeId(primitiveType);
          BooleanType = primitiveType;
        } else if ("uml:PrimitiveType".equals(xmiType) && "String".equals(name)) {
          PrimitiveTypeSymbol primitiveType = new PrimitiveTypeSymbol(name, id);
          symbolTable.define(primitiveType);
          symbolTable.defineByClassSymTypeId(primitiveType);
          StringType = primitiveType;
        } else if ("uml:PrimitiveType".equals(xmiType)) {
          errorMessages
              .add("Warning: Unrecognized primitive type '" + name + "' with xmi:id '" + id + "'.");
        }
      }
    }
  }

  private void bulidReferenceTypes(Document doc, GlobalScope symbolTable) {
    NodeList packagedElements = doc.getElementsByTagName("packagedElement");
    for (int i = 0; i < packagedElements.getLength(); i++) {
      Node node = packagedElements.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        String xmiType = element.getAttribute("xmi:type");
        String datatypename = element.getAttribute("name");
        String dataid = element.getAttribute("xmi:id");

        /* dataType For ArrayList */
        if ("uml:DataType".equals(xmiType) && datatypename.contains("ArrayList")) {
          ArrayListTypeClassSymbol classSymbol = new ArrayListTypeClassSymbol(datatypename, dataid);
          classSymbol.setScope(globalsymbolTable);
          globalsymbolTable.define(classSymbol);
          globalsymbolTable.defineByClassSymTypeId(classSymbol);
          // Process attributes 待修改
          // processAttributes(element, classSymbol, datatypename);
          // Process operations 待修改
          // processOperations(element, classSymbol, datatypename);
        } /* dataType For staitc Array */
        else if ("uml:DataType".equals(xmiType)) {
          ArrayTypeClassSymbol classSymbol = new ArrayTypeClassSymbol(datatypename, dataid);
          classSymbol.setScope(globalsymbolTable);
          globalsymbolTable.define(classSymbol);
          globalsymbolTable.defineByClassSymTypeId(classSymbol);

          // Process attributes
          processAttributes(element, classSymbol, datatypename);
          // Process operations
          processOperations(element, classSymbol, datatypename);
        }
      }
    }
  }

  /**
   * Get the type by ID from the symbol table.
   * 
   * @param arrelementTypeId The ID of the type to retrieve.
   * @return The Type object corresponding to the given ID.
   */
  private Type getTypebyID(String arrelementTypeId) {
    Symbol symbol = globalsymbolTable.resolveById(arrelementTypeId);
    if (symbol != null) {
      return (Type) symbol;
    } else {
      errorMessages.add("Error: Type with ID " + arrelementTypeId + " not found.");
      throw new IllegalArgumentException("Type with ID " + arrelementTypeId + " not found.");
    }
  }

  private void buildClasses(Document doc, GlobalScope symbolTable) {
    NodeList packagedElements = doc.getElementsByTagName("packagedElement");
    for (int i = 0; i < packagedElements.getLength(); i++) {
      Node node = packagedElements.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        String xmiType = element.getAttribute("xmi:type");
        String classname = element.getAttribute("name");
        String classid = element.getAttribute("xmi:id");

        // Check if the element is a UML Class
        if ("uml:Class".equals(xmiType)) {
          ClassSymbol classSymbol = new ClassSymbol(classname, classid);
          classSymbol.setScope(globalsymbolTable);
          globalsymbolTable.define(classSymbol);
          globalsymbolTable.defineByClassSymTypeId(classSymbol);

          // Process attributes
          processAttributes(element, classSymbol, classname);
          // Process operations
          processOperations(element, classSymbol, classname);
        }
      }
    }

  }

  private void processAttributes(Element classElement, ClassSymbol classSymbol, String classname) {
    NodeList ownedAttributes = classElement.getElementsByTagName("ownedAttribute");
    for (int j = 0; j < ownedAttributes.getLength(); j++) {
      Node attrNode = ownedAttributes.item(j);
      if (attrNode.getNodeType() == Node.ELEMENT_NODE
          && attrNode.getParentNode().isSameNode(classElement)) {

        Element attrElement = (Element) attrNode;
        String attrName = attrElement.getAttribute("name");
        String attrId = attrElement.getAttribute("xmi:id");
        String attrTypeId = attrElement.getAttribute("type");

        /*
         * deal with default value, default value is 0, if not set ,value always using String type
         */
        String defaultValue = "0";
        String defaultValueArray = extractDefaultValue(attrElement);

        defaultValue = defaultValueArray;
        int size = multiplyIfBraced(defaultValueArray);


        /*
         * deal with multiplicity {lowerValue, upperValue, id}, if upperValue is '*' then id change
         */
        String[] multiplicity = extractMultiplicity(attrElement, attrId);

        Type attrType = getTypebyID(attrTypeId);
        if (multiplicity[1].equals("*")) { // id changed cause multiplicity
          attrType = new MultiplicityListType(classname + "::" + attrName + "[]", attrType,
              multiplicity[2]);

          /* Special fun. : Size() */
          MethodSymbol sizeSymbol = new MethodSymbol("size", "predefined");
          Type returntype = globalsymbolTable.resolveType("int");
          sizeSymbol.setType(returntype);
          sizeSymbol.setScope((ArrayTypeClassSymbol) attrType);
          ((ArrayTypeClassSymbol) attrType).define(sizeSymbol);
          /* Special fun. End */

          globalsymbolTable.define((Symbol) attrType);
          globalsymbolTable.defineByClassSymTypeId((ClassSymbol) attrType);
          ((MultiplicityListType) attrType).setSize(size);
        }


        FieldSymbol variableSymbol = new FieldSymbol(attrName, attrId);
        variableSymbol.setType(attrType);
        variableSymbol.setScope(classSymbol);
        variableSymbol.setMultiplicity(multiplicity[0], multiplicity[1]);
        variableSymbol.setDefaultValue(defaultValue);


        classSymbol.define(variableSymbol);
      }
    }
  }

  /**
   * Multiplies all integers inside a string wrapped with '{' and '}'.
   * <p>
   * • If the string is not properly wrapped, an IllegalArgumentException is thrown. • If the braces
   * contain no numbers, the method returns 1.
   *
   * @param text a string such as "{2,2,5,4}"
   * @return the product of the integers inside the braces
   */
  private int multiplyIfBraced(String text) {
    // Validate the format: must start with '{' and end with '}'
    if (text == null || !text.startsWith("{") || !text.endsWith("}")) {
      return 0;
    }

    // Strip the outer braces and whitespace
    String content = text.substring(1, text.length() - 1).trim();
    if (content.isEmpty()) {
      return 0; // 空內容，視同乘積為 1
    }

    // Split by commas, parse each element to int, and reduce via multiplication
    return Arrays.stream(content.split(",")).map(String::trim) // Remove optional whitespace around
                                                               // numbers
        .mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b);
  }

  private String extractDefaultValue(Element attrElement) {
    NodeList defaults = attrElement.getElementsByTagName("defaultValue");
    if (defaults.getLength() > 0) {
      Element dvElem = (Element) defaults.item(0);

      String dvType = dvElem.getAttribute("xmi:type");

      if ("uml:LiteralInteger".equals(dvType) || "uml:LiteralString".equals(dvType)
          || "uml:LiteralBoolean".equals(dvType)) {

        return dvElem.getAttribute("value"); // 直接 value
      } else if ("uml:Expression".equals(dvType)) {
        return dvElem.getAttribute("symbol"); // 取 symbol
      }
      /* 其他 LiteralUnlimitedNatural… 需要時再補 */
    }
    return "0";
  }

  private void processOperations(Element classElement, ClassSymbol classSymbol, String classname) {
    boolean hasConstructor = false;
    NodeList ownedOperations = classElement.getElementsByTagName("ownedOperation");
    for (int j = 0; j < ownedOperations.getLength(); j++) {
      Node opNode = ownedOperations.item(j);
      if (opNode.getNodeType() == Node.ELEMENT_NODE
          && opNode.getParentNode().isSameNode(classElement)) {

        Element opElement = (Element) opNode;
        String opName = opElement.getAttribute("name");
        String opId = opElement.getAttribute("xmi:id");

        MethodSymbol methodSymbol = new MethodSymbol(opName, opId);
        methodSymbol.setScope(classSymbol);

        if (classname.equals(opName)) {
          hasConstructor = true;
        }



        NodeList parameters = opElement.getElementsByTagName("ownedParameter");
        for (int k = 0; k < parameters.getLength(); k++) {
          Node paramNode = parameters.item(k);
          if (paramNode.getNodeType() == Node.ELEMENT_NODE
              && paramNode.getParentNode().isSameNode(opElement)) {

            Element paramElement = (Element) paramNode;
            String paramName = paramElement.getAttribute("name");
            String paramId = paramElement.getAttribute("xmi:id");
            String paramDirection = paramElement.getAttribute("direction");

            String paramTypeId = paramElement.getAttribute("type");
            Type paramType = getTypebyID(paramTypeId);
            String[] multiplicity = extractMultiplicity(paramElement, paramId);
            if (multiplicity[1].equals("*")) {
              paramType = new MultiplicityListType(
                  classname + "::" + opName + "::" + paramName + "[]", paramType, multiplicity[2]);

              /* Special fun. : Size() */
              MethodSymbol sizeSymbol = new MethodSymbol("size", "predefined");
              Type returntype = globalsymbolTable.resolveType("int");
              sizeSymbol.setType(returntype);
              sizeSymbol.setScope((ArrayTypeClassSymbol) paramType);
              ((ArrayTypeClassSymbol) paramType).define(sizeSymbol);
              /* Special fun. End */

              globalsymbolTable.define((Symbol) paramType);
              globalsymbolTable.defineByClassSymTypeId((ClassSymbol) paramType);
            }
            if ("return".equals(paramDirection)) {
              methodSymbol.setType(paramType);
            } else {
              ParameterSymbol paramSymbol = new ParameterSymbol(paramName, paramId);
              paramSymbol.setType(paramType);
              paramSymbol.setScope(methodSymbol);
              paramSymbol.setMultiplicity(multiplicity[0], multiplicity[1]);
              methodSymbol.define(paramSymbol);
            }
          }
        }
        classSymbol.define(methodSymbol);
      }
    }

    if (!hasConstructor) {
      errorMessages.add("Warning: Class '" + classname + "' does not have a constructor.");
    }
  }

  private String[] extractMultiplicity(Element element, String defaultid) {
    String lowerValueStr = "1";
    String upperValueStr = "1";
    String id = defaultid;

    NodeList lowerValue = element.getElementsByTagName("lowerValue");
    NodeList upperValue = element.getElementsByTagName("upperValue");

    if (lowerValue.getLength() > 0 && lowerValue.item(0).getNodeType() == Node.ELEMENT_NODE) {
      String val = ((Element) lowerValue.item(0)).getAttribute("value");
      lowerValueStr = (val != null && !val.isEmpty()) ? val : "0";
    }

    if (upperValue.getLength() > 0 && upperValue.item(0).getNodeType() == Node.ELEMENT_NODE) {
      String val = ((Element) upperValue.item(0)).getAttribute("value");
      // If the value is "*", set new Type Id for ArrayType
      id = ((Element) upperValue.item(0)).getAttribute("xmi:id");
      upperValueStr = (val != null && !val.isEmpty()) ? val : "0";
    }

    return new String[] {lowerValueStr, upperValueStr, id};
  }

}
