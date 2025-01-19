package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0112_XP1_Camry extends AirBase {
    public Air_0112_XP1_Camry(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0112_rzc_camry/air_rzc_camry.webp";
        this.mPathHighlight = "0112_rzc_camry/air_rzc_camry_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[65] != 0) {
            c.clipRect(269.0f, 21.0f, 359.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[64] != 0 || this.DATA[63] != 0) {
            c.clipRect(265.0f, 97.0f, 359.0f, 132.0f, Region.Op.UNION);
        }
        if (this.DATA[61] != 0 || this.DATA[66] != 0) {
            c.clipRect(20.0f, 15.0f, 104.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[67] != 0) {
            c.clipRect(493.0f, 19.0f, 566.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[68] != 0) {
            c.clipRect(488.0f, 80.0f, 541.0f, 100.0f, Region.Op.UNION);
        }
        if (this.DATA[69] != 0) {
            c.clipRect(484.0f, 103.0f, 523.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[60] != 0) {
            c.clipRect(905.0f, 26.0f, 1013.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[62] == 0) {
            c.clipRect(613.0f, 19.0f, 744.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[149] == 1) {
            c.clipRect(268.0f, 134.0f, 295.0f, 157.0f, Region.Op.UNION);
        } else if (this.DATA[149] == 2) {
            c.clipRect(269.0f, 137.0f, 325.0f, 156.0f, Region.Op.UNION);
        } else if (this.DATA[149] == 3) {
            c.clipRect(269.0f, 133.0f, 354.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[181] != 0) {
            c.clipRect(83.0f, 117.0f, 122.0f, 154.0f, Region.Op.UNION);
            c.clipRect(980.0f, 115.0f, 1020.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(385.0f, 16.0f, 465.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[152] != 0) {
            c.clipRect(390.0f, 96.0f, 460.0f, 158.0f, Region.Op.UNION);
        }
        int value = this.DATA[70];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(617.0f, 93.0f, (value * 19) + 617, 160.0f, Region.Op.UNION);
        int value2 = this.DATA[200];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(182.0f, 48.0f, (value2 * 21) + 182, 80.0f, Region.Op.UNION);
        int value3 = this.DATA[202];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(182.0f, 127.0f, (value3 * 21) + 182, 159.0f, Region.Op.UNION);
        int value4 = this.DATA[201];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(816.0f, 48.0f, (value4 * 21) + 816, 80.0f, Region.Op.UNION);
        int value5 = this.DATA[203];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        c.clipRect(816.0f, 127.0f, (value5 * 21) + 816, 159.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(24.0f);
        int temp = this.DATA[71];
        if (temp == -1) {
            c.drawText("NO", 43.0f, 142.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 43.0f, 142.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 43.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 43.0f, 142.0f, this.mPaint);
        }
        int temp2 = this.DATA[72];
        if (temp2 == -1) {
            c.drawText("NO", 940.0f, 142.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 142.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 940.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 940.0f, 142.0f, this.mPaint);
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
