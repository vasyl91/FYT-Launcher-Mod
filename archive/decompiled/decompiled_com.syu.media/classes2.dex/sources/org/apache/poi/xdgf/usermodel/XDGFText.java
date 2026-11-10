package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.TextType;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFText {
    XDGFShape _parent;
    TextType _text;

    public XDGFText(TextType textType, XDGFShape xDGFShape) {
        this._text = textType;
        this._parent = xDGFShape;
    }

    @Internal
    TextType getXmlObject() {
        return this._text;
    }

    public String getTextContent() {
        return this._text.getStringValue();
    }

    public Rectangle2D.Double getTextBounds() {
        double dDoubleValue = this._parent.getTxtPinX().doubleValue();
        double dDoubleValue2 = this._parent.getTxtPinY().doubleValue();
        double dDoubleValue3 = this._parent.getTxtLocPinX().doubleValue();
        return new Rectangle2D.Double(dDoubleValue - dDoubleValue3, dDoubleValue2 - this._parent.getTxtLocPinY().doubleValue(), this._parent.getTxtWidth().doubleValue(), this._parent.getTxtHeight().doubleValue());
    }

    public Path2D.Double getBoundsAsPath() {
        Rectangle2D.Double textBounds = getTextBounds();
        Double dValueOf = Double.valueOf(textBounds.getWidth());
        Double dValueOf2 = Double.valueOf(textBounds.getHeight());
        Path2D.Double r2 = new Path2D.Double();
        r2.moveTo(0.0d, 0.0d);
        r2.lineTo(dValueOf.doubleValue(), 0.0d);
        r2.lineTo(dValueOf.doubleValue(), dValueOf2.doubleValue());
        r2.lineTo(0.0d, dValueOf2.doubleValue());
        r2.lineTo(0.0d, 0.0d);
        return r2;
    }

    public Point2D.Double getTextCenter() {
        return new Point2D.Double(this._parent.getTxtLocPinX().doubleValue(), this._parent.getTxtLocPinY().doubleValue());
    }

    public void draw(Graphics2D graphics2D) {
        double d;
        Font font;
        String textContent = getTextContent();
        if (textContent.length() == 0) {
            return;
        }
        Rectangle2D.Double textBounds = getTextBounds();
        String[] strArrSplit = textContent.trim().split("\n");
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        Font font2 = graphics2D.getFont();
        AffineTransform transform = graphics2D.getTransform();
        Boolean flipX = this._parent.getFlipX();
        if (this._parent.getFlipY() == null || !this._parent.getFlipY().booleanValue()) {
            graphics2D.translate(textBounds.x, textBounds.y);
            graphics2D.scale(1.0d, -1.0d);
            d = 0.0d;
            graphics2D.translate(0.0d, (-textBounds.height) + graphics2D.getFontMetrics().getMaxCharBounds(graphics2D).getHeight());
        } else {
            d = 0.0d;
        }
        if (flipX != null && this._parent.getFlipX().booleanValue()) {
            graphics2D.scale(-1.0d, 1.0d);
            graphics2D.translate(-textBounds.width, d);
        }
        Double txtAngle = this._parent.getTxtAngle();
        if (txtAngle != null && Math.abs(txtAngle.doubleValue()) > 0.01d) {
            graphics2D.rotate(txtAngle.doubleValue());
        }
        int length = strArrSplit.length;
        float f = 0.0f;
        int i = 0;
        float ascent = 0.0f;
        while (i < length) {
            String str = strArrSplit[i];
            if (str.length() == 0) {
                transform = transform;
                font = font2;
            } else {
                font = font2;
                TextLayout textLayout = new TextLayout(str, font, fontRenderContext);
                if (textLayout.isLeftToRight()) {
                    textLayout.draw(graphics2D, f, ascent);
                } else {
                    textLayout.draw(graphics2D, (float) (textBounds.width - ((double) textLayout.getAdvance())), ascent);
                }
                ascent += textLayout.getAscent() + textLayout.getDescent() + textLayout.getLeading();
            }
            i++;
            font2 = font;
            transform = transform;
            f = 0.0f;
        }
        graphics2D.setTransform(transform);
    }
}
