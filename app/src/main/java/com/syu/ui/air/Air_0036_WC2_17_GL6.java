package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0036_WC2_17_GL6 extends AirBase {
    public Air_0036_WC2_17_GL6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0036_wc2_gm/air_gl6_wc.webp";
        this.mPathHighlight = "0036_wc2_gm/air_gl6_wc_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[71] != 0) {
            c.clipRect(21.0f, 29.0f, 193.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[75] == 0) {
            c.clipRect(699.0f, 7.0f, 830.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[76] != 0) {
            c.clipRect(729.0f, 61.0f, 805.0f, 95.0f, Region.Op.UNION);
        }
        if (this.DATA[142] != 0) {
            c.clipRect(387.0f, 13.0f, 474.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[99] != 0) {
            c.clipRect(468.0f, 206.0f, 565.0f, 285.0f, Region.Op.UNION);
        }
        if (this.DATA[77] != 0) {
            c.clipRect(388.0f, 76.0f, 469.0f, 99.0f, Region.Op.UNION);
        }
        if (this.DATA[72] == 1) {
            c.clipRect(727.0f, 149.0f, 822.0f, 180.0f, Region.Op.UNION);
        }
        if (this.DATA[72] == 2) {
            c.clipRect(723.0f, 108.0f, 813.0f, 188.0f, Region.Op.UNION);
        }
        if (this.DATA[74] != 0) {
            c.clipRect(549.0f, 9.0f, 653.0f, 98.0f, Region.Op.UNION);
        }
        if (this.DATA[78] != 0) {
            c.clipRect(525.0f, 105.0f, 587.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[79] != 0) {
            c.clipRect(559.0f, 147.0f, 599.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[80] != 0) {
            c.clipRect(529.0f, 163.0f, 573.0f, 194.0f, Region.Op.UNION);
        }
        if (this.DATA[81] != 0) {
            c.clipRect(596.0f, 104.0f, 673.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[85] != 0) {
            c.clipRect(668.0f, 201.0f, 741.0f, 229.0f, Region.Op.UNION);
        }
        if (this.DATA[86] != 0) {
            c.clipRect(696.0f, 232.0f, 742.0f, 257.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(674.0f, 257.0f, 711.0f, 287.0f, Region.Op.UNION);
        }
        if (this.DATA[89] == 5) {
            c.clipRect(945.0f, 239.0f, 1014.0f, 272.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[89], 0, 4);
        if (value < 0) {
            value = 0;
        } else if (value > 4) {
            value = 4;
        }
        c.clipRect(869.0f, 228.0f, (value * 17) + 869, 281.0f, Region.Op.UNION);
        if (this.DATA[108] != 0) {
            c.clipRect(189.0f, 23.0f, 248.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[109] != 0) {
            c.clipRect(951.0f, 26.0f, 1004.0f, 83.0f, Region.Op.UNION);
        }
        int value2 = this.DATA[101];
        if (value2 < 0 || value2 > 3) {
            value2 = 0;
        }
        c.clipRect(249.0f, 57.0f, (value2 * 20) + 249, 84.0f, Region.Op.UNION);
        int value3 = this.DATA[100];
        if (value3 < 0 || value3 > 3) {
            value3 = 0;
        }
        c.clipRect(886.0f, 59.0f, (value3 * 21) + 886, 86.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int frontLevel = this.DATA[82];
        if (frontLevel == 0) {
            c.drawText("OFF", 453.0f, 164.0f, this.mPaint);
        } else if (frontLevel == 19) {
            c.drawText("AUTO", 453.0f, 164.0f, this.mPaint);
        } else {
            c.drawText("Lev" + frontLevel, 453.0f, 164.0f, this.mPaint);
        }
        int temp = this.DATA[83];
        if (temp == 254) {
            c.drawText("LOW", 225.0f, 155.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 225.0f, 155.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 225.0f, 155.0f, this.mPaint);
        }
        int temp3 = this.DATA[84];
        if (temp3 == 254) {
            c.drawText("LOW", 915.0f, 155.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 915.0f, 155.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 915.0f, 155.0f, this.mPaint);
        }
        int temp5 = this.DATA[88];
        if (temp5 == 254) {
            c.drawText("LOW", 300.0f, 260.0f, this.mPaint);
        } else if (temp5 == 255) {
            c.drawText("HI", 300.0f, 260.0f, this.mPaint);
        } else {
            int temp6 = temp5 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp6 / 10), Integer.valueOf(temp6 % 10)), 300.0f, 260.0f, this.mPaint);
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
