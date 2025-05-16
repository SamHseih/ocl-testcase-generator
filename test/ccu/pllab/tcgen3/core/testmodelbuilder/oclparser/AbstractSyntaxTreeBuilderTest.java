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

        assertNotNull(scope, "Symbol table (scope) ���Ӥ��ର null");
        assertNotNull(ast, "AST ���Ӥ��ର null");

        // �i�i�@�B�ˬd AST �� Scope ���e
        System.out.println("Global Scope: " + scope.getName());
        System.out.println(Utils.toString(scope)); 
    }

}
