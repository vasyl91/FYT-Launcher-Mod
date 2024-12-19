package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0439_XP1_Bnr_YueshengS350 extends AirBase {
    public Air_0439_XP1_Bnr_YueshengS350(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_bnr_yusheng350/bnr_yusheng_350.webp";
        this.mPathHighlight = "0439_bnr_yusheng350/bnr_yusheng_350_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(871.0f, 54.0f, 1010.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(372.0f, 106.0f, 493.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(35.0f, 9.0f, 158.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[15] == 0) {
            c.clipRect(357.0f, 11.0f, 500.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(210.0f, 14.0f, 315.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(210.0f, 94.0f, 311.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(548.0f, 37.0f, 607.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(556.0f, 76.0f, 616.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(546.0f, 97.0f, 589.0f, 135.0f, Region.Op.UNION);
        }
        int value = this.DATA[22];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(712.0f, 70.0f, (value * 16) + 712, 123.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[23];
        if (temp == -1) {
            c.drawText("NO", 69.0f, 139.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 69.0f, 139.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 69.0f, 139.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp * 0.1f).toString(), 69.0f, 139.0f, this.mPaint);
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
