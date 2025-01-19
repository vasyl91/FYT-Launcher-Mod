package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0172_XBS_XP1_ChangChengFengJun6 extends AirBase {
    public Air_0172_XBS_XP1_ChangChengFengJun6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0172_xbs_xp1_changchengfengjun6/air_xbs_xp1_changchengfengjun6_n.webp";
        this.mPathHighlight = "0172_xbs_xp1_changchengfengjun6/air_xbs_xp1_changchengfengjun6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[3] != 0) {
            c.clipRect(167.0f, 55.0f, 301.0f, 116.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(32.0f, 106.0f, 129.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(881.0f, 36.0f, 1010.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(915.0f, 86.0f, 1010.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(887.0f, 108.0f, 1010.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(320.0f, 54.0f, 472.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(506.0f, 36.0f, 629.0f, 146.0f, Region.Op.UNION);
        }
        int value = this.DATA[12];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(690.0f, 75.0f, (value * 20) + 690, 145.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[7];
        if (temp == -1) {
            c.drawText("NO", 65.0f, 58.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 65.0f, 58.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 65.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp), 65.0f, 58.0f, this.mPaint);
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
