package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_HC_ZHONGHUA530 extends AirBase {
    public Air_0439_HC_ZHONGHUA530(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_hechi_zhonghua530/air_0439_zhonghua530.webp";
        this.mPathHighlight = "0439_hechi_zhonghua530/air_0439_zhonghua530_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[2] != 0) {
            c.clipRect(580.0f, 55.0f, 664.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(19.0f, 101.0f, 164.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(890.0f, 53.0f, 990.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(701.0f, 44.0f, 839.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(209.0f, 27.0f, 279.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(214.0f, 87.0f, 270.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(209.0f, 110.0f, 243.0f, 140.0f, Region.Op.UNION);
        }
        int value = this.DATA[6];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(393.0f, 45.0f, (value * 20) + 393, 126.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[10];
        if (temp == -2) {
            c.drawText("LOW", 81.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 81.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp), 81.0f, 60.0f, this.mPaint);
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
