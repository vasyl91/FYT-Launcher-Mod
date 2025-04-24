package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0219_DJ_ChangAnYueXiangV7 extends AirBase {
    public Air_0219_DJ_ChangAnYueXiangV7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0219_dj_changanyuexiangv7/air_dj_yx7_n.webp";
        this.mPathHighlight = "0219_dj_changanyuexiangv7/air_dj_yx7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[6] != 0) {
            c.clipRect(312.0f, 66.0f, 462.0f, 115.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(875.0f, 88.0f, 934.0f, 105.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(843.0f, 108.0f, 894.0f, 139.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(836.0f, 28.0f, 921.0f, 87.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(71.0f, 46.0f, 206.0f, 137.0f, Region.Op.UNION);
        }
        int value = this.DATA[5];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(561.0f, 33.0f, (value * 21) + 561, 137.0f, Region.Op.UNION);
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
