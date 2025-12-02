package com.syu.carinfo.oudi.beiqi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityEnvironmentProtect extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
                case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                    int value = DataCanbus.DATA[updateCode];
                    switch (updateCode) {
                        case 105:
                            if (((TextView) ActivityEnvironmentProtect.this.findViewById(R.id.tv_277_drivered)) != null) {
                                ((TextView) ActivityEnvironmentProtect.this.findViewById(R.id.tv_277_drivered)).setText(new StringBuilder().append(value).toString());
                                break;
                            }
                        case 106:
                            if (((TextView) ActivityEnvironmentProtect.this.findViewById(R.id.tv_227_level_title)) != null) {
                                int titleLevelId = R.string.str_227_ec180_environmental_level_title_0;
                                switch (value) {
                                    case 0:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_0;
                                        break;
                                    case 1:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_1;
                                        break;
                                    case 2:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_2;
                                        break;
                                    case 3:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_3;
                                        break;
                                    case 4:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_4;
                                        break;
                                    case 5:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_5;
                                        break;
                                    case 6:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_6;
                                        break;
                                    case 7:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_7;
                                        break;
                                    case 8:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_8;
                                        break;
                                    case 9:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_9;
                                        break;
                                    case 10:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_10;
                                        break;
                                    case 11:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_11;
                                        break;
                                    case 12:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_12;
                                        break;
                                    case 13:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_13;
                                        break;
                                    case 14:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_14;
                                        break;
                                    case 15:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_15;
                                        break;
                                    case 16:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_16;
                                        break;
                                    case 17:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_17;
                                        break;
                                    case 18:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_18;
                                        break;
                                    case 19:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_19;
                                        break;
                                    case 20:
                                        titleLevelId = R.string.str_227_ec180_environmental_level_title_20;
                                        break;
                                }
                                ((TextView) ActivityEnvironmentProtect.this.findViewById(R.id.tv_227_level_title)).setText(titleLevelId);
                                break;
                            }
                        case 107:
                            if (((TextView) ActivityEnvironmentProtect.this.findViewById(R.id.tv_277_co2)) != null) {
                                ((TextView) ActivityEnvironmentProtect.this.findViewById(R.id.tv_277_co2)).setText(new StringBuilder().append(value).toString());
                                break;
                            }
                        case 108:
                            if (((TextView) ActivityEnvironmentProtect.this.findViewById(R.id.tv_277_equal_plant_tree)) != null) {
                                ((TextView) ActivityEnvironmentProtect.this.findViewById(R.id.tv_277_equal_plant_tree)).setText(new StringBuilder().append(value).toString());
                                break;
                            }
                    }
                case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                    switch (updateCode) {
                        case 100:
                            ActivityEnvironmentProtect.this.updateDriveMiles(DataCanbus.DATA[updateCode]);
                            break;
                    }
                default:
                    switch (updateCode) {
                        case 98:
                            ActivityEnvironmentProtect.this.updateDriveMiles(DataCanbus.DATA[updateCode]);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_227_environment_protect);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
                break;
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
                break;
        }
    }

    private void removeNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
                break;
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
                break;
        }
    }

    
    public void updateDriveMiles(int value) {
        int titleLevelId;
        if (((TextView) findViewById(R.id.tv_277_drivered)) != null) {
            ((TextView) findViewById(R.id.tv_277_drivered)).setText(new StringBuilder().append(value).toString());
        }
        if (((TextView) findViewById(R.id.tv_277_co2)) != null) {
            ((TextView) findViewById(R.id.tv_277_co2)).setText(new StringBuilder(String.valueOf((value + 5) / 6)).toString());
        }
        if (((TextView) findViewById(R.id.tv_277_equal_plant_tree)) != null) {
            ((TextView) findViewById(R.id.tv_277_equal_plant_tree)).setText(new StringBuilder(String.valueOf((value + 51) / 102)).toString());
        }
        if (((TextView) findViewById(R.id.tv_227_level_title)) != null) {
            if (value < 100) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_0;
            } else if (value < 200) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_1;
            } else if (value < 400) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_2;
            } else if (value < 800) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_3;
            } else if (value < 1200) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_4;
            } else if (value < 1800) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_5;
            } else if (value < 2400) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_6;
            } else if (value < 3000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_7;
            } else if (value < 3800) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_8;
            } else if (value < 5000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_9;
            } else if (value < 6000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_10;
            } else if (value < 7000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_11;
            } else if (value < 8000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_12;
            } else if (value < 9000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_13;
            } else if (value < 10000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_14;
            } else if (value < 12000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_15;
            } else if (value < 15000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_16;
            } else if (value < 20000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_17;
            } else if (value < 30000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_18;
            } else if (value < 50000) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_19;
            } else {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_20;
            }
            ((TextView) findViewById(R.id.tv_227_level_title)).setText(titleLevelId);
        }
    }
}
