package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0176_RZC_DongNanV5 extends AirBase {
    public Air_0176_RZC_DongNanV5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0176_rzc_dongnanv5/Air_dongnan_V5.webp";
        this.mPathHighlight = "0176_rzc_dongnanv5/Air_dongnan_V5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[18] != 0) {
            c.clipRect(21.0f, 19.0f, 155.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(216.0f, 29.0f, 312.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(540.0f, 86.0f, 604.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(536.0f, 109.0f, 582.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[11] == 0) {
            c.clipRect(366.0f, 14.0f, 504.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(872.0f, 31.0f, 998.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(539.0f, 17.0f, 612.0f, 86.0f, Region.Op.UNION);
        }
        int value = this.DATA[19];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(699.0f, 42.0f, (value * 18) + 699, 158.0f, Region.Op.UNION);
        int value2 = this.DATA[14];
        if (value2 < 15) {
            c.clipRect(74.0f, 94.0f, ((value2 / 2) * 24) + 74, 163.0f, Region.Op.UNION);
        } else {
            c.clipRect(247.0f, 104.0f, ((((value2 + 1) - 14) / 2) * 24) + 247, 158.0f, Region.Op.UNION);
        }
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
