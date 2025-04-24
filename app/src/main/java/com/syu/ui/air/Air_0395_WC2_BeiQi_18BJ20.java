package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0395_WC2_BeiQi_18BJ20 extends AirBase {
    public Air_0395_WC2_BeiQi_18BJ20(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_18bj20.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_18bj20_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(350.0f, 21.0f, 527.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(915.0f, 98.0f, 1003.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(909.0f, 19.0f, 1001.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(776.0f, 111.0f, 844.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(16.0f, 109.0f, 133.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(176.0f, 17.0f, 276.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(174.0f, 90.0f, 272.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(594.0f, 10.0f, 674.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(610.0f, 130.0f, 686.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(614.0f, 67.0f, 661.0f, 93.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(600.0f, 92.0f, 639.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(744.0f, 13.0f, 871.0f, 76.0f, Region.Op.UNION);
        }
        int value = this.DATA[39];
        c.clipRect(351.0f, 96.0f, (value * 19) + 351, 156.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 57.0f, 59.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 57.0f, 59.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 57.0f, 59.0f, this.mPaint);
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
