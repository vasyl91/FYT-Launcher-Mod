package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0289_WC2_ChuanQiGs4 extends AirBase {
    public Air_0289_WC2_ChuanQiGs4(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0289_wc2_ChuanQiGs4/air_289_wc_gs4_n.webp";
        this.mPathHighlight = "0289_wc2_ChuanQiGs4/air_289_wc_gs4_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[26] != 0) {
            c.clipRect(336.0f, 103.0f, 442.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(206.0f, 112.0f, 262.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(174.0f, 33.0f, 302.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(734.0f, 19.0f, 813.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(525.0f, 15.0f, 608.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(414.0f, 63.0f, 468.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(345.0f, 8.0f, 392.0f, 42.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(350.0f, 44.0f, 381.0f, 60.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(341.0f, 62.0f, 369.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[27] == 0) {
            c.clipRect(711.0f, 100.0f, 843.0f, 154.0f, Region.Op.UNION);
        }
        c.clipRect(510.0f, 104.0f, (this.DATA[35] * 20) + ConstRzcAddData.U_CAR_CUR_SPEED, 157.0f, Region.Op.UNION);
        int value = this.DATA[36];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(78.0f, 132.0f, (value * 21) + 78, 150.0f, Region.Op.UNION);
        int value2 = this.DATA[37];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(900.0f, 129.0f, (value2 * 21) + 900, 151.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[31];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 76.0f, 72.0f, this.mPaint);
        }
        int right_temp = this.DATA[38];
        if (right_temp == -2) {
            c.drawText("LOW", 940.0f, 72.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 10.0f), 940.0f, 72.0f, this.mPaint);
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
