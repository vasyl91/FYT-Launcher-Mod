package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(131.0f, 23.0f, 253.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(144.0f, 109.0f, 237.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(272.0f, 18.0f, 370.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(536.0f, 15.0f, 620.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(540.0f, 94.0f, 620.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[79] != 0) {
            this.srPath.addRect(269.0f, 99.0f, 367.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(808.0f, 104.0f, 864.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(658.0f, 105.0f, 760.0f, 144.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(410.0f, 29.0f, 466.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(413.0f, 87.0f, 464.0f, 109.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(403.0f, 106.0f, 440.0f, 139.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(730.0f, 24.0f, (value * 18) + 730, 77.0f, Path.Direction.CW);
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
        int unit = this.DATA[37];
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
        int temp2 = this.DATA[28];
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
