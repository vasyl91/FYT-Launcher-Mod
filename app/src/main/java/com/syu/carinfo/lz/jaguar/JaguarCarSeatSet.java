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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JaguarCarSeatSet extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSeatSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 60:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 61:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 62:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 63:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 64:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 65:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 77:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 78:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 79:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 80:
                    JaguarCarSeatSet.this.setCheck((CheckedTextView) JaguarCarSeatSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 126:
                    if (((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (val == 0) {
                            ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                            break;
                        } else {
                            ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val)).toString());
                            break;
                        }
                    }
                    break;
                case 127:
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
                case 128:
                    if (((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (val == 0) {
                            ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                            break;
                        } else {
                            ((TextView) JaguarCarSeatSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(val)).toString());
                            break;
                        }
                    }
                    break;
                case 129:
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCarInfo(30);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setCarInfo(30);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarInfo(19);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarInfo(31);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarInfo(20);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
            case R.id.btn_plus3 /* 2131427490 */:
                setCarInfo(57);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
            case R.id.btn_plus4 /* 2131427494 */:
                setCarInfo(58);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
            case R.id.btn_plus5 /* 2131427498 */:
                setCarInfo(59);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
            case R.id.btn_plus6 /* 2131427503 */:
                setCarInfo(60);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCarInfo(31);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfo(32);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setCarInfo(33);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                setCarInfo(34);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                setCarInfo(35);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                setCarInfo(47);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                setCarInfo(48);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                setCarInfo(49);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                setCarInfo(50);
                break;
        }
    }

    public void setCarInfo(int value) {
        DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSeatSet.2
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
    }
}
