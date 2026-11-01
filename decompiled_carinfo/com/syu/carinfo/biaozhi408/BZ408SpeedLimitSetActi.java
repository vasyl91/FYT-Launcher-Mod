package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BZ408SpeedLimitSetActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 120:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue7();
                    break;
                case 121:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue8();
                    break;
                case 122:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue9();
                    break;
                case 123:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue10();
                    break;
                case 124:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue11();
                    break;
                case 125:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue12();
                    break;
                case 133:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue1();
                    break;
                case 134:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue2();
                    break;
                case 135:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue3();
                    break;
                case 136:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue4();
                    break;
                case 137:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue5();
                    break;
                case 138:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue6();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_biaozhi408_speed_limit_set);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[133];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(17, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[134];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(26, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[135];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(28, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[136];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(30, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[137];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(32, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[138];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(34, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_1_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_1_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_2_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(27, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_2_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(27, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_3_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_3_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_4_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_4_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_5_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(33, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_5_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(33, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_6_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(35, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_6_set_plus)).setOnClickListener(new View.OnClickListener() { 
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
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 262425 || DataCanbus.DATA[1000] == 281) {
            DataCanbus.PROXY.cmd(53, new int[]{61}, null, null);
            findViewById(R.id.bz408_view_speed_limit_speed_1).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_2).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_3).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_4).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_5).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_6).setVisibility(8);
        } else {
            findViewById(R.id.bz408_view_speed_limit_speed_1).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_2).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_3).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_4).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_5).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_6).setVisibility(8);
        }
        addNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[133];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_1)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_1)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[134];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_2)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_2)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[135];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_3)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_3)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[136];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_4)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_4)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[137];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_5)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_5)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[138];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_6)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_6)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[120];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_1_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_1_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_2_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_2_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[122];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_3_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_3_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_4_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_4_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_5_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_5_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[125];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_6_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_6_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
