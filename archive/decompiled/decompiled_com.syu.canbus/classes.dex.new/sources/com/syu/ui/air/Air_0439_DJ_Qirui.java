package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_DJ_Qirui extends AirBase {
    public Air_0439_DJ_Qirui(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0138_dj_ga3/air_dj_ga3_n.webp";
        this.mPathHighlight = "0138_dj_ga3/air_dj_ga3_p.webp";
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
            this.srPath.addRect(10.0f, 29.0f, 137.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(892.0f, 26.0f, 1011.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(160.0f, 42.0f, 287.0f, 134.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(459.0f, 15.0f, 533.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(482.0f, 79.0f, 538.0f, 100.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(452.0f, 100.0f, 501.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(298.0f, 55.0f, 434.0f, 123.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(742.0f, 43.0f, 866.0f, 144.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(597.0f, 71.0f, (value * 18) + 597, 125.0f, Path.Direction.CW);
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
        int templev = this.DATA[75];
        if (templev != 0) {
            c.drawText("LEV " + templev, 71.0f, 142.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 71.0f, 142.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 71.0f, 142.0f, this.mPaint);
        } else if (temp >= 3 && temp <= 59) {
            int temp2 = (((temp - 3) * 5) / 2) + 180;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "℃", 71.0f, 142.0f, this.mPaint);
        } else {
            c.drawText("NO", 71.0f, 142.0f, this.mPaint);
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
