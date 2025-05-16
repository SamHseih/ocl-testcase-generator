package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ccu.pllab.tcgen3.core.testmodelbuilder.AbstractSyntaxTreeBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.symboltable.Utils;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

class AbstractSyntaxTreeBuilderTest {
	 private String[] args= {"F:\\papyrus\\WorkSpace","Cube"};

	@Test
    public void testInitializeFromArgs() {
		AbstractSyntaxTreeBuilder builder = new AbstractSyntaxTreeBuilder(args);
        builder.initializeFromArgs();

        Scope scope = builder.getGlobalScope();
        ASTree ast = builder.getAST();

        assertNotNull(scope, "Symbol table (scope) 應該不能為 null");
        assertNotNull(ast, "AST 應該不能為 null");

        // 可進一步檢查 AST 或 Scope 內容
        System.out.println("Global Scope: " + scope.getName());
        System.out.println(Utils.toString(scope)); 
    }

}
