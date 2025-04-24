package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_HC_Benz_C200 extends AirBase {
    public Air_0439_HC_Benz_C200(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_hc_benz_c200/benzc200_n.webp";
        this.mPathHighlight = "0439_hc_benz_c200/benzc200_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[17] != 0) {
            c.clipRect(517.0f, 51.0f, 577.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(162.0f, 93.0f, 275.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(752.0f, 100.0f, 861.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(753.0f, 18.0f, 863.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(294.0f, 87.0f, 437.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(306.0f, 10.0f, 420.0f, 89.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(175.0f, 20.0f, 260.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(615.0f, 89.0f, 665.0f, 105.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(602.0f, 60.0f, 654.0f, 87.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(597.0f, 11.0f, 664.0f, 60.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(601.0f, 102.0f, 642.0f, 130.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(626.0f, 139.0f, 692.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(8.0f, 7.0f, 137.0f, 69.0f, Region.Op.UNION);
            c.clipRect(902.0f, 15.0f, 1012.0f, 65.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(464.0f, 91.0f, (value * 13) + 464, 154.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[24];
        if (temp == -2) {
            c.drawText("LOW", 60.0f, 100.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 100.0f, this.mPaint);
        } else if (this.DATA[23] != 0) {
            c.drawText(String.valueOf(temp), 60.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 60.0f, 100.0f, this.mPaint);
        }
        int temp2 = this.DATA[25];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 100.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 100.0f, this.mPaint);
        } else if (this.DATA[23] != 0) {
            c.drawText(String.valueOf(temp2), 930.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 100.0f, this.mPaint);
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
