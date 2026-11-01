package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_Xincheng_Lexus extends AirBase {
    public Air_0452_Xincheng_Lexus(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0040_xp1_golf7/air_rzc_gaoerfu7.webp";
        this.mPathHighlight = "0040_xp1_golf7/air_rzc_gaoerfu7_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[13] != 0) {
            this.srPath.addRect(746.0f, 15.0f, 868.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(465.0f, 32.0f, 563.0f, 75.0f, Path.Direction.CW);
        } else if (this.DATA[12] == 3) {
            this.srPath.addRect(449.0f, 11.0f, 496.0f, 32.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0 || this.DATA[53] != 0) {
            this.srPath.addRect(154.0f, 19.0f, 277.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[21] != 0) {
            this.srPath.addRect(150.0f, 96.0f, 283.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(746.0f, 96.0f, 860.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0 || this.DATA[15] != 0) {
            this.srPath.addRect(608.0f, 97.0f, 713.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(614.0f, 14.0f, 709.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(299.0f, 32.0f, 360.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(336.0f, 74.0f, 388.0f, 99.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(302.0f, 99.0f, 348.0f, 141.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(459.0f, 117.0f, (value * 15) + 459, 164.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(12.0f);
        if (this.DATA[53] != 0) {
            c.drawText("MAX", 179.0f, 25.0f, this.mPaint);
        }
        if (this.DATA[15] != 0) {
            c.drawText("MAX", 606.0f, 105.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("Lo", 42.0f, 137.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 42.0f, 137.0f, this.mPaint);
        } else if (temp >= 1 && temp <= 33) {
            c.drawText(new StringBuilder().append(((temp * 5) + 155) / 10.0f).toString(), 42.0f, 137.0f, this.mPaint);
        } else {
            c.drawText("None", 42.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("Lo", 920.0f, 137.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 137.0f, this.mPaint);
        } else if (temp2 >= 1 && temp2 <= 33) {
            c.drawText(new StringBuilder().append(((temp2 * 5) + 155) / 10.0f).toString(), 920.0f, 137.0f, this.mPaint);
        } else {
            c.drawText("None", 920.0f, 137.0f, this.mPaint);
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
