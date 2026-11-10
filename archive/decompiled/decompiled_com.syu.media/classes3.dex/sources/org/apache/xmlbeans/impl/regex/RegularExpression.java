package org.apache.xmlbeans.impl.regex;

import java.io.Serializable;
import java.text.CharacterIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class RegularExpression implements Serializable {
    static final int CARRIAGE_RETURN = 13;
    static final boolean DEBUG = false;
    static final int EXTENDED_COMMENT = 16;
    static final int IGNORE_CASE = 2;
    static final int LINE_FEED = 10;
    static final int LINE_SEPARATOR = 8232;
    static final int MULTIPLE_LINES = 8;
    static final int PARAGRAPH_SEPARATOR = 8233;
    static final int PROHIBIT_FIXED_STRING_OPTIMIZATION = 256;
    static final int PROHIBIT_HEAD_CHARACTER_OPTIMIZATION = 128;
    static final int SINGLE_LINE = 4;
    static final int SPECIAL_COMMA = 1024;
    static final int UNICODE_WORD_BOUNDARY = 64;
    static final int USE_UNICODE_CATEGORY = 32;
    private static final int WT_IGNORE = 0;
    private static final int WT_LETTER = 1;
    private static final int WT_OTHER = 2;
    static final int XMLSCHEMA_MODE = 512;
    transient Context context;
    transient RangeToken firstChar;
    transient String fixedString;
    transient boolean fixedStringOnly;
    transient int fixedStringOptions;
    transient BMPattern fixedStringTable;
    boolean hasBackReferences;
    transient int minlength;
    int nofparen;
    transient int numberOfClosures;
    transient Op operations;
    int options;
    String regex;
    Token tokentree;

    private static final boolean isEOLChar(int i) {
        if (i == 10 || i == 13 || i == LINE_SEPARATOR || i == PARAGRAPH_SEPARATOR) {
            return true;
        }
        return DEBUG;
    }

    private static final boolean isSet(int i, int i2) {
        if ((i & i2) == i2) {
            return true;
        }
        return DEBUG;
    }

    private static final boolean isWordChar(int i) {
        if (i == 95) {
            return true;
        }
        if (i < 48 || i > 122) {
            return DEBUG;
        }
        if (i <= 57) {
            return true;
        }
        if (i < 65) {
            return DEBUG;
        }
        if (i > 90 && i < 97) {
            return DEBUG;
        }
        return true;
    }

    private synchronized void compile(Token token) {
        if (this.operations != null) {
            return;
        }
        this.numberOfClosures = 0;
        this.operations = compile(token, null, DEBUG);
    }

    private Op compile(Token token, Op op, boolean z) {
        Op opCreateChar;
        Op.ChildOp childOpCreateClosure;
        Op opCompile;
        int i = token.type;
        int i2 = 0;
        switch (i) {
            case 0:
                opCreateChar = Op.createChar(token.getChar());
                opCreateChar.next = op;
                break;
            case 1:
                if (!z) {
                    for (int size = token.size() - 1; size >= 0; size--) {
                        op = compile(token.getChild(size), op, DEBUG);
                    }
                    return op;
                }
                while (i2 < token.size()) {
                    op = compile(token.getChild(i2), op, true);
                    i2++;
                }
                return op;
            case 2:
                Op.UnionOp unionOpCreateUnion = Op.createUnion(token.size());
                while (i2 < token.size()) {
                    unionOpCreateUnion.addElement(compile(token.getChild(i2), op, z));
                    i2++;
                }
                return unionOpCreateUnion;
            case 3:
            case 9:
                Token child = token.getChild(0);
                int min = token.getMin();
                int max = token.getMax();
                if (min >= 0 && min == max) {
                    while (i2 < min) {
                        op = compile(child, op, z);
                        i2++;
                    }
                    return op;
                }
                if (min > 0 && max > 0) {
                    max -= min;
                }
                if (max > 0) {
                    Op op2 = op;
                    int i3 = 0;
                    while (i3 < max) {
                        Op.ChildOp childOpCreateQuestion = Op.createQuestion(token.type == 9);
                        childOpCreateQuestion.next = op;
                        childOpCreateQuestion.setChild(compile(child, op2, z));
                        i3++;
                        op2 = childOpCreateQuestion;
                    }
                    opCompile = op2;
                } else {
                    if (token.type == 9) {
                        childOpCreateClosure = Op.createNonGreedyClosure();
                    } else if (child.getMinLength() == 0) {
                        int i4 = this.numberOfClosures;
                        this.numberOfClosures = i4 + 1;
                        childOpCreateClosure = Op.createClosure(i4);
                    } else {
                        childOpCreateClosure = Op.createClosure(-1);
                    }
                    childOpCreateClosure.next = op;
                    childOpCreateClosure.setChild(compile(child, childOpCreateClosure, z));
                    opCompile = childOpCreateClosure;
                }
                if (min <= 0) {
                    return opCompile;
                }
                while (i2 < min) {
                    opCompile = compile(child, opCompile, z);
                    i2++;
                }
                return opCompile;
            case 4:
            case 5:
                opCreateChar = Op.createRange(token);
                opCreateChar.next = op;
                break;
            case 6:
                if (token.getParenNumber() == 0) {
                    return compile(token.getChild(0), op, z);
                }
                if (z) {
                    return Op.createCapture(-token.getParenNumber(), compile(token.getChild(0), Op.createCapture(token.getParenNumber(), op), z));
                }
                return Op.createCapture(token.getParenNumber(), compile(token.getChild(0), Op.createCapture(-token.getParenNumber(), op), z));
            case 7:
                return op;
            case 8:
                opCreateChar = Op.createAnchor(token.getChar());
                opCreateChar.next = op;
                break;
            case 10:
                opCreateChar = Op.createString(token.getString());
                opCreateChar.next = op;
                break;
            case 11:
                opCreateChar = Op.createDot();
                opCreateChar.next = op;
                break;
            case 12:
                opCreateChar = Op.createBackReference(token.getReferenceNumber());
                opCreateChar.next = op;
                break;
            default:
                switch (i) {
                    case 20:
                        return Op.createLook(20, op, compile(token.getChild(0), null, DEBUG));
                    case 21:
                        return Op.createLook(21, op, compile(token.getChild(0), null, DEBUG));
                    case 22:
                        return Op.createLook(22, op, compile(token.getChild(0), null, true));
                    case 23:
                        return Op.createLook(23, op, compile(token.getChild(0), null, true));
                    case 24:
                        return Op.createIndependent(op, compile(token.getChild(0), null, z));
                    case 25:
                        Op opCompile2 = compile(token.getChild(0), null, z);
                        Token.ModifierToken modifierToken = (Token.ModifierToken) token;
                        return Op.createModifier(op, opCompile2, modifierToken.getOptions(), modifierToken.getOptionsMask());
                    case 26:
                        Token.ConditionToken conditionToken = (Token.ConditionToken) token;
                        return Op.createCondition(op, conditionToken.refNumber, conditionToken.condition == null ? null : compile(conditionToken.condition, null, z), compile(conditionToken.yes, op, z), conditionToken.no != null ? compile(conditionToken.no, op, z) : null);
                    default:
                        throw new RuntimeException("Unknown token type: " + token.type);
                }
        }
        return opCreateChar;
    }

    public boolean matches(char[] cArr) {
        return matches(cArr, 0, cArr.length, (Match) null);
    }

    public boolean matches(char[] cArr, int i, int i2) {
        return matches(cArr, i, i2, (Match) null);
    }

    public boolean matches(char[] cArr, Match match) {
        return matches(cArr, 0, cArr.length, match);
    }

    /* JADX WARN: Code duplicated, block: B:140:0x01a3 A[EDGE_INSN: B:140:0x01a3->B:109:0x01a3 BREAK  A[LOOP:1: B:76:0x0126->B:94:0x016e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x016e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x015f  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean matches(char[] cArr, int i, int i2, Match match) {
        Context context;
        int i3;
        int iMatchCharArray;
        int i4;
        int iComposeFromSurrogates;
        int i5;
        int i6;
        synchronized (this) {
            if (this.operations == null) {
                prepare();
            }
            if (this.context == null) {
                this.context = new Context();
            }
        }
        synchronized (this.context) {
            context = this.context.inuse ? new Context() : this.context;
            context.reset(cArr, i, i2, this.numberOfClosures);
        }
        if (match != null) {
            match.setNumberOfGroups(this.nofparen);
            match.setSource(cArr);
        } else if (this.hasBackReferences) {
            match = new Match();
            match.setNumberOfGroups(this.nofparen);
        }
        context.match = match;
        if (isSet(this.options, 512)) {
            int iMatchCharArray2 = matchCharArray(context, this.operations, context.start, 1, this.options);
            if (iMatchCharArray2 != context.limit) {
                return DEBUG;
            }
            if (context.match != null) {
                context.match.setBeginning(0, context.start);
                context.match.setEnd(0, iMatchCharArray2);
            }
            context.inuse = DEBUG;
            return true;
        }
        if (this.fixedStringOnly) {
            int iMatches = this.fixedStringTable.matches(cArr, context.start, context.limit);
            if (iMatches >= 0) {
                if (context.match != null) {
                    context.match.setBeginning(0, iMatches);
                    context.match.setEnd(0, iMatches + this.fixedString.length());
                }
                context.inuse = DEBUG;
                return true;
            }
            context.inuse = DEBUG;
            return DEBUG;
        }
        if (this.fixedString != null && this.fixedStringTable.matches(cArr, context.start, context.limit) < 0) {
            context.inuse = DEBUG;
            return DEBUG;
        }
        int i7 = context.limit - this.minlength;
        Op op = this.operations;
        int iMatchCharArray3 = -1;
        if (op != null && op.type == 7 && this.operations.getChild().type == 0) {
            if (isSet(this.options, 4)) {
                i3 = context.start;
                iMatchCharArray = matchCharArray(context, this.operations, context.start, 1, this.options);
            } else {
                int i8 = context.start;
                boolean z = true;
                while (i8 <= i7) {
                    if (isEOLChar(cArr[i8])) {
                        z = true;
                    } else {
                        if (z) {
                            iMatchCharArray3 = matchCharArray(context, this.operations, i8, 1, this.options);
                            if (iMatchCharArray3 >= 0) {
                                break;
                            }
                        }
                        z = false;
                    }
                    i8++;
                }
                iMatchCharArray = iMatchCharArray3;
                i3 = i8;
            }
        } else {
            RangeToken rangeToken = this.firstChar;
            if (rangeToken != null) {
                if (isSet(this.options, 2)) {
                    RangeToken caseInsensitiveToken = this.firstChar.getCaseInsensitiveToken();
                    i4 = context.start;
                    while (i4 <= i7) {
                        char c = cArr[i4];
                        if (REUtil.isHighSurrogate(c) && (i6 = i4 + 1) < context.limit) {
                            if (caseInsensitiveToken.match(REUtil.composeFromSurrogates(c, cArr[i6]))) {
                                iMatchCharArray3 = matchCharArray(context, this.operations, i4, 1, this.options);
                                if (iMatchCharArray3 >= 0) {
                                    break;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } else if (!caseInsensitiveToken.match(c)) {
                            char upperCase = Character.toUpperCase(c);
                            if (caseInsensitiveToken.match(upperCase) || caseInsensitiveToken.match(Character.toLowerCase(upperCase))) {
                                iMatchCharArray3 = matchCharArray(context, this.operations, i4, 1, this.options);
                                if (iMatchCharArray3 >= 0) {
                                    break;
                                }
                            }
                        } else {
                            iMatchCharArray3 = matchCharArray(context, this.operations, i4, 1, this.options);
                            if (iMatchCharArray3 >= 0) {
                                break;
                                break;
                            }
                        }
                        i4++;
                    }
                } else {
                    i4 = context.start;
                    while (i4 <= i7) {
                        char c2 = cArr[i4];
                        if (REUtil.isHighSurrogate(c2) && (i5 = i4 + 1) < context.limit) {
                            iComposeFromSurrogates = c2;
                            iComposeFromSurrogates = c2;
                            iComposeFromSurrogates = REUtil.composeFromSurrogates(c2, cArr[i5]);
                        }
                        iComposeFromSurrogates = c2;
                        iComposeFromSurrogates = c2;
                        iComposeFromSurrogates = c2;
                        if (rangeToken.match(iComposeFromSurrogates)) {
                            iMatchCharArray3 = matchCharArray(context, this.operations, i4, 1, this.options);
                            if (iMatchCharArray3 >= 0) {
                                break;
                            }
                        }
                        i4++;
                    }
                }
                iMatchCharArray = iMatchCharArray3;
                i3 = i4;
            } else {
                i3 = context.start;
                while (i3 <= i7) {
                    iMatchCharArray3 = matchCharArray(context, this.operations, i3, 1, this.options);
                    if (iMatchCharArray3 >= 0) {
                        break;
                    }
                    i3++;
                }
                iMatchCharArray = iMatchCharArray3;
            }
        }
        if (iMatchCharArray >= 0) {
            if (context.match != null) {
                context.match.setBeginning(0, i3);
                context.match.setEnd(0, iMatchCharArray);
            }
            context.inuse = DEBUG;
            return true;
        }
        context.inuse = DEBUG;
        return DEBUG;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    private int matchCharArray(Context context, Op op, int i, int i2, int i3) {
        int iComposeFromSurrogates;
        int iComposeFromSurrogates2;
        int i4;
        int i5;
        int i6;
        int wordType;
        int wordType2;
        int iComposeFromSurrogates3;
        int iComposeFromSurrogates4;
        int i7;
        int i8;
        char[] cArr = context.charTarget;
        while (op != null) {
            if (i <= context.limit && i >= context.start) {
                int i9 = op.type;
                boolean z = true;
                if (i9 == 0) {
                    if (i2 > 0) {
                        if (i >= context.limit) {
                            return -1;
                        }
                        char c = cArr[i];
                        if (isSet(i3, 4)) {
                            if (REUtil.isHighSurrogate(c) && (i8 = i + 1) < context.limit) {
                                i = i8;
                            }
                        } else {
                            if (REUtil.isHighSurrogate(c) && (i7 = i + 1) < context.limit) {
                                iComposeFromSurrogates4 = c;
                                iComposeFromSurrogates4 = c;
                                i = i7;
                                iComposeFromSurrogates4 = REUtil.composeFromSurrogates(c, cArr[i7]);
                            }
                            iComposeFromSurrogates4 = c;
                            iComposeFromSurrogates4 = c;
                            iComposeFromSurrogates4 = c;
                            if (isEOLChar(iComposeFromSurrogates4)) {
                                return -1;
                            }
                        }
                        i++;
                    } else {
                        i--;
                        if (i < context.limit && i >= 0) {
                            char c2 = cArr[i];
                            if (isSet(i3, 4)) {
                                if (REUtil.isLowSurrogate(c2) && i - 1 >= 0) {
                                    i--;
                                }
                            } else {
                                if (REUtil.isLowSurrogate(c2) && i - 1 >= 0) {
                                    iComposeFromSurrogates3 = c2;
                                    iComposeFromSurrogates3 = c2;
                                    i--;
                                    iComposeFromSurrogates3 = REUtil.composeFromSurrogates(cArr[i], c2);
                                }
                                iComposeFromSurrogates3 = c2;
                                iComposeFromSurrogates3 = c2;
                                iComposeFromSurrogates3 = c2;
                                if (!isEOLChar(iComposeFromSurrogates3)) {
                                    return -1;
                                }
                            }
                        }
                    }
                    op = op.next;
                } else if (i9 == 1) {
                    if (isSet(i3, 2)) {
                        int data = op.getData();
                        if (i2 > 0) {
                            if (i >= context.limit || !matchIgnoreCase(data, cArr[i])) {
                                return -1;
                            }
                            i++;
                        } else {
                            i--;
                            if (i >= context.limit || i < 0 || !matchIgnoreCase(data, cArr[i])) {
                                return -1;
                            }
                        }
                    } else {
                        int data2 = op.getData();
                        if (i2 > 0) {
                            if (i >= context.limit || data2 != cArr[i]) {
                                return -1;
                            }
                            i++;
                        } else {
                            i--;
                            if (i >= context.limit || i < 0 || data2 != cArr[i]) {
                                return -1;
                            }
                        }
                    }
                    op = op.next;
                } else if (i9 == 15) {
                    int data3 = op.getData();
                    if (context.match != null && data3 > 0) {
                        int beginning = context.match.getBeginning(data3);
                        context.match.setBeginning(data3, i);
                        int iMatchCharArray = matchCharArray(context, op.next, i, i2, i3);
                        if (iMatchCharArray < 0) {
                            context.match.setBeginning(data3, beginning);
                        }
                        return iMatchCharArray;
                    }
                    if (context.match != null && data3 < 0) {
                        int i10 = -data3;
                        int end = context.match.getEnd(i10);
                        context.match.setEnd(i10, i);
                        int iMatchCharArray2 = matchCharArray(context, op.next, i, i2, i3);
                        if (iMatchCharArray2 < 0) {
                            context.match.setEnd(i10, end);
                        }
                        return iMatchCharArray2;
                    }
                    op = op.next;
                } else if (i9 != 16) {
                    switch (i9) {
                        case 3:
                        case 4:
                            if (i2 > 0) {
                                if (i >= context.limit) {
                                    return -1;
                                }
                                char c3 = cArr[i];
                                if (REUtil.isHighSurrogate(c3) && (i4 = i + 1) < context.limit) {
                                    iComposeFromSurrogates2 = c3;
                                    iComposeFromSurrogates2 = c3;
                                    i = i4;
                                    iComposeFromSurrogates2 = REUtil.composeFromSurrogates(c3, cArr[i4]);
                                }
                                iComposeFromSurrogates2 = c3;
                                iComposeFromSurrogates2 = c3;
                                iComposeFromSurrogates2 = c3;
                                RangeToken token = op.getToken();
                                if (isSet(i3, 2)) {
                                    RangeToken caseInsensitiveToken = token.getCaseInsensitiveToken();
                                    if (!caseInsensitiveToken.match(iComposeFromSurrogates2)) {
                                        if (iComposeFromSurrogates2 >= 65536) {
                                            return -1;
                                        }
                                        char upperCase = Character.toUpperCase((char) iComposeFromSurrogates2);
                                        if (!caseInsensitiveToken.match(upperCase) && !caseInsensitiveToken.match(Character.toLowerCase(upperCase))) {
                                            return -1;
                                        }
                                    }
                                } else if (!token.match(iComposeFromSurrogates2)) {
                                    return -1;
                                }
                                i++;
                            } else {
                                i--;
                                if (i >= context.limit || i < 0) {
                                    return -1;
                                }
                                char c4 = cArr[i];
                                if (REUtil.isLowSurrogate(c4) && i - 1 >= 0) {
                                    iComposeFromSurrogates = c4;
                                    iComposeFromSurrogates = c4;
                                    i--;
                                    iComposeFromSurrogates = REUtil.composeFromSurrogates(cArr[i], c4);
                                }
                                iComposeFromSurrogates = c4;
                                iComposeFromSurrogates = c4;
                                iComposeFromSurrogates = c4;
                                RangeToken token2 = op.getToken();
                                if (isSet(i3, 2)) {
                                    RangeToken caseInsensitiveToken2 = token2.getCaseInsensitiveToken();
                                    if (!caseInsensitiveToken2.match(iComposeFromSurrogates)) {
                                        if (iComposeFromSurrogates >= 65536) {
                                            return -1;
                                        }
                                        char upperCase2 = Character.toUpperCase((char) iComposeFromSurrogates);
                                        if (!caseInsensitiveToken2.match(upperCase2) && !caseInsensitiveToken2.match(Character.toLowerCase(upperCase2))) {
                                            return -1;
                                        }
                                    }
                                } else if (!token2.match(iComposeFromSurrogates)) {
                                    return -1;
                                }
                            }
                            op = op.next;
                            break;
                        case 5:
                            int data4 = op.getData();
                            if (data4 != 36) {
                                if (data4 != 60) {
                                    if (data4 != 62) {
                                        if (data4 != 90) {
                                            if (data4 != 94) {
                                                if (data4 != 98) {
                                                    if (data4 != 122) {
                                                        switch (data4) {
                                                            case 64:
                                                                if (i != context.start && (i <= context.start || !isEOLChar(cArr[i - 1]))) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 65:
                                                                if (i != context.start) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 66:
                                                                if (context.length != 0 && (wordType2 = getWordType(cArr, context.start, context.limit, i, i3)) != 0 && wordType2 != getPreviousWordType(cArr, context.start, context.limit, i, i3)) {
                                                                    z = false;
                                                                }
                                                                if (!z) {
                                                                    return -1;
                                                                }
                                                                break;
                                                        }
                                                    } else if (i != context.limit) {
                                                        return -1;
                                                    }
                                                } else if (context.length == 0 || (wordType = getWordType(cArr, context.start, context.limit, i, i3)) == 0 || wordType == getPreviousWordType(cArr, context.start, context.limit, i, i3)) {
                                                    return -1;
                                                }
                                            } else if (isSet(i3, 8)) {
                                                if (i != context.start && (i <= context.start || !isEOLChar(cArr[i - 1]))) {
                                                    return -1;
                                                }
                                            } else if (i != context.start) {
                                                return -1;
                                            }
                                        } else if (i != context.limit && (((i6 = i + 1) != context.limit || !isEOLChar(cArr[i])) && (i + 2 != context.limit || cArr[i] != '\r' || cArr[i6] != '\n'))) {
                                            return -1;
                                        }
                                    } else if (context.length == 0 || i == context.start || getWordType(cArr, context.start, context.limit, i, i3) != 2 || getPreviousWordType(cArr, context.start, context.limit, i, i3) != 1) {
                                        return -1;
                                    }
                                } else if (context.length == 0 || i == context.limit || getWordType(cArr, context.start, context.limit, i, i3) != 1 || getPreviousWordType(cArr, context.start, context.limit, i, i3) != 2) {
                                    return -1;
                                }
                            } else if (isSet(i3, 8)) {
                                if (i != context.limit && (i >= context.limit || !isEOLChar(cArr[i]))) {
                                    return -1;
                                }
                            } else if (i != context.limit && (((i5 = i + 1) != context.limit || !isEOLChar(cArr[i])) && (i + 2 != context.limit || cArr[i] != '\r' || cArr[i5] != '\n'))) {
                                return -1;
                            }
                            op = op.next;
                            break;
                        case 6:
                            String string = op.getString();
                            int length = string.length();
                            if (isSet(i3, 2)) {
                                if (i2 > 0) {
                                    if (!regionMatchesIgnoreCase(cArr, i, context.limit, string, length)) {
                                        return -1;
                                    }
                                    i += length;
                                } else {
                                    i -= length;
                                    if (!regionMatchesIgnoreCase(cArr, i, context.limit, string, length)) {
                                        return -1;
                                    }
                                }
                            } else if (i2 > 0) {
                                if (!regionMatches(cArr, i, context.limit, string, length)) {
                                    return -1;
                                }
                                i += length;
                            } else {
                                i -= length;
                                if (!regionMatches(cArr, i, context.limit, string, length)) {
                                    return -1;
                                }
                            }
                            op = op.next;
                            break;
                        case 7:
                            int data5 = op.getData();
                            if (data5 >= 0) {
                                int i11 = context.offsets[data5];
                                if (i11 < 0 || i11 != i) {
                                    context.offsets[data5] = i;
                                } else {
                                    context.offsets[data5] = -1;
                                    op = op.next;
                                }
                                break;
                            }
                            int iMatchCharArray3 = matchCharArray(context, op.getChild(), i, i2, i3);
                            if (data5 >= 0) {
                                context.offsets[data5] = -1;
                            }
                            if (iMatchCharArray3 >= 0) {
                                return iMatchCharArray3;
                            }
                            op = op.next;
                            break;
                            break;
                        case 8:
                        case 10:
                            int iMatchCharArray4 = matchCharArray(context, op.next, i, i2, i3);
                            if (iMatchCharArray4 >= 0) {
                                return iMatchCharArray4;
                            }
                            op = op.getChild();
                            break;
                            break;
                        case 9:
                            int iMatchCharArray5 = matchCharArray(context, op.getChild(), i, i2, i3);
                            if (iMatchCharArray5 >= 0) {
                                return iMatchCharArray5;
                            }
                            op = op.next;
                            break;
                            break;
                        case 11:
                            for (int i12 = 0; i12 < op.size(); i12++) {
                                int iMatchCharArray6 = matchCharArray(context, op.elementAt(i12), i, i2, i3);
                                if (iMatchCharArray6 >= 0) {
                                    return iMatchCharArray6;
                                }
                            }
                            return -1;
                        default:
                            switch (i9) {
                                case 20:
                                    if (matchCharArray(context, op.getChild(), i, 1, i3) < 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 21:
                                    if (matchCharArray(context, op.getChild(), i, 1, i3) >= 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 22:
                                    if (matchCharArray(context, op.getChild(), i, -1, i3) < 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 23:
                                    if (matchCharArray(context, op.getChild(), i, -1, i3) >= 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 24:
                                    i = matchCharArray(context, op.getChild(), i, i2, i3);
                                    if (i < 0) {
                                        return i;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 25:
                                    i = matchCharArray(context, op.getChild(), i, i2, (op.getData() | i3) & (~op.getData2()));
                                    if (i < 0) {
                                        return i;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 26:
                                    Op.ConditionOp conditionOp = (Op.ConditionOp) op;
                                    if (conditionOp.refNumber > 0) {
                                        if (conditionOp.refNumber >= this.nofparen) {
                                            throw new RuntimeException("Internal Error: Reference number must be more than zero: " + conditionOp.refNumber);
                                        }
                                        if (context.match.getBeginning(conditionOp.refNumber) < 0 || context.match.getEnd(conditionOp.refNumber) < 0) {
                                            z = false;
                                        }
                                    } else if (matchCharArray(context, conditionOp.condition, i, i2, i3) < 0) {
                                        z = false;
                                    }
                                    if (z) {
                                        op = conditionOp.yes;
                                    } else if (conditionOp.no != null) {
                                        op = conditionOp.no;
                                    } else {
                                        op = conditionOp.next;
                                    }
                                    break;
                                default:
                                    throw new RuntimeException("Unknown operation type: " + op.type);
                            }
                            break;
                    }
                } else {
                    int data6 = op.getData();
                    if (data6 <= 0 || data6 >= this.nofparen) {
                        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + data6);
                    }
                    if (context.match.getBeginning(data6) < 0 || context.match.getEnd(data6) < 0) {
                        return -1;
                    }
                    int beginning2 = context.match.getBeginning(data6);
                    int end2 = context.match.getEnd(data6) - beginning2;
                    if (isSet(i3, 2)) {
                        if (i2 > 0) {
                            if (!regionMatchesIgnoreCase(cArr, i, context.limit, beginning2, end2)) {
                                return -1;
                            }
                            i += end2;
                        } else {
                            i -= end2;
                            if (!regionMatchesIgnoreCase(cArr, i, context.limit, beginning2, end2)) {
                                return -1;
                            }
                        }
                    } else if (i2 > 0) {
                        if (!regionMatches(cArr, i, context.limit, beginning2, end2)) {
                            return -1;
                        }
                        i += end2;
                    } else {
                        i -= end2;
                        if (!regionMatches(cArr, i, context.limit, beginning2, end2)) {
                            return -1;
                        }
                    }
                    op = op.next;
                }
            }
            return -1;
        }
        if (!isSet(i3, 512) || i == context.limit) {
            return i;
        }
        return -1;
    }

    private static final int getPreviousWordType(char[] cArr, int i, int i2, int i3, int i4) {
        int i5 = i3 - 1;
        int wordType = getWordType(cArr, i, i2, i5, i4);
        while (wordType == 0) {
            i5--;
            wordType = getWordType(cArr, i, i2, i5, i4);
        }
        return wordType;
    }

    private static final int getWordType(char[] cArr, int i, int i2, int i3, int i4) {
        if (i3 < i || i3 >= i2) {
            return 2;
        }
        return getWordType0(cArr[i3], i4);
    }

    private static final boolean regionMatches(char[] cArr, int i, int i2, String str, int i3) {
        if (i < 0 || i2 - i < i3) {
            return DEBUG;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i + 1;
            int i7 = i4 + 1;
            if (cArr[i] != str.charAt(i4)) {
                return DEBUG;
            }
            i = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private static final boolean regionMatches(char[] cArr, int i, int i2, int i3, int i4) {
        if (i < 0 || i2 - i < i4) {
            return DEBUG;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i + 1;
            int i7 = i3 + 1;
            if (cArr[i] != cArr[i3]) {
                return DEBUG;
            }
            i = i6;
            i3 = i7;
            i4 = i5;
        }
    }

    private static final boolean regionMatchesIgnoreCase(char[] cArr, int i, int i2, String str, int i3) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i3) {
            return DEBUG;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i + 1;
            char c = cArr[i];
            int i7 = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (c != cCharAt && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(cCharAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return DEBUG;
            }
            i = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private static final boolean regionMatchesIgnoreCase(char[] cArr, int i, int i2, int i3, int i4) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i4) {
            return DEBUG;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i + 1;
            char c = cArr[i];
            int i7 = i3 + 1;
            char c2 = cArr[i3];
            if (c != c2 && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(c2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return DEBUG;
            }
            i = i6;
            i3 = i7;
            i4 = i5;
        }
    }

    public boolean matches(String str) {
        return matches(str, 0, str.length(), (Match) null);
    }

    public boolean matches(String str, int i, int i2) {
        return matches(str, i, i2, (Match) null);
    }

    public boolean matches(String str, Match match) {
        return matches(str, 0, str.length(), match);
    }

    /* JADX WARN: Code duplicated, block: B:140:0x01ad A[EDGE_INSN: B:140:0x01ad->B:109:0x01ad BREAK  A[LOOP:1: B:76:0x0128->B:94:0x0174], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0165  */
    public boolean matches(String str, int i, int i2, Match match) {
        Context context;
        int i3;
        int iMatchString;
        int i4;
        int i5;
        int i6;
        synchronized (this) {
            if (this.operations == null) {
                prepare();
            }
            if (this.context == null) {
                this.context = new Context();
            }
        }
        synchronized (this.context) {
            context = this.context.inuse ? new Context() : this.context;
            context.reset(str, i, i2, this.numberOfClosures);
        }
        if (match != null) {
            match.setNumberOfGroups(this.nofparen);
            match.setSource(str);
        } else if (this.hasBackReferences) {
            match = new Match();
            match.setNumberOfGroups(this.nofparen);
        }
        context.match = match;
        if (isSet(this.options, 512)) {
            int iMatchString2 = matchString(context, this.operations, context.start, 1, this.options);
            if (iMatchString2 != context.limit) {
                return DEBUG;
            }
            if (context.match != null) {
                context.match.setBeginning(0, context.start);
                context.match.setEnd(0, iMatchString2);
            }
            context.inuse = DEBUG;
            return true;
        }
        if (this.fixedStringOnly) {
            int iMatches = this.fixedStringTable.matches(str, context.start, context.limit);
            if (iMatches >= 0) {
                if (context.match != null) {
                    context.match.setBeginning(0, iMatches);
                    context.match.setEnd(0, iMatches + this.fixedString.length());
                }
                context.inuse = DEBUG;
                return true;
            }
            context.inuse = DEBUG;
            return DEBUG;
        }
        if (this.fixedString != null && this.fixedStringTable.matches(str, context.start, context.limit) < 0) {
            context.inuse = DEBUG;
            return DEBUG;
        }
        int i7 = context.limit - this.minlength;
        Op op = this.operations;
        int iMatchString3 = -1;
        if (op != null && op.type == 7 && this.operations.getChild().type == 0) {
            if (isSet(this.options, 4)) {
                i3 = context.start;
                iMatchString = matchString(context, this.operations, context.start, 1, this.options);
            } else {
                int i8 = context.start;
                boolean z = true;
                while (i8 <= i7) {
                    if (isEOLChar(str.charAt(i8))) {
                        z = true;
                    } else {
                        if (z) {
                            iMatchString3 = matchString(context, this.operations, i8, 1, this.options);
                            if (iMatchString3 >= 0) {
                                break;
                            }
                        }
                        z = false;
                    }
                    i8++;
                }
                iMatchString = iMatchString3;
                i3 = i8;
            }
        } else {
            RangeToken rangeToken = this.firstChar;
            if (rangeToken != null) {
                if (isSet(this.options, 2)) {
                    RangeToken caseInsensitiveToken = this.firstChar.getCaseInsensitiveToken();
                    i4 = context.start;
                    while (i4 <= i7) {
                        char cCharAt = str.charAt(i4);
                        if (REUtil.isHighSurrogate(cCharAt) && (i6 = i4 + 1) < context.limit) {
                            if (caseInsensitiveToken.match(REUtil.composeFromSurrogates(cCharAt, str.charAt(i6)))) {
                                iMatchString3 = matchString(context, this.operations, i4, 1, this.options);
                                if (iMatchString3 >= 0) {
                                    break;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } else if (!caseInsensitiveToken.match(cCharAt)) {
                            char upperCase = Character.toUpperCase(cCharAt);
                            if (caseInsensitiveToken.match(upperCase) || caseInsensitiveToken.match(Character.toLowerCase(upperCase))) {
                                iMatchString3 = matchString(context, this.operations, i4, 1, this.options);
                                if (iMatchString3 >= 0) {
                                    break;
                                }
                            }
                        } else {
                            iMatchString3 = matchString(context, this.operations, i4, 1, this.options);
                            if (iMatchString3 >= 0) {
                                break;
                                break;
                            }
                        }
                        i4++;
                    }
                } else {
                    i4 = context.start;
                    while (i4 <= i7) {
                        int iCharAt = str.charAt(i4);
                        if (REUtil.isHighSurrogate(iCharAt) && (i5 = i4 + 1) < context.limit) {
                            iCharAt = REUtil.composeFromSurrogates(iCharAt, str.charAt(i5));
                        }
                        if (rangeToken.match(iCharAt)) {
                            iMatchString3 = matchString(context, this.operations, i4, 1, this.options);
                            if (iMatchString3 >= 0) {
                                break;
                            }
                        }
                        i4++;
                    }
                }
                iMatchString = iMatchString3;
                i3 = i4;
            } else {
                i3 = context.start;
                while (i3 <= i7) {
                    iMatchString3 = matchString(context, this.operations, i3, 1, this.options);
                    if (iMatchString3 >= 0) {
                        break;
                    }
                    i3++;
                }
                iMatchString = iMatchString3;
            }
        }
        if (iMatchString >= 0) {
            if (context.match != null) {
                context.match.setBeginning(0, i3);
                context.match.setEnd(0, iMatchString);
            }
            context.inuse = DEBUG;
            return true;
        }
        context.inuse = DEBUG;
        return DEBUG;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    private int matchString(Context context, Op op, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int wordType;
        int wordType2;
        int i7;
        int i8;
        String str = context.strTarget;
        while (op != null) {
            if (i <= context.limit && i >= context.start) {
                int i9 = op.type;
                boolean z = true;
                if (i9 == 0) {
                    if (i2 > 0) {
                        if (i >= context.limit) {
                            return -1;
                        }
                        int iCharAt = str.charAt(i);
                        if (isSet(i3, 4)) {
                            if (REUtil.isHighSurrogate(iCharAt) && (i8 = i + 1) < context.limit) {
                                i = i8;
                            }
                        } else {
                            if (REUtil.isHighSurrogate(iCharAt) && (i7 = i + 1) < context.limit) {
                                iCharAt = REUtil.composeFromSurrogates(iCharAt, str.charAt(i7));
                                i = i7;
                            }
                            if (isEOLChar(iCharAt)) {
                                return -1;
                            }
                        }
                        i++;
                    } else {
                        i--;
                        if (i < context.limit && i >= 0) {
                            int iCharAt2 = str.charAt(i);
                            if (isSet(i3, 4)) {
                                if (REUtil.isLowSurrogate(iCharAt2) && i - 1 >= 0) {
                                    i--;
                                }
                            } else {
                                if (REUtil.isLowSurrogate(iCharAt2) && i - 1 >= 0) {
                                    i--;
                                    iCharAt2 = REUtil.composeFromSurrogates(str.charAt(i), iCharAt2);
                                }
                                if (!isEOLChar(iCharAt2)) {
                                    return -1;
                                }
                            }
                        }
                    }
                    op = op.next;
                } else if (i9 == 1) {
                    if (isSet(i3, 2)) {
                        int data = op.getData();
                        if (i2 > 0) {
                            if (i >= context.limit || !matchIgnoreCase(data, str.charAt(i))) {
                                return -1;
                            }
                            i++;
                        } else {
                            i--;
                            if (i >= context.limit || i < 0 || !matchIgnoreCase(data, str.charAt(i))) {
                                return -1;
                            }
                        }
                    } else {
                        int data2 = op.getData();
                        if (i2 > 0) {
                            if (i >= context.limit || data2 != str.charAt(i)) {
                                return -1;
                            }
                            i++;
                        } else {
                            i--;
                            if (i >= context.limit || i < 0 || data2 != str.charAt(i)) {
                                return -1;
                            }
                        }
                    }
                    op = op.next;
                } else if (i9 == 15) {
                    int data3 = op.getData();
                    if (context.match != null && data3 > 0) {
                        int beginning = context.match.getBeginning(data3);
                        context.match.setBeginning(data3, i);
                        int iMatchString = matchString(context, op.next, i, i2, i3);
                        if (iMatchString < 0) {
                            context.match.setBeginning(data3, beginning);
                        }
                        return iMatchString;
                    }
                    if (context.match != null && data3 < 0) {
                        int i10 = -data3;
                        int end = context.match.getEnd(i10);
                        context.match.setEnd(i10, i);
                        int iMatchString2 = matchString(context, op.next, i, i2, i3);
                        if (iMatchString2 < 0) {
                            context.match.setEnd(i10, end);
                        }
                        return iMatchString2;
                    }
                    op = op.next;
                } else if (i9 != 16) {
                    switch (i9) {
                        case 3:
                        case 4:
                            if (i2 > 0) {
                                if (i >= context.limit) {
                                    return -1;
                                }
                                int iCharAt3 = str.charAt(i);
                                if (REUtil.isHighSurrogate(iCharAt3) && (i4 = i + 1) < context.limit) {
                                    iCharAt3 = REUtil.composeFromSurrogates(iCharAt3, str.charAt(i4));
                                    i = i4;
                                }
                                RangeToken token = op.getToken();
                                if (isSet(i3, 2)) {
                                    RangeToken caseInsensitiveToken = token.getCaseInsensitiveToken();
                                    if (!caseInsensitiveToken.match(iCharAt3)) {
                                        if (iCharAt3 >= 65536) {
                                            return -1;
                                        }
                                        char upperCase = Character.toUpperCase((char) iCharAt3);
                                        if (!caseInsensitiveToken.match(upperCase) && !caseInsensitiveToken.match(Character.toLowerCase(upperCase))) {
                                            return -1;
                                        }
                                    }
                                } else if (!token.match(iCharAt3)) {
                                    return -1;
                                }
                                i++;
                            } else {
                                i--;
                                if (i >= context.limit || i < 0) {
                                    return -1;
                                }
                                int iCharAt4 = str.charAt(i);
                                if (REUtil.isLowSurrogate(iCharAt4) && i - 1 >= 0) {
                                    i--;
                                    iCharAt4 = REUtil.composeFromSurrogates(str.charAt(i), iCharAt4);
                                }
                                RangeToken token2 = op.getToken();
                                if (isSet(i3, 2)) {
                                    RangeToken caseInsensitiveToken2 = token2.getCaseInsensitiveToken();
                                    if (!caseInsensitiveToken2.match(iCharAt4)) {
                                        if (iCharAt4 >= 65536) {
                                            return -1;
                                        }
                                        char upperCase2 = Character.toUpperCase((char) iCharAt4);
                                        if (!caseInsensitiveToken2.match(upperCase2) && !caseInsensitiveToken2.match(Character.toLowerCase(upperCase2))) {
                                            return -1;
                                        }
                                    }
                                } else if (!token2.match(iCharAt4)) {
                                    return -1;
                                }
                            }
                            op = op.next;
                            break;
                        case 5:
                            int data4 = op.getData();
                            if (data4 != 36) {
                                if (data4 != 60) {
                                    if (data4 != 62) {
                                        if (data4 != 90) {
                                            if (data4 != 94) {
                                                if (data4 != 98) {
                                                    if (data4 != 122) {
                                                        switch (data4) {
                                                            case 64:
                                                                if (i != context.start && (i <= context.start || !isEOLChar(str.charAt(i - 1)))) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 65:
                                                                if (i != context.start) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 66:
                                                                if (context.length != 0 && (wordType2 = getWordType(str, context.start, context.limit, i, i3)) != 0 && wordType2 != getPreviousWordType(str, context.start, context.limit, i, i3)) {
                                                                    z = false;
                                                                }
                                                                if (!z) {
                                                                    return -1;
                                                                }
                                                                break;
                                                        }
                                                    } else if (i != context.limit) {
                                                        return -1;
                                                    }
                                                } else if (context.length == 0 || (wordType = getWordType(str, context.start, context.limit, i, i3)) == 0 || wordType == getPreviousWordType(str, context.start, context.limit, i, i3)) {
                                                    return -1;
                                                }
                                            } else if (isSet(i3, 8)) {
                                                if (i != context.start && (i <= context.start || !isEOLChar(str.charAt(i - 1)))) {
                                                    return -1;
                                                }
                                            } else if (i != context.start) {
                                                return -1;
                                            }
                                        } else if (i != context.limit && (((i6 = i + 1) != context.limit || !isEOLChar(str.charAt(i))) && (i + 2 != context.limit || str.charAt(i) != '\r' || str.charAt(i6) != '\n'))) {
                                            return -1;
                                        }
                                    } else if (context.length == 0 || i == context.start || getWordType(str, context.start, context.limit, i, i3) != 2 || getPreviousWordType(str, context.start, context.limit, i, i3) != 1) {
                                        return -1;
                                    }
                                } else if (context.length == 0 || i == context.limit || getWordType(str, context.start, context.limit, i, i3) != 1 || getPreviousWordType(str, context.start, context.limit, i, i3) != 2) {
                                    return -1;
                                }
                            } else if (isSet(i3, 8)) {
                                if (i != context.limit && (i >= context.limit || !isEOLChar(str.charAt(i)))) {
                                    return -1;
                                }
                            } else if (i != context.limit && (((i5 = i + 1) != context.limit || !isEOLChar(str.charAt(i))) && (i + 2 != context.limit || str.charAt(i) != '\r' || str.charAt(i5) != '\n'))) {
                                return -1;
                            }
                            op = op.next;
                            break;
                        case 6:
                            String string = op.getString();
                            int length = string.length();
                            if (isSet(i3, 2)) {
                                if (i2 > 0) {
                                    if (!regionMatchesIgnoreCase(str, i, context.limit, string, length)) {
                                        return -1;
                                    }
                                    i += length;
                                } else {
                                    i -= length;
                                    if (!regionMatchesIgnoreCase(str, i, context.limit, string, length)) {
                                        return -1;
                                    }
                                }
                            } else if (i2 > 0) {
                                if (!regionMatches(str, i, context.limit, string, length)) {
                                    return -1;
                                }
                                i += length;
                            } else {
                                i -= length;
                                if (!regionMatches(str, i, context.limit, string, length)) {
                                    return -1;
                                }
                            }
                            op = op.next;
                            break;
                        case 7:
                            int data5 = op.getData();
                            if (data5 >= 0) {
                                int i11 = context.offsets[data5];
                                if (i11 < 0 || i11 != i) {
                                    context.offsets[data5] = i;
                                } else {
                                    context.offsets[data5] = -1;
                                    op = op.next;
                                }
                                break;
                            }
                            int iMatchString3 = matchString(context, op.getChild(), i, i2, i3);
                            if (data5 >= 0) {
                                context.offsets[data5] = -1;
                            }
                            if (iMatchString3 >= 0) {
                                return iMatchString3;
                            }
                            op = op.next;
                            break;
                            break;
                        case 8:
                        case 10:
                            int iMatchString4 = matchString(context, op.next, i, i2, i3);
                            if (iMatchString4 >= 0) {
                                return iMatchString4;
                            }
                            op = op.getChild();
                            break;
                            break;
                        case 9:
                            int iMatchString5 = matchString(context, op.getChild(), i, i2, i3);
                            if (iMatchString5 >= 0) {
                                return iMatchString5;
                            }
                            op = op.next;
                            break;
                            break;
                        case 11:
                            for (int i12 = 0; i12 < op.size(); i12++) {
                                int iMatchString6 = matchString(context, op.elementAt(i12), i, i2, i3);
                                if (iMatchString6 >= 0) {
                                    return iMatchString6;
                                }
                            }
                            return -1;
                        default:
                            switch (i9) {
                                case 20:
                                    if (matchString(context, op.getChild(), i, 1, i3) < 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 21:
                                    if (matchString(context, op.getChild(), i, 1, i3) >= 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 22:
                                    if (matchString(context, op.getChild(), i, -1, i3) < 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 23:
                                    if (matchString(context, op.getChild(), i, -1, i3) >= 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 24:
                                    i = matchString(context, op.getChild(), i, i2, i3);
                                    if (i < 0) {
                                        return i;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 25:
                                    i = matchString(context, op.getChild(), i, i2, (op.getData() | i3) & (~op.getData2()));
                                    if (i < 0) {
                                        return i;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 26:
                                    Op.ConditionOp conditionOp = (Op.ConditionOp) op;
                                    if (conditionOp.refNumber > 0) {
                                        if (conditionOp.refNumber >= this.nofparen) {
                                            throw new RuntimeException("Internal Error: Reference number must be more than zero: " + conditionOp.refNumber);
                                        }
                                        if (context.match.getBeginning(conditionOp.refNumber) < 0 || context.match.getEnd(conditionOp.refNumber) < 0) {
                                            z = false;
                                        }
                                    } else if (matchString(context, conditionOp.condition, i, i2, i3) < 0) {
                                        z = false;
                                    }
                                    if (z) {
                                        op = conditionOp.yes;
                                    } else if (conditionOp.no != null) {
                                        op = conditionOp.no;
                                    } else {
                                        op = conditionOp.next;
                                    }
                                    break;
                                default:
                                    throw new RuntimeException("Unknown operation type: " + op.type);
                            }
                            break;
                    }
                } else {
                    int data6 = op.getData();
                    if (data6 <= 0 || data6 >= this.nofparen) {
                        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + data6);
                    }
                    if (context.match.getBeginning(data6) < 0 || context.match.getEnd(data6) < 0) {
                        return -1;
                    }
                    int beginning2 = context.match.getBeginning(data6);
                    int end2 = context.match.getEnd(data6) - beginning2;
                    if (isSet(i3, 2)) {
                        if (i2 > 0) {
                            if (!regionMatchesIgnoreCase(str, i, context.limit, beginning2, end2)) {
                                return -1;
                            }
                            i += end2;
                        } else {
                            i -= end2;
                            if (!regionMatchesIgnoreCase(str, i, context.limit, beginning2, end2)) {
                                return -1;
                            }
                        }
                    } else if (i2 > 0) {
                        if (!regionMatches(str, i, context.limit, beginning2, end2)) {
                            return -1;
                        }
                        i += end2;
                    } else {
                        i -= end2;
                        if (!regionMatches(str, i, context.limit, beginning2, end2)) {
                            return -1;
                        }
                    }
                    op = op.next;
                }
            }
            return -1;
        }
        if (!isSet(i3, 512) || i == context.limit) {
            return i;
        }
        return -1;
    }

    private static final int getPreviousWordType(String str, int i, int i2, int i3, int i4) {
        int i5 = i3 - 1;
        int wordType = getWordType(str, i, i2, i5, i4);
        while (wordType == 0) {
            i5--;
            wordType = getWordType(str, i, i2, i5, i4);
        }
        return wordType;
    }

    private static final int getWordType(String str, int i, int i2, int i3, int i4) {
        if (i3 < i || i3 >= i2) {
            return 2;
        }
        return getWordType0(str.charAt(i3), i4);
    }

    private static final boolean regionMatches(String str, int i, int i2, String str2, int i3) {
        return i2 - i < i3 ? DEBUG : str.regionMatches(i, str2, 0, i3);
    }

    private static final boolean regionMatches(String str, int i, int i2, int i3, int i4) {
        return i2 - i < i4 ? DEBUG : str.regionMatches(i, str, i3, i4);
    }

    private static final boolean regionMatchesIgnoreCase(String str, int i, int i2, String str2, int i3) {
        return str.regionMatches(true, i, str2, 0, i3);
    }

    private static final boolean regionMatchesIgnoreCase(String str, int i, int i2, int i3, int i4) {
        return i2 - i < i4 ? DEBUG : str.regionMatches(true, i, str, i3, i4);
    }

    public boolean matches(CharacterIterator characterIterator) {
        return matches(characterIterator, (Match) null);
    }

    /* JADX WARN: Code duplicated, block: B:141:0x01b5 A[EDGE_INSN: B:141:0x01b5->B:110:0x01b5 BREAK  A[LOOP:1: B:77:0x0130->B:95:0x017c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x016d  */
    public boolean matches(CharacterIterator characterIterator, Match match) {
        Context context;
        int i;
        int iMatchCharacterIterator;
        int i2;
        int i3;
        int i4;
        int beginIndex = characterIterator.getBeginIndex();
        int endIndex = characterIterator.getEndIndex();
        synchronized (this) {
            if (this.operations == null) {
                prepare();
            }
            if (this.context == null) {
                this.context = new Context();
            }
        }
        synchronized (this.context) {
            context = this.context.inuse ? new Context() : this.context;
            context.reset(characterIterator, beginIndex, endIndex, this.numberOfClosures);
        }
        if (match != null) {
            match.setNumberOfGroups(this.nofparen);
            match.setSource(characterIterator);
        } else if (this.hasBackReferences) {
            match = new Match();
            match.setNumberOfGroups(this.nofparen);
        }
        context.match = match;
        if (isSet(this.options, 512)) {
            int iMatchCharacterIterator2 = matchCharacterIterator(context, this.operations, context.start, 1, this.options);
            if (iMatchCharacterIterator2 != context.limit) {
                return DEBUG;
            }
            if (context.match != null) {
                context.match.setBeginning(0, context.start);
                context.match.setEnd(0, iMatchCharacterIterator2);
            }
            context.inuse = DEBUG;
            return true;
        }
        if (this.fixedStringOnly) {
            int iMatches = this.fixedStringTable.matches(characterIterator, context.start, context.limit);
            if (iMatches >= 0) {
                if (context.match != null) {
                    context.match.setBeginning(0, iMatches);
                    context.match.setEnd(0, iMatches + this.fixedString.length());
                }
                context.inuse = DEBUG;
                return true;
            }
            context.inuse = DEBUG;
            return DEBUG;
        }
        if (this.fixedString != null && this.fixedStringTable.matches(characterIterator, context.start, context.limit) < 0) {
            context.inuse = DEBUG;
            return DEBUG;
        }
        int i5 = context.limit - this.minlength;
        Op op = this.operations;
        int iMatchCharacterIterator3 = -1;
        if (op != null && op.type == 7 && this.operations.getChild().type == 0) {
            if (isSet(this.options, 4)) {
                i = context.start;
                iMatchCharacterIterator = matchCharacterIterator(context, this.operations, context.start, 1, this.options);
            } else {
                int i6 = context.start;
                boolean z = true;
                while (i6 <= i5) {
                    if (isEOLChar(characterIterator.setIndex(i6))) {
                        z = true;
                    } else {
                        if (z) {
                            iMatchCharacterIterator3 = matchCharacterIterator(context, this.operations, i6, 1, this.options);
                            if (iMatchCharacterIterator3 >= 0) {
                                break;
                            }
                        }
                        z = false;
                    }
                    i6++;
                }
                iMatchCharacterIterator = iMatchCharacterIterator3;
                i = i6;
            }
        } else {
            RangeToken rangeToken = this.firstChar;
            if (rangeToken != null) {
                if (isSet(this.options, 2)) {
                    RangeToken caseInsensitiveToken = this.firstChar.getCaseInsensitiveToken();
                    i2 = context.start;
                    while (i2 <= i5) {
                        char index = characterIterator.setIndex(i2);
                        if (REUtil.isHighSurrogate(index) && (i4 = i2 + 1) < context.limit) {
                            if (caseInsensitiveToken.match(REUtil.composeFromSurrogates(index, characterIterator.setIndex(i4)))) {
                                iMatchCharacterIterator3 = matchCharacterIterator(context, this.operations, i2, 1, this.options);
                                if (iMatchCharacterIterator3 >= 0) {
                                    break;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } else if (!caseInsensitiveToken.match(index)) {
                            char upperCase = Character.toUpperCase(index);
                            if (caseInsensitiveToken.match(upperCase) || caseInsensitiveToken.match(Character.toLowerCase(upperCase))) {
                                iMatchCharacterIterator3 = matchCharacterIterator(context, this.operations, i2, 1, this.options);
                                if (iMatchCharacterIterator3 >= 0) {
                                    break;
                                }
                            }
                        } else {
                            iMatchCharacterIterator3 = matchCharacterIterator(context, this.operations, i2, 1, this.options);
                            if (iMatchCharacterIterator3 >= 0) {
                                break;
                                break;
                            }
                        }
                        i2++;
                    }
                } else {
                    i2 = context.start;
                    while (i2 <= i5) {
                        int index2 = characterIterator.setIndex(i2);
                        if (REUtil.isHighSurrogate(index2) && (i3 = i2 + 1) < context.limit) {
                            index2 = REUtil.composeFromSurrogates(index2, characterIterator.setIndex(i3));
                        }
                        if (rangeToken.match(index2)) {
                            iMatchCharacterIterator3 = matchCharacterIterator(context, this.operations, i2, 1, this.options);
                            if (iMatchCharacterIterator3 >= 0) {
                                break;
                            }
                        }
                        i2++;
                    }
                }
                iMatchCharacterIterator = iMatchCharacterIterator3;
                i = i2;
            } else {
                i = context.start;
                while (i <= i5) {
                    iMatchCharacterIterator3 = matchCharacterIterator(context, this.operations, i, 1, this.options);
                    if (iMatchCharacterIterator3 >= 0) {
                        break;
                    }
                    i++;
                }
                iMatchCharacterIterator = iMatchCharacterIterator3;
            }
        }
        if (iMatchCharacterIterator >= 0) {
            if (context.match != null) {
                context.match.setBeginning(0, i);
                context.match.setEnd(0, iMatchCharacterIterator);
            }
            context.inuse = DEBUG;
            return true;
        }
        context.inuse = DEBUG;
        return DEBUG;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    private int matchCharacterIterator(Context context, Op op, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int wordType;
        int wordType2;
        int i7;
        int i8;
        CharacterIterator characterIterator = context.ciTarget;
        while (op != null) {
            if (i <= context.limit && i >= context.start) {
                int i9 = op.type;
                boolean z = true;
                if (i9 == 0) {
                    if (i2 > 0) {
                        if (i >= context.limit) {
                            return -1;
                        }
                        int index = characterIterator.setIndex(i);
                        if (isSet(i3, 4)) {
                            if (REUtil.isHighSurrogate(index) && (i8 = i + 1) < context.limit) {
                                i = i8;
                            }
                        } else {
                            if (REUtil.isHighSurrogate(index) && (i7 = i + 1) < context.limit) {
                                index = REUtil.composeFromSurrogates(index, characterIterator.setIndex(i7));
                                i = i7;
                            }
                            if (isEOLChar(index)) {
                                return -1;
                            }
                        }
                        i++;
                    } else {
                        i--;
                        if (i < context.limit && i >= 0) {
                            int index2 = characterIterator.setIndex(i);
                            if (isSet(i3, 4)) {
                                if (REUtil.isLowSurrogate(index2) && i - 1 >= 0) {
                                    i--;
                                }
                            } else {
                                if (REUtil.isLowSurrogate(index2) && i - 1 >= 0) {
                                    i--;
                                    index2 = REUtil.composeFromSurrogates(characterIterator.setIndex(i), index2);
                                }
                                if (!isEOLChar(index2)) {
                                    return -1;
                                }
                            }
                        }
                    }
                    op = op.next;
                } else if (i9 == 1) {
                    if (isSet(i3, 2)) {
                        int data = op.getData();
                        if (i2 > 0) {
                            if (i >= context.limit || !matchIgnoreCase(data, characterIterator.setIndex(i))) {
                                return -1;
                            }
                            i++;
                        } else {
                            i--;
                            if (i >= context.limit || i < 0 || !matchIgnoreCase(data, characterIterator.setIndex(i))) {
                                return -1;
                            }
                        }
                    } else {
                        int data2 = op.getData();
                        if (i2 > 0) {
                            if (i >= context.limit || data2 != characterIterator.setIndex(i)) {
                                return -1;
                            }
                            i++;
                        } else {
                            i--;
                            if (i >= context.limit || i < 0 || data2 != characterIterator.setIndex(i)) {
                                return -1;
                            }
                        }
                    }
                    op = op.next;
                } else if (i9 == 15) {
                    int data3 = op.getData();
                    if (context.match != null && data3 > 0) {
                        int beginning = context.match.getBeginning(data3);
                        context.match.setBeginning(data3, i);
                        int iMatchCharacterIterator = matchCharacterIterator(context, op.next, i, i2, i3);
                        if (iMatchCharacterIterator < 0) {
                            context.match.setBeginning(data3, beginning);
                        }
                        return iMatchCharacterIterator;
                    }
                    if (context.match != null && data3 < 0) {
                        int i10 = -data3;
                        int end = context.match.getEnd(i10);
                        context.match.setEnd(i10, i);
                        int iMatchCharacterIterator2 = matchCharacterIterator(context, op.next, i, i2, i3);
                        if (iMatchCharacterIterator2 < 0) {
                            context.match.setEnd(i10, end);
                        }
                        return iMatchCharacterIterator2;
                    }
                    op = op.next;
                } else if (i9 != 16) {
                    switch (i9) {
                        case 3:
                        case 4:
                            if (i2 > 0) {
                                if (i >= context.limit) {
                                    return -1;
                                }
                                int index3 = characterIterator.setIndex(i);
                                if (REUtil.isHighSurrogate(index3) && (i4 = i + 1) < context.limit) {
                                    index3 = REUtil.composeFromSurrogates(index3, characterIterator.setIndex(i4));
                                    i = i4;
                                }
                                RangeToken token = op.getToken();
                                if (isSet(i3, 2)) {
                                    RangeToken caseInsensitiveToken = token.getCaseInsensitiveToken();
                                    if (!caseInsensitiveToken.match(index3)) {
                                        if (index3 >= 65536) {
                                            return -1;
                                        }
                                        char upperCase = Character.toUpperCase((char) index3);
                                        if (!caseInsensitiveToken.match(upperCase) && !caseInsensitiveToken.match(Character.toLowerCase(upperCase))) {
                                            return -1;
                                        }
                                    }
                                } else if (!token.match(index3)) {
                                    return -1;
                                }
                                i++;
                            } else {
                                i--;
                                if (i >= context.limit || i < 0) {
                                    return -1;
                                }
                                int index4 = characterIterator.setIndex(i);
                                if (REUtil.isLowSurrogate(index4) && i - 1 >= 0) {
                                    i--;
                                    index4 = REUtil.composeFromSurrogates(characterIterator.setIndex(i), index4);
                                }
                                RangeToken token2 = op.getToken();
                                if (isSet(i3, 2)) {
                                    RangeToken caseInsensitiveToken2 = token2.getCaseInsensitiveToken();
                                    if (!caseInsensitiveToken2.match(index4)) {
                                        if (index4 >= 65536) {
                                            return -1;
                                        }
                                        char upperCase2 = Character.toUpperCase((char) index4);
                                        if (!caseInsensitiveToken2.match(upperCase2) && !caseInsensitiveToken2.match(Character.toLowerCase(upperCase2))) {
                                            return -1;
                                        }
                                    }
                                } else if (!token2.match(index4)) {
                                    return -1;
                                }
                            }
                            op = op.next;
                            break;
                        case 5:
                            int data4 = op.getData();
                            if (data4 != 36) {
                                if (data4 != 60) {
                                    if (data4 != 62) {
                                        if (data4 != 90) {
                                            if (data4 != 94) {
                                                if (data4 != 98) {
                                                    if (data4 != 122) {
                                                        switch (data4) {
                                                            case 64:
                                                                if (i != context.start && (i <= context.start || !isEOLChar(characterIterator.setIndex(i - 1)))) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 65:
                                                                if (i != context.start) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 66:
                                                                if (context.length != 0 && (wordType2 = getWordType(characterIterator, context.start, context.limit, i, i3)) != 0 && wordType2 != getPreviousWordType(characterIterator, context.start, context.limit, i, i3)) {
                                                                    z = false;
                                                                }
                                                                if (!z) {
                                                                    return -1;
                                                                }
                                                                break;
                                                        }
                                                    } else if (i != context.limit) {
                                                        return -1;
                                                    }
                                                } else if (context.length == 0 || (wordType = getWordType(characterIterator, context.start, context.limit, i, i3)) == 0 || wordType == getPreviousWordType(characterIterator, context.start, context.limit, i, i3)) {
                                                    return -1;
                                                }
                                            } else if (isSet(i3, 8)) {
                                                if (i != context.start && (i <= context.start || !isEOLChar(characterIterator.setIndex(i - 1)))) {
                                                    return -1;
                                                }
                                            } else if (i != context.start) {
                                                return -1;
                                            }
                                        } else if (i != context.limit && (((i6 = i + 1) != context.limit || !isEOLChar(characterIterator.setIndex(i))) && (i + 2 != context.limit || characterIterator.setIndex(i) != '\r' || characterIterator.setIndex(i6) != '\n'))) {
                                            return -1;
                                        }
                                    } else if (context.length == 0 || i == context.start || getWordType(characterIterator, context.start, context.limit, i, i3) != 2 || getPreviousWordType(characterIterator, context.start, context.limit, i, i3) != 1) {
                                        return -1;
                                    }
                                } else if (context.length == 0 || i == context.limit || getWordType(characterIterator, context.start, context.limit, i, i3) != 1 || getPreviousWordType(characterIterator, context.start, context.limit, i, i3) != 2) {
                                    return -1;
                                }
                            } else if (isSet(i3, 8)) {
                                if (i != context.limit && (i >= context.limit || !isEOLChar(characterIterator.setIndex(i)))) {
                                    return -1;
                                }
                            } else if (i != context.limit && (((i5 = i + 1) != context.limit || !isEOLChar(characterIterator.setIndex(i))) && (i + 2 != context.limit || characterIterator.setIndex(i) != '\r' || characterIterator.setIndex(i5) != '\n'))) {
                                return -1;
                            }
                            op = op.next;
                            break;
                        case 6:
                            String string = op.getString();
                            int length = string.length();
                            if (isSet(i3, 2)) {
                                if (i2 > 0) {
                                    if (!regionMatchesIgnoreCase(characterIterator, i, context.limit, string, length)) {
                                        return -1;
                                    }
                                    i += length;
                                } else {
                                    i -= length;
                                    if (!regionMatchesIgnoreCase(characterIterator, i, context.limit, string, length)) {
                                        return -1;
                                    }
                                }
                            } else if (i2 > 0) {
                                if (!regionMatches(characterIterator, i, context.limit, string, length)) {
                                    return -1;
                                }
                                i += length;
                            } else {
                                i -= length;
                                if (!regionMatches(characterIterator, i, context.limit, string, length)) {
                                    return -1;
                                }
                            }
                            op = op.next;
                            break;
                        case 7:
                            int data5 = op.getData();
                            if (data5 >= 0) {
                                int i11 = context.offsets[data5];
                                if (i11 < 0 || i11 != i) {
                                    context.offsets[data5] = i;
                                } else {
                                    context.offsets[data5] = -1;
                                    op = op.next;
                                }
                                break;
                            }
                            int iMatchCharacterIterator3 = matchCharacterIterator(context, op.getChild(), i, i2, i3);
                            if (data5 >= 0) {
                                context.offsets[data5] = -1;
                            }
                            if (iMatchCharacterIterator3 >= 0) {
                                return iMatchCharacterIterator3;
                            }
                            op = op.next;
                            break;
                            break;
                        case 8:
                        case 10:
                            int iMatchCharacterIterator4 = matchCharacterIterator(context, op.next, i, i2, i3);
                            if (iMatchCharacterIterator4 >= 0) {
                                return iMatchCharacterIterator4;
                            }
                            op = op.getChild();
                            break;
                            break;
                        case 9:
                            int iMatchCharacterIterator5 = matchCharacterIterator(context, op.getChild(), i, i2, i3);
                            if (iMatchCharacterIterator5 >= 0) {
                                return iMatchCharacterIterator5;
                            }
                            op = op.next;
                            break;
                            break;
                        case 11:
                            for (int i12 = 0; i12 < op.size(); i12++) {
                                int iMatchCharacterIterator6 = matchCharacterIterator(context, op.elementAt(i12), i, i2, i3);
                                if (iMatchCharacterIterator6 >= 0) {
                                    return iMatchCharacterIterator6;
                                }
                            }
                            return -1;
                        default:
                            switch (i9) {
                                case 20:
                                    if (matchCharacterIterator(context, op.getChild(), i, 1, i3) < 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 21:
                                    if (matchCharacterIterator(context, op.getChild(), i, 1, i3) >= 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 22:
                                    if (matchCharacterIterator(context, op.getChild(), i, -1, i3) < 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 23:
                                    if (matchCharacterIterator(context, op.getChild(), i, -1, i3) >= 0) {
                                        return -1;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 24:
                                    i = matchCharacterIterator(context, op.getChild(), i, i2, i3);
                                    if (i < 0) {
                                        return i;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 25:
                                    i = matchCharacterIterator(context, op.getChild(), i, i2, (op.getData() | i3) & (~op.getData2()));
                                    if (i < 0) {
                                        return i;
                                    }
                                    op = op.next;
                                    break;
                                    break;
                                case 26:
                                    Op.ConditionOp conditionOp = (Op.ConditionOp) op;
                                    if (conditionOp.refNumber > 0) {
                                        if (conditionOp.refNumber >= this.nofparen) {
                                            throw new RuntimeException("Internal Error: Reference number must be more than zero: " + conditionOp.refNumber);
                                        }
                                        if (context.match.getBeginning(conditionOp.refNumber) < 0 || context.match.getEnd(conditionOp.refNumber) < 0) {
                                            z = false;
                                        }
                                    } else if (matchCharacterIterator(context, conditionOp.condition, i, i2, i3) < 0) {
                                        z = false;
                                    }
                                    if (z) {
                                        op = conditionOp.yes;
                                    } else if (conditionOp.no != null) {
                                        op = conditionOp.no;
                                    } else {
                                        op = conditionOp.next;
                                    }
                                    break;
                                default:
                                    throw new RuntimeException("Unknown operation type: " + op.type);
                            }
                            break;
                    }
                } else {
                    int data6 = op.getData();
                    if (data6 <= 0 || data6 >= this.nofparen) {
                        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + data6);
                    }
                    if (context.match.getBeginning(data6) < 0 || context.match.getEnd(data6) < 0) {
                        return -1;
                    }
                    int beginning2 = context.match.getBeginning(data6);
                    int end2 = context.match.getEnd(data6) - beginning2;
                    if (isSet(i3, 2)) {
                        if (i2 > 0) {
                            if (!regionMatchesIgnoreCase(characterIterator, i, context.limit, beginning2, end2)) {
                                return -1;
                            }
                            i += end2;
                        } else {
                            i -= end2;
                            if (!regionMatchesIgnoreCase(characterIterator, i, context.limit, beginning2, end2)) {
                                return -1;
                            }
                        }
                    } else if (i2 > 0) {
                        if (!regionMatches(characterIterator, i, context.limit, beginning2, end2)) {
                            return -1;
                        }
                        i += end2;
                    } else {
                        i -= end2;
                        if (!regionMatches(characterIterator, i, context.limit, beginning2, end2)) {
                            return -1;
                        }
                    }
                    op = op.next;
                }
            }
            return -1;
        }
        if (!isSet(i3, 512) || i == context.limit) {
            return i;
        }
        return -1;
    }

    private static final int getPreviousWordType(CharacterIterator characterIterator, int i, int i2, int i3, int i4) {
        int i5 = i3 - 1;
        int wordType = getWordType(characterIterator, i, i2, i5, i4);
        while (wordType == 0) {
            i5--;
            wordType = getWordType(characterIterator, i, i2, i5, i4);
        }
        return wordType;
    }

    private static final int getWordType(CharacterIterator characterIterator, int i, int i2, int i3, int i4) {
        if (i3 < i || i3 >= i2) {
            return 2;
        }
        return getWordType0(characterIterator.setIndex(i3), i4);
    }

    private static final boolean regionMatches(CharacterIterator characterIterator, int i, int i2, String str, int i3) {
        if (i < 0 || i2 - i < i3) {
            return DEBUG;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i + 1;
            int i7 = i4 + 1;
            if (characterIterator.setIndex(i) != str.charAt(i4)) {
                return DEBUG;
            }
            i = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private static final boolean regionMatches(CharacterIterator characterIterator, int i, int i2, int i3, int i4) {
        if (i < 0 || i2 - i < i4) {
            return DEBUG;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i + 1;
            int i7 = i3 + 1;
            if (characterIterator.setIndex(i) != characterIterator.setIndex(i3)) {
                return DEBUG;
            }
            i = i6;
            i3 = i7;
            i4 = i5;
        }
    }

    private static final boolean regionMatchesIgnoreCase(CharacterIterator characterIterator, int i, int i2, String str, int i3) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i3) {
            return DEBUG;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i + 1;
            char index = characterIterator.setIndex(i);
            int i7 = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (index != cCharAt && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(cCharAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return DEBUG;
            }
            i = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private static final boolean regionMatchesIgnoreCase(CharacterIterator characterIterator, int i, int i2, int i3, int i4) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i4) {
            return DEBUG;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i + 1;
            char index = characterIterator.setIndex(i);
            int i7 = i3 + 1;
            char index2 = characterIterator.setIndex(i3);
            if (index != index2 && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(index2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return DEBUG;
            }
            i = i6;
            i3 = i7;
            i4 = i5;
        }
    }

    static final class Context {
        char[] charTarget;
        CharacterIterator ciTarget;
        boolean inuse = RegularExpression.DEBUG;
        int length;
        int limit;
        Match match;
        int[] offsets;
        int start;
        String strTarget;

        Context() {
        }

        private void resetCommon(int i) {
            this.length = this.limit - this.start;
            this.inuse = true;
            this.match = null;
            int[] iArr = this.offsets;
            if (iArr == null || iArr.length != i) {
                this.offsets = new int[i];
            }
            for (int i2 = 0; i2 < i; i2++) {
                this.offsets[i2] = -1;
            }
        }

        void reset(CharacterIterator characterIterator, int i, int i2, int i3) {
            this.ciTarget = characterIterator;
            this.start = i;
            this.limit = i2;
            resetCommon(i3);
        }

        void reset(String str, int i, int i2, int i3) {
            this.strTarget = str;
            this.start = i;
            this.limit = i2;
            resetCommon(i3);
        }

        void reset(char[] cArr, int i, int i2, int i3) {
            this.charTarget = cArr;
            this.start = i;
            this.limit = i2;
            resetCommon(i3);
        }
    }

    void prepare() {
        compile(this.tokentree);
        this.minlength = this.tokentree.getMinLength();
        this.firstChar = null;
        if (!isSet(this.options, 128) && !isSet(this.options, 512)) {
            RangeToken rangeTokenCreateRange = Token.createRange();
            if (this.tokentree.analyzeFirstCharacter(rangeTokenCreateRange, this.options) == 1) {
                rangeTokenCreateRange.compactRanges();
                this.firstChar = rangeTokenCreateRange;
            }
        }
        Op op = this.operations;
        if (op != null && ((op.type == 6 || this.operations.type == 1) && this.operations.next == null)) {
            this.fixedStringOnly = true;
            if (this.operations.type == 6) {
                this.fixedString = this.operations.getString();
            } else if (this.operations.getData() >= 65536) {
                this.fixedString = REUtil.decomposeToSurrogates(this.operations.getData());
            } else {
                this.fixedString = new String(new char[]{(char) this.operations.getData()});
            }
            this.fixedStringOptions = this.options;
            this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
            return;
        }
        if (isSet(this.options, 256) || isSet(this.options, 512)) {
            return;
        }
        Token.FixedStringContainer fixedStringContainer = new Token.FixedStringContainer();
        this.tokentree.findFixedString(fixedStringContainer, this.options);
        this.fixedString = fixedStringContainer.token == null ? null : fixedStringContainer.token.getString();
        this.fixedStringOptions = fixedStringContainer.options;
        String str = this.fixedString;
        if (str != null && str.length() < 2) {
            this.fixedString = null;
        }
        if (this.fixedString != null) {
            this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
        }
    }

    public RegularExpression(String str) throws ParseException {
        this.hasBackReferences = DEBUG;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = DEBUG;
        setPattern(str, (String) null);
    }

    public RegularExpression(String str, String str2) throws ParseException {
        this.hasBackReferences = DEBUG;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = DEBUG;
        setPattern(str, str2);
    }

    RegularExpression(String str, Token token, int i, boolean z, int i2) {
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = DEBUG;
        this.regex = str;
        this.tokentree = token;
        this.nofparen = i;
        this.options = i2;
        this.hasBackReferences = z;
    }

    public void setPattern(String str) throws ParseException {
        setPattern(str, this.options);
    }

    private void setPattern(String str, int i) throws ParseException {
        this.regex = str;
        this.options = i;
        RegexParser parserForXMLSchema = isSet(i, 512) ? new ParserForXMLSchema() : new RegexParser();
        this.tokentree = parserForXMLSchema.parse(this.regex, this.options);
        this.nofparen = parserForXMLSchema.parennumber;
        this.hasBackReferences = parserForXMLSchema.hasBackReferences;
        this.operations = null;
        this.context = null;
    }

    public void setPattern(String str, String str2) throws ParseException {
        setPattern(str, REUtil.parseOptions(str2));
    }

    public String getPattern() {
        return this.regex;
    }

    public String toString() {
        return this.tokentree.toString(this.options);
    }

    public String getOptions() {
        return REUtil.createOptionString(this.options);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RegularExpression)) {
            return DEBUG;
        }
        RegularExpression regularExpression = (RegularExpression) obj;
        if (this.regex.equals(regularExpression.regex) && this.options == regularExpression.options) {
            return true;
        }
        return DEBUG;
    }

    boolean equals(String str, int i) {
        if (this.regex.equals(str) && this.options == i) {
            return true;
        }
        return DEBUG;
    }

    public int hashCode() {
        return (this.regex + "/" + getOptions()).hashCode();
    }

    public int getNumberOfGroups() {
        return this.nofparen;
    }

    private static final int getWordType0(char c, int i) {
        if (!isSet(i, 64)) {
            if (isSet(i, 32)) {
                return Token.getRange("IsWord", true).match(c) ? 1 : 2;
            }
            return isWordChar(c) ? 1 : 2;
        }
        int type = Character.getType(c);
        if (type == 15) {
            switch (c) {
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                    return 2;
                default:
                    return 0;
            }
        }
        if (type != 16) {
            switch (type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                case 9:
                case 10:
                case 11:
                    return 1;
                case 6:
                case 7:
                    break;
                default:
                    return 2;
            }
        }
        return 0;
    }

    private static final boolean matchIgnoreCase(int i, int i2) {
        if (i == i2) {
            return true;
        }
        if (i > 65535 || i2 > 65535) {
            return DEBUG;
        }
        char upperCase = Character.toUpperCase((char) i);
        char upperCase2 = Character.toUpperCase((char) i2);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return DEBUG;
    }
}
