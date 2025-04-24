package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0319_WC3_15Fucos extends AirBase {
    public Air_0319_WC3_15Fucos(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0319_wc3_15focus/air_wc2_focus_n.webp";
        this.mPathHighlight = "0319_wc3_15focus/air_wc2_focus_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(211.0f, 25.0f, 314.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(160.0f, 98.0f, 296.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(380.0f, 16.0f, 455.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(395.0f, 64.0f, 443.0f, 89.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(377.0f, 89.0f, 418.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(393.0f, 127.0f, 470.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(500.0f, 16.0f, 653.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(690.0f, 12.0f, 844.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(704.0f, 93.0f, 857.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(48.0f, 18.0f, 133.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(894.0f, 12.0f, 977.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 1) {
            c.clipRect(121.0f, 98.0f, 160.0f, 152.0f, Region.Op.UNION);
            c.clipRect(971.0f, 96.0f, 1016.0f, 151.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(537.0f, 95.0f, (value * 19) + 537, 156.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[17];
        if (temp == -2) {
            c.drawText("LOW", 51.0f, 130.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 51.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 51.0f, 130.0f, this.mPaint);
        }
        int temp2 = this.DATA[23];
        if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 130.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 920.0f, 130.0f, this.mPaint);
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
