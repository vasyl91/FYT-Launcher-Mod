package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class CharUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int CHARUTIL_INITIAL_BUFSIZE = 32768;
    private static final int MAX_COPY = 64;
    private static ThreadLocal tl_charUtil = new ThreadLocal() { // from class: org.apache.xmlbeans.impl.store.CharUtil.1
        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return new SoftReference(new CharUtil(CharUtil.CHARUTIL_INITIAL_BUFSIZE));
        }
    };
    public int _cchSrc;
    private int _charBufSize;
    private CharIterator _charIter = new CharIterator();
    private char[] _currentBuffer;
    private int _currentOffset;
    public int _offSrc;

    public static final boolean isWhiteSpace(char c) {
        if (c == '\t' || c == '\n' || c == '\r' || c == ' ') {
            return true;
        }
        return $assertionsDisabled;
    }

    public CharUtil(int i) {
        this._charBufSize = i;
    }

    public CharIterator getCharIterator(Object obj, int i, int i2) {
        this._charIter.init(obj, i, i2);
        return this._charIter;
    }

    public CharIterator getCharIterator(Object obj, int i, int i2, int i3) {
        this._charIter.init(obj, i, i2, i3);
        return this._charIter;
    }

    public static CharUtil getThreadLocalCharUtil() {
        CharUtil charUtil = (CharUtil) ((SoftReference) tl_charUtil.get()).get();
        if (charUtil != null) {
            return charUtil;
        }
        CharUtil charUtil2 = new CharUtil(CHARUTIL_INITIAL_BUFSIZE);
        tl_charUtil.set(new SoftReference(charUtil2));
        return charUtil2;
    }

    public static void getString(StringBuffer stringBuffer, Object obj, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            stringBuffer.append((char[]) obj, i, i2);
            return;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (i == 0 && i2 == str.length()) {
                stringBuffer.append(str);
                return;
            } else {
                stringBuffer.append(str.substring(i, i2 + i));
                return;
            }
        }
        ((CharJoin) obj).getString(stringBuffer, i, i2);
    }

    public static void getChars(char[] cArr, int i, Object obj, int i2, int i3) {
        if (i3 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            System.arraycopy((char[]) obj, i2, cArr, i, i3);
        } else if (obj instanceof String) {
            ((String) obj).getChars(i2, i3 + i2, cArr, i);
        } else {
            ((CharJoin) obj).getChars(cArr, i, i2, i3);
        }
    }

    public static String getString(Object obj, int i, int i2) {
        if (i2 == 0) {
            return "";
        }
        if (obj instanceof char[]) {
            return new String((char[]) obj, i, i2);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return (i == 0 && i2 == str.length()) ? str : str.substring(i, i2 + i);
        }
        StringBuffer stringBuffer = new StringBuffer();
        ((CharJoin) obj).getString(stringBuffer, i, i2);
        return stringBuffer.toString();
    }

    public final boolean isWhiteSpace(Object obj, int i, int i2) {
        boolean z = true;
        if (i2 <= 0) {
            return true;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            while (i2 > 0) {
                int i3 = i + 1;
                if (!isWhiteSpace(cArr[i])) {
                    return $assertionsDisabled;
                }
                i2--;
                i = i3;
            }
            return true;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            while (i2 > 0) {
                int i4 = i + 1;
                if (!isWhiteSpace(str.charAt(i))) {
                    return $assertionsDisabled;
                }
                i2--;
                i = i4;
            }
            return true;
        }
        this._charIter.init(obj, i, i2);
        while (this._charIter.hasNext()) {
            if (!isWhiteSpace(this._charIter.next())) {
                z = false;
                break;
            }
        }
        this._charIter.release();
        return z;
    }

    public Object stripLeft(Object obj, int i, int i2) {
        if (i2 > 0) {
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                while (i2 > 0 && isWhiteSpace(cArr[i])) {
                    i2--;
                    i++;
                }
            } else if (obj instanceof String) {
                String str = (String) obj;
                while (i2 > 0 && isWhiteSpace(str.charAt(i))) {
                    i2--;
                    i++;
                }
            } else {
                this._charIter.init(obj, i, i2);
                int i3 = 0;
                while (this._charIter.hasNext() && isWhiteSpace(this._charIter.next())) {
                    i3++;
                }
                this._charIter.release();
                i += i3;
            }
        }
        if (i2 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i;
        this._cchSrc = i2;
        return obj;
    }

    public Object stripRight(Object obj, int i, int i2) {
        if (i2 > 0) {
            this._charIter.init(obj, i, i2, i2);
            while (this._charIter.hasPrev() && isWhiteSpace(this._charIter.prev())) {
                i2--;
            }
            this._charIter.release();
        }
        if (i2 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i;
        this._cchSrc = i2;
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0074  */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    public Object insertChars(int i, Object obj, int i2, int i3, Object obj2, int i4, int i5) {
        CharJoin charJoin;
        CharJoin charJoin2;
        if (i5 == 0) {
            this._cchSrc = i3;
            this._offSrc = i2;
            return obj;
        }
        if (i3 == 0) {
            this._cchSrc = i5;
            this._offSrc = i4;
            return obj2;
        }
        int i6 = i3 + i5;
        this._cchSrc = i6;
        if (i6 <= 64 && canAllocate(i6)) {
            char[] cArrAllocate = allocate(this._cchSrc);
            getChars(cArrAllocate, this._offSrc, obj, i2, i);
            getChars(cArrAllocate, this._offSrc + i, obj2, i4, i5);
            getChars(cArrAllocate, this._offSrc + i + i5, obj, i2 + i, i3 - i);
            return cArrAllocate;
        }
        this._offSrc = 0;
        if (i == 0) {
            charJoin2 = new CharJoin(obj2, i4, i5, obj, i2);
        } else {
            if (i == i3) {
                charJoin2 = new CharJoin(obj, i2, i3, obj2, i4);
            } else {
                charJoin = new CharJoin(new CharJoin(obj, i2, i, obj2, i4), 0, i + i5, obj, i2 + i);
            }
            if (charJoin._depth > 64) {
                return saveChars(charJoin, this._offSrc, this._cchSrc);
            }
            return charJoin;
        }
        charJoin = charJoin2;
        if (charJoin._depth > 64) {
            return saveChars(charJoin, this._offSrc, this._cchSrc);
        }
        return charJoin;
    }

    public Object removeChars(int i, int i2, Object obj, int i3, int i4) {
        int i5 = i4 - i2;
        this._cchSrc = i5;
        if (i5 == 0) {
            this._offSrc = 0;
            return null;
        }
        if (i == 0) {
            this._offSrc = i3 + i2;
            return obj;
        }
        if (i + i2 == i4) {
            this._offSrc = i3;
            return obj;
        }
        if (i5 <= 64 && canAllocate(i5)) {
            char[] cArrAllocate = allocate(i5);
            getChars(cArrAllocate, this._offSrc, obj, i3, i);
            getChars(cArrAllocate, this._offSrc + i, obj, i3 + i + i2, (i4 - i) - i2);
            this._offSrc = this._offSrc;
            return cArrAllocate;
        }
        CharJoin charJoin = new CharJoin(obj, i3, i, obj, i3 + i + i2);
        if (charJoin._depth > 64) {
            return saveChars(charJoin, 0, this._cchSrc);
        }
        this._offSrc = 0;
        return charJoin;
    }

    private static int sizeof(Object obj) {
        if (obj instanceof char[]) {
            return ((char[]) obj).length;
        }
        if (obj == null) {
            return 0;
        }
        return ((String) obj).length();
    }

    private boolean canAllocate(int i) {
        char[] cArr = this._currentBuffer;
        if (cArr == null || cArr.length - this._currentOffset >= i) {
            return true;
        }
        return $assertionsDisabled;
    }

    private char[] allocate(int i) {
        if (this._currentBuffer == null) {
            this._currentBuffer = new char[Math.max(i, this._charBufSize)];
            this._currentOffset = 0;
        }
        int i2 = this._currentOffset;
        this._offSrc = i2;
        int iMin = Math.min(this._currentBuffer.length - i2, i);
        this._cchSrc = iMin;
        char[] cArr = this._currentBuffer;
        int i3 = this._currentOffset + iMin;
        this._currentOffset = i3;
        if (i3 == cArr.length) {
            this._currentBuffer = null;
            this._currentOffset = 0;
        }
        return cArr;
    }

    public Object saveChars(Object obj, int i, int i2) {
        return saveChars(obj, i, i2, null, 0, 0);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    /* JADX WARN: Multi-variable type inference failed */
    public Object saveChars(Object obj, int i, int i2, Object obj2, int i3, int i4) {
        Object obj3;
        Object obj4;
        Object objSaveChars;
        char[] cArrAllocate = allocate(i2);
        int i5 = this._offSrc;
        int i6 = this._cchSrc;
        getChars(cArrAllocate, i5, obj, i, i6);
        int i7 = i6 + i4;
        int i8 = 0;
        if (i4 == 0) {
            obj3 = cArrAllocate;
        } else if (obj2 == cArrAllocate && i3 + i4 == i5) {
            i5 = i3;
            obj3 = obj2;
        } else {
            if (obj2 instanceof CharJoin) {
                CharJoin charJoin = (CharJoin) obj2;
                if (charJoin._srcRight == cArrAllocate && ((i3 + i4) - charJoin._cchLeft) + charJoin._offRight == i5) {
                    i5 = i3;
                    obj3 = obj2;
                }
            }
            CharJoin charJoin2 = new CharJoin(obj2, i3, i4, cArrAllocate, i5);
            int i9 = charJoin2._depth;
            Object objSaveChars2 = charJoin2;
            if (i9 > 64) {
                objSaveChars2 = saveChars(charJoin2, 0, i7);
            }
            i5 = 0;
            obj3 = objSaveChars2;
        }
        int i10 = i2 - i6;
        if (i10 > 0) {
            char[] cArrAllocate2 = allocate(i10);
            int i11 = this._offSrc;
            getChars(cArrAllocate2, i11, obj, i + (i2 - i10), i10);
            CharJoin charJoin3 = new CharJoin(obj3, i5, i7, cArrAllocate2, i11);
            i7 += i10;
            if (charJoin3._depth > 64) {
                objSaveChars = charJoin3;
                objSaveChars = saveChars(charJoin3, 0, i7);
            }
            objSaveChars = charJoin3;
            obj4 = objSaveChars;
        } else {
            i8 = i5;
            obj4 = obj3;
        }
        this._offSrc = i8;
        this._cchSrc = i7;
        return obj4;
    }

    private static void dumpText(PrintStream printStream, String str) {
        printStream.print("\"");
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (i == 36) {
                printStream.print("...");
                break;
            }
            if (cCharAt == '\n') {
                printStream.print("\\n");
            } else if (cCharAt == '\r') {
                printStream.print("\\r");
            } else if (cCharAt == '\t') {
                printStream.print("\\t");
            } else if (cCharAt == '\f') {
                printStream.print("\\f");
            } else if (cCharAt == '\f') {
                printStream.print("\\f");
            } else if (cCharAt == '\"') {
                printStream.print("\\\"");
            } else {
                printStream.print(cCharAt);
            }
        }
        printStream.print("\"");
    }

    public static void dump(Object obj, int i, int i2) {
        dumpChars(System.out, obj, i, i2);
        System.out.println();
    }

    public static void dumpChars(PrintStream printStream, Object obj, int i, int i2) {
        int i3;
        int i4;
        printStream.print("off=" + i + ", cch=" + i2 + ", ");
        if (obj == null) {
            printStream.print("<null-src>");
            return;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            printStream.print("String");
            if ((i != 0 || i2 != str.length()) && (i < 0 || i > str.length() || (i4 = i + i2) < 0 || i4 > str.length())) {
                printStream.print(" (Error)");
                return;
            } else {
                dumpText(printStream, str.substring(i, i2 + i));
                return;
            }
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            printStream.print("char[]");
            if ((i != 0 || i2 != cArr.length) && (i < 0 || i > cArr.length || (i3 = i + i2) < 0 || i3 > cArr.length)) {
                printStream.print(" (Error)");
                return;
            } else {
                dumpText(printStream, new String(cArr, i, i2));
                return;
            }
        }
        if (obj instanceof CharJoin) {
            printStream.print("CharJoin");
            ((CharJoin) obj).dumpChars(printStream, i, i2);
        } else {
            printStream.print("Unknown text source");
        }
    }

    public static boolean isValid(Object obj, int i, int i2) {
        if (i2 >= 0 && i >= 0) {
            if (obj == null) {
                if (i == 0 && i2 == 0) {
                    return true;
                }
                return $assertionsDisabled;
            }
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                if (i > cArr.length || i + i2 > cArr.length) {
                    return $assertionsDisabled;
                }
                return true;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (i > str.length() || i + i2 > str.length()) {
                    return $assertionsDisabled;
                }
                return true;
            }
            if (obj instanceof CharJoin) {
                return ((CharJoin) obj).isValid(i, i2);
            }
        }
        return $assertionsDisabled;
    }

    public static final class CharJoin {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int MAX_DEPTH = 64;
        public final int _cchLeft;
        public final int _depth;
        public final int _offLeft;
        public final int _offRight;
        public final Object _srcLeft;
        public final Object _srcRight;

        public CharJoin(Object obj, int i, int i2, Object obj2, int i3) {
            int i4;
            this._srcLeft = obj;
            this._offLeft = i;
            this._cchLeft = i2;
            this._srcRight = obj2;
            this._offRight = i3;
            int i5 = obj instanceof CharJoin ? ((CharJoin) obj)._depth : 0;
            if ((obj2 instanceof CharJoin) && (i4 = ((CharJoin) obj2)._depth) > i5) {
                i5 = i4;
            }
            this._depth = i5 + 1;
        }

        private int cchRight(int i, int i2) {
            return Math.max(0, (i2 - this._cchLeft) - i);
        }

        public int depth() {
            Object obj = this._srcLeft;
            int iDepth = obj instanceof CharJoin ? ((CharJoin) obj).depth() : 0;
            Object obj2 = this._srcRight;
            if (obj2 instanceof CharJoin) {
                iDepth = Math.max(((CharJoin) obj2).depth(), iDepth);
            }
            return iDepth + 1;
        }

        public boolean isValid(int i, int i2) {
            if (this._depth > 2) {
                return true;
            }
            if (i < 0 || i2 < 0 || !CharUtil.isValid(this._srcLeft, this._offLeft, this._cchLeft) || !CharUtil.isValid(this._srcRight, this._offRight, cchRight(i, i2))) {
                return $assertionsDisabled;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getString(StringBuffer stringBuffer, int i, int i2) {
            int i3 = this._cchLeft;
            if (i < i3) {
                int iMin = Math.min(i3 - i, i2);
                CharUtil.getString(stringBuffer, this._srcLeft, this._offLeft + i, iMin);
                if (i2 > iMin) {
                    CharUtil.getString(stringBuffer, this._srcRight, this._offRight, i2 - iMin);
                    return;
                }
                return;
            }
            CharUtil.getString(stringBuffer, this._srcRight, (this._offRight + i) - i3, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getChars(char[] cArr, int i, int i2, int i3) {
            int i4 = this._cchLeft;
            if (i2 < i4) {
                int iMin = Math.min(i4 - i2, i3);
                CharUtil.getChars(cArr, i, this._srcLeft, this._offLeft + i2, iMin);
                if (i3 > iMin) {
                    CharUtil.getChars(cArr, i + iMin, this._srcRight, this._offRight, i3 - iMin);
                    return;
                }
                return;
            }
            CharUtil.getChars(cArr, i, this._srcRight, (this._offRight + i2) - i4, i3);
        }

        private void dumpChars(int i, int i2) {
            dumpChars(System.out, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dumpChars(PrintStream printStream, int i, int i2) {
            printStream.print("( ");
            CharUtil.dumpChars(printStream, this._srcLeft, this._offLeft, this._cchLeft);
            printStream.print(", ");
            CharUtil.dumpChars(printStream, this._srcRight, this._offRight, cchRight(i, i2));
            printStream.print(" )");
        }
    }

    public static final class CharIterator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int _cchRoot;
        private int _maxPos;
        private int _minPos;
        private int _offLeaf;
        private int _offRoot;
        private int _pos;
        private char[] _srcLeafChars;
        private String _srcLeafString;
        private Object _srcRoot;

        public void init(Object obj, int i, int i2) {
            init(obj, i, i2, 0);
        }

        public void init(Object obj, int i, int i2, int i3) {
            release();
            this._srcRoot = obj;
            this._offRoot = i;
            this._cchRoot = i2;
            this._maxPos = -1;
            this._minPos = -1;
            movePos(i3);
        }

        public void release() {
            this._srcRoot = null;
            this._srcLeafString = null;
            this._srcLeafChars = null;
        }

        public boolean hasNext() {
            if (this._pos < this._cchRoot) {
                return true;
            }
            return CharUtil.$assertionsDisabled;
        }

        public boolean hasPrev() {
            if (this._pos > 0) {
                return true;
            }
            return CharUtil.$assertionsDisabled;
        }

        public char next() {
            char cCurrentChar = currentChar();
            movePos(this._pos + 1);
            return cCurrentChar;
        }

        public char prev() {
            movePos(this._pos - 1);
            return currentChar();
        }

        public void movePos(int i) {
            Object obj;
            if (i < this._minPos || i > this._maxPos) {
                Object obj2 = this._srcRoot;
                int i2 = this._offRoot;
                int i3 = i2 + i;
                int i4 = this._cchRoot;
                this._offLeaf = i2;
                while (obj2 instanceof CharJoin) {
                    CharJoin charJoin = (CharJoin) obj2;
                    if (i3 < charJoin._cchLeft) {
                        obj = charJoin._srcLeft;
                        this._offLeaf = charJoin._offLeft;
                        i3 += charJoin._offLeft;
                        i4 = charJoin._cchLeft;
                    } else {
                        obj = charJoin._srcRight;
                        this._offLeaf = charJoin._offRight;
                        i3 -= charJoin._cchLeft - charJoin._offRight;
                        i4 -= charJoin._cchLeft;
                    }
                    obj2 = obj;
                }
                int i5 = i - (i3 - this._offLeaf);
                this._minPos = i5;
                int i6 = i5 + i4;
                this._maxPos = i6;
                if (i < this._cchRoot) {
                    this._maxPos = i6 - 1;
                }
                this._srcLeafChars = null;
                this._srcLeafString = null;
                if (obj2 instanceof char[]) {
                    this._srcLeafChars = (char[]) obj2;
                } else {
                    this._srcLeafString = (String) obj2;
                }
            }
            this._pos = i;
        }

        private char currentChar() {
            int i = (this._offLeaf + this._pos) - this._minPos;
            char[] cArr = this._srcLeafChars;
            return cArr == null ? this._srcLeafString.charAt(i) : cArr[i];
        }
    }

    public static void clearThreadLocals() {
        tl_charUtil.remove();
    }
}
