package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_OUDI_17Fengjun6 extends AirBase {
    public Air_0439_OUDI_17Fengjun6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_17fengjun6/oudi_17fengjun6.webp";
        this.mPathHighlight = "0439_oudi_17fengjun6/oudi_17fengjun6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(145.0f, 65.0f, 269.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(294.0f, 68.0f, 391.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(793.0f, 19.0f, 876.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(783.0f, 91.0f, 879.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(438.0f, 25.0f, 513.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(452.0f, 83.0f, 507.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(438.0f, 107.0f, 482.0f, 139.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(602.0f, 46.0f, (value * 19) + 602, 117.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(40.0f);
        int temp = this.DATA[9];
        if (temp == -1) {
            c.drawText("NO", 55.0f, 79.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 55.0f, 79.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 55.0f, 79.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp + 17), 55.0f, 79.0f, this.mPaint);
        }
        int temp1 = this.DATA[10];
        if (temp1 == -1) {
            c.drawText("NO", 946.0f, 79.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 946.0f, 79.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 946.0f, 79.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp1 + 17), 55.0f, 79.0f, this.mPaint);
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
