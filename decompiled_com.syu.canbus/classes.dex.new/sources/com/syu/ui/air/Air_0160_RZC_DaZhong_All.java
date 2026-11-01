package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0160_RZC_DaZhong_All extends AirBase {
    public Air_0160_RZC_DaZhong_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0017_wc2_golf7/air_wc_all.webp";
        this.mPathHighlight = "0017_wc2_golf7/air_wc_all_p.webp";
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
            this.srPath.addRect(414.0f, 242.0f, 507.0f, 270.0f, Path.Direction.CW);
        }
        if (this.DATA[66] != 0) {
            this.srPath.addRect(629.0f, 20.0f, 696.0f, 87.0f, Path.Direction.CW);
        }
        if (this.DATA[358] != 0) {
            this.srPath.addRect(737.0f, 19.0f, 792.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(221.0f, 131.0f, 297.0f, 179.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(323.0f, 135.0f, 392.0f, 178.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(428.0f, 18.0f, 492.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(206.0f, 33.0f, 306.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(412.0f, 119.0f, 506.0f, 183.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(520.0f, 23.0f, 604.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[14] == 0) {
            this.srPath.addRect(317.0f, 36.0f, 394.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(826.0f, 112.0f, 911.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(523.0f, 110.0f, 577.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(534.0f, 150.0f, 573.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(532.0f, 162.0f, 560.0f, 192.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(535.0f, 232.0f, 578.0f, 251.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(529.0f, 250.0f, 557.0f, 280.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(216.0f, 237.0f, 300.0f, 277.0f, Path.Direction.CW);
        }
        if (this.DATA[38] != 0) {
            this.srPath.addRect(823.0f, 232.0f, 917.0f, 274.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(69.0f, 36.0f, 99.0f, 80.0f, Path.Direction.CW);
            this.srPath.addRect(990.0f, 36.0f, 1021.0f, 83.0f, Path.Direction.CW);
            this.srPath.addRect(380.0f, 230.0f, 409.0f, 273.0f, Path.Direction.CW);
        }
        int value = this.DATA[29];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        this.srPath.addRect(161.0f, 53.0f, 161.0f + (value * 14.0f), 83.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(866.0f - (value2 * 14.0f), 56.0f, 866.0f, 79.0f, Path.Direction.CW);
        int value3 = this.DATA[31];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(156.0f, 156.0f, 156.0f + (value3 * 14.0f), 176.0f, Path.Direction.CW);
        int value4 = this.DATA[32];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        this.srPath.addRect(929.0f, 152.0f, 929.0f + (value4 * 14.0f), 180.0f, Path.Direction.CW);
        int value5 = this.DATA[88];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        this.srPath.addRect(155.0f, 248.0f, 155.0f + (value5 * 14.0f), 274.0f, Path.Direction.CW);
        int value6 = this.DATA[89];
        if (value6 < 0) {
            value6 = 0;
        } else if (value6 > 3) {
            value6 = 3;
        }
        this.srPath.addRect(932.0f, 245.0f, 932.0f + (value6 * 14.0f), 273.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(35.0f);
        int lev = this.DATA[21];
        c.drawText(new StringBuilder().append(lev).toString(), 730.0f, 158.0f, this.mPaint);
        int lev2 = this.DATA[44];
        c.drawText(new StringBuilder().append(lev2).toString(), 730.0f, 255.0f, this.mPaint);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LO", 41.0f, 64.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 41.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 40.0f, 64.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LO", 960.0f, 64.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 960.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 960.0f, 64.0f, this.mPaint);
        }
        int temp3 = this.DATA[40];
        if (temp3 == -2) {
            c.drawText("LO", 352.0f, 259.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 352.0f, 259.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp3 / 10.0f).toString(), 352.0f, 259.0f, this.mPaint);
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
