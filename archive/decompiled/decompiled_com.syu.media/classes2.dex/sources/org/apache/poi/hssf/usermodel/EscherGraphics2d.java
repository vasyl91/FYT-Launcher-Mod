package org.apache.poi.hssf.usermodel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Hashtable;
import java.util.Map;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EscherGraphics2d extends Graphics2D {
    private Shape _deviceclip;
    private EscherGraphics _escherGraphics;
    private BufferedImage _img;
    private Paint _paint;
    private Stroke _stroke;
    private AffineTransform _trans;
    private POILogger logger = POILogFactory.getLogger(getClass());

    public EscherGraphics2d(EscherGraphics escherGraphics) {
        this._escherGraphics = escherGraphics;
        setImg(new BufferedImage(1, 1, 2));
        setColor(Color.black);
    }

    public void addRenderingHints(Map<?, ?> map) {
        getG2D().addRenderingHints(map);
    }

    public void clearRect(int i, int i2, int i3, int i4) {
        Paint paint = getPaint();
        setColor(getBackground());
        fillRect(i, i2, i3, i4);
        setPaint(paint);
    }

    public void clip(Shape shape) {
        if (getDeviceclip() != null) {
            Shape area = new Area(getClip());
            if (shape != null) {
                area.intersect(new Area(shape));
            }
            shape = area;
        }
        setClip(shape);
    }

    public void clipRect(int i, int i2, int i3, int i4) {
        clip(new Rectangle(i, i2, i3, i4));
    }

    public void copyArea(int i, int i2, int i3, int i4, int i5, int i6) {
        getG2D().copyArea(i, i2, i3, i4, i5, i6);
    }

    public Graphics create() {
        return new EscherGraphics2d(this._escherGraphics);
    }

    public void dispose() {
        getEscherGraphics().dispose();
        getG2D().dispose();
        getImg().flush();
    }

    public void draw(Shape shape) {
        int lineWidth = 0;
        if (shape instanceof Line2D) {
            Line2D line2D = (Line2D) shape;
            BasicStroke basicStroke = this._stroke;
            if (basicStroke != null && (basicStroke instanceof BasicStroke)) {
                lineWidth = ((int) basicStroke.getLineWidth()) * 12700;
            }
            drawLine((int) line2D.getX1(), (int) line2D.getY1(), (int) line2D.getX2(), (int) line2D.getY2(), lineWidth);
            return;
        }
        if (this.logger.check(5)) {
            this.logger.log(5, "draw not fully supported");
        }
    }

    public void drawArc(int i, int i2, int i3, int i4, int i5, int i6) {
        draw(new Arc2D.Float(i, i2, i3, i4, i5, i6, 0));
    }

    public void drawGlyphVector(GlyphVector glyphVector, float f, float f2) {
        fill(glyphVector.getOutline(f, f2));
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        if (this.logger.check(5)) {
            this.logger.log(5, "drawImage() not supported");
        }
        return true;
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        if (this.logger.check(5)) {
            this.logger.log(5, "drawImage() not supported");
        }
        return drawImage(image, i, i2, i3, i4, i5, i6, i7, i8, null, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, Color color, ImageObserver imageObserver) {
        if (this.logger.check(5)) {
            this.logger.log(5, "drawImage() not supported");
        }
        return true;
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, ImageObserver imageObserver) {
        return drawImage(image, i, i2, i3, i4, null, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, Color color, ImageObserver imageObserver) {
        return drawImage(image, i, i2, image.getWidth(imageObserver), image.getHeight(imageObserver), color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, ImageObserver imageObserver) {
        return drawImage(image, i, i2, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
    }

    public boolean drawImage(Image image, AffineTransform affineTransform, ImageObserver imageObserver) {
        AffineTransform affineTransform2 = (AffineTransform) getTrans().clone();
        getTrans().concatenate(affineTransform);
        drawImage(image, 0, 0, imageObserver);
        setTrans(affineTransform2);
        return true;
    }

    public void drawImage(BufferedImage bufferedImage, BufferedImageOp bufferedImageOp, int i, int i2) {
        drawImage(bufferedImageOp.filter(bufferedImage, (BufferedImage) null), new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, i, i2), null);
    }

    public void drawLine(int i, int i2, int i3, int i4, int i5) {
        getEscherGraphics().drawLine(i, i2, i3, i4, i5);
    }

    public void drawLine(int i, int i2, int i3, int i4) {
        BasicStroke basicStroke = this._stroke;
        getEscherGraphics().drawLine(i, i2, i3, i4, (basicStroke == null || !(basicStroke instanceof BasicStroke)) ? 0 : ((int) basicStroke.getLineWidth()) * 12700);
    }

    public void drawOval(int i, int i2, int i3, int i4) {
        getEscherGraphics().drawOval(i, i2, i3, i4);
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i) {
        getEscherGraphics().drawPolygon(iArr, iArr2, i);
    }

    public void drawPolyline(int[] iArr, int[] iArr2, int i) {
        if (i > 0) {
            GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo(iArr[0], iArr2[0]);
            for (int i2 = 1; i2 < i; i2++) {
                generalPath.lineTo(iArr[i2], iArr2[i2]);
            }
            draw(generalPath);
        }
    }

    public void drawRect(int i, int i2, int i3, int i4) {
        this._escherGraphics.drawRect(i, i2, i3, i4);
    }

    public void drawRenderableImage(RenderableImage renderableImage, AffineTransform affineTransform) {
        drawRenderedImage(renderableImage.createDefaultRendering(), affineTransform);
    }

    public void drawRenderedImage(RenderedImage renderedImage, AffineTransform affineTransform) {
        BufferedImage bufferedImage = new BufferedImage(renderedImage.getColorModel(), renderedImage.getData().createCompatibleWritableRaster(), false, (Hashtable) null);
        bufferedImage.setData(renderedImage.getData());
        drawImage(bufferedImage, affineTransform, null);
    }

    public void drawRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        draw(new RoundRectangle2D.Float(i, i2, i3, i4, i5, i6));
    }

    public void drawString(String str, float f, float f2) {
        getEscherGraphics().drawString(str, (int) f, (int) f2);
    }

    public void drawString(String str, int i, int i2) {
        getEscherGraphics().drawString(str, i, i2);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, float f, float f2) {
        TextLayout textLayout = new TextLayout(attributedCharacterIterator, getFontRenderContext());
        Paint paint = getPaint();
        setColor(getColor());
        fill(textLayout.getOutline(AffineTransform.getTranslateInstance(f, f2)));
        setPaint(paint);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2) {
        getEscherGraphics().drawString(attributedCharacterIterator, i, i2);
    }

    public void fill(Shape shape) {
        if (this.logger.check(5)) {
            this.logger.log(5, "fill(Shape) not supported");
        }
    }

    public void fillArc(int i, int i2, int i3, int i4, int i5, int i6) {
        fill(new Arc2D.Float(i, i2, i3, i4, i5, i6, 2));
    }

    public void fillOval(int i, int i2, int i3, int i4) {
        this._escherGraphics.fillOval(i, i2, i3, i4);
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i) {
        this._escherGraphics.fillPolygon(iArr, iArr2, i);
    }

    public void fillRect(int i, int i2, int i3, int i4) {
        getEscherGraphics().fillRect(i, i2, i3, i4);
    }

    public void fillRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        fill(new RoundRectangle2D.Float(i, i2, i3, i4, i5, i6));
    }

    public Color getBackground() {
        return getEscherGraphics().getBackground();
    }

    public Shape getClip() {
        try {
            return getTrans().createInverse().createTransformedShape(getDeviceclip());
        } catch (Exception unused) {
            return null;
        }
    }

    public Rectangle getClipBounds() {
        if (getDeviceclip() != null) {
            return getClip().getBounds();
        }
        return null;
    }

    public Color getColor() {
        return this._escherGraphics.getColor();
    }

    public Composite getComposite() {
        return getG2D().getComposite();
    }

    public GraphicsConfiguration getDeviceConfiguration() {
        return getG2D().getDeviceConfiguration();
    }

    public Font getFont() {
        return getEscherGraphics().getFont();
    }

    public FontMetrics getFontMetrics(Font font) {
        return getEscherGraphics().getFontMetrics(font);
    }

    public FontRenderContext getFontRenderContext() {
        getG2D().setTransform(getTrans());
        return getG2D().getFontRenderContext();
    }

    public Paint getPaint() {
        return this._paint;
    }

    public Object getRenderingHint(RenderingHints.Key key) {
        return getG2D().getRenderingHint(key);
    }

    public RenderingHints getRenderingHints() {
        return getG2D().getRenderingHints();
    }

    public Stroke getStroke() {
        return this._stroke;
    }

    public AffineTransform getTransform() {
        return (AffineTransform) getTrans().clone();
    }

    public boolean hit(Rectangle rectangle, Shape shape, boolean z) {
        getG2D().setTransform(getTrans());
        getG2D().setStroke(getStroke());
        getG2D().setClip(getClip());
        return getG2D().hit(rectangle, shape, z);
    }

    public void rotate(double d) {
        getTrans().rotate(d);
    }

    public void rotate(double d, double d2, double d3) {
        getTrans().rotate(d, d2, d3);
    }

    public void scale(double d, double d2) {
        getTrans().scale(d, d2);
    }

    public void setBackground(Color color) {
        getEscherGraphics().setBackground(color);
    }

    public void setClip(int i, int i2, int i3, int i4) {
        setClip(new Rectangle(i, i2, i3, i4));
    }

    public void setClip(Shape shape) {
        setDeviceclip(getTrans().createTransformedShape(shape));
    }

    public void setColor(Color color) {
        this._escherGraphics.setColor(color);
    }

    public void setComposite(Composite composite) {
        getG2D().setComposite(composite);
    }

    public void setFont(Font font) {
        getEscherGraphics().setFont(font);
    }

    public void setPaint(Paint paint) {
        if (paint != null) {
            this._paint = paint;
            if (paint instanceof Color) {
                setColor((Color) paint);
            }
        }
    }

    public void setPaintMode() {
        getEscherGraphics().setPaintMode();
    }

    public void setRenderingHint(RenderingHints.Key key, Object obj) {
        getG2D().setRenderingHint(key, obj);
    }

    public void setRenderingHints(Map<?, ?> map) {
        getG2D().setRenderingHints(map);
    }

    public void setStroke(Stroke stroke) {
        this._stroke = stroke;
    }

    public void setTransform(AffineTransform affineTransform) {
        setTrans((AffineTransform) affineTransform.clone());
    }

    public void setXORMode(Color color) {
        getEscherGraphics().setXORMode(color);
    }

    public void shear(double d, double d2) {
        getTrans().shear(d, d2);
    }

    public void transform(AffineTransform affineTransform) {
        getTrans().concatenate(affineTransform);
    }

    public void translate(double d, double d2) {
        getTrans().translate(d, d2);
    }

    public void translate(int i, int i2) {
        getTrans().translate(i, i2);
    }

    private EscherGraphics getEscherGraphics() {
        return this._escherGraphics;
    }

    private BufferedImage getImg() {
        return this._img;
    }

    private void setImg(BufferedImage bufferedImage) {
        this._img = bufferedImage;
    }

    private Graphics2D getG2D() {
        return this._img.getGraphics();
    }

    private AffineTransform getTrans() {
        return this._trans;
    }

    private void setTrans(AffineTransform affineTransform) {
        this._trans = affineTransform;
    }

    private Shape getDeviceclip() {
        return this._deviceclip;
    }

    private void setDeviceclip(Shape shape) {
        this._deviceclip = shape;
    }
}
