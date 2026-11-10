package com.syu.carinfo.od.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ODBMWX1CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.bmw.ODBMWX1CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    if (((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text1)).setText("km");
                                break;
                            case 1:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text1)).setText("mls");
                                break;
                        }
                    }
                    break;
                case 12:
                    if (((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.rzc_others_language_setting_15);
                                break;
                            case 1:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_psa_all_lauguage_set_value_1_UK);
                                break;
                            case 2:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_psa_all_lauguage_set_value_1_US);
                                break;
                            case 3:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_psa_all_lauguage_set_value_7);
                                break;
                            case 4:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_psa_all_lauguage_set_value_4);
                                break;
                            case 5:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_psa_all_lauguage_set_value_5);
                                break;
                        }
                    }
                    break;
                case 13:
                    if (((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text3)).setText("l/100km");
                                break;
                            case 1:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text3)).setText("mpg(UK)");
                                break;
                            case 2:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text3)).setText("mpg(US)");
                                break;
                            case 3:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text3)).setText("km/l");
                                break;
                        }
                    }
                    break;
                case 14:
                    if (((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text4)).setText("℃");
                                break;
                            case 1:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text4)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 15:
                    if (((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_bogoo_bmw_time_format_0);
                                break;
                            case 1:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                        }
                    }
                    break;
                case 16:
                    if (((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 17:
                    if (((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 18:
                    if (((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.rzc_c4l_close);
                                break;
                            default:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.rzc_c4l_open);
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
        setContentView(R.layout.layout_0452_od_bmw_x1_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.btn_minus1).setOnClickListener(this);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_minus2).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
        findViewById(R.id.btn_minus3).setOnClickListener(this);
        findViewById(R.id.btn_plus3).setOnClickListener(this);
        findViewById(R.id.btn_minus4).setOnClickListener(this);
        findViewById(R.id.btn_plus4).setOnClickListener(this);
        findViewById(R.id.btn_minus5).setOnClickListener(this);
        findViewById(R.id.btn_plus5).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCarInfo(1, 1);
                setCarInfo(1, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value0 = DataCanbus.DATA[11];
                int value1 = DataCanbus.DATA[12];
                int value2 = DataCanbus.DATA[13];
                int value3 = DataCanbus.DATA[14];
                int value4 = DataCanbus.DATA[15];
                int value5 = value0 - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo1(value5, value1, value2, value3, value4);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value6 = DataCanbus.DATA[11];
                int value7 = DataCanbus.DATA[12];
                int value8 = DataCanbus.DATA[13];
                int value9 = DataCanbus.DATA[14];
                int value10 = DataCanbus.DATA[15];
                int value11 = value6 + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo1(value11, value7, value8, value9, value10);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value12 = DataCanbus.DATA[11];
                int value13 = DataCanbus.DATA[12];
                int value14 = DataCanbus.DATA[13];
                int value15 = DataCanbus.DATA[14];
                int value16 = DataCanbus.DATA[15];
                int value17 = value13 - 1;
                if (value17 < 0) {
                    value17 = 5;
                }
                setCarInfo1(value12, value17, value14, value15, value16);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value18 = DataCanbus.DATA[11];
                int value19 = DataCanbus.DATA[12];
                int value20 = DataCanbus.DATA[13];
                int value21 = DataCanbus.DATA[14];
                int value22 = DataCanbus.DATA[15];
                int value23 = value19 + 1;
                if (value23 > 5) {
                    value23 = 0;
                }
                setCarInfo1(value18, value23, value20, value21, value22);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value24 = DataCanbus.DATA[11];
                int value25 = DataCanbus.DATA[12];
                int value26 = DataCanbus.DATA[13];
                int value27 = DataCanbus.DATA[14];
                int value28 = DataCanbus.DATA[15];
                int value29 = value26 - 1;
                if (value29 < 0) {
                    value29 = 3;
                }
                setCarInfo1(value24, value25, value29, value27, value28);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value30 = DataCanbus.DATA[11];
                int value31 = DataCanbus.DATA[12];
                int value32 = DataCanbus.DATA[13];
                int value33 = DataCanbus.DATA[14];
                int value34 = DataCanbus.DATA[15];
                int value35 = value32 + 1;
                if (value35 > 3) {
                    value35 = 0;
                }
                setCarInfo1(value30, value31, value35, value33, value34);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value36 = DataCanbus.DATA[11];
                int value37 = DataCanbus.DATA[12];
                int value38 = DataCanbus.DATA[13];
                int value39 = DataCanbus.DATA[14];
                int value40 = DataCanbus.DATA[15];
                int value41 = value39 - 1;
                if (value41 < 0) {
                    value41 = 1;
                }
                setCarInfo1(value36, value37, value38, value41, value40);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value42 = DataCanbus.DATA[11];
                int value43 = DataCanbus.DATA[12];
                int value44 = DataCanbus.DATA[13];
                int value45 = DataCanbus.DATA[14];
                int value46 = DataCanbus.DATA[15];
                int value47 = value45 + 1;
                if (value47 > 1) {
                    value47 = 0;
                }
                setCarInfo1(value42, value43, value44, value47, value46);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value48 = DataCanbus.DATA[11];
                int value49 = DataCanbus.DATA[12];
                int value50 = DataCanbus.DATA[13];
                int value51 = DataCanbus.DATA[14];
                int value52 = DataCanbus.DATA[15] - 1;
                if (value52 < 0) {
                    value52 = 1;
                }
                setCarInfo1(value48, value49, value50, value51, value52);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value53 = DataCanbus.DATA[11];
                int value54 = DataCanbus.DATA[12];
                int value55 = DataCanbus.DATA[13];
                int value56 = DataCanbus.DATA[14];
                int value57 = DataCanbus.DATA[15] + 1;
                if (value57 > 1) {
                    value57 = 0;
                }
                setCarInfo1(value53, value54, value55, value56, value57);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCarInfo(2, 1);
                setCarInfo(2, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfo(3, 1);
                setCarInfo(3, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setCarInfo(4, 1);
                setCarInfo(4, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo1(int value0, int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2, value3, value4}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
    }
}
