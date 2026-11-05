package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Drawable {
    public static final int TEXT_AS_CHARACTERS = 1;
    public static final int TEXT_AS_SHAPES = 2;
    public static final DrawableHint DRAW_FACTORY = new DrawableHint(1);

    @Internal
    public static final DrawableHint GROUP_TRANSFORM = new DrawableHint(2);
    public static final DrawableHint IMAGE_RENDERER = new DrawableHint(3);
    public static final DrawableHint TEXT_RENDERING_MODE = new DrawableHint(4);
    public static final DrawableHint GRADIENT_SHAPE = new DrawableHint(5);
    public static final DrawableHint PRESET_GEOMETRY_CACHE = new DrawableHint(6);
    public static final DrawableHint FONT_HANDLER = new DrawableHint(7);
    public static final DrawableHint FONT_FALLBACK = new DrawableHint(8);
    public static final DrawableHint FONT_MAP = new DrawableHint(9);
    public static final DrawableHint GSAVE = new DrawableHint(10);
    public static final DrawableHint GRESTORE = new DrawableHint(11);
    public static final DrawableHint CURRENT_SLIDE = new DrawableHint(12);

    void applyTransform(Graphics2D graphics2D);

    void draw(Graphics2D graphics2D);

    void drawContent(Graphics2D graphics2D);

    public static class DrawableHint extends RenderingHints.Key {
        public boolean isCompatibleValue(Object obj) {
            return true;
        }

        protected DrawableHint(int i) {
            super(i);
        }

        public String toString() {
            switch (intKey()) {
                case 1:
                    return "DRAW_FACTORY";
                case 2:
                    return "GROUP_TRANSFORM";
                case 3:
                    return "IMAGE_RENDERER";
                case 4:
                    return "TEXT_RENDERING_MODE";
                case 5:
                    return "GRADIENT_SHAPE";
                case 6:
                    return "PRESET_GEOMETRY_CACHE";
                case 7:
                    return "FONT_HANDLER";
                case 8:
                    return "FONT_FALLBACK";
                case 9:
                    return "FONT_MAP";
                case 10:
                    return "GSAVE";
                case 11:
                    return "GRESTORE";
                default:
                    return "UNKNOWN_ID " + intKey();
            }
        }
    }
}
