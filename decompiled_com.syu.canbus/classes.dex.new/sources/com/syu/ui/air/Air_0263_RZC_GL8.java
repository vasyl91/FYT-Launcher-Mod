package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0263_RZC_GL8 extends AirBase {
    public Air_0263_RZC_GL8(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0263_rzc_plb_saiou3/air_rzc_gl8.webp";
        this.mPathHighlight = "0263_rzc_plb_saiou3/air_rzc_gl8_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        String str2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        this.mPaint.setTextSize(30.0f);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(351.0f, 24.0f, 505.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[74] != 0) {
            this.srPath.addRect(397.0f, 169.0f, 461.0f, 196.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(702.0f, 124.0f, 835.0f, 181.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(562.0f, 179.0f, 623.0f, 196.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(560.0f, 102.0f, 607.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(563.0f, 137.0f, 601.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(559.0f, 152.0f, 589.0f, 178.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(547.0f, 20.0f, 656.0f, 92.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(196.0f, 123.0f, 311.0f, 181.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(691.0f, 102.0f, 744.0f, 123.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(900.0f, 120.0f, 980.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[80] != 0) {
            this.srPath.addRect(905.0f, 158.0f, 977.0f, 187.0f, Path.Direction.CW);
        }
        int value = this.DATA[29];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        this.srPath.addRect(84.0f, 62.0f, (value * 20) + 84, 83.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(887.0f, 62.0f, (value2 * 20) + 887, 83.0f, Path.Direction.CW);
        int value3 = this.DATA[44];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 == 15) {
            this.srPath.addRect(935.0f, 239.0f, 1014.0f, 271.0f, Path.Direction.CW);
        } else if (value3 > 6) {
            value3 = 6;
        }
        this.srPath.addRect(801.0f, 222.0f, (value3 * 20) + 801, 284.0f, Path.Direction.CW);
        if (this.DATA[43] != 0) {
            this.srPath.addRect(559.0f, 200.0f, 644.0f, 231.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(578.0f, 238.0f, 628.0f, 257.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(567.0f, 256.0f, 608.0f, 288.0f, Path.Direction.CW);
        }
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
        c.drawText(new StringBuilder().append(ToolkitMath.clamp(this.DATA[21], 0, 15)).toString(), 453.0f, 138.0f, this.mPaint);
        int value4 = ToolkitMath.clamp(this.DATA[27], 0, 310);
        if (value4 != 0) {
            if (value4 == 30) {
                str = "HI";
            } else {
                str = new StringBuilder(String.valueOf(value4 * 0.1f)).toString();
            }
        } else {
            str = "LOW";
        }
        c.drawText(str, 248.0f, 65.0f, this.mPaint);
        int value5 = ToolkitMath.clamp(this.DATA[28], 0, 310);
        if (value5 != 0) {
            if (value5 == 30) {
                str2 = "HI";
            } else {
                str2 = new StringBuilder(String.valueOf(value5 * 0.1f)).toString();
            }
        } else {
            str2 = "LOW";
        }
        c.drawText(str2, 754.0f, 65.0f, this.mPaint);
        int value6 = ToolkitMath.clamp(this.DATA[40], 0, 310);
        String str3 = "-- --";
        if (value6 != 0) {
            if (value6 != 129) {
                if (value6 >= 1 && value6 <= 128) {
                    str3 = new StringBuilder().append(value6 * 0.5f).toString();
                }
            } else {
                str3 = "HI";
            }
        } else {
            str3 = "LOW";
        }
        c.drawText(str3, 319.0f, 251.0f, this.mPaint);
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
