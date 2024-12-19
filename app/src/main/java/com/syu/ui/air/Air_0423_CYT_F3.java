package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0423_CYT_F3 extends AirBase {
    public Air_0423_CYT_F3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0422_rzc_fumeilai/cyt_bydf3.webp";
        this.mPathHighlight = "0422_rzc_fumeilai/cyt_bydf3_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[33] != 0) {
            c.clipRect(8.0f, 92.0f, 144.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(200.0f, 106.0f, 283.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(356.0f, 19.0f, 449.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(368.0f, 88.0f, 430.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(363.0f, 110.0f, 404.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(176.0f, 28.0f, 306.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[21] == 0) {
            c.clipRect(686.0f, 93.0f, 859.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(537.0f, 13.0f, 638.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(536.0f, 95.0f, 641.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(891.0f, 96.0f, 1011.0f, 154.0f, Region.Op.UNION);
        }
        int value = this.DATA[28];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(711.0f, 19.0f, (value * 20) + 711, 82.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = this.DATA[29];
        switch (value2) {
            case -3:
                c.drawText("HIGH", 59.0f, 49.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 59.0f, 49.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NONE", 59.0f, 49.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value2 / 10.0f)), 59.0f, 49.0f, this.mPaint);
                break;
        }
        int value3 = this.DATA[30];
        switch (value3) {
            case -3:
                c.drawText("HIGH", 930.0f, 49.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 930.0f, 49.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NONE", 930.0f, 49.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value3 / 10.0f)), 930.0f, 49.0f, this.mPaint);
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
