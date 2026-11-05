package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum FontUnderline {
    SINGLE(1),
    DOUBLE(2),
    SINGLE_ACCOUNTING(3),
    DOUBLE_ACCOUNTING(4),
    NONE(5);

    private static FontUnderline[] _table = new FontUnderline[6];
    private int value;

    static {
        for (FontUnderline fontUnderline : values()) {
            _table[fontUnderline.getValue()] = fontUnderline;
        }
    }

    FontUnderline(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.FontUnderline$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline;

        static {
            int[] iArr = new int[FontUnderline.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline = iArr;
            try {
                iArr[FontUnderline.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.DOUBLE_ACCOUNTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.SINGLE_ACCOUNTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.SINGLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public byte getByteValue() {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[ordinal()];
        if (i == 1) {
            return (byte) 2;
        }
        if (i == 2) {
            return (byte) 34;
        }
        if (i != 3) {
            return i != 4 ? (byte) 1 : (byte) 0;
        }
        return (byte) 33;
    }

    public static FontUnderline valueOf(int i) {
        return _table[i];
    }

    public static FontUnderline valueOf(byte b) {
        if (b == 1) {
            return SINGLE;
        }
        if (b == 2) {
            return DOUBLE;
        }
        if (b == 33) {
            return SINGLE_ACCOUNTING;
        }
        if (b == 34) {
            return DOUBLE_ACCOUNTING;
        }
        return NONE;
    }
}
