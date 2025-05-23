package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0395_WC2_JietuX70 extends AirBase {
    public Air_0395_WC2_JietuX70(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_ruihu5.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_ruihu5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(0.0f, 23.0f, 141.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(596.0f, 104.0f, 718.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(324.0f, 131.0f, 404.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(902.0f, 22.0f, 1007.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(179.0f, 96.0f, 254.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(163.0f, 24.0f, 272.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(756.0f, 16.0f, 848.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(757.0f, 94.0f, 846.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(318.0f, 10.0f, 389.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(320.0f, 68.0f, 383.0f, 91.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(315.0f, 94.0f, 358.0f, 128.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(590.0f, 16.0f, 724.0f, 76.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(461.0f, 75.0f, 461.0f + (value * 15.6f), 129.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((left_temp * 5) / 10.0f), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((right_temp * 5) / 10.0f), 930.0f, 152.0f, this.mPaint);
        }
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
