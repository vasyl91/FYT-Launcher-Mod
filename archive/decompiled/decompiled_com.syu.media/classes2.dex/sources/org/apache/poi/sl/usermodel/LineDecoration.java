package org.apache.poi.sl.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface LineDecoration {
    DecorationSize getHeadLength();

    DecorationShape getHeadShape();

    DecorationSize getHeadWidth();

    DecorationSize getTailLength();

    DecorationShape getTailShape();

    DecorationSize getTailWidth();

    public enum DecorationShape {
        NONE(0, 1),
        TRIANGLE(1, 2),
        STEALTH(2, 3),
        DIAMOND(3, 4),
        OVAL(4, 5),
        ARROW(5, 6);

        public final int nativeId;
        public final int ooxmlId;

        DecorationShape(int i, int i2) {
            this.nativeId = i;
            this.ooxmlId = i2;
        }

        public static DecorationShape fromNativeId(int i) {
            for (DecorationShape decorationShape : values()) {
                if (decorationShape.nativeId == i) {
                    return decorationShape;
                }
            }
            return null;
        }

        public static DecorationShape fromOoxmlId(int i) {
            for (DecorationShape decorationShape : values()) {
                if (decorationShape.ooxmlId == i) {
                    return decorationShape;
                }
            }
            return null;
        }
    }

    public enum DecorationSize {
        SMALL(0, 1),
        MEDIUM(1, 2),
        LARGE(2, 3);

        public final int nativeId;
        public final int ooxmlId;

        DecorationSize(int i, int i2) {
            this.nativeId = i;
            this.ooxmlId = i2;
        }

        public static DecorationSize fromNativeId(int i) {
            for (DecorationSize decorationSize : values()) {
                if (decorationSize.nativeId == i) {
                    return decorationSize;
                }
            }
            return null;
        }

        public static DecorationSize fromOoxmlId(int i) {
            for (DecorationSize decorationSize : values()) {
                if (decorationSize.ooxmlId == i) {
                    return decorationSize;
                }
            }
            return null;
        }
    }
}
