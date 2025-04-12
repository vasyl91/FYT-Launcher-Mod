package com.syu.carinfo.od.tusheng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_XiandaiE_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    switch (value) {
                        case 2:
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view3).setVisibility(0);
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view5).setVisibility(8);
                            ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text1)).setText("开始时间-充电率100%");
                            break;
                        case 3:
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view3).setVisibility(0);
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view4).setVisibility(0);
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view5).setVisibility(0);
                            ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text1)).setText("开始时间-结束时间");
                            break;
                        default:
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view3).setVisibility(8);
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                            RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.layout_view5).setVisibility(8);
                            ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                            break;
                    }
                case 124:
                    int hour = value & 31;
                    int munite = ((value >> 5) & 7) * 10;
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(hour).toString());
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(munite).toString());
                    break;
                case 125:
                    int hour2 = value & 31;
                    int munite2 = ((value >> 5) & 7) * 10;
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(hour2).toString());
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(munite2).toString());
                    break;
                case 126:
                    int weekday1 = (value >> 5) & 1;
                    int weekday2 = (value >> 4) & 1;
                    int weekday3 = (value >> 3) & 1;
                    int weekday4 = (value >> 2) & 1;
                    int weekday5 = (value >> 1) & 1;
                    int weekday6 = (value >> 0) & 1;
                    int weekday7 = (value >> 6) & 1;
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(weekday1 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(weekday2 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(weekday3 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(weekday4 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(weekday5 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(weekday6 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(weekday7 == 1);
                    break;
                case 140:
                    if (value >= 1 && value <= 8) {
                        ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    }
                case 141:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 142:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 143:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " KW");
                    break;
                case 144:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " Km/H");
                    break;
                case 145:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    break;
                case 147:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + " km");
                    break;
                case 148:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + " km");
                    break;
                case 149:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value) + " km");
                    break;
                case 150:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + "%");
                    break;
                case 151:
                    int hour3 = value / 60;
                    int munite3 = value % 60;
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text16)).setText(String.valueOf(hour3) + "小时" + munite3 + "分钟");
                    break;
                case 152:
                    int hour4 = value / 60;
                    int munite4 = value % 60;
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text17)).setText(String.valueOf(hour4) + "小时" + munite4 + "分钟");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0447_rzc_xiandai_e_carsetting);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        int value3;
        int value32;
        int value33;
        int value34;
        int value35;
        int value36;
        int value37;
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value1 = DataCanbus.DATA[123];
                int value12 = value1 - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{value12}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value13 = DataCanbus.DATA[123];
                int value14 = value13 + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{value14}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value15 = DataCanbus.DATA[124];
                int value2 = DataCanbus.DATA[125];
                int value38 = DataCanbus.DATA[126];
                int m = ((value15 >> 5) & 7) - 1;
                if (m < 0) {
                    m = 5;
                }
                DataCanbus.PROXY.cmd(4, new int[]{((m << 5) & 7) | (value15 & 31), value2, value38}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value16 = DataCanbus.DATA[124];
                int value22 = DataCanbus.DATA[125];
                int value39 = DataCanbus.DATA[126];
                int m2 = ((value16 >> 5) & 7) + 1;
                if (m2 > 5) {
                    m2 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{((m2 << 5) & 7) | (value16 & 31), value22, value39}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value17 = DataCanbus.DATA[124];
                int value23 = DataCanbus.DATA[125];
                int value310 = DataCanbus.DATA[126];
                int h = (value17 & 31) - 1;
                if (h < 0) {
                    h = 23;
                }
                DataCanbus.PROXY.cmd(4, new int[]{(h & 31) | (value17 & 224), value23, value310}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value18 = DataCanbus.DATA[124];
                int value24 = DataCanbus.DATA[125];
                int value311 = DataCanbus.DATA[126];
                int h2 = (value18 & 31) + 1;
                if (h2 > 23) {
                    h2 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{(h2 & 31) | (value18 & 224), value24, value311}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value19 = DataCanbus.DATA[124];
                int value25 = DataCanbus.DATA[125];
                int value312 = DataCanbus.DATA[126];
                int m3 = ((value25 >> 5) & 7) - 1;
                if (m3 < 0) {
                    m3 = 5;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value19, ((m3 << 5) & 7) | (value25 & 31), value312}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value110 = DataCanbus.DATA[124];
                int value26 = DataCanbus.DATA[125];
                int value313 = DataCanbus.DATA[126];
                int m4 = ((value26 >> 5) & 7) + 1;
                if (m4 > 5) {
                    m4 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value110, ((m4 << 5) & 7) | (value26 & 31), value313}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value111 = DataCanbus.DATA[124];
                int value27 = DataCanbus.DATA[125];
                int value314 = DataCanbus.DATA[126];
                int h3 = (value27 & 31) - 1;
                if (h3 < 0) {
                    h3 = 23;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value111, (h3 & 31) | (value27 & 224), value314}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value112 = DataCanbus.DATA[124];
                int value28 = DataCanbus.DATA[125];
                int value315 = DataCanbus.DATA[126];
                int h4 = (value28 & 31) + 1;
                if (h4 > 23) {
                    h4 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value112, (h4 & 31) | (value28 & 224), value315}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value113 = DataCanbus.DATA[124];
                int value29 = DataCanbus.DATA[125];
                int value316 = DataCanbus.DATA[126];
                if (((value316 >> 5) & 1) == 1) {
                    value37 = value316 & 254;
                } else {
                    value37 = value316 | 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value113, value29, value37}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value114 = DataCanbus.DATA[124];
                int value210 = DataCanbus.DATA[125];
                int value317 = DataCanbus.DATA[126];
                if (((value317 >> 4) & 1) == 1) {
                    value36 = value317 & 253;
                } else {
                    value36 = value317 | 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value114, value210, value36}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value115 = DataCanbus.DATA[124];
                int value211 = DataCanbus.DATA[125];
                int value318 = DataCanbus.DATA[126];
                if (((value318 >> 3) & 1) == 1) {
                    value35 = value318 & 251;
                } else {
                    value35 = value318 | 4;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value115, value211, value35}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value116 = DataCanbus.DATA[124];
                int value212 = DataCanbus.DATA[125];
                int value319 = DataCanbus.DATA[126];
                if (((value319 >> 2) & 1) == 1) {
                    value34 = value319 & 247;
                } else {
                    value34 = value319 | 8;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value116, value212, value34}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value117 = DataCanbus.DATA[124];
                int value213 = DataCanbus.DATA[125];
                int value320 = DataCanbus.DATA[126];
                if (((value320 >> 1) & 1) == 1) {
                    value33 = value320 & 239;
                } else {
                    value33 = value320 | 16;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value117, value213, value33}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value118 = DataCanbus.DATA[124];
                int value214 = DataCanbus.DATA[125];
                int value321 = DataCanbus.DATA[126];
                if (((value321 >> 0) & 1) == 1) {
                    value32 = value321 & 223;
                } else {
                    value32 = value321 | 32;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value118, value214, value32}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value119 = DataCanbus.DATA[124];
                int value215 = DataCanbus.DATA[125];
                int value322 = DataCanbus.DATA[126];
                if (((value322 >> 6) & 1) == 1) {
                    value3 = value322 & 191;
                } else {
                    value3 = value322 | 64;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value119, value215, value3}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZC_XiandaiE_InfoAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{83}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{84}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{85}, null, null);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
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
    }
}
