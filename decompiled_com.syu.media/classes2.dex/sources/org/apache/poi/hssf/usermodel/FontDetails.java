package org.apache.poi.hssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FontDetails {
    private String _fontName;
    private int _height;
    private final Map<Character, Integer> charWidths = new HashMap();

    public FontDetails(String str, int i) {
        this._fontName = str;
        this._height = i;
    }

    public String getFontName() {
        return this._fontName;
    }

    public int getHeight() {
        return this._height;
    }

    public void addChar(char c, int i) {
        this.charWidths.put(Character.valueOf(c), Integer.valueOf(i));
    }

    public int getCharWidth(char c) {
        Integer num = this.charWidths.get(Character.valueOf(c));
        if (num != null) {
            return num.intValue();
        }
        if ('W' == c) {
            return 0;
        }
        return getCharWidth('W');
    }

    public void addChars(char[] cArr, int[] iArr) {
        for (int i = 0; i < cArr.length; i++) {
            this.charWidths.put(Character.valueOf(cArr[i]), Integer.valueOf(iArr[i]));
        }
    }

    protected static String buildFontHeightProperty(String str) {
        return "font." + str + ".height";
    }

    protected static String buildFontWidthsProperty(String str) {
        return "font." + str + ".widths";
    }

    protected static String buildFontCharactersProperty(String str) {
        return "font." + str + ".characters";
    }

    public static FontDetails create(String str, Properties properties) {
        String property = properties.getProperty(buildFontHeightProperty(str));
        String property2 = properties.getProperty(buildFontWidthsProperty(str));
        String property3 = properties.getProperty(buildFontCharactersProperty(str));
        if (property == null || property2 == null || property3 == null) {
            throw new IllegalArgumentException("The supplied FontMetrics doesn't know about the font '" + str + "', so we can't use it. Please add it to your font metrics file (see StaticFontMetrics.getFontDetails");
        }
        FontDetails fontDetails = new FontDetails(str, Integer.parseInt(property));
        String[] strArrSplit = split(property3, ",", -1);
        String[] strArrSplit2 = split(property2, ",", -1);
        if (strArrSplit.length != strArrSplit2.length) {
            throw new RuntimeException("Number of characters does not number of widths for font " + str);
        }
        for (int i = 0; i < strArrSplit2.length; i++) {
            if (strArrSplit[i].length() != 0) {
                fontDetails.addChar(strArrSplit[i].charAt(0), Integer.parseInt(strArrSplit2[i]));
            }
        }
        return fontDetails;
    }

    public int getStringWidth(String str) {
        int charWidth = 0;
        for (int i = 0; i < str.length(); i++) {
            charWidth += getCharWidth(str.charAt(i));
        }
        return charWidth;
    }

    private static String[] split(String str, String str2, int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        int iCountTokens = stringTokenizer.countTokens();
        if (i != -1 && iCountTokens > i) {
            iCountTokens = i;
        }
        String[] strArr = new String[iCountTokens];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            if (i != -1 && i2 == iCountTokens - 1) {
                StringBuffer stringBuffer = new StringBuffer((str.length() * (iCountTokens - i2)) / iCountTokens);
                while (stringTokenizer.hasMoreTokens()) {
                    stringBuffer.append(stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        stringBuffer.append(str2);
                    }
                }
                strArr[i2] = stringBuffer.toString().trim();
                break;
            }
            strArr[i2] = stringTokenizer.nextToken().trim();
            i2++;
        }
        return strArr;
    }
}
