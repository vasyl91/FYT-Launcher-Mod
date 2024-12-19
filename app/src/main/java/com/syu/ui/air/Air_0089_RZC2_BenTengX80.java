package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(884.0f, 15.0f, 1001.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(36.0f, 18.0f, 124.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(542.0f, 13.0f, 631.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(726.0f, 12.0f, 818.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(198.0f, 27.0f, 312.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(210.0f, 102.0f, 316.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(544.0f, 88.0f, 611.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(539.0f, 113.0f, 586.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 1) {
            c.clipRect(357.0f, 46.0f, 496.0f, 121.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(717.0f, 101.0f, (value * 18) + 717, 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -2) {
            c.drawText("LOW", 50.0f, 130.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 50.0f, 130.0f, this.mPaint);
        }
        int temp2 = this.DATA[11];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 130.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 930.0f, 130.0f, this.mPaint);
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
