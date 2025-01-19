package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;

import com.android.launcher66.LauncherApplication;

public class Air_0274_DJ_XP1_ACCORD7 extends AirBase {
    public Air_0274_DJ_XP1_ACCORD7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0274_dj_xp1_accord7/air_0274_dj_xp1_accord7_n.webp";
        this.mPathHighlight = "0274_dj_xp1_accord7/air_0274_dj_xp1_accord7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[25] != 0) {
            c.clipRect(166.0f, 20.0f, 276.0f, 74.0f, Region.Op.UNION);
        }
        switch (this.DATA[15]) {
            case 2:
                c.clipRect(190.0f, 98.0f, 265.0f, 138.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(190.0f, 98.0f, 265.0f, 138.0f, Region.Op.UNION);
                c.clipRect(191.0f, 140.0f, 254.0f, 160.0f, Region.Op.UNION);
                break;
        }
        if (this.DATA[11] != 0) {
            c.clipRect(9.0f, 24.0f, 133.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(896.0f, 13.0f, 1005.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(602.0f, 40.0f, 720.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(741.0f, 11.0f, 817.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(766.0f, 131.0f, 830.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(759.0f, 69.0f, 818.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(743.0f, 95.0f, 785.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(457.0f, 47.0f, 583.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(337.0f, 123.0f, 417.0f, 149.0f, Region.Op.UNION);
        }
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (tempunit == 1) {
            c.clipRect(105.0f, 115.0f, 140.0f, 155.0f, Region.Op.UNION);
            c.clipRect(976.0f, 116.0f, 1014.0f, 156.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(310.0f, 55.0f, (value * 18) + 310, 122.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[22];
        if (left_temp == -2) {
            c.drawText("LOW", 60.0f, 136.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 60.0f, 136.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.valueOf(((left_temp * 9) / 5) + 32), 60.0f, 136.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp), 60.0f, 136.0f, this.mPaint);
        }
        int right_temp = this.DATA[23];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 136.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 136.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.valueOf(((right_temp * 9) / 5) + 32), 930.0f, 136.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp), 930.0f, 136.0f, this.mPaint);
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
