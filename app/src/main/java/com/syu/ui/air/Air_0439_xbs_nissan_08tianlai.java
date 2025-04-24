package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_xbs_nissan_08tianlai extends AirBase {
    public Air_0439_xbs_nissan_08tianlai(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_dj_lexus_es/dj_lexus_es.webp";
        this.mPathHighlight = "0439_dj_lexus_es/dj_lexus_es_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[3] != 0) {
            c.clipRect(13.0f, 103.0f, 162.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(379.0f, 26.0f, 477.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[11] == 0) {
            c.clipRect(710.0f, 16.0f, 835.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(716.0f, 106.0f, 830.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(884.0f, 107.0f, 997.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(196.0f, 16.0f, 299.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(205.0f, 93.0f, 292.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(558.0f, 27.0f, 631.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(573.0f, 82.0f, 622.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(558.0f, 101.0f, 598.0f, 135.0f, Region.Op.UNION);
        }
        int value = this.DATA[3];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(371.0f, 94.0f, (value * 20) + 371, 151.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[1];
        if (temp == -1) {
            c.drawText("NO", 82.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 82.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 82.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(((temp + 35) * 0.5f) + " ℃", 82.0f, 60.0f, this.mPaint);
        }
        int temp1 = this.DATA[2];
        if (temp1 == -1) {
            c.drawText("NO", 933.0f, 60.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 933.0f, 60.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 933.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(((temp1 + 35) * 0.5f) + " ℃", 933.0f, 60.0f, this.mPaint);
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
