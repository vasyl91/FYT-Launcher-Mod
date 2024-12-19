package com.syu.canbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BaseActivityForFragment extends Activity {
    public View.OnClickListener mClick;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    protected void finalize() throws Throwable {
        removeNotify();
    }

    public void init() {
    }

    public void addNotify() {
    }

    public void removeNotify() {
    }

    public void setClick(View v) {
        if (v != null && this.mClick != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    public void setCheck(CheckedTextView v, boolean on) {
        if (v != null) {
            v.setChecked(on);
        }
    }

    public void setViewVisible(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 0 : 8);
        }
    }

    public void setSelfClick(View v, View.OnClickListener l) {
        if (v != null && l != null) {
            v.setOnClickListener(l);
        }
    }

    public void setSelfTouch(View v, View.OnTouchListener l) {
        if (v != null && l != null) {
            v.setOnTouchListener(l);
        }
    }

    public <T extends View> T bindViewOnClick(int i, View.OnClickListener onClickListener) {
        T t = (T) findViewById(i);
        setSelfClick(t, onClickListener);
        return t;
    }
}
