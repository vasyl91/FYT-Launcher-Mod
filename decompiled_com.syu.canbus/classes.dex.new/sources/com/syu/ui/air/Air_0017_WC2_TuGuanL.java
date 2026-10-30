package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0017_WC2_TuGuanL extends AirBase {
    public Air_0017_WC2_TuGuanL(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0017_wc2_golf7/air_wc_tuguan_l.webp";
        this.mPathHighlight = "0017_wc2_golf7/air_wc_tuguan_l_p.webp";
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
            this.srPath.addRect(741.0f, 102.0f, 869.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[76] != 0) {
            this.srPath.addRect(292.0f, 25.0f, 436.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[66] != 0) {
            this.srPath.addRect(461.0f, 36.0f, 562.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(157.0f, 103.0f, 280.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(151.0f, 29.0f, 284.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(745.0f, 21.0f, 862.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(606.0f, 15.0f, 703.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(618.0f, 96.0f, 667.0f, 120.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(612.0f, 116.0f, 649.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1) {
            this.srPath.addRect(98.0f, 114.0f, 144.0f, 162.0f, Path.Direction.CW);
            this.srPath.addRect(973.0f, 114.0f, 1019.0f, 162.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(322.0f, 114.0f, (value * 15) + 322, 164.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(67.0f, 53.0f, 67.0f + (value2 * 20.0f), 71.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(950.0f - (value3 * 20.0f), 53.0f, 950.0f, 71.0f, Path.Direction.CW);
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
            c.drawText("LO", 56.0f, 124.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 56.0f, 124.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 56.0f, 124.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LO", 929.0f, 124.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 929.0f, 124.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 929.0f, 124.0f, this.mPaint);
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
