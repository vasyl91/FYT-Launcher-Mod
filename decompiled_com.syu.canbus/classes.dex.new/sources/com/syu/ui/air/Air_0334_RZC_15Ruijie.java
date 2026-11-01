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
public class Air_0334_RZC_15Ruijie extends AirBase {
    public Air_0334_RZC_15Ruijie(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0293_wc3_15ruijie/rzc_ford_all_n.webp";
        this.mPathHighlight = "0293_wc3_15ruijie/rzc_ford_all_p.webp";
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
            this.srPath.addRect(154.0f, 28.0f, 283.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(304.0f, 127.0f, 430.0f, 174.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(892.0f, 27.0f, 1009.0f, 92.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(299.0f, 19.0f, 434.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(607.0f, 13.0f, 708.0f, 91.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(461.0f, 114.0f, 564.0f, 185.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(608.0f, 110.0f, 711.0f, 192.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 1 || this.DATA[53] != 0) {
            this.srPath.addRect(47.0f, 133.0f, 107.0f, 167.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(911.0f, 103.0f, 965.0f, 139.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(923.0f, 137.0f, 959.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(915.0f, 149.0f, 947.0f, 173.0f, Path.Direction.CW);
        }
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (this.DATA[37] == 1 || TempUnit == 1) {
            this.srPath.addRect(107.0f, 52.0f, 143.0f, 97.0f, Path.Direction.CW);
            this.srPath.addRect(827.0f, 56.0f, 869.0f, 95.0f, Path.Direction.CW);
            this.srPath.addRect(970.0f, 242.0f, 1014.0f, 285.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(451.0f, 36.0f, (value * 18) + 451, 98.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 > 3) {
            value2 -= 3;
        } else {
            this.srPath.addRect(153.0f, 111.0f, 208.0f, 177.0f, Path.Direction.CW);
        }
        this.srPath.addRect(205.0f, 155.0f, (value2 * 24) + 205, 178.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 > 3) {
            value3 -= 3;
        } else {
            this.srPath.addRect(816.0f, 111.0f, 871.0f, 177.0f, Path.Direction.CW);
        }
        this.srPath.addRect(749.0f, 155.0f, (value3 * 24) + 749, 178.0f, Path.Direction.CW);
        if (this.DATA[42] != 0) {
            this.srPath.addRect(224.0f, 221.0f, 381.0f, 270.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(435.0f, 223.0f, 599.0f, 271.0f, Path.Direction.CW);
        }
        int value4 = this.DATA[44];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 7) {
            value4 = 7;
        }
        this.srPath.addRect(661.0f, 229.0f, (value4 * 21) + 661, 293.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(18.0f);
        if (this.DATA[53] != 0) {
            c.drawText("MAX", 30.0f, 130.0f, this.mPaint);
        } else {
            c.drawText("  ", 30.0f, 130.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Mustang_HY_LEFT /* 2687310 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_RIGHT /* 2752846 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_LOW /* 2818382 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_H /* 2883918 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_10 /* 3342670 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_12 /* 3408206 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_10_Auto /* 3473742 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_12_Auto /* 3539278 */:
                if (temp == -2) {
                    c.drawText("LO", 51.0f, 78.0f, this.mPaint);
                } else if (temp == -3) {
                    c.drawText("HI", 51.0f, 78.0f, this.mPaint);
                } else if (temp == -1) {
                    c.drawText("NO", 51.0f, 78.0f, this.mPaint);
                } else if (this.DATA[37] == 1) {
                    c.drawText(new StringBuilder(String.valueOf(temp / 10)).toString(), 51.0f, 78.0f, this.mPaint);
                } else if (TempUnit == 1) {
                    c.drawText(new StringBuilder(String.valueOf(((temp * 10) + 270) / 10)).toString(), 51.0f, 78.0f, this.mPaint);
                } else {
                    c.drawText(new StringBuilder(String.valueOf(temp * 0.5f)).toString(), 51.0f, 78.0f, this.mPaint);
                }
                break;
            default:
                if (temp == 1048576) {
                    c.drawText("LO", 51.0f, 78.0f, this.mPaint);
                } else if (temp == 1048577) {
                    c.drawText("HI", 51.0f, 78.0f, this.mPaint);
                } else if (temp == 1048578) {
                    c.drawText("NO", 51.0f, 78.0f, this.mPaint);
                } else if (this.DATA[37] == 1) {
                    c.drawText(new StringBuilder(String.valueOf(temp / 10)).toString(), 51.0f, 78.0f, this.mPaint);
                } else if (TempUnit == 1) {
                    c.drawText(new StringBuilder(String.valueOf((((((temp * 9) / 5) + 320) / 10) * 10) / 10)).toString(), 51.0f, 78.0f, this.mPaint);
                } else {
                    c.drawText(new StringBuilder(String.valueOf(temp * 0.1f)).toString(), 51.0f, 78.0f, this.mPaint);
                }
                break;
        }
        int temp2 = this.DATA[28];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Mustang_HY_LEFT /* 2687310 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_RIGHT /* 2752846 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_LOW /* 2818382 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_H /* 2883918 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_10 /* 3342670 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_12 /* 3408206 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_10_Auto /* 3473742 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_12_Auto /* 3539278 */:
                if (temp2 == -2) {
                    c.drawText("LO", 780.0f, 78.0f, this.mPaint);
                } else if (temp2 == -3) {
                    c.drawText("HI", 780.0f, 78.0f, this.mPaint);
                } else if (temp2 == -1) {
                    c.drawText("NO", 780.0f, 78.0f, this.mPaint);
                } else if (this.DATA[37] == 1) {
                    c.drawText(new StringBuilder(String.valueOf(temp2 / 10)).toString(), 780.0f, 78.0f, this.mPaint);
                } else if (TempUnit == 1) {
                    c.drawText(new StringBuilder(String.valueOf(((temp2 * 10) + 270) / 10)).toString(), 780.0f, 78.0f, this.mPaint);
                } else {
                    c.drawText(new StringBuilder(String.valueOf(temp2 * 0.5f)).toString(), 780.0f, 78.0f, this.mPaint);
                }
                break;
            default:
                if (temp2 == 1048576) {
                    c.drawText("LO", 780.0f, 78.0f, this.mPaint);
                } else if (temp2 == 1048577) {
                    c.drawText("HI", 780.0f, 78.0f, this.mPaint);
                } else if (temp2 == 1048578) {
                    c.drawText("NO", 780.0f, 78.0f, this.mPaint);
                } else if (this.DATA[37] == 1) {
                    c.drawText(new StringBuilder(String.valueOf(temp2 / 10)).toString(), 780.0f, 78.0f, this.mPaint);
                } else if (TempUnit == 1) {
                    c.drawText(new StringBuilder(String.valueOf((((((temp2 * 9) / 5) + 320) / 10) * 10) / 10)).toString(), 780.0f, 78.0f, this.mPaint);
                } else {
                    c.drawText(new StringBuilder(String.valueOf(temp2 * 0.1f)).toString(), 780.0f, 78.0f, this.mPaint);
                }
                break;
        }
        int temp3 = this.DATA[40];
        if (((temp3 >> 7) & 1) == 0) {
            if (temp3 == 0) {
                c.drawText("LO", 895.0f, 257.0f, this.mPaint);
            } else if (temp3 == 9) {
                c.drawText("HI", 895.0f, 257.0f, this.mPaint);
            } else if (temp3 == 126) {
                c.drawText("NO", 895.0f, 257.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder(String.valueOf(temp3)).toString(), 895.0f, 257.0f, this.mPaint);
            }
        } else {
            int temp4 = temp3 & 127;
            if (temp4 == 0) {
                c.drawText("LO", 895.0f, 257.0f, this.mPaint);
            } else if (temp4 == 127) {
                c.drawText("HI", 895.0f, 257.0f, this.mPaint);
            } else if (this.DATA[37] == 1 || TempUnit == 1) {
                c.drawText(new StringBuilder(String.valueOf(((temp4 * 9) + 320) / 10)).toString(), 895.0f, 257.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder(String.valueOf(temp4 * 0.5f)).toString(), 895.0f, 257.0f, this.mPaint);
            }
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
