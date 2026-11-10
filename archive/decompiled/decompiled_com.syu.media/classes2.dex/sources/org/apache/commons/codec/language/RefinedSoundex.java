package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RefinedSoundex implements StringEncoder {
    private final char[] soundexMapping;
    public static final String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
    private static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();

    public RefinedSoundex() {
        this.soundexMapping = US_ENGLISH_MAPPING;
    }

    public RefinedSoundex(char[] cArr) {
        char[] cArr2 = new char[cArr.length];
        this.soundexMapping = cArr2;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    public RefinedSoundex(String str) {
        this.soundexMapping = str.toCharArray();
    }

    public int difference(String str, String str2) throws EncoderException {
        return SoundexUtils.difference(this, str, str2);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
        }
        return soundex((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return soundex(str);
    }

    char getMappingCode(char c) {
        if (Character.isLetter(c)) {
            return this.soundexMapping[Character.toUpperCase(c) - 'A'];
        }
        return (char) 0;
    }

    public String soundex(String str) {
        if (str == null) {
            return null;
        }
        String strClean = SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strClean.charAt(0));
        char c = '*';
        for (int i = 0; i < strClean.length(); i++) {
            char mappingCode = getMappingCode(strClean.charAt(i));
            if (mappingCode != c) {
                if (mappingCode != 0) {
                    sb.append(mappingCode);
                }
                c = mappingCode;
            }
        }
        return sb.toString();
    }
}
