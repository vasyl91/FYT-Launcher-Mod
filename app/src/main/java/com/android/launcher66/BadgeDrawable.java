package com.android.launcher66;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * The badge of an icon: a small rounded rectangle with the number of notifications, in a corner of the icon's rectangle (the
 * bounds of this drawable). The size, the corner, the radius and the colours are {@link BadgeStyle}'s, the sizes and the place
 * are {@link BadgeGeometry}'s, the text is {@link BadgeCounts#label}. It draws nothing for no notifications, and nothing while
 * the badges are off. One drawable serves one icon view: the view sets the count, the style and the colour of the number (the
 * colour of the icon's own text: the home screen's, the drawer's) and draws it over its content (or adds it to its overlay).
 * Main thread.
 */
final class BadgeDrawable extends Drawable {

    private final float mDensity;
    private final Paint mFill = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mText = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF mRect = new RectF();
    private int mCount;
    private BadgeStyle mStyle;
    private int mTextColor = 0xffffffff;

    BadgeDrawable(Context context) {
        mDensity = context.getResources().getDisplayMetrics().density;
        mFill.setStyle(Paint.Style.FILL);
        mStroke.setStyle(Paint.Style.STROKE);
        mStroke.setStrokeWidth(mDensity);   // 1 dp
        mText.setTextAlign(Paint.Align.CENTER);
        mText.setFakeBoldText(true);
    }

    /** The number, the look and the colour of the number; true when anything changed. */
    boolean set(int count, BadgeStyle style, int textColor) {
        if (count == mCount && style == mStyle && textColor == mTextColor) {
            return false;
        }
        mCount = count;
        mStyle = style;
        mTextColor = textColor;
        invalidateSelf();
        return true;
    }

    /** Whether it draws anything now. */
    boolean isShown() {
        return mCount > 0 && mStyle != null && mStyle.enabled && !getBounds().isEmpty();
    }

    /**
     * The rectangle {left, top, right, bottom} of the badge for the number and the bounds it has, or null when it draws
     * nothing (the text width is measured with the paint of the drawable's own text size).
     */
    float[] badgeRect() {
        if (!isShown()) {
            return null;
        }
        float height = BadgeGeometry.height(mStyle.size, getBounds().height());
        mText.setTextSize(height * 0.62f);
        float width = BadgeGeometry.width(height, mText.measureText(BadgeCounts.label(mCount)), height * 0.3f);
        return BadgeGeometry.place(mStyle.position, getBounds().left, getBounds().top, getBounds().right,
                getBounds().bottom, width, height);
    }

    @Override
    public void draw(Canvas canvas) {
        float[] r = badgeRect();
        if (r == null) {
            return;
        }
        float height = r[3] - r[1];
        float radius = BadgeGeometry.radius(mStyle.corner, height);
        mRect.set(r[0], r[1], r[2], r[3]);
        mFill.setColor(mStyle.color);
        canvas.drawRoundRect(mRect, radius, radius, mFill);
        if (mStyle.outline) {
            mStroke.setColor(mTextColor);
            canvas.drawRoundRect(mRect, radius, radius, mStroke);
        }
        mText.setColor(mTextColor);
        mText.setTextSize(height * 0.62f);
        Paint.FontMetrics metrics = mText.getFontMetrics();
        canvas.drawText(BadgeCounts.label(mCount), mRect.centerX(), mRect.centerY() - (metrics.ascent + metrics.descent) / 2f, mText);
    }

    @Override
    public void setAlpha(int alpha) {
        mFill.setAlpha(alpha);
        mText.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mFill.setColorFilter(colorFilter);
        mText.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
