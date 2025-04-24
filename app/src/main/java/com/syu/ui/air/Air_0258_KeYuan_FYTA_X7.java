package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0258_KeYuan_FYTA_X7 extends AirBase {
    public Air_0258_KeYuan_FYTA_X7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0258_fyt_keyuan/air_fyt_keyuan_x7_n.webp";
        this.mPathHighlight = "0258_fyt_keyuan/air_fyt_keyuan_x7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[5] != 0) {
            c.clipRect(356.0f, 26.0f, 504.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(412.0f, 124.0f, 448.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(400.0f, 138.0f, 434.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(403.0f, 86.0f, 457.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(209.0f, 91.0f, 311.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(536.0f, 103.0f, 655.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(188.0f, 10.0f, 338.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(519.0f, 20.0f, 679.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(709.0f, 21.0f, 840.0f, 73.0f, Region.Op.UNION);
        }
        int value = this.DATA[1];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(721.0f, 100.0f, (value * 18) + 721, 155.0f, Region.Op.UNION);
        int value2 = this.DATA[13];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(83.0f, 132.0f, (value2 * 19) + 83, 157.0f, Region.Op.UNION);
        int value3 = this.DATA[14];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(897.0f, 134.0f, (value3 * 19) + 897, 159.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[11];
        if (left_temp == 0) {
            c.drawText("----", 72.0f, 76.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 2.0f), 72.0f, 76.0f, this.mPaint);
        }
        int right_temp = this.DATA[12];
        if (right_temp == 0) {
            c.drawText("----", 929.0f, 76.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 2.0f), 929.0f, 76.0f, this.mPaint);
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
