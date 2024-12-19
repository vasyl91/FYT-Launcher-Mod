package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS4AirControlAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 36:
                    GS4AirControlAct.this.updaterSeatHeatLeft();
                    break;
                case 37:
                    GS4AirControlAct.this.updaterSeatHeatRight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_289_wc_gs4_air_control_set);
        setUI();
    }

    private void setUI() {
        ((Button) findViewById(R.id.left_seat_heat_m)).setOnClickListener(this);
        ((Button) findViewById(R.id.left_seat_heat_p)).setOnClickListener(this);
        ((Button) findViewById(R.id.right_seat_heat_m)).setOnClickListener(this);
        ((Button) findViewById(R.id.right_seat_heat_p)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.left_seat_heat_m /* 2131429102 */:
                int mSeatLeftInt = DataCanbus.DATA[36];
                if (mSeatLeftInt != 0) {
                    if (mSeatLeftInt == 1) {
                        DataCanbus.PROXY.cmd(1, new int[]{15}, null, null);
                        break;
                    } else if (mSeatLeftInt == 2) {
                        DataCanbus.PROXY.cmd(1, new int[]{15, 1}, null, null);
                        break;
                    } else if (mSeatLeftInt == 3) {
                        DataCanbus.PROXY.cmd(1, new int[]{15, 2}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(1, new int[]{15}, null, null);
                        break;
                    }
                }
                break;
            case R.id.left_seat_heat_p /* 2131429104 */:
                int mSeatLeftInt2 = DataCanbus.DATA[36];
                if (mSeatLeftInt2 == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{15, 1}, null, null);
                    break;
                } else if (mSeatLeftInt2 == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{15, 2}, null, null);
                    break;
                } else if (mSeatLeftInt2 == 2) {
                    DataCanbus.PROXY.cmd(1, new int[]{15, 3}, null, null);
                    break;
                } else if (mSeatLeftInt2 != 3) {
                    DataCanbus.PROXY.cmd(1, new int[]{15, 1}, null, null);
                    break;
                }
            case R.id.right_seat_heat_m /* 2131429105 */:
                int mSeatRightInt = DataCanbus.DATA[37];
                if (mSeatRightInt != 0) {
                    if (mSeatRightInt == 1) {
                        DataCanbus.PROXY.cmd(1, new int[]{16}, null, null);
                        break;
                    } else if (mSeatRightInt == 2) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 1}, null, null);
                        break;
                    } else if (mSeatRightInt == 3) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 2}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(1, new int[]{16}, null, null);
                        break;
                    }
                }
                break;
            case R.id.right_seat_heat_p /* 2131429107 */:
                int mSeatRightInt2 = DataCanbus.DATA[37];
                if (mSeatRightInt2 == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{16, 1}, null, null);
                    break;
                } else if (mSeatRightInt2 == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{16, 2}, null, null);
                    break;
                } else if (mSeatRightInt2 == 2) {
                    DataCanbus.PROXY.cmd(1, new int[]{16, 3}, null, null);
                    break;
                } else if (mSeatRightInt2 != 3) {
                    DataCanbus.PROXY.cmd(1, new int[]{16, 1}, null, null);
                    break;
                }
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
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSeatHeatRight() {
        int mSeatRightInt = DataCanbus.DATA[37];
        ((TextView) findViewById(R.id.right_seat_heat_TV)).setText(new StringBuilder().append(mSeatRightInt).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSeatHeatLeft() {
        int mSeatLeftInt = DataCanbus.DATA[36];
        ((TextView) findViewById(R.id.left_seat_heat_TV)).setText(new StringBuilder().append(mSeatLeftInt).toString());
    }
}
