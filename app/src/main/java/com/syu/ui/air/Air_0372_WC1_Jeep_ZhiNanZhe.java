package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0372_WC1_Jeep_ZhiNanZhe extends AirBase {
    public Air_0372_WC1_Jeep_ZhiNanZhe(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0372_wc1_jeep_ziyouguang/372_wc_zhinanzhe.webp";
        this.mPathHighlight = "0372_wc1_jeep_ziyouguang/372_wc_zhinanzhe_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String strVal;
        String strVal2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[72] != 0) {
            c.clipRect(186.0f, 18.0f, 326.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[58] != 0) {
            c.clipRect(364.0f, 24.0f, 494.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[62] != 0) {
            c.clipRect(39.0f, 16.0f, 152.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[67] != 0) {
            c.clipRect(527.0f, 101.0f, 664.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[60] != 0) {
            c.clipRect(720.0f, 13.0f, 812.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[61] != 0) {
            c.clipRect(890.0f, 14.0f, 984.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[76] != 0) {
            c.clipRect(358.0f, 100.0f, 489.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(557.0f, 5.0f, 613.0f, 42.0f, Region.Op.UNION);
        }
        if (this.DATA[64] != 0) {
            c.clipRect(572.0f, 46.0f, 611.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(563.0f, 60.0f, 587.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[59] != 1) {
            c.clipRect(184.0f, 93.0f, 320.0f, 157.0f, Region.Op.UNION);
        }
        int value = this.DATA[68];
        if (value >= 0 && value <= 7) {
            c.clipRect(717.0f, 102.0f, (value * 18) + 717, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[92] == 2) {
            c.clipRect(117.0f, 99.0f, 163.0f, 164.0f, Region.Op.UNION);
            c.clipRect(976.0f, 102.0f, 1016.0f, 164.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[63];
        if (temp == -2) {
            c.drawText("LOW", 70.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 140.0f, this.mPaint);
        } else if (temp / 10 >= 16 && temp / 10 <= 28) {
            if (this.DATA[92] == 2) {
                strVal = String.valueOf(((temp * 9) / 50.0f) + 32.0f);
            } else {
                strVal = String.valueOf(temp / 10.0f);
            }
            c.drawText(strVal, 70.0f, 140.0f, this.mPaint);
        } else {
            c.drawText("NONE", 70.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[71];
        if (temp2 == -2) {
            c.drawText("LOW", 931.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 931.0f, 140.0f, this.mPaint);
        } else if (temp2 / 10 >= 16 && temp2 / 10 <= 28) {
            if (this.DATA[92] == 2) {
                strVal2 = String.valueOf(((temp2 * 9) / 50.0f) + 32.0f);
            } else {
                strVal2 = String.valueOf(temp2 / 10.0f);
            }
            c.drawText(strVal2, 931.0f, 140.0f, this.mPaint);
        } else {
            c.drawText("NONE", 931.0f, 140.0f, this.mPaint);
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
