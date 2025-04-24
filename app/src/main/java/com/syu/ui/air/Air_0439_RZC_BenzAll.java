package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_RZC_BenzAll extends AirBase {
    public Air_0439_RZC_BenzAll(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_rzc_benz_all/rzc_benz_all.webp";
        this.mPathHighlight = "0439_rzc_benz_all/rzc_benz_all_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int valuelevel_rear;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        int valueleft = this.DATA[24];
        if (valueleft >= 0 && valueleft <= 3) {
            c.clipRect(54.0f, 136.0f, (valueleft * 17) + 54, 156.0f, Region.Op.UNION);
        }
        int valueright = this.DATA[26];
        if (valueright >= 0 && valueright <= 3) {
            c.clipRect(582.0f, 136.0f, (valueright * 17) + 582, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(120.0f, 25.0f, 182.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(268.0f, 109.0f, 342.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(269.0f, 29.0f, 350.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(462.0f, 21.0f, 568.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(199.0f, 25.0f, 253.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(428.0f, 102.0f, 563.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(366.0f, 24.0f, 448.0f, 71.0f, Region.Op.UNION);
        }
        int valuelevel = this.DATA[19];
        if (valuelevel >= 0 && valuelevel <= 7) {
            c.clipRect(139.0f, 105.0f, (valuelevel * 15) + 139, 160.0f, Region.Op.UNION);
        }
        int rearAirState = this.DATA[36];
        if (rearAirState != 0) {
            c.clipRect(752.0f, 35.0f, 862.0f, 69.0f, Region.Op.UNION);
        }
        if (rearAirState != 0 && (valuelevel_rear = this.DATA[37]) >= 0 && valuelevel_rear <= 7) {
            c.clipRect(822.0f, 105.0f, (valuelevel_rear * 15) + 822, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(362.0f, 93.0f, 402.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(369.0f, 124.0f, 399.0f, 136.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(357.0f, 135.0f, 384.0f, 156.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[20];
        if (temp == -2) {
            c.drawText("LOW", 50.0f, 66.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 66.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 50.0f, 66.0f, this.mPaint);
        }
        int temp2 = this.DATA[21];
        if (temp2 == -2) {
            c.drawText("LOW", 630.0f, 66.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 630.0f, 66.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 630.0f, 66.0f, this.mPaint);
        }
        if (rearAirState != 0) {
            int temp3 = this.DATA[38];
            if (temp3 == -2) {
                c.drawText("LOW", 940.0f, 66.0f, this.mPaint);
            } else if (temp3 == -3) {
                c.drawText("HI", 940.0f, 66.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(temp3), 940.0f, 66.0f, this.mPaint);
            }
        } else {
            c.drawText("-.-", 940.0f, 66.0f, this.mPaint);
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
