package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0419_WC2_ChangAnYX extends AirBase {
    public Air_0419_WC2_ChangAnYX(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0419_wc2_guochan2/air_wc2_changanyx.webp";
        this.mPathHighlight = "0419_wc2_guochan2/air_wc2_changanyx_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(38.0f, 32.0f, 225.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(326.0f, 12.0f, 424.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(829.0f, 35.0f, 965.0f, 134.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(345.0f, 79.0f, 408.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(330.0f, 107.0f, 402.0f, 152.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value > 8) {
            value = 8;
        }
        c.clipRect(561.0f, 68.0f, (value * 21) + 561, 140.0f, Region.Op.UNION);
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
