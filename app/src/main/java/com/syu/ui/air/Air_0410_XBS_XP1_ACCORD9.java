package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0410_XBS_XP1_ACCORD9 extends AirBase {
    public Air_0410_XBS_XP1_ACCORD9(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0041_xp1_accord/air_xp1_2014siyu_n.webp";
        this.mPathHighlight = "0041_xp1_accord/air_xp1_2014siyu_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[34] != 0) {
            c.clipRect(735.0f, 19.0f, 848.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(206.0f, 18.0f, 303.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(203.0f, 97.0f, 303.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[32] == 0) {
            c.clipRect(521.0f, 10.0f, 689.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(895.0f, 20.0f, 1006.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(354.0f, 13.0f, 437.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(389.0f, 85.0f, 450.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(359.0f, 111.0f, 407.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(15.0f, 23.0f, 159.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(731.0f, 93.0f, 851.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[43] == 1) {
            c.clipRect(117.0f, 96.0f, 170.0f, 163.0f, Region.Op.UNION);
            c.clipRect(969.0f, 99.0f, 1019.0f, 163.0f, Region.Op.UNION);
        }
        int value = this.DATA[39];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(547.0f, 96.0f, (value * 20) + 547, 159.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[40];
        if (temp == -1) {
            c.drawText("NO", 65.0f, 135.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 65.0f, 135.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 65.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 65.0f, 135.0f, this.mPaint);
        }
        int temp2 = this.DATA[41];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 135.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 135.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 930.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 135.0f, this.mPaint);
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
