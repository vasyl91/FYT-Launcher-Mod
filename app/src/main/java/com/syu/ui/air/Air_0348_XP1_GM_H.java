package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0348_XP1_GM_H extends AirBase {
    public Air_0348_XP1_GM_H(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0253_xp1_yinglang/air_kaidilake.webp";
        this.mPathHighlight = "0253_xp1_yinglang/air_kaidilake_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[107] != 0) {
            c.clipRect(147.0f, 17.0f, 273.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[89] == 0) {
            c.clipRect(144.0f, 112.0f, 273.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[110] != 0) {
            c.clipRect(789.0f, 130.0f, 850.0f, 158.0f, Region.Op.UNION);
            c.clipRect(635.0f, 21.0f, 725.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[111] != 0) {
            c.clipRect(773.0f, 15.0f, 846.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[92] != 0) {
            c.clipRect(342.0f, 12.0f, 440.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[109] != 0) {
            c.clipRect(515.0f, 25.0f, 594.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[108] != 0) {
            c.clipRect(144.0f, 93.0f, 190.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(525.0f, 104.0f, 585.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[99] != 0) {
            c.clipRect(783.0f, 62.0f, 814.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(800.0f, 82.0f, 835.0f, 99.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(777.0f, 99.0f, 809.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(633.0f, 103.0f, 724.0f, 151.0f, Region.Op.UNION);
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.clipRect(86.0f, 40.0f, 127.0f, 77.0f, Region.Op.UNION);
            c.clipRect(980.0f, 43.0f, 1016.0f, 79.0f, Region.Op.UNION);
        }
        this.mRectTmp.set(309, 95, (this.DATA[102] * 20) + 309, 162);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        int value = this.DATA[95];
        if (value >= 13) {
            c.clipRect(14.0f, 96.0f, 60.0f, 152.0f, Region.Op.UNION);
            value = 16 - value;
        } else if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(59.0f, 131.0f, (value * 21) + 59, 155.0f, Region.Op.UNION);
        int value2 = this.DATA[96];
        if (value2 >= 13) {
            c.clipRect(963.0f, 99.0f, 1010.0f, 154.0f, Region.Op.UNION);
            value2 = 16 - value2;
        } else if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(905.0f, 131.0f, (value2 * 21) + 905, 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value3 = this.DATA[97];
        switch (value3) {
            case -3:
                c.drawText("HIGH", 40.0f, 54.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 40.0f, 54.0f, this.mPaint);
                break;
            default:
                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    c.drawText(String.valueOf(((value3 * 9) / 10) + 32), 40.0f, 54.0f, this.mPaint);
                    break;
                } else {
                    int value4 = value3 * 5;
                    c.drawText(value4 / 10 + "." + (value4 % 10), 40.0f, 54.0f, this.mPaint);
                    break;
                }
        }
        int value5 = this.DATA[98];
        switch (value5) {
            case -3:
                c.drawText("HIGH", 932.0f, 54.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 932.0f, 54.0f, this.mPaint);
                break;
            default:
                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    c.drawText(String.valueOf(((value5 * 9) / 10) + 32), 932.0f, 54.0f, this.mPaint);
                    break;
                } else {
                    int value6 = value5 * 5;
                    c.drawText(value6 / 10 + "." + (value6 % 10), 932.0f, 54.0f, this.mPaint);
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
