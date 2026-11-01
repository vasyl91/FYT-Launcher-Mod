package com.syu.carinfo.xfy.sr7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivitySR7Setting extends Activity implements View.OnClickListener {
    int value = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.xfy.sr7.ActivitySR7Setting.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                    if (((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.ctv_checkedtext2)).setChecked(DataCanbus.DATA[updateCode] != 0);
                    }
                    break;
                case 101:
                    if (((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.ctv_checkedtext1)).setChecked(DataCanbus.DATA[updateCode] != 0);
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_406_xfy_sr7);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(this.value)).toString());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                this.value--;
                if (this.value <= 0) {
                    this.value = 0;
                }
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(this.value)).toString());
                DataCanbus.PROXY.cmd(1, this.value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                this.value++;
                if (this.value >= 3) {
                    this.value = 3;
                }
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(this.value)).toString());
                DataCanbus.PROXY.cmd(1, this.value);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
    }
}
