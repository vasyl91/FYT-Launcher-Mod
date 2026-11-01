package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Bg_DaQieNuoJi_DoorLock extends BaseActivity {
    int[] ids = {147, 148, 149, 151, 150, 152, 153};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_DoorLock.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 147:
                    Bg_DaQieNuoJi_DoorLock.this.u7(val);
                    break;
                case 148:
                    Bg_DaQieNuoJi_DoorLock.this.u6(val);
                    break;
                case 149:
                    Bg_DaQieNuoJi_DoorLock.this.u4(val);
                    break;
                case 150:
                    Bg_DaQieNuoJi_DoorLock.this.u2(val);
                    break;
                case 151:
                    Bg_DaQieNuoJi_DoorLock.this.u3(val);
                    break;
                case 152:
                    Bg_DaQieNuoJi_DoorLock.this.u1(val);
                    break;
                case 153:
                    Bg_DaQieNuoJi_DoorLock.this.u0(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_doorlock);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        View v = findViewById(R.id.layout_view3);
        setGone(v, true);
        View v2 = findViewById(R.id.layout_view6);
        setGone(v2, true);
        View v3 = findViewById(R.id.layout_view7);
        setGone(v3, true);
        View v4 = findViewById(R.id.layout_view9);
        setGone(v4, true);
        View v5 = findViewById(R.id.layout_view4);
        setGone(v5, false);
        setCmdClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 33, 147);
        setCmdClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 34, 148);
        setCmdClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 35, 149);
        setCmdClick((Button) findViewById(R.id.btn_minus2), 36, 151);
        setCmdClick((Button) findViewById(R.id.btn_plus2), 36, 151);
        setCmdClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 37, 150);
        setCmdClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), 38, 152);
        setCmdClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 39, 153);
    }

    private void setCmdClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_DoorLock.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v2) {
                    int val = DataCanbus.DATA[id];
                    Bg_DaQieNuoJi_DoorLock.this.setCmd(cmd, val == 0 ? 2 : 1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCmd(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setGone(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 8 : 0);
        }
    }

    private void setChecked(CheckedTextView btn, boolean on) {
        if (btn != null) {
            btn.setChecked(on);
        }
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
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u7(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext1), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u6(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext2), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u4(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext6), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text2);
        if (v != null) {
            int id = R.string.jeep_presskeyunlock_1;
            if (val == 1) {
                id = R.string.jeep_presskeyunlock_0;
            }
            v.setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext3), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext8), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext7), val != 0);
    }
}
