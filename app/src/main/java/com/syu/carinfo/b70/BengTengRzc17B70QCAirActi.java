package com.syu.carinfo.b70;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BengTengRzc17B70QCAirActi extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private Handler mHandler = new Handler(LauncherApplication.getInstance().getMainLooper());
    private Runnable mrun = new Runnable() { // from class: com.syu.carinfo.b70.BengTengRzc17B70QCAirActi.1
        @Override // java.lang.Runnable
        public void run() {
            DataCanbus.PROXY.cmd(2, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.b70.BengTengRzc17B70QCAirActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    BengTengRzc17B70QCAirActi.this.mUpdaterPower();
                    break;
                case 1:
                    BengTengRzc17B70QCAirActi.this.mUpdataUpAuto();
                    break;
                case 2:
                    BengTengRzc17B70QCAirActi.this.mUpdataRecycle();
                    break;
                case 3:
                    BengTengRzc17B70QCAirActi.this.mUpdataFrontDeforst();
                    break;
                case 4:
                    BengTengRzc17B70QCAirActi.this.mUpdataRearDeforst();
                    break;
                case 5:
                    BengTengRzc17B70QCAirActi.this.mUpdataAc();
                    break;
                case 6:
                    BengTengRzc17B70QCAirActi.this.mUpataTempLeft();
                    break;
                case 7:
                    BengTengRzc17B70QCAirActi.this.mUpataTempRight();
                    break;
                case 8:
                case 9:
                case 10:
                    BengTengRzc17B70QCAirActi.this.mUpdataWindType();
                    break;
                case 11:
                    BengTengRzc17B70QCAirActi.this.mUpdataWindLevel();
                    break;
                case 12:
                    BengTengRzc17B70QCAirActi.this.mUpdataLeftHeat();
                    break;
                case 13:
                    BengTengRzc17B70QCAirActi.this.mUpdataRightHeat();
                    break;
            }
        }
    };
    int cycle = 0;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        AirHelper.disableAirWindowLocal(true);
        setContentView(R.layout.layout_rzc_14b70_air_control);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.air_cycle_outer).setOnClickListener(this);
        findViewById(R.id.air_cycle_inter).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_rear).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnClickListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                DataCanbus.PROXY.cmd(2, 10);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                DataCanbus.PROXY.cmd(2, 11);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                DataCanbus.PROXY.cmd(2, 1);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                DataCanbus.PROXY.cmd(2, 9);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                DataCanbus.PROXY.cmd(2, 8);
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                DataCanbus.PROXY.cmd(2, 17);
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                DataCanbus.PROXY.cmd(2, 16);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                DataCanbus.PROXY.cmd(2, 18);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                DataCanbus.PROXY.cmd(2, 14);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                DataCanbus.PROXY.cmd(2, 2);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                DataCanbus.PROXY.cmd(2, 7);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                DataCanbus.PROXY.cmd(2, 6);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                DataCanbus.PROXY.cmd(2, 12);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                DataCanbus.PROXY.cmd(2, 13);
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                DataCanbus.PROXY.cmd(2, 19);
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                DataCanbus.PROXY.cmd(2, 20);
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                DataCanbus.PROXY.cmd(2, 15);
                break;
            case R.id.air_cycle_outer /* 2131427557 */:
                DataCanbus.PROXY.cmd(2, 4);
                break;
            case R.id.air_cycle_inter /* 2131427558 */:
                DataCanbus.PROXY.cmd(2, 3);
                break;
        }
        this.mHandler.postDelayed(this.mrun, 100L);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataLeftHeat() {
        int value = DataCanbus.DATA[12];
        if (((Button) findViewById(R.id.air_xts_seathot_left)) != null) {
            ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_seathot_left_level0 : R.drawable.ic_xts_seathot_left_level3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataRightHeat() {
        int value = DataCanbus.DATA[13];
        if (((Button) findViewById(R.id.air_xts_seathot_right)) != null) {
            ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_seathot_right_level0 : R.drawable.ic_xts_seathot_right_level3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataUpAuto() {
        int value = DataCanbus.DATA[1];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataFrontDeforst() {
        int value = DataCanbus.DATA[3];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataRearDeforst() {
        int value = DataCanbus.DATA[4];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpataTempLeft() {
        int temp = DataCanbus.DATA[6];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp / 10.0f) + "°C");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataWindType() {
        int wind = DataCanbus.DATA[8];
        int body = DataCanbus.DATA[9];
        int foot = DataCanbus.DATA[10];
        int mHeadFoot = 0;
        int mWindowFoot = 0;
        int mHead = 0;
        int mFoot = 0;
        if (body != 0 && foot != 0) {
            mHeadFoot = 1;
        } else if (wind != 0 && foot != 0) {
            mWindowFoot = 1;
        } else if (body != 0) {
            mHead = 1;
        } else if (foot != 0) {
            mFoot = 1;
        }
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null && ((Button) findViewById(R.id.air_xts_mode_footwin)) != null && ((Button) findViewById(R.id.air_xts_mode_foot)) != null && ((Button) findViewById(R.id.air_xts_mode_footbody)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(mHead == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(mHeadFoot == 0 ? R.drawable.ic_xts_mode_footbody_n : R.drawable.ic_xts_mode_footbody_p);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(mFoot == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(mWindowFoot == 0 ? R.drawable.ic_xts_mode_footwin_n : R.drawable.ic_xts_mode_footwin_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterPower() {
        int value = DataCanbus.DATA[0];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataRecycle() {
        int value = DataCanbus.DATA[2];
        this.cycle = value;
        if (((Button) findViewById(R.id.air_cycle_outer)) != null) {
            ((Button) findViewById(R.id.air_cycle_outer)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (((Button) findViewById(R.id.air_cycle_inter)) != null) {
            ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataAc() {
        int value = DataCanbus.DATA[5];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataWindLevel() {
        int value = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpataTempRight() {
        int temp = DataCanbus.DATA[7];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp / 10.0f) + "°C");
            }
        }
    }
}
