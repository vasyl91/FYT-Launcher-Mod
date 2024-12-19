package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AIR_0265_LUZ_T600 extends AirBase {
    public AIR_0265_LUZ_T600(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/zt600_n.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/zt600_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        String str2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[31] != 0) {
            c.clipRect(131.0f, 25.0f, 255.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(153.0f, 101.0f, 240.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(262.0f, 101.0f, 380.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[44] != 0) {
            c.clipRect(266.0f, 20.0f, 377.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[45] != 0) {
            c.clipRect(772.0f, 16.0f, 887.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(779.0f, 89.0f, 886.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(523.0f, 14.0f, 627.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(530.0f, 92.0f, 626.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(402.0f, 24.0f, 470.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(416.0f, 85.0f, 466.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(403.0f, 108.0f, 442.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 1) {
            c.clipRect(645.0f, 11.0f, 765.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[37];
        c.clipRect(659.0f, 117.0f, (value * 15) + 659, 164.0f, Region.Op.UNION);
        int value2 = this.DATA[68];
        c.clipRect(61.0f, 133.0f, (value2 * 20) + 61, 160.0f, Region.Op.UNION);
        int value3 = this.DATA[69];
        c.clipRect(906.0f, 133.0f, (value3 * 20) + 906, 160.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int val = this.DATA[42];
        if (val == -1) {
            str = "--";
        } else if (val == -2) {
            str = "LOW";
        } else if (val == -3) {
            str = "HIGH";
        } else if (this.DATA[67] == 0) {
            str = String.valueOf(val / 10) + "." + (val % 10) + " ℃";
        } else {
            int val_f = ((val * 18) / 10) + 320;
            str = String.valueOf(val_f / 10) + "." + (val_f % 10) + " ℉";
        }
        c.drawText(str, 68.0f, 65.0f, this.mPaint);
        int val2 = this.DATA[39];
        if (val2 == -1) {
            str2 = "--";
        } else if (val2 == -2) {
            str2 = "LOW";
        } else if (val2 == -3) {
            str2 = "HIGH";
        } else if (this.DATA[67] == 0) {
            str2 = String.valueOf(val2 / 10) + "." + (val2 % 10) + " ℃";
        } else {
            int val_f2 = ((val2 * 18) / 10) + 320;
            str2 = String.valueOf(val_f2 / 10) + "." + (val_f2 % 10) + " ℉";
        }
        c.drawText(str2, 962.0f, 65.0f, this.mPaint);
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
