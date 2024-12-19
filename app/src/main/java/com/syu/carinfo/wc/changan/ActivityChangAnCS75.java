package com.syu.carinfo.wc.changan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityChangAnCS75 extends Activity {
    private IUiNotify canbusNotify = new IUiNotify() { // from class: com.syu.carinfo.wc.changan.ActivityChangAnCS75.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 22:
                    ((TextView) ActivityChangAnCS75.this.findViewById(R.id.cs75_tv_current_speed)).setText(String.valueOf(DataCanbus.DATA[updateCode]) + " km/h");
                    break;
                case 23:
                    ((TextView) ActivityChangAnCS75.this.findViewById(R.id.cs75_tv_engine_speed)).setText(String.valueOf(DataCanbus.DATA[updateCode]) + " r/min");
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_128_wc_changancs75);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.canbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.canbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.canbusNotify);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.canbusNotify);
    }
}
