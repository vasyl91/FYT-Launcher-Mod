package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0280_RZC_XP1_ChuangQiGs4 extends AirBase {
    public Air_0280_RZC_XP1_ChuangQiGs4(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0280_rzc_xp1_chuangqigs4/air_rzc_xp1_gs4_n.webp";
        this.mPathHighlight = "0280_rzc_xp1_chuangqigs4/air_rzc_xp1_gs4_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[2] != 0) {
            c.clipRect(201.0f, 23.0f, 316.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(214.0f, 105.0f, 305.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(36.0f, 23.0f, 134.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(715.0f, 12.0f, 809.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(727.0f, 90.0f, 814.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(385.0f, 89.0f, 433.0f, 118.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(386.0f, 128.0f, 424.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(872.0f, 16.0f, 1005.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 1) {
            c.clipRect(530.0f, 7.0f, 673.0f, 76.0f, Region.Op.UNION);
        }
        int value = this.DATA[12];
        c.clipRect(548.0f, 94.0f, (value * 18) + 548, 159.0f, Region.Op.UNION);
        int value2 = this.DATA[13];
        c.clipRect(376.0f, 17.0f, (value2 * 18) + 376, 81.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[7];
        if (left_temp == -2) {
            c.drawText("LOW", 65.0f, 140.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 65.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 100.0f), 65.0f, 140.0f, this.mPaint);
        }
        int right_temp = this.DATA[15];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 140.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 100.0f), 930.0f, 140.0f, this.mPaint);
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
