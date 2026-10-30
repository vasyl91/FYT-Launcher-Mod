package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0443_WC2_Nazhijie_U6 extends AirBase {
    public Air_0443_WC2_Nazhijie_U6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0128_wc2_changancs75/air_wc2_changancs75_n.webp";
        this.mPathHighlight = "0128_wc2_changancs75/air_wc2_changancs75_p.webp";
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
            this.srPath.addRect(853.0f, 50.0f, 1010.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(708.0f, 43.0f, 819.0f, 127.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(777.0f, 15.0f, 838.0f, 41.0f, Path.Direction.CW);
            this.srPath.addRect(379.0f, 13.0f, 459.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(395.0f, 80.0f, 451.0f, 107.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(379.0f, 13.0f, 459.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(377.0f, 107.0f, 425.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(183.0f, 34.0f, 334.0f, 128.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value == 5) {
            value = 6;
        } else if (value == 6) {
            value = 8;
        }
        this.srPath.addRect(525.0f, 65.0f, (value * 18) + 525, 125.0f, Path.Direction.CW);
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
            c.drawText("NO", 100.0f, 110.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 100.0f, 110.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 100.0f, 110.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + " ℃", 100.0f, 110.0f, this.mPaint);
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
