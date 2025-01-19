package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0198_CYT_FYTA_BYDS6 extends AirBase {
    public Air_0198_CYT_FYTA_BYDS6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0198_cyt_fyta_byds6/air_cyt_byds6_n.webp";
        this.mPathHighlight = "0198_cyt_fyta_byds6/air_cyt_byds6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[5] != 0) {
            c.clipRect(215.0f, 103.0f, 311.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(522.0f, 16.0f, 670.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(204.0f, 21.0f, 307.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(897.0f, 20.0f, 990.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(721.0f, 11.0f, 814.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(720.0f, 89.0f, 822.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(398.0f, 75.0f, 457.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(356.0f, 17.0f, 435.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(367.0f, 101.0f, 416.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(8.0f, 16.0f, 151.0f, 72.0f, Region.Op.UNION);
        }
        int value = this.DATA[11];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(527.0f, 96.0f, (value * 20) + 527, 165.0f, Region.Op.UNION);
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
