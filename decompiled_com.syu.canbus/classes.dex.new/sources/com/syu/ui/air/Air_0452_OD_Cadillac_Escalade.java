package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_OD_Cadillac_Escalade extends AirBase {
    public Air_0452_OD_Cadillac_Escalade(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_od_escalade/air_od_escalade.webp";
        this.mPathHighlight = "0452_od_escalade/air_od_escalade_p.webp";
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
        if (this.DATA[14] != 0) {
            this.srPath.addRect(162.0f, 26.0f, 268.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0 || this.DATA[26] != 0) {
            this.srPath.addRect(537.0f, 45.0f, 584.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[26] != 0) {
            this.srPath.addRect(586.0f, 42.0f, 606.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(607.0f, 40.0f, 634.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(434.0f, 31.0f, 536.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(665.0f, 27.0f, 721.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(154.0f, 106.0f, 281.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(782.0f, 11.0f, 864.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(785.0f, 98.0f, 860.0f, 148.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[29], 0, 3);
        this.mRectTmp.set(57.0f, 138.0f, (value * 21) + 57, 160.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        int value2 = ToolkitMath.clamp(this.DATA[30], 0, 3);
        this.mRectTmp.set(953.0f, 138.0f, (value2 * 21) + 953, 161.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        if (this.DATA[18] != 0) {
            this.srPath.addRect(319.0f, 25.0f, 336.0f, 49.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(340.0f, 49.0f, 367.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(320.0f, 64.0f, 340.0f, 88.0f, Path.Direction.CW);
        }
        int value3 = ToolkitMath.clamp(this.DATA[21], 0, 7);
        this.mRectTmp.set(433.0f, 110.0f, (value3 * 38) + 433, 154.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
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
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        this.mPaint.setTextSize(30.0f);
        int value4 = ToolkitMath.clamp(this.DATA[27], 0, 255);
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
        int value5 = ToolkitMath.clamp(this.DATA[28], 0, 255);
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
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
