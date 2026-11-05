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
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.PrintStream;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;
import java.util.Map;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DummyGraphics2d extends Graphics2D {
    private BufferedImage bufimg;
    private final Graphics2D g2D;
    private final PrintStream log;

    public DummyGraphics2d() {
        this(System.out);
    }

    public DummyGraphics2d(PrintStream printStream) {
        BufferedImage bufferedImage = new BufferedImage(1000, 1000, 2);
        this.bufimg = bufferedImage;
        this.g2D = bufferedImage.getGraphics();
        this.log = printStream;
    }

    public DummyGraphics2d(PrintStream printStream, Graphics2D graphics2D) {
        this.g2D = graphics2D;
        this.log = printStream;
    }

    public void addRenderingHints(Map<?, ?> map) {
        this.log.println("addRenderingHinds(Map):\n  hints = " + map);
        this.g2D.addRenderingHints(map);
    }

    public void clip(Shape shape) {
        this.log.println("clip(Shape):\n  s = " + shape);
        this.g2D.clip(shape);
    }

    public void draw(Shape shape) {
        this.log.println("draw(Shape):\n  s = " + shape);
        this.g2D.draw(shape);
    }

    public void drawGlyphVector(GlyphVector glyphVector, float f, float f2) {
        this.log.println("drawGlyphVector(GlyphVector, float, float):\n  g = " + glyphVector + "\n  x = " + f + "\n  y = " + f2);
        this.g2D.drawGlyphVector(glyphVector, f, f2);
    }

    public void drawImage(BufferedImage bufferedImage, BufferedImageOp bufferedImageOp, int i, int i2) {
        this.log.println("drawImage(BufferedImage, BufferedImageOp, x, y):\n  img = " + bufferedImage + "\n  op = " + bufferedImageOp + "\n  x = " + i + "\n  y = " + i2);
        this.g2D.drawImage(bufferedImage, bufferedImageOp, i, i2);
    }

    public boolean drawImage(Image image, AffineTransform affineTransform, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,AfflineTransform,ImageObserver):\n  img = " + image + "\n  xform = " + affineTransform + "\n  obs = " + imageObserver);
        return this.g2D.drawImage(image, affineTransform, imageObserver);
    }

    public void drawRenderableImage(RenderableImage renderableImage, AffineTransform affineTransform) {
        this.log.println("drawRenderableImage(RenderableImage, AfflineTransform):\n  img = " + renderableImage + "\n  xform = " + affineTransform);
        this.g2D.drawRenderableImage(renderableImage, affineTransform);
    }

    public void drawRenderedImage(RenderedImage renderedImage, AffineTransform affineTransform) {
        this.log.println("drawRenderedImage(RenderedImage, AffineTransform):\n  img = " + renderedImage + "\n  xform = " + affineTransform);
        this.g2D.drawRenderedImage(renderedImage, affineTransform);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, float f, float f2) {
        this.log.println("drawString(AttributedCharacterIterator):\n  iterator = " + attributedCharacterIterator + "\n  x = " + f + "\n  y = " + f2);
        this.g2D.drawString(attributedCharacterIterator, f, f2);
    }

    public void drawString(String str, float f, float f2) {
        this.log.println("drawString(s,x,y):\n  s = " + str + "\n  x = " + f + "\n  y = " + f2);
        this.g2D.drawString(str, f, f2);
    }

    public void fill(Shape shape) {
        this.log.println("fill(Shape):\n  s = " + shape);
        this.g2D.fill(shape);
    }

    public Color getBackground() {
        this.log.println("getBackground():");
        return this.g2D.getBackground();
    }

    public Composite getComposite() {
        this.log.println("getComposite():");
        return this.g2D.getComposite();
    }

    public GraphicsConfiguration getDeviceConfiguration() {
        this.log.println("getDeviceConfiguration():");
        return this.g2D.getDeviceConfiguration();
    }

    public FontRenderContext getFontRenderContext() {
        this.log.println("getFontRenderContext():");
        return this.g2D.getFontRenderContext();
    }

    public Paint getPaint() {
        this.log.println("getPaint():");
        return this.g2D.getPaint();
    }

    public Object getRenderingHint(RenderingHints.Key key) {
        this.log.println("getRenderingHint(RenderingHints.Key):\n  hintKey = " + key);
        return this.g2D.getRenderingHint(key);
    }

    public RenderingHints getRenderingHints() {
        this.log.println("getRenderingHints():");
        return this.g2D.getRenderingHints();
    }

    public Stroke getStroke() {
        this.log.println("getStroke():");
        return this.g2D.getStroke();
    }

    public AffineTransform getTransform() {
        this.log.println("getTransform():");
        return this.g2D.getTransform();
    }

    public boolean hit(Rectangle rectangle, Shape shape, boolean z) {
        this.log.println("hit(Rectangle, Shape, onStroke):\n  rect = " + rectangle + "\n  s = " + shape + "\n  onStroke = " + z);
        return this.g2D.hit(rectangle, shape, z);
    }

    public void rotate(double d) {
        this.log.println("rotate(theta):\n  theta = " + d);
        this.g2D.rotate(d);
    }

    public void rotate(double d, double d2, double d3) {
        this.log.println("rotate(double,double,double):\n  theta = " + d + "\n  x = " + d2 + "\n  y = " + d3);
        this.g2D.rotate(d, d2, d3);
    }

    public void scale(double d, double d2) {
        this.log.println("scale(double,double):\n  sx = " + d + "\n  sy");
        this.g2D.scale(d, d2);
    }

    public void setBackground(Color color) {
        this.log.println("setBackground(Color):\n  color = " + color);
        this.g2D.setBackground(color);
    }

    public void setComposite(Composite composite) {
        this.log.println("setComposite(Composite):\n  comp = " + composite);
        this.g2D.setComposite(composite);
    }

    public void setPaint(Paint paint) {
        this.log.println("setPaint(Paint):\n  paint = " + paint);
        this.g2D.setPaint(paint);
    }

    public void setRenderingHint(RenderingHints.Key key, Object obj) {
        this.log.println("setRenderingHint(RenderingHints.Key, Object):\n  hintKey = " + key + "\n  hintValue = " + obj);
        this.g2D.setRenderingHint(key, obj);
    }

    public void setRenderingHints(Map<?, ?> map) {
        this.log.println("setRenderingHints(Map):\n  hints = " + map);
        this.g2D.setRenderingHints(map);
    }

    public void setStroke(Stroke stroke) {
        String str;
        if (stroke instanceof BasicStroke) {
            BasicStroke basicStroke = (BasicStroke) stroke;
            str = "setStroke(Stoke):\n  s = BasicStroke(\n    dash[]: " + Arrays.toString(basicStroke.getDashArray()) + "\n    dashPhase: " + basicStroke.getDashPhase() + "\n    endCap: " + basicStroke.getEndCap() + "\n    lineJoin: " + basicStroke.getLineJoin() + "\n    width: " + basicStroke.getLineWidth() + "\n    miterLimit: " + basicStroke.getMiterLimit() + "\n  )";
        } else {
            str = "setStroke(Stoke):\n  s = " + stroke;
        }
        this.log.println(str);
        this.g2D.setStroke(stroke);
    }

    public void setTransform(AffineTransform affineTransform) {
        this.log.println("setTransform():\n  Tx = " + affineTransform);
        this.g2D.setTransform(affineTransform);
    }

    public void shear(double d, double d2) {
        this.log.println("shear(shx, dhy):\n  shx = " + d + "\n  shy = " + d2);
        this.g2D.shear(d, d2);
    }

    public void transform(AffineTransform affineTransform) {
        this.log.println("transform(AffineTransform):\n  Tx = " + affineTransform);
        this.g2D.transform(affineTransform);
    }

    public void translate(double d, double d2) {
        this.log.println("translate(double, double):\n  tx = " + d + "\n  ty = " + d2);
        this.g2D.translate(d, d2);
    }

    public void clearRect(int i, int i2, int i3, int i4) {
        this.log.println("clearRect(int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        this.g2D.clearRect(i, i2, i3, i4);
    }

    public void clipRect(int i, int i2, int i3, int i4) {
        this.log.println("clipRect(int, int, int, int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "height = " + i4);
        this.g2D.clipRect(i, i2, i3, i4);
    }

    public void copyArea(int i, int i2, int i3, int i4, int i5, int i6) {
        this.log.println("copyArea(int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        this.g2D.copyArea(i, i2, i3, i4, i5, i6);
    }

    public Graphics create() {
        this.log.println("create():");
        return this.g2D.create();
    }

    public Graphics create(int i, int i2, int i3, int i4) {
        this.log.println("create(int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        return this.g2D.create(i, i2, i3, i4);
    }

    public void dispose() {
        this.log.println("dispose():");
        this.g2D.dispose();
    }

    public void draw3DRect(int i, int i2, int i3, int i4, boolean z) {
        this.log.println("draw3DRect(int,int,int,int,boolean):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4 + "\n  raised = " + z);
        this.g2D.draw3DRect(i, i2, i3, i4, z);
    }

    public void drawArc(int i, int i2, int i3, int i4, int i5, int i6) {
        this.log.println("drawArc(int,int,int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4 + "\n  startAngle = " + i5 + "\n  arcAngle = " + i6);
        this.g2D.drawArc(i, i2, i3, i4, i5, i6);
    }

    public void drawBytes(byte[] bArr, int i, int i2, int i3, int i4) {
        this.log.println("drawBytes(byte[],int,int,int,int):\n  data = " + Arrays.toString(bArr) + "\n  offset = " + i + "\n  length = " + i2 + "\n  x = " + i3 + "\n  y = " + i4);
        this.g2D.drawBytes(bArr, i, i2, i3, i4);
    }

    public void drawChars(char[] cArr, int i, int i2, int i3, int i4) {
        this.log.println("drawChars(data,int,int,int,int):\n  data = " + Arrays.toString(cArr) + "\n  offset = " + i + "\n  length = " + i2 + "\n  x = " + i3 + "\n  y = " + i4);
        this.g2D.drawChars(cArr, i, i2, i3, i4);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,int,int,int,int,int,int,int,int,ImageObserver):\n  img = " + image + "\n  dx1 = " + i + "\n  dy1 = " + i2 + "\n  dx2 = " + i3 + "\n  dy2 = " + i4 + "\n  sx1 = " + i5 + "\n  sy1 = " + i6 + "\n  sx2 = " + i7 + "\n  sy2 = " + i8 + "\n  observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, i5, i6, i7, i8, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,int,int,int,int,int,int,int,int,Color,ImageObserver):\n  img = " + image + "\n  dx1 = " + i + "\n  dy1 = " + i2 + "\n  dx2 = " + i3 + "\n  dy2 = " + i4 + "\n  sx1 = " + i5 + "\n  sy1 = " + i6 + "\n  sx2 = " + i7 + "\n  sy2 = " + i8 + "\n  bgcolor = " + color + "\n  observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, i5, i6, i7, i8, color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, Color color, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,int,int,Color,ImageObserver):\n  img = " + image + "\n  x = " + i + "\n  y = " + i2 + "\n  bgcolor = " + color + "\n  observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,int,int,observer):\n  img = " + image + "\n  x = " + i + "\n  y = " + i2 + "\n  observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, Color color, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,int,int,int,int,Color,ImageObserver):\n  img = " + image + "\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4 + "\n  bgcolor = " + color + "\n  observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,int,int,width,height,observer):\n  img = " + image + "\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4 + "\n  observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, imageObserver);
    }

    public void drawLine(int i, int i2, int i3, int i4) {
        this.log.println("drawLine(int,int,int,int):\n  x1 = " + i + "\n  y1 = " + i2 + "\n  x2 = " + i3 + "\n  y2 = " + i4);
        this.g2D.drawLine(i, i2, i3, i4);
    }

    public void drawOval(int i, int i2, int i3, int i4) {
        this.log.println("drawOval(int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        this.g2D.drawOval(i, i2, i3, i4);
    }

    public void drawPolygon(Polygon polygon) {
        this.log.println("drawPolygon(Polygon):\n  p = " + polygon);
        this.g2D.drawPolygon(polygon);
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i) {
        this.log.println("drawPolygon(int[],int[],int):\n  xPoints = " + Arrays.toString(iArr) + "\n  yPoints = " + Arrays.toString(iArr2) + "\n  nPoints = " + i);
        this.g2D.drawPolygon(iArr, iArr2, i);
    }

    public void drawPolyline(int[] iArr, int[] iArr2, int i) {
        this.log.println("drawPolyline(int[],int[],int):\n  xPoints = " + Arrays.toString(iArr) + "\n  yPoints = " + Arrays.toString(iArr2) + "\n  nPoints = " + i);
        this.g2D.drawPolyline(iArr, iArr2, i);
    }

    public void drawRect(int i, int i2, int i3, int i4) {
        this.log.println("drawRect(int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        this.g2D.drawRect(i, i2, i3, i4);
    }

    public void drawRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        this.log.println("drawRoundRect(int,int,int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4 + "\n  arcWidth = " + i5 + "\n  arcHeight = " + i6);
        this.g2D.drawRoundRect(i, i2, i3, i4, i5, i6);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2) {
        this.log.println("drawString(AttributedCharacterIterator,int,int):\n  iterator = " + attributedCharacterIterator + "\n  x = " + i + "\n  y = " + i2);
        this.g2D.drawString(attributedCharacterIterator, i, i2);
    }

    public void drawString(String str, int i, int i2) {
        this.log.println("drawString(str,int,int):\n  str = " + str + "\n  x = " + i + "\n  y = " + i2);
        this.g2D.drawString(str, i, i2);
    }

    public void fill3DRect(int i, int i2, int i3, int i4, boolean z) {
        this.log.println("fill3DRect(int,int,int,int,boolean):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4 + "\n  raised = " + z);
        this.g2D.fill3DRect(i, i2, i3, i4, z);
    }

    public void fillArc(int i, int i2, int i3, int i4, int i5, int i6) {
        this.log.println("fillArc(int,int,int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4 + "\n  startAngle = " + i5 + "\n  arcAngle = " + i6);
        this.g2D.fillArc(i, i2, i3, i4, i5, i6);
    }

    public void fillOval(int i, int i2, int i3, int i4) {
        this.log.println("fillOval(int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        this.g2D.fillOval(i, i2, i3, i4);
    }

    public void fillPolygon(Polygon polygon) {
        this.log.println("fillPolygon(Polygon):\n  p = " + polygon);
        this.g2D.fillPolygon(polygon);
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i) {
        this.log.println("fillPolygon(int[],int[],int):\n  xPoints = " + Arrays.toString(iArr) + "\n  yPoints = " + Arrays.toString(iArr2) + "\n  nPoints = " + i);
        this.g2D.fillPolygon(iArr, iArr2, i);
    }

    public void fillRect(int i, int i2, int i3, int i4) {
        this.log.println("fillRect(int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        this.g2D.fillRect(i, i2, i3, i4);
    }

    public void fillRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        this.log.println("fillRoundRect(int,int,int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        this.g2D.fillRoundRect(i, i2, i3, i4, i5, i6);
    }

    @Internal
    public final void finalize() {
        this.log.println("finalize():");
        this.g2D.finalize();
        super.finalize();
    }

    public Shape getClip() {
        this.log.println("getClip():");
        return this.g2D.getClip();
    }

    public Rectangle getClipBounds() {
        this.log.println("getClipBounds():");
        return this.g2D.getClipBounds();
    }

    public Rectangle getClipBounds(Rectangle rectangle) {
        this.log.println("getClipBounds(Rectangle):\n  r = " + rectangle);
        return this.g2D.getClipBounds(rectangle);
    }

    public Color getColor() {
        this.log.println("getColor():");
        return this.g2D.getColor();
    }

    public Font getFont() {
        this.log.println("getFont():");
        return this.g2D.getFont();
    }

    public FontMetrics getFontMetrics() {
        this.log.println("getFontMetrics():");
        return this.g2D.getFontMetrics();
    }

    public FontMetrics getFontMetrics(Font font) {
        this.log.println("getFontMetrics():");
        return this.g2D.getFontMetrics(font);
    }

    public boolean hitClip(int i, int i2, int i3, int i4) {
        this.log.println("hitClip(int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        return this.g2D.hitClip(i, i2, i3, i4);
    }

    public void setClip(Shape shape) {
        this.log.println("setClip(Shape):\n  clip = " + shape);
        this.g2D.setClip(shape);
    }

    public void setClip(int i, int i2, int i3, int i4) {
        this.log.println("setClip(int,int,int,int):\n  x = " + i + "\n  y = " + i2 + "\n  width = " + i3 + "\n  height = " + i4);
        this.g2D.setClip(i, i2, i3, i4);
    }

    public void setColor(Color color) {
        this.log.println("setColor():\n  c = " + color);
        this.g2D.setColor(color);
    }

    public void setFont(Font font) {
        this.log.println("setFont(Font):\n  font = " + font);
        this.g2D.setFont(font);
    }

    public void setPaintMode() {
        this.log.println("setPaintMode():");
        this.g2D.setPaintMode();
    }

    public void setXORMode(Color color) {
        this.log.println("setXORMode(Color):\n  c1 = " + color);
        this.g2D.setXORMode(color);
    }

    public String toString() {
        this.log.println("toString():");
        return this.g2D.toString();
    }

    public void translate(int i, int i2) {
        this.log.println("translate(int,int):\n  x = " + i + "\n  y = " + i2);
        this.g2D.translate(i, i2);
    }
}
