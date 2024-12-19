package com.syu.carinfo.ky;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityHaimaS3 extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ky.ActivityHaimaS3.1
        int value;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 18:
                    ActivityHaimaS3.this.uBigLight(this.value);
                    break;
            }
        }
    };
    int value;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_258_haima_s3);
        ((CheckedTextView) findViewById(R.id.ky_haimas3_biglightcomehome)).setOnClickListener(this);
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

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBigLight(int value) {
        if (((CheckedTextView) findViewById(R.id.ky_haimas3_biglightcomehome)) != null) {
            ((CheckedTextView) findViewById(R.id.ky_haimas3_biglightcomehome)).setChecked(value != 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ky_haimas3_biglightcomehome /* 2131429005 */:
                this.value = DataCanbus.DATA[18];
                DataCanbus.PROXY.cmd(3, 18, this.value == 0 ? 1 : 0);
                break;
        }
    }
}
