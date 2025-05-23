package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_DJ_Ford_Fiesta extends AirBase {
    public Air_0452_DJ_Ford_Fiesta(Context context) {
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
        if (this.DATA[7] != 0) {
            c.clipRect(13.0f, 17.0f, 137.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(749.0f, 23.0f, 861.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(327.0f, 19.0f, 405.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(746.0f, 98.0f, 871.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(172.0f, 9.0f, 275.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(170.0f, 94.0f, 271.0f, 166.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(319.0f, 100.0f, 416.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(622.0f, 136.0f, 697.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(607.0f, 21.0f, 686.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(633.0f, 87.0f, 679.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(617.0f, 105.0f, 673.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(885.0f, 17.0f, 1012.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[17];
        if (value >= 0 && value <= 7) {
            c.clipRect(468.0f, 60.0f, (value * 16) + 468, 119.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[18];
        if (temp == -2) {
            c.drawText("LOW", 60.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 140.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("None", 60.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 60.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[19];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("None", 930.0f, 140.0f, this.mPaint);
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
