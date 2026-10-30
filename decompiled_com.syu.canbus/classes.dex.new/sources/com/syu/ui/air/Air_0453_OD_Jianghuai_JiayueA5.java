package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0453_OD_Jianghuai_JiayueA5 extends AirBase {
    public Air_0453_OD_Jianghuai_JiayueA5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_audia6/air_od_bmw_nbt_n.webp";
        this.mPathHighlight = "0439_oudi_audia6/air_od_bmw_nbt_p.webp";
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
            this.srPath.addRect(442.0f, 105.0f, 564.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(914.0f, 94.0f, 999.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(154.0f, 22.0f, 244.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(307.0f, 82.0f, 347.0f, 97.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(304.0f, 35.0f, 361.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(308.0f, 96.0f, 335.0f, 122.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(46.0f, 139.0f, 97.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(447.0f, 17.0f, 553.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(628.0f, 104.0f, 715.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(628.0f, 12.0f, 711.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(776.0f, 22.0f, 872.0f, 67.0f, Path.Direction.CW);
        }
        int value = this.DATA[29];
        this.srPath.addRect(204.0f, 132.0f, (value * 14) + 204, 147.0f, Path.Direction.CW);
        this.srPath.addRect(821 - (value * 14), 135.0f, 821.0f, 151.0f, Path.Direction.CW);
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
        c.drawText(new StringBuilder(String.valueOf(this.DATA[21])).toString(), 74.0f, 135.0f, this.mPaint);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 43.0f, 61.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 43.0f, 61.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 43.0f, 61.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp)).toString(), 43.0f, 61.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 945.0f, 61.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 945.0f, 61.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 945.0f, 61.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp2)).toString(), 945.0f, 61.0f, this.mPaint);
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
