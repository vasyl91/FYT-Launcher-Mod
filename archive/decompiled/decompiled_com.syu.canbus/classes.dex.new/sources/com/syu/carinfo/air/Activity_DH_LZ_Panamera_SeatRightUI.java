package com.syu.carinfo.air;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Activity_DH_LZ_Panamera_SeatRightUI extends Activity implements View.OnTouchListener {
    public static Activity_DH_LZ_Panamera_SeatRightUI mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Activity_DH_LZ_Panamera_SeatRightUI.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 30) {
                Activity_DH_LZ_Panamera_SeatRightUI.this.mUpdateHeatLeft();
            }
            if (updateCode != 32) {
                return;
            }
            Activity_DH_LZ_Panamera_SeatRightUI.this.mUpdateWindLeft();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_0455_dh_lz_panamera_seatrightui);
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    private void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
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
        int data0 = 255;
        switch (id) {
            case R.id.btn_plus1 /* 2131427458 */:
                finish();
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                data0 = 27;
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                data0 = 26;
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                data0 = 3;
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                data0 = 4;
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                data0 = 5;
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                data0 = 7;
                break;
        }
        if (data0 != 255) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatLeft() {
        int vel = DataCanbus.DATA[30];
        findViewById(R.id.layout_view1).setVisibility(0);
        switch (vel) {
            case 0:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_seat_dh_panamera_seathot_right_0);
                break;
            case 1:
                findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_seat_dh_panamera_seathot_right_1);
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_dh_panamera_rightseat_hot_1);
                break;
            case 2:
                findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_seat_dh_panamera_seathot_right_2);
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_dh_panamera_rightseat_hot_2);
                break;
            case 3:
                findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_seat_dh_panamera_seathot_right_3);
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_dh_panamera_rightseat_hot_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindLeft() {
        int vel = DataCanbus.DATA[32];
        findViewById(R.id.layout_view1).setVisibility(0);
        switch (vel) {
            case 0:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_seat_dh_panamera_seatblow_right_0);
                break;
            case 1:
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_seat_dh_panamera_seatblow_right_1);
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_dh_panamera_rightseat_blow_1);
                break;
            case 2:
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_seat_dh_panamera_seatblow_right_2);
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_dh_panamera_rightseat_blow_2);
                break;
            case 3:
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_seat_dh_panamera_seatblow_right_3);
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_dh_panamera_rightseat_blow_3);
                break;
        }
    }
}
