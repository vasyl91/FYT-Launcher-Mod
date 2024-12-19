package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GA6HelpSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.ga6.GA6HelpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 5:
                    GA6HelpSetAct.this.updaterSpeed();
                    break;
                case 6:
                    GA6HelpSetAct.this.updaterWarnSound();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_257_dongjian_ga6_help_set);
        setUI();
    }

    private void setUI() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427480 */:
                int value1 = (DataCanbus.DATA[5] / 10) - 1;
                if (value1 >= 0 && value1 <= 20) {
                    GA6Func.C_CAR_CARINFO_CMD(3, 1, value1);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = (DataCanbus.DATA[5] / 10) + 1;
                if (value2 >= 0 && value2 <= 20) {
                    GA6Func.C_CAR_CARINFO_CMD(3, 1, value2);
                    break;
                }
            case R.id.btn_minus2 /* 2131427484 */:
                if (DataCanbus.DATA[6] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(3, 2, 2);
                    break;
                } else if (DataCanbus.DATA[6] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(3, 2, 0);
                    break;
                } else if (DataCanbus.DATA[6] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(3, 2, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                if (DataCanbus.DATA[6] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(3, 2, 1);
                    break;
                } else if (DataCanbus.DATA[6] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(3, 2, 2);
                    break;
                } else if (DataCanbus.DATA[6] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(3, 2, 0);
                    break;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeed() {
        int mSpeedInt = DataCanbus.DATA[5];
        if (mSpeedInt > 200) {
            mSpeedInt = 200;
        } else if (mSpeedInt < 0) {
            mSpeedInt = 0;
        }
        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(mSpeedInt) + "Km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnSound() {
        int mWarnSoundInt = DataCanbus.DATA[6];
        if (mWarnSoundInt == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
        } else if (mWarnSoundInt == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
        } else if (mWarnSoundInt == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
        }
    }
}
