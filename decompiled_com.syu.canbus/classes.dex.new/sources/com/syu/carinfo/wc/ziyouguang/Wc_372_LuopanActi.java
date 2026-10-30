package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_372_LuopanActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_LuopanActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 134:
                    Wc_372_LuopanActi.this.mc1d3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_luopan);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.wc_372_luopan_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_LuopanActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[134] & 255;
                if (value2 < 15) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(6, value);
            }
        });
        ((Button) findViewById(R.id.wc_372_luopan_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_LuopanActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[134] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 15;
                }
                DataCanbus.PROXY.cmd(6, value);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_LuopanActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(8, 1);
                FuncMain.tips(Wc_372_LuopanActi.this.getString(R.string.str_372_calibration));
            }
        });
        if (DataCanbus.DATA[1000] == 131444) {
            findViewById(R.id.wc_372_view_gpsangle).setVisibility(8);
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
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc1d3() {
        int temp = DataCanbus.DATA[134] & 65535;
        int value = temp & 255;
        int i = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_luopan).setVisibility(0);
        if (((TextView) findViewById(R.id.wc_372_luopan_set_show)) != null) {
            ((TextView) findViewById(R.id.wc_372_luopan_set_show)).setText(new StringBuilder().append(value).toString());
        }
    }
}
