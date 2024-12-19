package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0439_RZC_Siwei extends AirBase {
    public Air_0439_RZC_Siwei(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_rzc_siwei/air_rzc_wiwei.webp";
        this.mPathHighlight = "0439_rzc_siwei/air_rzc_wiwei_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[14] != 0) {
            c.clipRect(893.0f, 105.0f, 1018.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(771.0f, 29.0f, 872.0f, 59.0f, Region.Op.UNION);
        }
        if (this.DATA[16] == 0) {
            c.clipRect(763.0f, 97.0f, 880.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(169.0f, 14.0f, 256.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(638.0f, 18.0f, 712.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(650.0f, 88.0f, 702.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(633.0f, 108.0f, 677.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(302.0f, 15.0f, 390.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(297.0f, 90.0f, 382.0f, 152.0f, Region.Op.UNION);
        }
        int value = this.DATA[22];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(463.0f, 47.0f, 463.0f + (value * 18.0f), 118.0f, Region.Op.UNION);
        int value2 = this.DATA[20];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(58.0f, 131.0f, 58.0f + (value2 * 22.0f), 155.0f, Region.Op.UNION);
        int value3 = this.DATA[21];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(203.0f, 129.0f, 203.0f + (value3 * 22.0f), 152.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[8];
        if (temp == -1) {
            c.drawText("NO", 55.0f, 54.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 55.0f, 54.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 55.0f, 54.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 11338180 || DataCanbus.DATA[1000] == 5964229) {
            if (temp >= 36 && temp <= 50) {
                c.drawText(new StringBuilder().append(((temp - 36) + 18) / 1.0f).toString(), 55.0f, 54.0f, this.mPaint);
            } else {
                c.drawText("NO", 55.0f, 54.0f, this.mPaint);
            }
        } else if (temp >= 30 && temp <= 70) {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 55.0f, 54.0f, this.mPaint);
        } else {
            c.drawText("NO", 55.0f, 54.0f, this.mPaint);
        }
        int temp2 = this.DATA[9];
        if (temp2 == -1) {
            c.drawText("NO", 941.0f, 54.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 941.0f, 54.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 941.0f, 54.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 11338180 || DataCanbus.DATA[1000] == 5964229) {
            if (temp2 >= 36 && temp2 <= 50) {
                c.drawText(new StringBuilder().append(((temp2 - 36) + 18) / 1.0f).toString(), 941.0f, 54.0f, this.mPaint);
            } else {
                c.drawText("NO", 941.0f, 54.0f, this.mPaint);
            }
        } else if (temp2 >= 30 && temp2 <= 70) {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 941.0f, 54.0f, this.mPaint);
        } else {
            c.drawText("NO", 941.0f, 54.0f, this.mPaint);
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
