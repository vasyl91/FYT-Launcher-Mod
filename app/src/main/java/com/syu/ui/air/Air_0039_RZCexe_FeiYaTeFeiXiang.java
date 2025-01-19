package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0039_RZCexe_FeiYaTeFeiXiang extends AirBase {
    public Air_0039_RZCexe_FeiYaTeFeiXiang(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0039_rzcexe_feiyatefeixiang/air_rzc_feixiang_n.webp";
        this.mPathHighlight = "0039_rzcexe_feiyatefeixiang/air_rzc_feixiang_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(155.0f, 100.0f, 286.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 0) {
            c.clipRect(751.0f, 33.0f, 866.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0 || this.DATA[2] != 0) {
            c.clipRect(446.0f, 30.0f, 516.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(546.0f, 33.0f, 582.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(517.0f, 35.0f, 544.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(616.0f, 13.0f, 705.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(608.0f, 93.0f, 696.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(755.0f, 98.0f, 851.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(178.0f, 23.0f, 254.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(305.0f, 41.0f, 356.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(330.0f, 78.0f, 386.0f, 96.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(306.0f, 98.0f, 348.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(738.0f, 10.0f, 784.0f, 31.0f, Region.Op.UNION);
        }
        int value = this.DATA[6];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(459.0f, 113.0f, (value * 16) + 459, 161.0f, Region.Op.UNION);
        int value2 = this.DATA[14];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(65.0f, 50.0f, (value2 * 21) + 65, 66.0f, Region.Op.UNION);
        int value3 = this.DATA[15];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(943.0f, 49.0f, (value3 * 21) + 943, 69.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[8];
        if (temp == 0) {
            c.drawText("LOW", 50.0f, 140.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 50.0f, 140.0f, this.mPaint);
        } else if (temp >= 1 && temp <= 17) {
            int temp2 = ((temp - 1) * 5) + 180;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 50.0f, 140.0f, this.mPaint);
        }
        int temp3 = this.DATA[4];
        if (temp3 == 0) {
            c.drawText("LOW", 928.0f, 140.0f, this.mPaint);
        } else if (temp3 == 31) {
            c.drawText("HI", 928.0f, 140.0f, this.mPaint);
        } else if (temp3 >= 1 && temp3 <= 17) {
            int temp4 = ((temp3 - 1) * 5) + 180;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 928.0f, 140.0f, this.mPaint);
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
