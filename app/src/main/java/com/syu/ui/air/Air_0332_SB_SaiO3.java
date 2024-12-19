package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0332_SB_SaiO3 extends AirBase {
    public Air_0332_SB_SaiO3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0332_sb_saio3/air.webp";
        this.mPathHighlight = "0332_sb_saio3/air_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[53] != 0) {
            c.clipRect(13.0f, 25.0f, 165.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(189.0f, 17.0f, 296.0f, 88.0f, Region.Op.UNION);
        }
        if (this.DATA[41] == 0) {
            c.clipRect(466.0f, 15.0f, 591.0f, 57.0f, Region.Op.UNION);
        }
        if (this.DATA[41] == 2) {
            c.clipRect(499.0f, 58.0f, 569.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(338.0f, 11.0f, 435.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[44] != 0) {
            c.clipRect(797.0f, 29.0f, 870.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[54] != 0) {
            c.clipRect(915.0f, 28.0f, 1011.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(184.0f, 100.0f, 303.0f, 154.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[45], 0, 3);
        this.mRectTmp.set(377, 134, (value * 21) + 377, 156);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        int value2 = ToolkitMath.clamp(this.DATA[46], 0, 3);
        this.mRectTmp.set(827, 134, (value2 * 21) + 827, 156);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        if (this.DATA[55] != 0) {
            c.clipRect(654.0f, 23.0f, 753.0f, 61.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(633.0f, 64.0f, 680.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[50] != 0) {
            c.clipRect(661.0f, 94.0f, 705.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[51] != 0) {
            c.clipRect(636.0f, 112.0f, 673.0f, 147.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value3 = ToolkitMath.clamp(this.DATA[47], 0, 255);
        switch (value3) {
            case 0:
                c.drawText("NO", 66.0f, 152.0f, this.mPaint);
                break;
            case 1:
                c.drawText("LOW", 66.0f, 152.0f, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", 66.0f, 152.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value3 / 10.0f)), 66.0f, 152.0f, this.mPaint);
                break;
        }
        int value4 = ToolkitMath.clamp(this.DATA[48], 0, 255);
        switch (value4) {
            case 0:
                c.drawText("NO", 930.0f, 152.0f, this.mPaint);
                break;
            case 1:
                c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", 930.0f, 152.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value4 / 10.0f)), 930.0f, 152.0f, this.mPaint);
                break;
        }
        int value5 = this.DATA[52];
        if (value5 >= 0 && value5 <= 8) {
            c.drawText(new StringBuilder().append(value5).toString(), 545.0f, 142.0f, this.mPaint);
        } else if (value5 == -1) {
            c.drawText("AUTO", 545.0f, 142.0f, this.mPaint);
        } else {
            c.drawText("", 545.0f, 142.0f, this.mPaint);
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
