package com.syu.carinfo.xbs.tule;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBS_TuleDZSJ_AirControlActi extends Activity implements View.OnTouchListener {
    public static XBS_TuleDZSJ_AirControlActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tule.XBS_TuleDZSJ_AirControlActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateAirTempLeft();
                    break;
                case 9:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateAirTempRight();
                    break;
                case 10:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdaterAirWindLevelLeft();
                    break;
                case 11:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdaterBlowWindow();
                    break;
                case 12:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 13:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdaterBlowFootLeftOn();
                    break;
                case 15:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateAutoOn();
                    break;
                case 16:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateACOn();
                    break;
                case 17:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateSyncOn();
                    break;
                case 18:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateCycle();
                    break;
                case 20:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateRearDefrost();
                    break;
                case 21:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateMaxfront();
                    break;
                case 22:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateRearCtrl();
                    break;
                case 23:
                    XBS_TuleDZSJ_AirControlActi.this.mUpdateFrontDefrost();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        mInstance = this;
        setContentView(R.layout.layout_0439_xbs_tuiledzsj_air_control);
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
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[23];
        if (front == 1) {
            ((ImageView) findViewById(R.id.image_air_winmode_up)).setBackgroundResource(R.drawable.air_tule_dzsj_airmode_up);
        } else {
            ((ImageView) findViewById(R.id.image_air_winmode_up)).setBackgroundResource(R.drawable.air_tule_dzsj_airmode_up_null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyLeftOn() {
        int body = DataCanbus.DATA[12];
        if (body == 1) {
            ((ImageView) findViewById(R.id.image_air_winmode_body)).setBackgroundResource(R.drawable.air_tule_dzsj_airmode_body);
        } else {
            ((ImageView) findViewById(R.id.image_air_winmode_body)).setBackgroundResource(R.drawable.air_tule_dzsj_airmode_body_null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootLeftOn() {
        int foot = DataCanbus.DATA[13];
        if (foot == 1) {
            ((ImageView) findViewById(R.id.image_air_winmode_foot)).setBackgroundResource(R.drawable.air_tule_dzsj_airmode_foot);
        } else {
            ((ImageView) findViewById(R.id.image_air_winmode_foot)).setBackgroundResource(R.drawable.air_tule_dzsj_airmode_foot_null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowWindow() {
        int window = DataCanbus.DATA[11];
        if (window == 1) {
            ((ImageView) findViewById(R.id.image_air_winmode_win)).setBackgroundResource(R.drawable.air_tule_dzsj_airmode_win);
        } else {
            ((ImageView) findViewById(R.id.image_air_winmode_win)).setBackgroundResource(R.drawable.air_tule_dzsj_airmode_win_null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[8];
        if (((TextView) findViewById(R.id.xbs_tule_temp_left_tv)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.xbs_tule_temp_left_tv)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.xbs_tule_temp_left_tv)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.xbs_tule_temp_left_tv)).setText((temp * 5 * 0.1f) + " °C");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[9];
        if (((TextView) findViewById(R.id.xbs_tule_temp_right_tv)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.xbs_tule_temp_right_tv)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.xbs_tule_temp_right_tv)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.xbs_tule_temp_right_tv)).setText((temp * 5 * 0.1f) + " °C");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[10];
        switch (leave) {
            case 1:
                ((ImageView) findViewById(R.id.image_air_winvol)).setBackgroundResource(R.drawable.air_tule_dzsj_airvol_1);
                break;
            case 2:
                ((ImageView) findViewById(R.id.image_air_winvol)).setBackgroundResource(R.drawable.air_tule_dzsj_airvol_2);
                break;
            case 3:
                ((ImageView) findViewById(R.id.image_air_winvol)).setBackgroundResource(R.drawable.air_tule_dzsj_airvol_3);
                break;
            case 4:
                ((ImageView) findViewById(R.id.image_air_winvol)).setBackgroundResource(R.drawable.air_tule_dzsj_airvol_4);
                break;
            case 5:
                ((ImageView) findViewById(R.id.image_air_winvol)).setBackgroundResource(R.drawable.air_tule_dzsj_airvol_5);
                break;
            case 6:
                ((ImageView) findViewById(R.id.image_air_winvol)).setBackgroundResource(R.drawable.air_tule_dzsj_airvol_6);
                break;
            case 7:
                ((ImageView) findViewById(R.id.image_air_winvol)).setBackgroundResource(R.drawable.air_tule_dzsj_airvol_7);
                break;
            default:
                ((ImageView) findViewById(R.id.image_air_winvol)).setBackgroundResource(R.drawable.air_tule_dzsj_airvol_0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMaxfront() {
        int maxfront = DataCanbus.DATA[21];
        if (maxfront == 1) {
            ((ImageView) findViewById(R.id.image_air_maxfront)).setBackgroundResource(R.drawable.air_tule_dzsj_maxfront_p);
        } else {
            ((ImageView) findViewById(R.id.image_air_maxfront)).setBackgroundResource(R.drawable.air_tule_dzsj_maxfront_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[20];
        if (rear == 1) {
            ((ImageView) findViewById(R.id.image_air_rear)).setBackgroundResource(R.drawable.air_tule_dzsj_rear_p);
        } else {
            ((ImageView) findViewById(R.id.image_air_rear)).setBackgroundResource(R.drawable.air_tule_dzsj_rear_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateACOn() {
        int acon = DataCanbus.DATA[16];
        if (acon == 1) {
            ((ImageView) findViewById(R.id.image_air_ac)).setBackgroundResource(R.drawable.air_tule_dzsj_ac_p);
        } else {
            ((ImageView) findViewById(R.id.image_air_ac)).setBackgroundResource(R.drawable.air_tule_dzsj_ac_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearCtrl() {
        int acon = DataCanbus.DATA[22];
        if (acon == 1) {
            ((ImageView) findViewById(R.id.image_air_rearctrl)).setBackgroundResource(R.drawable.air_tule_dzsj_rearctrl_p);
        } else {
            ((ImageView) findViewById(R.id.image_air_rearctrl)).setBackgroundResource(R.drawable.air_tule_dzsj_rearctrl_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSyncOn() {
        int dual = DataCanbus.DATA[17];
        if (dual == 1) {
            ((ImageView) findViewById(R.id.image_air_dual)).setBackgroundResource(R.drawable.air_tule_dzsj_dual_p);
        } else {
            ((ImageView) findViewById(R.id.image_air_dual)).setBackgroundResource(R.drawable.air_tule_dzsj_dual_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int auto = DataCanbus.DATA[15];
        if (auto == 1) {
            ((ImageView) findViewById(R.id.image_air_auto)).setBackgroundResource(R.drawable.air_tule_dzsj_auto_p);
        } else {
            ((ImageView) findViewById(R.id.image_air_auto)).setBackgroundResource(R.drawable.air_tule_dzsj_auto_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[18];
        if (cycle == 1) {
            ((ImageView) findViewById(R.id.image_air_cycle)).setBackgroundResource(R.drawable.air_tule_dzsj_cycle_p);
        } else {
            ((ImageView) findViewById(R.id.image_air_cycle)).setBackgroundResource(R.drawable.air_tule_dzsj_cycle_n);
        }
    }
}