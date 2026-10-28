package com.syu.carinfo.dj;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DjAiruize7Setting extends BaseActivity {
    int[] strs = {R.string.dj_airuize7_prompt_close, R.string.dj_airuize7_prompt_light, R.string.dj_airuize7_prompt_sounds, R.string.dj_airuize7_prompt_lightsounds};
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    DjAiruize7Setting.this.mUpdaterPrompt();
                    break;
                case 2:
                    DjAiruize7Setting.this.mUpdaterAutoUnlock();
                    break;
                case 3:
                    DjAiruize7Setting.this.mUpdaterAssiLight();
                    break;
                case 4:
                    DjAiruize7Setting.this.mUpdaterWarnning();
                    break;
                case 5:
                    DjAiruize7Setting.this.mUpdaterOnlyBackBox();
                    break;
                case 6:
                    DjAiruize7Setting.this.mUpdaterTimeHour();
                    break;
                case 7:
                    DjAiruize7Setting.this.mUpdaterTimeMinutes();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_airuize7_dj_setting);
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int index;
                int index2 = DataCanbus.DATA[1];
                if (index2 > 0) {
                    index = index2 - 1;
                } else {
                    index = 3;
                }
                DataCanbus.PROXY.cmd(0, index);
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int index;
                int index2 = DataCanbus.DATA[1];
                if (index2 < 3) {
                    index = index2 + 1;
                } else {
                    index = 0;
                }
                DataCanbus.PROXY.cmd(0, index);
            }
        });
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[2];
                DataCanbus.PROXY.cmd(1, value == 1 ? 0 : 1);
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[3];
                DataCanbus.PROXY.cmd(2, value == 1 ? 0 : 1);
            }
        });
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[4];
                DataCanbus.PROXY.cmd(3, value == 1 ? 0 : 1);
            }
        });
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[5];
                DataCanbus.PROXY.cmd(4, value == 1 ? 0 : 1);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int hour;
                int hour2 = DataCanbus.DATA[6];
                int minute = DataCanbus.DATA[7];
                if (hour2 > 0) {
                    hour = hour2 - 1;
                } else {
                    hour = 23;
                }
                DataCanbus.PROXY.cmd(5, hour, minute);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int hour;
                int hour2 = DataCanbus.DATA[6];
                int minute = DataCanbus.DATA[7];
                if (hour2 < 23) {
                    hour = hour2 + 1;
                } else {
                    hour = 0;
                }
                DataCanbus.PROXY.cmd(5, hour, minute);
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int minute;
                int minute2 = DataCanbus.DATA[7];
                int hour = DataCanbus.DATA[6];
                if (minute2 > 0) {
                    minute = minute2 - 1;
                } else {
                    minute = 59;
                }
                DataCanbus.PROXY.cmd(6, hour, minute);
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int minute;
                int minute2 = DataCanbus.DATA[7];
                int hour = DataCanbus.DATA[6];
                if (minute2 < 59) {
                    minute = minute2 + 1;
                } else {
                    minute = 0;
                }
                DataCanbus.PROXY.cmd(6, hour, minute);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterTimeMinutes() {
        int value = DataCanbus.DATA[7];
        ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value));
    }

    
    public void mUpdaterTimeHour() {
        int value = DataCanbus.DATA[6];
        ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value));
    }

    
    public void mUpdaterAutoUnlock() {
        int value = DataCanbus.DATA[2];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
    }

    
    public void mUpdaterAssiLight() {
        int value = DataCanbus.DATA[3];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
    }

    
    public void mUpdaterWarnning() {
        int value = DataCanbus.DATA[4];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
    }

    
    public void mUpdaterOnlyBackBox() {
        int value = DataCanbus.DATA[5];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
    }

    
    public void mUpdaterPrompt() {
        int value = DataCanbus.DATA[1];
        if (findViewById(R.id.tv_text1) != null && value < 4 && value >= 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(this.strs[value]);
        }
    }
}
