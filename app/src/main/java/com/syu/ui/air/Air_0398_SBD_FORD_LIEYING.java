package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0398_SBD_FORD_LIEYING extends AirBase {
    public Air_0398_SBD_FORD_LIEYING(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0398_sbd_ford_lieying/air.webp";
        this.mPathHighlight = "0398_sbd_ford_lieying/air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String str;
        String str2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(736.0f, 23.0f, 872.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(736.0f, 104.0f, 872.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(10.0f, 27.0f, 133.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(180.0f, 24.0f, 259.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(163.0f, 103.0f, 268.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(615.0f, 13.0f, 714.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(612.0f, 92.0f, 712.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(900.0f, 20.0f, 1009.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(313.0f, 27.0f, 367.0f, 58.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(318.0f, 59.0f, 374.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(312.0f, 76.0f, 354.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(329.0f, 116.0f, 393.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[25] == 0) {
            c.clipRect(443.0f, 15.0f, 578.0f, 79.0f, Region.Op.UNION);
        }
        c.clipRect(458.0f, 118.0f, (this.DATA[34] * 16) + 458, 164.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[35];
        if (value == -2) {
            str = "LOW";
        } else if (value == -3) {
            str = "HOT";
        } else if (value == -1) {
            str = "NONE";
        } else {
            float temp = value * 0.1f;
            str = String.valueOf(temp);
        }
        c.drawText(str, 46.0f, 125.0f, this.mPaint);
        int value2 = this.DATA[36];
        if (value2 == -2) {
            str2 = "LOW";
        } else if (value2 == -3) {
            str2 = "HOT";
        } else if (value2 == -1) {
            str2 = "NONE";
        } else {
            float temp2 = value2 * 0.1f;
            str2 = String.valueOf(temp2);
        }
        c.drawText(str2, 930.0f, 125.0f, this.mPaint);
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
