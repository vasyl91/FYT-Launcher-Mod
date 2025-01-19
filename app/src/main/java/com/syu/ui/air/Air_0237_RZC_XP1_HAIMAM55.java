package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0237_RZC_XP1_HAIMAM55 extends AirBase {
    public Air_0237_RZC_XP1_HAIMAM55(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0237_rzc_xp1_haima55/air_rzc_xp_haima_m5_n.webp";
        this.mPathHighlight = "0237_rzc_xp1_haima55/air_rzc_xp_haima_m5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[0] != 0) {
            c.clipRect(14.0f, 22.0f, 161.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(909.0f, 18.0f, 974.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(223.0f, 106.0f, 330.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(738.0f, 95.0f, 816.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(724.0f, 13.0f, 827.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(559.0f, 44.0f, 622.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(568.0f, 82.0f, 631.0f, 101.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(552.0f, 99.0f, 603.0f, 139.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(197.0f, 15.0f, 347.0f, 79.0f, Region.Op.UNION);
        }
        int value = this.DATA[7];
        c.clipRect(401.0f, 63.0f, (value * 18) + 401, 115.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[8];
        int unit = this.DATA[10];
        if (unit == 0) {
            c.drawText("℃", 138.0f, 152.0f, this.mPaint);
            c.drawText("℃", 977.0f, 152.0f, this.mPaint);
        } else {
            c.drawText("℉", 138.0f, 152.0f, this.mPaint);
            c.drawText("℉", 977.0f, 152.0f, this.mPaint);
        }
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else if (unit == 0) {
            c.drawText(String.valueOf(left_temp / 2.0f), 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[9];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else if (unit == 0) {
            c.drawText(String.valueOf(right_temp / 2.0f), 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp), 930.0f, 152.0f, this.mPaint);
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
