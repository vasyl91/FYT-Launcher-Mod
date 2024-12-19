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
public class GA6AirSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.ga6.GA6AirSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    GA6AirSetAct.this.updaterAutoCompressor();
                    break;
                case 1:
                    GA6AirSetAct.this.updaterAutoCycleState();
                    break;
                case 2:
                    GA6AirSetAct.this.updaterComfort();
                    break;
                case 3:
                    GA6AirSetAct.this.mUpdaterValue0();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_257_dongjian_ga6_air_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                GA6Func.C_CAR_CARINFO_CMD(1, 1, DataCanbus.DATA[0] == 0 ? 1 : 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                if (DataCanbus.DATA[2] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 2);
                    break;
                } else if (DataCanbus.DATA[2] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 0);
                    break;
                } else if (DataCanbus.DATA[2] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 1);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                if (DataCanbus.DATA[2] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 1);
                    break;
                } else if (DataCanbus.DATA[2] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 2);
                    break;
                } else if (DataCanbus.DATA[2] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 0);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                GA6Func.C_CAR_CARINFO_CMD(1, 2, DataCanbus.DATA[1] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                GA6Func.C_CAR_CARINFO_CMD(1, 3, DataCanbus.DATA[3] == 0 ? 1 : 0);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue0() {
        int mAnionMode = DataCanbus.DATA[3];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mAnionMode != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCompressor() {
        int mAutoCompre = DataCanbus.DATA[0];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mAutoCompre != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCycleState() {
        int mAutoCycle = DataCanbus.DATA[1];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mAutoCycle != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterComfort() {
        int mAirComfort = DataCanbus.DATA[2];
        if (mAirComfort == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_slow);
        } else if (mAirComfort == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_nomol);
        } else if (mAirComfort == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_fast);
        }
    }
}
