package org.apache.xmlbeans.impl.regex;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
class Token implements Serializable {
    static final int ANCHOR = 8;
    static final int BACKREFERENCE = 12;
    static final int CHAR = 0;
    static final int CHAR_FINAL_QUOTE = 30;
    static final int CHAR_INIT_QUOTE = 29;
    static final int CHAR_LETTER = 31;
    static final int CHAR_MARK = 32;
    static final int CHAR_NUMBER = 33;
    static final int CHAR_OTHER = 35;
    static final int CHAR_PUNCTUATION = 36;
    static final int CHAR_SEPARATOR = 34;
    static final int CHAR_SYMBOL = 37;
    static final int CLOSURE = 3;
    static final int CONCAT = 1;
    static final int CONDITION = 26;
    static final boolean COUNTTOKENS = true;
    static final int DOT = 11;
    static final int EMPTY = 7;
    static final int FC_ANY = 2;
    static final int FC_CONTINUE = 0;
    static final int FC_TERMINAL = 1;
    static final int INDEPENDENT = 24;
    static final int LOOKAHEAD = 20;
    static final int LOOKBEHIND = 22;
    static final int MODIFIERGROUP = 25;
    static final int NEGATIVELOOKAHEAD = 21;
    static final int NEGATIVELOOKBEHIND = 23;
    private static final int NONBMP_BLOCK_START = 84;
    static final int NONGREEDYCLOSURE = 9;
    static final int NRANGE = 5;
    static final int PAREN = 6;
    static final int RANGE = 4;
    static final int STRING = 10;
    static final int UNION = 2;
    static final int UTF16_MAX = 1114111;
    private static final String[] blockNames;
    static final String blockRanges = "\u0000\u007f\u0080ÿĀſƀɏɐʯʰ˿̀ͯͰϿЀӿ\u0530֏\u0590\u05ff\u0600ۿ܀ݏހ\u07bfऀॿঀ\u09ff\u0a00\u0a7f\u0a80૿\u0b00\u0b7f\u0b80\u0bffఀ౿ಀ\u0cffഀൿ\u0d80\u0dff\u0e00\u0e7f\u0e80\u0effༀ\u0fffက႟Ⴀჿᄀᇿሀ\u137fᎠ\u13ff᐀ᙿ\u1680\u169fᚠ\u16ffក\u17ff᠀\u18afḀỿἀ\u1fff\u2000\u206f⁰\u209f₠\u20cf⃐\u20ff℀⅏⅐\u218f←⇿∀⋿⌀⏿␀\u243f⑀\u245f①⓿─╿▀▟■◿☀⛿✀➿⠀⣿⺀\u2eff⼀\u2fdf⿰⿿\u3000〿\u3040ゟ゠ヿ\u3100ㄯ\u3130\u318f㆐㆟ㆠㆿ㈀㋿㌀㏿㐀䶵一鿿ꀀ\ua48f꒐\ua4cf가힣\ue000\uf8ff豈\ufaffﬀﭏﭐ﷿︠︯︰﹏﹐\ufe6fﹰ\ufefe\ufeff\ufeff\uff00\uffef";
    private static final Hashtable categories;
    private static final Hashtable categories2;
    private static final String[] categoryNames;
    static final int[] nonBMPBlockRanges;
    static Hashtable nonxs = null;
    static Token token_0to9 = null;
    private static Token token_ccs = null;
    private static Token token_grapheme = null;
    static Token token_not_0to9 = null;
    static Token token_not_spaces = null;
    static Token token_not_wordchars = null;
    static Token token_spaces = null;
    static Token token_wordchars = null;
    static int tokens = 0;
    static final String viramaString = "्্੍્୍்్್്ฺ྄";
    int type;
    static Token token_empty = new Token(7);
    static Token token_linebeginning = createAnchor(94);
    static Token token_linebeginning2 = createAnchor(64);
    static Token token_lineend = createAnchor(36);
    static Token token_stringbeginning = createAnchor(65);
    static Token token_stringend = createAnchor(122);
    static Token token_stringend2 = createAnchor(90);
    static Token token_wordedge = createAnchor(98);
    static Token token_not_wordedge = createAnchor(66);
    static Token token_wordbeginning = createAnchor(60);
    static Token token_wordend = createAnchor(62);
    static Token token_dot = new Token(11);

    private static final boolean isSet(int i, int i2) {
        if ((i & i2) == i2) {
            return COUNTTOKENS;
        }
        return false;
    }

    int getChar() {
        return -1;
    }

    Token getChild(int i) {
        return null;
    }

    int getMax() {
        return -1;
    }

    int getMin() {
        return -1;
    }

    int getParenNumber() {
        return 0;
    }

    int getReferenceNumber() {
        return 0;
    }

    String getString() {
        return null;
    }

    void setMax(int i) {
    }

    void setMin(int i) {
    }

    int size() {
        return 0;
    }

    static {
        RangeToken rangeTokenCreateRange = createRange();
        token_0to9 = rangeTokenCreateRange;
        rangeTokenCreateRange.addRange(48, 57);
        RangeToken rangeTokenCreateRange2 = createRange();
        token_wordchars = rangeTokenCreateRange2;
        rangeTokenCreateRange2.addRange(48, 57);
        token_wordchars.addRange(65, 90);
        token_wordchars.addRange(95, 95);
        token_wordchars.addRange(97, 122);
        RangeToken rangeTokenCreateRange3 = createRange();
        token_spaces = rangeTokenCreateRange3;
        rangeTokenCreateRange3.addRange(9, 9);
        token_spaces.addRange(10, 10);
        token_spaces.addRange(12, 12);
        token_spaces.addRange(13, 13);
        token_spaces.addRange(32, 32);
        token_not_0to9 = complementRanges(token_0to9);
        token_not_wordchars = complementRanges(token_wordchars);
        token_not_spaces = complementRanges(token_spaces);
        categories = new Hashtable();
        categories2 = new Hashtable();
        categoryNames = new String[]{"Cn", "Lu", "Ll", "Lt", "Lm", "Lo", "Mn", "Me", "Mc", "Nd", "Nl", "No", "Zs", "Zl", "Zp", "Cc", "Cf", null, "Co", "Cs", "Pd", "Ps", "Pe", "Pc", "Po", "Sm", "Sc", "Sk", "So", "Pi", "Pf", "L", "M", "N", "Z", "C", "P", "S"};
        blockNames = new String[]{"Basic Latin", "Latin-1 Supplement", "Latin Extended-A", "Latin Extended-B", "IPA Extensions", "Spacing Modifier Letters", "Combining Diacritical Marks", "Greek", "Cyrillic", "Armenian", "Hebrew", "Arabic", "Syriac", "Thaana", "Devanagari", "Bengali", "Gurmukhi", "Gujarati", "Oriya", "Tamil", "Telugu", "Kannada", "Malayalam", "Sinhala", "Thai", "Lao", "Tibetan", "Myanmar", "Georgian", "Hangul Jamo", "Ethiopic", "Cherokee", "Unified Canadian Aboriginal Syllabics", "Ogham", "Runic", "Khmer", "Mongolian", "Latin Extended Additional", "Greek Extended", "General Punctuation", "Superscripts and Subscripts", "Currency Symbols", "Combining Marks for Symbols", "Letterlike Symbols", "Number Forms", "Arrows", "Mathematical Operators", "Miscellaneous Technical", "Control Pictures", "Optical Character Recognition", "Enclosed Alphanumerics", "Box Drawing", "Block Elements", "Geometric Shapes", "Miscellaneous Symbols", "Dingbats", "Braille Patterns", "CJK Radicals Supplement", "Kangxi Radicals", "Ideographic Description Characters", "CJK Symbols and Punctuation", "Hiragana", "Katakana", "Bopomofo", "Hangul Compatibility Jamo", "Kanbun", "Bopomofo Extended", "Enclosed CJK Letters and Months", "CJK Compatibility", "CJK Unified Ideographs Extension A", "CJK Unified Ideographs", "Yi Syllables", "Yi Radicals", "Hangul Syllables", "Private Use", "CJK Compatibility Ideographs", "Alphabetic Presentation Forms", "Arabic Presentation Forms-A", "Combining Half Marks", "CJK Compatibility Forms", "Small Form Variants", "Arabic Presentation Forms-B", "Specials", "Halfwidth and Fullwidth Forms", "Old Italic", "Gothic", "Deseret", "Byzantine Musical Symbols", "Musical Symbols", "Mathematical Alphanumeric Symbols", "CJK Unified Ideographs Extension B", "CJK Compatibility Ideographs Supplement", "Tags"};
        nonBMPBlockRanges = new int[]{66304, 66351, 66352, 66383, 66560, 66639, 118784, 119039, 119040, 119295, 119808, 120831, 131072, 173782, 194560, 195103, 917504, 917631};
        nonxs = null;
        token_grapheme = null;
        token_ccs = null;
    }

    static ParenToken createLook(int i, Token token) {
        tokens++;
        return new ParenToken(i, token, 0);
    }

    static ParenToken createParen(Token token, int i) {
        tokens++;
        return new ParenToken(6, token, i);
    }

    static ClosureToken createClosure(Token token) {
        tokens++;
        return new ClosureToken(3, token);
    }

    static ClosureToken createNGClosure(Token token) {
        tokens++;
        return new ClosureToken(9, token);
    }

    static ConcatToken createConcat(Token token, Token token2) {
        tokens++;
        return new ConcatToken(token, token2);
    }

    static UnionToken createConcat() {
        tokens++;
        return new UnionToken(1);
    }

    static UnionToken createUnion() {
        tokens++;
        return new UnionToken(2);
    }

    static Token createEmpty() {
        return token_empty;
    }

    static RangeToken createRange() {
        tokens++;
        return new RangeToken(4);
    }

    static RangeToken createNRange() {
        tokens++;
        return new RangeToken(5);
    }

    static CharToken createChar(int i) {
        tokens++;
        return new CharToken(0, i);
    }

    private static CharToken createAnchor(int i) {
        tokens++;
        return new CharToken(8, i);
    }

    static StringToken createBackReference(int i) {
        tokens++;
        return new StringToken(12, null, i);
    }

    static StringToken createString(String str) {
        tokens++;
        return new StringToken(10, str, 0);
    }

    static ModifierToken createModifierGroup(Token token, int i, int i2) {
        tokens++;
        return new ModifierToken(token, i, i2);
    }

    static ConditionToken createCondition(int i, Token token, Token token2, Token token3) {
        tokens++;
        return new ConditionToken(i, token, token2, token3);
    }

    protected Token(int i) {
        this.type = i;
    }

    void addChild(Token token) {
        throw new RuntimeException("Not supported.");
    }

    protected void addRange(int i, int i2) {
        throw new RuntimeException("Not supported.");
    }

    protected void sortRanges() {
        throw new RuntimeException("Not supported.");
    }

    protected void compactRanges() {
        throw new RuntimeException("Not supported.");
    }

    protected void mergeRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    protected void subtractRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    protected void intersectRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    static Token complementRanges(Token token) {
        return RangeToken.complementRanges(token);
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i) {
        return this.type == 11 ? "." : "";
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    /* JADX WARN: Code duplicated, block: B:18:0x004a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0021 A[RETURN] */
    final int getMinLength() {
        int minLength;
        int minLength2;
        int i = this.type;
        switch (i) {
            case 0:
            case 4:
            case 5:
            case 11:
                return 1;
            case 1:
                int minLength3 = 0;
                for (int i2 = 0; i2 < size(); i2++) {
                    minLength3 += getChild(i2).getMinLength();
                }
                return minLength3;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                minLength = getChild(0).getMinLength();
                for (int i3 = 1; i3 < size(); i3++) {
                    minLength2 = getChild(i3).getMinLength();
                    if (minLength2 < minLength) {
                        minLength = minLength2;
                    }
                }
                return minLength;
            case 3:
            case 9:
                if (getMin() >= 0) {
                    return getMin() * getChild(0).getMinLength();
                }
                return 0;
            case 6:
                return getChild(0).getMinLength();
            case 7:
            case 8:
                return 0;
            case 10:
                return getString().length();
            case 12:
                return 0;
            default:
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        return 0;
                    case 24:
                    case 25:
                        return getChild(0).getMinLength();
                    case 26:
                        if (size() == 0) {
                            return 0;
                        }
                        minLength = getChild(0).getMinLength();
                        while (i3 < size()) {
                            minLength2 = getChild(i3).getMinLength();
                            if (minLength2 < minLength) {
                                minLength = minLength2;
                            }
                        }
                        return minLength;
                    default:
                        throw new RuntimeException("Token#getMinLength(): Invalid Type: " + this.type);
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002e  */
    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0054 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:25:0x005d
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    final int getMaxLength() {
        /*
            r4 = this;
            int r0 = r4.type
            r1 = -1
            r2 = 1
            r3 = 0
            switch(r0) {
                case 0: goto L8f;
                case 1: goto L78;
                case 2: goto L4e;
                case 3: goto L39;
                case 4: goto L37;
                case 5: goto L37;
                case 6: goto L2e;
                case 7: goto L2d;
                case 8: goto L2d;
                case 9: goto L39;
                case 10: goto L24;
                case 11: goto L37;
                case 12: goto L23;
                default: goto L8;
            }
        L8:
            switch(r0) {
                case 20: goto L22;
                case 21: goto L22;
                case 22: goto L22;
                case 23: goto L22;
                case 24: goto L2e;
                case 25: goto L2e;
                case 26: goto L4e;
                default: goto Lb;
            }
        Lb:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Token#getMaxLength(): Invalid Type: "
            r1.<init>(r2)
            int r2 = r4.type
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L22:
            return r3
        L23:
            return r1
        L24:
            java.lang.String r0 = r4.getString()
            int r0 = r0.length()
            return r0
        L2d:
            return r3
        L2e:
            org.apache.xmlbeans.impl.regex.Token r0 = r4.getChild(r3)
            int r0 = r0.getMaxLength()
            return r0
        L37:
            r0 = 2
            return r0
        L39:
            int r0 = r4.getMax()
            if (r0 < 0) goto L4d
            int r0 = r4.getMax()
            org.apache.xmlbeans.impl.regex.Token r1 = r4.getChild(r3)
            int r1 = r1.getMaxLength()
            int r0 = r0 * r1
            return r0
        L4d:
            return r1
        L4e:
            int r0 = r4.size()
            if (r0 != 0) goto L55
            return r3
        L55:
            org.apache.xmlbeans.impl.regex.Token r0 = r4.getChild(r3)
            int r0 = r0.getMaxLength()
        L5d:
            if (r0 < 0) goto L76
            int r3 = r4.size()
            if (r2 >= r3) goto L76
            org.apache.xmlbeans.impl.regex.Token r3 = r4.getChild(r2)
            int r3 = r3.getMaxLength()
            if (r3 >= 0) goto L70
            goto L77
        L70:
            if (r3 <= r0) goto L73
            r0 = r3
        L73:
            int r2 = r2 + 1
            goto L5d
        L76:
            r1 = r0
        L77:
            return r1
        L78:
            r0 = r3
        L79:
            int r2 = r4.size()
            if (r3 >= r2) goto L8e
            org.apache.xmlbeans.impl.regex.Token r2 = r4.getChild(r3)
            int r2 = r2.getMaxLength()
            if (r2 >= 0) goto L8a
            return r1
        L8a:
            int r0 = r0 + r2
            int r3 = r3 + 1
            goto L79
        L8e:
            return r0
        L8f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.Token.getMaxLength():int");
    }

    final int analyzeFirstCharacter(RangeToken rangeToken, int i) {
        int i2 = this.type;
        switch (i2) {
            case 0:
                int i3 = getChar();
                rangeToken.addRange(i3, i3);
                if (i3 < 65536 && isSet(i, 2)) {
                    char upperCase = Character.toUpperCase((char) i3);
                    rangeToken.addRange(upperCase, upperCase);
                    char lowerCase = Character.toLowerCase(upperCase);
                    rangeToken.addRange(lowerCase, lowerCase);
                }
                return 1;
            case 1:
                int iAnalyzeFirstCharacter = 0;
                for (int i4 = 0; i4 < size() && (iAnalyzeFirstCharacter = getChild(i4).analyzeFirstCharacter(rangeToken, i)) == 0; i4++) {
                }
                return iAnalyzeFirstCharacter;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                int iAnalyzeFirstCharacter2 = 0;
                boolean z = false;
                for (int i5 = 0; i5 < size() && (iAnalyzeFirstCharacter2 = getChild(i5).analyzeFirstCharacter(rangeToken, i)) != 2; i5++) {
                    if (iAnalyzeFirstCharacter2 == 0) {
                        z = true;
                    }
                }
                if (z) {
                    return 0;
                }
                return iAnalyzeFirstCharacter2;
            case 3:
            case 9:
                getChild(0).analyzeFirstCharacter(rangeToken, i);
                return 0;
            case 4:
                if (isSet(i, 2)) {
                    rangeToken.mergeRanges(((RangeToken) this).getCaseInsensitiveToken());
                } else {
                    rangeToken.mergeRanges(this);
                }
                return 1;
            case 5:
                if (isSet(i, 2)) {
                    rangeToken.mergeRanges(complementRanges(((RangeToken) this).getCaseInsensitiveToken()));
                } else {
                    rangeToken.mergeRanges(complementRanges(this));
                }
                return 1;
            case 6:
                break;
            case 7:
            case 8:
                return 0;
            case 10:
                int iCharAt = getString().charAt(0);
                if (REUtil.isHighSurrogate(iCharAt) && getString().length() >= 2) {
                    char cCharAt = getString().charAt(1);
                    if (REUtil.isLowSurrogate(cCharAt)) {
                        iCharAt = REUtil.composeFromSurrogates(iCharAt, cCharAt);
                    }
                }
                rangeToken.addRange(iCharAt, iCharAt);
                if (iCharAt < 65536 && isSet(i, 2)) {
                    char upperCase2 = Character.toUpperCase((char) iCharAt);
                    rangeToken.addRange(upperCase2, upperCase2);
                    char lowerCase2 = Character.toLowerCase(upperCase2);
                    rangeToken.addRange(lowerCase2, lowerCase2);
                }
                return 1;
            case 11:
                isSet(i, 4);
                return 0;
            case 12:
                rangeToken.addRange(0, UTF16_MAX);
                return 2;
            default:
                switch (i2) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        return 0;
                    case 24:
                        break;
                    case 25:
                        ModifierToken modifierToken = (ModifierToken) this;
                        return getChild(0).analyzeFirstCharacter(rangeToken, (i | modifierToken.getOptions()) & (~modifierToken.getOptionsMask()));
                    case 26:
                        int iAnalyzeFirstCharacter3 = getChild(0).analyzeFirstCharacter(rangeToken, i);
                        if (size() == 1) {
                            return 0;
                        }
                        if (iAnalyzeFirstCharacter3 == 2) {
                            return iAnalyzeFirstCharacter3;
                        }
                        int iAnalyzeFirstCharacter4 = getChild(1).analyzeFirstCharacter(rangeToken, i);
                        if (iAnalyzeFirstCharacter4 == 2) {
                            return iAnalyzeFirstCharacter4;
                        }
                        return (iAnalyzeFirstCharacter3 == 0 || iAnalyzeFirstCharacter4 == 0) ? 0 : 1;
                    default:
                        throw new RuntimeException("Token#analyzeHeadCharacter(): Invalid Type: " + this.type);
                }
                break;
        }
        return getChild(0).analyzeFirstCharacter(rangeToken, i);
    }

    private final boolean isShorterThan(Token token) {
        if (token == null) {
            return false;
        }
        if (this.type != 10) {
            throw new RuntimeException("Internal Error: Illegal type: " + this.type);
        }
        int length = getString().length();
        if (token.type != 10) {
            throw new RuntimeException("Internal Error: Illegal type: " + token.type);
        }
        if (length < token.getString().length()) {
            return COUNTTOKENS;
        }
        return false;
    }

    static class FixedStringContainer {
        Token token = null;
        int options = 0;

        FixedStringContainer() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003c  */
    /* JADX WARN: Code duplicated, block: B:13:0x0044  */
    final void findFixedString(FixedStringContainer fixedStringContainer, int i) {
        int i2 = this.type;
        Token token = null;
        switch (i2) {
            case 0:
                fixedStringContainer.token = null;
                return;
            case 1:
                int i3 = 0;
                for (int i4 = 0; i4 < size(); i4++) {
                    getChild(i4).findFixedString(fixedStringContainer, i);
                    if (token == null || token.isShorterThan(fixedStringContainer.token)) {
                        token = fixedStringContainer.token;
                        i3 = fixedStringContainer.options;
                    }
                }
                fixedStringContainer.token = token;
                fixedStringContainer.options = i3;
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
                fixedStringContainer.token = null;
                return;
            case 6:
                getChild(0).findFixedString(fixedStringContainer, i);
                return;
            case 10:
                fixedStringContainer.token = this;
                fixedStringContainer.options = i;
                return;
            default:
                switch (i2) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 26:
                        fixedStringContainer.token = null;
                        return;
                    case 24:
                        getChild(0).findFixedString(fixedStringContainer, i);
                        return;
                    case 25:
                        ModifierToken modifierToken = (ModifierToken) this;
                        getChild(0).findFixedString(fixedStringContainer, (i | modifierToken.getOptions()) & (~modifierToken.getOptionsMask()));
                        return;
                    default:
                        throw new RuntimeException("Token#findFixedString(): Invalid Type: " + this.type);
                }
        }
    }

    boolean match(int i) {
        throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type);
    }

    protected static RangeToken getRange(String str, boolean z) {
        Hashtable hashtable = categories;
        if (hashtable.size() == 0) {
            synchronized (hashtable) {
                int length = categoryNames.length;
                Token[] tokenArr = new Token[length];
                for (int i = 0; i < length; i++) {
                    tokenArr[i] = createRange();
                }
                int i2 = 0;
                while (true) {
                    char c = '\"';
                    if (i2 < 65536) {
                        int type = Character.getType((char) i2);
                        if (type == 21 || type == 22) {
                            if (i2 == 171 || i2 == 8216 || i2 == 8219 || i2 == 8220 || i2 == 8223 || i2 == 8249) {
                                type = 29;
                            }
                            if (i2 == 187 || i2 == 8217 || i2 == 8221 || i2 == 8250) {
                                type = 30;
                            }
                        }
                        tokenArr[type].addRange(i2, i2);
                        switch (type) {
                            case 0:
                            case 15:
                            case 16:
                            case 18:
                            case 19:
                                c = '#';
                                break;
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                c = 31;
                                break;
                            case 6:
                            case 7:
                            case 8:
                                c = ' ';
                                break;
                            case 9:
                            case 10:
                            case 11:
                                c = '!';
                                break;
                            case 12:
                            case 13:
                            case 14:
                                break;
                            case 17:
                            default:
                                throw new RuntimeException("org.apache.xerces.utils.regex.Token#getRange(): Unknown Unicode category: " + type);
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 29:
                            case 30:
                                c = '$';
                                break;
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                                c = '%';
                                break;
                        }
                        tokenArr[c].addRange(i2, i2);
                        i2++;
                    } else {
                        tokenArr[0].addRange(65536, UTF16_MAX);
                        for (int i3 = 0; i3 < length; i3++) {
                            String[] strArr = categoryNames;
                            if (strArr[i3] != null) {
                                if (i3 == 0) {
                                    tokenArr[i3].addRange(65536, UTF16_MAX);
                                }
                                categories.put(strArr[i3], tokenArr[i3]);
                                categories2.put(strArr[i3], complementRanges(tokenArr[i3]));
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer(50);
                        int i4 = 0;
                        while (true) {
                            String[] strArr2 = blockNames;
                            if (i4 < strArr2.length) {
                                RangeToken rangeTokenCreateRange = createRange();
                                if (i4 < 84) {
                                    int i5 = i4 * 2;
                                    rangeTokenCreateRange.addRange(blockRanges.charAt(i5), blockRanges.charAt(i5 + 1));
                                } else {
                                    int i6 = (i4 - 84) * 2;
                                    int[] iArr = nonBMPBlockRanges;
                                    rangeTokenCreateRange.addRange(iArr[i6], iArr[i6 + 1]);
                                }
                                String str2 = strArr2[i4];
                                if (str2.equals("Specials")) {
                                    rangeTokenCreateRange.addRange(65520, 65533);
                                }
                                if (str2.equals("Private Use")) {
                                    rangeTokenCreateRange.addRange(983040, 1048573);
                                    rangeTokenCreateRange.addRange(1048576, 1114109);
                                }
                                categories.put(str2, rangeTokenCreateRange);
                                categories2.put(str2, complementRanges(rangeTokenCreateRange));
                                stringBuffer.setLength(0);
                                stringBuffer.append("Is");
                                if (str2.indexOf(32) >= 0) {
                                    for (int i7 = 0; i7 < str2.length(); i7++) {
                                        if (str2.charAt(i7) != ' ') {
                                            stringBuffer.append(str2.charAt(i7));
                                        }
                                    }
                                } else {
                                    stringBuffer.append(str2);
                                }
                                setAlias(stringBuffer.toString(), str2, COUNTTOKENS);
                                i4++;
                            } else {
                                setAlias("ASSIGNED", "Cn", false);
                                setAlias("UNASSIGNED", "Cn", COUNTTOKENS);
                                RangeToken rangeTokenCreateRange2 = createRange();
                                rangeTokenCreateRange2.addRange(0, UTF16_MAX);
                                Hashtable hashtable2 = categories;
                                hashtable2.put("ALL", rangeTokenCreateRange2);
                                Hashtable hashtable3 = categories2;
                                hashtable3.put("ALL", complementRanges(rangeTokenCreateRange2));
                                registerNonXS("ASSIGNED");
                                registerNonXS("UNASSIGNED");
                                registerNonXS("ALL");
                                RangeToken rangeTokenCreateRange3 = createRange();
                                rangeTokenCreateRange3.mergeRanges(tokenArr[1]);
                                rangeTokenCreateRange3.mergeRanges(tokenArr[2]);
                                rangeTokenCreateRange3.mergeRanges(tokenArr[5]);
                                hashtable2.put("IsAlpha", rangeTokenCreateRange3);
                                hashtable3.put("IsAlpha", complementRanges(rangeTokenCreateRange3));
                                registerNonXS("IsAlpha");
                                RangeToken rangeTokenCreateRange4 = createRange();
                                rangeTokenCreateRange4.mergeRanges(rangeTokenCreateRange3);
                                rangeTokenCreateRange4.mergeRanges(tokenArr[9]);
                                hashtable2.put("IsAlnum", rangeTokenCreateRange4);
                                hashtable3.put("IsAlnum", complementRanges(rangeTokenCreateRange4));
                                registerNonXS("IsAlnum");
                                RangeToken rangeTokenCreateRange5 = createRange();
                                rangeTokenCreateRange5.mergeRanges(token_spaces);
                                rangeTokenCreateRange5.mergeRanges(tokenArr[34]);
                                hashtable2.put("IsSpace", rangeTokenCreateRange5);
                                hashtable3.put("IsSpace", complementRanges(rangeTokenCreateRange5));
                                registerNonXS("IsSpace");
                                RangeToken rangeTokenCreateRange6 = createRange();
                                rangeTokenCreateRange6.mergeRanges(rangeTokenCreateRange4);
                                rangeTokenCreateRange6.addRange(95, 95);
                                hashtable2.put("IsWord", rangeTokenCreateRange6);
                                hashtable3.put("IsWord", complementRanges(rangeTokenCreateRange6));
                                registerNonXS("IsWord");
                                RangeToken rangeTokenCreateRange7 = createRange();
                                rangeTokenCreateRange7.addRange(0, 127);
                                hashtable2.put("IsASCII", rangeTokenCreateRange7);
                                hashtable3.put("IsASCII", complementRanges(rangeTokenCreateRange7));
                                registerNonXS("IsASCII");
                                RangeToken rangeTokenCreateRange8 = createRange();
                                rangeTokenCreateRange8.mergeRanges(tokenArr[35]);
                                rangeTokenCreateRange8.addRange(32, 32);
                                hashtable2.put("IsGraph", complementRanges(rangeTokenCreateRange8));
                                hashtable3.put("IsGraph", rangeTokenCreateRange8);
                                registerNonXS("IsGraph");
                                RangeToken rangeTokenCreateRange9 = createRange();
                                rangeTokenCreateRange9.addRange(48, 57);
                                rangeTokenCreateRange9.addRange(65, 70);
                                rangeTokenCreateRange9.addRange(97, 102);
                                hashtable2.put("IsXDigit", complementRanges(rangeTokenCreateRange9));
                                hashtable3.put("IsXDigit", rangeTokenCreateRange9);
                                registerNonXS("IsXDigit");
                                setAlias("IsDigit", "Nd", COUNTTOKENS);
                                setAlias("IsUpper", "Lu", COUNTTOKENS);
                                setAlias("IsLower", "Ll", COUNTTOKENS);
                                setAlias("IsCntrl", "C", COUNTTOKENS);
                                setAlias("IsPrint", "C", false);
                                setAlias("IsPunct", "P", COUNTTOKENS);
                                registerNonXS("IsDigit");
                                registerNonXS("IsUpper");
                                registerNonXS("IsLower");
                                registerNonXS("IsCntrl");
                                registerNonXS("IsPrint");
                                registerNonXS("IsPunct");
                                setAlias("alpha", "IsAlpha", COUNTTOKENS);
                                setAlias("alnum", "IsAlnum", COUNTTOKENS);
                                setAlias("ascii", "IsASCII", COUNTTOKENS);
                                setAlias("cntrl", "IsCntrl", COUNTTOKENS);
                                setAlias("digit", "IsDigit", COUNTTOKENS);
                                setAlias("graph", "IsGraph", COUNTTOKENS);
                                setAlias("lower", "IsLower", COUNTTOKENS);
                                setAlias("print", "IsPrint", COUNTTOKENS);
                                setAlias("punct", "IsPunct", COUNTTOKENS);
                                setAlias("space", "IsSpace", COUNTTOKENS);
                                setAlias("upper", "IsUpper", COUNTTOKENS);
                                setAlias("word", "IsWord", COUNTTOKENS);
                                setAlias("xdigit", "IsXDigit", COUNTTOKENS);
                                registerNonXS("alpha");
                                registerNonXS("alnum");
                                registerNonXS("ascii");
                                registerNonXS("cntrl");
                                registerNonXS("digit");
                                registerNonXS("graph");
                                registerNonXS("lower");
                                registerNonXS("print");
                                registerNonXS("punct");
                                registerNonXS("space");
                                registerNonXS("upper");
                                registerNonXS("word");
                                registerNonXS("xdigit");
                            }
                        }
                    }
                }
            }
        }
        return (RangeToken) (z ? categories : categories2).get(str);
    }

    protected static RangeToken getRange(String str, boolean z, boolean z2) {
        RangeToken range = getRange(str, z);
        if (z2 && range != null && isRegisterNonXS(str)) {
            return null;
        }
        return range;
    }

    protected static void registerNonXS(String str) {
        if (nonxs == null) {
            nonxs = new Hashtable();
        }
        nonxs.put(str, str);
    }

    protected static boolean isRegisterNonXS(String str) {
        Hashtable hashtable = nonxs;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str);
    }

    private static void setAlias(String str, String str2, boolean z) {
        Hashtable hashtable = categories;
        Token token = (Token) hashtable.get(str2);
        Hashtable hashtable2 = categories2;
        Token token2 = (Token) hashtable2.get(str2);
        if (z) {
            hashtable.put(str, token);
            hashtable2.put(str, token2);
        } else {
            hashtable2.put(str, token);
            hashtable.put(str, token2);
        }
    }

    static synchronized Token getGraphemePattern() {
        Token token = token_grapheme;
        if (token != null) {
            return token;
        }
        RangeToken rangeTokenCreateRange = createRange();
        rangeTokenCreateRange.mergeRanges(getRange("ASSIGNED", COUNTTOKENS));
        rangeTokenCreateRange.subtractRanges(getRange("M", COUNTTOKENS));
        rangeTokenCreateRange.subtractRanges(getRange("C", COUNTTOKENS));
        RangeToken rangeTokenCreateRange2 = createRange();
        for (int i = 0; i < 11; i++) {
            viramaString.charAt(i);
            rangeTokenCreateRange2.addRange(i, i);
        }
        RangeToken rangeTokenCreateRange3 = createRange();
        rangeTokenCreateRange3.mergeRanges(getRange("M", COUNTTOKENS));
        rangeTokenCreateRange3.addRange(4448, 4607);
        rangeTokenCreateRange3.addRange(65438, 65439);
        UnionToken unionTokenCreateUnion = createUnion();
        unionTokenCreateUnion.addChild(rangeTokenCreateRange);
        unionTokenCreateUnion.addChild(token_empty);
        UnionToken unionTokenCreateUnion2 = createUnion();
        unionTokenCreateUnion2.addChild(createConcat(rangeTokenCreateRange2, getRange("L", COUNTTOKENS)));
        unionTokenCreateUnion2.addChild(rangeTokenCreateRange3);
        ConcatToken concatTokenCreateConcat = createConcat(unionTokenCreateUnion, createClosure(unionTokenCreateUnion2));
        token_grapheme = concatTokenCreateConcat;
        return concatTokenCreateConcat;
    }

    static synchronized Token getCombiningCharacterSequence() {
        Token token = token_ccs;
        if (token != null) {
            return token;
        }
        ConcatToken concatTokenCreateConcat = createConcat(getRange("M", false), createClosure(getRange("M", COUNTTOKENS)));
        token_ccs = concatTokenCreateConcat;
        return concatTokenCreateConcat;
    }

    static class StringToken extends Token implements Serializable {
        int refNumber;
        String string;

        StringToken(int i, String str, int i2) {
            super(i);
            this.string = str;
            this.refNumber = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getReferenceNumber() {
            return this.refNumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        String getString() {
            return this.string;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.type == 12) {
                return "\\" + this.refNumber;
            }
            return REUtil.quoteMeta(this.string);
        }
    }

    static class ConcatToken extends Token implements Serializable {
        Token child;
        Token child2;

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 2;
        }

        ConcatToken(Token token, Token token2) {
            super(1);
            this.child = token;
            this.child2 = token2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return i == 0 ? this.child : this.child2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.child2.type == 3 && this.child2.getChild(0) == this.child) {
                return this.child.toString(i) + "+";
            }
            if (this.child2.type == 9 && this.child2.getChild(0) == this.child) {
                return this.child.toString(i) + "+?";
            }
            return this.child.toString(i) + this.child2.toString(i);
        }
    }

    static class CharToken extends Token implements Serializable {
        int chardata;

        CharToken(int i, int i2) {
            super(i);
            this.chardata = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getChar() {
            return this.chardata;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            int i2 = this.type;
            if (i2 != 0) {
                if (i2 != 8) {
                    return null;
                }
                if (this == Token.token_linebeginning || this == Token.token_lineend) {
                    return "" + ((char) this.chardata);
                }
                return "\\" + ((char) this.chardata);
            }
            int i3 = this.chardata;
            if (i3 == 9) {
                return "\\t";
            }
            if (i3 == 10) {
                return "\\n";
            }
            if (i3 == 12) {
                return "\\f";
            }
            if (i3 == 13) {
                return "\\r";
            }
            if (i3 == 27) {
                return "\\e";
            }
            if (i3 != 46 && i3 != 63 && i3 != 91 && i3 != 92 && i3 != 123 && i3 != 124) {
                switch (i3) {
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                        break;
                    default:
                        if (i3 >= 65536) {
                            String str = "0" + Integer.toHexString(this.chardata);
                            return "\\v" + str.substring(str.length() - 6, str.length());
                        }
                        return "" + ((char) this.chardata);
                }
            }
            return "\\" + ((char) this.chardata);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        boolean match(int i) {
            if (this.type == 0) {
                if (i == this.chardata) {
                    return Token.COUNTTOKENS;
                }
                return false;
            }
            throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type);
        }
    }

    static class ClosureToken extends Token implements Serializable {
        Token child;
        int max;
        int min;

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        ClosureToken(int i, Token token) {
            super(i);
            this.child = token;
            setMin(-1);
            setMax(-1);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final void setMin(int i) {
            this.min = i;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final void setMax(int i) {
            this.max = i;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final int getMin() {
            return this.min;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final int getMax() {
            return this.max;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.type == 3) {
                if (getMin() < 0 && getMax() < 0) {
                    return this.child.toString(i) + "*";
                }
                if (getMin() == getMax()) {
                    return this.child.toString(i) + "{" + getMin() + "}";
                }
                if (getMin() >= 0 && getMax() >= 0) {
                    return this.child.toString(i) + "{" + getMin() + "," + getMax() + "}";
                }
                if (getMin() >= 0 && getMax() < 0) {
                    return this.child.toString(i) + "{" + getMin() + ",}";
                }
                throw new RuntimeException("Token#toString(): CLOSURE " + getMin() + ", " + getMax());
            }
            if (getMin() < 0 && getMax() < 0) {
                return this.child.toString(i) + "*?";
            }
            if (getMin() == getMax()) {
                return this.child.toString(i) + "{" + getMin() + "}?";
            }
            if (getMin() >= 0 && getMax() >= 0) {
                return this.child.toString(i) + "{" + getMin() + "," + getMax() + "}?";
            }
            if (getMin() >= 0 && getMax() < 0) {
                return this.child.toString(i) + "{" + getMin() + ",}?";
            }
            throw new RuntimeException("Token#toString(): NONGREEDYCLOSURE " + getMin() + ", " + getMax());
        }
    }

    static class ParenToken extends Token implements Serializable {
        Token child;
        int parennumber;

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        ParenToken(int i, Token token, int i2) {
            super(i);
            this.child = token;
            this.parennumber = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getParenNumber() {
            return this.parennumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            int i2 = this.type;
            if (i2 == 6) {
                if (this.parennumber == 0) {
                    return "(?:" + this.child.toString(i) + ")";
                }
                return "(" + this.child.toString(i) + ")";
            }
            switch (i2) {
                case 20:
                    return "(?=" + this.child.toString(i) + ")";
                case 21:
                    return "(?!" + this.child.toString(i) + ")";
                case 22:
                    return "(?<=" + this.child.toString(i) + ")";
                case 23:
                    return "(?<!" + this.child.toString(i) + ")";
                case 24:
                    return "(?>" + this.child.toString(i) + ")";
                default:
                    return null;
            }
        }
    }

    static class ConditionToken extends Token implements Serializable {
        Token condition;
        Token no;
        int refNumber;
        Token yes;

        ConditionToken(int i, Token token, Token token2, Token token3) {
            super(26);
            this.refNumber = i;
            this.condition = token;
            this.yes = token2;
            this.no = token3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return this.no == null ? 1 : 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            if (i == 0) {
                return this.yes;
            }
            if (i == 1) {
                return this.no;
            }
            throw new RuntimeException("Internal Error: " + i);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            String str;
            if (this.refNumber > 0) {
                str = "(?(" + this.refNumber + ")";
            } else if (this.condition.type == 8) {
                str = "(?(" + this.condition + ")";
            } else {
                str = "(?" + this.condition;
            }
            if (this.no == null) {
                return str + this.yes + ")";
            }
            return str + this.yes + "|" + this.no + ")";
        }
    }

    static class ModifierToken extends Token implements Serializable {
        int add;
        Token child;
        int mask;

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        ModifierToken(Token token, int i, int i2) {
            super(25);
            this.child = token;
            this.add = i;
            this.mask = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return this.child;
        }

        int getOptions() {
            return this.add;
        }

        int getOptionsMask() {
            return this.mask;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            StringBuilder sb = new StringBuilder("(?");
            int i2 = this.add;
            StringBuilder sbAppend = sb.append(i2 == 0 ? "" : REUtil.createOptionString(i2));
            int i3 = this.mask;
            return sbAppend.append(i3 != 0 ? REUtil.createOptionString(i3) : "").append(":").append(this.child.toString(i)).append(")").toString();
        }
    }

    static class UnionToken extends Token implements Serializable {
        Vector children;

        UnionToken(int i) {
            super(i);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        void addChild(Token token) {
            StringBuffer stringBuffer;
            if (token == null) {
                return;
            }
            if (this.children == null) {
                this.children = new Vector();
            }
            if (this.type == 2) {
                this.children.addElement(token);
                return;
            }
            if (token.type == 1) {
                for (int i = 0; i < token.size(); i++) {
                    addChild(token.getChild(i));
                }
                return;
            }
            int size = this.children.size();
            if (size == 0) {
                this.children.addElement(token);
                return;
            }
            int i2 = size - 1;
            Token tokenCreateString = (Token) this.children.elementAt(i2);
            if ((tokenCreateString.type != 0 && tokenCreateString.type != 10) || (token.type != 0 && token.type != 10)) {
                this.children.addElement(token);
                return;
            }
            int length = token.type == 0 ? 2 : token.getString().length();
            if (tokenCreateString.type == 0) {
                stringBuffer = new StringBuffer(length + 2);
                int i3 = tokenCreateString.getChar();
                if (i3 >= 65536) {
                    stringBuffer.append(REUtil.decomposeToSurrogates(i3));
                } else {
                    stringBuffer.append((char) i3);
                }
                tokenCreateString = Token.createString(null);
                this.children.setElementAt(tokenCreateString, i2);
            } else {
                stringBuffer = new StringBuffer(tokenCreateString.getString().length() + length);
                stringBuffer.append(tokenCreateString.getString());
            }
            if (token.type == 0) {
                int i4 = token.getChar();
                if (i4 >= 65536) {
                    stringBuffer.append(REUtil.decomposeToSurrogates(i4));
                } else {
                    stringBuffer.append((char) i4);
                }
            } else {
                stringBuffer.append(token.getString());
            }
            ((StringToken) tokenCreateString).string = new String(stringBuffer);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            Vector vector = this.children;
            if (vector == null) {
                return 0;
            }
            return vector.size();
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return (Token) this.children.elementAt(i);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.type == 1) {
                if (this.children.size() == 2) {
                    Token child = getChild(0);
                    Token child2 = getChild(1);
                    if (child2.type == 3 && child2.getChild(0) == child) {
                        return child.toString(i) + "+";
                    }
                    if (child2.type == 9 && child2.getChild(0) == child) {
                        return child.toString(i) + "+?";
                    }
                    return child.toString(i) + child2.toString(i);
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < this.children.size(); i2++) {
                    stringBuffer.append(((Token) this.children.elementAt(i2)).toString(i));
                }
                return new String(stringBuffer);
            }
            if (this.children.size() == 2 && getChild(1).type == 7) {
                return getChild(0).toString(i) + "?";
            }
            if (this.children.size() == 2 && getChild(0).type == 7) {
                return getChild(1).toString(i) + "??";
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(((Token) this.children.elementAt(0)).toString(i));
            for (int i3 = 1; i3 < this.children.size(); i3++) {
                stringBuffer2.append('|');
                stringBuffer2.append(((Token) this.children.elementAt(i3)).toString(i));
            }
            return new String(stringBuffer2);
        }
    }
}
