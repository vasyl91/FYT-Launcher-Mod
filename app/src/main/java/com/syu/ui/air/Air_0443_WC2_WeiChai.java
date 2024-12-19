package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0443_WC2_WeiChai extends AirBase {
    public Air_0443_WC2_WeiChai(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0443_wc2_weichai/air_wc2_weichai.webp";
        this.mPathHighlight = "0443_wc2_weichai/air_wc2_weichai_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[0] != 0) {
            c.clipRect(23.0f, 113.0f, 154.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(521.0f, 18.0f, 618.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(904.0f, 104.0f, 988.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[4] == 0) {
            c.clipRect(699.0f, 95.0f, 837.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(710.0f, 15.0f, 824.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(204.0f, 46.0f, 314.0f, 136.0f, Region.Op.UNION);
        }
        switch (this.DATA[11]) {
            case 1:
                c.clipRect(663.0f, 144.0f, 736.0f, 164.0f, Region.Op.UNION);
                break;
            case 2:
                c.clipRect(648.0f, 20.0f, 717.0f, 74.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(359.0f, 96.0f, 408.0f, 135.0f, Region.Op.UNION);
                break;
            case 5:
                c.clipRect(374.0f, 74.0f, 444.0f, 93.0f, Region.Op.UNION);
                c.clipRect(359.0f, 96.0f, 408.0f, 135.0f, Region.Op.UNION);
                break;
            case 6:
                c.clipRect(374.0f, 74.0f, 444.0f, 93.0f, Region.Op.UNION);
                break;
            case 11:
                c.clipRect(356.0f, 39.0f, 447.0f, 72.0f, Region.Op.UNION);
                break;
            case 12:
                c.clipRect(356.0f, 39.0f, 447.0f, 72.0f, Region.Op.UNION);
                c.clipRect(359.0f, 96.0f, 408.0f, 135.0f, Region.Op.UNION);
                break;
            case 13:
                c.clipRect(356.0f, 39.0f, 447.0f, 72.0f, Region.Op.UNION);
                c.clipRect(374.0f, 74.0f, 444.0f, 93.0f, Region.Op.UNION);
                break;
            case 14:
                c.clipRect(356.0f, 39.0f, 447.0f, 72.0f, Region.Op.UNION);
                c.clipRect(374.0f, 74.0f, 444.0f, 93.0f, Region.Op.UNION);
                c.clipRect(359.0f, 96.0f, 408.0f, 135.0f, Region.Op.UNION);
                break;
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(40.0f);
        int temp = this.DATA[13];
        if (temp == 254) {
            c.drawText("LOW", 72.0f, 74.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 72.0f, 74.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 72.0f, 74.0f, this.mPaint);
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
