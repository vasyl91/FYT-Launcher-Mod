package com.syu.carinfo.jili;

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
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ODJiliRuilanX3CarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliRuilanX3CarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_eco);
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_sport);
                            break;
                        case 2:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_comfort);
                            break;
                    }
                case 87:
                    ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    break;
                case 88:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text3)).setText("30s");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text3)).setText("60s");
                            break;
                        case 2:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text3)).setText("90s");
                            break;
                    }
                case 89:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                            break;
                    }
                case 90:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 91:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 92:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                case 93:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text5)).setText("L1");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text5)).setText("L2");
                            break;
                        case 2:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text5)).setText("L3");
                            break;
                    }
                case 94:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 95:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 108:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 109:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 110:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 111:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 112:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text8)).setText("所有车门");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text8)).setText("驾驶门");
                            break;
                    }
                case 113:
                    ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "km/h");
                    break;
                case 114:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text9)).setText("关闭");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text9)).setText("开启");
                            break;
                        case 2:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text9)).setText("自动");
                            break;
                    }
                case 115:
                    ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 116:
                    ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 117:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text12)).setText("报警+辅助");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text12)).setText("报警");
                            break;
                    }
                case 118:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 119:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text13)).setText("报警+制动");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text13)).setText("报警");
                            break;
                    }
                case 120:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 121:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text14)).setText("低");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text14)).setText("中");
                            break;
                        case 2:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text14)).setText("高");
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_jili_ruilan_x3_settings);
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
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.jili.ODJiliRuilanX3CarSettingsAct.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.jili.ODJiliRuilanX3CarSettingsAct.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.jili.ODJiliRuilanX3CarSettingsAct.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[119] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(23, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[119] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(23, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[121] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(24, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[121] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(24, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value5 = DataCanbus.DATA[109];
                if (value5 == 0) {
                    value5 = 1;
                } else if (value5 == 1) {
                    value5 = 0;
                }
                setCarInfo(11, value5);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value6 = DataCanbus.DATA[86] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(1, value6);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value7 = DataCanbus.DATA[86] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(1, value7);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value8 = DataCanbus.DATA[87];
                if (value8 > 1) {
                    value8--;
                }
                setCarInfo(2, value8);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value9 = DataCanbus.DATA[87];
                if (value9 < 8) {
                    value9++;
                }
                setCarInfo(2, value9);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value10 = DataCanbus.DATA[88] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value11 = DataCanbus.DATA[88] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(3, value11);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value12 = DataCanbus.DATA[92] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value13 = DataCanbus.DATA[92] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(7, value13);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value14 = DataCanbus.DATA[93] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value15 = DataCanbus.DATA[93] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(8, value15);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value16 = DataCanbus.DATA[89] - 1;
                if (value16 < 0) {
                    value16 = 3;
                }
                setCarInfo(4, value16);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value17 = DataCanbus.DATA[89] + 1;
                if (value17 > 3) {
                    value17 = 0;
                }
                setCarInfo(4, value17);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value18 = DataCanbus.DATA[113] - 5;
                if (value18 < 35) {
                    value18 = 35;
                }
                setCarInfo(17, value18);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value19 = DataCanbus.DATA[113] + 5;
                if (value19 > 220) {
                    value19 = 220;
                }
                setCarInfo(17, value19);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value20 = DataCanbus.DATA[112] - 1;
                if (value20 < 0) {
                    value20 = 1;
                }
                setCarInfo(16, value20);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value21 = DataCanbus.DATA[112] + 1;
                if (value21 > 1) {
                    value21 = 0;
                }
                setCarInfo(16, value21);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value22 = DataCanbus.DATA[114] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(18, value22);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value23 = DataCanbus.DATA[114] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarInfo(18, value23);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value24 = DataCanbus.DATA[115] - 1;
                if (value24 < 1) {
                    value24 = 8;
                }
                setCarInfo(19, value24);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value25 = DataCanbus.DATA[115] + 1;
                if (value25 > 8) {
                    value25 = 1;
                }
                setCarInfo(19, value25);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value26 = DataCanbus.DATA[116];
                if (value26 > 0) {
                    value26--;
                }
                setCarInfo(20, value26);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value27 = DataCanbus.DATA[116];
                if (value27 < 100) {
                    value27++;
                }
                setCarInfo(20, value27);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value28 = DataCanbus.DATA[117] - 1;
                if (value28 < 0) {
                    value28 = 1;
                }
                setCarInfo(21, value28);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value29 = DataCanbus.DATA[117] + 1;
                if (value29 > 1) {
                    value29 = 0;
                }
                setCarInfo(21, value29);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value30 = DataCanbus.DATA[90];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(5, value30);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value31 = DataCanbus.DATA[91];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(6, value31);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value32 = DataCanbus.DATA[94];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(9, value32);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value33 = DataCanbus.DATA[95];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(10, value33);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value34 = DataCanbus.DATA[108];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(12, value34);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                dialog(R.string.str_298_tpms_cal, 13);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value35 = DataCanbus.DATA[110];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(14, value35);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value36 = DataCanbus.DATA[111];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(15, value36);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value37 = DataCanbus.DATA[118];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(22, value37);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value38 = DataCanbus.DATA[120];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(25, value38);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{80}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
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
    }
}