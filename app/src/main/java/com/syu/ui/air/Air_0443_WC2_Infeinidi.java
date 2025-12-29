package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.SystemProperties;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0443_WC2_Infeinidi extends AirBase {
    public Air_0443_WC2_Infeinidi(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0443_wc_infeinidi/air_wc2_infeinidi_n.webp";
        this.mPathHighlight = "0443_wc_infeinidi/air_wc2_infeinidi_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(110.0f, 29.0f, 207.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(116.0f, 108.0f, 196.0f, 139.0f, Region.Op.UNION);
        }
        if (this.DATA[4] == 0) {
            c.clipRect(230.0f, 19.0f, 325.0f, 63.0f, Region.Op.UNION);
        } else if (this.DATA[4] == 2) {
            c.clipRect(246.0f, 61.0f, 308.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(372.0f, 24.0f, 452.0f, 61.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(367.0f, 92.0f, 448.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(493.0f, 29.0f, 545.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(474.0f, 96.0f, 570.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(596.0f, 19.0f, 669.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(599.0f, 111.0f, 667.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(600.0f, 93.0f, 668.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(24.0f, 97.0f, 63.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(28.0f, 123.0f, 61.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(18.0f, 134.0f, 46.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[45] != 0) {
            c.clipRect(711.0f, 96.0f, 746.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[44] != 0) {
            c.clipRect(709.0f, 123.0f, 742.0f, 134.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(703.0f, 134.0f, 727.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(834.0f, 59.0f, 888.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[48] != 0) {
            c.clipRect(834.0f, 24.0f, 870.0f, 37.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(824.0f, 37.0f, 852.0f, 58.0f, Region.Op.UNION);
        }
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit != 0) {
            c.clipRect(67.0f, 46.0f, 105.0f, 80.0f, Region.Op.UNION);
            c.clipRect(747.0f, 46.0f, 781.0f, 82.0f, Region.Op.UNION);
            c.clipRect(978.0f, 43.0f, 1011.0f, 76.0f, Region.Op.UNION);
        }
        int value = this.DATA[12];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(235.0f, 102.0f, (value * 15) + 235, 152.0f, Region.Op.UNION);
        int value2 = this.DATA[51];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 5) {
            value2 = 5;
        }
        c.clipRect(892.0f, 113.0f, (value2 * 15) + 892, 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[13];
        if (temp == -2) {
            c.drawText("LO", 41.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 41.0f, 72.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(String.valueOf(((temp * 9) + 320) / 10), 41.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp * 5) / 10.0f), 41.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[14];
        if (temp2 == -2) {
            c.drawText("LO", 724.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 724.0f, 72.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(String.valueOf(((temp2 * 9) + 320) / 10), 724.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp2 * 5) / 10.0f), 724.0f, 72.0f, this.mPaint);
        }
        int temp3 = this.DATA[52];
        if (temp3 == -2) {
            c.drawText("LO", 954.0f, 72.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 954.0f, 72.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(String.valueOf(((temp3 * 9) + 320) / 10), 954.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp3 * 5) / 10.0f), 954.0f, 72.0f, this.mPaint);
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
