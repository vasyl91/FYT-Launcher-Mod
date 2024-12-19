package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0230_WC1_BMW_X1 extends AirBase {
    public Air_0230_WC1_BMW_X1(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0001_wc1_dazhong/air_wc_bmw.webp";
        this.mPathHighlight = "0001_wc1_dazhong/air_wc_bmw_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[26] != 0) {
            c.clipRect(161.0f, 23.0f, 260.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(437.0f, 19.0f, 526.0f, 66.0f, Region.Op.UNION);
            c.clipRect(525.0f, 30.0f, 554.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(437.0f, 19.0f, 526.0f, 66.0f, Region.Op.UNION);
            c.clipRect(554.0f, 22.0f, 589.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[24] == 0) {
            c.clipRect(460.0f, 93.0f, 543.0f, 131.0f, Region.Op.UNION);
        } else if (this.DATA[24] == 3) {
            c.clipRect(548.0f, 90.0f, 595.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(311.0f, 17.0f, 382.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(641.0f, 16.0f, 716.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(818.0f, 26.0f, 873.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(754.0f, 23.0f, 874.0f, 73.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[19], 0, 3);
        if (value == 1) {
            c.clipRect(55.0f, 129.0f, 78.0f, 152.0f, Region.Op.UNION);
        } else if (value == 2) {
            c.clipRect(57.0f, 130.0f, 102.0f, 152.0f, Region.Op.UNION);
        } else if (value == 3) {
            c.clipRect(57.0f, 122.0f, 125.0f, 155.0f, Region.Op.UNION);
        }
        int value2 = ToolkitMath.clamp(this.DATA[20], 0, 3);
        if (value2 == 1) {
            c.clipRect(941.0f, 126.0f, 965.0f, 154.0f, Region.Op.UNION);
        } else if (value2 == 2) {
            c.clipRect(941.0f, 126.0f, 986.0f, 154.0f, Region.Op.UNION);
        } else if (value2 == 3) {
            c.clipRect(941.0f, 126.0f, 1009.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(166.0f, 92.0f, 208.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(178.0f, 112.0f, 217.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(170.0f, 125.0f, 201.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(821.0f, 91.0f, 852.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(811.0f, 113.0f, 844.0f, 128.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(822.0f, 126.0f, 854.0f, 144.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(18.0f);
        if (this.DATA[27] == 1) {
            c.drawText("Rear", 440.0f, 110.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        c.drawText(new StringBuilder(String.valueOf(this.DATA[36])).toString(), 358.0f, 139.0f, this.mPaint);
        c.drawText(new StringBuilder(String.valueOf(this.DATA[42])).toString(), 692.0f, 139.0f, this.mPaint);
        switch (this.DATA[31]) {
            case -3:
                c.drawText("HI", 51.0f, 67.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 51.0f, 67.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 51.0f, 67.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf((100 - 80) * 0.5f)), 51.0f, 67.0f, this.mPaint);
                break;
        }
        switch (this.DATA[32]) {
            case -3:
                c.drawText("HI", 940.0f, 67.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 940.0f, 67.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 940.0f, 67.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf((100 - 80) * 0.5f)), 945.0f, 67.0f, this.mPaint);
                break;
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
