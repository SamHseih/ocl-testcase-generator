// Generated from
// C:/Users/Sam/Desktop/workspace/2024_eclipcse_myReasearch/workspace20241216/workspace/tcgen3/src/ccu/pllab/tcgen3/core/testmodelbuilder/oclparser/Ocl.g4
// by ANTLR 4.13.2

package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue",
    "this-escape"})
public class OclParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7,
      T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15,
      T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22,
      T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29,
      T__29 = 30, T__30 = 31, T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36,
      T__36 = 37, T__37 = 38, T__38 = 39, T__39 = 40, T__40 = 41, T__41 = 42, T__42 = 43,
      T__43 = 44, T__44 = 45, T__45 = 46, T__46 = 47, T__47 = 48, T__48 = 49, T__49 = 50,
      T__50 = 51, T__51 = 52, BRACKETS = 53, SELF = 54, RESULT = 55, DOT = 56, ARROW = 57, ID = 58,
      INTEGER = 59, STRING_LITERAL = 60, LINE_COMMENT = 61, PARA_COMMENT = 62, WHITESPACE = 63;
  public static final int RULE_packageDeclarationCS = 0, RULE_contextDecl = 1,
      RULE_classifierContextDecl = 2, RULE_operationContextDecl = 3, RULE_context = 4,
      RULE_variableDecls = 5, RULE_variableDecl = 6, RULE_pathNameCS = 7, RULE_type = 8,
      RULE_basetype = 9, RULE_arrayType = 10, RULE_arrayListType = 11, RULE_primitiveType = 12,
      RULE_collectionTypeIdentifierCS = 13, RULE_userClassType = 14, RULE_oclExpressionCS = 15,
      RULE_expression = 16, RULE_logicalExpression = 17, RULE_relationalExpression = 18,
      RULE_additiveExpression = 19, RULE_multiplicativeExpression = 20, RULE_unaryExpression = 21,
      RULE_postfixExpression = 22, RULE_primaryExpression = 23, RULE_ifExpCS = 24,
      RULE_letExprCS = 25, RULE_variableExpCS = 26, RULE_literalExpCS = 27,
      RULE_arrayLiteralExpCS = 28, RULE_arrayListLiteralExpCS = 29, RULE_arrayLiteralPartsCS = 30,
      RULE_collectionLiteralExpCS = 31, RULE_collectionLiteralPartsCS = 32,
      RULE_collectionitem = 33, RULE_collectionRangeCS = 34, RULE_primitiveLiteralExpCS = 35,
      RULE_integerLiteralExpCS = 36, RULE_realLiteralExpCS = 37, RULE_stringLiteralExpCS = 38,
      RULE_booleanLiteralExpCS = 39, RULE_callExpCS = 40, RULE_featureCallExpCS = 41,
      RULE_propertyCallExpCS = 42, RULE_operationCallExpCS = 43, RULE_argumentsCS = 44,
      RULE_arrayAccessCS = 45, RULE_indexExpCS = 46, RULE_loopExpCS = 47, RULE_iterateExpCS = 48,
      RULE_logicalOperator = 49, RULE_relationalOperator = 50, RULE_additiveOperator = 51,
      RULE_multiplicativeOperator = 52, RULE_unaryOperator = 53, RULE_isMarkedPreCS = 54;

  private static String[] makeRuleNames() {
    return new String[] {"packageDeclarationCS", "contextDecl", "classifierContextDecl",
        "operationContextDecl", "context", "variableDecls", "variableDecl", "pathNameCS", "type",
        "basetype", "arrayType", "arrayListType", "primitiveType", "collectionTypeIdentifierCS",
        "userClassType", "oclExpressionCS", "expression", "logicalExpression",
        "relationalExpression", "additiveExpression", "multiplicativeExpression", "unaryExpression",
        "postfixExpression", "primaryExpression", "ifExpCS", "letExprCS", "variableExpCS",
        "literalExpCS", "arrayLiteralExpCS", "arrayListLiteralExpCS", "arrayLiteralPartsCS",
        "collectionLiteralExpCS", "collectionLiteralPartsCS", "collectionitem", "collectionRangeCS",
        "primitiveLiteralExpCS", "integerLiteralExpCS", "realLiteralExpCS", "stringLiteralExpCS",
        "booleanLiteralExpCS", "callExpCS", "featureCallExpCS", "propertyCallExpCS",
        "operationCallExpCS", "argumentsCS", "arrayAccessCS", "indexExpCS", "loopExpCS",
        "iterateExpCS", "logicalOperator", "relationalOperator", "additiveOperator",
        "multiplicativeOperator", "unaryOperator", "isMarkedPreCS"};
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {null, "'package'", "'endpackage'", "'context'", "'::'", "'('", "')'",
        "':'", "'inv'", "'pre'", "'post'", "','", "'='", "'['", "']'", "'ArrayList'", "'<'", "'>'",
        "'int'", "'String'", "'Boolean'", "'Set'", "'Bag'", "'Sequence'", "'OrderedSet'",
        "'Collection'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'in'", "'{'", "'}'",
        "'..'", "'true'", "'false'", "'iterate'", "';'", "'|'", "'and'", "'or'", "'xor'",
        "'implies'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'@'", "'[]'",
        "'self'", "'result'", "'.'", "'->'"};
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, "BRACKETS", "SELF",
        "RESULT", "DOT", "ARROW", "ID", "INTEGER", "STRING_LITERAL", "LINE_COMMENT", "PARA_COMMENT",
        "WHITESPACE"};
  }

  private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;
  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override

  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }

  @Override
  public String getGrammarFileName() {
    return "Ocl.g4";
  }

  @Override
  public String[] getRuleNames() {
    return ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return _serializedATN;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public OclParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PackageDeclarationCSContext extends ParserRuleContext {
    public PathNameCSContext pathNameCS() {
      return getRuleContext(PathNameCSContext.class, 0);
    }

    public List<ContextDeclContext> contextDecl() {
      return getRuleContexts(ContextDeclContext.class);
    }

    public ContextDeclContext contextDecl(int i) {
      return getRuleContext(ContextDeclContext.class, i);
    }

    public PackageDeclarationCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_packageDeclarationCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterPackageDeclarationCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitPackageDeclarationCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitPackageDeclarationCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final PackageDeclarationCSContext packageDeclarationCS() throws RecognitionException {
    PackageDeclarationCSContext _localctx = new PackageDeclarationCSContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_packageDeclarationCS);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(110);
        match(T__0);
        setState(111);
        pathNameCS();
        setState(115);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == T__2) {
          {
            {
              setState(112);
              contextDecl();
            }
          }
          setState(117);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(118);
        match(T__1);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ContextDeclContext extends ParserRuleContext {
    public ClassifierContextDeclContext classifierContextDecl() {
      return getRuleContext(ClassifierContextDeclContext.class, 0);
    }

    public List<ContextContext> context() {
      return getRuleContexts(ContextContext.class);
    }

    public ContextContext context(int i) {
      return getRuleContext(ContextContext.class, i);
    }

    public OperationContextDeclContext operationContextDecl() {
      return getRuleContext(OperationContextDeclContext.class, 0);
    }

    public ContextDeclContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_contextDecl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterContextDecl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitContextDecl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitContextDecl(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ContextDeclContext contextDecl() throws RecognitionException {
    ContextDeclContext _localctx = new ContextDeclContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_contextDecl);
    int _la;
    try {
      setState(134);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1); {
          setState(120);
          classifierContextDecl();
          setState(124);
          _errHandler.sync(this);
          _la = _input.LA(1);
          while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) {
            {
              {
                setState(121);
                context();
              }
            }
            setState(126);
            _errHandler.sync(this);
            _la = _input.LA(1);
          }
        }
          break;
        case 2:
          enterOuterAlt(_localctx, 2); {
          setState(127);
          operationContextDecl();
          setState(131);
          _errHandler.sync(this);
          _la = _input.LA(1);
          while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) {
            {
              {
                setState(128);
                context();
              }
            }
            setState(133);
            _errHandler.sync(this);
            _la = _input.LA(1);
          }
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ClassifierContextDeclContext extends ParserRuleContext {
    public PathNameCSContext pathNameCS() {
      return getRuleContext(PathNameCSContext.class, 0);
    }

    public ClassifierContextDeclContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_classifierContextDecl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterClassifierContextDecl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitClassifierContextDecl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitClassifierContextDecl(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ClassifierContextDeclContext classifierContextDecl() throws RecognitionException {
    ClassifierContextDeclContext _localctx = new ClassifierContextDeclContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_classifierContextDecl);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(136);
        match(T__2);
        setState(137);
        pathNameCS();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class OperationContextDeclContext extends ParserRuleContext {
    public OperationContextDeclContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_operationContextDecl;
    }

    public OperationContextDeclContext() {}

    public void copyFrom(OperationContextDeclContext ctx) {
      super.copyFrom(ctx);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class NoReturnTypeAltContext extends OperationContextDeclContext {
    public PathNameCSContext pathNameCS() {
      return getRuleContext(PathNameCSContext.class, 0);
    }

    public TerminalNode ID() {
      return getToken(OclParser.ID, 0);
    }

    public VariableDeclsContext variableDecls() {
      return getRuleContext(VariableDeclsContext.class, 0);
    }

    public NoReturnTypeAltContext(OperationContextDeclContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterNoReturnTypeAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitNoReturnTypeAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitNoReturnTypeAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class HasRturnTypeAltContext extends OperationContextDeclContext {
    public PathNameCSContext pathNameCS() {
      return getRuleContext(PathNameCSContext.class, 0);
    }

    public TerminalNode ID() {
      return getToken(OclParser.ID, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public VariableDeclsContext variableDecls() {
      return getRuleContext(VariableDeclsContext.class, 0);
    }

    public HasRturnTypeAltContext(OperationContextDeclContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterHasRturnTypeAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitHasRturnTypeAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitHasRturnTypeAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final OperationContextDeclContext operationContextDecl() throws RecognitionException {
    OperationContextDeclContext _localctx = new OperationContextDeclContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_operationContextDecl);
    int _la;
    try {
      setState(161);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
        case 1:
          _localctx = new NoReturnTypeAltContext(_localctx);
          enterOuterAlt(_localctx, 1); {
          setState(139);
          match(T__2);
          setState(140);
          pathNameCS();
          setState(141);
          match(T__3);
          setState(142);
          match(ID);
          setState(143);
          match(T__4);
          setState(145);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376216723456L) != 0)) {
            {
              setState(144);
              variableDecls();
            }
          }

          setState(147);
          match(T__5);
        }
          break;
        case 2:
          _localctx = new HasRturnTypeAltContext(_localctx);
          enterOuterAlt(_localctx, 2); {
          setState(149);
          match(T__2);
          setState(150);
          pathNameCS();
          setState(151);
          match(T__3);
          setState(152);
          match(ID);
          setState(153);
          match(T__4);
          setState(155);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376216723456L) != 0)) {
            {
              setState(154);
              variableDecls();
            }
          }

          setState(157);
          match(T__5);
          setState(158);
          match(T__6);
          setState(159);
          type();
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ContextContext extends ParserRuleContext {
    public OclExpressionCSContext oclExpressionCS() {
      return getRuleContext(OclExpressionCSContext.class, 0);
    }

    public TerminalNode ID() {
      return getToken(OclParser.ID, 0);
    }

    public ContextContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_context;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterContext(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitContext(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitContext(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ContextContext context() throws RecognitionException {
    ContextContext _localctx = new ContextContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_context);
    int _la;
    try {
      setState(181);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__7:
          enterOuterAlt(_localctx, 1); {
          setState(163);
          match(T__7);
          setState(165);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if (_la == ID) {
            {
              setState(164);
              match(ID);
            }
          }

          setState(167);
          match(T__6);
          setState(168);
          oclExpressionCS();
        }
          break;
        case T__8:
          enterOuterAlt(_localctx, 2); {
          setState(169);
          match(T__8);
          setState(171);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if (_la == ID) {
            {
              setState(170);
              match(ID);
            }
          }

          setState(173);
          match(T__6);
          setState(174);
          oclExpressionCS();
        }
          break;
        case T__9:
          enterOuterAlt(_localctx, 3); {
          setState(175);
          match(T__9);
          setState(177);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if (_la == ID) {
            {
              setState(176);
              match(ID);
            }
          }

          setState(179);
          match(T__6);
          setState(180);
          oclExpressionCS();
        }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableDeclsContext extends ParserRuleContext {
    public List<VariableDeclContext> variableDecl() {
      return getRuleContexts(VariableDeclContext.class);
    }

    public VariableDeclContext variableDecl(int i) {
      return getRuleContext(VariableDeclContext.class, i);
    }

    public VariableDeclsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableDecls;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterVariableDecls(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitVariableDecls(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitVariableDecls(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final VariableDeclsContext variableDecls() throws RecognitionException {
    VariableDeclsContext _localctx = new VariableDeclsContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_variableDecls);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(183);
        variableDecl();
        setState(188);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == T__10) {
          {
            {
              setState(184);
              match(T__10);
              setState(185);
              variableDecl();
            }
          }
          setState(190);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableDeclContext extends ParserRuleContext {
    public VariableDeclContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableDecl;
    }

    public VariableDeclContext() {}

    public void copyFrom(VariableDeclContext ctx) {
      super.copyFrom(ctx);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class VariableDeclAltContext extends VariableDeclContext {
    public TerminalNode ID() {
      return getToken(OclParser.ID, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public OclExpressionCSContext oclExpressionCS() {
      return getRuleContext(OclExpressionCSContext.class, 0);
    }

    public VariableDeclAltContext(VariableDeclContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterVariableDeclAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitVariableDeclAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitVariableDeclAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class CollectionDeclAltContext extends VariableDeclContext {
    public CollectionTypeIdentifierCSContext collectionTypeIdentifierCS() {
      return getRuleContext(CollectionTypeIdentifierCSContext.class, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public CollectionDeclAltContext(VariableDeclContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterCollectionDeclAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitCollectionDeclAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitCollectionDeclAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final VariableDeclContext variableDecl() throws RecognitionException {
    VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_variableDecl);
    int _la;
    try {
      setState(203);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case ID:
          _localctx = new VariableDeclAltContext(_localctx);
          enterOuterAlt(_localctx, 1); {
          setState(191);
          match(ID);
          setState(192);
          match(T__6);
          setState(193);
          type();
          setState(196);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if (_la == T__11) {
            {
              setState(194);
              match(T__11);
              setState(195);
              oclExpressionCS();
            }
          }

        }
          break;
        case T__20:
        case T__21:
        case T__22:
        case T__23:
        case T__24:
          _localctx = new CollectionDeclAltContext(_localctx);
          enterOuterAlt(_localctx, 2); {
          setState(198);
          collectionTypeIdentifierCS();
          setState(199);
          match(T__4);
          setState(200);
          type();
          setState(201);
          match(T__5);
        }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PathNameCSContext extends ParserRuleContext {
    public List<TerminalNode> ID() {
      return getTokens(OclParser.ID);
    }

    public TerminalNode ID(int i) {
      return getToken(OclParser.ID, i);
    }

    public PathNameCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_pathNameCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterPathNameCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitPathNameCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitPathNameCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final PathNameCSContext pathNameCS() throws RecognitionException {
    PathNameCSContext _localctx = new PathNameCSContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_pathNameCS);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(205);
        match(ID);
        setState(210);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(206);
                match(T__3);
                setState(207);
                match(ID);
              }
            }
          }
          setState(212);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeContext extends ParserRuleContext {
    public ArrayTypeContext arrayType() {
      return getRuleContext(ArrayTypeContext.class, 0);
    }

    public ArrayListTypeContext arrayListType() {
      return getRuleContext(ArrayListTypeContext.class, 0);
    }

    public BasetypeContext basetype() {
      return getRuleContext(BasetypeContext.class, 0);
    }

    public TypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_type;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitType(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final TypeContext type() throws RecognitionException {
    TypeContext _localctx = new TypeContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_type);
    try {
      setState(216);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1); {
          setState(213);
          arrayType();
        }
          break;
        case 2:
          enterOuterAlt(_localctx, 2); {
          setState(214);
          arrayListType();
        }
          break;
        case 3:
          enterOuterAlt(_localctx, 3); {
          setState(215);
          basetype();
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BasetypeContext extends ParserRuleContext {
    public PrimitiveTypeContext primitiveType() {
      return getRuleContext(PrimitiveTypeContext.class, 0);
    }

    public UserClassTypeContext userClassType() {
      return getRuleContext(UserClassTypeContext.class, 0);
    }

    public CollectionTypeIdentifierCSContext collectionTypeIdentifierCS() {
      return getRuleContext(CollectionTypeIdentifierCSContext.class, 0);
    }

    public BasetypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_basetype;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterBasetype(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitBasetype(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitBasetype(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final BasetypeContext basetype() throws RecognitionException {
    BasetypeContext _localctx = new BasetypeContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_basetype);
    try {
      setState(221);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__17:
        case T__18:
        case T__19:
          enterOuterAlt(_localctx, 1); {
          setState(218);
          primitiveType();
        }
          break;
        case ID:
          enterOuterAlt(_localctx, 2); {
          setState(219);
          userClassType();
        }
          break;
        case T__20:
        case T__21:
        case T__22:
        case T__23:
        case T__24:
          enterOuterAlt(_localctx, 3); {
          setState(220);
          collectionTypeIdentifierCS();
        }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrayTypeContext extends ParserRuleContext {
    public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayType;
    }

    public ArrayTypeContext() {}

    public void copyFrom(ArrayTypeContext ctx) {
      super.copyFrom(ctx);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class NonSizeDeclArrayContext extends ArrayTypeContext {
    public BasetypeContext basetype() {
      return getRuleContext(BasetypeContext.class, 0);
    }

    public List<TerminalNode> BRACKETS() {
      return getTokens(OclParser.BRACKETS);
    }

    public TerminalNode BRACKETS(int i) {
      return getToken(OclParser.BRACKETS, i);
    }

    public NonSizeDeclArrayContext(ArrayTypeContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterNonSizeDeclArray(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitNonSizeDeclArray(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitNonSizeDeclArray(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class DynamicFixSizeArrayContext extends ArrayTypeContext {
    public BasetypeContext basetype() {
      return getRuleContext(BasetypeContext.class, 0);
    }

    public List<TerminalNode> ID() {
      return getTokens(OclParser.ID);
    }

    public TerminalNode ID(int i) {
      return getToken(OclParser.ID, i);
    }

    public DynamicFixSizeArrayContext(ArrayTypeContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterDynamicFixSizeArray(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitDynamicFixSizeArray(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitDynamicFixSizeArray(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class StaticFixSizeArrayContext extends ArrayTypeContext {
    public BasetypeContext basetype() {
      return getRuleContext(BasetypeContext.class, 0);
    }

    public List<TerminalNode> INTEGER() {
      return getTokens(OclParser.INTEGER);
    }

    public TerminalNode INTEGER(int i) {
      return getToken(OclParser.INTEGER, i);
    }

    public StaticFixSizeArrayContext(ArrayTypeContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterStaticFixSizeArray(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitStaticFixSizeArray(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitStaticFixSizeArray(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ArrayTypeContext arrayType() throws RecognitionException {
    ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_arrayType);
    int _la;
    try {
      setState(245);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
        case 1:
          _localctx = new NonSizeDeclArrayContext(_localctx);
          enterOuterAlt(_localctx, 1); {
          setState(223);
          basetype();
          setState(225);
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
              {
                setState(224);
                match(BRACKETS);
              }
            }
            setState(227);
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while (_la == BRACKETS);
        }
          break;
        case 2:
          _localctx = new StaticFixSizeArrayContext(_localctx);
          enterOuterAlt(_localctx, 2); {
          setState(229);
          basetype();
          setState(233);
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
              {
                setState(230);
                match(T__12);
                setState(231);
                match(INTEGER);
                setState(232);
                match(T__13);
              }
            }
            setState(235);
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while (_la == T__12);
        }
          break;
        case 3:
          _localctx = new DynamicFixSizeArrayContext(_localctx);
          enterOuterAlt(_localctx, 3); {
          setState(237);
          basetype();
          setState(241);
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
              {
                setState(238);
                match(T__12);
                setState(239);
                match(ID);
                setState(240);
                match(T__13);
              }
            }
            setState(243);
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while (_la == T__12);
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrayListTypeContext extends ParserRuleContext {
    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public ArrayListTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayListType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterArrayListType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitArrayListType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitArrayListType(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ArrayListTypeContext arrayListType() throws RecognitionException {
    ArrayListTypeContext _localctx = new ArrayListTypeContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_arrayListType);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(247);
        match(T__14);
        setState(248);
        match(T__15);
        setState(249);
        type();
        setState(250);
        match(T__16);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimitiveTypeContext extends ParserRuleContext {
    public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primitiveType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterPrimitiveType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitPrimitiveType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitPrimitiveType(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final PrimitiveTypeContext primitiveType() throws RecognitionException {
    PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_primitiveType);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(252);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF)
            matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CollectionTypeIdentifierCSContext extends ParserRuleContext {
    public CollectionTypeIdentifierCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_collectionTypeIdentifierCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterCollectionTypeIdentifierCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitCollectionTypeIdentifierCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitCollectionTypeIdentifierCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final CollectionTypeIdentifierCSContext collectionTypeIdentifierCS()
      throws RecognitionException {
    CollectionTypeIdentifierCSContext _localctx =
        new CollectionTypeIdentifierCSContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_collectionTypeIdentifierCS);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(254);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 65011712L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF)
            matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UserClassTypeContext extends ParserRuleContext {
    public TerminalNode ID() {
      return getToken(OclParser.ID, 0);
    }

    public UserClassTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_userClassType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterUserClassType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitUserClassType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitUserClassType(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final UserClassTypeContext userClassType() throws RecognitionException {
    UserClassTypeContext _localctx = new UserClassTypeContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_userClassType);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(256);
        match(ID);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class OclExpressionCSContext extends ParserRuleContext {
    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public OclExpressionCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_oclExpressionCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterOclExpressionCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitOclExpressionCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitOclExpressionCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final OclExpressionCSContext oclExpressionCS() throws RecognitionException {
    OclExpressionCSContext _localctx = new OclExpressionCSContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_oclExpressionCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(258);
        expression();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExpressionContext extends ParserRuleContext {
    public LogicalExpressionContext logicalExpression() {
      return getRuleContext(LogicalExpressionContext.class, 0);
    }

    public ExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitExpression(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ExpressionContext expression() throws RecognitionException {
    ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_expression);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(260);
        logicalExpression();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LogicalExpressionContext extends ParserRuleContext {
    public List<RelationalExpressionContext> relationalExpression() {
      return getRuleContexts(RelationalExpressionContext.class);
    }

    public RelationalExpressionContext relationalExpression(int i) {
      return getRuleContext(RelationalExpressionContext.class, i);
    }

    public List<LogicalOperatorContext> logicalOperator() {
      return getRuleContexts(LogicalOperatorContext.class);
    }

    public LogicalOperatorContext logicalOperator(int i) {
      return getRuleContext(LogicalOperatorContext.class, i);
    }

    public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_logicalExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterLogicalExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitLogicalExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitLogicalExpression(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final LogicalExpressionContext logicalExpression() throws RecognitionException {
    LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_logicalExpression);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(262);
        relationalExpression();
        setState(268);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 21, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(263);
                logicalOperator();
                setState(264);
                relationalExpression();
              }
            }
          }
          setState(270);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 21, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class RelationalExpressionContext extends ParserRuleContext {
    public List<AdditiveExpressionContext> additiveExpression() {
      return getRuleContexts(AdditiveExpressionContext.class);
    }

    public AdditiveExpressionContext additiveExpression(int i) {
      return getRuleContext(AdditiveExpressionContext.class, i);
    }

    public List<RelationalOperatorContext> relationalOperator() {
      return getRuleContexts(RelationalOperatorContext.class);
    }

    public RelationalOperatorContext relationalOperator(int i) {
      return getRuleContext(RelationalOperatorContext.class, i);
    }

    public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_relationalExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterRelationalExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitRelationalExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitRelationalExpression(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final RelationalExpressionContext relationalExpression() throws RecognitionException {
    RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_relationalExpression);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(271);
        additiveExpression();
        setState(277);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(272);
                relationalOperator();
                setState(273);
                additiveExpression();
              }
            }
          }
          setState(279);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AdditiveExpressionContext extends ParserRuleContext {
    public List<MultiplicativeExpressionContext> multiplicativeExpression() {
      return getRuleContexts(MultiplicativeExpressionContext.class);
    }

    public MultiplicativeExpressionContext multiplicativeExpression(int i) {
      return getRuleContext(MultiplicativeExpressionContext.class, i);
    }

    public List<AdditiveOperatorContext> additiveOperator() {
      return getRuleContexts(AdditiveOperatorContext.class);
    }

    public AdditiveOperatorContext additiveOperator(int i) {
      return getRuleContext(AdditiveOperatorContext.class, i);
    }

    public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_additiveExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterAdditiveExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitAdditiveExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitAdditiveExpression(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
    AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_additiveExpression);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(280);
        multiplicativeExpression();
        setState(286);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 23, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(281);
                additiveOperator();
                setState(282);
                multiplicativeExpression();
              }
            }
          }
          setState(288);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 23, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MultiplicativeExpressionContext extends ParserRuleContext {
    public List<UnaryExpressionContext> unaryExpression() {
      return getRuleContexts(UnaryExpressionContext.class);
    }

    public UnaryExpressionContext unaryExpression(int i) {
      return getRuleContext(UnaryExpressionContext.class, i);
    }

    public List<MultiplicativeOperatorContext> multiplicativeOperator() {
      return getRuleContexts(MultiplicativeOperatorContext.class);
    }

    public MultiplicativeOperatorContext multiplicativeOperator(int i) {
      return getRuleContext(MultiplicativeOperatorContext.class, i);
    }

    public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_multiplicativeExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterMultiplicativeExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitMultiplicativeExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitMultiplicativeExpression(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final MultiplicativeExpressionContext multiplicativeExpression()
      throws RecognitionException {
    MultiplicativeExpressionContext _localctx =
        new MultiplicativeExpressionContext(_ctx, getState());
    enterRule(_localctx, 40, RULE_multiplicativeExpression);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(289);
        unaryExpression();
        setState(295);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 24, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(290);
                multiplicativeOperator();
                setState(291);
                unaryExpression();
              }
            }
          }
          setState(297);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 24, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnaryExpressionContext extends ParserRuleContext {
    public PostfixExpressionContext postfixExpression() {
      return getRuleContext(PostfixExpressionContext.class, 0);
    }

    public UnaryOperatorContext unaryOperator() {
      return getRuleContext(UnaryOperatorContext.class, 0);
    }

    public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unaryExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterUnaryExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitUnaryExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitUnaryExpression(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final UnaryExpressionContext unaryExpression() throws RecognitionException {
    UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
    enterRule(_localctx, 42, RULE_unaryExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(299);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__47 || _la == T__50) {
          {
            setState(298);
            unaryOperator();
          }
        }

        setState(301);
        postfixExpression();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PostfixExpressionContext extends ParserRuleContext {
    public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_postfixExpression;
    }

    public PostfixExpressionContext() {}

    public void copyFrom(PostfixExpressionContext ctx) {
      super.copyFrom(ctx);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class ResultFeatureCallAltContext extends PostfixExpressionContext {
    public TerminalNode RESULT() {
      return getToken(OclParser.RESULT, 0);
    }

    public List<CallExpCSContext> callExpCS() {
      return getRuleContexts(CallExpCSContext.class);
    }

    public CallExpCSContext callExpCS(int i) {
      return getRuleContext(CallExpCSContext.class, i);
    }

    public ResultFeatureCallAltContext(PostfixExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterResultFeatureCallAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitResultFeatureCallAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitResultFeatureCallAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class VarFeatureCallAltContext extends PostfixExpressionContext {
    public VariableExpCSContext variableExpCS() {
      return getRuleContext(VariableExpCSContext.class, 0);
    }

    public List<CallExpCSContext> callExpCS() {
      return getRuleContexts(CallExpCSContext.class);
    }

    public CallExpCSContext callExpCS(int i) {
      return getRuleContext(CallExpCSContext.class, i);
    }

    public VarFeatureCallAltContext(PostfixExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterVarFeatureCallAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitVarFeatureCallAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitVarFeatureCallAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class IterateCallAltContext extends PostfixExpressionContext {
    public LiteralExpCSContext literalExpCS() {
      return getRuleContext(LiteralExpCSContext.class, 0);
    }

    public IsMarkedPreCSContext isMarkedPreCS() {
      return getRuleContext(IsMarkedPreCSContext.class, 0);
    }

    public List<CallExpCSContext> callExpCS() {
      return getRuleContexts(CallExpCSContext.class);
    }

    public CallExpCSContext callExpCS(int i) {
      return getRuleContext(CallExpCSContext.class, i);
    }

    public IterateCallAltContext(PostfixExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterIterateCallAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitIterateCallAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitIterateCallAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class ClassFeatureCallAltContext extends PostfixExpressionContext {
    public TerminalNode SELF() {
      return getToken(OclParser.SELF, 0);
    }

    public IsMarkedPreCSContext isMarkedPreCS() {
      return getRuleContext(IsMarkedPreCSContext.class, 0);
    }

    public List<CallExpCSContext> callExpCS() {
      return getRuleContexts(CallExpCSContext.class);
    }

    public CallExpCSContext callExpCS(int i) {
      return getRuleContext(CallExpCSContext.class, i);
    }

    public ClassFeatureCallAltContext(PostfixExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterClassFeatureCallAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitClassFeatureCallAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitClassFeatureCallAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class ResultArrayAccessAltContext extends PostfixExpressionContext {
    public TerminalNode RESULT() {
      return getToken(OclParser.RESULT, 0);
    }

    public List<IndexExpCSContext> indexExpCS() {
      return getRuleContexts(IndexExpCSContext.class);
    }

    public IndexExpCSContext indexExpCS(int i) {
      return getRuleContext(IndexExpCSContext.class, i);
    }

    public ResultArrayAccessAltContext(PostfixExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterResultArrayAccessAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitResultArrayAccessAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitResultArrayAccessAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class NonCallExpContext extends PostfixExpressionContext {
    public PrimaryExpressionContext primaryExpression() {
      return getRuleContext(PrimaryExpressionContext.class, 0);
    }

    public NonCallExpContext(PostfixExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterNonCallExp(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitNonCallExp(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitNonCallExp(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class ImpliciteOpCallAltContext extends PostfixExpressionContext {
    public CallExpCSContext callExpCS() {
      return getRuleContext(CallExpCSContext.class, 0);
    }

    public ImpliciteOpCallAltContext(PostfixExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterImpliciteOpCallAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitImpliciteOpCallAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitImpliciteOpCallAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class VarArrayAccessAltContext extends PostfixExpressionContext {
    public VariableExpCSContext variableExpCS() {
      return getRuleContext(VariableExpCSContext.class, 0);
    }

    public List<IndexExpCSContext> indexExpCS() {
      return getRuleContexts(IndexExpCSContext.class);
    }

    public IndexExpCSContext indexExpCS(int i) {
      return getRuleContext(IndexExpCSContext.class, i);
    }

    public VarArrayAccessAltContext(PostfixExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterVarArrayAccessAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitVarArrayAccessAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitVarArrayAccessAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }
  @SuppressWarnings("CheckReturnValue")
  public static class ClassArrayAccessAltContext extends PostfixExpressionContext {
    public TerminalNode SELF() {
      return getToken(OclParser.SELF, 0);
    }

    public IsMarkedPreCSContext isMarkedPreCS() {
      return getRuleContext(IsMarkedPreCSContext.class, 0);
    }

    public List<IndexExpCSContext> indexExpCS() {
      return getRuleContexts(IndexExpCSContext.class);
    }

    public IndexExpCSContext indexExpCS(int i) {
      return getRuleContext(IndexExpCSContext.class, i);
    }

    public ClassArrayAccessAltContext(PostfixExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterClassArrayAccessAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitClassArrayAccessAlt(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitClassArrayAccessAlt(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final PostfixExpressionContext postfixExpression() throws RecognitionException {
    PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
    enterRule(_localctx, 44, RULE_postfixExpression);
    int _la;
    try {
      setState(357);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 36, _ctx)) {
        case 1:
          _localctx = new NonCallExpContext(_localctx);
          enterOuterAlt(_localctx, 1); {
          setState(303);
          primaryExpression();
        }
          break;
        case 2:
          _localctx = new VarFeatureCallAltContext(_localctx);
          enterOuterAlt(_localctx, 2); {
          setState(304);
          variableExpCS();
          setState(306);
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
              {
                setState(305);
                callExpCS();
              }
            }
            setState(308);
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 504403158265495552L) != 0));
        }
          break;
        case 3:
          _localctx = new IterateCallAltContext(_localctx);
          enterOuterAlt(_localctx, 3); {
          setState(310);
          literalExpCS();
          setState(312);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if (_la == T__51) {
            {
              setState(311);
              isMarkedPreCS();
            }
          }

          setState(315);
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
              {
                setState(314);
                callExpCS();
              }
            }
            setState(317);
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 504403158265495552L) != 0));
        }
          break;
        case 4:
          _localctx = new ImpliciteOpCallAltContext(_localctx);
          enterOuterAlt(_localctx, 4); {
          setState(319);
          callExpCS();
        }
          break;
        case 5:
          _localctx = new ClassFeatureCallAltContext(_localctx);
          enterOuterAlt(_localctx, 5); {
          setState(320);
          match(SELF);
          setState(322);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if (_la == T__51) {
            {
              setState(321);
              isMarkedPreCS();
            }
          }

          setState(325);
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
              {
                setState(324);
                callExpCS();
              }
            }
            setState(327);
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 504403158265495552L) != 0));
        }
          break;
        case 6:
          _localctx = new ResultFeatureCallAltContext(_localctx);
          enterOuterAlt(_localctx, 6); {
          setState(329);
          match(RESULT);
          setState(333);
          _errHandler.sync(this);
          _la = _input.LA(1);
          while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 504403158265495552L) != 0)) {
            {
              {
                setState(330);
                callExpCS();
              }
            }
            setState(335);
            _errHandler.sync(this);
            _la = _input.LA(1);
          }
        }
          break;
        case 7:
          _localctx = new VarArrayAccessAltContext(_localctx);
          enterOuterAlt(_localctx, 7); {
          setState(336);
          variableExpCS();
          setState(338);
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
              {
                setState(337);
                indexExpCS();
              }
            }
            setState(340);
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while (_la == T__12);
        }
          break;
        case 8:
          _localctx = new ClassArrayAccessAltContext(_localctx);
          enterOuterAlt(_localctx, 8); {
          setState(342);
          match(SELF);
          setState(344);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if (_la == T__51) {
            {
              setState(343);
              isMarkedPreCS();
            }
          }

          setState(347);
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
              {
                setState(346);
                indexExpCS();
              }
            }
            setState(349);
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while (_la == T__12);
        }
          break;
        case 9:
          _localctx = new ResultArrayAccessAltContext(_localctx);
          enterOuterAlt(_localctx, 9); {
          setState(351);
          match(RESULT);
          setState(353);
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
              {
                setState(352);
                indexExpCS();
              }
            }
            setState(355);
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while (_la == T__12);
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimaryExpressionContext extends ParserRuleContext {
    public IfExpCSContext ifExpCS() {
      return getRuleContext(IfExpCSContext.class, 0);
    }

    public LetExprCSContext letExprCS() {
      return getRuleContext(LetExprCSContext.class, 0);
    }

    public VariableExpCSContext variableExpCS() {
      return getRuleContext(VariableExpCSContext.class, 0);
    }

    public LiteralExpCSContext literalExpCS() {
      return getRuleContext(LiteralExpCSContext.class, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primaryExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterPrimaryExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitPrimaryExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitPrimaryExpression(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
    PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
    enterRule(_localctx, 46, RULE_primaryExpression);
    try {
      setState(367);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 37, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1); {
          setState(359);
          ifExpCS();
        }
          break;
        case 2:
          enterOuterAlt(_localctx, 2); {
          setState(360);
          letExprCS();
        }
          break;
        case 3:
          enterOuterAlt(_localctx, 3); {
          setState(361);
          variableExpCS();
        }
          break;
        case 4:
          enterOuterAlt(_localctx, 4); {
          setState(362);
          literalExpCS();
        }
          break;
        case 5:
          enterOuterAlt(_localctx, 5); {
          setState(363);
          match(T__4);
          setState(364);
          expression();
          setState(365);
          match(T__5);
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IfExpCSContext extends ParserRuleContext {
    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public IfExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ifExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterIfExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitIfExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitIfExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final IfExpCSContext ifExpCS() throws RecognitionException {
    IfExpCSContext _localctx = new IfExpCSContext(_ctx, getState());
    enterRule(_localctx, 48, RULE_ifExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(369);
        match(T__25);
        setState(370);
        match(T__4);
        setState(371);
        expression();
        setState(372);
        match(T__5);
        setState(373);
        match(T__26);
        setState(374);
        expression();
        setState(375);
        match(T__27);
        setState(376);
        expression();
        setState(377);
        match(T__28);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LetExprCSContext extends ParserRuleContext {
    public VariableDeclsContext variableDecls() {
      return getRuleContext(VariableDeclsContext.class, 0);
    }

    public OclExpressionCSContext oclExpressionCS() {
      return getRuleContext(OclExpressionCSContext.class, 0);
    }

    public LetExprCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_letExprCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterLetExprCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitLetExprCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitLetExprCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final LetExprCSContext letExprCS() throws RecognitionException {
    LetExprCSContext _localctx = new LetExprCSContext(_ctx, getState());
    enterRule(_localctx, 50, RULE_letExprCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(379);
        match(T__29);
        setState(380);
        variableDecls();
        setState(381);
        match(T__30);
        setState(382);
        oclExpressionCS();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableExpCSContext extends ParserRuleContext {
    public TerminalNode ID() {
      return getToken(OclParser.ID, 0);
    }

    public IsMarkedPreCSContext isMarkedPreCS() {
      return getRuleContext(IsMarkedPreCSContext.class, 0);
    }

    public VariableExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterVariableExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitVariableExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitVariableExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final VariableExpCSContext variableExpCS() throws RecognitionException {
    VariableExpCSContext _localctx = new VariableExpCSContext(_ctx, getState());
    enterRule(_localctx, 52, RULE_variableExpCS);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(384);
        match(ID);
        setState(386);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__51) {
          {
            setState(385);
            isMarkedPreCS();
          }
        }

      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LiteralExpCSContext extends ParserRuleContext {
    public ArrayLiteralExpCSContext arrayLiteralExpCS() {
      return getRuleContext(ArrayLiteralExpCSContext.class, 0);
    }

    public ArrayListLiteralExpCSContext arrayListLiteralExpCS() {
      return getRuleContext(ArrayListLiteralExpCSContext.class, 0);
    }

    public CollectionLiteralExpCSContext collectionLiteralExpCS() {
      return getRuleContext(CollectionLiteralExpCSContext.class, 0);
    }

    public PrimitiveLiteralExpCSContext primitiveLiteralExpCS() {
      return getRuleContext(PrimitiveLiteralExpCSContext.class, 0);
    }

    public ArrayLiteralPartsCSContext arrayLiteralPartsCS() {
      return getRuleContext(ArrayLiteralPartsCSContext.class, 0);
    }

    public LiteralExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_literalExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterLiteralExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitLiteralExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitLiteralExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final LiteralExpCSContext literalExpCS() throws RecognitionException {
    LiteralExpCSContext _localctx = new LiteralExpCSContext(_ctx, getState());
    enterRule(_localctx, 54, RULE_literalExpCS);
    try {
      setState(393);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 39, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1); {
          setState(388);
          arrayLiteralExpCS();
        }
          break;
        case 2:
          enterOuterAlt(_localctx, 2); {
          setState(389);
          arrayListLiteralExpCS();
        }
          break;
        case 3:
          enterOuterAlt(_localctx, 3); {
          setState(390);
          collectionLiteralExpCS();
        }
          break;
        case 4:
          enterOuterAlt(_localctx, 4); {
          setState(391);
          primitiveLiteralExpCS();
        }
          break;
        case 5:
          enterOuterAlt(_localctx, 5); {
          setState(392);
          arrayLiteralPartsCS();
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrayLiteralExpCSContext extends ParserRuleContext {
    public ArrayTypeContext arrayType() {
      return getRuleContext(ArrayTypeContext.class, 0);
    }

    public ArrayLiteralPartsCSContext arrayLiteralPartsCS() {
      return getRuleContext(ArrayLiteralPartsCSContext.class, 0);
    }

    public ArrayLiteralExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayLiteralExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterArrayLiteralExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitArrayLiteralExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitArrayLiteralExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ArrayLiteralExpCSContext arrayLiteralExpCS() throws RecognitionException {
    ArrayLiteralExpCSContext _localctx = new ArrayLiteralExpCSContext(_ctx, getState());
    enterRule(_localctx, 56, RULE_arrayLiteralExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(395);
        arrayType();
        setState(396);
        arrayLiteralPartsCS();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrayListLiteralExpCSContext extends ParserRuleContext {
    public ArrayListTypeContext arrayListType() {
      return getRuleContext(ArrayListTypeContext.class, 0);
    }

    public ArrayLiteralPartsCSContext arrayLiteralPartsCS() {
      return getRuleContext(ArrayLiteralPartsCSContext.class, 0);
    }

    public ArrayListLiteralExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayListLiteralExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterArrayListLiteralExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitArrayListLiteralExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitArrayListLiteralExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ArrayListLiteralExpCSContext arrayListLiteralExpCS() throws RecognitionException {
    ArrayListLiteralExpCSContext _localctx = new ArrayListLiteralExpCSContext(_ctx, getState());
    enterRule(_localctx, 58, RULE_arrayListLiteralExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(398);
        arrayListType();
        setState(399);
        arrayLiteralPartsCS();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrayLiteralPartsCSContext extends ParserRuleContext {
    public CollectionitemContext collectionitem() {
      return getRuleContext(CollectionitemContext.class, 0);
    }

    public ArrayLiteralPartsCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayLiteralPartsCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterArrayLiteralPartsCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitArrayLiteralPartsCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitArrayLiteralPartsCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ArrayLiteralPartsCSContext arrayLiteralPartsCS() throws RecognitionException {
    ArrayLiteralPartsCSContext _localctx = new ArrayLiteralPartsCSContext(_ctx, getState());
    enterRule(_localctx, 60, RULE_arrayLiteralPartsCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(401);
        match(T__31);
        setState(402);
        collectionitem();
        setState(403);
        match(T__32);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CollectionLiteralExpCSContext extends ParserRuleContext {
    public BasetypeContext basetype() {
      return getRuleContext(BasetypeContext.class, 0);
    }

    public CollectionLiteralPartsCSContext collectionLiteralPartsCS() {
      return getRuleContext(CollectionLiteralPartsCSContext.class, 0);
    }

    public CollectionLiteralExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_collectionLiteralExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterCollectionLiteralExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitCollectionLiteralExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitCollectionLiteralExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final CollectionLiteralExpCSContext collectionLiteralExpCS() throws RecognitionException {
    CollectionLiteralExpCSContext _localctx = new CollectionLiteralExpCSContext(_ctx, getState());
    enterRule(_localctx, 62, RULE_collectionLiteralExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(405);
        basetype();
        setState(406);
        match(T__31);
        setState(407);
        collectionLiteralPartsCS();
        setState(408);
        match(T__32);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CollectionLiteralPartsCSContext extends ParserRuleContext {
    public CollectionitemContext collectionitem() {
      return getRuleContext(CollectionitemContext.class, 0);
    }

    public CollectionRangeCSContext collectionRangeCS() {
      return getRuleContext(CollectionRangeCSContext.class, 0);
    }

    public CollectionLiteralPartsCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_collectionLiteralPartsCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterCollectionLiteralPartsCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitCollectionLiteralPartsCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitCollectionLiteralPartsCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final CollectionLiteralPartsCSContext collectionLiteralPartsCS()
      throws RecognitionException {
    CollectionLiteralPartsCSContext _localctx =
        new CollectionLiteralPartsCSContext(_ctx, getState());
    enterRule(_localctx, 64, RULE_collectionLiteralPartsCS);
    try {
      setState(412);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 40, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1); {
          setState(410);
          collectionitem();
        }
          break;
        case 2:
          enterOuterAlt(_localctx, 2); {
          setState(411);
          collectionRangeCS();
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CollectionitemContext extends ParserRuleContext {
    public List<LiteralExpCSContext> literalExpCS() {
      return getRuleContexts(LiteralExpCSContext.class);
    }

    public LiteralExpCSContext literalExpCS(int i) {
      return getRuleContext(LiteralExpCSContext.class, i);
    }

    public CollectionitemContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_collectionitem;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterCollectionitem(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitCollectionitem(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitCollectionitem(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final CollectionitemContext collectionitem() throws RecognitionException {
    CollectionitemContext _localctx = new CollectionitemContext(_ctx, getState());
    enterRule(_localctx, 66, RULE_collectionitem);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(414);
        literalExpCS();
        setState(419);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == T__10) {
          {
            {
              setState(415);
              match(T__10);
              setState(416);
              literalExpCS();
            }
          }
          setState(421);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CollectionRangeCSContext extends ParserRuleContext {
    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public CollectionRangeCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_collectionRangeCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterCollectionRangeCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitCollectionRangeCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitCollectionRangeCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final CollectionRangeCSContext collectionRangeCS() throws RecognitionException {
    CollectionRangeCSContext _localctx = new CollectionRangeCSContext(_ctx, getState());
    enterRule(_localctx, 68, RULE_collectionRangeCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(422);
        expression();
        setState(423);
        match(T__33);
        setState(424);
        expression();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimitiveLiteralExpCSContext extends ParserRuleContext {
    public IntegerLiteralExpCSContext integerLiteralExpCS() {
      return getRuleContext(IntegerLiteralExpCSContext.class, 0);
    }

    public RealLiteralExpCSContext realLiteralExpCS() {
      return getRuleContext(RealLiteralExpCSContext.class, 0);
    }

    public StringLiteralExpCSContext stringLiteralExpCS() {
      return getRuleContext(StringLiteralExpCSContext.class, 0);
    }

    public BooleanLiteralExpCSContext booleanLiteralExpCS() {
      return getRuleContext(BooleanLiteralExpCSContext.class, 0);
    }

    public PrimitiveLiteralExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primitiveLiteralExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterPrimitiveLiteralExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitPrimitiveLiteralExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitPrimitiveLiteralExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final PrimitiveLiteralExpCSContext primitiveLiteralExpCS() throws RecognitionException {
    PrimitiveLiteralExpCSContext _localctx = new PrimitiveLiteralExpCSContext(_ctx, getState());
    enterRule(_localctx, 70, RULE_primitiveLiteralExpCS);
    try {
      setState(430);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 42, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1); {
          setState(426);
          integerLiteralExpCS();
        }
          break;
        case 2:
          enterOuterAlt(_localctx, 2); {
          setState(427);
          realLiteralExpCS();
        }
          break;
        case 3:
          enterOuterAlt(_localctx, 3); {
          setState(428);
          stringLiteralExpCS();
        }
          break;
        case 4:
          enterOuterAlt(_localctx, 4); {
          setState(429);
          booleanLiteralExpCS();
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IntegerLiteralExpCSContext extends ParserRuleContext {
    public TerminalNode INTEGER() {
      return getToken(OclParser.INTEGER, 0);
    }

    public IntegerLiteralExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_integerLiteralExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterIntegerLiteralExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitIntegerLiteralExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitIntegerLiteralExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final IntegerLiteralExpCSContext integerLiteralExpCS() throws RecognitionException {
    IntegerLiteralExpCSContext _localctx = new IntegerLiteralExpCSContext(_ctx, getState());
    enterRule(_localctx, 72, RULE_integerLiteralExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(432);
        match(INTEGER);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class RealLiteralExpCSContext extends ParserRuleContext {
    public List<TerminalNode> INTEGER() {
      return getTokens(OclParser.INTEGER);
    }

    public TerminalNode INTEGER(int i) {
      return getToken(OclParser.INTEGER, i);
    }

    public TerminalNode DOT() {
      return getToken(OclParser.DOT, 0);
    }

    public RealLiteralExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_realLiteralExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterRealLiteralExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitRealLiteralExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitRealLiteralExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final RealLiteralExpCSContext realLiteralExpCS() throws RecognitionException {
    RealLiteralExpCSContext _localctx = new RealLiteralExpCSContext(_ctx, getState());
    enterRule(_localctx, 74, RULE_realLiteralExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(434);
        match(INTEGER);
        setState(435);
        match(DOT);
        setState(436);
        match(INTEGER);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class StringLiteralExpCSContext extends ParserRuleContext {
    public TerminalNode STRING_LITERAL() {
      return getToken(OclParser.STRING_LITERAL, 0);
    }

    public StringLiteralExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stringLiteralExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterStringLiteralExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitStringLiteralExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitStringLiteralExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final StringLiteralExpCSContext stringLiteralExpCS() throws RecognitionException {
    StringLiteralExpCSContext _localctx = new StringLiteralExpCSContext(_ctx, getState());
    enterRule(_localctx, 76, RULE_stringLiteralExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(438);
        match(STRING_LITERAL);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BooleanLiteralExpCSContext extends ParserRuleContext {
    public BooleanLiteralExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_booleanLiteralExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterBooleanLiteralExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitBooleanLiteralExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitBooleanLiteralExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final BooleanLiteralExpCSContext booleanLiteralExpCS() throws RecognitionException {
    BooleanLiteralExpCSContext _localctx = new BooleanLiteralExpCSContext(_ctx, getState());
    enterRule(_localctx, 78, RULE_booleanLiteralExpCS);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(440);
        _la = _input.LA(1);
        if (!(_la == T__34 || _la == T__35)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF)
            matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CallExpCSContext extends ParserRuleContext {
    public FeatureCallExpCSContext featureCallExpCS() {
      return getRuleContext(FeatureCallExpCSContext.class, 0);
    }

    public LoopExpCSContext loopExpCS() {
      return getRuleContext(LoopExpCSContext.class, 0);
    }

    public CallExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_callExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterCallExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitCallExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitCallExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final CallExpCSContext callExpCS() throws RecognitionException {
    CallExpCSContext _localctx = new CallExpCSContext(_ctx, getState());
    enterRule(_localctx, 80, RULE_callExpCS);
    try {
      setState(444);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 43, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1); {
          setState(442);
          featureCallExpCS();
        }
          break;
        case 2:
          enterOuterAlt(_localctx, 2); {
          setState(443);
          loopExpCS();
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FeatureCallExpCSContext extends ParserRuleContext {
    public PropertyCallExpCSContext propertyCallExpCS() {
      return getRuleContext(PropertyCallExpCSContext.class, 0);
    }

    public OperationCallExpCSContext operationCallExpCS() {
      return getRuleContext(OperationCallExpCSContext.class, 0);
    }

    public ArrayAccessCSContext arrayAccessCS() {
      return getRuleContext(ArrayAccessCSContext.class, 0);
    }

    public FeatureCallExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_featureCallExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterFeatureCallExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitFeatureCallExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitFeatureCallExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final FeatureCallExpCSContext featureCallExpCS() throws RecognitionException {
    FeatureCallExpCSContext _localctx = new FeatureCallExpCSContext(_ctx, getState());
    enterRule(_localctx, 82, RULE_featureCallExpCS);
    try {
      setState(449);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 44, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1); {
          setState(446);
          propertyCallExpCS();
        }
          break;
        case 2:
          enterOuterAlt(_localctx, 2); {
          setState(447);
          operationCallExpCS();
        }
          break;
        case 3:
          enterOuterAlt(_localctx, 3); {
          setState(448);
          arrayAccessCS();
        }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PropertyCallExpCSContext extends ParserRuleContext {
    public TerminalNode DOT() {
      return getToken(OclParser.DOT, 0);
    }

    public VariableExpCSContext variableExpCS() {
      return getRuleContext(VariableExpCSContext.class, 0);
    }

    public PropertyCallExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_propertyCallExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterPropertyCallExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitPropertyCallExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitPropertyCallExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final PropertyCallExpCSContext propertyCallExpCS() throws RecognitionException {
    PropertyCallExpCSContext _localctx = new PropertyCallExpCSContext(_ctx, getState());
    enterRule(_localctx, 84, RULE_propertyCallExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(451);
        match(DOT);
        setState(452);
        variableExpCS();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class OperationCallExpCSContext extends ParserRuleContext {
    public TerminalNode ARROW() {
      return getToken(OclParser.ARROW, 0);
    }

    public VariableExpCSContext variableExpCS() {
      return getRuleContext(VariableExpCSContext.class, 0);
    }

    public ArgumentsCSContext argumentsCS() {
      return getRuleContext(ArgumentsCSContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(OclParser.DOT, 0);
    }

    public OperationCallExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_operationCallExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterOperationCallExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitOperationCallExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitOperationCallExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final OperationCallExpCSContext operationCallExpCS() throws RecognitionException {
    OperationCallExpCSContext _localctx = new OperationCallExpCSContext(_ctx, getState());
    enterRule(_localctx, 86, RULE_operationCallExpCS);
    int _la;
    try {
      setState(477);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case ARROW:
          enterOuterAlt(_localctx, 1); {
          setState(454);
          match(ARROW);
          setState(455);
          variableExpCS();
          setState(456);
          match(T__4);
          setState(458);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290361994076520480L) != 0)) {
            {
              setState(457);
              argumentsCS();
            }
          }

          setState(460);
          match(T__5);
        }
          break;
        case DOT:
          enterOuterAlt(_localctx, 2); {
          setState(462);
          match(DOT);
          setState(463);
          variableExpCS();
          setState(464);
          match(T__4);
          setState(466);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290361994076520480L) != 0)) {
            {
              setState(465);
              argumentsCS();
            }
          }

          setState(468);
          match(T__5);
        }
          break;
        case ID:
          enterOuterAlt(_localctx, 3); {
          setState(470);
          variableExpCS();
          setState(471);
          match(T__4);
          setState(473);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290361994076520480L) != 0)) {
            {
              setState(472);
              argumentsCS();
            }
          }

          setState(475);
          match(T__5);
        }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgumentsCSContext extends ParserRuleContext {
    public OclExpressionCSContext oclExpressionCS() {
      return getRuleContext(OclExpressionCSContext.class, 0);
    }

    public ArgumentsCSContext argumentsCS() {
      return getRuleContext(ArgumentsCSContext.class, 0);
    }

    public ArgumentsCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argumentsCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterArgumentsCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitArgumentsCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitArgumentsCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ArgumentsCSContext argumentsCS() throws RecognitionException {
    ArgumentsCSContext _localctx = new ArgumentsCSContext(_ctx, getState());
    enterRule(_localctx, 88, RULE_argumentsCS);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(479);
        oclExpressionCS();
        setState(482);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__10) {
          {
            setState(480);
            match(T__10);
            setState(481);
            argumentsCS();
          }
        }

      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrayAccessCSContext extends ParserRuleContext {
    public TerminalNode DOT() {
      return getToken(OclParser.DOT, 0);
    }

    public VariableExpCSContext variableExpCS() {
      return getRuleContext(VariableExpCSContext.class, 0);
    }

    public List<IndexExpCSContext> indexExpCS() {
      return getRuleContexts(IndexExpCSContext.class);
    }

    public IndexExpCSContext indexExpCS(int i) {
      return getRuleContext(IndexExpCSContext.class, i);
    }

    public ArrayAccessCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayAccessCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterArrayAccessCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitArrayAccessCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitArrayAccessCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ArrayAccessCSContext arrayAccessCS() throws RecognitionException {
    ArrayAccessCSContext _localctx = new ArrayAccessCSContext(_ctx, getState());
    enterRule(_localctx, 90, RULE_arrayAccessCS);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(484);
        match(DOT);
        setState(485);
        variableExpCS();
        setState(487);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(486);
              indexExpCS();
            }
          }
          setState(489);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (_la == T__12);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IndexExpCSContext extends ParserRuleContext {
    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public IndexExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_indexExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterIndexExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitIndexExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitIndexExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final IndexExpCSContext indexExpCS() throws RecognitionException {
    IndexExpCSContext _localctx = new IndexExpCSContext(_ctx, getState());
    enterRule(_localctx, 92, RULE_indexExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(491);
        match(T__12);
        setState(492);
        expression();
        setState(493);
        match(T__13);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LoopExpCSContext extends ParserRuleContext {
    public IterateExpCSContext iterateExpCS() {
      return getRuleContext(IterateExpCSContext.class, 0);
    }

    public LoopExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_loopExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterLoopExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitLoopExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitLoopExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final LoopExpCSContext loopExpCS() throws RecognitionException {
    LoopExpCSContext _localctx = new LoopExpCSContext(_ctx, getState());
    enterRule(_localctx, 94, RULE_loopExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(495);
        iterateExpCS();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IterateExpCSContext extends ParserRuleContext {
    public TerminalNode ARROW() {
      return getToken(OclParser.ARROW, 0);
    }

    public List<VariableDeclContext> variableDecl() {
      return getRuleContexts(VariableDeclContext.class);
    }

    public VariableDeclContext variableDecl(int i) {
      return getRuleContext(VariableDeclContext.class, i);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public IterateExpCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_iterateExpCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterIterateExpCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitIterateExpCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitIterateExpCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final IterateExpCSContext iterateExpCS() throws RecognitionException {
    IterateExpCSContext _localctx = new IterateExpCSContext(_ctx, getState());
    enterRule(_localctx, 96, RULE_iterateExpCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(497);
        match(ARROW);
        setState(498);
        match(T__36);
        setState(499);
        match(T__4);
        setState(500);
        variableDecl();
        setState(501);
        match(T__37);
        setState(502);
        variableDecl();
        setState(503);
        match(T__38);
        setState(504);
        expression();
        setState(505);
        match(T__5);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LogicalOperatorContext extends ParserRuleContext {
    public LogicalOperatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_logicalOperator;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterLogicalOperator(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitLogicalOperator(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitLogicalOperator(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final LogicalOperatorContext logicalOperator() throws RecognitionException {
    LogicalOperatorContext _localctx = new LogicalOperatorContext(_ctx, getState());
    enterRule(_localctx, 98, RULE_logicalOperator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(507);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492674416640L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF)
            matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class RelationalOperatorContext extends ParserRuleContext {
    public RelationalOperatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_relationalOperator;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterRelationalOperator(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitRelationalOperator(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitRelationalOperator(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final RelationalOperatorContext relationalOperator() throws RecognitionException {
    RelationalOperatorContext _localctx = new RelationalOperatorContext(_ctx, getState());
    enterRule(_localctx, 100, RULE_relationalOperator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(509);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302511616L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF)
            matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AdditiveOperatorContext extends ParserRuleContext {
    public AdditiveOperatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_additiveOperator;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterAdditiveOperator(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitAdditiveOperator(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitAdditiveOperator(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final AdditiveOperatorContext additiveOperator() throws RecognitionException {
    AdditiveOperatorContext _localctx = new AdditiveOperatorContext(_ctx, getState());
    enterRule(_localctx, 102, RULE_additiveOperator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(511);
        _la = _input.LA(1);
        if (!(_la == T__46 || _la == T__47)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF)
            matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MultiplicativeOperatorContext extends ParserRuleContext {
    public MultiplicativeOperatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_multiplicativeOperator;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterMultiplicativeOperator(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitMultiplicativeOperator(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitMultiplicativeOperator(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final MultiplicativeOperatorContext multiplicativeOperator() throws RecognitionException {
    MultiplicativeOperatorContext _localctx = new MultiplicativeOperatorContext(_ctx, getState());
    enterRule(_localctx, 104, RULE_multiplicativeOperator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(513);
        _la = _input.LA(1);
        if (!(_la == T__48 || _la == T__49)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF)
            matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnaryOperatorContext extends ParserRuleContext {
    public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unaryOperator;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterUnaryOperator(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitUnaryOperator(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitUnaryOperator(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final UnaryOperatorContext unaryOperator() throws RecognitionException {
    UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
    enterRule(_localctx, 106, RULE_unaryOperator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(515);
        _la = _input.LA(1);
        if (!(_la == T__47 || _la == T__50)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF)
            matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IsMarkedPreCSContext extends ParserRuleContext {
    public IsMarkedPreCSContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_isMarkedPreCS;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).enterIsMarkedPreCS(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof OclListener)
        ((OclListener) listener).exitIsMarkedPreCS(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof OclVisitor)
        return ((OclVisitor<? extends T>) visitor).visitIsMarkedPreCS(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final IsMarkedPreCSContext isMarkedPreCS() throws RecognitionException {
    IsMarkedPreCSContext _localctx = new IsMarkedPreCSContext(_ctx, getState());
    enterRule(_localctx, 108, RULE_isMarkedPreCS);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(517);
        match(T__51);
        setState(518);
        match(T__8);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static final String _serializedATN =
      "\u0004\u0001?\u0209\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
          + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
          + "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
          + "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"
          + "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"
          + "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"
          + "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"
          + "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"
          + "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"
          + "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"
          + "\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"
          + "#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"
          + "(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"
          + "-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"
          + "2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0001"
          + "\u0000\u0001\u0000\u0001\u0000\u0005\u0000r\b\u0000\n\u0000\f\u0000u\t"
          + "\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001{\b"
          + "\u0001\n\u0001\f\u0001~\t\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u0082"
          + "\b\u0001\n\u0001\f\u0001\u0085\t\u0001\u0003\u0001\u0087\b\u0001\u0001"
          + "\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"
          + "\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0092\b\u0003\u0001\u0003\u0001"
          + "\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"
          + "\u0003\u0003\u0003\u009c\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"
          + "\u0003\u0003\u0003\u00a2\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004\u00a6"
          + "\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00ac"
          + "\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00b2"
          + "\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00b6\b\u0004\u0001\u0005"
          + "\u0001\u0005\u0001\u0005\u0005\u0005\u00bb\b\u0005\n\u0005\f\u0005\u00be"
          + "\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"
          + "\u0006\u00c5\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"
          + "\u0006\u0003\u0006\u00cc\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005"
          + "\u0007\u00d1\b\u0007\n\u0007\f\u0007\u00d4\t\u0007\u0001\b\u0001\b\u0001"
          + "\b\u0003\b\u00d9\b\b\u0001\t\u0001\t\u0001\t\u0003\t\u00de\b\t\u0001\n"
          + "\u0001\n\u0004\n\u00e2\b\n\u000b\n\f\n\u00e3\u0001\n\u0001\n\u0001\n\u0001"
          + "\n\u0004\n\u00ea\b\n\u000b\n\f\n\u00eb\u0001\n\u0001\n\u0001\n\u0001\n"
          + "\u0004\n\u00f2\b\n\u000b\n\f\n\u00f3\u0003\n\u00f6\b\n\u0001\u000b\u0001"
          + "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"
          + "\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"
          + "\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u010b\b\u0011"
          + "\n\u0011\f\u0011\u010e\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"
          + "\u0012\u0005\u0012\u0114\b\u0012\n\u0012\f\u0012\u0117\t\u0012\u0001\u0013"
          + "\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u011d\b\u0013\n\u0013"
          + "\f\u0013\u0120\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"
          + "\u0005\u0014\u0126\b\u0014\n\u0014\f\u0014\u0129\t\u0014\u0001\u0015\u0003"
          + "\u0015\u012c\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"
          + "\u0016\u0004\u0016\u0133\b\u0016\u000b\u0016\f\u0016\u0134\u0001\u0016"
          + "\u0001\u0016\u0003\u0016\u0139\b\u0016\u0001\u0016\u0004\u0016\u013c\b"
          + "\u0016\u000b\u0016\f\u0016\u013d\u0001\u0016\u0001\u0016\u0001\u0016\u0003"
          + "\u0016\u0143\b\u0016\u0001\u0016\u0004\u0016\u0146\b\u0016\u000b\u0016"
          + "\f\u0016\u0147\u0001\u0016\u0001\u0016\u0005\u0016\u014c\b\u0016\n\u0016"
          + "\f\u0016\u014f\t\u0016\u0001\u0016\u0001\u0016\u0004\u0016\u0153\b\u0016"
          + "\u000b\u0016\f\u0016\u0154\u0001\u0016\u0001\u0016\u0003\u0016\u0159\b"
          + "\u0016\u0001\u0016\u0004\u0016\u015c\b\u0016\u000b\u0016\f\u0016\u015d"
          + "\u0001\u0016\u0001\u0016\u0004\u0016\u0162\b\u0016\u000b\u0016\f\u0016"
          + "\u0163\u0003\u0016\u0166\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"
          + "\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0170"
          + "\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"
          + "\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"
          + "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0003"
          + "\u001a\u0183\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"
          + "\u001b\u0003\u001b\u018a\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"
          + "\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"
          + "\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"
          + " \u0001 \u0003 \u019d\b \u0001!\u0001!\u0001!\u0005!\u01a2\b!\n!\f!\u01a5"
          + "\t!\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0003"
          + "#\u01af\b#\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001"
          + "\'\u0001\'\u0001(\u0001(\u0003(\u01bd\b(\u0001)\u0001)\u0001)\u0003)\u01c2"
          + "\b)\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0003+\u01cb\b+\u0001"
          + "+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003+\u01d3\b+\u0001+\u0001+\u0001"
          + "+\u0001+\u0001+\u0003+\u01da\b+\u0001+\u0001+\u0003+\u01de\b+\u0001,\u0001"
          + ",\u0001,\u0003,\u01e3\b,\u0001-\u0001-\u0001-\u0004-\u01e8\b-\u000b-\f"
          + "-\u01e9\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u00010\u00010\u0001"
          + "0\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u0001"
          + "2\u00012\u00013\u00013\u00014\u00014\u00015\u00015\u00016\u00016\u0001"
          + "6\u00016\u0000\u00007\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"
          + "\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\"
          + "^`bdfhjl\u0000\b\u0001\u0000\u0012\u0014\u0001\u0000\u0015\u0019\u0001"
          + "\u0000#$\u0001\u0000(+\u0003\u0000\f\f\u0010\u0011,.\u0001\u0000/0\u0001"
          + "\u000012\u0002\u00000033\u0219\u0000n\u0001\u0000\u0000\u0000\u0002\u0086"
          + "\u0001\u0000\u0000\u0000\u0004\u0088\u0001\u0000\u0000\u0000\u0006\u00a1"
          + "\u0001\u0000\u0000\u0000\b\u00b5\u0001\u0000\u0000\u0000\n\u00b7\u0001"
          + "\u0000\u0000\u0000\f\u00cb\u0001\u0000\u0000\u0000\u000e\u00cd\u0001\u0000"
          + "\u0000\u0000\u0010\u00d8\u0001\u0000\u0000\u0000\u0012\u00dd\u0001\u0000"
          + "\u0000\u0000\u0014\u00f5\u0001\u0000\u0000\u0000\u0016\u00f7\u0001\u0000"
          + "\u0000\u0000\u0018\u00fc\u0001\u0000\u0000\u0000\u001a\u00fe\u0001\u0000"
          + "\u0000\u0000\u001c\u0100\u0001\u0000\u0000\u0000\u001e\u0102\u0001\u0000"
          + "\u0000\u0000 \u0104\u0001\u0000\u0000\u0000\"\u0106\u0001\u0000\u0000"
          + "\u0000$\u010f\u0001\u0000\u0000\u0000&\u0118\u0001\u0000\u0000\u0000("
          + "\u0121\u0001\u0000\u0000\u0000*\u012b\u0001\u0000\u0000\u0000,\u0165\u0001"
          + "\u0000\u0000\u0000.\u016f\u0001\u0000\u0000\u00000\u0171\u0001\u0000\u0000"
          + "\u00002\u017b\u0001\u0000\u0000\u00004\u0180\u0001\u0000\u0000\u00006"
          + "\u0189\u0001\u0000\u0000\u00008\u018b\u0001\u0000\u0000\u0000:\u018e\u0001"
          + "\u0000\u0000\u0000<\u0191\u0001\u0000\u0000\u0000>\u0195\u0001\u0000\u0000"
          + "\u0000@\u019c\u0001\u0000\u0000\u0000B\u019e\u0001\u0000\u0000\u0000D"
          + "\u01a6\u0001\u0000\u0000\u0000F\u01ae\u0001\u0000\u0000\u0000H\u01b0\u0001"
          + "\u0000\u0000\u0000J\u01b2\u0001\u0000\u0000\u0000L\u01b6\u0001\u0000\u0000"
          + "\u0000N\u01b8\u0001\u0000\u0000\u0000P\u01bc\u0001\u0000\u0000\u0000R"
          + "\u01c1\u0001\u0000\u0000\u0000T\u01c3\u0001\u0000\u0000\u0000V\u01dd\u0001"
          + "\u0000\u0000\u0000X\u01df\u0001\u0000\u0000\u0000Z\u01e4\u0001\u0000\u0000"
          + "\u0000\\\u01eb\u0001\u0000\u0000\u0000^\u01ef\u0001\u0000\u0000\u0000"
          + "`\u01f1\u0001\u0000\u0000\u0000b\u01fb\u0001\u0000\u0000\u0000d\u01fd"
          + "\u0001\u0000\u0000\u0000f\u01ff\u0001\u0000\u0000\u0000h\u0201\u0001\u0000"
          + "\u0000\u0000j\u0203\u0001\u0000\u0000\u0000l\u0205\u0001\u0000\u0000\u0000"
          + "no\u0005\u0001\u0000\u0000os\u0003\u000e\u0007\u0000pr\u0003\u0002\u0001"
          + "\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000"
          + "\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001"
          + "\u0000\u0000\u0000vw\u0005\u0002\u0000\u0000w\u0001\u0001\u0000\u0000"
          + "\u0000x|\u0003\u0004\u0002\u0000y{\u0003\b\u0004\u0000zy\u0001\u0000\u0000"
          + "\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000"
          + "\u0000\u0000}\u0087\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000"
          + "\u007f\u0083\u0003\u0006\u0003\u0000\u0080\u0082\u0003\b\u0004\u0000\u0081"
          + "\u0080\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083"
          + "\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084"
          + "\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086"
          + "x\u0001\u0000\u0000\u0000\u0086\u007f\u0001\u0000\u0000\u0000\u0087\u0003"
          + "\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0003\u0000\u0000\u0089\u008a"
          + "\u0003\u000e\u0007\u0000\u008a\u0005\u0001\u0000\u0000\u0000\u008b\u008c"
          + "\u0005\u0003\u0000\u0000\u008c\u008d\u0003\u000e\u0007\u0000\u008d\u008e"
          + "\u0005\u0004\u0000\u0000\u008e\u008f\u0005:\u0000\u0000\u008f\u0091\u0005"
          + "\u0005\u0000\u0000\u0090\u0092\u0003\n\u0005\u0000\u0091\u0090\u0001\u0000"
          + "\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"
          + "\u0000\u0000\u0093\u0094\u0005\u0006\u0000\u0000\u0094\u00a2\u0001\u0000"
          + "\u0000\u0000\u0095\u0096\u0005\u0003\u0000\u0000\u0096\u0097\u0003\u000e"
          + "\u0007\u0000\u0097\u0098\u0005\u0004\u0000\u0000\u0098\u0099\u0005:\u0000"
          + "\u0000\u0099\u009b\u0005\u0005\u0000\u0000\u009a\u009c\u0003\n\u0005\u0000"
          + "\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"
          + "\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u0006\u0000\u0000"
          + "\u009e\u009f\u0005\u0007\u0000\u0000\u009f\u00a0\u0003\u0010\b\u0000\u00a0"
          + "\u00a2\u0001\u0000\u0000\u0000\u00a1\u008b\u0001\u0000\u0000\u0000\u00a1"
          + "\u0095\u0001\u0000\u0000\u0000\u00a2\u0007\u0001\u0000\u0000\u0000\u00a3"
          + "\u00a5\u0005\b\u0000\u0000\u00a4\u00a6\u0005:\u0000\u0000\u00a5\u00a4"
          + "\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7"
          + "\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0007\u0000\u0000\u00a8\u00b6"
          + "\u0003\u001e\u000f\u0000\u00a9\u00ab\u0005\t\u0000\u0000\u00aa\u00ac\u0005"
          + ":\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"
          + "\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0007"
          + "\u0000\u0000\u00ae\u00b6\u0003\u001e\u000f\u0000\u00af\u00b1\u0005\n\u0000"
          + "\u0000\u00b0\u00b2\u0005:\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000"
          + "\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000"
          + "\u00b3\u00b4\u0005\u0007\u0000\u0000\u00b4\u00b6\u0003\u001e\u000f\u0000"
          + "\u00b5\u00a3\u0001\u0000\u0000\u0000\u00b5\u00a9\u0001\u0000\u0000\u0000"
          + "\u00b5\u00af\u0001\u0000\u0000\u0000\u00b6\t\u0001\u0000\u0000\u0000\u00b7"
          + "\u00bc\u0003\f\u0006\u0000\u00b8\u00b9\u0005\u000b\u0000\u0000\u00b9\u00bb"
          + "\u0003\f\u0006\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb\u00be\u0001"
          + "\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001"
          + "\u0000\u0000\u0000\u00bd\u000b\u0001\u0000\u0000\u0000\u00be\u00bc\u0001"
          + "\u0000\u0000\u0000\u00bf\u00c0\u0005:\u0000\u0000\u00c0\u00c1\u0005\u0007"
          + "\u0000\u0000\u00c1\u00c4\u0003\u0010\b\u0000\u00c2\u00c3\u0005\f\u0000"
          + "\u0000\u00c3\u00c5\u0003\u001e\u000f\u0000\u00c4\u00c2\u0001\u0000\u0000"
          + "\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00cc\u0001\u0000\u0000"
          + "\u0000\u00c6\u00c7\u0003\u001a\r\u0000\u00c7\u00c8\u0005\u0005\u0000\u0000"
          + "\u00c8\u00c9\u0003\u0010\b\u0000\u00c9\u00ca\u0005\u0006\u0000\u0000\u00ca"
          + "\u00cc\u0001\u0000\u0000\u0000\u00cb\u00bf\u0001\u0000\u0000\u0000\u00cb"
          + "\u00c6\u0001\u0000\u0000\u0000\u00cc\r\u0001\u0000\u0000\u0000\u00cd\u00d2"
          + "\u0005:\u0000\u0000\u00ce\u00cf\u0005\u0004\u0000\u0000\u00cf\u00d1\u0005"
          + ":\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000"
          + "\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000"
          + "\u0000\u0000\u00d3\u000f\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000"
          + "\u0000\u0000\u00d5\u00d9\u0003\u0014\n\u0000\u00d6\u00d9\u0003\u0016\u000b"
          + "\u0000\u00d7\u00d9\u0003\u0012\t\u0000\u00d8\u00d5\u0001\u0000\u0000\u0000"
          + "\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000"
          + "\u00d9\u0011\u0001\u0000\u0000\u0000\u00da\u00de\u0003\u0018\f\u0000\u00db"
          + "\u00de\u0003\u001c\u000e\u0000\u00dc\u00de\u0003\u001a\r\u0000\u00dd\u00da"
          + "\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00dc"
          + "\u0001\u0000\u0000\u0000\u00de\u0013\u0001\u0000\u0000\u0000\u00df\u00e1"
          + "\u0003\u0012\t\u0000\u00e0\u00e2\u00055\u0000\u0000\u00e1\u00e0\u0001"
          + "\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001"
          + "\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00f6\u0001"
          + "\u0000\u0000\u0000\u00e5\u00e9\u0003\u0012\t\u0000\u00e6\u00e7\u0005\r"
          + "\u0000\u0000\u00e7\u00e8\u0005;\u0000\u0000\u00e8\u00ea\u0005\u000e\u0000"
          + "\u0000\u00e9\u00e6\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000"
          + "\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000"
          + "\u0000\u00ec\u00f6\u0001\u0000\u0000\u0000\u00ed\u00f1\u0003\u0012\t\u0000"
          + "\u00ee\u00ef\u0005\r\u0000\u0000\u00ef\u00f0\u0005:\u0000\u0000\u00f0"
          + "\u00f2\u0005\u000e\u0000\u0000\u00f1\u00ee\u0001\u0000\u0000\u0000\u00f2"
          + "\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3"
          + "\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5"
          + "\u00df\u0001\u0000\u0000\u0000\u00f5\u00e5\u0001\u0000\u0000\u0000\u00f5"
          + "\u00ed\u0001\u0000\u0000\u0000\u00f6\u0015\u0001\u0000\u0000\u0000\u00f7"
          + "\u00f8\u0005\u000f\u0000\u0000\u00f8\u00f9\u0005\u0010\u0000\u0000\u00f9"
          + "\u00fa\u0003\u0010\b\u0000\u00fa\u00fb\u0005\u0011\u0000\u0000\u00fb\u0017"
          + "\u0001\u0000\u0000\u0000\u00fc\u00fd\u0007\u0000\u0000\u0000\u00fd\u0019"
          + "\u0001\u0000\u0000\u0000\u00fe\u00ff\u0007\u0001\u0000\u0000\u00ff\u001b"
          + "\u0001\u0000\u0000\u0000\u0100\u0101\u0005:\u0000\u0000\u0101\u001d\u0001"
          + "\u0000\u0000\u0000\u0102\u0103\u0003 \u0010\u0000\u0103\u001f\u0001\u0000"
          + "\u0000\u0000\u0104\u0105\u0003\"\u0011\u0000\u0105!\u0001\u0000\u0000"
          + "\u0000\u0106\u010c\u0003$\u0012\u0000\u0107\u0108\u0003b1\u0000\u0108"
          + "\u0109\u0003$\u0012\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a\u0107"
          + "\u0001\u0000\u0000\u0000\u010b\u010e\u0001\u0000\u0000\u0000\u010c\u010a"
          + "\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d#\u0001"
          + "\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010f\u0115\u0003"
          + "&\u0013\u0000\u0110\u0111\u0003d2\u0000\u0111\u0112\u0003&\u0013\u0000"
          + "\u0112\u0114\u0001\u0000\u0000\u0000\u0113\u0110\u0001\u0000\u0000\u0000"
          + "\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"
          + "\u0115\u0116\u0001\u0000\u0000\u0000\u0116%\u0001\u0000\u0000\u0000\u0117"
          + "\u0115\u0001\u0000\u0000\u0000\u0118\u011e\u0003(\u0014\u0000\u0119\u011a"
          + "\u0003f3\u0000\u011a\u011b\u0003(\u0014\u0000\u011b\u011d\u0001\u0000"
          + "\u0000\u0000\u011c\u0119\u0001\u0000\u0000\u0000\u011d\u0120\u0001\u0000"
          + "\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000"
          + "\u0000\u0000\u011f\'\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000"
          + "\u0000\u0121\u0127\u0003*\u0015\u0000\u0122\u0123\u0003h4\u0000\u0123"
          + "\u0124\u0003*\u0015\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125\u0122"
          + "\u0001\u0000\u0000\u0000\u0126\u0129\u0001\u0000\u0000\u0000\u0127\u0125"
          + "\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128)\u0001"
          + "\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u012a\u012c\u0003"
          + "j5\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000"
          + "\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012e\u0003,\u0016\u0000"
          + "\u012e+\u0001\u0000\u0000\u0000\u012f\u0166\u0003.\u0017\u0000\u0130\u0132"
          + "\u00034\u001a\u0000\u0131\u0133\u0003P(\u0000\u0132\u0131\u0001\u0000"
          + "\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000"
          + "\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0166\u0001\u0000"
          + "\u0000\u0000\u0136\u0138\u00036\u001b\u0000\u0137\u0139\u0003l6\u0000"
          + "\u0138\u0137\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000"
          + "\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u013c\u0003P(\u0000\u013b\u013a"
          + "\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013b"
          + "\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u0166"
          + "\u0001\u0000\u0000\u0000\u013f\u0166\u0003P(\u0000\u0140\u0142\u00056"
          + "\u0000\u0000\u0141\u0143\u0003l6\u0000\u0142\u0141\u0001\u0000\u0000\u0000"
          + "\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0145\u0001\u0000\u0000\u0000"
          + "\u0144\u0146\u0003P(\u0000\u0145\u0144\u0001\u0000\u0000\u0000\u0146\u0147"
          + "\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0147\u0148"
          + "\u0001\u0000\u0000\u0000\u0148\u0166\u0001\u0000\u0000\u0000\u0149\u014d"
          + "\u00057\u0000\u0000\u014a\u014c\u0003P(\u0000\u014b\u014a\u0001\u0000"
          + "\u0000\u0000\u014c\u014f\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000"
          + "\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e\u0166\u0001\u0000"
          + "\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0152\u00034\u001a"
          + "\u0000\u0151\u0153\u0003\\.\u0000\u0152\u0151\u0001\u0000\u0000\u0000"
          + "\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000\u0000"
          + "\u0154\u0155\u0001\u0000\u0000\u0000\u0155\u0166\u0001\u0000\u0000\u0000"
          + "\u0156\u0158\u00056\u0000\u0000\u0157\u0159\u0003l6\u0000\u0158\u0157"
          + "\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u015b"
          + "\u0001\u0000\u0000\u0000\u015a\u015c\u0003\\.\u0000\u015b\u015a\u0001"
          + "\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015b\u0001"
          + "\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u0166\u0001"
          + "\u0000\u0000\u0000\u015f\u0161\u00057\u0000\u0000\u0160\u0162\u0003\\"
          + ".\u0000\u0161\u0160\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000\u0000"
          + "\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000"
          + "\u0000\u0164\u0166\u0001\u0000\u0000\u0000\u0165\u012f\u0001\u0000\u0000"
          + "\u0000\u0165\u0130\u0001\u0000\u0000\u0000\u0165\u0136\u0001\u0000\u0000"
          + "\u0000\u0165\u013f\u0001\u0000\u0000\u0000\u0165\u0140\u0001\u0000\u0000"
          + "\u0000\u0165\u0149\u0001\u0000\u0000\u0000\u0165\u0150\u0001\u0000\u0000"
          + "\u0000\u0165\u0156\u0001\u0000\u0000\u0000\u0165\u015f\u0001\u0000\u0000"
          + "\u0000\u0166-\u0001\u0000\u0000\u0000\u0167\u0170\u00030\u0018\u0000\u0168"
          + "\u0170\u00032\u0019\u0000\u0169\u0170\u00034\u001a\u0000\u016a\u0170\u0003"
          + "6\u001b\u0000\u016b\u016c\u0005\u0005\u0000\u0000\u016c\u016d\u0003 \u0010"
          + "\u0000\u016d\u016e\u0005\u0006\u0000\u0000\u016e\u0170\u0001\u0000\u0000"
          + "\u0000\u016f\u0167\u0001\u0000\u0000\u0000\u016f\u0168\u0001\u0000\u0000"
          + "\u0000\u016f\u0169\u0001\u0000\u0000\u0000\u016f\u016a\u0001\u0000\u0000"
          + "\u0000\u016f\u016b\u0001\u0000\u0000\u0000\u0170/\u0001\u0000\u0000\u0000"
          + "\u0171\u0172\u0005\u001a\u0000\u0000\u0172\u0173\u0005\u0005\u0000\u0000"
          + "\u0173\u0174\u0003 \u0010\u0000\u0174\u0175\u0005\u0006\u0000\u0000\u0175"
          + "\u0176\u0005\u001b\u0000\u0000\u0176\u0177\u0003 \u0010\u0000\u0177\u0178"
          + "\u0005\u001c\u0000\u0000\u0178\u0179\u0003 \u0010\u0000\u0179\u017a\u0005"
          + "\u001d\u0000\u0000\u017a1\u0001\u0000\u0000\u0000\u017b\u017c\u0005\u001e"
          + "\u0000\u0000\u017c\u017d\u0003\n\u0005\u0000\u017d\u017e\u0005\u001f\u0000"
          + "\u0000\u017e\u017f\u0003\u001e\u000f\u0000\u017f3\u0001\u0000\u0000\u0000"
          + "\u0180\u0182\u0005:\u0000\u0000\u0181\u0183\u0003l6\u0000\u0182\u0181"
          + "\u0001\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u01835\u0001"
          + "\u0000\u0000\u0000\u0184\u018a\u00038\u001c\u0000\u0185\u018a\u0003:\u001d"
          + "\u0000\u0186\u018a\u0003>\u001f\u0000\u0187\u018a\u0003F#\u0000\u0188"
          + "\u018a\u0003<\u001e\u0000\u0189\u0184\u0001\u0000\u0000\u0000\u0189\u0185"
          + "\u0001\u0000\u0000\u0000\u0189\u0186\u0001\u0000\u0000\u0000\u0189\u0187"
          + "\u0001\u0000\u0000\u0000\u0189\u0188\u0001\u0000\u0000\u0000\u018a7\u0001"
          + "\u0000\u0000\u0000\u018b\u018c\u0003\u0014\n\u0000\u018c\u018d\u0003<"
          + "\u001e\u0000\u018d9\u0001\u0000\u0000\u0000\u018e\u018f\u0003\u0016\u000b"
          + "\u0000\u018f\u0190\u0003<\u001e\u0000\u0190;\u0001\u0000\u0000\u0000\u0191"
          + "\u0192\u0005 \u0000\u0000\u0192\u0193\u0003B!\u0000\u0193\u0194\u0005"
          + "!\u0000\u0000\u0194=\u0001\u0000\u0000\u0000\u0195\u0196\u0003\u0012\t"
          + "\u0000\u0196\u0197\u0005 \u0000\u0000\u0197\u0198\u0003@ \u0000\u0198"
          + "\u0199\u0005!\u0000\u0000\u0199?\u0001\u0000\u0000\u0000\u019a\u019d\u0003"
          + "B!\u0000\u019b\u019d\u0003D\"\u0000\u019c\u019a\u0001\u0000\u0000\u0000"
          + "\u019c\u019b\u0001\u0000\u0000\u0000\u019dA\u0001\u0000\u0000\u0000\u019e"
          + "\u01a3\u00036\u001b\u0000\u019f\u01a0\u0005\u000b\u0000\u0000\u01a0\u01a2"
          + "\u00036\u001b\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a2\u01a5\u0001"
          + "\u0000\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a3\u01a4\u0001"
          + "\u0000\u0000\u0000\u01a4C\u0001\u0000\u0000\u0000\u01a5\u01a3\u0001\u0000"
          + "\u0000\u0000\u01a6\u01a7\u0003 \u0010\u0000\u01a7\u01a8\u0005\"\u0000"
          + "\u0000\u01a8\u01a9\u0003 \u0010\u0000\u01a9E\u0001\u0000\u0000\u0000\u01aa"
          + "\u01af\u0003H$\u0000\u01ab\u01af\u0003J%\u0000\u01ac\u01af\u0003L&\u0000"
          + "\u01ad\u01af\u0003N\'\u0000\u01ae\u01aa\u0001\u0000\u0000\u0000\u01ae"
          + "\u01ab\u0001\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01ae"
          + "\u01ad\u0001\u0000\u0000\u0000\u01afG\u0001\u0000\u0000\u0000\u01b0\u01b1"
          + "\u0005;\u0000\u0000\u01b1I\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005;"
          + "\u0000\u0000\u01b3\u01b4\u00058\u0000\u0000\u01b4\u01b5\u0005;\u0000\u0000"
          + "\u01b5K\u0001\u0000\u0000\u0000\u01b6\u01b7\u0005<\u0000\u0000\u01b7M"
          + "\u0001\u0000\u0000\u0000\u01b8\u01b9\u0007\u0002\u0000\u0000\u01b9O\u0001"
          + "\u0000\u0000\u0000\u01ba\u01bd\u0003R)\u0000\u01bb\u01bd\u0003^/\u0000"
          + "\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bc\u01bb\u0001\u0000\u0000\u0000"
          + "\u01bdQ\u0001\u0000\u0000\u0000\u01be\u01c2\u0003T*\u0000\u01bf\u01c2"
          + "\u0003V+\u0000\u01c0\u01c2\u0003Z-\u0000\u01c1\u01be\u0001\u0000\u0000"
          + "\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c1\u01c0\u0001\u0000\u0000"
          + "\u0000\u01c2S\u0001\u0000\u0000\u0000\u01c3\u01c4\u00058\u0000\u0000\u01c4"
          + "\u01c5\u00034\u001a\u0000\u01c5U\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005"
          + "9\u0000\u0000\u01c7\u01c8\u00034\u001a\u0000\u01c8\u01ca\u0005\u0005\u0000"
          + "\u0000\u01c9\u01cb\u0003X,\u0000\u01ca\u01c9\u0001\u0000\u0000\u0000\u01ca"
          + "\u01cb\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000\u0000\u01cc"
          + "\u01cd\u0005\u0006\u0000\u0000\u01cd\u01de\u0001\u0000\u0000\u0000\u01ce"
          + "\u01cf\u00058\u0000\u0000\u01cf\u01d0\u00034\u001a\u0000\u01d0\u01d2\u0005"
          + "\u0005\u0000\u0000\u01d1\u01d3\u0003X,\u0000\u01d2\u01d1\u0001\u0000\u0000"
          + "\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000"
          + "\u0000\u01d4\u01d5\u0005\u0006\u0000\u0000\u01d5\u01de\u0001\u0000\u0000"
          + "\u0000\u01d6\u01d7\u00034\u001a\u0000\u01d7\u01d9\u0005\u0005\u0000\u0000"
          + "\u01d8\u01da\u0003X,\u0000\u01d9\u01d8\u0001\u0000\u0000\u0000\u01d9\u01da"
          + "\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01dc"
          + "\u0005\u0006\u0000\u0000\u01dc\u01de\u0001\u0000\u0000\u0000\u01dd\u01c6"
          + "\u0001\u0000\u0000\u0000\u01dd\u01ce\u0001\u0000\u0000\u0000\u01dd\u01d6"
          + "\u0001\u0000\u0000\u0000\u01deW\u0001\u0000\u0000\u0000\u01df\u01e2\u0003"
          + "\u001e\u000f\u0000\u01e0\u01e1\u0005\u000b\u0000\u0000\u01e1\u01e3\u0003"
          + "X,\u0000\u01e2\u01e0\u0001\u0000\u0000\u0000\u01e2\u01e3\u0001\u0000\u0000"
          + "\u0000\u01e3Y\u0001\u0000\u0000\u0000\u01e4\u01e5\u00058\u0000\u0000\u01e5"
          + "\u01e7\u00034\u001a\u0000\u01e6\u01e8\u0003\\.\u0000\u01e7\u01e6\u0001"
          + "\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e9\u01e7\u0001"
          + "\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea[\u0001\u0000"
          + "\u0000\u0000\u01eb\u01ec\u0005\r\u0000\u0000\u01ec\u01ed\u0003 \u0010"
          + "\u0000\u01ed\u01ee\u0005\u000e\u0000\u0000\u01ee]\u0001\u0000\u0000\u0000"
          + "\u01ef\u01f0\u0003`0\u0000\u01f0_\u0001\u0000\u0000\u0000\u01f1\u01f2"
          + "\u00059\u0000\u0000\u01f2\u01f3\u0005%\u0000\u0000\u01f3\u01f4\u0005\u0005"
          + "\u0000\u0000\u01f4\u01f5\u0003\f\u0006\u0000\u01f5\u01f6\u0005&\u0000"
          + "\u0000\u01f6\u01f7\u0003\f\u0006\u0000\u01f7\u01f8\u0005\'\u0000\u0000"
          + "\u01f8\u01f9\u0003 \u0010\u0000\u01f9\u01fa\u0005\u0006\u0000\u0000\u01fa"
          + "a\u0001\u0000\u0000\u0000\u01fb\u01fc\u0007\u0003\u0000\u0000\u01fcc\u0001"
          + "\u0000\u0000\u0000\u01fd\u01fe\u0007\u0004\u0000\u0000\u01fee\u0001\u0000"
          + "\u0000\u0000\u01ff\u0200\u0007\u0005\u0000\u0000\u0200g\u0001\u0000\u0000"
          + "\u0000\u0201\u0202\u0007\u0006\u0000\u0000\u0202i\u0001\u0000\u0000\u0000"
          + "\u0203\u0204\u0007\u0007\u0000\u0000\u0204k\u0001\u0000\u0000\u0000\u0205"
          + "\u0206\u00054\u0000\u0000\u0206\u0207\u0005\t\u0000\u0000\u0207m\u0001"
          + "\u0000\u0000\u00003s|\u0083\u0086\u0091\u009b\u00a1\u00a5\u00ab\u00b1"
          + "\u00b5\u00bc\u00c4\u00cb\u00d2\u00d8\u00dd\u00e3\u00eb\u00f3\u00f5\u010c"
          + "\u0115\u011e\u0127\u012b\u0134\u0138\u013d\u0142\u0147\u014d\u0154\u0158"
          + "\u015d\u0163\u0165\u016f\u0182\u0189\u019c\u01a3\u01ae\u01bc\u01c1\u01ca"
          + "\u01d2\u01d9\u01dd\u01e2\u01e9";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
