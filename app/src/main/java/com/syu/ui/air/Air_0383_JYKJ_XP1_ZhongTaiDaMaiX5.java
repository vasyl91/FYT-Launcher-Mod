package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0383_JYKJ_XP1_ZhongTaiDaMaiX5 extends AirBase {
    public Air_0383_JYKJ_XP1_ZhongTaiDaMaiX5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0383_jykj_zhongtaidamaix5/damaix5.webp";
        this.mPathHighlight = "0383_jykj_zhongtaidamaix5/damaix5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(8.0f, 101.0f, 166.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(906.0f, 93.0f, 982.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(715.0f, 18.0f, 826.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(198.0f, 32.0f, 324.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(362.0f, 36.0f, 419.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(375.0f, 69.0f, 442.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(349.0f, 92.0f, 412.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 1) {
            c.clipRect(691.0f, 95.0f, 842.0f, 156.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        c.clipRect(549.0f, 67.0f, (value * 18) + 549, 128.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[5];
        if (left_temp == -2) {
            c.drawText("LOW", 56.0f, 70.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 56.0f, 70.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp), 56.0f, 70.0f, this.mPaint);
        }
        int right_temp = this.DATA[10];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 70.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 70.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp), 930.0f, 70.0f, this.mPaint);
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
