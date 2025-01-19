package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0313_SBD_WC1_Electric extends AirBase {
    public Air_0313_SBD_WC1_Electric(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0313_sbd_wc1_electric/sibaide_313.webp";
        this.mPathHighlight = "0313_sbd_wc1_electric/sibaide_313_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[118] != 0) {
            c.clipRect(874.0f, 22.0f, 1012.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[110] != 0) {
            c.clipRect(167.0f, 103.0f, 272.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[112] != 0) {
            c.clipRect(50.0f, 25.0f, 144.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[119] != 0) {
            c.clipRect(194.0f, 32.0f, 321.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[116] != 0) {
            c.clipRect(551.0f, 36.0f, 611.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[114] != 0) {
            c.clipRect(555.0f, 77.0f, 613.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[115] != 0) {
            c.clipRect(547.0f, 97.0f, 590.0f, 131.0f, Region.Op.UNION);
        }
        if (this.DATA[111] == 0) {
            c.clipRect(348.0f, 39.0f, 501.0f, 124.0f, Region.Op.UNION);
        }
        int value = this.DATA[117];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(714.0f, 64.0f, (value * 28) + 714, 139.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[113];
        if (temp == 170) {
            c.drawText("LOW", 53.0f, 136.0f, this.mPaint);
        } else if (temp == 270) {
            c.drawText("HI", 53.0f, 136.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 53.0f, 136.0f, this.mPaint);
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
