package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0444_wy_audi_q4 extends AirBase {
    public Air_0444_wy_audi_q4(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1920;
        this.mContentHeight = 180;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_wy_audi_q4_n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_wy_audi_q4_p.webp";
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
            this.srPath.addRect(911.0f, 16.0f, 1006.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(1102.0f, 16.0f, 1203.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(905.0f, 109.0f, 1010.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(690.0f, 8.0f, 789.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(476.0f, 37.0f, 549.0f, 59.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(496.0f, 60.0f, 534.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(506.0f, 81.0f, 540.0f, 99.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(510.0f, 99.0f, 564.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[50] != 0) {
            this.srPath.addRect(1372.0f, 36.0f, 1438.0f, 60.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(1391.0f, 60.0f, 1428.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(1402.0f, 80.0f, 1438.0f, 97.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(1406.0f, 99.0f, 1451.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[29] != 0) {
            this.srPath.addRect(176.0f, 72.0f, 241.0f, 139.0f, Path.Direction.CW);
        }
        if (this.DATA[30] != 0) {
            this.srPath.addRect(1665.0f, 71.0f, 1751.0f, 137.0f, Path.Direction.CW);
        }
        if (this.DATA[31] != 0) {
            this.srPath.addRect(286.0f, 74.0f, 352.0f, 139.0f, Path.Direction.CW);
        }
        if (this.DATA[32] != 0) {
            this.srPath.addRect(1563.0f, 70.0f, 1640.0f, 138.0f, Path.Direction.CW);
        }
        switch (this.DATA[29]) {
            case 1:
                this.srPath.addRect(180.0f, 141.0f, 198.0f, 151.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(180.0f, 141.0f, 215.0f, 151.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(180.0f, 141.0f, 234.0f, 151.0f, Path.Direction.CW);
                break;
        }
        switch (this.DATA[30]) {
            case 1:
                this.srPath.addRect(1683.0f, 139.0f, 1704.0f, 151.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(1683.0f, 139.0f, 1721.0f, 151.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(1683.0f, 139.0f, 1745.0f, 151.0f, Path.Direction.CW);
                break;
        }
        switch (this.DATA[31]) {
            case 1:
                this.srPath.addRect(290.0f, 141.0f, 309.0f, 151.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(290.0f, 141.0f, 326.0f, 151.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(290.0f, 141.0f, 346.0f, 151.0f, Path.Direction.CW);
                break;
        }
        switch (this.DATA[32]) {
            case 1:
                this.srPath.addRect(1575.0f, 140.0f, 1593.0f, 151.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(1575.0f, 140.0f, 1612.0f, 151.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(1575.0f, 140.0f, 1633.0f, 151.0f, Path.Direction.CW);
                break;
        }
        if (this.DATA[37] == 1) {
            this.srPath.addRect(110.0f, 97.0f, 161.0f, 138.0f, Path.Direction.CW);
            this.srPath.addRect(1861.0f, 96.0f, 1906.0f, 140.0f, Path.Direction.CW);
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
        int temp = this.DATA[21];
        c.drawText(new StringBuilder().append(temp).toString(), 843.0f, 145.0f, this.mPaint);
        int temp2 = this.DATA[77];
        c.drawText(new StringBuilder().append(temp2).toString(), 703.0f, 145.0f, this.mPaint);
        int temp3 = this.DATA[25];
        c.drawText(new StringBuilder().append(temp3).toString(), 1145.0f, 145.0f, this.mPaint);
        int temp4 = this.DATA[87];
        c.drawText(new StringBuilder().append(temp4).toString(), 1282.0f, 145.0f, this.mPaint);
        this.mPaint.setTextSize(40.0f);
        int temp5 = this.DATA[27];
        if (temp5 == -2) {
            c.drawText("LO", 65.0f, 126.0f, this.mPaint);
        } else if (temp5 == -3) {
            c.drawText("HI", 65.0f, 126.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp5).toString(), 65.0f, 126.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp5 / 2.0f).toString(), 65.0f, 126.0f, this.mPaint);
        }
        int temp6 = this.DATA[28];
        if (temp6 == -2) {
            c.drawText("LO", 1813.0f, 126.0f, this.mPaint);
        } else if (temp6 == -3) {
            c.drawText("HI", 1813.0f, 126.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp6).toString(), 1813.0f, 126.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp6 / 2.0f).toString(), 1813.0f, 126.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1920.0f, TheApp.getScreenHeight() / 1200.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
