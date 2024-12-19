package com.syu.carinfo.wc.ruijie15;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RJCarSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.RJCarSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 2:
                    RJCarSetAct.this.updaterCameraDelay();
                    break;
                case 3:
                    RJCarSetAct.this.updaterTempUnit();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc3_15ruijie_car_set);
        setUI();
    }

    private void setUI() {
        findViewById(R.id.wc_15ruijie_temp_unit_set_check).setOnClickListener(this);
        findViewById(R.id.wc_15ruijie_camera_delay_set_check).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_15ruijie_temp_unit_set_check /* 2131433021 */:
                RJFunc.SET_TIPS_CMD(4, DataCanbus.DATA[3] != 0 ? 0 : 1);
                break;
            case R.id.wc_15ruijie_camera_delay_set_check /* 2131433024 */:
                RJFunc.SET_CAR_CMD(5, DataCanbus.DATA[2] != 0 ? 0 : 1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempUnit() {
        int value = DataCanbus.DATA[3];
        if (value == 1) {
            ((TextView) findViewById(R.id.wc_15ruijie_temp_unit_c_set_tv)).setText(R.string.wc_15ruijie_temp_unit_c_set);
        } else {
            ((TextView) findViewById(R.id.wc_15ruijie_temp_unit_c_set_tv)).setText(R.string.wc_15ruijie_temp_unit_f_set);
        }
        ((CheckedTextView) findViewById(R.id.wc_15ruijie_temp_unit_set_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCameraDelay() {
        int value = DataCanbus.DATA[2];
        ((CheckedTextView) findViewById(R.id.wc_15ruijie_camera_delay_set_check)).setChecked(value != 0);
    }
}
