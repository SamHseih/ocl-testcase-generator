package ccu.pllab.tcgen3.core.testscriptgen;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

  /** Represents a parsed value with its Java code and type information. */
  private static class ValueRep {
    String code; // Java code representation of the value
    String type; // Base type (e.g., "int", "double", "String", etc.), or null for composite
    boolean isArray;

    ValueRep(String code, String type, boolean isArray) {
      this.code = code;
      this.type = type;
      this.isArray = isArray;
    }
  }

  /**
   * Parses a value given as string into a ValueRep containing the Java code snippet and type. This
   * handles primitives, booleans, strings/chars, and arrays.
   */
  public static ValueRep parseValue(String valStr) {
    String trimmed = valStr.trim();
    // Boolean values
    if (trimmed.equalsIgnoreCase("true") || trimmed.equalsIgnoreCase("false")) {
      return new ValueRep(trimmed.toLowerCase(), "boolean", false);
    }
    // Quoted string or character
    if ((trimmed.startsWith("\"") && trimmed.endsWith("\""))
        || (trimmed.startsWith("'") && trimmed.endsWith("'"))) {
      // Remove surrounding quotes
      String content = trimmed.substring(1, trimmed.length() - 1);
      if (trimmed.startsWith("\"")) {
        // It's a string literal
        String escaped = content.replace("\"", "\\\""); // escape quotes if any
        return new ValueRep("\"" + escaped + "\"", "String", false);
      } else {
        // It's a character literal (or a multi-char in single quotes)
        if (content.length() == 1) {
          return new ValueRep("'" + content + "'", "char", false);
        } else {
          // Treat multi-character in single quotes as a string for safety
          String escaped = content.replace("\"", "\\\"");
          return new ValueRep("\"" + escaped + "\"", "String", false);
        }
      }
    }
    // Single unquoted letter (likely a char)
    if (trimmed.length() == 1 && Character.isLetter(trimmed.charAt(0))) {
      return new ValueRep("'" + trimmed + "'", "char", false);
    }
    // Numeric values (integer or floating-point)
    try {
      // Try parsing as integer
      int intVal = Integer.parseInt(trimmed);
      return new ValueRep(String.valueOf(intVal), "int", false);
    } catch (NumberFormatException e) {
      // Not an int
    }
    try {
      double dVal = Double.parseDouble(trimmed);
      // Use 'd' suffix for float if needed, but here assume double for any with a decimal point
      return new ValueRep(String.valueOf(dVal), "double", false);
    } catch (NumberFormatException e) {
      // Not a basic numeric type
    }
    // Array values (starts with '[' and ends with ']')
    if (trimmed.startsWith("[") && trimmed.endsWith("]")) {
      return parseArray(trimmed);
    }
    // Fallback: treat as object identifier or unknown type
    return new ValueRep(trimmed, null, false);
  }

  /**
   * Parses an array value given in bracket notation into a ValueRep with the proper Java array
   * initializer. Supports nested arrays (multi-dimensional).
   */
  private static ValueRep parseArray(String arrayStr) {
    // Remove outer [ ] and split top-level elements by commas (respecting nested brackets)
    String inner = arrayStr.trim().substring(1, arrayStr.length() - 1);
    List<String> elements = new ArrayList<>();
    int depth = 0;
    StringBuilder current = new StringBuilder();
    for (char ch : inner.toCharArray()) {
      if (ch == '[') {
        depth++;
        current.append(ch);
      } else if (ch == ']') {
        depth--;
        current.append(ch);
      } else if (ch == ',' && depth == 0) {
        // Top-level separator
        elements.add(current.toString().trim());
        current.setLength(0);
      } else {
        current.append(ch);
      }
    }
    if (current.length() > 0) {
      elements.add(current.toString().trim());
    }

    // Parse each element recursively
    List<ValueRep> childValues = new ArrayList<>();
    for (String elem : elements) {
      childValues.add(parseValue(elem));
    }
    // Determine base type of children
    String baseType = childValues.isEmpty() ? "Object" : childValues.get(0).type;
    boolean uniform = true;
    for (ValueRep child : childValues) {
      if (baseType == null || !baseType.equals(child.type)) {
        // Different types found, use Object as base type (heterogeneous array)
        uniform = false;
        baseType = "Object";
        break;
      }
    }
    // Construct array code with "new <baseType>[] {...}" syntax
    StringBuilder codeBuilder = new StringBuilder();
    codeBuilder.append("new ").append(baseType);
    codeBuilder.append("[]"); // one dimension for this array level
    codeBuilder.append("{");
    for (int i = 0; i < childValues.size(); i++) {
      ValueRep child = childValues.get(i);
      // If child is an array, its code already includes its own "new ..." initializer
      codeBuilder.append(child.code);
      if (i < childValues.size() - 1) {
        codeBuilder.append(", ");
      }
    }
    codeBuilder.append("}");
    // Increase the type's bracket level by one for this array
    String typeName = (baseType != null ? baseType : "Object") + "[]";
    return new ValueRep(codeBuilder.toString(), baseType, true);
  }
}
