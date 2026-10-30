package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class AIR_0265_RZC_ZhongTaiDaMaiX5 extends AirBase {
    public AIR_0265_RZC_ZhongTaiDaMaiX5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/air_rzc_zhongtai_damaix5.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/air_rzc_zhongtai_damaix5_p.webp";
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
        if (this.DATA[11] != 0) {
            this.srPath.addRect(892.0f, 98.0f, 1001.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(17.0f, 100.0f, 151.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(724.0f, 13.0f, 813.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(195.0f, 33.0f, 313.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(360.0f, 37.0f, 423.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(371.0f, 74.0f, 443.0f, 93.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(358.0f, 93.0f, 411.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(699.0f, 94.0f, 838.0f, 154.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(549.0f, 49.0f, (value * 18) + 549, 124.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else if (DataCanbus.DATA[37] == 0) {
            c.drawText(new StringBuilder().append(left_temp).toString(), 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp + 17) + "   ℃", 76.0f, 72.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (DataCanbus.DATA[1000] == 65801) {
            right_temp = this.DATA[27];
        }
        if (right_temp == -2) {
            c.drawText("LOW", 940.0f, 72.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 940.0f, 72.0f, this.mPaint);
        } else if (DataCanbus.DATA[37] == 0) {
            c.drawText(new StringBuilder().append(right_temp).toString(), 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp + 17) + "   ℃", 940.0f, 72.0f, this.mPaint);
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
