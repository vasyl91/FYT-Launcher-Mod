package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0168_Xp2_SuoLaTa extends AirBase {
    public Air_0168_Xp2_SuoLaTa(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0015_31_xp2_xiandai_ix3545/air_xp1_xiandaiix45.webp";
        this.mPathHighlight = "0015_31_xp2_xiandai_ix3545/air_xp1_xiandaiix45_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[22] != 0) {
            c.clipRect(5.0f, 12.0f, 152.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(167.0f, 17.0f, 301.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(167.0f, 94.0f, 305.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(687.0f, 9.0f, 866.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(336.0f, 39.0f, 387.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(875.0f, 13.0f, 1017.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(364.0f, 71.0f, 415.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(332.0f, 92.0f, 379.0f, 131.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(679.0f, 91.0f, 868.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[19];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(498.0f, 71.0f, (value * 20) + 498, 132.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[14];
        if (temp == -2) {
            c.drawText("LOW", 50.0f, 130.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf((temp / 2.0f) + 17.0f)).toString(), 50.0f, 130.0f, this.mPaint);
        }
        int temp2 = this.DATA[21];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 130.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf((temp2 / 2.0f) + 17.0f)).toString(), 930.0f, 130.0f, this.mPaint);
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
