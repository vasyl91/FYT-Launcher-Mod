package com.syu.carinfo.xbs.gs3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS3AirControlAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 45:
                    GS3AirControlAct.this.updaterSeatHeatLeft();
                    break;
                case 46:
                    GS3AirControlAct.this.updaterSeatHeatRight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        DataCanbus.PROXY.cmd(3, new int[]{3}, null, null);
        setContentView(R.layout.layout_165_xbs_gs3_air_control_set);
        setUI();
    }

    private void setUI() {
        setSelfClick((Button) findViewById(R.id.left_seat_heat_btn), this);
        setSelfClick((Button) findViewById(R.id.right_seat_heat_btn), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.left_seat_heat_btn /* 2131428692 */:
                DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                break;
            case R.id.right_seat_heat_btn /* 2131428693 */:
                DataCanbus.PROXY.cmd(1, new int[]{2}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSeatHeatRight() {
        int mSeatRightInt = DataCanbus.DATA[46];
        switch (mSeatRightInt) {
            case 0:
                ((Button) findViewById(R.id.right_seat_heat_btn)).setBackgroundResource(R.drawable.d_seat_heat_btn_r0);
                break;
            case 1:
                ((Button) findViewById(R.id.right_seat_heat_btn)).setBackgroundResource(R.drawable.d_seat_heat_btn_r1);
                break;
            case 2:
                ((Button) findViewById(R.id.right_seat_heat_btn)).setBackgroundResource(R.drawable.d_seat_heat_btn_r2);
                break;
            case 3:
                ((Button) findViewById(R.id.right_seat_heat_btn)).setBackgroundResource(R.drawable.d_seat_heat_btn_r3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSeatHeatLeft() {
        int mSeatLeftInt = DataCanbus.DATA[45];
        switch (mSeatLeftInt) {
            case 0:
                ((Button) findViewById(R.id.left_seat_heat_btn)).setBackgroundResource(R.drawable.d_seat_heat_btn_l0);
                break;
            case 1:
                ((Button) findViewById(R.id.left_seat_heat_btn)).setBackgroundResource(R.drawable.d_seat_heat_btn_l1);
                break;
            case 2:
                ((Button) findViewById(R.id.left_seat_heat_btn)).setBackgroundResource(R.drawable.d_seat_heat_btn_l2);
                break;
            case 3:
                ((Button) findViewById(R.id.left_seat_heat_btn)).setBackgroundResource(R.drawable.d_seat_heat_btn_l3);
                break;
        }
    }
}
