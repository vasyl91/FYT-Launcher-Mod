package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0452_RZC_BisuT5 extends AirBase {
    public Air_0452_RZC_BisuT5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_rzc_bisu_t5/air.webp";
        this.mPathHighlight = "0452_rzc_bisu_t5/air_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(454.0f, 28.0f, 544.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(123.0f, 93.0f, 248.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(846.0f, 28.0f, 968.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(565.0f, 31.0f, 647.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(141.0f, 15.0f, 239.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(323.0f, 34.0f, 386.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(311.0f, 14.0f, 389.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(321.0f, 100.0f, 386.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(21.0f, 99.0f, 83.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(698.0f, 97.0f, 746.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(704.0f, 125.0f, 738.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(702.0f, 137.0f, 726.0f, 160.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        if (value < 0) {
            value = 0;
        }
        c.clipRect(489.0f, 100.0f, (value * 20) + 489, 159.0f, Region.Op.UNION);
        int value2 = this.DATA[22];
        if (value2 < 0) {
            value2 = 0;
        }
        c.clipRect(892.0f, 123.0f, (value2 * 20) + 892, 157.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[19];
        if (temp == 0) {
            c.drawText("", 42.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.5d + (temp / 2.0f)).toString(), 42.0f, 64.0f, this.mPaint);
        }
        int temp2 = this.DATA[20];
        if (temp2 == 0) {
            c.drawText("", 711.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.5d + (temp2 / 2.0f)).toString(), 711.0f, 64.0f, this.mPaint);
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
