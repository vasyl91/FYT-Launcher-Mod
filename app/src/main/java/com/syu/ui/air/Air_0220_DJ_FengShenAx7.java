package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0220_DJ_FengShenAx7 extends AirBase {
    public Air_0220_DJ_FengShenAx7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0220_dj_fengshengax7/air_dj_ax7.webp";
        this.mPathHighlight = "0220_dj_fengshengax7/air_dj_ax7_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(18.0f, 105.0f, 158.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(373.0f, 71.0f, 441.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(359.0f, 93.0f, 411.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(361.0f, 33.0f, 419.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(903.0f, 107.0f, 989.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(197.0f, 26.0f, 309.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(701.0f, 94.0f, 840.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(209.0f, 97.0f, 304.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(712.0f, 16.0f, 824.0f, 83.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(531.0f, 66.0f, (value * 18) + 531, 127.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[5];
        if (left_temp == -2) {
            c.drawText("LOW", 80.0f, 72.0f, this.mPaint);
            c.drawText("LOW", 938.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 80.0f, 72.0f, this.mPaint);
            c.drawText("HI", 938.0f, 72.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("----", 80.0f, 72.0f, this.mPaint);
            c.drawText("----", 938.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp).toString(), 80.0f, 72.0f, this.mPaint);
            c.drawText(new StringBuilder().append(left_temp).toString(), 938.0f, 72.0f, this.mPaint);
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
