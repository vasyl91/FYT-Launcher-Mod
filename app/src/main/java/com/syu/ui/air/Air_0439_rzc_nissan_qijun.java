package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0439_rzc_nissan_qijun extends AirBase {
    public Air_0439_rzc_nissan_qijun(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0174_xp_mengdiou/xp_mengdiou.webp";
        this.mPathHighlight = "0174_xp_mengdiou/xp_mengdiou_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String str;
        String str2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(152.0f, 24.0f, 288.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(748.0f, 10.0f, 873.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(4.0f, 93.0f, 143.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(909.0f, 93.0f, 988.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(458.0f, 18.0f, 555.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(471.0f, 88.0f, 536.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(458.0f, 110.0f, 506.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(168.0f, 97.0f, 280.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(299.0f, 62.0f, 432.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(772.0f, 92.0f, 860.0f, 164.0f, Region.Op.UNION);
        }
        int value = this.DATA[17];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(613.0f, 77.0f, (value * 15) + 613, 137.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = this.DATA[18];
        switch (value2) {
            case -3:
                str = "HI";
                break;
            case -2:
                str = "LO";
                break;
            case -1:
                str = "NO";
                break;
            default:
                str = String.valueOf(value2 / 2.0f);
                break;
        }
        c.drawText(str, 60.0f, 60.0f, this.mPaint);
        int value3 = this.DATA[19];
        switch (value3) {
            case -3:
                str2 = "HI";
                break;
            case -2:
                str2 = "LO";
                break;
            case -1:
                str2 = "NO";
                break;
            default:
                str2 = String.valueOf(value3 / 2.0f);
                break;
        }
        c.drawText(str2, 940.0f, 60.0f, this.mPaint);
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
