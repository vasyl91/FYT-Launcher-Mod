package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0071_RZC_XP1_HaiMaM8 extends AirBase {
    public Air_0071_RZC_XP1_HaiMaM8(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0071_rzc_xp1_haimam8/air_rzc_haimam8.webp";
        this.mPathHighlight = "0071_rzc_xp1_haimam8/air_rzc_haimam8_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[15] != 0) {
            c.clipRect(209.0f, 100.0f, 327.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(702.0f, 91.0f, 843.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(725.0f, 11.0f, 820.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(544.0f, 15.0f, 653.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(38.0f, 99.0f, 137.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(877.0f, 98.0f, 1002.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(191.0f, 20.0f, 326.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(364.0f, 106.0f, 485.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(379.0f, 10.0f, 434.0f, 32.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(390.0f, 35.0f, 444.0f, 51.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(380.0f, 49.0f, 420.0f, 79.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(541.0f, 94.0f, (value * 19) + 541, 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[16];
        if (temp == -2) {
            c.drawText("LOW", 55.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 55.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 55.0f, 60.0f, this.mPaint);
        }
        int temp2 = this.DATA[17];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 60.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 930.0f, 60.0f, this.mPaint);
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
