package org.apache.poi.sl.draw.geom;

import org.apache.poi.sl.draw.binding.CTGeomGuide;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Guide implements Formula {
    private final String fmla;
    private final String name;
    private final Op op;
    private final String[] operands;

    enum Op {
        muldiv,
        addsub,
        adddiv,
        ifelse,
        val,
        abs,
        sqrt,
        max,
        min,
        at2,
        sin,
        cos,
        tan,
        cat2,
        sat2,
        pin,
        mod
    }

    public Guide(CTGeomGuide cTGeomGuide) {
        this(cTGeomGuide.getName(), cTGeomGuide.getFmla());
    }

    public Guide(String str, String str2) {
        this.name = str;
        this.fmla = str2;
        String[] strArrSplit = str2.split("\\s+");
        this.operands = strArrSplit;
        this.op = Op.valueOf(strArrSplit[0].replace("*", "mul").replace("/", "div").replace("+", "add").replace("-", "sub").replace("?:", "ifelse"));
    }

    public String getName() {
        return this.name;
    }

    String getFormula() {
        return this.fmla;
    }

    @Override // org.apache.poi.sl.draw.geom.Formula
    public double evaluate(Context context) {
        String[] strArr = this.operands;
        double value = strArr.length > 1 ? context.getValue(strArr[1]) : 0.0d;
        String[] strArr2 = this.operands;
        double value2 = strArr2.length > 2 ? context.getValue(strArr2[2]) : 0.0d;
        String[] strArr3 = this.operands;
        double value3 = strArr3.length > 3 ? context.getValue(strArr3[3]) : 0.0d;
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[this.op.ordinal()]) {
            case 1:
                return Math.abs(value);
            case 2:
                return (value + value2) / value3;
            case 3:
                return (value + value2) - value3;
            case 4:
                return Math.toDegrees(Math.atan2(value2, value)) * 60000.0d;
            case 5:
                return value * Math.cos(Math.toRadians(value2 / 60000.0d));
            case 6:
                return value * Math.cos(Math.atan2(value3, value2));
            case 7:
                return value > 0.0d ? value2 : value3;
            case 8:
                return value;
            case 9:
                return Math.max(value, value2);
            case 10:
                return Math.min(value, value2);
            case 11:
                return Math.sqrt((value * value) + (value2 * value2) + (value3 * value3));
            case 12:
                return (value * value2) / value3;
            case 13:
                if (value2 < value) {
                    return value;
                }
                return value2 > value3 ? value3 : value2;
            case 14:
                return value * Math.sin(Math.atan2(value3, value2));
            case 15:
                return value * Math.sin(Math.toRadians(value2 / 60000.0d));
            case 16:
                return Math.sqrt(value);
            case 17:
                return value * Math.tan(Math.toRadians(value2 / 60000.0d));
            default:
                return 0.0d;
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.geom.Guide$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op;

        static {
            int[] iArr = new int[Op.values().length];
            $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op = iArr;
            try {
                iArr[Op.abs.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.adddiv.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.addsub.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.at2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.cos.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.cat2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.ifelse.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.val.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.max.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.min.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.mod.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.muldiv.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.pin.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.sat2.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.sin.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.sqrt.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$Guide$Op[Op.tan.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }
}
