package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0272_RZC_JiangHuai_S3 extends AirBase {
    public Air_0272_RZC_JiangHuai_S3(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0272_rzc_jianghuai_s3/air_rzc_jianghuai_s3.webp";
        this.mPathHighlight = "0272_rzc_jianghuai_s3/air_rzc_jianghuai_s3_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[14] != 0) {
            c.clipRect(26.0f, 97.0f, 136.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(906.0f, 96.0f, 973.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(204.0f, 42.0f, 312.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(373.0f, 11.0f, 460.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[15] == 0) {
            c.clipRect(695.0f, 50.0f, 846.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(385.0f, 87.0f, 451.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(373.0f, 111.0f, 421.0f, 152.0f, Region.Op.UNION);
        }
        int value = this.DATA[22];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(531.0f, 40.0f, (value * 18) + 531, 134.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[23];
        if (temp == -1) {
            c.drawText("NO", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 70.0f, 60.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 60.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 60.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 920.0f, 60.0f, this.mPaint);
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
