package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.util.ToolkitMath;

public class Air_0348_XP1_GM_H2 extends AirBase {
    private int nWindLevelLeft;

    public Air_0348_XP1_GM_H2(Context context) {
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
        boolean invalidate = false;
        c.clipRect(this.mRectEmpty);
        if (this.DATA[107] != 0) {
            c.clipRect(168.0f, 24.0f, 306.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[89] == 0) {
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
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.clipRect(112.0f, 41.0f, 149.0f, 76.0f, Region.Op.UNION);
            c.clipRect(979.0f, 42.0f, 1015.0f, 78.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[102], 0, 8);
        if (this.nWindLevelLeft != value) {
            invalidate = true;
            if (this.nWindLevelLeft < value) {
                this.nWindLevelLeft++;
            } else {
                this.nWindLevelLeft--;
            }
        }
        this.mRectTmp.set(ConstRzcAddData.U_CAR_CUR_SPEED, 95, (value * 19) + ConstRzcAddData.U_CAR_CUR_SPEED, 157);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        int value2 = this.DATA[95];
        if (value2 >= 13) {
            c.clipRect(34.0f, 100.0f, 83.0f, 157.0f, Region.Op.UNION);
            value2 = 16 - value2;
        } else if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(83.0f, 134.0f, (value2 * 21) + 83, 151.0f, Region.Op.UNION);
        int value3 = this.DATA[96];
        if (value3 >= 13) {
            c.clipRect(955.0f, 101.0f, 1002.0f, 155.0f, Region.Op.UNION);
            value3 = 16 - value3;
        } else if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(897.0f, 137.0f, (value3 * 21) + 897, 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value4 = this.DATA[97];
        switch (value4) {
            case -3:
                c.drawText("HIGH", 64.0f, 62.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 64.0f, 62.0f, this.mPaint);
                break;
            default:
                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    c.drawText(String.valueOf(((value4 * 9) / 10) + 32), 64.0f, 62.0f, this.mPaint);
                    break;
                } else {
                    int value5 = value4 * 5;
                    c.drawText(value5 / 10 + "." + (value5 % 10), 64.0f, 62.0f, this.mPaint);
                    break;
                }
        }
        int value6 = this.DATA[98];
        switch (value6) {
            case -3:
                c.drawText("HIGH", 926.0f, 62.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 926.0f, 62.0f, this.mPaint);
                break;
            default:
                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    c.drawText(String.valueOf(((value6 * 9) / 10) + 32), 926.0f, 62.0f, this.mPaint);
                    break;
                } else {
                    int value7 = value6 * 5;
                    c.drawText(value7 / 10 + "." + (value7 % 10), 926.0f, 62.0f, this.mPaint);
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
        if (invalidate) {
            invalidate();
        }
    }
}
