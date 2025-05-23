package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0361_RZC_XP1_MaiRuiBao16 extends AirBase {
    private int nWindLevelLeft;

    public Air_0361_RZC_XP1_MaiRuiBao16(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0359_xp_mairuibao16/xp_16mairuibao.webp";
        this.mPathHighlight = "0359_xp_mairuibao16/xp_16mairuibao_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        boolean invalidate = false;
        c.clipRect(this.mRectEmpty);
        if (this.DATA[107] != 0) {
            c.clipRect(156.0f, 13.0f, 288.0f, 80.0f, Region.Op.UNION);
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
            c.clipRect(312.0f, 96.0f, 429.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[92] != 0) {
            c.clipRect(312.0f, 12.0f, 414.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[109] != 0) {
            c.clipRect(760.0f, 28.0f, 859.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[108] != 0) {
            c.clipRect(591.0f, 40.0f, 642.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(168.0f, 96.0f, 269.0f, 157.0f, Region.Op.UNION);
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
        this.mRectTmp.set(755, 108, (value * 14) + 755, 164);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        int value2 = this.DATA[95];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(70.0f, 124.0f, (value2 * 21) + 70, 157.0f, Region.Op.UNION);
        int value3 = this.DATA[96];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(908.0f, 123.0f, (value3 * 21) + 908, 162.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value4 = ToolkitMath.clamp(this.DATA[97], 0, 310);
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
        int value5 = ToolkitMath.clamp(this.DATA[98], 0, 310);
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
