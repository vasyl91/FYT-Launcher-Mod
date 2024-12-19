package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0453_LZ_Nissan_03Teana extends AirBase {
    public Air_0453_LZ_Nissan_03Teana(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0008_wc1_bentengx80/air_fyta_bentengx80.webp";
        this.mPathHighlight = "0008_wc1_bentengx80/air_fyta_bentengx80_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[13] != 0) {
            c.clipRect(19.0f, 16.0f, 161.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(862.0f, 18.0f, 994.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(520.0f, 10.0f, 679.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(199.0f, 15.0f, 336.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(201.0f, 93.0f, 335.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(707.0f, 18.0f, 826.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(380.0f, 24.0f, 415.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(402.0f, 59.0f, 439.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(388.0f, 76.0f, 411.0f, 107.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(517.0f, 123.0f, (value * 39) + ConstRzcAddData.U_CAR_LIGHT, 156.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 70.0f, 135.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 135.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp * 5) + 175) / 10.0f).toString(), 70.0f, 135.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 915.0f, 135.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 915.0f, 135.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 915.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp2 * 5) + 175) / 10.0f).toString(), 915.0f, 135.0f, this.mPaint);
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / this.mContentWidth, LauncherApplication.getScreenWidth() / this.mContentWidth);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / this.mContentWidth, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
