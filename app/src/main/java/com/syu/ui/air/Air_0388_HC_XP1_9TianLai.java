package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0388_HC_XP1_9TianLai extends AirBase {
    public Air_0388_HC_XP1_9TianLai(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0388_HC_XP1_OLD_9TianLai/HC_XP1_9TianLai.webp";
        this.mPathHighlight = "0388_HC_XP1_OLD_9TianLai/HC_XP1_9TianLai_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] == 0) {
            c.clipRect(447.0f, 48.0f, 566.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(730.0f, 21.0f, 801.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(177.0f, 104.0f, 258.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(24.0f, 27.0f, 129.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(162.0f, 27.0f, 279.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(586.0f, 33.0f, 700.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(882.0f, 17.0f, 995.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(748.0f, 94.0f, 800.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(725.0f, 114.0f, 765.0f, 147.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(307.0f, 72.0f, (value * 18) + 307, 123.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[16];
        if (temp == -1) {
            c.drawText("NONE", 64.0f, 142.0f, this.mPaint);
        } else if (temp <= 64) {
            c.drawText(String.valueOf(temp / 2.0f), 64.0f, 142.0f, this.mPaint);
        }
        int temp2 = this.DATA[17];
        if (temp2 == -1) {
            c.drawText("NONE", 926.0f, 142.0f, this.mPaint);
        } else if (temp2 <= 64) {
            c.drawText(String.valueOf(temp2 / 2.0f), 926.0f, 142.0f, this.mPaint);
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
