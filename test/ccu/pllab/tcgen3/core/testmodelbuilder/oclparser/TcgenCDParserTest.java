package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.TcgenCDparser;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

class TcgenCDParserTest {

	@Test
	void TcgenCDparser_shouldThrowException_whenNullPassed() {
	    // Arrange + Act + Assert
	    assertThrows(IllegalArgumentException.class, () -> {
	        TcgenCDparser cdParser = new TcgenCDparser(null);
	        cdParser.parse();
	    });
	}
	
	@Test
	void TcgenCDparser_shouldParseSuccessfully_withValidInput() {
	    // Arrange
		Path umlPath = Path.of(".\\spec\\Cube.uml");
	    TcgenCDparser cdParser = new TcgenCDparser(umlPath);

	    // Act
	    Scope scope = cdParser.parse();

	    // Assert
	    assertNotNull(scope);
	    assertNotNull(cdParser.getSymboltable());
	}

}
