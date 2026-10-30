package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0319_WC3_15Fucos extends AirBase {
    public Air_0319_WC3_15Fucos(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0319_wc3_15focus/air_wc2_focus_n.webp";
        this.mPathHighlight = "0319_wc3_15focus/air_wc2_focus_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[13] != 0) {
            this.srPath.addRect(211.0f, 25.0f, 314.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(160.0f, 98.0f, 296.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(380.0f, 16.0f, 455.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(395.0f, 64.0f, 443.0f, 89.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(377.0f, 89.0f, 418.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(393.0f, 127.0f, 470.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(500.0f, 16.0f, 653.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(690.0f, 12.0f, 844.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(704.0f, 93.0f, 857.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(48.0f, 18.0f, 133.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(894.0f, 12.0f, 977.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 1) {
            this.srPath.addRect(121.0f, 98.0f, 160.0f, 152.0f, Path.Direction.CW);
            this.srPath.addRect(971.0f, 96.0f, 1016.0f, 151.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(537.0f, 95.0f, (value * 19) + 537, 156.0f, Path.Direction.CW);
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
            c.drawText("LOW", 51.0f, 130.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 51.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 51.0f, 130.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 130.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 920.0f, 130.0f, this.mPaint);
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
