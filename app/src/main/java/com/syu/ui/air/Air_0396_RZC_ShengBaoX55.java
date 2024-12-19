package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0396_RZC_ShengBaoX55 extends AirBase {
    public Air_0396_RZC_ShengBaoX55(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0396_rzc_shenbao/air_shenbao_x55.webp";
        this.mPathHighlight = "0396_rzc_shenbao/air_shenbao_x55_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(870.0f, 102.0f, 1009.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(35.0f, 11.0f, 139.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(721.0f, 15.0f, 819.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(735.0f, 94.0f, 817.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(360.0f, 11.0f, 455.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(375.0f, 80.0f, 441.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(361.0f, 113.0f, 413.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(185.0f, 12.0f, 334.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(882.0f, 16.0f, 975.0f, 73.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        c.clipRect(519.0f, 61.0f, (value * 20) + ConstRzcAddData.U_CAR_HANDBRAKE, 131.0f, Region.Op.UNION);
        int value2 = this.DATA[21];
        c.clipRect(17.0f, 98.0f, (value2 * 22) + 17, 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
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
