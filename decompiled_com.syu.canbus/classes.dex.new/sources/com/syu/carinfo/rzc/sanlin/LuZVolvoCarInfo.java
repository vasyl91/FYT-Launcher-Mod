package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuZVolvoCarInfo extends BaseActivity implements View.OnTouchListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuZVolvoCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext36).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key3_p : R.drawable.ic_volvo_key3_n);
                    break;
                case 128:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext26).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key27_p : R.drawable.ic_volvo_key27_n);
                    break;
                case 129:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext37).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key4_p : R.drawable.ic_volvo_key4_n);
                    break;
                case 136:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext38).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key26_p : R.drawable.ic_volvo_key26_n);
                    break;
                case 137:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext39).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key1_p : R.drawable.ic_volvo_key1_n);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_volvo_carinfo);
        findViewById(R.id.ctv_checkedtext1).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext8).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext9).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext10).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext11).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext12).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext13).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext14).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext15).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext16).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext17).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext18).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext19).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext20).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext21).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext22).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext23).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext24).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext25).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext26).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext27).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext28).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext29).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext30).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext31).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext32).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext33).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext34).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext35).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext36).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext37).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext38).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext39).setOnTouchListener(this);
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                data0 = 26;
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                data0 = 29;
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                data0 = 30;
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                data0 = 27;
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                data0 = 28;
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                data0 = 31;
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                data0 = 32;
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                data0 = 33;
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                data0 = 34;
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                data0 = 35;
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                data0 = 36;
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                data0 = 37;
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                data0 = 22;
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                data0 = 11;
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                data0 = 12;
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                data0 = 24;
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                data0 = 19;
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                data0 = 23;
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                data0 = 20;
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                data0 = 25;
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                data0 = 7;
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                data0 = 21;
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                data0 = 18;
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                data0 = 16;
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                data0 = 13;
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                data0 = 39;
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                data0 = 8;
                break;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                data0 = 15;
                break;
            case R.id.ctv_checkedtext29 /* 2131427827 */:
                data0 = 14;
                break;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                data0 = 10;
                break;
            case R.id.ctv_checkedtext31 /* 2131427839 */:
                data0 = 9;
                break;
            case R.id.ctv_checkedtext32 /* 2131427840 */:
                data0 = 6;
                break;
            case R.id.ctv_checkedtext33 /* 2131427841 */:
                data0 = 5;
                break;
            case R.id.ctv_checkedtext34 /* 2131427842 */:
                data0 = 17;
                break;
            case R.id.ctv_checkedtext35 /* 2131427843 */:
                data0 = 2;
                break;
            case R.id.ctv_checkedtext36 /* 2131427844 */:
                data0 = 3;
                break;
            case R.id.ctv_checkedtext37 /* 2131427855 */:
                data0 = 4;
                break;
            case R.id.ctv_checkedtext38 /* 2131427856 */:
                data0 = 38;
                break;
            case R.id.ctv_checkedtext39 /* 2131427857 */:
                data0 = 1;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(3, new int[]{data0, 1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(3, new int[]{data0, 0}, null, null);
        }
        return false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }
}
