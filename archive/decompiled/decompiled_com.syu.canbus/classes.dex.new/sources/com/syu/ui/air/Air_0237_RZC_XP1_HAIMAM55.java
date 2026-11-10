package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0237_RZC_XP1_HAIMAM55 extends AirBase {
    public Air_0237_RZC_XP1_HAIMAM55(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0237_rzc_xp1_haima55/air_rzc_xp_haima_m5_n.webp";
        this.mPathHighlight = "0237_rzc_xp1_haima55/air_rzc_xp_haima_m5_p.webp";
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
            this.srPath.addRect(14.0f, 22.0f, 161.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(909.0f, 18.0f, 974.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(223.0f, 106.0f, 330.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(738.0f, 95.0f, 816.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(724.0f, 13.0f, 827.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(559.0f, 44.0f, 622.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(568.0f, 82.0f, 631.0f, 101.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(552.0f, 99.0f, 603.0f, 139.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(197.0f, 15.0f, 347.0f, 79.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(401.0f, 63.0f, (value * 18) + 401, 115.0f, Path.Direction.CW);
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
        int unit = this.DATA[37];
        if (unit == 0) {
            c.drawText("℃", 138.0f, 152.0f, this.mPaint);
            c.drawText("℃", 977.0f, 152.0f, this.mPaint);
        } else {
            c.drawText("℉", 138.0f, 152.0f, this.mPaint);
            c.drawText("℉", 977.0f, 152.0f, this.mPaint);
        }
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else if (unit == 0) {
            c.drawText(new StringBuilder().append(left_temp / 2.0f).toString(), 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp).toString(), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else if (unit == 0) {
            c.drawText(new StringBuilder().append(right_temp / 2.0f).toString(), 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp).toString(), 930.0f, 152.0f, this.mPaint);
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
