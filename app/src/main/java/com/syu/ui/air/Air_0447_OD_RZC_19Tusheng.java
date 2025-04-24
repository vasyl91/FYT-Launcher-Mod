package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0447_OD_RZC_19Tusheng extends AirBase {
    public Air_0447_OD_RZC_19Tusheng(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0447_od_rzc_19tusheng/air_19tusheng_n.webp";
        this.mPathHighlight = "0447_od_rzc_19tusheng/air_19tusheng_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[5] != 0) {
            c.clipRect(353.0f, 101.0f, 430.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(191.0f, 104.0f, 295.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(912.0f, 106.0f, 1003.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(619.0f, 12.0f, 718.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(616.0f, 106.0f, 723.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(493.0f, 60.0f, 553.0f, 95.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(470.0f, 87.0f, 522.0f, 131.0f, Region.Op.UNION);
        }
        if (this.DATA[6] < 62 || this.DATA[6] > 90) {
            c.clipRect(264.0f, 41.0f, 302.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[11] < 62 || this.DATA[11] > 90) {
            c.clipRect(976.0f, 38.0f, 1016.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(323.0f, 15.0f, 454.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        c.clipRect(742.0f, 51.0f, (value * 18) + 742, 115.0f, Region.Op.UNION);
        int value2 = this.DATA[77];
        c.clipRect(15.0f, 97.0f, (value2 * 18) + 15, 158.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[6];
        if (left_temp == -2) {
            c.drawText("LOW", 218.0f, 60.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 218.0f, 60.0f, this.mPaint);
        } else if (left_temp >= 62 && left_temp <= 90) {
            c.drawText(String.valueOf(left_temp), 218.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(17.0f + (left_temp / 2.0f)), 218.0f, 60.0f, this.mPaint);
        }
        int right_temp = this.DATA[11];
        if (right_temp == -2) {
            c.drawText("LOW", 934.0f, 60.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 934.0f, 60.0f, this.mPaint);
        } else if (right_temp >= 62 && right_temp <= 90) {
            c.drawText(String.valueOf(right_temp), 934.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(17.0f + (right_temp / 2.0f)), 934.0f, 60.0f, this.mPaint);
        }
        int rear_temp = this.DATA[78];
        if (rear_temp == -2) {
            c.drawText("LOW", 52.0f, 60.0f, this.mPaint);
        } else if (rear_temp == -3) {
            c.drawText("HI", 52.0f, 60.0f, this.mPaint);
        } else if (rear_temp == -1) {
            c.drawText("----", 52.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(17.0f + (rear_temp / 2.0f)), 52.0f, 60.0f, this.mPaint);
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
