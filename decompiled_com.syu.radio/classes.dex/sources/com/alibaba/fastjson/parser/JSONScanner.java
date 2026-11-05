package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.Base64;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class JSONScanner extends JSONLexerBase {
    private static boolean isAndroid = ASMUtils.isAndroid();
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    public final int ISO8601_LEN_0;
    public final int ISO8601_LEN_1;
    public final int ISO8601_LEN_2;
    private final String text;

    public JSONScanner(String input) {
        this(input, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(String input, int features) {
        this.ISO8601_LEN_0 = "0000-00-00".length();
        this.ISO8601_LEN_1 = "0000-00-00T00:00:00".length();
        this.ISO8601_LEN_2 = "0000-00-00T00:00:00.000".length();
        this.features = features;
        this.text = input;
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int index) {
        if (index >= this.text.length()) {
            return (char) 26;
        }
        return this.text.charAt(index);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char doNext() {
        int i = this.bp + 1;
        this.bp = i;
        char cCharAt = charAt(i);
        this.ch = cCharAt;
        return cCharAt;
    }

    public JSONScanner(char[] input, int inputLength) {
        this(input, inputLength, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] input, int inputLength, int features) {
        this(new String(input, 0, inputLength), features);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int offset, int count, char[] dest) {
        this.text.getChars(offset, offset + count, dest, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int scanType(String type) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, typeFieldName)) {
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

    static boolean charArrayCompare(String src, int offset, char[] dest) {
        int destLen = dest.length;
        if (destLen + offset > src.length()) {
            return false;
        }
        for (int i = 0; i < destLen; i++) {
            if (dest[i] != src.charAt(offset + i)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] chars) {
        return charArrayCompare(this.text, this.bp, chars);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char ch, int startIndex) {
        return this.text.indexOf(ch, startIndex);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int offset, int len, int hash, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, offset, len, hash);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        return Base64.decodeFast(this.text, this.np + 1, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        return !this.hasSpecial ? subString(this.np + 1, this.sp) : new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int offset, int count) {
        if (isAndroid) {
            char[] chars = new char[count];
            for (int i = offset; i < offset + count; i++) {
                chars[i - offset] = this.text.charAt(i);
            }
            return new String(chars);
        }
        return this.text.substring(offset, offset + count);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char chLocal = charAt((this.np + this.sp) - 1);
        int sp = this.sp;
        if (chLocal == 'L' || chLocal == 'S' || chLocal == 'B' || chLocal == 'F' || chLocal == 'D') {
            sp--;
        }
        return subString(this.np, sp);
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    public boolean scanISO8601DateIfMatch(boolean strict) {
        int hour;
        int minute;
        int seconds;
        int millis;
        int rest = this.text.length() - this.bp;
        if (!strict && rest > 13) {
            char c0 = charAt(this.bp);
            char c1 = charAt(this.bp + 1);
            char c2 = charAt(this.bp + 2);
            char c3 = charAt(this.bp + 3);
            char c4 = charAt(this.bp + 4);
            char c5 = charAt(this.bp + 5);
            char c_r0 = charAt((this.bp + rest) - 1);
            char c_r1 = charAt((this.bp + rest) - 2);
            if (c0 == '/' && c1 == 'D' && c2 == 'a' && c3 == 't' && c4 == 'e' && c5 == '(' && c_r0 == '/' && c_r1 == ')') {
                int plusIndex = -1;
                for (int i = 6; i < rest; i++) {
                    char c = charAt(this.bp + i);
                    if (c == '+') {
                        plusIndex = i;
                    } else if (c < '0' || c > '9') {
                        break;
                    }
                }
                if (plusIndex == -1) {
                    return false;
                }
                int offset = this.bp + 6;
                String numberText = subString(offset, plusIndex - offset);
                long millis2 = Long.parseLong(numberText);
                Locale local = Locale.getDefault();
                this.calendar = Calendar.getInstance(TimeZone.getDefault(), local);
                this.calendar.setTimeInMillis(millis2);
                this.token = 5;
                return true;
            }
        }
        if (rest == 8 || rest == 14 || rest == 17) {
            if (strict) {
                return false;
            }
            char y0 = charAt(this.bp);
            char y1 = charAt(this.bp + 1);
            char y2 = charAt(this.bp + 2);
            char y3 = charAt(this.bp + 3);
            char M0 = charAt(this.bp + 4);
            char M1 = charAt(this.bp + 5);
            char d0 = charAt(this.bp + 6);
            char d1 = charAt(this.bp + 7);
            if (!checkDate(y0, y1, y2, y3, M0, M1, d0, d1)) {
                return false;
            }
            setCalendar(y0, y1, y2, y3, M0, M1, d0, d1);
            if (rest != 8) {
                char h0 = charAt(this.bp + 8);
                char h1 = charAt(this.bp + 9);
                char m0 = charAt(this.bp + 10);
                char m1 = charAt(this.bp + 11);
                char s0 = charAt(this.bp + 12);
                char s1 = charAt(this.bp + 13);
                if (!checkTime(h0, h1, m0, m1, s0, s1)) {
                    return false;
                }
                if (rest == 17) {
                    char S0 = charAt(this.bp + 14);
                    char S1 = charAt(this.bp + 15);
                    char S2 = charAt(this.bp + 16);
                    if (S0 < '0' || S0 > '9' || S1 < '0' || S1 > '9' || S2 < '0' || S2 > '9') {
                        return false;
                    }
                    millis = (digits[S0] * 100) + (digits[S1] * 10) + digits[S2];
                } else {
                    millis = 0;
                }
                hour = (digits[h0] * 10) + digits[h1];
                minute = (digits[m0] * 10) + digits[m1];
                seconds = (digits[s0] * 10) + digits[s1];
            } else {
                hour = 0;
                minute = 0;
                seconds = 0;
                millis = 0;
            }
            this.calendar.set(11, hour);
            this.calendar.set(12, minute);
            this.calendar.set(13, seconds);
            this.calendar.set(14, millis);
            this.token = 5;
            return true;
        }
        if (rest < this.ISO8601_LEN_0 || charAt(this.bp + 4) != '-' || charAt(this.bp + 7) != '-') {
            return false;
        }
        char y4 = charAt(this.bp);
        char y5 = charAt(this.bp + 1);
        char y6 = charAt(this.bp + 2);
        char y7 = charAt(this.bp + 3);
        char M2 = charAt(this.bp + 5);
        char M3 = charAt(this.bp + 6);
        char d2 = charAt(this.bp + 8);
        char d3 = charAt(this.bp + 9);
        if (!checkDate(y4, y5, y6, y7, M2, M3, d2, d3)) {
            return false;
        }
        setCalendar(y4, y5, y6, y7, M2, M3, d2, d3);
        char t = charAt(this.bp + 10);
        if (t == 'T' || (t == ' ' && !strict)) {
            if (rest < this.ISO8601_LEN_1 || charAt(this.bp + 13) != ':' || charAt(this.bp + 16) != ':') {
                return false;
            }
            char h2 = charAt(this.bp + 11);
            char h3 = charAt(this.bp + 12);
            char m2 = charAt(this.bp + 14);
            char m3 = charAt(this.bp + 15);
            char s2 = charAt(this.bp + 17);
            char s3 = charAt(this.bp + 18);
            if (!checkTime(h2, h3, m2, m3, s2, s3)) {
                return false;
            }
            int hour2 = (digits[h2] * 10) + digits[h3];
            int minute2 = (digits[m2] * 10) + digits[m3];
            int seconds2 = (digits[s2] * 10) + digits[s3];
            this.calendar.set(11, hour2);
            this.calendar.set(12, minute2);
            this.calendar.set(13, seconds2);
            char dot = charAt(this.bp + 19);
            if (dot == '.') {
                if (rest < this.ISO8601_LEN_2) {
                    return false;
                }
                char S3 = charAt(this.bp + 20);
                if (S3 < '0' || S3 > '9') {
                    return false;
                }
                int millis3 = digits[S3];
                int millisLen = 1;
                char S4 = charAt(this.bp + 21);
                if (S4 >= '0' && S4 <= '9') {
                    millis3 = (millis3 * 10) + digits[S4];
                    millisLen = 2;
                }
                if (millisLen == 2) {
                    char S5 = charAt(this.bp + 22);
                    if (S5 >= '0' && S5 <= '9') {
                        millis3 = (millis3 * 10) + digits[S5];
                        millisLen = 3;
                    }
                }
                this.calendar.set(14, millis3);
                int timzeZoneLength = 0;
                char timeZoneFlag = charAt(this.bp + 20 + millisLen);
                if (timeZoneFlag == '+' || timeZoneFlag == '-') {
                    char t0 = charAt(this.bp + 20 + millisLen + 1);
                    if (t0 < '0' || t0 > '1') {
                        return false;
                    }
                    char t1 = charAt(this.bp + 20 + millisLen + 2);
                    if (t1 < '0' || t1 > '9') {
                        return false;
                    }
                    char t2 = charAt(this.bp + 20 + millisLen + 3);
                    if (t2 == ':') {
                        char t3 = charAt(this.bp + 20 + millisLen + 4);
                        if (t3 != '0') {
                            return false;
                        }
                        char t4 = charAt(this.bp + 20 + millisLen + 5);
                        if (t4 != '0') {
                            return false;
                        }
                        timzeZoneLength = 6;
                    } else if (t2 == '0') {
                        char t5 = charAt(this.bp + 20 + millisLen + 4);
                        if (t5 != '0') {
                            return false;
                        }
                        timzeZoneLength = 5;
                    } else {
                        timzeZoneLength = 3;
                    }
                    int timeZoneOffset = ((digits[t0] * 10) + digits[t1]) * 3600 * 1000;
                    if (timeZoneFlag == '-') {
                        timeZoneOffset = -timeZoneOffset;
                    }
                    if (this.calendar.getTimeZone().getRawOffset() != timeZoneOffset) {
                        String[] timeZoneIDs = TimeZone.getAvailableIDs(timeZoneOffset);
                        if (timeZoneIDs.length > 0) {
                            TimeZone timeZone = TimeZone.getTimeZone(timeZoneIDs[0]);
                            this.calendar.setTimeZone(timeZone);
                        }
                    }
                } else if (timeZoneFlag == 'Z') {
                    timzeZoneLength = 1;
                    if (this.calendar.getTimeZone().getRawOffset() != 0) {
                        String[] timeZoneIDs2 = TimeZone.getAvailableIDs(0);
                        if (timeZoneIDs2.length > 0) {
                            TimeZone timeZone2 = TimeZone.getTimeZone(timeZoneIDs2[0]);
                            this.calendar.setTimeZone(timeZone2);
                        }
                    }
                }
                char end = charAt(this.bp + millisLen + 20 + timzeZoneLength);
                if (end != 26 && end != '\"') {
                    return false;
                }
                int i2 = this.bp + millisLen + 20 + timzeZoneLength;
                this.bp = i2;
                this.ch = charAt(i2);
                this.token = 5;
                return true;
            }
            this.calendar.set(14, 0);
            int i3 = this.bp + 19;
            this.bp = i3;
            this.ch = charAt(i3);
            this.token = 5;
            if (dot == 'Z' && this.calendar.getTimeZone().getRawOffset() != 0) {
                String[] timeZoneIDs3 = TimeZone.getAvailableIDs(0);
                if (timeZoneIDs3.length > 0) {
                    TimeZone timeZone3 = TimeZone.getTimeZone(timeZoneIDs3[0]);
                    this.calendar.setTimeZone(timeZone3);
                }
            }
            return true;
        }
        if (t == '\"' || t == 26) {
            this.calendar.set(11, 0);
            this.calendar.set(12, 0);
            this.calendar.set(13, 0);
            this.calendar.set(14, 0);
            int i4 = this.bp + 10;
            this.bp = i4;
            this.ch = charAt(i4);
            this.token = 5;
            return true;
        }
        return false;
    }

    private boolean checkTime(char h0, char h1, char m0, char m1, char s0, char s1) {
        if (h0 == '0') {
            if (h1 < '0' || h1 > '9') {
                return false;
            }
        } else if (h0 == '1') {
            if (h1 < '0' || h1 > '9') {
                return false;
            }
        } else if (h0 != '2' || h1 < '0' || h1 > '4') {
            return false;
        }
        if (m0 >= '0' && m0 <= '5') {
            if (m1 < '0' || m1 > '9') {
                return false;
            }
        } else if (m0 != '6' || m1 != '0') {
            return false;
        }
        if (s0 >= '0' && s0 <= '5') {
            if (s1 < '0' || s1 > '9') {
                return false;
            }
        } else if (s0 != '6' || s1 != '0') {
            return false;
        }
        return true;
    }

    private void setCalendar(char y0, char y1, char y2, char y3, char M0, char M1, char d0, char d1) {
        Locale local = Locale.getDefault();
        this.calendar = Calendar.getInstance(TimeZone.getDefault(), local);
        int year = (digits[y0] * 1000) + (digits[y1] * 100) + (digits[y2] * 10) + digits[y3];
        int month = ((digits[M0] * 10) + digits[M1]) - 1;
        int day = (digits[d0] * 10) + digits[d1];
        this.calendar.set(1, year);
        this.calendar.set(2, month);
        this.calendar.set(5, day);
    }

    static boolean checkDate(char y0, char y1, char y2, char y3, char M0, char M1, int d0, int d1) {
        if ((y0 != '1' && y0 != '2') || y1 < '0' || y1 > '9' || y2 < '0' || y2 > '9' || y3 < '0' || y3 > '9') {
            return false;
        }
        if (M0 == '0') {
            if (M1 < '1' || M1 > '9') {
                return false;
            }
        } else {
            if (M0 != '1') {
                return false;
            }
            if (M1 != '0' && M1 != '1' && M1 != '2') {
                return false;
            }
        }
        if (d0 == 48) {
            if (d1 < 49 || d1 > 57) {
                return false;
            }
        } else if (d0 == 49 || d0 == 50) {
            if (d1 < 48 || d1 > 57) {
                return false;
            }
        } else {
            if (d0 != 51) {
                return false;
            }
            if (d1 != 48 && d1 != 49) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        return this.bp == this.text.length() || (this.ch == 26 && this.bp + 1 == this.text.length());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] fieldName) {
        char ch;
        this.matchStat = 0;
        int startPos = this.bp;
        char startChar = this.ch;
        if (!charArrayCompare(this.text, this.bp, fieldName)) {
            this.matchStat = -2;
            return 0;
        }
        int index = this.bp + fieldName.length;
        int index2 = index + 1;
        char ch2 = charAt(index);
        if (ch2 >= '0' && ch2 <= '9') {
            int value = digits[ch2];
            while (true) {
                int index3 = index2;
                index2 = index3 + 1;
                ch = charAt(index3);
                if (ch < '0' || ch > '9') {
                    break;
                }
                value = (value * 10) + digits[ch];
            }
            if (ch == '.') {
                this.matchStat = -1;
                return 0;
            }
            this.bp = index2 - 1;
            if (value < 0) {
                this.matchStat = -1;
                return 0;
            }
            if (ch == ',') {
                int i = this.bp + 1;
                this.bp = i;
                this.ch = charAt(i);
                this.matchStat = 3;
                this.token = 16;
                return value;
            }
            if (ch == '}') {
                int i2 = this.bp + 1;
                this.bp = i2;
                char ch3 = charAt(i2);
                if (ch3 == ',') {
                    this.token = 16;
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    this.ch = charAt(i3);
                } else if (ch3 == ']') {
                    this.token = 15;
                    int i4 = this.bp + 1;
                    this.bp = i4;
                    this.ch = charAt(i4);
                } else if (ch3 == '}') {
                    this.token = 13;
                    int i5 = this.bp + 1;
                    this.bp = i5;
                    this.ch = charAt(i5);
                } else if (ch3 == 26) {
                    this.token = 20;
                } else {
                    this.bp = startPos;
                    this.ch = startChar;
                    this.matchStat = -1;
                    return 0;
                }
                this.matchStat = 4;
                return value;
            }
            return value;
        }
        this.matchStat = -1;
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] fieldName) {
        this.matchStat = 0;
        int startPos = this.bp;
        char startChar = this.ch;
        if (!charArrayCompare(this.text, this.bp, fieldName)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int index = this.bp + fieldName.length;
        int index2 = index + 1;
        if (charAt(index) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        boolean hasSpecial = false;
        int endIndex = this.text.indexOf(34, index2);
        if (endIndex != -1) {
            String stringVal = subString(index2, endIndex - index2);
            for (int i = 0; i < stringVal.length(); i++) {
                if (stringVal.charAt(i) == '\\') {
                    hasSpecial = true;
                    break;
                }
            }
            if (hasSpecial) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.bp = endIndex + 1;
            char ch = charAt(this.bp);
            this.ch = ch;
            if (ch == ',') {
                int i2 = this.bp + 1;
                this.bp = i2;
                this.ch = charAt(i2);
                this.matchStat = 3;
                return stringVal;
            }
            if (ch == '}') {
                int i3 = this.bp + 1;
                this.bp = i3;
                char ch2 = charAt(i3);
                if (ch2 == ',') {
                    this.token = 16;
                    int i4 = this.bp + 1;
                    this.bp = i4;
                    this.ch = charAt(i4);
                } else if (ch2 == ']') {
                    this.token = 15;
                    int i5 = this.bp + 1;
                    this.bp = i5;
                    this.ch = charAt(i5);
                } else if (ch2 == '}') {
                    this.token = 13;
                    int i6 = this.bp + 1;
                    this.bp = i6;
                    this.ch = charAt(i6);
                } else if (ch2 == 26) {
                    this.token = 20;
                } else {
                    this.bp = startPos;
                    this.ch = startChar;
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
        throw new JSONException("unclosed str");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldSymbol(char[] fieldName, SymbolTable symbolTable) {
        char ch;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, fieldName)) {
            this.matchStat = -2;
            return null;
        }
        int index = this.bp + fieldName.length;
        int index2 = index + 1;
        if (charAt(index) != '\"') {
            this.matchStat = -1;
            return null;
        }
        int hash = 0;
        do {
            int index3 = index2;
            index2 = index3 + 1;
            ch = charAt(index3);
            if (ch == '\"') {
                this.bp = index2;
                char ch2 = charAt(this.bp);
                this.ch = ch2;
                String strAddSymbol = symbolTable.addSymbol(this.text, index2, (index2 - index2) - 1, hash);
                if (ch2 == ',') {
                    int i = this.bp + 1;
                    this.bp = i;
                    this.ch = charAt(i);
                    this.matchStat = 3;
                    return strAddSymbol;
                }
                if (ch2 == '}') {
                    int i2 = this.bp + 1;
                    this.bp = i2;
                    char ch3 = charAt(i2);
                    if (ch3 == ',') {
                        this.token = 16;
                        int i3 = this.bp + 1;
                        this.bp = i3;
                        this.ch = charAt(i3);
                    } else if (ch3 == ']') {
                        this.token = 15;
                        int i4 = this.bp + 1;
                        this.bp = i4;
                        this.ch = charAt(i4);
                    } else if (ch3 == '}') {
                        this.token = 13;
                        int i5 = this.bp + 1;
                        this.bp = i5;
                        this.ch = charAt(i5);
                    } else if (ch3 == 26) {
                        this.token = 20;
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
            hash = (hash * 31) + ch;
        } while (ch != '\\');
        this.matchStat = -1;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Collection<String> scanFieldStringArray(char[] fieldName, Class<?> type) {
        Collection<String> list;
        int index;
        int index2;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, fieldName)) {
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
        int index3 = this.bp + fieldName.length;
        int index4 = index3 + 1;
        char ch = charAt(index3);
        if (ch != '[') {
            this.matchStat = -1;
            return null;
        }
        int index5 = index4 + 1;
        char ch2 = charAt(index4);
        while (ch2 == '\"') {
            int start = index5;
            while (true) {
                index = index5 + 1;
                char ch3 = charAt(index5);
                if (ch3 == '\"') {
                    break;
                }
                if (ch3 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                index5 = index;
            }
            String strVal = subString(start, (index - start) - 1);
            list.add(strVal);
            int index6 = index + 1;
            char ch4 = charAt(index);
            if (ch4 == ',') {
                ch2 = charAt(index6);
                index5 = index6 + 1;
            } else {
                if (ch4 == ']') {
                    int index7 = index6 + 1;
                    char ch5 = charAt(index6);
                    while (true) {
                        index2 = index7;
                        if (!isWhitespace(ch5)) {
                            break;
                        }
                        index7 = index2 + 1;
                        ch5 = charAt(index2);
                    }
                    this.bp = index2;
                    if (ch5 == ',') {
                        this.ch = charAt(this.bp);
                        this.matchStat = 3;
                        return list;
                    }
                    if (ch5 == '}') {
                        char ch6 = charAt(this.bp);
                        while (isWhitespace(ch6)) {
                            int index8 = index2 + 1;
                            ch6 = charAt(index2);
                            this.bp = index8;
                            index2 = index8;
                        }
                        if (ch6 == ',') {
                            this.token = 16;
                            int i = this.bp + 1;
                            this.bp = i;
                            this.ch = charAt(i);
                        } else if (ch6 == ']') {
                            this.token = 15;
                            int i2 = this.bp + 1;
                            this.bp = i2;
                            this.ch = charAt(i2);
                        } else if (ch6 == '}') {
                            this.token = 13;
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            this.ch = charAt(i3);
                        } else if (ch6 == 26) {
                            this.token = 20;
                            this.ch = ch6;
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] fieldName) {
        char ch;
        this.matchStat = 0;
        int startPos = this.bp;
        char startChar = this.ch;
        if (!charArrayCompare(this.text, this.bp, fieldName)) {
            this.matchStat = -2;
            return 0L;
        }
        int index = this.bp + fieldName.length;
        int index2 = index + 1;
        char ch2 = charAt(index);
        if (ch2 >= '0' && ch2 <= '9') {
            long value = digits[ch2];
            while (true) {
                int index3 = index2;
                index2 = index3 + 1;
                ch = charAt(index3);
                if (ch < '0' || ch > '9') {
                    break;
                }
                value = (10 * value) + ((long) digits[ch]);
            }
            if (ch == '.') {
                this.matchStat = -1;
                return 0L;
            }
            this.bp = index2 - 1;
            if (value < 0) {
                this.bp = startPos;
                this.ch = startChar;
                this.matchStat = -1;
                return 0L;
            }
            if (ch == ',') {
                int i = this.bp + 1;
                this.bp = i;
                this.ch = charAt(i);
                this.matchStat = 3;
                this.token = 16;
                return value;
            }
            if (ch == '}') {
                int i2 = this.bp + 1;
                this.bp = i2;
                char ch3 = charAt(i2);
                if (ch3 == ',') {
                    this.token = 16;
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    this.ch = charAt(i3);
                } else if (ch3 == ']') {
                    this.token = 15;
                    int i4 = this.bp + 1;
                    this.bp = i4;
                    this.ch = charAt(i4);
                } else if (ch3 == '}') {
                    this.token = 13;
                    int i5 = this.bp + 1;
                    this.bp = i5;
                    this.ch = charAt(i5);
                } else if (ch3 == 26) {
                    this.token = 20;
                } else {
                    this.bp = startPos;
                    this.ch = startChar;
                    this.matchStat = -1;
                    return 0L;
                }
                this.matchStat = 4;
                return value;
            }
            this.matchStat = -1;
            return 0L;
        }
        this.bp = startPos;
        this.ch = startChar;
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean scanFieldBoolean(char[] fieldName) {
        char ch;
        boolean value;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, fieldName)) {
            this.matchStat = -2;
            return false;
        }
        int index = this.bp + fieldName.length;
        int index2 = index + 1;
        char ch2 = charAt(index);
        if (ch2 == 't') {
            int index3 = index2 + 1;
            if (charAt(index2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int index4 = index3 + 1;
            if (charAt(index3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            int index5 = index4 + 1;
            if (charAt(index4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            this.bp = index5;
            ch = charAt(this.bp);
            value = true;
        } else if (ch2 == 'f') {
            int index6 = index2 + 1;
            if (charAt(index2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int index7 = index6 + 1;
            if (charAt(index6) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int index8 = index7 + 1;
            if (charAt(index7) != 's') {
                this.matchStat = -1;
                return false;
            }
            int index9 = index8 + 1;
            if (charAt(index8) != 'e') {
                this.matchStat = -1;
                return false;
            }
            this.bp = index9;
            ch = charAt(this.bp);
            value = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        if (ch == ',') {
            int i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
            this.matchStat = 3;
            this.token = 16;
            return value;
        }
        if (ch == '}') {
            int i2 = this.bp + 1;
            this.bp = i2;
            char ch3 = charAt(i2);
            if (ch3 == ',') {
                this.token = 16;
                int i3 = this.bp + 1;
                this.bp = i3;
                this.ch = charAt(i3);
            } else if (ch3 == ']') {
                this.token = 15;
                int i4 = this.bp + 1;
                this.bp = i4;
                this.ch = charAt(i4);
            } else if (ch3 == '}') {
                this.token = 13;
                int i5 = this.bp + 1;
                this.bp = i5;
                this.ch = charAt(i5);
            } else if (ch3 == 26) {
                this.token = 20;
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int srcPos, char[] dest, int destPos, int length) {
        this.text.getChars(srcPos, srcPos + length, dest, destPos);
    }
}
