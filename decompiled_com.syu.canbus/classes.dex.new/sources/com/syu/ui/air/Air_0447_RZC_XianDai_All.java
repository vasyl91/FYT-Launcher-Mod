package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0447_RZC_XianDai_All extends AirBase {
    public Air_0447_RZC_XianDai_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0447_od_rzc_19tusheng/air_rzc_xiandai_all_n.webp";
        this.mPathHighlight = "0447_od_rzc_19tusheng/air_rzc_xiandai_all_p.webp";
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
        if (this.DATA[11] != 0) {
            this.srPath.addRect(185.0f, 112.0f, 240.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(20.0f, 114.0f, 114.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(737.0f, 113.0f, 827.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(607.0f, 18.0f, 695.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(610.0f, 98.0f, 690.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(310.0f, 48.0f, 359.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(317.0f, 76.0f, 366.0f, 96.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(306.0f, 93.0f, 341.0f, 120.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 0) {
            this.srPath.addRect(93.0f, 42.0f, 123.0f, 75.0f, Path.Direction.CW);
            this.srPath.addRect(805.0f, 42.0f, 837.0f, 72.0f, Path.Direction.CW);
            this.srPath.addRect(972.0f, 41.0f, 1003.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(146.0f, 26.0f, 276.0f, 73.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(437.0f, 56.0f, (value * 18) + 437, 113.0f, Path.Direction.CW);
        int value2 = this.DATA[44];
        this.srPath.addRect(865.0f, 96.0f, (value2 * 18) + 865, 158.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LO", 51.0f, 60.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 51.0f, 60.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NO", 51.0f, 60.0f, this.mPaint);
        } else if (left_temp >= 50 && left_temp <= 100) {
            c.drawText(new StringBuilder().append(left_temp).toString(), 51.0f, 60.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(((((left_temp * 5) + 170) * 9) / 50) + 32).toString(), 51.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (left_temp / 2.0f)).toString(), 51.0f, 60.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 752.0f, 60.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 752.0f, 60.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("NO", 752.0f, 60.0f, this.mPaint);
        } else if (right_temp >= 50 && right_temp <= 100) {
            c.drawText(new StringBuilder().append(right_temp).toString(), 752.0f, 60.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            right_temp = ((((right_temp * 5) + 170) * 9) / 50) + 32;
            c.drawText(new StringBuilder().append(right_temp).toString(), 752.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (right_temp / 2.0f)).toString(), 752.0f, 60.0f, this.mPaint);
        }
        int rear_temp = this.DATA[40];
        if (rear_temp == -2) {
            c.drawText("LO", 890.0f, 60.0f, this.mPaint);
        } else if (rear_temp == -3) {
            c.drawText("HI", 890.0f, 60.0f, this.mPaint);
        } else if (rear_temp == -1) {
            c.drawText("----", 890.0f, 60.0f, this.mPaint);
        } else if (right_temp >= 50 && right_temp <= 100) {
            c.drawText(new StringBuilder().append(rear_temp).toString(), 890.0f, 60.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(((((rear_temp * 5) + 170) * 9) / 50) + 32).toString(), 890.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (rear_temp / 2.0f)).toString(), 890.0f, 60.0f, this.mPaint);
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
