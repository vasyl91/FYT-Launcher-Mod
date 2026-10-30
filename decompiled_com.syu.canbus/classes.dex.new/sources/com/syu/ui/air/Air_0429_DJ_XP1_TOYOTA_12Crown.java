package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0429_DJ_XP1_TOYOTA_12Crown extends AirBase {
    public Air_0429_DJ_XP1_TOYOTA_12Crown(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0429_dj_xp1_toyota_12crown/air_dj_xp1_12crown_n.webp";
        this.mPathHighlight = "0429_dj_xp1_toyota_12crown/air_dj_xp1_12crown_p.webp";
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
            this.srPath.addRect(185.0f, 35.0f, 329.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(731.0f, 23.0f, 793.0f, 92.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(860.0f, 113.0f, 1009.0f, 189.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(371.0f, 30.0f, 490.0f, 90.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(549.0f, 24.0f, 661.0f, 87.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(177.0f, 123.0f, 329.0f, 193.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(710.0f, 104.0f, 780.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(720.0f, 135.0f, 795.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(709.0f, 153.0f, 764.0f, 195.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(246.0f, 122.0f, 330.0f, 191.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(370.0f, 105.0f, 485.0f, 190.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(249.0f, 216.0f, 363.0f, 269.0f, Path.Direction.CW);
        }
        if (this.DATA[55] == 0) {
            this.srPath.addRect(116.0f, 52.0f, 164.0f, 104.0f, Path.Direction.CW);
            this.srPath.addRect(970.0f, 44.0f, 1015.0f, 102.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(858.0f, 218.0f, 1002.0f, 282.0f, Path.Direction.CW);
        }
        if ((this.DATA[78] & 1) == 1) {
            this.srPath.addRect(677.0f, 220.0f, 759.0f, 269.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(544.0f, 120.0f, 544.0f + (value * 18.4f), 192.0f, Path.Direction.CW);
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
            c.drawText("NO", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else if (this.DATA[55] == 0) {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp).toString(), 76.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 72.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 72.0f, this.mPaint);
        } else if (this.DATA[55] == 0) {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 920.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2).toString(), 920.0f, 72.0f, this.mPaint);
        }
        int temp3 = this.DATA[40];
        if (temp3 == -1) {
            c.drawText("NO", 494.0f, 262.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 494.0f, 262.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 494.0f, 262.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp3 / 2.0f).toString(), 494.0f, 262.0f, this.mPaint);
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
