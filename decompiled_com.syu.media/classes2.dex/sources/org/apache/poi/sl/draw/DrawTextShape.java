package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.sl.usermodel.VerticalAlignment;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawTextShape extends DrawSimpleShape {
    public DrawTextShape(TextShape<?, ?> textShape) {
        super(textShape);
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
        double height;
        double height2;
        DrawFactory.getInstance(graphics2D).fixFonts(graphics2D);
        TextShape<?, ? extends TextParagraph<?, ?, ? extends TextRun>> shape = getShape();
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, shape);
        Insets2D insets = shape.getInsets();
        double x = anchor.getX() + insets.left;
        double y = anchor.getY();
        AffineTransform transform = graphics2D.getTransform();
        boolean flipVertical = shape.getFlipVertical();
        boolean flipHorizontal = shape.getFlipHorizontal();
        ShapeContainer<?, ? extends TextParagraph<?, ?, ? extends TextRun>> parent = shape.getParent();
        while (parent instanceof PlaceableShape) {
            PlaceableShape placeableShape = (PlaceableShape) parent;
            flipVertical ^= placeableShape.getFlipVertical();
            flipHorizontal ^= placeableShape.getFlipHorizontal();
            parent = placeableShape.getParent();
        }
        if (flipVertical ^ flipHorizontal) {
            double x2 = anchor.getX();
            double y2 = anchor.getY();
            graphics2D.translate(anchor.getWidth() + x2, y2);
            graphics2D.scale(-1.0d, 1.0d);
            graphics2D.translate(-x2, -y2);
        }
        Double textRotation = shape.getTextRotation();
        if (textRotation != null && textRotation.doubleValue() != 0.0d) {
            double centerX = anchor.getCenterX();
            double centerY = anchor.getCenterY();
            graphics2D.translate(centerX, centerY);
            graphics2D.rotate(Math.toRadians(textRotation.doubleValue()));
            graphics2D.translate(-centerX, -centerY);
        }
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment[shape.getVerticalAlignment().ordinal()];
        if (i != 2) {
            if (i != 3) {
                height2 = insets.top;
            } else {
                height2 = insets.top + ((((anchor.getHeight() - getTextHeight(graphics2D)) - insets.top) - insets.bottom) / 2.0d);
            }
            height = y + height2;
        } else {
            height = y + ((anchor.getHeight() - getTextHeight(graphics2D)) - insets.bottom);
        }
        double d = height;
        TextShape.TextDirection textDirection = shape.getTextDirection();
        if (textDirection == TextShape.TextDirection.VERTICAL || textDirection == TextShape.TextDirection.VERTICAL_270) {
            double d2 = textDirection == TextShape.TextDirection.VERTICAL ? 90.0d : 270.0d;
            double centerX2 = anchor.getCenterX();
            double centerY2 = anchor.getCenterY();
            graphics2D.translate(centerX2, centerY2);
            graphics2D.rotate(Math.toRadians(d2));
            graphics2D.translate(-centerX2, -centerY2);
            double width = (anchor.getWidth() - anchor.getHeight()) / 2.0d;
            graphics2D.translate(width, -width);
        }
        drawParagraphs(graphics2D, x, d);
        graphics2D.setTransform(transform);
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawTextShape$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment;

        static {
            int[] iArr = new int[VerticalAlignment.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment = iArr;
            try {
                iArr[VerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment[VerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment[VerticalAlignment.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public double drawParagraphs(Graphics2D graphics2D, double d, double d2) {
        double dDoubleValue;
        double dDoubleValue2;
        DrawFactory drawFactory = DrawFactory.getInstance(graphics2D);
        Iterator<? extends TextParagraph<?, ?, ? extends TextRun>> it = getShape().iterator();
        int i = 1;
        double y = d2;
        boolean z = true;
        int iIntValue = 0;
        while (it.hasNext()) {
            TextParagraph<?, ?, ? extends TextRun> next = it.next();
            DrawTextParagraph drawable = drawFactory.getDrawable(next);
            TextParagraph.BulletStyle bulletStyle = next.getBulletStyle();
            if (bulletStyle == null || bulletStyle.getAutoNumberingScheme() == null) {
                iIntValue = -1;
            } else {
                Integer autoNumberingStartAt = bulletStyle.getAutoNumberingStartAt();
                if (autoNumberingStartAt == null) {
                    autoNumberingStartAt = Integer.valueOf(i);
                }
                if (autoNumberingStartAt.intValue() > iIntValue) {
                    iIntValue = autoNumberingStartAt.intValue();
                }
            }
            drawable.setAutoNumberingIdx(iIntValue);
            drawable.breakText(graphics2D);
            if (z) {
                dDoubleValue = drawable.getFirstLineLeading();
            } else {
                Double spaceBefore = next.getSpaceBefore();
                if (spaceBefore == null) {
                    spaceBefore = Double.valueOf(0.0d);
                }
                if (spaceBefore.doubleValue() > 0.0d) {
                    dDoubleValue = spaceBefore.doubleValue() * 0.01d * ((double) drawable.getFirstLineHeight());
                } else {
                    dDoubleValue = -spaceBefore.doubleValue();
                }
            }
            double d3 = y + dDoubleValue;
            drawable.setPosition(d, d3);
            drawable.draw(graphics2D);
            y = d3 + drawable.getY();
            if (it.hasNext()) {
                Double spaceAfter = next.getSpaceAfter();
                if (spaceAfter == null) {
                    spaceAfter = Double.valueOf(0.0d);
                }
                if (spaceAfter.doubleValue() > 0.0d) {
                    dDoubleValue2 = spaceAfter.doubleValue() * 0.01d * ((double) drawable.getLastLineHeight());
                } else {
                    dDoubleValue2 = -spaceAfter.doubleValue();
                }
                y += dDoubleValue2;
            }
            iIntValue++;
            i = 1;
            z = false;
        }
        return y - d2;
    }

    public double getTextHeight() {
        return getTextHeight(null);
    }

    public double getTextHeight(Graphics2D graphics2D) {
        Graphics2D graphics2DCreateGraphics = new BufferedImage(1, 1, 1).createGraphics();
        if (graphics2D != null) {
            graphics2DCreateGraphics.addRenderingHints(graphics2D.getRenderingHints());
            graphics2DCreateGraphics.setTransform(graphics2D.getTransform());
        }
        DrawFactory.getInstance(graphics2DCreateGraphics).fixFonts(graphics2DCreateGraphics);
        return drawParagraphs(graphics2DCreateGraphics, 0.0d, 0.0d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.poi.sl.draw.DrawSimpleShape, org.apache.poi.sl.draw.DrawShape
    public TextShape<?, ? extends TextParagraph<?, ?, ? extends TextRun>> getShape() {
        return (TextShape) this.shape;
    }
}
