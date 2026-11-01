package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0453_Oudi_JMC_NewEnergy extends AirBase {
    public Air_0453_Oudi_JMC_NewEnergy(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0307_xbs_xp1_15zhonghuav3/zhonghuav3.webp";
        this.mPathHighlight = "0307_xbs_xp1_15zhonghuav3/zhonghuav3_p.webp";
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
            this.srPath.addRect(775.0f, 120.0f, 839.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(745.0f, 92.0f, 859.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[21] != 0) {
            this.srPath.addRect(734.0f, 25.0f, 872.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(455.0f, 12.0f, 537.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(476.0f, 76.0f, 536.0f, 102.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(451.0f, 100.0f, 499.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(305.0f, 17.0f, 426.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(312.0f, 91.0f, 423.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(154.0f, 45.0f, 286.0f, 123.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(597.0f, 55.0f, (value * 18) + 597, 133.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(20.0f);
        if (this.DATA[13] != 0) {
            c.drawText("Auto", 667.0f, 34.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int value2 = this.DATA[27];
        switch (value2) {
            case -3:
                c.drawText("HIGH", 51.0f, 97.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 51.0f, 97.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NONE", 51.0f, 97.0f, this.mPaint);
                break;
            default:
                c.drawText(new StringBuilder(String.valueOf(((value2 * 5) + 180) * 0.1f)).toString(), 51.0f, 97.0f, this.mPaint);
                break;
        }
        int value3 = this.DATA[27];
        switch (value3) {
            case -3:
                c.drawText("HIGH", 945.0f, 97.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 945.0f, 97.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NONE", 945.0f, 97.0f, this.mPaint);
                break;
            default:
                c.drawText(new StringBuilder(String.valueOf(((value3 * 5) + 180) * 0.1f)).toString(), 945.0f, 97.0f, this.mPaint);
                break;
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
