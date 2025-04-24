package com.syu.ui.benzair;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.MotionEvent;

import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToolkitRes;

@SuppressWarnings({"deprecation", "unchecked"})
public class SHow_Benz extends Show_BenzBase {
    private final Rect config;
    boolean touch;

    public SHow_Benz(Context context) {
        super(context);
        this.config = new Rect(548, 257, 729, 309);
        this.touch = false;
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1280;
        this.mContentHeight = 420;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "parking/zhtd_Benz/parking_001.png";
        this.mPathHighlight1 = "parking/zhtd_Benz/parking_001_p.png";
        this.mDrawableNormal = ToolkitRes.loadDrawable(this.mPathNormal);
        this.mDrawableHighlight1 = ToolkitRes.loadDrawable(this.mPathHighlight1);
    }

    public boolean TouchRect(int x, int y, Rect rect) {
        return x >= rect.left && x <= rect.right && y >= rect.top && y <= rect.bottom;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) (event.getX() / this.mScale);
        int y = (int) (event.getY() / this.mScale);
        this.touch = false;
        if (TouchRect(x, y, this.config)) {
            DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
        }
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (DataCanbus.DATA[61] == 1) {
            this.mDrawableNormal.draw(c);
            if (this.touch) {
                c.clipRect(this.config, Region.Op.UNION);
            }
            this.mDrawableHighlight1.draw(c);
            c.clipRect(this.mRectDrawable, Region.Op.XOR);
            this.mDrawableNormal.draw(c);
        }
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
