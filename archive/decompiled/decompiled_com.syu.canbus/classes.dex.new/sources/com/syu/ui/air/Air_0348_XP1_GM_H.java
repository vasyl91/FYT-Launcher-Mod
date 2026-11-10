package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0348_XP1_GM_H extends AirBase {
    public Air_0348_XP1_GM_H(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0253_xp1_yinglang/air_kaidilake.webp";
        this.mPathHighlight = "0253_xp1_yinglang/air_kaidilake_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(147.0f, 17.0f, 273.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(144.0f, 112.0f, 273.0f, 155.0f, Path.Direction.CW);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                if (this.DATA[49] != 0) {
                    this.srPath.addRect(789.0f, 130.0f, 850.0f, 158.0f, Path.Direction.CW);
                }
                if (this.DATA[13] != 0) {
                    this.srPath.addRect(635.0f, 21.0f, 725.0f, 74.0f, Path.Direction.CW);
                }
                break;
            default:
                if (this.DATA[49] != 0) {
                    this.srPath.addRect(789.0f, 130.0f, 850.0f, 158.0f, Path.Direction.CW);
                    this.srPath.addRect(635.0f, 21.0f, 725.0f, 74.0f, Path.Direction.CW);
                }
                break;
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(773.0f, 15.0f, 846.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(342.0f, 12.0f, 440.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(515.0f, 25.0f, 594.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(144.0f, 93.0f, 190.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(525.0f, 104.0f, 585.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(783.0f, 62.0f, 814.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(800.0f, 82.0f, 835.0f, 99.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(777.0f, 99.0f, 809.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(633.0f, 103.0f, 724.0f, 151.0f, Path.Direction.CW);
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(86.0f, 40.0f, 127.0f, 77.0f, Path.Direction.CW);
            this.srPath.addRect(980.0f, 43.0f, 1016.0f, 79.0f, Path.Direction.CW);
        }
        this.mRectTmp.set(309.0f, 95.0f, (this.DATA[21] * 20) + 309, 162.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        int value = this.DATA[29];
        if (value >= 13) {
            this.srPath.addRect(14.0f, 96.0f, 60.0f, 152.0f, Path.Direction.CW);
            value = 16 - value;
        } else if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        this.srPath.addRect(59.0f, 131.0f, (value * 21) + 59, 155.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if (value2 >= 13) {
            this.srPath.addRect(963.0f, 99.0f, 1010.0f, 154.0f, Path.Direction.CW);
            value2 = 16 - value2;
        } else if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(905.0f, 131.0f, (value2 * 21) + 905, 155.0f, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value3 = this.DATA[27];
        switch (value3) {
            case -3:
                c.drawText("HIGH", 40.0f, 54.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 40.0f, 54.0f, this.mPaint);
                break;
            default:
                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    c.drawText(new StringBuilder(String.valueOf(((value3 * 9) / 10) + 32)).toString(), 40.0f, 54.0f, this.mPaint);
                } else {
                    int value4 = value3 * 5;
                    c.drawText(String.valueOf(value4 / 10) + "." + (value4 % 10), 40.0f, 54.0f, this.mPaint);
                }
                break;
        }
        int value5 = this.DATA[28];
        switch (value5) {
            case -3:
                c.drawText("HIGH", 932.0f, 54.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 932.0f, 54.0f, this.mPaint);
                break;
            default:
                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    c.drawText(new StringBuilder(String.valueOf(((value5 * 9) / 10) + 32)).toString(), 932.0f, 54.0f, this.mPaint);
                } else {
                    int value6 = value5 * 5;
                    c.drawText(String.valueOf(value6 / 10) + "." + (value6 % 10), 932.0f, 54.0f, this.mPaint);
                }
                break;
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
