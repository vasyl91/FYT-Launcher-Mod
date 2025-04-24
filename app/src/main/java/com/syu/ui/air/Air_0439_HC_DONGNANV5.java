package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_HC_DONGNANV5 extends AirBase {
    public Air_0439_HC_DONGNANV5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_hechi_dongnanv5/air_0439_dongnanv5.webp";
        this.mPathHighlight = "0439_hechi_dongnanv5/air_0439_dongnanv5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(43.0f, 104.0f, 139.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(580.0f, 67.0f, 671.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(889.0f, 18.0f, 983.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(897.0f, 94.0f, 986.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(701.0f, 44.0f, 847.0f, 130.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(204.0f, 22.0f, 285.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(219.0f, 87.0f, 269.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(208.0f, 109.0f, 244.0f, 141.0f, Region.Op.UNION);
        }
        int value = this.DATA[6];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(374.0f, 36.0f, (value * 20) + 374, 126.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[10];
        if (temp == -2) {
            c.drawText("LOW", 60.0f, 66.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 66.0f, this.mPaint);
        } else {
            int temp2 = ((temp * 5) + 160) & 65535;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 60.0f, 66.0f, this.mPaint);
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
