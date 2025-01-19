package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

public class Air_0260_WC2_ChuangQiGa6 extends AirBase {
    public Air_0260_WC2_ChuangQiGa6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0260_wc2_changqiga6/air_wc_ga6_n.webp";
        this.mPathHighlight = "0260_wc2_changqiga6/air_wc_ga6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[26] != 0) {
            c.clipRect(17.0f, 98.0f, 144.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(194.0f, 108.0f, 276.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(170.0f, 27.0f, 307.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(724.0f, 15.0f, 829.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(515.0f, 12.0f, 627.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(894.0f, 97.0f, 1011.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(355.0f, 129.0f, 436.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(360.0f, 27.0f, 419.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(364.0f, 74.0f, 404.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(352.0f, 90.0f, 388.0f, 120.0f, Region.Op.UNION);
        }
        if (this.DATA[27] == 0) {
            c.clipRect(705.0f, 93.0f, 852.0f, 161.0f, Region.Op.UNION);
        }
        int value = this.DATA[35];
        c.clipRect(506.0f, 94.0f, (value * 21) + ConstRzcAddData.U_CAR_LIGHT_RIGHT, 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[31];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 76.0f, 72.0f, this.mPaint);
        }
        int right_temp = this.DATA[38];
        if (right_temp == -2) {
            c.drawText("LOW", 940.0f, 72.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 10.0f), 940.0f, 72.0f, this.mPaint);
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
