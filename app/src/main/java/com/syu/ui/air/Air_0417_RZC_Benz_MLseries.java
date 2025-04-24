package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0417_RZC_Benz_MLseries extends AirBase {
    public Air_0417_RZC_Benz_MLseries(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 768;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0417_rzc_benzmlseries/air_rzc_benz_mlseries.webp";
        this.mPathHighlight = "0417_rzc_benzmlseries/air_rzc_benz_mlseries_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        int valueleft = this.DATA[24];
        if (valueleft >= 0 && valueleft <= 3) {
            c.clipRect(42.0f, 44.0f, (valueleft * 14) + 42, 83.0f, Region.Op.UNION);
        }
        int valueright = this.DATA[26];
        if (valueright >= 0 && valueright <= 3) {
            c.clipRect(681.0f, 46.0f, (valueright * 14) + 681, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(125.0f, 21.0f, 206.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(221.0f, 13.0f, 325.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(334.0f, 15.0f, 431.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(441.0f, 11.0f, 543.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(128.0f, 98.0f, 200.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(223.0f, 99.0f, 324.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(332.0f, 99.0f, 433.0f, 155.0f, Region.Op.UNION);
        }
        int valuelevel = this.DATA[19];
        if (valuelevel >= 0 && valuelevel <= 7) {
            c.clipRect(465.0f, 89.0f, (valuelevel * 9) + 465, 166.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(547.0f, 36.0f, 601.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(550.0f, 78.0f, 611.0f, 93.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(550.0f, 94.0f, 589.0f, 129.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[20];
        if (temp == -2) {
            c.drawText("LOW", 45.0f, 126.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 45.0f, 126.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp), 45.0f, 126.0f, this.mPaint);
        }
        int temp2 = this.DATA[21];
        if (temp2 == -2) {
            c.drawText("LOW", 700.0f, 128.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 700.0f, 128.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2), 700.0f, 128.0f, this.mPaint);
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / this.mContentWidth, LauncherApplication.getScreenWidth() / this.mContentWidth);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / this.mContentWidth, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
