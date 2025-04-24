package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0419_WC2_ZhongHua_H3 extends AirBase {
    public Air_0419_WC2_ZhongHua_H3(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0419_wc2_guochan2/air_wc_zhonghua_h3.webp";
        this.mPathHighlight = "0419_wc2_guochan2/air_wc_zhonghua_h3_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(739.0f, 27.0f, 871.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(462.0f, 22.0f, 536.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(767.0f, 99.0f, 847.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(316.0f, 13.0f, 418.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(319.0f, 92.0f, 415.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(451.0f, 85.0f, 540.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(454.0f, 108.0f, 505.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(158.0f, 51.0f, 288.0f, 131.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value > 7) {
            value = 7;
        }
        c.clipRect(597.0f, 41.0f, 597.0f + (value * 17.57f), 133.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[21];
        if (temp == -2) {
            c.drawText("LOW", 60.0f, 105.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 105.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 60.0f, 105.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 105.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 105.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 105.0f, this.mPaint);
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
