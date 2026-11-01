package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0398_SBD_FORD_LIEYING extends AirBase {
    public Air_0398_SBD_FORD_LIEYING(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0398_sbd_ford_lieying/air.webp";
        this.mPathHighlight = "0398_sbd_ford_lieying/air_p.webp";
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
        if (this.DATA[13] != 0) {
            this.srPath.addRect(736.0f, 23.0f, 872.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[26] != 0) {
            this.srPath.addRect(736.0f, 104.0f, 872.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(10.0f, 27.0f, 133.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(180.0f, 24.0f, 259.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(163.0f, 103.0f, 268.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(615.0f, 13.0f, 714.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(612.0f, 92.0f, 712.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(900.0f, 20.0f, 1009.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(313.0f, 27.0f, 367.0f, 58.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(318.0f, 59.0f, 374.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(312.0f, 76.0f, 354.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(329.0f, 116.0f, 393.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(443.0f, 15.0f, 578.0f, 79.0f, Path.Direction.CW);
        }
        this.srPath.addRect(458.0f, 118.0f, (this.DATA[21] * 16) + 458, 164.0f, Path.Direction.CW);
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
        int value = this.DATA[27];
        if (value == -2) {
            str = "LOW";
        } else if (value == -3) {
            str = "HOT";
        } else if (value == -1) {
            str = "NONE";
        } else {
            float temp = value * 0.1f;
            str = new StringBuilder(String.valueOf(temp)).toString();
        }
        c.drawText(str, 46.0f, 125.0f, this.mPaint);
        int value2 = this.DATA[28];
        if (value2 == -2) {
            str2 = "LOW";
        } else if (value2 == -3) {
            str2 = "HOT";
        } else if (value2 == -1) {
            str2 = "NONE";
        } else {
            float temp2 = value2 * 0.1f;
            str2 = new StringBuilder(String.valueOf(temp2)).toString();
        }
        c.drawText(str2, 930.0f, 125.0f, this.mPaint);
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
