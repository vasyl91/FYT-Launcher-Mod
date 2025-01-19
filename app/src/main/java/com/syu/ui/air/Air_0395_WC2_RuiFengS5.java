package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0395_WC2_RuiFengS5 extends AirBase {
    public Air_0395_WC2_RuiFengS5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_ruifeng_s5.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_ruifeng_s5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(266.0f, 31.0f, 381.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(136.0f, 21.0f, 217.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(164.0f, 131.0f, 227.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(162.0f, 80.0f, 215.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(153.0f, 101.0f, 190.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[67] != 0) {
            c.clipRect(786.0f, 25.0f, 853.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[64] != 0) {
            c.clipRect(805.0f, 131.0f, 864.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(800.0f, 80.0f, 850.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(792.0f, 103.0f, 829.0f, 132.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(419.0f, 111.0f, 487.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(653.0f, 105.0f, 755.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(272.0f, 103.0f, 361.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(544.0f, 13.0f, 621.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(413.0f, 15.0f, 487.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(646.0f, 15.0f, 766.0f, 79.0f, Region.Op.UNION);
        }
        int value = this.DATA[39];
        c.clipRect(537.0f, 98.0f, (value * 14) + 537, 160.0f, Region.Op.UNION);
        int value1 = this.DATA[31];
        if (value1 < 0) {
            value1 = 0;
        } else if (value1 > 3) {
            value1 = 3;
        }
        c.clipRect(51.0f, 49.0f, (value1 * 21) + 51, 71.0f, Region.Op.UNION);
        int value2 = this.DATA[32];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(911.0f, 50.0f, (value2 * 21) + 911, 73.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[68];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 10.0f), 930.0f, 152.0f, this.mPaint);
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
