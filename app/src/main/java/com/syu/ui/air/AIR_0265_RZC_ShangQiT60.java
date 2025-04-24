package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class AIR_0265_RZC_ShangQiT60 extends AirBase {
    public AIR_0265_RZC_ShangQiT60(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/rzc_shangqi_t60.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/rzc_shangqi_t60_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[32] != 0) {
            c.clipRect(190.0f, 14.0f, 321.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(184.0f, 92.0f, 329.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[44] != 0) {
            c.clipRect(708.0f, 100.0f, 843.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(544.0f, 19.0f, 660.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(530.0f, 95.0f, 675.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(371.0f, 29.0f, 427.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(389.0f, 64.0f, 440.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(365.0f, 82.0f, 415.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 1) {
            c.clipRect(704.0f, 8.0f, 846.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[92] != 0) {
            c.clipRect(393.0f, 124.0f, 493.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(900.0f, 109.0f, 995.0f, 142.0f, Region.Op.UNION);
        }
        int value = this.DATA[37];
        c.clipRect(888.0f, 37.0f, (value * 15) + 888, 103.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[42];
        if (left_temp == -2) {
            c.drawText("LOW", 70.0f, 80.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 70.0f, 80.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NO", 70.0f, 80.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp), 70.0f, 80.0f, this.mPaint);
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
