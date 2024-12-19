package com.syu.carinfo.oudi.bisu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityBiSuT3AndM3 extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.bisu.ActivityBiSuT3AndM3.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode != 50) {
                return;
            }
            ActivityBiSuT3AndM3.this.setRadarMuteState(DataCanbus.DATA[updateCode]);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_216_oudi_bisut3);
        ((CheckedTextView) findViewById(R.id.ctv_oudi_bisu_t3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.bisu.ActivityBiSuT3AndM3.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, DataCanbus.DATA[50] == 0 ? 1 : 0);
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadarMuteState(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_oudi_bisu_t3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_oudi_bisu_t3)).setChecked(value != 0);
        }
    }
}
