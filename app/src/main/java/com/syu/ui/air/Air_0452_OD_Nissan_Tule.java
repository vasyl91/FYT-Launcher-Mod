package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_OD_Nissan_Tule extends AirBase {
    public Air_0452_OD_Nissan_Tule(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0411_wc_landrover/air_wc_landrover.webp";
        this.mPathHighlight = "0411_wc_landrover/air_wc_landrover_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[21] != 0) {
            c.clipRect(13.0f, 17.0f, 137.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(749.0f, 23.0f, 861.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(327.0f, 19.0f, 405.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(172.0f, 9.0f, 275.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(170.0f, 94.0f, 271.0f, 166.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(319.0f, 100.0f, 416.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(607.0f, 21.0f, 686.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(633.0f, 87.0f, 679.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(617.0f, 105.0f, 673.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(885.0f, 17.0f, 1012.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value >= 0 && value <= 7) {
            c.clipRect(469.0f, 60.0f, (value * 15) + 469, 119.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LOW", 50.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 50.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 941.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 941.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 941.0f, 140.0f, this.mPaint);
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
