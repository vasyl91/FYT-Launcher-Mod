package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0413_RZC_XP1_16BenTengB50 extends AirBase {
    public Air_0413_RZC_XP1_16BenTengB50(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0413_rzc_xp1_bentengb50/air_rzc_bentengb50.webp";
        this.mPathHighlight = "0413_rzc_xp1_bentengb50/air_rzc_bentengb50_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[13] != 0) {
            c.clipRect(205.0f, 19.0f, 311.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(208.0f, 100.0f, 304.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(709.0f, 95.0f, 816.0f, 166.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(361.0f, 21.0f, 444.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(374.0f, 85.0f, 441.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(364.0f, 110.0f, 409.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(687.0f, 14.0f, 828.0f, 74.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        if (value >= 0 && value <= 7) {
            c.clipRect(514.0f, 54.0f, (value * 20) + ConstRzcAddData.U_CAR_SEAT_BELT_LEFT, 135.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[19];
        if (temp == -2) {
            c.drawText("LOW", 95.0f, 105.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 95.0f, 105.0f, this.mPaint);
        } else {
            c.drawText((temp / 2.0f) + " ℃", 95.0f, 105.0f, this.mPaint);
        }
        int temp2 = this.DATA[20];
        if (temp2 == -2) {
            c.drawText("LOW", 935.0f, 105.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 935.0f, 105.0f, this.mPaint);
        } else {
            c.drawText((temp2 / 2.0f) + " ℃", 935.0f, 105.0f, this.mPaint);
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
