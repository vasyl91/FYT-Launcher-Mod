package com.syu.ui.benzair;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.syu.util.ToolkitRes;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_RZC_23Yage extends Air_BenzBase {
    public Air_RZC_23Yage(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathHighlight1 = "0450_benz_air/rzc_23yage_highlight1.png";
        this.mPathHighlight2 = "0450_benz_air/rzc_23yage_highlight2.png";
        this.mDrawableHighlight1 = ToolkitRes.loadDrawable(this.mPathHighlight1);
        this.mDrawableHighlight2 = ToolkitRes.loadDrawable(this.mPathHighlight2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[256] == 1) {
            c.clipRect(23.0f, 6.0f, 113.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 2) {
            c.clipRect(157.0f, 86.0f, 251.0f, 166.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 3) {
            c.clipRect(160.0f, 5.0f, 254.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 4) {
            c.clipRect(434.0f, 5.0f, 519.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 5) {
            c.clipRect(912.0f, 29.0f, 1020.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 6) {
            c.clipRect(297.0f, 6.0f, 391.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 7) {
            c.clipRect(295.0f, 88.0f, 382.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 8) {
            c.clipRect(28.0f, 86.0f, 110.0f, 167.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 9) {
            c.clipRect(431.0f, 88.0f, 527.0f, 168.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 10) {
            c.clipRect(550.0f, 23.0f, 664.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 11) {
            c.clipRect(671.0f, 29.0f, 780.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[256] == 12) {
            c.clipRect(791.0f, 29.0f, 900.0f, 143.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight2.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableHighlight1.draw(c);
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
