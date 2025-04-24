package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_RZC_Beiqi_Bj90 extends AirBase {
    public Air_0452_RZC_Beiqi_Bj90(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_ay_byd_surui/ay_byd_surui.webp";
        this.mPathHighlight = "0439_ay_byd_surui/ay_byd_surui_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int value;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[30] != 0) {
            c.clipRect(3.0f, 99.0f, 144.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(776.0f, 104.0f, 841.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(290.0f, 22.0f, 390.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(748.0f, 11.0f, 872.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(897.0f, 105.0f, 1008.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(166.0f, 12.0f, 260.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(170.0f, 92.0f, 256.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(622.0f, 24.0f, 689.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(630.0f, 84.0f, 679.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(618.0f, 106.0f, 656.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(291.0f, 96.0f, 391.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(444.0f, 21.0f, 552.0f, 67.0f, Region.Op.UNION);
        }
        int value2 = this.DATA[19];
        if (value2 == 1) {
            value = 2;
        } else if (value2 == 2) {
            value = 4;
        } else {
            value = value2 + 2;
        }
        c.clipRect(423.0f, 86.0f, (value * 19) + 423, 157.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[20];
        if (temp == -1) {
            c.drawText("NO", 63.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 63.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 63.0f, 60.0f, this.mPaint);
        } else {
            int temp2 = ((temp - 30) * 5) + 150;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 63.0f, 60.0f, this.mPaint);
        }
        int temp1 = this.DATA[21];
        if (temp1 == -1) {
            c.drawText("NO", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 930.0f, 60.0f, this.mPaint);
        } else {
            int temp12 = ((temp1 - 30) * 5) + 150;
            c.drawText(temp12 / 10 + "." + (temp12 % 10), 930.0f, 60.0f, this.mPaint);
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
