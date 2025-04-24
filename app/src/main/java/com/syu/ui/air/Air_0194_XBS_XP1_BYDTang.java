package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0194_XBS_XP1_BYDTang extends AirBase {
    public Air_0194_XBS_XP1_BYDTang(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0194_xbs_xp1_bydtang/ic_xbs_xp1_byttang_n.webp";
        this.mPathHighlight = "0194_xbs_xp1_bydtang/ic_xbs_xp1_byttang_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(862.0f, 23.0f, 1007.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(679.0f, 11.0f, 826.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(195.0f, 103.0f, 318.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(377.0f, 13.0f, 466.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(381.0f, 95.0f, 470.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(42.0f, 26.0f, 132.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(196.0f, 17.0f, 319.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(526.0f, 12.0f, 608.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(532.0f, 78.0f, 596.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(526.0f, 109.0f, 579.0f, 153.0f, Region.Op.UNION);
        }
        int value = this.DATA[17];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(701.0f, 111.0f, 701.0f + (value * 15.5f), 167.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[23];
        if (temp == -1) {
            c.drawText("NONE", 60.0f, 130.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 60.0f, 130.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 60.0f, 130.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -1) {
            c.drawText("NONE", 940.0f, 130.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 130.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 940.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 940.0f, 130.0f, this.mPaint);
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
