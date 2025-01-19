package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class Air_0139_RZC_DIHAOYUANJING extends AirBase {
    public Air_0139_RZC_DIHAOYUANJING(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0139_jl_dihaoyuanjing/air_dihaoyuanjing.webp";
        this.mPathHighlight = "0139_jl_dihaoyuanjing/air_dihaoyuanjing_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(885.0f, 17.0f, 982.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(13.0f, 23.0f, 163.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(878.0f, 97.0f, 1007.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(203.0f, 16.0f, 311.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(203.0f, 95.0f, 311.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(549.0f, 54.0f, 605.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(549.0f, 76.0f, 605.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(545.0f, 95.0f, 586.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 1) {
            c.clipRect(361.0f, 53.0f, 502.0f, 119.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(698.0f, 60.0f, (value * 18) + 698, 126.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[27];
        if (left_temp < 1) {
            c.drawText("LOW", 50.0f, 140.0f, this.mPaint);
        } else if (left_temp > 17) {
            c.drawText("HI", 50.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp + 15), 50.0f, 140.0f, this.mPaint);
        }
        int i = this.DATA[27];
        if (DataCanbus.DATA[1000] == 65801) {
            int right_temp = this.DATA[27];
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
