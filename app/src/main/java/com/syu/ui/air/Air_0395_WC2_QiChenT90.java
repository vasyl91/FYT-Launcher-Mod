package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0395_WC2_QiChenT90 extends AirBase {
    public Air_0395_WC2_QiChenT90(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_qichent90.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_qichent90_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(5.0f, 24.0f, 166.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(533.0f, 101.0f, 665.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(362.0f, 12.0f, 457.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[72] != 0) {
            c.clipRect(870.0f, 17.0f, 1005.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(200.0f, 102.0f, 302.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(696.0f, 91.0f, 844.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(197.0f, 10.0f, 323.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(376.0f, 81.0f, 441.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(358.0f, 113.0f, 416.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(517.0f, 8.0f, 674.0f, 80.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[39];
        c.drawText(new StringBuilder().append(value).toString(), 773.0f, 60.0f, this.mPaint);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 69.0f, 140.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 69.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 10.0f).toString(), 69.0f, 140.0f, this.mPaint);
        }
        int right_temp = this.DATA[68];
        if (right_temp == -2) {
            c.drawText("LOW", 925.0f, 140.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 925.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp / 10.0f).toString(), 925.0f, 140.0f, this.mPaint);
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
