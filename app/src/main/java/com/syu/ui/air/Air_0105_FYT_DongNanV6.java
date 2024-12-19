package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0105_FYT_DongNanV6 extends AirBase {
    public Air_0105_FYT_DongNanV6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0105_fyt_dongnanv6/air_fyt_dongnan_v6_n.webp";
        this.mPathHighlight = "0105_fyt_dongnanv6/air_fyt_dongnan_v6_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(362.0f, 35.0f, 483.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(872.0f, 16.0f, 1004.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(14.0f, 11.0f, 155.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(545.0f, 12.0f, 631.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(559.0f, 82.0f, 619.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(538.0f, 106.0f, 591.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(186.0f, 26.0f, 332.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(874.0f, 91.0f, 1005.0f, 164.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        c.clipRect(687.0f, 17.0f, (value * 19) + 687, 150.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == 0) {
            c.drawText("LOW", 71.0f, 142.0f, this.mPaint);
        } else if (temp == 28) {
            c.drawText("HI", 71.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp * 5) + 160) / 10.0f).toString(), 71.0f, 142.0f, this.mPaint);
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
