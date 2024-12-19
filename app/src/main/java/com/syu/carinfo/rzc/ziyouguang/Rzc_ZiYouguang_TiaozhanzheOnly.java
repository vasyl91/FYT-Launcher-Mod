package com.syu.carinfo.rzc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_ZiYouguang_TiaozhanzheOnly extends Activity {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    Rzc_ZiYouguang_TiaozhanzheOnly.this.mtiaozhanzhe0(value);
                    break;
                case 115:
                    Rzc_ZiYouguang_TiaozhanzheOnly.this.mtiaozhanzhe5(value);
                    break;
                case 117:
                    Rzc_ZiYouguang_TiaozhanzheOnly.this.mtiaozhanzhe(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_tiaozhanzhe_only);
        init();
    }

    private void init() {
        ((Button) findViewById(R.id.jeep_tiaozhanzhe0_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[114] + 1;
                if (value > 5) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{176, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe0_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[114] - 1;
                if (value < 0) {
                    value = 5;
                }
                DataCanbus.PROXY.cmd(2, new int[]{176, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe1_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = (DataCanbus.DATA[117] >> 7) & 1;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{178, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe1_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = (DataCanbus.DATA[117] >> 7) & 1;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{178, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe2_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = (DataCanbus.DATA[117] >> 6) & 1;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{179, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe2_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = (DataCanbus.DATA[117] >> 6) & 1;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{179, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe3_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = (DataCanbus.DATA[117] >> 5) & 1;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{180, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe3_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = (DataCanbus.DATA[117] >> 5) & 1;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{180, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe4_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = ((DataCanbus.DATA[117] >> 3) & 3) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{181, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe4_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = ((DataCanbus.DATA[117] >> 3) & 3) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{181, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe5_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{182, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_tiaozhanzhe5_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_TiaozhanzheOnly.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{182, value}, null, null);
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{177}, null, null);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mCanbusNotify);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mtiaozhanzhe(int value) {
        if (((TextView) findViewById(R.id.jeep_tiaozhanzhe1_set_show)) != null) {
            switch ((value >> 7) & 1) {
                case 0:
                    ((TextView) findViewById(R.id.jeep_tiaozhanzhe1_set_show)).setText(R.string.klc_sport_mode_Engine_Normal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.jeep_tiaozhanzhe1_set_show)).setText(R.string.klc_sport_mode_Engine_sport);
                    break;
            }
        }
        if (((TextView) findViewById(R.id.jeep_tiaozhanzhe2_set_show)) != null) {
            switch ((value >> 6) & 1) {
                case 0:
                    ((TextView) findViewById(R.id.jeep_tiaozhanzhe2_set_show)).setText(R.string.str_right_camera_close);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.jeep_tiaozhanzhe2_set_show)).setText(R.string.str_right_camera_open);
                    break;
            }
        }
        if (((TextView) findViewById(R.id.jeep_tiaozhanzhe3_set_show)) != null) {
            switch ((value >> 5) & 1) {
                case 0:
                    ((TextView) findViewById(R.id.jeep_tiaozhanzhe3_set_show)).setText(R.string.klc_sport_mode_Engine_Normal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.jeep_tiaozhanzhe3_set_show)).setText(R.string.klc_sport_mode_Engine_sport);
                    break;
            }
        }
        if (((TextView) findViewById(R.id.jeep_tiaozhanzhe4_set_show)) != null) {
            switch ((value >> 3) & 3) {
                case 0:
                    ((TextView) findViewById(R.id.jeep_tiaozhanzhe4_set_show)).setText(R.string.klc_sport_mode_Engine_Normal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.jeep_tiaozhanzhe4_set_show)).setText(R.string.klc_sport_mode_Engine_sport);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.jeep_tiaozhanzhe4_set_show)).setText(R.string.str_wc_174008_str14);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mtiaozhanzhe5(int value) {
        if (((TextView) findViewById(R.id.jeep_tiaozhanzhe5_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.jeep_tiaozhanzhe5_set_show)).setText(R.string.klc_sport_mode_Engine_sport);
            } else {
                ((TextView) findViewById(R.id.jeep_tiaozhanzhe5_set_show)).setText(R.string.klc_sport_mode_Engine_Normal);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mtiaozhanzhe0(int value) {
        if (((TextView) findViewById(R.id.jeep_tiaozhanzhe0_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.jeep_tiaozhanzhe0_set_show)).setText("1900");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.jeep_tiaozhanzhe0_set_show)).setText("2000");
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.jeep_tiaozhanzhe0_set_show)).setText("2100");
                return;
            }
            if (value == 4) {
                ((TextView) findViewById(R.id.jeep_tiaozhanzhe0_set_show)).setText("2200");
            } else if (value == 5) {
                ((TextView) findViewById(R.id.jeep_tiaozhanzhe0_set_show)).setText("2300");
            } else {
                ((TextView) findViewById(R.id.jeep_tiaozhanzhe0_set_show)).setText("1800");
            }
        }
    }
}
