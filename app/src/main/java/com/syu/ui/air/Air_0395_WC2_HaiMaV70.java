package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0395_WC2_HaiMaV70 extends AirBase {
    public Air_0395_WC2_HaiMaV70(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_haima_v70.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_haima_v70_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(15.0f, 26.0f, 160.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(340.0f, 18.0f, 432.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(886.0f, 96.0f, 998.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(717.0f, 93.0f, 812.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(717.0f, 12.0f, 814.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(354.0f, 92.0f, 419.0f, 117.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(349.0f, 115.0f, 399.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(186.0f, 44.0f, 319.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(883.0f, 19.0f, 1002.0f, 68.0f, Region.Op.UNION);
        }
        int value = this.DATA[39];
        c.clipRect(530.0f, 67.0f, (value * 19) + 530, 131.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 76.0f, 152.0f, this.mPaint);
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
