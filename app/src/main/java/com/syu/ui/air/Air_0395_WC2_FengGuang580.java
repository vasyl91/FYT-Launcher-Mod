package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0395_WC2_FengGuang580 extends AirBase {
    public Air_0395_WC2_FengGuang580(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_fengguang580.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_fengguang580_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(18.0f, 101.0f, 157.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[71] != 0) {
            c.clipRect(869.0f, 94.0f, 1016.0f, 167.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(371.0f, 19.0f, 466.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(898.0f, 31.0f, 987.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(199.0f, 38.0f, 317.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(377.0f, 90.0f, 445.0f, 115.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(363.0f, 114.0f, 421.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(695.0f, 41.0f, 839.0f, 140.0f, Region.Op.UNION);
        }
        int value = this.DATA[39];
        c.clipRect(529.0f, 43.0f, (value * 19) + 529, 131.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 76.0f, 72.0f, this.mPaint);
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
