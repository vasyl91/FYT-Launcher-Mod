package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0318_XP1_15WeiLang extends AirBase {
    private int nWindLevelLeft;

    public Air_0318_XP1_15WeiLang(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0253_xp1_yinglang/air.webp";
        this.mPathHighlight = "0253_xp1_yinglang/air_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        boolean invalidate = false;
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(168.0f, 24.0f, 306.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(722.0f, 108.0f, 852.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(358.0f, 131.0f, 430.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(356.0f, 20.0f, 418.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(512.0f, 10.0f, 613.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(704.0f, 21.0f, 824.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(693.0f, 89.0f, 739.0f, 109.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(198.0f, 106.0f, 264.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(359.0f, 63.0f, 395.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(373.0f, 85.0f, 415.0f, 100.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(352.0f, 101.0f, 388.0f, 125.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[21], 0, 8);
        if (this.nWindLevelLeft != value) {
            invalidate = true;
            if (this.nWindLevelLeft < value) {
                this.nWindLevelLeft++;
            } else {
                this.nWindLevelLeft--;
            }
        }
        this.mRectTmp.set(510.0f, 95.0f, (value * 19) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D4_B70, 157.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(83.0f, 134.0f, (value2 * 21) + 83, 151.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(897.0f, 137.0f, (value3 * 21) + 897, 155.0f, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value4 = ToolkitMath.clamp(this.DATA[27], 0, 310);
        switch (value4) {
            case 0:
                c.drawText("LOW", 64.0f, 62.0f, this.mPaint);
                break;
            case 30:
                c.drawText("HIGH", 64.0f, 62.0f, this.mPaint);
                break;
            case 255:
                c.drawText("NO", 64.0f, 62.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value4 / 10.0f)), 64.0f, 62.0f, this.mPaint);
                break;
        }
        int value5 = ToolkitMath.clamp(this.DATA[28], 0, 310);
        switch (value5) {
            case 0:
                c.drawText("LOW", 926.0f, 62.0f, this.mPaint);
                break;
            case 30:
                c.drawText("HIGH", 926.0f, 62.0f, this.mPaint);
                break;
            case 255:
                c.drawText("NO", 926.0f, 62.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value5 / 10.0f)), 926.0f, 62.0f, this.mPaint);
                break;
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (invalidate) {
            invalidate();
        }
    }
}
