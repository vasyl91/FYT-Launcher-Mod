package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0013_WC2_XinJunWei2013 extends AirBase {
    public Air_0013_WC2_XinJunWei2013(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0013_wc2_xinjunwei2013/air_wc2_angkewei_n.webp";
        this.mPathHighlight = "0013_wc2_xinjunwei2013/air_wc2_angkewei_p.webp";
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
            this.srPath.addRect(13.0f, 25.0f, 123.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(521.0f, 18.0f, 618.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(273.0f, 105.0f, 368.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(285.0f, 17.0f, 353.0f, 55.0f, Path.Direction.CW);
        }
        switch (this.DATA[53]) {
            case 1:
                this.srPath.addRect(285.0f, 17.0f, 353.0f, 55.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(285.0f, 57.0f, 353.0f, 82.0f, Path.Direction.CW);
                break;
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(909.0f, 17.0f, 1007.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(397.0f, 19.0f, 497.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(399.0f, 94.0f, 489.0f, 158.0f, Path.Direction.CW);
        }
        switch (this.DATA[77]) {
            case 1:
                this.srPath.addRect(663.0f, 144.0f, 736.0f, 164.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(648.0f, 20.0f, 717.0f, 74.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(663.0f, 114.0f, 700.0f, 141.0f, Path.Direction.CW);
                break;
            case 5:
                this.srPath.addRect(675.0f, 97.0f, 727.0f, 114.0f, Path.Direction.CW);
                this.srPath.addRect(663.0f, 114.0f, 700.0f, 141.0f, Path.Direction.CW);
                break;
            case 6:
                this.srPath.addRect(675.0f, 97.0f, 727.0f, 114.0f, Path.Direction.CW);
                break;
            case 11:
                this.srPath.addRect(663.0f, 74.0f, 711.0f, 99.0f, Path.Direction.CW);
                break;
            case 12:
                this.srPath.addRect(663.0f, 74.0f, 711.0f, 99.0f, Path.Direction.CW);
                this.srPath.addRect(663.0f, 114.0f, 700.0f, 141.0f, Path.Direction.CW);
                break;
            case 13:
                this.srPath.addRect(663.0f, 74.0f, 711.0f, 99.0f, Path.Direction.CW);
                this.srPath.addRect(675.0f, 97.0f, 727.0f, 114.0f, Path.Direction.CW);
                break;
            case 14:
                this.srPath.addRect(663.0f, 74.0f, 711.0f, 99.0f, Path.Direction.CW);
                this.srPath.addRect(675.0f, 97.0f, 727.0f, 114.0f, Path.Direction.CW);
                this.srPath.addRect(663.0f, 114.0f, 700.0f, 141.0f, Path.Direction.CW);
                break;
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(526.0f, 113.0f, (value * 14) + 526, 163.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(188.0f, 59.0f, (value2 * 20) + 188, 77.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(840 - (value3 * 20), 59.0f, 840.0f, 77.0f, Path.Direction.CW);
        int value4 = this.DATA[31];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        this.srPath.addRect(186.0f, 137.0f, (value4 * 20) + 186, 155.0f, Path.Direction.CW);
        int value5 = this.DATA[32];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        this.srPath.addRect(843 - (value5 * 20), 137.0f, 843.0f, 155.0f, Path.Direction.CW);
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
            c.drawText("LO", 40.0f, 137.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 40.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 40.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LO", 930.0f, 137.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 930.0f, 137.0f, this.mPaint);
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
