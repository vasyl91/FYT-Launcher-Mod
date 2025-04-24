package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0167_XBS_MZD extends AirBase {
    public Air_0167_XBS_MZD(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0126_wc1_ga3/air_wc_ga3_n.webp";
        this.mPathHighlight = "0126_wc1_ga3/air_wc_ga3_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[28] != 0) {
            c.clipRect(20.0f, 31.0f, 137.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(153.0f, 99.0f, 224.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(224.0f, 99.0f, 361.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(715.0f, 9.0f, 811.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(714.0f, 90.0f, 816.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(892.0f, 21.0f, 1001.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(534.0f, 71.0f, 592.0f, 30.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(566.0f, 61.0f, 627.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(534.0f, 82.0f, 582.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(173.0f, 11.0f, 321.0f, 81.0f, Region.Op.UNION);
        }
        int value = this.DATA[36];
        c.clipRect(384.0f, 59.0f, (value * 19) + 384, 119.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[37];
        if (left_temp == -1) {
            c.drawText("NO", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((left_temp * 5) / 10.0f), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[38];
        if (right_temp == -1) {
            c.drawText("NO", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((right_temp * 5) / 10.0f), 930.0f, 152.0f, this.mPaint);
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
