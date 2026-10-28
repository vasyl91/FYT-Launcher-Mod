package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_BZ408SpeedLimitSetActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 172:
                    RZC_BZ408SpeedLimitSetActi.this.mUpdaterValue1();
                    break;
                case 173:
                    RZC_BZ408SpeedLimitSetActi.this.mUpdaterValue2();
                    break;
                case 174:
                    RZC_BZ408SpeedLimitSetActi.this.mUpdaterValue3();
                    break;
                case 175:
                    RZC_BZ408SpeedLimitSetActi.this.mUpdaterValue4();
                    break;
                case 176:
                    RZC_BZ408SpeedLimitSetActi.this.mUpdaterValue5();
                    break;
                case 177:
                    RZC_BZ408SpeedLimitSetActi.this.mUpdaterValue6();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_biaozhi408_speed_limit_set);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[172] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(60, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[172] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(60, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[173] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(61, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[173] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(61, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[174] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(62, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[174] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(62, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[175] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(63, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[175] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(63, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[176] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(64, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[176] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(64, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[177] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(65, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[177] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(65, new int[]{value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[172];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[173];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[174];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[175];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[176];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[177];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
