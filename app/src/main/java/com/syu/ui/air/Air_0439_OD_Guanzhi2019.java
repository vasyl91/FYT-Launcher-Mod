package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.util.Log;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_OD_Guanzhi2019 extends AirBase {
    public Air_0439_OD_Guanzhi2019(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0021_wc_13mengdiou/mengdiou13_high.webp";
        this.mPathHighlight = "0021_wc_13mengdiou/mengdiou13_high_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[42] != 0) {
            c.clipRect(303.0f, 22.0f, 433.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(601.0f, 19.0f, 718.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(184.0f, 28.0f, 269.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(738.0f, 11.0f, 872.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(752.0f, 93.0f, 855.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(466.0f, 18.0f, 555.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(309.0f, 97.0f, 418.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[35] == 0) {
            c.clipRect(159.0f, 97.0f, 285.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(480.0f, 84.0f, 532.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(458.0f, 107.0f, 521.0f, 144.0f, Region.Op.UNION);
        }
        int value = this.DATA[42];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(613.0f, 91.0f, (value * 17) + 613, 161.0f, Region.Op.UNION);
        int value2 = this.DATA[45];
        Log.d("LG", "value1=" + value2);
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(68.0f, 42.0f, (value2 * 20) + 68, 77.0f, Region.Op.UNION);
        int value3 = this.DATA[46];
        Log.d("LG", "value2=" + value3);
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(899.0f, 46.0f, (value3 * 20) + 899, 77.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[43];
        if (temp == -1) {
            c.drawText("NO", 65.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 65.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 65.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp * 10) + 160) / 10.0f), 65.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[44];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp2 * 10) + 160) / 10.0f), 930.0f, 140.0f, this.mPaint);
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
