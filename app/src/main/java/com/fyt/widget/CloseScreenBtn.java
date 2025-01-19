package com.fyt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.syu.car.CarStates;

public class CloseScreenBtn extends Button {
    public CloseScreenBtn(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CloseScreenBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CloseScreenBtn(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        switch (arg0.getAction()) {
            case 0:
                CarStates.getCar(getContext()).getTools().sendInt(0, 18, 2);
                break;
        }
        return super.onTouchEvent(arg0);
    }
}
