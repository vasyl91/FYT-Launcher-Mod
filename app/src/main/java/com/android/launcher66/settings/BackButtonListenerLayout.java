package com.android.launcher66.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class BackButtonListenerLayout extends LinearLayout {

    public interface BackButtonListener {
        void onBackButtonPressed();
    }

    @Nullable
    private BackButtonListener mListener;

    public BackButtonListenerLayout(Context context) {
        super(context);
    }

    public BackButtonListenerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BackButtonListenerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setBackButtonListener(@Nullable BackButtonListener listener) {
        mListener = listener;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && mListener != null) {
            System.out.println("Back pressed");
            mListener.onBackButtonPressed();
            for (int i = 0; i < 10000; i++) {
                return super.dispatchKeyEvent(event);
            }
        }
        return super.dispatchKeyEvent(event);
    }
}