package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_OD_Weichai_U70 extends AirBase {
    public Air_0452_OD_Weichai_U70(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0020_xp1_camry2013/air_bnr_camry2013.webp";
        this.mPathHighlight = "0020_xp1_camry2013/air_bnr_camry2013_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(208.0f, 105.0f, 311.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(53.0f, 26.0f, 128.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(527.0f, 20.0f, 607.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(536.0f, 81.0f, 598.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(528.0f, 110.0f, 573.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(860.0f, 25.0f, 1004.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(681.0f, 17.0f, 820.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(372.0f, 16.0f, 471.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(378.0f, 92.0f, 474.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[16];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(682.0f, 90.0f, 682.0f + (value * 19.4f), 156.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[17];
        if (temp == -1) {
            c.drawText("NO", 70.0f, 132.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 132.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 70.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp * 5) + 175) / 10.0f), 70.0f, 132.0f, this.mPaint);
        }
        int temp2 = this.DATA[18];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 132.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 132.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 920.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp2 * 5) + 175) / 10.0f), 920.0f, 132.0f, this.mPaint);
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
