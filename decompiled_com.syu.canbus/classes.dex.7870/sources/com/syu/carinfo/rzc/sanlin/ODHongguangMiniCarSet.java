package com.syu.carinfo.rzc.sanlin;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ODHongguangMiniCarSet extends BaseActivity implements View.OnClickListener {
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODHongguangMiniCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 99:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_driving_comfort);
                                break;
                            case 1:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.mateng_air_con_profile_2);
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ODHongguangMiniCarSet.this.findViewById(R.id.layout_view1).setVisibility(8);
                        ODHongguangMiniCarSet.this.findViewById(R.id.layout_view2).setVisibility(8);
                        switch (value) {
                            case 0:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.driver_system_economics);
                                break;
                            case 1:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.driver_system_sports);
                                break;
                            case 3:
                                ODHongguangMiniCarSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                                ODHongguangMiniCarSet.this.findViewById(R.id.layout_view2).setVisibility(0);
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.wc_golf_custom);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value * 10) + "%");
                    }
                    break;
                case 102:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value * 10) + "%");
                    }
                    break;
                case 103:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.dj_airuize7_prompt_light);
                                break;
                            case 1:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.dj_airuize7_prompt_lightsounds);
                                break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.dj_airuize7_prompt_light);
                                break;
                            case 1:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.dj_airuize7_prompt_lightsounds);
                                break;
                        }
                    }
                    break;
                case 105:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 106:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text12)).setText("10s");
                                break;
                            case 1:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text12)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text12)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 107:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 108:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 109:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.xp_psa_all_string_door_open_0);
                                break;
                            case 2:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.xp_psa_all_string_door_open_1);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.xp_psa_all_string_door_open_0);
                                break;
                            case 1:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.xp_psa_all_string_door_open_1);
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.xp_accord9_auto_light_0lowest);
                                break;
                            case 1:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.xp_accord9_auto_light_1lower);
                                break;
                            case 2:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.xp_accord9_auto_light_2middle);
                                break;
                            case 3:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.xp_accord9_auto_light_4highest);
                                break;
                        }
                    }
                    break;
                case 112:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 113:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 114:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_165_cycle_one);
                                break;
                            case 2:
                                ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_loop);
                                break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 116:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 117:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 118:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 119:
                    if (((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) ODHongguangMiniCarSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 120:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 121:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 122:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 123:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 124:
                    ODHongguangMiniCarSet.this.setCheck((CheckedTextView) ODHongguangMiniCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_hongguang_mini_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_OD_26HongguangMini_EV /* 983496 */:
            case FinalCanbus.CAR_455_OD_25HongguangMini_EV /* 5571015 */:
            case FinalCanbus.CAR_455_OD_25HongguangMini_EV_H /* 5636551 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                break;
            case FinalCanbus.CAR_456_OD_26Hongguang_AiShang /* 1704392 */:
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                break;
        }
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
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODHongguangMiniCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.ODHongguangMiniCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODHongguangMiniCarSet.3
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
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[114];
                int start_h = DataCanbus.DATA[115];
                int start_min = DataCanbus.DATA[116];
                int end_h = DataCanbus.DATA[117];
                int end_min = DataCanbus.DATA[118];
                int value2 = value - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                if (value2 == 0) {
                    setCarChargeInfo(1, 0);
                    break;
                } else {
                    switch (value2) {
                        case 1:
                            setCarCharge2Info(2, start_h, start_min, end_h, end_min, 0);
                            break;
                        case 2:
                            setCarCharge2Info(2, start_h, start_min, end_h, end_min, 1);
                            break;
                    }
                }
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value3 = DataCanbus.DATA[114];
                int start_h2 = DataCanbus.DATA[115];
                int start_min2 = DataCanbus.DATA[116];
                int end_h2 = DataCanbus.DATA[117];
                int end_min2 = DataCanbus.DATA[118];
                int value4 = value3 + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                if (value4 == 0) {
                    setCarChargeInfo(1, 0);
                    break;
                } else {
                    switch (value4) {
                        case 1:
                            setCarCharge2Info(2, start_h2, start_min2, end_h2, end_min2, 0);
                            break;
                        case 2:
                            setCarCharge2Info(2, start_h2, start_min2, end_h2, end_min2, 1);
                            break;
                    }
                }
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value5 = DataCanbus.DATA[114];
                int start_h3 = DataCanbus.DATA[115];
                int start_min3 = DataCanbus.DATA[116];
                int end_h3 = DataCanbus.DATA[117];
                int end_min3 = DataCanbus.DATA[118];
                int start_h4 = start_h3 - 1;
                if (start_h4 < 0) {
                    start_h4 = 23;
                }
                switch (value5) {
                    case 1:
                        setCarCharge2Info(2, start_h4, start_min3, end_h3, end_min3, 0);
                        break;
                    case 2:
                        setCarCharge2Info(2, start_h4, start_min3, end_h3, end_min3, 1);
                        break;
                }
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value6 = DataCanbus.DATA[114];
                int start_h5 = DataCanbus.DATA[115];
                int start_min4 = DataCanbus.DATA[116];
                int end_h4 = DataCanbus.DATA[117];
                int end_min4 = DataCanbus.DATA[118];
                int start_h6 = start_h5 + 1;
                if (start_h6 > 23) {
                    start_h6 = 0;
                }
                switch (value6) {
                    case 1:
                        setCarCharge2Info(2, start_h6, start_min4, end_h4, end_min4, 0);
                        break;
                    case 2:
                        setCarCharge2Info(2, start_h6, start_min4, end_h4, end_min4, 1);
                        break;
                }
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value7 = DataCanbus.DATA[114];
                int start_h7 = DataCanbus.DATA[115];
                int start_min5 = DataCanbus.DATA[116];
                int end_h5 = DataCanbus.DATA[117];
                int end_min5 = DataCanbus.DATA[118];
                int start_min6 = start_min5 - 5;
                if (start_min6 < 0) {
                    start_min6 = 0;
                }
                switch (value7) {
                    case 1:
                        setCarCharge2Info(2, start_h7, start_min6, end_h5, end_min5, 0);
                        break;
                    case 2:
                        setCarCharge2Info(2, start_h7, start_min6, end_h5, end_min5, 1);
                        break;
                }
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value8 = DataCanbus.DATA[114];
                int start_h8 = DataCanbus.DATA[115];
                int start_min7 = DataCanbus.DATA[116];
                int end_h6 = DataCanbus.DATA[117];
                int end_min6 = DataCanbus.DATA[118];
                int start_min8 = start_min7 + 5;
                if (start_min8 > 55) {
                    start_min8 = 55;
                }
                switch (value8) {
                    case 1:
                        setCarCharge2Info(2, start_h8, start_min8, end_h6, end_min6, 0);
                        break;
                    case 2:
                        setCarCharge2Info(2, start_h8, start_min8, end_h6, end_min6, 1);
                        break;
                }
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value9 = DataCanbus.DATA[114];
                int start_h9 = DataCanbus.DATA[115];
                int start_min9 = DataCanbus.DATA[116];
                int end_h7 = DataCanbus.DATA[117];
                int end_min7 = DataCanbus.DATA[118];
                int end_h8 = end_h7 + 1;
                if (end_h8 > 23) {
                    end_h8 = 0;
                }
                switch (value9) {
                    case 1:
                        setCarCharge2Info(2, start_h9, start_min9, end_h8, end_min7, 0);
                        break;
                    case 2:
                        setCarCharge2Info(2, start_h9, start_min9, end_h8, end_min7, 1);
                        break;
                }
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value10 = DataCanbus.DATA[114];
                int start_h10 = DataCanbus.DATA[115];
                int start_min10 = DataCanbus.DATA[116];
                int end_h9 = DataCanbus.DATA[117];
                int end_min8 = DataCanbus.DATA[118] + 5;
                if (end_min8 > 55) {
                    end_min8 = 55;
                }
                switch (value10) {
                    case 1:
                        setCarCharge2Info(2, start_h10, start_min10, end_h9, end_min8, 0);
                        break;
                    case 2:
                        setCarCharge2Info(2, start_h10, start_min10, end_h9, end_min8, 1);
                        break;
                }
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value11 = DataCanbus.DATA[99] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(2, value11);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value12 = DataCanbus.DATA[100] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(1, value12);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value13 = DataCanbus.DATA[101] + 1;
                if (value13 > 10) {
                    value13 = 1;
                }
                setCarInfo(3, value13);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value14 = DataCanbus.DATA[102] + 1;
                if (value14 > 10) {
                    value14 = 0;
                }
                setCarInfo(4, value14);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value15 = DataCanbus.DATA[103] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(8, value15);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int value16 = DataCanbus.DATA[104] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(9, value16);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int value17 = DataCanbus.DATA[106] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarInfo(7, value17);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int value18 = DataCanbus.DATA[109] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(12, value18);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int value19 = DataCanbus.DATA[110] + 1;
                if (value19 > 1) {
                    value19 = 0;
                }
                setCarInfo(11, value19);
                break;
            case R.id.btn_plus15 /* 2131427439 */:
                int value20 = DataCanbus.DATA[111] + 1 + 1;
                if (value20 > 4) {
                    value20 = 1;
                }
                setCarInfo(10, value20);
                break;
            case R.id.btn_plus16 /* 2131427440 */:
                int value21 = DataCanbus.DATA[119] + 1;
                if (value21 > 10) {
                    value21 = 1;
                }
                setCarInfo(18, value21);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value22 = DataCanbus.DATA[114];
                int start_h11 = DataCanbus.DATA[115];
                int start_min11 = DataCanbus.DATA[116];
                int end_h10 = DataCanbus.DATA[117];
                int end_min9 = DataCanbus.DATA[118];
                int end_h11 = end_h10 - 1;
                if (end_h11 < 0) {
                    end_h11 = 23;
                }
                switch (value22) {
                    case 1:
                        setCarCharge2Info(2, start_h11, start_min11, end_h11, end_min9, 0);
                        break;
                    case 2:
                        setCarCharge2Info(2, start_h11, start_min11, end_h11, end_min9, 1);
                        break;
                }
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value23 = DataCanbus.DATA[114];
                int start_h12 = DataCanbus.DATA[115];
                int start_min12 = DataCanbus.DATA[116];
                int end_h12 = DataCanbus.DATA[117];
                int end_min10 = DataCanbus.DATA[118] - 5;
                if (end_min10 < 0) {
                    end_min10 = 0;
                }
                switch (value23) {
                    case 1:
                        setCarCharge2Info(2, start_h12, start_min12, end_h12, end_min10, 0);
                        break;
                    case 2:
                        setCarCharge2Info(2, start_h12, start_min12, end_h12, end_min10, 1);
                        break;
                }
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value24 = DataCanbus.DATA[99] - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                setCarInfo(2, value24);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value25 = DataCanbus.DATA[100] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarInfo(1, value25);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value26 = DataCanbus.DATA[101] - 1;
                if (value26 < 1) {
                    value26 = 10;
                }
                setCarInfo(3, value26);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value27 = DataCanbus.DATA[102] - 1;
                if (value27 < 0) {
                    value27 = 10;
                }
                setCarInfo(4, value27);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value28 = DataCanbus.DATA[103] - 1;
                if (value28 < 0) {
                    value28 = 1;
                }
                setCarInfo(8, value28);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value29 = DataCanbus.DATA[104] - 1;
                if (value29 < 0) {
                    value29 = 1;
                }
                setCarInfo(9, value29);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value30 = DataCanbus.DATA[106] - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarInfo(7, value30);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int value31 = DataCanbus.DATA[109] - 1;
                if (value31 < 0) {
                    value31 = 2;
                }
                setCarInfo(12, value31);
                break;
            case R.id.btn_minus14 /* 2131427492 */:
                int value32 = DataCanbus.DATA[110] - 1;
                if (value32 < 0) {
                    value32 = 1;
                }
                setCarInfo(11, value32);
                break;
            case R.id.btn_minus15 /* 2131427494 */:
                int value33 = (DataCanbus.DATA[111] + 1) - 1;
                if (value33 < 1) {
                    value33 = 4;
                }
                setCarInfo(10, value33);
                break;
            case R.id.btn_minus16 /* 2131427496 */:
                int value34 = DataCanbus.DATA[119] - 1;
                if (value34 < 1) {
                    value34 = 10;
                }
                setCarInfo(18, value34);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                setCarInfo(5, DataCanbus.DATA[98] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                setCarInfo(13, DataCanbus.DATA[108] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                setCarInfo(17, DataCanbus.DATA[112] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                setCarInfo(6, DataCanbus.DATA[105] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                setCarInfo(14, DataCanbus.DATA[107] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                setCarInfo(15, DataCanbus.DATA[113] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                dialog(R.string.accumulated_mileage, 16);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                setCarInfo(19, DataCanbus.DATA[120] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                setCarInfo(21, DataCanbus.DATA[122] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                setCarInfo(23, DataCanbus.DATA[124] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                setCarInfo(24, DataCanbus.DATA[123] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                setCarInfo(25, DataCanbus.DATA[121] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427620 */:
                dialog(R.string.xp_yinglang_car_set_Second_str10, 20);
                break;
            case R.id.ctv_checkedtext14 /* 2131427621 */:
                setCarInfo(22, 1);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    public void setCarChargeInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    public void setCarCharge2Info(int value0, int value1, int value2, int value3, int value4, int value5) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3, value4, value5}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{64}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
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
    }

    @Override // com.syu.canbus.BaseActivity
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
    }
}
