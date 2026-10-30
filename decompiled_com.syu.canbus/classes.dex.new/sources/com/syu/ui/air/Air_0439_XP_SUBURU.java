package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_XP_SUBURU extends AirBase {
    public Air_0439_XP_SUBURU(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0372_wc1_jeep_ziyouguang/372_wc_zhinanzhe.webp";
        this.mPathHighlight = "0372_wc1_jeep_ziyouguang/372_wc_zhinanzhe_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String strVal;
        String strVal2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(186.0f, 18.0f, 326.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(364.0f, 24.0f, 494.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(39.0f, 16.0f, 152.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(527.0f, 101.0f, 664.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(720.0f, 13.0f, 812.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(890.0f, 14.0f, 984.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(358.0f, 100.0f, 489.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(557.0f, 5.0f, 613.0f, 42.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(572.0f, 46.0f, 611.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(563.0f, 60.0f, 587.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(184.0f, 93.0f, 320.0f, 157.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value >= 0 && value <= 7) {
            this.srPath.addRect(717.0f, 102.0f, (value * 18) + 717, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(117.0f, 99.0f, 163.0f, 164.0f, Path.Direction.CW);
            this.srPath.addRect(976.0f, 102.0f, 1016.0f, 164.0f, Path.Direction.CW);
        }
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LO", 70.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 140.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            if (this.DATA[37] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                strVal = new StringBuilder().append(((temp2 * 9) / 50.0f) + 32.0f).toString();
            } else {
                strVal = new StringBuilder().append(temp2 / 10.0f).toString();
            }
            c.drawText(strVal, 70.0f, 140.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == -2) {
            c.drawText("LO", 920.0f, 140.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 920.0f, 140.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            if (this.DATA[37] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                strVal2 = new StringBuilder().append(((temp4 * 9) / 50.0f) + 32.0f).toString();
            } else {
                strVal2 = new StringBuilder().append(temp4 / 10.0f).toString();
            }
            c.drawText(strVal2, 920.0f, 140.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
