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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class SanwuHuangguanCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.SanwuHuangguanCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    SanwuHuangguanCarSettingsAct.this.setCheck((CheckedTextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 108:
                    if (((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("2010");
                                break;
                            case 1:
                                ((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("2016");
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 111:
                    SanwuHuangguanCarSettingsAct.this.setCheck((CheckedTextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 112:
                    if (((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_original_car_mode);
                                break;
                            case 1:
                                ((TextView) SanwuHuangguanCarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_installation_mode);
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
        setContentView(R.layout.layout_0456_sanwu_huangguan_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
            case R.id.btn_plus1 /* 2131427419 */:
                int value = DataCanbus.DATA[108];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
            case R.id.btn_plus2 /* 2131427423 */:
                int value2 = DataCanbus.DATA[109];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
            case R.id.btn_plus3 /* 2131427427 */:
                int value3 = DataCanbus.DATA[110];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
            case R.id.btn_minus4 /* 2131427473 */:
                int value4 = DataCanbus.DATA[111];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                setCarInfo(6, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value5 = DataCanbus.DATA[107];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(1, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value6 = DataCanbus.DATA[111];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(5, value6);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{104, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }
}
