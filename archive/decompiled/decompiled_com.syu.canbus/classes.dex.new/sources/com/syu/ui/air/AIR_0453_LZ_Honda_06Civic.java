package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class AIR_0453_LZ_Honda_06Civic extends AirBase {
    public AIR_0453_LZ_Honda_06Civic(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/lz_06civic_air_n.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/lz_06civic_air_p.webp";
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
            this.srPath.addRect(206.0f, 105.0f, 286.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[79] != 0) {
            this.srPath.addRect(198.0f, 19.0f, 297.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(341.0f, 48.0f, 474.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(537.0f, 31.0f, 600.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(528.0f, 75.0f, 586.0f, 99.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(516.0f, 96.0f, 563.0f, 133.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(102.0f, 102.0f, 159.0f, 154.0f, Path.Direction.CW);
            this.srPath.addRect(960.0f, 101.0f, 1018.0f, 154.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value == 1) {
            this.srPath.addRect(690.0f, 26.0f, 718.0f, 134.0f, Path.Direction.CW);
        } else if (value == 2) {
            this.srPath.addRect(690.0f, 26.0f, 736.0f, 134.0f, Path.Direction.CW);
        } else if (value == 3) {
            this.srPath.addRect(690.0f, 26.0f, 754.0f, 134.0f, Path.Direction.CW);
        } else if (value == 4) {
            this.srPath.addRect(690.0f, 26.0f, 772.0f, 134.0f, Path.Direction.CW);
        } else if (value == 5) {
            this.srPath.addRect(690.0f, 26.0f, 790.0f, 134.0f, Path.Direction.CW);
        } else if (value == 6) {
            this.srPath.addRect(690.0f, 26.0f, 808.0f, 134.0f, Path.Direction.CW);
        } else if (value == 7) {
            this.srPath.addRect(690.0f, 26.0f, 828.0f, 134.0f, Path.Direction.CW);
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
            c.drawText("LO", 58.0f, 74.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 58.0f, 74.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NO", 58.0f, 74.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10) + "." + (left_temp % 10), 58.0f, 74.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 915.0f, 74.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 915.0f, 74.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("NO", 915.0f, 74.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 10) + "." + (right_temp % 10), 915.0f, 74.0f, this.mPaint);
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
