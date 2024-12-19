package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0439_Bnr_RongweiRx5 extends AirBase {
    public Air_0439_Bnr_RongweiRx5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0273_rzc_mingjueruiteng/air_rzc_xp1mingjueruiteng_n.webp";
        this.mPathHighlight = "0273_rzc_mingjueruiteng/air_rzc_xp1mingjueruiteng_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(20.0f, 26.0f, 163.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(899.0f, 16.0f, 971.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(888.0f, 102.0f, 994.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(713.0f, 12.0f, 807.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(719.0f, 95.0f, 810.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(543.0f, 95.0f, 587.0f, 138.0f, Region.Op.UNION);
            c.clipRect(557.0f, 71.0f, 616.0f, 98.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(543.0f, 95.0f, 587.0f, 138.0f, Region.Op.UNION);
            c.clipRect(539.0f, 9.0f, 620.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(557.0f, 71.0f, 616.0f, 98.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(543.0f, 95.0f, 587.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(193.0f, 47.0f, 325.0f, 124.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        if (value == 15) {
            c.clipRect(406.0f, 123.0f, 473.0f, 146.0f, Region.Op.UNION);
        } else {
            c.clipRect(376.0f, 61.0f, (value * 18) + 376, 115.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[14] & 127;
        int flag = (this.DATA[14] >> 7) & 1;
        if (flag == 0) {
            if (left_temp == 1) {
                c.drawText("LOW", 70.0f, 142.0f, this.mPaint);
            } else if (left_temp == 15) {
                c.drawText("HI", 70.0f, 142.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(left_temp + 15).toString(), 70.0f, 142.0f, this.mPaint);
            }
        } else if (left_temp == 0) {
            c.drawText("LOW", 70.0f, 142.0f, this.mPaint);
        } else if (left_temp == 31) {
            c.drawText("HI", 70.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp + 17).toString(), 70.0f, 142.0f, this.mPaint);
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
