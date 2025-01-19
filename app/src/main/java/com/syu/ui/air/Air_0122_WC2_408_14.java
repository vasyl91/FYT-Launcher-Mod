package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class Air_0122_WC2_408_14 extends AirBase {
    public Air_0122_WC2_408_14(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0122_wc2_408_14/air_wc2_408_14_n.webp";
        this.mPathHighlight = "0122_wc2_408_14/air_wc2_408_14_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int temp;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[70] != 0) {
            c.clipRect(20.0f, 23.0f, 148.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(191.0f, 24.0f, 313.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(199.0f, 98.0f, 309.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(880.0f, 18.0f, 1004.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[71] == 0) {
            c.clipRect(338.0f, 92.0f, 516.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[72] != 0) {
            c.clipRect(721.0f, 12.0f, 845.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[73] != 0) {
            c.clipRect(720.0f, 93.0f, 850.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[78] != 0) {
            c.clipRect(555.0f, 90.0f, 606.0f, 121.0f, Region.Op.UNION);
        }
        if (this.DATA[76] != 0) {
            c.clipRect(595.0f, 116.0f, 632.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[77] != 0) {
            c.clipRect(564.0f, 131.0f, 600.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[83] == 0) {
            c.clipRect(612.0f, 22.0f, 645.0f, 55.0f, Region.Op.UNION);
        } else if (this.DATA[83] == 1) {
            c.clipRect(612.0f, 22.0f, 645.0f, 55.0f, Region.Op.UNION);
            c.clipRect(576.0f, 23.0f, 607.0f, 59.0f, Region.Op.UNION);
        } else if (this.DATA[83] == 2) {
            c.clipRect(612.0f, 22.0f, 645.0f, 55.0f, Region.Op.UNION);
            c.clipRect(576.0f, 23.0f, 607.0f, 59.0f, Region.Op.UNION);
            c.clipRect(592.0f, 58.0f, 630.0f, 79.0f, Region.Op.UNION);
        }
        int value = this.DATA[79];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(364.0f, 35.0f, (value * 16) + 364, 85.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp2 = this.DATA[75];
        if (temp2 == -1) {
            c.drawText("NO", 56.0f, 132.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 56.0f, 132.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 56.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 56.0f, 132.0f, this.mPaint);
        }
        if (DataCanbus.DATA[1000] == 122) {
            temp = this.DATA[75];
        } else {
            temp = this.DATA[81];
        }
        if (temp == -1) {
            c.drawText("NO", 920.0f, 132.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 920.0f, 132.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 920.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 920.0f, 132.0f, this.mPaint);
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
