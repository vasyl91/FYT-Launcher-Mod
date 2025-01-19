package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.util.ToolkitMath;

public class Air_0025_XP1_GM_H extends AirBase {
    public Air_0025_XP1_GM_H(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0253_xp1_yinglang/air.webp";
        this.mPathHighlight = "0253_xp1_yinglang/air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (this.DATA[107] != 0) {
            c.clipRect(168.0f, 24.0f, 306.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(722.0f, 108.0f, 852.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[110] != 0) {
            c.clipRect(358.0f, 131.0f, 430.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[111] != 0) {
            c.clipRect(356.0f, 20.0f, 418.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[92] != 0) {
            c.clipRect(512.0f, 10.0f, 613.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[109] != 0) {
            c.clipRect(704.0f, 21.0f, 824.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[108] != 0) {
            c.clipRect(693.0f, 89.0f, 739.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(198.0f, 106.0f, 264.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[99] != 0) {
            c.clipRect(359.0f, 63.0f, 395.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(373.0f, 85.0f, 415.0f, 100.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(352.0f, 101.0f, 388.0f, 125.0f, Region.Op.UNION);
        }
        if (TempUnit != 0) {
            c.clipRect(111.0f, 39.0f, 149.0f, 84.0f, Region.Op.UNION);
            c.clipRect(980.0f, 36.0f, 1016.0f, 83.0f, Region.Op.UNION);
        }
        c.clipRect(510.0f, 95.0f, (ToolkitMath.clamp(this.DATA[102], 0, 8) * 19) + ConstRzcAddData.U_CAR_CUR_SPEED, 157.0f, Region.Op.UNION);
        int value = this.DATA[95];
        if (value >= 13) {
            c.clipRect(34.0f, 100.0f, 83.0f, 157.0f, Region.Op.UNION);
            value = 16 - value;
        } else if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(83.0f, 134.0f, (value * 21) + 83, 151.0f, Region.Op.UNION);
        int value2 = this.DATA[96];
        if (value2 >= 13) {
            c.clipRect(955.0f, 101.0f, 1002.0f, 155.0f, Region.Op.UNION);
            value2 = 16 - value2;
        } else if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(897.0f, 137.0f, (value2 * 21) + 897, 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value3 = ToolkitMath.clamp(this.DATA[97], 0, 310);
        switch (value3) {
            case 0:
                c.drawText("LOW", 64.0f, 62.0f, this.mPaint);
                break;
            case 30:
                c.drawText("HIGH", 64.0f, 62.0f, this.mPaint);
                break;
            case 255:
                c.drawText("NO", 64.0f, 62.0f, this.mPaint);
                break;
            default:
                if (TempUnit != 0) {
                    c.drawText(String.valueOf(((value3 * 9) / 50) + 32), 64.0f, 62.0f, this.mPaint);
                    break;
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value3 / 10.0f)), 64.0f, 62.0f, this.mPaint);
                    break;
                }
        }
        int value4 = ToolkitMath.clamp(this.DATA[98], 0, 310);
        switch (value4) {
            case 0:
                c.drawText("LOW", 926.0f, 62.0f, this.mPaint);
                break;
            case 30:
                c.drawText("HIGH", 926.0f, 62.0f, this.mPaint);
                break;
            case 255:
                c.drawText("NO", 926.0f, 62.0f, this.mPaint);
                break;
            default:
                if (TempUnit != 0) {
                    c.drawText(String.valueOf(((value4 * 9) / 50) + 32), 926.0f, 62.0f, this.mPaint);
                    break;
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value4 / 10.0f)), 926.0f, 62.0f, this.mPaint);
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
