package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class CollectingSyntaxErrorListener extends BaseErrorListener {
	public static boolean hasError = false;
	public static List<String> errors =new ArrayList<>();
   
    @Override
    public void syntaxError(Recognizer<?,?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
    	hasError = true;
    	List<String>stack = ((Parser)recognizer).getRuleInvocationStack();
    	Collections.reverse(stack);
    	String tokenText = ((Token)offendingSymbol).getText();
    	
        errors.add("Syntax Error Detected:");
        errors.add("Token: \"" + tokenText + "\"");
        errors.add("(Line " + line + ", Column " + (charPositionInLine + 1)+")");
        errors.add("Message: " + msg);
        errors.add("Rule Invocation Stack (innermost first): " + stack);
        errors.add("Hint: Please check for missing brackets, separators, or incorrect token order before this point.");

    }
    
    public static void reset() {
    	hasError = false;
    	errors = new ArrayList<>();
    }
}
