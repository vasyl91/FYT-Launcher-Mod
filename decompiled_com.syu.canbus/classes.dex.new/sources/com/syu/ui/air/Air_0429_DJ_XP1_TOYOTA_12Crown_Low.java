package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0429_DJ_XP1_TOYOTA_12Crown_Low extends AirBase {
    public Air_0429_DJ_XP1_TOYOTA_12Crown_Low(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0429_dj_xp1_toyota_12crown/air_dj_xp1_12crown_low_n.webp";
        this.mPathHighlight = "0429_dj_xp1_toyota_12crown/air_dj_xp1_12crown_low_p.webp";
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
            this.srPath.addRect(185.0f, 21.0f, 329.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(708.0f, 15.0f, 821.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(842.0f, 90.0f, 1011.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(353.0f, 14.0f, 501.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(539.0f, 23.0f, 664.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(15.0f, 99.0f, 187.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(685.0f, 91.0f, 725.0f, 121.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(689.0f, 121.0f, 722.0f, 131.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(683.0f, 130.0f, 710.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(89.0f, 97.0f, 175.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(251.0f, 90.0f, 382.0f, 169.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(249.0f, 216.0f, 363.0f, 269.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(858.0f, 218.0f, 1002.0f, 282.0f, Path.Direction.CW);
        }
        if (this.DATA[78] != 0) {
            this.srPath.addRect(677.0f, 220.0f, 759.0f, 269.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(457.0f, 97.0f, 457.0f + (value * 18.4f), 169.0f, Path.Direction.CW);
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(128.0f, 43.0f, 163.0f, 80.0f, Path.Direction.CW);
            this.srPath.addRect(983.0f, 46.0f, 1020.0f, 83.0f, Path.Direction.CW);
        }
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
        if (temp == -1) {
            c.drawText("NO", 68.0f, 55.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 68.0f, 55.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 68.0f, 55.0f, this.mPaint);
        } else if (this.DATA[55] == 0) {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                c.drawText(new StringBuilder(String.valueOf(((temp * 9) / 10) + 32)).toString(), 68.0f, 55.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 68.0f, 55.0f, this.mPaint);
            }
        } else {
            c.drawText(new StringBuilder().append(temp).toString(), 68.0f, 55.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 922.0f, 55.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 922.0f, 55.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 922.0f, 55.0f, this.mPaint);
        } else if (this.DATA[55] == 0) {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                c.drawText(new StringBuilder(String.valueOf(((temp2 * 9) / 10) + 32)).toString(), 922.0f, 55.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 922.0f, 55.0f, this.mPaint);
            }
        } else {
            c.drawText(new StringBuilder().append(temp2).toString(), 922.0f, 55.0f, this.mPaint);
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
