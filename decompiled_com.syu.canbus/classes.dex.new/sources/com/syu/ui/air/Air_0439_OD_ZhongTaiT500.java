package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_OD_ZhongTaiT500 extends AirBase {
    public Air_0439_OD_ZhongTaiT500(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_changan/oudi_changan.webp";
        this.mPathHighlight = "0439_oudi_changan/oudi_changan_p.webp";
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
            this.srPath.addRect(898.0f, 110.0f, 1019.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(151.0f, 29.0f, 213.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(443.0f, 16.0f, 580.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[26] != 0) {
            this.srPath.addRect(803.0f, 30.0f, 892.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(705.0f, 28.0f, 795.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(21.0f, 105.0f, 122.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(136.0f, 94.0f, 240.0f, 159.0f, Path.Direction.CW);
            this.srPath.addRect(251.0f, 25.0f, 327.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[38] != 0) {
            this.srPath.addRect(592.0f, 111.0f, 700.0f, 160.0f, Path.Direction.CW);
            this.srPath.addRect(255.0f, 97.0f, 322.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(341.0f, 37.0f, 399.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(343.0f, 90.0f, 396.0f, 106.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(338.0f, 107.0f, 372.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(809.0f, 104.0f, 886.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(709.0f, 109.0f, 791.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(604.0f, 16.0f, 693.0f, 81.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(449.0f, 96.0f, (value * 17) + 449, 153.0f, Path.Direction.CW);
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
            c.drawText("NO", 63.0f, 57.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 63.0f, 57.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 63.0f, 57.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp * 0.1f) + " ℃", 63.0f, 57.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 957.0f, 57.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 957.0f, 57.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 957.0f, 57.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp1 * 0.1f) + " ℃", 957.0f, 57.0f, this.mPaint);
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
