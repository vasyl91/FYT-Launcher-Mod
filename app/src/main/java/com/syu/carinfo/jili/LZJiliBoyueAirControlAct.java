package com.syu.carinfo.jili;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZJiliBoyueAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.LZJiliBoyueAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    LZJiliBoyueAirControlAct.this.mUpdaterAirPower();
                    break;
                case 8:
                    LZJiliBoyueAirControlAct.this.mUpdaterAirAC();
                    break;
                case 9:
                    LZJiliBoyueAirControlAct.this.mUpdateAirCycle();
                    break;
                case 10:
                    LZJiliBoyueAirControlAct.this.mUpdaterAirACMAX();
                    break;
                case 11:
                    LZJiliBoyueAirControlAct.this.mUpdaterAuto();
                    break;
                case 12:
                    LZJiliBoyueAirControlAct.this.mUpdaterSync();
                    break;
                case 13:
                    LZJiliBoyueAirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 14:
                    LZJiliBoyueAirControlAct.this.mUpdateAirFrontDefrost(DataCanbus.DATA[updateCode]);
                    break;
                case 15:
                case 16:
                case 17:
                    LZJiliBoyueAirControlAct.this.UBlowMode();
                    break;
                case 18:
                    LZJiliBoyueAirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 19:
                    LZJiliBoyueAirControlAct.this.UTempLeft(DataCanbus.DATA[updateCode]);
                    break;
                case 20:
                    LZJiliBoyueAirControlAct.this.UTempRight(DataCanbus.DATA[updateCode]);
                    break;
                case 21:
                    if (((Button) LZJiliBoyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left)) != null) {
                        int i = R.drawable.ic_xts_seathot_left_level0;
                        if (value == 1) {
                            i = R.drawable.ic_xts_seathot_left_level1;
                        } else if (value == 2) {
                            i = R.drawable.ic_xts_seathot_left_level2;
                        } else if (value == 3) {
                            i = R.drawable.ic_xts_seathot_left_level3;
                        }
                        ((Button) LZJiliBoyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(i);
                        break;
                    }
                case 22:
                    if (((Button) LZJiliBoyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right)) != null) {
                        int i2 = R.drawable.ic_xts_seathot_right_level0;
                        if (value == 1) {
                            i2 = R.drawable.ic_xts_seathot_right_level1;
                        } else if (value == 2) {
                            i2 = R.drawable.ic_xts_seathot_right_level2;
                        } else if (value == 3) {
                            i2 = R.drawable.ic_xts_seathot_right_level3;
                        }
                        ((Button) LZJiliBoyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(i2);
                        break;
                    }
                case 23:
                    LZJiliBoyueAirControlAct.this.mUpdateAirION();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_jili_ruilan_air_control_set);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_cycle_outer).setOnTouchListener(this);
        findViewById(R.id.air_cycle_inter).setOnTouchListener(this);
        findViewById(R.id.air_xts_ion).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        int data4 = 0;
        int data5 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                int value = DataCanbus.DATA[19];
                if (value == -2) {
                    data4 = 2;
                    break;
                } else if (value == -3) {
                    data4 = 16;
                    break;
                } else {
                    data4 = value + 1;
                    break;
                }
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                int value2 = DataCanbus.DATA[19];
                if (value2 == -2) {
                    data4 = 1;
                    break;
                } else if (value2 == -3) {
                    data4 = 15;
                    break;
                } else {
                    data4 = value2 - 1;
                    break;
                }
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                int winlev = DataCanbus.DATA[18];
                if (winlev > 0) {
                    winlev--;
                }
                data2 = winlev | 128;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                int winlev2 = DataCanbus.DATA[18];
                if (winlev2 < 8) {
                    winlev2++;
                }
                data2 = winlev2 | 128;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                int value3 = DataCanbus.DATA[24] + 1;
                if (value3 > 5) {
                    value3 = 1;
                }
                data3 = value3;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 32;
                if (DataCanbus.DATA[11] == 0) {
                    data1 = 1;
                    break;
                } else {
                    data1 = 0;
                    break;
                }
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 128;
                if (DataCanbus.DATA[14] == 0) {
                    data1 = 1;
                    break;
                } else {
                    data1 = 0;
                    break;
                }
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 16;
                if (DataCanbus.DATA[8] == 0) {
                    data1 = 1;
                    break;
                } else {
                    data1 = 0;
                    break;
                }
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 8;
                if (DataCanbus.DATA[10] == 0) {
                    data1 = 1;
                    break;
                } else {
                    data1 = 0;
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                int value4 = DataCanbus.DATA[20];
                if (value4 == -2) {
                    data5 = 2;
                    break;
                } else if (value4 == -3) {
                    data5 = 16;
                    break;
                } else {
                    data5 = value4 + 1;
                    break;
                }
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                int value5 = DataCanbus.DATA[20];
                if (value5 == -2) {
                    data5 = 1;
                    break;
                } else if (value5 == -3) {
                    data5 = 15;
                    break;
                } else {
                    data5 = value5 - 1;
                    break;
                }
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 4;
                if (DataCanbus.DATA[12] == 0) {
                    data1 = 1;
                    break;
                } else {
                    data1 = 0;
                    break;
                }
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 1;
                if (DataCanbus.DATA[13] == 0) {
                    data1 = 1;
                    break;
                } else {
                    data1 = 0;
                    break;
                }
            case R.id.air_cycle_outer /* 2131427557 */:
                if (DataCanbus.DATA[9] == 1) {
                    data0 = 64;
                    data1 = 0;
                    break;
                }
            case R.id.air_cycle_inter /* 2131427558 */:
                if (DataCanbus.DATA[9] == 0) {
                    data0 = 64;
                    data1 = 1;
                    break;
                }
            case R.id.air_xts_ion /* 2131427559 */:
                data0 = 2;
                if (DataCanbus.DATA[23] == 0) {
                    data1 = 1;
                    break;
                } else {
                    data1 = 0;
                    break;
                }
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(2, new int[]{data0, data1, data2, data3, data4, data5, 0}, null, null);
            return false;
        }
        if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(2, new int[7], null, null);
            return false;
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UTempLeft(int data) {
        int data2;
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (data == -2) {
                str = "LOW";
            } else if (data == -3) {
                str = "HI";
            } else {
                if (data >= 32 && data <= 34) {
                    data2 = ((data - 32) * 5) + 160;
                } else {
                    data2 = (data * 5) + 170;
                }
                str = String.valueOf(data2 / 10) + "." + (data2 % 10) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UTempRight(int data) {
        int data2;
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (data == -2) {
                str = "LOW";
            } else if (data == -3) {
                str = "HI";
            } else {
                if (data >= 32 && data <= 34) {
                    data2 = ((data - 32) * 5) + 160;
                } else {
                    data2 = (data * 5) + 170;
                }
                str = String.valueOf(data2 / 10) + "." + (data2 % 10) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[18];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[9];
        if (((Button) findViewById(R.id.air_cycle_outer)) != null) {
            ((Button) findViewById(R.id.air_cycle_outer)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (((Button) findViewById(R.id.air_cycle_inter)) != null) {
            ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirION() {
        int value = DataCanbus.DATA[23];
        if (((Button) findViewById(R.id.air_xts_ion)) != null) {
            ((Button) findViewById(R.id.air_xts_ion)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ion_n : R.drawable.ic_xts_ion_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[8];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirACMAX() {
        int value = DataCanbus.DATA[10];
        if (((Button) findViewById(R.id.air_xts_maxac)) != null) {
            ((Button) findViewById(R.id.air_xts_maxac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFrontDefrost(int data) {
        int value = DataCanbus.DATA[14];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[13];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSync() {
        int value = DataCanbus.DATA[12];
        if (((Button) findViewById(R.id.air_xts_dual)) != null) {
            ((Button) findViewById(R.id.air_xts_dual)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAuto() {
        int value = DataCanbus.DATA[11];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[7];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UBlowMode() {
        int win = DataCanbus.DATA[15];
        int body = DataCanbus.DATA[17];
        int foot = DataCanbus.DATA[16];
        int mode = 0;
        if (foot == 1) {
            mode = 0 | 1;
        } else if (foot == 0) {
            mode = 0 & 254;
        }
        if (body == 1) {
            mode |= 2;
        } else if (body == 0) {
            mode &= 253;
        }
        if (win == 1) {
            mode |= 4;
        } else if (win == 0) {
            mode &= 251;
        }
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
        }
    }
}
