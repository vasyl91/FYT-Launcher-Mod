package com.syu.carinfo.rzc.yingfeinidi_gx50;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCBeiqiSuansuS7CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.yingfeinidi_gx50.RZCBeiqiSuansuS7CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((CheckedTextView) RZCBeiqiSuansuS7CarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                    break;
                case 100:
                    ((CheckedTextView) RZCBeiqiSuansuS7CarSet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0396_rzc_huansus7_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.yingfeinidi_gx50.RZCBeiqiSuansuS7CarSet.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value;
                    int value2 = DataCanbus.DATA[99] & 255;
                    int value1 = DataCanbus.DATA[100] & 255;
                    if (value2 == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    int sendvalue = ((value << 7) & 128) | ((value1 << 6) & 64);
                    DataCanbus.PROXY.cmd(2, new int[]{5, sendvalue, 0, 0}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.yingfeinidi_gx50.RZCBeiqiSuansuS7CarSet.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value1;
                    int value = DataCanbus.DATA[99] & 255;
                    int value2 = DataCanbus.DATA[100] & 255;
                    if (value2 == 0) {
                        value1 = 1;
                    } else {
                        value1 = 0;
                    }
                    int sendvalue = ((value << 7) & 128) | ((value1 << 6) & 64);
                    DataCanbus.PROXY.cmd(2, new int[]{5, sendvalue, 0, 0}, null, null);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }
}
