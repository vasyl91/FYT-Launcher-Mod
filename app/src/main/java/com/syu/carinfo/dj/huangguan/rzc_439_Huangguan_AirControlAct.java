package com.syu.carinfo.dj.huangguan;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class rzc_439_Huangguan_AirControlAct extends Activity implements View.OnTouchListener {
    public static rzc_439_Huangguan_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    rzc_439_Huangguan_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    rzc_439_Huangguan_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    rzc_439_Huangguan_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    rzc_439_Huangguan_AirControlAct.this.mUpdateAirAuto();
                    break;
                case 14:
                    rzc_439_Huangguan_AirControlAct.this.mUpdateAirdual();
                    break;
                case 16:
                    rzc_439_Huangguan_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 17:
                    rzc_439_Huangguan_AirControlAct.this.mUpdaterAirCleanIce();
                    break;
                case 21:
                    rzc_439_Huangguan_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    rzc_439_Huangguan_AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    rzc_439_Huangguan_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 33:
                    rzc_439_Huangguan_AirControlAct.this.mUpdaterAirCleanFlower();
                    break;
                case 35:
                    rzc_439_Huangguan_AirControlAct.this.mUpdaterAirCleanSwing();
                    break;
                case 65:
                    rzc_439_Huangguan_AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 76:
                    rzc_439_Huangguan_AirControlAct.this.mUpdaterAirClean();
                    break;
                case 77:
                    rzc_439_Huangguan_AirControlAct.this.mUpdateAirBlow();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_toyota_crown_carairset);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_cycle_outer).setOnTouchListener(this);
        findViewById(R.id.air_cycle_inter).setOnTouchListener(this);
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
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
    
        return false;
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
        /*
            r13 = this;
            r12 = 5
            r8 = 1
            r11 = 0
            r10 = 3
            r9 = 0
            int r5 = r14.getId()
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            switch(r5) {
                case 2131427425: goto L38;
                case 2131427427: goto L3a;
                case 2131427428: goto L33;
                case 2131427429: goto L45;
                case 2131427431: goto L47;
                case 2131427434: goto L55;
                case 2131427436: goto L19;
                case 2131427438: goto L40;
                case 2131427439: goto L36;
                case 2131427449: goto L3c;
                case 2131427451: goto L3e;
                case 2131427560: goto L43;
                case 2131427566: goto L1c;
                case 2131427569: goto L4c;
                case 2131427570: goto L4f;
                case 2131427571: goto L49;
                case 2131427572: goto L52;
                case 2131428106: goto L1f;
                case 2131428107: goto L29;
                default: goto L11;
            }
        L11:
            int r6 = r15.getAction()
            switch(r6) {
                case 0: goto L58;
                case 1: goto L6c;
                default: goto L18;
            }
        L18:
            return r11
        L19:
            r0 = 32
            goto L11
        L1c:
            r1 = 8
            goto L11
        L1f:
            int[] r6 = com.syu.module.canbus.DataCanbus.DATA
            r7 = 12
            r6 = r6[r7]
            if (r6 != r8) goto L11
            r2 = 1
            goto L11
        L29:
            int[] r6 = com.syu.module.canbus.DataCanbus.DATA
            r7 = 12
            r6 = r6[r7]
            if (r6 != 0) goto L11
            r2 = 1
            goto L11
        L33:
            r0 = 128(0x80, float:1.8E-43)
            goto L11
        L36:
            r0 = 2
            goto L11
        L38:
            r3 = 2
            goto L11
        L3a:
            r3 = 1
            goto L11
        L3c:
            r4 = 2
            goto L11
        L3e:
            r4 = 1
            goto L11
        L40:
            r0 = 16
            goto L11
        L43:
            r1 = 4
            goto L11
        L45:
            r1 = 1
            goto L11
        L47:
            r1 = 2
            goto L11
        L49:
            r1 = 16
            goto L11
        L4c:
            r1 = 32
            goto L11
        L4f:
            r1 = 128(0x80, float:1.8E-43)
            goto L11
        L52:
            r1 = 64
            goto L11
        L55:
            r0 = 64
            goto L11
        L58:
            com.syu.ipc.RemoteModuleProxy r6 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r7 = new int[r12]
            r7[r11] = r0
            r7[r8] = r1
            r8 = 2
            r7[r8] = r2
            r7[r10] = r3
            r8 = 4
            r7[r8] = r4
            r6.cmd(r10, r7, r9, r9)
            goto L18
        L6c:
            com.syu.ipc.RemoteModuleProxy r6 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r7 = new int[r12]
            r6.cmd(r10, r7, r9, r9)
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.dj.huangguan.rzc_439_Huangguan_AirControlAct.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirClean() {
        int value = DataCanbus.DATA[76];
        findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
    }

    
    public void mUpdaterAirCleanFlower() {
        int value = DataCanbus.DATA[33];
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
        int unit = SystemProperties.getInt("persist.fyt.temperature", 0);
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
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10) + "℉");
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
        int unit = SystemProperties.getInt("persist.fyt.temperature", 0);
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
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10) + "℉");
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
        if (findViewById(R.id.air_cycle_outer) != null) {
            findViewById(R.id.air_cycle_outer).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (findViewById(R.id.air_cycle_inter) != null) {
            findViewById(R.id.air_cycle_inter).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
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
        int value = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdateAirBlow() {
        int value = DataCanbus.DATA[77];
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
