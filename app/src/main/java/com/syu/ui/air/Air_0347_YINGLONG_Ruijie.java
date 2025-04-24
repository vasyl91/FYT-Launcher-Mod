package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0347_YINGLONG_Ruijie extends AirBase {
    public Air_0347_YINGLONG_Ruijie(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0347_yinglong_ruijie/yinglongruijie.webp";
        this.mPathHighlight = "0347_yinglong_ruijie/yinglongruijie_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(173.0f, 54.0f, 269.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(180.0f, 12.0f, 258.0f, 51.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(593.0f, 14.0f, 657.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(598.0f, 81.0f, 661.0f, 116.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(594.0f, 111.0f, 640.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(316.0f, 45.0f, 424.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(5.0f, 17.0f, 144.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(742.0f, 52.0f, 867.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(887.0f, 17.0f, 1015.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(764.0f, 13.0f, 855.0f, 51.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(101.0f, 101.0f, 145.0f, 153.0f, Region.Op.UNION);
            c.clipRect(981.0f, 104.0f, 1019.0f, 151.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(471.0f, 81.0f, (value * 15) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D1_B76, 154.0f, Region.Op.UNION);
        int value2 = this.DATA[10];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(194.0f, 121.0f, (value2 * 11) + 194, 163.0f, Region.Op.UNION);
        int value3 = this.DATA[11];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(797.0f, 121.0f, (value3 * 11) + 797, 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value4 = this.DATA[5];
        switch (value4) {
            case -3:
                c.drawText("HIGH", 45.0f, 136.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 45.0f, 136.0f, this.mPaint);
                break;
            default:
                if (this.DATA[16] != 0) {
                    c.drawText(String.format("%.1f", Float.valueOf(value4 / 10.0f)), 45.0f, 136.0f, this.mPaint);
                    break;
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value4 / 10.0f)), 45.0f, 136.0f, this.mPaint);
                    break;
                }
        }
        int value5 = this.DATA[12];
        switch (value5) {
            case -3:
                c.drawText("HIGH", 930.0f, 136.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 930.0f, 136.0f, this.mPaint);
                break;
            default:
                if (this.DATA[16] != 0) {
                    c.drawText(String.format("%.1f", Float.valueOf(value5 / 10.0f)), 930.0f, 136.0f, this.mPaint);
                    break;
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value5 / 10.0f)), 930.0f, 136.0f, this.mPaint);
                    break;
                }
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
