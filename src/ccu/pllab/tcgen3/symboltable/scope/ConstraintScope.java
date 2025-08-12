package ccu.pllab.tcgen3.symboltable.scope;

public class ConstraintScope extends BaseScope {
  private String keyword;
  private String className;
  private String methodName;

  public ConstraintScope(Scope parent, String keyword, String className, String methodName) {
    super(parent);
    this.keyword = keyword;
    this.className = className;
    this.methodName = methodName;
  }

  public ConstraintScope(Scope parent, String name, String className) {
    super(parent);
    this.keyword = name;
    this.className = className;
  }

  public String getName() {
    return keyword;
  }

  public String getClassName() {
    return className;
  }

}
