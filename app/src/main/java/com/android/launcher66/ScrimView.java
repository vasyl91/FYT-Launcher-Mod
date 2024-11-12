package com.android.launcher66;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ScrimView extends FrameLayout implements Insettable {
    public ScrimView(Context context) {
        this(context, null, 0);
    }

    public ScrimView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrimView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setInsets(Rect insets) {
    }
}
