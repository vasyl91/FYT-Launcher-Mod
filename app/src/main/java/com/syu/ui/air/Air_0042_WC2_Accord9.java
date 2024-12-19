package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0042_WC2_Accord9 extends AirBase {
    public Air_0042_WC2_Accord9(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0042_wc2_accord9/air_wc2_accord9_lo.webp";
        this.mPathHighlight = "0042_wc2_accord9/air_wc2_accord9_lo_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[53] != 0) {
            c.clipRect(867.0f, 22.0f, 1000.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[42] == 0) {
            c.clipRect(447.0f, 48.0f, 566.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(730.0f, 21.0f, 801.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[45] != 0) {
            c.clipRect(177.0f, 104.0f, 258.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(24.0f, 27.0f, 129.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[54] != 0) {
            c.clipRect(169.0f, 25.0f, 266.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[44] != 0) {
            c.clipRect(586.0f, 48.0f, 690.0f, 136.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(748.0f, 94.0f, 800.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[48] != 0) {
            c.clipRect(725.0f, 114.0f, 765.0f, 147.0f, Region.Op.UNION);
        }
        int value = this.DATA[50];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(307.0f, 72.0f, (value * 18) + 307, 123.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[46];
        if (temp == -2) {
            c.drawText("LOW", 64.0f, 142.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 64.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp).toString(), 64.0f, 142.0f, this.mPaint);
        }
        int temp2 = this.DATA[52];
        if (temp2 == -2) {
            c.drawText("LOW", 926.0f, 142.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 926.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2).toString(), 926.0f, 142.0f, this.mPaint);
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
