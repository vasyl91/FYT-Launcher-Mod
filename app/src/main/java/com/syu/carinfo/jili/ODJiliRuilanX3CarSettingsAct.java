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

@SuppressWarnings({"deprecation", "unchecked"})
public class ODJiliRuilanX3CarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
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
                case 99:
                    ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    break;
                case 100:
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
                case 101:
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
                case 102:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 103:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 104:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                case 105:
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
                case 106:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 107:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 120:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 121:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 122:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 123:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 124:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text8)).setText("所有车门");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text8)).setText("驾驶门");
                            break;
                    }
                case 125:
                    ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "km/h");
                    break;
                case 126:
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
                case 127:
                    ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 128:
                    ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text12)).setText("报警+辅助");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text12)).setText("报警");
                            break;
                    }
                case 130:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 131:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text13)).setText("报警+制动");
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text13)).setText("报警");
                            break;
                    }
                case 132:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 133:
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
                case 186:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 187:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 188:
                    ODJiliRuilanX3CarSettingsAct.this.setCheck((CheckedTextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 189:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text15)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text15)).setText("10km/h");
                            break;
                        case 2:
                            ((TextView) ODJiliRuilanX3CarSettingsAct.this.findViewById(R.id.tv_text15)).setText("20km/h");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_jili_ruilan_x3_settings);
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
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_OD_Jilie_JiheA /* 2228679 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                break;
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
                findViewById(R.id.layout_view13).setVisibility(0);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[99];
                if (value3 > 1) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[99];
                if (value4 < 8) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[100] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[100] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[104] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[104] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[105] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(8, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[105] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(8, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[101] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(4, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[101] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(4, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[125] - 5;
                if (value13 < 35) {
                    value13 = 35;
                }
                setCarInfo(17, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[125] + 5;
                if (value14 > 220) {
                    value14 = 220;
                }
                setCarInfo(17, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[124] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(16, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[124] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(16, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[126] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(18, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[126] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(18, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[127] - 1;
                if (value19 < 1) {
                    value19 = 8;
                }
                setCarInfo(19, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[127] + 1;
                if (value20 > 8) {
                    value20 = 1;
                }
                setCarInfo(19, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[128];
                if (value21 > 0) {
                    value21--;
                }
                setCarInfo(20, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[128];
                if (value22 < 100) {
                    value22++;
                }
                setCarInfo(20, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[129] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(21, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[129] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(21, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[131] - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                setCarInfo(23, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[131] + 1;
                if (value26 > 1) {
                    value26 = 0;
                }
                setCarInfo(23, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[133] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(24, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[133] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfo(24, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[189] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(32, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[189] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarInfo(32, value30);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value31 = DataCanbus.DATA[121];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(11, value31);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value32 = DataCanbus.DATA[102];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(5, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value33 = DataCanbus.DATA[103];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(6, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value34 = DataCanbus.DATA[106];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(9, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value35 = DataCanbus.DATA[107];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(10, value35);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value36 = DataCanbus.DATA[120];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(12, value36);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                dialog(R.string.str_298_tpms_cal, 13);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value37 = DataCanbus.DATA[122];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(14, value37);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value38 = DataCanbus.DATA[123];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(15, value38);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value39 = DataCanbus.DATA[130];
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                setCarInfo(22, value39);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value40 = DataCanbus.DATA[132];
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                setCarInfo(25, value40);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value41 = DataCanbus.DATA[186];
                if (value41 == 0) {
                    value41 = 1;
                } else if (value41 == 1) {
                    value41 = 0;
                }
                setCarInfo(33, value41);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value42 = DataCanbus.DATA[187];
                if (value42 == 0) {
                    value42 = 1;
                } else if (value42 == 1) {
                    value42 = 0;
                }
                setCarInfo(30, value42);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value43 = DataCanbus.DATA[188];
                if (value43 == 0) {
                    value43 = 1;
                } else if (value43 == 1) {
                    value43 = 0;
                }
                setCarInfo(31, value43);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{80}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
    }
}
