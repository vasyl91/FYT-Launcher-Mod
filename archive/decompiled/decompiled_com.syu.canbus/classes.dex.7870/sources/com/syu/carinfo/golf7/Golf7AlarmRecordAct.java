package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Golf7AlarmRecordAct extends BaseActivity {
    private TextView[] mTvWarning = new TextView[18];
    private TextView[] mTvWarningLine = new TextView[18];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7AlarmRecordAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 171:
                    if (ints == null) {
                        for (int i = 0; i < 16; i++) {
                            int[] ints2 = ConstGolf.mVehicleWarning[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i, 0};
                            }
                            Golf7AlarmRecordAct.this.vehicleWarning(ints2);
                        }
                    } else {
                        Golf7AlarmRecordAct.this.vehicleWarning(ints);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setContentView(R.layout.layout_golf7_alarm_record_od);
        } else {
            setContentView(R.layout.layout_golf7_alarm_record);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTvWarning[0] = (TextView) findViewById(R.id.tv_text1);
        this.mTvWarning[1] = (TextView) findViewById(R.id.tv_text2);
        this.mTvWarning[2] = (TextView) findViewById(R.id.tv_text3);
        this.mTvWarning[3] = (TextView) findViewById(R.id.tv_text4);
        this.mTvWarning[4] = (TextView) findViewById(R.id.tv_text5);
        this.mTvWarning[5] = (TextView) findViewById(R.id.tv_text6);
        this.mTvWarning[6] = (TextView) findViewById(R.id.tv_text7);
        this.mTvWarning[7] = (TextView) findViewById(R.id.tv_text8);
        this.mTvWarning[8] = (TextView) findViewById(R.id.tv_text9);
        this.mTvWarning[9] = (TextView) findViewById(R.id.tv_text10);
        this.mTvWarning[10] = (TextView) findViewById(R.id.tv_text11);
        this.mTvWarning[11] = (TextView) findViewById(R.id.tv_text12);
        this.mTvWarning[12] = (TextView) findViewById(R.id.tv_text13);
        this.mTvWarning[13] = (TextView) findViewById(R.id.tv_text14);
        this.mTvWarning[14] = (TextView) findViewById(R.id.tv_text15);
        this.mTvWarning[15] = (TextView) findViewById(R.id.tv_text16);
        this.mTvWarning[16] = (TextView) findViewById(R.id.tv_text17);
        this.mTvWarning[17] = (TextView) findViewById(R.id.tv_text18);
        this.mTvWarningLine[0] = (TextView) findViewById(R.id.tv_text21);
        this.mTvWarningLine[1] = (TextView) findViewById(R.id.tv_text22);
        this.mTvWarningLine[2] = (TextView) findViewById(R.id.tv_text23);
        this.mTvWarningLine[3] = (TextView) findViewById(R.id.tv_text24);
        this.mTvWarningLine[4] = (TextView) findViewById(R.id.tv_text25);
        this.mTvWarningLine[5] = (TextView) findViewById(R.id.tv_text26);
        this.mTvWarningLine[6] = (TextView) findViewById(R.id.tv_text27);
        this.mTvWarningLine[7] = (TextView) findViewById(R.id.tv_text28);
        this.mTvWarningLine[8] = (TextView) findViewById(R.id.tv_text29);
        this.mTvWarningLine[9] = (TextView) findViewById(R.id.tv_text30);
        this.mTvWarningLine[10] = (TextView) findViewById(R.id.tv_text31);
        this.mTvWarningLine[11] = (TextView) findViewById(R.id.tv_text32);
        this.mTvWarningLine[12] = (TextView) findViewById(R.id.tv_text33);
        this.mTvWarningLine[13] = (TextView) findViewById(R.id.tv_text34);
        this.mTvWarningLine[14] = (TextView) findViewById(R.id.tv_text35);
        this.mTvWarningLine[15] = (TextView) findViewById(R.id.tv_text36);
        this.mTvWarningLine[16] = (TextView) findViewById(R.id.tv_text37);
        this.mTvWarningLine[17] = (TextView) findViewById(R.id.tv_text38);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        switch (DataCanbus.DATA[1000]) {
            case 160:
            case FinalCanbus.CAR_CYT_GaoErFu7 /* 65576 */:
            case FinalCanbus.CAR_CYT_GaoErFu7_M /* 131112 */:
            case FinalCanbus.CAR2_RZC_XP1_DaZhong_GaoErFu7_H /* 131232 */:
            case FinalCanbus.CAR_CYT_GaoErFu7_H /* 196648 */:
            case FinalCanbus.CAR_RZC_XP1_MaiTeng /* 196768 */:
            case FinalCanbus.CAR_RZC_TuGuan_L /* 262304 */:
            case FinalCanbus.CAR_OD_GaoErFu7 /* 327720 */:
            case FinalCanbus.CAR_RZC_TuAng /* 327840 */:
            case FinalCanbus.CAR_OD_TuAnL /* 393256 */:
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP /* 458912 */:
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP_H /* 524448 */:
            case FinalCanbus.CAR2_RZC_DaZhong_Tange /* 589984 */:
            case FinalCanbus.CAR2_RZC_DaZhong_MQB_E /* 655520 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20 /* 721056 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Lavida_plus /* 786592 */:
            case FinalCanbus.CAR_RZC_MQB_11_18Sagitar /* 852128 */:
            case FinalCanbus.CAR_RZC_MQB_19Sagitar /* 917664 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Passat /* 983200 */:
            case FinalCanbus.CAR_RZC_MQB_19Passat /* 1048736 */:
            case FinalCanbus.CAR_RZC_MQB_19Tharu /* 1179808 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Golf7 /* 1310880 */:
            case FinalCanbus.CAR_RZC_MQB_19Bora /* 1376416 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Lamando /* 1441952 */:
            case FinalCanbus.CAR_RZC_MQB_19Polo /* 1507488 */:
            case FinalCanbus.CAR_RZC_MQB_19CC /* 1573024 */:
            case FinalCanbus.CAR_RZC_MQB_19T_Cross /* 1638560 */:
            case FinalCanbus.CAR_RZC_MQB_16_18TouranL /* 1704096 */:
            case FinalCanbus.CAR_RZC_MQB_17_18C_Trek /* 1769632 */:
            case FinalCanbus.CAR_RZC_MQB_16_19Golf_jialv /* 1835168 */:
            case FinalCanbus.CAR_RZC_MQB_19T_ROC /* 1900704 */:
            case FinalCanbus.CAR_RZC_MQB_19Tayron /* 1966240 */:
            case FinalCanbus.CAR_RZC_MQB_13_14Octavia /* 2031776 */:
            case FinalCanbus.CAR_RZC_MQB_15_19Octavia /* 2097312 */:
            case FinalCanbus.CAR_RZC_MQB_13_15Superb /* 2162848 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Superb /* 2228384 */:
            case FinalCanbus.CAR_RZC_MQB_18Kamiq /* 2293920 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Karoq /* 2359456 */:
            case FinalCanbus.CAR_RZC_MQB_17_19Kodiaq /* 2424992 */:
            case FinalCanbus.CAR_RZC_MQB_14_18Caravan /* 2490528 */:
            case FinalCanbus.CAR_RZC_MQB_19Jetta_VS5 /* 2556064 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Touareg /* 2621600 */:
            case FinalCanbus.CAR_RZC_MQB_09_19Multivan /* 2687136 */:
            case FinalCanbus.CAR_RZC_MQB_Jetta_Brazil /* 2752672 */:
            case FinalCanbus.CAR_RZC_MQB_SUPERB_Turkey /* 2818208 */:
            case FinalCanbus.CAR_RZC_MQB_Huiang_21 /* 3080352 */:
            case FinalCanbus.CAR_RZC_MQB_20Tayron_GTE /* 3145888 */:
            case FinalCanbus.CAR_RZC_MQB_20Jetta_VS7 /* 3211424 */:
            case FinalCanbus.CAR_RZC_MQB_20Viloran /* 3276960 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Weilan /* 3408032 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20_H /* 3473568 */:
            case FinalCanbus.CAR_6606_MQB_Lavida_23 /* 3539104 */:
            case FinalCanbus.CAR_RZC_MQB_All_360 /* 3670176 */:
            case FinalCanbus.CAR_RZC_MaiTeng_20_H_EC /* 3801248 */:
            case FinalCanbus.CAR_RZC_TuguanL_AHD_23 /* 3932320 */:
            case FinalCanbus.CAR_RZC_Sagitar_AHD_23 /* 3997856 */:
            case FinalCanbus.CAR_RZC_Bora_AHD_23 /* 4063392 */:
                for (int i = 7; i < 18; i++) {
                    this.mTvWarning[i].setVisibility(8);
                    this.mTvWarningLine[i].setVisibility(8);
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vehicleWarning(int[] ints) {
        String str = "";
        int index = 0;
        if (DataCanbus.DATA[1000] == 17 || DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 524305) {
            if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 16) {
                index = ints[0];
                int value = ints[1];
                if (value > 0 && value < Golf7Data.mStrVehicleWarning.length) {
                    str = Golf7Data.mStrVehicleWarning[value - 1];
                }
            } else {
                str = "";
            }
            this.mTvWarning[index].setText(String.valueOf(index + 1) + "." + str);
            return;
        }
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            index = ints[0];
            int value2 = ints[1];
            if (value2 > 0 && value2 < Golf7Data.mStrVehicleWarning.length) {
                str = Golf7Data.mStrVehicleWarningXp[value2 - 1];
            }
        } else {
            str = "";
        }
        this.mTvWarning[index].setText(String.valueOf(index + 1) + "." + str);
    }
}
