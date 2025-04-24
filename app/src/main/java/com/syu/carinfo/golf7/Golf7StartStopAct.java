package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7StartStopAct extends BaseActivity {
    private TextView[] mTvWarning = new TextView[7];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 172:
                    if (ints == null) {
                        for (int i = 0; i < 7; i++) {
                            int[] ints2 = ConstGolf.mSartStop[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            Golf7StartStopAct.this.startStopWarrning(ints2);
                        }
                        break;
                    } else {
                        Golf7StartStopAct.this.startStopWarrning(ints);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            //setContentView(R.layout.layout_golf7_start_stop_od);
        } else {
            //setContentView(R.layout.layout_golf7_start_stop);
        }
        init();
    }

    @Override
    public void init() {
        this.mTvWarning[0] = (TextView) findViewById(R.id.golf7_tv_start_stop_0);
        this.mTvWarning[1] = (TextView) findViewById(R.id.golf7_tv_start_stop_1);
        this.mTvWarning[2] = (TextView) findViewById(R.id.golf7_tv_start_stop_2);
        this.mTvWarning[3] = (TextView) findViewById(R.id.golf7_tv_start_stop_3);
        this.mTvWarning[4] = (TextView) findViewById(R.id.golf7_tv_start_stop_4);
        this.mTvWarning[5] = (TextView) findViewById(R.id.golf7_tv_start_stop_5);
        this.mTvWarning[6] = (TextView) findViewById(R.id.golf7_tv_start_stop_6);
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
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }

    
    public void startStopWarrning(int[] ints) {
        String str;
        String str2 = "";
        int index = 0;
        if (DataCanbus.DATA[1000] == 17 || DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 524305) {
            if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
                index = ints[0];
                int value = ints[1];
                if (value > 0) {
                    if (value > 0 && value < 22) {
                        str2 = Golf7Data.mStrStartStopWarning[value - 1];
                    } else if (value > 31 && value < 53) {
                        str2 = Golf7Data.mStrStartStopWarning[value - 11];
                    } else if (value > 223 && value < 234) {
                        str2 = Golf7Data.mStrStartStopWarning[value - 182];
                    }
                }
            } else {
                str2 = "";
            }
            this.mTvWarning[index].setText(String.valueOf(index + 1) + "." + str2);
            return;
        }
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            index = ints[0];
            int value2 = ints[1];
            if (value2 == 48) {
                str = Golf7Data.mStrStartStopWarningXp[34];
            } else if (value2 == 49) {
                str = Golf7Data.mStrStartStopWarningXp[35];
            } else if (value2 > 0 && value2 < 34) {
                str = Golf7Data.mStrStartStopWarningXp[value2];
            } else {
                str = "";
            }
        } else {
            str = "";
        }
        this.mTvWarning[index].setText(String.valueOf(index + 1) + "." + str);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            try {
                Intent intent = new Intent();
                if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                    intent.setClass(this, Golf7OilMileageIndexActiOD.class);
                } else {
                    intent.setClass(this, Golf7IndexAct.class);
                }
                startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }
}
