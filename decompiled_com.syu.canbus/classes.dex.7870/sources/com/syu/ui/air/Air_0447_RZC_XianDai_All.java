package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Air_0447_RZC_XianDai_All extends AirBase {
    public Air_0447_RZC_XianDai_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 140;
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
            this.srPath.addRect(480.0f, 9.0f, 543.0f, 56.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(322.0f, 19.0f, 406.0f, 51.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(623.0f, 9.0f, 710.0f, 56.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(231.0f, 79.0f, 290.0f, 131.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(350.0f, 83.0f, 404.0f, 130.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(505.0f, 87.0f, 531.0f, 102.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(509.0f, 102.0f, 535.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(513.0f, 112.0f, 543.0f, 129.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(90.0f, 25.0f, 118.0f, 62.0f, Path.Direction.CW);
            this.srPath.addRect(90.0f, 94.0f, 118.0f, 133.0f, Path.Direction.CW);
            this.srPath.addRect(983.0f, 95.0f, 1013.0f, 133.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(747.0f, 78.0f, 814.0f, 127.0f, Path.Direction.CW);
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
        int value = this.DATA[21];
        c.drawText(new StringBuilder(String.valueOf(value)).toString(), 672.0f, 114.0f, this.mPaint);
        this.mPaint.setTextSize(25.0f);
        int value2 = this.DATA[44];
        c.drawText(new StringBuilder(String.valueOf(value2)).toString(), 980.0f, 57.0f, this.mPaint);
        this.mPaint.setTextSize(22.0f);
        int value3 = this.DATA[27];
        switch (value3) {
            case -3:
                c.drawText("HI", 48.0f, 115.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 48.0f, 115.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 48.0f, 115.0f, this.mPaint);
                break;
            default:
                if (value3 >= 50 && value3 <= 100) {
                    c.drawText(new StringBuilder().append(value3).toString(), 48.0f, 115.0f, this.mPaint);
                } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    c.drawText(new StringBuilder().append(((((value3 * 5) + 170) * 9) / 50) + 32).toString(), 48.0f, 115.0f, this.mPaint);
                } else {
                    c.drawText(new StringBuilder().append(17.0f + (value3 / 2.0f)).toString(), 48.0f, 115.0f, this.mPaint);
                }
                break;
        }
        int value4 = this.DATA[28];
        switch (value4) {
            case -3:
                c.drawText("HI", 940.0f, 115.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 940.0f, 115.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 940.0f, 115.0f, this.mPaint);
                break;
            default:
                if (value4 >= 50 && value4 <= 100) {
                    c.drawText(new StringBuilder().append(value4).toString(), 940.0f, 115.0f, this.mPaint);
                } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    c.drawText(new StringBuilder().append(((((value4 * 5) + 170) * 9) / 50) + 32).toString(), 940.0f, 115.0f, this.mPaint);
                } else {
                    c.drawText(new StringBuilder().append(17.0f + (value4 / 2.0f)).toString(), 940.0f, 115.0f, this.mPaint);
                }
                break;
        }
        int rear_temp = this.DATA[40];
        if (rear_temp == -2) {
            c.drawText("LO", 48.0f, 57.0f, this.mPaint);
        } else if (rear_temp == -3) {
            c.drawText("HI", 48.0f, 57.0f, this.mPaint);
        } else if (rear_temp == -1) {
            c.drawText("----", 48.0f, 57.0f, this.mPaint);
        } else if (rear_temp >= 50 && rear_temp <= 100) {
            c.drawText(new StringBuilder().append(rear_temp).toString(), 48.0f, 57.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(((((rear_temp * 5) + 170) * 9) / 50) + 32).toString(), 48.0f, 57.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (rear_temp / 2.0f)).toString(), 48.0f, 57.0f, this.mPaint);
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
