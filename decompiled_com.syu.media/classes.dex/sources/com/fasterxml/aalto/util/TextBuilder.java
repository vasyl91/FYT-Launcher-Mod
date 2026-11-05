package com.fasterxml.aalto.util;

import chip.FinalChip;
import com.fasterxml.aalto.in.ReaderConfig;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.stax2.ri.typed.CharArrayBase64Decoder;
import org.codehaus.stax2.typed.Base64Variant;
import org.codehaus.stax2.typed.TypedArrayDecoder;
import org.codehaus.stax2.typed.TypedXMLStreamException;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class TextBuilder {
    static final int DEF_INITIAL_BUFFER_SIZE = 500;
    static final int INT_SPACE = 32;
    public static final int MAX_INDENT_SPACES = 32;
    public static final int MAX_INDENT_TABS = 8;
    static final int MAX_SEGMENT_LENGTH = 262144;
    private static final String sIndSpaces = "\n                                 ";
    private static final char[] sIndSpacesArray;
    private static final String[] sIndSpacesStrings;
    private static final String sIndTabs = "\n\t\t\t\t\t\t\t\t\t";
    private static final char[] sIndTabsArray;
    private static final String[] sIndTabsStrings;
    static final char[] sNoChars = new char[0];
    private final ReaderConfig _config;
    private char[] _currentSegment;
    private int _currentSize;
    private char[] _decodeBuffer;
    private int _decodeEnd;
    private int _decodePtr;
    private boolean _isIndentation = false;
    private char[] _resultArray;
    private int _resultLen;
    private String _resultString;
    private int _segmentSize;
    private ArrayList<char[]> _segments;

    static {
        char[] charArray = sIndSpaces.toCharArray();
        sIndSpacesArray = charArray;
        sIndSpacesStrings = new String[charArray.length];
        char[] charArray2 = sIndTabs.toCharArray();
        sIndTabsArray = charArray2;
        sIndTabsStrings = new String[charArray2.length];
    }

    private TextBuilder(ReaderConfig readerConfig) {
        this._config = readerConfig;
    }

    public static TextBuilder createRecyclableBuffer(ReaderConfig readerConfig) {
        return new TextBuilder(readerConfig);
    }

    public void recycle(boolean z) {
        if (this._config == null || this._currentSegment == null) {
            return;
        }
        if (z) {
            this._resultString = null;
            this._resultArray = null;
        } else if (this._segmentSize + this._currentSize > 0) {
            return;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null && arrayList.size() > 0) {
            this._segments.clear();
            this._segmentSize = 0;
        }
        char[] cArr = this._currentSegment;
        this._currentSegment = null;
        this._config.freeMediumCBuffer(cArr);
    }

    public char[] resetWithEmpty() {
        this._resultString = null;
        this._resultArray = null;
        this._isIndentation = false;
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null && arrayList.size() > 0) {
            this._segments.clear();
            this._segmentSize = 0;
        }
        this._currentSize = 0;
        if (this._currentSegment == null) {
            this._currentSegment = allocBuffer(0);
        }
        return this._currentSegment;
    }

    public void resetWithIndentation(int i, char c) {
        String strSubstring;
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null && arrayList.size() > 0) {
            this._segments.clear();
            this._segmentSize = 0;
        }
        this._currentSize = -1;
        this._isIndentation = true;
        int i2 = i + 1;
        this._resultLen = i2;
        if (c == '\t') {
            this._resultArray = sIndTabsArray;
            String[] strArr = sIndTabsStrings;
            strSubstring = strArr[i];
            if (strSubstring == null) {
                strSubstring = sIndTabs.substring(0, i2);
                strArr[i] = strSubstring;
            }
        } else {
            this._resultArray = sIndSpacesArray;
            String[] strArr2 = sIndSpacesStrings;
            strSubstring = strArr2[i];
            if (strSubstring == null) {
                strSubstring = sIndSpaces.substring(0, i2);
                strArr2[i] = strSubstring;
            }
        }
        this._resultString = strSubstring;
    }

    public void resetWithChar(char c) {
        this._resultString = null;
        this._resultArray = null;
        this._isIndentation = false;
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null && arrayList.size() > 0) {
            this._segments.clear();
            this._segmentSize = 0;
        }
        this._currentSize = 1;
        if (this._currentSegment == null) {
            this._currentSegment = allocBuffer(1);
        }
        this._currentSegment[0] = c;
    }

    public void resetWithSurrogate(int i) {
        this._resultString = null;
        this._resultArray = null;
        this._isIndentation = false;
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null && arrayList.size() > 0) {
            this._segments.clear();
            this._segmentSize = 0;
        }
        this._currentSize = 2;
        if (this._currentSegment == null) {
            this._currentSegment = allocBuffer(2);
        }
        char[] cArr = this._currentSegment;
        cArr[0] = (char) ((i >> 10) | 55296);
        cArr[1] = (char) ((i & 1023) | 56320);
    }

    public char[] getBufferWithoutReset() {
        return this._currentSegment;
    }

    public int size() {
        int i = this._currentSize;
        if (i < 0) {
            return this._resultLen;
        }
        return i + this._segmentSize;
    }

    public char[] getTextBuffer() {
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList == null || arrayList.size() == 0) {
            char[] cArr = this._resultArray;
            return cArr != null ? cArr : this._currentSegment;
        }
        return contentsAsArray();
    }

    public String contentsAsString() {
        if (this._resultString == null) {
            if (this._resultArray != null) {
                this._resultString = new String(this._resultArray);
            } else {
                int i = this._segmentSize;
                int i2 = this._currentSize;
                if (i == 0) {
                    String str = i2 == 0 ? FinalChip.BSP_PLATFORM_Null : new String(this._currentSegment, 0, i2);
                    this._resultString = str;
                    return str;
                }
                StringBuilder sb = new StringBuilder(i + i2);
                ArrayList<char[]> arrayList = this._segments;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        char[] cArr = this._segments.get(i3);
                        sb.append(cArr, 0, cArr.length);
                    }
                }
                sb.append(this._currentSegment, 0, i2);
                this._resultString = sb.toString();
            }
        }
        return this._resultString;
    }

    public char[] contentsAsArray() {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrBuildResultArray = buildResultArray();
        this._resultArray = cArrBuildResultArray;
        return cArrBuildResultArray;
    }

    public int contentsToArray(int i, char[] cArr, int i2, int i3) {
        ArrayList<char[]> arrayList = this._segments;
        int i4 = 0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                char[] cArr2 = this._segments.get(i6);
                int length = cArr2.length;
                int i7 = length - i;
                if (i7 < 1) {
                    i -= length;
                } else {
                    if (i7 >= i3) {
                        System.arraycopy(cArr2, i, cArr, i2, i3);
                        return i5 + i3;
                    }
                    System.arraycopy(cArr2, i, cArr, i2, i7);
                    i5 += i7;
                    i2 += i7;
                    i3 -= i7;
                    i = 0;
                }
            }
            i4 = i5;
        }
        if (i3 <= 0) {
            return i4;
        }
        int i8 = this._currentSize - i;
        if (i3 > i8) {
            i3 = i8;
        }
        if (i3 <= 0) {
            return i4;
        }
        System.arraycopy(this._currentSegment, i, cArr, i2, i3);
        return i4 + i3;
    }

    public int rawContentsTo(Writer writer) throws IOException {
        int length;
        char[] cArr = this._resultArray;
        if (cArr != null) {
            writer.write(cArr);
            return this._resultArray.length;
        }
        String str = this._resultString;
        if (str != null) {
            writer.write(str);
            return this._resultString.length();
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size = arrayList.size();
            length = 0;
            for (int i = 0; i < size; i++) {
                char[] cArr2 = this._segments.get(i);
                writer.write(cArr2);
                length += cArr2.length;
            }
        } else {
            length = 0;
        }
        int i2 = this._currentSize;
        if (i2 <= 0) {
            return length;
        }
        writer.write(this._currentSegment, 0, i2);
        return length + this._currentSize;
    }

    public boolean isAllWhitespace() {
        if (this._isIndentation) {
            return true;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                for (char c : this._segments.get(i)) {
                    if (c > ' ') {
                        return false;
                    }
                }
            }
        }
        char[] cArr = this._currentSegment;
        int i2 = this._currentSize;
        for (int i3 = 0; i3 < i2; i3++) {
            if (cArr[i3] > ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean endsWith(String str) {
        ArrayList<char[]> arrayList = this._segments;
        int size = arrayList == null ? 0 : arrayList.size();
        int length = str.length() - 1;
        char[] cArr = this._currentSegment;
        int length2 = this._currentSize;
        loop0: while (true) {
            int i = length2 - 1;
            while (length >= 0) {
                if (str.charAt(length) != cArr[i]) {
                    return false;
                }
                length--;
                if (length == 0) {
                    break loop0;
                }
                i--;
                if (i < 0) {
                    size--;
                    if (size < 0) {
                        return false;
                    }
                    cArr = this._segments.get(size);
                    length2 = cArr.length;
                }
            }
            break loop0;
        }
        return true;
    }

    public boolean equalsString(String str) {
        char[] cArrContentsAsArray;
        int length = str.length();
        if (length != size()) {
            return false;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList == null || arrayList.size() == 0) {
            cArrContentsAsArray = this._currentSegment;
        } else {
            cArrContentsAsArray = contentsAsArray();
        }
        for (int i = 0; i < length; i++) {
            if (cArrContentsAsArray[i] != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public void fireSaxCharacterEvents(ContentHandler contentHandler) throws SAXException {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            contentHandler.characters(cArr, 0, this._resultLen);
            return;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                char[] cArr2 = this._segments.get(i);
                contentHandler.characters(cArr2, 0, cArr2.length);
            }
        }
        int i2 = this._currentSize;
        if (i2 > 0) {
            contentHandler.characters(this._currentSegment, 0, i2);
        }
    }

    public void fireSaxSpaceEvents(ContentHandler contentHandler) throws SAXException {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            contentHandler.ignorableWhitespace(cArr, 0, this._resultLen);
            return;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                char[] cArr2 = this._segments.get(i);
                contentHandler.ignorableWhitespace(cArr2, 0, cArr2.length);
            }
        }
        int i2 = this._currentSize;
        if (i2 > 0) {
            contentHandler.ignorableWhitespace(this._currentSegment, 0, i2);
        }
    }

    public void fireSaxCommentEvent(LexicalHandler lexicalHandler) throws SAXException {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            lexicalHandler.comment(cArr, 0, this._resultLen);
            return;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null && arrayList.size() > 0) {
            char[] cArrContentsAsArray = contentsAsArray();
            lexicalHandler.comment(cArrContentsAsArray, 0, cArrContentsAsArray.length);
        } else {
            lexicalHandler.comment(this._currentSegment, 0, this._currentSize);
        }
    }

    public void append(char c) {
        this._resultString = null;
        this._resultArray = null;
        char[] cArr = this._currentSegment;
        if (this._currentSize >= cArr.length) {
            expand(1);
        }
        int i = this._currentSize;
        this._currentSize = i + 1;
        cArr[i] = c;
    }

    public void appendSurrogate(int i) {
        append((char) ((i >> 10) | 55296));
        append((char) ((i & 1023) | 56320));
    }

    public void append(char[] cArr, int i, int i2) {
        this._resultString = null;
        this._resultArray = null;
        char[] cArr2 = this._currentSegment;
        int length = cArr2.length;
        int i3 = this._currentSize;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this._currentSize += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        expand(i2);
        System.arraycopy(cArr, i, this._currentSegment, 0, i2);
        this._currentSize = i2;
    }

    public void append(String str) {
        this._resultString = null;
        this._resultArray = null;
        int length = str.length();
        char[] cArr = this._currentSegment;
        int length2 = cArr.length;
        int i = this._currentSize;
        int i2 = length2 - i;
        if (i2 >= length) {
            str.getChars(0, length, cArr, i);
            this._currentSize += length;
            return;
        }
        if (i2 > 0) {
            str.getChars(0, i2, cArr, i);
            length -= i2;
        }
        expand(length);
        str.getChars(i2, i2 + length, this._currentSegment, 0);
        this._currentSize = length;
    }

    public int getCurrentLength() {
        return this._currentSize;
    }

    public void setCurrentLength(int i) {
        this._currentSize = i;
    }

    public char[] finishCurrentSegment() {
        if (this._segments == null) {
            this._segments = new ArrayList<>();
        }
        this._segments.add(this._currentSegment);
        int length = this._currentSegment.length;
        this._segmentSize += length;
        char[] cArr = new char[calcNewSize(length)];
        this._currentSize = 0;
        this._currentSegment = cArr;
        return cArr;
    }

    private int calcNewSize(int i) {
        return Math.min(i + (i < 8000 ? i : i >> 1), 262144);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public int decodeElements(TypedArrayDecoder typedArrayDecoder, boolean z) throws TypedXMLStreamException {
        int i;
        if (z) {
            resetForDecode();
        }
        int i2 = this._decodePtr;
        char[] cArr = this._decodeBuffer;
        try {
            int i3 = this._decodeEnd;
            int i4 = 0;
            int i5 = i2;
            loop0: while (i2 < i3) {
                while (cArr[i2] <= ' ') {
                    try {
                        i2++;
                        if (i2 >= i3) {
                            break loop0;
                        }
                    } catch (IllegalArgumentException e) {
                        e = e;
                        i = i2;
                        i2 = i5;
                    }
                }
                int i6 = i2 + 1;
                while (i6 < i3) {
                    try {
                        if (cArr[i6] <= ' ') {
                            break;
                        }
                        i6++;
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        i = i6;
                        throw new TypedXMLStreamException(new String(cArr, i2, (i - i2) - 1), e.getMessage(), e);
                    }
                }
                i4++;
                i = i6 + 1;
                try {
                    if (typedArrayDecoder.decodeValue(cArr, i2, i6)) {
                        i5 = i2;
                        i2 = i;
                        break;
                    }
                    this._decodePtr = i;
                    i5 = i2;
                    i2 = i;
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    throw new TypedXMLStreamException(new String(cArr, i2, (i - i2) - 1), e.getMessage(), e);
                }
            }
            this._decodePtr = i2;
            return i4;
        } catch (IllegalArgumentException e4) {
            e = e4;
            i = i2;
        }
    }

    public void resetForBinaryDecode(Base64Variant base64Variant, CharArrayBase64Decoder charArrayBase64Decoder, boolean z) {
        ArrayList<char[]> arrayList = this._segments;
        if ((arrayList == null || arrayList.size() == 0) && this._isIndentation) {
            char[] cArr = this._resultArray;
            charArrayBase64Decoder.init(base64Variant, z, cArr, 0, cArr.length, (List) null);
        } else {
            charArrayBase64Decoder.init(base64Variant, z, this._currentSegment, 0, this._currentSize, this._segments);
        }
    }

    private final void resetForDecode() {
        this._decodePtr = 0;
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList == null || arrayList.size() == 0) {
            if (this._isIndentation) {
                char[] cArr = this._resultArray;
                this._decodeBuffer = cArr;
                this._decodeEnd = cArr.length;
                return;
            } else {
                this._decodeBuffer = this._currentSegment;
                this._decodeEnd = this._currentSize;
                return;
            }
        }
        char[] cArrContentsAsArray = contentsAsArray();
        this._decodeBuffer = cArrContentsAsArray;
        this._decodeEnd = cArrContentsAsArray.length;
    }

    public String toString() {
        this._resultString = null;
        this._resultArray = null;
        return contentsAsString();
    }

    private final char[] allocBuffer(int i) {
        char[] cArrAllocMediumCBuffer;
        int iMax = Math.max(DEF_INITIAL_BUFFER_SIZE, i);
        ReaderConfig readerConfig = this._config;
        return (readerConfig == null || (cArrAllocMediumCBuffer = readerConfig.allocMediumCBuffer(iMax)) == null) ? new char[iMax] : cArrAllocMediumCBuffer;
    }

    private void expand(int i) {
        if (this._segments == null) {
            this._segments = new ArrayList<>();
        }
        char[] cArr = this._currentSegment;
        this._segments.add(cArr);
        int length = cArr.length;
        this._segmentSize += length;
        char[] cArr2 = new char[Math.max(i, calcNewSize(length))];
        this._currentSize = 0;
        this._currentSegment = cArr2;
    }

    private char[] buildResultArray() {
        int i;
        String str = this._resultString;
        if (str != null) {
            return str.toCharArray();
        }
        int size = size();
        if (size < 1) {
            return sNoChars;
        }
        char[] cArr = new char[size];
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size2 = arrayList.size();
            i = 0;
            for (int i2 = 0; i2 < size2; i2++) {
                char[] cArr2 = this._segments.get(i2);
                int length = cArr2.length;
                System.arraycopy(cArr2, 0, cArr, i, length);
                i += length;
            }
        } else {
            i = 0;
        }
        System.arraycopy(this._currentSegment, 0, cArr, i, this._currentSize);
        return cArr;
    }
}
