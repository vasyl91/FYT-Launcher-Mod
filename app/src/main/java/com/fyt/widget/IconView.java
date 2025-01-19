package com.fyt.widget;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

public class IconView extends FrameLayout {
    private int app_name;
    public TextView mTitle;
    private int padding;
    private int paddingpress;
    BroadcastReceiver receiver;
    private int textSize;

    public IconView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.app_name = -1;
        this.receiver = new BroadcastReceiver() { 
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                IconView.this.updateStr();
            }
        };
        init(context, attrs);
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.app_name = -1;
        this.receiver = new BroadcastReceiver() { 
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                IconView.this.updateStr();
            }
        };
        init(context, attrs);
    }

    public IconView(Context context) {
        super(context);
        this.app_name = -1;
        this.receiver = new BroadcastReceiver() { 
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                IconView.this.updateStr();
            }
        };
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconView);
        this.app_name = a.getResourceId(0, 0);
        a.recycle();
        Resources res = context.getResources();
        this.padding = (int) res.getDimension(R.dimen.sbd_iconview_padding);
        this.textSize = (int) res.getDimension(R.dimen.sbd_iconview_textsize);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.app_name >= 0) {
            this.mTitle = new TextView(getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
            params.gravity = 81;
            if (isPressed()) {
                params.bottomMargin = this.paddingpress;
            } else {
                params.bottomMargin = this.padding;
            }
            this.mTitle.setText(this.app_name);
            this.mTitle.setTextSize(this.textSize);
            Typeface typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.ITALIC);
            this.mTitle.setTypeface(typeface);
            addView(this.mTitle, params);
        }
    }

    @Override
    public void setPressed(boolean pressed) {
        this.paddingpress = (int) getContext().getResources().getDimension(R.dimen.sbd_iconview_padding_p);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 81;
        if (pressed) {
            params.bottomMargin = this.paddingpress;
        } else {
            params.bottomMargin = this.padding;
        }
        removeView(this.mTitle);
        addView(this.mTitle, params);
        super.setPressed(pressed);
    }

    public void updateStr() {
        Log.i("hy", "updateStr" + LauncherApplication.sApp.getResources().getString(this.app_name) + "mTitle" + this.mTitle);
        if (this.app_name >= 0 && this.mTitle != null) {
            this.mTitle.setText(this.app_name);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter filter = new IntentFilter("android.intent.action.LOCALE_CHANGED");
        getContext().registerReceiver(this.receiver, filter);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(this.receiver);
    }
}
