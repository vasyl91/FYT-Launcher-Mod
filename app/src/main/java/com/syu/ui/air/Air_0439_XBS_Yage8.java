package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_XBS_Yage8 extends AirBase {
    public Air_0439_XBS_Yage8(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0055_wc1_xiandaiix45/air_wc1_ix45_n.webp";
        this.mPathHighlight = "0055_wc1_xiandaiix45/air_wc1_ix45_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[3] != 0) {
            c.clipRect(876.0f, 27.0f, 990.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(49.0f, 27.0f, 133.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(376.0f, 16.0f, 457.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(389.0f, 81.0f, 448.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(372.0f, 103.0f, 418.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(180.0f, 59.0f, 334.0f, 111.0f, Region.Op.UNION);
        }
        int value = this.DATA[7];
        if (value < 0) {
            value = 0;
        } else if (value >= 7) {
            value = 8;
        }
        c.clipRect(533.0f, 58.0f, (value * 18) + 533, 125.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[8];
        if (temp == -1) {
            c.drawText("NO", 70.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 140.0f, this.mPaint);
        } else if (temp == 20) {
            c.drawText("18.0", 70.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 70.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[9];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 140.0f, this.mPaint);
        } else if (temp2 == 20) {
            c.drawText("18.0", 920.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 920.0f, 140.0f, this.mPaint);
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
