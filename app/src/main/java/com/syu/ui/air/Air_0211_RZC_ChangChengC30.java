package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0211_RZC_ChangChengC30 extends AirBase {
    public Air_0211_RZC_ChangChengC30(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0211_rzc_changchengc30/air_rzc_changchengc30_n.webp";
        this.mPathHighlight = "0211_rzc_changchengc30/air_rzc_changchengc30_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(867.0f, 99.0f, 1017.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(901.0f, 18.0f, 976.0f, 70.0f, Region.Op.UNION);
        }
        switch (this.DATA[5]) {
            case 1:
                c.clipRect(389.0f, 80.0f, 450.0f, 106.0f, Region.Op.UNION);
                break;
            case 2:
                c.clipRect(389.0f, 80.0f, 450.0f, 106.0f, Region.Op.UNION);
                c.clipRect(382.0f, 107.0f, 422.0f, 146.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(382.0f, 107.0f, 422.0f, 146.0f, Region.Op.UNION);
                break;
            case 4:
                c.clipRect(382.0f, 107.0f, 422.0f, 146.0f, Region.Op.UNION);
                c.clipRect(379.0f, 13.0f, 460.0f, 74.0f, Region.Op.UNION);
                break;
            case 5:
                c.clipRect(379.0f, 13.0f, 460.0f, 74.0f, Region.Op.UNION);
                break;
        }
        if (this.DATA[2] != 0) {
            c.clipRect(515.0f, 36.0f, 658.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 0) {
            c.clipRect(196.0f, 37.0f, 344.0f, 118.0f, Region.Op.UNION);
        }
        int value = this.DATA[6];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(678.0f, 67.0f, (value * 21) + 678, 136.0f, Region.Op.UNION);
        c.clipRect(24.0f, 76.0f, (this.DATA[4] * 21) + 24, 136.0f, Region.Op.UNION);
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
