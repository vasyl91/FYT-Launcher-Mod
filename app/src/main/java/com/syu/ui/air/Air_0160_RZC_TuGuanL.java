package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0160_RZC_TuGuanL extends AirBase {
    public Air_0160_RZC_TuGuanL(Context context) {
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[89] != 0) {
            c.clipRect(741.0f, 102.0f, 869.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[190] != 0) {
            c.clipRect(292.0f, 25.0f, 436.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(461.0f, 36.0f, 562.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(157.0f, 103.0f, 280.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(151.0f, 29.0f, 284.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(745.0f, 21.0f, 862.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[94] != 0) {
            c.clipRect(606.0f, 15.0f, 703.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[95] != 0) {
            c.clipRect(618.0f, 96.0f, 667.0f, 120.0f, Region.Op.UNION);
        }
        if (this.DATA[96] != 0) {
            c.clipRect(612.0f, 116.0f, 649.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[77] == 1) {
            c.clipRect(98.0f, 114.0f, 144.0f, 162.0f, Region.Op.UNION);
            c.clipRect(973.0f, 114.0f, 1019.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[97];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(322.0f, 114.0f, (value * 15) + 322, 164.0f, Region.Op.UNION);
        int value2 = this.DATA[92];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(67.0f, 53.0f, 67.0f + (value2 * 20.0f), 71.0f, Region.Op.UNION);
        int value3 = this.DATA[93];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(950.0f - (value3 * 20.0f), 53.0f, 950.0f, 71.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[98];
        if (temp == 0) {
            c.drawText("LOW", 56.0f, 124.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 56.0f, 124.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(new StringBuilder().append(temp + 59).toString(), 56.0f, 124.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp * 5) + 155) / 10.0f).toString(), 56.0f, 124.0f, this.mPaint);
        }
        int temp2 = this.DATA[99];
        if (temp2 == 0) {
            c.drawText("LOW", 929.0f, 124.0f, this.mPaint);
        } else if (temp2 == 31) {
            c.drawText("HI", 929.0f, 124.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(new StringBuilder().append(temp2 + 59).toString(), 929.0f, 124.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp2 * 5) + 155) / 10.0f).toString(), 929.0f, 124.0f, this.mPaint);
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
