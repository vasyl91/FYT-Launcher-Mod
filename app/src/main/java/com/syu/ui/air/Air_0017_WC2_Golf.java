package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0017_WC2_Golf extends AirBase {
    public Air_0017_WC2_Golf(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0017_wc2_golf7/air_wc2_gaoerfu7.webp";
        this.mPathHighlight = "0017_wc2_golf7/air_wc2_gaoerfu7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[89] != 0) {
            c.clipRect(706.0f, 95.0f, 796.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(188.0f, 98.0f, 332.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(188.0f, 23.0f, 326.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[90] != 0) {
            c.clipRect(709.0f, 23.0f, 821.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[94] != 0) {
            c.clipRect(563.0f, 11.0f, 657.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[95] != 0) {
            c.clipRect(567.0f, 100.0f, 620.0f, 130.0f, Region.Op.UNION);
        }
        if (this.DATA[96] != 0) {
            c.clipRect(543.0f, 128.0f, 584.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[77] == 1) {
            c.clipRect(110.0f, 108.0f, 156.0f, 161.0f, Region.Op.UNION);
            c.clipRect(975.0f, 106.0f, 1020.0f, 163.0f, Region.Op.UNION);
        }
        int value = this.DATA[97];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(370.0f, 69.0f, (value * 20) + 370, 131.0f, Region.Op.UNION);
        int value2 = this.DATA[92];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(76.0f, 48.0f, (value2 * 20) + 76, 75.0f, Region.Op.UNION);
        int value3 = this.DATA[93];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(951 - (value3 * 20), 45.0f, 951.0f, 78.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[98];
        if (temp == 254) {
            c.drawText("LOW", 62.0f, 137.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 62.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp * 5) / 10.0f), 62.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[99];
        if (temp2 == 254) {
            c.drawText("LOW", 920.0f, 137.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HI", 920.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp2 * 5) / 10.0f), 920.0f, 137.0f, this.mPaint);
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
