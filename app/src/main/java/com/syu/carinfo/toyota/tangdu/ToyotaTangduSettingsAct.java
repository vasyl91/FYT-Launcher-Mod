package com.syu.carinfo.toyota.tangdu;

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
public class ToyotaTangduSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.toyota.tangdu.ToyotaTangduSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 109:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 110:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text4)).setText("7.5S");
                                break;
                            case 2:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text4)).setText("15S");
                                break;
                            case 3:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text4)).setText("30S");
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text5)).setText("30S");
                                break;
                            case 2:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text5)).setText("60S");
                                break;
                            case 3:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text5)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 112:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 113:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 114:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 115:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 116:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_0);
                                break;
                            case 1:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_1);
                                break;
                            case 2:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_2);
                                break;
                            case 3:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_3);
                                break;
                            case 4:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_4);
                                break;
                            case 5:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_5);
                                break;
                            case 6:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_6);
                                break;
                        }
                    }
                    break;
                case 117:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 118:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 119:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.lock_set_unlock_intelligent_door_all);
                                break;
                            case 1:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.lock_set_unlock_intelligent_door_driver);
                                break;
                        }
                    }
                    break;
                case 120:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 121:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 122:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 123:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 134:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 135:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            case 1:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            case 1:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 138:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 139:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 140:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 152:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text9)).setText("2010");
                                break;
                            case 1:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text9)).setText("2016");
                                break;
                        }
                    }
                    break;
                case 153:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 154:
                    if (((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) ToyotaTangduSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 155:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 156:
                    ToyotaTangduSettingsAct.this.setCheck((CheckedTextView) ToyotaTangduSettingsAct.this.findViewById(R.id.ctv_checkedtext19), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_toyota_tangdu_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[112];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[116] - 1;
                if (value2 < 0) {
                    value2 = 6;
                }
                setCarInfo(5, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[116] + 1;
                if (value3 > 6) {
                    value3 = 0;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[109] - 1;
                if (value4 < 0) {
                    value4 = 4;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[109] + 1;
                if (value5 > 4) {
                    value5 = 0;
                }
                setCarInfo(6, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[110] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(12, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[110] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(12, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[111] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[111] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[138];
                if (value10 > 1) {
                    value10--;
                }
                setCarInfo(21, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[138];
                if (value11 < 5) {
                    value11++;
                }
                setCarInfo(21, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[137] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(24, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[137] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(24, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[135] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(23, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[135] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(23, value15);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value16 = DataCanbus.DATA[152] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                setCarInfo4(2, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value17 = DataCanbus.DATA[152] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setCarInfo4(2, value17);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value18 = DataCanbus.DATA[153] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                setCarInfo4(3, value18);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value19 = DataCanbus.DATA[153] + 1;
                if (value19 > 1) {
                    value19 = 0;
                }
                setCarInfo4(3, value19);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value20 = DataCanbus.DATA[154] - 1;
                if (value20 < 0) {
                    value20 = 1;
                }
                setCarInfo4(4, value20);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value21 = DataCanbus.DATA[154] + 1;
                if (value21 > 1) {
                    value21 = 0;
                }
                setCarInfo4(4, value21);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value22 = DataCanbus.DATA[113];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(1, value22);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value23 = DataCanbus.DATA[114];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(2, value23);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value24 = DataCanbus.DATA[115];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(3, value24);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value25 = DataCanbus.DATA[117];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(13, value25);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value26 = DataCanbus.DATA[118];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(14, value26);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value27 = DataCanbus.DATA[119];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(15, value27);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value28 = DataCanbus.DATA[120];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(16, value28);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value29 = DataCanbus.DATA[121];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(17, value29);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value30 = DataCanbus.DATA[122];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(18, value30);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value31 = DataCanbus.DATA[123];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(19, value31);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value32 = DataCanbus.DATA[108];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(4, value32);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value33 = DataCanbus.DATA[134];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(22, value33);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                setCarInfo(66, 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                setCarInfo(66, 2);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value34 = DataCanbus.DATA[139];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo1(96, value34);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value35 = DataCanbus.DATA[140];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo1(97, value35);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value36 = DataCanbus.DATA[155];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo4(5, value36);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value37 = DataCanbus.DATA[156];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo4(6, value37);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo1(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo4(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
    }
}
