package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0452_OUDI_Changchang_Oula extends AirBase {
    public Air_0452_OUDI_Changchang_Oula(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_haval_h9/oudi_haval_h9.webp";
        this.mPathHighlight = "0439_oudi_haval_h9/oudi_haval_h9_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(359.0f, 24.0f, 454.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(368.0f, 109.0f, 412.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[57] != 0) {
            c.clipRect(266.0f, 26.0f, 351.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(464.0f, 21.0f, 566.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(269.0f, 111.0f, 350.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(501.0f, 101.0f, 566.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(433.0f, 99.0f, 497.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(153.0f, 9.0f, 205.0f, 45.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(161.0f, 44.0f, 198.0f, 59.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(152.0f, 57.0f, 182.0f, 80.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(125.0f, 93.0f, (value * 15) + 125, 155.0f, Region.Op.UNION);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 2) {
            value2 = 2;
        }
        c.clipRect(58.0f, 126.0f, (value2 * 20) + 58, 162.0f, Region.Op.UNION);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        c.clipRect(593.0f, 129.0f, (value3 * 20) + 593, 159.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 45.0f, 63.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 45.0f, 63.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 45.0f, 63.0f, this.mPaint);
        } else {
            int temp2 = ((temp - 116) * 5) + 160;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 45.0f, 63.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 623.0f, 63.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LO", 623.0f, 63.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 623.0f, 63.0f, this.mPaint);
        } else {
            int temp12 = ((temp1 - 116) * 5) + 160;
            c.drawText(temp12 / 10 + "." + (temp12 % 10), 623.0f, 63.0f, this.mPaint);
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
