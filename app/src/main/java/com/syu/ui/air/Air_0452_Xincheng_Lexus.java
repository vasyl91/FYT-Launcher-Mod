package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0452_Xincheng_Lexus extends AirBase {
    public Air_0452_Xincheng_Lexus(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0040_xp1_golf7/air_rzc_gaoerfu7.webp";
        this.mPathHighlight = "0040_xp1_golf7/air_rzc_gaoerfu7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(746.0f, 15.0f, 868.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(465.0f, 32.0f, 563.0f, 75.0f, Region.Op.UNION);
        } else if (this.DATA[10] == 3) {
            c.clipRect(449.0f, 11.0f, 496.0f, 32.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0 || this.DATA[23] != 0) {
            c.clipRect(154.0f, 19.0f, 277.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(150.0f, 96.0f, 283.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(746.0f, 96.0f, 860.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0 || this.DATA[24] != 0) {
            c.clipRect(608.0f, 97.0f, 713.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(614.0f, 14.0f, 709.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(299.0f, 32.0f, 360.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(336.0f, 74.0f, 388.0f, 99.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(302.0f, 99.0f, 348.0f, 141.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(459.0f, 117.0f, (value * 15) + 459, 164.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(12.0f);
        if (this.DATA[23] != 0) {
            c.drawText("MAX", 179.0f, 25.0f, this.mPaint);
        }
        if (this.DATA[24] != 0) {
            c.drawText("MAX", 606.0f, 105.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[19];
        if (temp == -2) {
            c.drawText("Lo", 42.0f, 137.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 42.0f, 137.0f, this.mPaint);
        } else if (temp >= 1 && temp <= 33) {
            c.drawText(String.valueOf(((temp * 5) + 155) / 10.0f), 42.0f, 137.0f, this.mPaint);
        } else {
            c.drawText("None", 42.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[20];
        if (temp2 == -2) {
            c.drawText("Lo", 920.0f, 137.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 137.0f, this.mPaint);
        } else if (temp2 >= 1 && temp2 <= 33) {
            c.drawText(String.valueOf(((temp2 * 5) + 155) / 10.0f), 920.0f, 137.0f, this.mPaint);
        } else {
            c.drawText("None", 920.0f, 137.0f, this.mPaint);
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
