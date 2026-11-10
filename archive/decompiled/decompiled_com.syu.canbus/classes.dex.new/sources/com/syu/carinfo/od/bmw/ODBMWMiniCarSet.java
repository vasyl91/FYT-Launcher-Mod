package com.syu.carinfo.od.bmw;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class ODBMWMiniCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.bmw.ODBMWMiniCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 102:
                    if (((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text1)) != null) {
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
                    if (((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text2)) != null) {
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
                    if (((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text3)) != null) {
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
                    if (((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text4)) != null) {
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
                    if (((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text5)) != null) {
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
                    if (((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "km/h");
                    }
                    break;
                case 108:
                    if (((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "s");
                    }
                    break;
                case 109:
                    ODBMWMiniCarSet.this.setCheck((CheckedTextView) ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 110:
                    ODBMWMiniCarSet.this.setCheck((CheckedTextView) ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 111:
                    ODBMWMiniCarSet.this.setCheck((CheckedTextView) ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 112:
                    if (((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text8)) != null) {
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
                    ODBMWMiniCarSet.this.setCheck((CheckedTextView) ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 114:
                    ODBMWMiniCarSet.this.setCheck((CheckedTextView) ODBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 115:
                    if (((TextView) ODBMWMiniCarSet.this.findViewById(R.id.tv_text9)) != null) {
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_bmw_mini_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value0 = DataCanbus.DATA[102];
                int value1 = DataCanbus.DATA[103];
                int value2 = DataCanbus.DATA[104];
                int value3 = DataCanbus.DATA[105];
                int value4 = DataCanbus.DATA[106];
                int value5 = value0 - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo1(value5, value1, value2, value3, value4);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value6 = DataCanbus.DATA[102];
                int value7 = DataCanbus.DATA[103];
                int value8 = DataCanbus.DATA[104];
                int value9 = DataCanbus.DATA[105];
                int value10 = DataCanbus.DATA[106];
                int value11 = value6 + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo1(value11, value7, value8, value9, value10);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value12 = DataCanbus.DATA[102];
                int value13 = DataCanbus.DATA[103];
                int value14 = DataCanbus.DATA[104];
                int value15 = DataCanbus.DATA[105];
                int value16 = DataCanbus.DATA[106];
                int value17 = value13 - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo1(value12, value17, value14, value15, value16);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value18 = DataCanbus.DATA[102];
                int value19 = DataCanbus.DATA[103];
                int value20 = DataCanbus.DATA[104];
                int value21 = DataCanbus.DATA[105];
                int value22 = DataCanbus.DATA[106];
                int value23 = value19 + 1;
                if (value23 > 1) {
                    value23 = 0;
                }
                setCarInfo1(value18, value23, value20, value21, value22);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value24 = DataCanbus.DATA[102];
                int value25 = DataCanbus.DATA[103];
                int value26 = DataCanbus.DATA[104];
                int value27 = DataCanbus.DATA[105];
                int value28 = DataCanbus.DATA[106];
                int value29 = value26 - 1;
                if (value29 < 0) {
                    value29 = 1;
                }
                setCarInfo1(value24, value25, value29, value27, value28);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value30 = DataCanbus.DATA[102];
                int value31 = DataCanbus.DATA[103];
                int value32 = DataCanbus.DATA[104];
                int value33 = DataCanbus.DATA[105];
                int value34 = DataCanbus.DATA[106];
                int value35 = value32 + 1;
                if (value35 > 1) {
                    value35 = 0;
                }
                setCarInfo1(value30, value31, value35, value33, value34);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value36 = DataCanbus.DATA[102];
                int value37 = DataCanbus.DATA[103];
                int value38 = DataCanbus.DATA[104];
                int value39 = DataCanbus.DATA[105];
                int value40 = DataCanbus.DATA[106];
                int value41 = value39 - 1;
                if (value41 < 0) {
                    value41 = 3;
                }
                setCarInfo1(value36, value37, value38, value41, value40);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value42 = DataCanbus.DATA[102];
                int value43 = DataCanbus.DATA[103];
                int value44 = DataCanbus.DATA[104];
                int value45 = DataCanbus.DATA[105];
                int value46 = DataCanbus.DATA[106];
                int value47 = value45 + 1;
                if (value47 > 3) {
                    value47 = 0;
                }
                setCarInfo1(value42, value43, value44, value47, value46);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value48 = DataCanbus.DATA[102];
                int value49 = DataCanbus.DATA[103];
                int value50 = DataCanbus.DATA[104];
                int value51 = DataCanbus.DATA[105];
                int value52 = DataCanbus.DATA[106] - 1;
                if (value52 < 0) {
                    value52 = 1;
                }
                setCarInfo1(value48, value49, value50, value51, value52);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value53 = DataCanbus.DATA[102];
                int value54 = DataCanbus.DATA[103];
                int value55 = DataCanbus.DATA[104];
                int value56 = DataCanbus.DATA[105];
                int value57 = DataCanbus.DATA[106] + 1;
                if (value57 > 1) {
                    value57 = 0;
                }
                setCarInfo1(value53, value54, value55, value56, value57);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value = DataCanbus.DATA[107];
                if (value > 0) {
                    value -= 5;
                }
                if (value < 0) {
                    value = 0;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value58 = DataCanbus.DATA[107];
                if (value58 < 255) {
                    value58 += 5;
                }
                if (value58 > 255) {
                    value58 = 255;
                }
                setCarInfo(2, value58);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value59 = DataCanbus.DATA[108];
                if (value59 > 0) {
                    value59 -= 10;
                }
                if (value59 < 0) {
                    value59 = 0;
                }
                setCarInfo(3, value59);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value60 = DataCanbus.DATA[108];
                if (value60 < 240) {
                    value60 += 10;
                }
                if (value60 > 240) {
                    value60 = 240;
                }
                setCarInfo(3, value60);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value61 = DataCanbus.DATA[112] - 1;
                if (value61 < 0) {
                    value61 = 1;
                }
                setCarInfo(7, value61);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value62 = DataCanbus.DATA[112] + 1;
                if (value62 > 1) {
                    value62 = 0;
                }
                setCarInfo(7, value62);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value63 = DataCanbus.DATA[109];
                if (value63 == 1) {
                    value63 = 0;
                } else if (value63 == 0) {
                    value63 = 1;
                }
                setCarInfo(4, value63);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value64 = DataCanbus.DATA[113];
                if (value64 == 1) {
                    value64 = 0;
                } else if (value64 == 0) {
                    value64 = 1;
                }
                setCarInfo(8, value64);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value65 = DataCanbus.DATA[114];
                if (value65 == 1) {
                    value65 = 0;
                } else if (value65 == 0) {
                    value65 = 1;
                }
                setCarInfo(9, value65);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value66 = DataCanbus.DATA[110];
                if (value66 == 1) {
                    value66 = 0;
                } else if (value66 == 0) {
                    value66 = 1;
                }
                setCarInfo(5, value66);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value67 = DataCanbus.DATA[111];
                if (value67 == 1) {
                    value67 = 0;
                } else if (value67 == 0) {
                    value67 = 1;
                }
                setCarInfo(6, value67);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                dialog(R.string.bsd_klj_str15, 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
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

    @Override // com.syu.canbus.BaseActivity
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
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.bmw.ODBMWMiniCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.bmw.ODBMWMiniCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.bmw.ODBMWMiniCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
