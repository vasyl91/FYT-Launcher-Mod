package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_081_LSDT_XP1_HaiMaS7 extends AirBase {
    public Air_081_LSDT_XP1_HaiMaS7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0157_daojun_xp1_haimam8s7/air_daojun_haimam8_n.webp";
        this.mPathHighlight = "0157_daojun_xp1_haimam8s7/air_daojun_haimam8_p.webp";
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
            this.srPath.addRect(28.0f, 25.0f, 148.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(890.0f, 16.0f, 996.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(413.0f, 82.0f, 463.0f, 107.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(385.0f, 16.0f, 464.0f, 78.0f, Path.Direction.CW);
            this.srPath.addRect(204.0f, 94.0f, 310.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(381.0f, 106.0f, 426.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(704.0f, 13.0f, 841.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(727.0f, 92.0f, 824.0f, 163.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(536.0f, 64.0f, (value * 18) + 536, 130.0f, Path.Direction.CW);
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
        int lef_temp = this.DATA[27];
        if (lef_temp == 0) {
            c.drawText("LO", 71.0f, 142.0f, this.mPaint);
        } else if (lef_temp == 28) {
            c.drawText("HI", 71.0f, 142.0f, this.mPaint);
        } else {
            int lef_temp2 = (lef_temp * 5) + 180;
            c.drawText(String.valueOf(lef_temp2 / 10) + "." + (lef_temp2 % 10), 71.0f, 142.0f, this.mPaint);
        }
        int right_temp = this.DATA[27];
        if (right_temp == 0) {
            c.drawText("LO", 915.0f, 142.0f, this.mPaint);
        } else if (right_temp == 28) {
            c.drawText("HI", 915.0f, 142.0f, this.mPaint);
        } else {
            int right_temp2 = (right_temp * 5) + 180;
            c.drawText(String.valueOf(right_temp2 / 10) + "." + (right_temp2 % 10), 915.0f, 142.0f, this.mPaint);
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
