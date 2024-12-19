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
public class ODCHuangWeiET5CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODCHuangWeiET5CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    if (((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                            break;
                        } else {
                            ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                            break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 103:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 105:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 106:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 107:
                    if (((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("60 KM/h");
                                break;
                            case 2:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("70 KM/h");
                                break;
                            case 3:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("80 KM/h");
                                break;
                            case 4:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("90 KM/h");
                                break;
                            case 5:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("100 KM/h");
                                break;
                            case 6:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("110 KM/h");
                                break;
                            case 7:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("120 KM/h");
                                break;
                            case 8:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("130 KM/h");
                                break;
                            case 9:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("140 KM/h");
                                break;
                        }
                    }
                    break;
                case 108:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 109:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 110:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 111:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 112:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 113:
                    if (((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_chuangwei_et5_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[103];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[86];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[102];
                if (value3 > 20) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[102];
                if (value4 < 100) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value5 = DataCanbus.DATA[107];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value6 = DataCanbus.DATA[107];
                if (value6 < 9) {
                    value6++;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = DataCanbus.DATA[113];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(13, value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = DataCanbus.DATA[113];
                if (value8 < 3) {
                    value8++;
                }
                setCarInfo(13, value8);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value9 = DataCanbus.DATA[104];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(4, value9);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value10 = DataCanbus.DATA[105];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(5, value10);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value11 = DataCanbus.DATA[106];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(6, value11);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value12 = DataCanbus.DATA[108];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(8, value12);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value13 = DataCanbus.DATA[109];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(9, value13);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value14 = DataCanbus.DATA[110];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(10, value14);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value15 = DataCanbus.DATA[111];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(11, value15);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value16 = DataCanbus.DATA[112];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(12, value16);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }
}
