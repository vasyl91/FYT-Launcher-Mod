package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0359_XP1_16mairuibao extends AirBase {
    private int nWindLevelLeft;

    public Air_0359_XP1_16mairuibao(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0359_xp_mairuibao16/xp_16mairuibao.webp";
        this.mPathHighlight = "0359_xp_mairuibao16/xp_16mairuibao_p.webp";
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
            this.srPath.addRect(156.0f, 13.0f, 288.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(598.0f, 69.0f, 727.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(473.0f, 129.0f, 551.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(472.0f, 18.0f, 547.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(312.0f, 96.0f, 429.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(312.0f, 12.0f, 414.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(760.0f, 28.0f, 859.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(591.0f, 40.0f, 642.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(168.0f, 96.0f, 269.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(477.0f, 64.0f, 521.0f, 88.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(484.0f, 88.0f, 526.0f, 101.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(469.0f, 101.0f, 510.0f, 127.0f, Path.Direction.CW);
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
        this.mRectTmp.set(755.0f, 108.0f, (value * 14) + 755, 164.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(70.0f, 124.0f, (value2 * 21) + 70, 157.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(908.0f, 123.0f, (value3 * 21) + 908, 162.0f, Path.Direction.CW);
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
