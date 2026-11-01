package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0454_OD_QichenD60EV extends AirBase {
    public Air_0454_OD_QichenD60EV(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0226_fyta_changanyuexiang7/air_rzc_jingyi_x5_n.webp";
        this.mPathHighlight = "0226_fyta_changanyuexiang7/air_rzc_jingyi_x5_p.webp";
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
            this.srPath.addRect(15.0f, 18.0f, 160.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(911.0f, 33.0f, 967.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(222.0f, 97.0f, 328.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(199.0f, 14.0f, 342.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(397.0f, 107.0f, 507.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(732.0f, 91.0f, 830.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(716.0f, 9.0f, 837.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(553.0f, 10.0f, 644.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(561.0f, 85.0f, 627.0f, 113.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(552.0f, 112.0f, 604.0f, 161.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(393.0f, 18.0f, 393.0f + (value * 17.5f), 87.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(15.0f);
        if (this.DATA[53] != 0) {
            c.drawText("MAX", 888.0f, 28.0f, this.mPaint);
        } else {
            c.drawText("", 888.0f, 28.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LO", 66.0f, 147.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 66.0f, 147.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NO", 66.0f, 147.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp).toString(), 66.0f, 147.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 930.0f, 147.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 147.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("NO", 930.0f, 147.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp).toString(), 930.0f, 147.0f, this.mPaint);
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
