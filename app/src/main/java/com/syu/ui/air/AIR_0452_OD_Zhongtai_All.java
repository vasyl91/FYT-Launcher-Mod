package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class AIR_0452_OD_Zhongtai_All extends AirBase {
    public AIR_0452_OD_Zhongtai_All(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/jili_boyue.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/jili_boyue_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(753.0f, 100.0f, 854.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(10.0f, 26.0f, 140.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(303.0f, 101.0f, 426.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(596.0f, 102.0f, 715.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(602.0f, 22.0f, 713.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(893.0f, 19.0f, 1000.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(171.0f, 12.0f, 271.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(178.0f, 94.0f, 269.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(458.0f, 10.0f, 538.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(465.0f, 91.0f, 520.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(454.0f, 118.0f, 501.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 1) {
            c.clipRect(296.0f, 11.0f, 436.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[17];
        c.clipRect(753.0f, 38.0f, (value * 15) + 753, 83.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[19];
        if (left_temp == -2) {
            c.drawText("LOW", 56.0f, 138.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 56.0f, 138.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NO", 56.0f, 138.0f, this.mPaint);
        } else {
            int left_temp2 = (left_temp * 5) + 175;
            c.drawText(left_temp2 / 10 + "." + (left_temp2 % 10), 56.0f, 138.0f, this.mPaint);
        }
        int right_temp = this.DATA[20];
        if (DataCanbus.DATA[1000] == 65801) {
            right_temp = this.DATA[19];
        }
        if (right_temp == -2) {
            c.drawText("LOW", 935.0f, 138.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 935.0f, 138.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("NO", 935.0f, 138.0f, this.mPaint);
        } else {
            int right_temp2 = (right_temp * 5) + 175;
            c.drawText(right_temp2 / 10 + "." + (right_temp2 % 10), 935.0f, 138.0f, this.mPaint);
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
