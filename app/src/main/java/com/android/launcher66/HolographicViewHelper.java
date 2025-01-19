package com.android.launcher66;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.ImageView;

public class HolographicViewHelper {
    private int mHighlightColor;
    private int mHotwordColor;
    private boolean mStatesUpdated;
    private final Canvas mTempCanvas = new Canvas();

    public HolographicViewHelper(Context context) {
        Resources res = context.getResources();
        this.mHighlightColor = res.getColor(android.R.color.holo_blue_light);
        this.mHotwordColor = res.getColor(android.R.color.holo_green_light);
    }

    void generatePressedFocusedStates(ImageView v) {
        if (!this.mStatesUpdated && v != null) {
            this.mStatesUpdated = true;
            Bitmap original = createOriginalImage(v, this.mTempCanvas);
            Bitmap outline = createImageWithOverlay(v, this.mTempCanvas, this.mHighlightColor);
            Bitmap hotword = createImageWithOverlay(v, this.mTempCanvas, this.mHotwordColor);
            FastBitmapDrawable originalD = new FastBitmapDrawable(original);
            FastBitmapDrawable outlineD = new FastBitmapDrawable(outline);
            FastBitmapDrawable hotwordD = new FastBitmapDrawable(hotword);
            StateListDrawable states = new StateListDrawable();
            states.addState(new int[]{android.R.attr.state_pressed}, outlineD);
            states.addState(new int[]{android.R.attr.state_focused}, outlineD);
            states.addState(new int[]{R.attr.stateHotwordOn}, hotwordD);
            states.addState(new int[0], originalD);
            v.setImageDrawable(states);
        }
    }

    void invalidatePressedFocusedStates(ImageView v) {
        this.mStatesUpdated = false;
        if (v != null) {
            v.invalidate();
        }
    }

    private Bitmap createOriginalImage(ImageView v, Canvas canvas) {
        Drawable d = v.getDrawable();
        Bitmap b = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(b);
        canvas.save();
        d.draw(canvas);
        canvas.restore();
        canvas.setBitmap(null);
        return b;
    }

    private Bitmap createImageWithOverlay(ImageView v, Canvas canvas, int color) {
        Drawable d = v.getDrawable();
        Bitmap b = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(b);
        canvas.save();
        d.draw(canvas);
        canvas.restore();
        canvas.drawColor(color, PorterDuff.Mode.SRC_IN);
        canvas.setBitmap(null);
        return b;
    }
}
