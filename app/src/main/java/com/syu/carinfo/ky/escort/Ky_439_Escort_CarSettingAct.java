package com.syu.carinfo.ky.escort;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Ky_439_Escort_CarSettingAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ky.escort.Ky_439_Escort_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    Ky_439_Escort_CarSettingAct.this.updateEngineCoolTemp();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_ky_escort_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEngineCoolTemp() {
        int enginecooltemp = DataCanbus.DATA[7] & 255;
        if (((TextView) findViewById(R.id.ky_escort_enginecootemp_text)) != null) {
            if ((enginecooltemp & 128) == 128) {
                if (enginecooltemp >= 206 && enginecooltemp <= 255) {
                    ((TextView) findViewById(R.id.ky_escort_enginecootemp_text)).setText(String.format("-%d  ℃", Integer.valueOf(((enginecooltemp ^ (-1)) + 1) & 255)));
                    return;
                }
                return;
            }
            if (enginecooltemp > 127) {
                enginecooltemp = 127;
            }
            if (enginecooltemp < 0) {
                enginecooltemp = 0;
            }
            ((TextView) findViewById(R.id.ky_escort_enginecootemp_text)).setText(String.format("%d   ℃", Integer.valueOf(enginecooltemp)));
        }
    }
}
