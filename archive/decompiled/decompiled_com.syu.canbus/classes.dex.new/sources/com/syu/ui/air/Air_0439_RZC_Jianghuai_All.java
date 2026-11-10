package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_RZC_Jianghuai_All extends AirBase {
    public Air_0439_RZC_Jianghuai_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_rzc_jianghuai/rzc_jianghuai.webp";
        this.mPathHighlight = "0439_rzc_jianghuai/rzc_jianghuai_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int temp;
        int temp1;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[11] != 0) {
            this.srPath.addRect(739.0f, 107.0f, 798.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(710.0f, 14.0f, 835.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(882.0f, 108.0f, 996.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(570.0f, 18.0f, 649.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(586.0f, 86.0f, 635.0f, 108.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(576.0f, 107.0f, 614.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(198.0f, 53.0f, 317.0f, 143.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        if (value != 0) {
            this.srPath.addRect(15.0f, 95.0f, 168.0f, 150.0f, Path.Direction.CW);
        }
        this.srPath.addRect(374.0f, 45.0f, (value * 19) + 374, 121.0f, Path.Direction.CW);
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
        int temp2 = this.DATA[27];
        if (temp2 == -1) {
            c.drawText("NO", 73.0f, 57.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 73.0f, 57.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 73.0f, 57.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 10879428 || DataCanbus.DATA[1000] == 10944964) {
                temp = ((temp2 - 128) * 5) + 160;
            } else {
                temp = (temp2 * 5) + 170;
            }
            c.drawText(new StringBuilder(String.valueOf(temp / 10.0f)).toString(), 73.0f, 57.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == -1) {
            c.drawText("NO", 924.0f, 57.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LO", 924.0f, 57.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 924.0f, 57.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 10879428 || DataCanbus.DATA[1000] == 10944964) {
                temp1 = ((temp3 - 128) * 5) + 160;
            } else {
                temp1 = (temp3 * 5) + 170;
            }
            c.drawText(new StringBuilder(String.valueOf(temp1 / 10.0f)).toString(), 924.0f, 57.0f, this.mPaint);
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
