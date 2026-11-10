package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.Base64;
import com.alibaba.fastjson.util.IOUtils;
import com.lsec.core.util.data.FinalChip;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class SerializeWriter extends Writer {
    private static final ThreadLocal<SoftReference<char[]>> bufLocal = new ThreadLocal<>();
    protected char[] buf;
    protected int count;
    private int features;
    private final Writer writer;

    public SerializeWriter() {
        this((Writer) null);
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        SoftReference<char[]> ref = bufLocal.get();
        if (ref != null) {
            this.buf = ref.get();
            bufLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public SerializeWriter(SerializerFeature... features) {
        this((Writer) null, features);
    }

    public SerializeWriter(Writer writer, SerializerFeature... features) {
        this.writer = writer;
        SoftReference<char[]> ref = bufLocal.get();
        if (ref != null) {
            this.buf = ref.get();
            bufLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        int featuresValue = 0;
        for (SerializerFeature feature : features) {
            featuresValue |= feature.getMask();
        }
        this.features = featuresValue;
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public SerializeWriter(int initialSize) {
        this((Writer) null, initialSize);
    }

    public SerializeWriter(Writer writer, int initialSize) {
        this.writer = writer;
        if (initialSize <= 0) {
            throw new IllegalArgumentException("Negative initial size: " + initialSize);
        }
        this.buf = new char[initialSize];
    }

    public void config(SerializerFeature feature, boolean state) {
        if (state) {
            this.features |= feature.getMask();
            if (feature == SerializerFeature.WriteEnumUsingToString) {
                this.features &= SerializerFeature.WriteEnumUsingName.getMask() ^ (-1);
                return;
            } else {
                if (feature == SerializerFeature.WriteEnumUsingName) {
                    this.features &= SerializerFeature.WriteEnumUsingToString.getMask() ^ (-1);
                    return;
                }
                return;
            }
        }
        this.features &= feature.getMask() ^ (-1);
    }

    public boolean isEnabled(SerializerFeature feature) {
        return SerializerFeature.isEnabled(this.features, feature);
    }

    @Override // java.io.Writer
    public void write(int c) {
        int newcount = this.count + 1;
        if (newcount > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(newcount);
            } else {
                flush();
                newcount = 1;
            }
        }
        this.buf[this.count] = (char) c;
        this.count = newcount;
    }

    public void write(char c) {
        int newcount = this.count + 1;
        if (newcount > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(newcount);
            } else {
                flush();
                newcount = 1;
            }
        }
        this.buf[this.count] = c;
        this.count = newcount;
    }

    @Override // java.io.Writer
    public void write(char[] c, int off, int len) {
        if (off < 0 || off > c.length || len < 0 || off + len > c.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len != 0) {
            int newcount = this.count + len;
            if (newcount > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(newcount);
                } else {
                    do {
                        int rest = this.buf.length - this.count;
                        System.arraycopy(c, off, this.buf, this.count, rest);
                        this.count = this.buf.length;
                        flush();
                        len -= rest;
                        off += rest;
                    } while (len > this.buf.length);
                    newcount = len;
                }
            }
            System.arraycopy(c, off, this.buf, this.count, len);
            this.count = newcount;
        }
    }

    public void expandCapacity(int minimumCapacity) {
        int newCapacity = ((this.buf.length * 3) / 2) + 1;
        if (newCapacity < minimumCapacity) {
            newCapacity = minimumCapacity;
        }
        char[] newValue = new char[newCapacity];
        System.arraycopy(this.buf, 0, newValue, 0, this.count);
        this.buf = newValue;
    }

    @Override // java.io.Writer
    public void write(String str, int off, int len) {
        int newcount = this.count + len;
        if (newcount > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(newcount);
            } else {
                do {
                    int rest = this.buf.length - this.count;
                    str.getChars(off, off + rest, this.buf, this.count);
                    this.count = this.buf.length;
                    flush();
                    len -= rest;
                    off += rest;
                } while (len > this.buf.length);
                newcount = len;
            }
        }
        str.getChars(off, off + len, this.buf, this.count);
        this.count = newcount;
    }

    public void writeTo(Writer out) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        out.write(this.buf, 0, this.count);
    }

    public void writeTo(OutputStream out, String charsetName) throws IOException {
        writeTo(out, Charset.forName(charsetName));
    }

    public void writeTo(OutputStream out, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
        out.write(bytes);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence csq) {
        String s = csq == null ? "null" : csq.toString();
        write(s, 0, s.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        String s = csq.subSequence(start, end).toString();
        write(s, 0, s.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c) {
        write(c);
        return this;
    }

    public void reset() {
        this.count = 0;
    }

    public char[] toCharArray() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        char[] newValue = new char[this.count];
        System.arraycopy(this.buf, 0, newValue, 0, this.count);
        return newValue;
    }

    public byte[] toBytes(String charsetName) {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charsetName == null) {
            charsetName = HTTP.UTF_8;
        }
        Charset cs = Charset.forName(charsetName);
        SerialWriterStringEncoder encoder = new SerialWriterStringEncoder(cs);
        return encoder.encode(this.buf, 0, this.count);
    }

    public int size() {
        return this.count;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        if (this.buf.length <= 8192) {
            bufLocal.set(new SoftReference<>(this.buf));
        }
        this.buf = null;
    }

    @Override // java.io.Writer
    public void write(String text) {
        if (text == null) {
            writeNull();
        } else {
            write(text, 0, text.length());
        }
    }

    public void writeInt(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int size = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int newcount = this.count + size;
        if (newcount > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(newcount);
            } else {
                char[] chars = new char[size];
                IOUtils.getChars(i, size, chars);
                write(chars, 0, chars.length);
                return;
            }
        }
        IOUtils.getChars(i, newcount, this.buf);
        this.count = newcount;
    }

    public void writeByteArray(byte[] bytes) {
        int bytesLen = bytes.length;
        boolean singleQuote = isEnabled(SerializerFeature.UseSingleQuotes);
        char quote = singleQuote ? '\'' : '\"';
        if (bytesLen == 0) {
            String emptyString = singleQuote ? "''" : "\"\"";
            write(emptyString);
            return;
        }
        char[] CA = Base64.CA;
        int eLen = (bytesLen / 3) * 3;
        int charsLen = (((bytesLen - 1) / 3) + 1) << 2;
        int offset = this.count;
        int newcount = this.count + charsLen + 2;
        if (newcount > this.buf.length) {
            if (this.writer != null) {
                write(quote);
                int s = 0;
                while (true) {
                    int s2 = s;
                    if (s2 >= eLen) {
                        break;
                    }
                    int s3 = s2 + 1;
                    int i = (bytes[s2] & 255) << 16;
                    int s4 = s3 + 1;
                    int i2 = i | ((bytes[s3] & 255) << 8);
                    s = s4 + 1;
                    int i3 = i2 | (bytes[s4] & 255);
                    write(CA[(i3 >>> 18) & 63]);
                    write(CA[(i3 >>> 12) & 63]);
                    write(CA[(i3 >>> 6) & 63]);
                    write(CA[i3 & 63]);
                }
                int left = bytesLen - eLen;
                if (left > 0) {
                    int i4 = ((bytes[eLen] & 255) << 10) | (left == 2 ? (bytes[bytesLen - 1] & 255) << 2 : 0);
                    write(CA[i4 >> 12]);
                    write(CA[(i4 >>> 6) & 63]);
                    write(left == 2 ? CA[i4 & 63] : '=');
                    write('=');
                }
                write(quote);
                return;
            }
            expandCapacity(newcount);
        }
        this.count = newcount;
        this.buf[offset] = quote;
        int s5 = 0;
        int d = offset + 1;
        while (true) {
            int s6 = s5;
            if (s6 >= eLen) {
                break;
            }
            int s7 = s6 + 1;
            int i5 = (bytes[s6] & 255) << 16;
            int s8 = s7 + 1;
            int i6 = i5 | ((bytes[s7] & 255) << 8);
            s5 = s8 + 1;
            int i7 = i6 | (bytes[s8] & 255);
            int d2 = d + 1;
            this.buf[d] = CA[(i7 >>> 18) & 63];
            int d3 = d2 + 1;
            this.buf[d2] = CA[(i7 >>> 12) & 63];
            int d4 = d3 + 1;
            this.buf[d3] = CA[(i7 >>> 6) & 63];
            d = d4 + 1;
            this.buf[d4] = CA[i7 & 63];
        }
        int left2 = bytesLen - eLen;
        if (left2 > 0) {
            int i8 = ((bytes[eLen] & 255) << 10) | (left2 == 2 ? (bytes[bytesLen - 1] & 255) << 2 : 0);
            this.buf[newcount - 5] = CA[i8 >> 12];
            this.buf[newcount - 4] = CA[(i8 >>> 6) & 63];
            this.buf[newcount - 3] = left2 == 2 ? CA[i8 & 63] : '=';
            this.buf[newcount - 2] = '=';
        }
        this.buf[newcount - 1] = quote;
    }

    public void writeFloatAndChar(float value, char c) {
        String text = Float.toString(value);
        if (text.endsWith(".0")) {
            text = text.substring(0, text.length() - 2);
        }
        write(text);
        write(c);
    }

    public void writeDoubleAndChar(double value, char c) {
        String text = Double.toString(value);
        if (text.endsWith(".0")) {
            text = text.substring(0, text.length() - 2);
        }
        write(text);
        write(c);
    }

    public void writeBooleanAndChar(boolean value, char c) {
        if (value) {
            if (c == ',') {
                write("true,");
                return;
            } else if (c == ']') {
                write("true]");
                return;
            } else {
                write("true");
                write(c);
                return;
            }
        }
        if (c == ',') {
            write("false,");
        } else if (c == ']') {
            write("false]");
        } else {
            write("false");
            write(c);
        }
    }

    public void writeCharacterAndChar(char value, char c) {
        writeString(Character.toString(value));
        write(c);
    }

    public void writeEnum(Enum<?> value, char c) {
        if (value == null) {
            writeNull();
            write(',');
        } else if (isEnabled(SerializerFeature.WriteEnumUsingName)) {
            writeEnumValue(value.name(), c);
        } else if (isEnabled(SerializerFeature.WriteEnumUsingToString)) {
            writeEnumValue(value.toString(), c);
        } else {
            writeIntAndChar(value.ordinal(), c);
        }
    }

    private void writeEnumValue(String value, char c) {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            write('\'');
            write(value);
            write('\'');
            write(c);
            return;
        }
        write('\"');
        write(value);
        write('\"');
        write(c);
    }

    public void writeIntAndChar(int i, char c) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            write(c);
            return;
        }
        int size = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int newcount0 = this.count + size;
        int newcount1 = newcount0 + 1;
        if (newcount1 > this.buf.length) {
            if (this.writer != null) {
                writeInt(i);
                write(c);
                return;
            }
            expandCapacity(newcount1);
        }
        IOUtils.getChars(i, newcount0, this.buf);
        this.buf[newcount0] = c;
        this.count = newcount1;
    }

    public void writeLongAndChar(long i, char c) throws IOException {
        boolean needQuotationMark = needQuotationMark(i);
        if (i == Long.MIN_VALUE) {
            if (needQuotationMark) {
                write("\"-9223372036854775808\"");
            } else {
                write("-9223372036854775808");
            }
            write(c);
            return;
        }
        int size = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int newcount0 = this.count + size;
        if (needQuotationMark) {
            newcount0 += 2;
        }
        int newcount1 = newcount0 + 1;
        if (newcount1 > this.buf.length) {
            if (this.writer != null) {
                writeLong(i);
                write(c);
                return;
            }
            expandCapacity(newcount1);
        }
        if (needQuotationMark) {
            this.buf[this.count] = '\"';
            IOUtils.getChars(i, newcount0 - 1, this.buf);
            this.buf[newcount0 - 1] = '\"';
        } else {
            IOUtils.getChars(i, newcount0, this.buf);
        }
        this.buf[newcount0] = c;
        this.count = newcount1;
    }

    private boolean needQuotationMark(long val) {
        if (!isEnabled(SerializerFeature.BrowserCompatible) || isEnabled(SerializerFeature.WriteClassName)) {
            return false;
        }
        return val > 9007199254740991L || val < -9007199254740991L;
    }

    public void writeLong(long i) {
        boolean needQuotationMark = needQuotationMark(i);
        if (i == Long.MIN_VALUE) {
            if (needQuotationMark) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int size = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int newcount = this.count + size;
        if (needQuotationMark) {
            newcount += 2;
        }
        if (newcount > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(newcount);
            } else {
                char[] chars = new char[size];
                IOUtils.getChars(i, size, chars);
                if (needQuotationMark) {
                    write('\"');
                    write(chars, 0, chars.length);
                    write('\"');
                    return;
                }
                write(chars, 0, chars.length);
                return;
            }
        }
        if (needQuotationMark) {
            this.buf[this.count] = '\"';
            IOUtils.getChars(i, newcount - 1, this.buf);
            this.buf[newcount - 1] = '\"';
        } else {
            IOUtils.getChars(i, newcount, this.buf);
        }
        this.count = newcount;
    }

    public void writeNull() {
        write("null");
    }

    private void writeStringWithDoubleQuote(String text, char seperator) {
        writeStringWithDoubleQuote(text, seperator, true);
    }

    /* JADX WARN: Code duplicated, block: B:79:0x026c  */
    private void writeStringWithDoubleQuote(String text, char seperator, boolean checkSpecial) {
        if (text == null) {
            writeNull();
            if (seperator != 0) {
                write(seperator);
                return;
            }
            return;
        }
        int len = text.length();
        int newcount = this.count + len + 2;
        if (seperator != 0) {
            newcount++;
        }
        if (newcount > this.buf.length) {
            if (this.writer != null) {
                write('\"');
                for (int i = 0; i < text.length(); i++) {
                    char ch = text.charAt(i);
                    if (isEnabled(SerializerFeature.BrowserSecure)) {
                        if ((ch < '0' || ch > '9') && ((ch < 'a' || ch > 'z') && ((ch < 'A' || ch > 'Z') && ch != ',' && ch != '.' && ch != '_'))) {
                            write('\\');
                            write('u');
                            write(IOUtils.DIGITS[(ch >>> '\f') & 15]);
                            write(IOUtils.DIGITS[(ch >>> '\b') & 15]);
                            write(IOUtils.DIGITS[(ch >>> 4) & 15]);
                            write(IOUtils.DIGITS[ch & 15]);
                        } else {
                            write(ch);
                        }
                    } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
                        if (ch == '\b' || ch == '\f' || ch == '\n' || ch == '\r' || ch == '\t' || ch == '\"' || ch == '/' || ch == '\\') {
                            write('\\');
                            write(IOUtils.replaceChars[ch]);
                        } else if (ch < ' ') {
                            write('\\');
                            write('u');
                            write('0');
                            write('0');
                            write(IOUtils.ASCII_CHARS[ch * 2]);
                            write(IOUtils.ASCII_CHARS[(ch * 2) + 1]);
                        } else if (ch >= 127) {
                            write('\\');
                            write('u');
                            write(IOUtils.DIGITS[(ch >>> '\f') & 15]);
                            write(IOUtils.DIGITS[(ch >>> '\b') & 15]);
                            write(IOUtils.DIGITS[(ch >>> 4) & 15]);
                            write(IOUtils.DIGITS[ch & 15]);
                        } else {
                            write(ch);
                        }
                    } else if ((ch < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[ch] != 0) || (ch == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write('\\');
                        if (IOUtils.specicalFlags_doubleQuotes[ch] == 4) {
                            write('u');
                            write(IOUtils.DIGITS[(ch >>> '\f') & 15]);
                            write(IOUtils.DIGITS[(ch >>> '\b') & 15]);
                            write(IOUtils.DIGITS[(ch >>> 4) & 15]);
                            write(IOUtils.DIGITS[ch & 15]);
                        } else {
                            write(IOUtils.replaceChars[ch]);
                        }
                    } else {
                        write(ch);
                    }
                }
                write('\"');
                if (seperator != 0) {
                    write(seperator);
                    return;
                }
                return;
            }
            expandCapacity(newcount);
        }
        int start = this.count + 1;
        int end = start + len;
        this.buf[this.count] = '\"';
        text.getChars(0, len, this.buf, start);
        this.count = newcount;
        if (isEnabled(SerializerFeature.BrowserSecure)) {
            int lastSpecialIndex = -1;
            for (int i2 = start; i2 < end; i2++) {
                char ch2 = this.buf[i2];
                if ((ch2 < '0' || ch2 > '9') && ((ch2 < 'a' || ch2 > 'z') && ((ch2 < 'A' || ch2 > 'Z') && ch2 != ',' && ch2 != '.' && ch2 != '_'))) {
                    lastSpecialIndex = i2;
                    newcount += 5;
                }
            }
            if (newcount > this.buf.length) {
                expandCapacity(newcount);
            }
            this.count = newcount;
            for (int i3 = lastSpecialIndex; i3 >= start; i3--) {
                char ch3 = this.buf[i3];
                if ((ch3 < '0' || ch3 > '9') && ((ch3 < 'a' || ch3 > 'z') && ((ch3 < 'A' || ch3 > 'Z') && ch3 != ',' && ch3 != '.' && ch3 != '_'))) {
                    System.arraycopy(this.buf, i3 + 1, this.buf, i3 + 6, (end - i3) - 1);
                    this.buf[i3] = '\\';
                    this.buf[i3 + 1] = 'u';
                    this.buf[i3 + 2] = IOUtils.DIGITS[(ch3 >>> '\f') & 15];
                    this.buf[i3 + 3] = IOUtils.DIGITS[(ch3 >>> '\b') & 15];
                    this.buf[i3 + 4] = IOUtils.DIGITS[(ch3 >>> 4) & 15];
                    this.buf[i3 + 5] = IOUtils.DIGITS[ch3 & 15];
                    end += 5;
                }
            }
            if (seperator != 0) {
                this.buf[this.count - 2] = '\"';
                this.buf[this.count - 1] = seperator;
                return;
            } else {
                this.buf[this.count - 1] = '\"';
                return;
            }
        }
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            int lastSpecialIndex2 = -1;
            for (int i4 = start; i4 < end; i4++) {
                char ch4 = this.buf[i4];
                if (ch4 == '\"' || ch4 == '/' || ch4 == '\\') {
                    lastSpecialIndex2 = i4;
                    newcount++;
                } else if (ch4 == '\b' || ch4 == '\f' || ch4 == '\n' || ch4 == '\r' || ch4 == '\t') {
                    lastSpecialIndex2 = i4;
                    newcount++;
                } else if (ch4 < ' ') {
                    lastSpecialIndex2 = i4;
                    newcount += 5;
                } else if (ch4 >= 127) {
                    lastSpecialIndex2 = i4;
                    newcount += 5;
                }
            }
            if (newcount > this.buf.length) {
                expandCapacity(newcount);
            }
            this.count = newcount;
            for (int i5 = lastSpecialIndex2; i5 >= start; i5--) {
                char ch5 = this.buf[i5];
                if (ch5 == '\b' || ch5 == '\f' || ch5 == '\n' || ch5 == '\r' || ch5 == '\t') {
                    System.arraycopy(this.buf, i5 + 1, this.buf, i5 + 2, (end - i5) - 1);
                    this.buf[i5] = '\\';
                    this.buf[i5 + 1] = IOUtils.replaceChars[ch5];
                    end++;
                } else if (ch5 == '\"' || ch5 == '/' || ch5 == '\\') {
                    System.arraycopy(this.buf, i5 + 1, this.buf, i5 + 2, (end - i5) - 1);
                    this.buf[i5] = '\\';
                    this.buf[i5 + 1] = ch5;
                    end++;
                } else if (ch5 < ' ') {
                    System.arraycopy(this.buf, i5 + 1, this.buf, i5 + 6, (end - i5) - 1);
                    this.buf[i5] = '\\';
                    this.buf[i5 + 1] = 'u';
                    this.buf[i5 + 2] = '0';
                    this.buf[i5 + 3] = '0';
                    this.buf[i5 + 4] = IOUtils.ASCII_CHARS[ch5 * 2];
                    this.buf[i5 + 5] = IOUtils.ASCII_CHARS[(ch5 * 2) + 1];
                    end += 5;
                } else if (ch5 >= 127) {
                    System.arraycopy(this.buf, i5 + 1, this.buf, i5 + 6, (end - i5) - 1);
                    this.buf[i5] = '\\';
                    this.buf[i5 + 1] = 'u';
                    this.buf[i5 + 2] = IOUtils.DIGITS[(ch5 >>> '\f') & 15];
                    this.buf[i5 + 3] = IOUtils.DIGITS[(ch5 >>> '\b') & 15];
                    this.buf[i5 + 4] = IOUtils.DIGITS[(ch5 >>> 4) & 15];
                    this.buf[i5 + 5] = IOUtils.DIGITS[ch5 & 15];
                    end += 5;
                }
            }
            if (seperator != 0) {
                this.buf[this.count - 2] = '\"';
                this.buf[this.count - 1] = seperator;
                return;
            } else {
                this.buf[this.count - 1] = '\"';
                return;
            }
        }
        int specialCount = 0;
        int lastSpecialIndex3 = -1;
        int firstSpecialIndex = -1;
        char lastSpecial = 0;
        if (checkSpecial) {
            for (int i6 = start; i6 < end; i6++) {
                char ch6 = this.buf[i6];
                if (ch6 == 8232) {
                    specialCount++;
                    lastSpecialIndex3 = i6;
                    lastSpecial = ch6;
                    newcount += 4;
                    if (firstSpecialIndex == -1) {
                        firstSpecialIndex = i6;
                    }
                } else if (ch6 >= ']') {
                    if (ch6 >= 127 && ch6 <= 160) {
                        if (firstSpecialIndex == -1) {
                            firstSpecialIndex = i6;
                        }
                        specialCount++;
                        lastSpecialIndex3 = i6;
                        lastSpecial = ch6;
                        newcount += 4;
                    }
                } else if (isSpecial(ch6, this.features)) {
                    specialCount++;
                    lastSpecialIndex3 = i6;
                    lastSpecial = ch6;
                    if (ch6 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[ch6] == 4) {
                        newcount += 4;
                    }
                    if (firstSpecialIndex == -1) {
                        firstSpecialIndex = i6;
                    }
                }
            }
            if (specialCount > 0) {
                int newcount2 = newcount + specialCount;
                if (newcount2 > this.buf.length) {
                    expandCapacity(newcount2);
                }
                this.count = newcount2;
                if (specialCount == 1) {
                    if (lastSpecial == 8232) {
                        int srcPos = lastSpecialIndex3 + 1;
                        int destPos = lastSpecialIndex3 + 6;
                        int LengthOfCopy = (end - lastSpecialIndex3) - 1;
                        System.arraycopy(this.buf, srcPos, this.buf, destPos, LengthOfCopy);
                        this.buf[lastSpecialIndex3] = '\\';
                        int lastSpecialIndex4 = lastSpecialIndex3 + 1;
                        this.buf[lastSpecialIndex4] = 'u';
                        int lastSpecialIndex5 = lastSpecialIndex4 + 1;
                        this.buf[lastSpecialIndex5] = '2';
                        int lastSpecialIndex6 = lastSpecialIndex5 + 1;
                        this.buf[lastSpecialIndex6] = '0';
                        int lastSpecialIndex7 = lastSpecialIndex6 + 1;
                        this.buf[lastSpecialIndex7] = '2';
                        this.buf[lastSpecialIndex7 + 1] = '8';
                    } else {
                        char ch7 = lastSpecial;
                        if (ch7 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[ch7] == 4) {
                            int srcPos2 = lastSpecialIndex3 + 1;
                            int destPos2 = lastSpecialIndex3 + 6;
                            int LengthOfCopy2 = (end - lastSpecialIndex3) - 1;
                            System.arraycopy(this.buf, srcPos2, this.buf, destPos2, LengthOfCopy2);
                            int bufIndex = lastSpecialIndex3;
                            int bufIndex2 = bufIndex + 1;
                            this.buf[bufIndex] = '\\';
                            int bufIndex3 = bufIndex2 + 1;
                            this.buf[bufIndex2] = 'u';
                            int bufIndex4 = bufIndex3 + 1;
                            this.buf[bufIndex3] = IOUtils.DIGITS[(ch7 >>> '\f') & 15];
                            int bufIndex5 = bufIndex4 + 1;
                            this.buf[bufIndex4] = IOUtils.DIGITS[(ch7 >>> '\b') & 15];
                            int bufIndex6 = bufIndex5 + 1;
                            this.buf[bufIndex5] = IOUtils.DIGITS[(ch7 >>> 4) & 15];
                            int i7 = bufIndex6 + 1;
                            this.buf[bufIndex6] = IOUtils.DIGITS[ch7 & 15];
                        } else {
                            int srcPos3 = lastSpecialIndex3 + 1;
                            int destPos3 = lastSpecialIndex3 + 2;
                            int LengthOfCopy3 = (end - lastSpecialIndex3) - 1;
                            System.arraycopy(this.buf, srcPos3, this.buf, destPos3, LengthOfCopy3);
                            this.buf[lastSpecialIndex3] = '\\';
                            this.buf[lastSpecialIndex3 + 1] = IOUtils.replaceChars[ch7];
                        }
                    }
                } else if (specialCount > 1) {
                    int textIndex = firstSpecialIndex - start;
                    int bufIndex7 = firstSpecialIndex;
                    for (int i8 = textIndex; i8 < text.length(); i8++) {
                        char ch8 = text.charAt(i8);
                        if ((ch8 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[ch8] != 0) || (ch8 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            int bufIndex8 = bufIndex7 + 1;
                            this.buf[bufIndex7] = '\\';
                            if (IOUtils.specicalFlags_doubleQuotes[ch8] == 4) {
                                int bufIndex9 = bufIndex8 + 1;
                                this.buf[bufIndex8] = 'u';
                                int bufIndex10 = bufIndex9 + 1;
                                this.buf[bufIndex9] = IOUtils.DIGITS[(ch8 >>> '\f') & 15];
                                int bufIndex11 = bufIndex10 + 1;
                                this.buf[bufIndex10] = IOUtils.DIGITS[(ch8 >>> '\b') & 15];
                                int bufIndex12 = bufIndex11 + 1;
                                this.buf[bufIndex11] = IOUtils.DIGITS[(ch8 >>> 4) & 15];
                                bufIndex7 = bufIndex12 + 1;
                                this.buf[bufIndex12] = IOUtils.DIGITS[ch8 & 15];
                                end += 5;
                            } else {
                                bufIndex7 = bufIndex8 + 1;
                                this.buf[bufIndex8] = IOUtils.replaceChars[ch8];
                                end++;
                            }
                        } else if (ch8 == 8232) {
                            int bufIndex13 = bufIndex7 + 1;
                            this.buf[bufIndex7] = '\\';
                            int bufIndex14 = bufIndex13 + 1;
                            this.buf[bufIndex13] = 'u';
                            int bufIndex15 = bufIndex14 + 1;
                            this.buf[bufIndex14] = IOUtils.DIGITS[(ch8 >>> '\f') & 15];
                            int bufIndex16 = bufIndex15 + 1;
                            this.buf[bufIndex15] = IOUtils.DIGITS[(ch8 >>> '\b') & 15];
                            int bufIndex17 = bufIndex16 + 1;
                            this.buf[bufIndex16] = IOUtils.DIGITS[(ch8 >>> 4) & 15];
                            bufIndex7 = bufIndex17 + 1;
                            this.buf[bufIndex17] = IOUtils.DIGITS[ch8 & 15];
                            end += 5;
                        } else {
                            this.buf[bufIndex7] = ch8;
                            bufIndex7++;
                        }
                    }
                }
            }
        }
        if (seperator != 0) {
            this.buf[this.count - 2] = '\"';
            this.buf[this.count - 1] = seperator;
        } else {
            this.buf[this.count - 1] = '\"';
        }
    }

    public void writeFieldNull(char seperator, String name) {
        write(seperator);
        writeFieldName(name);
        writeNull();
    }

    public void writeFieldEmptyList(char seperator, String key) {
        write(seperator);
        writeFieldName(key);
        write("[]");
    }

    public void writeFieldNullString(char seperator, String name) {
        write(seperator);
        writeFieldName(name);
        if (isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
            writeString(FinalChip.BSP_PLATFORM_Null);
        } else {
            writeNull();
        }
    }

    public void writeFieldNullBoolean(char seperator, String name) {
        write(seperator);
        writeFieldName(name);
        if (isEnabled(SerializerFeature.WriteNullBooleanAsFalse)) {
            write("false");
        } else {
            writeNull();
        }
    }

    public void writeFieldNullList(char seperator, String name) {
        write(seperator);
        writeFieldName(name);
        if (isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
            write("[]");
        } else {
            writeNull();
        }
    }

    public void writeFieldNullNumber(char seperator, String name) {
        write(seperator);
        writeFieldName(name);
        if (isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
            write('0');
        } else {
            writeNull();
        }
    }

    public void writeFieldValue(char seperator, String name, char value) {
        write(seperator);
        writeFieldName(name);
        if (value == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(value));
        }
    }

    public void writeFieldValue(char seperator, String name, boolean value) {
        char keySeperator = isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
        int intSize = value ? 4 : 5;
        int nameLen = name.length();
        int newcount = this.count + nameLen + 4 + intSize;
        if (newcount > this.buf.length) {
            if (this.writer != null) {
                write(seperator);
                writeString(name);
                write(':');
                write(value);
                return;
            }
            expandCapacity(newcount);
        }
        int start = this.count;
        this.count = newcount;
        this.buf[start] = seperator;
        int nameEnd = start + nameLen + 1;
        this.buf[start + 1] = keySeperator;
        name.getChars(0, nameLen, this.buf, start + 2);
        this.buf[nameEnd + 1] = keySeperator;
        if (value) {
            System.arraycopy(":true".toCharArray(), 0, this.buf, nameEnd + 2, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.buf, nameEnd + 2, 6);
        }
    }

    public void write(boolean value) {
        if (value) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char seperator, String name, int value) {
        if (value == Integer.MIN_VALUE || !isEnabled(SerializerFeature.QuoteFieldNames)) {
            writeFieldValue1(seperator, name, value);
            return;
        }
        char keySeperator = isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
        int intSize = value < 0 ? IOUtils.stringSize(-value) + 1 : IOUtils.stringSize(value);
        int nameLen = name.length();
        int newcount = this.count + nameLen + 4 + intSize;
        if (newcount > this.buf.length) {
            if (this.writer != null) {
                writeFieldValue1(seperator, name, value);
                return;
            }
            expandCapacity(newcount);
        }
        int start = this.count;
        this.count = newcount;
        this.buf[start] = seperator;
        int nameEnd = start + nameLen + 1;
        this.buf[start + 1] = keySeperator;
        name.getChars(0, nameLen, this.buf, start + 2);
        this.buf[nameEnd + 1] = keySeperator;
        this.buf[nameEnd + 2] = ':';
        IOUtils.getChars(value, this.count, this.buf);
    }

    public void writeFieldValue1(char seperator, String name, int value) {
        write(seperator);
        writeFieldName(name);
        writeInt(value);
    }

    public void writeFieldValue(char seperator, String name, long value) {
        if (value == Long.MIN_VALUE || !isEnabled(SerializerFeature.QuoteFieldNames)) {
            writeFieldValue1(seperator, name, value);
            return;
        }
        char keySeperator = isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
        int intSize = value < 0 ? IOUtils.stringSize(-value) + 1 : IOUtils.stringSize(value);
        int nameLen = name.length();
        int newcount = this.count + nameLen + 4 + intSize;
        if (newcount > this.buf.length) {
            if (this.writer != null) {
                write(seperator);
                writeFieldName(name);
                writeLong(value);
                return;
            }
            expandCapacity(newcount);
        }
        int start = this.count;
        this.count = newcount;
        this.buf[start] = seperator;
        int nameEnd = start + nameLen + 1;
        this.buf[start + 1] = keySeperator;
        name.getChars(0, nameLen, this.buf, start + 2);
        this.buf[nameEnd + 1] = keySeperator;
        this.buf[nameEnd + 2] = ':';
        IOUtils.getChars(value, this.count, this.buf);
    }

    public void writeFieldValue1(char seperator, String name, long value) {
        write(seperator);
        writeFieldName(name);
        writeLong(value);
    }

    public void writeFieldValue(char seperator, String name, float value) {
        write(seperator);
        writeFieldName(name);
        if (value == 0.0f) {
            write('0');
            return;
        }
        if (Float.isNaN(value)) {
            writeNull();
            return;
        }
        if (Float.isInfinite(value)) {
            writeNull();
            return;
        }
        String text = Float.toString(value);
        if (text.endsWith(".0")) {
            text = text.substring(0, text.length() - 2);
        }
        write(text);
    }

    public void writeFieldValue(char seperator, String name, double value) {
        write(seperator);
        writeFieldName(name);
        if (value == 0.0d) {
            write('0');
            return;
        }
        if (Double.isNaN(value)) {
            writeNull();
            return;
        }
        if (Double.isInfinite(value)) {
            writeNull();
            return;
        }
        String text = Double.toString(value);
        if (text.endsWith(".0")) {
            text = text.substring(0, text.length() - 2);
        }
        write(text);
    }

    public void writeFieldValue(char seperator, String name, String value) {
        if (isEnabled(SerializerFeature.QuoteFieldNames)) {
            if (isEnabled(SerializerFeature.UseSingleQuotes)) {
                write(seperator);
                writeFieldName(name);
                if (value == null) {
                    writeNull();
                    return;
                } else {
                    writeString(value);
                    return;
                }
            }
            if (isEnabled(SerializerFeature.BrowserSecure)) {
                write(seperator);
                writeStringWithDoubleQuote(name, ':');
                writeStringWithDoubleQuote(value, (char) 0);
                return;
            } else {
                if (isEnabled(SerializerFeature.BrowserCompatible)) {
                    write(seperator);
                    writeStringWithDoubleQuote(name, ':');
                    writeStringWithDoubleQuote(value, (char) 0);
                    return;
                }
                writeFieldValueStringWithDoubleQuote(seperator, name, value, true);
                return;
            }
        }
        write(seperator);
        writeFieldName(name);
        if (value == null) {
            writeNull();
        } else {
            writeString(value);
        }
    }

    private void writeFieldValueStringWithDoubleQuote(char seperator, String name, String value, boolean checkSpecial) {
        int valueLen;
        int newcount;
        int nameLen = name.length();
        int newcount2 = this.count;
        if (value == null) {
            valueLen = 4;
            newcount = newcount2 + nameLen + 8;
        } else {
            valueLen = value.length();
            newcount = newcount2 + nameLen + valueLen + 6;
        }
        if (newcount > this.buf.length) {
            if (this.writer != null) {
                write(seperator);
                writeStringWithDoubleQuote(name, ':', checkSpecial);
                writeStringWithDoubleQuote(value, (char) 0, checkSpecial);
                return;
            }
            expandCapacity(newcount);
        }
        this.buf[this.count] = seperator;
        int nameStart = this.count + 2;
        int nameEnd = nameStart + nameLen;
        this.buf[this.count + 1] = '\"';
        name.getChars(0, nameLen, this.buf, nameStart);
        this.count = newcount;
        this.buf[nameEnd] = '\"';
        int index = nameEnd + 1;
        int index2 = index + 1;
        this.buf[index] = ':';
        if (value == null) {
            int index3 = index2 + 1;
            this.buf[index2] = 'n';
            int index4 = index3 + 1;
            this.buf[index3] = 'u';
            int index5 = index4 + 1;
            this.buf[index4] = 'l';
            int i = index5 + 1;
            this.buf[index5] = 'l';
            return;
        }
        int index6 = index2 + 1;
        this.buf[index2] = '\"';
        int valueEnd = index6 + valueLen;
        value.getChars(0, valueLen, this.buf, index6);
        if (checkSpecial && !isEnabled(SerializerFeature.DisableCheckSpecialChar)) {
            int specialCount = 0;
            int lastSpecialIndex = -1;
            int firstSpecialIndex = -1;
            char lastSpecial = 0;
            for (int i2 = index6; i2 < valueEnd; i2++) {
                char ch = this.buf[i2];
                if (ch == 8232) {
                    specialCount++;
                    lastSpecialIndex = i2;
                    lastSpecial = ch;
                    newcount += 4;
                    if (firstSpecialIndex == -1) {
                        firstSpecialIndex = i2;
                    }
                } else if (ch >= ']') {
                    if (ch >= 127 && ch <= 160) {
                        if (firstSpecialIndex == -1) {
                            firstSpecialIndex = i2;
                        }
                        specialCount++;
                        lastSpecialIndex = i2;
                        lastSpecial = ch;
                        newcount += 4;
                    }
                } else if (isSpecial(ch, this.features)) {
                    specialCount++;
                    lastSpecialIndex = i2;
                    lastSpecial = ch;
                    if (ch < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[ch] == 4) {
                        newcount += 4;
                    }
                    if (firstSpecialIndex == -1) {
                        firstSpecialIndex = i2;
                    }
                }
            }
            if (specialCount > 0) {
                int newcount3 = newcount + specialCount;
                if (newcount3 > this.buf.length) {
                    expandCapacity(newcount3);
                }
                this.count = newcount3;
                if (specialCount == 1) {
                    if (lastSpecial == 8232) {
                        int srcPos = lastSpecialIndex + 1;
                        int destPos = lastSpecialIndex + 6;
                        int LengthOfCopy = (valueEnd - lastSpecialIndex) - 1;
                        System.arraycopy(this.buf, srcPos, this.buf, destPos, LengthOfCopy);
                        this.buf[lastSpecialIndex] = '\\';
                        int lastSpecialIndex2 = lastSpecialIndex + 1;
                        this.buf[lastSpecialIndex2] = 'u';
                        int lastSpecialIndex3 = lastSpecialIndex2 + 1;
                        this.buf[lastSpecialIndex3] = '2';
                        int lastSpecialIndex4 = lastSpecialIndex3 + 1;
                        this.buf[lastSpecialIndex4] = '0';
                        int lastSpecialIndex5 = lastSpecialIndex4 + 1;
                        this.buf[lastSpecialIndex5] = '2';
                        this.buf[lastSpecialIndex5 + 1] = '8';
                    } else {
                        char ch2 = lastSpecial;
                        if (ch2 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[ch2] == 4) {
                            int srcPos2 = lastSpecialIndex + 1;
                            int destPos2 = lastSpecialIndex + 6;
                            int LengthOfCopy2 = (valueEnd - lastSpecialIndex) - 1;
                            System.arraycopy(this.buf, srcPos2, this.buf, destPos2, LengthOfCopy2);
                            int bufIndex = lastSpecialIndex;
                            int bufIndex2 = bufIndex + 1;
                            this.buf[bufIndex] = '\\';
                            int bufIndex3 = bufIndex2 + 1;
                            this.buf[bufIndex2] = 'u';
                            int bufIndex4 = bufIndex3 + 1;
                            this.buf[bufIndex3] = IOUtils.DIGITS[(ch2 >>> '\f') & 15];
                            int bufIndex5 = bufIndex4 + 1;
                            this.buf[bufIndex4] = IOUtils.DIGITS[(ch2 >>> '\b') & 15];
                            int bufIndex6 = bufIndex5 + 1;
                            this.buf[bufIndex5] = IOUtils.DIGITS[(ch2 >>> 4) & 15];
                            int i3 = bufIndex6 + 1;
                            this.buf[bufIndex6] = IOUtils.DIGITS[ch2 & 15];
                        } else {
                            int srcPos3 = lastSpecialIndex + 1;
                            int destPos3 = lastSpecialIndex + 2;
                            int LengthOfCopy3 = (valueEnd - lastSpecialIndex) - 1;
                            System.arraycopy(this.buf, srcPos3, this.buf, destPos3, LengthOfCopy3);
                            this.buf[lastSpecialIndex] = '\\';
                            this.buf[lastSpecialIndex + 1] = IOUtils.replaceChars[ch2];
                        }
                    }
                } else if (specialCount > 1) {
                    int textIndex = firstSpecialIndex - index6;
                    int bufIndex7 = firstSpecialIndex;
                    for (int i4 = textIndex; i4 < value.length(); i4++) {
                        char ch3 = value.charAt(i4);
                        if ((ch3 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[ch3] != 0) || (ch3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            int bufIndex8 = bufIndex7 + 1;
                            this.buf[bufIndex7] = '\\';
                            if (IOUtils.specicalFlags_doubleQuotes[ch3] == 4) {
                                int bufIndex9 = bufIndex8 + 1;
                                this.buf[bufIndex8] = 'u';
                                int bufIndex10 = bufIndex9 + 1;
                                this.buf[bufIndex9] = IOUtils.DIGITS[(ch3 >>> '\f') & 15];
                                int bufIndex11 = bufIndex10 + 1;
                                this.buf[bufIndex10] = IOUtils.DIGITS[(ch3 >>> '\b') & 15];
                                int bufIndex12 = bufIndex11 + 1;
                                this.buf[bufIndex11] = IOUtils.DIGITS[(ch3 >>> 4) & 15];
                                bufIndex7 = bufIndex12 + 1;
                                this.buf[bufIndex12] = IOUtils.DIGITS[ch3 & 15];
                                valueEnd += 5;
                            } else {
                                bufIndex7 = bufIndex8 + 1;
                                this.buf[bufIndex8] = IOUtils.replaceChars[ch3];
                                valueEnd++;
                            }
                        } else if (ch3 == 8232) {
                            int bufIndex13 = bufIndex7 + 1;
                            this.buf[bufIndex7] = '\\';
                            int bufIndex14 = bufIndex13 + 1;
                            this.buf[bufIndex13] = 'u';
                            int bufIndex15 = bufIndex14 + 1;
                            this.buf[bufIndex14] = IOUtils.DIGITS[(ch3 >>> '\f') & 15];
                            int bufIndex16 = bufIndex15 + 1;
                            this.buf[bufIndex15] = IOUtils.DIGITS[(ch3 >>> '\b') & 15];
                            int bufIndex17 = bufIndex16 + 1;
                            this.buf[bufIndex16] = IOUtils.DIGITS[(ch3 >>> 4) & 15];
                            bufIndex7 = bufIndex17 + 1;
                            this.buf[bufIndex17] = IOUtils.DIGITS[ch3 & 15];
                            valueEnd += 5;
                        } else {
                            this.buf[bufIndex7] = ch3;
                            bufIndex7++;
                        }
                    }
                }
            }
        }
        this.buf[this.count - 1] = '\"';
    }

    static boolean isSpecial(char ch, int features) {
        if (ch == ' ') {
            return false;
        }
        if (ch == '/' && SerializerFeature.isEnabled(features, SerializerFeature.WriteSlashAsSpecial)) {
            return true;
        }
        if (ch <= '#' || ch == '\\') {
            return ch <= 31 || ch == '\\' || ch == '\"';
        }
        return false;
    }

    public void writeFieldValue(char seperator, String name, Enum<?> value) {
        if (value == null) {
            write(seperator);
            writeFieldName(name);
            writeNull();
        } else if (isEnabled(SerializerFeature.WriteEnumUsingName)) {
            writeEnumFieldValue(seperator, name, value.name());
        } else if (isEnabled(SerializerFeature.WriteEnumUsingToString)) {
            writeEnumFieldValue(seperator, name, value.toString());
        } else {
            writeFieldValue(seperator, name, value.ordinal());
        }
    }

    private void writeEnumFieldValue(char seperator, String name, String value) {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            writeFieldValue(seperator, name, value);
        } else {
            writeFieldValueStringWithDoubleQuote(seperator, name, value, false);
        }
    }

    public void writeFieldValue(char seperator, String name, BigDecimal value) {
        write(seperator);
        writeFieldName(name);
        if (value == null) {
            writeNull();
        } else {
            write(value.toString());
        }
    }

    public void writeString(String text, char seperator) {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            writeStringWithSingleQuote(text);
            write(seperator);
        } else {
            writeStringWithDoubleQuote(text, seperator);
        }
    }

    public void writeString(String text) {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            writeStringWithSingleQuote(text);
        } else {
            writeStringWithDoubleQuote(text, (char) 0);
        }
    }

    private void writeStringWithSingleQuote(String text) {
        if (text == null) {
            int newcount = this.count + 4;
            if (newcount > this.buf.length) {
                expandCapacity(newcount);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = newcount;
            return;
        }
        int len = text.length();
        int newcount2 = this.count + len + 2;
        if (newcount2 > this.buf.length) {
            if (this.writer != null) {
                write('\'');
                for (int i = 0; i < text.length(); i++) {
                    char ch = text.charAt(i);
                    if (ch <= '\r' || ch == '\\' || ch == '\'' || (ch == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write('\\');
                        write(IOUtils.replaceChars[ch]);
                    } else {
                        write(ch);
                    }
                }
                write('\'');
                return;
            }
            expandCapacity(newcount2);
        }
        int start = this.count + 1;
        int end = start + len;
        this.buf[this.count] = '\'';
        text.getChars(0, len, this.buf, start);
        this.count = newcount2;
        int specialCount = 0;
        int lastSpecialIndex = -1;
        char lastSpecial = 0;
        for (int i2 = start; i2 < end; i2++) {
            char ch2 = this.buf[i2];
            if (ch2 <= '\r' || ch2 == '\\' || ch2 == '\'' || (ch2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                specialCount++;
                lastSpecialIndex = i2;
                lastSpecial = ch2;
            }
        }
        int newcount3 = newcount2 + specialCount;
        if (newcount3 > this.buf.length) {
            expandCapacity(newcount3);
        }
        this.count = newcount3;
        if (specialCount == 1) {
            System.arraycopy(this.buf, lastSpecialIndex + 1, this.buf, lastSpecialIndex + 2, (end - lastSpecialIndex) - 1);
            this.buf[lastSpecialIndex] = '\\';
            this.buf[lastSpecialIndex + 1] = IOUtils.replaceChars[lastSpecial];
        } else if (specialCount > 1) {
            System.arraycopy(this.buf, lastSpecialIndex + 1, this.buf, lastSpecialIndex + 2, (end - lastSpecialIndex) - 1);
            this.buf[lastSpecialIndex] = '\\';
            int lastSpecialIndex2 = lastSpecialIndex + 1;
            this.buf[lastSpecialIndex2] = IOUtils.replaceChars[lastSpecial];
            int end2 = end + 1;
            for (int i3 = lastSpecialIndex2 - 2; i3 >= start; i3--) {
                char ch3 = this.buf[i3];
                if (ch3 <= '\r' || ch3 == '\\' || ch3 == '\'' || (ch3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    System.arraycopy(this.buf, i3 + 1, this.buf, i3 + 2, (end2 - i3) - 1);
                    this.buf[i3] = '\\';
                    this.buf[i3 + 1] = IOUtils.replaceChars[ch3];
                    end2++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldName(String key) {
        writeFieldName(key, false);
    }

    public void writeFieldName(String key, boolean checkSpecial) {
        if (key == null) {
            write("null:");
            return;
        }
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            if (isEnabled(SerializerFeature.QuoteFieldNames)) {
                writeStringWithSingleQuote(key);
                write(':');
                return;
            } else {
                writeKeyWithSingleQuoteIfHasSpecial(key);
                return;
            }
        }
        if (isEnabled(SerializerFeature.QuoteFieldNames)) {
            writeStringWithDoubleQuote(key, ':', checkSpecial);
        } else {
            writeKeyWithDoubleQuoteIfHasSpecial(key);
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String text) {
        byte[] specicalFlags_doubleQuotes = IOUtils.specicalFlags_doubleQuotes;
        int len = text.length();
        int newcount = this.count + len + 1;
        if (newcount > this.buf.length) {
            if (this.writer != null) {
                if (len == 0) {
                    write('\"');
                    write('\"');
                    write(':');
                    return;
                }
                boolean hasSpecial = false;
                for (int i = 0; i < len; i++) {
                    char ch = text.charAt(i);
                    if (ch < specicalFlags_doubleQuotes.length && specicalFlags_doubleQuotes[ch] != 0) {
                        hasSpecial = true;
                        break;
                    }
                }
                if (hasSpecial) {
                    write('\"');
                }
                for (int i2 = 0; i2 < len; i2++) {
                    char ch2 = text.charAt(i2);
                    if (ch2 < specicalFlags_doubleQuotes.length && specicalFlags_doubleQuotes[ch2] != 0) {
                        write('\\');
                        write(IOUtils.replaceChars[ch2]);
                    } else {
                        write(ch2);
                    }
                }
                if (hasSpecial) {
                    write('\"');
                }
                write(':');
                return;
            }
            expandCapacity(newcount);
        }
        if (len == 0) {
            int newCount = this.count + 3;
            if (newCount > this.buf.length) {
                expandCapacity(this.count + 3);
            }
            char[] cArr = this.buf;
            int i3 = this.count;
            this.count = i3 + 1;
            cArr[i3] = '\"';
            char[] cArr2 = this.buf;
            int i4 = this.count;
            this.count = i4 + 1;
            cArr2[i4] = '\"';
            char[] cArr3 = this.buf;
            int i5 = this.count;
            this.count = i5 + 1;
            cArr3[i5] = ':';
            return;
        }
        int start = this.count;
        int end = start + len;
        text.getChars(0, len, this.buf, start);
        this.count = newcount;
        boolean hasSpecial2 = false;
        int i6 = start;
        while (i6 < end) {
            char ch3 = this.buf[i6];
            if (ch3 < specicalFlags_doubleQuotes.length && specicalFlags_doubleQuotes[ch3] != 0) {
                if (!hasSpecial2) {
                    newcount += 3;
                    if (newcount > this.buf.length) {
                        expandCapacity(newcount);
                    }
                    this.count = newcount;
                    System.arraycopy(this.buf, i6 + 1, this.buf, i6 + 3, (end - i6) - 1);
                    System.arraycopy(this.buf, 0, this.buf, 1, i6);
                    this.buf[start] = '\"';
                    int i7 = i6 + 1;
                    this.buf[i7] = '\\';
                    i6 = i7 + 1;
                    this.buf[i6] = IOUtils.replaceChars[ch3];
                    end += 2;
                    this.buf[this.count - 2] = '\"';
                    hasSpecial2 = true;
                } else {
                    newcount++;
                    if (newcount > this.buf.length) {
                        expandCapacity(newcount);
                    }
                    this.count = newcount;
                    System.arraycopy(this.buf, i6 + 1, this.buf, i6 + 2, end - i6);
                    this.buf[i6] = '\\';
                    i6++;
                    this.buf[i6] = IOUtils.replaceChars[ch3];
                    end++;
                }
            }
            i6++;
        }
        this.buf[this.count - 1] = ':';
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String text) {
        byte[] specicalFlags_singleQuotes = IOUtils.specicalFlags_singleQuotes;
        int len = text.length();
        int newcount = this.count + len + 1;
        if (newcount > this.buf.length) {
            if (this.writer != null) {
                if (len == 0) {
                    write('\'');
                    write('\'');
                    write(':');
                    return;
                }
                boolean hasSpecial = false;
                for (int i = 0; i < len; i++) {
                    char ch = text.charAt(i);
                    if (ch < specicalFlags_singleQuotes.length && specicalFlags_singleQuotes[ch] != 0) {
                        hasSpecial = true;
                        break;
                    }
                }
                if (hasSpecial) {
                    write('\'');
                }
                for (int i2 = 0; i2 < len; i2++) {
                    char ch2 = text.charAt(i2);
                    if (ch2 < specicalFlags_singleQuotes.length && specicalFlags_singleQuotes[ch2] != 0) {
                        write('\\');
                        write(IOUtils.replaceChars[ch2]);
                    } else {
                        write(ch2);
                    }
                }
                if (hasSpecial) {
                    write('\'');
                }
                write(':');
                return;
            }
            expandCapacity(newcount);
        }
        if (len == 0) {
            int newCount = this.count + 3;
            if (newCount > this.buf.length) {
                expandCapacity(this.count + 3);
            }
            char[] cArr = this.buf;
            int i3 = this.count;
            this.count = i3 + 1;
            cArr[i3] = '\'';
            char[] cArr2 = this.buf;
            int i4 = this.count;
            this.count = i4 + 1;
            cArr2[i4] = '\'';
            char[] cArr3 = this.buf;
            int i5 = this.count;
            this.count = i5 + 1;
            cArr3[i5] = ':';
            return;
        }
        int start = this.count;
        int end = start + len;
        text.getChars(0, len, this.buf, start);
        this.count = newcount;
        boolean hasSpecial2 = false;
        int i6 = start;
        while (i6 < end) {
            char ch3 = this.buf[i6];
            if (ch3 < specicalFlags_singleQuotes.length && specicalFlags_singleQuotes[ch3] != 0) {
                if (!hasSpecial2) {
                    newcount += 3;
                    if (newcount > this.buf.length) {
                        expandCapacity(newcount);
                    }
                    this.count = newcount;
                    System.arraycopy(this.buf, i6 + 1, this.buf, i6 + 3, (end - i6) - 1);
                    System.arraycopy(this.buf, 0, this.buf, 1, i6);
                    this.buf[start] = '\'';
                    int i7 = i6 + 1;
                    this.buf[i7] = '\\';
                    i6 = i7 + 1;
                    this.buf[i6] = IOUtils.replaceChars[ch3];
                    end += 2;
                    this.buf[this.count - 2] = '\'';
                    hasSpecial2 = true;
                } else {
                    newcount++;
                    if (newcount > this.buf.length) {
                        expandCapacity(newcount);
                    }
                    this.count = newcount;
                    System.arraycopy(this.buf, i6 + 1, this.buf, i6 + 2, end - i6);
                    this.buf[i6] = '\\';
                    i6++;
                    this.buf[i6] = IOUtils.replaceChars[ch3];
                    end++;
                }
            }
            i6++;
        }
        this.buf[newcount - 1] = ':';
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        if (this.writer != null) {
            try {
                this.writer.write(this.buf, 0, this.count);
                this.writer.flush();
                this.count = 0;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
    }
}
