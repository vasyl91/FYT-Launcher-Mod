package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0439_DJ_14B70_H extends AirBase {
    public Air_0439_DJ_14B70_H(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_dj_14b70/dj_14b70_h.webp";
        this.mPathHighlight = "0439_dj_14b70/dj_14b70_h_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(138.0f, 21.0f, 270.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(289.0f, 20.0f, 390.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(159.0f, 108.0f, 255.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(302.0f, 103.0f, 376.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(610.0f, 16.0f, 737.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(785.0f, 17.0f, 881.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(799.0f, 95.0f, 872.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(429.0f, 32.0f, 502.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(444.0f, 83.0f, 494.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(433.0f, 108.0f, 470.0f, 138.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(607.0f, 95.0f, (value * 19) + 607, 157.0f, Region.Op.UNION);
        int value2 = this.DATA[13];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(66.0f, 130.0f, 66.0f + (value2 * 20.0f), 155.0f, Region.Op.UNION);
        int value3 = this.DATA[14];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(964.0f - (value3 * 20.0f), 130.0f, 964.0f, 159.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[11];
        if (temp == -1) {
            c.drawText("NO", 49.0f, 51.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 49.0f, 51.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 49.0f, 51.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp * 0.5f).toString(), 49.0f, 51.0f, this.mPaint);
        }
        int temp1 = this.DATA[12];
        if (temp1 == -1) {
            c.drawText("NO", 939.0f, 51.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 939.0f, 51.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 939.0f, 51.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp * 0.5f).toString(), 49.0f, 51.0f, this.mPaint);
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
