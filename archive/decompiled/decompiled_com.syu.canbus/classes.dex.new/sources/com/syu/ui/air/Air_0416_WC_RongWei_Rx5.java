package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0416_WC_RongWei_Rx5 extends AirBase {
    public Air_0416_WC_RongWei_Rx5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0253_xp1_yinglang/air.webp";
        this.mPathHighlight = "0253_xp1_yinglang/air_p.webp";
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
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(168.0f, 24.0f, 306.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(722.0f, 108.0f, 852.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(358.0f, 131.0f, 430.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(362.0f, 26.0f, 412.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(512.0f, 10.0f, 613.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(728.0f, 34.0f, 809.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 2) {
            this.srPath.addRect(693.0f, 89.0f, 739.0f, 109.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(198.0f, 106.0f, 264.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(359.0f, 63.0f, 395.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(373.0f, 85.0f, 415.0f, 100.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(352.0f, 101.0f, 388.0f, 125.0f, Path.Direction.CW);
        }
        if (TempUnit != 0 || this.DATA[37] != 0) {
            this.srPath.addRect(111.0f, 39.0f, 149.0f, 84.0f, Path.Direction.CW);
            this.srPath.addRect(980.0f, 36.0f, 1016.0f, 83.0f, Path.Direction.CW);
        }
        this.srPath.addRect(510.0f, 95.0f, (ToolkitMath.clamp(this.DATA[21], 0, 8) * 19) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D4_B70, 157.0f, Path.Direction.CW);
        int value = this.DATA[29];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        this.srPath.addRect(83.0f, 134.0f, (value * 21) + 83, 151.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(897.0f, 137.0f, (value2 * 21) + 897, 155.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(18.0f);
        if (this.DATA[13] != 0) {
            c.drawText("Auto", 702.0f, 25.0f, this.mPaint);
        } else {
            c.drawText(" ", 702.0f, 25.0f, this.mPaint);
        }
        if (this.DATA[14] != 0) {
            c.drawText("DUAL", 834.0f, 25.0f, this.mPaint);
        } else {
            c.drawText(" ", 834.0f, 25.0f, this.mPaint);
        }
        if (this.DATA[80] != 0) {
            c.drawText("UV", 440.0f, 31.0f, this.mPaint);
        } else {
            c.drawText(" ", 440.0f, 31.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int value3 = this.DATA[27];
        switch (value3) {
            case -3:
                c.drawText("HI", 64.0f, 62.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 64.0f, 62.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 64.0f, 62.0f, this.mPaint);
                break;
            default:
                if (TempUnit != 0) {
                    c.drawText(new StringBuilder(String.valueOf(((value3 * 9) / 10) + 32)).toString(), 64.0f, 62.0f, this.mPaint);
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value3 / 2.0f)), 64.0f, 62.0f, this.mPaint);
                }
                break;
        }
        int value4 = this.DATA[28];
        switch (value4) {
            case -3:
                c.drawText("HI", 926.0f, 62.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 926.0f, 62.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 926.0f, 62.0f, this.mPaint);
                break;
            default:
                if (TempUnit != 0) {
                    c.drawText(new StringBuilder(String.valueOf(((value4 * 9) / 10) + 32)).toString(), 926.0f, 62.0f, this.mPaint);
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value4 / 2.0f)), 926.0f, 62.0f, this.mPaint);
                }
                break;
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
