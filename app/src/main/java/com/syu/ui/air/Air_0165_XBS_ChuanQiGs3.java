package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0165_XBS_ChuanQiGs3 extends AirBase {
    public Air_0165_XBS_ChuanQiGs3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0165_xbs_chuangqi_gs3/air.webp";
        this.mPathHighlight = "0165_xbs_chuangqi_gs3/air_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[35] != 0) {
            c.clipRect(744.0f, 100.0f, 865.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(191.0f, 100.0f, 257.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[51] != 0) {
            c.clipRect(604.0f, 101.0f, 717.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[48] != 0) {
            c.clipRect(159.0f, 26.0f, 286.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(320.0f, 13.0f, 408.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(320.0f, 96.0f, 403.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(617.0f, 24.0f, 699.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(468.0f, 25.0f, 535.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(472.0f, 81.0f, 521.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(470.0f, 103.0f, 503.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(743.0f, 11.0f, 866.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[44];
        c.clipRect(907.0f, 78.0f, (value * 14) + 907, 120.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == 0) {
            c.drawText("LOW", 65.0f, 72.0f, this.mPaint);
        } else if (left_temp == 255) {
            c.drawText("HI", 65.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((left_temp * 5) / 10.0f).toString(), 65.0f, 72.0f, this.mPaint);
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
