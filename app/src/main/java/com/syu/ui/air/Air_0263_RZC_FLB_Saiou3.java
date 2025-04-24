package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0263_RZC_FLB_Saiou3 extends AirBase {
    private int nWindLevelLeft;

    public Air_0263_RZC_FLB_Saiou3(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0263_rzc_plb_saiou3/rzc_flb_saiou.webp";
        this.mPathHighlight = "0263_rzc_plb_saiou3/rzc_flb_saiou_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        boolean invalidate = false;
        c.clipRect(this.mRectEmpty);
        if (this.DATA[107] != 0) {
            c.clipRect(178.0f, 55.0f, 321.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(710.0f, 64.0f, 861.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[110] != 0) {
            c.clipRect(379.0f, 131.0f, 452.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[111] != 0) {
            c.clipRect(364.0f, 16.0f, 454.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[108] != 0) {
            c.clipRect(680.0f, 31.0f, 734.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(899.0f, 60.0f, 1002.0f, 132.0f, Region.Op.UNION);
        }
        if (this.DATA[99] != 0) {
            c.clipRect(369.0f, 66.0f, 417.0f, 88.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(382.0f, 88.0f, 430.0f, 101.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(377.0f, 99.0f, 419.0f, 124.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[102], 0, 6);
        if (this.nWindLevelLeft != value) {
            invalidate = true;
            if (this.nWindLevelLeft < value) {
                this.nWindLevelLeft++;
            } else {
                this.nWindLevelLeft--;
            }
        }
        this.mRectTmp.set(530, 73, (value * 22) + 530, 134);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = ToolkitMath.clamp(this.DATA[97], 0, 310);
        switch (value2) {
            case 0:
                c.drawText("LOW", 50.0f, 100.0f, this.mPaint);
                break;
            case 30:
                c.drawText("HIGH", 50.0f, 100.0f, this.mPaint);
                break;
            case 255:
                c.drawText("NO", 50.0f, 100.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value2 / 10.0f)), 50.0f, 100.0f, this.mPaint);
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
