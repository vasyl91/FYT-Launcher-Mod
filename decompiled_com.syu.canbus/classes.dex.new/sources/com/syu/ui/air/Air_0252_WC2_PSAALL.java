package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0252_WC2_PSAALL extends AirBase {
    public Air_0252_WC2_PSAALL(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0252_wc2_psaall/air_wc_psa_all_n.webp";
        this.mPathHighlight = "0252_wc2_psaall/air_wc_psa_all_p.webp";
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
            this.srPath.addRect(20.0f, 23.0f, 148.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[55] != 0) {
            this.srPath.addRect(191.0f, 24.0f, 313.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(199.0f, 98.0f, 309.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(880.0f, 18.0f, 1004.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(383.0f, 109.0f, 477.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(721.0f, 12.0f, 845.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(720.0f, 93.0f, 850.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(555.0f, 90.0f, 606.0f, 121.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(595.0f, 116.0f, 632.0f, 129.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(564.0f, 131.0f, 600.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[51] == 0) {
            this.srPath.addRect(612.0f, 22.0f, 645.0f, 55.0f, Path.Direction.CW);
        } else if (this.DATA[51] == 1) {
            this.srPath.addRect(612.0f, 22.0f, 645.0f, 55.0f, Path.Direction.CW);
            this.srPath.addRect(576.0f, 23.0f, 607.0f, 59.0f, Path.Direction.CW);
        } else if (this.DATA[51] == 2) {
            this.srPath.addRect(612.0f, 22.0f, 645.0f, 55.0f, Path.Direction.CW);
            this.srPath.addRect(576.0f, 23.0f, 607.0f, 59.0f, Path.Direction.CW);
            this.srPath.addRect(592.0f, 58.0f, 630.0f, 79.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(364.0f, 35.0f, (value * 16) + 364, 85.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(15.0f);
        if (this.DATA[54] != 0) {
            c.drawText("AQS", 363.0f, 109.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        int tempvalue = this.DATA[242];
        if (temp == -1) {
            c.drawText("NO", 56.0f, 150.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 56.0f, 150.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 56.0f, 150.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp + (tempvalue * 10)) / 10.0f).toString(), 56.0f, 150.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 150.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 150.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 150.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp2 + (tempvalue * 10)) / 10.0f).toString(), 920.0f, 150.0f, this.mPaint);
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
