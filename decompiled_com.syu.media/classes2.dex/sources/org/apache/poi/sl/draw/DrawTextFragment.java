package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawTextFragment implements Drawable {
    final TextLayout layout;
    final AttributedString str;
    double x;
    double y;

    @Override // org.apache.poi.sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
    }

    public DrawTextFragment(TextLayout textLayout, AttributedString attributedString) {
        this.layout = textLayout;
        this.str = attributedString;
    }

    public void setPosition(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        if (this.str == null) {
            return;
        }
        double ascent = this.y + ((double) this.layout.getAscent());
        Integer num = (Integer) graphics2D.getRenderingHint(Drawable.TEXT_RENDERING_MODE);
        if (num != null && num.intValue() == 2) {
            this.layout.draw(graphics2D, (float) this.x, (float) ascent);
        } else {
            graphics2D.drawString(this.str.getIterator(), (float) this.x, (float) ascent);
        }
    }

    public TextLayout getLayout() {
        return this.layout;
    }

    public AttributedString getAttributedString() {
        return this.str;
    }

    public float getHeight() {
        return this.layout.getAscent() + this.layout.getDescent() + getLeading();
    }

    public float getLeading() {
        double leading = this.layout.getLeading();
        if (leading == 0.0d) {
            leading = ((double) (this.layout.getAscent() + this.layout.getDescent())) * 0.15d;
        }
        return (float) leading;
    }

    public float getWidth() {
        return this.layout.getAdvance();
    }

    public String getString() {
        AttributedString attributedString = this.str;
        if (attributedString == null) {
            return "";
        }
        AttributedCharacterIterator iterator = attributedString.getIterator();
        StringBuilder sb = new StringBuilder();
        for (char cFirst = iterator.first(); cFirst != 65535; cFirst = iterator.next()) {
            sb.append(cFirst);
        }
        return sb.toString();
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + getString();
    }
}
