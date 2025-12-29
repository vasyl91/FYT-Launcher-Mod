package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.SystemProperties;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_OD_Cadillac_Escalade extends AirBase {
    public Air_0452_OD_Cadillac_Escalade(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0452_od_escalade/air_od_escalade.webp";
        this.mPathHighlight = "0452_od_escalade/air_od_escalade_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.save();
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[15] != 0) {
            c.clipRect(162.0f, 26.0f, 268.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0 || this.DATA[14] != 0) {
            c.clipRect(537.0f, 45.0f, 584.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(586.0f, 42.0f, 606.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(607.0f, 40.0f, 634.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(434.0f, 31.0f, 536.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(665.0f, 27.0f, 721.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(154.0f, 106.0f, 281.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(782.0f, 11.0f, 864.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(785.0f, 98.0f, 860.0f, 148.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[24], 0, 3);
        this.mRectTmp.set(57, 138, (value * 21) + 57, 160);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        int value2 = ToolkitMath.clamp(this.DATA[25], 0, 3);
        this.mRectTmp.set(953, 138, (value2 * 21) + 953, 161);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        if (this.DATA[18] != 0) {
            c.clipRect(319.0f, 25.0f, 336.0f, 49.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(340.0f, 49.0f, 367.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(320.0f, 64.0f, 340.0f, 88.0f, Region.Op.UNION);
        }
        int value3 = ToolkitMath.clamp(this.DATA[21], 0, 7);
        this.mRectTmp.set(433, 110, (value3 * 38) + 433, 154);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        this.mPaint.setTextSize(30.0f);
        int value4 = ToolkitMath.clamp(this.DATA[22], 0, 255);
        if (value4 == 0) {
            c.drawText("LOW", 71.0f, 60.0f, this.mPaint);
        } else if (value4 == 31) {
            c.drawText("HIGH", 71.0f, 60.0f, this.mPaint);
        } else if (value4 >= 1 && value4 <= 29) {
            if (tempunit == 1) {
                c.drawText((((value4 * 9) + 635) / 10.0f) + " ℉", 71.0f, 60.0f, this.mPaint);
            } else {
                c.drawText((((value4 * 5) + 175) / 10.0f) + " ℃", 71.0f, 60.0f, this.mPaint);
            }
        } else {
            c.drawText("NONE", 71.0f, 60.0f, this.mPaint);
        }
        int value5 = ToolkitMath.clamp(this.DATA[23], 0, 255);
        if (value5 == 0) {
            c.drawText("LOW", 960.0f, 60.0f, this.mPaint);
        } else if (value5 == 31) {
            c.drawText("HIGH", 960.0f, 60.0f, this.mPaint);
        } else if (value5 >= 1 && value5 <= 29) {
            if (tempunit == 1) {
                c.drawText((((value5 * 9) + 635) / 10.0f) + " ℉", 960.0f, 60.0f, this.mPaint);
            } else {
                c.drawText((((value5 * 5) + 175) / 10.0f) + " ℃", 960.0f, 60.0f, this.mPaint);
            }
        } else {
            c.drawText("NONE", 960.0f, 60.0f, this.mPaint);
        }
        c.restore();
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
