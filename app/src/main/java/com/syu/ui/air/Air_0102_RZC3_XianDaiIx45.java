package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0102_RZC3_XianDaiIx45 extends AirBase {
    public Air_0102_RZC3_XianDaiIx45(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0102_rzc3_xiandaiix45/air_rzc3_xiandaiix45.webp";
        this.mPathHighlight = "0102_rzc3_xiandaiix45/air_rzc3_xiandaiix45_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(27.0f, 31.0f, 137.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(224.0f, 99.0f, 293.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(715.0f, 9.0f, 811.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(714.0f, 90.0f, 816.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(892.0f, 21.0f, 1001.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(566.0f, 61.0f, 627.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(534.0f, 82.0f, 582.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(173.0f, 11.0f, 321.0f, 81.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(364.0f, 59.0f, (value * 19) + 364, 119.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -1) {
            c.drawText("NO", 56.0f, 122.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 56.0f, 122.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 56.0f, 122.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 56.0f, 122.0f, this.mPaint);
        }
        int temp2 = this.DATA[11];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 122.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 122.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 122.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 920.0f, 122.0f, this.mPaint);
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
