package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0376_SBD_RuiFengS5 extends AirBase {
    public Air_0376_SBD_RuiFengS5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0376_sbd_ruifeng_s5/air_sbd_ruifeng_s5_n.webp";
        this.mPathHighlight = "0376_sbd_ruifeng_s5/air_sbd_ruifeng_s5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(808.0f, 55.0f, 987.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(586.0f, 55.0f, 690.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(96.0f, 138.0f, 166.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(75.0f, 13.0f, 157.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(91.0f, 71.0f, 143.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(79.0f, 97.0f, 132.0f, 137.0f, Region.Op.UNION);
        }
        int value = this.DATA[13];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(307.0f, 66.0f, 307.0f + (value * 24.6f), 152.0f, Region.Op.UNION);
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
