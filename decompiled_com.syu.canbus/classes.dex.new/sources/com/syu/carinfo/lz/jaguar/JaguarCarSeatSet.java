package com.syu.carinfo.lz.jaguar;

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
public class JaguarCarSeatSet extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSeatSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 125:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 126:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 127:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 139:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 140:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 141:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 143:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 185:
                    if (((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (val == 0) {
                            ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                        } else {
                            ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val)).toString());
                        }
                    }
                    break;
                case 186:
                    if (((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_seat_massage_set1);
                                break;
                            case 2:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_seat_massage_set2);
                                break;
                            case 3:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_seat_massage_set3);
                                break;
                            case 4:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_seat_massage_set4);
                                break;
                            case 5:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_seat_massage_set5);
                                break;
                        }
                    }
                    break;
                case 187:
                    if (((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (val == 0) {
                            ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                        } else {
                            ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(val)).toString());
                        }
                    }
                    break;
                case 188:
                    if (((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_seat_massage_set1);
                                break;
                            case 2:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_seat_massage_set2);
                                break;
                            case 3:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_seat_massage_set3);
                                break;
                            case 4:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_seat_massage_set4);
                                break;
                            case 5:
                                ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_seat_massage_set5);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_jaguar_seat_settings);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                setCarInfo(30);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                setCarInfo(19);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                setCarInfo(31);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                setCarInfo(20);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
            case R.id.btn_plus3 /* 2131427464 */:
                setCarInfo(57);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
            case R.id.btn_plus4 /* 2131427467 */:
                setCarInfo(58);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
            case R.id.btn_plus5 /* 2131427470 */:
                setCarInfo(59);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
            case R.id.btn_plus6 /* 2131427473 */:
                setCarInfo(60);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(33);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(34);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(32);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(35);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(47);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(48);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(49);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(50);
                break;
        }
    }

    public void setCarInfo(int value) {
        DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSeatSet.2
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{8, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }
}
