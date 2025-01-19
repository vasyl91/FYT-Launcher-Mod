package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

public class Air_0359_XP1_16mairuibao_low extends AirBase {
    private int nWindLevelLeft;

    public Air_0359_XP1_16mairuibao_low(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0359_xp_mairuibao16/xp_16mairuibao_low.webp";
        this.mPathHighlight = "0359_xp_mairuibao16/xp_16mairuibao_p_low.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        boolean invalidate = false;
        c.clipRect(this.mRectEmpty);
        if (this.DATA[107] != 0) {
            c.clipRect(152.0f, 47.0f, 289.0f, 117.0f, Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(598.0f, 69.0f, 727.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[110] != 0) {
            c.clipRect(473.0f, 129.0f, 551.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[111] != 0) {
            c.clipRect(472.0f, 18.0f, 547.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[112] != 0) {
            c.clipRect(13.0f, 101.0f, 134.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[92] != 0) {
            c.clipRect(305.0f, 31.0f, 424.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[108] != 0) {
            c.clipRect(591.0f, 40.0f, 642.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(917.0f, 96.0f, 990.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[99] != 0) {
            c.clipRect(477.0f, 64.0f, 521.0f, 88.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(484.0f, 88.0f, 526.0f, 101.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(469.0f, 101.0f, 510.0f, 127.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[102], 0, 8);
        if (this.nWindLevelLeft != value) {
            invalidate = true;
            if (this.nWindLevelLeft < value) {
                this.nWindLevelLeft++;
            } else {
                this.nWindLevelLeft--;
            }
        }
        this.mRectTmp.set(757, 60, (value * 14) + 757, 129);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = ToolkitMath.clamp(this.DATA[97], 0, 310);
        switch (value2) {
            case 0:
                c.drawText("LOW", 64.0f, 62.0f, this.mPaint);
                break;
            case 30:
                c.drawText("HIGH", 64.0f, 62.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value2 / 10.0f)), 64.0f, 62.0f, this.mPaint);
                break;
        }
        int value3 = ToolkitMath.clamp(this.DATA[98], 0, 310);
        switch (value3) {
            case 0:
                c.drawText("LOW", 926.0f, 62.0f, this.mPaint);
                break;
            case 30:
                c.drawText("HIGH", 926.0f, 62.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value3 / 10.0f)), 926.0f, 62.0f, this.mPaint);
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
        if (invalidate) {
            invalidate();
        }
    }
}
