package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0430_wc2_TianLai03 extends AirBase {
    public Air_0430_wc2_TianLai03(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0430_wc2_tianlai03/air_wc2_tianlai03_n.webp";
        this.mPathHighlight = "0430_wc2_tianlai03/air_wc2_tianlai03_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.save(2);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(12.0f, 27.0f, 156.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(210.0f, 104.0f, 292.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(717.0f, 92.0f, 820.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(200.0f, 10.0f, 308.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(373.0f, 16.0f, 454.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(380.0f, 84.0f, 458.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(366.0f, 114.0f, 420.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(525.0f, 11.0f, 667.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(541.0f, 101.0f, 649.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(883.0f, 26.0f, 996.0f, 90.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value >= 0 && value <= 7) {
            c.clipRect(723.0f, 25.0f, 723.0f + (value * 15.3f), 89.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[21];
        if (temp == -2) {
            c.drawText("LOW", 70.0f, 132.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 132.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("----", 70.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 70.0f, 132.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 132.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 132.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("----", 930.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 132.0f, this.mPaint);
        }
        c.restore();
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
