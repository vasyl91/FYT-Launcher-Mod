package com.alibaba.fastjson.parser;

import android.support.v4.widget.ExploreByTouchHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.lsec.core.util.data.FinalChip;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    private static final Map<String, Integer> DEFAULT_KEYWORDS;
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final int INT_N_MULTMAX_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    protected static final long N_MULTMAX_RADIX_TEN = -922337203685477580L;
    private static final ThreadLocal<SoftReference<char[]>> SBUF_REF_LOCAL;
    protected static final int[] digits;
    protected static final char[] typeFieldName;
    protected int bp;
    protected char ch;
    protected int eofPos;
    protected boolean hasSpecial;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected int token;
    protected int features = JSON.DEFAULT_PARSER_FEATURE;
    protected Calendar calendar = null;
    public int matchStat = 0;
    protected Map<String, Integer> keywods = DEFAULT_KEYWORDS;

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    protected abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    protected abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    protected abstract void copyTo(int i, int i2, char[] cArr);

    public abstract char doNext();

    public abstract int indexOf(char c, int i);

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("null", 8);
        map.put("new", 9);
        map.put("true", 6);
        map.put("false", 7);
        map.put("undefined", 23);
        DEFAULT_KEYWORDS = map;
        SBUF_REF_LOCAL = new ThreadLocal<>();
        typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
        digits = new int[103];
        for (int i = 48; i <= 57; i++) {
            digits[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            digits[i2] = (i2 - 97) + 10;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            digits[i3] = (i3 - 65) + 10;
        }
    }

    protected void lexError(String key, Object... args) {
        this.token = 1;
    }

    public JSONLexerBase() {
        SoftReference<char[]> sbufRef = SBUF_REF_LOCAL.get();
        if (sbufRef != null) {
            this.sbuf = sbufRef.get();
            SBUF_REF_LOCAL.set(null);
        }
        if (this.sbuf == null) {
            this.sbuf = new char[64];
        }
    }

    public final int matchStat() {
        return this.matchStat;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            if (this.ch == '\"') {
                scanString();
                return;
            }
            if (this.ch == ',') {
                next();
                this.token = 16;
                return;
            }
            if (this.ch >= '0' && this.ch <= '9') {
                scanNumber();
                return;
            }
            if (this.ch == '-') {
                scanNumber();
                return;
            }
            switch (this.ch) {
                case '\b':
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    next();
                    break;
                case '\'':
                    if (!isEnabled(Feature.AllowSingleQuotes)) {
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    }
                    scanStringSingleQuote();
                    return;
                case '(':
                    next();
                    this.token = 10;
                    return;
                case ')':
                    next();
                    this.token = 11;
                    return;
                case ':':
                    next();
                    this.token = 17;
                    return;
                case 'N':
                    scanNULL();
                    return;
                case 'S':
                    scanSet();
                    return;
                case 'T':
                    scanTreeSet();
                    return;
                case '[':
                    next();
                    this.token = 14;
                    return;
                case ']':
                    next();
                    this.token = 15;
                    return;
                case 'f':
                    scanFalse();
                    return;
                case 'n':
                    scanNullOrNew();
                    return;
                case 't':
                    scanTrue();
                    return;
                case 'u':
                    scanUndefined();
                    return;
                case '{':
                    next();
                    this.token = 12;
                    return;
                case '}':
                    next();
                    this.token = 13;
                    return;
                default:
                    if (isEOF()) {
                        if (this.token == 20) {
                            throw new JSONException("EOF error");
                        }
                        this.token = 20;
                        int i = this.eofPos;
                        this.bp = i;
                        this.pos = i;
                        return;
                    }
                    lexError("illegal.char", String.valueOf((int) this.ch));
                    next();
                    return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x0016  */
    /* JADX WARN: Code duplicated, block: B:97:0x0116 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0030 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int expect) {
        this.sp = 0;
        while (true) {
            switch (expect) {
                case 2:
                    if (this.ch >= '0' && this.ch <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                    } else if (this.ch == '\"') {
                        this.pos = this.bp;
                        scanString();
                    } else if (this.ch == '[') {
                        this.token = 14;
                        next();
                    } else {
                        if (this.ch == '{') {
                            this.token = 12;
                            next();
                        }
                        if (this.ch != ' ' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b') {
                            next();
                        } else {
                            nextToken();
                        }
                    }
                    break;
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 13:
                case 17:
                case 19:
                default:
                    if (this.ch != ' ') {
                    }
                    next();
                    break;
                case 4:
                    if (this.ch == '\"') {
                        this.pos = this.bp;
                        scanString();
                    } else if (this.ch >= '0' && this.ch <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                    } else if (this.ch == '[') {
                        this.token = 14;
                        next();
                    } else {
                        if (this.ch == '{') {
                            this.token = 12;
                            next();
                        }
                        if (this.ch != ' ') {
                        }
                        next();
                    }
                    break;
                case 12:
                    if (this.ch == '{') {
                        this.token = 12;
                        next();
                    } else {
                        if (this.ch == '[') {
                            this.token = 14;
                            next();
                        }
                        if (this.ch != ' ') {
                        }
                        next();
                    }
                    break;
                case 14:
                    if (this.ch == '[') {
                        this.token = 14;
                        next();
                    } else {
                        if (this.ch == '{') {
                            this.token = 12;
                            next();
                        }
                        if (this.ch != ' ') {
                        }
                        next();
                    }
                    break;
                case 15:
                    if (this.ch == ']') {
                        this.token = 15;
                        next();
                    }
                    if (this.ch == 26) {
                        this.token = 20;
                    }
                    if (this.ch != ' ') {
                    }
                    next();
                    break;
                case 16:
                    if (this.ch == ',') {
                        this.token = 16;
                        next();
                    } else if (this.ch == '}') {
                        this.token = 13;
                        next();
                    } else if (this.ch == ']') {
                        this.token = 15;
                        next();
                    } else {
                        if (this.ch == 26) {
                            this.token = 20;
                        }
                        if (this.ch != ' ') {
                        }
                        next();
                    }
                    break;
                case 18:
                    nextIdent();
                    break;
                case 20:
                    if (this.ch == 26) {
                        this.token = 20;
                    }
                    if (this.ch != ' ') {
                    }
                    next();
                    break;
            }
            return;
        }
    }

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        if (this.ch == '_' || Character.isLetter(this.ch)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithComma() {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithChar(char expect) {
        this.sp = 0;
        while (this.ch != expect) {
            if (this.ch == ' ' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b') {
                next();
            } else {
                throw new JSONException("not match " + expect + " - " + this.ch);
            }
        }
        next();
        nextToken();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int getBufferPosition() {
        return this.bp;
    }

    public final String stringDefaultValue() {
        if (isEnabled(Feature.InitStringFieldAsEmpty)) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        long limit;
        int i;
        long result = 0;
        boolean negative = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i2 = this.np;
        int max = this.np + this.sp;
        char type = ' ';
        switch (charAt(max - 1)) {
            case 'B':
                max--;
                type = 'B';
                break;
            case 'L':
                max--;
                type = 'L';
                break;
            case 'S':
                max--;
                type = 'S';
                break;
        }
        if (charAt(this.np) == '-') {
            negative = true;
            limit = Long.MIN_VALUE;
            i = i2 + 1;
        } else {
            limit = -9223372036854775807L;
            i = i2;
        }
        long multmin = negative ? -922337203685477580L : -922337203685477580L;
        if (i < max) {
            result = -digits[charAt(i)];
            i++;
        }
        while (i < max) {
            int i3 = i + 1;
            int digit = digits[charAt(i)];
            if (result < multmin) {
                return new BigInteger(numberString());
            }
            long result2 = result * 10;
            if (result2 < ((long) digit) + limit) {
                return new BigInteger(numberString());
            }
            result = result2 - ((long) digit);
            i = i3;
        }
        if (negative) {
            if (i <= this.np + 1) {
                throw new NumberFormatException(numberString());
            }
            if (result >= -2147483648L && type != 'L') {
                if (type == 'S') {
                    return Short.valueOf((short) result);
                }
                if (type == 'B') {
                    return Byte.valueOf((byte) result);
                }
                return Integer.valueOf((int) result);
            }
            return Long.valueOf(result);
        }
        long result3 = -result;
        if (result3 <= 2147483647L && type != 'L') {
            if (type == 'S') {
                return Short.valueOf((short) result3);
            }
            if (type == 'B') {
                return Byte.valueOf((byte) result3);
            }
            return Integer.valueOf((int) result3);
        }
        return Long.valueOf(result3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int expect) {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithComma(int expect) {
        nextTokenWithChar(',');
    }

    public final void nextTokenWithChar(char seperator, int expect) {
        this.sp = 0;
        while (this.ch != seperator) {
            if (isWhitespace(this.ch)) {
                next();
            } else {
                throw new JSONException("not match " + expect + " - " + this.ch);
            }
        }
        next();
        while (true) {
            if (expect == 2) {
                if (this.ch >= '0' && this.ch <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (this.ch == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                }
            } else if (expect == 4) {
                if (this.ch == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (this.ch >= '0' && this.ch <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
            } else if (expect == 12) {
                if (this.ch == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (this.ch == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (expect == 14) {
                if (this.ch == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (this.ch == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            }
            if (isWhitespace(this.ch)) {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        return Float.parseFloat(numberString());
    }

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean state) {
        this.features = Feature.config(this.features, feature, state);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return Feature.isEnabled(this.features, feature);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        this.ch = doNext();
        if (this.ch == '/' && isEnabled(Feature.AllowComment)) {
            skipComment();
        }
        return this.ch;
    }

    protected void skipComment() {
        doNext();
        if (this.ch == '/') {
            do {
                doNext();
            } while (this.ch != '\n');
            doNext();
        } else {
            if (this.ch != '*') {
                throw new JSONException("invalid comment");
            }
            while (true) {
                doNext();
                if (this.ch == '*') {
                    doNext();
                    if (this.ch == '/') {
                        doNext();
                        return;
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        if (this.ch == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (this.ch == '\'') {
            if (!isEnabled(Feature.AllowSingleQuotes)) {
                throw new JSONException("syntax error");
            }
            return scanSymbol(symbolTable, '\'');
        }
        if (this.ch == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (this.ch == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (this.ch == 26) {
            this.token = 20;
            return null;
        }
        if (!isEnabled(Feature.AllowUnQuotedFieldNames)) {
            throw new JSONException("syntax error");
        }
        return scanSymbolUnQuoted(symbolTable);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char quote) {
        String value;
        int offset;
        int hash = 0;
        this.np = this.bp;
        this.sp = 0;
        boolean hasSpecial = false;
        while (true) {
            char chLocal = next();
            if (chLocal != quote) {
                if (chLocal == 26) {
                    throw new JSONException("unclosed.str");
                }
                if (chLocal == '\\') {
                    if (!hasSpecial) {
                        hasSpecial = true;
                        if (this.sp >= this.sbuf.length) {
                            int newCapcity = this.sbuf.length * 2;
                            if (this.sp > newCapcity) {
                                newCapcity = this.sp;
                            }
                            char[] newsbuf = new char[newCapcity];
                            System.arraycopy(this.sbuf, 0, newsbuf, 0, this.sbuf.length);
                            this.sbuf = newsbuf;
                        }
                        arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                    }
                    char chLocal2 = next();
                    switch (chLocal2) {
                        case '\"':
                            hash = (hash * 31) + 34;
                            putChar('\"');
                            break;
                        case '\'':
                            hash = (hash * 31) + 39;
                            putChar('\'');
                            break;
                        case '/':
                            hash = (hash * 31) + 47;
                            putChar('/');
                            break;
                        case '0':
                            hash = (hash * 31) + chLocal2;
                            putChar((char) 0);
                            break;
                        case '1':
                            hash = (hash * 31) + chLocal2;
                            putChar((char) 1);
                            break;
                        case '2':
                            hash = (hash * 31) + chLocal2;
                            putChar((char) 2);
                            break;
                        case '3':
                            hash = (hash * 31) + chLocal2;
                            putChar((char) 3);
                            break;
                        case '4':
                            hash = (hash * 31) + chLocal2;
                            putChar((char) 4);
                            break;
                        case '5':
                            hash = (hash * 31) + chLocal2;
                            putChar((char) 5);
                            break;
                        case '6':
                            hash = (hash * 31) + chLocal2;
                            putChar((char) 6);
                            break;
                        case '7':
                            hash = (hash * 31) + chLocal2;
                            putChar((char) 7);
                            break;
                        case 'F':
                        case 'f':
                            hash = (hash * 31) + 12;
                            putChar('\f');
                            break;
                        case '\\':
                            hash = (hash * 31) + 92;
                            putChar('\\');
                            break;
                        case 'b':
                            hash = (hash * 31) + 8;
                            putChar('\b');
                            break;
                        case 'n':
                            hash = (hash * 31) + 10;
                            putChar('\n');
                            break;
                        case 'r':
                            hash = (hash * 31) + 13;
                            putChar('\r');
                            break;
                        case 't':
                            hash = (hash * 31) + 9;
                            putChar('\t');
                            break;
                        case 'u':
                            int val = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                            hash = (hash * 31) + val;
                            putChar((char) val);
                            break;
                        case 'v':
                            hash = (hash * 31) + 11;
                            putChar((char) 11);
                            break;
                        case 'x':
                            char x1 = next();
                            this.ch = x1;
                            char x2 = next();
                            this.ch = x2;
                            int x_val = (digits[x1] * 16) + digits[x2];
                            char x_char = (char) x_val;
                            hash = (hash * 31) + x_char;
                            putChar(x_char);
                            break;
                        default:
                            this.ch = chLocal2;
                            throw new JSONException("unclosed.str.lit");
                    }
                } else {
                    hash = (hash * 31) + chLocal;
                    if (!hasSpecial) {
                        this.sp++;
                    } else if (this.sp == this.sbuf.length) {
                        putChar(chLocal);
                    } else {
                        char[] cArr = this.sbuf;
                        int i = this.sp;
                        this.sp = i + 1;
                        cArr[i] = chLocal;
                    }
                }
            } else {
                this.token = 4;
                if (!hasSpecial) {
                    if (this.np == -1) {
                        offset = 0;
                    } else {
                        offset = this.np + 1;
                    }
                    value = addSymbol(offset, this.sp, hash, symbolTable);
                } else {
                    value = symbolTable.addSymbol(this.sbuf, 0, this.sp, hash);
                }
                this.sp = 0;
                next();
                return value;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean[] firstIdentifierFlags = IOUtils.firstIdentifierFlags;
        char first = this.ch;
        boolean firstFlag = this.ch >= firstIdentifierFlags.length || firstIdentifierFlags[first];
        if (!firstFlag) {
            throw new JSONException("illegal identifier : " + this.ch);
        }
        boolean[] identifierFlags = IOUtils.identifierFlags;
        int hash = first;
        this.np = this.bp;
        this.sp = 1;
        while (true) {
            char chLocal = next();
            if (chLocal < identifierFlags.length && !identifierFlags[chLocal]) {
                break;
            }
            hash = (hash * 31) + chLocal;
            this.sp++;
        }
        this.ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && hash == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
            return null;
        }
        return addSymbol(this.np, this.sp, hash, symbolTable);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char ch = next();
            if (ch != '\"') {
                if (ch == 26) {
                    throw new JSONException("unclosed string : " + ch);
                }
                if (ch == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        if (this.sp >= this.sbuf.length) {
                            int newCapcity = this.sbuf.length * 2;
                            if (this.sp > newCapcity) {
                                newCapcity = this.sp;
                            }
                            char[] newsbuf = new char[newCapcity];
                            System.arraycopy(this.sbuf, 0, newsbuf, 0, this.sbuf.length);
                            this.sbuf = newsbuf;
                        }
                        copyTo(this.np + 1, this.sp, this.sbuf);
                    }
                    char ch2 = next();
                    switch (ch2) {
                        case '\"':
                            putChar('\"');
                            break;
                        case '\'':
                            putChar('\'');
                            break;
                        case '/':
                            putChar('/');
                            break;
                        case '0':
                            putChar((char) 0);
                            break;
                        case '1':
                            putChar((char) 1);
                            break;
                        case '2':
                            putChar((char) 2);
                            break;
                        case '3':
                            putChar((char) 3);
                            break;
                        case '4':
                            putChar((char) 4);
                            break;
                        case '5':
                            putChar((char) 5);
                            break;
                        case '6':
                            putChar((char) 6);
                            break;
                        case '7':
                            putChar((char) 7);
                            break;
                        case 'F':
                        case 'f':
                            putChar('\f');
                            break;
                        case '\\':
                            putChar('\\');
                            break;
                        case 'b':
                            putChar('\b');
                            break;
                        case 'n':
                            putChar('\n');
                            break;
                        case 'r':
                            putChar('\r');
                            break;
                        case 't':
                            putChar('\t');
                            break;
                        case 'u':
                            int val = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                            putChar((char) val);
                            break;
                        case 'v':
                            putChar((char) 11);
                            break;
                        case 'x':
                            int x_val = (digits[next()] * 16) + digits[next()];
                            char x_char = (char) x_val;
                            putChar(x_char);
                            break;
                        default:
                            this.ch = ch2;
                            throw new JSONException("unclosed string : " + ch2);
                    }
                } else if (!this.hasSpecial) {
                    this.sp++;
                } else if (this.sp == this.sbuf.length) {
                    putChar(ch);
                } else {
                    char[] cArr = this.sbuf;
                    int i = this.sp;
                    this.sp = i + 1;
                    cArr[i] = ch;
                }
            } else {
                this.token = 4;
                this.ch = next();
                return;
            }
        }
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int limit;
        int i;
        int i2;
        if (this.np == -1) {
            this.np = 0;
        }
        int result = 0;
        boolean negative = false;
        int i3 = this.np;
        int max = this.np + this.sp;
        if (charAt(this.np) == '-') {
            negative = true;
            limit = ExploreByTouchHelper.INVALID_ID;
            i = i3 + 1;
        } else {
            limit = -2147483647;
            i = i3;
        }
        if (negative) {
        }
        if (i < max) {
            result = -digits[charAt(i)];
            i++;
        }
        while (true) {
            if (i >= max) {
                i2 = i;
                break;
            }
            i2 = i + 1;
            char chLocal = charAt(i);
            if (chLocal == 'L' || chLocal == 'S' || chLocal == 'B') {
                break;
            }
            int digit = digits[chLocal];
            if (result < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int result2 = result * 10;
            if (result2 < limit + digit) {
                throw new NumberFormatException(numberString());
            }
            result = result2 - digit;
            i = i2;
        }
        if (negative) {
            if (i2 <= this.np + 1) {
                throw new NumberFormatException(numberString());
            }
            return result;
        }
        return -result;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.sbuf.length <= 8192) {
            SBUF_REF_LOCAL.set(new SoftReference<>(this.sbuf));
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    public int scanType(String type) {
        this.matchStat = 0;
        if (!charArrayCompare(typeFieldName)) {
            return -2;
        }
        int bpLocal = this.bp + typeFieldName.length;
        int typeLength = type.length();
        for (int i = 0; i < typeLength; i++) {
            if (type.charAt(i) != charAt(bpLocal + i)) {
                return -1;
            }
        }
        int bpLocal2 = bpLocal + typeLength;
        if (charAt(bpLocal2) != '\"') {
            return -1;
        }
        int bpLocal3 = bpLocal2 + 1;
        this.ch = charAt(bpLocal3);
        if (this.ch == ',') {
            int bpLocal4 = bpLocal3 + 1;
            this.ch = charAt(bpLocal4);
            this.bp = bpLocal4;
            this.token = 16;
            return 3;
        }
        if (this.ch == '}') {
            bpLocal3++;
            this.ch = charAt(bpLocal3);
            if (this.ch == ',') {
                this.token = 16;
                bpLocal3++;
                this.ch = charAt(bpLocal3);
            } else if (this.ch == ']') {
                this.token = 15;
                bpLocal3++;
                this.ch = charAt(bpLocal3);
            } else if (this.ch == '}') {
                this.token = 13;
                bpLocal3++;
                this.ch = charAt(bpLocal3);
            } else {
                if (this.ch != 26) {
                    return -1;
                }
                this.token = 20;
            }
            this.matchStat = 4;
        }
        this.bp = bpLocal3;
        return this.matchStat;
    }

    public final boolean matchField(char[] fieldName) {
        if (!charArrayCompare(fieldName)) {
            return false;
        }
        this.bp += fieldName.length;
        this.ch = charAt(this.bp);
        if (this.ch == '{') {
            next();
            this.token = 12;
        } else if (this.ch == '[') {
            next();
            this.token = 14;
        } else {
            nextToken();
        }
        return true;
    }

    public String scanFieldString(char[] fieldName) {
        this.matchStat = 0;
        if (!charArrayCompare(fieldName)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int offset = fieldName.length;
        int offset2 = offset + 1;
        if (charAt(this.bp + offset) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        boolean hasSpecial = false;
        int startIndex = this.bp + fieldName.length + 1;
        int endIndex = indexOf('\"', startIndex);
        if (endIndex == -1) {
            throw new JSONException("unclosed str");
        }
        int startIndex2 = this.bp + fieldName.length + 1;
        String stringVal = subString(startIndex2, endIndex - startIndex2);
        for (int i = this.bp + fieldName.length + 1; i < endIndex; i++) {
            if (charAt(i) == '\\') {
                hasSpecial = true;
                break;
            }
        }
        if (hasSpecial) {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int offset3 = offset2 + (endIndex - ((this.bp + fieldName.length) + 1)) + 1;
        int offset4 = offset3 + 1;
        char chLocal = charAt(this.bp + offset3);
        if (chLocal == ',') {
            this.bp += offset4 - 1;
            next();
            this.matchStat = 3;
            return stringVal;
        }
        if (chLocal == '}') {
            int offset5 = offset4 + 1;
            char chLocal2 = charAt(this.bp + offset4);
            if (chLocal2 == ',') {
                this.token = 16;
                this.bp += offset5 - 1;
                next();
            } else if (chLocal2 == ']') {
                this.token = 15;
                this.bp += offset5 - 1;
                next();
            } else if (chLocal2 == '}') {
                this.token = 13;
                this.bp += offset5 - 1;
                next();
            } else if (chLocal2 == 26) {
                this.token = 20;
                this.bp += offset5 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                String strVal = stringDefaultValue();
                return strVal;
            }
            this.matchStat = 4;
            return stringVal;
        }
        this.matchStat = -1;
        String strVal2 = stringDefaultValue();
        return strVal2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char expectNextChar) {
        this.matchStat = 0;
        int offset = 0 + 1;
        char chLocal = charAt(this.bp + 0);
        if (chLocal == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                int i = offset + 3 + 1;
                if (charAt(this.bp + 4) == expectNextChar) {
                    this.bp += 4;
                    next();
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        if (chLocal != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        boolean hasSpecial = false;
        int startIndex = this.bp + 1;
        int endIndex = indexOf('\"', startIndex);
        if (endIndex == -1) {
            throw new JSONException("unclosed str");
        }
        String stringVal = subString(this.bp + 1, endIndex - startIndex);
        for (int i2 = this.bp + 1; i2 < endIndex; i2++) {
            if (charAt(i2) == '\\') {
                hasSpecial = true;
                break;
            }
        }
        if (hasSpecial) {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int offset2 = (endIndex - (this.bp + 1)) + 1 + 1;
        int offset3 = offset2 + 1;
        if (charAt(this.bp + offset2) == expectNextChar) {
            this.bp += offset3 - 1;
            next();
            this.matchStat = 3;
            return stringVal;
        }
        this.matchStat = -1;
        return stringVal;
    }

    public String scanFieldSymbol(char[] fieldName, SymbolTable symbolTable) {
        char chLocal;
        this.matchStat = 0;
        if (!charArrayCompare(fieldName)) {
            this.matchStat = -2;
            return null;
        }
        int offset = fieldName.length;
        int offset2 = offset + 1;
        if (charAt(this.bp + offset) != '\"') {
            this.matchStat = -1;
            return null;
        }
        int hash = 0;
        do {
            int offset3 = offset2;
            offset2 = offset3 + 1;
            chLocal = charAt(this.bp + offset3);
            if (chLocal == '\"') {
                int start = this.bp + fieldName.length + 1;
                int len = ((this.bp + offset2) - start) - 1;
                String strAddSymbol = addSymbol(start, len, hash, symbolTable);
                int offset4 = offset2 + 1;
                char chLocal2 = charAt(this.bp + offset2);
                if (chLocal2 == ',') {
                    this.bp += offset4 - 1;
                    next();
                    this.matchStat = 3;
                    return strAddSymbol;
                }
                if (chLocal2 == '}') {
                    int offset5 = offset4 + 1;
                    char chLocal3 = charAt(this.bp + offset4);
                    if (chLocal3 == ',') {
                        this.token = 16;
                        this.bp += offset5 - 1;
                        next();
                    } else if (chLocal3 == ']') {
                        this.token = 15;
                        this.bp += offset5 - 1;
                        next();
                    } else if (chLocal3 == '}') {
                        this.token = 13;
                        this.bp += offset5 - 1;
                        next();
                    } else if (chLocal3 == 26) {
                        this.token = 20;
                        this.bp += offset5 - 1;
                        this.ch = (char) 26;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return strAddSymbol;
                }
                this.matchStat = -1;
                return null;
            }
            hash = (hash * 31) + chLocal;
        } while (chLocal != '\\');
        this.matchStat = -1;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> enumClass, SymbolTable symbolTable, char serperator) {
        String name = scanSymbolWithSeperator(symbolTable, serperator);
        if (name == null) {
            return null;
        }
        return Enum.valueOf(enumClass, name);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char serperator) {
        char chLocal;
        String strAddSymbol = null;
        this.matchStat = 0;
        int offset = 0 + 1;
        char chLocal2 = charAt(this.bp + 0);
        if (chLocal2 == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                int i = offset + 3 + 1;
                if (charAt(this.bp + 4) == serperator) {
                    this.bp += 4;
                    next();
                    this.matchStat = 3;
                } else {
                    this.matchStat = -1;
                }
            } else {
                this.matchStat = -1;
            }
        } else if (chLocal2 != '\"') {
            this.matchStat = -1;
        } else {
            int hash = 0;
            do {
                int offset2 = offset;
                offset = offset2 + 1;
                chLocal = charAt(this.bp + offset2);
                if (chLocal == '\"') {
                    int start = this.bp + 0 + 1;
                    int len = ((this.bp + offset) - start) - 1;
                    strAddSymbol = addSymbol(start, len, hash, symbolTable);
                    int offset3 = offset + 1;
                    if (charAt(this.bp + offset) == serperator) {
                        this.bp += offset3 - 1;
                        next();
                        this.matchStat = 3;
                    } else {
                        this.matchStat = -1;
                    }
                } else {
                    hash = (hash * 31) + chLocal;
                }
            } while (chLocal != '\\');
            this.matchStat = -1;
        }
        return strAddSymbol;
    }

    public Collection<String> scanFieldStringArray(char[] fieldName, Class<?> type) {
        Collection<String> list;
        int offset;
        this.matchStat = 0;
        if (!charArrayCompare(fieldName)) {
            this.matchStat = -2;
            return null;
        }
        if (type.isAssignableFrom(HashSet.class)) {
            list = new HashSet<>();
        } else if (type.isAssignableFrom(ArrayList.class)) {
            list = new ArrayList<>();
        } else {
            try {
                list = (Collection) type.newInstance();
            } catch (Exception e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        int offset2 = fieldName.length;
        int offset3 = offset2 + 1;
        char chLocal = charAt(this.bp + offset2);
        if (chLocal != '[') {
            this.matchStat = -1;
            return null;
        }
        int offset4 = offset3 + 1;
        char chLocal2 = charAt(this.bp + offset3);
        while (chLocal2 == '\"') {
            int startOffset = offset4;
            while (true) {
                offset = offset4 + 1;
                char chLocal3 = charAt(this.bp + offset4);
                if (chLocal3 == '\"') {
                    break;
                }
                if (chLocal3 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                offset4 = offset;
            }
            int start = this.bp + startOffset;
            int len = ((this.bp + offset) - start) - 1;
            String strVal = subString(start, len);
            list.add(strVal);
            int offset5 = offset + 1;
            char chLocal4 = charAt(this.bp + offset);
            if (chLocal4 == ',') {
                chLocal2 = charAt(this.bp + offset5);
                offset4 = offset5 + 1;
            } else {
                if (chLocal4 == ']') {
                    int offset6 = offset5 + 1;
                    char chLocal5 = charAt(this.bp + offset5);
                    if (chLocal5 == ',') {
                        this.bp += offset6 - 1;
                        next();
                        this.matchStat = 3;
                        return list;
                    }
                    if (chLocal5 == '}') {
                        int offset7 = offset6 + 1;
                        char chLocal6 = charAt(this.bp + offset6);
                        if (chLocal6 == ',') {
                            this.token = 16;
                            this.bp += offset7 - 1;
                            next();
                        } else if (chLocal6 == ']') {
                            this.token = 15;
                            this.bp += offset7 - 1;
                            next();
                        } else if (chLocal6 == '}') {
                            this.token = 13;
                            this.bp += offset7 - 1;
                            next();
                        } else if (chLocal6 == 26) {
                            this.bp += offset7 - 1;
                            this.token = 20;
                            this.ch = (char) 26;
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                        this.matchStat = 4;
                        return list;
                    }
                    this.matchStat = -1;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
        }
        this.matchStat = -1;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Collection<String> scanStringArray(Class<?> type, char seperator) {
        Collection<String> list;
        char chLocal;
        int offset;
        this.matchStat = 0;
        if (type.isAssignableFrom(HashSet.class)) {
            list = new HashSet<>();
        } else if (type.isAssignableFrom(ArrayList.class)) {
            list = new ArrayList<>();
        } else {
            try {
                list = (Collection) type.newInstance();
            } catch (Exception e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        int offset2 = 0 + 1;
        char chLocal2 = charAt(this.bp + 0);
        if (chLocal2 == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                int i = offset2 + 3 + 1;
                if (charAt(this.bp + 4) == seperator) {
                    this.bp += 4;
                    next();
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        if (chLocal2 != '[') {
            this.matchStat = -1;
            return null;
        }
        int offset3 = offset2 + 1;
        char chLocal3 = charAt(this.bp + 1);
        while (true) {
            if (chLocal3 == 'n' && charAt(this.bp + offset3) == 'u' && charAt(this.bp + offset3 + 1) == 'l' && charAt(this.bp + offset3 + 2) == 'l') {
                int offset4 = offset3 + 3;
                offset = offset4 + 1;
                chLocal = charAt(this.bp + offset4);
            } else {
                if (chLocal3 != '\"') {
                    this.matchStat = -1;
                    return null;
                }
                int startOffset = offset3;
                while (true) {
                    int offset5 = offset3 + 1;
                    char chLocal4 = charAt(this.bp + offset3);
                    if (chLocal4 == '\"') {
                        int start = this.bp + startOffset;
                        int len = ((this.bp + offset5) - start) - 1;
                        String strVal = subString(start, len);
                        list.add(strVal);
                        chLocal = charAt(this.bp + offset5);
                        offset = offset5 + 1;
                        break;
                    }
                    if (chLocal4 == '\\') {
                        this.matchStat = -1;
                        return null;
                    }
                    offset3 = offset5;
                }
            }
            if (chLocal == ',') {
                offset3 = offset + 1;
                chLocal3 = charAt(this.bp + offset);
            } else {
                if (chLocal != ']') {
                    this.matchStat = -1;
                    return null;
                }
                int offset6 = offset + 1;
                if (charAt(this.bp + offset) == seperator) {
                    this.bp += offset6 - 1;
                    next();
                    this.matchStat = 3;
                    return list;
                }
                this.matchStat = -1;
                return list;
            }
        }
    }

    public int scanFieldInt(char[] fieldName) {
        char chLocal;
        this.matchStat = 0;
        if (!charArrayCompare(fieldName)) {
            this.matchStat = -2;
            return 0;
        }
        int offset = fieldName.length;
        int offset2 = offset + 1;
        char chLocal2 = charAt(this.bp + offset);
        if (chLocal2 >= '0' && chLocal2 <= '9') {
            int value = digits[chLocal2];
            while (true) {
                int offset3 = offset2;
                offset2 = offset3 + 1;
                chLocal = charAt(this.bp + offset3);
                if (chLocal < '0' || chLocal > '9') {
                    break;
                }
                value = (value * 10) + digits[chLocal];
            }
            if (chLocal == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (value < 0) {
                this.matchStat = -1;
                return 0;
            }
            if (chLocal == ',') {
                this.bp += offset2 - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return value;
            }
            if (chLocal == '}') {
                int offset4 = offset2 + 1;
                char chLocal3 = charAt(this.bp + offset2);
                if (chLocal3 == ',') {
                    this.token = 16;
                    this.bp += offset4 - 1;
                    next();
                } else if (chLocal3 == ']') {
                    this.token = 15;
                    this.bp += offset4 - 1;
                    next();
                } else if (chLocal3 == '}') {
                    this.token = 13;
                    this.bp += offset4 - 1;
                    next();
                } else if (chLocal3 == 26) {
                    this.token = 20;
                    this.bp += offset4 - 1;
                    this.ch = (char) 26;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
                this.matchStat = 4;
                return value;
            }
            this.matchStat = -1;
            return 0;
        }
        this.matchStat = -1;
        return 0;
    }

    public boolean scanBoolean(char expectNext) {
        boolean value;
        int offset;
        this.matchStat = 0;
        int offset2 = 0 + 1;
        char chLocal = charAt(this.bp + 0);
        if (chLocal == 't') {
            if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 1 + 1) == 'u' && charAt(this.bp + 1 + 2) == 'e') {
                offset = offset2 + 3 + 1;
                chLocal = charAt(this.bp + 4);
                value = true;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (chLocal != 'f') {
            value = false;
            offset = offset2;
        } else if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
            offset = offset2 + 4 + 1;
            chLocal = charAt(this.bp + 5);
            value = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        if (chLocal == expectNext) {
            this.bp += offset - 1;
            next();
            this.matchStat = 3;
            return value;
        }
        this.matchStat = -1;
        return value;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char expectNext) {
        char chLocal;
        this.matchStat = 0;
        int offset = 0 + 1;
        char chLocal2 = charAt(this.bp + 0);
        if (chLocal2 >= '0' && chLocal2 <= '9') {
            int value = digits[chLocal2];
            while (true) {
                int offset2 = offset;
                offset = offset2 + 1;
                chLocal = charAt(this.bp + offset2);
                if (chLocal < '0' || chLocal > '9') {
                    break;
                }
                value = (value * 10) + digits[chLocal];
            }
            if (chLocal == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (value < 0) {
                this.matchStat = -1;
                return 0;
            }
            if (chLocal == expectNext) {
                this.bp += offset - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return value;
            }
            this.matchStat = -1;
            return value;
        }
        this.matchStat = -1;
        return 0;
    }

    public boolean scanFieldBoolean(char[] fieldName) {
        boolean value;
        int offset;
        this.matchStat = 0;
        if (!charArrayCompare(fieldName)) {
            this.matchStat = -2;
            return false;
        }
        int offset2 = fieldName.length;
        int offset3 = offset2 + 1;
        char chLocal = charAt(this.bp + offset2);
        if (chLocal == 't') {
            int offset4 = offset3 + 1;
            if (charAt(this.bp + offset3) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int offset5 = offset4 + 1;
            if (charAt(this.bp + offset4) != 'u') {
                this.matchStat = -1;
                return false;
            }
            offset = offset5 + 1;
            if (charAt(this.bp + offset5) != 'e') {
                this.matchStat = -1;
                return false;
            }
            value = true;
        } else if (chLocal == 'f') {
            int offset6 = offset3 + 1;
            if (charAt(this.bp + offset3) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int offset7 = offset6 + 1;
            if (charAt(this.bp + offset6) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int offset8 = offset7 + 1;
            if (charAt(this.bp + offset7) != 's') {
                this.matchStat = -1;
                return false;
            }
            int offset9 = offset8 + 1;
            if (charAt(this.bp + offset8) != 'e') {
                this.matchStat = -1;
                return false;
            }
            value = false;
            offset = offset9;
        } else {
            this.matchStat = -1;
            return false;
        }
        int offset10 = offset + 1;
        char chLocal2 = charAt(this.bp + offset);
        if (chLocal2 == ',') {
            this.bp += offset10 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return value;
        }
        if (chLocal2 == '}') {
            int offset11 = offset10 + 1;
            char chLocal3 = charAt(this.bp + offset10);
            if (chLocal3 == ',') {
                this.token = 16;
                this.bp += offset11 - 1;
                next();
            } else if (chLocal3 == ']') {
                this.token = 15;
                this.bp += offset11 - 1;
                next();
            } else if (chLocal3 == '}') {
                this.token = 13;
                this.bp += offset11 - 1;
                next();
            } else if (chLocal3 == 26) {
                this.token = 20;
                this.bp += offset11 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return value;
        }
        this.matchStat = -1;
        return false;
    }

    public long scanFieldLong(char[] fieldName) {
        char chLocal;
        this.matchStat = 0;
        if (!charArrayCompare(fieldName)) {
            this.matchStat = -2;
            return 0L;
        }
        int offset = fieldName.length;
        int offset2 = offset + 1;
        char chLocal2 = charAt(this.bp + offset);
        if (chLocal2 >= '0' && chLocal2 <= '9') {
            long value = digits[chLocal2];
            while (true) {
                int offset3 = offset2;
                offset2 = offset3 + 1;
                chLocal = charAt(this.bp + offset3);
                if (chLocal < '0' || chLocal > '9') {
                    break;
                }
                value = (10 * value) + ((long) digits[chLocal]);
            }
            if (chLocal == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (value < 0) {
                this.matchStat = -1;
                return 0L;
            }
            if (chLocal == ',') {
                this.bp += offset2 - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return value;
            }
            if (chLocal == '}') {
                int offset4 = offset2 + 1;
                char chLocal3 = charAt(this.bp + offset2);
                if (chLocal3 == ',') {
                    this.token = 16;
                    this.bp += offset4 - 1;
                    next();
                } else if (chLocal3 == ']') {
                    this.token = 15;
                    this.bp += offset4 - 1;
                    next();
                } else if (chLocal3 == '}') {
                    this.token = 13;
                    this.bp += offset4 - 1;
                    next();
                } else if (chLocal3 == 26) {
                    this.token = 20;
                    this.bp += offset4 - 1;
                    this.ch = (char) 26;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
                this.matchStat = 4;
                return value;
            }
            this.matchStat = -1;
            return 0L;
        }
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char expectNextChar) {
        char chLocal;
        this.matchStat = 0;
        int offset = 0 + 1;
        char chLocal2 = charAt(this.bp + 0);
        if (chLocal2 >= '0' && chLocal2 <= '9') {
            long value = digits[chLocal2];
            while (true) {
                int offset2 = offset;
                offset = offset2 + 1;
                chLocal = charAt(this.bp + offset2);
                if (chLocal < '0' || chLocal > '9') {
                    break;
                }
                value = (10 * value) + ((long) digits[chLocal]);
            }
            if (chLocal == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (value < 0) {
                this.matchStat = -1;
                return 0L;
            }
            if (chLocal == expectNextChar) {
                this.bp += offset - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return value;
            }
            this.matchStat = -1;
            return value;
        }
        this.matchStat = -1;
        return 0L;
    }

    public final float scanFieldFloat(char[] fieldName) {
        char chLocal;
        this.matchStat = 0;
        if (!charArrayCompare(fieldName)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int offset = fieldName.length;
        int offset2 = offset + 1;
        char chLocal2 = charAt(this.bp + offset);
        if (chLocal2 >= '0' && chLocal2 <= '9') {
            do {
                int offset3 = offset2;
                offset2 = offset3 + 1;
                chLocal = charAt(this.bp + offset3);
                if (chLocal < '0') {
                    break;
                }
            } while (chLocal <= '9');
            if (chLocal == '.') {
                int offset4 = offset2 + 1;
                char chLocal3 = charAt(this.bp + offset2);
                if (chLocal3 < '0' || chLocal3 > '9') {
                    this.matchStat = -1;
                    return 0.0f;
                }
                while (true) {
                    offset2 = offset4 + 1;
                    chLocal = charAt(this.bp + offset4);
                    if (chLocal < '0' || chLocal > '9') {
                        break;
                    }
                    offset4 = offset2;
                }
            }
            int offset5 = offset2;
            int start = this.bp + fieldName.length;
            int count = ((this.bp + offset5) - start) - 1;
            String text = subString(start, count);
            float f = Float.parseFloat(text);
            if (chLocal == ',') {
                this.bp += offset5 - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return f;
            }
            if (chLocal == '}') {
                int offset6 = offset5 + 1;
                char chLocal4 = charAt(this.bp + offset5);
                if (chLocal4 == ',') {
                    this.token = 16;
                    this.bp += offset6 - 1;
                    next();
                } else if (chLocal4 == ']') {
                    this.token = 15;
                    this.bp += offset6 - 1;
                    next();
                } else if (chLocal4 == '}') {
                    this.token = 13;
                    this.bp += offset6 - 1;
                    next();
                } else if (chLocal4 == 26) {
                    this.bp += offset6 - 1;
                    this.token = 20;
                    this.ch = (char) 26;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
                this.matchStat = 4;
                return f;
            }
            this.matchStat = -1;
            return 0.0f;
        }
        this.matchStat = -1;
        return 0.0f;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0073  */
    public final float scanFloat(char seperator) {
        char chLocal;
        int offset;
        float f = 0.0f;
        this.matchStat = 0;
        int offset2 = 0 + 1;
        char chLocal2 = charAt(this.bp + 0);
        if (chLocal2 >= '0' && chLocal2 <= '9') {
            do {
                int offset3 = offset2;
                offset2 = offset3 + 1;
                chLocal = charAt(this.bp + offset3);
                if (chLocal < '0') {
                    break;
                }
            } while (chLocal <= '9');
            if (chLocal == '.') {
                int offset4 = offset2 + 1;
                char chLocal3 = charAt(this.bp + offset2);
                if (chLocal3 < '0' || chLocal3 > '9') {
                    this.matchStat = -1;
                } else {
                    while (true) {
                        offset2 = offset4 + 1;
                        chLocal = charAt(this.bp + offset4);
                        if (chLocal < '0' || chLocal > '9') {
                            break;
                        }
                        offset4 = offset2;
                    }
                    offset = offset2;
                    int start = this.bp;
                    int count = ((this.bp + offset) - start) - 1;
                    String text = subString(start, count);
                    f = Float.parseFloat(text);
                    if (chLocal == seperator) {
                        this.bp += offset - 1;
                        next();
                        this.matchStat = 3;
                        this.token = 16;
                    } else {
                        this.matchStat = -1;
                    }
                }
            } else {
                offset = offset2;
                int start2 = this.bp;
                int count2 = ((this.bp + offset) - start2) - 1;
                String text2 = subString(start2, count2);
                f = Float.parseFloat(text2);
                if (chLocal == seperator) {
                    this.bp += offset - 1;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                } else {
                    this.matchStat = -1;
                }
            }
        } else {
            this.matchStat = -1;
        }
        return f;
    }

    public final double scanFieldDouble(char[] fieldName) {
        char chLocal;
        this.matchStat = 0;
        if (!charArrayCompare(fieldName)) {
            this.matchStat = -2;
            return 0.0d;
        }
        int offset = fieldName.length;
        int offset2 = offset + 1;
        char chLocal2 = charAt(this.bp + offset);
        if (chLocal2 >= '0' && chLocal2 <= '9') {
            do {
                int offset3 = offset2;
                offset2 = offset3 + 1;
                chLocal = charAt(this.bp + offset3);
                if (chLocal < '0') {
                    break;
                }
            } while (chLocal <= '9');
            if (chLocal == '.') {
                int offset4 = offset2 + 1;
                char chLocal3 = charAt(this.bp + offset2);
                if (chLocal3 < '0' || chLocal3 > '9') {
                    this.matchStat = -1;
                    return 0.0d;
                }
                while (true) {
                    offset2 = offset4 + 1;
                    chLocal = charAt(this.bp + offset4);
                    if (chLocal < '0' || chLocal > '9') {
                        break;
                    }
                    offset4 = offset2;
                }
            }
            if (chLocal == 'e' || chLocal == 'E') {
                int offset5 = offset2 + 1;
                chLocal = charAt(this.bp + offset2);
                if (chLocal == '+' || chLocal == '-') {
                    offset2 = offset5 + 1;
                    chLocal = charAt(this.bp + offset5);
                } else {
                    offset2 = offset5;
                }
                while (chLocal >= '0' && chLocal <= '9') {
                    chLocal = charAt(this.bp + offset2);
                    offset2++;
                }
            }
            int offset6 = offset2;
            int start = this.bp + fieldName.length;
            int count = ((this.bp + offset6) - start) - 1;
            String text = subString(start, count);
            double d = Double.parseDouble(text);
            if (chLocal == ',') {
                this.bp += offset6 - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return d;
            }
            if (chLocal == '}') {
                int offset7 = offset6 + 1;
                char chLocal4 = charAt(this.bp + offset6);
                if (chLocal4 == ',') {
                    this.token = 16;
                    this.bp += offset7 - 1;
                    next();
                } else if (chLocal4 == ']') {
                    this.token = 15;
                    this.bp += offset7 - 1;
                    next();
                } else if (chLocal4 == '}') {
                    this.token = 13;
                    this.bp += offset7 - 1;
                    next();
                } else if (chLocal4 == 26) {
                    this.token = 20;
                    this.bp += offset7 - 1;
                    this.ch = (char) 26;
                } else {
                    this.matchStat = -1;
                    return 0.0d;
                }
                this.matchStat = 4;
                return d;
            }
            this.matchStat = -1;
            return 0.0d;
        }
        this.matchStat = -1;
        return 0.0d;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    /* JADX WARN: Code duplicated, block: B:27:0x0060  */
    /* JADX WARN: Code duplicated, block: B:29:0x0064  */
    /* JADX WARN: Code duplicated, block: B:31:0x006f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:35:0x008f  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a5  */
    public final double scanFieldDouble(char seperator) {
        char chLocal;
        int offset;
        int offset2;
        double d = 0.0d;
        this.matchStat = 0;
        int offset3 = 0 + 1;
        char chLocal2 = charAt(this.bp + 0);
        if (chLocal2 >= '0' && chLocal2 <= '9') {
            do {
                int offset4 = offset3;
                offset3 = offset4 + 1;
                chLocal = charAt(this.bp + offset4);
                if (chLocal < '0') {
                    break;
                }
            } while (chLocal <= '9');
            if (chLocal == '.') {
                int offset5 = offset3 + 1;
                char chLocal3 = charAt(this.bp + offset3);
                if (chLocal3 < '0' || chLocal3 > '9') {
                    this.matchStat = -1;
                } else {
                    while (true) {
                        offset3 = offset5 + 1;
                        chLocal = charAt(this.bp + offset5);
                        if (chLocal < '0' || chLocal > '9') {
                            break;
                        }
                        offset5 = offset3;
                    }
                    if (chLocal != 'e' || chLocal == 'E') {
                        offset = offset3 + 1;
                        chLocal = charAt(this.bp + offset3);
                        if (chLocal != '+' || chLocal == '-') {
                            offset3 = offset + 1;
                            chLocal = charAt(this.bp + offset);
                        } else {
                            offset3 = offset;
                        }
                        while (chLocal >= '0' && chLocal <= '9') {
                            chLocal = charAt(this.bp + offset3);
                            offset3++;
                        }
                    }
                    offset2 = offset3;
                    int start = this.bp;
                    int count = ((this.bp + offset2) - start) - 1;
                    String text = subString(start, count);
                    d = Double.parseDouble(text);
                    if (chLocal == seperator) {
                        this.bp += offset2 - 1;
                        next();
                        this.matchStat = 3;
                        this.token = 16;
                    } else {
                        this.matchStat = -1;
                    }
                }
            } else {
                if (chLocal != 'e') {
                    offset = offset3 + 1;
                    chLocal = charAt(this.bp + offset3);
                    if (chLocal != '+') {
                        offset3 = offset + 1;
                        chLocal = charAt(this.bp + offset);
                    } else {
                        offset3 = offset + 1;
                        chLocal = charAt(this.bp + offset);
                    }
                    while (chLocal >= '0') {
                        chLocal = charAt(this.bp + offset3);
                        offset3++;
                    }
                } else {
                    offset = offset3 + 1;
                    chLocal = charAt(this.bp + offset3);
                    if (chLocal != '+') {
                        offset3 = offset + 1;
                        chLocal = charAt(this.bp + offset);
                    } else {
                        offset3 = offset + 1;
                        chLocal = charAt(this.bp + offset);
                    }
                    while (chLocal >= '0') {
                        chLocal = charAt(this.bp + offset3);
                        offset3++;
                    }
                }
                offset2 = offset3;
                int start2 = this.bp;
                int count2 = ((this.bp + offset2) - start2) - 1;
                String text2 = subString(start2, count2);
                d = Double.parseDouble(text2);
                if (chLocal == seperator) {
                    this.bp += offset2 - 1;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                } else {
                    this.matchStat = -1;
                }
            }
        } else {
            this.matchStat = -1;
        }
        return d;
    }

    public final void scanTrue() {
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b' || this.ch == ':') {
            this.token = 6;
            return;
        }
        throw new JSONException("scan true error");
    }

    public final void scanTreeSet() {
        if (this.ch != 'T') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'S') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch == ' ' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b' || this.ch == '[' || this.ch == '(') {
            this.token = 22;
            return;
        }
        throw new JSONException("scan set error");
    }

    public final void scanNullOrNew() {
        if (this.ch != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        if (this.ch == 'u') {
            next();
            if (this.ch != 'l') {
                throw new JSONException("error parse l");
            }
            next();
            if (this.ch != 'l') {
                throw new JSONException("error parse l");
            }
            next();
            if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b') {
                this.token = 8;
                return;
            }
            throw new JSONException("scan true error");
        }
        if (this.ch != 'e') {
            throw new JSONException("error parse e");
        }
        next();
        if (this.ch != 'w') {
            throw new JSONException("error parse w");
        }
        next();
        if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b') {
            this.token = 9;
            return;
        }
        throw new JSONException("scan true error");
    }

    public final void scanNULL() {
        if (this.ch != 'N') {
            throw new JSONException("error parse NULL");
        }
        next();
        if (this.ch == 'U') {
            next();
            if (this.ch != 'L') {
                throw new JSONException("error parse U");
            }
            next();
            if (this.ch != 'L') {
                throw new JSONException("error parse NULL");
            }
            next();
            if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b') {
                this.token = 8;
                return;
            }
            throw new JSONException("scan NULL error");
        }
    }

    public final void scanUndefined() {
        if (this.ch != 'u') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'n') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'd') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'i') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'n') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'd') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b') {
            this.token = 23;
            return;
        }
        throw new JSONException("scan false error");
    }

    public final void scanFalse() {
        if (this.ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b' || this.ch == ':') {
            this.token = 7;
            return;
        }
        throw new JSONException("scan false error");
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String ident = stringVal();
        Integer tok = this.keywods.get(ident);
        if (tok != null) {
            this.token = tok.intValue();
        } else {
            this.token = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char chLocal = charAt(i);
            if (chLocal != 26) {
                if (isWhitespace(chLocal)) {
                    i++;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (this.ch < IOUtils.whitespaceFlags.length && IOUtils.whitespaceFlags[this.ch]) {
            next();
        }
    }

    private void scanStringSingleQuote() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char chLocal = next();
            if (chLocal != '\'') {
                if (chLocal == 26) {
                    throw new JSONException("unclosed single-quote string");
                }
                if (chLocal == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        if (this.sp > this.sbuf.length) {
                            char[] newsbuf = new char[this.sp * 2];
                            System.arraycopy(this.sbuf, 0, newsbuf, 0, this.sbuf.length);
                            this.sbuf = newsbuf;
                        }
                        copyTo(this.np + 1, this.sp, this.sbuf);
                    }
                    char chLocal2 = next();
                    switch (chLocal2) {
                        case '\"':
                            putChar('\"');
                            break;
                        case '\'':
                            putChar('\'');
                            break;
                        case '/':
                            putChar('/');
                            break;
                        case '0':
                            putChar((char) 0);
                            break;
                        case '1':
                            putChar((char) 1);
                            break;
                        case '2':
                            putChar((char) 2);
                            break;
                        case '3':
                            putChar((char) 3);
                            break;
                        case '4':
                            putChar((char) 4);
                            break;
                        case '5':
                            putChar((char) 5);
                            break;
                        case '6':
                            putChar((char) 6);
                            break;
                        case '7':
                            putChar((char) 7);
                            break;
                        case 'F':
                        case 'f':
                            putChar('\f');
                            break;
                        case '\\':
                            putChar('\\');
                            break;
                        case 'b':
                            putChar('\b');
                            break;
                        case 'n':
                            putChar('\n');
                            break;
                        case 'r':
                            putChar('\r');
                            break;
                        case 't':
                            putChar('\t');
                            break;
                        case 'u':
                            int val = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                            putChar((char) val);
                            break;
                        case 'v':
                            putChar((char) 11);
                            break;
                        case 'x':
                            int x_val = (digits[next()] * 16) + digits[next()];
                            char x_char = (char) x_val;
                            putChar(x_char);
                            break;
                        default:
                            this.ch = chLocal2;
                            throw new JSONException("unclosed single-quote string");
                    }
                } else if (!this.hasSpecial) {
                    this.sp++;
                } else if (this.sp == this.sbuf.length) {
                    putChar(chLocal);
                } else {
                    char[] cArr = this.sbuf;
                    int i = this.sp;
                    this.sp = i + 1;
                    cArr[i] = chLocal;
                }
            } else {
                this.token = 4;
                next();
                return;
            }
        }
    }

    public final void scanSet() {
        if (this.ch != 'S') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch == ' ' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b' || this.ch == '[' || this.ch == '(') {
            this.token = 21;
            return;
        }
        throw new JSONException("scan set error");
    }

    protected final void putChar(char ch) {
        if (this.sp == this.sbuf.length) {
            char[] newsbuf = new char[this.sbuf.length * 2];
            System.arraycopy(this.sbuf, 0, newsbuf, 0, this.sbuf.length);
            this.sbuf = newsbuf;
        }
        char[] cArr = this.sbuf;
        int i = this.sp;
        this.sp = i + 1;
        cArr[i] = ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanNumber() {
        this.np = this.bp;
        if (this.ch == '-') {
            this.sp++;
            next();
        }
        while (this.ch >= '0' && this.ch <= '9') {
            this.sp++;
            next();
        }
        boolean isDouble = false;
        if (this.ch == '.') {
            this.sp++;
            next();
            isDouble = true;
            while (this.ch >= '0' && this.ch <= '9') {
                this.sp++;
                next();
            }
        }
        if (this.ch == 'L' || this.ch == 'S' || this.ch == 'B') {
            this.sp++;
            next();
        } else if (this.ch == 'F' || this.ch == 'D') {
            this.sp++;
            next();
            isDouble = true;
        } else if (this.ch == 'e' || this.ch == 'E') {
            this.sp++;
            next();
            if (this.ch == '+' || this.ch == '-') {
                this.sp++;
                next();
            }
            while (this.ch >= '0' && this.ch <= '9') {
                this.sp++;
                next();
            }
            if (this.ch == 'D' || this.ch == 'F') {
                this.sp++;
                next();
            }
            isDouble = true;
        }
        if (isDouble) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final long longValue() throws NumberFormatException {
        long limit;
        int i;
        int i2;
        long result = 0;
        boolean negative = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i3 = this.np;
        int max = this.np + this.sp;
        if (charAt(this.np) == '-') {
            negative = true;
            limit = Long.MIN_VALUE;
            i = i3 + 1;
        } else {
            limit = -9223372036854775807L;
            i = i3;
        }
        if (negative) {
        }
        if (i < max) {
            result = -digits[charAt(i)];
            i++;
        }
        while (true) {
            if (i >= max) {
                i2 = i;
                break;
            }
            i2 = i + 1;
            char chLocal = charAt(i);
            if (chLocal == 'L' || chLocal == 'S' || chLocal == 'B') {
                break;
            }
            int digit = digits[chLocal];
            if (result < -922337203685477580L) {
                throw new NumberFormatException(numberString());
            }
            long result2 = result * 10;
            if (result2 < ((long) digit) + limit) {
                throw new NumberFormatException(numberString());
            }
            result = result2 - ((long) digit);
            i = i2;
        }
        if (negative) {
            if (i2 <= this.np + 1) {
                throw new NumberFormatException(numberString());
            }
            return result;
        }
        return -result;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean decimal) {
        char chLocal = charAt((this.np + this.sp) - 1);
        if (chLocal == 'F') {
            return Float.valueOf(Float.parseFloat(numberString()));
        }
        if (chLocal == 'D') {
            return Double.valueOf(Double.parseDouble(numberString()));
        }
        if (decimal) {
            return decimalValue();
        }
        return Double.valueOf(doubleValue());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        return new BigDecimal(numberString());
    }

    public static boolean isWhitespace(char ch) {
        return ch == ' ' || ch == '\n' || ch == '\r' || ch == '\t' || ch == '\f' || ch == '\b';
    }
}
