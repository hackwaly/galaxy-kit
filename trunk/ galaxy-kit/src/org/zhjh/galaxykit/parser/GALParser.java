/* Generated By:JavaCC: Do not edit this line. GALParser.java */
package org.zhjh.galaxykit.parser;

public class GALParser implements GALParserConstants {
  public static void main(String [] args)
  {
    GALParser parser = new GALParser(System.in);
    try
    {
      parser.Program();
    }
    catch (ParseException ex)
    {
      System.out.println(ex.toString());
    }
  }

/*****************************
  final public void Program() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case BREAK:
      case CONTINUE:
      case VOID:
      case BOOL:
      case INT:
      case FIXED:
      case STRING:
      case STRUCT:
      case INCLUDE:
      case RETURN:
      case TRUE:
      case FALSE:
      case NULL:
      case INTEGER_LITERAL:
      case FLOAT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
      case 33:
      case 37:
      case 39:
      case 40:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      if (jj_2_1(3)) {
        FunctionDefinition();
      } else if (jj_2_2(2)) {
        VariableDefinition();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case STRUCT:
          StructDefinition();
          break;
        case INCLUDE:
          IncludeDeclaration();
          break;
        case IF:
        case WHILE:
        case BREAK:
        case CONTINUE:
        case RETURN:
        case TRUE:
        case FALSE:
        case NULL:
        case INTEGER_LITERAL:
        case FLOAT_LITERAL:
        case STRING_LITERAL:
        case IDENTIFIER:
        case 33:
        case 37:
        case 39:
        case 40:
          Statement();
          break;
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    jj_consume_token(0);
  }

  final public void IncludeDeclaration() throws ParseException {
    jj_consume_token(INCLUDE);
    jj_consume_token(STRING_LITERAL);
  }

  final public void VariableDefinition() throws ParseException {
    Type();
    Identifier();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      Expression();
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    jj_consume_token(33);
  }

  final public void VariableDeclaration() throws ParseException {
    Type();
    Identifier();
    jj_consume_token(33);
  }

  final public void StructDefinition() throws ParseException {
    jj_consume_token(STRUCT);
    Identifier();
    jj_consume_token(34);
    label_2:
    while (true) {
      VariableDeclaration();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BOOL:
      case INT:
      case FIXED:
      case STRING:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
    }
    jj_consume_token(35);
  }

  final public void FormalParameter() throws ParseException {
    Type();
    Identifier();
  }

  final public void FormalParameterList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VOID:
      jj_consume_token(VOID);
      break;
    default:
      jj_la1[6] = jj_gen;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BOOL:
      case INT:
      case FIXED:
      case STRING:
      case IDENTIFIER:
        FormalParameter();
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 36:
            ;
            break;
          default:
            jj_la1[4] = jj_gen;
            break label_3;
          }
          jj_consume_token(36);
          FormalParameter();
        }
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
    }
  }

  final public void FunctionDefinition() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BOOL:
    case INT:
    case FIXED:
    case STRING:
    case IDENTIFIER:
      Type();
      break;
    case VOID:
      jj_consume_token(VOID);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    Identifier();
    jj_consume_token(37);
    FormalParameterList();
    jj_consume_token(38);
    FunctionBody();
  }

  final public void FunctionBody() throws ParseException {
    jj_consume_token(34);
    label_4:
    while (true) {
      if (jj_2_3(2)) {
        ;
      } else {
        break label_4;
      }
      VariableDefinition();
    }
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case BREAK:
      case CONTINUE:
      case RETURN:
      case TRUE:
      case FALSE:
      case NULL:
      case INTEGER_LITERAL:
      case FLOAT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
      case 33:
      case 37:
      case 39:
      case 40:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      Statement();
    }
    jj_consume_token(35);
  }

  final public void Block() throws ParseException {
    jj_consume_token(34);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case BREAK:
      case CONTINUE:
      case RETURN:
      case TRUE:
      case FALSE:
      case NULL:
      case INTEGER_LITERAL:
      case FLOAT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
      case 33:
      case 37:
      case 39:
      case 40:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_6;
      }
      Statement();
    }
    jj_consume_token(35);
  }

  final public void Statement() throws ParseException {
    if (jj_2_4(3)) {
      ExpressionStatement();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
        IfStatement();
        break;
      case WHILE:
        WhileStatement();
        break;
      case TRUE:
      case FALSE:
      case NULL:
      case INTEGER_LITERAL:
      case FLOAT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
      case 37:
      case 39:
      case 40:
        AssignmentStatement();
        break;
      case 33:
        EmptyStatement();
        break;
      case RETURN:
        ReturnStatement();
        break;
      case BREAK:
        BreakStatement();
        break;
      case CONTINUE:
        ContinueStatement();
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void ExpressionStatement() throws ParseException {
    Expression();
    jj_consume_token(33);
  }

  final public void EmptyStatement() throws ParseException {
    jj_consume_token(33);
  }

  final public void ReturnStatement() throws ParseException {
    jj_consume_token(RETURN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
    case FALSE:
    case NULL:
    case INTEGER_LITERAL:
    case FLOAT_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
    case 37:
    case 39:
    case 40:
      Expression();
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    jj_consume_token(33);
  }

  final public void BreakStatement() throws ParseException {
    jj_consume_token(BREAK);
    jj_consume_token(33);
  }

  final public void ContinueStatement() throws ParseException {
    jj_consume_token(CONTINUE);
    jj_consume_token(33);
  }

  final public void AssignmentStatement() throws ParseException {
    LeftHandSideExpression();
    jj_consume_token(32);
    Expression();
    jj_consume_token(33);
  }

  final public void IfStatement() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(37);
    Expression();
    jj_consume_token(38);
    Block();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      Block();
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
  }

  final public void WhileStatement() throws ParseException {
    jj_consume_token(WHILE);
  }

  final public void PrimaryExpression() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING_LITERAL:
      StringLiteral();
      break;
    case INTEGER_LITERAL:
      IntegerLiteral();
      break;
    case FLOAT_LITERAL:
      FloatLiteral();
      break;
    case TRUE:
    case FALSE:
      BooleanLiteral();
      break;
    case NULL:
      HandleLiteral();
      break;
    default:
      jj_la1[13] = jj_gen;
      if (jj_2_5(2)) {
        CallExpression();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          Identifier();
          break;
        case 37:
          jj_consume_token(37);
          Expression();
          jj_consume_token(38);
          break;
        default:
          jj_la1[14] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  final public void UnaryExpression() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 39:
    case 40:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 39:
        jj_consume_token(39);
        break;
      case 40:
        jj_consume_token(40);
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
    PrimaryExpression();
  }

  final public void Arguments() throws ParseException {
    Expression();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 36:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_7;
      }
      jj_consume_token(36);
      Expression();
    }
  }

  final public void CallExpression() throws ParseException {
    Identifier();
    jj_consume_token(37);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
    case FALSE:
    case NULL:
    case INTEGER_LITERAL:
    case FLOAT_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
    case 37:
    case 39:
    case 40:
      Arguments();
      break;
    default:
      jj_la1[18] = jj_gen;
      ;
    }
    jj_consume_token(38);
  }

  final public void LeftHandSideExpression() throws ParseException {
    MemberExpression();
  }

  final public void MemberExpression() throws ParseException {
    UnaryExpression();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 41:
      case 42:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_8;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 41:
        jj_consume_token(41);
        break;
      case 42:
        jj_consume_token(42);
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      Identifier();
    }
  }

  final public void MultiplicativeExpression() throws ParseException {
    MemberExpression();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIV:
      case 40:
        ;
        break;
      default:
        jj_la1[21] = jj_gen;
        break label_9;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 40:
        jj_consume_token(40);
        break;
      case DIV:
        jj_consume_token(DIV);
        break;
      default:
        jj_la1[22] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      MemberExpression();
    }
  }

  final public void AdditiveExpression() throws ParseException {
    MultiplicativeExpression();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 43:
      case 44:
        ;
        break;
      default:
        jj_la1[23] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 43:
        jj_consume_token(43);
        break;
      case 44:
        jj_consume_token(44);
        break;
      default:
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      MultiplicativeExpression();
    }
  }

  final public void RelationExpression() throws ParseException {
    AdditiveExpression();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 45:
      case 46:
      case 47:
      case 48:
        ;
        break;
      default:
        jj_la1[25] = jj_gen;
        break label_11;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 45:
        jj_consume_token(45);
        break;
      case 46:
        jj_consume_token(46);
        break;
      case 47:
        jj_consume_token(47);
        break;
      case 48:
        jj_consume_token(48);
        break;
      default:
        jj_la1[26] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void EqualityExpression() throws ParseException {
    RelationExpression();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 49:
      case 50:
        ;
        break;
      default:
        jj_la1[27] = jj_gen;
        break label_12;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 49:
        jj_consume_token(49);
        break;
      case 50:
        jj_consume_token(50);
        break;
      default:
        jj_la1[28] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      RelationExpression();
    }
  }

  final public void BitwiseANDExpression() throws ParseException {
    EqualityExpression();
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 39:
        ;
        break;
      default:
        jj_la1[29] = jj_gen;
        break label_13;
      }
      jj_consume_token(39);
      EqualityExpression();
    }
  }

  final public void BitwiseXORExpression() throws ParseException {
    EqualityExpression();
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 51:
        ;
        break;
      default:
        jj_la1[30] = jj_gen;
        break label_14;
      }
      jj_consume_token(51);
      EqualityExpression();
    }
  }

  final public void BitwiseORExpression() throws ParseException {
    BitwiseXORExpression();
    label_15:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 52:
        ;
        break;
      default:
        jj_la1[31] = jj_gen;
        break label_15;
      }
      jj_consume_token(52);
      BitwiseXORExpression();
    }
  }

  final public void LogicalANDExpression() throws ParseException {
    BitwiseORExpression();
    label_16:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 53:
        ;
        break;
      default:
        jj_la1[32] = jj_gen;
        break label_16;
      }
      jj_consume_token(53);
      BitwiseORExpression();
    }
  }

  final public void LogicalORExpression() throws ParseException {
    LogicalANDExpression();
    label_17:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 54:
        ;
        break;
      default:
        jj_la1[33] = jj_gen;
        break label_17;
      }
      jj_consume_token(54);
      LogicalANDExpression();
    }
  }

  final public void Expression() throws ParseException {
    LogicalORExpression();
  }

  final public void Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BOOL:
      jj_consume_token(BOOL);
      break;
    case INT:
      jj_consume_token(INT);
      break;
    case FIXED:
      jj_consume_token(FIXED);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    case IDENTIFIER:
      Identifier();
      break;
    default:
      jj_la1[34] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_18:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 55:
        ;
        break;
      default:
        jj_la1[35] = jj_gen;
        break label_18;
      }
      jj_consume_token(55);
      IntegerLiteral();
      jj_consume_token(56);
    }
    label_19:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 40:
        ;
        break;
      default:
        jj_la1[36] = jj_gen;
        break label_19;
      }
      jj_consume_token(40);
    }
  }

  final public void BooleanLiteral() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    default:
      jj_la1[37] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void StringLiteral() throws ParseException {
    jj_consume_token(STRING_LITERAL);
  }

  final public void IntegerLiteral() throws ParseException {
    jj_consume_token(INTEGER_LITERAL);
  }

  final public void FloatLiteral() throws ParseException {
    jj_consume_token(FLOAT_LITERAL);
  }

  final public void HandleLiteral() throws ParseException {
    jj_consume_token(NULL);
  }

  final public void Identifier() throws ParseException {
    jj_consume_token(IDENTIFIER);
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_3R_31() {
    if (jj_3R_33()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_34()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_4() {
    if (jj_3R_22()) return true;
    return false;
  }

  private boolean jj_3R_23() {
    if (jj_scan_token(29)) return true;
    if (jj_scan_token(37)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_52()) jj_scanpos = xsp;
    if (jj_scan_token(38)) return true;
    return false;
  }

  private boolean jj_3R_36() {
    if (jj_scan_token(51)) return true;
    if (jj_3R_35()) return true;
    return false;
  }

  private boolean jj_3R_33() {
    if (jj_3R_35()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_36()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_53() {
    if (jj_3R_26()) return true;
    return false;
  }

  private boolean jj_3R_47() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(39)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) return true;
    }
    return false;
  }

  private boolean jj_3R_45() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_47()) jj_scanpos = xsp;
    if (jj_3R_48()) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_21()) return true;
    return false;
  }

  private boolean jj_3R_50() {
    if (jj_scan_token(37)) return true;
    if (jj_3R_26()) return true;
    if (jj_scan_token(38)) return true;
    return false;
  }

  private boolean jj_3R_38() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(49)) {
    jj_scanpos = xsp;
    if (jj_scan_token(50)) return true;
    }
    if (jj_3R_37()) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_3R_23()) return true;
    return false;
  }

  private boolean jj_3R_49() {
    if (jj_3R_51()) return true;
    return false;
  }

  private boolean jj_3R_35() {
    if (jj_3R_37()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_38()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_24() {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_48() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(28)) {
    jj_scanpos = xsp;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(27)) {
    jj_scanpos = xsp;
    if (jj_3R_49()) {
    jj_scanpos = xsp;
    if (jj_scan_token(23)) {
    jj_scanpos = xsp;
    if (jj_3_5()) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_3R_50()) return true;
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_20() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_24()) {
    jj_scanpos = xsp;
    if (jj_scan_token(11)) return true;
    }
    if (jj_scan_token(29)) return true;
    if (jj_scan_token(37)) return true;
    return false;
  }

  private boolean jj_3R_40() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(45)) {
    jj_scanpos = xsp;
    if (jj_scan_token(46)) {
    jj_scanpos = xsp;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(48)) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_37() {
    if (jj_3R_39()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_40()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_51() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(21)) {
    jj_scanpos = xsp;
    if (jj_scan_token(22)) return true;
    }
    return false;
  }

  private boolean jj_3R_27() {
    if (jj_scan_token(55)) return true;
    if (jj_scan_token(25)) return true;
    return false;
  }

  private boolean jj_3R_42() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(43)) {
    jj_scanpos = xsp;
    if (jj_scan_token(44)) return true;
    }
    if (jj_3R_41()) return true;
    return false;
  }

  private boolean jj_3R_39() {
    if (jj_3R_41()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_42()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_25() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(12)) {
    jj_scanpos = xsp;
    if (jj_scan_token(13)) {
    jj_scanpos = xsp;
    if (jj_scan_token(14)) {
    jj_scanpos = xsp;
    if (jj_scan_token(15)) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) return true;
    }
    }
    }
    }
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_27()) { jj_scanpos = xsp; break; }
    }
    while (true) {
      xsp = jj_scanpos;
      if (jj_scan_token(40)) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_44() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(40)) {
    jj_scanpos = xsp;
    if (jj_scan_token(24)) return true;
    }
    if (jj_3R_43()) return true;
    return false;
  }

  private boolean jj_3R_26() {
    if (jj_3R_28()) return true;
    return false;
  }

  private boolean jj_3R_41() {
    if (jj_3R_43()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_44()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_30() {
    if (jj_scan_token(54)) return true;
    if (jj_3R_29()) return true;
    return false;
  }

  private boolean jj_3R_21() {
    if (jj_3R_25()) return true;
    if (jj_scan_token(29)) return true;
    return false;
  }

  private boolean jj_3R_52() {
    if (jj_3R_53()) return true;
    return false;
  }

  private boolean jj_3R_28() {
    if (jj_3R_29()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_30()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_46() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) return true;
    }
    if (jj_scan_token(29)) return true;
    return false;
  }

  private boolean jj_3R_22() {
    if (jj_3R_26()) return true;
    if (jj_scan_token(33)) return true;
    return false;
  }

  private boolean jj_3R_32() {
    if (jj_scan_token(53)) return true;
    if (jj_3R_31()) return true;
    return false;
  }

  private boolean jj_3R_43() {
    if (jj_3R_45()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_46()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_29() {
    if (jj_3R_31()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_32()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_2() {
    if (jj_3R_21()) return true;
    return false;
  }

  private boolean jj_3R_34() {
    if (jj_scan_token(52)) return true;
    if (jj_3R_33()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_20()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public GALParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[38];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x3af9ff40,0x3af90740,0x0,0x2000f000,0x0,0x2000f000,0x800,0x2000f800,0x3af00740,0x3af00740,0x3af00740,0x3ae00000,0x80,0x1ae00000,0x20000000,0x0,0x0,0x0,0x3ae00000,0x0,0x0,0x1000000,0x1000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x2000f000,0x0,0x0,0x600000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1a2,0x1a2,0x1,0x0,0x10,0x0,0x0,0x0,0x1a2,0x1a2,0x1a2,0x1a0,0x0,0x0,0x20,0x180,0x180,0x10,0x1a0,0x600,0x600,0x100,0x100,0x1800,0x1800,0x1e000,0x1e000,0x60000,0x60000,0x80,0x80000,0x100000,0x200000,0x400000,0x0,0x800000,0x100,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[5];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public GALParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public GALParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new GALParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public GALParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GALParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public GALParser(GALParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(GALParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[57];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 38; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 57; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 5; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}