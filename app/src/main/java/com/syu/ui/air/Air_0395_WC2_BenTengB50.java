package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0395_WC2_BenTengB50 extends AirBase {
    public Air_0395_WC2_BenTengB50(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_beiteng_b50.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_beiteng_b50_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[37] != 0) {
            c.clipRect(538.0f, 19.0f, 619.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(44.0f, 20.0f, 138.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(206.0f, 13.0f, 312.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(888.0f, 35.0f, 996.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(545.0f, 88.0f, 604.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(538.0f, 109.0f, 584.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(359.0f, 13.0f, 497.0f, 75.0f, Region.Op.UNION);
        }
        c.clipRect(709.0f, 54.0f, (this.DATA[39] * 18) + 709, 123.0f, Region.Op.UNION);
        int value = this.DATA[40] / 5;
        if (value < 0) {
            value = 0;
        } else if (value > 17) {
            value = 17;
        }
        c.clipRect(63.0f, 91.0f, (value * 23) + 63, 158.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
