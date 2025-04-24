package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0402_RZC_Leinuo_Kabin extends AirBase {
    public Air_0402_RZC_Leinuo_Kabin(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0402_rzc_leinuo/leinuo_kabin.webp";
        this.mPathHighlight = "0402_rzc_leinuo/leinuo_kabin_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[59] != 0) {
            c.clipRect(27.0f, 23.0f, 133.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[63] != 0) {
            c.clipRect(209.0f, 18.0f, 308.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[62] != 0) {
            c.clipRect(205.0f, 92.0f, 311.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[67] != 0) {
            c.clipRect(525.0f, 18.0f, 612.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(538.0f, 94.0f, 601.0f, 118.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(526.0f, 118.0f, 570.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[60] != 0) {
            c.clipRect(348.0f, 52.0f, 496.0f, 121.0f, Region.Op.UNION);
        }
        if (this.DATA[61] != 0) {
            c.clipRect(882.0f, 16.0f, 975.0f, 73.0f, Region.Op.UNION);
        }
        c.clipRect(676.0f, 56.0f, (this.DATA[68] * 16) + 676, 115.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[69];
        if (value == -2) {
            c.drawText("LOW", 69.0f, 142.0f, this.mPaint);
        } else if (value == -3) {
            c.drawText("HI", 69.0f, 142.0f, this.mPaint);
        } else if (value == -1) {
            c.drawText("NO", 69.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(value / 10.0f), 69.0f, 142.0f, this.mPaint);
        }
        int value2 = this.DATA[70];
        if (value2 == -2) {
            c.drawText("LOW", 916.0f, 142.0f, this.mPaint);
        } else if (value2 == -3) {
            c.drawText("HI", 916.0f, 142.0f, this.mPaint);
        } else if (value2 == -1) {
            c.drawText("NO", 916.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(value2 / 10.0f), 916.0f, 142.0f, this.mPaint);
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
