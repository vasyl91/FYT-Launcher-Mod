package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0439_DJ_MAZIDA6 extends AirBase {
    public Air_0439_DJ_MAZIDA6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0440_daojun_mazida6/air_0440_mazida6.webp";
        this.mPathHighlight = "0440_daojun_mazida6/air_0440_mazida6_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(131.0f, 26.0f, 255.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(163.0f, 107.0f, 223.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(20.0f, 105.0f, 119.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(277.0f, 25.0f, 370.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(278.0f, 106.0f, 371.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(787.0f, 15.0f, 879.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(787.0f, 94.0f, 876.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(604.0f, 17.0f, 743.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(909.0f, 100.0f, 1007.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(433.0f, 26.0f, 508.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(449.0f, 80.0f, 503.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(443.0f, 108.0f, 478.0f, 139.0f, Region.Op.UNION);
        }
        int value = this.DATA[17];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(611.0f, 94.0f, (value * 20) + 611, 157.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[14];
        if (temp == -2) {
            c.drawText("LOW", 51.0f, 54.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 51.0f, 54.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 51.0f, 54.0f, this.mPaint);
        }
        int temp1 = this.DATA[15];
        if (temp1 == -2) {
            c.drawText("LOW", 944.0f, 54.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 944.0f, 54.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp1 / 2.0f).toString(), 944.0f, 54.0f, this.mPaint);
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
