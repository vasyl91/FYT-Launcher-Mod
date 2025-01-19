package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0070_RZC_XP1_CHANGANCS75 extends AirBase {
    public Air_0070_RZC_XP1_CHANGANCS75(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0070_rzc_xp1_changancs75/air_rzc_changan_cs75.webp";
        this.mPathHighlight = "0070_rzc_xp1_changancs75/air_rzc_changan_cs75_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[9] != 0) {
            c.clipRect(32.0f, 51.0f, 136.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[6] == 0) {
            c.clipRect(172.0f, 39.0f, 316.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(360.0f, 14.0f, 470.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(545.0f, 10.0f, 653.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(729.0f, 81.0f, 792.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(714.0f, 106.0f, 763.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(713.0f, 17.0f, 805.0f, 77.0f, Region.Op.UNION);
        }
        int temp = this.DATA[10];
        if (temp <= 0) {
            temp = 0;
        } else if (temp > 16) {
            temp = 16;
        }
        c.clipRect(337.0f, 90.0f, (temp * 22) + 337, 164.0f, Region.Op.UNION);
        int value = this.DATA[14];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(866.0f, 62.0f, (value * 19) + 866, 130.0f, Region.Op.UNION);
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
