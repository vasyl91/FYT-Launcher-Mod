package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_OD_Captiva extends AirBase {
    public Air_0452_OD_Captiva(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0448_lz_bmw/air_lz_bmw_carui_n.webp";
        this.mPathHighlight = "0448_lz_bmw/air_lz_bmw_carui_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(266.0f, 31.0f, 381.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(136.0f, 21.0f, 217.0f, 79.0f, Region.Op.UNION);
            c.clipRect(783.0f, 21.0f, 852.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(164.0f, 131.0f, 227.0f, 152.0f, Region.Op.UNION);
            c.clipRect(807.0f, 133.0f, 863.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(162.0f, 80.0f, 215.0f, 104.0f, Region.Op.UNION);
            c.clipRect(807.0f, 84.0f, 847.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(153.0f, 101.0f, 190.0f, 129.0f, Region.Op.UNION);
            c.clipRect(795.0f, 104.0f, 826.0f, 132.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(419.0f, 111.0f, 487.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(653.0f, 105.0f, 755.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(272.0f, 103.0f, 361.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(544.0f, 13.0f, 621.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(413.0f, 15.0f, 487.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0 && this.DATA[11] == 0) {
            c.clipRect(646.0f, 15.0f, 766.0f, 79.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value1 = this.DATA[21];
        if (value1 < 0) {
            value1 = 0;
        } else if (value1 > 3) {
            value1 = 3;
        }
        c.drawText(String.valueOf(value1), 86.0f, 62.0f, this.mPaint);
        int value2 = this.DATA[22];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.drawText(String.valueOf(value2), 931.0f, 62.0f, this.mPaint);
        int left_temp = this.DATA[19];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            if (left_temp >= 1 && left_temp <= 28) {
                left_temp = (left_temp * 5) + 165;
            } else if (left_temp == 29) {
                left_temp = 160;
            } else if (left_temp == 31) {
                left_temp = 165;
            } else if (left_temp == 32) {
                left_temp = 150;
            } else if (left_temp == 33) {
                left_temp = 155;
            } else if (left_temp == 34) {
                left_temp = 310;
            }
            c.drawText(String.valueOf(left_temp / 10.0f), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[20];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            if (right_temp >= 1 && right_temp <= 28) {
                right_temp = (right_temp * 5) + 165;
            } else if (right_temp == 29) {
                right_temp = 160;
            } else if (right_temp == 31) {
                right_temp = 165;
            } else if (right_temp == 32) {
                right_temp = 150;
            } else if (right_temp == 33) {
                right_temp = 155;
            } else if (right_temp == 34) {
                right_temp = 310;
            }
            c.drawText(String.valueOf(right_temp / 10.0f), 930.0f, 152.0f, this.mPaint);
        }
        if (this.DATA[24] != 0) {
            c.drawText("Auto", 580.0f, 144.0f, this.mPaint);
        } else {
            int value = this.DATA[12];
            c.drawText(String.valueOf(value), 580.0f, 144.0f, this.mPaint);
        }
        this.mPaint.setTextSize(15.0f);
        if (this.DATA[11] != 0) {
            c.drawText("AQS", 670.0f, 25.0f, this.mPaint);
        } else {
            c.drawText("", 670.0f, 25.0f, this.mPaint);
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
