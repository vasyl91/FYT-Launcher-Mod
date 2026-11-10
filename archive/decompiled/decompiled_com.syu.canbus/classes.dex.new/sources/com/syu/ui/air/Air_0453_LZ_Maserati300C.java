package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0453_LZ_Maserati300C extends AirBase {
    public Air_0453_LZ_Maserati300C(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0294_wc_toyota/vw_18prado_air.webp";
        this.mPathHighlight = "0294_wc_toyota/vw_18prado_air_p.webp";
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
            this.srPath.addRect(173.0f, 126.0f, 272.0f, 176.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(386.0f, 18.0f, 472.0f, 90.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(326.0f, 114.0f, 407.0f, 183.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(481.0f, 125.0f, 548.0f, 172.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(758.0f, 105.0f, 822.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(774.0f, 150.0f, 821.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(766.0f, 164.0f, 803.0f, 196.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(190.0f, 34.0f, 315.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(895.0f, 122.0f, 1016.0f, 181.0f, Path.Direction.CW);
        }
        if (this.DATA[62] == 0) {
            this.srPath.addRect(549.0f, 34.0f, 644.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(700.0f, 26.0f, 833.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(866.0f, 220.0f, 1015.0f, 280.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(194.0f, 222.0f, 310.0f, 268.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(556.0f, 228.0f, 610.0f, 249.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(544.0f, 248.0f, 586.0f, 286.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(612.0f, 136.0f, (value * 16) + 612, 186.0f, Path.Direction.CW);
        int value2 = this.DATA[44];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        this.srPath.addRect(720.0f, 229.0f, (value2 * 16) + 720, 279.0f, Path.Direction.CW);
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit == 1) {
            this.srPath.addRect(128.0f, 52.0f, 166.0f, 95.0f, Path.Direction.CW);
            this.srPath.addRect(978.0f, 54.0f, 1017.0f, 95.0f, Path.Direction.CW);
            this.srPath.addRect(468.0f, 240.0f, 503.0f, 281.0f, Path.Direction.CW);
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
        if (temp == -1) {
            c.drawText("NONE", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 60.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder().append(temp / 2).toString(), 70.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 70.0f, 60.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NONE", 925.0f, 60.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 925.0f, 60.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 925.0f, 60.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder().append(temp2 / 2).toString(), 925.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 925.0f, 60.0f, this.mPaint);
        }
        int temp3 = this.DATA[40];
        if (temp3 == -1) {
            c.drawText("NONE", 412.0f, 247.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 412.0f, 247.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 412.0f, 247.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder().append(temp3 / 2).toString(), 412.0f, 247.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp3 / 2.0f).toString(), 412.0f, 247.0f, this.mPaint);
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
