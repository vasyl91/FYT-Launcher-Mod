package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CamryicPetrolElectricActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.CamryicPetrolElectricActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (CamryicPetrolElectricActi.this.is_wc_canbus()) {
                switch (updateCode) {
                    case 31:
                        CamryicPetrolElectricActi.this.mUpdaterPEStates();
                        break;
                    case 32:
                        CamryicPetrolElectricActi.this.mUpdaterBatteryVol();
                        break;
                }
            }
            switch (updateCode) {
                case 2:
                    CamryicPetrolElectricActi.this.mUpdaterPEStates();
                    break;
                case 147:
                    CamryicPetrolElectricActi.this.mUpdaterBatteryVol();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_petrol_electric);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (is_wc_canbus()) {
            DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        } else {
            DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (is_wc_canbus()) {
            DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        } else {
            DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean is_wc_canbus() {
        int id = DataCanbus.DATA[1000];
        return (65535 & id) == 294;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryVol() {
        int value;
        if (is_wc_canbus()) {
            value = DataCanbus.DATA[32];
        } else {
            value = DataCanbus.DATA[147];
        }
        if (value > -1 && value < 9) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterPEStates() {
        int data;
        if (is_wc_canbus()) {
            data = DataCanbus.DATA[31];
        } else {
            data = DataCanbus.DATA[2];
        }
        int value1 = data & 1;
        int value2 = data & 2;
        int value3 = data & 4;
        int value4 = data & 8;
        int value5 = data & 16;
        int value6 = data & 32;
        ((TextView) findViewById(R.id.camry_tv_pe_3)).setBackgroundResource(value3 == 0 ? R.drawable.ic_camry_tv_3_n : R.drawable.ic_camry_tv_3_p);
        ((TextView) findViewById(R.id.camry_tv_pe_1)).setBackgroundResource(value4 == 0 ? R.drawable.ic_camry_tv_1_n : R.drawable.ic_camry_tv_1_p);
        if (value1 == 1) {
            ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_p_r);
        } else if (value5 == 16) {
            ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_p_l);
        } else {
            ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_n);
        }
        if (value2 != 0) {
            ((TextView) findViewById(R.id.camry_tv_pe_2)).setBackgroundResource(R.drawable.ic_camry_tv_2_p);
            ((TextView) findViewById(R.id.camry_tv_pe_4)).setBackgroundResource(R.drawable.ic_camry_tv_4_p);
        } else if (value6 != 0) {
            ((TextView) findViewById(R.id.camry_tv_pe_2)).setBackgroundResource(R.drawable.ic_camry_tv_2_p_n);
            ((TextView) findViewById(R.id.camry_tv_pe_4)).setBackgroundResource(R.drawable.ic_camry_tv_4_p_r);
        } else {
            ((TextView) findViewById(R.id.camry_tv_pe_2)).setBackgroundResource(R.drawable.ic_camry_tv_2_n);
            ((TextView) findViewById(R.id.camry_tv_pe_4)).setBackgroundResource(R.drawable.ic_camry_tv_4_n);
        }
    }
}
