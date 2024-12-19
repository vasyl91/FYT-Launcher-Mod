package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(185.0f, 35.0f, 329.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(731.0f, 23.0f, 793.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(860.0f, 113.0f, 1009.0f, 189.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(371.0f, 30.0f, 490.0f, 90.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(549.0f, 24.0f, 661.0f, 87.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(177.0f, 123.0f, 329.0f, 193.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(710.0f, 104.0f, 780.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(720.0f, 135.0f, 795.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(709.0f, 153.0f, 764.0f, 195.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(246.0f, 122.0f, 330.0f, 191.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(370.0f, 105.0f, 485.0f, 190.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(249.0f, 216.0f, 363.0f, 269.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(116.0f, 52.0f, 164.0f, 104.0f, Region.Op.UNION);
            c.clipRect(970.0f, 44.0f, 1015.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(858.0f, 218.0f, 1002.0f, 282.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(677.0f, 220.0f, 759.0f, 269.0f, Region.Op.UNION);
        }
        int value = this.DATA[22];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(544.0f, 120.0f, 544.0f + (value * 18.4f), 192.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[23];
        if (temp == -1) {
            c.drawText("NO", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else if (this.DATA[28] == 0) {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp).toString(), 76.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 72.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 72.0f, this.mPaint);
        } else if (this.DATA[28] == 0) {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 920.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2).toString(), 920.0f, 72.0f, this.mPaint);
        }
        int temp3 = this.DATA[33];
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
