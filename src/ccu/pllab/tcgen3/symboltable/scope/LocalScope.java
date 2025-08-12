package ccu.pllab.tcgen3.symboltable.scope;

/**
 * A scope object typically associated with {...} code blocks In OCL Like Let Scope
 */
public class LocalScope extends BaseScope {
  private String scopeName;

  public LocalScope(Scope enclosingScope, String scopeName) {
    super(enclosingScope);
    this.scopeName = scopeName;
  }

  @Override
  public String getName() {
    return "LocalScope  " + scopeName;
  }



}
