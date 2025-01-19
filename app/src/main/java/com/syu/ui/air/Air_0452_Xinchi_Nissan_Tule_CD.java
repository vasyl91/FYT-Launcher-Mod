package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0452_Xinchi_Nissan_Tule_CD extends AirBase {
    public Air_0452_Xinchi_Nissan_Tule_CD(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_xbs_tule/xbs_nissan_tule.webp";
        this.mPathHighlight = "0439_xbs_tule/xbs_nissan_tule_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(500.0f, 24.0f, 560.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[72] != 0) {
            c.clipRect(412.0f, 23.0f, 474.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(722.0f, 8.0f, 844.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(731.0f, 96.0f, 837.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(292.0f, 101.0f, 395.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(184.0f, 9.0f, 267.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(194.0f, 37.0f, 258.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(191.0f, 100.0f, 261.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(594.0f, 22.0f, 665.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(600.0f, 82.0f, 656.0f, 101.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(594.0f, 100.0f, 630.0f, 136.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(293.0f, 18.0f, 395.0f, 69.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(438.0f, 90.0f, (value * 19) + 438, 156.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 76.0f, 98.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 76.0f, 98.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 76.0f, 98.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 76.0f, 98.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 923.0f, 98.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 923.0f, 98.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 923.0f, 98.0f, this.mPaint);
        } else {
            int temp12 = temp1 * 5;
            c.drawText(temp12 / 10 + "." + (temp12 % 10), 923.0f, 98.0f, this.mPaint);
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
