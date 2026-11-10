package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0443_WC2_Proton_All extends AirBase {
    public Air_0443_WC2_Proton_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0139_jl_dihaoyuanjing/air_borui_yuanjSUV.webp";
        this.mPathHighlight = "0139_jl_dihaoyuanjing/air_borui_yuanjSUV_p.webp";
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
        if (this.DATA[11] != 0) {
            this.srPath.addRect(525.0f, 20.0f, 592.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(156.0f, 109.0f, 273.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(183.0f, 8.0f, 244.0f, 40.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(756.0f, 20.0f, 868.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(764.0f, 105.0f, 855.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(408.0f, 11.0f, 478.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(640.0f, 15.0f, 725.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(643.0f, 88.0f, 721.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(530.0f, 90.0f, 570.0f, 121.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(535.0f, 120.0f, 565.0f, 134.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(522.0f, 132.0f, 549.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(167.0f, 41.0f, 261.0f, 80.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(323.0f, 90.0f, (value * 20) + 323, 158.0f, Path.Direction.CW);
        int value2 = this.DATA[58];
        if (value2 != 0) {
            this.srPath.addRect(311.0f, 47.0f, 362.0f, 71.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LO", 61.0f, 54.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 61.0f, 54.0f, this.mPaint);
        } else {
            int left_temp2 = left_temp * 5;
            c.drawText(String.valueOf(left_temp2 / 10) + "." + (left_temp2 % 10), 61.0f, 54.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 940.0f, 54.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 940.0f, 54.0f, this.mPaint);
        } else {
            int right_temp2 = right_temp * 5;
            c.drawText(String.valueOf(right_temp2 / 10) + "." + (right_temp2 % 10), 940.0f, 54.0f, this.mPaint);
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
