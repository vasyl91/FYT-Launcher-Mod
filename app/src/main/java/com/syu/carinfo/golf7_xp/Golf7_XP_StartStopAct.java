package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7Data;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7_XP_StartStopAct extends BaseActivity {
    private TextView[] mTvWarning = new TextView[7];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_StartStopAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 75:
                    if (ints == null) {
                        for (int i = 0; i < 7; i++) {
                            int[] ints2 = ConstGolf.mSartStop[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            Golf7_XP_StartStopAct.this.startStopWarrning(ints2);
                        }
                        break;
                    } else {
                        Golf7_XP_StartStopAct.this.startStopWarrning(ints);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_start_stop);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTvWarning[0] = (TextView) findViewById(R.id.golf7_tv_start_stop_0);
        this.mTvWarning[1] = (TextView) findViewById(R.id.golf7_tv_start_stop_1);
        this.mTvWarning[2] = (TextView) findViewById(R.id.golf7_tv_start_stop_2);
        this.mTvWarning[3] = (TextView) findViewById(R.id.golf7_tv_start_stop_3);
        this.mTvWarning[4] = (TextView) findViewById(R.id.golf7_tv_start_stop_4);
        this.mTvWarning[5] = (TextView) findViewById(R.id.golf7_tv_start_stop_5);
        this.mTvWarning[6] = (TextView) findViewById(R.id.golf7_tv_start_stop_6);
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
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startStopWarrning(int[] ints) {
        String str;
        int index = 0;
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            index = ints[0];
            int value = ints[1];
            if (value == 48) {
                str = Golf7Data.mStrStartStopWarningXp[34];
            } else if (value == 49) {
                str = Golf7Data.mStrStartStopWarningXp[35];
            } else if (value > 0 && value < 34) {
                str = Golf7Data.mStrStartStopWarningXp[value];
            } else {
                str = "";
            }
        } else {
            str = "";
        }
        this.mTvWarning[index].setText(String.valueOf(index + 1) + "." + str);
    }
}
