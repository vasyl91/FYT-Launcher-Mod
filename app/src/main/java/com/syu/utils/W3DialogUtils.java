package com.syu.utils;

import com.android.launcher66.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;

import com.syu.ipc.data.FinalCanbus;
import org.apache.http.HttpStatus;

public class W3DialogUtils {
    private static final int BTN_CANCEL = 2131234561;
    private static final int BTN_SURE = 2131234560;
    private static final int TEXTVIEW_MSG = 2131234563;
    private static final int TEXTVIEW_TITLE = 2131234562;

    public static class CustomDialog extends Dialog {
        View.OnClickListener clickListener;
        String msg;
        String negative;
        String positive;
        String title;

        public CustomDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
            super(context, cancelable, cancelListener);
            this.title = null;
            this.msg = null;
            this.positive = null;
            this.negative = null;
            this.clickListener = new View.OnClickListener() { // from class: com.syu.utils.W3DialogUtils.CustomDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    switch (v.getId()) {
                        case W3DialogUtils.BTN_SURE /* 2131234560 */:
                            CustomDialog.this.dismiss();
                            CustomDialog.this.stratActivityByName();
                            break;
                        case W3DialogUtils.BTN_CANCEL /* 2131234561 */:
                            CustomDialog.this.dismiss();
                            break;
                    }
                }
            };
            init();
        }

        public CustomDialog(Context context, int theme) {
            super(context, theme);
            this.title = null;
            this.msg = null;
            this.positive = null;
            this.negative = null;
            this.clickListener = new View.OnClickListener() { // from class: com.syu.utils.W3DialogUtils.CustomDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    switch (v.getId()) {
                        case W3DialogUtils.BTN_SURE /* 2131234560 */:
                            CustomDialog.this.dismiss();
                            CustomDialog.this.stratActivityByName();
                            break;
                        case W3DialogUtils.BTN_CANCEL /* 2131234561 */:
                            CustomDialog.this.dismiss();
                            break;
                    }
                }
            };
            init();
        }

        public CustomDialog(Context context) {
            this(context, R.style.ThemeTranslucent);
        }

        void init() {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            Window w = getWindow();
            w.setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            w.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            w.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams params = w.getAttributes();
            params.width = 500;
            params.height = 340;
            getWindow().setGravity(17);
            getWindow().setAttributes(params);
        }

        @SuppressLint("RestrictedApi")
        @Override 
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Context context = getContext();
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackgroundColor(Color.parseColor("#e8e8e8"));
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            TextView title = new TextView(context);
            title.setTextColor(SupportMenu.CATEGORY_MASK);
            if (this.title != null) {
                title.setText(this.title);
            }
            title.setId(W3DialogUtils.TEXTVIEW_TITLE);
            title.setTextSize(30.0f);
            title.setGravity(17);
            title.setPadding(0, 15, 0, 0);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.addView(title, lp);
            View view1 = new View(context);
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(-1, 15);
            linearLayout.addView(view1, lp2);
            TextView textView = new TextView(context);
            textView.setBackgroundColor(Color.parseColor("#a7a7a7"));
            textView.setWidth(300);
            textView.setHeight(1);
            linearLayout.addView(textView);
            TextView msg = new TextView(context);
            msg.setTextColor(View.MEASURED_STATE_MASK);
            if (this.msg != null) {
                msg.setText(this.msg);
            }
            msg.setId(W3DialogUtils.TEXTVIEW_MSG);
            msg.setTextSize(20.0F);
            msg.setHeight(180);
            msg.setWidth(500);
            msg.setPadding(30, 20, 30, 30);
            LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(500, -2);
            linearLayout.addView(msg, lp3);
            LinearLayout layout = new LinearLayout(getContext());
            layout.setPadding(0, 0, 0, 20);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setGravity(17);
            StateListDrawable drawable = new StateListDrawable();
            drawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(Color.parseColor("#8b8b8b")));
            drawable.addState(new int[0], new ColorDrawable(Color.parseColor("#a7a7a7")));
            Button button = new Button(getContext());
            if (this.positive != null) {
                button.setText(this.positive);
            }
            button.setTextColor(View.MEASURED_STATE_MASK);
            button.setId(W3DialogUtils.BTN_SURE);
            button.setWidth(178);
            button.setHeight(62);
            button.setTextSize(25.0f);
            button.setOnClickListener(this.clickListener);
            button.setBackground(drawable);
            layout.addView(button);
            View view = new View(getContext());
            LinearLayout.LayoutParams lp4 = new LinearLayout.LayoutParams(80, 50);
            layout.addView(view, lp4);
            LinearLayout.LayoutParams lp5 = new LinearLayout.LayoutParams(-1, -2);
            StateListDrawable drawable2 = new StateListDrawable();
            drawable2.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(Color.parseColor("#8b8b8b")));
            drawable2.addState(new int[0], new ColorDrawable(Color.parseColor("#a7a7a7")));
            Button button2 = new Button(getContext());
            if (this.negative != null) {
                button2.setText(this.negative);
            }
            button2.setTextColor(View.MEASURED_STATE_MASK);
            button2.setId(W3DialogUtils.BTN_CANCEL);
            button2.setBackground(drawable2);
            button2.setWidth(178);
            button2.setHeight(62);
            button2.setTextSize(25.0f);
            button2.setOnClickListener(this.clickListener);
            layout.addView(button2);
            linearLayout.addView(layout, lp5);
            setContentView(linearLayout);
        }

        @Override // android.app.Dialog
        public void setTitle(CharSequence title) {
            TextView tv = (TextView) findViewById(W3DialogUtils.TEXTVIEW_TITLE);
            this.title = (String) title;
            if (tv != null) {
                tv.setText(title);
            }
        }

        @Override // android.app.Dialog
        public void setTitle(int titleId) {
            setTitle(getContext().getText(titleId));
        }

        public void setMsg(CharSequence msg) {
            this.msg = (String) msg;
            TextView tv = (TextView) findViewById(W3DialogUtils.TEXTVIEW_MSG);
            if (tv != null) {
                tv.setText(msg);
            }
        }

        public void setMsg(int msgId) {
            setMsg(getContext().getString(msgId));
        }

        public void setButton(String positive, String negative) {
            this.positive = positive;
            this.negative = negative;
            Button btn = (Button) findViewById(W3DialogUtils.BTN_SURE);
            if (btn != null) {
                btn.setText(positive);
            }
            Button btn2 = (Button) findViewById(W3DialogUtils.BTN_CANCEL);
            if (btn2 != null) {
                btn2.setText(negative);
            }
        }

        public void setButton(int positive, int negative) {
            setButton(getContext().getString(positive), getContext().getString(negative));
        }

        public void stratActivityByName() {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.syu.unicar", "com.syu.unicar.MainAct"));
            intent.putExtra("isFromLauncher", true);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                getContext().startActivity(intent);
            } catch (Exception e) {
            }
        }
    }
}
