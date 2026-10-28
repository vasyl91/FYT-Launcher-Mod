package com.syu.carinfo.bg.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class Bg_ZiYouGuangAirControlAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private final View.OnTouchListener touchSeat = new View.OnTouchListener() { 
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
        
            return false;
         */
        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
            /*
                r5 = this;
                r2 = 1
                r1 = 2
                r4 = 0
                r3 = 0
                int r0 = r6.getId()
                switch(r0) {
                    case 2131427433: goto Lc;
                    case 2131427434: goto Lb;
                    case 2131427435: goto L2f;
                    default: goto Lb;
                }
            Lb:
                return r4
            Lc:
                int r0 = r7.getAction()
                if (r0 != 0) goto L1d
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r1]
                r1 = {x005c: FILL_ARRAY_DATA , data: [48, 1} // fill-array
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            L1d:
                int r0 = r7.getAction()
                if (r0 != r2) goto Lb
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r1]
                r2 = 48
                r1[r4] = r2
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            L2f:
                int r0 = r7.getAction()
                if (r0 != 0) goto L40
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r1]
                r1 = {x0064: FILL_ARRAY_DATA , data: [50, 1} // fill-array
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            L40:
                int r0 = r7.getAction()
                if (r0 != r2) goto Lb
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r1]
                r2 = 50
                r1[r4] = r2
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            */
            throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouGuangAirControlAct.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    };
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirAuto();
                    break;
                case 16:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirBlowMode();
                    break;
                case 21:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 29:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirSeatHeatLeft();
                    break;
                case 30:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirSeatHeatRight();
                    break;
                case 37:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempRight();
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 53:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirGoFog();
                    break;
                case 62:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirSYNC();
                    break;
                case 65:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 66:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirSteerHot();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_371_jeep_carairset);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this.touchSeat);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_steer_hot).setOnClickListener(this);
        findViewById(R.id.air_xts_sync).setOnClickListener(this);
        findViewById(R.id.air_xts_cycle).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this.touchSeat);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.air_xts_rear).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_maxac).setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                int temp = DataCanbus.DATA[27];
                int unit = DataCanbus.DATA[37];
                if ((temp >= 13 && temp < 30) || (temp >= 60 && temp < 84)) {
                    temp++;
                } else if (temp == 30 || temp == 84) {
                    temp = 127;
                } else if (temp == -2 && unit == 1) {
                    temp = 14;
                } else if (temp == -2 && unit == 0) {
                    temp = 60;
                }
                DataCanbus.PROXY.cmd(0, new int[]{34, temp}, null, null);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                int temp2 = DataCanbus.DATA[27];
                int unit2 = DataCanbus.DATA[37];
                if ((temp2 > 13 && temp2 <= 30) || (temp2 > 60 && temp2 <= 84)) {
                    temp2--;
                } else if (temp2 == 13 || temp2 == 60) {
                    temp2 = 0;
                } else if (temp2 == -3 && unit2 == 1) {
                    temp2 = 30;
                } else if (temp2 == -3 && unit2 == 0) {
                    temp2 = 84;
                }
                DataCanbus.PROXY.cmd(0, new int[]{34, temp2}, null, null);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                DataCanbus.PROXY.cmd(0, new int[]{16, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{16}, null, null);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                DataCanbus.PROXY.cmd(0, new int[]{28, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{28}, null, null);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                DataCanbus.PROXY.cmd(0, new int[]{29, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{29}, null, null);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                DataCanbus.PROXY.cmd(0, new int[]{20, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{20}, null, null);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                DataCanbus.PROXY.cmd(0, new int[]{19, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{19}, null, null);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                DataCanbus.PROXY.cmd(0, new int[]{21, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{21}, null, null);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                DataCanbus.PROXY.cmd(0, new int[]{17, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{17}, null, null);
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                DataCanbus.PROXY.cmd(0, new int[]{18, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{18}, null, null);
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                DataCanbus.PROXY.cmd(0, new int[]{23, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{23}, null, null);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                DataCanbus.PROXY.cmd(0, new int[]{26, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{26}, null, null);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                DataCanbus.PROXY.cmd(0, new int[]{24, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{24}, null, null);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                int temp3 = DataCanbus.DATA[28];
                int unit3 = DataCanbus.DATA[37];
                if ((temp3 >= 13 && temp3 < 30) || (temp3 >= 60 && temp3 < 84)) {
                    temp3++;
                } else if (temp3 == 30 || temp3 == 84) {
                    temp3 = 127;
                } else if (temp3 == -2 && unit3 == 1) {
                    temp3 = 14;
                } else if (temp3 == -2 && unit3 == 0) {
                    temp3 = 60;
                }
                DataCanbus.PROXY.cmd(0, new int[]{35, temp3}, null, null);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                int temp4 = DataCanbus.DATA[28];
                int unit4 = DataCanbus.DATA[37];
                if ((temp4 > 13 && temp4 <= 30) || (temp4 > 60 && temp4 <= 84)) {
                    temp4--;
                } else if (temp4 == 13 || temp4 == 60) {
                    temp4 = 0;
                } else if (temp4 == -3 && unit4 == 1) {
                    temp4 = 30;
                } else if (temp4 == -3 && unit4 == 0) {
                    temp4 = 84;
                }
                DataCanbus.PROXY.cmd(0, new int[]{35, temp4}, null, null);
                break;
            case R.id.air_xts_steer_hot /* 2131427453 */:
                DataCanbus.PROXY.cmd(0, new int[]{52, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{52}, null, null);
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                DataCanbus.PROXY.cmd(0, new int[]{25, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{25}, null, null);
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                DataCanbus.PROXY.cmd(0, new int[]{22, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{22}, null, null);
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                DataCanbus.PROXY.cmd(0, new int[]{27, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{27}, null, null);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
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
                default:
                    if (unit == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℃");
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
                default:
                    if (unit == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℃");
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

    
    public void mUpdateAirGoFog() {
        int value = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAirSteerHot() {
        int value = DataCanbus.DATA[66];
        findViewById(R.id.air_xts_steer_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
    }

    
    public void mUpdateAirSYNC() {
        int value = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_sync).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        findViewById(R.id.air_xts_cycle).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdateAirBlowMode() {
        int up = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        if (up == 1 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
            return;
        }
        if (up == 0 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
            return;
        }
        if (up == 0 && body == 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
        } else if (up == 0 && body == 1 && foot == 0) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdaterAirSeatHeatLeft() {
        int value = DataCanbus.DATA[29];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                break;
            case 2:
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                break;
        }
    }

    
    public void mUpdaterAirSeatHeatRight() {
        int value = DataCanbus.DATA[30];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                break;
            case 2:
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }
}
