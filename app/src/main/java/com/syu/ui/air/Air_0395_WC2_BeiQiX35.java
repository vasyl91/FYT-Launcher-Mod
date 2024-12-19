package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0395_WC2_BeiQiX35 extends AirBase {
    public Air_0395_WC2_BeiQiX35(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_beiqi_x5.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_beiqi_x5_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (DataCanbus.DATA[1000] != 2228619) {
            c.clipRect(122.0f, 41.0f, 160.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(17.0f, 109.0f, 161.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(381.0f, 18.0f, 460.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(388.0f, 138.0f, 472.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(393.0f, 79.0f, 442.0f, 100.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(377.0f, 96.0f, 421.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(911.0f, 105.0f, 992.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(888.0f, 11.0f, 988.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(203.0f, 45.0f, 322.0f, 134.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(702.0f, 51.0f, 842.0f, 143.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(529.0f, 49.0f, (value * 18) + 529, 134.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 72.0f, 57.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 72.0f, 57.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 2228619) {
            c.drawText(new StringBuilder().append(left_temp).toString(), 80.0f, 62.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((left_temp * 5) / 10.0f).toString(), 72.0f, 62.0f, this.mPaint);
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
