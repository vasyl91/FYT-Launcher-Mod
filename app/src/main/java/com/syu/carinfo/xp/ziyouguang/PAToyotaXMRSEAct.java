package com.syu.carinfo.xp.ziyouguang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAToyotaXMRSEAct extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAToyotaXMRSEAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 235:
                    if (value == 0) {
                        ((TextView) PAToyotaXMRSEAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#666666"));
                        break;
                    } else {
                        ((TextView) PAToyotaXMRSEAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#ffffff"));
                        break;
                    }
                case 236:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 237:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 238:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 239:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 240:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 241:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0397_pa_toyota_rse);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427482 */:
                data0 = 1;
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                data0 = 2;
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                data0 = 3;
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                data0 = 4;
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                data0 = 5;
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                data0 = 6;
                break;
        }
        if (data0 != 0) {
            if (event.getAction() == 0) {
                DataCanbus.PROXY.cmd(46, new int[]{data0, 1}, null, null);
            } else if (event.getAction() == 1) {
                DataCanbus.PROXY.cmd(46, new int[]{data0}, null, null);
            }
        }
        return false;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(17);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
    }
}
