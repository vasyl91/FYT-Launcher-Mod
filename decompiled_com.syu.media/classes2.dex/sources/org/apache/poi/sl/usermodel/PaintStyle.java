package org.apache.poi.sl.usermodel;

import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface PaintStyle {

    public interface GradientPaint extends PaintStyle {

        public enum GradientType {
            linear,
            circular,
            shape
        }

        double getGradientAngle();

        ColorStyle[] getGradientColors();

        float[] getGradientFractions();

        GradientType getGradientType();

        boolean isRotatedWithShape();
    }

    public enum PaintModifier {
        NONE,
        NORM,
        LIGHTEN,
        LIGHTEN_LESS,
        DARKEN,
        DARKEN_LESS
    }

    public interface SolidPaint extends PaintStyle {
        ColorStyle getSolidColor();
    }

    public interface TexturePaint extends PaintStyle {
        int getAlpha();

        String getContentType();

        InputStream getImageData();
    }
}
