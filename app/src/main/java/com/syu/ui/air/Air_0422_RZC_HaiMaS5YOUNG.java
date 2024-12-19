package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0422_RZC_HaiMaS5YOUNG extends AirBase {
    public Air_0422_RZC_HaiMaS5YOUNG(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0422_rzc_fumeilai/air_rzc_haimas5young.webp";
        this.mPathHighlight = "0422_rzc_fumeilai/air_rzc_haimas5young_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(846.0f, 58.0f, 1015.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(537.0f, 36.0f, 602.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(40.0f, 21.0f, 114.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(382.0f, 16.0f, 468.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(376.0f, 97.0f, 462.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(537.0f, 68.0f, 611.0f, 90.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(525.0f, 92.0f, 575.0f, 130.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(183.0f, 16.0f, 329.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(183.0f, 97.0f, 329.0f, 161.0f, Region.Op.UNION);
        }
        int value = this.DATA[16];
        if (value > 7) {
            value = 7;
        }
        c.clipRect(681.0f, 73.0f, (value * 20) + 681, 134.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[23];
        if (temp == -2) {
            c.drawText("LOW", 70.0f, 137.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 137.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 70.0f, 137.0f, this.mPaint);
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
