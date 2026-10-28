package com.syu.carinfo.dj.huangguan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZ_0439_Toyota_AirControlAct extends Activity implements View.OnTouchListener {
    public static LZ_0439_Toyota_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirAuto();
                    break;
                case 14:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirdual();
                    break;
                case 15:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 16:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 17:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirCleanIce();
                    break;
                case 21:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 35:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirCleanSwing();
                    break;
                case 37:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirTempLeft();
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 58:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirCleanFlower();
                    break;
                case 67:
                    LZ_0439_Toyota_AirControlAct.this.findViewById(R.id.air_xts_rear_light).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_light_n : R.drawable.ic_xts_rear_light_p);
                    break;
                case 76:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirClean();
                    break;
                case 77:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirBlow();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
                //setContentView(R.layout.layout_0439_luz_toyota_cruiser_carairset);
                break;
            default:
                //setContentView(R.layout.layout_0439_luz_toyota_carairset);
                break;
        }
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_clear).setOnTouchListener(this);
        findViewById(R.id.air_xts_ion).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_blow_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear_light).setOnTouchListener(this);
        if (LauncherApplication.getConfiguration() == 1) {
            findViewById(R.id.air_xts_mode_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rearpage) != null) {
            findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        return false;
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            r9 = 22
            r8 = 2
            r7 = 1
            r6 = 0
            r5 = 0
            int r2 = r11.getId()
            r0 = 0
            switch(r2) {
                case 2131427425: goto L18;
                case 2131427427: goto L1a;
                case 2131427428: goto L16;
                case 2131427429: goto L20;
                case 2131427431: goto L23;
                case 2131427434: goto L44;
                case 2131427436: goto L2f;
                case 2131427437: goto L32;
                case 2131427438: goto L29;
                case 2131427439: goto L35;
                case 2131427448: goto L4a;
                case 2131427449: goto L1c;
                case 2131427451: goto L1e;
                case 2131427560: goto L2c;
                case 2131427566: goto L26;
                case 2131427569: goto L3b;
                case 2131427570: goto L3e;
                case 2131427571: goto L38;
                case 2131427572: goto L41;
                case 2131427573: goto L47;
                case 2131428283: goto L44;
                default: goto Le;
            }
        Le:
            int r3 = r12.getAction()
            switch(r3) {
                case 0: goto L5a;
                case 1: goto L66;
                default: goto L15;
            }
        L15:
            return r6
        L16:
            r0 = 1
            goto Le
        L18:
            r0 = 3
            goto Le
        L1a:
            r0 = 2
            goto Le
        L1c:
            r0 = 5
            goto Le
        L1e:
            r0 = 4
            goto Le
        L20:
            r0 = 9
            goto Le
        L23:
            r0 = 10
            goto Le
        L26:
            r0 = 16
            goto Le
        L29:
            r0 = 18
            goto Le
        L2c:
            r0 = 20
            goto Le
        L2f:
            r0 = 21
            goto Le
        L32:
            r0 = 25
            goto Le
        L35:
            r0 = 23
            goto Le
        L38:
            r0 = 26
            goto Le
        L3b:
            r0 = 32
            goto Le
        L3e:
            r0 = 28
            goto Le
        L41:
            r0 = 29
            goto Le
        L44:
            r0 = 36
            goto Le
        L47:
            r0 = 42
            goto Le
        L4a:
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Exception -> L55
            java.lang.Class<com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_RearAirControlAct> r4 = com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_RearAirControlAct.class
            r3.<init>(r10, r4)     // Catch: java.lang.Exception -> L55
            r10.startActivity(r3)     // Catch: java.lang.Exception -> L55
            goto Le
        L55:
            r1 = move-exception
            r1.printStackTrace()
            goto Le
        L5a:
            com.syu.ipc.RemoteModuleProxy r3 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r4 = new int[r8]
            r4[r6] = r0
            r4[r7] = r7
            r3.cmd(r9, r4, r5, r5)
            goto L15
        L66:
            com.syu.ipc.RemoteModuleProxy r3 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r4 = new int[r8]
            r4[r6] = r0
            r3.cmd(r9, r4, r5, r5)
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_AirControlAct.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirClean() {
        int value = DataCanbus.DATA[76];
        findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
    }

    
    public void mUpdaterAirCleanFlower() {
        int value = DataCanbus.DATA[58];
        findViewById(R.id.air_xts_ion).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ion_n : R.drawable.ic_xts_ion_p);
    }

    
    public void mUpdaterAirCleanIce() {
        int value = DataCanbus.DATA[17];
        findViewById(R.id.air_xts_front_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
    }

    
    public void mUpdaterAirCleanSwing() {
        int value = DataCanbus.DATA[35];
        findViewById(R.id.air_xts_front_blow_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_blow_auto_n : R.drawable.ic_xts_blow_auto_p);
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[37];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("--");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(level));
        }
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAirdual() {
        int value = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        if (value == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (value == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdateAirBlow() {
        int value = DataCanbus.DATA[77];
        if (LauncherApplication.getConfiguration() == 1) {
            if (value == 3) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
            } else if (value == 5) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
            } else if (value == 2) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_body);
            } else if (value == 1) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot);
            } else if (value == 4) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_win);
            } else {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_null);
            }
            if (value == 3) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_body);
                return;
            }
            if (value == 5) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_win);
                return;
            }
            if (value == 2) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body);
                return;
            }
            if (value == 1) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot);
                return;
            } else if (value == 4) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_win);
                return;
            } else {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                return;
            }
        }
        if (value == 3) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
            return;
        }
        if (value == 5) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
            return;
        }
        if (value == 2) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
            return;
        }
        if (value == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
        } else if (value == 4) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
        } else {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
        }
    }
}
