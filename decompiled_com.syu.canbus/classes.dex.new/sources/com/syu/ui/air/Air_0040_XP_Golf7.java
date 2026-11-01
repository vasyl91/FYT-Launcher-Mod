package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0040_XP_Golf7 extends AirBase {
    public Air_0040_XP_Golf7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0040_xp1_golf7/air_xp1_gaoerfu7.webp";
        this.mPathHighlight = "0040_xp1_golf7/air_xp1_gaoerfu7_p.webp";
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
        if (this.DATA[13] != 0) {
            this.srPath.addRect(746.0f, 15.0f, 868.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(440.0f, 11.0f, 581.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(154.0f, 19.0f, 277.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(150.0f, 96.0f, 283.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(746.0f, 96.0f, 860.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[66] != 0) {
            this.srPath.addRect(609.0f, 11.0f, 716.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(609.0f, 97.0f, 706.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(304.0f, 43.0f, 356.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(336.0f, 74.0f, 388.0f, 99.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(302.0f, 99.0f, 348.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1) {
            this.srPath.addRect(89.0f, 112.0f, 125.0f, 164.0f, Path.Direction.CW);
            this.srPath.addRect(977.0f, 101.0f, 1013.0f, 164.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(459.0f, 117.0f, (value * 15) + 459, 164.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(63.0f, 43.0f, 63.0f + (value2 * 20.0f), 71.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(942.0f, 48.0f, 942.0f + (value3 * 20.0f), 72.0f, Path.Direction.CW);
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
        int temp = this.DATA[27];
        if (DataCanbus.DATA[1000] == 458912 || DataCanbus.DATA[1000] == 524448) {
            if (temp == 0) {
                c.drawText("NONE", 42.0f, 137.0f, this.mPaint);
            } else if (temp <= 15 && temp >= 1) {
                c.drawText("LOW", 42.0f, 137.0f, this.mPaint);
            } else if (temp <= 63 && temp >= 49) {
                c.drawText("HIGH", 42.0f, 137.0f, this.mPaint);
            } else if (temp >= 16 && temp <= 48) {
                c.drawText(((((temp - 16) * 5) + 160) / 10.0f) + " ℃", 42.0f, 137.0f, this.mPaint);
            }
        } else if (temp == 0) {
            c.drawText("LOW", 42.0f, 137.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 42.0f, 137.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp + 59).toString(), 42.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp * 5) + 155) / 10.0f).toString(), 42.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (DataCanbus.DATA[1000] == 196659 || DataCanbus.DATA[1000] == 262195) {
            if (temp2 == 0) {
                c.drawText("NONE", 920.0f, 137.0f, this.mPaint);
            } else if (temp2 <= 15 && temp2 >= 1) {
                c.drawText("LOW", 920.0f, 137.0f, this.mPaint);
            } else if (temp2 <= 63 && temp2 >= 49) {
                c.drawText("HIGH", 920.0f, 137.0f, this.mPaint);
            } else if (temp2 >= 16 && temp2 <= 48) {
                c.drawText(((((temp2 - 16) * 5) + 160) / 10.0f) + " ℃", 920.0f, 137.0f, this.mPaint);
            }
        } else if (temp2 == 0) {
            c.drawText("LOW", 920.0f, 137.0f, this.mPaint);
        } else if (temp2 == 31) {
            c.drawText("HI", 920.0f, 137.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp2 + 59).toString(), 920.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp2 * 5) + 155) / 10.0f).toString(), 920.0f, 137.0f, this.mPaint);
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
