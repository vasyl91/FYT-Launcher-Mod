package com.syu.ui.benzair;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToolkitRes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class SHow_Benz extends Show_BenzBase {
    private RectF config;
    boolean touch;

    public SHow_Benz(Context context) {
        super(context);
        this.config = new RectF(548.0f, 257.0f, 729.0f, 309.0f);
        this.touch = false;
    }

    @Override // com.syu.ui.benzair.Show_BenzBase
    protected void initSize() {
        this.mContentWidth = 1280;
        this.mContentHeight = 420;
    }

    @Override // com.syu.ui.benzair.Show_BenzBase
    protected void initDrawable() {
        this.mPathNormal = "parking/zhtd_Benz/parking_001.png";
        this.mPathHighlight1 = "parking/zhtd_Benz/parking_001_p.png";
        this.mDrawableNormal = ToolkitRes.loadDrawable(this.mPathNormal);
        this.mDrawableHighlight1 = ToolkitRes.loadDrawable(this.mPathHighlight1);
    }

    public boolean TouchRect(int x, int y, RectF rect) {
        return ((float) x) >= rect.left && ((float) x) <= rect.right && ((float) y) >= rect.top && ((float) y) <= rect.bottom;
    }

    @Override // com.syu.ui.benzair.Show_BenzBase, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) (event.getX() / this.mScale);
        int y = (int) (event.getY() / this.mScale);
        this.touch = false;
        if (TouchRect(x, y, this.config)) {
            DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
        }
        return false;
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
        if (DataCanbus.DATA[130] == 1) {
            this.mDrawableNormal.draw(c);
            if (this.touch) {
                this.srPath.addRect(this.config, Path.Direction.CW);
            }
            this.mPath.op(this.srPath, Path.Op.UNION);
            c.clipPath(this.mPath);
            this.mDrawableHighlight1.draw(c);
            c.restore();
            this.srPath.reset();
            this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
            this.mPath.op(this.srPath, Path.Op.XOR);
            c.clipRect(this.mRectDrawable);
            c.clipPath(this.mPath);
            this.mDrawableNormal.draw(c);
        }
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
