package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0374_XP_Keleiao extends AirBase {
    public Air_0374_XP_Keleiao(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0374_xp_keleiao/xp_keleiao.webp";
        this.mPathHighlight = "0374_xp_keleiao/xp_keleiao_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 1) {
            c.clipRect(850.0f, 15.0f, 1006.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(187.0f, 28.0f, 322.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(363.0f, 33.0f, 482.0f, 139.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(30.0f, 20.0f, 133.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(534.0f, 18.0f, 607.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(532.0f, 77.0f, 596.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(526.0f, 107.0f, 573.0f, 148.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(698.0f, 67.0f, (value * 16) + 698, 122.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 74.0f, 133.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 74.0f, 133.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 74.0f, 133.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 74.0f, 133.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 133.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 133.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 133.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 920.0f, 133.0f, this.mPaint);
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
