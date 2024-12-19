package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0203_Oudi_08AodeSai extends AirBase {
    public Air_0203_Oudi_08AodeSai(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0203_Oudi_08Aodesai/oudi_08aodesai.webp";
        this.mPathHighlight = "0203_Oudi_08Aodesai/oudi_08aodesai_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        String str2;
        Canvas c = this.mContentCanvas;
        c.save(2);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[32] != 0) {
            c.clipRect(872.0f, 95.0f, 992.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(23.0f, 105.0f, 147.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[30] == 0) {
            c.clipRect(692.0f, 94.0f, 839.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(191.0f, 93.0f, 322.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(181.0f, 18.0f, 328.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(724.0f, 12.0f, 823.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(539.0f, 9.0f, 657.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(376.0f, 29.0f, 450.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(388.0f, 87.0f, 435.0f, 105.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(378.0f, 105.0f, 416.0f, 139.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(973.0f, 30.0f, 1020.0f, 84.0f, Region.Op.UNION);
            c.clipRect(117.0f, 30.0f, 164.0f, 84.0f, Region.Op.UNION);
        }
        this.mRectTmp.set(539, 100, (ToolkitMath.clamp(this.DATA[35], 0, 7) * 19) + 539, 160);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = ToolkitMath.clamp(this.DATA[41], 0, 255);
        switch (value) {
            case -3:
                str = "HIGH";
                break;
            case -2:
                str = "LOW";
                break;
            case -1:
                str = "NONE";
                break;
            default:
                str = new StringBuilder(String.valueOf(value * 0.1f)).toString();
                break;
        }
        c.drawText(str, 66.0f, 48.0f, this.mPaint);
        int value2 = ToolkitMath.clamp(this.DATA[42], 0, 255);
        switch (value2) {
            case -3:
                str2 = "HIGH";
                break;
            case -2:
                str2 = "LOW";
                break;
            case -1:
                str2 = "NONE";
                break;
            default:
                str2 = new StringBuilder(String.valueOf(value2 * 0.1f)).toString();
                break;
        }
        c.drawText(str2, 919.0f, 48.0f, this.mPaint);
        c.restore();
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
