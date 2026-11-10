package org.apache.poi.sl.draw;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.InvalidObjectException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.sl.usermodel.AutoNumberingScheme;
import org.apache.poi.sl.usermodel.Hyperlink;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Units;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawTextParagraph implements Drawable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected int autoNbrIdx;
    protected DrawTextFragment bullet;
    protected List<DrawTextFragment> lines = new ArrayList();
    protected double maxLineHeight;
    protected TextParagraph<?, ?, ?> paragraph;
    protected String rawText;
    double x;
    double y;
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) DrawTextParagraph.class);
    public static final XlinkAttribute HYPERLINK_HREF = new XlinkAttribute("href");
    public static final XlinkAttribute HYPERLINK_LABEL = new XlinkAttribute("label");

    @Override // org.apache.poi.sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
    }

    private static class XlinkAttribute extends AttributedCharacterIterator.Attribute {
        XlinkAttribute(String str) {
            super(str);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        protected Object readResolve() throws InvalidObjectException {
            if (DrawTextParagraph.HYPERLINK_HREF.getName().equals(getName())) {
                return DrawTextParagraph.HYPERLINK_HREF;
            }
            if (DrawTextParagraph.HYPERLINK_LABEL.getName().equals(getName())) {
                return DrawTextParagraph.HYPERLINK_LABEL;
            }
            throw new InvalidObjectException("unknown attribute name");
        }
    }

    public DrawTextParagraph(TextParagraph<?, ?, ?> textParagraph) {
        this.paragraph = textParagraph;
    }

    public void setPosition(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public double getY() {
        return this.y;
    }

    public void setAutoNumberingIdx(int i) {
        this.autoNbrIdx = i;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:36:0x0106  */
    /* JADX WARN: Code duplicated, block: B:39:0x010b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0119  */
    /* JADX WARN: Code duplicated, block: B:43:0x0141  */
    /* JADX WARN: Code duplicated, block: B:44:0x0152  */
    @Override // org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        double d;
        double dDoubleValue;
        double width;
        Rectangle2D anchor;
        double d2;
        double d3;
        TextParagraph.TextAlign textAlign;
        int i;
        double dDoubleValue2;
        DrawTextParagraph drawTextParagraph = this;
        Graphics2D graphics2D2 = graphics2D;
        if (drawTextParagraph.lines.isEmpty()) {
            return;
        }
        double d4 = drawTextParagraph.y;
        int indentLevel = drawTextParagraph.paragraph.getIndentLevel();
        Double leftMargin = drawTextParagraph.paragraph.getLeftMargin();
        if (leftMargin == null) {
            leftMargin = Double.valueOf(Units.toPoints(((long) indentLevel) * 347663));
        }
        Double indent = drawTextParagraph.paragraph.getIndent();
        if (indent == null) {
            indent = Double.valueOf(Units.toPoints(((long) indentLevel) * 347663));
        }
        if (isHSLF()) {
            indent = Double.valueOf(indent.doubleValue() - leftMargin.doubleValue());
        }
        Double lineSpacing = drawTextParagraph.paragraph.getLineSpacing();
        if (lineSpacing == null) {
            lineSpacing = Double.valueOf(100.0d);
        }
        Iterator<DrawTextFragment> it = drawTextParagraph.lines.iterator();
        boolean z = true;
        while (it.hasNext()) {
            DrawTextFragment next = it.next();
            if (z) {
                if (!isEmptyParagraph()) {
                    drawTextParagraph.bullet = drawTextParagraph.getBullet(graphics2D2, next.getAttributedString().getIterator());
                }
                DrawTextFragment drawTextFragment = drawTextParagraph.bullet;
                if (drawTextFragment != null) {
                    drawTextFragment.setPosition(drawTextParagraph.x + leftMargin.doubleValue() + indent.doubleValue(), d4);
                    drawTextParagraph.bullet.draw(graphics2D2);
                    d4 = d4;
                    width = drawTextParagraph.x + Math.max(leftMargin.doubleValue(), leftMargin.doubleValue() + indent.doubleValue() + ((double) (drawTextParagraph.bullet.getLayout().getAdvance() + 1.0f)));
                } else {
                    d = drawTextParagraph.x;
                    dDoubleValue = leftMargin.doubleValue();
                }
                anchor = DrawShape.getAnchor(graphics2D2, drawTextParagraph.paragraph.getParentShape());
                Insets2D insets = drawTextParagraph.paragraph.getParentShape().getInsets();
                d2 = insets.left;
                Double d5 = indent;
                d3 = insets.right;
                textAlign = drawTextParagraph.paragraph.getTextAlign();
                if (textAlign == null) {
                    textAlign = TextParagraph.TextAlign.LEFT;
                }
                i = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TextParagraph$TextAlign[textAlign.ordinal()];
                Iterator<DrawTextFragment> it2 = it;
                if (i != 1) {
                    width += ((((anchor.getWidth() - ((double) next.getWidth())) - d2) - d3) - leftMargin.doubleValue()) / 2.0d;
                } else if (i == 2) {
                    width += ((anchor.getWidth() - ((double) next.getWidth())) - d2) - d3;
                }
                double d6 = d4;
                next.setPosition(width, d6);
                next.draw(graphics2D);
                if (lineSpacing.doubleValue() > 0.0d) {
                    dDoubleValue2 = lineSpacing.doubleValue() * 0.01d * ((double) next.getHeight());
                } else {
                    dDoubleValue2 = -lineSpacing.doubleValue();
                }
                d4 = d6 + dDoubleValue2;
                indent = d5;
                it = it2;
                z = false;
                graphics2D2 = graphics2D;
                drawTextParagraph = this;
            } else {
                d = drawTextParagraph.x;
                dDoubleValue = leftMargin.doubleValue();
            }
            width = d + dDoubleValue;
            anchor = DrawShape.getAnchor(graphics2D2, drawTextParagraph.paragraph.getParentShape());
            Insets2D insets2 = drawTextParagraph.paragraph.getParentShape().getInsets();
            d2 = insets2.left;
            Double d7 = indent;
            d3 = insets2.right;
            textAlign = drawTextParagraph.paragraph.getTextAlign();
            if (textAlign == null) {
                textAlign = TextParagraph.TextAlign.LEFT;
            }
            i = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TextParagraph$TextAlign[textAlign.ordinal()];
            Iterator<DrawTextFragment> it3 = it;
            if (i != 1) {
                width += ((((anchor.getWidth() - ((double) next.getWidth())) - d2) - d3) - leftMargin.doubleValue()) / 2.0d;
            } else if (i == 2) {
                width += ((anchor.getWidth() - ((double) next.getWidth())) - d2) - d3;
            }
            double d8 = d4;
            next.setPosition(width, d8);
            next.draw(graphics2D);
            if (lineSpacing.doubleValue() > 0.0d) {
                dDoubleValue2 = lineSpacing.doubleValue() * 0.01d * ((double) next.getHeight());
            } else {
                dDoubleValue2 = -lineSpacing.doubleValue();
            }
            d4 = d8 + dDoubleValue2;
            indent = d7;
            it = it3;
            z = false;
            graphics2D2 = graphics2D;
            drawTextParagraph = this;
        }
        DrawTextParagraph drawTextParagraph2 = drawTextParagraph;
        drawTextParagraph2.y = d4 - drawTextParagraph2.y;
    }

    public float getFirstLineLeading() {
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        return this.lines.get(0).getLeading();
    }

    public float getFirstLineHeight() {
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        return this.lines.get(0).getHeight();
    }

    public float getLastLineHeight() {
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        List<DrawTextFragment> list = this.lines;
        return list.get(list.size() - 1).getHeight();
    }

    public boolean isEmptyParagraph() {
        return this.lines.isEmpty() || this.rawText.trim().isEmpty();
    }

    protected void breakText(Graphics2D graphics2D) {
        int position;
        this.lines.clear();
        DrawFactory drawFactory = DrawFactory.getInstance(graphics2D);
        drawFactory.fixFonts(graphics2D);
        StringBuilder sb = new StringBuilder();
        AttributedString attributedString = getAttributedString(graphics2D, sb);
        boolean zEquals = "".equals(sb.toString().trim());
        AttributedCharacterIterator iterator = attributedString.getIterator();
        LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(iterator, graphics2D.getFontRenderContext());
        do {
            int position2 = lineBreakMeasurer.getPosition();
            double wrappingWidth = getWrappingWidth(this.lines.isEmpty(), graphics2D) + 1.0d;
            double d = wrappingWidth >= 0.0d ? wrappingWidth : 1.0d;
            int iIndexOf = sb.indexOf("\n", position2 + 1);
            if (iIndexOf == -1) {
                iIndexOf = iterator.getEndIndex();
            }
            float f = (float) d;
            TextLayout textLayoutNextLayout = lineBreakMeasurer.nextLayout(f, iIndexOf, true);
            if (textLayoutNextLayout == null) {
                textLayoutNextLayout = lineBreakMeasurer.nextLayout(f, iIndexOf, false);
            }
            if (textLayoutNextLayout == null) {
                break;
            }
            position = lineBreakMeasurer.getPosition();
            if (position < iterator.getEndIndex() && sb.charAt(position) == '\n') {
                lineBreakMeasurer.setPosition(position + 1);
            }
            TextParagraph.TextAlign textAlign = this.paragraph.getTextAlign();
            if (textAlign == TextParagraph.TextAlign.JUSTIFY || textAlign == TextParagraph.TextAlign.JUSTIFY_LOW) {
                textLayoutNextLayout = textLayoutNextLayout.getJustifiedLayout(f);
            }
            DrawTextFragment textFragment = drawFactory.getTextFragment(textLayoutNextLayout, zEquals ? null : new AttributedString(iterator, position2, position));
            this.lines.add(textFragment);
            this.maxLineHeight = Math.max(this.maxLineHeight, textFragment.getHeight());
        } while (position != iterator.getEndIndex());
        this.rawText = sb.toString();
    }

    protected DrawTextFragment getBullet(Graphics2D graphics2D, AttributedCharacterIterator attributedCharacterIterator) {
        String bulletCharacter;
        Paint paint;
        float fDoubleValue;
        TextParagraph.BulletStyle bulletStyle = this.paragraph.getBulletStyle();
        if (bulletStyle == null) {
            return null;
        }
        AutoNumberingScheme autoNumberingScheme = bulletStyle.getAutoNumberingScheme();
        if (autoNumberingScheme != null) {
            bulletCharacter = autoNumberingScheme.format(this.autoNbrIdx);
        } else {
            bulletCharacter = bulletStyle.getBulletCharacter();
        }
        if (bulletCharacter == null) {
            return null;
        }
        PlaceableShape<?, ?> paragraphShape = getParagraphShape();
        PaintStyle bulletFontColor = bulletStyle.getBulletFontColor();
        if (bulletFontColor == null) {
            paint = (Paint) attributedCharacterIterator.getAttribute(TextAttribute.FOREGROUND);
        } else {
            paint = new DrawPaint(paragraphShape).getPaint(graphics2D, bulletFontColor);
        }
        float fFloatValue = ((Float) attributedCharacterIterator.getAttribute(TextAttribute.SIZE)).floatValue();
        Double bulletFontSize = bulletStyle.getBulletFontSize();
        if (bulletFontSize == null) {
            bulletFontSize = Double.valueOf(100.0d);
        }
        if (bulletFontSize.doubleValue() > 0.0d) {
            fDoubleValue = (float) (((double) fFloatValue) * bulletFontSize.doubleValue() * 0.01d);
        } else {
            fDoubleValue = (float) (-bulletFontSize.doubleValue());
        }
        String bulletFont = bulletStyle.getBulletFont();
        if (bulletFont == null) {
            bulletFont = this.paragraph.getDefaultFontFamily();
        }
        DrawFontInfo drawFontInfo = new DrawFontInfo(bulletFont);
        DrawFontManager fontManager = DrawFactory.getInstance(graphics2D).getFontManager(graphics2D);
        FontInfo mappedFont = fontManager.getMappedFont(graphics2D, drawFontInfo);
        AttributedString attributedString = new AttributedString(fontManager.mapFontCharset(graphics2D, mappedFont, bulletCharacter));
        attributedString.addAttribute(TextAttribute.FOREGROUND, paint);
        attributedString.addAttribute(TextAttribute.FAMILY, mappedFont.getTypeface());
        attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf(fDoubleValue));
        return DrawFactory.getInstance(graphics2D).getTextFragment(new TextLayout(attributedString.getIterator(), graphics2D.getFontRenderContext()), attributedString);
    }

    protected String getRenderableText(Graphics2D graphics2D, TextRun textRun) {
        if (textRun.getFieldType() == TextRun.FieldType.SLIDE_NUMBER) {
            Slide slide = (Slide) graphics2D.getRenderingHint(Drawable.CURRENT_SLIDE);
            return slide == null ? "" : Integer.toString(slide.getSlideNumber());
        }
        StringBuilder sb = new StringBuilder();
        TextRun.TextCap textCap = textRun.getTextCap();
        String strTab2space = null;
        for (char upperCase : textRun.getRawText().toCharArray()) {
            if (upperCase == '\t') {
                if (strTab2space == null) {
                    strTab2space = tab2space(textRun);
                }
                sb.append(strTab2space);
            } else if (upperCase == 11) {
                sb.append('\n');
            } else {
                int i = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap[textCap.ordinal()];
                if (i == 1) {
                    upperCase = Character.toUpperCase(upperCase);
                } else if (i == 2) {
                    upperCase = Character.toLowerCase(upperCase);
                }
                sb.append(upperCase);
            }
        }
        return sb.toString();
    }

    private String tab2space(TextRun textRun) {
        AttributedString attributedString = new AttributedString(" ");
        String fontFamily = textRun.getFontFamily();
        if (fontFamily == null) {
            fontFamily = "Lucida Sans";
        }
        attributedString.addAttribute(TextAttribute.FAMILY, fontFamily);
        Double fontSize = textRun.getFontSize();
        if (fontSize == null) {
            fontSize = Double.valueOf(12.0d);
        }
        attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf(fontSize.floatValue()));
        double advance = new TextLayout(attributedString.getIterator(), new FontRenderContext((AffineTransform) null, true, true)).getAdvance();
        Double defaultTabSize = this.paragraph.getDefaultTabSize();
        if (defaultTabSize == null) {
            defaultTabSize = Double.valueOf(4.0d * advance);
        }
        int iCeil = (int) Math.ceil(defaultTabSize.doubleValue() / advance);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iCeil; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    protected double getWrappingWidth(boolean z, Graphics2D graphics2D) {
        double height;
        double dDoubleValue;
        double height2;
        double dDoubleValue2;
        TextShape<S, P> parentShape = this.paragraph.getParentShape();
        Insets2D insets = parentShape.getInsets();
        double d = insets.left;
        double d2 = insets.right;
        int indentLevel = this.paragraph.getIndentLevel();
        if (indentLevel == -1) {
            indentLevel = 0;
        }
        Double leftMargin = this.paragraph.getLeftMargin();
        if (leftMargin == null) {
            leftMargin = Double.valueOf(Units.toPoints(((long) (indentLevel + 1)) * 347663));
        }
        Double indent = this.paragraph.getIndent();
        if (indent == null) {
            indent = Double.valueOf(Units.toPoints(((long) indentLevel) * 347663));
        }
        Double rightMargin = this.paragraph.getRightMargin();
        if (rightMargin == null) {
            rightMargin = Double.valueOf(0.0d);
        }
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, parentShape);
        TextShape.TextDirection textDirection = parentShape.getTextDirection();
        if (!parentShape.getWordWrap()) {
            Dimension pageSize = parentShape.getSheet().getSlideShow().getPageSize();
            int i = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[textDirection.ordinal()];
            if (i == 1) {
                height2 = pageSize.getHeight();
                dDoubleValue2 = anchor.getX();
            } else if (i != 2) {
                height2 = pageSize.getWidth();
                dDoubleValue2 = anchor.getX();
            } else {
                return anchor.getX();
            }
        } else {
            int i2 = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[textDirection.ordinal()];
            if (i2 != 1 && i2 != 2) {
                height = ((anchor.getWidth() - d) - d2) - leftMargin.doubleValue();
                dDoubleValue = rightMargin.doubleValue();
            } else {
                height = ((anchor.getHeight() - d) - d2) - leftMargin.doubleValue();
                dDoubleValue = rightMargin.doubleValue();
            }
            height2 = height - dDoubleValue;
            if (!z || isHSLF()) {
                return height2;
            }
            if (this.bullet != null) {
                if (indent.doubleValue() <= 0.0d) {
                    return height2;
                }
                dDoubleValue2 = indent.doubleValue();
            } else {
                if (indent.doubleValue() <= 0.0d) {
                    return indent.doubleValue() < 0.0d ? height2 + leftMargin.doubleValue() : height2;
                }
                dDoubleValue2 = indent.doubleValue();
            }
        }
        return height2 - dDoubleValue2;
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawTextParagraph$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextParagraph$TextAlign;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection;

        static {
            int[] iArr = new int[TextShape.TextDirection.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection = iArr;
            try {
                iArr[TextShape.TextDirection.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[TextShape.TextDirection.VERTICAL_270.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[TextRun.TextCap.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap = iArr2;
            try {
                iArr2[TextRun.TextCap.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap[TextRun.TextCap.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap[TextRun.TextCap.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[TextParagraph.TextAlign.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextParagraph$TextAlign = iArr3;
            try {
                iArr3[TextParagraph.TextAlign.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextParagraph$TextAlign[TextParagraph.TextAlign.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class AttributedStringData {
        AttributedCharacterIterator.Attribute attribute;
        int beginIndex;
        int endIndex;
        Object value;

        AttributedStringData(AttributedCharacterIterator.Attribute attribute, Object obj, int i, int i2) {
            this.attribute = attribute;
            this.value = obj;
            this.beginIndex = i;
            this.endIndex = i2;
        }
    }

    private PlaceableShape<?, ?> getParagraphShape() {
        return new PlaceableShape() { // from class: org.apache.poi.sl.draw.DrawTextParagraph.1
            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public boolean getFlipHorizontal() {
                return false;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public boolean getFlipVertical() {
                return false;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public ShapeContainer<?, ?> getParent() {
                return null;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public double getRotation() {
                return 0.0d;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setAnchor(Rectangle2D rectangle2D) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setFlipHorizontal(boolean z) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setFlipVertical(boolean z) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setRotation(double d) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public Rectangle2D getAnchor() {
                return DrawTextParagraph.this.paragraph.getParentShape().getAnchor();
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public Sheet<?, ?> getSheet() {
                return DrawTextParagraph.this.paragraph.getParentShape().getSheet();
            }
        };
    }

    protected AttributedString getAttributedString(Graphics2D graphics2D, StringBuilder sb) {
        ArrayList arrayList = new ArrayList();
        if (sb == null) {
            sb = new StringBuilder();
        }
        PlaceableShape<?, ?> paragraphShape = getParagraphShape();
        DrawFontManager fontManager = DrawFactory.getInstance(graphics2D).getFontManager(graphics2D);
        Iterator<?> it = this.paragraph.iterator();
        while (it.hasNext()) {
            TextRun textRun = (TextRun) it.next();
            String renderableText = getRenderableText(graphics2D, textRun);
            if (!renderableText.isEmpty()) {
                String strMapFontCharset = fontManager.mapFontCharset(graphics2D, textRun.getFontInfo(null), renderableText);
                int length = sb.length();
                sb.append(strMapFontCharset);
                int length2 = sb.length();
                arrayList.add(new AttributedStringData(TextAttribute.FOREGROUND, new DrawPaint(paragraphShape).getPaint(graphics2D, textRun.getFontColor()), length, length2));
                Double fontSize = textRun.getFontSize();
                if (fontSize == null) {
                    fontSize = this.paragraph.getDefaultFontSize();
                }
                arrayList.add(new AttributedStringData(TextAttribute.SIZE, Float.valueOf(fontSize.floatValue()), length, length2));
                if (textRun.isBold()) {
                    arrayList.add(new AttributedStringData(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, length, length2));
                }
                if (textRun.isItalic()) {
                    arrayList.add(new AttributedStringData(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, length, length2));
                }
                if (textRun.isUnderlined()) {
                    arrayList.add(new AttributedStringData(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, length, length2));
                    arrayList.add(new AttributedStringData(TextAttribute.INPUT_METHOD_UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL, length, length2));
                }
                if (textRun.isStrikethrough()) {
                    arrayList.add(new AttributedStringData(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON, length, length2));
                }
                if (textRun.isSubscript()) {
                    arrayList.add(new AttributedStringData(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, length, length2));
                }
                if (textRun.isSuperscript()) {
                    arrayList.add(new AttributedStringData(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, length, length2));
                }
                Hyperlink<?, ?> hyperlink = textRun.getHyperlink();
                if (hyperlink != null) {
                    arrayList.add(new AttributedStringData(HYPERLINK_HREF, hyperlink.getAddress(), length, length2));
                    arrayList.add(new AttributedStringData(HYPERLINK_LABEL, hyperlink.getLabel(), length, length2));
                }
                processGlyphs(graphics2D, fontManager, arrayList, length, textRun, strMapFontCharset);
            }
        }
        if (sb.length() == 0) {
            Double defaultFontSize = this.paragraph.getDefaultFontSize();
            sb.append(" ");
            arrayList.add(new AttributedStringData(TextAttribute.SIZE, Float.valueOf(defaultFontSize.floatValue()), 0, 1));
        }
        AttributedString attributedString = new AttributedString(sb.toString());
        for (AttributedStringData attributedStringData : arrayList) {
            attributedString.addAttribute(attributedStringData.attribute, attributedStringData.value, attributedStringData.beginIndex, attributedStringData.endIndex);
        }
        return attributedString;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x013a  */
    private void processGlyphs(Graphics2D graphics2D, DrawFontManager drawFontManager, List<AttributedStringData> list, int i, TextRun textRun, String str) {
        int i2;
        int i3;
        int i4 = 0;
        for (FontGroup.FontGroupRange fontGroupRange : FontGroup.getFontGroupRanges(str)) {
            FontInfo fontInfo = textRun.getFontInfo(fontGroupRange.getFontGroup());
            if (fontInfo == null) {
                fontInfo = textRun.getFontInfo(FontGroup.LATIN);
            }
            FontInfo mappedFont = drawFontManager.getMappedFont(graphics2D, fontInfo);
            FontInfo fallbackFont = drawFontManager.getFallbackFont(graphics2D, fontInfo);
            if (mappedFont == null) {
                mappedFont = drawFontManager.getMappedFont(graphics2D, new DrawFontInfo(this.paragraph.getDefaultFontFamily()));
            }
            Font fontCreateAWTFont = drawFontManager.createAWTFont(graphics2D, mappedFont == null ? fallbackFont : mappedFont, 10.0d, textRun.isBold(), textRun.isItalic());
            Font fontCreateAWTFont2 = drawFontManager.createAWTFont(graphics2D, fallbackFont, 10.0d, textRun.isBold(), textRun.isItalic());
            int length = fontGroupRange.getLength();
            int iNextPart = i4;
            while (true) {
                i2 = i4 + length;
                if (iNextPart < i2) {
                    int iNextPart2 = nextPart(fontCreateAWTFont, str, iNextPart, i2, true);
                    if (iNextPart < iNextPart2) {
                        i3 = length;
                        int i5 = i + iNextPart;
                        int i6 = i + iNextPart2;
                        list.add(new AttributedStringData(TextAttribute.FAMILY, fontCreateAWTFont.getFontName(Locale.ROOT), i5, i6));
                        POILogger pOILogger = LOG;
                        if (pOILogger.check(1)) {
                            pOILogger.log(1, "mapped: ", fontCreateAWTFont.getFontName(Locale.ROOT), " ", Integer.valueOf(i5), " ", Integer.valueOf(i6), " - ", str.substring(i5, i6));
                        }
                    } else {
                        i3 = length;
                    }
                    iNextPart = nextPart(fontCreateAWTFont, str, iNextPart2, i2, false);
                    if (iNextPart2 < iNextPart) {
                        int i7 = i + iNextPart2;
                        int i8 = i + iNextPart;
                        list.add(new AttributedStringData(TextAttribute.FAMILY, fontCreateAWTFont2.getFontName(Locale.ROOT), i7, i8));
                        POILogger pOILogger2 = LOG;
                        if (pOILogger2.check(1)) {
                            pOILogger2.log(1, "fallback: ", fontCreateAWTFont2.getFontName(Locale.ROOT), " ", Integer.valueOf(i7), " ", Integer.valueOf(i8), " - ", str.substring(i7, i8));
                        }
                    }
                    length = i3;
                }
            }
            i4 = i2;
        }
    }

    private static int nextPart(Font font, String str, int i, int i2, boolean z) {
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (font.canDisplay(iCodePointAt) != z) {
                break;
            }
            i += Character.charCount(iCodePointAt);
        }
        return i;
    }

    protected boolean isHSLF() {
        return DrawShape.isHSLF(this.paragraph.getParentShape());
    }
}
