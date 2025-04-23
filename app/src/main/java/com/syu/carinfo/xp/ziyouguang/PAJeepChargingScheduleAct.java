package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PAJeepChargingScheduleAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 272:
                    ((Button) PAJeepChargingScheduleAct.this.findViewById(R.id.btn_pa_jeep_onoff)).setBackgroundResource(value == 1 ? R.drawable.ic_pa_jeep_on : R.drawable.ic_pa_jeep_off);
                    break;
                case 273:
                case 274:
                case 275:
                case 276:
                    PAJeepChargingScheduleAct.this.UpdateWeekdays();
                    break;
                case 277:
                case 278:
                case 279:
                case 280:
                    PAJeepChargingScheduleAct.this.UpdateWeekends();
                    break;
                case 304:
                case 305:
                    PAJeepChargingScheduleAct.this.UpdateNextCharge();
                    break;
                case 306:
                case 307:
                    PAJeepChargingScheduleAct.this.Update120V();
                    break;
                case 308:
                case 309:
                    PAJeepChargingScheduleAct.this.Update240V();
                    break;
            }
        }
    };
    private PAJeepWeekdaysWindow mPaJeepWeekdaysWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_charging_schedule);
        init();
    }

    @Override
    public void init() {
        this.mPaJeepWeekdaysWindow = new PAJeepWeekdaysWindow(this);
        ((Button) findViewById(R.id.btn_pa_jeep_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[272];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(11, new int[]{3}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(11, new int[]{3, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_pa_jeep_goto1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                PAJeepChargingScheduleAct.this.mPaJeepWeekdaysWindow.showWindow(v, 1);
            }
        });
        ((Button) findViewById(R.id.btn_pa_jeep_goto2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                PAJeepChargingScheduleAct.this.mPaJeepWeekdaysWindow.showWindow(v, 2);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{86}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[277].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[279].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[280].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[304].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[305].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[306].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[307].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[308].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[309].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[277].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[279].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[280].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[304].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[305].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[306].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[307].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[308].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[309].removeNotify(this.mNotifyCanbus);
    }

    void Update240V() {
        int start_h = DataCanbus.DATA[308];
        int start_m = DataCanbus.DATA[309];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText("240V(Level 2):   " + (start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10));
        }
    }

    void Update120V() {
        int start_h = DataCanbus.DATA[306];
        int start_m = DataCanbus.DATA[307];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText("120V(Level 1):   " + (start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10));
        }
    }

    void UpdateNextCharge() {
        int start_h = DataCanbus.DATA[304];
        int start_m = DataCanbus.DATA[305];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (start_h == 255) {
                ((TextView) findViewById(R.id.tv_text3)).setText("when Plugged In");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10));
            }
        }
    }

    void UpdateWeekdays() {
        int start_h = DataCanbus.DATA[273];
        int start_m = DataCanbus.DATA[274];
        int end_h = DataCanbus.DATA[275];
        int end_m = DataCanbus.DATA[276];
        if (end_h == 24) {
            if (((TextView) findViewById(R.id.tv_text1)) != null) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10) + " -  Full");
            }
        } else if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10) + " - " + (end_h / 10) + (end_h % 10) + ":" + (end_m / 10) + (end_m % 10));
        }
    }

    void UpdateWeekends() {
        int start_h = DataCanbus.DATA[277];
        int start_m = DataCanbus.DATA[278];
        int end_h = DataCanbus.DATA[279];
        int end_m = DataCanbus.DATA[280];
        if (end_h == 24) {
            if (((TextView) findViewById(R.id.tv_text2)) != null) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10) + " -  Full");
            }
        } else if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(start_h / 10) + (start_h % 10) + ":" + (start_m / 10) + (start_m % 10) + " - " + (end_h / 10) + (end_h % 10) + ":" + (end_m / 10) + (end_m % 10));
        }
    }
}
