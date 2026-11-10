package com.syu.carinfo.rzc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Rzc_ZiYouguang_EV_Info extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_EV_Info.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 227:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text1)).setText("Hybrid");
                                break;
                            case 2:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text1)).setText("Sport");
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            default:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text1)).setText("----");
                                break;
                            case 4:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text1)).setText("e-Save");
                                break;
                            case 8:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text1)).setText("Electric");
                                break;
                        }
                    }
                    break;
                case 228:
                case 231:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text2)) != null) {
                        int flag = DataCanbus.DATA[231];
                        int data = DataCanbus.DATA[228];
                        if (flag == 1 || data > 4095) {
                            ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text2)).setText("----");
                        } else {
                            ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text2)).setText(String.valueOf(data) + " kW");
                        }
                    }
                    break;
                case 229:
                case 233:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text3)) != null) {
                        int flag2 = DataCanbus.DATA[233];
                        int data2 = DataCanbus.DATA[229];
                        if (flag2 == 1) {
                            ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text3)).setText("----");
                        } else {
                            ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text3)).setText(String.valueOf(data2 - 125) + " kW");
                        }
                    }
                    break;
                case 230:
                case 232:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text4)) != null) {
                        int flag3 = DataCanbus.DATA[232];
                        int data3 = DataCanbus.DATA[230];
                        if (flag3 == 1 || data3 > 127) {
                            ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text4)).setText("----");
                        } else {
                            ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text4)).setText(String.valueOf(data3) + " kW");
                        }
                    }
                    break;
                case 234:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " kW");
                    }
                    break;
                case 235:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " kW");
                    }
                    break;
                case 236:
                    ((CheckedTextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 237:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text7)).setText("15");
                                break;
                            case 2:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text7)).setText("30");
                                break;
                            case 3:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text7)).setText("45");
                                break;
                            default:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text7)).setText("0");
                                break;
                        }
                    }
                    break;
                case 238:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 239:
                    ((CheckedTextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 240:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text9)).setText("15");
                                break;
                            case 2:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text9)).setText("30");
                                break;
                            case 3:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text9)).setText("45");
                                break;
                            default:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text9)).setText("0");
                                break;
                        }
                    }
                    break;
                case 241:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 242:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text11)).setText("15");
                                break;
                            case 2:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text11)).setText("30");
                                break;
                            case 3:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text11)).setText("45");
                                break;
                            default:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text11)).setText("0");
                                break;
                        }
                    }
                    break;
                case 243:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 244:
                    ((CheckedTextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 245:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text13)).setText("15");
                                break;
                            case 2:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text13)).setText("30");
                                break;
                            case 3:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text13)).setText("45");
                                break;
                            default:
                                ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text13)).setText("0");
                                break;
                        }
                    }
                    break;
                case 246:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text14)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 247:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text15)) != null) {
                        int hour = value / 60;
                        int min = value % 60;
                        ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text15)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                    }
                    break;
                case 248:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text16)) != null) {
                        int hour2 = value / 60;
                        int min2 = value % 60;
                        ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text16)).setText(String.valueOf(hour2 / 10) + (hour2 % 10) + ":" + (min2 / 10) + (min2 % 10));
                    }
                    break;
                case 250:
                    if (((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) Rzc_ZiYouguang_EV_Info.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value) + "%");
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_rzc_ev_info);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int data5_b7;
        int data3_b7;
        int data1;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int data2 = DataCanbus.DATA[236];
                int data2_b65 = DataCanbus.DATA[237];
                int data2_b40 = DataCanbus.DATA[238];
                int data3_b8 = DataCanbus.DATA[239];
                int data3_b65 = DataCanbus.DATA[240];
                int data3_b40 = DataCanbus.DATA[241];
                int data4_b65 = DataCanbus.DATA[242];
                int data4_b40 = DataCanbus.DATA[243];
                int data5_b8 = DataCanbus.DATA[244];
                int data5_b65 = DataCanbus.DATA[245];
                int data5_b40 = DataCanbus.DATA[246];
                int data2_b66 = data2_b65 - 1;
                if (data2_b66 < 0) {
                    data2_b66 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data2, ((data2_b66 << 5) & 96) | (data2_b40 & 31), ((data3_b8 << 7) & 128) | ((data3_b65 << 5) & 96) | (data3_b40 & 31), ((data4_b65 << 5) & 96) | (data4_b40 & 31), ((data5_b8 << 7) & 128) | ((data5_b65 << 5) & 96) | (data5_b40 & 31), 0}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int data3 = DataCanbus.DATA[236];
                int data2_b67 = DataCanbus.DATA[237];
                int data2_b41 = DataCanbus.DATA[238];
                int data3_b9 = DataCanbus.DATA[239];
                int data3_b66 = DataCanbus.DATA[240];
                int data3_b41 = DataCanbus.DATA[241];
                int data4_b66 = DataCanbus.DATA[242];
                int data4_b41 = DataCanbus.DATA[243];
                int data5_b9 = DataCanbus.DATA[244];
                int data5_b66 = DataCanbus.DATA[245];
                int data5_b41 = DataCanbus.DATA[246];
                int data2_b68 = data2_b67 + 1;
                if (data2_b68 > 3) {
                    data2_b68 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data3, ((data2_b68 << 5) & 96) | (data2_b41 & 31), ((data3_b9 << 7) & 128) | ((data3_b66 << 5) & 96) | (data3_b41 & 31), ((data4_b66 << 5) & 96) | (data4_b41 & 31), ((data5_b9 << 7) & 128) | ((data5_b66 << 5) & 96) | (data5_b41 & 31), 0}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int data4 = DataCanbus.DATA[236];
                int data2_b69 = DataCanbus.DATA[237];
                int data2_b42 = DataCanbus.DATA[238];
                int data3_b10 = DataCanbus.DATA[239];
                int data3_b67 = DataCanbus.DATA[240];
                int data3_b42 = DataCanbus.DATA[241];
                int data4_b67 = DataCanbus.DATA[242];
                int data4_b42 = DataCanbus.DATA[243];
                int data5_b10 = DataCanbus.DATA[244];
                int data5_b67 = DataCanbus.DATA[245];
                int data5_b42 = DataCanbus.DATA[246];
                int data2_b43 = data2_b42 - 1;
                if (data2_b43 < 0) {
                    data2_b43 = 23;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data4, ((data2_b69 << 5) & 96) | (data2_b43 & 31), ((data3_b10 << 7) & 128) | ((data3_b67 << 5) & 96) | (data3_b42 & 31), ((data4_b67 << 5) & 96) | (data4_b42 & 31), ((data5_b10 << 7) & 128) | ((data5_b67 << 5) & 96) | (data5_b42 & 31), 0}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int data5 = DataCanbus.DATA[236];
                int data2_b610 = DataCanbus.DATA[237];
                int data2_b44 = DataCanbus.DATA[238];
                int data3_b11 = DataCanbus.DATA[239];
                int data3_b68 = DataCanbus.DATA[240];
                int data3_b43 = DataCanbus.DATA[241];
                int data4_b68 = DataCanbus.DATA[242];
                int data4_b43 = DataCanbus.DATA[243];
                int data5_b11 = DataCanbus.DATA[244];
                int data5_b68 = DataCanbus.DATA[245];
                int data5_b43 = DataCanbus.DATA[246];
                int data2_b45 = data2_b44 + 1;
                if (data2_b45 > 23) {
                    data2_b45 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data5, ((data2_b610 << 5) & 96) | (data2_b45 & 31), ((data3_b11 << 7) & 128) | ((data3_b68 << 5) & 96) | (data3_b43 & 31), ((data4_b68 << 5) & 96) | (data4_b43 & 31), ((data5_b11 << 7) & 128) | ((data5_b68 << 5) & 96) | (data5_b43 & 31), 0}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int data6 = DataCanbus.DATA[236];
                int data2_b611 = DataCanbus.DATA[237];
                int data2_b46 = DataCanbus.DATA[238];
                int data3_b12 = DataCanbus.DATA[239];
                int data3_b69 = DataCanbus.DATA[240];
                int data3_b44 = DataCanbus.DATA[241];
                int data4_b69 = DataCanbus.DATA[242];
                int data4_b44 = DataCanbus.DATA[243];
                int data5_b12 = DataCanbus.DATA[244];
                int data5_b69 = DataCanbus.DATA[245];
                int data5_b44 = DataCanbus.DATA[246];
                int data3_b610 = data3_b69 - 1;
                if (data3_b610 < 0) {
                    data3_b610 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data6, ((data2_b611 << 5) & 96) | (data2_b46 & 31), ((data3_b12 << 7) & 128) | ((data3_b610 << 5) & 96) | (data3_b44 & 31), ((data4_b69 << 5) & 96) | (data4_b44 & 31), ((data5_b12 << 7) & 128) | ((data5_b69 << 5) & 96) | (data5_b44 & 31), 0}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int data7 = DataCanbus.DATA[236];
                int data2_b612 = DataCanbus.DATA[237];
                int data2_b47 = DataCanbus.DATA[238];
                int data3_b13 = DataCanbus.DATA[239];
                int data3_b611 = DataCanbus.DATA[240];
                int data3_b45 = DataCanbus.DATA[241];
                int data4_b610 = DataCanbus.DATA[242];
                int data4_b45 = DataCanbus.DATA[243];
                int data5_b13 = DataCanbus.DATA[244];
                int data5_b610 = DataCanbus.DATA[245];
                int data5_b45 = DataCanbus.DATA[246];
                int data3_b612 = data3_b611 + 1;
                if (data3_b612 > 3) {
                    data3_b612 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data7, ((data2_b612 << 5) & 96) | (data2_b47 & 31), ((data3_b13 << 7) & 128) | ((data3_b612 << 5) & 96) | (data3_b45 & 31), ((data4_b610 << 5) & 96) | (data4_b45 & 31), ((data5_b13 << 7) & 128) | ((data5_b610 << 5) & 96) | (data5_b45 & 31), 0}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int data8 = DataCanbus.DATA[236];
                int data2_b613 = DataCanbus.DATA[237];
                int data2_b48 = DataCanbus.DATA[238];
                int data3_b14 = DataCanbus.DATA[239];
                int data3_b613 = DataCanbus.DATA[240];
                int data3_b46 = DataCanbus.DATA[241];
                int data4_b611 = DataCanbus.DATA[242];
                int data4_b46 = DataCanbus.DATA[243];
                int data5_b14 = DataCanbus.DATA[244];
                int data5_b611 = DataCanbus.DATA[245];
                int data5_b46 = DataCanbus.DATA[246];
                int data3_b47 = data3_b46 - 1;
                if (data3_b47 < 0) {
                    data3_b47 = 23;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data8, ((data2_b613 << 5) & 96) | (data2_b48 & 31), ((data3_b14 << 7) & 128) | ((data3_b613 << 5) & 96) | (data3_b47 & 31), ((data4_b611 << 5) & 96) | (data4_b46 & 31), ((data5_b14 << 7) & 128) | ((data5_b611 << 5) & 96) | (data5_b46 & 31), 0}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int data9 = DataCanbus.DATA[236];
                int data2_b614 = DataCanbus.DATA[237];
                int data2_b49 = DataCanbus.DATA[238];
                int data3_b15 = DataCanbus.DATA[239];
                int data3_b614 = DataCanbus.DATA[240];
                int data3_b48 = DataCanbus.DATA[241];
                int data4_b612 = DataCanbus.DATA[242];
                int data4_b47 = DataCanbus.DATA[243];
                int data5_b15 = DataCanbus.DATA[244];
                int data5_b612 = DataCanbus.DATA[245];
                int data5_b47 = DataCanbus.DATA[246];
                int data3_b49 = data3_b48 + 1;
                if (data3_b49 > 23) {
                    data3_b49 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data9, ((data2_b614 << 5) & 96) | (data2_b49 & 31), ((data3_b15 << 7) & 128) | ((data3_b614 << 5) & 96) | (data3_b49 & 31), ((data4_b612 << 5) & 96) | (data4_b47 & 31), ((data5_b15 << 7) & 128) | ((data5_b612 << 5) & 96) | (data5_b47 & 31), 0}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int data10 = DataCanbus.DATA[236];
                int data2_b615 = DataCanbus.DATA[237];
                int data2_b410 = DataCanbus.DATA[238];
                int data3_b16 = DataCanbus.DATA[239];
                int data3_b615 = DataCanbus.DATA[240];
                int data3_b410 = DataCanbus.DATA[241];
                int data4_b613 = DataCanbus.DATA[242];
                int data4_b48 = DataCanbus.DATA[243];
                int data5_b16 = DataCanbus.DATA[244];
                int data5_b613 = DataCanbus.DATA[245];
                int data5_b48 = DataCanbus.DATA[246];
                int data4_b614 = data4_b613 - 1;
                if (data4_b614 < 0) {
                    data4_b614 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data10, ((data2_b615 << 5) & 96) | (data2_b410 & 31), ((data3_b16 << 7) & 128) | ((data3_b615 << 5) & 96) | (data3_b410 & 31), ((data4_b614 << 5) & 96) | (data4_b48 & 31), ((data5_b16 << 7) & 128) | ((data5_b613 << 5) & 96) | (data5_b48 & 31), 0}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int data11 = DataCanbus.DATA[236];
                int data2_b616 = DataCanbus.DATA[237];
                int data2_b411 = DataCanbus.DATA[238];
                int data3_b17 = DataCanbus.DATA[239];
                int data3_b616 = DataCanbus.DATA[240];
                int data3_b411 = DataCanbus.DATA[241];
                int data4_b615 = DataCanbus.DATA[242];
                int data4_b49 = DataCanbus.DATA[243];
                int data5_b17 = DataCanbus.DATA[244];
                int data5_b614 = DataCanbus.DATA[245];
                int data5_b49 = DataCanbus.DATA[246];
                int data4_b616 = data4_b615 + 1;
                if (data4_b616 > 3) {
                    data4_b616 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data11, ((data2_b616 << 5) & 96) | (data2_b411 & 31), ((data3_b17 << 7) & 128) | ((data3_b616 << 5) & 96) | (data3_b411 & 31), ((data4_b616 << 5) & 96) | (data4_b49 & 31), ((data5_b17 << 7) & 128) | ((data5_b614 << 5) & 96) | (data5_b49 & 31), 0}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int data12 = DataCanbus.DATA[236];
                int data2_b617 = DataCanbus.DATA[237];
                int data2_b412 = DataCanbus.DATA[238];
                int data3_b18 = DataCanbus.DATA[239];
                int data3_b617 = DataCanbus.DATA[240];
                int data3_b412 = DataCanbus.DATA[241];
                int data4_b617 = DataCanbus.DATA[242];
                int data4_b410 = DataCanbus.DATA[243];
                int data5_b18 = DataCanbus.DATA[244];
                int data5_b615 = DataCanbus.DATA[245];
                int data5_b410 = DataCanbus.DATA[246];
                int data4_b411 = data4_b410 - 1;
                if (data4_b411 < 0) {
                    data4_b411 = 23;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data12, ((data2_b617 << 5) & 96) | (data2_b412 & 31), ((data3_b18 << 7) & 128) | ((data3_b617 << 5) & 96) | (data3_b412 & 31), ((data4_b617 << 5) & 96) | (data4_b411 & 31), ((data5_b18 << 7) & 128) | ((data5_b615 << 5) & 96) | (data5_b410 & 31), 0}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int data13 = DataCanbus.DATA[236];
                int data2_b618 = DataCanbus.DATA[237];
                int data2_b413 = DataCanbus.DATA[238];
                int data3_b19 = DataCanbus.DATA[239];
                int data3_b618 = DataCanbus.DATA[240];
                int data3_b413 = DataCanbus.DATA[241];
                int data4_b618 = DataCanbus.DATA[242];
                int data4_b412 = DataCanbus.DATA[243];
                int data5_b19 = DataCanbus.DATA[244];
                int data5_b616 = DataCanbus.DATA[245];
                int data5_b411 = DataCanbus.DATA[246];
                int data4_b413 = data4_b412 + 1;
                if (data4_b413 > 23) {
                    data4_b413 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data13, ((data2_b618 << 5) & 96) | (data2_b413 & 31), ((data3_b19 << 7) & 128) | ((data3_b618 << 5) & 96) | (data3_b413 & 31), ((data4_b618 << 5) & 96) | (data4_b413 & 31), ((data5_b19 << 7) & 128) | ((data5_b616 << 5) & 96) | (data5_b411 & 31), 0}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int data14 = DataCanbus.DATA[236];
                int data2_b619 = DataCanbus.DATA[237];
                int data2_b414 = DataCanbus.DATA[238];
                int data3_b20 = DataCanbus.DATA[239];
                int data3_b619 = DataCanbus.DATA[240];
                int data3_b414 = DataCanbus.DATA[241];
                int data4_b619 = DataCanbus.DATA[242];
                int data4_b414 = DataCanbus.DATA[243];
                int data5_b20 = DataCanbus.DATA[244];
                int data5_b617 = DataCanbus.DATA[245];
                int data5_b412 = DataCanbus.DATA[246];
                int data5_b618 = data5_b617 - 1;
                if (data5_b618 < 0) {
                    data5_b618 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data14, ((data2_b619 << 5) & 96) | (data2_b414 & 31), ((data3_b20 << 7) & 128) | ((data3_b619 << 5) & 96) | (data3_b414 & 31), ((data4_b619 << 5) & 96) | (data4_b414 & 31), ((data5_b20 << 7) & 128) | ((data5_b618 << 5) & 96) | (data5_b412 & 31), 0}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int data15 = DataCanbus.DATA[236];
                int data2_b620 = DataCanbus.DATA[237];
                int data2_b415 = DataCanbus.DATA[238];
                int data3_b21 = DataCanbus.DATA[239];
                int data3_b620 = DataCanbus.DATA[240];
                int data3_b415 = DataCanbus.DATA[241];
                int data4_b620 = DataCanbus.DATA[242];
                int data4_b415 = DataCanbus.DATA[243];
                int data5_b21 = DataCanbus.DATA[244];
                int data5_b619 = DataCanbus.DATA[245];
                int data5_b413 = DataCanbus.DATA[246];
                int data5_b620 = data5_b619 + 1;
                if (data5_b620 > 3) {
                    data5_b620 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data15, ((data2_b620 << 5) & 96) | (data2_b415 & 31), ((data3_b21 << 7) & 128) | ((data3_b620 << 5) & 96) | (data3_b415 & 31), ((data4_b620 << 5) & 96) | (data4_b415 & 31), ((data5_b21 << 7) & 128) | ((data5_b620 << 5) & 96) | (data5_b413 & 31), 0}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int data16 = DataCanbus.DATA[236];
                int data2_b621 = DataCanbus.DATA[237];
                int data2_b416 = DataCanbus.DATA[238];
                int data3_b22 = DataCanbus.DATA[239];
                int data3_b621 = DataCanbus.DATA[240];
                int data3_b416 = DataCanbus.DATA[241];
                int data4_b621 = DataCanbus.DATA[242];
                int data4_b416 = DataCanbus.DATA[243];
                int data5_b22 = DataCanbus.DATA[244];
                int data5_b621 = DataCanbus.DATA[245];
                int data5_b414 = DataCanbus.DATA[246] - 1;
                if (data5_b414 < 0) {
                    data5_b414 = 23;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data16, ((data2_b621 << 5) & 96) | (data2_b416 & 31), ((data3_b22 << 7) & 128) | ((data3_b621 << 5) & 96) | (data3_b416 & 31), ((data4_b621 << 5) & 96) | (data4_b416 & 31), ((data5_b22 << 7) & 128) | ((data5_b621 << 5) & 96) | (data5_b414 & 31), 0}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int data17 = DataCanbus.DATA[236];
                int data2_b622 = DataCanbus.DATA[237];
                int data2_b417 = DataCanbus.DATA[238];
                int data3_b23 = DataCanbus.DATA[239];
                int data3_b622 = DataCanbus.DATA[240];
                int data3_b417 = DataCanbus.DATA[241];
                int data4_b622 = DataCanbus.DATA[242];
                int data4_b417 = DataCanbus.DATA[243];
                int data5_b23 = DataCanbus.DATA[244];
                int data5_b622 = DataCanbus.DATA[245];
                int data5_b415 = DataCanbus.DATA[246] + 1;
                if (data5_b415 > 23) {
                    data5_b415 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data17, ((data2_b622 << 5) & 96) | (data2_b417 & 31), ((data3_b23 << 7) & 128) | ((data3_b622 << 5) & 96) | (data3_b417 & 31), ((data4_b622 << 5) & 96) | (data4_b417 & 31), ((data5_b23 << 7) & 128) | ((data5_b622 << 5) & 96) | (data5_b415 & 31), 0}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int data18 = DataCanbus.DATA[236];
                int data2_b623 = DataCanbus.DATA[237];
                int data2_b418 = DataCanbus.DATA[238];
                int data3_b24 = DataCanbus.DATA[239];
                int data3_b623 = DataCanbus.DATA[240];
                int data3_b418 = DataCanbus.DATA[241];
                int data4_b623 = DataCanbus.DATA[242];
                int data4_b418 = DataCanbus.DATA[243];
                int data5_b24 = DataCanbus.DATA[244];
                int data5_b623 = DataCanbus.DATA[245];
                int data5_b416 = DataCanbus.DATA[246];
                if (data18 == 1) {
                    data1 = 0;
                } else {
                    data1 = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data1, ((data2_b623 << 5) & 96) | (data2_b418 & 31), ((data3_b24 << 7) & 128) | ((data3_b623 << 5) & 96) | (data3_b418 & 31), ((data4_b623 << 5) & 96) | (data4_b418 & 31), ((data5_b24 << 7) & 128) | ((data5_b623 << 5) & 96) | (data5_b416 & 31), 0}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int data19 = DataCanbus.DATA[236];
                int data2_b624 = DataCanbus.DATA[237];
                int data2_b419 = DataCanbus.DATA[238];
                int data3_b25 = DataCanbus.DATA[239];
                int data3_b624 = DataCanbus.DATA[240];
                int data3_b419 = DataCanbus.DATA[241];
                int data4_b624 = DataCanbus.DATA[242];
                int data4_b419 = DataCanbus.DATA[243];
                int data5_b25 = DataCanbus.DATA[244];
                int data5_b624 = DataCanbus.DATA[245];
                int data5_b417 = DataCanbus.DATA[246];
                if (data3_b25 == 1) {
                    data3_b7 = 0;
                } else {
                    data3_b7 = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data19, ((data2_b624 << 5) & 96) | (data2_b419 & 31), ((data3_b7 << 7) & 128) | ((data3_b624 << 5) & 96) | (data3_b419 & 31), ((data4_b624 << 5) & 96) | (data4_b419 & 31), ((data5_b25 << 7) & 128) | ((data5_b624 << 5) & 96) | (data5_b417 & 31), 0}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int data20 = DataCanbus.DATA[236];
                int data2_b625 = DataCanbus.DATA[237];
                int data2_b420 = DataCanbus.DATA[238];
                int data3_b26 = DataCanbus.DATA[239];
                int data3_b625 = DataCanbus.DATA[240];
                int data3_b420 = DataCanbus.DATA[241];
                int data4_b625 = DataCanbus.DATA[242];
                int data4_b420 = DataCanbus.DATA[243];
                int data5_b26 = DataCanbus.DATA[244];
                int data5_b625 = DataCanbus.DATA[245];
                int data5_b418 = DataCanbus.DATA[246];
                if (data5_b26 == 1) {
                    data5_b7 = 0;
                } else {
                    data5_b7 = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{0, data20, ((data2_b625 << 5) & 96) | (data2_b420 & 31), ((data3_b26 << 7) & 128) | ((data3_b625 << 5) & 96) | (data3_b420 & 31), ((data4_b625 << 5) & 96) | (data4_b420 & 31), ((data5_b7 << 7) & 128) | ((data5_b625 << 5) & 96) | (data5_b418 & 31), 0}, null, null);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mCanbusNotify);
    }
}
