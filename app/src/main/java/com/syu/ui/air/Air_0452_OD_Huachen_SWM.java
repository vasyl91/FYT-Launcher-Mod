package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_OD_Huachen_SWM extends AirBase {
    public Air_0452_OD_Huachen_SWM(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0151_daojun_xp1_byds6/ansheng_byd_yuan.webp";
        this.mPathHighlight = "0151_daojun_xp1_byds6/ansheng_byd_yuan_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(18.0f, 21.0f, 159.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(224.0f, 113.0f, 288.0f, 1486.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(224.0f, 113.0f, 288.0f, 1486.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(380.0f, 91.0f, 420.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(389.0f, 68.0f, 445.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(381.0f, 8.0f, 456.0f, 59.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(722.0f, 18.0f, 827.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(208.0f, 12.0f, 314.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(711.0f, 98.0f, 842.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(884.0f, 22.0f, 995.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(539.0f, 61.0f, (value * 20) + 539, 124.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(20.0f);
        if (this.DATA[12] != 0) {
            c.drawText("MAX", 202.0f, 112.0f, this.mPaint);
        } else {
            c.drawText("", 202.0f, 112.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[19];
        switch (temp) {
            case -3:
                c.drawText("HI", 70.0f, 132.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 70.0f, 132.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 70.0f, 132.0f, this.mPaint);
                break;
            default:
                c.drawText(String.valueOf(((temp * 5) + 160) / 10.0f), 70.0f, 132.0f, this.mPaint);
                break;
        }
        int temp2 = this.DATA[20];
        switch (temp2) {
            case -3:
                c.drawText("HI", 920.0f, 132.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 920.0f, 132.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 920.0f, 132.0f, this.mPaint);
                break;
            default:
                c.drawText(String.valueOf(((temp2 * 5) + 160) / 10.0f), 920.0f, 132.0f, this.mPaint);
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
