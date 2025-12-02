package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7Data;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7_XP_AlarmRecordAct extends BaseActivity {
    private TextView[] mTvWarning = new TextView[7];
    private TextView[] mTvWarningLine = new TextView[7];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 171:
                    if (ints == null) {
                        for (int i = 0; i < 7; i++) {
                            int[] ints2 = ConstGolf.mVehicleWarning[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            Golf7_XP_AlarmRecordAct.this.vehicleWarning(ints2);
                        }
                        break;
                    } else {
                        Golf7_XP_AlarmRecordAct.this.vehicleWarning(ints);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_alarm_record_xp);
        init();
    }

    @Override
    public void init() {
        this.mTvWarning[0] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_0);
        this.mTvWarning[1] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_1);
        this.mTvWarning[2] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_2);
        this.mTvWarning[3] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_3);
        this.mTvWarning[4] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_4);
        this.mTvWarning[5] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_5);
        this.mTvWarning[6] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_6);
        this.mTvWarningLine[0] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_line_0);
        this.mTvWarningLine[1] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_line_1);
        this.mTvWarningLine[2] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_line_2);
        this.mTvWarningLine[3] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_line_3);
        this.mTvWarningLine[4] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_line_4);
        this.mTvWarningLine[5] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_line_5);
        this.mTvWarningLine[6] = (TextView) findViewById(R.id.golf7_tv_warnning_Vehicle_line_6);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
    }

    
    public void vehicleWarning(int[] ints) {
        String str = "";
        int index = 0;
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            index = ints[0];
            int value = ints[1];
            if (value > 0 && value < Golf7Data.mStrVehicleWarning.length) {
                str = Golf7Data.mStrVehicleWarningXp[value - 1];
            }
        } else {
            str = "";
        }
        this.mTvWarning[index].setText(String.valueOf(index + 1) + "." + str);
    }
}
