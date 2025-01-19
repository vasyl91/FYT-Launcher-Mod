package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0409_XP_RuiHu5 extends AirBase {
    public Air_0409_XP_RuiHu5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0409_hc_ruihu5/air_xp_qirui_ruihu5.webp";
        this.mPathHighlight = "0409_hc_ruihu5/air_xp_qirui_ruihu5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(13.0f, 23.0f, 156.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(896.0f, 24.0f, 995.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(370.0f, 46.0f, 449.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(188.0f, 103.0f, 308.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(196.0f, 23.0f, 315.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(733.0f, 93.0f, 817.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(374.0f, 72.0f, 442.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(363.0f, 95.0f, 416.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(527.0f, 40.0f, 665.0f, 130.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        c.clipRect(716.0f, 25.0f, (value * 19) + 716, 86.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[19];
        if (temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 46.0f, 152.0f, this.mPaint);
        }
        int temp2 = this.DATA[20];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 152.0f, this.mPaint);
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
