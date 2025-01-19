package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0419_WC2_JingyiX5 extends AirBase {
    public Air_0419_WC2_JingyiX5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0419_wc2_guochan2/air_wc2_jingyix5.webp";
        this.mPathHighlight = "0419_wc2_guochan2/air_wc2_jingyix5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(16.0f, 102.0f, 155.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(200.0f, 112.0f, 323.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(384.0f, 25.0f, 449.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(911.0f, 106.0f, 972.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(883.0f, 10.0f, 986.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(214.0f, 11.0f, 308.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(393.0f, 88.0f, 443.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(376.0f, 108.0f, 419.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(696.0f, 49.0f, 843.0f, 122.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value > 8) {
            value = 8;
        }
        c.clipRect(538.0f, 63.0f, (value * 17) + 538, 125.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[21];
        if (left_temp == -2) {
            c.drawText("LOW", 65.0f, 60.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 65.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 2.0f), 65.0f, 60.0f, this.mPaint);
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
