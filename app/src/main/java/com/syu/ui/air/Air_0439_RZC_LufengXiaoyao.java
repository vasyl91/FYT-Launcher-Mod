package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_RZC_LufengXiaoyao extends AirBase {
    public Air_0439_RZC_LufengXiaoyao(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_rzc_lufengxiaoyao/rzc_lufengxiaoyao.webp";
        this.mPathHighlight = "0439_rzc_lufengxiaoyao/rzc_lufengxiaoyao_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(869.0f, 54.0f, 1011.0f, 120.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(392.0f, 23.0f, 489.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(712.0f, 45.0f, 837.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(208.0f, 13.0f, 305.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(206.0f, 92.0f, 298.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(580.0f, 23.0f, 643.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(584.0f, 83.0f, 640.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(571.0f, 107.0f, 612.0f, 139.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(399.0f, 92.0f, (value * 17) + 399, 150.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 77.0f, 101.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 77.0f, 101.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("HI", 77.0f, 101.0f, this.mPaint);
        } else {
            int temp2 = ((temp * 5) + 170) & 65535;
            c.drawText(temp2 / 10 + "." + (temp2 % 10) + "℃", 77.0f, 101.0f, this.mPaint);
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
