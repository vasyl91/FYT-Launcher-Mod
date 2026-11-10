package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_XC_Xiandai_Suolantuo extends AirBase {
    public Air_0439_XC_Xiandai_Suolantuo(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0355_xp_qiyak5/air_xp_qiya_k5_n.webp";
        this.mPathHighlight = "0355_xp_qiyak5/air_xp_qiya_k5_p.webp";
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
            this.srPath.addRect(190.0f, 18.0f, 341.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(212.0f, 109.0f, 303.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(25.0f, 106.0f, 146.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(895.0f, 106.0f, 1006.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(536.0f, 32.0f, 661.0f, 137.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(384.0f, 52.0f, 432.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(398.0f, 76.0f, 447.0f, 92.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(387.0f, 92.0f, 423.0f, 123.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(701.0f, 95.0f, 842.0f, 159.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(712.0f, 19.0f, (value * 18) + 712, 79.0f, Path.Direction.CW);
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
            c.drawText("LO", 70.0f, 55.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 70.0f, 55.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("No", 70.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 2.0f).toString(), 70.0f, 55.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 930.0f, 55.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 55.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("No", 930.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp / 2.0f).toString(), 930.0f, 55.0f, this.mPaint);
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
