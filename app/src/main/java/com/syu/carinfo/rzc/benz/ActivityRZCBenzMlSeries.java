package com.syu.carinfo.rzc.benz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityRZCBenzMlSeries extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.benz.ActivityRZCBenzMlSeries.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 38:
                    if (DataCanbus.DATA[updateCode] == 1) {
                        ((TextView) ActivityRZCBenzMlSeries.this.findViewById(R.id.benz_carassist_flag)).setText(R.string.rzc_c4l_open);
                        break;
                    } else {
                        ((TextView) ActivityRZCBenzMlSeries.this.findViewById(R.id.benz_carassist_flag)).setText(R.string.rzc_c4l_close);
                        break;
                    }
                case 39:
                    if (DataCanbus.DATA[updateCode] == 1) {
                        ((TextView) ActivityRZCBenzMlSeries.this.findViewById(R.id.benz_carradar_flag)).setText(R.string.rzc_c4l_open);
                        break;
                    } else {
                        ((TextView) ActivityRZCBenzMlSeries.this.findViewById(R.id.benz_carradar_flag)).setText(R.string.rzc_c4l_close);
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_benz_mlseries);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
    }
}
