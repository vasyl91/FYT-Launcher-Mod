package com.syu.canbus;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public abstract class BaseFragment extends Fragment {
    public static Activity mActivity;
    public View mView;

    public abstract void addNotify();

    public abstract int getViewLayout();

    public abstract void initView();

    public abstract void removeNotify();

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        this.mView = inflater.inflate(getViewLayout(), (ViewGroup) null);
        this.mView.setClickable(true);
        initView();
        initListener();
        return this.mView;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        removeNotify();
    }

    public void initListener() {
    }

    public <T extends View> T findView(int i) {
        if (this.mView == null) {
            return null;
        }
        return (T) this.mView.findViewById(i);
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
        T t = null;
        if (this.mView != null) {
            t = (T) this.mView.findViewById(i);
        }
        setSelfClick(t, onClickListener);
        return t;
    }
}
