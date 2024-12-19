package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[0] != 0) {
            c.clipRect(13.0f, 25.0f, 123.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(521.0f, 18.0f, 618.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(273.0f, 105.0f, 368.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(285.0f, 17.0f, 353.0f, 55.0f, Region.Op.UNION);
        }
        switch (this.DATA[3]) {
            case 2:
                c.clipRect(285.0f, 57.0f, 353.0f, 82.0f, Region.Op.UNION);
            case 1:
                c.clipRect(285.0f, 17.0f, 353.0f, 55.0f, Region.Op.UNION);
                break;
        }
        if (this.DATA[4] == 0) {
            c.clipRect(909.0f, 17.0f, 1007.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(397.0f, 19.0f, 497.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(399.0f, 94.0f, 489.0f, 158.0f, Region.Op.UNION);
        }
        switch (this.DATA[11]) {
            case 1:
                c.clipRect(663.0f, 144.0f, 736.0f, 164.0f, Region.Op.UNION);
                break;
            case 2:
                c.clipRect(648.0f, 20.0f, 717.0f, 74.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(663.0f, 114.0f, 700.0f, 141.0f, Region.Op.UNION);
                break;
            case 5:
                c.clipRect(675.0f, 97.0f, 727.0f, 114.0f, Region.Op.UNION);
                c.clipRect(663.0f, 114.0f, 700.0f, 141.0f, Region.Op.UNION);
                break;
            case 6:
                c.clipRect(675.0f, 97.0f, 727.0f, 114.0f, Region.Op.UNION);
                break;
            case 11:
                c.clipRect(663.0f, 74.0f, 711.0f, 99.0f, Region.Op.UNION);
                break;
            case 12:
                c.clipRect(663.0f, 74.0f, 711.0f, 99.0f, Region.Op.UNION);
                c.clipRect(663.0f, 114.0f, 700.0f, 141.0f, Region.Op.UNION);
                break;
            case 13:
                c.clipRect(663.0f, 74.0f, 711.0f, 99.0f, Region.Op.UNION);
                c.clipRect(675.0f, 97.0f, 727.0f, 114.0f, Region.Op.UNION);
                break;
            case 14:
                c.clipRect(663.0f, 74.0f, 711.0f, 99.0f, Region.Op.UNION);
                c.clipRect(675.0f, 97.0f, 727.0f, 114.0f, Region.Op.UNION);
                c.clipRect(663.0f, 114.0f, 700.0f, 141.0f, Region.Op.UNION);
                break;
        }
        int value = this.DATA[12];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(526.0f, 113.0f, (value * 14) + 526, 163.0f, Region.Op.UNION);
        int value2 = this.DATA[7];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(188.0f, 59.0f, (value2 * 20) + 188, 77.0f, Region.Op.UNION);
        int value3 = this.DATA[8];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(840 - (value3 * 20), 59.0f, 840.0f, 77.0f, Region.Op.UNION);
        int value4 = this.DATA[9];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(186.0f, 137.0f, (value4 * 20) + 186, 155.0f, Region.Op.UNION);
        int value5 = this.DATA[10];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        c.clipRect(843 - (value5 * 20), 137.0f, 843.0f, 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[13];
        if (temp == 254) {
            c.drawText("LOW", 40.0f, 137.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 40.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 40.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[14];
        if (temp2 == 254) {
            c.drawText("LOW", 930.0f, 137.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HI", 930.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 930.0f, 137.0f, this.mPaint);
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
