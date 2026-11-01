package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_Daojun_BydM6 extends AirBase {
    public Air_0439_Daojun_BydM6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_dj_byd_m6/daojun_byd_m6.webp";
        this.mPathHighlight = "0439_dj_byd_m6/daojun_byd_m6_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int left_temp;
        int right_temp;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[13] != 0) {
            this.srPath.addRect(119.0f, 22.0f, 197.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(131.0f, 107.0f, 191.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(237.0f, 20.0f, 331.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(242.0f, 97.0f, 322.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(371.0f, 14.0f, 458.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(383.0f, 86.0f, 429.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(394.0f, 113.0f, 423.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(384.0f, 122.0f, 409.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(393.0f, 143.0f, 442.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(477.0f, 22.0f, 575.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(589.0f, 22.0f, 671.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(810.0f, 27.0f, 907.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(931.0f, 56.0f, 956.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(938.0f, 40.0f, 973.0f, 57.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(513.0f, 95.0f, 513.0f + (value * 15.0f), 150.0f, Path.Direction.CW);
        int value2 = this.DATA[44];
        this.srPath.addRect(810.0f, 102.0f, 810.0f + (value2 * 13.0f), 155.0f, Path.Direction.CW);
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
        int left_temp2 = this.DATA[27];
        if (left_temp2 == -2) {
            c.drawText("LOW", 42.0f, 141.0f, this.mPaint);
        } else if (left_temp2 == -3) {
            c.drawText("HI", 42.0f, 141.0f, this.mPaint);
        } else if (left_temp2 == -1) {
            c.drawText("NONE", 42.0f, 141.0f, this.mPaint);
        } else {
            if (left_temp2 <= 28) {
                left_temp = (left_temp2 * 5) + 165;
            } else {
                left_temp = ((left_temp2 - 34) * 5) + 310;
            }
            c.drawText(String.valueOf(left_temp / 10) + "." + (left_temp % 10), 42.0f, 141.0f, this.mPaint);
        }
        int right_temp2 = this.DATA[28];
        if (right_temp2 == -2) {
            c.drawText("LOW", 725.0f, 141.0f, this.mPaint);
        } else if (right_temp2 == -3) {
            c.drawText("HI", 725.0f, 141.0f, this.mPaint);
        } else if (right_temp2 == -1) {
            c.drawText("NONE", 725.0f, 141.0f, this.mPaint);
        } else {
            if (right_temp2 <= 28) {
                right_temp = (right_temp2 * 5) + 165;
            } else {
                right_temp = ((right_temp2 - 34) * 5) + 310;
            }
            c.drawText(String.valueOf(right_temp / 10) + "." + (right_temp % 10), 725.0f, 141.0f, this.mPaint);
        }
        int rear_temp = this.DATA[40];
        if (rear_temp == -2) {
            c.drawText("LOW", 958.0f, 137.0f, this.mPaint);
        } else if (rear_temp == -3) {
            c.drawText("HI", 958.0f, 137.0f, this.mPaint);
        } else if (rear_temp == -1) {
            c.drawText("NONE", 958.0f, 137.0f, this.mPaint);
        } else {
            int rear_temp2 = (rear_temp * 5) + 175;
            c.drawText(String.valueOf(rear_temp2 / 10) + "." + (rear_temp2 % 10), 958.0f, 137.0f, this.mPaint);
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
