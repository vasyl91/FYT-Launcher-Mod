package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GA6AirSeatControlAct extends BaseActivity {
    public static boolean mIsFront = false;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.ga6.GA6AirSeatControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 32:
                    GA6AirSeatControlAct.this.updaterLeftSeatHeat();
                    break;
                case 33:
                    GA6AirSeatControlAct.this.updaterRightSeatHeat();
                    break;
            }
        }
    };
    private View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.syu.carinfo.dongjian.ga6.GA6AirSeatControlAct.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int id = v.getId();
            if (action == 0) {
                if (id == 2131427482) {
                    GA6Func.C_AIR_SEAT_CMD(1, 1);
                } else if (id == 2131427486) {
                    GA6Func.C_AIR_SEAT_CMD(2, 1);
                }
            } else if (action == 1) {
                if (id == 2131427482) {
                    GA6Func.C_AIR_SEAT_CMD(0, 0);
                } else if (id == 2131427486) {
                    GA6Func.C_AIR_SEAT_CMD(0, 0);
                }
            }
            return true;
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_257_dongjian_ga6_air_seat_heat_control);
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    private void setUI() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this.onTouchListener);
        findViewById(R.id.btn_plus2).setOnTouchListener(this.onTouchListener);
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
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLeftSeatHeat() {
        int leftvalue = DataCanbus.DATA[32];
        ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(leftvalue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRightSeatHeat() {
        int rightvalue = DataCanbus.DATA[33];
        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(rightvalue).toString());
    }
}
