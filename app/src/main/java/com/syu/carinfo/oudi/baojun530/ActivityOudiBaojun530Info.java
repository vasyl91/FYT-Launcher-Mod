package com.syu.carinfo.oudi.baojun530;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityOudiBaojun530Info extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.baojun530.ActivityOudiBaojun530Info.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 9:
                    ActivityOudiBaojun530Info.this.updateRearVautoChoose(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_baojun730_rearvauto);
        ((CheckedTextView) findViewById(R.id.ctv_baojun730_rearvauto_choose)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.baojun530.ActivityOudiBaojun530Info.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[9];
                DataCanbus.PROXY.cmd(0, value == 1 ? 0 : 1);
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearVautoChoose(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_baojun730_rearvauto_choose)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_baojun730_rearvauto_choose)).setChecked(value != 0);
        }
    }
}
