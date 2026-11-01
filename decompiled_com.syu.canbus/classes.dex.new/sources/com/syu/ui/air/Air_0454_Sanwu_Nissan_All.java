package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0454_Sanwu_Nissan_All extends AirBase {
    public Air_0454_Sanwu_Nissan_All(Context context) {
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(12.0f, 27.0f, 156.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(525.0f, 11.0f, 667.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(210.0f, 104.0f, 292.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(541.0f, 101.0f, 649.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(883.0f, 26.0f, 996.0f, 90.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(200.0f, 10.0f, 308.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(717.0f, 92.0f, 820.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(373.0f, 16.0f, 454.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(380.0f, 84.0f, 458.0f, 113.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(366.0f, 114.0f, 420.0f, 162.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(723.0f, 25.0f, 723.0f + (value * 15.3f), 89.0f, Path.Direction.CW);
        if (this.DATA[37] != 0 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(125.0f, 119.0f, 163.0f, 159.0f, Path.Direction.CW);
            this.srPath.addRect(980.0f, 121.0f, 1018.0f, 159.0f, Path.Direction.CW);
        }
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
        int arg = this.DATA[27];
        if (arg == -1) {
            tempStr = "----";
        } else if (arg == -2) {
            tempStr = "LO";
        } else if (arg == -3) {
            tempStr = "HI";
        } else {
            if (this.DATA[37] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                arg = ((arg * 9) / 5) + 320;
            }
            tempStr = new StringBuilder(String.valueOf(arg * 0.1f)).toString();
        }
        c.drawText(tempStr, 70.0f, 132.0f, this.mPaint);
        int arg2 = this.DATA[28];
        if (arg2 == -1) {
            tempStr2 = "----";
        } else if (arg2 == -2) {
            tempStr2 = "LO";
        } else if (arg2 == -3) {
            tempStr2 = "HI";
        } else {
            if (this.DATA[37] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                arg2 = ((arg2 * 9) / 5) + 320;
            }
            tempStr2 = new StringBuilder(String.valueOf(arg2 * 0.1f)).toString();
        }
        c.drawText(tempStr2, 930.0f, 132.0f, this.mPaint);
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
