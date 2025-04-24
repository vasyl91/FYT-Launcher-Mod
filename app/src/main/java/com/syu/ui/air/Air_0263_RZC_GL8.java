package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0263_RZC_GL8 extends AirBase {
    public Air_0263_RZC_GL8(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0263_rzc_plb_saiou3/air_rzc_gl8.webp";
        this.mPathHighlight = "0263_rzc_plb_saiou3/air_rzc_gl8_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String str;
        String str2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        this.mPaint.setTextSize(30.0f);
        if (this.DATA[107] != 0) {
            c.clipRect(351.0f, 24.0f, 505.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[296] != 0) {
            c.clipRect(397.0f, 169.0f, 461.0f, 196.0f, Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(702.0f, 124.0f, 835.0f, 181.0f, Region.Op.UNION);
        }
        if (this.DATA[110] != 0) {
            c.clipRect(562.0f, 179.0f, 623.0f, 196.0f, Region.Op.UNION);
        }
        if (this.DATA[111] != 0) {
            c.clipRect(560.0f, 102.0f, 607.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(563.0f, 137.0f, 601.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(559.0f, 152.0f, 589.0f, 178.0f, Region.Op.UNION);
        }
        if (this.DATA[92] != 0) {
            c.clipRect(547.0f, 20.0f, 656.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(196.0f, 123.0f, 311.0f, 181.0f, Region.Op.UNION);
        }
        if (this.DATA[108] != 0) {
            c.clipRect(691.0f, 102.0f, 744.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(900.0f, 120.0f, 980.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[295] != 0) {
            c.clipRect(905.0f, 158.0f, 977.0f, 187.0f, Region.Op.UNION);
        }
        int value = this.DATA[95];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(84.0f, 62.0f, (value * 20) + 84, 83.0f, Region.Op.UNION);
        int value2 = this.DATA[96];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(887.0f, 62.0f, (value2 * 20) + 887, 83.0f, Region.Op.UNION);
        int value3 = this.DATA[294];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 == 15) {
            c.clipRect(935.0f, 239.0f, 1014.0f, 271.0f, Region.Op.UNION);
        } else if (value3 > 6) {
            value3 = 6;
        }
        c.clipRect(801.0f, 222.0f, (value3 * 20) + 801, 284.0f, Region.Op.UNION);
        if (this.DATA[288] != 0) {
            c.clipRect(559.0f, 200.0f, 644.0f, 231.0f, Region.Op.UNION);
        }
        if (this.DATA[289] != 0) {
            c.clipRect(578.0f, 238.0f, 628.0f, 257.0f, Region.Op.UNION);
        }
        if (this.DATA[290] != 0) {
            c.clipRect(567.0f, 256.0f, 608.0f, 288.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        c.drawText(String.valueOf(ToolkitMath.clamp(this.DATA[102], 0, 15)), 453.0f, 138.0f, this.mPaint);
        int value4 = ToolkitMath.clamp(this.DATA[97], 0, 310);
        if (value4 != 0) {
            if (value4 == 30) {
                str = "HI";
            } else {
                str = String.valueOf(value4 * 0.1f);
            }
        } else {
            str = "LOW";
        }
        c.drawText(str, 248.0f, 65.0f, this.mPaint);
        int value5 = ToolkitMath.clamp(this.DATA[98], 0, 310);
        if (value5 != 0) {
            if (value5 == 30) {
                str2 = "HI";
            } else {
                str2 = String.valueOf(value5 * 0.1f);
            }
        } else {
            str2 = "LOW";
        }
        c.drawText(str2, 754.0f, 65.0f, this.mPaint);
        int value6 = ToolkitMath.clamp(this.DATA[287], 0, 310);
        String str3 = "-- --";
        if (value6 != 0) {
            if (value6 != 129) {
                if (value6 >= 1 && value6 <= 128) {
                    str3 = String.valueOf(value6 * 0.5f);
                }
            } else {
                str3 = "HI";
            }
        } else {
            str3 = "LOW";
        }
        c.drawText(str3, 319.0f, 251.0f, this.mPaint);
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
