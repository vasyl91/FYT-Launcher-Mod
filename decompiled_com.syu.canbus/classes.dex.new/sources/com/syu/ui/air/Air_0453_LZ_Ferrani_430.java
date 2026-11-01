package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0453_LZ_Ferrani_430 extends AirBase {
    public Air_0453_LZ_Ferrani_430(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0061_rzc_xp1_gm/air.webp";
        this.mPathHighlight = "0061_rzc_xp1_gm/air_p.webp";
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
        if (this.DATA[10] != 0) {
            this.srPath.addRect(165.0f, 23.0f, 305.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(513.0f, 31.0f, 610.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(348.0f, 143.0f, 412.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(325.0f, 12.0f, 415.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(332.0f, 63.0f, 377.0f, 90.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(354.0f, 89.0f, 404.0f, 106.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(333.0f, 106.0f, 370.0f, 140.0f, Path.Direction.CW);
        }
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit == 1) {
            this.srPath.addRect(112.0f, 40.0f, 159.0f, 82.0f, Path.Direction.CW);
            this.srPath.addRect(977.0f, 36.0f, 1017.0f, 78.0f, Path.Direction.CW);
        }
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
        if (temp == -2) {
            c.drawText("LO", 70.0f, 70.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 70.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("No", 70.0f, 70.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp * 9) / 10) + 32)), 70.0f, 70.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 70.0f, 70.0f, this.mPaint);
        }
        int temp3 = this.DATA[27];
        if (temp3 == -2) {
            c.drawText("LO", 938.0f, 70.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 938.0f, 70.0f, this.mPaint);
        } else if (temp3 == -1) {
            c.drawText("No", 938.0f, 70.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp3 * 9) / 10) + 32)), 938.0f, 70.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 938.0f, 70.0f, this.mPaint);
        }
        int wind = this.DATA[21];
        c.drawText(String.format("%d", Integer.valueOf(wind)), 737.0f, 142.0f, this.mPaint);
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
