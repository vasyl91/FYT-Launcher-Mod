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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_XiandaiE_ENCINO_PreChargeSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.tusheng.RZC_XiandaiE_ENCINO_PreChargeSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 127:
                    int hour = value & 31;
                    int munite = ((value >> 5) & 7) * 10;
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(hour)).toString());
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(munite)).toString());
                    break;
                case 128:
                    int weekday1 = (value >> 0) & 1;
                    int weekday2 = (value >> 1) & 1;
                    int weekday3 = (value >> 2) & 1;
                    int weekday4 = (value >> 3) & 1;
                    int weekday5 = (value >> 4) & 1;
                    int weekday6 = (value >> 5) & 1;
                    int weekday7 = (value >> 6) & 1;
                    int onoff = (value >> 7) & 1;
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(onoff == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(weekday1 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(weekday2 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(weekday3 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(weekday4 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(weekday5 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(weekday6 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(weekday7 == 1);
                    break;
                case 129:
                    int hour2 = value & 31;
                    int munite2 = ((value >> 5) & 7) * 10;
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(hour2)).toString());
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(munite2)).toString());
                    break;
                case 130:
                    int weekday8 = (value >> 0) & 1;
                    int weekday9 = (value >> 1) & 1;
                    int weekday10 = (value >> 2) & 1;
                    int weekday11 = (value >> 3) & 1;
                    int weekday12 = (value >> 4) & 1;
                    int weekday13 = (value >> 5) & 1;
                    int weekday14 = (value >> 6) & 1;
                    int onoff2 = (value >> 7) & 1;
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(onoff2 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(weekday8 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(weekday9 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(weekday10 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(weekday11 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(weekday12 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(weekday13 == 1);
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(weekday14 == 1);
                    break;
                case 131:
                    int hour3 = value & 31;
                    int munite3 = ((value >> 5) & 7) * 10;
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(hour3)).toString());
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(munite3)).toString());
                    break;
                case 132:
                    int hour4 = value & 31;
                    int munite4 = ((value >> 5) & 7) * 10;
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(hour4)).toString());
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(munite4)).toString());
                    break;
                case 133:
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                    break;
                case 134:
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                    break;
                case 135:
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 1);
                    break;
                case 136:
                    ((CheckedTextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 1);
                    break;
                case 137:
                    switch (value) {
                        case 0:
                            ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text10)).setText("最大");
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text10)).setText("减小");
                            break;
                        case 2:
                            ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text10)).setText("最小");
                            break;
                    }
                    break;
                case 138:
                    switch (value) {
                        case 0:
                            ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text11)).setText("最大");
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text11)).setText("减小");
                            break;
                        case 2:
                            ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text11)).setText("最小");
                            break;
                    }
                    break;
                case 139:
                    int value2 = (value * 5) + 145;
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
                    break;
                case 144:
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + " Km/H");
                    break;
                case 145:
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    break;
                case 149:
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value) + " km");
                    break;
                case 150:
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + "%");
                    break;
                case 151:
                    int hour5 = value / 60;
                    int munite5 = value % 60;
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text16)).setText(String.valueOf(hour5) + "小时" + munite5 + "分钟");
                    break;
                case 152:
                    int hour6 = value / 60;
                    int munite6 = value % 60;
                    ((TextView) RZC_XiandaiE_ENCINO_PreChargeSettingAct.this.findViewById(R.id.tv_text17)).setText(String.valueOf(hour6) + "小时" + munite6 + "分钟");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0447_rzc_xiandai_encino_e_prechargesetting);
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
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int data4 = DataCanbus.DATA[127];
                int data5 = DataCanbus.DATA[128];
                int hour = data4 & 31;
                int min = (data4 >> 5) & 7;
                int hour2 = hour - 1;
                if (hour2 < 0) {
                    hour2 = 23;
                }
                DataCanbus.PROXY.cmd(15, new int[]{5, ((min << 5) & 224) | (hour2 & 31), data5}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int data6 = DataCanbus.DATA[127];
                int data7 = DataCanbus.DATA[128];
                int hour3 = data6 & 31;
                int min2 = (data6 >> 5) & 7;
                int hour4 = hour3 + 1;
                if (hour4 > 23) {
                    hour4 = 0;
                }
                DataCanbus.PROXY.cmd(15, new int[]{5, ((min2 << 5) & 224) | (hour4 & 31), data7}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int data8 = DataCanbus.DATA[127];
                int data9 = DataCanbus.DATA[128];
                int hour5 = data8 & 31;
                int min3 = ((data8 >> 5) & 7) - 1;
                if (min3 < 0) {
                    min3 = 5;
                }
                DataCanbus.PROXY.cmd(15, new int[]{5, ((min3 << 5) & 224) | (hour5 & 31), data9}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int data10 = DataCanbus.DATA[127];
                int data11 = DataCanbus.DATA[128];
                int hour6 = data10 & 31;
                int min4 = ((data10 >> 5) & 7) + 1;
                if (min4 > 5) {
                    min4 = 0;
                }
                DataCanbus.PROXY.cmd(15, new int[]{5, ((min4 << 5) & 224) | (hour6 & 31), data11}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int data12 = DataCanbus.DATA[129];
                int data13 = DataCanbus.DATA[130];
                int hour7 = data12 & 31;
                int min5 = (data12 >> 5) & 7;
                int hour8 = hour7 - 1;
                if (hour8 < 0) {
                    hour8 = 23;
                }
                DataCanbus.PROXY.cmd(15, new int[]{6, ((min5 << 5) & 224) | (hour8 & 31), data13}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int data14 = DataCanbus.DATA[129];
                int data15 = DataCanbus.DATA[130];
                int hour9 = data14 & 31;
                int min6 = (data14 >> 5) & 7;
                int hour10 = hour9 + 1;
                if (hour10 > 23) {
                    hour10 = 0;
                }
                DataCanbus.PROXY.cmd(15, new int[]{6, ((min6 << 5) & 224) | (hour10 & 31), data15}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int data16 = DataCanbus.DATA[129];
                int data17 = DataCanbus.DATA[130];
                int hour11 = data16 & 31;
                int min7 = ((data16 >> 5) & 7) - 1;
                if (min7 < 0) {
                    min7 = 5;
                }
                DataCanbus.PROXY.cmd(15, new int[]{6, ((min7 << 5) & 224) | (hour11 & 31), data17}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int data18 = DataCanbus.DATA[129];
                int data19 = DataCanbus.DATA[130];
                int hour12 = data18 & 31;
                int min8 = ((data18 >> 5) & 7) + 1;
                if (min8 > 5) {
                    min8 = 0;
                }
                DataCanbus.PROXY.cmd(15, new int[]{6, ((min8 << 5) & 224) | (hour12 & 31), data19}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int bit5 = DataCanbus.DATA[135];
                int bit4 = DataCanbus.DATA[136];
                int data20 = DataCanbus.DATA[131];
                int data21 = DataCanbus.DATA[132];
                int hour13 = data20 & 31;
                int min9 = (data20 >> 5) & 7;
                int hour14 = hour13 - 1;
                if (hour14 < 0) {
                    hour14 = 23;
                }
                int data1 = ((bit5 << 1) & 2) | (bit4 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data1, ((min9 << 5) & 224) | (hour14 & 31), data21}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int bit6 = DataCanbus.DATA[135];
                int bit7 = DataCanbus.DATA[136];
                int data22 = DataCanbus.DATA[131];
                int data23 = DataCanbus.DATA[132];
                int hour15 = data22 & 31;
                int min10 = (data22 >> 5) & 7;
                int hour16 = hour15 + 1;
                if (hour16 > 23) {
                    hour16 = 0;
                }
                int data2 = ((bit6 << 1) & 2) | (bit7 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data2, ((min10 << 5) & 224) | (hour16 & 31), data23}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int bit8 = DataCanbus.DATA[135];
                int bit9 = DataCanbus.DATA[136];
                int data24 = DataCanbus.DATA[131];
                int data25 = DataCanbus.DATA[132];
                int hour17 = data24 & 31;
                int min11 = ((data24 >> 5) & 7) - 1;
                if (min11 < 0) {
                    min11 = 5;
                }
                int data3 = ((bit8 << 1) & 2) | (bit9 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data3, ((min11 << 5) & 224) | (hour17 & 31), data25}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int bit10 = DataCanbus.DATA[135];
                int bit11 = DataCanbus.DATA[136];
                int data26 = DataCanbus.DATA[131];
                int data27 = DataCanbus.DATA[132];
                int hour18 = data26 & 31;
                int min12 = ((data26 >> 5) & 7) + 1;
                if (min12 > 5) {
                    min12 = 0;
                }
                int data28 = ((bit10 << 1) & 2) | (bit11 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data28, ((min12 << 5) & 224) | (hour18 & 31), data27}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int bit12 = DataCanbus.DATA[135];
                int bit13 = DataCanbus.DATA[136];
                int data29 = DataCanbus.DATA[131];
                int data30 = DataCanbus.DATA[132];
                int hour19 = data30 & 31;
                int min13 = (data30 >> 5) & 7;
                int hour20 = hour19 - 1;
                if (hour20 < 0) {
                    hour20 = 23;
                }
                int data31 = ((bit12 << 1) & 2) | (bit13 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data31, data29, ((min13 << 5) & 224) | (hour20 & 31)}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int bit14 = DataCanbus.DATA[135];
                int bit15 = DataCanbus.DATA[136];
                int data32 = DataCanbus.DATA[131];
                int data33 = DataCanbus.DATA[132];
                int hour21 = data33 & 31;
                int min14 = (data33 >> 5) & 7;
                int hour22 = hour21 + 1;
                if (hour22 > 23) {
                    hour22 = 0;
                }
                int data34 = ((bit14 << 1) & 2) | (bit15 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data34, data32, ((min14 << 5) & 224) | (hour22 & 31)}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int bit16 = DataCanbus.DATA[135];
                int bit17 = DataCanbus.DATA[136];
                int data35 = DataCanbus.DATA[131];
                int data36 = DataCanbus.DATA[132];
                int hour23 = data36 & 31;
                int min15 = ((data36 >> 5) & 7) - 1;
                if (min15 < 0) {
                    min15 = 5;
                }
                int data37 = ((bit16 << 1) & 2) | (bit17 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data37, data35, ((min15 << 5) & 224) | (hour23 & 31)}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int bit18 = DataCanbus.DATA[135];
                int bit19 = DataCanbus.DATA[136];
                int data38 = DataCanbus.DATA[131];
                int data39 = DataCanbus.DATA[132];
                int hour24 = data39 & 31;
                int min16 = ((data39 >> 5) & 7) + 1;
                if (min16 > 5) {
                    min16 = 0;
                }
                int data40 = ((bit18 << 1) & 2) | (bit19 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data40, data38, ((min16 << 5) & 224) | (hour24 & 31)}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int bit20 = DataCanbus.DATA[133];
                int bit21 = DataCanbus.DATA[134];
                int value = DataCanbus.DATA[139];
                if (value > 6) {
                    value--;
                }
                if (value < 6) {
                    value = 6;
                }
                int data41 = ((bit20 << 7) & 128) | ((bit21 << 6) & 64) | (value & 31);
                DataCanbus.PROXY.cmd(13, new int[]{7, data41}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int bit22 = DataCanbus.DATA[133];
                int bit23 = DataCanbus.DATA[134];
                int value2 = DataCanbus.DATA[139];
                if (value2 < 26) {
                    value2++;
                }
                if (value2 > 26) {
                    value2 = 26;
                }
                int data42 = ((bit22 << 7) & 128) | ((bit23 << 6) & 64) | (value2 & 31);
                DataCanbus.PROXY.cmd(13, new int[]{7, data42}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int bit32 = DataCanbus.DATA[137];
                int bit110 = DataCanbus.DATA[138];
                int bit33 = bit32 - 1;
                if (bit33 < 0) {
                    bit33 = 2;
                }
                int data43 = ((bit33 << 2) & 192) | (bit110 & 3);
                DataCanbus.PROXY.cmd(13, new int[]{4, data43}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int bit34 = DataCanbus.DATA[137];
                int bit111 = DataCanbus.DATA[138];
                int bit35 = bit34 + 1;
                if (bit35 > 2) {
                    bit35 = 0;
                }
                int data44 = ((bit35 << 2) & 192) | (bit111 & 3);
                DataCanbus.PROXY.cmd(13, new int[]{4, data44}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int bit36 = DataCanbus.DATA[137];
                int bit112 = DataCanbus.DATA[138] - 1;
                if (bit112 < 0) {
                    bit112 = 2;
                }
                int data45 = ((bit36 << 2) & 192) | (bit112 & 3);
                DataCanbus.PROXY.cmd(13, new int[]{4, data45}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int bit37 = DataCanbus.DATA[137];
                int bit113 = DataCanbus.DATA[138] + 1;
                if (bit113 > 2) {
                    bit113 = 0;
                }
                int data46 = ((bit37 << 2) & 192) | (bit113 & 3);
                DataCanbus.PROXY.cmd(13, new int[]{4, data46}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int data47 = DataCanbus.DATA[127];
                int data48 = DataCanbus.DATA[128];
                int onoff = (data48 >> 7) & 1;
                int week1 = (data48 >> 0) & 1;
                int week2 = (data48 >> 1) & 1;
                int week3 = (data48 >> 2) & 1;
                int week4 = (data48 >> 3) & 1;
                int week5 = (data48 >> 4) & 1;
                int week6 = (data48 >> 5) & 1;
                int week7 = (data48 >> 6) & 1;
                int onoff2 = onoff == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{5, data47, ((onoff2 << 7) & 128) | ((week7 << 6) & 64) | ((week6 << 5) & 32) | ((week5 << 4) & 16) | ((week4 << 3) & 8) | ((week3 << 2) & 4) | ((week2 << 1) & 2) | ((week1 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int data49 = DataCanbus.DATA[127];
                int data50 = DataCanbus.DATA[128];
                int onoff3 = (data50 >> 7) & 1;
                int week8 = (data50 >> 0) & 1;
                int week9 = (data50 >> 1) & 1;
                int week10 = (data50 >> 2) & 1;
                int week11 = (data50 >> 3) & 1;
                int week12 = (data50 >> 4) & 1;
                int week13 = (data50 >> 5) & 1;
                int week14 = (data50 >> 6) & 1;
                int week15 = week10 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{5, data49, ((onoff3 << 7) & 128) | ((week14 << 6) & 64) | ((week13 << 5) & 32) | ((week12 << 4) & 16) | ((week11 << 3) & 8) | ((week15 << 2) & 4) | ((week9 << 1) & 2) | ((week8 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int data51 = DataCanbus.DATA[127];
                int data52 = DataCanbus.DATA[128];
                int onoff4 = (data52 >> 7) & 1;
                int week16 = (data52 >> 0) & 1;
                int week17 = (data52 >> 1) & 1;
                int week18 = (data52 >> 2) & 1;
                int week19 = (data52 >> 3) & 1;
                int week20 = (data52 >> 4) & 1;
                int week21 = (data52 >> 5) & 1;
                int week22 = (data52 >> 6) & 1;
                int week23 = week19 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{5, data51, ((onoff4 << 7) & 128) | ((week22 << 6) & 64) | ((week21 << 5) & 32) | ((week20 << 4) & 16) | ((week23 << 3) & 8) | ((week18 << 2) & 4) | ((week17 << 1) & 2) | ((week16 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int data53 = DataCanbus.DATA[127];
                int data54 = DataCanbus.DATA[128];
                int onoff5 = (data54 >> 7) & 1;
                int week24 = (data54 >> 0) & 1;
                int week25 = (data54 >> 1) & 1;
                int week26 = (data54 >> 2) & 1;
                int week27 = (data54 >> 3) & 1;
                int week28 = (data54 >> 4) & 1;
                int week29 = (data54 >> 5) & 1;
                int week30 = (data54 >> 6) & 1;
                int week31 = week24 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{5, data53, ((onoff5 << 7) & 128) | ((week30 << 6) & 64) | ((week29 << 5) & 32) | ((week28 << 4) & 16) | ((week27 << 3) & 8) | ((week26 << 2) & 4) | ((week25 << 1) & 2) | ((week31 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int data55 = DataCanbus.DATA[127];
                int data56 = DataCanbus.DATA[128];
                int onoff6 = (data56 >> 7) & 1;
                int week32 = (data56 >> 0) & 1;
                int week33 = (data56 >> 1) & 1;
                int week34 = (data56 >> 2) & 1;
                int week35 = (data56 >> 3) & 1;
                int week36 = (data56 >> 4) & 1;
                int week37 = (data56 >> 5) & 1;
                int week38 = (data56 >> 6) & 1;
                int week39 = week33 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{5, data55, ((onoff6 << 7) & 128) | ((week38 << 6) & 64) | ((week37 << 5) & 32) | ((week36 << 4) & 16) | ((week35 << 3) & 8) | ((week34 << 2) & 4) | ((week39 << 1) & 2) | ((week32 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int data57 = DataCanbus.DATA[127];
                int data58 = DataCanbus.DATA[128];
                int onoff7 = (data58 >> 7) & 1;
                int week40 = (data58 >> 0) & 1;
                int week41 = (data58 >> 1) & 1;
                int week42 = (data58 >> 2) & 1;
                int week43 = (data58 >> 3) & 1;
                int week44 = (data58 >> 4) & 1;
                int week45 = (data58 >> 5) & 1;
                int week46 = (data58 >> 6) & 1;
                int week47 = week44 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{5, data57, ((onoff7 << 7) & 128) | ((week46 << 6) & 64) | ((week45 << 5) & 32) | ((week47 << 4) & 16) | ((week43 << 3) & 8) | ((week42 << 2) & 4) | ((week41 << 1) & 2) | ((week40 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int data59 = DataCanbus.DATA[127];
                int data60 = DataCanbus.DATA[128];
                int onoff8 = (data60 >> 7) & 1;
                int week48 = (data60 >> 0) & 1;
                int week49 = (data60 >> 1) & 1;
                int week50 = (data60 >> 2) & 1;
                int week51 = (data60 >> 3) & 1;
                int week52 = (data60 >> 4) & 1;
                int week53 = (data60 >> 5) & 1;
                int week54 = (data60 >> 6) & 1;
                int week55 = week53 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{5, data59, ((onoff8 << 7) & 128) | ((week54 << 6) & 64) | ((week55 << 5) & 32) | ((week52 << 4) & 16) | ((week51 << 3) & 8) | ((week50 << 2) & 4) | ((week49 << 1) & 2) | ((week48 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int data61 = DataCanbus.DATA[127];
                int data62 = DataCanbus.DATA[128];
                int onoff9 = (data62 >> 7) & 1;
                int week56 = (data62 >> 0) & 1;
                int week57 = (data62 >> 1) & 1;
                int week58 = (data62 >> 2) & 1;
                int week59 = (data62 >> 3) & 1;
                int week60 = (data62 >> 4) & 1;
                int week61 = (data62 >> 5) & 1;
                int week62 = (data62 >> 6) & 1;
                int week63 = week62 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{5, data61, ((onoff9 << 7) & 128) | ((week63 << 6) & 64) | ((week61 << 5) & 32) | ((week60 << 4) & 16) | ((week59 << 3) & 8) | ((week58 << 2) & 4) | ((week57 << 1) & 2) | ((week56 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int data63 = DataCanbus.DATA[129];
                int data64 = DataCanbus.DATA[130];
                int onoff10 = (data64 >> 7) & 1;
                int week64 = (data64 >> 0) & 1;
                int week65 = (data64 >> 1) & 1;
                int week66 = (data64 >> 2) & 1;
                int week67 = (data64 >> 3) & 1;
                int week68 = (data64 >> 4) & 1;
                int week69 = (data64 >> 5) & 1;
                int week70 = (data64 >> 6) & 1;
                int onoff11 = onoff10 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{6, data63, ((onoff11 << 7) & 128) | ((week70 << 6) & 64) | ((week69 << 5) & 32) | ((week68 << 4) & 16) | ((week67 << 3) & 8) | ((week66 << 2) & 4) | ((week65 << 1) & 2) | ((week64 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int data65 = DataCanbus.DATA[129];
                int data66 = DataCanbus.DATA[130];
                int onoff12 = (data66 >> 7) & 1;
                int week71 = (data66 >> 0) & 1;
                int week72 = (data66 >> 1) & 1;
                int week73 = (data66 >> 2) & 1;
                int week74 = (data66 >> 3) & 1;
                int week75 = (data66 >> 4) & 1;
                int week76 = (data66 >> 5) & 1;
                int week77 = (data66 >> 6) & 1;
                int week78 = week71 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{6, data65, ((onoff12 << 7) & 128) | ((week77 << 6) & 64) | ((week76 << 5) & 32) | ((week75 << 4) & 16) | ((week74 << 3) & 8) | ((week73 << 2) & 4) | ((week72 << 1) & 2) | ((week78 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int data67 = DataCanbus.DATA[129];
                int data68 = DataCanbus.DATA[130];
                int onoff13 = (data68 >> 7) & 1;
                int week79 = (data68 >> 0) & 1;
                int week80 = (data68 >> 1) & 1;
                int week81 = (data68 >> 2) & 1;
                int week82 = (data68 >> 3) & 1;
                int week83 = (data68 >> 4) & 1;
                int week84 = (data68 >> 5) & 1;
                int week85 = (data68 >> 6) & 1;
                int week86 = week80 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{6, data67, ((onoff13 << 7) & 128) | ((week85 << 6) & 64) | ((week84 << 5) & 32) | ((week83 << 4) & 16) | ((week82 << 3) & 8) | ((week81 << 2) & 4) | ((week86 << 1) & 2) | ((week79 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int data69 = DataCanbus.DATA[129];
                int data70 = DataCanbus.DATA[130];
                int onoff14 = (data70 >> 7) & 1;
                int week87 = (data70 >> 0) & 1;
                int week88 = (data70 >> 1) & 1;
                int week89 = (data70 >> 2) & 1;
                int week90 = (data70 >> 3) & 1;
                int week91 = (data70 >> 4) & 1;
                int week92 = (data70 >> 5) & 1;
                int week93 = (data70 >> 6) & 1;
                int week94 = week89 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{6, data69, ((onoff14 << 7) & 128) | ((week93 << 6) & 64) | ((week92 << 5) & 32) | ((week91 << 4) & 16) | ((week90 << 3) & 8) | ((week94 << 2) & 4) | ((week88 << 1) & 2) | ((week87 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int data71 = DataCanbus.DATA[129];
                int data72 = DataCanbus.DATA[130];
                int onoff15 = (data72 >> 7) & 1;
                int week95 = (data72 >> 0) & 1;
                int week96 = (data72 >> 1) & 1;
                int week97 = (data72 >> 2) & 1;
                int week98 = (data72 >> 3) & 1;
                int week99 = (data72 >> 4) & 1;
                int week100 = (data72 >> 5) & 1;
                int week101 = (data72 >> 6) & 1;
                int week102 = week98 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{6, data71, ((onoff15 << 7) & 128) | ((week101 << 6) & 64) | ((week100 << 5) & 32) | ((week99 << 4) & 16) | ((week102 << 3) & 8) | ((week97 << 2) & 4) | ((week96 << 1) & 2) | ((week95 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int data73 = DataCanbus.DATA[129];
                int data74 = DataCanbus.DATA[130];
                int onoff16 = (data74 >> 7) & 1;
                int week103 = (data74 >> 0) & 1;
                int week104 = (data74 >> 1) & 1;
                int week105 = (data74 >> 2) & 1;
                int week106 = (data74 >> 3) & 1;
                int week107 = (data74 >> 4) & 1;
                int week108 = (data74 >> 5) & 1;
                int week109 = (data74 >> 6) & 1;
                int week110 = week107 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{6, data73, ((onoff16 << 7) & 128) | ((week109 << 6) & 64) | ((week108 << 5) & 32) | ((week110 << 4) & 16) | ((week106 << 3) & 8) | ((week105 << 2) & 4) | ((week104 << 1) & 2) | ((week103 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int data75 = DataCanbus.DATA[129];
                int data76 = DataCanbus.DATA[130];
                int onoff17 = (data76 >> 7) & 1;
                int week111 = (data76 >> 0) & 1;
                int week112 = (data76 >> 1) & 1;
                int week113 = (data76 >> 2) & 1;
                int week114 = (data76 >> 3) & 1;
                int week115 = (data76 >> 4) & 1;
                int week116 = (data76 >> 5) & 1;
                int week117 = (data76 >> 6) & 1;
                int week118 = week116 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{6, data75, ((onoff17 << 7) & 128) | ((week117 << 6) & 64) | ((week118 << 5) & 32) | ((week115 << 4) & 16) | ((week114 << 3) & 8) | ((week113 << 2) & 4) | ((week112 << 1) & 2) | ((week111 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int data77 = DataCanbus.DATA[129];
                int data78 = DataCanbus.DATA[130];
                int onoff18 = (data78 >> 7) & 1;
                int week119 = (data78 >> 0) & 1;
                int week120 = (data78 >> 1) & 1;
                int week121 = (data78 >> 2) & 1;
                int week122 = (data78 >> 3) & 1;
                int week123 = (data78 >> 4) & 1;
                int week124 = (data78 >> 5) & 1;
                int week125 = (data78 >> 6) & 1;
                int week126 = week125 == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(15, new int[]{6, data77, ((onoff18 << 7) & 128) | ((week126 << 6) & 64) | ((week124 << 5) & 32) | ((week123 << 4) & 16) | ((week122 << 3) & 8) | ((week121 << 2) & 4) | ((week120 << 1) & 2) | ((week119 << 0) & 1)}, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int bit24 = DataCanbus.DATA[133];
                int bit25 = DataCanbus.DATA[134];
                int value3 = DataCanbus.DATA[139];
                int bit26 = bit24 == 1 ? 0 : 1;
                int data79 = ((bit26 << 7) & 128) | ((bit25 << 6) & 64) | (value3 & 31);
                DataCanbus.PROXY.cmd(13, new int[]{7, data79}, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int bit27 = DataCanbus.DATA[133];
                int bit28 = DataCanbus.DATA[134];
                int value4 = DataCanbus.DATA[139];
                int bit29 = bit28 == 1 ? 0 : 1;
                int data80 = ((bit27 << 7) & 128) | ((bit29 << 6) & 64) | (value4 & 31);
                DataCanbus.PROXY.cmd(13, new int[]{7, data80}, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int bit30 = DataCanbus.DATA[135];
                int bit31 = DataCanbus.DATA[136];
                int data81 = DataCanbus.DATA[131];
                int data82 = DataCanbus.DATA[132];
                int bit38 = bit30 == 1 ? 0 : 1;
                int data83 = ((bit38 << 1) & 2) | (bit31 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data83, data81, data82}, null, null);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int bit39 = DataCanbus.DATA[135];
                int bit40 = DataCanbus.DATA[136];
                int data84 = DataCanbus.DATA[131];
                int data85 = DataCanbus.DATA[132];
                int bit41 = bit40 == 1 ? 0 : 1;
                int data86 = ((bit39 << 1) & 2) | (bit41 & 1);
                DataCanbus.PROXY.cmd(14, new int[]{4, data86, data84, data85}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{83, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{84, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{85, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
    }
}
