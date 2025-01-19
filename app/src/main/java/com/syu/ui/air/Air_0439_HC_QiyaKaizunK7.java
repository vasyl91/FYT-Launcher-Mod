package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0439_HC_QiyaKaizunK7 extends AirBase {
    public Air_0439_HC_QiyaKaizunK7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_hc_qiyakaizunk7/hc_qiyakaizunk7.webp";
        this.mPathHighlight = "0439_hc_qiyakaizunk7/hc_qiyakaizunk7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(389.0f, 25.0f, 543.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[4] == 0) {
            c.clipRect(724.0f, 13.0f, 842.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(722.0f, 96.0f, 838.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(197.0f, 16.0f, 311.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(212.0f, 96.0f, 295.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(598.0f, 10.0f, 667.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(606.0f, 69.0f, 660.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(594.0f, 84.0f, 634.0f, 118.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(607.0f, 126.0f, 684.0f, 151.0f, Region.Op.UNION);
        }
        int value = this.DATA[7];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(396.0f, 92.0f, (value * 19) + 396, 152.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[12];
        if (temp == -1) {
            c.drawText("NO", 74.0f, 80.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 74.0f, 80.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 74.0f, 80.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) + 95;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 74.0f, 80.0f, this.mPaint);
        }
        int temp1 = this.DATA[13];
        if (temp1 == -1) {
            c.drawText("NO", 925.0f, 80.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 925.0f, 80.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 925.0f, 80.0f, this.mPaint);
        } else {
            int temp12 = (temp1 * 5) + 95;
            c.drawText(temp12 / 10 + "." + (temp12 % 10), 925.0f, 80.0f, this.mPaint);
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
