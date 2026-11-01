package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0443_WC_nissan_ruiqi extends AirBase {
    public Air_0443_WC_nissan_ruiqi(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0172_xbs_xp1_changchengfengjun6/air_wc2_nissan_ruiqi_n.webp";
        this.mPathHighlight = "0172_xbs_xp1_changchengfengjun6/air_wc2_nissan_ruiqi_p.webp";
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
        if (this.DATA[12] == 0) {
            this.srPath.addRect(165.0f, 53.0f, 305.0f, 130.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(32.0f, 106.0f, 129.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(881.0f, 36.0f, 1010.0f, 86.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(915.0f, 86.0f, 1010.0f, 106.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(887.0f, 108.0f, 1010.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(320.0f, 54.0f, 472.0f, 119.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(506.0f, 36.0f, 629.0f, 146.0f, Path.Direction.CW);
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
        int value = this.DATA[21];
        c.drawText(new StringBuilder().append(value).toString(), 769.0f, 104.0f, this.mPaint);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_446_WC2_Dongfeng_25Tangguo /* 328126 */:
                if (temp <= 3) {
                    c.drawText("COLD " + temp, 65.0f, 58.0f, this.mPaint);
                } else if (temp <= 6) {
                    c.drawText("HOT " + (temp - 3), 65.0f, 58.0f, this.mPaint);
                } else {
                    c.drawText("----", 65.0f, 58.0f, this.mPaint);
                }
                break;
            default:
                if (temp == -1) {
                    c.drawText("NO", 65.0f, 58.0f, this.mPaint);
                } else if (temp == -2) {
                    c.drawText("LO", 65.0f, 58.0f, this.mPaint);
                } else if (temp == -3) {
                    c.drawText("HI", 65.0f, 58.0f, this.mPaint);
                } else {
                    c.drawText((temp * 0.5f) + " ℃", 65.0f, 58.0f, this.mPaint);
                }
                break;
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
