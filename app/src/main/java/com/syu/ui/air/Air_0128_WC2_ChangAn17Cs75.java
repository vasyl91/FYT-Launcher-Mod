package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class Air_0128_WC2_ChangAn17Cs75 extends AirBase {
    public Air_0128_WC2_ChangAn17Cs75(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0070_rzc_xp1_changancs75/rzc_17cs75.webp";
        this.mPathHighlight = "0070_rzc_xp1_changancs75/rzc_17cs75_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(36.0f, 100.0f, 146.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(69.0f, 32.0f, 134.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(9.0f, 14.0f, 69.0f, 42.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(350.0f, 46.0f, 504.0f, 127.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(202.0f, 13.0f, 317.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(215.0f, 89.0f, 306.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(549.0f, 22.0f, 629.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(556.0f, 90.0f, 613.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(548.0f, 112.0f, 591.0f, 146.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(711.0f, 71.0f, (value * 16) + 711, 137.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[4];
        if (temp == -2) {
            c.drawText("LOW", 927.0f, 84.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 927.0f, 84.0f, this.mPaint);
        } else if (327808 == DataCanbus.DATA[1000] || 458880 == DataCanbus.DATA[1000] || 589952 == DataCanbus.DATA[1000] || 524416 == DataCanbus.DATA[1000]) {
            c.drawText(String.valueOf((temp + 15) * 0.5f), 927.0f, 84.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp * 0.5f), 927.0f, 84.0f, this.mPaint);
        }
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
