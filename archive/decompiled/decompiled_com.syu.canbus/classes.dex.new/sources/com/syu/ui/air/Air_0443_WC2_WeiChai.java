package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0443_WC2_WeiChai extends AirBase {
    public Air_0443_WC2_WeiChai(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0443_wc2_weichai/air_wc2_weichai.webp";
        this.mPathHighlight = "0443_wc2_weichai/air_wc2_weichai_p.webp";
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
            this.srPath.addRect(23.0f, 113.0f, 154.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(521.0f, 18.0f, 618.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(904.0f, 104.0f, 988.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(699.0f, 95.0f, 837.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(710.0f, 15.0f, 824.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(204.0f, 46.0f, 314.0f, 136.0f, Path.Direction.CW);
        }
        switch (this.DATA[77]) {
            case 1:
                this.srPath.addRect(663.0f, 144.0f, 736.0f, 164.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(648.0f, 20.0f, 717.0f, 74.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(359.0f, 96.0f, 408.0f, 135.0f, Path.Direction.CW);
                break;
            case 5:
                this.srPath.addRect(374.0f, 74.0f, 444.0f, 93.0f, Path.Direction.CW);
                this.srPath.addRect(359.0f, 96.0f, 408.0f, 135.0f, Path.Direction.CW);
                break;
            case 6:
                this.srPath.addRect(374.0f, 74.0f, 444.0f, 93.0f, Path.Direction.CW);
                break;
            case 11:
                this.srPath.addRect(356.0f, 39.0f, 447.0f, 72.0f, Path.Direction.CW);
                break;
            case 12:
                this.srPath.addRect(356.0f, 39.0f, 447.0f, 72.0f, Path.Direction.CW);
                this.srPath.addRect(359.0f, 96.0f, 408.0f, 135.0f, Path.Direction.CW);
                break;
            case 13:
                this.srPath.addRect(356.0f, 39.0f, 447.0f, 72.0f, Path.Direction.CW);
                this.srPath.addRect(374.0f, 74.0f, 444.0f, 93.0f, Path.Direction.CW);
                break;
            case 14:
                this.srPath.addRect(356.0f, 39.0f, 447.0f, 72.0f, Path.Direction.CW);
                this.srPath.addRect(374.0f, 74.0f, 444.0f, 93.0f, Path.Direction.CW);
                this.srPath.addRect(359.0f, 96.0f, 408.0f, 135.0f, Path.Direction.CW);
                break;
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
        this.mPaint.setTextSize(40.0f);
        int temp = this.DATA[27];
        if (temp == 254) {
            c.drawText("LOW", 72.0f, 74.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 72.0f, 74.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 72.0f, 74.0f, this.mPaint);
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
