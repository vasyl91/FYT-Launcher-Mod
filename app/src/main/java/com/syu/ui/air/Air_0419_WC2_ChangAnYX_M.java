package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0419_WC2_ChangAnYX_M extends AirBase {
    public Air_0419_WC2_ChangAnYX_M(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0419_wc2_guochan2/air_wc2_changanyx_m.webp";
        this.mPathHighlight = "0419_wc2_guochan2/air_wc2_changanyx_m_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(185.0f, 61.0f, 333.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(712.0f, 15.0f, 790.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(42.0f, 59.0f, 126.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(551.0f, 36.0f, 651.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(365.0f, 37.0f, 491.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(723.0f, 82.0f, 784.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(711.0f, 107.0f, 751.0f, 146.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value > 8) {
            value = 8;
        }
        c.clipRect(858.0f, 74.0f, (value * 18) + 858, 137.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
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
