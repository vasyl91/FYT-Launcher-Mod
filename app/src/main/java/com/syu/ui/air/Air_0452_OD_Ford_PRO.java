package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_OD_Ford_PRO extends AirBase {
    public Air_0452_OD_Ford_PRO(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0255_rzc_fengshenax7/air_rzc_hanteng.webp";
        this.mPathHighlight = "0255_rzc_fengshenax7/air_rzc_hanteng_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(150.0f, 11.0f, 290.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(151.0f, 93.0f, 291.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(296.0f, 11.0f, 436.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(296.0f, 93.0f, 436.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(453.0f, 17.0f, 539.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(460.0f, 88.0f, 529.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(451.0f, 112.0f, 498.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(588.0f, 11.0f, 728.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(734.0f, 11.0f, 874.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[62] != 0) {
            c.clipRect(734.0f, 93.0f, 874.0f, 165.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value > 7) {
            value = 7;
        }
        c.clipRect(609.0f, 114.0f, (value * 16) + 609, 160.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        String str = String.valueOf(temp * 0.5f);
        if (temp <= 36) {
            str = "LO";
        } else if (temp >= 64) {
            str = "HI";
        }
        c.drawText(str, 62.0f, 138.0f, this.mPaint);
        int temp2 = this.DATA[28];
        String str2 = String.valueOf(temp2 * 0.5f);
        if (temp2 <= 36) {
            str2 = "LO";
        } else if (temp2 >= 64) {
            str2 = "HI";
        }
        c.drawText(str2, 936.0f, 138.0f, this.mPaint);
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
