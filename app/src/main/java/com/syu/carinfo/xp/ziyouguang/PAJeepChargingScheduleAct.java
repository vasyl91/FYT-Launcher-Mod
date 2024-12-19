package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepChargingScheduleAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepChargingScheduleAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 260:
                    ((Button) PAJeepChargingScheduleAct.this.findViewById(R.id.btn_pa_jeep_onoff)).setBackgroundResource(value == 1 ? R.drawable.ic_pa_jeep_on : R.drawable.ic_pa_jeep_off);
                    break;
                case 261:
                case 262:
                case 263:
                case 264:
                    PAJeepChargingScheduleAct.this.UpdateWeekdays();
                    break;
                case 265:
                case 266:
                case 267:
                case 268:
                    PAJeepChargingScheduleAct.this.UpdateWeekends();
                    break;
                case 292:
                case 293:
                    PAJeepChargingScheduleAct.this.UpdateNextCharge();
                    break;
                case 294:
                case 295:
                    PAJeepChargingScheduleAct.this.Update120V();
                    break;
                case 296:
                case 297:
                    PAJeepChargingScheduleAct.this.Update240V();
                    break;
            }
        }
    };
    private PAJeepWeekdaysWindow mPaJeepWeekdaysWindow;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_charging_schedule);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPaJeepWeekdaysWindow = new PAJeepWeekdaysWindow(this);
        ((Button) findViewById(R.id.btn_pa_jeep_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepChargingScheduleAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[260];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(11, new int[]{3}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(11, new int[]{3, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_pa_jeep_goto1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepChargingScheduleAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PAJeepChargingScheduleAct.this.mPaJeepWeekdaysWindow.showWindow(v, 1);
            }
        });
        ((Button) findViewById(R.id.btn_pa_jeep_goto2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepChargingScheduleAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PAJeepChargingScheduleAct.this.mPaJeepWeekdaysWindow.showWindow(v, 2);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{86}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[263].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[264].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[265].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[266].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[268].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[292].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[293].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[294].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[295].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[297].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[263].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[264].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[265].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[266].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[268].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[292].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[293].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[294].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[295].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[297].removeNotify(this.mNotifyCanbus);
    }

    void Update240V() {
        int start_h = DataCanbus.DATA[296];
        int start_m = DataCanbus.DATA[297];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText("240V(Level 2):   " + (start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10));
        }
    }

    void Update120V() {
        int start_h = DataCanbus.DATA[294];
        int start_m = DataCanbus.DATA[295];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText("120V(Level 1):   " + (start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10));
        }
    }

    void UpdateNextCharge() {
        int start_h = DataCanbus.DATA[292];
        int start_m = DataCanbus.DATA[293];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (start_h == 255) {
                ((TextView) findViewById(R.id.tv_text3)).setText("when Plugged In");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10));
            }
        }
    }

    void UpdateWeekdays() {
        int start_h = DataCanbus.DATA[261];
        int start_m = DataCanbus.DATA[262];
        int end_h = DataCanbus.DATA[263];
        int end_m = DataCanbus.DATA[264];
        if (end_h == 24) {
            if (((TextView) findViewById(R.id.tv_text1)) != null) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10) + " -  Full");
            }
        } else if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10) + " - " + (end_h / 10) + (end_h % 10) + ":" + (end_m / 10) + (end_m % 10));
        }
    }

    void UpdateWeekends() {
        int start_h = DataCanbus.DATA[265];
        int start_m = DataCanbus.DATA[266];
        int end_h = DataCanbus.DATA[267];
        int end_m = DataCanbus.DATA[268];
        if (end_h == 24) {
            if (((TextView) findViewById(R.id.tv_text2)) != null) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10) + " -  Full");
            }
        } else if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10) + " - " + (end_h / 10) + (end_h % 10) + ":" + (end_m / 10) + (end_m % 10));
        }
    }
}
