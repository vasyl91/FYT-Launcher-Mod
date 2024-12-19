package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0379_HC_GL6 extends AirBase {
    public Air_0379_HC_GL6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 200;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0379_hc_gl6/hc_gl6.webp";
        this.mPathHighlight = "0379_hc_gl6/hc_gl6_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[107] != 0) {
            c.clipRect(15.0f, 30.0f, 185.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[89] == 0) {
            c.clipRect(430.0f, 12.0f, 590.0f, 88.0f, Region.Op.UNION);
        }
        if (this.DATA[91] != 0) {
            c.clipRect(232.0f, 12.0f, 377.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[92] != 0) {
            c.clipRect(257.0f, 109.0f, 377.0f, 184.0f, Region.Op.UNION);
        }
        if (this.DATA[93] == 1) {
            c.clipRect(880.0f, 30.0f, 970.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[99] != 0) {
            c.clipRect(655.0f, 55.0f, 721.0f, 88.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(663.0f, 90.0f, 728.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(658.0f, 109.0f, 706.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[151] != 0) {
            c.clipRect(860.0f, 115.0f, 985.0f, 175.0f, Region.Op.UNION);
        }
        int value = this.DATA[112];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(458.0f, 134.0f, (value * 20) + 458, 186.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[97];
        if (temp == -2) {
            c.drawText("LOW", 40.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 40.0f, 140.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NONE", 40.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 40.0f, 140.0f, this.mPaint);
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
