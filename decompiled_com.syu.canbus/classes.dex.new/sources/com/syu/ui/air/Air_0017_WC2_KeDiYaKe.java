package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0017_WC2_KeDiYaKe extends AirBase {
    public Air_0017_WC2_KeDiYaKe(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 260;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0017_wc2_golf7/air_wc2_kediyake_n.webp";
        this.mPathHighlight = "0017_wc2_golf7/air_wc2_kediyake_p.webp";
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
        if (this.DATA[76] != 0) {
            this.srPath.addRect(539.0f, 183.0f, 661.0f, 250.0f, Path.Direction.CW);
        }
        if (this.DATA[66] != 0) {
            this.srPath.addRect(733.0f, 171.0f, 836.0f, 248.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(204.0f, 19.0f, 315.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(261.0f, 109.0f, 316.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(196.0f, 108.0f, 315.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(190.0f, 183.0f, 330.0f, 240.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(538.0f, 90.0f, 634.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(531.0f, 18.0f, 675.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(712.0f, 23.0f, 823.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(355.0f, 15.0f, 489.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(779.0f, 139.0f, 839.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(710.0f, 86.0f, 759.0f, 123.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(710.0f, 125.0f, 756.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(700.0f, 139.0f, 733.0f, 167.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(122.0f, 35.0f, 158.0f, 85.0f, Path.Direction.CW);
            this.srPath.addRect(976.0f, 39.0f, 1018.0f, 86.0f, Path.Direction.CW);
            this.srPath.addRect(461.0f, 198.0f, 501.0f, 249.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(380.0f, 96.0f, 380.0f + (value * 15.7f), 168.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(84.0f, 133.0f, 84.0f + (value2 * 19.0f), 153.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(946.0f - (value3 * 19.0f), 131.0f, 946.0f, 153.0f, Path.Direction.CW);
        int value4 = this.DATA[31];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        this.srPath.addRect(84.0f, 216.0f, 84.0f + (value4 * 19.0f), 237.0f, Path.Direction.CW);
        int value5 = this.DATA[32];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        this.srPath.addRect(948.0f - (value5 * 19.0f), 217.0f, 948.0f, 239.0f, Path.Direction.CW);
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
            c.drawText("LO", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 76.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LO", 930.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 930.0f, 72.0f, this.mPaint);
        }
        int temp3 = this.DATA[40];
        if (temp3 == -2) {
            c.drawText("LO", 416.0f, 236.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 416.0f, 236.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp3 / 10.0f).toString(), 416.0f, 236.0f, this.mPaint);
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
