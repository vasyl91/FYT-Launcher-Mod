package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0227_RZC_16YueXiangV7 extends AirBase {
    public Air_0227_RZC_16YueXiangV7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0226_fyta_changanyuexiang7/rzc_16yuexiangv7.webp";
        this.mPathHighlight = "0226_fyta_changanyuexiang7/rzc_16yuexiangv7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(56.0f, 46.0f, 220.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(582.0f, 39.0f, 709.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(336.0f, 17.0f, 409.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(340.0f, 87.0f, 403.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(329.0f, 114.0f, 376.0f, 150.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(833.0f, 62.0f, 833.0f + (value * 20.0f), 153.0f, Region.Op.UNION);
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
