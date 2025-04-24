package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_RZC_Jianghuai_All extends AirBase {
    public Air_0439_RZC_Jianghuai_All(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_rzc_jianghuai/rzc_jianghuai.webp";
        this.mPathHighlight = "0439_rzc_jianghuai/rzc_jianghuai_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(739.0f, 107.0f, 798.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(710.0f, 14.0f, 835.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(882.0f, 108.0f, 996.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(570.0f, 18.0f, 649.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(586.0f, 86.0f, 635.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(576.0f, 107.0f, 614.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(198.0f, 53.0f, 317.0f, 143.0f, Region.Op.UNION);
        }
        int value = this.DATA[16];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        if (value != 0) {
            c.clipRect(15.0f, 95.0f, 168.0f, 150.0f, Region.Op.UNION);
        }
        c.clipRect(374.0f, 45.0f, (value * 19) + 374, 121.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[17];
        if (temp == -1) {
            c.drawText("NO", 73.0f, 57.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 73.0f, 57.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 73.0f, 57.0f, this.mPaint);
        } else {
            int value1 = (temp * 5) + 170;
            c.drawText(String.valueOf(value1 / 10.0f), 73.0f, 57.0f, this.mPaint);
        }
        int temp1 = this.DATA[18];
        if (temp1 == -1) {
            c.drawText("NO", 924.0f, 57.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 924.0f, 57.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 924.0f, 57.0f, this.mPaint);
        } else {
            int value2 = (temp1 * 5) + 170;
            c.drawText(String.valueOf(value2 / 10.0f), 924.0f, 57.0f, this.mPaint);
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
