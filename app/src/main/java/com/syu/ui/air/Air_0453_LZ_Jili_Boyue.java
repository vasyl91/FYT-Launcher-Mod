package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0453_LZ_Jili_Boyue extends AirBase {
    public Air_0453_LZ_Jili_Boyue(Context context) {
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(525.0f, 20.0f, 592.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(156.0f, 109.0f, 273.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(756.0f, 20.0f, 868.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(764.0f, 105.0f, 855.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(408.0f, 11.0f, 478.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(640.0f, 15.0f, 725.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(643.0f, 88.0f, 721.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(530.0f, 90.0f, 570.0f, 121.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(535.0f, 120.0f, 565.0f, 134.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(522.0f, 132.0f, 549.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 1) {
            c.clipRect(167.0f, 41.0f, 261.0f, 80.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        c.clipRect(323.0f, 90.0f, (value * 20) + 323, 158.0f, Region.Op.UNION);
        int value2 = this.DATA[21];
        if (value2 != 0) {
            c.clipRect(60.0f, 126.0f, 111.0f, 155.0f, Region.Op.UNION);
        }
        int value3 = this.DATA[22];
        if (value3 != 0) {
            c.clipRect(903.0f, 128.0f, 954.0f, 156.0f, Region.Op.UNION);
        }
        int value4 = this.DATA[23];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(311.0f, 47.0f, 311.0f + (value4 * 17.0f), 71.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[19];
        if (left_temp == -2) {
            c.drawText("LO", 61.0f, 54.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 61.0f, 54.0f, this.mPaint);
        } else {
            int left_temp2 = (left_temp * 10) + 160;
            c.drawText(String.valueOf(left_temp2 / 10) + "." + (left_temp2 % 10), 61.0f, 54.0f, this.mPaint);
        }
        int right_temp = this.DATA[20];
        if (right_temp == -2) {
            c.drawText("LO", 940.0f, 54.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 940.0f, 54.0f, this.mPaint);
        } else {
            int right_temp2 = (right_temp * 10) + 160;
            c.drawText(String.valueOf(right_temp2 / 10) + "." + (right_temp2 % 10), 940.0f, 54.0f, this.mPaint);
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
