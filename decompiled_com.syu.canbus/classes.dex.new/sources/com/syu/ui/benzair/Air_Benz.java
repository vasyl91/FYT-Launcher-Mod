package com.syu.ui.benzair;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToolkitRes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_Benz extends Air_BenzBase {
    public Air_Benz(Context context) {
        super(context);
    }

    @Override // com.syu.ui.benzair.Air_BenzBase
    protected void initSize() {
        this.mContentWidth = 1280;
        this.mContentHeight = 110;
    }

    @Override // com.syu.ui.benzair.Air_BenzBase
    protected void initDrawable() {
        this.mPathNormal = "0450_benz_air/benz_air_null.png";
        this.mPathHighlight1 = "0450_benz_air/benz_air_highlight1.png";
        this.mPathHighlight2 = "0450_benz_air/benz_air_highlight2.png";
        this.mPathHighlight3 = "0450_benz_air/benz_air_highlight3.png";
        this.mDrawableNormal = ToolkitRes.loadDrawable(this.mPathNormal);
        this.mDrawableHighlight1 = ToolkitRes.loadDrawable(this.mPathHighlight1);
        this.mDrawableHighlight2 = ToolkitRes.loadDrawable(this.mPathHighlight2);
        this.mDrawableHighlight3 = ToolkitRes.loadDrawable(this.mPathHighlight3);
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
        if (DataCanbus.DATA[27] == -1 && DataCanbus.DATA[28] == -1) {
            this.mPath.op(this.srPath, Path.Op.UNION);
            c.clipPath(this.mPath);
            this.mDrawableNormal.draw(c);
            c.restore();
            this.srPath.reset();
            this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
            this.mPath.op(this.srPath, Path.Op.XOR);
            c.clipRect(this.mRectDrawable);
            c.clipPath(this.mPath);
            this.mDrawableNormal.draw(c);
            this.mPaint.setTextSize(30.0f);
            c.drawText("OFF", 80.0f, 82.0f, this.mPaint);
        } else if (this.DATA[65] != 0) {
            this.mPath.op(this.srPath, Path.Op.UNION);
            c.clipPath(this.mPath);
            this.mDrawableHighlight3.draw(c);
            c.restore();
            this.srPath.reset();
            this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
            this.mPath.op(this.srPath, Path.Op.XOR);
            c.clipRect(this.mRectDrawable);
            c.clipPath(this.mPath);
            this.mDrawableHighlight3.draw(c);
        } else {
            this.srPath.addRect(778.0f, 42.0f, 832.0f, 94.0f, Path.Direction.CW);
            if (this.DATA[12] == 0) {
                this.srPath.addRect(368.0f, 43.0f, 462.0f, 94.0f, Path.Direction.CW);
            }
            if (this.DATA[11] != 0) {
                this.srPath.addRect(186.0f, 35.0f, 265.0f, 98.0f, Path.Direction.CW);
            }
            if (this.DATA[49] == 0) {
                if (this.DATA[18] != 0) {
                    this.srPath.addRect(976.0f, 34.0f, 1019.0f, 64.0f, Path.Direction.CW);
                }
                if (this.DATA[19] != 0) {
                    this.srPath.addRect(1007.0f, 61.0f, 1023.0f, 75.0f, Path.Direction.CW);
                }
                if (this.DATA[20] != 0) {
                    this.srPath.addRect(991.0f, 69.0f, 1007.0f, 91.0f, Path.Direction.CW);
                }
            }
            this.mPath.op(this.srPath, Path.Op.UNION);
            c.clipPath(this.mPath);
            this.mDrawableHighlight1.draw(c);
            c.restore();
            this.srPath.reset();
            this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
            this.mPath.op(this.srPath, Path.Op.XOR);
            c.clipRect(this.mRectDrawable);
            c.clipPath(this.mPath);
            this.mDrawableHighlight2.draw(c);
            int value = this.DATA[21];
            if (value > 0 && value <= 8) {
                this.mPaint.setTextSize(25.0f);
                c.drawText(new StringBuilder().append(value).toString(), 848.0f, 75.0f, this.mPaint);
            } else if (value == 15) {
                this.mPaint.setTextSize(20.0f);
                c.drawText("AUTO", 868.0f, 75.0f, this.mPaint);
            }
            this.mPaint.setTextSize(20.0f);
            if (this.DATA[49] != 0) {
                c.drawText("AUTO", 990.0f, 75.0f, this.mPaint);
            }
            this.mPaint.setTextSize(30.0f);
            int temp = this.DATA[27];
            if (temp == -2) {
                c.drawText("LO", 80.0f, 82.0f, this.mPaint);
            } else if (temp == -3) {
                c.drawText("HI", 80.0f, 82.0f, this.mPaint);
            } else {
                c.drawText((temp / 2.0f) + " ℃", 80.0f, 82.0f, this.mPaint);
            }
            int temp2 = this.DATA[28];
            if (temp2 == -2) {
                c.drawText("LO", 1200.0f, 82.0f, this.mPaint);
            } else if (temp2 == -3) {
                c.drawText("HI", 1200.0f, 82.0f, this.mPaint);
            } else {
                c.drawText((temp2 / 2.0f) + " ℃", 1200.0f, 82.0f, this.mPaint);
            }
        }
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
