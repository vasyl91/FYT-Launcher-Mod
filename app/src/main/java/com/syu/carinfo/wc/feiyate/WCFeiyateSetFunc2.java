package com.syu.carinfo.wc.feiyate;

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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WCFeiyateSetFunc2 extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 123:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text2)).setText(R.string.str_brake);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text3)).setText(R.string.str_brake);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text4)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text4)).setText(R.string.wc_372_high);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text4)).setText(R.string.wc_372_low);
                                break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_parksense_0);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_parksense_1);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_high);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                                break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_blindwarn_1);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_blindwarn_2);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 130:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 131:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_presskeyunlock_1);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_presskeyunlock_0);
                                break;
                        }
                    }
                    break;
                case 132:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_high);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_low);
                                break;
                        }
                    }
                    break;
                case 133:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 134:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 136:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 137:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 138:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_feiyate_setfunc2);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_feiyate_brake_0));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc2.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc2.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc2.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc2.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCarInfo(46, DataCanbus.DATA[130] != 1 ? 1 : 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[123] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(39, value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[123] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(39, value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[124] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(40, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[124] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(40, value4);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value5 = DataCanbus.DATA[125] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(41, value5);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value6 = DataCanbus.DATA[125] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(41, value6);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = DataCanbus.DATA[126] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(42, value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = DataCanbus.DATA[126] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(42, value8);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value9 = DataCanbus.DATA[127] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(43, value9);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value10 = DataCanbus.DATA[127] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(43, value10);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value11 = DataCanbus.DATA[128] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(44, value11);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value12 = DataCanbus.DATA[128] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(44, value12);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value13 = DataCanbus.DATA[129] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(45, value13);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value14 = DataCanbus.DATA[129] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(45, value14);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value15 = DataCanbus.DATA[131] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(47, value15);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value16 = DataCanbus.DATA[131] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(47, value16);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value17 = DataCanbus.DATA[132] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(36, value17);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value18 = DataCanbus.DATA[132] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(36, value18);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value19 = DataCanbus.DATA[136] - 1;
                if (value19 < 1) {
                    value19 = 4;
                }
                setCarInfo(35, value19);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value20 = DataCanbus.DATA[136] + 1;
                if (value20 > 4) {
                    value20 = 1;
                }
                setCarInfo(35, value20);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value21 = DataCanbus.DATA[138] - 5;
                if (value21 < 30) {
                    value21 = 30;
                }
                setCarInfo(33, value21);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value22 = DataCanbus.DATA[138] + 5;
                if (value22 > 180) {
                    value22 = 180;
                }
                setCarInfo(33, value22);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCarInfo(37, DataCanbus.DATA[133] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfo(38, DataCanbus.DATA[134] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setCarInfo(32, DataCanbus.DATA[137] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                dialog(R.string.jeep_brakemode, 34);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
    }
}
