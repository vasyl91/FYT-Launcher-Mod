package org.apache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Rule {
    public static final String ALL = "ALL";
    private static final String DOUBLE_QUOTE = "\"";
    private static final String HASH_INCLUDE = "#include";
    private final RPattern lContext;
    private final String pattern;
    private final PhonemeExpr phoneme;
    private final RPattern rContext;
    public static final RPattern ALL_STRINGS_RMATCHER = new RPattern() { // from class: org.apache.commons.codec.language.bm.Rule.1
        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(CharSequence charSequence) {
            return true;
        }
    };
    private static final Map<NameType, Map<RuleType, Map<String, Map<String, List<Rule>>>>> RULES = new EnumMap(NameType.class);

    public interface PhonemeExpr {
        Iterable<Phoneme> getPhonemes();
    }

    public interface RPattern {
        boolean isMatch(CharSequence charSequence);
    }

    public static final class Phoneme implements PhonemeExpr {
        public static final Comparator<Phoneme> COMPARATOR = new Comparator<Phoneme>() { // from class: org.apache.commons.codec.language.bm.Rule.Phoneme.1
            @Override // java.util.Comparator
            public int compare(Phoneme phoneme, Phoneme phoneme2) {
                for (int i = 0; i < phoneme.phonemeText.length(); i++) {
                    if (i >= phoneme2.phonemeText.length()) {
                        return 1;
                    }
                    int iCharAt = phoneme.phonemeText.charAt(i) - phoneme2.phonemeText.charAt(i);
                    if (iCharAt != 0) {
                        return iCharAt;
                    }
                }
                return phoneme.phonemeText.length() < phoneme2.phonemeText.length() ? -1 : 0;
            }
        };
        private final Languages.LanguageSet languages;
        private final StringBuilder phonemeText;

        public Phoneme(CharSequence charSequence, Languages.LanguageSet languageSet) {
            this.phonemeText = new StringBuilder(charSequence);
            this.languages = languageSet;
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2) {
            this(phoneme.phonemeText, phoneme.languages);
            this.phonemeText.append((CharSequence) phoneme2.phonemeText);
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2, Languages.LanguageSet languageSet) {
            this(phoneme.phonemeText, languageSet);
            this.phonemeText.append((CharSequence) phoneme2.phonemeText);
        }

        public Phoneme append(CharSequence charSequence) {
            this.phonemeText.append(charSequence);
            return this;
        }

        public Languages.LanguageSet getLanguages() {
            return this.languages;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public Iterable<Phoneme> getPhonemes() {
            return Collections.singleton(this);
        }

        public CharSequence getPhonemeText() {
            return this.phonemeText;
        }

        @Deprecated
        public Phoneme join(Phoneme phoneme) {
            return new Phoneme(this.phonemeText.toString() + phoneme.phonemeText.toString(), this.languages.restrictTo(phoneme.languages));
        }

        public Phoneme mergeWithLanguage(Languages.LanguageSet languageSet) {
            return new Phoneme(this.phonemeText.toString(), this.languages.merge(languageSet));
        }

        public String toString() {
            return this.phonemeText.toString() + "[" + this.languages + "]";
        }
    }

    public static final class PhonemeList implements PhonemeExpr {
        private final List<Phoneme> phonemes;

        public PhonemeList(List<Phoneme> list) {
            this.phonemes = list;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public List<Phoneme> getPhonemes() {
            return this.phonemes;
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            EnumMap enumMap = new EnumMap(RuleType.class);
            for (RuleType ruleType : RuleType.values()) {
                HashMap map = new HashMap();
                for (String str : Languages.getInstance(nameType).getLanguages()) {
                    try {
                        map.put(str, parseRules(createScanner(nameType, ruleType, str), createResourceName(nameType, ruleType, str)));
                    } catch (IllegalStateException e) {
                        throw new IllegalStateException("Problem processing " + createResourceName(nameType, ruleType, str), e);
                    }
                }
                if (!ruleType.equals(RuleType.RULES)) {
                    map.put("common", parseRules(createScanner(nameType, ruleType, "common"), createResourceName(nameType, ruleType, "common")));
                }
                enumMap.put(ruleType, Collections.unmodifiableMap(map));
            }
            RULES.put(nameType, Collections.unmodifiableMap(enumMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean contains(CharSequence charSequence, char c) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    private static String createResourceName(NameType nameType, RuleType ruleType, String str) {
        return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", nameType.getName(), ruleType.getName(), str);
    }

    private static Scanner createScanner(NameType nameType, RuleType ruleType, String str) {
        String strCreateResourceName = createResourceName(nameType, ruleType, str);
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(strCreateResourceName);
        if (resourceAsStream == null) {
            throw new IllegalArgumentException("Unable to load resource: " + strCreateResourceName);
        }
        return new Scanner(resourceAsStream, "UTF-8");
    }

    private static Scanner createScanner(String str) {
        String str2 = String.format("org/apache/commons/codec/language/bm/%s.txt", str);
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(str2);
        if (resourceAsStream == null) {
            throw new IllegalArgumentException("Unable to load resource: " + str2);
        }
        return new Scanner(resourceAsStream, "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int length = charSequence.length() - 1;
        for (int length2 = charSequence2.length() - 1; length2 >= 0; length2--) {
            if (charSequence.charAt(length) != charSequence2.charAt(length2)) {
                return false;
            }
            length--;
        }
        return true;
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, Languages.LanguageSet languageSet) {
        Map<String, List<Rule>> instanceMap = getInstanceMap(nameType, ruleType, languageSet);
        ArrayList arrayList = new ArrayList();
        Iterator<List<Rule>> it = instanceMap.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next());
        }
        return arrayList;
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, String str) {
        return getInstance(nameType, ruleType, Languages.LanguageSet.from(new HashSet(Arrays.asList(str))));
    }

    public static Map<String, List<Rule>> getInstanceMap(NameType nameType, RuleType ruleType, Languages.LanguageSet languageSet) {
        return getInstanceMap(nameType, ruleType, languageSet.isSingleton() ? languageSet.getAny() : Languages.ANY);
    }

    public static Map<String, List<Rule>> getInstanceMap(NameType nameType, RuleType ruleType, String str) {
        Map<String, List<Rule>> map = RULES.get(nameType).get(ruleType).get(str);
        if (map != null) {
            return map;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", nameType.getName(), ruleType.getName(), str));
    }

    private static Phoneme parsePhoneme(String str) {
        int iIndexOf = str.indexOf("[");
        if (iIndexOf >= 0) {
            if (!str.endsWith("]")) {
                throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
            }
            return new Phoneme(str.substring(0, iIndexOf), Languages.LanguageSet.from(new HashSet(Arrays.asList(str.substring(iIndexOf + 1, str.length() - 1).split("[+]")))));
        }
        return new Phoneme(str, Languages.ANY_LANGUAGE);
    }

    private static PhonemeExpr parsePhonemeExpr(String str) {
        if (str.startsWith("(")) {
            if (!str.endsWith(")")) {
                throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
            }
            ArrayList arrayList = new ArrayList();
            String strSubstring = str.substring(1, str.length() - 1);
            for (String str2 : strSubstring.split("[|]")) {
                arrayList.add(parsePhoneme(str2));
            }
            if (strSubstring.startsWith("|") || strSubstring.endsWith("|")) {
                arrayList.add(new Phoneme("", Languages.ANY_LANGUAGE));
            }
            return new PhonemeList(arrayList);
        }
        return parsePhoneme(str);
    }

    private static Map<String, List<Rule>> parseRules(Scanner scanner, String str) {
        int i;
        HashMap map = new HashMap();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (scanner.hasNextLine()) {
            int i5 = i3 + 1;
            String strNextLine = scanner.nextLine();
            if (i4 != 0) {
                i = i2;
                if (strNextLine.endsWith("*/")) {
                    i4 = i;
                }
            } else if (strNextLine.startsWith("/*")) {
                i = i2;
                i4 = 1;
            } else {
                int iIndexOf = strNextLine.indexOf("//");
                String strTrim = (iIndexOf >= 0 ? strNextLine.substring(i2, iIndexOf) : strNextLine).trim();
                if (strTrim.length() == 0) {
                    continue;
                } else if (strTrim.startsWith(HASH_INCLUDE)) {
                    String strTrim2 = strTrim.substring(8).trim();
                    if (strTrim2.contains(" ")) {
                        throw new IllegalArgumentException("Malformed import statement '" + strNextLine + "' in " + str);
                    }
                    map.putAll(parseRules(createScanner(strTrim2), str + "->" + strTrim2));
                    i = i2;
                } else {
                    String[] strArrSplit = strTrim.split("\\s+");
                    if (strArrSplit.length != 4) {
                        throw new IllegalArgumentException("Malformed rule statement split into " + strArrSplit.length + " parts: " + strNextLine + " in " + str);
                    }
                    try {
                        String strStripQuotes = stripQuotes(strArrSplit[i2]);
                        String strStripQuotes2 = stripQuotes(strArrSplit[1]);
                        String strStripQuotes3 = stripQuotes(strArrSplit[2]);
                        try {
                            Rule rule = new Rule(strStripQuotes, strStripQuotes2, strStripQuotes3, parsePhonemeExpr(stripQuotes(strArrSplit[3])), i5, str, strStripQuotes, strStripQuotes2, strStripQuotes3) { // from class: org.apache.commons.codec.language.bm.Rule.2
                                private final String loc;
                                private final int myLine;
                                final /* synthetic */ int val$cLine;
                                final /* synthetic */ String val$lCon;
                                final /* synthetic */ String val$location;
                                final /* synthetic */ String val$pat;
                                final /* synthetic */ String val$rCon;

                                {
                                    this.val$cLine = i5;
                                    this.val$location = str;
                                    this.val$pat = strStripQuotes;
                                    this.val$lCon = strStripQuotes2;
                                    this.val$rCon = strStripQuotes3;
                                    this.myLine = i5;
                                    this.loc = str;
                                }

                                public String toString() {
                                    StringBuilder sb = new StringBuilder("Rule{line=");
                                    sb.append(this.myLine);
                                    sb.append(", loc='").append(this.loc).append("', pat='");
                                    sb.append(this.val$pat).append("', lcon='");
                                    sb.append(this.val$lCon).append("', rcon='");
                                    sb.append(this.val$rCon).append("'}");
                                    return sb.toString();
                                }
                            };
                            i = 0;
                            String strSubstring = rule.pattern.substring(0, 1);
                            List arrayList = (List) map.get(strSubstring);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                map.put(strSubstring, arrayList);
                            }
                            arrayList.add(rule);
                        } catch (IllegalArgumentException e) {
                            e = e;
                            throw new IllegalStateException("Problem parsing line '" + i5 + "' in " + str, e);
                        }
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                    }
                }
                i3 = i5;
            }
            i2 = i;
            i3 = i5;
        }
        return map;
    }

    private static RPattern pattern(String str) {
        boolean zStartsWith = str.startsWith("^");
        boolean zEndsWith = str.endsWith("$");
        int length = str.length();
        if (zEndsWith) {
            length--;
        }
        final String strSubstring = str.substring(zStartsWith ? 1 : 0, length);
        if (strSubstring.contains("[")) {
            boolean zStartsWith2 = strSubstring.startsWith("[");
            boolean zEndsWith2 = strSubstring.endsWith("]");
            if (zStartsWith2 && zEndsWith2) {
                final String strSubstring2 = strSubstring.substring(1, strSubstring.length() - 1);
                if (!strSubstring2.contains("[")) {
                    boolean zStartsWith3 = strSubstring2.startsWith("^");
                    if (zStartsWith3) {
                        strSubstring2 = strSubstring2.substring(1);
                    }
                    final boolean z = !zStartsWith3;
                    if (zStartsWith && zEndsWith) {
                        return new RPattern() { // from class: org.apache.commons.codec.language.bm.Rule.7
                            @Override // org.apache.commons.codec.language.bm.Rule.RPattern
                            public boolean isMatch(CharSequence charSequence) {
                                return charSequence.length() == 1 && Rule.contains(strSubstring2, charSequence.charAt(0)) == z;
                            }
                        };
                    }
                    if (zStartsWith) {
                        return new RPattern() { // from class: org.apache.commons.codec.language.bm.Rule.8
                            @Override // org.apache.commons.codec.language.bm.Rule.RPattern
                            public boolean isMatch(CharSequence charSequence) {
                                return charSequence.length() > 0 && Rule.contains(strSubstring2, charSequence.charAt(0)) == z;
                            }
                        };
                    }
                    if (zEndsWith) {
                        return new RPattern() { // from class: org.apache.commons.codec.language.bm.Rule.9
                            @Override // org.apache.commons.codec.language.bm.Rule.RPattern
                            public boolean isMatch(CharSequence charSequence) {
                                return charSequence.length() > 0 && Rule.contains(strSubstring2, charSequence.charAt(charSequence.length() - 1)) == z;
                            }
                        };
                    }
                }
            }
        } else {
            if (zStartsWith && zEndsWith) {
                if (strSubstring.length() == 0) {
                    return new RPattern() { // from class: org.apache.commons.codec.language.bm.Rule.3
                        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
                        public boolean isMatch(CharSequence charSequence) {
                            return charSequence.length() == 0;
                        }
                    };
                }
                return new RPattern() { // from class: org.apache.commons.codec.language.bm.Rule.4
                    @Override // org.apache.commons.codec.language.bm.Rule.RPattern
                    public boolean isMatch(CharSequence charSequence) {
                        return charSequence.equals(strSubstring);
                    }
                };
            }
            if ((zStartsWith || zEndsWith) && strSubstring.length() == 0) {
                return ALL_STRINGS_RMATCHER;
            }
            if (zStartsWith) {
                return new RPattern() { // from class: org.apache.commons.codec.language.bm.Rule.5
                    @Override // org.apache.commons.codec.language.bm.Rule.RPattern
                    public boolean isMatch(CharSequence charSequence) {
                        return Rule.startsWith(charSequence, strSubstring);
                    }
                };
            }
            if (zEndsWith) {
                return new RPattern() { // from class: org.apache.commons.codec.language.bm.Rule.6
                    @Override // org.apache.commons.codec.language.bm.Rule.RPattern
                    public boolean isMatch(CharSequence charSequence) {
                        return Rule.endsWith(charSequence, strSubstring);
                    }
                };
            }
        }
        return new RPattern(str) { // from class: org.apache.commons.codec.language.bm.Rule.10
            Pattern pattern;
            final /* synthetic */ String val$regex;

            {
                this.val$regex = str;
                this.pattern = Pattern.compile(str);
            }

            @Override // org.apache.commons.codec.language.bm.Rule.RPattern
            public boolean isMatch(CharSequence charSequence) {
                return this.pattern.matcher(charSequence).find();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        for (int i = 0; i < charSequence2.length(); i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static String stripQuotes(String str) {
        if (str.startsWith(DOUBLE_QUOTE)) {
            str = str.substring(1);
        }
        return str.endsWith(DOUBLE_QUOTE) ? str.substring(0, str.length() - 1) : str;
    }

    public Rule(String str, String str2, String str3, PhonemeExpr phonemeExpr) {
        this.pattern = str;
        this.lContext = pattern(str2 + "$");
        this.rContext = pattern("^" + str3);
        this.phoneme = phonemeExpr;
    }

    public RPattern getLContext() {
        return this.lContext;
    }

    public String getPattern() {
        return this.pattern;
    }

    public PhonemeExpr getPhoneme() {
        return this.phoneme;
    }

    public RPattern getRContext() {
        return this.rContext;
    }

    public boolean patternAndContextMatches(CharSequence charSequence, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
        }
        int length = this.pattern.length() + i;
        if (length <= charSequence.length() && charSequence.subSequence(i, length).equals(this.pattern) && this.rContext.isMatch(charSequence.subSequence(length, charSequence.length()))) {
            return this.lContext.isMatch(charSequence.subSequence(0, i));
        }
        return false;
    }
}
