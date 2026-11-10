package org.apache.poi.ss.format;

import java.awt.Color;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellFormatPart {
    public static final int COLOR_GROUP;
    public static final Pattern COLOR_PAT;
    public static final int CONDITION_OPERATOR_GROUP;
    public static final Pattern CONDITION_PAT;
    public static final int CONDITION_VALUE_GROUP;
    public static final Pattern CURRENCY_PAT;
    public static final Pattern FORMAT_PAT;
    private static final Map<String, Color> NAMED_COLORS = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    public static final int SPECIFICATION_GROUP;
    public static final Pattern SPECIFICATION_PAT;
    private final Color color;
    private CellFormatCondition condition;
    private final CellFormatter format;
    private final CellFormatType type;

    interface PartHandler {
        String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer);
    }

    static {
        for (HSSFColor hSSFColor : HSSFColor.getIndexHash().values()) {
            String simpleName = hSSFColor.getClass().getSimpleName();
            if (simpleName.equals(simpleName.toUpperCase(Locale.ROOT))) {
                short[] triplet = hSSFColor.getTriplet();
                Color color = new Color(triplet[0], triplet[1], triplet[2]);
                Map<String, Color> map = NAMED_COLORS;
                map.put(simpleName, color);
                if (simpleName.indexOf(95) > 0) {
                    map.put(simpleName.replace('_', ' '), color);
                }
                if (simpleName.indexOf("_PERCENT") > 0) {
                    map.put(simpleName.replace("_PERCENT", "%").replace('_', ' '), color);
                }
            }
        }
        COLOR_PAT = Pattern.compile("\\[(black|blue|cyan|green|magenta|red|white|yellow|color [0-9]+)\\]", 6);
        CONDITION_PAT = Pattern.compile("([<>=]=?|!=|<>)    # The operator\n  \\s*([0-9]+(?:\\.[0-9]*)?)\\s*  # The constant to test against\n", 6);
        SPECIFICATION_PAT = Pattern.compile("\\\\.                 # Quoted single character\n|\"([^\\\\\"]|\\\\.)*\"         # Quoted string of characters (handles escaped quotes like \\\") \n|(\\[\\$.{0,3}-[0-9a-f]{3}\\])                   # Currency symbol in a given locale\n|_.                             # Space as wide as a given character\n|\\*.                           # Repeating fill character\n|@                              # Text: cell text\n|([0?\\#](?:[0?\\#,]*))         # Number: digit + other digits and commas\n|e[-+]                          # Number: Scientific: Exponent\n|m{1,5}                         # Date: month or minute spec\n|d{1,4}                         # Date: day/date spec\n|y{2,4}                         # Date: year spec\n|h{1,2}                         # Date: hour spec\n|s{1,2}                         # Date: second spec\n|am?/pm?                        # Date: am/pm spec\n|\\[h{1,2}\\]                   # Elapsed time: hour spec\n|\\[m{1,2}\\]                   # Elapsed time: minute spec\n|\\[s{1,2}\\]                   # Elapsed time: second spec\n|[^;]                           # A character\n", 6);
        CURRENCY_PAT = Pattern.compile("(\\[\\$.{0,3}-[0-9a-f]{3}\\])", 6);
        Pattern patternCompile = Pattern.compile("(?:\\[(black|blue|cyan|green|magenta|red|white|yellow|color [0-9]+)\\])?                 # Text color\n(?:\\[([<>=]=?|!=|<>)    # The operator\n  \\s*([0-9]+(?:\\.[0-9]*)?)\\s*  # The constant to test against\n\\])?               # Condition\n(?:\\[\\$-[0-9a-fA-F]+\\])?                # Optional locale id, ignored currently\n((?:\\\\.                 # Quoted single character\n|\"([^\\\\\"]|\\\\.)*\"         # Quoted string of characters (handles escaped quotes like \\\") \n|(\\[\\$.{0,3}-[0-9a-f]{3}\\])                   # Currency symbol in a given locale\n|_.                             # Space as wide as a given character\n|\\*.                           # Repeating fill character\n|@                              # Text: cell text\n|([0?\\#](?:[0?\\#,]*))         # Number: digit + other digits and commas\n|e[-+]                          # Number: Scientific: Exponent\n|m{1,5}                         # Date: month or minute spec\n|d{1,4}                         # Date: day/date spec\n|y{2,4}                         # Date: year spec\n|h{1,2}                         # Date: hour spec\n|s{1,2}                         # Date: second spec\n|am?/pm?                        # Date: am/pm spec\n|\\[h{1,2}\\]                   # Elapsed time: hour spec\n|\\[m{1,2}\\]                   # Elapsed time: minute spec\n|\\[s{1,2}\\]                   # Elapsed time: second spec\n|[^;]                           # A character\n)+)                        # Format spec\n", 6);
        FORMAT_PAT = patternCompile;
        COLOR_GROUP = findGroup(patternCompile, "[Blue]@", "Blue");
        CONDITION_OPERATOR_GROUP = findGroup(patternCompile, "[>=1]@", ">=");
        CONDITION_VALUE_GROUP = findGroup(patternCompile, "[>=1]@", "1");
        SPECIFICATION_GROUP = findGroup(patternCompile, "[Blue][>1]\\a ?", "\\a ?");
    }

    public CellFormatPart(String str) {
        this(LocaleUtil.getUserLocale(), str);
    }

    public CellFormatPart(Locale locale, String str) {
        Matcher matcher = FORMAT_PAT.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Unrecognized format: " + CellFormatter.quote(str));
        }
        this.color = getColor(matcher);
        this.condition = getCondition(matcher);
        this.type = getCellFormatType(matcher);
        this.format = getFormatter(locale, matcher);
    }

    public boolean applies(Object obj) {
        CellFormatCondition cellFormatCondition = this.condition;
        if (cellFormatCondition != null && (obj instanceof Number)) {
            return cellFormatCondition.pass(((Number) obj).doubleValue());
        }
        if (obj != null) {
            return true;
        }
        throw new NullPointerException("valueObject");
    }

    private static int findGroup(Pattern pattern, String str, String str2) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Pattern \"" + pattern.pattern() + "\" doesn't match \"" + str + "\"");
        }
        for (int i = 1; i <= matcher.groupCount(); i++) {
            String strGroup = matcher.group(i);
            if (strGroup != null && strGroup.equals(str2)) {
                return i;
            }
        }
        throw new IllegalArgumentException("\"" + str2 + "\" not found in \"" + pattern.pattern() + "\"");
    }

    private static Color getColor(Matcher matcher) {
        String strGroup = matcher.group(COLOR_GROUP);
        if (strGroup == null || strGroup.length() == 0) {
            return null;
        }
        Color color = NAMED_COLORS.get(strGroup);
        if (color == null) {
            CellFormatter.logger.warning("Unknown color: " + CellFormatter.quote(strGroup));
        }
        return color;
    }

    private CellFormatCondition getCondition(Matcher matcher) {
        int i = CONDITION_OPERATOR_GROUP;
        String strGroup = matcher.group(i);
        if (strGroup == null || strGroup.length() == 0) {
            return null;
        }
        return CellFormatCondition.getInstance(matcher.group(i), matcher.group(CONDITION_VALUE_GROUP));
    }

    private CellFormatType getCellFormatType(Matcher matcher) {
        return formatType(matcher.group(SPECIFICATION_GROUP));
    }

    private CellFormatter getFormatter(Locale locale, Matcher matcher) {
        String strGroup = matcher.group(SPECIFICATION_GROUP);
        Matcher matcher2 = CURRENCY_PAT.matcher(strGroup);
        if (matcher2.find()) {
            String strGroup2 = matcher2.group(1);
            strGroup = strGroup.replace(strGroup2, strGroup2.startsWith("[$-") ? "$" : strGroup2.substring(2, strGroup2.lastIndexOf(45)));
        }
        return this.type.formatter(locale, strGroup);
    }

    private CellFormatType formatType(String str) {
        String strTrim = str.trim();
        if (strTrim.equals("") || strTrim.equalsIgnoreCase("General")) {
            return CellFormatType.GENERAL;
        }
        Matcher matcher = SPECIFICATION_PAT.matcher(strTrim);
        boolean z = false;
        boolean z2 = false;
        while (matcher.find()) {
            String strGroup = matcher.group(0);
            if (strGroup.length() > 0) {
                char cCharAt = strGroup.charAt(0);
                char lowerCase = strGroup.length() > 1 ? Character.toLowerCase(strGroup.charAt(1)) : (char) 0;
                switch (cCharAt) {
                    case '#':
                    case '?':
                        return CellFormatType.NUMBER;
                    case '0':
                        z2 = true;
                        break;
                    case '@':
                        return CellFormatType.TEXT;
                    case 'D':
                    case 'Y':
                    case 'd':
                    case 'y':
                        return CellFormatType.DATE;
                    case 'H':
                    case 'M':
                    case 'S':
                    case 'h':
                    case 'm':
                    case 's':
                        z = true;
                        break;
                    case '[':
                        if (lowerCase == 'h' || lowerCase == 'm' || lowerCase == 's') {
                            return CellFormatType.ELAPSED;
                        }
                        if (lowerCase == '$') {
                            return CellFormatType.NUMBER;
                        }
                        throw new IllegalArgumentException("Unsupported [] format block '" + strGroup + "' in '" + strTrim + "' with c2: " + lowerCase);
                }
            }
        }
        if (z) {
            return CellFormatType.DATE;
        }
        if (z2) {
            return CellFormatType.NUMBER;
        }
        return CellFormatType.TEXT;
    }

    static String quoteSpecial(String str, CellFormatType cellFormatType) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\'' && cellFormatType.isSpecial('\'')) {
                sb.append((char) 0);
            } else {
                boolean zIsSpecial = cellFormatType.isSpecial(cCharAt);
                if (zIsSpecial) {
                    sb.append("'");
                }
                sb.append(cCharAt);
                if (zIsSpecial) {
                    sb.append("'");
                }
            }
        }
        return sb.toString();
    }

    public CellFormatResult apply(Object obj) {
        String strSimpleFormat;
        Color color;
        boolean zApplies = applies(obj);
        if (zApplies) {
            strSimpleFormat = this.format.format(obj);
            color = this.color;
        } else {
            strSimpleFormat = this.format.simpleFormat(obj);
            color = null;
        }
        return new CellFormatResult(zApplies, strSimpleFormat, color);
    }

    public CellFormatResult apply(JLabel jLabel, Object obj) {
        CellFormatResult cellFormatResultApply = apply(obj);
        jLabel.setText(cellFormatResultApply.text);
        if (cellFormatResultApply.textColor != null) {
            jLabel.setForeground(cellFormatResultApply.textColor);
        }
        return cellFormatResultApply;
    }

    CellFormatType getCellFormatType() {
        return this.type;
    }

    boolean hasCondition() {
        return this.condition != null;
    }

    public static StringBuffer parseFormat(String str, CellFormatType cellFormatType, PartHandler partHandler) {
        int iIndexOf;
        Matcher matcher = SPECIFICATION_PAT.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            iIndexOf = 0;
            if (!matcher.find()) {
                break;
            }
            String strGroup = group(matcher, 0);
            if (strGroup.length() > 0) {
                String strHandlePart = partHandler.handlePart(matcher, strGroup, cellFormatType, stringBuffer);
                if (strHandlePart == null) {
                    char cCharAt = strGroup.charAt(0);
                    if (cCharAt == '\"') {
                        strGroup = quoteSpecial(strGroup.substring(1, strGroup.length() - 1), cellFormatType);
                    } else if (cCharAt == '*') {
                        strGroup = expandChar(strGroup);
                    } else if (cCharAt == '\\') {
                        strGroup = quoteSpecial(strGroup.substring(1), cellFormatType);
                    } else if (cCharAt == '_') {
                        strGroup = " ";
                    }
                } else {
                    strGroup = strHandlePart;
                }
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(strGroup));
            }
        }
        matcher.appendTail(stringBuffer);
        if (cellFormatType.isSpecial('\'')) {
            int iIndexOf2 = 0;
            while (true) {
                iIndexOf2 = stringBuffer.indexOf("''", iIndexOf2);
                if (iIndexOf2 < 0) {
                    break;
                }
                stringBuffer.delete(iIndexOf2, iIndexOf2 + 2);
            }
            while (true) {
                iIndexOf = stringBuffer.indexOf("\u0000", iIndexOf);
                if (iIndexOf < 0) {
                    break;
                }
                stringBuffer.replace(iIndexOf, iIndexOf + 1, "''");
            }
        }
        return stringBuffer;
    }

    static String expandChar(String str) {
        char cCharAt = str.charAt(1);
        return "" + cCharAt + cCharAt + cCharAt;
    }

    public static String group(Matcher matcher, int i) {
        String strGroup = matcher.group(i);
        return strGroup == null ? "" : strGroup;
    }

    public String toString() {
        return this.format.format;
    }
}
