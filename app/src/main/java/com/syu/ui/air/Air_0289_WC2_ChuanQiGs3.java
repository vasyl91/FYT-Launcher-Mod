package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0289_WC2_ChuanQiGs3 extends AirBase {
    public Air_0289_WC2_ChuanQiGs3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0289_wc2_ChuanQiGs3/air_289_wc_gs3_n.webp";
        this.mPathHighlight = "0289_wc2_ChuanQiGs3/air_289_wc_gs3_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[26] != 0) {
            c.clipRect(595.0f, 106.0f, 724.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(620.0f, 27.0f, 693.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(184.0f, 93.0f, 262.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(150.0f, 24.0f, 291.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(318.0f, 14.0f, 414.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(318.0f, 88.0f, 418.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(479.0f, 134.0f, 547.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(464.0f, 8.0f, 534.0f, 61.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(464.0f, 66.0f, 530.0f, 90.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(462.0f, 92.0f, 502.0f, 130.0f, Region.Op.UNION);
        }
        if (this.DATA[27] == 0) {
            c.clipRect(735.0f, 13.0f, 873.0f, 82.0f, Region.Op.UNION);
        }
        c.clipRect(754.0f, 119.0f, (this.DATA[35] * 15) + 754, 163.0f, Region.Op.UNION);
        int value = this.DATA[36];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(66.0f, 127.0f, (value * 20) + 66, 157.0f, Region.Op.UNION);
        int value2 = this.DATA[37];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(898.0f, 127.0f, (value2 * 20) + 898, 157.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[31];
        if (left_temp == -2) {
            c.drawText("LOW", 55.0f, 51.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 55.0f, 51.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 10.0f).toString(), 55.0f, 51.0f, this.mPaint);
        }
        int right_temp = this.DATA[38];
        if (right_temp == -2) {
            c.drawText("LOW", 942.0f, 51.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 942.0f, 51.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp / 10.0f).toString(), 942.0f, 51.0f, this.mPaint);
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
