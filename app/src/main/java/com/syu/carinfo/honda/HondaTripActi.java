package com.syu.carinfo.honda;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HondaTripActi extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.HondaTripActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 0:
                    HondaTripActi.this.currentOilConsumption();
                    break;
                case 1:
                    HondaTripActi.this.currentAverageOilConsumption();
                    break;
                case 2:
                    HondaTripActi.this.historyAverageOilConsumption();
                    break;
                case 5:
                case 10:
                    HondaTripActi.this.lastMile();
                    break;
                case 6:
                    HondaTripActi.this.currentOilConsumptionUnit();
                    break;
                case 7:
                    HondaTripActi.this.currentAverageOilConsumption();
                    HondaTripActi.this.historyAverageOilConsumption();
                    break;
                case 11:
                    HondaTripActi.this.currentAverageOilConsumption();
                    HondaTripActi.this.historyAverageOilConsumption();
                    break;
                case 103:
                case 104:
                    HondaTripActi.this.currentDrivedTime();
                    break;
                case 174:
                    if (((TextView) HondaTripActi.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) HondaTripActi.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jiede_trip);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] != 1966378 && findViewById(R.id.layout_view1) != null) {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_Honda_17CRV /* 459073 */:
            case FinalCanbus.CAR_WC2_Honda_17CRV_H /* 524609 */:
            case FinalCanbus.CAR_WC2_Honda_17CRV_M /* 590145 */:
            case FinalCanbus.CAR_RZC_XP1_17CRV /* 786730 */:
            case FinalCanbus.CAR_WC2_Honda_16SIYU_HAND /* 786753 */:
            case FinalCanbus.CAR_XP1_17CRV /* 852266 */:
            case FinalCanbus.CAR_WC2_Honda_16SIYU_AUTO /* 852289 */:
            case FinalCanbus.CAR_WC2_Honda_17GuanDao /* 917825 */:
            case FinalCanbus.CAR_WC2_Honda_19CRV /* 1179969 */:
            case FinalCanbus.CAR_WC2_Honda_19Lingpai /* 1245505 */:
            case FinalCanbus.CAR_WC2_Honda_19Xiangyu /* 1311041 */:
            case FinalCanbus.CAR_RZC_HONDA_10Yage /* 1769770 */:
            case FinalCanbus.CAR_RZC_HONDA_20Haoying /* 1835306 */:
            case FinalCanbus.CAR_RZC_HONDA_20Haoying_H /* 1900842 */:
            case FinalCanbus.CAR_RZC_HONDA_21Haoying /* 2425130 */:
            case FinalCanbus.CAR_RZC_HONDA_21CRV /* 2490666 */:
            case FinalCanbus.CAR_RZC_HONDA_10Yage_H /* 2556202 */:
            case FinalCanbus.CAR_RZC_HONDA_2022SIYU /* 2687274 */:
            case FinalCanbus.CAR_RZC_HONDA_2022Lingpai /* 2752810 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_10Yage /* 3014954 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_10Yage_H /* 3080490 */:
            case FinalCanbus.CAR_RZC_XP1_22ZRV /* 3211562 */:
            case FinalCanbus.CAR_RZC_XP1_22ZRV_H /* 3277098 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_17CRV /* 3932458 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_17BREEZE /* 3997994 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_17CRV_H /* 4194602 */:
                ((TextView) findViewById(R.id.crv_title_curr_oil)).setText(R.string.average_oil_cur);
                ((TextView) findViewById(R.id.crv_title_his_oil)).setText(R.string.average_oil_history);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(100, 1);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        super.removeNotify();
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void currentDrivedTime() {
        int value = DataCanbus.DATA[103];
        int value1 = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.jiede_trip_tv_driving_time)) != null) {
            ((TextView) findViewById(R.id.jiede_trip_tv_driving_time)).setText(String.valueOf(value) + " : " + value1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void currentOilConsumption() {
        int value = DataCanbus.DATA[0];
        if (((ProgressBar) findViewById(R.id.jiede_trip_progress_curr_oil)) != null) {
            if (value < 0 || value == 255) {
                value = 0;
            } else if (value > 21) {
                value = 21;
            }
            ((ProgressBar) findViewById(R.id.jiede_trip_progress_curr_oil)).setProgress(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void currentAverageOilConsumption() {
        int value;
        int value2 = DataCanbus.DATA[1];
        int unit = DataCanbus.DATA[7];
        int max = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.jiede_trip_tv_ave_curr_oil)) != null) {
            if (value2 == 65535) {
                ((TextView) findViewById(R.id.jiede_trip_tv_ave_curr_oil)).setText("--.-");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.jiede_trip_tv_ave_curr_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " KM/L");
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.jiede_trip_tv_ave_curr_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " L/100KM");
            } else {
                ((TextView) findViewById(R.id.jiede_trip_tv_ave_curr_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " MPG");
            }
        }
        if (((ProgressBar) findViewById(R.id.jiede_trip_progress_ave_curr_oil)) != null && max > 0) {
            if (value2 < 0 || value2 == 65535) {
                value = 0;
            } else {
                value = (value2 * 21) / max;
            }
            ((ProgressBar) findViewById(R.id.jiede_trip_progress_ave_curr_oil)).setProgress(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void historyAverageOilConsumption() {
        int value;
        int value2 = DataCanbus.DATA[2];
        int unit = DataCanbus.DATA[7];
        int max = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.jiede_trip_tv_ave_his_oil)) != null) {
            if (value2 == 65535) {
                ((TextView) findViewById(R.id.jiede_trip_tv_ave_his_oil)).setText("--.-");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.jiede_trip_tv_ave_his_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " KM/L");
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.jiede_trip_tv_ave_his_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " L/100KM");
            } else {
                ((TextView) findViewById(R.id.jiede_trip_tv_ave_his_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " MPG");
            }
        }
        if (((ProgressBar) findViewById(R.id.jiede_trip_progress_ave_his_oil)) != null && max > 0) {
            if (value2 < 0 || value2 == 65535) {
                value = 0;
            } else {
                value = (value2 * 21) / max;
            }
            ((ProgressBar) findViewById(R.id.jiede_trip_progress_ave_his_oil)).setProgress(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void currentOilConsumptionUnit() {
        int value = DataCanbus.DATA[6];
        if (((TextView) findViewById(R.id.jiede_trip_tv_curr_oil_unit)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.jiede_trip_tv_curr_oil_unit)).setText("KM/L");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.jiede_trip_tv_curr_oil_unit)).setText("L/100KM");
            } else {
                ((TextView) findViewById(R.id.jiede_trip_tv_curr_oil_unit)).setText("MPG");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lastMile() {
        int value = DataCanbus.DATA[5];
        int unit = DataCanbus.DATA[10];
        if (((TextView) findViewById(R.id.jiede_trip_tv_driving_mileage)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.jiede_trip_tv_driving_mileage)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.jiede_trip_tv_driving_mileage)).setText(String.valueOf(value) + " M");
            } else {
                ((TextView) findViewById(R.id.jiede_trip_tv_driving_mileage)).setText(String.valueOf(value) + " KM");
            }
        }
    }
}
