package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

public class Air_0154_ZMYT_XP1_Medeo extends AirBase {
    public Air_0154_ZMYT_XP1_Medeo(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0154_zmyt_xp1_mendeo/air_zmyt_xp1_mendeo_n.webp";
        this.mPathHighlight = "0154_zmyt_xp1_mendeo/air_zmyt_xp1_mendeo_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[13] != 0) {
            c.clipRect(874.0f, 14.0f, 1017.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(177.0f, 17.0f, 285.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(687.0f, 96.0f, 853.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(172.0f, 96.0f, 292.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(525.0f, 13.0f, 641.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(713.0f, 15.0f, 830.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(342.0f, 24.0f, 412.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(350.0f, 74.0f, 404.0f, 99.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(338.0f, 95.0f, 391.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(99.0f, 115.0f, 150.0f, 163.0f, Region.Op.UNION);
            c.clipRect(972.0f, 115.0f, 1017.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(24.0f, 17.0f, 134.0f, 72.0f, Region.Op.UNION);
        }
        int value = this.DATA[11];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(515.0f, 98.0f, (value * 19) + ConstRzcAddData.U_CAR_SEAT_BELT_RIGHT, 157.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -1) {
            c.drawText("NO", 60.0f, 150.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 60.0f, 150.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 150.0f, this.mPaint);
        } else if (this.DATA[14] != 0) {
            c.drawText(String.valueOf(temp + 32), 60.0f, 150.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 60.0f, 150.0f, this.mPaint);
        }
        int temp2 = this.DATA[12];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 150.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 150.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 150.0f, this.mPaint);
        } else if (this.DATA[14] != 0) {
            c.drawText(String.valueOf(temp2 + 32), 930.0f, 150.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 150.0f, this.mPaint);
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
