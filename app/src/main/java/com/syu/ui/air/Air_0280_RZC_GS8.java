package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0280_RZC_GS8 extends AirBase {
    public Air_0280_RZC_GS8(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        if (DataCanbus.DATA[1000] == 459032) {
            this.mPathNormal = "0280_rzc_xp1_chuangqigs4/rzc_gs3_air.webp";
            this.mPathHighlight = "0280_rzc_xp1_chuangqigs4/rzc_gs3_air_p.webp";
        } else {
            this.mPathNormal = "0280_rzc_xp1_chuangqigs4/rzc_gs8_air.webp";
            this.mPathHighlight = "0280_rzc_xp1_chuangqigs4/rzc_gs8_air_p.webp";
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[2] != 0) {
            c.clipRect(304.0f, 32.0f, 434.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(603.0f, 30.0f, 713.0f, 87.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(743.0f, 26.0f, 874.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(743.0f, 26.0f, 874.0f, 83.0f, Region.Op.UNION);
        }
        if (DataCanbus.DATA[1000] == 459032) {
            if (this.DATA[73] != 0) {
                c.clipRect(452.0f, 31.0f, 572.0f, 85.0f, Region.Op.UNION);
            }
        } else if (this.DATA[32] != 0) {
            c.clipRect(452.0f, 31.0f, 572.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(650.0f, 249.0f, 699.0f, 288.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(667.0f, 225.0f, 726.0f, 255.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(453.0f, 224.0f, 566.0f, 271.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(192.0f, 110.0f, 325.0f, 193.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(364.0f, 108.0f, 504.0f, 194.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(725.0f, 104.0f, 777.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(730.0f, 145.0f, 778.0f, 167.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(722.0f, 165.0f, 761.0f, 196.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(866.0f, 110.0f, 1013.0f, 186.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[7];
        if (left_temp == -2) {
            c.drawText("LOW", 60.0f, 66.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 60.0f, 66.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 100.0f).toString(), 60.0f, 66.0f, this.mPaint);
        }
        int right_temp = this.DATA[15];
        if (right_temp == -2) {
            c.drawText("LOW", 936.0f, 66.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 936.0f, 66.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp / 100.0f).toString(), 936.0f, 66.0f, this.mPaint);
        }
        int rear_temp = this.DATA[37];
        if (rear_temp == -2) {
            c.drawText("LOW", 291.0f, 256.0f, this.mPaint);
        } else if (rear_temp == -3) {
            c.drawText("HI", 291.0f, 256.0f, this.mPaint);
        } else if (rear_temp == -1) {
            c.drawText("NO", 291.0f, 256.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(rear_temp / 100.0f).toString(), 291.0f, 256.0f, this.mPaint);
        }
        int wind = this.DATA[12];
        c.drawText(new StringBuilder(String.valueOf(wind)).toString(), 608.0f, 156.0f, this.mPaint);
        int rearwind = this.DATA[36];
        c.drawText(new StringBuilder(String.valueOf(rearwind)).toString(), 924.0f, 256.0f, this.mPaint);
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
