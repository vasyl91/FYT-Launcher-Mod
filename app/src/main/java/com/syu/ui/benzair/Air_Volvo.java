package com.syu.ui.benzair;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToolkitRes;

public class Air_Volvo extends Air_BenzBase {
    public Air_Volvo(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1280;
        this.mContentHeight = 110;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0450_benz_air/volvo_air_null.png";
        this.mPathHighlight1 = "0450_benz_air/volvo_air_highlight1.png";
        this.mPathHighlight2 = "0450_benz_air/volvo_air_highlight2.png";
        this.mPathHighlight3 = "0450_benz_air/volvo_air_highlight3.png";
        this.mDrawableNormal = ToolkitRes.loadDrawable(this.mPathNormal);
        this.mDrawableHighlight1 = ToolkitRes.loadDrawable(this.mPathHighlight1);
        this.mDrawableHighlight2 = ToolkitRes.loadDrawable(this.mPathHighlight2);
        this.mDrawableHighlight3 = ToolkitRes.loadDrawable(this.mPathHighlight3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (DataCanbus.DATA[23] == -1 && DataCanbus.DATA[24] == -1) {
            this.mDrawableNormal.draw(c);
            c.clipRect(this.mRectDrawable, Region.Op.XOR);
            this.mDrawableNormal.draw(c);
            this.mPaint.setTextSize(30.0f);
            c.drawText("OFF", 80.0f, 82.0f, this.mPaint);
        } else if (this.DATA[38] != 0) {
            this.mDrawableHighlight3.draw(c);
            c.clipRect(this.mRectDrawable, Region.Op.XOR);
            this.mDrawableHighlight3.draw(c);
        } else {
            c.clipRect(765.0f, 48.0f, 812.0f, 93.0f, Region.Op.UNION);
            if (this.DATA[35] == 0) {
                c.clipRect(420.0f, 47.0f, 497.0f, 92.0f, Region.Op.UNION);
            }
            if (this.DATA[37] != 0) {
                c.clipRect(286.0f, 51.0f, 358.0f, 88.0f, Region.Op.UNION);
            }
            if (this.DATA[28] == 0) {
                if (this.DATA[25] != 0) {
                    c.clipRect(890.0f, 40.0f, 931.0f, 64.0f, Region.Op.UNION);
                }
                if (this.DATA[26] != 0) {
                    c.clipRect(920.0f, 62.0f, 940.0f, 76.0f, Region.Op.UNION);
                }
                if (this.DATA[27] != 0) {
                    c.clipRect(903.0f, 73.0f, 922.0f, 92.0f, Region.Op.UNION);
                }
            }
            if (this.DATA[67] != 0) {
                c.clipRect(160.0f, 39.0f, 205.0f, 87.0f, Region.Op.UNION);
                int temp = this.DATA[67];
                if (temp == 1) {
                    c.clipRect(163.0f, 86.0f, 174.0f, 98.0f, Region.Op.UNION);
                } else if (temp == 2) {
                    c.clipRect(163.0f, 86.0f, 185.0f, 98.0f, Region.Op.UNION);
                } else if (temp == 3) {
                    c.clipRect(163.0f, 86.0f, 199.0f, 98.0f, Region.Op.UNION);
                }
            }
            if (this.DATA[68] != 0) {
                c.clipRect(1046.0f, 43.0f, 1093.0f, 89.0f, Region.Op.UNION);
                int temp2 = this.DATA[68];
                if (temp2 == 1) {
                    c.clipRect(1053.0f, 89.0f, 1067.0f, 100.0f, Region.Op.UNION);
                } else if (temp2 == 2) {
                    c.clipRect(1053.0f, 89.0f, 1078.0f, 100.0f, Region.Op.UNION);
                } else if (temp2 == 3) {
                    c.clipRect(1053.0f, 89.0f, 1089.0f, 100.0f, Region.Op.UNION);
                }
            }
            this.mDrawableHighlight1.draw(c);
            c.clipRect(this.mRectDrawable, Region.Op.XOR);
            this.mDrawableHighlight2.draw(c);
            int value = this.DATA[33];
            if (value > 0 && value <= 18) {
                this.mPaint.setTextSize(20.0f);
                c.drawText(String.valueOf(value), 835.0f, 74.0f, this.mPaint);
            } else if (value == 255) {
                this.mPaint.setTextSize(15.0f);
                c.drawText("AUTO", 840.0f, 75.0f, this.mPaint);
            }
            this.mPaint.setTextSize(15.0f);
            if (this.DATA[28] != 0) {
                c.drawText("AUTO", 900.0f, 75.0f, this.mPaint);
            }
            this.mPaint.setTextSize(30.0f);
            int temp3 = this.DATA[23];
            if (temp3 == -2) {
                c.drawText("LO", 80.0f, 82.0f, this.mPaint);
            } else if (temp3 == -3) {
                c.drawText("HI", 80.0f, 82.0f, this.mPaint);
            } else {
                c.drawText((temp3 / 2.0f) + " ℃", 80.0f, 82.0f, this.mPaint);
            }
            int temp4 = this.DATA[24];
            if (temp4 == -2) {
                c.drawText("LO", 1200.0f, 82.0f, this.mPaint);
            } else if (temp4 == -3) {
                c.drawText("HI", 1200.0f, 82.0f, this.mPaint);
            } else {
                c.drawText((temp4 / 2.0f) + " ℃", 1200.0f, 82.0f, this.mPaint);
            }
        }
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
