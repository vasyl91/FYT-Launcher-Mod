package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0351_WC2_16_QiyaK5 extends AirBase {
    public Air_0351_WC2_16_QiyaK5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0351_wc2_16_qiyak5/air_wc2_qiya_k5_n.webp";
        this.mPathHighlight = "0351_wc2_16_qiyak5/air_wc2_qiya_k5_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(190.0f, 18.0f, 341.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(25.0f, 106.0f, 146.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(398.0f, 95.0f, 448.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(539.0f, 97.0f, 659.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(546.0f, 18.0f, 648.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(212.0f, 109.0f, 303.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(895.0f, 106.0f, 1006.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(378.0f, 74.0f, 438.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(386.0f, 16.0f, 450.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(383.0f, 111.0f, 425.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(399.0f, 145.0f, 459.0f, 163.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(713.0f, 40.0f, (value * 18) + 713, 121.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 76.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[11];
        if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 940.0f, 72.0f, this.mPaint);
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
