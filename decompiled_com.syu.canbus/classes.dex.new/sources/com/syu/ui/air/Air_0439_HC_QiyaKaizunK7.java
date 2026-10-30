package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_HC_QiyaKaizunK7 extends AirBase {
    public Air_0439_HC_QiyaKaizunK7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_hc_qiyakaizunk7/hc_qiyakaizunk7.webp";
        this.mPathHighlight = "0439_hc_qiyakaizunk7/hc_qiyakaizunk7_p.webp";
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
            this.srPath.addRect(389.0f, 25.0f, 543.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(724.0f, 13.0f, 842.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(722.0f, 96.0f, 838.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(197.0f, 16.0f, 311.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(212.0f, 96.0f, 295.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(598.0f, 10.0f, 667.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(606.0f, 69.0f, 660.0f, 86.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(594.0f, 84.0f, 634.0f, 118.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(607.0f, 126.0f, 684.0f, 151.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(396.0f, 92.0f, (value * 19) + 396, 152.0f, Path.Direction.CW);
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
            c.drawText("NO", 74.0f, 80.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 74.0f, 80.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 74.0f, 80.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) + 95;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 74.0f, 80.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 925.0f, 80.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 925.0f, 80.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 925.0f, 80.0f, this.mPaint);
        } else {
            int temp3 = (temp1 * 5) + 95;
            c.drawText(String.valueOf(temp3 / 10) + "." + (temp3 % 10), 925.0f, 80.0f, this.mPaint);
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
