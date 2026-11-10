package org.apache.poi.hssf.usermodel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherGraphics extends Graphics {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) EscherGraphics.class);
    private Color background;
    private final HSSFShapeGroup escherGroup;
    private Font font;
    private Color foreground;
    private final float verticalPixelsPerPoint;
    private float verticalPointsPerPixel;
    private final HSSFWorkbook workbook;

    public void dispose() {
    }

    public Rectangle getClipBounds() {
        return null;
    }

    @NotImplemented
    public void setClip(Shape shape) {
    }

    public EscherGraphics(HSSFShapeGroup hSSFShapeGroup, HSSFWorkbook hSSFWorkbook, Color color, float f) {
        this.verticalPointsPerPixel = 1.0f;
        this.background = Color.white;
        this.escherGroup = hSSFShapeGroup;
        this.workbook = hSSFWorkbook;
        this.verticalPointsPerPixel = f;
        this.verticalPixelsPerPoint = 1.0f / f;
        this.font = new Font(HSSFFont.FONT_ARIAL, 0, 10);
        this.foreground = color;
    }

    EscherGraphics(HSSFShapeGroup hSSFShapeGroup, HSSFWorkbook hSSFWorkbook, Color color, Font font, float f) {
        this.verticalPointsPerPixel = 1.0f;
        this.background = Color.white;
        this.escherGroup = hSSFShapeGroup;
        this.workbook = hSSFWorkbook;
        this.foreground = color;
        this.font = font;
        this.verticalPointsPerPixel = f;
        this.verticalPixelsPerPoint = 1.0f / f;
    }

    @NotImplemented
    public void clearRect(int i, int i2, int i3, int i4) {
        Color color = this.foreground;
        setColor(this.background);
        fillRect(i, i2, i3, i4);
        setColor(color);
    }

    @NotImplemented
    public void clipRect(int i, int i2, int i3, int i4) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "clipRect not supported");
        }
    }

    @NotImplemented
    public void copyArea(int i, int i2, int i3, int i4, int i5, int i6) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "copyArea not supported");
        }
    }

    public Graphics create() {
        return new EscherGraphics(this.escherGroup, this.workbook, this.foreground, this.font, this.verticalPointsPerPixel);
    }

    @NotImplemented
    public void drawArc(int i, int i2, int i3, int i4, int i5, int i6) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "drawArc not supported");
        }
    }

    @NotImplemented
    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "drawImage not supported");
        }
        return true;
    }

    @NotImplemented
    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "drawImage not supported");
        }
        return true;
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, Color color, ImageObserver imageObserver) {
        return drawImage(image, i, i2, i + i3, i2 + i4, 0, 0, image.getWidth(imageObserver), image.getHeight(imageObserver), color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, ImageObserver imageObserver) {
        return drawImage(image, i, i2, i + i3, i2 + i4, 0, 0, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, Color color, ImageObserver imageObserver) {
        return drawImage(image, i, i2, image.getWidth(imageObserver), image.getHeight(imageObserver), color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, ImageObserver imageObserver) {
        return drawImage(image, i, i2, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
    }

    public void drawLine(int i, int i2, int i3, int i4) {
        drawLine(i, i2, i3, i4, 0);
    }

    public void drawLine(int i, int i2, int i3, int i4, int i5) {
        HSSFSimpleShape hSSFSimpleShapeCreateShape = this.escherGroup.createShape(new HSSFChildAnchor(i, i2, i3, i4));
        hSSFSimpleShapeCreateShape.setShapeType(20);
        hSSFSimpleShapeCreateShape.setLineWidth(i5);
        hSSFSimpleShapeCreateShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
    }

    public void drawOval(int i, int i2, int i3, int i4) {
        HSSFSimpleShape hSSFSimpleShapeCreateShape = this.escherGroup.createShape(new HSSFChildAnchor(i, i2, i3 + i, i4 + i2));
        hSSFSimpleShapeCreateShape.setShapeType(3);
        hSSFSimpleShapeCreateShape.setLineWidth(0);
        hSSFSimpleShapeCreateShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFSimpleShapeCreateShape.setNoFill(true);
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i) {
        int iFindBiggest = findBiggest(iArr);
        int iFindBiggest2 = findBiggest(iArr2);
        int iFindSmallest = findSmallest(iArr);
        int iFindSmallest2 = findSmallest(iArr2);
        HSSFPolygon hSSFPolygonCreatePolygon = this.escherGroup.createPolygon(new HSSFChildAnchor(iFindSmallest, iFindSmallest2, iFindBiggest, iFindBiggest2));
        hSSFPolygonCreatePolygon.setPolygonDrawArea(iFindBiggest - iFindSmallest, iFindBiggest2 - iFindSmallest2);
        hSSFPolygonCreatePolygon.setPoints(addToAll(iArr, -iFindSmallest), addToAll(iArr2, -iFindSmallest2));
        hSSFPolygonCreatePolygon.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFPolygonCreatePolygon.setLineWidth(0);
        hSSFPolygonCreatePolygon.setNoFill(true);
    }

    private int[] addToAll(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = iArr[i2] + i;
        }
        return iArr2;
    }

    @NotImplemented
    public void drawPolyline(int[] iArr, int[] iArr2, int i) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "drawPolyline not supported");
        }
    }

    @NotImplemented
    public void drawRect(int i, int i2, int i3, int i4) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "drawRect not supported");
        }
    }

    @NotImplemented
    public void drawRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "drawRoundRect not supported");
        }
    }

    public void drawString(String str, int i, int i2) {
        Font font;
        if (str == null || str.equals("")) {
            return;
        }
        if (this.font.getName().equals("SansSerif")) {
            font = new Font(HSSFFont.FONT_ARIAL, this.font.getStyle(), (int) (this.font.getSize() / this.verticalPixelsPerPoint));
        } else {
            font = new Font(this.font.getName(), this.font.getStyle(), (int) (this.font.getSize() / this.verticalPixelsPerPoint));
        }
        int stringWidth = (StaticFontMetrics.getFontDetails(font).getStringWidth(str) * 8) + 12;
        int size = ((int) ((this.font.getSize() / this.verticalPixelsPerPoint) + 6.0f)) * 2;
        float size2 = this.font.getSize();
        float f = this.verticalPixelsPerPoint;
        int i3 = (int) (i2 - ((size2 / f) + (f * 2.0f)));
        HSSFTextbox hSSFTextboxCreateTextbox = this.escherGroup.createTextbox(new HSSFChildAnchor(i, i3, stringWidth + i, size + i3));
        hSSFTextboxCreateTextbox.setNoFill(true);
        hSSFTextboxCreateTextbox.setLineStyle(-1);
        HSSFRichTextString hSSFRichTextString = new HSSFRichTextString(str);
        hSSFRichTextString.applyFont(matchFont(font));
        hSSFTextboxCreateTextbox.setString(hSSFRichTextString);
    }

    private HSSFFont matchFont(Font font) {
        HSSFColor hSSFColorFindColor = this.workbook.getCustomPalette().findColor((byte) this.foreground.getRed(), (byte) this.foreground.getGreen(), (byte) this.foreground.getBlue());
        if (hSSFColorFindColor == null) {
            hSSFColorFindColor = this.workbook.getCustomPalette().findSimilarColor((byte) this.foreground.getRed(), (byte) this.foreground.getGreen(), (byte) this.foreground.getBlue());
        }
        boolean z = (font.getStyle() & 1) != 0;
        boolean z2 = (font.getStyle() & 2) != 0;
        HSSFFont hSSFFontFindFont = this.workbook.findFont(z, hSSFColorFindColor.getIndex(), (short) (font.getSize() * 20), font.getName(), z2, false, (short) 0, (byte) 0);
        if (hSSFFontFindFont != null) {
            return hSSFFontFindFont;
        }
        HSSFFont hSSFFontCreateFont = this.workbook.createFont();
        hSSFFontCreateFont.setBold(z);
        hSSFFontCreateFont.setColor(hSSFColorFindColor.getIndex());
        hSSFFontCreateFont.setFontHeight((short) (font.getSize() * 20));
        hSSFFontCreateFont.setFontName(font.getName());
        hSSFFontCreateFont.setItalic(z2);
        hSSFFontCreateFont.setStrikeout(false);
        hSSFFontCreateFont.setTypeOffset((short) 0);
        hSSFFontCreateFont.setUnderline((byte) 0);
        return hSSFFontCreateFont;
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "drawString not supported");
        }
    }

    public void fillArc(int i, int i2, int i3, int i4, int i5, int i6) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "fillArc not supported");
        }
    }

    public void fillOval(int i, int i2, int i3, int i4) {
        HSSFSimpleShape hSSFSimpleShapeCreateShape = this.escherGroup.createShape(new HSSFChildAnchor(i, i2, i3 + i, i4 + i2));
        hSSFSimpleShapeCreateShape.setShapeType(3);
        hSSFSimpleShapeCreateShape.setLineStyle(-1);
        hSSFSimpleShapeCreateShape.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFSimpleShapeCreateShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFSimpleShapeCreateShape.setNoFill(false);
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i) {
        int iFindBiggest = findBiggest(iArr);
        int iFindBiggest2 = findBiggest(iArr2);
        int iFindSmallest = findSmallest(iArr);
        int iFindSmallest2 = findSmallest(iArr2);
        HSSFPolygon hSSFPolygonCreatePolygon = this.escherGroup.createPolygon(new HSSFChildAnchor(iFindSmallest, iFindSmallest2, iFindBiggest, iFindBiggest2));
        hSSFPolygonCreatePolygon.setPolygonDrawArea(iFindBiggest - iFindSmallest, iFindBiggest2 - iFindSmallest2);
        hSSFPolygonCreatePolygon.setPoints(addToAll(iArr, -iFindSmallest), addToAll(iArr2, -iFindSmallest2));
        hSSFPolygonCreatePolygon.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFPolygonCreatePolygon.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
    }

    private int findBiggest(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    private int findSmallest(int[] iArr) {
        int i = Integer.MAX_VALUE;
        for (int i2 : iArr) {
            if (i2 < i) {
                i = i2;
            }
        }
        return i;
    }

    public void fillRect(int i, int i2, int i3, int i4) {
        HSSFSimpleShape hSSFSimpleShapeCreateShape = this.escherGroup.createShape(new HSSFChildAnchor(i, i2, i3 + i, i4 + i2));
        hSSFSimpleShapeCreateShape.setShapeType(1);
        hSSFSimpleShapeCreateShape.setLineStyle(-1);
        hSSFSimpleShapeCreateShape.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFSimpleShapeCreateShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
    }

    public void fillRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "fillRoundRect not supported");
        }
    }

    public Shape getClip() {
        return getClipBounds();
    }

    public Color getColor() {
        return this.foreground;
    }

    public Font getFont() {
        return this.font;
    }

    public FontMetrics getFontMetrics(Font font) {
        return Toolkit.getDefaultToolkit().getFontMetrics(font);
    }

    public void setClip(int i, int i2, int i3, int i4) {
        setClip(new Rectangle(i, i2, i3, i4));
    }

    public void setColor(Color color) {
        this.foreground = color;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    @NotImplemented
    public void setPaintMode() {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "setPaintMode not supported");
        }
    }

    @NotImplemented
    public void setXORMode(Color color) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "setXORMode not supported");
        }
    }

    @NotImplemented
    public void translate(int i, int i2) {
        POILogger pOILogger = logger;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "translate not supported");
        }
    }

    public Color getBackground() {
        return this.background;
    }

    public void setBackground(Color color) {
        this.background = color;
    }

    HSSFShapeGroup getEscherGraphics() {
        return this.escherGroup;
    }
}
