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

public class WCFeiyateSetFunc2 extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 135:
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
                case 136:
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
                case 137:
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
                case 138:
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
                case 139:
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
                case 140:
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
                case 141:
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
                case 142:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 143:
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
                case 144:
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
                case 145:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 146:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 148:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 149:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 150:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 162:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text12)).setText(R.string.str_warning_assist);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text12)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 163:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 164:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text13)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text13)).setText(R.string.jeep_parksense_1);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 165:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text14)).setText(R.string.str_steering_maintain);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text14)).setText(R.string.str_steering_maintain_vibrate);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text14)).setText(R.string.str_vibrate);
                                break;
                        }
                    }
                    break;
                case 166:
                    if (((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc2.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 167:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 168:
                    WCFeiyateSetFunc2.this.setCheck((CheckedTextView) WCFeiyateSetFunc2.this.findViewById(R.id.ctv_checkedtext8), value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_feiyate_setfunc2);
        init();
    }

    @Override
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
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_feiyate_brake_0));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[135] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(39, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[135] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(39, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[136] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(40, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[136] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(40, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[137] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(41, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[137] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(41, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[138] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(42, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[138] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(42, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[139] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(43, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[139] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(43, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[140] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(44, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[140] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(44, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[141] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(45, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[141] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(45, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[143] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(47, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[143] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(47, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[144] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(36, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[144] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(36, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[148] - 1;
                if (value19 < 1) {
                    value19 = 4;
                }
                setCarInfo(35, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[148] + 1;
                if (value20 > 4) {
                    value20 = 1;
                }
                setCarInfo(35, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[150] - 5;
                if (value21 < 30) {
                    value21 = 30;
                }
                setCarInfo(33, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[150] + 5;
                if (value22 > 180) {
                    value22 = 180;
                }
                setCarInfo(33, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[162] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(48, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[162] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(48, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[164] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(49, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[164] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(49, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[165] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(51, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[165] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfo(51, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[166] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(52, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[166] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarInfo(52, value30);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(46, DataCanbus.DATA[142] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(37, DataCanbus.DATA[145] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(38, DataCanbus.DATA[146] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(32, DataCanbus.DATA[149] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                dialog(R.string.jeep_brakemode, 34);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(50, DataCanbus.DATA[163] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(53, DataCanbus.DATA[167] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(54, DataCanbus.DATA[168] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.notifyCanbus);
    }
}
