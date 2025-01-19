package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0442_WC1_Audi_A3 extends AirBase {
    public Air_0442_WC1_Audi_A3(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0442_wc1_audi_a3/air_wc_audi_a3.webp";
        this.mPathHighlight = "0442_wc1_audi_a3/air_wc_audi_a3_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(400.0f, 104.0f, 504.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(519.0f, 98.0f, 633.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(656.0f, 23.0f, 745.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(406.0f, 25.0f, 495.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(650.0f, 116.0f, 746.0f, 155.0f, Region.Op.UNION);
        } else if (this.DATA[9] == 3) {
            c.clipRect(660.0f, 91.0f, 738.0f, 116.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(282.0f, 15.0f, 382.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(282.0f, 94.0f, 368.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(543.0f, 25.0f, 613.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(172.0f, 91.0f, 218.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(182.0f, 123.0f, 211.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(170.0f, 135.0f, 196.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(801.0f, 93.0f, 846.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(808.0f, 123.0f, 840.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(800.0f, 136.0f, 825.0f, 158.0f, Region.Op.UNION);
        }
        int value = this.DATA[16];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(197.0f, 50.0f, (value * 14) + 197, 71.0f, Region.Op.UNION);
        int value2 = this.DATA[17];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(785.0f, 49.0f, (value2 * 14) + 785, 69.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        c.drawText(String.valueOf(this.DATA[23]), 90.0f, 134.0f, this.mPaint);
        c.drawText(String.valueOf(this.DATA[27]), 972.0f, 134.0f, this.mPaint);
        int temp = this.DATA[18];
        if (temp == -1) {
            c.drawText("NO", 55.0f, 58.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 55.0f, 58.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 55.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp), 55.0f, 58.0f, this.mPaint);
        }
        int temp2 = this.DATA[19];
        if (temp2 == -1) {
            c.drawText("NO", 932.0f, 58.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 932.0f, 58.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 932.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2), 932.0f, 58.0f, this.mPaint);
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
