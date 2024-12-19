package com.syu.carinfo.sos;

import android.app.Activity;
import android.os.Bundle;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivitySos extends Activity {
    int Old_App_Id;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sos.ActivitySos.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 29) {
                if (DataCanbus.DATA[29] == 1) {
                    if (DataMain.DATA[0] != 12) {
                        ActivitySos.this.Old_App_Id = DataMain.DATA[0];
                        DataMain.PROXY.cmd(0, 12);
                        return;
                    }
                    return;
                }
                DataMain.PROXY.cmd(0, ActivitySos.this.Old_App_Id);
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_280_sos);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }
}
