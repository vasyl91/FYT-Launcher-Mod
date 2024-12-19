package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0096_RZC1_FML_M3_S7 extends AirBase {
    public Air_0096_RZC1_FML_M3_S7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0096_rzc1_fml_m3_s7/air_rzc1_haimas7.webp";
        this.mPathHighlight = "0096_rzc1_fml_m3_s7/air_rzc1_haimas7_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(51.0f, 102.0f, 150.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(878.0f, 107.0f, 959.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(878.0f, 24.0f, 963.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(482.0f, 67.0f, 543.0f, 93.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(452.0f, 94.0f, 499.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 1) {
            c.clipRect(230.0f, 11.0f, 384.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(671.0f, 93.0f, 777.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(668.0f, 17.0f, 769.0f, 82.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        c.clipRect(250.0f, 102.0f, (value * 20) + 250, 165.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -1) {
            c.drawText("NO", 70.0f, 70.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 70.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 70.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 70.0f, 70.0f, this.mPaint);
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
