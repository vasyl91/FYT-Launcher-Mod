package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0452_LZ_Nissan_Fuga extends AirBase {
    public Air_0452_LZ_Nissan_Fuga(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0008_wc1_bentengx80/air_nissan_fuga.webp";
        this.mPathHighlight = "0008_wc1_bentengx80/air_nissan_fuga_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(274.0f, 111.0f, 373.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(390.0f, 25.0f, 486.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(292.0f, 22.0f, 361.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(627.0f, 19.0f, 737.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(393.0f, 102.0f, 482.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(787.0f, 27.0f, 875.0f, 59.0f, Region.Op.UNION);
            c.clipRect(153.0f, 25.0f, 237.0f, 59.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(508.0f, 9.0f, 591.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(517.0f, 101.0f, 585.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(141.0f, 70.0f, 197.0f, 98.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(142.0f, 104.0f, 183.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(782.0f, 60.0f, 829.0f, 103.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(776.0f, 104.0f, 819.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(81.0f, 118.0f, 112.0f, 155.0f, Region.Op.UNION);
            c.clipRect(981.0f, 121.0f, 1018.0f, 154.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(630.0f, 96.0f, (value * 15) + 630, 154.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int unit = this.DATA[20];
        int temp = this.DATA[16];
        if (temp == -1) {
            c.drawText("NO", 52.0f, 91.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 52.0f, 91.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 52.0f, 91.0f, this.mPaint);
        } else if (unit == 1) {
            if (temp >= 1 && temp <= 31) {
                c.drawText(String.valueOf(temp + 59), 52.0f, 91.0f, this.mPaint);
            } else {
                c.drawText("NO", 52.0f, 91.0f, this.mPaint);
            }
        } else if (temp >= 1 && temp <= 29) {
            c.drawText(String.valueOf(((temp * 5) + 175) / 10.0f), 52.0f, 91.0f, this.mPaint);
        } else {
            c.drawText("NO", 52.0f, 91.0f, this.mPaint);
        }
        int temp2 = this.DATA[17];
        if (temp2 == -1) {
            c.drawText("NO", 958.0f, 91.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 958.0f, 91.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 958.0f, 91.0f, this.mPaint);
        } else if (unit == 1) {
            if (temp2 >= 1 && temp2 <= 31) {
                c.drawText(String.valueOf(temp2 + 59), 958.0f, 91.0f, this.mPaint);
            } else {
                c.drawText("NO", 958.0f, 91.0f, this.mPaint);
            }
        } else if (temp2 >= 1 && temp2 <= 29) {
            c.drawText(String.valueOf(((temp2 * 5) + 175) / 10.0f), 958.0f, 91.0f, this.mPaint);
        } else {
            c.drawText("NO", 958.0f, 91.0f, this.mPaint);
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
