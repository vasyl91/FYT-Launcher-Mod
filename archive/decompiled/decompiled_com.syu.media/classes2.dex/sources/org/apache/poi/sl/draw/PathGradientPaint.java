package org.apache.poi.sl.draw;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.IllegalPathStateException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class PathGradientPaint implements Paint {
    protected final int capStyle;
    protected final Color[] colors;
    protected final float[] fractions;
    protected final int joinStyle;
    protected final int transparency;

    public PathGradientPaint(Color[] colorArr, float[] fArr) {
        this(colorArr, fArr, 1, 1);
    }

    public PathGradientPaint(Color[] colorArr, float[] fArr, int i, int i2) {
        this.colors = (Color[]) colorArr.clone();
        this.fractions = (float[]) fArr.clone();
        this.capStyle = i;
        this.joinStyle = i2;
        boolean z = true;
        for (Color color : colorArr) {
            if (color != null) {
                z = z && color.getAlpha() == 255;
            }
        }
        this.transparency = z ? 1 : 3;
    }

    public PaintContext createContext(ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints) {
        return new PathGradientContext(colorModel, rectangle, rectangle2D, affineTransform, renderingHints);
    }

    public int getTransparency() {
        return this.transparency;
    }

    class PathGradientContext implements PaintContext {
        protected final Rectangle deviceBounds;
        protected final int gradientSteps;
        protected final RenderingHints hints;
        protected final PaintContext pCtx;
        WritableRaster raster;
        protected final Shape shape;
        protected final Rectangle2D userBounds;
        protected final AffineTransform xform;

        public void dispose() {
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.awt.geom.IllegalPathStateException */
        public PathGradientContext(ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints) throws IllegalPathStateException {
            Shape shape = (Shape) renderingHints.get(Drawable.GRADIENT_SHAPE);
            this.shape = shape;
            if (shape == null) {
                throw new IllegalPathStateException("PathGradientPaint needs a shape to be set via the rendering hint Drawable.GRADIANT_SHAPE.");
            }
            this.deviceBounds = rectangle;
            this.userBounds = rectangle2D;
            this.xform = affineTransform;
            this.hints = renderingHints;
            int gradientSteps = getGradientSteps(shape);
            this.gradientSteps = gradientSteps;
            LinearGradientPaint linearGradientPaint = new LinearGradientPaint(new Point2D.Double(0.0d, 0.0d), new Point2D.Double(gradientSteps, 0.0d), PathGradientPaint.this.fractions, PathGradientPaint.this.colors, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform());
            Rectangle rectangle2 = new Rectangle(0, 0, gradientSteps, 1);
            this.pCtx = linearGradientPaint.createContext(colorModel, rectangle2, rectangle2, new AffineTransform(), renderingHints);
        }

        public ColorModel getColorModel() {
            return this.pCtx.getColorModel();
        }

        public Raster getRaster(int i, int i2, int i3, int i4) {
            ColorModel colorModel = getColorModel();
            if (this.raster == null) {
                createRaster();
            }
            WritableRaster writableRasterCreateCompatibleWritableRaster = colorModel.createCompatibleWritableRaster(i3, i4);
            Rectangle2D.Double r10 = new Rectangle2D.Double(i, i2, i3, i4);
            if (!r10.intersects(this.deviceBounds)) {
                return writableRasterCreateCompatibleWritableRaster;
            }
            Rectangle2D.Double r12 = new Rectangle2D.Double();
            Rectangle2D.intersect(r10, this.deviceBounds, r12);
            int x = (int) (r12.getX() - this.deviceBounds.getX());
            int y = (int) (r12.getY() - this.deviceBounds.getY());
            int width = (int) r12.getWidth();
            int height = (int) r12.getHeight();
            writableRasterCreateCompatibleWritableRaster.setDataElements((int) (r12.getX() - r10.getX()), (int) (r12.getY() - r10.getY()), width, height, this.raster.getDataElements(x, y, width, height, (Object) null));
            return writableRasterCreateCompatibleWritableRaster;
        }

        protected int getGradientSteps(Shape shape) {
            Rectangle bounds = shape.getBounds();
            int iMax = (int) (Math.max(bounds.getWidth(), bounds.getHeight()) / 2.0d);
            int i = 1;
            while (i < iMax - 1) {
                int i2 = ((iMax - i) / 2) + i;
                if (new Area(new BasicStroke(i2, PathGradientPaint.this.capStyle, PathGradientPaint.this.joinStyle).createStrokedShape(shape)).isSingular()) {
                    iMax = i2;
                } else {
                    i = i2;
                }
            }
            return iMax;
        }

        protected void createRaster() {
            ColorModel colorModel = getColorModel();
            this.raster = colorModel.createCompatibleWritableRaster((int) this.deviceBounds.getWidth(), (int) this.deviceBounds.getHeight());
            Graphics2D graphics2DCreateGraphics = new BufferedImage(colorModel, this.raster, false, (Hashtable) null).createGraphics();
            graphics2DCreateGraphics.setRenderingHints(this.hints);
            graphics2DCreateGraphics.translate(-this.deviceBounds.getX(), -this.deviceBounds.getY());
            graphics2DCreateGraphics.transform(this.xform);
            Raster raster = this.pCtx.getRaster(0, 0, this.gradientSteps, 1);
            int numComponents = colorModel.getNumComponents();
            int[] iArr = new int[numComponents];
            for (int i = this.gradientSteps - 1; i >= 0; i--) {
                raster.getPixel(i, 0, iArr);
                Color color = new Color(iArr[0], iArr[1], iArr[2]);
                if (numComponents == 4) {
                    graphics2DCreateGraphics.setComposite(AlphaComposite.getInstance(2, iArr[3] / 255.0f));
                }
                graphics2DCreateGraphics.setStroke(new BasicStroke(i + 1, PathGradientPaint.this.capStyle, PathGradientPaint.this.joinStyle));
                graphics2DCreateGraphics.setColor(color);
                graphics2DCreateGraphics.draw(this.shape);
            }
            graphics2DCreateGraphics.dispose();
        }
    }
}
