package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.util.ToolkitMath;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0025_DJ_Saiou3 extends AirBase {
    private int nWindLevelLeft;

    public Air_0025_DJ_Saiou3(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0025_dj_parkavenue/dj_saiou3.webp";
        this.mPathHighlight = "0025_dj_parkavenue/dj_saiou3_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        boolean invalidate = false;
        c.clipRect(this.mRectEmpty);
        if (this.DATA[107] != 0) {
            c.clipRect(14.0f, 103.0f, 162.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(697.0f, 46.0f, 842.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[110] != 0) {
            c.clipRect(358.0f, 131.0f, 430.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(890.0f, 14.0f, 1003.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[92] != 0) {
            c.clipRect(203.0f, 43.0f, 314.0f, 136.0f, Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(880.0f, 97.0f, 996.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[99] != 0) {
            c.clipRect(379.0f, 45.0f, 428.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(387.0f, 76.0f, 445.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(381.0f, 92.0f, 420.0f, 125.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[102], 0, 8);
        if (this.nWindLevelLeft != value) {
            invalidate = true;
            if (this.nWindLevelLeft < value) {
                this.nWindLevelLeft++;
            } else {
                this.nWindLevelLeft--;
            }
        }
        c.clipRect(558.0f, 79.0f, (value * 18) + ConstRzcAddData.U_DOOR_BACK_ADD, 130.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = ToolkitMath.clamp(this.DATA[97], 0, 310);
        switch (value2) {
            case 0:
                c.drawText("LOW", 69.0f, 68.0f, this.mPaint);
                break;
            case 30:
                c.drawText("HIGH", 69.0f, 68.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value2 / 10.0f)), 69.0f, 68.0f, this.mPaint);
                break;
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (invalidate) {
            invalidate();
        }
    }
}
