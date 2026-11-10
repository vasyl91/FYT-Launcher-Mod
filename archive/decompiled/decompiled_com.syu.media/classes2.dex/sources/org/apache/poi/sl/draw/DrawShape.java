package org.apache.poi.sl.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Locale;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.StrokeStyle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawShape implements Drawable {
    protected final Shape<?, ?> shape;

    private static double safeScale(double d, double d2) {
        if (d == 0.0d || d2 == 0.0d) {
            return 1.0d;
        }
        return d / d2;
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
    }

    public DrawShape(Shape<?, ?> shape) {
        this.shape = shape;
    }

    protected static boolean isHSLF(Shape<?, ?> shape) {
        return shape.getClass().getCanonicalName().toLowerCase(Locale.ROOT).contains("hslf");
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
        Graphics2D graphics2D2;
        boolean z;
        PlaceableShape placeableShape;
        AffineTransform affineTransform;
        Rectangle2D rectangle2D;
        char[] cArr;
        AffineTransform affineTransform2;
        double dSafeScale;
        double dSafeScale2;
        Graphics2D graphics2D3 = graphics2D;
        Shape<?, ?> shape = this.shape;
        if (shape instanceof PlaceableShape) {
            PlaceableShape placeableShape2 = (PlaceableShape) shape;
            boolean zIsHSLF = isHSLF(shape);
            AffineTransform affineTransform3 = (AffineTransform) graphics2D3.getRenderingHint(Drawable.GROUP_TRANSFORM);
            if (affineTransform3 == null) {
                affineTransform3 = new AffineTransform();
            }
            Rectangle2D bounds2D = affineTransform3.createTransformedShape(placeableShape2.getAnchor()).getBounds2D();
            char[] cArr2 = {'r', 'h', 'v'};
            if (zIsHSLF) {
                // fill-array-data instruction
                cArr2[0] = 'h';
                cArr2[1] = 'v';
                cArr2[2] = 'r';
            }
            int length = cArr2.length;
            int i = 0;
            while (i < length) {
                char c = cArr2[i];
                int i2 = i;
                if (c != 'h') {
                    if (c == 'r') {
                        cArr = cArr2;
                        double rotation = placeableShape2.getRotation();
                        if (rotation != 0.0d) {
                            double centerX = bounds2D.getCenterX();
                            double centerY = bounds2D.getCenterY();
                            double d = rotation % 360.0d;
                            if (d < 0.0d) {
                                d += 360.0d;
                            }
                            int i3 = ((((int) d) + 45) / 90) % 4;
                            if (i3 == 1 || i3 == 3) {
                                if (zIsHSLF) {
                                    affineTransform2 = new AffineTransform(affineTransform3);
                                } else {
                                    affineTransform2 = new AffineTransform();
                                    affineTransform2.translate(centerX, centerY);
                                    affineTransform2.rotate(1.5707963267948966d);
                                    affineTransform2.translate(-centerX, -centerY);
                                    affineTransform2.concatenate(affineTransform3);
                                }
                                affineTransform2.translate(centerX, centerY);
                                affineTransform2.rotate(1.5707963267948966d);
                                affineTransform2.translate(-centerX, -centerY);
                                Rectangle2D bounds2D2 = affineTransform2.createTransformedShape(placeableShape2.getAnchor()).getBounds2D();
                                dSafeScale = safeScale(bounds2D.getWidth(), bounds2D2.getWidth());
                                dSafeScale2 = safeScale(bounds2D.getHeight(), bounds2D2.getHeight());
                                graphics2D2 = graphics2D;
                            } else {
                                graphics2D2 = graphics2D3;
                                d = d;
                                dSafeScale2 = 1.0d;
                                dSafeScale = 1.0d;
                                i3 = 0;
                            }
                            graphics2D2.translate(centerX, centerY);
                            affineTransform = affineTransform3;
                            rectangle2D = bounds2D;
                            double d2 = ((double) i3) * 90.0d;
                            double d3 = d - d2;
                            z = zIsHSLF;
                            placeableShape = placeableShape2;
                            double radians = Math.toRadians(d3);
                            if (radians != 0.0d) {
                                graphics2D2.rotate(radians);
                            }
                            graphics2D2.scale(dSafeScale, dSafeScale2);
                            double radians2 = Math.toRadians(d2);
                            if (radians2 != 0.0d) {
                                graphics2D2.rotate(radians2);
                            }
                            graphics2D2.translate(-centerX, -centerY);
                        }
                    } else if (c == 'v') {
                        if (placeableShape2.getFlipVertical()) {
                            cArr = cArr2;
                            graphics2D3.translate(bounds2D.getX(), bounds2D.getY() + bounds2D.getHeight());
                            graphics2D3.scale(1.0d, -1.0d);
                            graphics2D3.translate(-bounds2D.getX(), -bounds2D.getY());
                        } else {
                            cArr = cArr2;
                        }
                    } else {
                        throw new RuntimeException("unexpected transform code " + c);
                    }
                    graphics2D2 = graphics2D3;
                    z = zIsHSLF;
                    placeableShape = placeableShape2;
                    affineTransform = affineTransform3;
                    rectangle2D = bounds2D;
                } else {
                    graphics2D2 = graphics2D3;
                    z = zIsHSLF;
                    placeableShape = placeableShape2;
                    affineTransform = affineTransform3;
                    rectangle2D = bounds2D;
                    cArr = cArr2;
                    if (placeableShape.getFlipHorizontal()) {
                        graphics2D2.translate(rectangle2D.getX() + rectangle2D.getWidth(), rectangle2D.getY());
                        graphics2D2.scale(-1.0d, 1.0d);
                        graphics2D2.translate(-rectangle2D.getX(), -rectangle2D.getY());
                    }
                }
                i = i2 + 1;
                graphics2D3 = graphics2D2;
                affineTransform3 = affineTransform;
                placeableShape2 = placeableShape;
                bounds2D = rectangle2D;
                cArr2 = cArr;
                zIsHSLF = z;
            }
        }
    }

    public static Rectangle2D getAnchor(Graphics2D graphics2D, PlaceableShape<?, ?> placeableShape) {
        return getAnchor(graphics2D, placeableShape.getAnchor());
    }

    public static Rectangle2D getAnchor(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        AffineTransform affineTransform;
        return (graphics2D == null || (affineTransform = (AffineTransform) graphics2D.getRenderingHint(Drawable.GROUP_TRANSFORM)) == null || affineTransform.isIdentity()) ? rectangle2D : affineTransform.createTransformedShape(rectangle2D).getBounds2D();
    }

    protected Shape<?, ?> getShape() {
        return this.shape;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004c A[PHI: r0
  0x004c: PHI (r0v9 int) = (r0v8 int), (r0v10 int) binds: [B:20:0x0045, B:22:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    protected static BasicStroke getStroke(StrokeStyle strokeStyle) {
        float[] fArr;
        int i;
        float lineWidth = (float) strokeStyle.getLineWidth();
        if (lineWidth == 0.0f) {
            lineWidth = 0.25f;
        }
        float f = lineWidth;
        StrokeStyle.LineDash lineDash = strokeStyle.getLineDash();
        if (lineDash == null) {
            lineDash = StrokeStyle.LineDash.SOLID;
        }
        int[] iArr = lineDash.pattern;
        if (iArr != null) {
            float[] fArr2 = new float[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                fArr2[i2] = iArr[i2] * Math.max(1.0f, f);
            }
            fArr = fArr2;
        } else {
            fArr = null;
        }
        StrokeStyle.LineCap lineCap = strokeStyle.getLineCap();
        if (lineCap == null) {
            lineCap = StrokeStyle.LineCap.FLAT;
        }
        int i3 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap[lineCap.ordinal()];
        int i4 = 1;
        if (i3 != 1) {
            i4 = 2;
            if (i3 != 2) {
                i = 0;
            } else {
                i = i4;
            }
        } else {
            i = i4;
        }
        return new BasicStroke(f, i, 1, f, fArr, 0.0f);
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawShape$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap;

        static {
            int[] iArr = new int[StrokeStyle.LineCap.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap = iArr;
            try {
                iArr[StrokeStyle.LineCap.ROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap[StrokeStyle.LineCap.SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap[StrokeStyle.LineCap.FLAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
