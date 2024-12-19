package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AIR_0265_RZC_ZhongTaiDaMaiX5 extends AirBase {
    public AIR_0265_RZC_ZhongTaiDaMaiX5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/air_rzc_zhongtai_damaix5.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/air_rzc_zhongtai_damaix5_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[32] != 0) {
            c.clipRect(892.0f, 98.0f, 1001.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(17.0f, 100.0f, 151.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(724.0f, 13.0f, 813.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(195.0f, 33.0f, 313.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(360.0f, 37.0f, 423.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(371.0f, 74.0f, 443.0f, 93.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(358.0f, 93.0f, 411.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 1) {
            c.clipRect(699.0f, 94.0f, 838.0f, 154.0f, Region.Op.UNION);
        }
        int value = this.DATA[37];
        c.clipRect(549.0f, 49.0f, (value * 18) + 549, 124.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[42];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else if (DataCanbus.DATA[38] == 0) {
            c.drawText(new StringBuilder().append(left_temp).toString(), 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp + 17) + "   ℃", 76.0f, 72.0f, this.mPaint);
        }
        int right_temp = this.DATA[39];
        if (DataCanbus.DATA[1000] == 65801) {
            right_temp = this.DATA[42];
        }
        if (right_temp == -2) {
            c.drawText("LOW", 940.0f, 72.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 940.0f, 72.0f, this.mPaint);
        } else if (DataCanbus.DATA[43] == 0) {
            c.drawText(new StringBuilder().append(right_temp).toString(), 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp + 17) + "   ℃", 940.0f, 72.0f, this.mPaint);
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
