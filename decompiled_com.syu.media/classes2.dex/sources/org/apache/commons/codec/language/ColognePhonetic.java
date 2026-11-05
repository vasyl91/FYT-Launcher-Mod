package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ColognePhonetic implements StringEncoder {
    private static final char[] AEIJOUY = {'A', 'E', 'I', 'J', 'O', 'U', 'Y'};
    private static final char[] SCZ = {'S', 'C', 'Z'};
    private static final char[] WFPV = {'W', 'F', 'P', 'V'};
    private static final char[] GKQ = {'G', 'K', 'Q'};
    private static final char[] CKQ = {'C', 'K', 'Q'};
    private static final char[] AHKLOQRUX = {'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'};
    private static final char[] SZ = {'S', 'Z'};
    private static final char[] AHOUKQX = {'A', 'H', 'O', 'U', 'K', 'Q', 'X'};
    private static final char[] TDX = {'T', 'D', 'X'};
    private static final char[][] PREPROCESS_MAP = {new char[]{196, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};

    private abstract class CologneBuffer {
        protected final char[] data;
        protected int length;

        protected abstract char[] copyData(int i, int i2);

        public CologneBuffer(char[] cArr) {
            this.length = 0;
            this.data = cArr;
            this.length = cArr.length;
        }

        public CologneBuffer(int i) {
            this.length = 0;
            this.data = new char[i];
            this.length = 0;
        }

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }
    }

    private class CologneOutputBuffer extends CologneBuffer {
        public CologneOutputBuffer(int i) {
            super(i);
        }

        public void addRight(char c) {
            this.data[this.length] = c;
            this.length++;
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, i, cArr, 0, i2);
            return cArr;
        }
    }

    private class CologneInputBuffer extends CologneBuffer {
        public CologneInputBuffer(char[] cArr) {
            super(cArr);
        }

        public void addLeft(char c) {
            this.length++;
            this.data[getNextPos()] = c;
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, (this.data.length - this.length) + i, cArr, 0, i2);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        protected int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            char nextChar = getNextChar();
            this.length--;
            return nextChar;
        }
    }

    private static boolean arrayContains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public String colognePhonetic(String str) {
        char c;
        if (str == null) {
            return null;
        }
        String strPreprocess = preprocess(str);
        CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(strPreprocess.length() * 2);
        CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(strPreprocess.toCharArray());
        int length = cologneInputBuffer.length();
        char c2 = '/';
        char c3 = '-';
        while (length > 0) {
            char cRemoveNext = cologneInputBuffer.removeNext();
            int length2 = cologneInputBuffer.length();
            char nextChar = length2 > 0 ? cologneInputBuffer.getNextChar() : '-';
            if (arrayContains(AEIJOUY, cRemoveNext)) {
                c = '0';
            } else if (cRemoveNext == 'H' || cRemoveNext < 'A' || cRemoveNext > 'Z') {
                if (c2 != '/') {
                    c = '-';
                }
                length = length2;
            } else if (cRemoveNext == 'B' || (cRemoveNext == 'P' && nextChar != 'H')) {
                c = '1';
            } else if ((cRemoveNext == 'D' || cRemoveNext == 'T') && !arrayContains(SCZ, nextChar)) {
                c = '2';
            } else if (arrayContains(WFPV, cRemoveNext)) {
                c = '3';
            } else if (arrayContains(GKQ, cRemoveNext)) {
                c = '4';
            } else {
                if (cRemoveNext == 'X' && !arrayContains(CKQ, c3)) {
                    cologneInputBuffer.addLeft('S');
                    length2++;
                } else if (cRemoveNext == 'S' || cRemoveNext == 'Z') {
                    c = '8';
                } else {
                    if (cRemoveNext == 'C') {
                        if (c2 != '/' ? arrayContains(SZ, c3) || !arrayContains(AHOUKQX, nextChar) : !arrayContains(AHKLOQRUX, nextChar)) {
                        }
                    } else if (!arrayContains(TDX, cRemoveNext)) {
                        if (cRemoveNext == 'R') {
                            c = '7';
                        } else if (cRemoveNext == 'L') {
                            c = '5';
                        } else {
                            c = (cRemoveNext == 'M' || cRemoveNext == 'N') ? '6' : cRemoveNext;
                        }
                    }
                    c = '8';
                }
                c = '4';
            }
            if (c != '-' && ((c2 != c && (c != '0' || c2 == '/')) || c < '0' || c > '8')) {
                cologneOutputBuffer.addRight(c);
            }
            c2 = c;
            c3 = cRemoveNext;
            length = length2;
        }
        return cologneOutputBuffer.toString();
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + ".");
        }
        return encode((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return colognePhonetic(str);
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    private String preprocess(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 'Z') {
                for (char[] cArr : PREPROCESS_MAP) {
                    if (charArray[i] == cArr[0]) {
                        charArray[i] = cArr[1];
                        break;
                    }
                }
            }
        }
        return new String(charArray);
    }
}
