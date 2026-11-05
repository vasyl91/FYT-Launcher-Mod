package org.apache.commons.codec.language;

import java.util.regex.Pattern;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Nysiis implements StringEncoder {
    private static final char SPACE = ' ';
    private static final int TRUE_LENGTH = 6;
    private final boolean strict;
    private static final char[] CHARS_A = {'A'};
    private static final char[] CHARS_AF = {'A', 'F'};
    private static final char[] CHARS_C = {'C'};
    private static final char[] CHARS_FF = {'F', 'F'};
    private static final char[] CHARS_G = {'G'};
    private static final char[] CHARS_N = {'N'};
    private static final char[] CHARS_NN = {'N', 'N'};
    private static final char[] CHARS_S = {'S'};
    private static final char[] CHARS_SSS = {'S', 'S', 'S'};
    private static final Pattern PAT_MAC = Pattern.compile("^MAC");
    private static final Pattern PAT_KN = Pattern.compile("^KN");
    private static final Pattern PAT_K = Pattern.compile("^K");
    private static final Pattern PAT_PH_PF = Pattern.compile("^(PH|PF)");
    private static final Pattern PAT_SCH = Pattern.compile("^SCH");
    private static final Pattern PAT_EE_IE = Pattern.compile("(EE|IE)$");
    private static final Pattern PAT_DT_ETC = Pattern.compile("(DT|RT|RD|NT|ND)$");

    private static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private static char[] transcodeRemaining(char c, char c2, char c3, char c4) {
        if (c2 == 'E' && c3 == 'V') {
            return CHARS_AF;
        }
        if (isVowel(c2)) {
            return CHARS_A;
        }
        if (c2 == 'Q') {
            return CHARS_G;
        }
        if (c2 == 'Z') {
            return CHARS_S;
        }
        if (c2 == 'M') {
            return CHARS_N;
        }
        if (c2 == 'K') {
            if (c3 == 'N') {
                return CHARS_NN;
            }
            return CHARS_C;
        }
        if (c2 == 'S' && c3 == 'C' && c4 == 'H') {
            return CHARS_SSS;
        }
        if (c2 == 'P' && c3 == 'H') {
            return CHARS_FF;
        }
        if (c2 != 'H' || (isVowel(c) && isVowel(c3))) {
            return (c2 == 'W' && isVowel(c)) ? new char[]{c} : new char[]{c2};
        }
        return new char[]{c};
    }

    public Nysiis() {
        this(true);
    }

    public Nysiis(boolean z) {
        this.strict = z;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to Nysiis encode is not of type java.lang.String");
        }
        return nysiis((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return nysiis(str);
    }

    public boolean isStrict() {
        return this.strict;
    }

    public String nysiis(String str) {
        if (str == null) {
            return null;
        }
        String strClean = SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        String strReplaceFirst = PAT_DT_ETC.matcher(PAT_EE_IE.matcher(PAT_SCH.matcher(PAT_PH_PF.matcher(PAT_K.matcher(PAT_KN.matcher(PAT_MAC.matcher(strClean).replaceFirst("MCC")).replaceFirst("NN")).replaceFirst("C")).replaceFirst("FF")).replaceFirst("SSS")).replaceFirst("Y")).replaceFirst("D");
        StringBuilder sb = new StringBuilder(strReplaceFirst.length());
        sb.append(strReplaceFirst.charAt(0));
        char[] charArray = strReplaceFirst.toCharArray();
        int length = charArray.length;
        int i = 1;
        while (i < length) {
            int i2 = length - 1;
            char c = SPACE;
            char c2 = i < i2 ? charArray[i + 1] : ' ';
            if (i < length - 2) {
                c = charArray[i + 2];
            }
            int i3 = i - 1;
            char[] cArrTranscodeRemaining = transcodeRemaining(charArray[i3], charArray[i], c2, c);
            System.arraycopy(cArrTranscodeRemaining, 0, charArray, i, cArrTranscodeRemaining.length);
            char c3 = charArray[i];
            if (c3 != charArray[i3]) {
                sb.append(c3);
            }
            i++;
        }
        if (sb.length() > 1) {
            char cCharAt = sb.charAt(sb.length() - 1);
            if (cCharAt == 'S') {
                sb.deleteCharAt(sb.length() - 1);
                cCharAt = sb.charAt(sb.length() - 1);
            }
            if (sb.length() > 2 && sb.charAt(sb.length() - 2) == 'A' && cCharAt == 'Y') {
                sb.deleteCharAt(sb.length() - 2);
            }
            if (cCharAt == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        String string = sb.toString();
        return isStrict() ? string.substring(0, Math.min(6, string.length())) : string;
    }
}
