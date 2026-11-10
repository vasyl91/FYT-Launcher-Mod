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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_XiandaiE_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.tusheng.RZC_XiandaiE_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
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
                    break;
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
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(weekday2 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(weekday3 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(weekday4 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(weekday5 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(weekday6 == 1);
                    ((CheckedTextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(weekday7 == 1);
                    break;
                case 140:
                    if (value >= 1 && value <= 8) {
                        ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    } else {
                        ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text6)).setText("----");
                    }
                    break;
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0447_rzc_xiandai_e_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value1 = DataCanbus.DATA[123];
                int value2 = value1 - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value10 = DataCanbus.DATA[123];
                int value11 = value10 + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{value11}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value12 = DataCanbus.DATA[124];
                int value13 = DataCanbus.DATA[125];
                int value14 = DataCanbus.DATA[126];
                int m = ((value12 >> 5) & 7) - 1;
                if (m < 0) {
                    m = 5;
                }
                DataCanbus.PROXY.cmd(4, new int[]{((m << 5) & 7) | (value12 & 31), value13, value14}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value15 = DataCanbus.DATA[124];
                int value16 = DataCanbus.DATA[125];
                int value17 = DataCanbus.DATA[126];
                int m2 = ((value15 >> 5) & 7) + 1;
                if (m2 > 5) {
                    m2 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{((m2 << 5) & 7) | (value15 & 31), value16, value17}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value18 = DataCanbus.DATA[124];
                int value19 = DataCanbus.DATA[125];
                int value20 = DataCanbus.DATA[126];
                int h = (value18 & 31) - 1;
                if (h < 0) {
                    h = 23;
                }
                DataCanbus.PROXY.cmd(4, new int[]{(h & 31) | (value18 & 224), value19, value20}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value21 = DataCanbus.DATA[124];
                int value22 = DataCanbus.DATA[125];
                int value23 = DataCanbus.DATA[126];
                int h2 = (value21 & 31) + 1;
                if (h2 > 23) {
                    h2 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{(h2 & 31) | (value21 & 224), value22, value23}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value24 = DataCanbus.DATA[124];
                int value25 = DataCanbus.DATA[125];
                int value26 = DataCanbus.DATA[126];
                int m3 = ((value25 >> 5) & 7) - 1;
                if (m3 < 0) {
                    m3 = 5;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value24, ((m3 << 5) & 7) | (value25 & 31), value26}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value27 = DataCanbus.DATA[124];
                int value28 = DataCanbus.DATA[125];
                int value29 = DataCanbus.DATA[126];
                int m4 = ((value28 >> 5) & 7) + 1;
                if (m4 > 5) {
                    m4 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value27, ((m4 << 5) & 7) | (value28 & 31), value29}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value30 = DataCanbus.DATA[124];
                int value31 = DataCanbus.DATA[125];
                int value32 = DataCanbus.DATA[126];
                int h3 = (value31 & 31) - 1;
                if (h3 < 0) {
                    h3 = 23;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value30, (h3 & 31) | (value31 & 224), value32}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value33 = DataCanbus.DATA[124];
                int value34 = DataCanbus.DATA[125];
                int value35 = DataCanbus.DATA[126];
                int h4 = (value34 & 31) + 1;
                if (h4 > 23) {
                    h4 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value33, (h4 & 31) | (value34 & 224), value35}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value36 = DataCanbus.DATA[124];
                int value37 = DataCanbus.DATA[125];
                int value38 = DataCanbus.DATA[126];
                if (((value38 >> 5) & 1) == 1) {
                    value9 = value38 & 254;
                } else {
                    value9 = value38 | 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value36, value37, value9}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value39 = DataCanbus.DATA[124];
                int value40 = DataCanbus.DATA[125];
                int value41 = DataCanbus.DATA[126];
                if (((value41 >> 2) & 1) == 1) {
                    value6 = value41 & 247;
                } else {
                    value6 = value41 | 8;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value39, value40, value6}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value42 = DataCanbus.DATA[124];
                int value43 = DataCanbus.DATA[125];
                int value44 = DataCanbus.DATA[126];
                if (((value44 >> 1) & 1) == 1) {
                    value5 = value44 & 239;
                } else {
                    value5 = value44 | 16;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value42, value43, value5}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value45 = DataCanbus.DATA[124];
                int value46 = DataCanbus.DATA[125];
                int value47 = DataCanbus.DATA[126];
                if (((value47 >> 4) & 1) == 1) {
                    value8 = value47 & 253;
                } else {
                    value8 = value47 | 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value45, value46, value8}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value48 = DataCanbus.DATA[124];
                int value49 = DataCanbus.DATA[125];
                int value50 = DataCanbus.DATA[126];
                if (((value50 >> 3) & 1) == 1) {
                    value7 = value50 & 251;
                } else {
                    value7 = value50 | 4;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value48, value49, value7}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value51 = DataCanbus.DATA[124];
                int value52 = DataCanbus.DATA[125];
                int value53 = DataCanbus.DATA[126];
                if (((value53 >> 0) & 1) == 1) {
                    value4 = value53 & 223;
                } else {
                    value4 = value53 | 32;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value51, value52, value4}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value54 = DataCanbus.DATA[124];
                int value55 = DataCanbus.DATA[125];
                int value56 = DataCanbus.DATA[126];
                if (((value56 >> 6) & 1) == 1) {
                    value3 = value56 & 191;
                } else {
                    value3 = value56 | 64;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value54, value55, value3}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZC_XiandaiE_InfoAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{83, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{84, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{85, 0}, null, null);
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

    @Override // com.syu.canbus.BaseActivity
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
