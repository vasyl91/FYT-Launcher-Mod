package com.android.launcher66;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * A Button which becomes translucent when it is disabled
 */
public class AlphaDisableableButton extends Button {
    public static float DISABLED_ALPHA_VALUE = 0.4f;
    public AlphaDisableableButton(Context context) {
        this(context, null);
    }

    public AlphaDisableableButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AlphaDisableableButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_HARDWARE, null);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if(enabled) {
            setAlpha(1.0f);
        } else {
            setAlpha(DISABLED_ALPHA_VALUE);
        }
    }
}
