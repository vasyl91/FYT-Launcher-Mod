package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0190_RZC_TianLai extends AirBase {
    public Air_0190_RZC_TianLai(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0430_wc2_tianlai03/air_wc2_tianlai03_n.webp";
        this.mPathHighlight = "0430_wc2_tianlai03/air_wc2_tianlai03_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String tempStr;
        String tempStr2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(12.0f, 27.0f, 156.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(525.0f, 11.0f, 667.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(373.0f, 16.0f, 454.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(210.0f, 104.0f, 292.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(541.0f, 101.0f, 649.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(883.0f, 26.0f, 996.0f, 90.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(200.0f, 10.0f, 308.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(717.0f, 92.0f, 820.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(380.0f, 84.0f, 458.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(366.0f, 114.0f, 420.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[12];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(723.0f, 25.0f, 723.0f + (value * 15.3f), 89.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int arg = this.DATA[13];
        if (arg == -1) {
            tempStr = "NONE";
        } else if (arg == -2) {
            tempStr = "LOW";
        } else if (arg == -3) {
            tempStr = "HIGH";
        } else {
            int value_temp = arg + 16;
            tempStr = new StringBuilder(String.valueOf(value_temp * 0.5f)).toString();
        }
        c.drawText(tempStr, 70.0f, 132.0f, this.mPaint);
        int arg2 = this.DATA[14];
        if (arg2 == -1) {
            tempStr2 = "NONE";
        } else if (arg2 == -2) {
            tempStr2 = "LOW";
        } else if (arg2 == -3) {
            tempStr2 = "HIGH";
        } else {
            int value_temp2 = arg2 + 16;
            tempStr2 = new StringBuilder(String.valueOf(value_temp2 * 0.5f)).toString();
        }
        c.drawText(tempStr2, 930.0f, 132.0f, this.mPaint);
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
