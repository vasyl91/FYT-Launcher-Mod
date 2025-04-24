package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0321_WC2_16_civic extends AirBase {
    public Air_0321_WC2_16_civic(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0321_wc2_16civic/wc_16_civic_n.webp";
        this.mPathHighlight = "0321_wc2_16civic/wc_16_civic_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[38] != 0) {
            c.clipRect(19.0f, 22.0f, 158.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[27] == 0) {
            c.clipRect(889.0f, 20.0f, 1002.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(198.0f, 25.0f, 311.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(713.0f, 92.0f, 846.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(715.0f, 10.0f, 844.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(205.0f, 99.0f, 298.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(526.0f, 92.0f, 658.0f, 148.0f, Region.Op.UNION);
        }
        if (DataCanbus.DATA[1000] == 262465) {
            if (this.DATA[34] != 0) {
                c.clipRect(353.0f, 36.0f, 416.0f, 72.0f, Region.Op.UNION);
            }
        } else if (this.DATA[34] != 0 || this.DATA[28] != 0) {
            c.clipRect(353.0f, 36.0f, 416.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(382.0f, 69.0f, 450.0f, 91.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(351.0f, 93.0f, 406.0f, 134.0f, Region.Op.UNION);
        }
        int value = this.DATA[35];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(541.0f, 23.0f, (value * 18) + 541, 77.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[31];
        if (temp == -1) {
            c.drawText("NO", 60.0f, 130.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 60.0f, 130.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 60.0f, 130.0f, this.mPaint);
        }
        int temp2 = this.DATA[37];
        if (temp2 == -1) {
            c.drawText("NO", 940.0f, 130.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 130.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 940.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 940.0f, 130.0f, this.mPaint);
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
