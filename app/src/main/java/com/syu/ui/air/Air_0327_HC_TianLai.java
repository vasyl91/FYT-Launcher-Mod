package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0327_HC_TianLai extends AirBase {
    public Air_0327_HC_TianLai(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0327_hc_tianlai/air_hc_03tianlai_n.webp";
        this.mPathHighlight = "0327_hc_tianlai/air_hc_03tianlai_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[22] != 0) {
            c.clipRect(885.0f, 100.0f, 998.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(221.0f, 105.0f, 324.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(206.0f, 13.0f, 305.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(694.0f, 13.0f, 839.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(28.0f, 106.0f, 143.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(376.0f, 15.0f, 454.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(369.0f, 72.0f, 425.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(390.0f, 102.0f, 459.0f, 118.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(375.0f, 119.0f, 422.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(696.0f, 91.0f, 845.0f, 169.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(541.0f, 19.0f, 649.0f, 67.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(539.0f, 101.0f, 539.0f + (value * 19.5f), 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[16];
        if (temp == -1) {
            c.drawText("NONE", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 76.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[17];
        if (temp2 == -1) {
            c.drawText("NONE", 940.0f, 72.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 940.0f, 72.0f, this.mPaint);
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
