package com.syu.carinfo.dj.huangguan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCLexusRearAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.XCLexusRearAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 17:
                    XCLexusRearAirControlAct.this.mUpdateRearLockOn();
                    break;
                case 30:
                case 31:
                case 32:
                    XCLexusRearAirControlAct.this.mUpdateManual();
                    break;
                case 33:
                    XCLexusRearAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 80:
                    XCLexusRearAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 82:
                case 83:
                    XCLexusRearAirControlAct.this.updateBtnSource();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
    }

    private void sendRearCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(6, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0429_xc_toyota_lexus_air_rear_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_frontpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_manual).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        int flag = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 67;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 68;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 66;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                flag = 1;
                data0 = 70;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                flag = 1;
                data0 = 69;
                break;
            case R.id.air_xts_frontpage /* 2131427432 */:
                flag = 2;
                try {
                    startActivity(new Intent(this, (Class<?>) XC_429_Lexus_AirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                flag = 1;
                data0 = 65;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                flag = 1;
                data0 = 74;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                flag = 1;
                data0 = 72;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                flag = 1;
                data0 = 64;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                flag = 1;
                data0 = 73;
                break;
            case R.id.air_xts_manual /* 2131427562 */:
                data0 = 64;
                break;
        }
        if (flag == 0) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        } else if (flag == 1) {
            if (event.getAction() == 0) {
                sendRearCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendRearCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearLockOn() {
        int power = DataCanbus.DATA[17];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(power == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[33];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0f) + "℃");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 2.0f) + "℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[80];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 7) {
            leave = 7;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
        findViewById(R.id.air_xts_power).setBackgroundResource(leave == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource() {
        int foot = DataCanbus.DATA[83];
        int body = DataCanbus.DATA[82];
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
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateManual() {
        int ac = DataCanbus.DATA[30];
        int lo = DataCanbus.DATA[31];
        int hi = DataCanbus.DATA[32];
        int mode = 0;
        if (hi == 1) {
            mode = 0 | 1;
        } else if (hi == 0) {
            mode = 0 & 254;
        }
        if (ac == 1) {
            mode |= 2;
        } else if (ac == 0) {
            mode &= 253;
        }
        if (lo == 1) {
            mode |= 4;
        } else if (lo == 0) {
            mode &= 251;
        }
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_0);
                break;
            case 1:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_1);
                break;
            case 2:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_2);
                break;
            case 3:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_3);
                break;
            case 4:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_4);
                break;
            case 5:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_5);
                break;
            case 6:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_6);
                break;
            case 7:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_7);
                break;
        }
    }
}
