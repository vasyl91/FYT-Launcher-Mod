package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_OUDI_17Fengjun6 extends AirBase {
    public Air_0439_OUDI_17Fengjun6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_17fengjun6/oudi_17fengjun6.webp";
        this.mPathHighlight = "0439_oudi_17fengjun6/oudi_17fengjun6_p.webp";
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
            this.srPath.addRect(145.0f, 65.0f, 269.0f, 111.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(294.0f, 68.0f, 391.0f, 106.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(793.0f, 19.0f, 876.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(783.0f, 91.0f, 879.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(438.0f, 25.0f, 513.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(452.0f, 83.0f, 507.0f, 108.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(438.0f, 107.0f, 482.0f, 139.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(602.0f, 46.0f, (value * 19) + 602, 117.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(40.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 55.0f, 79.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 55.0f, 79.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 55.0f, 79.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp + 17).toString(), 55.0f, 79.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 946.0f, 79.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LO", 946.0f, 79.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 946.0f, 79.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp1 + 17).toString(), 55.0f, 79.0f, this.mPaint);
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
