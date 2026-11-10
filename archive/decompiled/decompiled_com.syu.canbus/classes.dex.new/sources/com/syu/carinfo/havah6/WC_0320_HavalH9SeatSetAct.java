package com.syu.carinfo.havah6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC_0320_HavalH9SeatSetAct extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9SeatSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    if (((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 30:
                    if (((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 157:
                    if (((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 158:
                    if (((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 159:
                    if (((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 160:
                    if (((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 161:
                    if (((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 162:
                    if (((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) WC_0320_HavalH9SeatSetAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0320_wc_haval_h9_seatsettings);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus9 /* 2131427480 */:
                int value = DataCanbus.DATA[157] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(29, value, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value2 = DataCanbus.DATA[157] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(29, value2, 0, 0);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value3 = DataCanbus.DATA[160] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(32, value3, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value4 = DataCanbus.DATA[160] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(32, value4, 0, 0);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value5 = DataCanbus.DATA[158] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(30, value5, 0, 0);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value6 = DataCanbus.DATA[158] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(30, value6, 0, 0);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value7 = DataCanbus.DATA[161] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(33, value7, 0, 0);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value8 = DataCanbus.DATA[161] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(33, value8, 0, 0);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value9 = DataCanbus.DATA[159] - 1;
                if (value9 < 0) {
                    value9 = 5;
                }
                setCarInfo(31, value9, 0, 0);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value10 = DataCanbus.DATA[159] + 1;
                if (value10 > 5) {
                    value10 = 0;
                }
                setCarInfo(31, value10, 0, 0);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value11 = DataCanbus.DATA[162] - 1;
                if (value11 < 0) {
                    value11 = 5;
                }
                setCarInfo(34, value11, 0, 0);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value12 = DataCanbus.DATA[162] + 1;
                if (value12 > 5) {
                    value12 = 0;
                }
                setCarInfo(34, value12, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setAir(17);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setAir(18);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(7, new int[]{value0, value1, value2, value3}, null, null);
    }

    private void setAir(final int cmd) {
        DataCanbus.PROXY.cmd(4, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9SeatSetAct.2
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(4, new int[]{cmd, 0}, null, null);
            }
        }, 200L);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }
}
