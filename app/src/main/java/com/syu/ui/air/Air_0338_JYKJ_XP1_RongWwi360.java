package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0338_JYKJ_XP1_RongWwi360 extends AirBase {
    public Air_0338_JYKJ_XP1_RongWwi360(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0338_jykj_xp1_rongwei360/air_jykj_xp1_rongwei360_n.webp";
        this.mPathHighlight = "0338_jykj_xp1_rongwei360/air_jykj_xp1_rongwei360_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(881.0f, 25.0f, 1017.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(23.0f, 22.0f, 120.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(307.0f, 38.0f, 437.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(455.0f, 38.0f, 569.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(752.0f, 52.0f, 803.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(771.0f, 81.0f, 823.0f, 103.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(750.0f, 100.0f, 793.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 1) {
            c.clipRect(154.0f, 53.0f, 288.0f, 130.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        c.clipRect(624.0f, 72.0f, (value * 21) + 624, 123.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[5];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[10];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp), 930.0f, 152.0f, this.mPaint);
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
