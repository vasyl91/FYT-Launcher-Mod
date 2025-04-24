package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0273_RZC_17MingJueRuiTeng extends AirBase {
    public Air_0273_RZC_17MingJueRuiTeng(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0273_rzc_mingjueruiteng/air_rzc_xp1mingjueruiteng17_n.webp";
        this.mPathHighlight = "0273_rzc_mingjueruiteng/air_rzc_xp1mingjueruiteng17_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[22] != 0) {
            c.clipRect(9.0f, 21.0f, 169.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(908.0f, 22.0f, 968.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(216.0f, 106.0f, 329.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(384.0f, 15.0f, 503.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(721.0f, 12.0f, 827.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(728.0f, 91.0f, 823.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(561.0f, 12.0f, 641.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(588.0f, 134.0f, 644.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(574.0f, 78.0f, 626.0f, 98.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(563.0f, 97.0f, 605.0f, 132.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(199.0f, 22.0f, 346.0f, 78.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value == 15) {
            c.clipRect(424.0f, 91.0f, 485.0f, 111.0f, Region.Op.UNION);
        } else {
            c.clipRect(394.0f, 113.0f, (value * 17) + 394, 158.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[16];
        if (left_temp == -2) {
            c.drawText("LOW", 86.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 86.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp), 86.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[21];
        if (right_temp == -2) {
            c.drawText("LOW", 934.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 934.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp), 934.0f, 152.0f, this.mPaint);
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
