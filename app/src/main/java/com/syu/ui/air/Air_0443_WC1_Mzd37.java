package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0443_WC1_Mzd37 extends AirBase {
    public Air_0443_WC1_Mzd37(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0150_wc1_mzd36/air_wc1_maz6_n.webp";
        this.mPathHighlight = "0150_wc1_mzd36/air_wc1_maz6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(777.0f, 18.0f, 884.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[5] == 0) {
            c.clipRect(417.0f, 16.0f, 530.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[6] == 1) {
            c.clipRect(531.0f, 30.0f, 605.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(779.0f, 94.0f, 888.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(416.0f, 98.0f, 501.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(525.0f, 99.0f, 605.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(135.0f, 97.0f, 257.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(136.0f, 21.0f, 256.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(294.0f, 9.0f, 316.0f, 32.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(314.0f, 30.0f, 347.0f, 49.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(297.0f, 47.0f, 318.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(717.0f, 8.0f, 737.0f, 34.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(687.0f, 31.0f, 718.0f, 47.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(714.0f, 44.0f, 732.0f, 69.0f, Region.Op.UNION);
        }
        int value = this.DATA[15];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(282.0f, 109.0f, (value * 16) + 282, 161.0f, Region.Op.UNION);
        int value2 = this.DATA[19];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        c.clipRect(651.0f, 109.0f, (value2 * 16) + 651, 161.0f, Region.Op.UNION);
        int value3 = this.DATA[10];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(53.0f, 140.0f, (value3 * 21) + 53, 155.0f, Region.Op.UNION);
        int value4 = this.DATA[11];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(956.0f, 140.0f, (value4 * 21) + 956, 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[20];
        if (temp == 0) {
            c.drawText("NO", 45.0f, 60.0f, this.mPaint);
        } else if (temp == 254) {
            c.drawText("LOW", 45.0f, 60.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 45.0f, 60.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 45.0f, 60.0f, this.mPaint);
        }
        int temp3 = this.DATA[21];
        if (temp3 == 0) {
            c.drawText("NO", 940.0f, 60.0f, this.mPaint);
        } else if (temp3 == 254) {
            c.drawText("LOW", 940.0f, 60.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 940.0f, 60.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            c.drawText(temp4 / 10 + "." + (temp4 % 10), 940.0f, 60.0f, this.mPaint);
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
