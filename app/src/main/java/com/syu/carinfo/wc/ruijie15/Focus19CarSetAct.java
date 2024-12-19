package com.syu.carinfo.wc.ruijie15;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Focus19CarSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.Focus19CarSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 33:
                    Focus19CarSetAct.this.updaterTempUnit();
                    break;
                case 34:
                    Focus19CarSetAct.this.updaterCameraDelay();
                    break;
                case 40:
                    Focus19CarSetAct.this.updaterMileUnit();
                    break;
                case 41:
                    Focus19CarSetAct.this.updaterAmbientLight();
                    break;
                case 42:
                    Focus19CarSetAct.this.updaterEQVol();
                    break;
                case 43:
                    Focus19CarSetAct.this.updaterEQBal();
                    break;
                case 44:
                    Focus19CarSetAct.this.updaterEQFad();
                    break;
                case 45:
                    Focus19CarSetAct.this.updaterEQBass();
                    break;
                case 46:
                    Focus19CarSetAct.this.updaterEQMid();
                    break;
                case 47:
                    Focus19CarSetAct.this.updaterEQTreb();
                    break;
                case 48:
                    Focus19CarSetAct.this.updaterEQSpeedVol();
                    break;
                case 49:
                    Focus19CarSetAct.this.updaterEQSurround();
                    break;
                case 51:
                    Focus19CarSetAct.this.updaterChecked1();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc3_15ruijie_car_set);
        setUI();
    }

    private void setUI() {
        if (DataCanbus.DATA[1000] == 1769915 || DataCanbus.DATA[1000] == 1835451 || DataCanbus.DATA[1000] == 4391355 || DataCanbus.DATA[1000] == 4456891 || DataCanbus.DATA[1000] == 4522427 || DataCanbus.DATA[1000] == 5964219 || DataCanbus.DATA[1000] == 5898683 || DataCanbus.DATA[1000] == 6160827 || DataCanbus.DATA[1000] == 6226363 || DataCanbus.DATA[1000] == 6291899 || DataCanbus.DATA[1000] == 6357435) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 1835451) {
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
            findViewById(R.id.layout_view9).setVisibility(0);
            findViewById(R.id.layout_view10).setVisibility(0);
        } else {
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
        }
        findViewById(R.id.wc_15ruijie_temp_unit_set_check).setOnClickListener(this);
        findViewById(R.id.wc_15ruijie_camera_delay_set_check).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.wc_15ruijie_mile_unit_set_check).setOnClickListener(this);
        findViewById(R.id.ambient_Light_minus).setOnClickListener(this);
        findViewById(R.id.ambient_Light_plus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_carvol_minus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_carvol_plus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_bass_minus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_bass_plus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_mid_minus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_mid_plus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_treble_minus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_treble_plus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_balance_minus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_balance_plus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_fade_minus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_fade_plus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_surroundvol_minus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_surroundvol_plus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_speedvol_minus).setOnClickListener(this);
        findViewById(R.id.tianlaigongjue_btn_speedvol_plus).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                RJFunc.SET_TIPS_CMD(6, DataCanbus.DATA[51] != 0 ? 0 : 1);
                break;
            case R.id.wc_15ruijie_mile_unit_set_check /* 2131433015 */:
                DataCanbus.PROXY.cmd(6, new int[]{5, DataCanbus.DATA[40] == 0 ? 1 : 0}, null, null);
                break;
            case R.id.wc_15ruijie_temp_unit_set_check /* 2131433021 */:
                RJFunc.SET_TIPS_CMD(4, DataCanbus.DATA[33] != 0 ? 0 : 1);
                break;
            case R.id.wc_15ruijie_camera_delay_set_check /* 2131433024 */:
                RJFunc.SET_CAR_CMD(6, DataCanbus.DATA[34] != 0 ? 0 : 1);
                break;
            case R.id.ambient_Light_minus /* 2131433025 */:
                int value = DataCanbus.DATA[41] - 1;
                if (value < 0) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(7, new int[]{3, value}, null, null);
                break;
            case R.id.ambient_Light_plus /* 2131433027 */:
                int value2 = DataCanbus.DATA[41] + 1;
                if (value2 > 7) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{3, value2}, null, null);
                break;
            case R.id.tianlaigongjue_btn_carvol_minus /* 2131433028 */:
                int value3 = DataCanbus.DATA[42];
                if (value3 > 0) {
                    value3--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{1, value3}, null, null);
                break;
            case R.id.tianlaigongjue_btn_carvol_plus /* 2131433030 */:
                int value4 = DataCanbus.DATA[42];
                if (value4 < 30) {
                    value4++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{1, value4}, null, null);
                break;
            case R.id.tianlaigongjue_btn_bass_minus /* 2131433031 */:
                int value5 = DataCanbus.DATA[45];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{4, value5}, null, null);
                break;
            case R.id.tianlaigongjue_btn_bass_plus /* 2131433033 */:
                int value6 = DataCanbus.DATA[45];
                if (value6 < 14) {
                    value6++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{4, value6}, null, null);
                break;
            case R.id.tianlaigongjue_btn_mid_minus /* 2131433034 */:
                int value7 = DataCanbus.DATA[46];
                if (value7 > 0) {
                    value7--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{5, value7}, null, null);
                break;
            case R.id.tianlaigongjue_btn_mid_plus /* 2131433036 */:
                int value8 = DataCanbus.DATA[46];
                if (value8 < 14) {
                    value8++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{5, value8}, null, null);
                break;
            case R.id.tianlaigongjue_btn_treble_minus /* 2131433037 */:
                int value9 = DataCanbus.DATA[47];
                if (value9 > 0) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{6, value9}, null, null);
                break;
            case R.id.tianlaigongjue_btn_treble_plus /* 2131433039 */:
                int value10 = DataCanbus.DATA[47];
                if (value10 < 14) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{6, value10}, null, null);
                break;
            case R.id.tianlaigongjue_btn_balance_minus /* 2131433040 */:
                int value11 = DataCanbus.DATA[43];
                if (value11 > 0) {
                    value11--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{2, value11}, null, null);
                break;
            case R.id.tianlaigongjue_btn_balance_plus /* 2131433042 */:
                int value12 = DataCanbus.DATA[43];
                if (value12 < 14) {
                    value12++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{2, value12}, null, null);
                break;
            case R.id.tianlaigongjue_btn_fade_minus /* 2131433043 */:
                int value13 = DataCanbus.DATA[44];
                if (value13 > 0) {
                    value13--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{3, value13}, null, null);
                break;
            case R.id.tianlaigongjue_btn_fade_plus /* 2131433045 */:
                int value14 = DataCanbus.DATA[44];
                if (value14 < 14) {
                    value14++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{3, value14}, null, null);
                break;
            case R.id.tianlaigongjue_btn_surroundvol_minus /* 2131433046 */:
                int value15 = DataCanbus.DATA[49] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(8, new int[]{8, value15}, null, null);
                break;
            case R.id.tianlaigongjue_btn_surroundvol_plus /* 2131433048 */:
                int value16 = DataCanbus.DATA[49] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(8, new int[]{8, value16}, null, null);
                break;
            case R.id.tianlaigongjue_btn_speedvol_minus /* 2131433049 */:
                int value17 = DataCanbus.DATA[48] - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                DataCanbus.PROXY.cmd(8, new int[]{7, value17}, null, null);
                break;
            case R.id.tianlaigongjue_btn_speedvol_plus /* 2131433051 */:
                int value18 = DataCanbus.DATA[48] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                DataCanbus.PROXY.cmd(8, new int[]{7, value18}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEQSurround() {
        int value = DataCanbus.DATA[49];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tianlaigongjue_tv_surroundvol)).setText(R.string.haval_volspeed1);
                break;
            case 1:
                ((TextView) findViewById(R.id.tianlaigongjue_tv_surroundvol)).setText(R.string.wc_372_surroundstr);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEQSpeedVol() {
        int value = DataCanbus.DATA[48];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)).setText(R.string.off);
                break;
            case 1:
                ((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)).setText(R.string.klc_air_low);
                break;
            case 2:
                ((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)).setText(R.string.klc_air_middle);
                break;
            case 3:
                ((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)).setText(R.string.klc_air_high);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEQTreb() {
        int value = DataCanbus.DATA[47];
        if (value >= 7) {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_treble)).setText(new StringBuilder().append(value - 7).toString());
        } else {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_treble)).setText("-" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEQMid() {
        int value = DataCanbus.DATA[46];
        if (value >= 7) {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_mid)).setText(new StringBuilder().append(value - 7).toString());
        } else {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_mid)).setText("-" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEQBass() {
        int value = DataCanbus.DATA[45];
        if (value >= 7) {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_bass)).setText(new StringBuilder().append(value - 7).toString());
        } else {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_bass)).setText("-" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEQFad() {
        int value = DataCanbus.DATA[44];
        if (value >= 7) {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_fade)).setText(new StringBuilder().append(value - 7).toString());
        } else {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_fade)).setText("-" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEQBal() {
        int value = DataCanbus.DATA[43];
        if (value >= 7) {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_balance)).setText(new StringBuilder().append(value - 7).toString());
        } else {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_balance)).setText("-" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEQVol() {
        int value = DataCanbus.DATA[42];
        ((TextView) findViewById(R.id.tianlaigongjue_tv_carvol)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAmbientLight() {
        int value = DataCanbus.DATA[41];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.ambient_Light_tv)).setText(R.string.str_403_ambient_2);
                break;
            case 2:
                ((TextView) findViewById(R.id.ambient_Light_tv)).setText(R.string.str_403_ambient_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.ambient_Light_tv)).setText(R.string.str_wc_174008_str11);
                break;
            case 4:
                ((TextView) findViewById(R.id.ambient_Light_tv)).setText(R.string.str_403_ambient_3);
                break;
            case 5:
                ((TextView) findViewById(R.id.ambient_Light_tv)).setText(R.string.str_403_ambient_4);
                break;
            case 6:
                ((TextView) findViewById(R.id.ambient_Light_tv)).setText(R.string.str_403_ambient_5);
                break;
            case 7:
                ((TextView) findViewById(R.id.ambient_Light_tv)).setText(R.string.str_403_ambient_6);
                break;
            default:
                ((TextView) findViewById(R.id.ambient_Light_tv)).setText(R.string.off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMileUnit() {
        int value = DataCanbus.DATA[40];
        if (value == 1) {
            ((TextView) findViewById(R.id.wc_15ruijie_mile_unit_c_set_tv)).setText(R.string.jeep_format_set1);
        } else {
            ((TextView) findViewById(R.id.wc_15ruijie_mile_unit_c_set_tv)).setText(R.string.jeep_format_set0);
        }
        ((CheckedTextView) findViewById(R.id.wc_15ruijie_mile_unit_set_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempUnit() {
        int value = DataCanbus.DATA[33];
        if (value == 1) {
            ((TextView) findViewById(R.id.wc_15ruijie_temp_unit_c_set_tv)).setText(R.string.wc_15ruijie_temp_unit_c_set);
        } else {
            ((TextView) findViewById(R.id.wc_15ruijie_temp_unit_c_set_tv)).setText(R.string.wc_15ruijie_temp_unit_f_set);
        }
        ((CheckedTextView) findViewById(R.id.wc_15ruijie_temp_unit_set_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCameraDelay() {
        int value = DataCanbus.DATA[34];
        ((CheckedTextView) findViewById(R.id.wc_15ruijie_camera_delay_set_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterChecked1() {
        int value = DataCanbus.DATA[51];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }
}
