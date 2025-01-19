package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0227_RZC_ChangAnYueXiangV7 extends AirBase {
    public Air_0227_RZC_ChangAnYueXiangV7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0226_fyta_changanyuexiang7/air_fyt_yuexiangv7_n.webp";
        this.mPathHighlight = "0226_fyta_changanyuexiang7/air_fyt_yuexiangv7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[18] != 0) {
            c.clipRect(74.0f, 18.0f, 287.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(826.0f, 53.0f, 895.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(794.0f, 83.0f, 847.0f, 141.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(423.0f, 63.0f, (value * 25) + 423, 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
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
