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
public class RZC_GMChargeSet6InfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RZC_GMChargeSet6InfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 269:
                    RZC_GMChargeSet6InfoAct.this.setCheck((CheckedTextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 270:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text1)).setText("6A");
                                break;
                            case 1:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text1)).setText("8A");
                                break;
                        }
                    }
                    break;
                case 271:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text2)).setText("是");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text2)).setText("否");
                                break;
                        }
                    }
                    break;
                case 272:
                    RZC_GMChargeSet6InfoAct.this.setCheck((CheckedTextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 273:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text3)).setText("设置失败");
                        } else if (value == 2) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text3)).setText("设置成功");
                        } else {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text3)).setText("");
                        }
                    }
                    break;
                case 274:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 1) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text4)).setText("更新失败");
                        } else if (value == 2) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text4)).setText("更新成功");
                        } else {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text4)).setText("");
                        }
                    }
                    break;
                case 275:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 1) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text5)).setText("移除失败");
                        } else if (value == 2) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text5)).setText("移除成功");
                        } else {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text5)).setText("");
                        }
                    }
                    break;
                case 276:
                case 277:
                case 278:
                    int weekday = DataCanbus.DATA[276];
                    int hour = DataCanbus.DATA[277];
                    int min = DataCanbus.DATA[278];
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text6)) != null) {
                        if (weekday == 7) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text6)).setText("星期日-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 6) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text6)).setText("星期六-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 5) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text6)).setText("星期五-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 4) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text6)).setText("星期四-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 3) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text6)).setText("星期三-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 2) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text6)).setText("星期二-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        } else if (weekday == 1) {
                            ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text6)).setText("星期一-" + (hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        }
                    }
                    break;
                case 279:
                case 280:
                    int hour2 = DataCanbus.DATA[279];
                    int min2 = DataCanbus.DATA[280];
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(hour2 / 10) + (hour2 % 10) + ":" + (min2 / 10) + (min2 % 10));
                    }
                    break;
                case 281:
                case 282:
                    int hour3 = DataCanbus.DATA[281];
                    int min3 = DataCanbus.DATA[282];
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(hour3 / 10) + (hour3 % 10) + ":" + (min3 / 10) + (min3 % 10));
                    }
                    break;
                case 283:
                case 284:
                    int hour4 = DataCanbus.DATA[283];
                    int min4 = DataCanbus.DATA[284];
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(hour4 / 10) + (hour4 % 10) + ":" + (min4 / 10) + (min4 % 10));
                    }
                    break;
                case 285:
                case 286:
                    int hour5 = DataCanbus.DATA[285];
                    int min5 = DataCanbus.DATA[286];
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(hour5 / 10) + (hour5 % 10) + ":" + (min5 / 10) + (min5 % 10));
                    }
                    break;
                case 287:
                    int hour6 = (value >> 8) & 255;
                    int min6 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(hour6)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(min6)).toString());
                    }
                    break;
                case 288:
                    int hour7 = (value >> 8) & 255;
                    int min7 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(hour7)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder(String.valueOf(min7)).toString());
                    }
                    break;
                case 289:
                    int hour8 = (value >> 8) & 255;
                    int min8 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(hour8)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text16)).setText(new StringBuilder(String.valueOf(min8)).toString());
                    }
                    break;
                case 290:
                    int hour9 = (value >> 8) & 255;
                    int min9 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text17)).setText(new StringBuilder(String.valueOf(hour9)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text18)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text18)).setText(new StringBuilder(String.valueOf(min9)).toString());
                    }
                    break;
                case 291:
                    int hour10 = (value >> 8) & 255;
                    int min10 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text19)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text19)).setText(new StringBuilder(String.valueOf(hour10)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text20)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text20)).setText(new StringBuilder(String.valueOf(min10)).toString());
                    }
                    break;
                case 292:
                    int hour11 = (value >> 8) & 255;
                    int min11 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text21)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text21)).setText(new StringBuilder(String.valueOf(hour11)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text22)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text22)).setText(new StringBuilder(String.valueOf(min11)).toString());
                    }
                    break;
                case 293:
                    int hour12 = (value >> 8) & 255;
                    int min12 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text23)).setText(new StringBuilder(String.valueOf(hour12)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text24)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text24)).setText(new StringBuilder(String.valueOf(min12)).toString());
                    }
                    break;
                case 327:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text25)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text25)).setText("低峰");
                                break;
                            case 2:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text25)).setText("平段");
                                break;
                            case 3:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text25)).setText("高峰");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text25)).setText("----");
                                break;
                        }
                    }
                    break;
                case 328:
                    int hour13 = (value >> 8) & 255;
                    int min13 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text40)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text40)).setText(String.valueOf(hour13 / 10) + (hour13 % 10) + ":" + (min13 / 10) + (min13 % 10));
                    }
                    break;
                case 329:
                    int hour14 = (value >> 8) & 255;
                    int min14 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text26)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text26)).setText(new StringBuilder(String.valueOf(hour14)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text27)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text27)).setText(new StringBuilder(String.valueOf(min14)).toString());
                    }
                    break;
                case 330:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text28)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text28)).setText("低峰");
                                break;
                            case 2:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text28)).setText("平段");
                                break;
                            case 3:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text28)).setText("高峰");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text28)).setText("----");
                                break;
                        }
                    }
                    break;
                case 331:
                    int hour15 = (value >> 8) & 255;
                    int min15 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text41)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text41)).setText(String.valueOf(hour15 / 10) + (hour15 % 10) + ":" + (min15 / 10) + (min15 % 10));
                    }
                    break;
                case 332:
                    int hour16 = (value >> 8) & 255;
                    int min16 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text29)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text29)).setText(new StringBuilder(String.valueOf(hour16)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text30)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text30)).setText(new StringBuilder(String.valueOf(min16)).toString());
                    }
                    break;
                case 333:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text31)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text31)).setText("低峰");
                                break;
                            case 2:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text31)).setText("平段");
                                break;
                            case 3:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text31)).setText("高峰");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text31)).setText("----");
                                break;
                        }
                    }
                    break;
                case 334:
                    int hour17 = (value >> 8) & 255;
                    int min17 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text42)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text42)).setText(String.valueOf(hour17 / 10) + (hour17 % 10) + ":" + (min17 / 10) + (min17 % 10));
                    }
                    break;
                case 335:
                    int hour18 = (value >> 8) & 255;
                    int min18 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text32)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text32)).setText(new StringBuilder(String.valueOf(hour18)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text33)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text33)).setText(new StringBuilder(String.valueOf(min18)).toString());
                    }
                    break;
                case 336:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text34)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text34)).setText("低峰");
                                break;
                            case 2:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text34)).setText("平段");
                                break;
                            case 3:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text34)).setText("高峰");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text34)).setText("----");
                                break;
                        }
                    }
                    break;
                case 337:
                    int hour19 = (value >> 8) & 255;
                    int min19 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text43)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text43)).setText(String.valueOf(hour19 / 10) + (hour19 % 10) + ":" + (min19 / 10) + (min19 % 10));
                    }
                    break;
                case 338:
                    int hour20 = (value >> 8) & 255;
                    int min20 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text35)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text35)).setText(new StringBuilder(String.valueOf(hour20)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text36)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text36)).setText(new StringBuilder(String.valueOf(min20)).toString());
                    }
                    break;
                case 339:
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text37)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text37)).setText("低峰");
                                break;
                            case 2:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text37)).setText("平段");
                                break;
                            case 3:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text37)).setText("高峰");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text37)).setText("----");
                                break;
                        }
                    }
                    break;
                case 340:
                    int hour21 = (value >> 8) & 255;
                    int min21 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text44)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text44)).setText(String.valueOf(hour21 / 10) + (hour21 % 10) + ":" + (min21 / 10) + (min21 % 10));
                    }
                    break;
                case 341:
                    int hour22 = (value >> 8) & 255;
                    int min22 = value & 255;
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text38)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text38)).setText(new StringBuilder(String.valueOf(hour22)).toString());
                    }
                    if (((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text39)) != null) {
                        ((TextView) RZC_GMChargeSet6InfoAct.this.findViewById(R.id.tv_text39)).setText(new StringBuilder(String.valueOf(min22)).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_charge_setinf6);
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
                int value = DataCanbus.DATA[270];
                if (value == 1) {
                    value = 1;
                } else if (value == 0) {
                    value = 2;
                }
                setCarInfo(27, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[270];
                if (value2 == 1) {
                    value2 = 1;
                } else if (value2 == 0) {
                    value2 = 2;
                }
                setCarInfo(27, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int hour = (DataCanbus.DATA[287] >> 8) & 255;
                int min = DataCanbus.DATA[287] & 255;
                int hour2 = hour - 1;
                if (hour2 < 0) {
                    hour2 = 23;
                }
                setCarInfo(28, 1, hour2, min);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int hour3 = (DataCanbus.DATA[287] >> 8) & 255;
                int min2 = DataCanbus.DATA[287] & 255;
                int hour4 = hour3 + 1;
                if (hour4 > 23) {
                    hour4 = 0;
                }
                setCarInfo(28, 1, hour4, min2);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int hour5 = (DataCanbus.DATA[287] >> 8) & 255;
                int min3 = (DataCanbus.DATA[287] & 255) - 1;
                if (min3 < 0) {
                    min3 = 59;
                }
                setCarInfo(28, 1, hour5, min3);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int hour6 = (DataCanbus.DATA[287] >> 8) & 255;
                int min4 = (DataCanbus.DATA[287] & 255) + 1;
                if (min4 > 59) {
                    min4 = 0;
                }
                setCarInfo(28, 1, hour6, min4);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int hour7 = (DataCanbus.DATA[288] >> 8) & 255;
                int min5 = DataCanbus.DATA[288] & 255;
                int hour8 = hour7 - 1;
                if (hour8 < 0) {
                    hour8 = 23;
                }
                setCarInfo(28, 2, hour8, min5);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int hour9 = (DataCanbus.DATA[288] >> 8) & 255;
                int min6 = DataCanbus.DATA[288] & 255;
                int hour10 = hour9 + 1;
                if (hour10 > 23) {
                    hour10 = 0;
                }
                setCarInfo(28, 2, hour10, min6);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int hour11 = (DataCanbus.DATA[288] >> 8) & 255;
                int min7 = (DataCanbus.DATA[288] & 255) - 1;
                if (min7 < 0) {
                    min7 = 59;
                }
                setCarInfo(28, 2, hour11, min7);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int hour12 = (DataCanbus.DATA[288] >> 8) & 255;
                int min8 = (DataCanbus.DATA[288] & 255) + 1;
                if (min8 > 59) {
                    min8 = 0;
                }
                setCarInfo(28, 2, hour12, min8);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int hour13 = (DataCanbus.DATA[289] >> 8) & 255;
                int min9 = DataCanbus.DATA[289] & 255;
                int hour14 = hour13 - 1;
                if (hour14 < 0) {
                    hour14 = 23;
                }
                setCarInfo(28, 3, hour14, min9);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int hour15 = (DataCanbus.DATA[289] >> 8) & 255;
                int min10 = DataCanbus.DATA[289] & 255;
                int hour16 = hour15 + 1;
                if (hour16 > 23) {
                    hour16 = 0;
                }
                setCarInfo(28, 3, hour16, min10);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int hour17 = (DataCanbus.DATA[289] >> 8) & 255;
                int min11 = (DataCanbus.DATA[289] & 255) - 1;
                if (min11 < 0) {
                    min11 = 59;
                }
                setCarInfo(28, 3, hour17, min11);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int hour18 = (DataCanbus.DATA[289] >> 8) & 255;
                int min12 = (DataCanbus.DATA[289] & 255) + 1;
                if (min12 > 59) {
                    min12 = 0;
                }
                setCarInfo(28, 3, hour18, min12);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int hour19 = (DataCanbus.DATA[290] >> 8) & 255;
                int min13 = DataCanbus.DATA[290] & 255;
                int hour20 = hour19 - 1;
                if (hour20 < 0) {
                    hour20 = 23;
                }
                setCarInfo(28, 4, hour20, min13);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int hour21 = (DataCanbus.DATA[290] >> 8) & 255;
                int min14 = DataCanbus.DATA[290] & 255;
                int hour22 = hour21 + 1;
                if (hour22 > 23) {
                    hour22 = 0;
                }
                setCarInfo(28, 4, hour22, min14);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int hour23 = (DataCanbus.DATA[290] >> 8) & 255;
                int min15 = (DataCanbus.DATA[290] & 255) - 1;
                if (min15 < 0) {
                    min15 = 59;
                }
                setCarInfo(28, 4, hour23, min15);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int hour24 = (DataCanbus.DATA[290] >> 8) & 255;
                int min16 = (DataCanbus.DATA[290] & 255) + 1;
                if (min16 > 59) {
                    min16 = 0;
                }
                setCarInfo(28, 4, hour24, min16);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int hour25 = (DataCanbus.DATA[291] >> 8) & 255;
                int min17 = DataCanbus.DATA[291] & 255;
                int hour26 = hour25 - 1;
                if (hour26 < 0) {
                    hour26 = 23;
                }
                setCarInfo(28, 5, hour26, min17);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int hour27 = (DataCanbus.DATA[291] >> 8) & 255;
                int min18 = DataCanbus.DATA[291] & 255;
                int hour28 = hour27 + 1;
                if (hour28 > 23) {
                    hour28 = 0;
                }
                setCarInfo(28, 5, hour28, min18);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int hour29 = (DataCanbus.DATA[291] >> 8) & 255;
                int min19 = (DataCanbus.DATA[291] & 255) - 1;
                if (min19 < 0) {
                    min19 = 59;
                }
                setCarInfo(28, 5, hour29, min19);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int hour30 = (DataCanbus.DATA[291] >> 8) & 255;
                int min20 = (DataCanbus.DATA[291] & 255) + 1;
                if (min20 > 59) {
                    min20 = 0;
                }
                setCarInfo(28, 5, hour30, min20);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int hour31 = (DataCanbus.DATA[292] >> 8) & 255;
                int min21 = DataCanbus.DATA[292] & 255;
                int hour32 = hour31 - 1;
                if (hour32 < 0) {
                    hour32 = 23;
                }
                setCarInfo(28, 6, hour32, min21);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int hour33 = (DataCanbus.DATA[292] >> 8) & 255;
                int min22 = DataCanbus.DATA[292] & 255;
                int hour34 = hour33 + 1;
                if (hour34 > 23) {
                    hour34 = 0;
                }
                setCarInfo(28, 6, hour34, min22);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int hour35 = (DataCanbus.DATA[292] >> 8) & 255;
                int min23 = (DataCanbus.DATA[292] & 255) - 1;
                if (min23 < 0) {
                    min23 = 59;
                }
                setCarInfo(28, 6, hour35, min23);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int hour36 = (DataCanbus.DATA[292] >> 8) & 255;
                int min24 = (DataCanbus.DATA[292] & 255) + 1;
                if (min24 > 59) {
                    min24 = 0;
                }
                setCarInfo(28, 6, hour36, min24);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int hour37 = (DataCanbus.DATA[293] >> 8) & 255;
                int min25 = DataCanbus.DATA[293] & 255;
                int hour38 = hour37 - 1;
                if (hour38 < 0) {
                    hour38 = 23;
                }
                setCarInfo(28, 7, hour38, min25);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int hour39 = (DataCanbus.DATA[293] >> 8) & 255;
                int min26 = DataCanbus.DATA[293] & 255;
                int hour40 = hour39 + 1;
                if (hour40 > 23) {
                    hour40 = 0;
                }
                setCarInfo(28, 7, hour40, min26);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int hour41 = (DataCanbus.DATA[293] >> 8) & 255;
                int min27 = (DataCanbus.DATA[293] & 255) - 1;
                if (min27 < 0) {
                    min27 = 59;
                }
                setCarInfo(28, 7, hour41, min27);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int hour42 = (DataCanbus.DATA[293] >> 8) & 255;
                int min28 = (DataCanbus.DATA[293] & 255) + 1;
                if (min28 > 59) {
                    min28 = 0;
                }
                setCarInfo(28, 7, hour42, min28);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int type = DataCanbus.DATA[327];
                int hour43 = (DataCanbus.DATA[329] >> 8) & 255;
                int min29 = DataCanbus.DATA[329] & 255;
                int type2 = type - 1;
                if (type2 < 1) {
                    type2 = 3;
                }
                setCarInfo(29, type2 | 16, hour43, min29);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int type3 = DataCanbus.DATA[327];
                int hour44 = (DataCanbus.DATA[329] >> 8) & 255;
                int min30 = DataCanbus.DATA[329] & 255;
                int type4 = type3 + 1;
                if (type4 > 3) {
                    type4 = 1;
                }
                setCarInfo(29, type4 | 16, hour44, min30);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int type5 = DataCanbus.DATA[327];
                int hour45 = (DataCanbus.DATA[329] >> 8) & 255;
                int min31 = DataCanbus.DATA[329] & 255;
                int hour46 = hour45 - 1;
                if (hour46 < 0) {
                    hour46 = 23;
                }
                setCarInfo(29, type5 | 16, hour46, min31);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int type6 = DataCanbus.DATA[327];
                int hour47 = (DataCanbus.DATA[329] >> 8) & 255;
                int min32 = DataCanbus.DATA[329] & 255;
                int hour48 = hour47 + 1;
                if (hour48 > 23) {
                    hour48 = 0;
                }
                setCarInfo(29, type6 | 16, hour48, min32);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int type7 = DataCanbus.DATA[327];
                int hour49 = (DataCanbus.DATA[329] >> 8) & 255;
                int min33 = (DataCanbus.DATA[329] & 255) - 1;
                if (min33 < 0) {
                    min33 = 59;
                }
                setCarInfo(29, type7 | 16, hour49, min33);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int type8 = DataCanbus.DATA[327];
                int hour50 = (DataCanbus.DATA[329] >> 8) & 255;
                int min34 = (DataCanbus.DATA[329] & 255) + 1;
                if (min34 > 59) {
                    min34 = 0;
                }
                setCarInfo(29, type8 | 16, hour50, min34);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[269] == 0) {
                    setCarInfo(26, 1, 0, 0);
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(32, 1, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(33, 1, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value3 = DataCanbus.DATA[272];
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                setCarInfo(30, value3, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(31, 1, 0, 0);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int type9 = DataCanbus.DATA[330];
                int hour51 = (DataCanbus.DATA[332] >> 8) & 255;
                int min35 = DataCanbus.DATA[332] & 255;
                int type10 = type9 - 1;
                if (type10 < 1) {
                    type10 = 3;
                }
                setCarInfo(29, type10 | 32, hour51, min35);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int type11 = DataCanbus.DATA[330];
                int hour52 = (DataCanbus.DATA[332] >> 8) & 255;
                int min36 = DataCanbus.DATA[332] & 255;
                int type12 = type11 + 1;
                if (type12 > 3) {
                    type12 = 1;
                }
                setCarInfo(29, type12 | 32, hour52, min36);
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int type13 = DataCanbus.DATA[330];
                int hour53 = (DataCanbus.DATA[332] >> 8) & 255;
                int min37 = DataCanbus.DATA[332] & 255;
                int hour54 = hour53 - 1;
                if (hour54 < 0) {
                    hour54 = 23;
                }
                setCarInfo(29, type13 | 32, hour54, min37);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int type14 = DataCanbus.DATA[330];
                int hour55 = (DataCanbus.DATA[332] >> 8) & 255;
                int min38 = DataCanbus.DATA[332] & 255;
                int hour56 = hour55 + 1;
                if (hour56 > 23) {
                    hour56 = 0;
                }
                setCarInfo(29, type14 | 32, hour56, min38);
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int type15 = DataCanbus.DATA[330];
                int hour57 = (DataCanbus.DATA[332] >> 8) & 255;
                int min39 = (DataCanbus.DATA[332] & 255) - 1;
                if (min39 < 0) {
                    min39 = 59;
                }
                setCarInfo(29, type15 | 32, hour57, min39);
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int type16 = DataCanbus.DATA[330];
                int hour58 = (DataCanbus.DATA[332] >> 8) & 255;
                int min40 = (DataCanbus.DATA[332] & 255) + 1;
                if (min40 > 59) {
                    min40 = 0;
                }
                setCarInfo(29, type16 | 32, hour58, min40);
                break;
            case R.id.btn_minus22 /* 2131427603 */:
                int type17 = DataCanbus.DATA[333];
                int hour59 = (DataCanbus.DATA[335] >> 8) & 255;
                int min41 = DataCanbus.DATA[335] & 255;
                int type18 = type17 - 1;
                if (type18 < 1) {
                    type18 = 3;
                }
                setCarInfo(29, type18 | 48, hour59, min41);
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                int type19 = DataCanbus.DATA[333];
                int hour60 = (DataCanbus.DATA[335] >> 8) & 255;
                int min42 = DataCanbus.DATA[335] & 255;
                int type20 = type19 + 1;
                if (type20 > 3) {
                    type20 = 1;
                }
                setCarInfo(29, type20 | 48, hour60, min42);
                break;
            case R.id.btn_minus23 /* 2131427607 */:
                int type21 = DataCanbus.DATA[333];
                int hour61 = (DataCanbus.DATA[335] >> 8) & 255;
                int min43 = DataCanbus.DATA[335] & 255;
                int hour62 = hour61 - 1;
                if (hour62 < 0) {
                    hour62 = 23;
                }
                setCarInfo(29, type21 | 48, hour62, min43);
                break;
            case R.id.btn_plus23 /* 2131427609 */:
                int type22 = DataCanbus.DATA[333];
                int hour63 = (DataCanbus.DATA[335] >> 8) & 255;
                int min44 = DataCanbus.DATA[335] & 255;
                int hour64 = hour63 + 1;
                if (hour64 > 23) {
                    hour64 = 0;
                }
                setCarInfo(29, type22 | 48, hour64, min44);
                break;
            case R.id.btn_minus24 /* 2131427610 */:
                int type23 = DataCanbus.DATA[333];
                int hour65 = (DataCanbus.DATA[335] >> 8) & 255;
                int min45 = (DataCanbus.DATA[335] & 255) - 1;
                if (min45 < 0) {
                    min45 = 59;
                }
                setCarInfo(29, type23 | 48, hour65, min45);
                break;
            case R.id.btn_plus24 /* 2131427612 */:
                int type24 = DataCanbus.DATA[333];
                int hour66 = (DataCanbus.DATA[335] >> 8) & 255;
                int min46 = (DataCanbus.DATA[335] & 255) + 1;
                if (min46 > 59) {
                    min46 = 0;
                }
                setCarInfo(29, type24 | 48, hour66, min46);
                break;
            case R.id.btn_minus25 /* 2131427613 */:
                int type25 = DataCanbus.DATA[336];
                int hour67 = (DataCanbus.DATA[338] >> 8) & 255;
                int min47 = DataCanbus.DATA[338] & 255;
                int type26 = type25 - 1;
                if (type26 < 1) {
                    type26 = 3;
                }
                setCarInfo(29, type26 | 64, hour67, min47);
                break;
            case R.id.btn_plus25 /* 2131427615 */:
                int type27 = DataCanbus.DATA[336];
                int hour68 = (DataCanbus.DATA[338] >> 8) & 255;
                int min48 = DataCanbus.DATA[338] & 255;
                int type28 = type27 + 1;
                if (type28 > 3) {
                    type28 = 1;
                }
                setCarInfo(29, type28 | 64, hour68, min48);
                break;
            case R.id.btn_minus26 /* 2131427617 */:
                int type29 = DataCanbus.DATA[336];
                int hour69 = (DataCanbus.DATA[338] >> 8) & 255;
                int min49 = DataCanbus.DATA[338] & 255;
                int hour70 = hour69 - 1;
                if (hour70 < 0) {
                    hour70 = 23;
                }
                setCarInfo(29, type29 | 64, hour70, min49);
                break;
            case R.id.btn_plus26 /* 2131427619 */:
                int type30 = DataCanbus.DATA[336];
                int hour71 = (DataCanbus.DATA[338] >> 8) & 255;
                int min50 = DataCanbus.DATA[338] & 255;
                int hour72 = hour71 + 1;
                if (hour72 > 23) {
                    hour72 = 0;
                }
                setCarInfo(29, type30 | 64, hour72, min50);
                break;
            case R.id.btn_minus27 /* 2131427620 */:
                int type31 = DataCanbus.DATA[336];
                int hour73 = (DataCanbus.DATA[338] >> 8) & 255;
                int min51 = (DataCanbus.DATA[338] & 255) - 1;
                if (min51 < 0) {
                    min51 = 59;
                }
                setCarInfo(29, type31 | 64, hour73, min51);
                break;
            case R.id.btn_plus27 /* 2131427622 */:
                int type32 = DataCanbus.DATA[336];
                int hour74 = (DataCanbus.DATA[338] >> 8) & 255;
                int min52 = (DataCanbus.DATA[338] & 255) + 1;
                if (min52 > 59) {
                    min52 = 0;
                }
                setCarInfo(29, type32 | 64, hour74, min52);
                break;
            case R.id.btn_minus28 /* 2131427623 */:
                int type33 = DataCanbus.DATA[339];
                int hour75 = (DataCanbus.DATA[341] >> 8) & 255;
                int min53 = DataCanbus.DATA[341] & 255;
                int type34 = type33 - 1;
                if (type34 < 1) {
                    type34 = 3;
                }
                setCarInfo(29, type34 | 80, hour75, min53);
                break;
            case R.id.btn_plus28 /* 2131427625 */:
                int type35 = DataCanbus.DATA[339];
                int hour76 = (DataCanbus.DATA[341] >> 8) & 255;
                int min54 = DataCanbus.DATA[341] & 255;
                int type36 = type35 + 1;
                if (type36 > 3) {
                    type36 = 1;
                }
                setCarInfo(29, type36 | 80, hour76, min54);
                break;
            case R.id.btn_minus29 /* 2131427627 */:
                int type37 = DataCanbus.DATA[339];
                int hour77 = (DataCanbus.DATA[341] >> 8) & 255;
                int min55 = DataCanbus.DATA[341] & 255;
                int hour78 = hour77 - 1;
                if (hour78 < 0) {
                    hour78 = 23;
                }
                setCarInfo(29, type37 | 80, hour78, min55);
                break;
            case R.id.btn_plus29 /* 2131427629 */:
                int type38 = DataCanbus.DATA[339];
                int hour79 = (DataCanbus.DATA[341] >> 8) & 255;
                int min56 = DataCanbus.DATA[341] & 255;
                int hour80 = hour79 + 1;
                if (hour80 > 23) {
                    hour80 = 0;
                }
                setCarInfo(29, type38 | 80, hour80, min56);
                break;
            case R.id.btn_minus30 /* 2131427630 */:
                int type39 = DataCanbus.DATA[339];
                int hour81 = (DataCanbus.DATA[341] >> 8) & 255;
                int min57 = (DataCanbus.DATA[341] & 255) - 1;
                if (min57 < 0) {
                    min57 = 59;
                }
                setCarInfo(29, type39 | 80, hour81, min57);
                break;
            case R.id.btn_plus30 /* 2131427632 */:
                int type40 = DataCanbus.DATA[339];
                int hour82 = (DataCanbus.DATA[341] >> 8) & 255;
                int min58 = (DataCanbus.DATA[341] & 255) + 1;
                if (min58 > 59) {
                    min58 = 0;
                }
                setCarInfo(29, type40 | 80, hour82, min58);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(12, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(11, new int[]{81, 4}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[271].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[277].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[279].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[280].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[281].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[282].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[283].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[284].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[285].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[286].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[287].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[288].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[289].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[290].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[291].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[292].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[293].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[327].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[328].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[329].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[330].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[331].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[332].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[333].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[334].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[335].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[336].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[337].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[338].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[339].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[340].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[341].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[271].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[277].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[279].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[280].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[281].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[282].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[283].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[284].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[285].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[286].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[287].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[288].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[289].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[290].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[291].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[292].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[293].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[327].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[328].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[329].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[330].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[331].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[332].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[333].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[334].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[335].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[336].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[337].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[338].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[339].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[340].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[341].removeNotify(this.mNotifyCanbus);
    }
}
