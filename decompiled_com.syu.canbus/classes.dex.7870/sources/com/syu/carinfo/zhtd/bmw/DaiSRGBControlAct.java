package com.syu.carinfo.zhtd.bmw;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class DaiSRGBControlAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int touchnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.DaiSRGBControlAct.1
        @Override // java.lang.Runnable
        public void run() {
            DaiSRGBControlAct.this.touchnum++;
            if (DaiSRGBControlAct.this.touchnum == 3) {
                int colortype = (int) ((Math.random() * 7.0d) + 1.0d);
                int r_value = 0;
                int g_value = 0;
                int b_value = 0;
                switch (colortype) {
                    case 1:
                        r_value = 255;
                        g_value = 255;
                        b_value = 255;
                        break;
                    case 2:
                        r_value = 255;
                        g_value = 0;
                        b_value = 0;
                        break;
                    case 3:
                        r_value = 0;
                        g_value = 255;
                        b_value = 0;
                        break;
                    case 4:
                        r_value = 0;
                        g_value = 0;
                        b_value = 255;
                        break;
                    case 5:
                        r_value = 255;
                        g_value = 192;
                        b_value = 203;
                        break;
                    case 6:
                        r_value = 255;
                        g_value = 255;
                        b_value = 0;
                        break;
                    case 7:
                        r_value = 0;
                        g_value = 255;
                        b_value = 255;
                        break;
                }
                DataCanbus.PROXY.cmd(101, new int[]{colortype}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{0, r_value, g_value, b_value, 1, 0}, null, null);
                DaiSRGBControlAct.this.touchnum = 0;
            }
            HandlerUI.getInstance().removeCallbacks(DaiSRGBControlAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(DaiSRGBControlAct.this.mCalTime, 1000L);
        }
    };
    boolean seekbartouch = false;
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { // from class: com.syu.carinfo.zhtd.bmw.DaiSRGBControlAct.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar v) {
            if (DataCanbus.DATA[45] == 0) {
                switch (v.getId()) {
                    case R.id.layout_view2 /* 2131427405 */:
                    case R.id.layout_view3 /* 2131427406 */:
                    case R.id.layout_view4 /* 2131427407 */:
                        DaiSRGBControlAct.this.seekbartouch = false;
                        break;
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            if (DataCanbus.DATA[45] == 0) {
                switch (arg0.getId()) {
                    case R.id.layout_view2 /* 2131427405 */:
                        int i = DataCanbus.DATA[22];
                        int g_value = DataCanbus.DATA[23];
                        int b_value = DataCanbus.DATA[24];
                        if (DaiSRGBControlAct.this.seekbartouch) {
                            DataCanbus.PROXY.cmd(1, new int[]{0, arg0.getProgress(), g_value, b_value, 1, 0}, null, null);
                        }
                        break;
                    case R.id.layout_view3 /* 2131427406 */:
                        int r_value = DataCanbus.DATA[22];
                        int i2 = DataCanbus.DATA[23];
                        int b_value2 = DataCanbus.DATA[24];
                        if (DaiSRGBControlAct.this.seekbartouch) {
                            DataCanbus.PROXY.cmd(1, new int[]{0, r_value, arg0.getProgress(), b_value2, 1, 0}, null, null);
                        }
                        break;
                    case R.id.layout_view4 /* 2131427407 */:
                        int r_value2 = DataCanbus.DATA[22];
                        int g_value2 = DataCanbus.DATA[23];
                        int i3 = DataCanbus.DATA[24];
                        if (DaiSRGBControlAct.this.seekbartouch) {
                            DataCanbus.PROXY.cmd(1, new int[]{0, r_value2, g_value2, arg0.getProgress(), 1, 0}, null, null);
                        }
                        break;
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar arg0) {
            if (DataCanbus.DATA[45] == 0) {
                switch (arg0.getId()) {
                    case R.id.layout_view2 /* 2131427405 */:
                    case R.id.layout_view3 /* 2131427406 */:
                    case R.id.layout_view4 /* 2131427407 */:
                        if (DataCanbus.DATA[44] != 0) {
                            DataCanbus.PROXY.cmd(101, new int[1], null, null);
                        }
                        DaiSRGBControlAct.this.seekbartouch = true;
                        break;
                }
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.DaiSRGBControlAct.3
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 22:
                case 23:
                case 24:
                    int r_value = DataCanbus.DATA[22];
                    int g_value = DataCanbus.DATA[23];
                    int b_value = DataCanbus.DATA[24];
                    ((SeekBar) DaiSRGBControlAct.this.findViewById(R.id.layout_view2)).setProgress(r_value);
                    ((TextView) DaiSRGBControlAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(r_value).toString());
                    ((SeekBar) DaiSRGBControlAct.this.findViewById(R.id.layout_view3)).setProgress(g_value);
                    ((TextView) DaiSRGBControlAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(g_value).toString());
                    ((SeekBar) DaiSRGBControlAct.this.findViewById(R.id.layout_view4)).setProgress(b_value);
                    ((TextView) DaiSRGBControlAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(b_value).toString());
                    DaiSRGBControlAct.this.UpdateBk_RGB(r_value, g_value, b_value);
                    break;
                case 44:
                    DaiSRGBControlAct.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_ds_golf_color_white_n);
                    DaiSRGBControlAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_ds_golf_color_red_n);
                    DaiSRGBControlAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_ds_golf_color_green_n);
                    DaiSRGBControlAct.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_ds_golf_color_blue_n);
                    DaiSRGBControlAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_ds_golf_color_pink_n);
                    DaiSRGBControlAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_color_yellow_n);
                    DaiSRGBControlAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_ds_golf_color_azure_n);
                    switch (value) {
                        case 1:
                            DaiSRGBControlAct.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_ds_golf_color_white_p);
                            break;
                        case 2:
                            DaiSRGBControlAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_ds_golf_color_red_p);
                            break;
                        case 3:
                            DaiSRGBControlAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_ds_golf_color_green_p);
                            break;
                        case 4:
                            DaiSRGBControlAct.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_ds_golf_color_blue_p);
                            break;
                        case 5:
                            DaiSRGBControlAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_ds_golf_color_pink_p);
                            break;
                        case 6:
                            DaiSRGBControlAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_color_yellow_p);
                            break;
                        case 7:
                            DaiSRGBControlAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_ds_golf_color_azure_p);
                            break;
                    }
                    break;
                case 45:
                    DaiSRGBControlAct.this.findViewById(R.id.btn_plus9).setBackgroundResource(value == 1 ? R.drawable.ic_ds_golf_button_p : R.drawable.ic_ds_golf_button_n);
                    if (value == 1) {
                        DaiSRGBControlAct.this.mUpdatermCalTime(true);
                    } else {
                        DaiSRGBControlAct.this.mUpdatermCalTime(false);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_ds_golf_rgbctrl);
        seekbaronClick((SeekBar) findViewById(R.id.layout_view2));
        seekbaronClick((SeekBar) findViewById(R.id.layout_view3));
        seekbaronClick((SeekBar) findViewById(R.id.layout_view4));
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int r_value = 0;
        int g_value = 0;
        int b_value = 0;
        int colortype = 0;
        boolean sendrgb = true;
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427419 */:
                r_value = 255;
                g_value = 255;
                b_value = 255;
                colortype = 1;
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                r_value = 255;
                g_value = 0;
                b_value = 0;
                colortype = 2;
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                r_value = 0;
                g_value = 255;
                b_value = 0;
                colortype = 3;
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                r_value = 0;
                g_value = 0;
                b_value = 255;
                colortype = 4;
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                r_value = 255;
                g_value = 192;
                b_value = 203;
                colortype = 5;
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                r_value = 255;
                g_value = 255;
                b_value = 0;
                colortype = 6;
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                r_value = 0;
                g_value = 255;
                b_value = 255;
                colortype = 7;
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                r_value = 130;
                g_value = 130;
                b_value = 130;
                colortype = 0;
                if (DataCanbus.DATA[45] == 1) {
                    DataCanbus.PROXY.cmd(101, new int[]{0}, null, null);
                    UpdateBk_RGB(130, 130, 130);
                    DataCanbus.PROXY.cmd(1, new int[]{0, 130, 130, 130, 1, 0}, null, null);
                    mUpdatermCalTime(false);
                    DataCanbus.PROXY.cmd(102, new int[1], null, null);
                    sendrgb = false;
                }
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value2 = DataCanbus.DATA[45];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{value}, null, null);
                sendrgb = false;
                DataCanbus.PROXY.cmd(101, new int[1], null, null);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                sendrgb = false;
                break;
        }
        if (sendrgb && DataCanbus.DATA[45] != 1) {
            DataCanbus.PROXY.cmd(102, new int[1], null, null);
            UpdateBk_RGB(r_value, g_value, b_value);
            DataCanbus.PROXY.cmd(1, new int[]{0, r_value, g_value, b_value, 1, 0}, null, null);
            DataCanbus.PROXY.cmd(101, new int[]{colortype}, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatermCalTime(boolean on) {
        if (on) {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
            HandlerUI.getInstance().postDelayed(this.mCalTime, 1000L);
            this.touchnum = 0;
            findViewById(R.id.btn_plus10).setVisibility(0);
            return;
        }
        HandlerUI.getInstance().removeCallbacks(this.mCalTime);
        findViewById(R.id.btn_plus10).setVisibility(8);
    }

    void UpdateBk_RGB(int r_value, int g_value, int b_value) {
        String str = "#" + Integer.toHexString((r_value >> 4) & 15) + Integer.toHexString(r_value & 15) + Integer.toHexString((g_value >> 4) & 15) + Integer.toHexString(g_value & 15) + Integer.toHexString((b_value >> 4) & 15) + Integer.toHexString(b_value & 15);
        Log.v("zed", " rgbstr  == " + str);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor(str));
        findViewById(R.id.layout_view1).setBackground(drawable);
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{57, 0}, null, null);
        addNotify();
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
    }
}
