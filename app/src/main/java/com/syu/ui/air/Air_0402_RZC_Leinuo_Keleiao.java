package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0402_RZC_Leinuo_Keleiao extends AirBase {
    public Air_0402_RZC_Leinuo_Keleiao(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0402_rzc_leinuo/leinuo_keleiao.webp";
        this.mPathHighlight = "0402_rzc_leinuo/leinuo_keleiao_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (((this.DATA[50] >> 7) & 1) != 0) {
            c.clipRect(388.0f, 12.0f, 454.0f, 30.0f, Region.Op.UNION);
        }
        if (((this.DATA[50] >> 6) & 1) != 0) {
            c.clipRect(27.0f, 23.0f, 133.0f, 73.0f, Region.Op.UNION);
        }
        if (((this.DATA[50] >> 4) & 3) == 0) {
            c.clipRect(348.0f, 52.0f, 496.0f, 121.0f, Region.Op.UNION);
        }
        if (((this.DATA[50] >> 3) & 1) != 0) {
            c.clipRect(882.0f, 16.0f, 975.0f, 73.0f, Region.Op.UNION);
        }
        if (((this.DATA[50] >> 2) & 1) != 0) {
            c.clipRect(685.0f, 109.0f, 815.0f, 160.0f, Region.Op.UNION);
        }
        if (((this.DATA[50] >> 1) & 1) != 0) {
            c.clipRect(205.0f, 92.0f, 311.0f, 161.0f, Region.Op.UNION);
        }
        if (((this.DATA[50] >> 0) & 1) != 0) {
            c.clipRect(209.0f, 18.0f, 308.0f, 79.0f, Region.Op.UNION);
        }
        if (((this.DATA[51] >> 7) & 1) != 0) {
            c.clipRect(371.0f, 98.0f, 474.0f, 152.0f, Region.Op.UNION);
        }
        if (((this.DATA[51] >> 2) & 1) != 0) {
            c.clipRect(526.0f, 118.0f, 570.0f, 152.0f, Region.Op.UNION);
        }
        if (((this.DATA[51] >> 1) & 1) != 0) {
            c.clipRect(538.0f, 94.0f, 601.0f, 118.0f, Region.Op.UNION);
        }
        if (((this.DATA[51] >> 0) & 1) != 0) {
            c.clipRect(525.0f, 18.0f, 612.0f, 75.0f, Region.Op.UNION);
        }
        c.clipRect(678.0f, 16.0f, (this.DATA[52] * 18) + 678, 85.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[53] & 255;
        if (value == 254) {
            c.drawText("LOW", 69.0f, 142.0f, this.mPaint);
        } else if (value == 255) {
            c.drawText("HI", 69.0f, 142.0f, this.mPaint);
        } else if (value == 0) {
            c.drawText("NO", 69.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(value / 2.0f), 69.0f, 142.0f, this.mPaint);
        }
        int value2 = this.DATA[54] & 255;
        if (value2 == 254) {
            c.drawText("LOW", 916.0f, 142.0f, this.mPaint);
        } else if (value2 == 255) {
            c.drawText("HI", 916.0f, 142.0f, this.mPaint);
        } else if (value2 == 0) {
            c.drawText("NO", 916.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(value2 / 2.0f), 916.0f, 142.0f, this.mPaint);
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
