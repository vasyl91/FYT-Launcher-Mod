package com.syu.carinfo.rzc.klc;

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
public class RZC_GMChargeSet5InfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RZC_GMChargeSet5InfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 244:
                    RZC_GMChargeSet5InfoAct.this.setCheck((CheckedTextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 245:
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text1)).setText("6A");
                                break;
                            case 1:
                                ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text1)).setText("8A");
                                break;
                        }
                    }
                    break;
                case 246:
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text2)).setText("是");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text2)).setText("否");
                                break;
                        }
                    }
                    break;
                case 247:
                    RZC_GMChargeSet5InfoAct.this.setCheck((CheckedTextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 248:
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text3)).setText("设置失败");
                        } else if (value == 2) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text3)).setText("设置成功");
                        } else {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text3)).setText("");
                        }
                    }
                    break;
                case 249:
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 1) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text4)).setText("更新失败");
                        } else if (value == 2) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text4)).setText("更新成功");
                        } else {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text4)).setText("");
                        }
                    }
                    break;
                case 250:
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 1) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text5)).setText("移除失败");
                        } else if (value == 2) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text5)).setText("移除成功");
                        } else {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text5)).setText("");
                        }
                    }
                    break;
                case 251:
                case 252:
                case 253:
                    int weekday = DataCanbus.DATA[251];
                    int hour = DataCanbus.DATA[252];
                    int min = DataCanbus.DATA[253];
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text6)) != null) {
                        if (weekday == 7) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text6)).setText("星期日-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 6) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text6)).setText("星期六-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 5) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text6)).setText("星期五-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 4) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text6)).setText("星期四-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 3) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text6)).setText("星期三-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 2) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text6)).setText("星期二-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 1) {
                            ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text6)).setText("星期一-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        }
                    }
                    break;
                case 254:
                case 255:
                    int hour2 = DataCanbus.DATA[254];
                    int min2 = DataCanbus.DATA[255];
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(hour2 / 10) + (hour2 % 10) + ":" + (min2 / 10) + (min2 % 10));
                    }
                    break;
                case 256:
                case 257:
                    int hour3 = DataCanbus.DATA[256];
                    int min3 = DataCanbus.DATA[257];
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(hour3 / 10) + (hour3 % 10) + ":" + (min3 / 10) + (min3 % 10));
                    }
                    break;
                case 258:
                case 259:
                    int hour4 = DataCanbus.DATA[258];
                    int min4 = DataCanbus.DATA[259];
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(hour4 / 10) + (hour4 % 10) + ":" + (min4 / 10) + (min4 % 10));
                    }
                    break;
                case 260:
                case 261:
                    int hour5 = DataCanbus.DATA[260];
                    int min5 = DataCanbus.DATA[261];
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(hour5 / 10) + (hour5 % 10) + ":" + (min5 / 10) + (min5 % 10));
                    }
                    break;
                case 262:
                    int hour6 = (value >> 8) & 255;
                    int min6 = value & 255;
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(hour6)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(min6)).toString());
                    }
                    break;
                case 263:
                    int hour7 = (value >> 8) & 255;
                    int min7 = value & 255;
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(hour7)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder(String.valueOf(min7)).toString());
                    }
                    break;
                case 264:
                    int hour8 = (value >> 8) & 255;
                    int min8 = value & 255;
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(hour8)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text16)).setText(new StringBuilder(String.valueOf(min8)).toString());
                    }
                    break;
                case 265:
                    int hour9 = (value >> 8) & 255;
                    int min9 = value & 255;
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text17)).setText(new StringBuilder(String.valueOf(hour9)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text18)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text18)).setText(new StringBuilder(String.valueOf(min9)).toString());
                    }
                    break;
                case 266:
                    int hour10 = (value >> 8) & 255;
                    int min10 = value & 255;
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text19)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text19)).setText(new StringBuilder(String.valueOf(hour10)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text20)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text20)).setText(new StringBuilder(String.valueOf(min10)).toString());
                    }
                    break;
                case 267:
                    int hour11 = (value >> 8) & 255;
                    int min11 = value & 255;
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text21)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text21)).setText(new StringBuilder(String.valueOf(hour11)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text22)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text22)).setText(new StringBuilder(String.valueOf(min11)).toString());
                    }
                    break;
                case 268:
                    int hour12 = (value >> 8) & 255;
                    int min12 = value & 255;
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text23)).setText(new StringBuilder(String.valueOf(hour12)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text24)) != null) {
                        ((TextView) RZC_GMChargeSet5InfoAct.this.findViewById(R.id.tv_text24)).setText(new StringBuilder(String.valueOf(min12)).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_charge_setinf5);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[245];
                if (value == 1) {
                    value = 1;
                } else if (value == 0) {
                    value = 2;
                }
                setCarInfo(20, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[245];
                if (value2 == 1) {
                    value2 = 1;
                } else if (value2 == 0) {
                    value2 = 2;
                }
                setCarInfo(20, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int hour = (DataCanbus.DATA[262] >> 8) & 255;
                int min = DataCanbus.DATA[262] & 255;
                int hour2 = hour + 1;
                if (hour2 > 23) {
                    hour2 = 0;
                }
                setCarInfo(21, 1, hour2, min);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int hour3 = (DataCanbus.DATA[262] >> 8) & 255;
                int min2 = DataCanbus.DATA[262] & 255;
                int hour4 = hour3 - 1;
                if (hour4 < 0) {
                    hour4 = 23;
                }
                setCarInfo(21, 1, hour4, min2);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int hour5 = (DataCanbus.DATA[262] >> 8) & 255;
                int min3 = (DataCanbus.DATA[262] & 255) + 1;
                if (min3 > 59) {
                    min3 = 0;
                }
                setCarInfo(21, 1, hour5, min3);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int hour6 = (DataCanbus.DATA[262] >> 8) & 255;
                int min4 = (DataCanbus.DATA[262] & 255) - 1;
                if (min4 < 0) {
                    min4 = 59;
                }
                setCarInfo(21, 1, hour6, min4);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int hour7 = (DataCanbus.DATA[263] >> 8) & 255;
                int min5 = DataCanbus.DATA[263] & 255;
                int hour8 = hour7 + 1;
                if (hour8 > 23) {
                    hour8 = 0;
                }
                setCarInfo(21, 2, hour8, min5);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int hour9 = (DataCanbus.DATA[263] >> 8) & 255;
                int min6 = DataCanbus.DATA[263] & 255;
                int hour10 = hour9 - 1;
                if (hour10 < 0) {
                    hour10 = 23;
                }
                setCarInfo(21, 2, hour10, min6);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int hour11 = (DataCanbus.DATA[263] >> 8) & 255;
                int min7 = (DataCanbus.DATA[263] & 255) + 1;
                if (min7 > 59) {
                    min7 = 0;
                }
                setCarInfo(21, 2, hour11, min7);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int hour12 = (DataCanbus.DATA[263] >> 8) & 255;
                int min8 = (DataCanbus.DATA[263] & 255) - 1;
                if (min8 < 0) {
                    min8 = 59;
                }
                setCarInfo(21, 2, hour12, min8);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int hour13 = (DataCanbus.DATA[264] >> 8) & 255;
                int min9 = DataCanbus.DATA[264] & 255;
                int hour14 = hour13 + 1;
                if (hour14 > 23) {
                    hour14 = 0;
                }
                setCarInfo(21, 3, hour14, min9);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int hour15 = (DataCanbus.DATA[264] >> 8) & 255;
                int min10 = DataCanbus.DATA[264] & 255;
                int hour16 = hour15 - 1;
                if (hour16 < 0) {
                    hour16 = 23;
                }
                setCarInfo(21, 3, hour16, min10);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int hour17 = (DataCanbus.DATA[264] >> 8) & 255;
                int min11 = (DataCanbus.DATA[264] & 255) + 1;
                if (min11 > 59) {
                    min11 = 0;
                }
                setCarInfo(21, 3, hour17, min11);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int hour18 = (DataCanbus.DATA[264] >> 8) & 255;
                int min12 = (DataCanbus.DATA[264] & 255) - 1;
                if (min12 < 0) {
                    min12 = 59;
                }
                setCarInfo(21, 3, hour18, min12);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int hour19 = (DataCanbus.DATA[265] >> 8) & 255;
                int min13 = DataCanbus.DATA[265] & 255;
                int hour20 = hour19 + 1;
                if (hour20 > 23) {
                    hour20 = 0;
                }
                setCarInfo(21, 4, hour20, min13);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int hour21 = (DataCanbus.DATA[265] >> 8) & 255;
                int min14 = DataCanbus.DATA[265] & 255;
                int hour22 = hour21 - 1;
                if (hour22 < 0) {
                    hour22 = 23;
                }
                setCarInfo(21, 4, hour22, min14);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int hour23 = (DataCanbus.DATA[265] >> 8) & 255;
                int min15 = (DataCanbus.DATA[265] & 255) + 1;
                if (min15 > 59) {
                    min15 = 0;
                }
                setCarInfo(21, 4, hour23, min15);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int hour24 = (DataCanbus.DATA[265] >> 8) & 255;
                int min16 = (DataCanbus.DATA[265] & 255) - 1;
                if (min16 < 0) {
                    min16 = 59;
                }
                setCarInfo(21, 4, hour24, min16);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int hour25 = (DataCanbus.DATA[266] >> 8) & 255;
                int min17 = DataCanbus.DATA[266] & 255;
                int hour26 = hour25 + 1;
                if (hour26 > 23) {
                    hour26 = 0;
                }
                setCarInfo(21, 5, hour26, min17);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int hour27 = (DataCanbus.DATA[266] >> 8) & 255;
                int min18 = DataCanbus.DATA[266] & 255;
                int hour28 = hour27 - 1;
                if (hour28 < 0) {
                    hour28 = 23;
                }
                setCarInfo(21, 5, hour28, min18);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int hour29 = (DataCanbus.DATA[266] >> 8) & 255;
                int min19 = (DataCanbus.DATA[266] & 255) + 1;
                if (min19 > 59) {
                    min19 = 0;
                }
                setCarInfo(21, 5, hour29, min19);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int hour30 = (DataCanbus.DATA[266] >> 8) & 255;
                int min20 = (DataCanbus.DATA[266] & 255) - 1;
                if (min20 < 0) {
                    min20 = 59;
                }
                setCarInfo(21, 5, hour30, min20);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int hour31 = (DataCanbus.DATA[267] >> 8) & 255;
                int min21 = DataCanbus.DATA[267] & 255;
                int hour32 = hour31 + 1;
                if (hour32 > 23) {
                    hour32 = 0;
                }
                setCarInfo(21, 6, hour32, min21);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int hour33 = (DataCanbus.DATA[267] >> 8) & 255;
                int min22 = DataCanbus.DATA[267] & 255;
                int hour34 = hour33 - 1;
                if (hour34 < 0) {
                    hour34 = 23;
                }
                setCarInfo(21, 6, hour34, min22);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int hour35 = (DataCanbus.DATA[267] >> 8) & 255;
                int min23 = (DataCanbus.DATA[267] & 255) + 1;
                if (min23 > 59) {
                    min23 = 0;
                }
                setCarInfo(21, 6, hour35, min23);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int hour36 = (DataCanbus.DATA[267] >> 8) & 255;
                int min24 = (DataCanbus.DATA[267] & 255) - 1;
                if (min24 < 0) {
                    min24 = 59;
                }
                setCarInfo(21, 6, hour36, min24);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int hour37 = (DataCanbus.DATA[268] >> 8) & 255;
                int min25 = DataCanbus.DATA[268] & 255;
                int hour38 = hour37 + 1;
                if (hour38 > 23) {
                    hour38 = 0;
                }
                setCarInfo(21, 7, hour38, min25);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int hour39 = (DataCanbus.DATA[268] >> 8) & 255;
                int min26 = DataCanbus.DATA[268] & 255;
                int hour40 = hour39 - 1;
                if (hour40 < 0) {
                    hour40 = 23;
                }
                setCarInfo(21, 7, hour40, min26);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int hour41 = (DataCanbus.DATA[268] >> 8) & 255;
                int min27 = (DataCanbus.DATA[268] & 255) + 1;
                if (min27 > 59) {
                    min27 = 0;
                }
                setCarInfo(21, 7, hour41, min27);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int hour42 = (DataCanbus.DATA[268] >> 8) & 255;
                int min28 = (DataCanbus.DATA[268] & 255) - 1;
                if (min28 < 0) {
                    min28 = 59;
                }
                setCarInfo(21, 7, hour42, min28);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[244] == 0) {
                    setCarInfo(19, 1, 0, 0);
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(24, 1, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(25, 1, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value3 = DataCanbus.DATA[247];
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                setCarInfo(22, value3, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(23, 1, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(12, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(11, new int[]{81, 3}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
    }
}
