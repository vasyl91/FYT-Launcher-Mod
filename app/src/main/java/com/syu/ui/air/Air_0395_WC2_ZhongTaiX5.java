package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

public class Air_0395_WC2_ZhongTaiX5 extends AirBase {
    public Air_0395_WC2_ZhongTaiX5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_zhongtai_x5.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_zhongtai_x5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(12.0f, 21.0f, 158.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(332.0f, 15.0f, 426.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(213.0f, 48.0f, 280.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(888.0f, 13.0f, 987.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(890.0f, 92.0f, 991.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(342.0f, 82.0f, 410.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(336.0f, 113.0f, 393.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(691.0f, 37.0f, 832.0f, 134.0f, Region.Op.UNION);
        }
        int value = this.DATA[39];
        c.clipRect(508.0f, 44.0f, (value * 19) + ConstRzcAddData.U_CAR_LIGHT_REAR, 140.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 76.0f, 152.0f, this.mPaint);
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
