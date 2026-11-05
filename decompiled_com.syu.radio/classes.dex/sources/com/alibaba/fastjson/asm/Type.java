package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Type {
    public static final int ARRAY = 9;
    public static final int BOOLEAN = 1;
    public static final int BYTE = 3;
    public static final int CHAR = 2;
    public static final int DOUBLE = 8;
    public static final int FLOAT = 6;
    public static final int INT = 5;
    public static final int LONG = 7;
    public static final int OBJECT = 10;
    public static final int SHORT = 4;
    public static final int VOID = 0;
    private final char[] buf;
    private final int len;
    private final int off;
    private final int sort;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    private Type(int sort, char[] buf, int off, int len) {
        this.sort = sort;
        this.buf = buf;
        this.off = off;
        this.len = len;
    }

    public static Type getType(String typeDescriptor) {
        return getType(typeDescriptor.toCharArray(), 0);
    }

    public static int getArgumentsAndReturnSizes(String desc) {
        int c;
        int i;
        int c2;
        int n = 1;
        int c3 = 1;
        while (true) {
            c = c3 + 1;
            char car = desc.charAt(c3);
            if (car == ')') {
                break;
            }
            if (car == 'L') {
                do {
                    c2 = c;
                    c = c2 + 1;
                } while (desc.charAt(c2) != ';');
                n++;
                c3 = c;
            } else if (car == 'D' || car == 'J') {
                n += 2;
                c3 = c;
            } else {
                n++;
                c3 = c;
            }
        }
        char car2 = desc.charAt(c);
        int i2 = n << 2;
        if (car2 == 'V') {
            i = 0;
        } else {
            i = (car2 == 'D' || car2 == 'J') ? 2 : 1;
        }
        return i | i2;
    }

    private static Type getType(char[] buf, int off) {
        switch (buf[off]) {
            case 'B':
                return BYTE_TYPE;
            case 'C':
                return CHAR_TYPE;
            case 'D':
                return DOUBLE_TYPE;
            case 'F':
                return FLOAT_TYPE;
            case 'I':
                return INT_TYPE;
            case 'J':
                return LONG_TYPE;
            case 'S':
                return SHORT_TYPE;
            case 'V':
                return VOID_TYPE;
            case 'Z':
                return BOOLEAN_TYPE;
            case '[':
                int len = 1;
                while (buf[off + len] == '[') {
                    len++;
                }
                if (buf[off + len] == 'L') {
                    do {
                        len++;
                    } while (buf[off + len] != ';');
                }
                return new Type(9, buf, off, len + 1);
            default:
                int len2 = 1;
                while (buf[off + len2] != ';') {
                    len2++;
                }
                return new Type(10, buf, off + 1, len2 - 1);
        }
    }

    public int getSort() {
        return this.sort;
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }
}
