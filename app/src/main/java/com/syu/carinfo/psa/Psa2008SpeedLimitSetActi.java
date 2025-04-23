package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Psa2008SpeedLimitSetActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 120:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue7();
                    break;
                case 121:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue8();
                    break;
                case 122:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue9();
                    break;
                case 123:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue10();
                    break;
                case 124:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue11();
                    break;
                case 125:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue12();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa2008_speed_limit_set);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_1_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_1_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_2_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(27, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_2_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(27, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_3_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_3_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_4_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_4_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_5_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(33, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_5_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(33, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_6_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(35, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_6_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(35, new int[]{value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[120];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_1_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_1_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_2_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_2_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[122];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_3_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_3_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_4_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_4_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_5_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_5_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[125];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_6_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_6_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
