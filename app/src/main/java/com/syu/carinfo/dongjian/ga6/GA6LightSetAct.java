package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GA6LightSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.ga6.GA6LightSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 16:
                    GA6LightSetAct.this.updaterWithMeHome();
                    break;
                case 17:
                    GA6LightSetAct.this.updaterDayLight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_257_dongjian_ga6_light_set);
        setUI();
    }

    private void setUI() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                GA6Func.C_CAR_CARINFO_CMD(5, 2, DataCanbus.DATA[17] != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                if (DataCanbus.DATA[16] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(5, 1, 2);
                    break;
                } else if (DataCanbus.DATA[16] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(5, 1, 0);
                    break;
                } else if (DataCanbus.DATA[16] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(5, 1, 1);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                if (DataCanbus.DATA[16] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(5, 1, 1);
                    break;
                } else if (DataCanbus.DATA[16] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(5, 1, 2);
                    break;
                } else if (DataCanbus.DATA[16] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(5, 1, 0);
                    break;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWithMeHome() {
        int mWithMeHomeInt = DataCanbus.DATA[16];
        if (mWithMeHomeInt == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
        } else if (mWithMeHomeInt == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_only_near_light);
        } else if (mWithMeHomeInt == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_near_light_forgost);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDayLight() {
        int mDayLightInt = DataCanbus.DATA[17];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mDayLightInt != 0);
    }
}
