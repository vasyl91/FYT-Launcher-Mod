package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(131.0f, 25.0f, 255.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(153.0f, 101.0f, 240.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(262.0f, 101.0f, 380.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(266.0f, 20.0f, 377.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(772.0f, 16.0f, 887.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[33] != 0) {
            this.srPath.addRect(779.0f, 89.0f, 886.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(523.0f, 14.0f, 627.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(530.0f, 92.0f, 626.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(402.0f, 24.0f, 470.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(416.0f, 85.0f, 466.0f, 111.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(403.0f, 108.0f, 442.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(645.0f, 11.0f, 765.0f, 77.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(659.0f, 117.0f, (value * 15) + 659, 164.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        this.srPath.addRect(61.0f, 133.0f, (value2 * 20) + 61, 160.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        this.srPath.addRect(906.0f, 133.0f, (value3 * 20) + 906, 160.0f, Path.Direction.CW);
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
        int val = this.DATA[27];
        if (val == -1) {
            str = "--";
        } else if (val == -2) {
            str = "LOW";
        } else if (val == -3) {
            str = "HIGH";
        } else if (this.DATA[37] == 0) {
            str = String.valueOf(val / 10) + "." + (val % 10) + " ℃";
        } else {
            int val_f = ((val * 18) / 10) + 320;
            str = String.valueOf(val_f / 10) + "." + (val_f % 10) + " ℉";
        }
        c.drawText(str, 68.0f, 65.0f, this.mPaint);
        int val2 = this.DATA[28];
        if (val2 == -1) {
            str2 = "--";
        } else if (val2 == -2) {
            str2 = "LOW";
        } else if (val2 == -3) {
            str2 = "HIGH";
        } else if (this.DATA[37] == 0) {
            str2 = String.valueOf(val2 / 10) + "." + (val2 % 10) + " ℃";
        } else {
            int val_f2 = ((val2 * 18) / 10) + 320;
            str2 = String.valueOf(val_f2 / 10) + "." + (val_f2 % 10) + " ℉";
        }
        c.drawText(str2, 962.0f, 65.0f, this.mPaint);
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
