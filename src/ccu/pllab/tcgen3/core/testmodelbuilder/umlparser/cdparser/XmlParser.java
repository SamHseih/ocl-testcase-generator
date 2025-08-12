package ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser;

import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser {
  private final Path umlPath;
  private final Document doc;

  /**
   * Constructor: receives the UML file path and immediately parses it to obtain the Document.
   * 
   * @param umlPath the path to the UML (XML) file
   */
  public XmlParser(Path umlPath) {
    if (umlPath == null) {
      throw new IllegalArgumentException("umlPath cannot be null");
    }
    this.umlPath = umlPath;
    this.doc = parseXml();
  }

  /**
   * Parses the XML (UML) file and returns the Document object.
   * 
   * @return the parsed Document
   */
  private Document parseXml() {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // 安全性設定（防止 XXE）
    try {
      factory.setNamespaceAware(false);
      factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
      factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
      factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
      factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
      factory.setXIncludeAware(false);
      factory.setExpandEntityReferences(false);
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(umlPath.toFile());
      document.getDocumentElement().normalize();
      return document;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to parse XML file: " + umlPath, e);
    }
  }

  public Document getDocument() {
    return doc;
  }

  /**
   * (1) Retrieve packagedElement (type = uml:Class) properties and method information.
   * 
   * @return a string describing class names, attributes, and operations
   */
  public String parseClassInfo() {
    StringBuilder classInfo = new StringBuilder();

    // Get all <packagedElement> nodes
    NodeList packagedElements = doc.getElementsByTagName("packagedElement");
    for (int i = 0; i < packagedElements.getLength(); i++) {
      Node node = packagedElements.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        String xmiType = element.getAttribute("xmi:type");

        // Check if this is a UML Class
        if ("uml:Class".equals(xmiType)) {
          String className = element.getAttribute("name");
          String classId = element.getAttribute("xmi:id");

          classInfo.append("Class Name: ").append(className).append(", ID: ").append(classId)
              .append("\n");

          // (A) Parse owned attributes
          NodeList ownedAttributes = element.getElementsByTagName("ownedAttribute");
          for (int j = 0; j < ownedAttributes.getLength(); j++) {
            Node attrNode = ownedAttributes.item(j);

            // Ensure parent is the same <packagedElement> (Class)
            if (attrNode.getNodeType() == Node.ELEMENT_NODE
                && attrNode.getParentNode().isSameNode(node)) {
              Element attrElement = (Element) attrNode;
              String attrName = attrElement.getAttribute("name");
              String attrType = attrElement.getAttribute("type");
              String attrVisibility = attrElement.getAttribute("visibility");
              String attrId = attrElement.getAttribute("xmi:id");

              classInfo.append("  Owned Attribute:\n").append("    name=").append(attrName)
                  .append("\n").append("    type=").append(attrType).append("\n")
                  .append("    visibility=").append(attrVisibility).append("\n").append("    id=")
                  .append(attrId).append("\n");
            }
          }

          // (B) Parse owned operations
          NodeList ownedOperations = element.getElementsByTagName("ownedOperation");
          for (int j = 0; j < ownedOperations.getLength(); j++) {
            Node opNode = ownedOperations.item(j);

            // Ensure parent is the same <packagedElement> (Class)
            if (opNode.getNodeType() == Node.ELEMENT_NODE
                && opNode.getParentNode().isSameNode(node)) {
              Element opElement = (Element) opNode;
              String opName = opElement.getAttribute("name");
              String opId = opElement.getAttribute("xmi:id");

              // Find if there's a return parameter
              NodeList paramNodes = opElement.getElementsByTagName("ownedParameter");
              String returnType = "void"; // default if no return parameter

              StringBuilder paramsBuilder = new StringBuilder();

              for (int k = 0; k < paramNodes.getLength(); k++) {
                Node paramNode = paramNodes.item(k);
                if (paramNode.getNodeType() == Node.ELEMENT_NODE
                    && paramNode.getParentNode().isSameNode(opNode)) {
                  Element paramElement = (Element) paramNode;
                  String direction = paramElement.getAttribute("direction");
                  String paramName = paramElement.getAttribute("name");
                  String paramType = paramElement.getAttribute("type");
                  String paramId = paramElement.getAttribute("xmi:id");

                  // Check if this parameter is a return parameter
                  if ("return".equals(direction)) {
                    // If there's a return parameter, use that type
                    returnType = paramType;
                  } else {
                    // Otherwise, it's a normal parameter
                    paramsBuilder.append("      Parameter:\n").append("        name=")
                        .append(paramName).append("\n").append("        type=").append(paramType)
                        .append("\n").append("        id=").append(paramId).append("\n");
                  }
                }
              }

              classInfo.append("  Owned Operation:\n").append("    name=").append(opName)
                  .append("\n").append("    id=").append(opId).append("\n")
                  .append("    returnType=").append(returnType).append("\n");

              // Append any parameters found
              if (paramsBuilder.length() > 0) {
                classInfo.append(paramsBuilder);
              }
            }
          }

          classInfo.append("\n");
        }
      }
    }

    return classInfo.toString();
  }

  /**
   * (2) Retrieve packagedElement (type = uml:Association) information.
   * 
   * @return a string describing associations
   */
  public String parseAssociationInfo() {
    StringBuilder associationInfo = new StringBuilder();

    NodeList packagedElements = doc.getElementsByTagName("packagedElement");
    for (int i = 0; i < packagedElements.getLength(); i++) {
      Node node = packagedElements.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        String xmiType = element.getAttribute("xmi:type");
        if ("uml:Association".equals(xmiType)) {
          String name = element.getAttribute("name");
          associationInfo.append("Association Name: ").append(name).append("\n\n");
        }
      }
    }

    return associationInfo.toString();
  }

  /**
   * (3) Retrieve packagedElement (type = uml:Package, name = Primitivetype) information.
   * 
   * @return a string describing the Primitivetype package
   */
  public String parsePrimitivePackageInfo() {
    StringBuilder primitivePackageInfo = new StringBuilder();

    NodeList packagedElements = doc.getElementsByTagName("packagedElement");
    for (int i = 0; i < packagedElements.getLength(); i++) {
      Node node = packagedElements.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        String xmiType = element.getAttribute("xmi:type");
        String name = element.getAttribute("name");

        if ("uml:Package".equals(xmiType) && "Primitivetype".equals(name)) {
          primitivePackageInfo.append("Package (Primitivetype) Name: ").append(name).append("\n");

          // Get child elements under that Package (e.g., <packagedElement
          // xmi:type="uml:PrimitiveType">)
          NodeList subNodes = element.getElementsByTagName("packagedElement");
          for (int j = 0; j < subNodes.getLength(); j++) {
            Node subNode = subNodes.item(j);
            // Check if the parent node is the same element
            if (subNode.getNodeType() == Node.ELEMENT_NODE
                && subNode.getParentNode().isSameNode(node)) {
              Element subElem = (Element) subNode;
              String subElemName = subElem.getAttribute("name");
              primitivePackageInfo.append("  PrimitiveType: ").append(subElemName).append("\n");
            }
          }
          primitivePackageInfo.append("\n");
        }
      }
    }

    return primitivePackageInfo.toString();
  }

  /**
   * (4) Retrieve packagedElement (type = uml:Package, name = Referencetype) information.
   * 
   * @return a string describing the Referencetype package
   */
  public String parseReferencePackageInfo() {
    StringBuilder referencePackageInfo = new StringBuilder();

    NodeList packagedElements = doc.getElementsByTagName("packagedElement");
    for (int i = 0; i < packagedElements.getLength(); i++) {
      Node node = packagedElements.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        String xmiType = element.getAttribute("xmi:type");
        String name = element.getAttribute("name");

        if ("uml:Package".equals(xmiType) && "Referencetype".equals(name)) {
          referencePackageInfo.append("Package (Referencetype) Name: ").append(name).append("\n");

          // Get child elements under that Package (e.g., <packagedElement xmi:type="uml:DataType">)
          NodeList subNodes = element.getElementsByTagName("packagedElement");
          for (int j = 0; j < subNodes.getLength(); j++) {
            Node subNode = subNodes.item(j);
            // Check if the parent node is the same element
            if (subNode.getNodeType() == Node.ELEMENT_NODE
                && subNode.getParentNode().isSameNode(node)) {
              Element subElem = (Element) subNode;
              String subElemName = subElem.getAttribute("name");
              referencePackageInfo.append("  DataType: ").append(subElemName).append("\n");
            }
          }
          referencePackageInfo.append("\n");
        }
      }
    }

    return referencePackageInfo.toString();
  }

  @Override
  public String toString() {
    return parseClassInfo() + "\n" + parseAssociationInfo() + "\n" + parsePrimitivePackageInfo()
        + "\n" + parseReferencePackageInfo();
  }


}
