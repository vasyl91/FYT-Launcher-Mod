package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0089_RZC2_BenTengX80 extends AirBase {
    public Air_0089_RZC2_BenTengX80(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0089_rzc2_bentengx80/air_rzc2_bentengx80_n.webp";
        this.mPathHighlight = "0089_rzc2_bentengx80/air_rzc2_bentengx80_p.webp";
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
            this.srPath.addRect(884.0f, 15.0f, 1001.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(36.0f, 18.0f, 124.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(542.0f, 13.0f, 631.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(726.0f, 12.0f, 818.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(198.0f, 27.0f, 312.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(210.0f, 102.0f, 316.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(544.0f, 88.0f, 611.0f, 114.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(539.0f, 113.0f, 586.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 1) {
            this.srPath.addRect(357.0f, 46.0f, 496.0f, 121.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(717.0f, 101.0f, (value * 18) + 717, 163.0f, Path.Direction.CW);
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
            c.drawText("LOW", 50.0f, 130.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 50.0f, 130.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 130.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 930.0f, 130.0f, this.mPaint);
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
