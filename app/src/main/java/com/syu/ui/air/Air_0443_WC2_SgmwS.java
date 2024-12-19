package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0443_WC2_SgmwS extends AirBase {
    public Air_0443_WC2_SgmwS(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0443_wc2_sgmws/air_0433_sgmws.webp";
        this.mPathHighlight = "0443_wc2_sgmws/air_0433_sgmws_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[30] != 0) {
            c.clipRect(828.0f, 60.0f, 1000.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(584.0f, 35.0f, 714.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[11] == 0) {
            c.clipRect(279.0f, 27.0f, 472.0f, 122.0f, Region.Op.UNION);
        }
        int value = this.DATA[31];
        if (value < 0) {
            value = 0;
        } else if (value > 4) {
            value = 3;
        }
        c.clipRect(113.0f, 88.0f, (value * 27) + 113, 147.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
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
