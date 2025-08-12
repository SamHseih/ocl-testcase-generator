package ccu.pllab.tcgen3.symboltable.scope;

public class PackageScope extends BaseScope {
  // PackageScope is a scope that represents a package in the symbol table
  // It is used to store the symbols defined in the package
  // It extends the BaseScope class, which provides the basic functionality for a scope

  private String packagename;

  public PackageScope(Scope parent, String name) {
    super(parent);
    this.packagename = name;
  }

  public String getName() {
    return packagename;
  }

  @Override
  public String toString() {
    return "PackageScope: " + packagename;
  }

}
