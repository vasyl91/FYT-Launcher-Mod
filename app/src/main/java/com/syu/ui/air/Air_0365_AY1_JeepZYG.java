package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

public class Air_0365_AY1_JeepZYG extends AirBase {
    private int nWindLevelLeft;

    public Air_0365_AY1_JeepZYG(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0365_ay_jeepzyg/ay_jeepzyg_n.webp";
        this.mPathHighlight = "0365_ay_jeepzyg/ay_jeepzyg_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        boolean invalidate = false;
        c.clipRect(this.mRectEmpty);
        if (this.DATA[38] != 0) {
            c.clipRect(451.0f, 14.0f, 572.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(163.0f, 104.0f, 277.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(309.0f, 104.0f, 423.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(739.0f, 13.0f, 869.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(314.0f, 9.0f, 409.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(182.0f, 27.0f, 256.0f, 70.0f, Region.Op.UNION);
        }
        int front = 0;
        int foot = 0;
        int body = this.DATA[47] != 0 ? 1 : 0;
        if (this.DATA[48] != 0) {
            body = 1;
            foot = 1;
        }
        if (this.DATA[49] != 0) {
            foot = 1;
        }
        if (this.DATA[50] != 0) {
            front = 0;
            foot = 1;
        }
        if (this.DATA[51] != 0) {
            front = 1;
        }
        int rear = this.DATA[52] != 0 ? 1 : 0;
        if (front == 1) {
            c.clipRect(614.0f, 13.0f, 713.0f, 80.0f, Region.Op.UNION);
        }
        if (rear == 1) {
            c.clipRect(614.0f, 96.0f, 713.0f, 163.0f, Region.Op.UNION);
        }
        if (body == 1) {
            c.clipRect(471.0f, 106.0f, 520.0f, 125.0f, Region.Op.UNION);
        }
        if (foot == 1) {
            c.clipRect(465.0f, 128.0f, 502.0f, 162.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[53], 0, 8);
        if (this.nWindLevelLeft != value) {
            invalidate = true;
            if (this.nWindLevelLeft < value) {
                this.nWindLevelLeft++;
            } else {
                this.nWindLevelLeft--;
            }
        }
        this.mRectTmp.set(763, 118, (value * 14) + 763, 163);
        if (value == 8) {
            c.clipRect(781.0f, 90.0f, 833.0f, 109.0f, Region.Op.UNION);
        } else {
            c.clipRect(this.mRectTmp, Region.Op.UNION);
        }
        int value2 = this.DATA[54];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(67.0f, 50.0f, (value2 * 21) + 67, 74.0f, Region.Op.UNION);
        int value3 = this.DATA[55];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(903.0f, 50.0f, (value3 * 21) + 903, 74.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(40.0f);
        int value4 = this.DATA[44];
        switch (value4) {
            case 0:
                c.drawText("NO", 50.0f, 145.0f, this.mPaint);
                break;
            case 1:
                c.drawText("LOW", 50.0f, 145.0f, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", 50.0f, 145.0f, this.mPaint);
                break;
            default:
                if (value4 >= 14 && value4 <= 30) {
                    c.drawText(String.format("%d", Integer.valueOf(value4)), 50.0f, 145.0f, this.mPaint);
                    break;
                } else {
                    c.drawText("NO", 50.0f, 145.0f, this.mPaint);
                    break;
                }
        }
        int value5 = this.DATA[45];
        switch (value5) {
            case 0:
                c.drawText("NO", 935.0f, 145.0f, this.mPaint);
                break;
            case 1:
                c.drawText("LOW", 935.0f, 145.0f, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", 935.0f, 145.0f, this.mPaint);
                break;
            default:
                if (value5 >= 14 && value5 <= 30) {
                    c.drawText(String.format("%d", Integer.valueOf(value5)), 935.0f, 145.0f, this.mPaint);
                    break;
                } else {
                    c.drawText("NO", 935.0f, 145.0f, this.mPaint);
                    break;
                }
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
