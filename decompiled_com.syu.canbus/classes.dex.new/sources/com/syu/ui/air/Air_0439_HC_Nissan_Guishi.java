package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_HC_Nissan_Guishi extends AirBase {
    public Air_0439_HC_Nissan_Guishi(Context context) {
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[13] != 0) {
            this.srPath.addRect(19.0f, 16.0f, 161.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(862.0f, 18.0f, 994.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(520.0f, 10.0f, 679.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(199.0f, 15.0f, 336.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(201.0f, 93.0f, 335.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(707.0f, 18.0f, 826.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(380.0f, 24.0f, 415.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(402.0f, 59.0f, 439.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(388.0f, 76.0f, 411.0f, 107.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(517.0f, 123.0f, (value * 39) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B4, 156.0f, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
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
            int temp2 = (temp * 5) + 175;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 70.0f, 135.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == -1) {
            c.drawText("NO", 915.0f, 135.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 915.0f, 135.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 915.0f, 135.0f, this.mPaint);
        } else {
            int temp4 = (temp3 * 5) + 175;
            c.drawText(String.valueOf(temp4 / 10) + "." + (temp4 % 10), 915.0f, 135.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
