package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Air_0439_RZC_Jianghuai_All extends AirBase {
    public Air_0439_RZC_Jianghuai_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 140;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_rzc_jianghuai/air_all_type0_n.webp";
        this.mPathHighlight = "0439_rzc_jianghuai/air_all_type0_p.webp";
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
        if (this.DATA[21] != 0) {
            this.srPath.addRect(401.0f, 11.0f, 514.0f, 55.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(539.0f, 1.0f, 617.0f, 60.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(737.0f, 86.0f, 825.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(281.0f, 8.0f, 376.0f, 58.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(485.0f, 77.0f, 529.0f, 98.0f, Path.Direction.CW);
            this.srPath.addRect(230.0f, 85.0f, 291.0f, 130.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(505.0f, 99.0f, 536.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(513.0f, 111.0f, 540.0f, 129.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(346.0f, 83.0f, 409.0f, 129.0f, Path.Direction.CW);
        }
        if (this.DATA[29] != 0) {
            this.srPath.addRect(47.0f, 16.0f, 99.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[30] != 0) {
            this.srPath.addRect(925.0f, 13.0f, 985.0f, 66.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[21];
        c.drawText(new StringBuilder(String.valueOf(value)).toString(), 672.0f, 114.0f, this.mPaint);
        int value2 = this.DATA[29];
        c.drawText(new StringBuilder(String.valueOf(value2)).toString(), 106.0f, 51.0f, this.mPaint);
        int value3 = this.DATA[30];
        c.drawText(new StringBuilder(String.valueOf(value3)).toString(), 911.0f, 51.0f, this.mPaint);
        this.mPaint.setTextSize(22.0f);
        int temp2 = this.DATA[27];
        if (temp2 == -1) {
            c.drawText("NO", 48.0f, 115.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 48.0f, 115.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 48.0f, 115.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 10879428 || DataCanbus.DATA[1000] == 10944964) {
                temp = ((temp2 - 128) * 5) + 160;
            } else {
                temp = (temp2 * 5) + 170;
            }
            c.drawText(new StringBuilder(String.valueOf(temp / 10.0f)).toString(), 48.0f, 115.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == -1) {
            c.drawText("NO", 940.0f, 115.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LO", 940.0f, 115.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 940.0f, 115.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 10879428 || DataCanbus.DATA[1000] == 10944964) {
                temp1 = ((temp3 - 128) * 5) + 160;
            } else {
                temp1 = (temp3 * 5) + 170;
            }
            c.drawText(new StringBuilder(String.valueOf(temp1 / 10.0f)).toString(), 940.0f, 115.0f, this.mPaint);
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
