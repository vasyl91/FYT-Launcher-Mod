package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LadaSettingsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.LadaSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 32:
                    LadaSettingsAct.this.mUpdaterElectric();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lada_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.camry_btn_electric_door_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.LadaSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_electric_door_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.LadaSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(19, new int[]{value + 1}, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterElectric() {
        int value = DataCanbus.DATA[32];
        if (((TextView) findViewById(R.id.camry_tv_electric_door)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_4);
                    break;
                default:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_0);
                    break;
            }
        }
    }
}