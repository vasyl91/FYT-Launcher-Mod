package com.android.launcher66;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class PagedViewWidgetImageView extends ImageView {
    public boolean mAllowRequestLayout;

    public PagedViewWidgetImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAllowRequestLayout = true;
    }

    @Override // android.view.View
    public void requestLayout() {
        if (this.mAllowRequestLayout) {
            super.requestLayout();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(getScrollX() + getPaddingLeft(), getScrollY() + getPaddingTop(), ((getScrollX() + getRight()) - getLeft()) - getPaddingRight(), ((getScrollY() + getBottom()) - getTop()) - getPaddingBottom());
        super.onDraw(canvas);
        canvas.restore();
    }
}