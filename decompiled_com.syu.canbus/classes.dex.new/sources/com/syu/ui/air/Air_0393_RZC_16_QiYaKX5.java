package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0393_RZC_16_QiYaKX5 extends AirBase {
    public Air_0393_RZC_16_QiYaKX5(Context context) {
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[11] != 0) {
            this.srPath.addRect(219.0f, 104.0f, 313.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(26.0f, 99.0f, 156.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(878.0f, 100.0f, 1005.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(536.0f, 14.0f, 650.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(539.0f, 91.0f, 658.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(387.0f, 44.0f, 443.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(385.0f, 66.0f, 434.0f, 94.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(371.0f, 85.0f, 400.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1) {
            this.srPath.addRect(129.0f, 21.0f, 176.0f, 84.0f, Path.Direction.CW);
            this.srPath.addRect(978.0f, 17.0f, 1015.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(189.0f, 12.0f, 335.0f, 78.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(712.0f, 44.0f, (value * 18) + 712, 116.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp >= 50 && left_temp <= 100) {
            c.drawText(new StringBuilder().append(left_temp).toString(), 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (left_temp / 2.0f)).toString(), 76.0f, 72.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 940.0f, 72.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 940.0f, 72.0f, this.mPaint);
        } else if (right_temp >= 50 && right_temp <= 100) {
            c.drawText(new StringBuilder().append(right_temp).toString(), 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (right_temp / 2.0f)).toString(), 940.0f, 72.0f, this.mPaint);
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
