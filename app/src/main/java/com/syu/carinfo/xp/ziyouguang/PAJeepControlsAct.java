package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepControlsAct extends Activity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepControlsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    switch (value) {
                        case 0:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus1).setBackgroundResource(R.drawable.ic_pa_jeep_control1_0);
                            break;
                        case 1:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus1).setBackgroundResource(R.drawable.ic_pa_jeep_control1_3);
                            break;
                        case 2:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus1).setBackgroundResource(R.drawable.ic_pa_jeep_control1_2);
                            break;
                        case 3:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus1).setBackgroundResource(R.drawable.ic_pa_jeep_control1_1);
                            break;
                    }
                case 30:
                    switch (value) {
                        case 0:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus4).setBackgroundResource(R.drawable.ic_pa_jeep_control4_0);
                            break;
                        case 1:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus4).setBackgroundResource(R.drawable.ic_pa_jeep_control4_3);
                            break;
                        case 2:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus4).setBackgroundResource(R.drawable.ic_pa_jeep_control4_2);
                            break;
                        case 3:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus4).setBackgroundResource(R.drawable.ic_pa_jeep_control4_1);
                            break;
                    }
                case 31:
                    switch (value) {
                        case 0:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus2).setBackgroundResource(R.drawable.ic_pa_jeep_control2_0);
                            break;
                        case 1:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus2).setBackgroundResource(R.drawable.ic_pa_jeep_control2_4);
                            break;
                        case 2:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus2).setBackgroundResource(R.drawable.ic_pa_jeep_control2_2);
                            break;
                        case 3:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus2).setBackgroundResource(R.drawable.ic_pa_jeep_control2_1);
                            break;
                    }
                case 32:
                    switch (value) {
                        case 0:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus5).setBackgroundResource(R.drawable.ic_pa_jeep_control5_0);
                            break;
                        case 1:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus5).setBackgroundResource(R.drawable.ic_pa_jeep_control5_3);
                            break;
                        case 2:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus5).setBackgroundResource(R.drawable.ic_pa_jeep_control5_2);
                            break;
                        case 3:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus5).setBackgroundResource(R.drawable.ic_pa_jeep_control5_1);
                            break;
                    }
                case 66:
                    switch (value) {
                        case 0:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus3).setBackgroundResource(R.drawable.ic_pa_jeep_control3_0);
                            break;
                        case 1:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus3).setBackgroundResource(R.drawable.ic_pa_jeep_control3_1);
                            break;
                    }
                case 96:
                    switch (value) {
                        case 0:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus6).setBackgroundResource(R.drawable.ic_pa_jeep_control6_n);
                            break;
                        case 1:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus6).setBackgroundResource(R.drawable.ic_pa_jeep_control6_p);
                            break;
                    }
                case 206:
                    switch (value) {
                        case 0:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus7).setBackgroundResource(R.drawable.ic_pa_jeep_control7_n);
                            break;
                        case 1:
                            PAJeepControlsAct.this.findViewById(R.id.btn_minus7).setBackgroundResource(R.drawable.ic_pa_jeep_control7_p);
                            break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_controls);
        init();
    }

    public void init() {
        findViewById(R.id.btn_minus1).setOnTouchListener(this);
        findViewById(R.id.btn_minus2).setOnTouchListener(this);
        findViewById(R.id.btn_minus3).setOnTouchListener(this);
        findViewById(R.id.btn_minus4).setOnTouchListener(this);
        findViewById(R.id.btn_minus5).setOnTouchListener(this);
        findViewById(R.id.btn_minus6).setOnTouchListener(this);
        findViewById(R.id.btn_minus7).setOnTouchListener(this);
        findViewById(R.id.btn_minus8).setOnTouchListener(this);
        findViewById(R.id.btn_minus9).setOnTouchListener(this);
        findViewById(R.id.btn_minus10).setOnTouchListener(this);
        findViewById(R.id.btn_minus11).setOnTouchListener(this);
        findViewById(R.id.btn_minus12).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int value;
        int value2;
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427480 */:
                    DataCanbus.PROXY.cmd(6, new int[]{1, 17}, null, null);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    DataCanbus.PROXY.cmd(6, new int[]{1, 22}, null, null);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    DataCanbus.PROXY.cmd(6, new int[]{1, 24}, null, null);
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                    DataCanbus.PROXY.cmd(6, new int[]{1, 18}, null, null);
                    break;
                case R.id.btn_minus5 /* 2131427496 */:
                    DataCanbus.PROXY.cmd(6, new int[]{1, 23}, null, null);
                    break;
                case R.id.btn_minus6 /* 2131427501 */:
                    int value3 = DataCanbus.DATA[96];
                    if (value3 == 1) {
                        value2 = 0;
                    } else {
                        value2 = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{39, value2}, null, null);
                    break;
                case R.id.btn_minus7 /* 2131427505 */:
                    int value4 = DataCanbus.DATA[206];
                    if (value4 == 1) {
                        value = 0;
                    } else {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{195, value}, null, null);
                    break;
                case R.id.btn_minus8 /* 2131427509 */:
                    DataCanbus.PROXY.cmd(0, new int[]{213, 1}, null, null);
                    break;
                case R.id.btn_minus9 /* 2131427513 */:
                    DataCanbus.PROXY.cmd(14, new int[]{2}, null, null);
                    break;
                case R.id.btn_minus10 /* 2131427517 */:
                    DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
                    break;
                case R.id.btn_minus11 /* 2131427521 */:
                    DataCanbus.PROXY.cmd(14, new int[]{3}, null, null);
                    break;
                case R.id.btn_minus12 /* 2131427525 */:
                    DataCanbus.PROXY.cmd(0, new int[]{214, 1}, null, null);
                    break;
            }
        } else {
            event.getAction();
        }
        return false;
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

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
    }
}