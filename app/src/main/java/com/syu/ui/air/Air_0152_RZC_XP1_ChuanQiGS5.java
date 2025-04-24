package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0152_RZC_XP1_ChuanQiGS5 extends AirBase {
    public Air_0152_RZC_XP1_ChuanQiGS5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0152_rzc_xp1_chuanqigs5/air_rzc_xp1_chuanqi_gs5_n.webp";
        this.mPathHighlight = "0152_rzc_xp1_chuanqigs5/air_rzc_xp1_chuanqi_gs5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[2] == 0) {
            c.clipRect(352.0f, 49.0f, 479.0f, 116.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(194.0f, 12.0f, 316.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(201.0f, 91.0f, 311.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(700.0f, 56.0f, 792.0f, 116.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(545.0f, 73.0f, 607.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(516.0f, 100.0f, 565.0f, 142.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(863.0f, 76.0f, (value * 20) + 863, 133.0f, Region.Op.UNION);
        int temp = this.DATA[6];
        if (temp < 0) {
            temp = 0;
        } else if (temp > 7) {
            temp = 7;
        }
        c.clipRect(20.0f, 68.0f, (temp * 20) + 20, 125.0f, Region.Op.UNION);
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
