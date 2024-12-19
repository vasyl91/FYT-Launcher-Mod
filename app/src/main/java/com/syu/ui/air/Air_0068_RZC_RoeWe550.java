package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0068_RZC_RoeWe550 extends AirBase {
    public Air_0068_RZC_RoeWe550(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0342_rzc_xp1_roewe360/air_rzc_xp1_rongwei360_n.webp";
        this.mPathHighlight = "0342_rzc_xp1_roewe360/air_rzc_xp1_rongwei360_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[22] != 0) {
            c.clipRect(15.0f, 22.0f, 159.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(896.0f, 21.0f, 972.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(373.0f, 38.0f, 489.0f, 131.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(891.0f, 93.0f, 986.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(543.0f, 16.0f, 626.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(558.0f, 79.0f, 618.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(540.0f, 108.0f, 589.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(193.0f, 56.0f, 334.0f, 126.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        c.clipRect(732.0f, 69.0f, (value * 22) + 732, 124.0f, Region.Op.UNION);
        int left_temp = this.DATA[16];
        c.clipRect(12.0f, 105.0f, (left_temp * 16) + 12, 161.0f, Region.Op.UNION);
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
