package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0040_XP_MaiTeng17 extends AirBase {
    public Air_0040_XP_MaiTeng17(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0040_xp1_golf7/air_xp1_17maiteng.webp";
        this.mPathHighlight = "0040_xp1_golf7/air_xp1_17maiteng_p.webp";
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
        if (this.DATA[13] != 0) {
            this.srPath.addRect(689.0f, 14.0f, 788.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(236.0f, 15.0f, 333.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(129.0f, 24.0f, 209.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(234.0f, 104.0f, 338.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(809.0f, 20.0f, 900.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[66] != 0) {
            this.srPath.addRect(584.0f, 14.0f, 663.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(699.0f, 103.0f, 784.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(346.0f, 104.0f, 452.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(467.0f, 18.0f, 537.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(468.0f, 92.0f, 522.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(459.0f, 110.0f, 511.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(77.0f, 112.0f, 106.0f, 164.0f, Path.Direction.CW);
            this.srPath.addRect(977.0f, 112.0f, 1011.0f, 159.0f, Path.Direction.CW);
            this.srPath.addRect(420.0f, 35.0f, 452.0f, 79.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(582.0f, 110.0f, 582.0f + (value * 13.5f), 165.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(50.0f, 19.0f, 50.0f + (value2 * 19.0f), 79.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(963.0f, 34.0f, 963.0f + (value3 * 19.0f), 76.0f, Path.Direction.CW);
        int value4 = this.DATA[88];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        this.srPath.addRect(169.0f, 111.0f, 169.0f + (value4 * 19.0f), 159.0f, Path.Direction.CW);
        int value5 = this.DATA[89];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        this.srPath.addRect(847.0f, 122.0f, 847.0f + (value5 * 19.0f), 169.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(25.0f);
        int temp4 = this.DATA[27];
        if (temp4 == 0) {
            c.drawText("LOW", 40.0f, 137.0f, this.mPaint);
        } else if (temp4 == 31) {
            c.drawText("HI", 40.0f, 137.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp4 + 59).toString(), 40.0f, 137.0f, this.mPaint);
        } else {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                temp = (temp4 * 9) + 579;
            } else {
                temp = (temp4 * 5) + 155;
            }
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 40.0f, 137.0f, this.mPaint);
        }
        int temp5 = this.DATA[28];
        if (temp5 == 0) {
            c.drawText("LOW", 945.0f, 137.0f, this.mPaint);
        } else if (temp5 == 31) {
            c.drawText("HI", 945.0f, 137.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp5 + 59).toString(), 945.0f, 137.0f, this.mPaint);
        } else {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                temp2 = (temp5 * 9) + 579;
            } else {
                temp2 = (temp5 * 5) + 155;
            }
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 945.0f, 137.0f, this.mPaint);
        }
        int temp6 = this.DATA[40];
        if (temp6 == 0) {
            c.drawText("LOW", 385.0f, 70.0f, this.mPaint);
        } else if (temp6 == 31) {
            c.drawText("HI", 385.0f, 70.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp6 + 59).toString(), 385.0f, 70.0f, this.mPaint);
        } else {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                temp3 = (temp6 * 9) + 579;
            } else {
                temp3 = (temp6 * 5) + 155;
            }
            c.drawText(new StringBuilder().append(temp3 / 10.0f).toString(), 385.0f, 70.0f, this.mPaint);
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
