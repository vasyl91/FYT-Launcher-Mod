package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0355_XP_QiYaK5 extends AirBase {
    public Air_0355_XP_QiYaK5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0355_xp_qiyak5/air_xp_qiya_k5_n.webp";
        this.mPathHighlight = "0355_xp_qiyak5/air_xp_qiya_k5_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(190.0f, 18.0f, 341.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(212.0f, 109.0f, 303.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(25.0f, 106.0f, 146.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(895.0f, 106.0f, 1006.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(536.0f, 32.0f, 661.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(384.0f, 52.0f, 432.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(398.0f, 76.0f, 447.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(387.0f, 92.0f, 423.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(701.0f, 95.0f, 842.0f, 159.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        c.clipRect(712.0f, 19.0f, (value * 18) + 712, 79.0f, Region.Op.UNION);
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit != 0) {
            c.clipRect(135.0f, 43.0f, 171.0f, 77.0f, Region.Op.UNION);
            c.clipRect(980.0f, 42.0f, 1015.0f, 77.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[5];
        if (left_temp == 0) {
            c.drawText("LOW", 70.0f, 55.0f, this.mPaint);
        } else if (left_temp == 30) {
            c.drawText("HI", 70.0f, 55.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder().append(((left_temp * 9) + 626) / 10).toString(), 70.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (left_temp / 2.0f)).toString(), 70.0f, 55.0f, this.mPaint);
        }
        int right_temp = this.DATA[11];
        if (right_temp == 0) {
            c.drawText("LOW", 930.0f, 55.0f, this.mPaint);
        } else if (right_temp == 30) {
            c.drawText("HI", 930.0f, 55.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder().append(((right_temp * 9) + 626) / 10).toString(), 930.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (right_temp / 2.0f)).toString(), 930.0f, 55.0f, this.mPaint);
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