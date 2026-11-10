package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZC_GMChargeSet7InfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RZC_GMChargeSet7InfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 294:
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text1)).setText("关闭");
                                break;
                            case 1:
                                ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text1)).setText("临时即插即用");
                                break;
                            case 2:
                                ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text1)).setText("下次出发时间");
                                break;
                        }
                    }
                    break;
                case 295:
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text2)).setText("是");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text2)).setText("否");
                                break;
                        }
                    }
                    break;
                case 296:
                case 297:
                case 298:
                    int weekday = DataCanbus.DATA[296];
                    int hour = DataCanbus.DATA[297];
                    int min = DataCanbus.DATA[298];
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text6)) != null) {
                        if (weekday == 7) {
                            ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text6)).setText("星期日-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 6) {
                            ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text6)).setText("星期六-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 5) {
                            ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text6)).setText("星期五-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 4) {
                            ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text6)).setText("星期四-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 3) {
                            ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text6)).setText("星期三-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 2) {
                            ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text6)).setText("星期二-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 1) {
                            ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text6)).setText("星期一-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        }
                    }
                    break;
                case 299:
                case 300:
                    int hour2 = DataCanbus.DATA[299];
                    int min2 = DataCanbus.DATA[300];
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(hour2 / 10) + (hour2 % 10) + ":" + (min2 / 10) + (min2 % 10));
                    }
                    break;
                case 301:
                case 302:
                    int hour3 = DataCanbus.DATA[301];
                    int min3 = DataCanbus.DATA[302];
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(hour3 / 10) + (hour3 % 10) + ":" + (min3 / 10) + (min3 % 10));
                    }
                    break;
                case 303:
                case 304:
                    int hour4 = DataCanbus.DATA[303];
                    int min4 = DataCanbus.DATA[304];
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(hour4 / 10) + (hour4 % 10) + ":" + (min4 / 10) + (min4 % 10));
                    }
                    break;
                case 305:
                case 306:
                    int hour5 = DataCanbus.DATA[305];
                    int min5 = DataCanbus.DATA[306];
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(hour5 / 10) + (hour5 % 10) + ":" + (min5 / 10) + (min5 % 10));
                    }
                    break;
                case 307:
                    int hour6 = (value >> 8) & 255;
                    int min6 = value & 255;
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(hour6)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(min6)).toString());
                    }
                    break;
                case 308:
                    int hour7 = (value >> 8) & 255;
                    int min7 = value & 255;
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(hour7)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder(String.valueOf(min7)).toString());
                    }
                    break;
                case 309:
                    int hour8 = (value >> 8) & 255;
                    int min8 = value & 255;
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(hour8)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text16)).setText(new StringBuilder(String.valueOf(min8)).toString());
                    }
                    break;
                case 310:
                    int hour9 = (value >> 8) & 255;
                    int min9 = value & 255;
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text17)).setText(new StringBuilder(String.valueOf(hour9)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text18)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text18)).setText(new StringBuilder(String.valueOf(min9)).toString());
                    }
                    break;
                case 311:
                    int hour10 = (value >> 8) & 255;
                    int min10 = value & 255;
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text19)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text19)).setText(new StringBuilder(String.valueOf(hour10)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text20)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text20)).setText(new StringBuilder(String.valueOf(min10)).toString());
                    }
                    break;
                case 312:
                    int hour11 = (value >> 8) & 255;
                    int min11 = value & 255;
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text21)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text21)).setText(new StringBuilder(String.valueOf(hour11)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text22)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text22)).setText(new StringBuilder(String.valueOf(min11)).toString());
                    }
                    break;
                case 313:
                    int hour12 = (value >> 8) & 255;
                    int min12 = value & 255;
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text23)).setText(new StringBuilder(String.valueOf(hour12)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text24)) != null) {
                        ((TextView) RZC_GMChargeSet7InfoAct.this.findViewById(R.id.tv_text24)).setText(new StringBuilder(String.valueOf(min12)).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_charge_setinf7);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[294] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(34, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[294] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(34, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int hour = (DataCanbus.DATA[307] >> 8) & 255;
                int min = DataCanbus.DATA[307] & 255;
                int hour2 = hour + 1;
                if (hour2 > 23) {
                    hour2 = 0;
                }
                setCarInfo(35, 1, hour2, min);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int hour3 = (DataCanbus.DATA[307] >> 8) & 255;
                int min2 = DataCanbus.DATA[307] & 255;
                int hour4 = hour3 - 1;
                if (hour4 < 0) {
                    hour4 = 23;
                }
                setCarInfo(35, 1, hour4, min2);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int hour5 = (DataCanbus.DATA[307] >> 8) & 255;
                int min3 = (DataCanbus.DATA[307] & 255) + 1;
                if (min3 > 59) {
                    min3 = 0;
                }
                setCarInfo(35, 1, hour5, min3);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int hour6 = (DataCanbus.DATA[307] >> 8) & 255;
                int min4 = (DataCanbus.DATA[307] & 255) - 1;
                if (min4 < 0) {
                    min4 = 59;
                }
                setCarInfo(35, 1, hour6, min4);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int hour7 = (DataCanbus.DATA[308] >> 8) & 255;
                int min5 = DataCanbus.DATA[308] & 255;
                int hour8 = hour7 - 1;
                if (hour8 < 0) {
                    hour8 = 23;
                }
                setCarInfo(35, 2, hour8, min5);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int hour9 = (DataCanbus.DATA[308] >> 8) & 255;
                int min6 = (DataCanbus.DATA[308] & 255) - 1;
                if (min6 < 0) {
                    min6 = 59;
                }
                setCarInfo(35, 2, hour9, min6);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int hour10 = (DataCanbus.DATA[309] >> 8) & 255;
                int min7 = DataCanbus.DATA[309] & 255;
                int hour11 = hour10 - 1;
                if (hour11 < 0) {
                    hour11 = 23;
                }
                setCarInfo(35, 3, hour11, min7);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int hour12 = (DataCanbus.DATA[309] >> 8) & 255;
                int min8 = (DataCanbus.DATA[309] & 255) - 1;
                if (min8 < 0) {
                    min8 = 59;
                }
                setCarInfo(35, 3, hour12, min8);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int hour13 = (DataCanbus.DATA[310] >> 8) & 255;
                int min9 = DataCanbus.DATA[310] & 255;
                int hour14 = hour13 - 1;
                if (hour14 < 0) {
                    hour14 = 23;
                }
                setCarInfo(35, 4, hour14, min9);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int hour15 = (DataCanbus.DATA[310] >> 8) & 255;
                int min10 = (DataCanbus.DATA[310] & 255) - 1;
                if (min10 < 0) {
                    min10 = 59;
                }
                setCarInfo(35, 4, hour15, min10);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int hour16 = (DataCanbus.DATA[311] >> 8) & 255;
                int min11 = DataCanbus.DATA[311] & 255;
                int hour17 = hour16 - 1;
                if (hour17 < 0) {
                    hour17 = 23;
                }
                setCarInfo(35, 5, hour17, min11);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int hour18 = (DataCanbus.DATA[311] >> 8) & 255;
                int min12 = (DataCanbus.DATA[311] & 255) - 1;
                if (min12 < 0) {
                    min12 = 59;
                }
                setCarInfo(35, 5, hour18, min12);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int hour19 = (DataCanbus.DATA[312] >> 8) & 255;
                int min13 = DataCanbus.DATA[312] & 255;
                int hour20 = hour19 - 1;
                if (hour20 < 0) {
                    hour20 = 23;
                }
                setCarInfo(35, 6, hour20, min13);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int hour21 = (DataCanbus.DATA[312] >> 8) & 255;
                int min14 = (DataCanbus.DATA[312] & 255) - 1;
                if (min14 < 0) {
                    min14 = 59;
                }
                setCarInfo(35, 6, hour21, min14);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int hour22 = (DataCanbus.DATA[313] >> 8) & 255;
                int min15 = DataCanbus.DATA[313] & 255;
                int hour23 = hour22 - 1;
                if (hour23 < 0) {
                    hour23 = 23;
                }
                setCarInfo(35, 7, hour23, min15);
                break;
            case R.id.btn_plus15 /* 2131427439 */:
                int hour24 = (DataCanbus.DATA[313] >> 8) & 255;
                int min16 = (DataCanbus.DATA[313] & 255) - 1;
                if (min16 < 0) {
                    min16 = 59;
                }
                setCarInfo(35, 7, hour24, min16);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int hour25 = (DataCanbus.DATA[308] >> 8) & 255;
                int min17 = DataCanbus.DATA[308] & 255;
                int hour26 = hour25 + 1;
                if (hour26 > 23) {
                    hour26 = 0;
                }
                setCarInfo(35, 2, hour26, min17);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int hour27 = (DataCanbus.DATA[308] >> 8) & 255;
                int min18 = (DataCanbus.DATA[308] & 255) + 1;
                if (min18 > 59) {
                    min18 = 0;
                }
                setCarInfo(35, 2, hour27, min18);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int hour28 = (DataCanbus.DATA[309] >> 8) & 255;
                int min19 = DataCanbus.DATA[309] & 255;
                int hour29 = hour28 + 1;
                if (hour29 > 23) {
                    hour29 = 0;
                }
                setCarInfo(35, 3, hour29, min19);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int hour30 = (DataCanbus.DATA[309] >> 8) & 255;
                int min20 = (DataCanbus.DATA[309] & 255) + 1;
                if (min20 > 59) {
                    min20 = 0;
                }
                setCarInfo(35, 3, hour30, min20);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int hour31 = (DataCanbus.DATA[310] >> 8) & 255;
                int min21 = DataCanbus.DATA[310] & 255;
                int hour32 = hour31 + 1;
                if (hour32 > 23) {
                    hour32 = 0;
                }
                setCarInfo(35, 4, hour32, min21);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int hour33 = (DataCanbus.DATA[310] >> 8) & 255;
                int min22 = (DataCanbus.DATA[310] & 255) + 1;
                if (min22 > 59) {
                    min22 = 0;
                }
                setCarInfo(35, 4, hour33, min22);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int hour34 = (DataCanbus.DATA[311] >> 8) & 255;
                int min23 = DataCanbus.DATA[311] & 255;
                int hour35 = hour34 + 1;
                if (hour35 > 23) {
                    hour35 = 0;
                }
                setCarInfo(35, 5, hour35, min23);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int hour36 = (DataCanbus.DATA[311] >> 8) & 255;
                int min24 = (DataCanbus.DATA[311] & 255) + 1;
                if (min24 > 59) {
                    min24 = 0;
                }
                setCarInfo(35, 5, hour36, min24);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int hour37 = (DataCanbus.DATA[312] >> 8) & 255;
                int min25 = DataCanbus.DATA[312] & 255;
                int hour38 = hour37 + 1;
                if (hour38 > 23) {
                    hour38 = 0;
                }
                setCarInfo(35, 6, hour38, min25);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int hour39 = (DataCanbus.DATA[312] >> 8) & 255;
                int min26 = (DataCanbus.DATA[312] & 255) + 1;
                if (min26 > 59) {
                    min26 = 0;
                }
                setCarInfo(35, 6, hour39, min26);
                break;
            case R.id.btn_minus14 /* 2131427492 */:
                int hour40 = (DataCanbus.DATA[313] >> 8) & 255;
                int min27 = DataCanbus.DATA[313] & 255;
                int hour41 = hour40 + 1;
                if (hour41 > 23) {
                    hour41 = 0;
                }
                setCarInfo(35, 7, hour41, min27);
                break;
            case R.id.btn_minus15 /* 2131427494 */:
                int hour42 = (DataCanbus.DATA[313] >> 8) & 255;
                int min28 = (DataCanbus.DATA[313] & 255) + 1;
                if (min28 > 59) {
                    min28 = 0;
                }
                setCarInfo(35, 7, hour42, min28);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(12, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(11, new int[]{81, 5}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[294].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[295].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[297].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[298].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[299].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[300].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[301].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[302].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[303].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[304].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[305].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[306].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[307].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[308].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[309].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[310].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[311].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[312].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[313].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[294].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[295].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[297].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[298].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[299].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[300].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[301].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[302].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[303].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[304].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[305].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[306].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[307].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[308].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[309].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[310].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[311].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[312].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[313].removeNotify(this.mNotifyCanbus);
    }
}
