package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0152_RZC_ChuanQiGS5_Tempvalue extends AirBase {
    public Air_0152_RZC_ChuanQiGS5_Tempvalue(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0152_rzc_xp1_chuanqigs5/air_rzc_chuanqi_gs5_temp_n.webp";
        this.mPathHighlight = "0152_rzc_xp1_chuanqigs5/air_rzc_chuanqi_gs5_temp_p.webp";
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
        if (this.DATA[12] == 0) {
            this.srPath.addRect(845.0f, 94.0f, 989.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(204.0f, 35.0f, 312.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(369.0f, 48.0f, 466.0f, 134.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(50.0f, 102.0f, 145.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(537.0f, 47.0f, 601.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(512.0f, 80.0f, 560.0f, 125.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(676.0f, 24.0f, (value * 20) + 676, 124.0f, Path.Direction.CW);
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
            c.drawText("NO", 73.0f, 58.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 73.0f, 58.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 73.0f, 58.0f, this.mPaint);
        } else {
            int temp2 = (((temp - 3) / 2) * 5) + 185;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 73.0f, 58.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == -1) {
            c.drawText("NO", 909.0f, 58.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 909.0f, 58.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 909.0f, 58.0f, this.mPaint);
        } else {
            int temp4 = (((temp3 - 3) / 2) * 5) + 185;
            c.drawText(String.valueOf(temp4 / 10) + "." + (temp4 % 10), 909.0f, 58.0f, this.mPaint);
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
