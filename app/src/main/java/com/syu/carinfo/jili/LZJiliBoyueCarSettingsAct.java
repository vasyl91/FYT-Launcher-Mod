package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZJiliBoyueCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {26, 27, 28, 29, 30, 31, 32, 33, 34};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.LZJiliBoyueCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 26:
                    if (((TextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(value == 1 ? R.string.str_driving_sport : R.string.wc_golf_comfort);
                        break;
                    }
                case 27:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 28:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 29:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 30:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 31:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 32:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 33:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 34:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_453_lz_jili_boyue);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(1, new int[]{50}, null, null);
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 1, 27);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 2, 28);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), 12, 29);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 7, 30);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 8, 31);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 9, 32);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 10, 33);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 11, 34);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.LZJiliBoyueCarSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.LZJiliBoyueCarSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
    }

    private void sendClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.LZJiliBoyueCarSettingsAct.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    LZJiliBoyueCarSettingsAct.this.sendCmd(cmd, value == 0 ? 1 : 0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckView(CheckedTextView v, boolean b) {
        if (v != null) {
            v.setChecked(b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, value}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
