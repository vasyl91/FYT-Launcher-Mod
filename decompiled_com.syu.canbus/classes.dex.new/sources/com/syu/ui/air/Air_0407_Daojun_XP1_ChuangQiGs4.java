package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0407_Daojun_XP1_ChuangQiGs4 extends AirBase {
    public Air_0407_Daojun_XP1_ChuangQiGs4(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0280_rzc_xp1_chuangqigs4/air_rzc_xp1_gs4_n.webp";
        this.mPathHighlight = "0280_rzc_xp1_chuangqigs4/air_rzc_xp1_gs4_p.webp";
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
            this.srPath.addRect(201.0f, 23.0f, 316.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(214.0f, 105.0f, 305.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(36.0f, 23.0f, 134.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(715.0f, 12.0f, 809.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(727.0f, 90.0f, 814.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(385.0f, 89.0f, 433.0f, 118.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(386.0f, 128.0f, 424.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(872.0f, 16.0f, 1005.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 1) {
            this.srPath.addRect(530.0f, 7.0f, 673.0f, 76.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(548.0f, 94.0f, (value * 18) + 548, 159.0f, Path.Direction.CW);
        int value2 = this.DATA[25];
        this.srPath.addRect(376.0f, 17.0f, (value2 * 18) + 376, 81.0f, Path.Direction.CW);
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
            c.drawText("LOW", 65.0f, 140.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 65.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 100.0f).toString(), 65.0f, 140.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 140.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp / 100.0f).toString(), 930.0f, 140.0f, this.mPaint);
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
