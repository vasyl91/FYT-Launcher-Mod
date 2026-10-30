package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0177_RZC_ChangChengFengJun6 extends AirBase {
    public Air_0177_RZC_ChangChengFengJun6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0177_rzc_changchengfengjun6/air_rzc_changchengfengjun6_n.webp";
        this.mPathHighlight = "0177_rzc_changchengfengjun6/air_rzc_changchengfengjun6_p.webp";
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
            this.srPath.addRect(887.0f, 103.0f, 1001.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(34.0f, 102.0f, 129.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(342.0f, 37.0f, 415.0f, 88.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(376.0f, 87.0f, 430.0f, 109.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(353.0f, 107.0f, 393.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(165.0f, 93.0f, 306.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(163.0f, 24.0f, 305.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(501.0f, 42.0f, 629.0f, 141.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(693.0f, 73.0f, (value * 20) + 693, 133.0f, Path.Direction.CW);
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
            c.drawText("NO", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp).toString(), 70.0f, 60.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 60.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 60.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2).toString(), 920.0f, 60.0f, this.mPaint);
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
