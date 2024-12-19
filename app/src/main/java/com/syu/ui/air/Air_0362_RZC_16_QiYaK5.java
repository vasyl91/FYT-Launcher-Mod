package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0362_RZC_16_QiYaK5 extends AirBase {
    public Air_0362_RZC_16_QiYaK5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0362_rzc_16_qiyaK5/air_qiya_k5.webp";
        this.mPathHighlight = "0362_rzc_16_qiyaK5/air_qiya_k5_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[15] != 0) {
            c.clipRect(219.0f, 104.0f, 313.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(26.0f, 99.0f, 156.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(878.0f, 100.0f, 1005.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(536.0f, 14.0f, 650.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(539.0f, 91.0f, 658.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(380.0f, 56.0f, 451.0f, 88.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(365.0f, 87.0f, 424.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[16] < 62 || this.DATA[16] > 90) {
            c.clipRect(129.0f, 21.0f, 176.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[21] < 62 || this.DATA[21] > 90) {
            c.clipRect(978.0f, 17.0f, 1015.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(189.0f, 12.0f, 335.0f, 78.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        c.clipRect(712.0f, 44.0f, (value * 18) + 712, 116.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[16];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 62.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 62.0f, this.mPaint);
        } else if (left_temp >= 62 && left_temp <= 90) {
            c.drawText(new StringBuilder().append(left_temp).toString(), 76.0f, 62.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (left_temp / 2.0f)).toString(), 76.0f, 62.0f, this.mPaint);
        }
        int right_temp = this.DATA[21];
        if (right_temp == -2) {
            c.drawText("LOW", 940.0f, 62.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 940.0f, 62.0f, this.mPaint);
        } else if (right_temp >= 62 && right_temp <= 90) {
            c.drawText(new StringBuilder().append(right_temp).toString(), 940.0f, 62.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (right_temp / 2.0f)).toString(), 940.0f, 62.0f, this.mPaint);
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
