package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_BNR_Toyota extends AirBase {
    public Air_0439_BNR_Toyota(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0294_wc_toyota/vw_18prado_air.webp";
        this.mPathHighlight = "0294_wc_toyota/vw_18prado_air_p.webp";
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
            this.srPath.addRect(173.0f, 126.0f, 272.0f, 176.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(386.0f, 18.0f, 472.0f, 90.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(326.0f, 114.0f, 407.0f, 183.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(481.0f, 125.0f, 548.0f, 172.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(758.0f, 105.0f, 822.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(774.0f, 150.0f, 821.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(766.0f, 164.0f, 803.0f, 196.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(190.0f, 34.0f, 315.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(895.0f, 122.0f, 1016.0f, 181.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(549.0f, 34.0f, 644.0f, 77.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(612.0f, 136.0f, (value * 16) + 612, 186.0f, Path.Direction.CW);
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
            c.drawText("NONE", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 60.0f, this.mPaint);
        } else {
            if (temp >= 1 && temp <= 29) {
                temp = (temp + 35) * 5;
            } else if (temp >= 33 && temp <= 38) {
                temp = ((temp - 33) * 5) + 150;
            }
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 70.0f, 60.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NONE", 925.0f, 60.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 925.0f, 60.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 925.0f, 60.0f, this.mPaint);
        } else {
            if (temp2 >= 1 && temp2 <= 29) {
                temp2 = (temp2 + 35) * 5;
            } else if (temp2 >= 33 && temp2 <= 38) {
                temp2 = ((temp2 - 33) * 5) + 150;
            }
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 925.0f, 60.0f, this.mPaint);
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
