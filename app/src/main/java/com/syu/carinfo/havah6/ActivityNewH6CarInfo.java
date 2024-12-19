package com.syu.carinfo.havah6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityNewH6CarInfo extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.ActivityNewH6CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 23:
                    if (((TextView) ActivityNewH6CarInfo.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ActivityNewH6CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + "V");
                        break;
                    }
                case 24:
                    if (((TextView) ActivityNewH6CarInfo.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ActivityNewH6CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value - 40) + "℃");
                        break;
                    }
                case 25:
                    if (((TextView) ActivityNewH6CarInfo.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ActivityNewH6CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "℃");
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_132_havah2s_info);
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
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
    }
}
