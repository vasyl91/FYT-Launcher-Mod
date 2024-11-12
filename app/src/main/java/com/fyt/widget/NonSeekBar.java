package com.fyt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class NonSeekBar extends SeekBar {
    public NonSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NonSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NonSeekBar(Context context) {
        super(context);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
