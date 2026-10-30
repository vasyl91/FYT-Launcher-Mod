package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0273_RZC_17MingJueRuiTeng extends AirBase {
    public Air_0273_RZC_17MingJueRuiTeng(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0273_rzc_mingjueruiteng/air_rzc_xp1mingjueruiteng17_n.webp";
        this.mPathHighlight = "0273_rzc_mingjueruiteng/air_rzc_xp1mingjueruiteng17_p.webp";
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
            this.srPath.addRect(9.0f, 21.0f, 169.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(908.0f, 22.0f, 968.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(216.0f, 106.0f, 329.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(384.0f, 15.0f, 503.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(721.0f, 12.0f, 827.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(728.0f, 91.0f, 823.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(561.0f, 12.0f, 641.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(588.0f, 134.0f, 644.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(574.0f, 78.0f, 626.0f, 98.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(563.0f, 97.0f, 605.0f, 132.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(199.0f, 22.0f, 346.0f, 78.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value == 15) {
            this.srPath.addRect(424.0f, 91.0f, 485.0f, 111.0f, Path.Direction.CW);
        } else {
            this.srPath.addRect(394.0f, 113.0f, (value * 17) + 394, 158.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 86.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 86.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp).toString(), 86.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 934.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 934.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp).toString(), 934.0f, 152.0f, this.mPaint);
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
