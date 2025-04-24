package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0385_HC_Accord8 extends AirBase {
    public Air_0385_HC_Accord8(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0385_hc_accord8/air_hc_accord8.webp";
        this.mPathHighlight = "0385_hc_accord8/air_hc_accord8_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] == 2) {
            c.clipRect(214.0f, 69.0f, 295.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(722.0f, 76.0f, 827.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(548.0f, 60.0f, 620.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(546.0f, 84.0f, 587.0f, 126.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(366.0f, 73.0f, (value * 18) + 366, 124.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[10];
        if (temp == 1) {
            c.drawText("LOW", 80.0f, 95.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HIGH", 80.0f, 95.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp), 80.0f, 95.0f, this.mPaint);
        }
        int temp2 = this.DATA[11];
        if (temp2 == 1) {
            c.drawText("LOW", 915.0f, 95.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HIGH", 915.0f, 95.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2), 915.0f, 95.0f, this.mPaint);
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
