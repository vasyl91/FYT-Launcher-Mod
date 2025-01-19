package com.syu.carinfo.od.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODBMWX1CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    if (ODBMWX1CarSet.this.findViewById(R.id.tv_text1) != null) {
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
                    if (ODBMWX1CarSet.this.findViewById(R.id.tv_text2) != null) {
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
                    if (ODBMWX1CarSet.this.findViewById(R.id.tv_text3) != null) {
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
                    if (ODBMWX1CarSet.this.findViewById(R.id.tv_text4) != null) {
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
                    if (ODBMWX1CarSet.this.findViewById(R.id.tv_text5) != null) {
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
                    if (ODBMWX1CarSet.this.findViewById(R.id.tv_text6) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 17:
                    if (ODBMWX1CarSet.this.findViewById(R.id.tv_text7) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) ODBMWX1CarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 18:
                    if (ODBMWX1CarSet.this.findViewById(R.id.tv_text8) != null) {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_bmw_x1_settings);
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value0 = DataCanbus.DATA[11];
                int value1 = DataCanbus.DATA[12];
                int value2 = DataCanbus.DATA[13];
                int value3 = DataCanbus.DATA[14];
                int value4 = DataCanbus.DATA[15];
                int value02 = value0 - 1;
                if (value02 < 0) {
                    value02 = 1;
                }
                setCarInfo1(value02, value1, value2, value3, value4);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value03 = DataCanbus.DATA[11];
                int value12 = DataCanbus.DATA[12];
                int value22 = DataCanbus.DATA[13];
                int value32 = DataCanbus.DATA[14];
                int value42 = DataCanbus.DATA[15];
                int value04 = value03 + 1;
                if (value04 > 1) {
                    value04 = 0;
                }
                setCarInfo1(value04, value12, value22, value32, value42);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value05 = DataCanbus.DATA[11];
                int value13 = DataCanbus.DATA[12];
                int value23 = DataCanbus.DATA[13];
                int value33 = DataCanbus.DATA[14];
                int value43 = DataCanbus.DATA[15];
                int value14 = value13 - 1;
                if (value14 < 0) {
                    value14 = 5;
                }
                setCarInfo1(value05, value14, value23, value33, value43);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value06 = DataCanbus.DATA[11];
                int value15 = DataCanbus.DATA[12];
                int value24 = DataCanbus.DATA[13];
                int value34 = DataCanbus.DATA[14];
                int value44 = DataCanbus.DATA[15];
                int value16 = value15 + 1;
                if (value16 > 5) {
                    value16 = 0;
                }
                setCarInfo1(value06, value16, value24, value34, value44);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value07 = DataCanbus.DATA[11];
                int value17 = DataCanbus.DATA[12];
                int value25 = DataCanbus.DATA[13];
                int value35 = DataCanbus.DATA[14];
                int value45 = DataCanbus.DATA[15];
                int value26 = value25 - 1;
                if (value26 < 0) {
                    value26 = 3;
                }
                setCarInfo1(value07, value17, value26, value35, value45);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value08 = DataCanbus.DATA[11];
                int value18 = DataCanbus.DATA[12];
                int value27 = DataCanbus.DATA[13];
                int value36 = DataCanbus.DATA[14];
                int value46 = DataCanbus.DATA[15];
                int value28 = value27 + 1;
                if (value28 > 3) {
                    value28 = 0;
                }
                setCarInfo1(value08, value18, value28, value36, value46);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value09 = DataCanbus.DATA[11];
                int value19 = DataCanbus.DATA[12];
                int value29 = DataCanbus.DATA[13];
                int value37 = DataCanbus.DATA[14];
                int value47 = DataCanbus.DATA[15];
                int value38 = value37 - 1;
                if (value38 < 0) {
                    value38 = 1;
                }
                setCarInfo1(value09, value19, value29, value38, value47);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value010 = DataCanbus.DATA[11];
                int value110 = DataCanbus.DATA[12];
                int value210 = DataCanbus.DATA[13];
                int value39 = DataCanbus.DATA[14];
                int value48 = DataCanbus.DATA[15];
                int value310 = value39 + 1;
                if (value310 > 1) {
                    value310 = 0;
                }
                setCarInfo1(value010, value110, value210, value310, value48);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value011 = DataCanbus.DATA[11];
                int value111 = DataCanbus.DATA[12];
                int value211 = DataCanbus.DATA[13];
                int value311 = DataCanbus.DATA[14];
                int value49 = DataCanbus.DATA[15] - 1;
                if (value49 < 0) {
                    value49 = 1;
                }
                setCarInfo1(value011, value111, value211, value311, value49);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value012 = DataCanbus.DATA[11];
                int value112 = DataCanbus.DATA[12];
                int value212 = DataCanbus.DATA[13];
                int value312 = DataCanbus.DATA[14];
                int value410 = DataCanbus.DATA[15] + 1;
                if (value410 > 1) {
                    value410 = 0;
                }
                setCarInfo1(value012, value112, value212, value312, value410);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(1, 1);
                setCarInfo(1, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(2, 1);
                setCarInfo(2, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(3, 1);
                setCarInfo(3, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
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

    @Override
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
