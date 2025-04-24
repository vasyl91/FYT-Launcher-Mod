package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_Daojun_BydM6 extends AirBase {
    public Air_0439_Daojun_BydM6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_dj_byd_m6/daojun_byd_m6.webp";
        this.mPathHighlight = "0439_dj_byd_m6/daojun_byd_m6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int left_temp;
        int right_temp;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[20] != 0) {
            c.clipRect(119.0f, 22.0f, 197.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(131.0f, 107.0f, 191.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(237.0f, 20.0f, 331.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(242.0f, 97.0f, 322.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(371.0f, 14.0f, 458.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(383.0f, 86.0f, 429.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(394.0f, 113.0f, 423.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(384.0f, 122.0f, 409.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(393.0f, 143.0f, 442.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(477.0f, 22.0f, 575.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(589.0f, 22.0f, 671.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(810.0f, 27.0f, 907.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(931.0f, 56.0f, 956.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(938.0f, 40.0f, 973.0f, 57.0f, Region.Op.UNION);
        }
        int value = this.DATA[7];
        c.clipRect(513.0f, 95.0f, 513.0f + (value * 15.0f), 150.0f, Region.Op.UNION);
        int value2 = this.DATA[25];
        c.clipRect(810.0f, 102.0f, 810.0f + (value2 * 13.0f), 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp2 = this.DATA[18];
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
            c.drawText(left_temp / 10 + "." + (left_temp % 10), 42.0f, 141.0f, this.mPaint);
        }
        int right_temp2 = this.DATA[19];
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
            c.drawText(right_temp / 10 + "." + (right_temp % 10), 725.0f, 141.0f, this.mPaint);
        }
        int rear_temp = this.DATA[24];
        if (rear_temp == -2) {
            c.drawText("LOW", 958.0f, 137.0f, this.mPaint);
        } else if (rear_temp == -3) {
            c.drawText("HI", 958.0f, 137.0f, this.mPaint);
        } else if (rear_temp == -1) {
            c.drawText("NONE", 958.0f, 137.0f, this.mPaint);
        } else {
            int rear_temp2 = (rear_temp * 5) + 175;
            c.drawText(rear_temp2 / 10 + "." + (rear_temp2 % 10), 958.0f, 137.0f, this.mPaint);
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
