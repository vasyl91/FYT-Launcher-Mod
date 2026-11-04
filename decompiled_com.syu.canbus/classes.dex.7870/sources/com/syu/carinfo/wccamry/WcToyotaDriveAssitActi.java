package com.syu.carinfo.wccamry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class WcToyotaDriveAssitActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.WcToyotaDriveAssitActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 238:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 239:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text1)).setText("默认");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text1)).setText("稍后");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text1)).setText("提前");
                                break;
                        }
                    }
                    break;
                case 240:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 241:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 242:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 243:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 244:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 245:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 246:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text2)).setText("无");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text2)).setText("视觉");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text2)).setText("视觉+听觉");
                                break;
                        }
                    }
                    break;
                case 247:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text3)).setText("无");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text3)).setText("视觉");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text3)).setText("视觉+听觉");
                                break;
                        }
                    }
                    break;
                case 248:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text4)).setText("10km");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text4)).setText("5km");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text4)).setText("2km");
                                break;
                        }
                    }
                    break;
                case 249:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 250:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text5)).setText("默认");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text5)).setText("提前");
                                break;
                        }
                    }
                    break;
                case 251:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text6)).setText("震动");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text6)).setText("声音");
                                break;
                        }
                    }
                    break;
                case 252:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 253:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 254:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 255:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text7)).setText("低");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text7)).setText("中");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text7)).setText("高");
                                break;
                        }
                    }
                    break;
                case 256:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 257:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text8)).setText("低");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text8)).setText("中");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text8)).setText("高");
                                break;
                        }
                    }
                    break;
                case 258:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 259:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 260:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 261:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 262:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text9)).setText("默认");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text9)).setText("稍后");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text9)).setText("提前");
                                break;
                        }
                    }
                    break;
                case 263:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 264:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text10)).setText("暗");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text10)).setText("亮");
                                break;
                        }
                    }
                    break;
                case 265:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text11)).setText("低");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text11)).setText("中");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text11)).setText("高");
                                break;
                        }
                    }
                    break;
                case 266:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 267:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text12)).setText("低");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text12)).setText("中");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text12)).setText("高");
                                break;
                        }
                    }
                    break;
                case 268:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text13)).setText("1km");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text13)).setText("5km");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text13)).setText("10km");
                                break;
                        }
                    }
                    break;
                case 269:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text14)).setText("1km");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text14)).setText("5km");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text14)).setText("10km");
                                break;
                        }
                    }
                    break;
                case 270:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text15)).setText("关闭");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text15)).setText("低");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text15)).setText("中");
                                break;
                            case 3:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text15)).setText("高");
                                break;
                        }
                    }
                    break;
                case 271:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 272:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 273:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 274:
                    WcToyotaDriveAssitActi.this.setCheck((CheckedTextView) WcToyotaDriveAssitActi.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 275:
                    if (((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text16)).setText("默认");
                                break;
                            case 1:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text16)).setText("稍后");
                                break;
                            case 2:
                                ((TextView) WcToyotaDriveAssitActi.this.findViewById(R.id.tv_text16)).setText("提前");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0294_wc_toyota_driveassite_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[239] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(7, 2, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[239] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(7, 2, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[246] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(7, 4, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[246] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(7, 4, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[247] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(7, 5, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[247] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(7, 5, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[248] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(7, 6, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[250] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(7, 8, value8);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[251] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(7, 9, value9);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[255] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(7, 27, value10);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[257] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(7, 12, value11);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value12 = DataCanbus.DATA[262] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(7, 22, value12);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value13 = DataCanbus.DATA[264] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(7, 24, value13);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int value14 = DataCanbus.DATA[265] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(7, 33, value14);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int value15 = DataCanbus.DATA[267] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(7, 29, value15);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int value16 = DataCanbus.DATA[268] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(7, 30, value16);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int value17 = DataCanbus.DATA[269] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarInfo(7, 31, value17);
                break;
            case R.id.btn_plus15 /* 2131427439 */:
                int value18 = DataCanbus.DATA[270] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfo(7, 32, value18);
                break;
            case R.id.btn_plus16 /* 2131427440 */:
                int value19 = DataCanbus.DATA[275] + 1;
                if (value19 > 2) {
                    value19 = 0;
                }
                setCarInfo(7, 38, value19);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value20 = DataCanbus.DATA[248] - 1;
                if (value20 < 0) {
                    value20 = 2;
                }
                setCarInfo(7, 6, value20);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value21 = DataCanbus.DATA[250] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarInfo(7, 8, value21);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value22 = DataCanbus.DATA[251] - 1;
                if (value22 < 0) {
                    value22 = 1;
                }
                setCarInfo(7, 9, value22);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value23 = DataCanbus.DATA[255] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(7, 27, value23);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value24 = DataCanbus.DATA[257] - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                setCarInfo(7, 12, value24);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value25 = DataCanbus.DATA[262] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(7, 22, value25);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value26 = DataCanbus.DATA[264] - 1;
                if (value26 < 0) {
                    value26 = 1;
                }
                setCarInfo(7, 24, value26);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value27 = DataCanbus.DATA[265] - 1;
                if (value27 < 0) {
                    value27 = 1;
                }
                setCarInfo(7, 33, value27);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value28 = DataCanbus.DATA[267] - 1;
                if (value28 < 0) {
                    value28 = 2;
                }
                setCarInfo(7, 29, value28);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int value29 = DataCanbus.DATA[268] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(7, 30, value29);
                break;
            case R.id.btn_minus14 /* 2131427492 */:
                int value30 = DataCanbus.DATA[269] - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarInfo(7, 31, value30);
                break;
            case R.id.btn_minus15 /* 2131427494 */:
                int value31 = DataCanbus.DATA[270] - 1;
                if (value31 < 0) {
                    value31 = 3;
                }
                setCarInfo(7, 32, value31);
                break;
            case R.id.btn_minus16 /* 2131427496 */:
                int value32 = DataCanbus.DATA[275] - 1;
                if (value32 < 0) {
                    value32 = 2;
                }
                setCarInfo(7, 38, value32);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value33 = DataCanbus.DATA[238];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(7, 1, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value34 = DataCanbus.DATA[242];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(7, 18, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value35 = DataCanbus.DATA[243];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(7, 19, value35);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value36 = DataCanbus.DATA[240];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(7, 16, value36);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value37 = DataCanbus.DATA[241];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(7, 17, value37);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value38 = DataCanbus.DATA[244];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(7, 20, value38);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int value39 = DataCanbus.DATA[245];
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                setCarInfo(7, 3, value39);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int value40 = DataCanbus.DATA[249];
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                setCarInfo(7, 7, value40);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int value41 = DataCanbus.DATA[252];
                if (value41 == 0) {
                    value41 = 1;
                } else if (value41 == 1) {
                    value41 = 0;
                }
                setCarInfo(7, 10, value41);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                int value42 = DataCanbus.DATA[253];
                if (value42 == 0) {
                    value42 = 1;
                } else if (value42 == 1) {
                    value42 = 0;
                }
                setCarInfo(7, 25, value42);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                int value43 = DataCanbus.DATA[254];
                if (value43 == 0) {
                    value43 = 1;
                } else if (value43 == 1) {
                    value43 = 0;
                }
                setCarInfo(7, 26, value43);
                break;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                int value44 = DataCanbus.DATA[256];
                if (value44 == 0) {
                    value44 = 1;
                } else if (value44 == 1) {
                    value44 = 0;
                }
                setCarInfo(7, 11, value44);
                break;
            case R.id.ctv_checkedtext13 /* 2131427620 */:
                int value45 = DataCanbus.DATA[258];
                if (value45 == 0) {
                    value45 = 1;
                } else if (value45 == 1) {
                    value45 = 0;
                }
                setCarInfo(7, 13, value45);
                break;
            case R.id.ctv_checkedtext14 /* 2131427621 */:
                int value46 = DataCanbus.DATA[259];
                if (value46 == 0) {
                    value46 = 1;
                } else if (value46 == 1) {
                    value46 = 0;
                }
                setCarInfo(7, 14, value46);
                break;
            case R.id.ctv_checkedtext15 /* 2131427622 */:
                int value47 = DataCanbus.DATA[260];
                if (value47 == 0) {
                    value47 = 1;
                } else if (value47 == 1) {
                    value47 = 0;
                }
                setCarInfo(7, 15, value47);
                break;
            case R.id.ctv_checkedtext16 /* 2131427623 */:
                int value48 = DataCanbus.DATA[261];
                if (value48 == 0) {
                    value48 = 1;
                } else if (value48 == 1) {
                    value48 = 0;
                }
                setCarInfo(7, 21, value48);
                break;
            case R.id.ctv_checkedtext17 /* 2131427624 */:
                int value49 = DataCanbus.DATA[263];
                if (value49 == 0) {
                    value49 = 1;
                } else if (value49 == 1) {
                    value49 = 0;
                }
                setCarInfo(7, 23, value49);
                break;
            case R.id.ctv_checkedtext18 /* 2131427728 */:
                int value50 = DataCanbus.DATA[266];
                if (value50 == 0) {
                    value50 = 1;
                } else if (value50 == 1) {
                    value50 = 0;
                }
                setCarInfo(7, 28, value50);
                break;
            case R.id.ctv_checkedtext19 /* 2131427730 */:
                int value51 = DataCanbus.DATA[271];
                if (value51 == 0) {
                    value51 = 1;
                } else if (value51 == 1) {
                    value51 = 0;
                }
                setCarInfo(7, 34, value51);
                break;
            case R.id.ctv_checkedtext20 /* 2131427732 */:
                int value52 = DataCanbus.DATA[272];
                if (value52 == 0) {
                    value52 = 1;
                } else if (value52 == 1) {
                    value52 = 0;
                }
                setCarInfo(7, 35, value52);
                break;
            case R.id.ctv_checkedtext21 /* 2131427734 */:
                int value53 = DataCanbus.DATA[273];
                if (value53 == 0) {
                    value53 = 1;
                } else if (value53 == 1) {
                    value53 = 0;
                }
                setCarInfo(7, 36, value53);
                break;
            case R.id.ctv_checkedtext22 /* 2131427736 */:
                int value54 = DataCanbus.DATA[274];
                if (value54 == 0) {
                    value54 = 1;
                } else if (value54 == 1) {
                    value54 = 0;
                }
                setCarInfo(7, 37, value54);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(29, new int[]{value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[254].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[263].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[264].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[265].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[266].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[268].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[271].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[263].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[264].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[265].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[266].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[268].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[271].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
    }
}
