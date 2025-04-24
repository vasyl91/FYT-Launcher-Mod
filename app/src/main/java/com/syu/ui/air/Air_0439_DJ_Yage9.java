package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_DJ_Yage9 extends AirBase {
    public Air_0439_DJ_Yage9(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_dj_yage9/daojun_yag9.webp";
        this.mPathHighlight = "0439_dj_yage9/daojun_yag9_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(151.0f, 108.0f, 274.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(513.0f, 107.0f, 613.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(162.0f, 25.0f, 262.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(512.0f, 16.0f, 611.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(355.0f, 17.0f, 415.0f, 52.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(342.0f, 13.0f, 432.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(643.0f, 14.0f, 721.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(641.0f, 95.0f, 723.0f, 160.0f, Region.Op.UNION);
        }
        int valuelevel = this.DATA[11];
        if (valuelevel >= 0 && valuelevel <= 7) {
            c.clipRect(329.0f, 91.0f, (valuelevel * 20) + 329, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(766.0f, 34.0f, 831.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(777.0f, 84.0f, 826.0f, 103.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(774.0f, 100.0f, 810.0f, 136.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[12];
        if (temp == -2) {
            c.drawText("LOW", 62.0f, 89.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 62.0f, 89.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 62.0f, 89.0f, this.mPaint);
        }
        int temp2 = this.DATA[13];
        if (temp2 == -2) {
            c.drawText("LOW", 943.0f, 89.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 943.0f, 89.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 943.0f, 89.0f, this.mPaint);
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
