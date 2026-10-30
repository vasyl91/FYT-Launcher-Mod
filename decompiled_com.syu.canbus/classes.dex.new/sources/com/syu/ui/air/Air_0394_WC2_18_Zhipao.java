package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0394_WC2_18_Zhipao extends AirBase {
    public Air_0394_WC2_18_Zhipao(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0394_wc2_18_qiyazhipao/air_wc2_qiya_zhipao_n.webp";
        this.mPathHighlight = "0394_wc2_18_qiyazhipao/air_wc2_qiya_zhipao_p.webp";
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
            this.srPath.addRect(16.0f, 102.0f, 155.0f, 165.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(189.0f, 105.0f, 310.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(719.0f, 11.0f, 840.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(196.0f, 16.0f, 306.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[76] != 0) {
            this.srPath.addRect(391.0f, 10.0f, 498.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(738.0f, 108.0f, 813.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(879.0f, 103.0f, 986.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(619.0f, 12.0f, 679.0f, 51.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(592.0f, 55.0f, 641.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(602.0f, 76.0f, 648.0f, 94.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(589.0f, 92.0f, 629.0f, 119.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(601.0f, 127.0f, 685.0f, 157.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(374.0f, 92.0f, (value * 19) + 374, 160.0f, Path.Direction.CW);
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
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 76.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 940.0f, 72.0f, this.mPaint);
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
