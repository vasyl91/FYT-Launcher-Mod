package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Golf7AuxiliaryheatingCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7AuxiliaryheatingCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 468:
                    if (((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_blowing);
                                break;
                            case 1:
                                ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_heating);
                                break;
                        }
                    }
                    break;
                case 469:
                    if (((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 470:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                    break;
                case 471:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                    break;
                case 472:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                    break;
                case 473:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                    break;
                case 474:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                    break;
                case 475:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(val).toString());
                    break;
                case 476:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(val).toString());
                    break;
                case 477:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(val).toString());
                    break;
                case 478:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(val).toString());
                    break;
                case 479:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(val).toString());
                    break;
                case 480:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text18)).setText(new StringBuilder().append(val).toString());
                    break;
                case 481:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(val).toString());
                    break;
                case 482:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(val).toString());
                    break;
                case 483:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(val).toString());
                    break;
                case 484:
                    ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(val).toString());
                    break;
                case 485:
                    if (((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (val == 0) {
                            ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                        } else {
                            ((TextView) Golf7AuxiliaryheatingCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0017_wc_vwmqb_heating_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[468] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value, 0, 0, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[468] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 0, 0, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[469] - 1;
                if (value3 < 10) {
                    value3 = 60;
                }
                setCarInfo(2, value3, 0, 0, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[469] + 1;
                if (value4 > 60) {
                    value4 = 10;
                }
                setCarInfo(2, value4, 0, 0, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[485] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(3, value5, 0, 0, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[485] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(50, value6, 0, 0, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int year = DataCanbus.DATA[474];
                int month = DataCanbus.DATA[473];
                int day = DataCanbus.DATA[472];
                int hour = DataCanbus.DATA[470];
                int min = DataCanbus.DATA[471];
                int year2 = year - 1;
                if (year2 < 0) {
                    year2 = 99;
                }
                setCarInfo(4, year2, month, day, hour, min);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int year3 = DataCanbus.DATA[474];
                int month2 = DataCanbus.DATA[473];
                int day2 = DataCanbus.DATA[472];
                int hour2 = DataCanbus.DATA[470];
                int min2 = DataCanbus.DATA[471];
                int year4 = year3 + 1;
                if (year4 > 99) {
                    year4 = 0;
                }
                setCarInfo(4, year4, month2, day2, hour2, min2);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int year5 = DataCanbus.DATA[474];
                int month3 = DataCanbus.DATA[473];
                int day3 = DataCanbus.DATA[472];
                int hour3 = DataCanbus.DATA[470];
                int min3 = DataCanbus.DATA[471];
                int month4 = month3 - 1;
                if (month4 < 1) {
                    month4 = 12;
                }
                setCarInfo(4, year5, month4, day3, hour3, min3);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int year6 = DataCanbus.DATA[474];
                int month5 = DataCanbus.DATA[473];
                int day4 = DataCanbus.DATA[472];
                int hour4 = DataCanbus.DATA[470];
                int min4 = DataCanbus.DATA[471];
                int month6 = month5 + 1;
                if (month6 > 12) {
                    month6 = 1;
                }
                setCarInfo(4, year6, month6, day4, hour4, min4);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int year7 = DataCanbus.DATA[474];
                int month7 = DataCanbus.DATA[473];
                int day5 = DataCanbus.DATA[472];
                int hour5 = DataCanbus.DATA[470];
                int min5 = DataCanbus.DATA[471];
                int day6 = day5 - 1;
                if (day6 < 1) {
                    day6 = 31;
                }
                setCarInfo(4, year7, month7, day6, hour5, min5);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int year8 = DataCanbus.DATA[474];
                int month8 = DataCanbus.DATA[473];
                int day7 = DataCanbus.DATA[472];
                int hour6 = DataCanbus.DATA[470];
                int min6 = DataCanbus.DATA[471];
                int day8 = day7 + 1;
                if (day8 > 31) {
                    day8 = 1;
                }
                setCarInfo(4, year8, month8, day8, hour6, min6);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int year9 = DataCanbus.DATA[474];
                int month9 = DataCanbus.DATA[473];
                int day9 = DataCanbus.DATA[472];
                int hour7 = DataCanbus.DATA[470];
                int min7 = DataCanbus.DATA[471];
                int hour8 = hour7 - 1;
                if (hour8 < 0) {
                    hour8 = 23;
                }
                setCarInfo(4, year9, month9, day9, hour8, min7);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int year10 = DataCanbus.DATA[474];
                int month10 = DataCanbus.DATA[473];
                int day10 = DataCanbus.DATA[472];
                int hour9 = DataCanbus.DATA[470];
                int min8 = DataCanbus.DATA[471];
                int hour10 = hour9 + 1;
                if (hour10 > 23) {
                    hour10 = 0;
                }
                setCarInfo(4, year10, month10, day10, hour10, min8);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int year11 = DataCanbus.DATA[474];
                int month11 = DataCanbus.DATA[473];
                int day11 = DataCanbus.DATA[472];
                int hour11 = DataCanbus.DATA[470];
                int min9 = DataCanbus.DATA[471] - 5;
                if (min9 < 0) {
                    min9 = 55;
                }
                setCarInfo(4, year11, month11, day11, hour11, min9);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int year12 = DataCanbus.DATA[474];
                int month12 = DataCanbus.DATA[473];
                int day12 = DataCanbus.DATA[472];
                int hour12 = DataCanbus.DATA[470];
                int min10 = DataCanbus.DATA[471] + 5;
                if (min10 > 55) {
                    min10 = 0;
                }
                setCarInfo(4, year12, month12, day12, hour12, min10);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int year13 = DataCanbus.DATA[479];
                int month13 = DataCanbus.DATA[478];
                int day13 = DataCanbus.DATA[477];
                int hour13 = DataCanbus.DATA[475];
                int min11 = DataCanbus.DATA[476];
                int year14 = year13 - 1;
                if (year14 < 0) {
                    year14 = 99;
                }
                setCarInfo(5, year14, month13, day13, hour13, min11);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int year15 = DataCanbus.DATA[479];
                int month14 = DataCanbus.DATA[478];
                int day14 = DataCanbus.DATA[477];
                int hour14 = DataCanbus.DATA[475];
                int min12 = DataCanbus.DATA[476];
                int year16 = year15 + 1;
                if (year16 > 99) {
                    year16 = 0;
                }
                setCarInfo(5, year16, month14, day14, hour14, min12);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int year17 = DataCanbus.DATA[479];
                int month15 = DataCanbus.DATA[478];
                int day15 = DataCanbus.DATA[477];
                int hour15 = DataCanbus.DATA[475];
                int min13 = DataCanbus.DATA[476];
                int month16 = month15 - 1;
                if (month16 < 1) {
                    month16 = 12;
                }
                setCarInfo(5, year17, month16, day15, hour15, min13);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int year18 = DataCanbus.DATA[479];
                int month17 = DataCanbus.DATA[478];
                int day16 = DataCanbus.DATA[477];
                int hour16 = DataCanbus.DATA[475];
                int min14 = DataCanbus.DATA[476];
                int month18 = month17 + 1;
                if (month18 > 12) {
                    month18 = 1;
                }
                setCarInfo(5, year18, month18, day16, hour16, min14);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int year19 = DataCanbus.DATA[479];
                int month19 = DataCanbus.DATA[478];
                int day17 = DataCanbus.DATA[477];
                int hour17 = DataCanbus.DATA[475];
                int min15 = DataCanbus.DATA[476];
                int day18 = day17 - 1;
                if (day18 < 1) {
                    day18 = 31;
                }
                setCarInfo(5, year19, month19, day18, hour17, min15);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int year20 = DataCanbus.DATA[479];
                int month20 = DataCanbus.DATA[478];
                int day19 = DataCanbus.DATA[477];
                int hour18 = DataCanbus.DATA[475];
                int min16 = DataCanbus.DATA[476];
                int day20 = day19 + 1;
                if (day20 > 31) {
                    day20 = 1;
                }
                setCarInfo(5, year20, month20, day20, hour18, min16);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int year21 = DataCanbus.DATA[479];
                int month21 = DataCanbus.DATA[478];
                int day21 = DataCanbus.DATA[477];
                int hour19 = DataCanbus.DATA[475];
                int min17 = DataCanbus.DATA[476];
                int hour20 = hour19 - 1;
                if (hour20 < 0) {
                    hour20 = 23;
                }
                setCarInfo(5, year21, month21, day21, hour20, min17);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int year22 = DataCanbus.DATA[479];
                int month22 = DataCanbus.DATA[478];
                int day22 = DataCanbus.DATA[477];
                int hour21 = DataCanbus.DATA[475];
                int min18 = DataCanbus.DATA[476];
                int hour22 = hour21 + 1;
                if (hour22 > 23) {
                    hour22 = 0;
                }
                setCarInfo(5, year22, month22, day22, hour22, min18);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int year23 = DataCanbus.DATA[479];
                int month23 = DataCanbus.DATA[478];
                int day23 = DataCanbus.DATA[477];
                int hour23 = DataCanbus.DATA[475];
                int min19 = DataCanbus.DATA[476] - 5;
                if (min19 < 0) {
                    min19 = 55;
                }
                setCarInfo(5, year23, month23, day23, hour23, min19);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int year24 = DataCanbus.DATA[479];
                int month24 = DataCanbus.DATA[478];
                int day24 = DataCanbus.DATA[477];
                int hour24 = DataCanbus.DATA[475];
                int min20 = DataCanbus.DATA[476] + 5;
                if (min20 > 55) {
                    min20 = 0;
                }
                setCarInfo(5, year24, month24, day24, hour24, min20);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int year25 = DataCanbus.DATA[484];
                int month25 = DataCanbus.DATA[483];
                int day25 = DataCanbus.DATA[482];
                int hour25 = DataCanbus.DATA[480];
                int min21 = DataCanbus.DATA[481];
                int year26 = year25 - 1;
                if (year26 < 0) {
                    year26 = 99;
                }
                setCarInfo(6, year26, month25, day25, hour25, min21);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int year27 = DataCanbus.DATA[484];
                int month26 = DataCanbus.DATA[483];
                int day26 = DataCanbus.DATA[482];
                int hour26 = DataCanbus.DATA[480];
                int min22 = DataCanbus.DATA[481];
                int year28 = year27 + 1;
                if (year28 > 99) {
                    year28 = 0;
                }
                setCarInfo(6, year28, month26, day26, hour26, min22);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int year29 = DataCanbus.DATA[484];
                int month27 = DataCanbus.DATA[483];
                int day27 = DataCanbus.DATA[482];
                int hour27 = DataCanbus.DATA[480];
                int min23 = DataCanbus.DATA[481];
                int month28 = month27 - 1;
                if (month28 < 1) {
                    month28 = 12;
                }
                setCarInfo(6, year29, month28, day27, hour27, min23);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int year30 = DataCanbus.DATA[484];
                int month29 = DataCanbus.DATA[483];
                int day28 = DataCanbus.DATA[482];
                int hour28 = DataCanbus.DATA[480];
                int min24 = DataCanbus.DATA[481];
                int month30 = month29 + 1;
                if (month30 > 12) {
                    month30 = 1;
                }
                setCarInfo(6, year30, month30, day28, hour28, min24);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int year31 = DataCanbus.DATA[484];
                int month31 = DataCanbus.DATA[483];
                int day29 = DataCanbus.DATA[482];
                int hour29 = DataCanbus.DATA[480];
                int min25 = DataCanbus.DATA[481];
                int day30 = day29 - 1;
                if (day30 < 1) {
                    day30 = 31;
                }
                setCarInfo(6, year31, month31, day30, hour29, min25);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int year32 = DataCanbus.DATA[484];
                int month32 = DataCanbus.DATA[483];
                int day31 = DataCanbus.DATA[482];
                int hour30 = DataCanbus.DATA[480];
                int min26 = DataCanbus.DATA[481];
                int day32 = day31 + 1;
                if (day32 > 31) {
                    day32 = 1;
                }
                setCarInfo(6, year32, month32, day32, hour30, min26);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int year33 = DataCanbus.DATA[484];
                int month33 = DataCanbus.DATA[483];
                int day33 = DataCanbus.DATA[482];
                int hour31 = DataCanbus.DATA[480];
                int min27 = DataCanbus.DATA[481];
                int hour32 = hour31 - 1;
                if (hour32 < 0) {
                    hour32 = 23;
                }
                setCarInfo(6, year33, month33, day33, hour32, min27);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int year34 = DataCanbus.DATA[484];
                int month34 = DataCanbus.DATA[483];
                int day34 = DataCanbus.DATA[482];
                int hour33 = DataCanbus.DATA[480];
                int min28 = DataCanbus.DATA[481];
                int hour34 = hour33 + 1;
                if (hour34 > 23) {
                    hour34 = 0;
                }
                setCarInfo(6, year34, month34, day34, hour34, min28);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int year35 = DataCanbus.DATA[484];
                int month35 = DataCanbus.DATA[483];
                int day35 = DataCanbus.DATA[482];
                int hour35 = DataCanbus.DATA[480];
                int min29 = DataCanbus.DATA[481] - 5;
                if (min29 < 0) {
                    min29 = 55;
                }
                setCarInfo(6, year35, month35, day35, hour35, min29);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int year36 = DataCanbus.DATA[484];
                int month36 = DataCanbus.DATA[483];
                int day36 = DataCanbus.DATA[482];
                int hour36 = DataCanbus.DATA[480];
                int min30 = DataCanbus.DATA[481] + 5;
                if (min30 > 55) {
                    min30 = 0;
                }
                setCarInfo(6, year36, month36, day36, hour36, min30);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5) {
        DataCanbus.PROXY.cmd(148, new int[]{value0, value1, value2, value3, value4, value5}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[468].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[469].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[470].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[471].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[472].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[473].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[474].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[475].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[476].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[477].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[478].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[479].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[480].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[481].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[482].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[483].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[484].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[485].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[468].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[469].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[470].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[471].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[472].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[473].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[474].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[475].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[476].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[477].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[478].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[479].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[480].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[481].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[482].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[483].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[484].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[485].removeNotify(this.mNotifyCanbus);
    }
}
