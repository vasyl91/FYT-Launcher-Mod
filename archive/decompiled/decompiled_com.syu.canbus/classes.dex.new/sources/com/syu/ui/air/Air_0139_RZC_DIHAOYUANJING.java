package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0139_RZC_DIHAOYUANJING extends AirBase {
    public Air_0139_RZC_DIHAOYUANJING(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0139_jl_dihaoyuanjing/air_dihaoyuanjing.webp";
        this.mPathHighlight = "0139_jl_dihaoyuanjing/air_dihaoyuanjing_p.webp";
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
            this.srPath.addRect(885.0f, 17.0f, 982.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(13.0f, 23.0f, 163.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(878.0f, 97.0f, 1007.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(203.0f, 16.0f, 311.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(203.0f, 95.0f, 311.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(549.0f, 54.0f, 605.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(549.0f, 76.0f, 605.0f, 94.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(545.0f, 95.0f, 586.0f, 137.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(361.0f, 53.0f, 502.0f, 119.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(698.0f, 60.0f, (value * 18) + 698, 126.0f, Path.Direction.CW);
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
            c.drawText("LO", 80.0f, 140.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 80.0f, 140.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 2818187) {
            c.drawText(new StringBuilder(String.valueOf(left_temp)).toString(), 80.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp + 15) + " ℃", 80.0f, 140.0f, this.mPaint);
        }
        int i = this.DATA[27];
        if (DataCanbus.DATA[1000] == 65801) {
            int right_temp = this.DATA[27];
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
