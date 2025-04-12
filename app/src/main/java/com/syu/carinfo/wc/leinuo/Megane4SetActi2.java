package com.syu.carinfo.wc.leinuo;

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

public class Megane4SetActi2 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 153:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 154:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 155:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 156:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 157:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 158:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 160:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 161:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 162:
                case 163:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text10)) != null) {
                        int msbdata = DataCanbus.DATA[162];
                        int lsbdata = DataCanbus.DATA[163];
                        ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text10)).setText(String.valueOf((msbdata * 256) + lsbdata) + "km");
                        break;
                    }
                case 164:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 165:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 3:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text2)).setText("90s");
                                break;
                            case 4:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text2)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 168:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 169:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 170:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value * 5).toString());
                        break;
                    }
                case 171:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value * 5).toString());
                        break;
                    }
                case 172:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 174:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 175:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_high);
                                break;
                            default:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                                break;
                        }
                    }
                    break;
                case 176:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 177:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 178:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 179:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 180:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 181:
                    Megane4SetActi2.this.setCheck((CheckedTextView) Megane4SetActi2.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 182:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_Manual);
                                break;
                            default:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 183:
                    if (((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text9)).setText(R.string.stop_mode2_str);
                                break;
                            case 2:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text9)).setText(R.string.stop_mode3_str);
                                break;
                            default:
                                ((TextView) Megane4SetActi2.this.findViewById(R.id.tv_text9)).setText(R.string.stop_mode1_str);
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
        //setContentView(R.layout.layout_0352_wc_magane_settings2);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[161];
                if (value > 30) {
                    value -= 5;
                }
                if (value < 30) {
                    value = 30;
                }
                setCarInfo(59, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[161];
                if (value2 < 220) {
                    value2 += 5;
                }
                if (value2 > 220) {
                    value2 = 220;
                }
                setCarInfo(59, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[165] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(62, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[165] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(62, value4, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[170];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(84, value5, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[170];
                if (value6 < 20) {
                    value6++;
                }
                setCarInfo(84, value6, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[171];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(85, value7, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[171];
                if (value8 < 20) {
                    value8++;
                }
                setCarInfo(85, value8, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[172];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(86, value9, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[172];
                if (value10 < 50) {
                    value10++;
                }
                setCarInfo(86, value10, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[175] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(65, value11, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[175] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(65, value12, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[176];
                if (value13 > 1) {
                    value13--;
                }
                setCarInfo(66, value13, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[176];
                if (value14 < 5) {
                    value14++;
                }
                setCarInfo(66, value14, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[182] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(72, value15, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[182] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(72, value16, 0, 0);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[183] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(90, value17, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[183] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(90, value18, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value19 = DataCanbus.DATA[153];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(53, value19, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value20 = DataCanbus.DATA[154];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(54, value20, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value21 = DataCanbus.DATA[155];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(55, value21, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value22 = DataCanbus.DATA[156];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(56, value22, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value23 = DataCanbus.DATA[157];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(57, value23, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value24 = DataCanbus.DATA[158];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(58, value24, 0, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value25 = DataCanbus.DATA[160];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(63, value25, 0, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value26 = DataCanbus.DATA[164];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(61, value26, 0, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value27 = DataCanbus.DATA[168];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(82, value27, 0, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value28 = DataCanbus.DATA[169];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(83, value28, 0, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value29 = DataCanbus.DATA[174];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(64, value29, 0, 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value30 = DataCanbus.DATA[177];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(67, value30, 0, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value31 = DataCanbus.DATA[178];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(68, value31, 0, 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value32 = DataCanbus.DATA[179];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(69, value32, 0, 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value33 = DataCanbus.DATA[180];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(70, value33, 0, 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value34 = DataCanbus.DATA[181];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(71, value34, 0, 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                creatShowDialog();
                break;
        }
    }

    private void creatShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_other_set_Maintenance_Reset));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        Megane4SetActi2.this.setCarInfo(60, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Megane4SetActi2.this.setCarInfo(60, 0, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
    }
}
