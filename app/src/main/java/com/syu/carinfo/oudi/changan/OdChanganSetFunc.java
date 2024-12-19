package com.syu.carinfo.oudi.changan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class OdChanganSetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.changan.OdChanganSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 65:
                    OdChanganSetFunc.this.updateAmbientlightLev(value);
                    break;
                case 66:
                    OdChanganSetFunc.this.mUpdaterAmbientlightOn(value);
                    break;
                case 67:
                    OdChanganSetFunc.this.mUpdaterSeatPleaseOn(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_odchangan_setfunc);
        ((Button) findViewById(R.id.changan_btn_ambient_light_lev_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.changan.OdChanganSetFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[65] - 1;
                if (value < 1) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.changan_btn_ambient_light_lev_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.changan.OdChanganSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[65] + 1;
                if (value > 7) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_changan_ambient_light_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.changan.OdChanganSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[66];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{148, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_changan_set_please_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.changan.OdChanganSetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[67];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{147, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAmbientlightLev(int value) {
        ((TextView) findViewById(R.id.tv_changan_ambient_light)).setText(String.format("%d", Integer.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAmbientlightOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_changan_ambient_light_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_changan_ambient_light_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatPleaseOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_changan_set_please_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_changan_set_please_onoff)).setChecked(value == 1);
        }
    }
}
