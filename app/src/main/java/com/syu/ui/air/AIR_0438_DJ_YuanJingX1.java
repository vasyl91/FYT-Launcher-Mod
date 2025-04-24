package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class AIR_0438_DJ_YuanJingX1 extends AirBase {
    public AIR_0438_DJ_YuanJingX1(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0438_yuanjingX1/air_dihaoyuanjingX1.webp";
        this.mPathHighlight = "0438_yuanjingX1/air_dihaoyuanjingX1_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[4] != 0) {
            c.clipRect(885.0f, 17.0f, 982.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(13.0f, 23.0f, 163.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(203.0f, 17.0f, 311.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(549.0f, 54.0f, 605.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(549.0f, 76.0f, 605.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(545.0f, 95.0f, 586.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 1) {
            c.clipRect(361.0f, 53.0f, 502.0f, 119.0f, Region.Op.UNION);
        }
        int value = this.DATA[5];
        c.clipRect(698.0f, 60.0f, (value * 18) + 698, 126.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[9];
        if (left_temp < 1) {
            c.drawText("LOW", 65.0f, 132.0f, this.mPaint);
        } else if (left_temp >= 30) {
            c.drawText("HI", 65.0f, 132.0f, this.mPaint);
        } else {
            int left_temp2 = (left_temp * 5) + 165;
            c.drawText(left_temp2 / 10 + "." + (left_temp2 % 10), 65.0f, 132.0f, this.mPaint);
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
