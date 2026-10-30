package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCJiliRD6CarPowerSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.RZCJiliRD6CarPowerSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 222:
                    if (((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text1)).setText("CLTC");
                                break;
                            case 1:
                                ((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text1)).setText("WLTP");
                                break;
                        }
                    }
                    break;
                case 223:
                    RZCJiliRD6CarPowerSettingsAct.this.setCheck((CheckedTextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 224:
                    RZCJiliRD6CarPowerSettingsAct.this.setCheck((CheckedTextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 225:
                    if (((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 226:
                    if (((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 227:
                    if (((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 228:
                    if (((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 231:
                    if (((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text6)).setText("充电枪未连接");
                                break;
                            case 1:
                                ((TextView) RZCJiliRD6CarPowerSettingsAct.this.findViewById(R.id.tv_text6)).setText("正在充电...");
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
        setContentView(R.layout.layout_0139_rzc_jilird6_power_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[222] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[222] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[226];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[226];
                if (value4 < 100) {
                    value4++;
                }
                setCarInfo(4, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = DataCanbus.DATA[223];
                if (value5 == 0) {
                    value5 = 1;
                } else if (value5 == 1) {
                    value5 = 0;
                }
                setCarInfo(1, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value6 = DataCanbus.DATA[224];
                if (value6 == 0) {
                    value6 = 1;
                } else if (value6 == 1) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(8, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(7, new int[]{100, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
    }
}
