package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0021_WC1_MengDiOu2013 extends AirBase {
    public Air_0021_WC1_MengDiOu2013(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0021_wc_13mengdiou/mengdiou13_low.webp";
        this.mPathHighlight = "0021_wc_13mengdiou/mengdiou13_low_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[14] != 0) {
            c.clipRect(181.0f, 16.0f, 327.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(369.0f, 27.0f, 490.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(41.0f, 26.0f, 148.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(696.0f, 10.0f, 836.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(882.0f, 15.0f, 987.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(547.0f, 20.0f, 639.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(373.0f, 106.0f, 484.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(185.0f, 93.0f, 323.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(567.0f, 91.0f, 617.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(540.0f, 106.0f, 593.0f, 144.0f, Region.Op.UNION);
        }
        int value = this.DATA[11];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(717.0f, 101.0f, (value * 18) + 717, 161.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -1) {
            c.drawText("NO", 65.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 65.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 65.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 65.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[13];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 140.0f, this.mPaint);
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
