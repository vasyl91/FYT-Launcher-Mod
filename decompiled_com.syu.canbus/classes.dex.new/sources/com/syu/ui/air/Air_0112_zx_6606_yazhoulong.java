package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0112_zx_6606_yazhoulong extends AirBase {
    public Air_0112_zx_6606_yazhoulong(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1280;
        this.mContentHeight = 132;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_zx_6606_yazhoulong_n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_zx_6606_yazhoulong_p.webp";
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
        if (this.DATA[14] != 0) {
            this.srPath.addRect(832.0f, 8.0f, 913.0f, 51.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0 || this.DATA[26] != 0) {
            this.srPath.addRect(365.0f, 11.0f, 447.0f, 38.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(756.0f, 9.0f, 808.0f, 51.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(268.0f, 22.0f, 297.0f, 52.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(278.0f, 49.0f, 316.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(277.0f, 68.0f, 315.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(463.0f, 10.0f, 553.0f, 51.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(955.0f, 37.0f, 1042.0f, 95.0f, Path.Direction.CW);
        }
        if (this.DATA[166] == 1) {
            this.srPath.addRect(388.0f, 37.0f, 403.0f, 48.0f, Path.Direction.CW);
        } else if (this.DATA[166] == 2) {
            this.srPath.addRect(388.0f, 37.0f, 413.0f, 48.0f, Path.Direction.CW);
        } else if (this.DATA[166] == 3) {
            this.srPath.addRect(388.0f, 37.0f, 431.0f, 48.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(581.0f, 10.0f, 635.0f, 53.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(667.0f, 11.0f, 716.0f, 51.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value == 1) {
            this.srPath.addRect(460.0f, 70.0f, 513.0f, 124.0f, Path.Direction.CW);
        } else if (value == 2) {
            this.srPath.addRect(460.0f, 70.0f, 565.0f, 124.0f, Path.Direction.CW);
        } else if (value == 3) {
            this.srPath.addRect(460.0f, 70.0f, 615.0f, 124.0f, Path.Direction.CW);
        } else if (value == 4) {
            this.srPath.addRect(460.0f, 70.0f, 663.0f, 124.0f, Path.Direction.CW);
        } else if (value == 5) {
            this.srPath.addRect(460.0f, 70.0f, 715.0f, 124.0f, Path.Direction.CW);
        } else if (value == 6) {
            this.srPath.addRect(460.0f, 70.0f, 763.0f, 124.0f, Path.Direction.CW);
        } else if (value == 7) {
            this.srPath.addRect(460.0f, 70.0f, 820.0f, 124.0f, Path.Direction.CW);
        }
        int value2 = this.DATA[29];
        if (value2 == 1) {
            this.srPath.addRect(128.0f, 99.0f, 148.0f, 109.0f, Path.Direction.CW);
        } else if (value2 == 2) {
            this.srPath.addRect(128.0f, 99.0f, 161.0f, 109.0f, Path.Direction.CW);
        } else if (value2 == 3) {
            this.srPath.addRect(128.0f, 99.0f, 177.0f, 109.0f, Path.Direction.CW);
        }
        int value3 = this.DATA[31];
        if (value3 == 1) {
            this.srPath.addRect(40.0f, 100.0f, 56.0f, 111.0f, Path.Direction.CW);
        } else if (value3 == 2) {
            this.srPath.addRect(40.0f, 100.0f, 68.0f, 111.0f, Path.Direction.CW);
        } else if (value3 == 3) {
            this.srPath.addRect(40.0f, 100.0f, 82.0f, 111.0f, Path.Direction.CW);
        }
        int value4 = this.DATA[30];
        if (value4 == 1) {
            this.srPath.addRect(1101.0f, 100.0f, 1123.0f, 109.0f, Path.Direction.CW);
        } else if (value4 == 2) {
            this.srPath.addRect(1101.0f, 100.0f, 1135.0f, 109.0f, Path.Direction.CW);
        } else if (value4 == 3) {
            this.srPath.addRect(1101.0f, 100.0f, 1151.0f, 109.0f, Path.Direction.CW);
        }
        int value5 = this.DATA[32];
        if (value5 == 1) {
            this.srPath.addRect(1195.0f, 100.0f, 1215.0f, 108.0f, Path.Direction.CW);
        } else if (value5 == 2) {
            this.srPath.addRect(1195.0f, 100.0f, 1227.0f, 108.0f, Path.Direction.CW);
        } else if (value5 == 3) {
            this.srPath.addRect(1195.0f, 100.0f, 1243.0f, 108.0f, Path.Direction.CW);
        }
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
            c.drawText("NO", 371.0f, 111.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 371.0f, 111.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 371.0f, 111.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(new StringBuilder(String.valueOf(temp / 10.0f)).toString(), 371.0f, 111.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp / 10.0f)).toString(), 371.0f, 111.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 852.0f, 111.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 852.0f, 111.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 852.0f, 111.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(new StringBuilder(String.valueOf(temp2 / 10.0f)).toString(), 852.0f, 111.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp2 / 10.0f)).toString(), 852.0f, 111.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(TheApp.getScreenWidth() / 1920.0f, 1.0f);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
