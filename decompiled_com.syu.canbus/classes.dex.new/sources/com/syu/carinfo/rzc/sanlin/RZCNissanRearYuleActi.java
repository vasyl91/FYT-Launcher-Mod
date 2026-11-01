package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCNissanRearYuleActi extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.RZCNissanRearYuleActi.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427554 */:
                    RZCNissanRearYuleActi.this.sendCMD(51, DataCanbus.DATA[211] != 0 ? 0 : 1);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427561 */:
                    RZCNissanRearYuleActi.this.sendCMD(54, DataCanbus.DATA[214] != 0 ? 0 : 1);
                    break;
                case R.id.ctv_checkedtext5 /* 2131427562 */:
                    RZCNissanRearYuleActi.this.sendCMD(55, DataCanbus.DATA[215] != 0 ? 0 : 1);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427576 */:
                    RZCNissanRearYuleActi.this.sendCMD(52, DataCanbus.DATA[212] != 0 ? 0 : 1);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427577 */:
                    RZCNissanRearYuleActi.this.sendCMD(53, DataCanbus.DATA[213] != 0 ? 0 : 1);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCNissanRearYuleActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 211:
                    ((CheckedTextView) RZCNissanRearYuleActi.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 212:
                    ((CheckedTextView) RZCNissanRearYuleActi.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 213:
                    ((CheckedTextView) RZCNissanRearYuleActi.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 214:
                    ((CheckedTextView) RZCNissanRearYuleActi.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 215:
                    ((CheckedTextView) RZCNissanRearYuleActi.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nissan_rzc_rear_settings);
        init();
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        if ((DataCanbus.DATA[1000] & 65535) == 80) {
            DataCanbus.PROXY.cmd(0, new int[]{cmd, val}, null, null);
        } else {
            DataCanbus.PROXY.cmd(2, new int[]{cmd, val}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        sendCMD(50, 1);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        sendCMD(50, 0);
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
    }
}
