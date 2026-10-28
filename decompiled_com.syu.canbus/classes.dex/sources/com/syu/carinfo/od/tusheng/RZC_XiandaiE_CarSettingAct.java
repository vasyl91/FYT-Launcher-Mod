package com.syu.carinfo.od.tusheng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_XiandaiE_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.tusheng.RZC_XiandaiE_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 45:
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
                case 46:
                    int hour = value & 31;
                    int munite = ((value >> 5) & 7) * 10;
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(hour).toString());
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(munite).toString());
                    break;
                case 47:
                    int hour2 = value & 31;
                    int munite2 = ((value >> 5) & 7) * 10;
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(hour2).toString());
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(munite2).toString());
                    break;
                case 48:
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
                case 62:
                    if (value >= 1 && value <= 8) {
                        ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    } else {
                        ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text6)).setText("----");
                    }
                    break;
                case 63:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 64:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 65:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " KW");
                    break;
                case 66:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " Km/H");
                    break;
                case 67:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    break;
                case 69:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + " km");
                    break;
                case 70:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + " km");
                    break;
                case 71:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value) + " km");
                    break;
                case 72:
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + "%");
                    break;
                case 73:
                    int hour3 = value / 60;
                    int munite3 = value % 60;
                    ((TextView) RZC_XiandaiE_CarSettingAct.this.findViewById(R.id.tv_text16)).setText(String.valueOf(hour3) + "小时" + munite3 + "分钟");
                    break;
                case 74:
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value1 = DataCanbus.DATA[46];
                int value2 = DataCanbus.DATA[47];
                int value10 = DataCanbus.DATA[48];
                if (((value10 >> 5) & 1) == 1) {
                    value9 = value10 & 254;
                } else {
                    value9 = value10 | 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value1, value2, value9}, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value11 = DataCanbus.DATA[45];
                int value12 = value11 - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{value12}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value13 = DataCanbus.DATA[45];
                int value14 = value13 + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{value14}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value15 = DataCanbus.DATA[46];
                int value16 = DataCanbus.DATA[47];
                int value17 = DataCanbus.DATA[48];
                int m = ((value15 >> 5) & 7) - 1;
                if (m < 0) {
                    m = 5;
                }
                DataCanbus.PROXY.cmd(4, new int[]{((m << 5) & 7) | (value15 & 31), value16, value17}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value18 = DataCanbus.DATA[46];
                int value19 = DataCanbus.DATA[47];
                int value20 = DataCanbus.DATA[48];
                int m2 = ((value18 >> 5) & 7) + 1;
                if (m2 > 5) {
                    m2 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{((m2 << 5) & 7) | (value18 & 31), value19, value20}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value21 = DataCanbus.DATA[46];
                int value22 = DataCanbus.DATA[47];
                int value23 = DataCanbus.DATA[48];
                int h = (value21 & 31) - 1;
                if (h < 0) {
                    h = 23;
                }
                DataCanbus.PROXY.cmd(4, new int[]{(h & 31) | (value21 & 224), value22, value23}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value24 = DataCanbus.DATA[46];
                int value25 = DataCanbus.DATA[47];
                int value26 = DataCanbus.DATA[48];
                int h2 = (value24 & 31) + 1;
                if (h2 > 23) {
                    h2 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{(h2 & 31) | (value24 & 224), value25, value26}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value27 = DataCanbus.DATA[46];
                int value28 = DataCanbus.DATA[47];
                int value29 = DataCanbus.DATA[48];
                int m3 = ((value28 >> 5) & 7) - 1;
                if (m3 < 0) {
                    m3 = 5;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value27, ((m3 << 5) & 7) | (value28 & 31), value29}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value30 = DataCanbus.DATA[46];
                int value31 = DataCanbus.DATA[47];
                int value32 = DataCanbus.DATA[48];
                int m4 = ((value31 >> 5) & 7) + 1;
                if (m4 > 5) {
                    m4 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value30, ((m4 << 5) & 7) | (value31 & 31), value32}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value33 = DataCanbus.DATA[46];
                int value34 = DataCanbus.DATA[47];
                int value35 = DataCanbus.DATA[48];
                int h3 = (value34 & 31) - 1;
                if (h3 < 0) {
                    h3 = 23;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value33, (h3 & 31) | (value34 & 224), value35}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value36 = DataCanbus.DATA[46];
                int value37 = DataCanbus.DATA[47];
                int value38 = DataCanbus.DATA[48];
                int h4 = (value37 & 31) + 1;
                if (h4 > 23) {
                    h4 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value36, (h4 & 31) | (value37 & 224), value38}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value39 = DataCanbus.DATA[46];
                int value40 = DataCanbus.DATA[47];
                int value41 = DataCanbus.DATA[48];
                if (((value41 >> 4) & 1) == 1) {
                    value8 = value41 & 253;
                } else {
                    value8 = value41 | 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value39, value40, value8}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value42 = DataCanbus.DATA[46];
                int value43 = DataCanbus.DATA[47];
                int value44 = DataCanbus.DATA[48];
                if (((value44 >> 3) & 1) == 1) {
                    value7 = value44 & 251;
                } else {
                    value7 = value44 | 4;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value42, value43, value7}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value45 = DataCanbus.DATA[46];
                int value46 = DataCanbus.DATA[47];
                int value47 = DataCanbus.DATA[48];
                if (((value47 >> 2) & 1) == 1) {
                    value6 = value47 & 247;
                } else {
                    value6 = value47 | 8;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value45, value46, value6}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value48 = DataCanbus.DATA[46];
                int value49 = DataCanbus.DATA[47];
                int value50 = DataCanbus.DATA[48];
                if (((value50 >> 1) & 1) == 1) {
                    value5 = value50 & 239;
                } else {
                    value5 = value50 | 16;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value48, value49, value5}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value51 = DataCanbus.DATA[46];
                int value52 = DataCanbus.DATA[47];
                int value53 = DataCanbus.DATA[48];
                if (((value53 >> 0) & 1) == 1) {
                    value4 = value53 & 223;
                } else {
                    value4 = value53 | 32;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value51, value52, value4}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value54 = DataCanbus.DATA[46];
                int value55 = DataCanbus.DATA[47];
                int value56 = DataCanbus.DATA[48];
                if (((value56 >> 6) & 1) == 1) {
                    value3 = value56 & 191;
                } else {
                    value3 = value56 | 64;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value54, value55, value3}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{83, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{84, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{85, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
    }
}
