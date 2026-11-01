package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_OD_HZ_Nezha extends AirBase {
    public Air_0452_OD_HZ_Nezha(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_od_hz_nezha/air_od_hz_nezha.webp";
        this.mPathHighlight = "0452_od_hz_nezha/air_od_hz_nezha_p.webp";
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
        if (this.DATA[10] != 0) {
            this.srPath.addRect(190.0f, 26.0f, 328.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(251.0f, 100.0f, 323.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(197.0f, 100.0f, 314.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(365.0f, 100.0f, 488.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(888.0f, 104.0f, 1000.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(549.0f, 10.0f, 643.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(726.0f, 6.0f, 813.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(702.0f, 94.0f, 844.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[63] != 0) {
            this.srPath.addRect(39.0f, 95.0f, 129.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(387.0f, 10.0f, 424.0f, 35.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(393.0f, 33.0f, 437.0f, 53.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(384.0f, 53.0f, 416.0f, 79.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(541.0f, 94.0f, (value * 19) + 541, 163.0f, Path.Direction.CW);
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
            c.drawText("LO", 55.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 55.0f, 60.0f, this.mPaint);
        } else if (temp >= 1 && temp <= 29) {
            int temp2 = (temp * 5) + 175;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 55.0f, 60.0f, this.mPaint);
        } else {
            c.drawText("NO", 55.0f, 60.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -2) {
            c.drawText("LO", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 >= 1 && temp1 <= 29) {
            int temp3 = (temp1 * 5) + 175;
            c.drawText(String.valueOf(temp3 / 10) + "." + (temp3 % 10), 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -1) {
            c.drawText("NO", 930.0f, 60.0f, this.mPaint);
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
