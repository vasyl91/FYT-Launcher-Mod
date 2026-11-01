package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_Bnr_RongweiRx5 extends AirBase {
    public Air_0439_Bnr_RongweiRx5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0273_rzc_mingjueruiteng/air_rzc_xp1mingjueruiteng_n.webp";
        this.mPathHighlight = "0273_rzc_mingjueruiteng/air_rzc_xp1mingjueruiteng_p.webp";
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
            this.srPath.addRect(20.0f, 26.0f, 163.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(899.0f, 16.0f, 971.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(888.0f, 102.0f, 994.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(713.0f, 12.0f, 807.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(719.0f, 95.0f, 810.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(539.0f, 9.0f, 620.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(557.0f, 71.0f, 616.0f, 98.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(543.0f, 95.0f, 587.0f, 138.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(193.0f, 47.0f, 325.0f, 124.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value == 15) {
            this.srPath.addRect(406.0f, 123.0f, 473.0f, 146.0f, Path.Direction.CW);
        } else {
            this.srPath.addRect(376.0f, 61.0f, (value * 18) + 376, 115.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27] & 127;
        int flag = this.DATA[56];
        if (flag == 0) {
            if (left_temp == 1) {
                c.drawText("LOW", 70.0f, 142.0f, this.mPaint);
            } else if (left_temp == 15) {
                c.drawText("HI", 70.0f, 142.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(left_temp + 15).toString(), 70.0f, 142.0f, this.mPaint);
            }
        } else if (left_temp == 0) {
            c.drawText("LOW", 70.0f, 142.0f, this.mPaint);
        } else if (left_temp == 31) {
            c.drawText("HI", 70.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp + 17).toString(), 70.0f, 142.0f, this.mPaint);
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
