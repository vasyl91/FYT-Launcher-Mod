package com.syu.carinfo.geshitu.wc;

import android.content.SharedPreferences;
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
public class WCGeshituSetting extends BaseActivity {
    int index;
    int[] times = {0, 2};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.geshitu.wc.WCGeshituSetting.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 20:
                    WCGeshituSetting.this.mUpdaterTravelMode();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_geshitu_wc_setting);
        ((CheckedTextView) findViewById(R.id.wc_geshitu_right_steer_lamp)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.geshitu.wc.WCGeshituSetting.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                WCGeshituSetting.this.setRightTurnRightCameraSwitch(DataCanbus.DATA[20] == 1 ? 0 : 1);
            }
        });
        ((Button) findViewById(R.id.wc_geshitu_steer_lamp_timer_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.geshitu.wc.WCGeshituSetting.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (WCGeshituSetting.this.index > 0) {
                    WCGeshituSetting wCGeshituSetting = WCGeshituSetting.this;
                    wCGeshituSetting.index--;
                    ((TextView) WCGeshituSetting.this.findViewById(R.id.wc_geshitu_steer_lamp_timer)).setText(String.valueOf(WCGeshituSetting.this.times[WCGeshituSetting.this.index]) + "s");
                    WCGeshituSetting.this.saveTimes();
                }
            }
        });
        ((Button) findViewById(R.id.wc_geshitu_steer_lamp_timer_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.geshitu.wc.WCGeshituSetting.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (WCGeshituSetting.this.index < WCGeshituSetting.this.times.length - 1) {
                    WCGeshituSetting.this.index++;
                    ((TextView) WCGeshituSetting.this.findViewById(R.id.wc_geshitu_steer_lamp_timer)).setText(String.valueOf(WCGeshituSetting.this.times[WCGeshituSetting.this.index]) + "s");
                    WCGeshituSetting.this.saveTimes();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTravelMode() {
        int value = DataCanbus.DATA[20];
        if (DataCanbus.DATA[1000] == 108) {
            ((CheckedTextView) findViewById(R.id.wc_geshitu_right_steer_lamp)).setChecked(value == 1);
        }
    }

    void saveTimes() {
        SharedPreferences sp = getSharedPreferences("geshitu", 32768);
        if (sp != null) {
            sp.edit().putInt("steer_lamp_time", this.times[this.index]).commit();
        }
    }

    int getTimes() {
        SharedPreferences sp = getSharedPreferences("geshitu", 32768);
        if (sp != null) {
            return sp.getInt("steer_lamp_time", 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRightTurnRightCameraSwitch(int value) {
        DataCanbus.PROXY.cmd(0, new int[]{value}, null, null);
    }
}
