package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7FunctionalEscSystemActiVW_DZSJ extends BaseActivity {
    public static Golf7FunctionalEscSystemActiVW_DZSJ mInstance;
    public static boolean mIsFront = false;
    private int DriveMode = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode = 0;
            switch (updateCode) {
                case 127:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_ss)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_ss_p : R.drawable.ic_esc_ss);
                    break;
                case 128:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_bz)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_bz_p : R.drawable.ic_esc_bz);
                    break;
                case 129:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_yd)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_yd_p : R.drawable.ic_esc_yd);
                    break;
                case 130:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_jj)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_jj_p : R.drawable.ic_esc_jj);
                    break;
                case 131:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_diy)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_diy_p : R.drawable.ic_esc_diy);
                    if (((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_xd_set)) != null && value == 1) {
                        Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode = 1;
                        break;
                    }
                case 196:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_xd)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_xd_p : R.drawable.ic_esc_xd);
                    break;
                case 197:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_yy)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_yy_p : R.drawable.ic_esc_yy);
                    if (((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_xd_set)) != null && value == 1) {
                        Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode = 2;
                        break;
                    }
            }
            Golf7FunctionalEscSystemActiVW_DZSJ.this.setViewVisible((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_xd_set), Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode != 0);
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_esc_system_od);
        init();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.glf7_btn_esc_system_jj)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{4}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_bz)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{2}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_yd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{3}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_ss)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_diy)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{5}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_yy)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{8}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_xd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{6}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_xd_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode != 2) {
                        if (Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode == 1) {
                            intent.setClass(Golf7FunctionalEscSystemActiVW_DZSJ.this, Golf7FunctionalDrivingInfo2Acti.class);
                        }
                    } else {
                        intent.setClass(Golf7FunctionalEscSystemActiVW_DZSJ.this, Golf7Functional_OffRoadCustom_Wc_Acti.class);
                    }
                    Golf7FunctionalEscSystemActiVW_DZSJ.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] != 393233 || DataCanbus.DATA[1000] == 458769) {
            setViewVisible(findViewById(R.id.view_esc_system_xd), false);
            setViewVisible(findViewById(R.id.view_esc_system_yy), false);
        } else {
            setViewVisible(findViewById(R.id.view_esc_system_xd), true);
            setViewVisible(findViewById(R.id.view_esc_system_yy), true);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        }
        return true;
    }
}
