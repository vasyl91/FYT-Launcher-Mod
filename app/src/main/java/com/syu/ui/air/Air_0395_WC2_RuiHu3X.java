package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0395_WC2_RuiHu3X extends AirBase {
    public Air_0395_WC2_RuiHu3X(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_ruihu_3x.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_ruihu_3x_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(186.0f, 15.0f, 329.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(705.0f, 22.0f, 836.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(547.0f, 9.0f, 624.0f, 61.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(560.0f, 138.0f, 631.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(41.0f, 97.0f, 131.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(205.0f, 106.0f, 314.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(897.0f, 92.0f, 987.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(897.0f, 11.0f, 985.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(568.0f, 75.0f, 621.0f, 98.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(545.0f, 96.0f, 592.0f, 132.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(699.0f, 92.0f, 841.0f, 159.0f, Region.Op.UNION);
        }
        int value = this.DATA[39];
        c.clipRect(364.0f, 71.0f, (value * 19) + 364, 137.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 76.0f, 72.0f, this.mPaint);
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
