package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLAirMessageAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    boolean bRzc_Gl8 = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLAirMessageAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    YLAirMessageAct.this.updaterAutoAirVo();
                    break;
                case 1:
                    YLAirMessageAct.this.updaterAirQualitySensor1();
                    break;
                case 2:
                    YLAirMessageAct.this.updaterAutoZoneCon();
                    break;
                case 3:
                    YLAirMessageAct.this.updaterAutoRearWindowDefogg();
                    break;
                case 4:
                    YLAirMessageAct.this.updaterAutoFrontWindowDefogg();
                    break;
                case 5:
                    YLAirMessageAct.this.updaterRemoteSeatAutoHeat();
                    break;
                case 6:
                    YLAirMessageAct.this.updaterAirConditioning();
                    break;
                case 57:
                    YLAirMessageAct.this.updaterFeeback();
                    break;
                case 58:
                    YLAirMessageAct.this.updaterAutoAc();
                    break;
                case 59:
                    YLAirMessageAct.this.updaterOpenBig();
                    break;
                case 60:
                    YLAirMessageAct.this.updaterNavi();
                    break;
                case 61:
                    YLAirMessageAct.this.updaterRuning();
                    break;
                case 62:
                    YLAirMessageAct.this.updaterClose();
                    break;
                case 63:
                    YLAirMessageAct.this.updaterRemoteSeatAutoHeatAble();
                    break;
                case 282:
                    YLAirMessageAct.this.updaterearairpower();
                    break;
                case 283:
                    YLAirMessageAct.this.updateremotepowerair();
                    break;
                case 284:
                    YLAirMessageAct.this.updateremotepowerseatblow();
                    break;
                case 285:
                    YLAirMessageAct.this.updateRemotepowerseatheat();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_air_message_set);
        setUI();
    }

    private void setUI() {
        setClick((CheckedTextView) findViewById(R.id.xp_yl_btn_remote_Seat_auto_heating_check));
        setClick((Button) findViewById(R.id.xp_yl_air_Air_quality_sensor_pre));
        setClick((Button) findViewById(R.id.xp_yl_air_Air_quality_sensor_next));
        setClick((CheckedTextView) findViewById(R.id.xp_yl_btn_Auto_front_window_defogging_check));
        setClick((CheckedTextView) findViewById(R.id.xp_yl_air_Auto_rear_window_defogging_check));
        setClick((Button) findViewById(R.id.xp_yl_btn_Autoc_air_volume_pre));
        setClick((Button) findViewById(R.id.xp_yl_btn_Auto_air_volume_next));
        setClick((Button) findViewById(R.id.xp_yl_btn_Air_conditioning_pre));
        setClick((Button) findViewById(R.id.xp_yl_btn_Air_conditioning_next));
        setClick((Button) findViewById(R.id.xp_yl_btn_Auto_zone_climate_control_pre));
        setClick((Button) findViewById(R.id.xp_yl_btn_Auto_zone_climate_control_next));
        setClick(findViewById(R.id.rzc_gl8_remote_start_seat_blow));
        setClick(findViewById(R.id.rzc_gl8_remote_start_seat_heat));
        setClick(findViewById(R.id.rzc_gl8_remote_start_air));
        setClick(findViewById(R.id.rzc_gl8_start_rear_air));
        setClick((Button) findViewById(R.id.xp_wr_remote_Seat_auto_heating_pre));
        setClick((Button) findViewById(R.id.xp_wr_remote_Seat_auto_heating_next));
        this.bRzc_Gl8 = DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 393479 || DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087;
        if (findViewById(R.id.rzc_gl8_remote_start_seat_blow) != null) {
            findViewById(R.id.rzc_gl8_remote_start_seat_blow).setVisibility(this.bRzc_Gl8 ? 0 : 8);
        }
        if (findViewById(R.id.rzc_gl8_remote_start_seat_heat) != null) {
            findViewById(R.id.rzc_gl8_remote_start_seat_heat).setVisibility(this.bRzc_Gl8 ? 0 : 8);
        }
        if (findViewById(R.id.rzc_gl8_remote_start_air) != null) {
            findViewById(R.id.rzc_gl8_remote_start_air).setVisibility(this.bRzc_Gl8 ? 0 : 8);
        }
        if (findViewById(R.id.rzc_gl8_start_rear_air) != null) {
            findViewById(R.id.rzc_gl8_start_rear_air).setVisibility(this.bRzc_Gl8 ? 0 : 8);
        }
    }

    private void setClick(View v) {
        if (v != null) {
            v.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.xp_yl_btn_Autoc_air_volume_pre /* 2131433449 */:
                int valAutoVolPre = DataCanbus.DATA[0];
                if (valAutoVolPre == 0) {
                    YLFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (valAutoVolPre == 1) {
                    YLFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                } else if (valAutoVolPre == 2) {
                    YLFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                }
            case R.id.xp_yl_btn_Auto_air_volume_next /* 2131433451 */:
                int valAutoVolNext = DataCanbus.DATA[0];
                if (valAutoVolNext == 0) {
                    YLFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                } else if (valAutoVolNext == 1) {
                    YLFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (valAutoVolNext == 2) {
                    YLFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                }
            case R.id.xp_yl_btn_Air_conditioning_pre /* 2131433453 */:
                int valAirConPre = DataCanbus.DATA[6];
                if (valAirConPre == 0) {
                    YLFunc.CAR_AIR_CONTROL(6, 2);
                    break;
                } else if (valAirConPre == 1) {
                    YLFunc.CAR_AIR_CONTROL(6, 0);
                    break;
                } else if (valAirConPre == 2) {
                    YLFunc.CAR_AIR_CONTROL(6, 1);
                    break;
                }
            case R.id.xp_yl_btn_Air_conditioning_next /* 2131433455 */:
                int valAirConNext = DataCanbus.DATA[6];
                if (valAirConNext == 0) {
                    YLFunc.CAR_AIR_CONTROL(6, 1);
                    break;
                } else if (valAirConNext == 1) {
                    YLFunc.CAR_AIR_CONTROL(6, 2);
                    break;
                } else if (valAirConNext == 2) {
                    YLFunc.CAR_AIR_CONTROL(6, 0);
                    break;
                }
            case R.id.xp_yl_air_Air_quality_sensor_pre /* 2131433457 */:
                int value = DataCanbus.DATA[1];
                if (value == 0) {
                    YLFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (value == 1) {
                    YLFunc.CAR_AIR_CONTROL(1, 0);
                    break;
                } else if (value == 2) {
                    YLFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                }
            case R.id.xp_yl_air_Air_quality_sensor_next /* 2131433459 */:
                int valueQualityNext = DataCanbus.DATA[1];
                if (valueQualityNext == 0) {
                    YLFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                } else if (valueQualityNext == 1) {
                    YLFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (valueQualityNext == 2) {
                    YLFunc.CAR_AIR_CONTROL(1, 0);
                    break;
                }
            case R.id.xp_yl_btn_Auto_zone_climate_control_pre /* 2131433461 */:
                int valAutoZonePre = DataCanbus.DATA[2];
                if (valAutoZonePre == 0) {
                    YLFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (valAutoZonePre == 1) {
                    YLFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                } else if (valAutoZonePre == 2) {
                    YLFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                }
            case R.id.xp_yl_btn_Auto_zone_climate_control_next /* 2131433463 */:
                int valAutoZoneNext = DataCanbus.DATA[2];
                if (valAutoZoneNext == 0) {
                    YLFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                } else if (valAutoZoneNext == 1) {
                    YLFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (valAutoZoneNext == 2) {
                    YLFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                }
            case R.id.xp_yl_btn_remote_Seat_auto_heating_check /* 2131433465 */:
                int valRemoteSeatHeat = DataCanbus.DATA[5];
                YLFunc.CAR_AIR_CONTROL(5, valRemoteSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.xp_wr_remote_Seat_auto_heating_pre /* 2131433467 */:
                int Heat_next = DataCanbus.DATA[5] - 1;
                if (Heat_next <= 0) {
                    Heat_next = 2;
                }
                YLFunc.CAR_AIR_CONTROL(5, Heat_next);
                break;
            case R.id.xp_wr_remote_Seat_auto_heating_next /* 2131433469 */:
                int Heat_pre = DataCanbus.DATA[5] + 1;
                if (Heat_pre >= 2) {
                    Heat_pre = 0;
                }
                YLFunc.CAR_AIR_CONTROL(5, Heat_pre);
                break;
            case R.id.xp_yl_btn_Auto_front_window_defogging_check /* 2131433471 */:
                int valAutFrontDefog = DataCanbus.DATA[4];
                YLFunc.CAR_AIR_CONTROL(4, valAutFrontDefog == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_air_Auto_rear_window_defogging_check /* 2131433473 */:
                int valRearWindowDefog = DataCanbus.DATA[3];
                YLFunc.CAR_AIR_CONTROL(3, valRearWindowDefog == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_remote_start_seat_blow /* 2131433475 */:
                YLFunc.CAR_AIR_CONTROL(66, DataCanbus.DATA[284] == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_remote_start_seat_heat /* 2131433477 */:
                YLFunc.CAR_AIR_CONTROL(65, DataCanbus.DATA[285] == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_remote_start_air /* 2131433479 */:
                YLFunc.CAR_AIR_CONTROL(67, DataCanbus.DATA[283] == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_start_rear_air /* 2131433481 */:
                int val = DataCanbus.DATA[282] + 1;
                if (val > 2) {
                    val = 0;
                }
                YLFunc.CAR_AIR_CONTROL(68, val);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        mIsFront = true;
        if (DataCanbus.DATA[1000] == 2294139) {
            findViewById(R.id.xp_yl_air_Air_conditioning_view).setVisibility(8);
            findViewById(R.id.xp_yl_air_Air_quality_sensor_1_view).setVisibility(8);
            findViewById(R.id.xp_yl_air_Auto_zone_climate_control_view).setVisibility(8);
            findViewById(R.id.xp_yl_btn_remote_Seat_auto_heating_view).setVisibility(8);
            findViewById(R.id.xp_yl_btn_Auto_front_window_defogging_view).setVisibility(8);
            findViewById(R.id.rzc_gl8_remote_start_seat_blow).setVisibility(8);
            findViewById(R.id.rzc_gl8_remote_start_seat_heat).setVisibility(8);
            findViewById(R.id.rzc_gl8_remote_start_air).setVisibility(8);
            findViewById(R.id.rzc_gl8_start_rear_air).setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
        mIsFront = false;
    }

    private void addUpdater() {
        if ((DataCanbus.DATA[1000] & 65535) != 379) {
            DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        if (this.bRzc_Gl8) {
            DataCanbus.NOTIFY_EVENTS[283].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[284].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[285].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[282].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        if (this.bRzc_Gl8) {
            DataCanbus.NOTIFY_EVENTS[283].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[284].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[285].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[282].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFeeback() {
        if (findViewById(R.id.xp_yl_air_Automatic_air_volume_view) != null) {
            int enable = DataCanbus.DATA[57];
            if (enable == 0) {
                findViewById(R.id.xp_yl_air_Automatic_air_volume_view).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.xp_yl_air_Automatic_air_volume_view).setVisibility(0);
            }
        }
    }

    protected void updateRemotepowerseatheat() {
        if (((CheckedTextView) findViewById(R.id.rzc_gl8_remote_start_seat_heat_check)) != null) {
            int val = DataCanbus.DATA[285];
            ((CheckedTextView) findViewById(R.id.rzc_gl8_remote_start_seat_heat_check)).setChecked(val != 0);
        }
    }

    protected void updateremotepowerseatblow() {
        if (((CheckedTextView) findViewById(R.id.rzc_gl8_remote_start_seat_blow_check)) != null) {
            int val = DataCanbus.DATA[284];
            ((CheckedTextView) findViewById(R.id.rzc_gl8_remote_start_seat_blow_check)).setChecked(val != 0);
        }
    }

    protected void updaterearairpower() {
        if (((TextView) findViewById(R.id.rzc_gl8_start_rear_air_tip)) != null) {
            int val = DataCanbus.DATA[282];
            int[] resId = {R.string.str_rzc_17gl8_str1, R.string.str_rzc_17gl8_str2, R.string.str_rzc_17gl8_str3};
            ((TextView) findViewById(R.id.rzc_gl8_start_rear_air_tip)).setText(resId[val]);
        }
    }

    protected void updateremotepowerair() {
        if (((TextView) findViewById(R.id.rzc_gl8_remote_start_air_tip)) != null) {
            int val = DataCanbus.DATA[283];
            int[] resId = {R.string.klc_air_auto, R.string.klc_air_last_Set};
            ((TextView) findViewById(R.id.rzc_gl8_remote_start_air_tip)).setText(resId[val]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoAirVo() {
        if (((TextView) findViewById(R.id.xp_yl_air_Automatic_air_volume_Tv)) != null) {
            int switchOn = DataCanbus.DATA[0];
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.xp_yl_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_low);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.xp_yl_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_middle);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.xp_yl_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_high);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOpenBig() {
        if (findViewById(R.id.xp_yl_air_Air_conditioning_view) != null) {
            int enable = DataCanbus.DATA[59];
            if (enable == 0) {
                findViewById(R.id.xp_yl_air_Air_conditioning_view).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.xp_yl_air_Air_conditioning_view).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAirConditioning() {
        if (((TextView) findViewById(R.id.xp_yl_air_Air_conditioning_Tv)) != null) {
            int switchOn = DataCanbus.DATA[6];
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.xp_yl_air_Air_conditioning_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.xp_yl_air_Air_conditioning_Tv)).setText(R.string.klc_Parking_with_trailer_ON);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.xp_yl_air_Air_conditioning_Tv)).setText(R.string.klc_air_last_set);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoAc() {
        if (findViewById(R.id.xp_yl_air_Air_quality_sensor_1_view) != null) {
            int enable = DataCanbus.DATA[58];
            if (enable == 0) {
                findViewById(R.id.xp_yl_air_Air_quality_sensor_1_view).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.xp_yl_air_Air_quality_sensor_1_view).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAirQualitySensor1() {
        if (((TextView) findViewById(R.id.xp_yl_air_Air_quality_sensor_tv)) != null) {
            int switchOn = DataCanbus.DATA[1];
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.xp_yl_air_Air_quality_sensor_tv)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.xp_yl_air_Air_quality_sensor_tv)).setText(R.string.klc_air_Low_sensitivity);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.xp_yl_air_Air_quality_sensor_tv)).setText(R.string.klc_air_high_sensitivity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterClose() {
        if (findViewById(R.id.xp_yl_air_Auto_zone_climate_control_view) != null) {
            int enable = DataCanbus.DATA[62];
            if (enable == 0) {
                findViewById(R.id.xp_yl_air_Auto_zone_climate_control_view).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.xp_yl_air_Auto_zone_climate_control_view).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoZoneCon() {
        if (((TextView) findViewById(R.id.xp_yl_air_Auto_zone_climate_control_Tv)) != null) {
            int switchOn = DataCanbus.DATA[2];
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.xp_yl_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.xp_yl_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.xp_yl_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_last_Set);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteSeatAutoHeatAble() {
        if (findViewById(R.id.xp_yl_btn_remote_Seat_auto_heating_view) != null) {
            int enable = DataCanbus.DATA[63];
            if (DataCanbus.DATA[1000] == 327998) {
                findViewById(R.id.xp_yl_btn_remote_Seat_auto_heating_view).setVisibility(8);
                if (findViewById(R.id.xp_wr_remote_Seat_auto_heating_view) != null) {
                    findViewById(R.id.xp_wr_remote_Seat_auto_heating_view).setVisibility(enable != 0 ? 0 : 8);
                    return;
                }
                return;
            }
            findViewById(R.id.xp_yl_btn_remote_Seat_auto_heating_view).setVisibility(enable != 0 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteSeatAutoHeat() {
        if (((CheckedTextView) findViewById(R.id.xp_yl_btn_remote_Seat_auto_heating_check)) != null) {
            int switchOn = DataCanbus.DATA[5];
            if (switchOn > 2 || switchOn < 0) {
                switchOn = 0;
            }
            if (DataCanbus.DATA[1000] == 327998) {
                int[] resId = {R.string.off, R.string.str_318_xp_heat_1, R.string.str_318_xp_heat_2};
                if (((TextView) findViewById(R.id.xp_wr_remote_Seat_auto_heating_Tv)) != null && switchOn >= 0 && switchOn <= 2) {
                    ((TextView) findViewById(R.id.xp_wr_remote_Seat_auto_heating_Tv)).setText(resId[switchOn]);
                    return;
                }
                return;
            }
            ((CheckedTextView) findViewById(R.id.xp_yl_btn_remote_Seat_auto_heating_check)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterNavi() {
        if (findViewById(R.id.xp_yl_btn_Auto_front_window_defogging_view) != null) {
            int enable = DataCanbus.DATA[60];
            if (enable == 0) {
                findViewById(R.id.xp_yl_btn_Auto_front_window_defogging_view).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.xp_yl_btn_Auto_front_window_defogging_view).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoFrontWindowDefogg() {
        if (((CheckedTextView) findViewById(R.id.xp_yl_btn_Auto_front_window_defogging_check)) != null) {
            int switchOn = DataCanbus.DATA[4];
            ((CheckedTextView) findViewById(R.id.xp_yl_btn_Auto_front_window_defogging_check)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRuning() {
        if (findViewById(R.id.xp_yl_air_Auto_rear_window_defogging_view) != null) {
            int enable = DataCanbus.DATA[61];
            if (enable == 0) {
                findViewById(R.id.xp_yl_air_Auto_rear_window_defogging_view).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.xp_yl_air_Auto_rear_window_defogging_view).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoRearWindowDefogg() {
        if (((CheckedTextView) findViewById(R.id.xp_yl_air_Auto_rear_window_defogging_check)) != null) {
            int switchOn = DataCanbus.DATA[3];
            ((CheckedTextView) findViewById(R.id.xp_yl_air_Auto_rear_window_defogging_check)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.xp_yl_air_Auto_rear_window_defogging_Tv)).setText(R.string.klc_air_Manual);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.xp_yl_air_Auto_rear_window_defogging_Tv)).setText(R.string.klc_air_auto);
            }
        }
    }
}
