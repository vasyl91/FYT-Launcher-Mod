package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0004_FYT1_DongNanV5 extends AirBase {
    public Air_0004_FYT1_DongNanV5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0004_fyt_dongnanv5/air_fyt1_dongnanv5_n.webp";
        this.mPathHighlight = "0004_fyt_dongnanv5/air_fyt1_dongnanv5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[0] != 0) {
            c.clipRect(755.0f, 57.0f, 856.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(912.0f, 49.0f, 989.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(459.0f, 68.0f, 513.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(457.0f, 98.0f, 500.0f, 136.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 0) {
            c.clipRect(152.0f, 44.0f, 288.0f, 120.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(309.0f, 34.0f, 429.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(457.0f, 14.0f, 539.0f, 67.0f, Region.Op.UNION);
        }
        int value = this.DATA[2];
        if (value < 1) {
            value = 1;
        } else if (value > 9) {
            value = 9;
        }
        c.clipRect(583.0f, 66.0f, ((value - 1) * 18) + 583, 126.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[8];
        if (temp == 1) {
            c.drawText("LOW", 60.0f, 100.0f, this.mPaint);
        } else if (temp == 9) {
            c.drawText("HI", 60.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf((temp + 180) / 10), Integer.valueOf((temp + 180) % 10)), 60.0f, 100.0f, this.mPaint);
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
