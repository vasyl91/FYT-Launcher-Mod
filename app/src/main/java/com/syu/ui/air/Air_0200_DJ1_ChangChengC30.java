package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0200_DJ1_ChangChengC30 extends AirBase {
    public Air_0200_DJ1_ChangChengC30(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0200_dj1_changchengc30/air_dj1_changchengc30_n.webp";
        this.mPathHighlight = "0200_dj1_changchengc30/air_dj1_changchengc30_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(163.0f, 19.0f, 305.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(182.0f, 93.0f, 271.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(372.0f, 69.0f, 426.0f, 95.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(345.0f, 94.0f, 393.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(346.0f, 29.0f, 397.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(711.0f, 12.0f, 820.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(722.0f, 91.0f, 824.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 0) {
            c.clipRect(861.0f, 29.0f, 1008.0f, 122.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(498.0f, 60.0f, (value * 20) + 498, 153.0f, Region.Op.UNION);
        int value2 = this.DATA[5];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        c.clipRect(12.0f, 77.0f, (value2 * 19) + 12, 148.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
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
