package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0454_OD_Shanqi_Zhongka_All extends AirBase {
    public Air_0454_OD_Shanqi_Zhongka_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0443_wc2_tata/air_od_shanqi_n.webp";
        this.mPathHighlight = "0443_wc2_tata/air_od_shanqi_p.webp";
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
            this.srPath.addRect(337.0f, 14.0f, 468.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(165.0f, 102.0f, 261.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(715.0f, 22.0f, 830.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(551.0f, 24.0f, 620.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(551.0f, 101.0f, 624.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(738.0f, 102.0f, 806.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(150.0f, 21.0f, 282.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(899.0f, 103.0f, 932.0f, 133.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(909.0f, 89.0f, 949.0f, 104.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(899.0f, 44.0f, 960.0f, 89.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        switch (value) {
            case 1:
                this.srPath.addRect(340.0f, 93.0f, 355.0f, 155.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(340.0f, 93.0f, 371.0f, 155.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(340.0f, 93.0f, 388.0f, 155.0f, Path.Direction.CW);
                break;
            case 4:
                this.srPath.addRect(340.0f, 93.0f, 403.0f, 155.0f, Path.Direction.CW);
                break;
            case 5:
                this.srPath.addRect(340.0f, 93.0f, 419.0f, 155.0f, Path.Direction.CW);
                break;
            case 6:
                this.srPath.addRect(340.0f, 93.0f, 435.0f, 155.0f, Path.Direction.CW);
                break;
            case 7:
                this.srPath.addRect(340.0f, 93.0f, 451.0f, 155.0f, Path.Direction.CW);
                break;
            case 8:
                this.srPath.addRect(340.0f, 93.0f, 468.0f, 155.0f, Path.Direction.CW);
                break;
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
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LO", 52.0f, 117.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 52.0f, 117.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NO", 52.0f, 117.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10) + "." + (temp % 10), 52.0f, 117.0f, this.mPaint);
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
