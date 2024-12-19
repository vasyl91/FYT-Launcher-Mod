package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0034_WC1_LiFan720 extends AirBase {
    public Air_0034_WC1_LiFan720(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0034_wc1_lifan720/air_wc1_lifan720_n.webp";
        this.mPathHighlight = "0034_wc1_lifan720/air_wc1_lifan720_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(726.0f, 66.0f, 857.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 0) {
            c.clipRect(222.0f, 60.0f, 343.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[5] == 1) {
            c.clipRect(919.0f, 64.0f, 984.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(389.0f, 20.0f, 461.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(412.0f, 84.0f, 463.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(387.0f, 109.0f, 428.0f, 143.0f, Region.Op.UNION);
        }
        int value = this.DATA[6];
        if (value < 0) {
            value = 0;
        } else if (value > 9) {
            value = 9;
        }
        c.clipRect(536.0f, 60.0f, (value * 18) + 536, 123.0f, Region.Op.UNION);
        int value2 = this.DATA[8];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 9) {
            value2 = 9;
        }
        c.clipRect(20.0f, 59.0f, (value2 * 18) + 20, 124.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
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
