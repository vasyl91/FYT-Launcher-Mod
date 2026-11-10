package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_XP_ZH_Ford_All extends AirBase {
    public Air_0452_XP_ZH_Ford_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0293_wc3_15ruijie/rzc_15ruijie.webp";
        this.mPathHighlight = "0293_wc3_15ruijie/rzc_15ruijie_p.webp";
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
        if (this.DATA[10] != 0) {
            this.srPath.addRect(154.0f, 28.0f, 283.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(446.0f, 116.0f, 578.0f, 184.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(304.0f, 127.0f, 430.0f, 174.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(892.0f, 27.0f, 1009.0f, 92.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(299.0f, 19.0f, 434.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(603.0f, 16.0f, 712.0f, 97.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(608.0f, 110.0f, 711.0f, 192.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 1) {
            this.srPath.addRect(18.0f, 113.0f, 132.0f, 188.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(911.0f, 103.0f, 965.0f, 139.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(923.0f, 137.0f, 959.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(915.0f, 149.0f, 947.0f, 173.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(100.0f, 54.0f, 143.0f, 98.0f, Path.Direction.CW);
            this.srPath.addRect(830.0f, 54.0f, 874.0f, 101.0f, Path.Direction.CW);
            this.srPath.addRect(968.0f, 238.0f, 1020.0f, 290.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(451.0f, 36.0f, (value * 18) + 451, 98.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 -= 3;
        }
        this.srPath.addRect(205.0f, 155.0f, (value2 * 24) + 205, 178.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 -= 3;
        }
        this.srPath.addRect(749.0f, 155.0f, (value3 * 24) + 749, 178.0f, Path.Direction.CW);
        if (this.DATA[42] != 0) {
            this.srPath.addRect(224.0f, 221.0f, 381.0f, 270.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(435.0f, 223.0f, 599.0f, 271.0f, Path.Direction.CW);
        }
        int value4 = this.DATA[44];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 7) {
            value4 = 7;
        }
        this.srPath.addRect(661.0f, 229.0f, (value4 * 21) + 661, 293.0f, Path.Direction.CW);
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
        int i = this.DATA[75];
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LO", 51.0f, 78.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 51.0f, 78.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NO", 51.0f, 78.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder(String.valueOf(temp / 2)).toString(), 51.0f, 78.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder(String.valueOf(temp + 27)).toString(), 51.0f, 78.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp * 0.5f)).toString(), 51.0f, 78.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LO", 780.0f, 78.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 780.0f, 78.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("NO", 780.0f, 78.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder(String.valueOf(temp2 / 2)).toString(), 780.0f, 78.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder(String.valueOf(temp2 + 27)).toString(), 780.0f, 78.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp2 * 0.5f)).toString(), 780.0f, 78.0f, this.mPaint);
        }
        int rear_temp = this.DATA[40];
        if (rear_temp == 0) {
            c.drawText("LO", 895.0f, 257.0f, this.mPaint);
        } else if (rear_temp == 9) {
            c.drawText("HI", 895.0f, 257.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(rear_temp)).toString(), 895.0f, 257.0f, this.mPaint);
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
