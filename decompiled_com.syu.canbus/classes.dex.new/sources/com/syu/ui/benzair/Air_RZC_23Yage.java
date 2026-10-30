package com.syu.ui.benzair;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.util.ToolkitRes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_RZC_23Yage extends Air_BenzBase {
    public Air_RZC_23Yage(Context context) {
        super(context);
    }

    @Override // com.syu.ui.benzair.Air_BenzBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.benzair.Air_BenzBase
    protected void initDrawable() {
        this.mPathHighlight1 = "0450_benz_air/rzc_23yage_highlight1.png";
        this.mPathHighlight2 = "0450_benz_air/rzc_23yage_highlight2.png";
        this.mDrawableHighlight1 = ToolkitRes.loadDrawable(this.mPathHighlight1);
        this.mDrawableHighlight2 = ToolkitRes.loadDrawable(this.mPathHighlight2);
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
        if (this.DATA[293] == 1) {
            this.srPath.addRect(23.0f, 6.0f, 113.0f, 86.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 2) {
            this.srPath.addRect(157.0f, 86.0f, 251.0f, 166.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 3) {
            this.srPath.addRect(160.0f, 5.0f, 254.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 4) {
            this.srPath.addRect(434.0f, 5.0f, 519.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 5) {
            this.srPath.addRect(912.0f, 29.0f, 1020.0f, 138.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 6) {
            this.srPath.addRect(297.0f, 6.0f, 391.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 7) {
            this.srPath.addRect(295.0f, 88.0f, 382.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 8) {
            this.srPath.addRect(28.0f, 86.0f, 110.0f, 167.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 9) {
            this.srPath.addRect(431.0f, 88.0f, 527.0f, 168.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 10) {
            this.srPath.addRect(550.0f, 23.0f, 664.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 11) {
            this.srPath.addRect(671.0f, 29.0f, 780.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[293] == 12) {
            this.srPath.addRect(791.0f, 29.0f, 900.0f, 143.0f, Path.Direction.CW);
        }
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight2.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableHighlight1.draw(c);
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
