package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KYCZhonghuaCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.KYCZhonghuaCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 25:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 26:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                        }
                    }
                    break;
                case 27:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 2:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                                break;
                            case 3:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 28:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 29:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 30:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 31:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 32:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_language_set1);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_language_set0);
                                break;
                        }
                    }
                    break;
                case 33:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_bogoo_bmw_time_format_0);
                                break;
                        }
                    }
                    break;
                case 34:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 35:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 36:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 37:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)).setText("30S");
                                break;
                            case 2:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)).setText("60S");
                                break;
                            case 3:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 38:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText("30S");
                                break;
                            case 2:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText("60S");
                                break;
                            case 3:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText("90S");
                                break;
                            case 4:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText("120S");
                                break;
                        }
                    }
                    break;
                case 39:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 40:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 41:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                            case 2:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 3:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_lanesensewarn_0);
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
        setContentView(R.layout.layout_0452_kyc_zhonghua_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[25];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[26] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[26] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[27] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[27] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[31];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[31];
                if (value7 < 8) {
                    value7++;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[32] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(8, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[32] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(8, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[33] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(9, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[33] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(9, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[34];
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(10, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[34];
                if (value13 < 15) {
                    value13++;
                }
                setCarInfo(10, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[37] - 1;
                if (value14 < 0) {
                    value14 = 3;
                }
                setCarInfo(13, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[37] + 1;
                if (value15 > 3) {
                    value15 = 0;
                }
                setCarInfo(13, value15);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value16 = DataCanbus.DATA[38] - 1;
                if (value16 < 0) {
                    value16 = 4;
                }
                setCarInfo(14, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value17 = DataCanbus.DATA[38] + 1;
                if (value17 > 4) {
                    value17 = 0;
                }
                setCarInfo(14, value17);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value18 = DataCanbus.DATA[41] - 1;
                if (value18 < 0) {
                    value18 = 3;
                }
                setCarInfo(17, value18);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value19 = DataCanbus.DATA[41] + 1;
                if (value19 > 3) {
                    value19 = 0;
                }
                setCarInfo(17, value19);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value20 = DataCanbus.DATA[28];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(4, value20);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value21 = DataCanbus.DATA[29];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(5, value21);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value22 = DataCanbus.DATA[30];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(6, value22);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value23 = DataCanbus.DATA[35];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(11, value23);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value24 = DataCanbus.DATA[36];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(12, value24);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value25 = DataCanbus.DATA[39];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(15, value25);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value26 = DataCanbus.DATA[40];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(16, value26);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{83}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
    }
}
