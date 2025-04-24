package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0066_WC1_MingTu extends AirBase {
    public Air_0066_WC1_MingTu(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0066_wc1_mingtu/air_wc1_mingtu_n.webp";
        this.mPathHighlight = "0066_wc1_mingtu/air_wc1_mingtu_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(688.0f, 96.0f, 859.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(169.0f, 22.0f, 293.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(178.0f, 104.0f, 288.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(337.0f, 23.0f, 408.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(703.0f, 23.0f, 840.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(376.0f, 81.0f, 422.0f, 98.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(344.0f, 101.0f, 387.0f, 137.0f, Region.Op.UNION);
        }
        int value = this.DATA[5];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(500.0f, 72.0f, (value * 20) + ConstRzcAddData.U_CAR_ADD_START, 132.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[7];
        if (temp == 254) {
            c.drawText("LOW", 55.0f, 100.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 55.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp * 5) / 10.0f), 55.0f, 100.0f, this.mPaint);
        }
        int temp2 = this.DATA[4];
        if (temp2 == 254) {
            c.drawText("LOW", 930.0f, 100.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HI", 930.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp2 * 5) / 10.0f), 930.0f, 100.0f, this.mPaint);
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
