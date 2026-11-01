package com.syu.carinfo.od.bmw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ODBMWMiniCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 102:
                    if (ODBMWMiniCarSet.this.findViewById(R.id.tv_text1) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_1);
                                break;
                            case 1:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_0);
                                break;
                            case 2:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_lauguage_set_value_20);
                                break;
                        }
                    }
                    break;
                case 103:
                    if (ODBMWMiniCarSet.this.findViewById(R.id.tv_text2) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text2)).setText("l/100km");
                                break;
                            case 1:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text2)).setText("km/l");
                                break;
                        }
                    }
                    break;
                case 104:
                    if (ODBMWMiniCarSet.this.findViewById(R.id.tv_text3) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text3)).setText("℃");
                                break;
                            case 1:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text3)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (ODBMWMiniCarSet.this.findViewById(R.id.tv_text4) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text4)).setText("日.月.年");
                                break;
                            case 1:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text4)).setText("月/日/年");
                                break;
                            case 2:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text4)).setText("年.月.日");
                                break;
                            case 3:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text4)).setText("年/月/日");
                                break;
                        }
                    }
                    break;
                case 106:
                    if (ODBMWMiniCarSet.this.findViewById(R.id.tv_text5) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_bogoo_bmw_time_format_0);
                                break;
                            case 1:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                        }
                    }
                    break;
                case 107:
                    if (ODBMWMiniCarSet.this.findViewById(R.id.tv_text6) != null) {
                        ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text6)).setText(value + "km/h");
                        break;
                    }
                case 108:
                    if (ODBMWMiniCarSet.this.findViewById(R.id.tv_text7) != null) {
                        ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text7)).setText(value + "s");
                        break;
                    }
                case 109:
                    ODBMWMiniCarSet.this.setCheck(ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 110:
                    ODBMWMiniCarSet.this.setCheck(ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 111:
                    ODBMWMiniCarSet.this.setCheck(ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 112:
                    if (ODBMWMiniCarSet.this.findViewById(R.id.tv_text8) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                            case 1:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_all_door_tailgate);
                                break;
                        }
                    }
                    break;
                case 113:
                    ODBMWMiniCarSet.this.setCheck(ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 114:
                    ODBMWMiniCarSet.this.setCheck(ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 115:
                    if (ODBMWMiniCarSet.this.findViewById(R.id.tv_text9) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_oil_signal_normal);
                                break;
                            case 1:
                                ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.setting_313_tv51str);
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
        //setContentView(R.layout.layout_0452_od_bmw_mini_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_minus4), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_minus5), this);
        setSelfClick(findViewById(R.id.btn_plus5), this);
        setSelfClick(findViewById(R.id.btn_minus6), this);
        setSelfClick(findViewById(R.id.btn_plus6), this);
        setSelfClick(findViewById(R.id.btn_minus7), this);
        setSelfClick(findViewById(R.id.btn_plus7), this);
        setSelfClick(findViewById(R.id.btn_minus8), this);
        setSelfClick(findViewById(R.id.btn_plus8), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value0 = DataCanbus.DATA[102];
                int value1 = DataCanbus.DATA[103];
                int value2 = DataCanbus.DATA[104];
                int value3 = DataCanbus.DATA[105];
                int value4 = DataCanbus.DATA[106];
                int value02 = value0 - 1;
                if (value02 < 0) {
                    value02 = 2;
                }
                setCarInfo1(value02, value1, value2, value3, value4);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value03 = DataCanbus.DATA[102];
                int value12 = DataCanbus.DATA[103];
                int value22 = DataCanbus.DATA[104];
                int value32 = DataCanbus.DATA[105];
                int value42 = DataCanbus.DATA[106];
                int value04 = value03 + 1;
                if (value04 > 2) {
                    value04 = 0;
                }
                setCarInfo1(value04, value12, value22, value32, value42);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value05 = DataCanbus.DATA[102];
                int value13 = DataCanbus.DATA[103];
                int value23 = DataCanbus.DATA[104];
                int value33 = DataCanbus.DATA[105];
                int value43 = DataCanbus.DATA[106];
                int value14 = value13 - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo1(value05, value14, value23, value33, value43);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value06 = DataCanbus.DATA[102];
                int value15 = DataCanbus.DATA[103];
                int value24 = DataCanbus.DATA[104];
                int value34 = DataCanbus.DATA[105];
                int value44 = DataCanbus.DATA[106];
                int value16 = value15 + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo1(value06, value16, value24, value34, value44);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value07 = DataCanbus.DATA[102];
                int value17 = DataCanbus.DATA[103];
                int value25 = DataCanbus.DATA[104];
                int value35 = DataCanbus.DATA[105];
                int value45 = DataCanbus.DATA[106];
                int value26 = value25 - 1;
                if (value26 < 0) {
                    value26 = 1;
                }
                setCarInfo1(value07, value17, value26, value35, value45);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value08 = DataCanbus.DATA[102];
                int value18 = DataCanbus.DATA[103];
                int value27 = DataCanbus.DATA[104];
                int value36 = DataCanbus.DATA[105];
                int value46 = DataCanbus.DATA[106];
                int value28 = value27 + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo1(value08, value18, value28, value36, value46);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value09 = DataCanbus.DATA[102];
                int value19 = DataCanbus.DATA[103];
                int value29 = DataCanbus.DATA[104];
                int value37 = DataCanbus.DATA[105];
                int value47 = DataCanbus.DATA[106];
                int value38 = value37 - 1;
                if (value38 < 0) {
                    value38 = 3;
                }
                setCarInfo1(value09, value19, value29, value38, value47);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value010 = DataCanbus.DATA[102];
                int value110 = DataCanbus.DATA[103];
                int value210 = DataCanbus.DATA[104];
                int value39 = DataCanbus.DATA[105];
                int value48 = DataCanbus.DATA[106];
                int value310 = value39 + 1;
                if (value310 > 3) {
                    value310 = 0;
                }
                setCarInfo1(value010, value110, value210, value310, value48);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value011 = DataCanbus.DATA[102];
                int value111 = DataCanbus.DATA[103];
                int value211 = DataCanbus.DATA[104];
                int value311 = DataCanbus.DATA[105];
                int value49 = DataCanbus.DATA[106] - 1;
                if (value49 < 0) {
                    value49 = 1;
                }
                setCarInfo1(value011, value111, value211, value311, value49);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value012 = DataCanbus.DATA[102];
                int value112 = DataCanbus.DATA[103];
                int value212 = DataCanbus.DATA[104];
                int value312 = DataCanbus.DATA[105];
                int value410 = DataCanbus.DATA[106] + 1;
                if (value410 > 1) {
                    value410 = 0;
                }
                setCarInfo1(value012, value112, value212, value312, value410);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value = DataCanbus.DATA[107];
                if (value > 0) {
                    value -= 5;
                }
                if (value < 0) {
                    value = 0;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value5 = DataCanbus.DATA[107];
                if (value5 < 255) {
                    value5 += 5;
                }
                if (value5 > 255) {
                    value5 = 255;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value6 = DataCanbus.DATA[108];
                if (value6 > 0) {
                    value6 -= 10;
                }
                if (value6 < 0) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value7 = DataCanbus.DATA[108];
                if (value7 < 240) {
                    value7 += 10;
                }
                if (value7 > 240) {
                    value7 = 240;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value8 = DataCanbus.DATA[112] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value9 = DataCanbus.DATA[112] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(7, value9);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value10 = DataCanbus.DATA[109];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(4, value10);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value11 = DataCanbus.DATA[110];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(5, value11);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value20 = DataCanbus.DATA[111];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(6, value20);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value21 = DataCanbus.DATA[113];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(8, value21);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value30 = DataCanbus.DATA[114];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(9, value30);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                dialog(R.string.bsd_klj_str15, 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                dialog(R.string.str_engine_oil_testing, 10);
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
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm_reset) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
