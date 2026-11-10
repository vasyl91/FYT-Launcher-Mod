package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0454_OD_Xinte_DEV1 extends AirBase {
    public Air_0454_OD_Xinte_DEV1(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0154_zmyt_xp1_mendeo/air_zmyt_xp1_mendeo_n.webp";
        this.mPathHighlight = "0154_zmyt_xp1_mendeo/air_zmyt_xp1_mendeo_p.webp";
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
            this.srPath.addRect(874.0f, 14.0f, 1017.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(177.0f, 17.0f, 285.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(687.0f, 96.0f, 853.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(525.0f, 13.0f, 641.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(713.0f, 15.0f, 830.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(342.0f, 24.0f, 412.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(350.0f, 74.0f, 404.0f, 99.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(338.0f, 95.0f, 391.0f, 138.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(24.0f, 17.0f, 134.0f, 72.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value >= 6) {
            value = 7;
        }
        this.srPath.addRect(515.0f, 98.0f, (value * 19) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B6, 157.0f, Path.Direction.CW);
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
            c.drawText("NO", 60.0f, 150.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 60.0f, 150.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 150.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 1.0f).toString(), 60.0f, 150.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 150.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 930.0f, 150.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 150.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 1.0f).toString(), 930.0f, 150.0f, this.mPaint);
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
