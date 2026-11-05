package org.apache.xmlbeans.impl.regex;

import java.util.Hashtable;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
class ParserForXMLSchema extends RegexParser {
    private static final String DIGITS = "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩";
    private static final String LETTERS = "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣";
    private static final String NAMECHARS = "-.0:AZ__az··ÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁːˑ̀͠͡ͅΆΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁ҃҆ҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆֹֻֽֿֿׁׂ֑֣֡ׄׄאתװײءغـْ٠٩ٰڷںھۀێېۓە۪ۭۨ۰۹ँःअह़्॑॔क़ॣ०९ঁঃঅঌএঐওনপরললশহ়়াৄেৈো্ৗৗড়ঢ়য়ৣ০ৱਂਂਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹ਼਼ਾੂੇੈੋ੍ਖ਼ੜਫ਼ਫ਼੦ੴઁઃઅઋઍઍએઑઓનપરલળવહ઼ૅેૉો્ૠૠ૦૯ଁଃଅଌଏଐଓନପରଲଳଶହ଼ୃେୈୋ୍ୖୗଡ଼ଢ଼ୟୡ୦୯ஂஃஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹாூெைொ்ௗௗ௧௯ఁఃఅఌఎఐఒనపళవహాౄెైొ్ౕౖౠౡ౦౯ಂಃಅಌಎಐಒನಪಳವಹಾೄೆೈೊ್ೕೖೞೞೠೡ೦೯ംഃഅഌഎഐഒനപഹാൃെൈൊ്ൗൗൠൡ൦൯กฮะฺเ๎๐๙ກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະູົຽເໄໆໆ່ໍ໐໙༘༙༠༩༹༹༵༵༷༷༾ཇཉཀྵ྄ཱ྆ྋྐྕྗྗྙྭྱྷྐྵྐྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼ⃐⃜⃡⃡ΩΩKÅ℮℮ↀↂ々々〇〇〡〯〱〵ぁゔ゙゚ゝゞァヺーヾㄅㄬ一龥가힣";
    private static final String SPACES = "\t\n\r\r  ";
    private static Hashtable ranges;
    private static Hashtable ranges2;

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    boolean checkQuestion(int i) {
        return false;
    }

    public ParserForXMLSchema() {
    }

    public ParserForXMLSchema(Locale locale) {
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processCaret() throws ParseException {
        next();
        return Token.createChar(94);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processDollar() throws ParseException {
        next();
        return Token.createChar(36);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processLookahead() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processNegativelookahead() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processLookbehind() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processNegativelookbehind() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_A() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_Z() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_z() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_b() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_B() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_lt() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_gt() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processStar(Token token) throws ParseException {
        next();
        return Token.createClosure(token);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processPlus(Token token) throws ParseException {
        next();
        return Token.createConcat(token, Token.createClosure(token));
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processQuestion(Token token) throws ParseException {
        next();
        Token.UnionToken unionTokenCreateUnion = Token.createUnion();
        unionTokenCreateUnion.addChild(token);
        unionTokenCreateUnion.addChild(Token.createEmpty());
        return unionTokenCreateUnion;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processParen() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), 0);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processParen2() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processCondition() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processModifiers() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processIndependent() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_c() throws ParseException {
        next();
        return getTokenForShorthand(99);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_C() throws ParseException {
        next();
        return getTokenForShorthand(67);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_i() throws ParseException {
        next();
        return getTokenForShorthand(105);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_I() throws ParseException {
        next();
        return getTokenForShorthand(73);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_g() throws ParseException {
        throw ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_X() throws ParseException {
        throw ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBackreference() throws ParseException {
        throw ex("parser.process.1", this.offset - 4);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    int processCIinCharacterClass(RangeToken rangeToken, int i) {
        rangeToken.mergeRanges(getTokenForShorthand(i));
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x0189  */
    /* JADX WARN: Code duplicated, block: B:139:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x018c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e6  */
    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    protected RangeToken parseCharacterClass(boolean z) throws ParseException {
        RangeToken rangeTokenCreateRange;
        RangeToken rangeTokenCreateRange2;
        boolean z2;
        boolean z3;
        setContext(1);
        next();
        boolean z4 = false;
        if (read() == 0 && this.chardata == 94) {
            next();
            rangeTokenCreateRange2 = Token.createRange();
            rangeTokenCreateRange2.addRange(0, 1114111);
            rangeTokenCreateRange = Token.createRange();
            z2 = true;
        } else {
            rangeTokenCreateRange = Token.createRange();
            rangeTokenCreateRange2 = null;
            z2 = false;
        }
        boolean z5 = true;
        while (true) {
            int i = read();
            if (i != 1) {
                if (i != 0 || this.chardata != 93 || z5) {
                    int iProcessCIinCharacterClass = this.chardata;
                    if (i != 10) {
                        if (i == 24 && !z5) {
                            if (z2) {
                                rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
                            } else {
                                rangeTokenCreateRange2 = rangeTokenCreateRange;
                            }
                            rangeTokenCreateRange2.subtractRanges(parseCharacterClass(z4));
                            if (read() == 0 && this.chardata == 93) {
                                break;
                            }
                            throw ex("parser.cc.5", this.offset);
                        }
                    } else {
                        if (iProcessCIinCharacterClass == 67) {
                            iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                            if (iProcessCIinCharacterClass < 0) {
                                z3 = true;
                            }
                        } else {
                            if (iProcessCIinCharacterClass == 68) {
                                rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                            } else if (iProcessCIinCharacterClass == 73) {
                                iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                                if (iProcessCIinCharacterClass < 0) {
                                }
                            } else {
                                if (iProcessCIinCharacterClass != 80) {
                                    if (iProcessCIinCharacterClass != 83 && iProcessCIinCharacterClass != 87) {
                                        if (iProcessCIinCharacterClass == 105) {
                                            iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                                            if (iProcessCIinCharacterClass < 0) {
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
                            z3 = true;
                        }
                        next();
                        if (z3) {
                            if (i == 0) {
                                if (iProcessCIinCharacterClass != 91) {
                                    throw ex("parser.cc.6", this.offset - 2);
                                }
                                if (iProcessCIinCharacterClass != 93) {
                                    throw ex("parser.cc.7", this.offset - 2);
                                }
                                if (iProcessCIinCharacterClass == 45 && !z5 && this.chardata != 93) {
                                    throw ex("parser.cc.8", this.offset - 2);
                                }
                            }
                            if (read() == 0 || this.chardata != 45) {
                                rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                            } else {
                                next();
                                int i3 = read();
                                if (i3 == 1) {
                                    throw ex("parser.cc.2", this.offset);
                                }
                                if (i3 == 24) {
                                    throw ex("parser.cc.8", this.offset - 1);
                                }
                                if (i3 == 0 && this.chardata == 93) {
                                    rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                                    rangeTokenCreateRange.addRange(45, 45);
                                } else {
                                    int iDecodeEscaped = this.chardata;
                                    if (i3 == 0) {
                                        if (iDecodeEscaped == 91) {
                                            throw ex("parser.cc.6", this.offset - 1);
                                        }
                                        if (iDecodeEscaped == 93) {
                                            throw ex("parser.cc.7", this.offset - 1);
                                        }
                                        if (iDecodeEscaped == 45) {
                                            next();
                                            if (this.chardata != 93) {
                                                throw ex("parser.cc.8", this.offset - 2);
                                            }
                                        }
                                    } else if (i3 == 10) {
                                        iDecodeEscaped = decodeEscaped();
                                    }
                                    if (iDecodeEscaped != 45 || this.chardata != 93) {
                                        next();
                                    }
                                    if (iProcessCIinCharacterClass > iDecodeEscaped) {
                                        throw ex("parser.ope.3", this.offset - 1);
                                    }
                                    rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iDecodeEscaped);
                                }
                            }
                        }
                        z4 = false;
                        z5 = false;
                    }
                    z3 = z4;
                    next();
                    if (z3) {
                        if (i == 0) {
                            if (iProcessCIinCharacterClass != 91) {
                                throw ex("parser.cc.6", this.offset - 2);
                            }
                            if (iProcessCIinCharacterClass != 93) {
                                throw ex("parser.cc.7", this.offset - 2);
                            }
                            if (iProcessCIinCharacterClass == 45) {
                                throw ex("parser.cc.8", this.offset - 2);
                            }
                        }
                        if (read() == 0) {
                            rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        } else {
                            rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        }
                    }
                    z4 = false;
                    z5 = false;
                } else if (z2) {
                    rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
                    break;
                }
            }
            rangeTokenCreateRange2 = rangeTokenCreateRange;
            break;
        }
        if (read() == 1) {
            throw ex("parser.cc.2", this.offset);
        }
        rangeTokenCreateRange2.sortRanges();
        rangeTokenCreateRange2.compactRanges();
        setContext(0);
        next();
        return rangeTokenCreateRange2;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    protected RangeToken parseSetOperations() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token getTokenForShorthand(int i) {
        if (i == 67) {
            return getRange("xml:isNameChar", false);
        }
        if (i == 68) {
            return getRange("xml:isDigit", false);
        }
        if (i == 73) {
            return getRange("xml:isInitialNameChar", false);
        }
        if (i == 83) {
            return getRange("xml:isSpace", false);
        }
        if (i == 87) {
            return getRange("xml:isWord", false);
        }
        if (i == 105) {
            return getRange("xml:isInitialNameChar", true);
        }
        if (i == 115) {
            return getRange("xml:isSpace", true);
        }
        if (i == 119) {
            return getRange("xml:isWord", true);
        }
        if (i == 99) {
            return getRange("xml:isNameChar", true);
        }
        if (i == 100) {
            return getRange("xml:isDigit", true);
        }
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(i, 16));
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    int decodeEscaped() throws ParseException {
        if (read() != 10) {
            throw ex("parser.next.1", this.offset - 1);
        }
        int i = this.chardata;
        if (i == 45 || i == 46 || i == 63) {
            return i;
        }
        if (i == 110) {
            return 10;
        }
        if (i == 114) {
            return 13;
        }
        if (i == 116) {
            return 9;
        }
        switch (i) {
            case 40:
            case 41:
            case 42:
            case 43:
                return i;
            default:
                switch (i) {
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                        return i;
                    default:
                        switch (i) {
                            case 123:
                            case 124:
                            case 125:
                                return i;
                            default:
                                throw ex("parser.process.1", this.offset - 2);
                        }
                }
        }
    }

    protected static synchronized RangeToken getRange(String str, boolean z) {
        if (ranges == null) {
            ranges = new Hashtable();
            ranges2 = new Hashtable();
            RangeToken rangeTokenCreateRange = Token.createRange();
            setupRange(rangeTokenCreateRange, SPACES);
            ranges.put("xml:isSpace", rangeTokenCreateRange);
            ranges2.put("xml:isSpace", Token.complementRanges(rangeTokenCreateRange));
            RangeToken rangeTokenCreateRange2 = Token.createRange();
            setupRange(rangeTokenCreateRange2, DIGITS);
            ranges.put("xml:isDigit", rangeTokenCreateRange2);
            ranges2.put("xml:isDigit", Token.complementRanges(rangeTokenCreateRange2));
            RangeToken rangeTokenCreateRange3 = Token.createRange();
            setupRange(rangeTokenCreateRange3, DIGITS);
            ranges.put("xml:isDigit", rangeTokenCreateRange3);
            ranges2.put("xml:isDigit", Token.complementRanges(rangeTokenCreateRange3));
            RangeToken rangeTokenCreateRange4 = Token.createRange();
            setupRange(rangeTokenCreateRange4, LETTERS);
            rangeTokenCreateRange4.mergeRanges((Token) ranges.get("xml:isDigit"));
            ranges.put("xml:isWord", rangeTokenCreateRange4);
            ranges2.put("xml:isWord", Token.complementRanges(rangeTokenCreateRange4));
            RangeToken rangeTokenCreateRange5 = Token.createRange();
            setupRange(rangeTokenCreateRange5, NAMECHARS);
            ranges.put("xml:isNameChar", rangeTokenCreateRange5);
            ranges2.put("xml:isNameChar", Token.complementRanges(rangeTokenCreateRange5));
            RangeToken rangeTokenCreateRange6 = Token.createRange();
            setupRange(rangeTokenCreateRange6, LETTERS);
            rangeTokenCreateRange6.addRange(95, 95);
            rangeTokenCreateRange6.addRange(58, 58);
            ranges.put("xml:isInitialNameChar", rangeTokenCreateRange6);
            ranges2.put("xml:isInitialNameChar", Token.complementRanges(rangeTokenCreateRange6));
        }
        return (RangeToken) (z ? ranges.get(str) : ranges2.get(str));
    }

    static void setupRange(Token token, String str) {
        int length = str.length();
        for (int i = 0; i < length; i += 2) {
            token.addRange(str.charAt(i), str.charAt(i + 1));
        }
    }
}
