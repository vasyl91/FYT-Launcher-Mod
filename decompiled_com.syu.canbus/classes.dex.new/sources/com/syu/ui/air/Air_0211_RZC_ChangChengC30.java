package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0211_RZC_ChangChengC30 extends AirBase {
    public Air_0211_RZC_ChangChengC30(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0211_rzc_changchengc30/air_rzc_changchengc30_n.webp";
        this.mPathHighlight = "0211_rzc_changchengc30/air_rzc_changchengc30_p.webp";
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
            this.srPath.addRect(867.0f, 99.0f, 1017.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(901.0f, 18.0f, 976.0f, 70.0f, Path.Direction.CW);
        }
        switch (this.DATA[19]) {
            case 1:
                this.srPath.addRect(389.0f, 80.0f, 450.0f, 106.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(389.0f, 80.0f, 450.0f, 106.0f, Path.Direction.CW);
                this.srPath.addRect(382.0f, 107.0f, 422.0f, 146.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(382.0f, 107.0f, 422.0f, 146.0f, Path.Direction.CW);
                break;
            case 4:
                this.srPath.addRect(382.0f, 107.0f, 422.0f, 146.0f, Path.Direction.CW);
                this.srPath.addRect(379.0f, 13.0f, 460.0f, 74.0f, Path.Direction.CW);
                break;
            case 5:
                this.srPath.addRect(379.0f, 13.0f, 460.0f, 74.0f, Path.Direction.CW);
                break;
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(515.0f, 36.0f, 658.0f, 137.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(196.0f, 37.0f, 344.0f, 118.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(678.0f, 67.0f, (value * 21) + 678, 136.0f, Path.Direction.CW);
        this.srPath.addRect(24.0f, 76.0f, (this.DATA[27] * 21) + 24, 136.0f, Path.Direction.CW);
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
