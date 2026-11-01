package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0454_LZ_GMC_All extends AirBase {
    public Air_0454_LZ_GMC_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0036_wc2_gm/air_gl6_wc.webp";
        this.mPathHighlight = "0036_wc2_gm/air_gl6_wc_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int temp;
        int temp2;
        int temp3;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(21.0f, 29.0f, 193.0f, 86.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(37.0f, 211.0f, 164.0f, 284.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(699.0f, 7.0f, 830.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(729.0f, 61.0f, 805.0f, 95.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(387.0f, 13.0f, 474.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(468.0f, 206.0f, 565.0f, 285.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(388.0f, 76.0f, 469.0f, 99.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(727.0f, 149.0f, 822.0f, 180.0f, Path.Direction.CW);
        }
        if (this.DATA[55] != 0) {
            this.srPath.addRect(728.0f, 113.0f, 812.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[76] != 0) {
            this.srPath.addRect(549.0f, 9.0f, 653.0f, 98.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(525.0f, 105.0f, 587.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(559.0f, 147.0f, 599.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(529.0f, 163.0f, 573.0f, 194.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(596.0f, 104.0f, 673.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(668.0f, 201.0f, 741.0f, 229.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(696.0f, 232.0f, 742.0f, 257.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(674.0f, 257.0f, 711.0f, 287.0f, Path.Direction.CW);
        }
        if (this.DATA[81] != 0) {
            this.srPath.addRect(944.0f, 239.0f, 1019.0f, 277.0f, Path.Direction.CW);
        }
        int TempUnit = this.DATA[37];
        if (TempUnit == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(290.0f, 150.0f, 329.0f, 189.0f, Path.Direction.CW);
            this.srPath.addRect(968.0f, 149.0f, 1005.0f, 186.0f, Path.Direction.CW);
            this.srPath.addRect(365.0f, 242.0f, 402.0f, 280.0f, Path.Direction.CW);
        }
        if ((this.DATA[29] & 8) != 0) {
            this.srPath.addRect(189.0f, 23.0f, 248.0f, 84.0f, Path.Direction.CW);
        }
        if ((this.DATA[30] & 8) != 0) {
            this.srPath.addRect(951.0f, 26.0f, 1004.0f, 83.0f, Path.Direction.CW);
        }
        int value = this.DATA[29];
        if ((value & 8) != 0) {
            value = 16 - value;
        }
        this.srPath.addRect(249.0f, 57.0f, (value * 20) + 249, 84.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if ((value2 & 8) != 0) {
            value2 = 16 - value2;
        }
        this.srPath.addRect(886.0f, 59.0f, (value2 * 21) + 886, 86.0f, Path.Direction.CW);
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
        int Rearlevel = this.DATA[44];
        if (Rearlevel == 5) {
            c.drawText("AUTO", 932.0f, 253.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(Rearlevel)).toString(), 932.0f, 253.0f, this.mPaint);
        }
        int frontLevel = this.DATA[21];
        if (this.DATA[33] != 0) {
            c.drawText("AUTO", 453.0f, 164.0f, this.mPaint);
        } else {
            c.drawText("Lev" + frontLevel, 453.0f, 164.0f, this.mPaint);
        }
        int temp4 = this.DATA[27];
        if (temp4 == -2) {
            c.drawText("LO", 225.0f, 155.0f, this.mPaint);
        } else if (temp4 == -3) {
            c.drawText("HI", 225.0f, 155.0f, this.mPaint);
        } else {
            if (temp4 >= 30 && temp4 <= 64) {
                if (TempUnit == 1) {
                    temp = (temp4 * 9) + 320;
                } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    temp = (temp4 * 5 * 9) + 320;
                } else {
                    temp = temp4 * 5;
                }
            } else if (TempUnit == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                temp = ((temp4 + 15) * 18) + 320;
            } else {
                temp = (temp4 * 10) + 150;
            }
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 225.0f, 155.0f, this.mPaint);
        }
        int temp5 = this.DATA[28];
        if (temp5 == -2) {
            c.drawText("LO", 915.0f, 155.0f, this.mPaint);
        } else if (temp5 == -3) {
            c.drawText("HI", 915.0f, 155.0f, this.mPaint);
        } else {
            if (temp5 >= 30 && temp5 <= 64) {
                if (TempUnit == 1) {
                    temp2 = (temp5 * 9) + 320;
                } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    temp2 = (temp5 * 5 * 9) + 320;
                } else {
                    temp2 = temp5 * 5;
                }
            } else if (TempUnit == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                temp2 = ((temp5 + 15) * 18) + 320;
            } else {
                temp2 = (temp5 * 10) + 150;
            }
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 915.0f, 155.0f, this.mPaint);
        }
        int temp6 = this.DATA[40];
        if (temp6 == -2) {
            c.drawText("LO", 300.0f, 260.0f, this.mPaint);
        } else if (temp6 == -3) {
            c.drawText("HI", 300.0f, 260.0f, this.mPaint);
        } else {
            if (temp6 >= 30 && temp6 <= 64) {
                if (TempUnit == 1) {
                    temp3 = (temp6 * 9) + 320;
                } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                    temp3 = (temp6 * 5 * 9) + 320;
                } else {
                    temp3 = temp6 * 5;
                }
            } else if (TempUnit == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                temp3 = ((temp6 + 15) * 18) + 320;
            } else {
                temp3 = (temp6 * 10) + 150;
            }
            c.drawText(String.format("%d.%d", Integer.valueOf(temp3 / 10), Integer.valueOf(temp3 % 10)), 300.0f, 260.0f, this.mPaint);
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
