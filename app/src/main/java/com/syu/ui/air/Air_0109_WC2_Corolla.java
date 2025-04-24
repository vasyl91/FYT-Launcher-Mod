package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0109_WC2_Corolla extends AirBase {
    public Air_0109_WC2_Corolla(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0109_wc2_corolla/air_wc2_corolla_n.webp";
        this.mPathHighlight = "0109_wc2_corolla/air_wc2_corolla_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[41] != 0) {
            c.clipRect(186.0f, 54.0f, 328.0f, 121.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(361.0f, 49.0f, 490.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[44] != 0) {
            c.clipRect(529.0f, 46.0f, 652.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(16.0f, 18.0f, 141.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[45] != 0) {
            c.clipRect(911.0f, 88.0f, 965.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[46] != 0) {
            c.clipRect(885.0f, 21.0f, 960.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(886.0f, 111.0f, 931.0f, 145.0f, Region.Op.UNION);
        }
        int value = this.DATA[48];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(711.0f, 80.0f, (value * 18) + 711, 130.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[49];
        if (temp == 0) {
            c.drawText("LOW", 80.0f, 130.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 80.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp * 5) + 175) / 10.0f), 80.0f, 130.0f, this.mPaint);
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
