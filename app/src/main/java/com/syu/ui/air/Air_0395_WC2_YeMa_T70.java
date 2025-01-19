package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0395_WC2_YeMa_T70 extends AirBase {
    public Air_0395_WC2_YeMa_T70(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_yema_T70.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_yema_T70_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(17.0f, 109.0f, 161.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(377.0f, 23.0f, 455.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(390.0f, 87.0f, 443.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(373.0f, 107.0f, 428.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(911.0f, 105.0f, 992.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(888.0f, 11.0f, 988.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(209.0f, 13.0f, 314.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(198.0f, 99.0f, 323.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(702.0f, 51.0f, 842.0f, 143.0f, Region.Op.UNION);
        }
        int value = this.DATA[39];
        c.clipRect(546.0f, 70.0f, (value * 18) + 546, 132.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 60.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 76.0f, 60.0f, this.mPaint);
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
