package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0372_WC1_Jeep_ZiYouGuang extends AirBase {
    public Air_0372_WC1_Jeep_ZiYouGuang(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0372_wc1_jeep_ziyouguang/372_wc_ziyouguang.webp";
        this.mPathHighlight = "0372_wc1_jeep_ziyouguang/372_wc_ziyouguang_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[72] != 0) {
            c.clipRect(9.0f, 23.0f, 123.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[58] != 0) {
            c.clipRect(527.0f, 19.0f, 628.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[62] != 0) {
            c.clipRect(290.0f, 19.0f, 358.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[67] != 0) {
            c.clipRect(390.0f, 104.0f, 507.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[60] != 0) {
            c.clipRect(144.0f, 14.0f, 239.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[61] != 0) {
            c.clipRect(402.0f, 19.0f, 497.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[76] != 0) {
            c.clipRect(274.0f, 105.0f, 372.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[75] != 0) {
            c.clipRect(675.0f, 135.0f, 740.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(657.0f, 21.0f, 730.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[64] != 0) {
            c.clipRect(676.0f, 89.0f, 723.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(658.0f, 106.0f, 700.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[59] != 1) {
            c.clipRect(906.0f, 17.0f, 1008.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[77] != 0) {
            c.clipRect(782.0f, 15.0f, 880.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[73] == 2) {
            c.clipRect(84.0f, 113.0f, 124.0f, 164.0f, Region.Op.UNION);
            c.clipRect(977.0f, 114.0f, 1017.0f, 164.0f, Region.Op.UNION);
        }
        int value = this.DATA[68];
        if (value == 19) {
            c.clipRect(551.0f, 145.0f, 615.0f, 165.0f, Region.Op.UNION);
            c.clipRect(540.0f, 97.0f, 540.0f, 146.0f, Region.Op.UNION);
        } else if (value >= 0 && value <= 7) {
            c.clipRect(540.0f, 97.0f, (value * 13) + 540, 146.0f, Region.Op.UNION);
        }
        int value2 = this.DATA[69];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 2) {
            value2 = 2;
        }
        c.clipRect(198.0f, 131.0f, (value2 * 20) + 198, 157.0f, Region.Op.UNION);
        int value3 = this.DATA[70];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        c.clipRect(797.0f, 129.0f, (value3 * 20) + 797, 158.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[63];
        if (temp == -2) {
            c.drawText("LOW", 50.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 50.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[71];
        if (temp2 == -2) {
            c.drawText("LOW", 941.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 941.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 941.0f, 140.0f, this.mPaint);
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
