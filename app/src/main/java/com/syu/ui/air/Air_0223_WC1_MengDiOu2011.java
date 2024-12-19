package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0223_WC1_MengDiOu2011 extends AirBase {
    public Air_0223_WC1_MengDiOu2011(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0223_wc1_mengdiou2011/air_wc1_mengdiou_n.webp";
        this.mPathHighlight = "0223_wc1_mengdiou2011/air_wc1_mengdiou_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(183.0f, 15.0f, 326.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(360.0f, 21.0f, 490.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(547.0f, 19.0f, 644.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(711.0f, 11.0f, 817.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(549.0f, 91.0f, 590.0f, 117.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(363.0f, 105.0f, 505.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(183.0f, 99.0f, 319.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(575.0f, 113.0f, 614.0f, 131.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(548.0f, 132.0f, 586.0f, 165.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(717.0f, 103.0f, (value * 18) + 717, 160.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[5];
        if (temp == -1) {
            c.drawText("NO", 65.0f, 100.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 65.0f, 100.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 65.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf((temp / 2.0f) - 40.0f)).toString(), 65.0f, 100.0f, this.mPaint);
        }
        int temp2 = this.DATA[11];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 100.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 100.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf((temp2 / 2.0f) - 40.0f)).toString(), 930.0f, 100.0f, this.mPaint);
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
