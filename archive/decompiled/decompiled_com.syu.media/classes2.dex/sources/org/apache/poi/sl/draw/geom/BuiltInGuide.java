package org.apache.poi.sl.draw.geom;

import java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
enum BuiltInGuide implements Formula {
    _3cd4,
    _3cd8,
    _5cd8,
    _7cd8,
    _b,
    _cd2,
    _cd4,
    _cd8,
    _hc,
    _h,
    _hd2,
    _hd3,
    _hd4,
    _hd5,
    _hd6,
    _hd8,
    _l,
    _ls,
    _r,
    _ss,
    _ssd2,
    _ssd4,
    _ssd6,
    _ssd8,
    _ssd16,
    _ssd32,
    _t,
    _vc,
    _w,
    _wd2,
    _wd3,
    _wd4,
    _wd5,
    _wd6,
    _wd8,
    _wd10,
    _wd32;

    public String getName() {
        return name().substring(1);
    }

    @Override // org.apache.poi.sl.draw.geom.Formula
    public double evaluate(Context context) {
        Rectangle2D shapeAnchor = context.getShapeAnchor();
        double height = shapeAnchor.getHeight();
        double width = shapeAnchor.getWidth();
        double dMin = Math.min(width, height);
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[ordinal()]) {
            case 1:
                return 1.62E7d;
            case 2:
                return 8100000.0d;
            case 3:
                return 1.35E7d;
            case 4:
                return 1.89E7d;
            case 5:
                return shapeAnchor.getY();
            case 6:
                return shapeAnchor.getMaxY();
            case 7:
                return shapeAnchor.getX();
            case 8:
                return shapeAnchor.getMaxX();
            case 9:
                return 1.08E7d;
            case 10:
                return 5400000.0d;
            case 11:
                return 2700000.0d;
            case 12:
                return shapeAnchor.getCenterX();
            case 13:
                return height;
            case 14:
                return height / 2.0d;
            case 15:
                return height / 3.0d;
            case 16:
                return height / 4.0d;
            case 17:
                return height / 5.0d;
            case 18:
                return height / 6.0d;
            case 19:
                return height / 8.0d;
            case 20:
                return Math.max(width, height);
            case 21:
                return dMin;
            case 22:
                return dMin / 2.0d;
            case 23:
                return dMin / 4.0d;
            case 24:
                return dMin / 6.0d;
            case 25:
                return dMin / 8.0d;
            case 26:
                return dMin / 16.0d;
            case 27:
                return dMin / 32.0d;
            case 28:
                return shapeAnchor.getCenterY();
            case 29:
                return width;
            case 30:
                return width / 2.0d;
            case 31:
                return width / 3.0d;
            case 32:
                return width / 4.0d;
            case 33:
                return width / 5.0d;
            case 34:
                return width / 6.0d;
            case 35:
                return width / 8.0d;
            case 36:
                return width / 10.0d;
            case 37:
                return width / 32.0d;
            default:
                return 0.0d;
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.geom.BuiltInGuide$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide;

        static {
            int[] iArr = new int[BuiltInGuide.values().length];
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide = iArr;
            try {
                iArr[BuiltInGuide._3cd4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._3cd8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._5cd8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._7cd8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._t.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._b.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._l.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._r.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._cd2.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._cd4.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._cd8.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hc.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._h.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd2.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd3.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd4.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd5.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd6.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd8.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ls.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ss.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd2.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd4.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd6.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd8.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd16.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd32.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._vc.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._w.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd2.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd3.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd4.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd5.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd6.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd8.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd10.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd32.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
        }
    }
}
