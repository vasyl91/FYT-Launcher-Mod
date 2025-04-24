package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0293_WC3_15RuiJie extends AirBase {
    public Air_0293_WC3_15RuiJie(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0293_wc3_15ruijie/air_wc3_ruijie15_n.webp";
        this.mPathHighlight = "0293_wc3_15ruijie/air_wc3_ruijie15_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[24] != 0) {
            c.clipRect(155.0f, 34.0f, 283.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(451.0f, 125.0f, 575.0f, 171.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(313.0f, 125.0f, 420.0f, 168.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(301.0f, 22.0f, 431.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(600.0f, 21.0f, 705.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(617.0f, 113.0f, 703.0f, 186.0f, Region.Op.UNION);
        }
        if (this.DATA[16] == 1) {
            c.clipRect(39.0f, 117.0f, 109.0f, 174.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(881.0f, 22.0f, 1017.0f, 89.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(911.0f, 103.0f, 969.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(923.0f, 137.0f, 965.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(909.0f, 148.0f, 969.0f, 173.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(927.0f, 175.0f, 988.0f, 199.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 1) {
            c.clipRect(88.0f, 32.0f, 143.0f, 98.0f, Region.Op.UNION);
            c.clipRect(818.0f, 39.0f, 869.0f, 101.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(456.0f, 46.0f, (value * 18) + 456, 93.0f, Region.Op.UNION);
        int value2 = this.DATA[30];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(209.0f, 156.0f, (value2 * 21) + 209, 175.0f, Region.Op.UNION);
        int value3 = this.DATA[31];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(753.0f, 154.0f, (value3 * 21) + 753, 175.0f, Region.Op.UNION);
        if (this.DATA[29] != 0) {
            c.clipRect(192.0f, 225.0f, 314.0f, 262.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(352.0f, 224.0f, 505.0f, 263.0f, Region.Op.UNION);
        }
        int value4 = this.DATA[22];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 7) {
            value4 = 7;
        }
        c.clipRect(538.0f, 236.0f, (value4 * 20) + 538, 290.0f, Region.Op.UNION);
        int value5 = this.DATA[25];
        if (value5 > 5 && value5 <= 9) {
            int leve = value5 - 5;
            c.clipRect(753.0f, 222.0f, (leve * 18) + 753, 281.0f, Region.Op.UNION);
            c.clipRect(928.0f, 226.0f, 928.0f, 279.0f, Region.Op.UNION);
        } else if (value5 > 0 && value5 < 5) {
            int leve2 = 5 - value5;
            c.clipRect(753.0f, 222.0f, 753.0f, 281.0f, Region.Op.UNION);
            c.clipRect(928.0f, 226.0f, (leve2 * 18) + 928, 279.0f, Region.Op.UNION);
        } else if (value5 == 5 || value5 == 0) {
            c.clipRect(753.0f, 222.0f, 753.0f, 281.0f, Region.Op.UNION);
            c.clipRect(928.0f, 226.0f, 928.0f, 279.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[17];
        if (temp == -2) {
            c.drawText("LOW", 51.0f, 78.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 51.0f, 78.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 51.0f, 78.0f, this.mPaint);
        }
        int temp2 = this.DATA[23];
        if (temp2 == -2) {
            c.drawText("LOW", 780.0f, 78.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 780.0f, 78.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 780.0f, 78.0f, this.mPaint);
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
