package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_Xincheng_Nissan_Tule extends AirBase {
    public Air_0452_Xincheng_Nissan_Tule(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_xbs_tule/xbs_nissan_tule.webp";
        this.mPathHighlight = "0439_xbs_tule/xbs_nissan_tule_p.webp";
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
            this.srPath.addRect(500.0f, 24.0f, 560.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(722.0f, 8.0f, 844.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(731.0f, 96.0f, 837.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(292.0f, 101.0f, 395.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(184.0f, 9.0f, 267.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(191.0f, 100.0f, 261.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(594.0f, 22.0f, 665.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(600.0f, 82.0f, 656.0f, 101.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(594.0f, 100.0f, 630.0f, 136.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(293.0f, 18.0f, 395.0f, 69.0f, Path.Direction.CW);
        }
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit != 0 || this.DATA[37] == 1) {
            this.srPath.addRect(124.0f, 42.0f, 160.0f, 77.0f, Path.Direction.CW);
            this.srPath.addRect(974.0f, 38.0f, 1014.0f, 77.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(438.0f, 90.0f, (value * 19) + 438, 156.0f, Path.Direction.CW);
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
            c.drawText("NO", 76.0f, 98.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 76.0f, 98.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 76.0f, 98.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder(String.valueOf(((temp * 10) - 160) / 10)).toString(), 76.0f, 98.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(new StringBuilder().append(((temp * 9) + 320) / 10).toString(), 76.0f, 98.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 76.0f, 98.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 923.0f, 98.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LO", 923.0f, 98.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 923.0f, 98.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder(String.valueOf(((temp1 * 10) - 160) / 10)).toString(), 923.0f, 98.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(new StringBuilder().append(((temp1 * 9) + 320) / 10).toString(), 923.0f, 98.0f, this.mPaint);
        } else {
            int temp3 = temp1 * 5;
            c.drawText(String.valueOf(temp3 / 10) + "." + (temp3 % 10), 923.0f, 98.0f, this.mPaint);
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
