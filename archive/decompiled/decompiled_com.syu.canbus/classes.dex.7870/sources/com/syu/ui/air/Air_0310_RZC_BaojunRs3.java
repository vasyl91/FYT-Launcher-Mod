package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Air_0310_RZC_BaojunRs3 extends AirBase {
    public Air_0310_RZC_BaojunRs3(Context context) {
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
        if (this.DATA[11] != 0 || this.DATA[53] != 0) {
            this.srPath.addRect(553.0f, 12.0f, 603.0f, 52.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(737.0f, 86.0f, 825.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[14] == 0) {
            this.srPath.addRect(662.0f, 19.0f, 728.0f, 53.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(12.0f);
        if (this.DATA[53] != 0) {
            c.drawText("MAX", 619.0f, 19.0f, this.mPaint);
        } else {
            c.drawText(" ", 619.0f, 19.0f, this.mPaint);
        }
        this.mPaint.setTextSize(22.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 48.0f, 115.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 48.0f, 115.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 48.0f, 115.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 1376566 || DataCanbus.DATA[1000] == 1704246 || DataCanbus.DATA[1000] == 1573174 || DataCanbus.DATA[1000] == 1638710) {
            c.drawText(new StringBuilder().append(temp).toString(), 48.0f, 115.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 48.0f, 115.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 940.0f, 115.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 940.0f, 115.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 940.0f, 115.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 1376566 || DataCanbus.DATA[1000] == 1704246 || DataCanbus.DATA[1000] == 1573174 || DataCanbus.DATA[1000] == 1638710) {
            c.drawText(new StringBuilder().append(temp2).toString(), 940.0f, 115.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 940.0f, 115.0f, this.mPaint);
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
