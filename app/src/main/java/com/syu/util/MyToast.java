package com.syu.util;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.syu.canbus.R;

public class MyToast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    TextView textView;
    Toast toast;

    public MyToast(Context context) {
        this.textView = new TextView(context);
        this.textView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.toast_bg));
        this.textView.setMaxWidth(600);
        this.textView.setMaxHeight(360);
        this.textView.setGravity(17);
        this.toast = new Toast(context);
        this.toast.setGravity(17, 0, 60);
        this.toast.setView(this.textView);
    }

    public MyToast(Context context, CharSequence text, int duration, int textColor, int textSize) {
        this.textView = new TextView(context);
        this.textView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.toast_bg));
        this.textView.setMaxWidth(600);
        this.textView.setMaxHeight(360);
        this.textView.setGravity(17);
        this.textView.setTextColor(textColor);
        this.textView.setTextSize(textSize);
        this.textView.setText(text);
        this.toast = new Toast(context);
        this.toast.setGravity(17, 0, 60);
        this.toast.setView(this.textView);
    }

    public static Toast makeText(Context context, CharSequence text, int duration, int textColor, int textSize) {
        MyToast toastView = new MyToast(context, text, duration, textColor, textSize);
        return toastView.toast;
    }

    public void show() {
        if (this.toast != null) {
            this.toast.show();
        }
    }

    public void cancel() {
        if (this.toast != null) {
            this.toast.cancel();
        }
    }

    public void setText(CharSequence s) {
        if (this.textView != null) {
            this.textView.setText(s);
            if (this.toast != null) {
                this.toast.setView(this.textView);
            }
        }
    }

    public void setDuration(int duration) {
        if (this.toast != null) {
            this.toast.setDuration(duration);
        }
    }

    public void setTextSize(float size) {
        if (this.textView != null) {
            this.textView.setTextSize(size);
            if (this.toast != null) {
                this.toast.setView(this.textView);
            }
        }
    }

    public void setTextColor(int color) {
        if (this.textView != null) {
            this.textView.setTextColor(color);
            if (this.toast != null) {
                this.toast.setView(this.textView);
            }
        }
    }

    public CharSequence getText() {
        if (this.toast == null || this.textView == null) {
            return null;
        }
        return this.textView.getText();
    }
}
