package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0404_RZC_RuiHu7 extends AirBase {
    public Air_0404_RZC_RuiHu7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0404_rzc_ruihu7/air_rzc_ruihu7.webp";
        this.mPathHighlight = "0404_rzc_ruihu7/air_rzc_ruihu7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(15.0f, 15.0f, 159.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(371.0f, 12.0f, 471.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[62] != 0) {
            c.clipRect(897.0f, 23.0f, 995.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(219.0f, 103.0f, 298.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(190.0f, 17.0f, 320.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(729.0f, 93.0f, 824.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(392.0f, 80.0f, 458.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(375.0f, 106.0f, 434.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(522.0f, 48.0f, 664.0f, 140.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(716.0f, 36.0f, (value * 16) + 716, 89.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 142.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 46.0f, 142.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 142.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 10.0f), 930.0f, 142.0f, this.mPaint);
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
