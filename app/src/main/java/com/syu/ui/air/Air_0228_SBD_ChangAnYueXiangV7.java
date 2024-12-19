package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0228_SBD_ChangAnYueXiangV7 extends AirBase {
    public Air_0228_SBD_ChangAnYueXiangV7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0228_sbd_changanyuexiang7/air_sbd_wc1_changan_yuexiang_v7.webp";
        this.mPathHighlight = "0228_sbd_changanyuexiang7/air_sbd_wc1_changan_yuexiang_v7_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(384.0f, 61.0f, 462.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(527.0f, 63.0f, 667.0f, 116.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(38.0f, 48.0f, 91.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(45.0f, 75.0f, 100.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(35.0f, 94.0f, 80.0f, 131.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(891.0f, 36.0f, 946.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(905.0f, 72.0f, 956.0f, 93.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(896.0f, 93.0f, 940.0f, 135.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        if (value < 0) {
            value = 0;
        }
        if (value > 8) {
            value = 8;
        }
        c.clipRect(188.0f, 40.0f, (value * 20) + 188, 132.0f, Region.Op.UNION);
        int value2 = this.DATA[9];
        if (value2 < 0) {
            value2 = 0;
        }
        if (value2 > 8) {
            value2 = 8;
        }
        c.clipRect(701.0f, 41.0f, (value2 * 20) + 701, 133.0f, Region.Op.UNION);
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
