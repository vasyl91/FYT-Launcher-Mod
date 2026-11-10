package com.syu.carinfo.dj.huangguan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class rzc_112_Toyota_AirRearControlAct extends Activity implements View.OnTouchListener {
    public static rzc_112_Toyota_AirRearControlAct mInstance;
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 60:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirPower();
                    break;
                case 61:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirAC();
                    break;
                case 62:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdateAirCycle();
                    break;
                case 63:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdateAirAuto();
                    break;
                case 65:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdateAirdual();
                    break;
                case 70:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 71:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 72:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirTempRight();
                    break;
                case 152:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 163:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirClean();
                    break;
                case 164:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirCleanFlower();
                    break;
                case 165:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirCleanIce();
                    break;
                case 166:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirCleanSwing();
                    break;
                case 167:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdateAirBlow();
                    break;
                case 169:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 179:
                    if (rzc_112_Toyota_AirRearControlAct.this.findViewById(R.id.air_xts_rear_light) != null) {
                        rzc_112_Toyota_AirRearControlAct.this.findViewById(R.id.air_xts_rear_light).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_light_n : R.drawable.ic_xts_rear_light_p);
                        break;
                    }
                case 180:
                    if (rzc_112_Toyota_AirRearControlAct.this.findViewById(R.id.air_xts_econ) != null) {
                        rzc_112_Toyota_AirRearControlAct.this.findViewById(R.id.air_xts_econ).setBackgroundResource(value == 0 ? R.drawable.ic_xts_econ_n : R.drawable.ic_xts_econ_p);
                        break;
                    }
                case 181:
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirTempLeft();
                    rzc_112_Toyota_AirRearControlAct.this.mUpdaterAirTempRight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0112_rzc_xc_huangguan14_rear_carairset);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
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
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
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
            r12 = 41
            r11 = 5
            r8 = 1
            r10 = 0
            r9 = 0
            int r5 = r14.getId()
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            switch(r5) {
                case 2131427425: goto L3b;
                case 2131427427: goto L3d;
                case 2131427428: goto L36;
                case 2131427429: goto L48;
                case 2131427431: goto L4a;
                case 2131427434: goto L58;
                case 2131427436: goto L1a;
                case 2131427437: goto L20;
                case 2131427438: goto L43;
                case 2131427439: goto L39;
                case 2131427449: goto L3f;
                case 2131427451: goto L41;
                case 2131427460: goto L1d;
                case 2131427465: goto L4f;
                case 2131427466: goto L4c;
                case 2131427534: goto L46;
                case 2131427557: goto L22;
                case 2131427558: goto L2c;
                case 2131427559: goto L52;
                case 2131427560: goto L55;
                case 2131427561: goto L5b;
                case 2131427563: goto L5d;
                default: goto L12;
            }
        L12:
            int r6 = r15.getAction()
            switch(r6) {
                case 0: goto L60;
                case 1: goto L75;
                default: goto L19;
            }
        L19:
            return r10
        L1a:
            r0 = 32
            goto L12
        L1d:
            r1 = 8
            goto L12
        L20:
            r2 = 1
            goto L12
        L22:
            int[] r6 = com.syu.module.canbus.DataCanbus.DATA
            r7 = 62
            r6 = r6[r7]
            if (r6 != r8) goto L12
            r2 = 1
            goto L12
        L2c:
            int[] r6 = com.syu.module.canbus.DataCanbus.DATA
            r7 = 62
            r6 = r6[r7]
            if (r6 != 0) goto L12
            r2 = 1
            goto L12
        L36:
            r0 = 128(0x80, float:1.8E-43)
            goto L12
        L39:
            r0 = 2
            goto L12
        L3b:
            r3 = 2
            goto L12
        L3d:
            r3 = 1
            goto L12
        L3f:
            r4 = 2
            goto L12
        L41:
            r4 = 1
            goto L12
        L43:
            r0 = 16
            goto L12
        L46:
            r1 = 4
            goto L12
        L48:
            r1 = 1
            goto L12
        L4a:
            r1 = 2
            goto L12
        L4c:
            r1 = 16
            goto L12
        L4f:
            r1 = 32
            goto L12
        L52:
            r1 = 128(0x80, float:1.8E-43)
            goto L12
        L55:
            r1 = 64
            goto L12
        L58:
            r0 = 64
            goto L12
        L5b:
            r4 = 4
            goto L12
        L5d:
            r4 = 8
            goto L12
        L60:
            com.syu.ipc.RemoteModuleProxy r6 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r7 = new int[r11]
            r7[r10] = r0
            r7[r8] = r1
            r8 = 2
            r7[r8] = r2
            r8 = 3
            r7[r8] = r3
            r8 = 4
            r7[r8] = r4
            r6.cmd(r12, r7, r9, r9)
            goto L19
        L75:
            com.syu.ipc.RemoteModuleProxy r6 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r7 = new int[r11]
            r6.cmd(r12, r7, r9, r9)
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.dj.huangguan.rzc_112_Toyota_AirRearControlAct.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirClean() {
        int value = DataCanbus.DATA[163];
        if (findViewById(R.id.air_xts_clear) != null) {
            findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
        }
    }

    
    public void mUpdaterAirCleanFlower() {
        int value = DataCanbus.DATA[164];
        if (findViewById(R.id.air_xts_ion) != null) {
            findViewById(R.id.air_xts_ion).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ion_n : R.drawable.ic_xts_ion_p);
        }
    }

    
    public void mUpdaterAirCleanIce() {
        int value = DataCanbus.DATA[165];
        if (findViewById(R.id.air_xts_front_hot) != null) {
            findViewById(R.id.air_xts_front_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
        }
    }

    
    public void mUpdaterAirCleanSwing() {
        int value = DataCanbus.DATA[166];
        if (findViewById(R.id.air_xts_front_blow_auto) != null) {
            findViewById(R.id.air_xts_front_blow_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_blow_auto_n : R.drawable.ic_xts_blow_auto_p);
        }
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[71];
        int unit = DataCanbus.DATA[181];
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
        int temp = DataCanbus.DATA[72];
        int unit = DataCanbus.DATA[181];
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
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "°C");
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[70];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(level));
        }
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[63];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdateAirdual() {
        int value = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    
    public void mUpdateAirCycle() {
        int i = R.drawable.ic_xts_cycle_n;
        int value = DataCanbus.DATA[62];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (value == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            } else if (value == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
            }
        }
        if (findViewById(R.id.air_cycle_outer) != null) {
            Button button = findViewById(R.id.air_cycle_outer);
            if (value == 0) {
                i = R.drawable.ic_xts_cycle_out_p;
            }
            button.setBackgroundResource(i);
        }
        if (findViewById(R.id.air_cycle_inter) != null) {
            findViewById(R.id.air_cycle_inter).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[61];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[60];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[169];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[152];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdateAirBlow() {
        int value = DataCanbus.DATA[167];
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
