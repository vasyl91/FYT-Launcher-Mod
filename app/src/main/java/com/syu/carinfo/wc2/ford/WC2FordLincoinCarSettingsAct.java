package com.syu.carinfo.wc2.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC2FordLincoinCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    WC2FordLincoinCarSettingsAct.this.updateTempUnit(val);
                    break;
                case 43:
                    WC2FordLincoinCarSettingsAct.this.updateLanguage(val);
                    break;
                case 44:
                    WC2FordLincoinCarSettingsAct.this.updateMeasure(val);
                    break;
                case 45:
                    WC2FordLincoinCarSettingsAct.this.updateAmbientLight(val);
                    break;
                case 46:
                    WC2FordLincoinCarSettingsAct.this.updaterCameraDelay(val);
                    break;
                case 47:
                    WC2FordLincoinCarSettingsAct.this.updaterradarDisplay(val);
                    break;
                case 98:
                    ((CheckedTextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(val != 0);
                    break;
                case 99:
                    ((CheckedTextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(val != 0);
                    break;
                case 100:
                    ((TextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_ford_lincoin_car_settings_act);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
        if (DataCanbus.DATA[1000] == 4981179) {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int data0 = 0;
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        int data4 = 0;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                data0 = 2;
                data1 = 242;
                data2 = 6;
                if (DataCanbus.DATA[46] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
            case R.id.btn_minus1 /* 2131427480 */:
                data0 = 2;
                data1 = 154;
                data2 = 1;
                data3 = DataCanbus.DATA[43] - 1;
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                data0 = 2;
                data1 = 154;
                data2 = 1;
                data3 = DataCanbus.DATA[43] + 1;
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                data0 = 4;
                data1 = 111;
                data2 = 3;
                data3 = DataCanbus.DATA[45] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                data0 = 4;
                data1 = 111;
                data2 = 3;
                data3 = DataCanbus.DATA[45] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
            case R.id.btn_minus3 /* 2131427488 */:
                data0 = 4;
                data1 = 111;
                data2 = 2;
                data3 = DataCanbus.DATA[100] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
            case R.id.btn_plus3 /* 2131427490 */:
                data0 = 4;
                data1 = 111;
                data2 = 2;
                data3 = DataCanbus.DATA[100] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int data02 = DataCanbus.DATA[47] == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(4, new int[]{data02}, null, null);
                return;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                data0 = 2;
                data1 = 108;
                data2 = 5;
                if (DataCanbus.DATA[44] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                data0 = 2;
                data1 = 109;
                data2 = 4;
                if (DataCanbus.DATA[11] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                data0 = 2;
                data1 = 242;
                data2 = 11;
                if (DataCanbus.DATA[98] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                data0 = 2;
                data1 = 242;
                data2 = 10;
                if (DataCanbus.DATA[99] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
        }
        sendCmd(data0, data1, data2, data3, data4, 0);
    }

    private void sendCmd(int data0, int data1, int data2, int data3, int data4, int data5) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempUnit(int value) {
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_15ruijie_temp_unit_c_set);
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_15ruijie_temp_unit_f_set);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAmbientLight(int value) {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                switch (value) {
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_white_str);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_background_amber);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_blue_green_str);
                        break;
                    case 4:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                        break;
                    case 5:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                        break;
                    case 6:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_background_green);
                        break;
                    case 7:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_lavender_str);
                        break;
                    default:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                        break;
                }
            default:
                switch (value) {
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_ice_blue);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_orange_str);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_2);
                        break;
                    case 4:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                        break;
                    case 5:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_4);
                        break;
                    case 6:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                        break;
                    case 7:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_6);
                        break;
                    default:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                        break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMeasure(int value) {
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_format_set1);
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_format_set0);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLanguage(int value) {
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_0);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_lauguage_set_value_20);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCameraDelay(int value) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterradarDisplay(int value) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }
}
