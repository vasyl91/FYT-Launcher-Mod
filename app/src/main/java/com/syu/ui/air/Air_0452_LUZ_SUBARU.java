package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0452_LUZ_SUBARU extends AirBase {
    public Air_0452_LUZ_SUBARU(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_luz_subaru/air_luz_subaru_n.webp";
        this.mPathHighlight = "0452_luz_subaru/air_luz_subaru_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(131.0f, 23.0f, 253.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(144.0f, 109.0f, 237.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(272.0f, 18.0f, 370.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(536.0f, 15.0f, 620.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(540.0f, 94.0f, 620.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(269.0f, 99.0f, 367.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(808.0f, 104.0f, 864.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(658.0f, 105.0f, 760.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(410.0f, 29.0f, 466.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(413.0f, 87.0f, 464.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(403.0f, 106.0f, 440.0f, 139.0f, Region.Op.UNION);
        }
        int value = this.DATA[19];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(730.0f, 24.0f, (value * 18) + 730, 77.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[20];
        int unit = this.DATA[22];
        if (temp == -2) {
            c.drawText("LOW", 59.0f, 108.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 59.0f, 108.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NONE", 59.0f, 108.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(String.valueOf(((temp * 9) + 320) / 10.0f) + " ℉", 59.0f, 108.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f) + " ℃", 59.0f, 108.0f, this.mPaint);
        }
        int temp2 = this.DATA[21];
        if (temp2 == -2) {
            c.drawText("LOW", 956.0f, 108.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 956.0f, 108.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("NONE", 956.0f, 108.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(String.valueOf(((temp2 * 9) + 320) / 10.0f) + " ℉", 956.0f, 108.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f) + " ℃", 956.0f, 108.0f, this.mPaint);
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
