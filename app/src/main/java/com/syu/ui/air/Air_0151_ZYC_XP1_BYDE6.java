package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0151_ZYC_XP1_BYDE6 extends AirBase {
    public Air_0151_ZYC_XP1_BYDE6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0151_daojun_xp1_byds6/air_zyc_xp1_byde6_n.webp";
        this.mPathHighlight = "0151_daojun_xp1_byds6/air_zyc_xp1_byde6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(17.0f, 17.0f, 157.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(205.0f, 98.0f, 297.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(877.0f, 59.0f, 992.0f, 105.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(692.0f, 88.0f, 842.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(212.0f, 12.0f, 311.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(337.0f, 11.0f, 427.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(376.0f, 7.0f, 462.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(390.0f, 69.0f, 453.0f, 93.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(379.0f, 92.0f, 421.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 1) {
            c.clipRect(397.0f, 135.0f, 477.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[22] == 1) {
            c.clipRect(120.0f, 112.0f, 165.0f, 159.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(538.0f, 63.0f, (value * 20) + 538, 127.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[21];
        switch (temp) {
            case -3:
                c.drawText("HI", 55.0f, 152.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 55.0f, 152.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NONE", 55.0f, 152.0f, this.mPaint);
                break;
            default:
                c.drawText(String.valueOf(temp), 55.0f, 152.0f, this.mPaint);
                break;
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
