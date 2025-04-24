package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_BNR_Nissan_Tule extends AirBase {
    public Air_0439_BNR_Nissan_Tule(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_xp1_2015siyu_crv_1n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_xp1_2015siyu_crv_1p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[13] != 0) {
            c.clipRect(739.0f, 20.0f, 847.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(202.0f, 21.0f, 300.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(195.0f, 91.0f, 320.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(531.0f, 16.0f, 677.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(892.0f, 18.0f, 1008.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(352.0f, 11.0f, 445.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(387.0f, 85.0f, 451.0f, 115.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(359.0f, 112.0f, 409.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(13.0f, 17.0f, 163.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(733.0f, 94.0f, 855.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[22] == 1) {
            c.clipRect(124.0f, 113.0f, 169.0f, 161.0f, Region.Op.UNION);
            c.clipRect(970.0f, 107.0f, 1017.0f, 161.0f, Region.Op.UNION);
        }
        int value = this.DATA[19];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(548.0f, 95.0f, (value * 20) + 548, 161.0f, Region.Op.UNION);
        if (this.DATA[11] != 0) {
            c.clipRect(31.0f, 171.0f, 196.0f, 245.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[20];
        if (temp == -1) {
            c.drawText("NO", 65.0f, 135.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 65.0f, 135.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 65.0f, 135.0f, this.mPaint);
        } else if (this.DATA[22] == 1) {
            c.drawText(String.valueOf(temp), 65.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 65.0f, 135.0f, this.mPaint);
        }
        int temp2 = this.DATA[21];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 135.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 135.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 930.0f, 135.0f, this.mPaint);
        } else if (this.DATA[22] == 1) {
            c.drawText(String.valueOf(temp2), 930.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 135.0f, this.mPaint);
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
