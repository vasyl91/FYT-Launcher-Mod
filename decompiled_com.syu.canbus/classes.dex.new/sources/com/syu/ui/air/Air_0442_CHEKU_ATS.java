package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0442_CHEKU_ATS extends AirBase {
    public Air_0442_CHEKU_ATS(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0442_cheku_ats/air_0442_ats.webp";
        this.mPathHighlight = "0442_cheku_ats/air_0442_ats_p.webp";
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
            this.srPath.addRect(203.0f, 13.0f, 316.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(208.0f, 88.0f, 313.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(710.0f, 71.0f, 842.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 2) {
            this.srPath.addRect(722.0f, 29.0f, 819.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(579.0f, 20.0f, 645.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(587.0f, 84.0f, 637.0f, 110.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(574.0f, 107.0f, 613.0f, 140.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(393.0f, 57.0f, (value * 19) + 393, 120.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(50.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 75.0f, 83.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 75.0f, 83.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 75.0f, 83.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp * 1.0f).toString(), 75.0f, 83.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 927.0f, 83.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 927.0f, 83.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 927.0f, 83.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp1 * 1.0f).toString(), 927.0f, 83.0f, this.mPaint);
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
