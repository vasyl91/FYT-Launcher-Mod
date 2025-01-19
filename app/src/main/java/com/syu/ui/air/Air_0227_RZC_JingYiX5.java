package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0227_RZC_JingYiX5 extends AirBase {
    public Air_0227_RZC_JingYiX5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0226_fyta_changanyuexiang7/air_rzc_jingyi_x5_n.webp";
        this.mPathHighlight = "0226_fyta_changanyuexiang7/air_rzc_jingyi_x5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(15.0f, 18.0f, 160.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(901.0f, 17.0f, 971.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(222.0f, 97.0f, 328.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(199.0f, 14.0f, 342.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[62] != 0) {
            c.clipRect(397.0f, 107.0f, 507.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(732.0f, 91.0f, 830.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(716.0f, 9.0f, 837.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(553.0f, 10.0f, 644.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(561.0f, 85.0f, 627.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(552.0f, 112.0f, 604.0f, 161.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(393.0f, 18.0f, 393.0f + (value * 17.5f), 87.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 66.0f, 147.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 66.0f, 147.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NONE", 66.0f, 147.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp), 66.0f, 147.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 147.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 147.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("NONE", 930.0f, 147.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp), 930.0f, 147.0f, this.mPaint);
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
