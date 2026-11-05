package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class MatchRatingApproachEncoder implements StringEncoder {
    private static final String[] DOUBLE_CONSONANT = {"BB", "CC", "DD", "FF", "GG", "HH", "JJ", "KK", "LL", "MM", "NN", "PP", "QQ", "RR", "SS", "TT", "VV", "WW", "XX", "YY", "ZZ"};
    private static final int EIGHT = 8;
    private static final int ELEVEN = 11;
    private static final String EMPTY = "";
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int ONE = 1;
    private static final String PLAIN_ASCII = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final String SPACE = " ";
    private static final int THREE = 3;
    private static final int TWELVE = 12;
    private static final int TWO = 2;
    private static final String UNICODE = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";

    int getMinRating(int i) {
        if (i <= 4) {
            return 5;
        }
        if (i >= 5 && i <= 7) {
            return 4;
        }
        if (i < 8 || i > 11) {
            return i == 12 ? 2 : 1;
        }
        return 3;
    }

    String cleanName(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        String[] strArr = {"\\-", "[&]", "\\'", "\\.", "[\\,]"};
        for (int i = 0; i < 5; i++) {
            upperCase = upperCase.replaceAll(strArr[i], "");
        }
        return removeAccents(upperCase).replaceAll("\\s+", "");
    }

    @Override // org.apache.commons.codec.Encoder
    public final Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to Match Rating Approach encoder is not of type java.lang.String");
        }
        return encode((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public final String encode(String str) {
        return (str == null || "".equalsIgnoreCase(str) || SPACE.equalsIgnoreCase(str) || str.length() == 1) ? "" : getFirst3Last3(removeDoubleConsonants(removeVowels(cleanName(str))));
    }

    String getFirst3Last3(String str) {
        int length = str.length();
        if (length <= 6) {
            return str;
        }
        return str.substring(0, 3) + str.substring(length - 3, length);
    }

    public boolean isEncodeEquals(String str, String str2) {
        if (str == null || "".equalsIgnoreCase(str) || SPACE.equalsIgnoreCase(str) || str2 == null || "".equalsIgnoreCase(str2) || SPACE.equalsIgnoreCase(str2) || str.length() == 1 || str2.length() == 1) {
            return false;
        }
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String strCleanName = cleanName(str);
        String strCleanName2 = cleanName(str2);
        String strRemoveVowels = removeVowels(strCleanName);
        String strRemoveVowels2 = removeVowels(strCleanName2);
        String strRemoveDoubleConsonants = removeDoubleConsonants(strRemoveVowels);
        String strRemoveDoubleConsonants2 = removeDoubleConsonants(strRemoveVowels2);
        String first3Last3 = getFirst3Last3(strRemoveDoubleConsonants);
        String first3Last4 = getFirst3Last3(strRemoveDoubleConsonants2);
        if (Math.abs(first3Last3.length() - first3Last4.length()) >= 3) {
            return false;
        }
        return leftToRightThenRightToLeftProcessing(first3Last3, first3Last4) >= getMinRating(Math.abs(first3Last3.length() + first3Last4.length()));
    }

    boolean isVowel(String str) {
        return str.equalsIgnoreCase("E") || str.equalsIgnoreCase("A") || str.equalsIgnoreCase("O") || str.equalsIgnoreCase("I") || str.equalsIgnoreCase("U");
    }

    int leftToRightThenRightToLeftProcessing(String str, String str2) {
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        int i = 0;
        while (i < charArray.length && i <= length2) {
            int i2 = i + 1;
            String strSubstring = str.substring(i, i2);
            int i3 = length - i;
            String strSubstring2 = str.substring(i3, i3 + 1);
            String strSubstring3 = str2.substring(i, i2);
            int i4 = length2 - i;
            String strSubstring4 = str2.substring(i4, i4 + 1);
            if (strSubstring.equals(strSubstring3)) {
                charArray[i] = ' ';
                charArray2[i] = ' ';
            }
            if (strSubstring2.equals(strSubstring4)) {
                charArray[i3] = ' ';
                charArray2[i4] = ' ';
            }
            i = i2;
        }
        String strReplaceAll = new String(charArray).replaceAll("\\s+", "");
        String strReplaceAll2 = new String(charArray2).replaceAll("\\s+", "");
        if (strReplaceAll.length() > strReplaceAll2.length()) {
            return Math.abs(6 - strReplaceAll.length());
        }
        return Math.abs(6 - strReplaceAll2.length());
    }

    String removeAccents(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            int iIndexOf = UNICODE.indexOf(cCharAt);
            if (iIndexOf > -1) {
                sb.append(PLAIN_ASCII.charAt(iIndexOf));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    String removeDoubleConsonants(String str) {
        String upperCase = str.toUpperCase();
        for (String str2 : DOUBLE_CONSONANT) {
            if (upperCase.contains(str2)) {
                upperCase = upperCase.replace(str2, str2.substring(0, 1));
            }
        }
        return upperCase;
    }

    String removeVowels(String str) {
        String strSubstring = str.substring(0, 1);
        String strReplaceAll = str.replaceAll("A", "").replaceAll("E", "").replaceAll("I", "").replaceAll("O", "").replaceAll("U", "").replaceAll("\\s{2,}\\b", SPACE);
        return isVowel(strSubstring) ? strSubstring + strReplaceAll : strReplaceAll;
    }
}
