package com.syu.carinfo.huiteng;

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
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Huiteng_AirRearCtrl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { // from class: com.syu.carinfo.huiteng.Huiteng_AirRearCtrl.1
        @Override // java.lang.Runnable
        public void run() {
            Huiteng_AirRearCtrl.this.setAirControl(Huiteng_AirRearCtrl.this.cmdId, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.huiteng.Huiteng_AirRearCtrl.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    Huiteng_AirRearCtrl.this.mUpdaterAirAutoRight();
                    break;
                case 30:
                    Huiteng_AirRearCtrl.this.mUpdaterAirAutoLeft();
                    break;
                case 31:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowUpRight();
                    break;
                case 32:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowBodyRight();
                    break;
                case 33:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowFootRight();
                    break;
                case 34:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowUpLeft();
                    break;
                case 35:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowBodyLeft();
                    break;
                case 36:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowFootLeft();
                    break;
                case 37:
                    Huiteng_AirRearCtrl.this.mUpdaterAirPower();
                    break;
                case 38:
                    Huiteng_AirRearCtrl.this.mUpdaterAirTempLeft();
                    break;
                case 39:
                    Huiteng_AirRearCtrl.this.mUpdaterAirTempRight();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_439_huiteng_rearair_dj_control);
        init();
    }

    private void init() {
        ((Button) findViewById(R.id.huiteng_rearair_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_autoleft)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_autoright)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_templeft_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_templeft_munits_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_tempright_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_tempright_munits_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_foot_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_foot_right)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_body_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_body_right)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_win_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_win_right)).setOnTouchListener(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setAirControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(4, cmdId, touchState);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.huiteng_rearair_power /* 2131430108 */:
                this.cmdId = 13;
                break;
            case R.id.huiteng_rearair_templeft_plus_btn /* 2131430109 */:
                this.cmdId = 3;
                break;
            case R.id.huiteng_rearair_templeft_munits_btn /* 2131430111 */:
                this.cmdId = 4;
                break;
            case R.id.huiteng_rearair_win_left /* 2131430112 */:
                this.cmdId = 7;
                break;
            case R.id.huiteng_rearair_win_right /* 2131430113 */:
                this.cmdId = 10;
                break;
            case R.id.huiteng_rearair_body_left /* 2131430114 */:
                this.cmdId = 8;
                break;
            case R.id.huiteng_rearair_body_right /* 2131430115 */:
                this.cmdId = 11;
                break;
            case R.id.huiteng_rearair_foot_left /* 2131430116 */:
                this.cmdId = 9;
                break;
            case R.id.huiteng_rearair_foot_right /* 2131430117 */:
                this.cmdId = 12;
                break;
            case R.id.huiteng_rearair_tempright_plus_btn /* 2131430118 */:
                this.cmdId = 5;
                break;
            case R.id.huiteng_rearair_tempright_munits_btn /* 2131430120 */:
                this.cmdId = 6;
                break;
            case R.id.huiteng_rearair_autoleft /* 2131430121 */:
                this.cmdId = 1;
                break;
            case R.id.huiteng_rearair_autoright /* 2131430122 */:
                this.cmdId = 2;
                break;
        }
        switch (event.getAction()) {
            case 0:
                this.touchState = 1;
                this.bNeedSend = true;
                setAirControl(this.cmdId, this.touchState);
                break;
            case 1:
                this.bNeedSend = false;
                this.touchState = 0;
                HandlerUI.getInstance().postDelayed(this.airControl, 100L);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int value = DataCanbus.DATA[38];
        if (((TextView) findViewById(R.id.huiteng_rearair_templeft_tv)) != null) {
            switch (value) {
                case -3:
                    ((TextView) findViewById(R.id.huiteng_rearair_templeft_tv)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.huiteng_rearair_templeft_tv)).setText("LOW");
                    break;
                default:
                    ((TextView) findViewById(R.id.huiteng_rearair_templeft_tv)).setText((value * 0.5f) + "°C");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int value = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.huiteng_rearair_tempright_tv)) != null) {
            switch (value) {
                case -3:
                    ((TextView) findViewById(R.id.huiteng_rearair_tempright_tv)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.huiteng_rearair_tempright_tv)).setText("LOW");
                    break;
                default:
                    ((TextView) findViewById(R.id.huiteng_rearair_tempright_tv)).setText((value * 0.5f) + "°C");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirBlowFootLeft() {
        int value = DataCanbus.DATA[36];
        if (((Button) findViewById(R.id.huiteng_rearair_foot_left)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_foot_left)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_foot_left)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirBlowBodyLeft() {
        int value = DataCanbus.DATA[35];
        if (((Button) findViewById(R.id.huiteng_rearair_body_left)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_body_left)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_body_left)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirBlowUpLeft() {
        int value = DataCanbus.DATA[34];
        if (((Button) findViewById(R.id.huiteng_rearair_win_left)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_win_left)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_win_left)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirBlowFootRight() {
        int value = DataCanbus.DATA[33];
        if (((Button) findViewById(R.id.huiteng_rearair_foot_right)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_foot_right)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_foot_right)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirBlowBodyRight() {
        int value = DataCanbus.DATA[32];
        if (((Button) findViewById(R.id.huiteng_rearair_body_right)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_body_right)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_body_right)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirBlowUpRight() {
        int value = DataCanbus.DATA[31];
        if (((Button) findViewById(R.id.huiteng_rearair_win_right)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_win_right)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_win_right)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[37];
        if (((Button) findViewById(R.id.huiteng_rearair_power)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_power)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_power)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAutoRight() {
        int value = DataCanbus.DATA[29];
        if (((Button) findViewById(R.id.huiteng_rearair_autoright)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_autoright)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_autoright)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAutoLeft() {
        int value = DataCanbus.DATA[30];
        if (((Button) findViewById(R.id.huiteng_rearair_autoleft)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_autoleft)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_autoleft)).setSelected(true);
            }
        }
    }
}
