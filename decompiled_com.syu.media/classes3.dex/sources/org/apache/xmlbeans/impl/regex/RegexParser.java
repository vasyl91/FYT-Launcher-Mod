package org.apache.xmlbeans.impl.regex;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
class RegexParser {
    protected static final int S_INBRACKETS = 1;
    protected static final int S_INXBRACKETS = 2;
    protected static final int S_NORMAL = 0;
    static final int T_BACKSOLIDUS = 10;
    static final int T_CARET = 11;
    static final int T_CHAR = 0;
    static final int T_COMMENT = 21;
    static final int T_CONDITION = 23;
    static final int T_DOLLAR = 12;
    static final int T_DOT = 8;
    static final int T_EOF = 1;
    static final int T_INDEPENDENT = 18;
    static final int T_LBRACKET = 9;
    static final int T_LOOKAHEAD = 14;
    static final int T_LOOKBEHIND = 16;
    static final int T_LPAREN = 6;
    static final int T_LPAREN2 = 13;
    static final int T_MODIFIERS = 22;
    static final int T_NEGATIVELOOKAHEAD = 15;
    static final int T_NEGATIVELOOKBEHIND = 17;
    static final int T_OR = 2;
    static final int T_PLUS = 4;
    static final int T_POSIX_CHARCLASS_START = 20;
    static final int T_QUESTION = 5;
    static final int T_RPAREN = 7;
    static final int T_SET_OPERATIONS = 19;
    static final int T_STAR = 3;
    static final int T_XMLSCHEMA_CC_SUBTRACTION = 24;
    int chardata;
    boolean hasBackReferences;
    int nexttoken;
    int offset;
    int options;
    String regex;
    int regexlen;
    ResourceBundle resources;
    int context = 0;
    int parennumber = 1;
    Vector references = null;

    private static final int hexChar(int i) {
        if (i < 48 || i > 102) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        int i2 = 65;
        if (i < 65) {
            return -1;
        }
        if (i > 70) {
            i2 = 97;
            if (i < 97) {
                return -1;
            }
        }
        return (i - i2) + 10;
    }

    static class ReferencePosition {
        int position;
        int refNumber;

        ReferencePosition(int i, int i2) {
            this.refNumber = i;
            this.position = i2;
        }
    }

    public RegexParser() {
        setLocale(Locale.getDefault());
    }

    public RegexParser(Locale locale) {
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        try {
            this.resources = ResourceBundle.getBundle("org.apache.xmlbeans.impl.regex.message", locale);
        } catch (MissingResourceException e) {
            throw new RuntimeException("Installation Problem???  Couldn't load messages: " + e.getMessage());
        }
    }

    final ParseException ex(String str, int i) {
        return new ParseException(this.resources.getString(str), i);
    }

    private final boolean isSet(int i) {
        return (this.options & i) == i;
    }

    synchronized Token parse(String str, int i) throws ParseException {
        Token regex;
        this.options = i;
        this.offset = 0;
        setContext(0);
        this.parennumber = 1;
        this.hasBackReferences = false;
        this.regex = str;
        if (isSet(16)) {
            this.regex = REUtil.stripExtendedComment(this.regex);
        }
        this.regexlen = this.regex.length();
        next();
        regex = parseRegex();
        int i2 = this.offset;
        if (i2 != this.regexlen) {
            throw ex("parser.parse.1", i2);
        }
        if (this.references != null) {
            for (int i3 = 0; i3 < this.references.size(); i3++) {
                ReferencePosition referencePosition = (ReferencePosition) this.references.elementAt(i3);
                if (this.parennumber <= referencePosition.refNumber) {
                    throw ex("parser.parse.2", referencePosition.position);
                }
            }
            this.references.removeAllElements();
        }
        return regex;
    }

    protected final void setContext(int i) {
        this.context = i;
    }

    final int read() {
        return this.nexttoken;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0185  */
    /* JADX WARN: Code duplicated, block: B:111:0x0188  */
    /* JADX WARN: Code duplicated, block: B:25:0x0068  */
    /* JADX WARN: Code duplicated, block: B:31:0x0080  */
    final void next() {
        int i;
        int i2;
        int i3;
        char cCharAt;
        int i4 = this.offset;
        if (i4 >= this.regexlen) {
            this.chardata = -1;
            this.nexttoken = 1;
            return;
        }
        String str = this.regex;
        this.offset = i4 + 1;
        char cCharAt2 = str.charAt(i4);
        this.chardata = cCharAt2;
        int i5 = 10;
        if (this.context == 1) {
            if (cCharAt2 != '-') {
                if (cCharAt2 != '[') {
                    if (cCharAt2 == '\\') {
                        int i6 = this.offset;
                        if (i6 >= this.regexlen) {
                            throw ex("parser.next.1", i6 - 1);
                        }
                        String str2 = this.regex;
                        this.offset = i6 + 1;
                        this.chardata = str2.charAt(i6);
                    } else {
                        if (REUtil.isHighSurrogate(cCharAt2) && (i3 = this.offset) < this.regexlen) {
                            cCharAt = this.regex.charAt(i3);
                            if (REUtil.isLowSurrogate(cCharAt)) {
                                this.chardata = REUtil.composeFromSurrogates(cCharAt2, cCharAt);
                                this.offset++;
                            }
                        }
                        i5 = 0;
                    }
                } else if (!isSet(512) && (i2 = this.offset) < this.regexlen && this.regex.charAt(i2) == ':') {
                    this.offset++;
                    i5 = 20;
                } else {
                    if (REUtil.isHighSurrogate(cCharAt2)) {
                        cCharAt = this.regex.charAt(i3);
                        if (REUtil.isLowSurrogate(cCharAt)) {
                            this.chardata = REUtil.composeFromSurrogates(cCharAt2, cCharAt);
                            this.offset++;
                        }
                    }
                    i5 = 0;
                }
            } else if (isSet(512) && (i = this.offset) < this.regexlen && this.regex.charAt(i) == '[') {
                this.offset++;
                i5 = 24;
            } else {
                i5 = 0;
            }
            this.nexttoken = i5;
            return;
        }
        if (cCharAt2 == '$') {
            i5 = 12;
        } else if (cCharAt2 == '.') {
            i5 = 8;
        } else if (cCharAt2 == '?') {
            i5 = 5;
        } else if (cCharAt2 == '^') {
            i5 = 11;
        } else if (cCharAt2 == '|') {
            i5 = 2;
        } else if (cCharAt2 == '[') {
            i5 = 9;
        } else if (cCharAt2 != '\\') {
            i5 = 3;
            switch (cCharAt2) {
                case '(':
                    int i7 = this.offset;
                    if (i7 < this.regexlen && this.regex.charAt(i7) == '?') {
                        int i8 = this.offset + 1;
                        this.offset = i8;
                        if (i8 >= this.regexlen) {
                            throw ex("parser.next.2", i8 - 1);
                        }
                        String str3 = this.regex;
                        this.offset = i8 + 1;
                        char cCharAt3 = str3.charAt(i8);
                        if (cCharAt3 != '!') {
                            if (cCharAt3 != '#') {
                                if (cCharAt3 != ':') {
                                    if (cCharAt3 != '[') {
                                        switch (cCharAt3) {
                                            case '<':
                                                int i9 = this.offset;
                                                if (i9 >= this.regexlen) {
                                                    throw ex("parser.next.2", i9 - 3);
                                                }
                                                String str4 = this.regex;
                                                this.offset = i9 + 1;
                                                char cCharAt4 = str4.charAt(i9);
                                                if (cCharAt4 == '=') {
                                                    i5 = 16;
                                                } else {
                                                    if (cCharAt4 != '!') {
                                                        throw ex("parser.next.3", this.offset - 3);
                                                    }
                                                    i5 = 17;
                                                }
                                                break;
                                                break;
                                            case '=':
                                                i5 = 14;
                                                break;
                                            case '>':
                                                i5 = 18;
                                                break;
                                            default:
                                                if (cCharAt3 == '-' || (('a' <= cCharAt3 && cCharAt3 <= 'z') || ('A' <= cCharAt3 && cCharAt3 <= 'Z'))) {
                                                    this.offset--;
                                                    i5 = 22;
                                                } else {
                                                    if (cCharAt3 != '(') {
                                                        throw ex("parser.next.2", this.offset - 2);
                                                    }
                                                    i5 = 23;
                                                }
                                                break;
                                        }
                                    } else {
                                        i5 = 19;
                                        break;
                                    }
                                } else {
                                    i5 = 13;
                                    break;
                                }
                            } else {
                                do {
                                    int i10 = this.offset;
                                    if (i10 < this.regexlen) {
                                        String str5 = this.regex;
                                        this.offset = i10 + 1;
                                        cCharAt3 = str5.charAt(i10);
                                    }
                                    if (cCharAt3 == ')') {
                                        throw ex("parser.next.4", this.offset - 1);
                                    }
                                    i5 = 21;
                                    break;
                                } while (cCharAt3 != ')');
                                if (cCharAt3 == ')') {
                                    throw ex("parser.next.4", this.offset - 1);
                                }
                                i5 = 21;
                                break;
                            }
                        } else {
                            i5 = 15;
                            break;
                        }
                    } else {
                        i5 = 6;
                        break;
                    }
                    break;
                case ')':
                    i5 = 7;
                    break;
                case '*':
                    break;
                case '+':
                    i5 = 4;
                    break;
                default:
                    i5 = 0;
                    break;
            }
        } else {
            int i11 = this.offset;
            if (i11 >= this.regexlen) {
                throw ex("parser.next.1", i11 - 1);
            }
            String str6 = this.regex;
            this.offset = i11 + 1;
            this.chardata = str6.charAt(i11);
        }
        this.nexttoken = i5;
    }

    Token parseRegex() throws ParseException {
        Token term = parseTerm();
        Token.UnionToken unionTokenCreateUnion = null;
        while (read() == 2) {
            next();
            if (unionTokenCreateUnion == null) {
                unionTokenCreateUnion = Token.createUnion();
                unionTokenCreateUnion.addChild(term);
                term = unionTokenCreateUnion;
            }
            term.addChild(parseTerm());
        }
        return term;
    }

    Token parseTerm() throws ParseException {
        int i = read();
        if (i == 2 || i == 7 || i == 1) {
            return Token.createEmpty();
        }
        Token factor = parseFactor();
        Token.UnionToken unionTokenCreateConcat = null;
        while (true) {
            int i2 = read();
            if (i2 == 2 || i2 == 7 || i2 == 1) {
                break;
            }
            if (unionTokenCreateConcat == null) {
                unionTokenCreateConcat = Token.createConcat();
                unionTokenCreateConcat.addChild(factor);
                factor = unionTokenCreateConcat;
            }
            unionTokenCreateConcat.addChild(parseFactor());
        }
        return factor;
    }

    Token processCaret() throws ParseException {
        next();
        return Token.token_linebeginning;
    }

    Token processDollar() throws ParseException {
        next();
        return Token.token_lineend;
    }

    Token processLookahead() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(20, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processNegativelookahead() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(21, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processLookbehind() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(22, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processNegativelookbehind() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(23, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processBacksolidus_A() throws ParseException {
        next();
        return Token.token_stringbeginning;
    }

    Token processBacksolidus_Z() throws ParseException {
        next();
        return Token.token_stringend2;
    }

    Token processBacksolidus_z() throws ParseException {
        next();
        return Token.token_stringend;
    }

    Token processBacksolidus_b() throws ParseException {
        next();
        return Token.token_wordedge;
    }

    Token processBacksolidus_B() throws ParseException {
        next();
        return Token.token_not_wordedge;
    }

    Token processBacksolidus_lt() throws ParseException {
        next();
        return Token.token_wordbeginning;
    }

    Token processBacksolidus_gt() throws ParseException {
        next();
        return Token.token_wordend;
    }

    Token processStar(Token token) throws ParseException {
        next();
        if (read() == 5) {
            next();
            return Token.createNGClosure(token);
        }
        return Token.createClosure(token);
    }

    Token processPlus(Token token) throws ParseException {
        next();
        if (read() == 5) {
            next();
            return Token.createConcat(token, Token.createNGClosure(token));
        }
        return Token.createConcat(token, Token.createClosure(token));
    }

    Token processQuestion(Token token) throws ParseException {
        next();
        Token.UnionToken unionTokenCreateUnion = Token.createUnion();
        if (read() == 5) {
            next();
            unionTokenCreateUnion.addChild(Token.createEmpty());
            unionTokenCreateUnion.addChild(token);
        } else {
            unionTokenCreateUnion.addChild(token);
            unionTokenCreateUnion.addChild(Token.createEmpty());
        }
        return unionTokenCreateUnion;
    }

    boolean checkQuestion(int i) {
        return i < this.regexlen && this.regex.charAt(i) == '?';
    }

    Token processParen() throws ParseException {
        next();
        int i = this.parennumber;
        this.parennumber = i + 1;
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), i);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    Token processParen2() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), 0);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    Token processCondition() throws ParseException {
        Token token;
        int i;
        int i2 = this.offset;
        if (i2 + 1 >= this.regexlen) {
            throw ex("parser.factor.4", i2);
        }
        char cCharAt = this.regex.charAt(i2);
        Token child = null;
        if ('1' <= cCharAt && cCharAt <= '9') {
            i = cCharAt - '0';
            this.hasBackReferences = true;
            if (this.references == null) {
                this.references = new Vector();
            }
            this.references.addElement(new ReferencePosition(i, this.offset));
            int i3 = this.offset + 1;
            this.offset = i3;
            if (this.regex.charAt(i3) != ')') {
                throw ex("parser.factor.1", this.offset);
            }
            this.offset++;
            token = null;
        } else {
            if (cCharAt == '?') {
                this.offset--;
            }
            next();
            Token factor = parseFactor();
            int i4 = factor.type;
            if (i4 == 8) {
                if (read() != 7) {
                    throw ex("parser.factor.1", this.offset - 1);
                }
            } else {
                switch (i4) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ex("parser.factor.5", this.offset);
                }
            }
            token = factor;
            i = -1;
        }
        next();
        Token regex = parseRegex();
        if (regex.type == 2) {
            if (regex.size() != 2) {
                throw ex("parser.factor.6", this.offset);
            }
            child = regex.getChild(1);
            regex = regex.getChild(0);
        }
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return Token.createCondition(i, token, regex, child);
    }

    Token processModifiers() throws ParseException {
        int optionValue;
        int optionValue2;
        int i = 0;
        byte bCharAt = -1;
        int i2 = 0;
        while (true) {
            int i3 = this.offset;
            if (i3 >= this.regexlen || (optionValue2 = REUtil.getOptionValue((bCharAt = this.regex.charAt(i3)))) == 0) {
                break;
            }
            i2 |= optionValue2;
            this.offset++;
        }
        int i4 = this.offset;
        if (i4 >= this.regexlen) {
            throw ex("parser.factor.2", i4 - 1);
        }
        if (bCharAt == 45) {
            this.offset = i4 + 1;
            while (true) {
                int i5 = this.offset;
                if (i5 >= this.regexlen || (optionValue = REUtil.getOptionValue((bCharAt = this.regex.charAt(i5)))) == 0) {
                    break;
                }
                i |= optionValue;
                this.offset++;
            }
            int i6 = this.offset;
            if (i6 >= this.regexlen) {
                throw ex("parser.factor.2", i6 - 1);
            }
        }
        if (bCharAt != 58) {
            if (bCharAt == 41) {
                this.offset++;
                next();
                return Token.createModifierGroup(parseRegex(), i2, i);
            }
            throw ex("parser.factor.3", this.offset);
        }
        this.offset++;
        next();
        Token.ModifierToken modifierTokenCreateModifierGroup = Token.createModifierGroup(parseRegex(), i2, i);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return modifierTokenCreateModifierGroup;
    }

    Token processIndependent() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(24, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processBacksolidus_c() throws ParseException {
        int i = this.offset;
        if (i < this.regexlen) {
            String str = this.regex;
            this.offset = i + 1;
            char cCharAt = str.charAt(i);
            if ((65504 & cCharAt) == 64) {
                next();
                return Token.createChar(cCharAt - '@');
            }
        }
        throw ex("parser.atom.1", this.offset - 1);
    }

    Token processBacksolidus_C() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    Token processBacksolidus_i() throws ParseException {
        Token.CharToken charTokenCreateChar = Token.createChar(105);
        next();
        return charTokenCreateChar;
    }

    Token processBacksolidus_I() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    Token processBacksolidus_g() throws ParseException {
        next();
        return Token.getGraphemePattern();
    }

    Token processBacksolidus_X() throws ParseException {
        next();
        return Token.getCombiningCharacterSequence();
    }

    Token processBackreference() throws ParseException {
        int i = this.chardata - 48;
        Token.StringToken stringTokenCreateBackReference = Token.createBackReference(i);
        this.hasBackReferences = true;
        if (this.references == null) {
            this.references = new Vector();
        }
        this.references.addElement(new ReferencePosition(i, this.offset - 2));
        next();
        return stringTokenCreateBackReference;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x010d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0116  */
    /* JADX WARN: Code duplicated, block: B:108:0x011a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0123  */
    /* JADX WARN: Code duplicated, block: B:113:0x0128  */
    /* JADX WARN: Code duplicated, block: B:115:0x012e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0137  */
    /* JADX WARN: Code duplicated, block: B:118:0x0147  */
    /* JADX WARN: Code duplicated, block: B:85:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00dc  */
    Token parseFactor() throws ParseException {
        int i;
        int i2;
        int i3;
        switch (read()) {
            case 10:
                int i4 = this.chardata;
                if (i4 == 60) {
                    return processBacksolidus_lt();
                }
                if (i4 == 62) {
                    return processBacksolidus_gt();
                }
                if (i4 == 90) {
                    return processBacksolidus_Z();
                }
                if (i4 == 98) {
                    return processBacksolidus_b();
                }
                if (i4 == 122) {
                    return processBacksolidus_z();
                }
                if (i4 == 65) {
                    return processBacksolidus_A();
                }
                if (i4 == 66) {
                    return processBacksolidus_B();
                }
                break;
            case 11:
                return processCaret();
            case 12:
                return processDollar();
            case 14:
                return processLookahead();
            case 15:
                return processNegativelookahead();
            case 16:
                return processLookbehind();
            case 17:
                return processNegativelookbehind();
            case 21:
                next();
                return Token.createEmpty();
        }
        Token atom = parseAtom();
        int i5 = read();
        if (i5 != 0) {
            if (i5 == 3) {
                return processStar(atom);
            }
            if (i5 == 4) {
                return processPlus(atom);
            }
            if (i5 == 5) {
                return processQuestion(atom);
            }
        } else if (this.chardata == 123 && (i = this.offset) < this.regexlen) {
            int i6 = i + 1;
            char cCharAt = this.regex.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                int i7 = cCharAt - '0';
                while (i6 < this.regexlen) {
                    int i8 = i6 + 1;
                    cCharAt = this.regex.charAt(i6);
                    if (cCharAt < '0' || cCharAt > '9') {
                        i6 = i8;
                        if (cCharAt == ',') {
                            i2 = i7;
                        } else {
                            if (i6 < this.regexlen) {
                                throw ex("parser.quantifier.3", this.offset);
                            }
                            int i9 = i6 + 1;
                            cCharAt = this.regex.charAt(i6);
                            if (cCharAt >= '0' || cCharAt > '9') {
                                i3 = -1;
                            } else {
                                i3 = cCharAt - '0';
                                while (i9 < this.regexlen) {
                                    int i10 = i9 + 1;
                                    cCharAt = this.regex.charAt(i9);
                                    if (cCharAt < '0' || cCharAt > '9') {
                                        i9 = i10;
                                        if (i7 > i3) {
                                            throw ex("parser.quantifier.4", this.offset);
                                        }
                                    } else {
                                        i3 = ((i3 * 10) + cCharAt) - 48;
                                        if (i3 < 0) {
                                            throw ex("parser.quantifier.5", this.offset);
                                        }
                                        i9 = i10;
                                    }
                                }
                                if (i7 > i3) {
                                    throw ex("parser.quantifier.4", this.offset);
                                }
                            }
                            i2 = i3;
                            i6 = i9;
                        }
                        if (cCharAt == '}') {
                            throw ex("parser.quantifier.2", this.offset);
                        }
                        if (checkQuestion(i6)) {
                            atom = Token.createNGClosure(atom);
                            this.offset = i6 + 1;
                        } else {
                            atom = Token.createClosure(atom);
                            this.offset = i6;
                        }
                        atom.setMin(i7);
                        atom.setMax(i2);
                        next();
                    } else {
                        i7 = ((i7 * 10) + cCharAt) - 48;
                        if (i7 < 0) {
                            throw ex("parser.quantifier.5", this.offset);
                        }
                        i6 = i8;
                    }
                }
                if (cCharAt == ',') {
                    i2 = i7;
                } else {
                    if (i6 < this.regexlen) {
                        throw ex("parser.quantifier.3", this.offset);
                    }
                    int i11 = i6 + 1;
                    cCharAt = this.regex.charAt(i6);
                    if (cCharAt >= '0') {
                        i3 = -1;
                    } else {
                        i3 = -1;
                    }
                    i2 = i3;
                    i6 = i11;
                }
                if (cCharAt == '}') {
                    throw ex("parser.quantifier.2", this.offset);
                }
                if (checkQuestion(i6)) {
                    atom = Token.createNGClosure(atom);
                    this.offset = i6 + 1;
                } else {
                    atom = Token.createClosure(atom);
                    this.offset = i6;
                }
                atom.setMin(i7);
                atom.setMax(i2);
                next();
            } else {
                throw ex("parser.quantifier.1", this.offset);
            }
        }
        return atom;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0077  */
    /* JADX WARN: Code duplicated, block: B:53:0x007f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0084  */
    /* JADX WARN: Code duplicated, block: B:57:0x0092  */
    /* JADX WARN: Code duplicated, block: B:60:0x009f  */
    Token parseAtom() throws ParseException {
        int i;
        Token tokenProcessBacksolidus_pP;
        int iDecodeEscaped;
        int i2 = read();
        if (i2 == 0) {
            int i3 = this.chardata;
            if (i3 == 93 || i3 == 123 || i3 == 125) {
                throw ex("parser.atom.4", this.offset - 1);
            }
            Token.CharToken charTokenCreateChar = Token.createChar(i3);
            int i4 = this.chardata;
            next();
            if (!REUtil.isHighSurrogate(i4) || read() != 0 || !REUtil.isLowSurrogate(this.chardata)) {
                return charTokenCreateChar;
            }
            Token.ParenToken parenTokenCreateParen = Token.createParen(Token.createString(new String(new char[]{(char) i4, (char) this.chardata})), 0);
            next();
            return parenTokenCreateParen;
        }
        if (i2 == 6) {
            return processParen();
        }
        if (i2 == 13) {
            return processParen2();
        }
        if (i2 == 18) {
            return processIndependent();
        }
        if (i2 == 19) {
            return parseSetOperations();
        }
        if (i2 == 22) {
            return processModifiers();
        }
        if (i2 == 23) {
            return processCondition();
        }
        switch (i2) {
            case 8:
                next();
                return Token.token_dot;
            case 9:
                return parseCharacterClass(true);
            case 10:
                int i5 = this.chardata;
                if (i5 != 67) {
                    if (i5 != 68) {
                        if (i5 == 73) {
                            return processBacksolidus_I();
                        }
                        if (i5 != 80) {
                            if (i5 != 83) {
                                if (i5 == 105) {
                                    return processBacksolidus_i();
                                }
                                if (i5 != 110) {
                                    if (i5 != 112) {
                                        if (i5 != 87) {
                                            if (i5 == 88) {
                                                return processBacksolidus_X();
                                            }
                                            switch (i5) {
                                                case 49:
                                                case 50:
                                                case 51:
                                                case 52:
                                                case 53:
                                                case 54:
                                                case 55:
                                                case 56:
                                                case 57:
                                                    return processBackreference();
                                                default:
                                                    switch (i5) {
                                                        case 99:
                                                            return processBacksolidus_c();
                                                        case 100:
                                                            break;
                                                        case 101:
                                                        case 102:
                                                            iDecodeEscaped = decodeEscaped();
                                                            if (iDecodeEscaped < 65536) {
                                                                tokenProcessBacksolidus_pP = Token.createChar(iDecodeEscaped);
                                                            } else {
                                                                tokenProcessBacksolidus_pP = Token.createString(REUtil.decomposeToSurrogates(iDecodeEscaped));
                                                            }
                                                            break;
                                                        case 103:
                                                            return processBacksolidus_g();
                                                        default:
                                                            switch (i5) {
                                                                case 114:
                                                                case 116:
                                                                case 117:
                                                                case 118:
                                                                case 120:
                                                                    iDecodeEscaped = decodeEscaped();
                                                                    if (iDecodeEscaped < 65536) {
                                                                        tokenProcessBacksolidus_pP = Token.createChar(iDecodeEscaped);
                                                                    } else {
                                                                        tokenProcessBacksolidus_pP = Token.createString(REUtil.decomposeToSurrogates(iDecodeEscaped));
                                                                    }
                                                                    break;
                                                                case 115:
                                                                case 119:
                                                                    break;
                                                                default:
                                                                    tokenProcessBacksolidus_pP = Token.createChar(i5);
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        i = this.offset;
                                        tokenProcessBacksolidus_pP = processBacksolidus_pP(i5);
                                        if (tokenProcessBacksolidus_pP == null) {
                                            throw ex("parser.atom.5", i);
                                        }
                                    }
                                } else {
                                    iDecodeEscaped = decodeEscaped();
                                    if (iDecodeEscaped < 65536) {
                                        tokenProcessBacksolidus_pP = Token.createChar(iDecodeEscaped);
                                    } else {
                                        tokenProcessBacksolidus_pP = Token.createString(REUtil.decomposeToSurrogates(iDecodeEscaped));
                                    }
                                }
                            }
                        } else {
                            i = this.offset;
                            tokenProcessBacksolidus_pP = processBacksolidus_pP(i5);
                            if (tokenProcessBacksolidus_pP == null) {
                                throw ex("parser.atom.5", i);
                            }
                        }
                        next();
                        return tokenProcessBacksolidus_pP;
                    }
                    Token tokenForShorthand = getTokenForShorthand(i5);
                    next();
                    return tokenForShorthand;
                }
                return processBacksolidus_C();
            default:
                throw ex("parser.atom.4", this.offset - 1);
        }
    }

    protected RangeToken processBacksolidus_pP(int i) throws ParseException {
        next();
        if (read() != 0 || this.chardata != 123) {
            throw ex("parser.atom.2", this.offset - 1);
        }
        boolean z = i == 112;
        int i2 = this.offset;
        int iIndexOf = this.regex.indexOf(125, i2);
        if (iIndexOf < 0) {
            throw ex("parser.atom.3", this.offset);
        }
        String strSubstring = this.regex.substring(i2, iIndexOf);
        this.offset = iIndexOf + 1;
        return Token.getRange(strSubstring, z, isSet(512));
    }

    int processCIinCharacterClass(RangeToken rangeToken, int i) {
        return decodeEscaped();
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:79:0x010d A[PHI: r7
  0x010d: PHI (r7v10 int) = (r7v2 int), (r7v11 int), (r7v12 int) binds: [B:58:0x00ab, B:55:0x00a6, B:47:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    protected RangeToken parseCharacterClass(boolean z) throws ParseException {
        RangeToken rangeTokenCreateRange;
        boolean z2;
        boolean z3;
        boolean z4;
        setContext(1);
        next();
        RangeToken rangeTokenCreateRange2 = null;
        if (read() == 0 && this.chardata == 94) {
            next();
            if (z) {
                rangeTokenCreateRange = Token.createNRange();
            } else {
                rangeTokenCreateRange2 = Token.createRange();
                rangeTokenCreateRange2.addRange(0, 1114111);
                rangeTokenCreateRange = Token.createRange();
            }
            z2 = true;
        } else {
            rangeTokenCreateRange = Token.createRange();
            z2 = false;
        }
        boolean z5 = true;
        while (true) {
            int i = read();
            if (i == 1 || (i == 0 && this.chardata == 93 && !z5)) {
                break;
            }
            int iProcessCIinCharacterClass = this.chardata;
            if (i == 10) {
                if (iProcessCIinCharacterClass == 67) {
                    iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                    if (iProcessCIinCharacterClass < 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                } else {
                    if (iProcessCIinCharacterClass == 68) {
                        rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                    } else if (iProcessCIinCharacterClass == 73) {
                        iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                        if (iProcessCIinCharacterClass < 0) {
                            z4 = false;
                        }
                    } else {
                        if (iProcessCIinCharacterClass != 80) {
                            if (iProcessCIinCharacterClass != 83 && iProcessCIinCharacterClass != 87) {
                                if (iProcessCIinCharacterClass == 105) {
                                    iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                                    if (iProcessCIinCharacterClass < 0) {
                                        z4 = false;
                                    }
                                } else if (iProcessCIinCharacterClass != 112) {
                                    if (iProcessCIinCharacterClass != 115 && iProcessCIinCharacterClass != 119) {
                                        if (iProcessCIinCharacterClass == 99) {
                                            iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                                            if (iProcessCIinCharacterClass < 0) {
                                            }
                                        } else if (iProcessCIinCharacterClass != 100) {
                                            iProcessCIinCharacterClass = decodeEscaped();
                                        }
                                        z4 = false;
                                    }
                                }
                            }
                            rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                        }
                        int i2 = this.offset;
                        RangeToken rangeTokenProcessBacksolidus_pP = processBacksolidus_pP(iProcessCIinCharacterClass);
                        if (rangeTokenProcessBacksolidus_pP == null) {
                            throw ex("parser.atom.5", i2);
                        }
                        rangeTokenCreateRange.mergeRanges(rangeTokenProcessBacksolidus_pP);
                    }
                    z4 = true;
                }
            } else if (i == 20) {
                int iIndexOf = this.regex.indexOf(58, this.offset);
                if (iIndexOf < 0) {
                    throw ex("parser.cc.1", this.offset);
                }
                if (this.regex.charAt(this.offset) == '^') {
                    this.offset++;
                    z3 = false;
                } else {
                    z3 = true;
                }
                RangeToken range = Token.getRange(this.regex.substring(this.offset, iIndexOf), z3, isSet(512));
                if (range == null) {
                    throw ex("parser.cc.3", this.offset);
                }
                rangeTokenCreateRange.mergeRanges(range);
                int i3 = iIndexOf + 1;
                if (i3 >= this.regexlen || this.regex.charAt(i3) != ']') {
                    throw ex("parser.cc.1", iIndexOf);
                }
                this.offset = iIndexOf + 2;
                z4 = true;
            } else {
                z4 = false;
            }
            next();
            if (!z4) {
                if (read() != 0 || this.chardata != 45) {
                    rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                } else {
                    next();
                    int i4 = read();
                    if (i4 == 1) {
                        throw ex("parser.cc.2", this.offset);
                    }
                    if (i4 == 0 && this.chardata == 93) {
                        rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        rangeTokenCreateRange.addRange(45, 45);
                    } else {
                        int iDecodeEscaped = this.chardata;
                        if (i4 == 10) {
                            iDecodeEscaped = decodeEscaped();
                        }
                        next();
                        rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iDecodeEscaped);
                    }
                }
            }
            if (isSet(XMLEvent.START_PREFIX_MAPPING) && read() == 0 && this.chardata == 44) {
                next();
            }
            z5 = false;
        }
        if (read() == 1) {
            throw ex("parser.cc.2", this.offset);
        }
        if (!z && z2) {
            rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
            rangeTokenCreateRange = rangeTokenCreateRange2;
        }
        rangeTokenCreateRange.sortRanges();
        rangeTokenCreateRange.compactRanges();
        setContext(0);
        next();
        return rangeTokenCreateRange;
    }

    protected RangeToken parseSetOperations() throws ParseException {
        RangeToken characterClass = parseCharacterClass(false);
        while (true) {
            int i = read();
            if (i != 7) {
                int i2 = this.chardata;
                if ((i == 0 && (i2 == 45 || i2 == 38)) || i == 4) {
                    next();
                    if (read() != 9) {
                        throw ex("parser.ope.1", this.offset - 1);
                    }
                    RangeToken characterClass2 = parseCharacterClass(false);
                    if (i == 4) {
                        characterClass.mergeRanges(characterClass2);
                    } else if (i2 == 45) {
                        characterClass.subtractRanges(characterClass2);
                    } else if (i2 == 38) {
                        characterClass.intersectRanges(characterClass2);
                    } else {
                        throw new RuntimeException("ASSERT");
                    }
                } else {
                    throw ex("parser.ope.2", this.offset - 1);
                }
            } else {
                next();
                return characterClass;
            }
        }
    }

    Token getTokenForShorthand(int i) {
        if (i == 68) {
            return isSet(32) ? Token.getRange("Nd", false) : Token.token_not_0to9;
        }
        if (i == 83) {
            return isSet(32) ? Token.getRange("IsSpace", false) : Token.token_not_spaces;
        }
        if (i == 87) {
            return isSet(32) ? Token.getRange("IsWord", false) : Token.token_not_wordchars;
        }
        if (i == 100) {
            return isSet(32) ? Token.getRange("Nd", true) : Token.token_0to9;
        }
        if (i == 115) {
            return isSet(32) ? Token.getRange("IsSpace", true) : Token.token_spaces;
        }
        if (i == 119) {
            return isSet(32) ? Token.getRange("IsWord", true) : Token.token_wordchars;
        }
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(i, 16));
    }

    int decodeEscaped() throws ParseException {
        int iHexChar;
        int iHexChar2;
        int iHexChar3;
        int iHexChar4;
        int iHexChar5;
        int iHexChar6;
        int iHexChar7;
        int iHexChar8;
        int iHexChar9;
        int iHexChar10;
        int iHexChar11;
        if (read() != 10) {
            throw ex("parser.next.1", this.offset - 1);
        }
        int i = this.chardata;
        if (i != 65 && i != 90) {
            if (i == 110) {
                return 10;
            }
            if (i == 114) {
                return 13;
            }
            if (i == 120) {
                next();
                if (read() != 0) {
                    throw ex("parser.descape.1", this.offset - 1);
                }
                if (this.chardata == 123) {
                    int i2 = 0;
                    while (true) {
                        next();
                        if (read() != 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int iHexChar12 = hexChar(this.chardata);
                        if (iHexChar12 < 0) {
                            if (this.chardata != 125) {
                                throw ex("parser.descape.3", this.offset - 1);
                            }
                            if (i2 <= 1114111) {
                                return i2;
                            }
                            throw ex("parser.descape.4", this.offset - 1);
                        }
                        int i3 = i2 * 16;
                        if (i2 > i3) {
                            throw ex("parser.descape.2", this.offset - 1);
                        }
                        i2 = i3 + iHexChar12;
                    }
                } else {
                    if (read() != 0 || (iHexChar = hexChar(this.chardata)) < 0) {
                        throw ex("parser.descape.1", this.offset - 1);
                    }
                    next();
                    if (read() != 0 || (iHexChar2 = hexChar(this.chardata)) < 0) {
                        throw ex("parser.descape.1", this.offset - 1);
                    }
                }
            } else if (i != 122) {
                if (i == 101) {
                    return 27;
                }
                if (i == 102) {
                    return 12;
                }
                switch (i) {
                    case 116:
                        return 9;
                    case 117:
                        next();
                        if (read() != 0 || (iHexChar3 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (iHexChar4 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i4 = (iHexChar3 * 16) + iHexChar4;
                        next();
                        if (read() != 0 || (iHexChar5 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        iHexChar = (i4 * 16) + iHexChar5;
                        next();
                        if (read() != 0 || (iHexChar2 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        break;
                    case 118:
                        next();
                        if (read() != 0 || (iHexChar6 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (iHexChar7 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i5 = (iHexChar6 * 16) + iHexChar7;
                        next();
                        if (read() != 0 || (iHexChar8 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i6 = (i5 * 16) + iHexChar8;
                        next();
                        if (read() != 0 || (iHexChar9 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i7 = (i6 * 16) + iHexChar9;
                        next();
                        if (read() != 0 || (iHexChar10 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i8 = (i7 * 16) + iHexChar10;
                        next();
                        if (read() != 0 || (iHexChar11 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i9 = iHexChar11 + (i8 * 16);
                        if (i9 <= 1114111) {
                            return i9;
                        }
                        throw ex("parser.descappe.4", this.offset - 1);
                    default:
                        return i;
                }
            }
            return iHexChar2 + (iHexChar * 16);
        }
        throw ex("parser.descape.5", this.offset - 2);
    }
}
