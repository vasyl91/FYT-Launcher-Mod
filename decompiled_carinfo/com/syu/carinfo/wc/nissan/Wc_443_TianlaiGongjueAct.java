package com.syu.carinfo.wc.nissan;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Wc_443_TianlaiGongjueAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("canbus", String.format("IUiNotify->updateCode:%d", Integer.valueOf(updateCode)));
            switch (updateCode) {
                case 99:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarVol();
                    break;
                case 100:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarEQBal();
                    break;
                case 101:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarEQFad();
                    break;
                case 102:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarEQTreble();
                    break;
                case 103:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarEQBass();
                    break;
                case 104:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterBoseCenterpoint();
                    break;
                case 105:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterSpeedVol();
                    break;
                case 106:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarSurroundVol();
                    break;
                case 109:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterUnlockLighton();
                    break;
                case 110:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterHeadlightSensitivity();
                    break;
                case 111:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterHeadlightsDelaytime();
                    break;
                case 112:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterSpeedSensingWiper();
                    break;
                case 113:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterAutoUnlock();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_tianlaigongjue_settings);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.tianlaigongjue_btn_carvol_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_carvol_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_bass_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{4, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_bass_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_treble_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{6, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_treble_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{6, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_balance_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{2, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_balance_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{2, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_fade_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{3, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_fade_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{3, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_surroundvol_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{8, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_surroundvol_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{8, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_speedvol_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{7, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_speedvol_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{7, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_headlamps_on_sensitivity_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110];
                DataCanbus.PROXY.cmd(1, new int[]{5, value <= 1 ? 1 : value - 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_headlamps_on_sensitivity_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110];
                DataCanbus.PROXY.cmd(1, new int[]{5, value >= 4 ? 4 : value + 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_headlight_delay_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_headlight_delay_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111];
                if (value < 7) {
                    value++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{6, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.tianlaigongjue_btn_bose_centerpoint_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[104];
                int value2 = value != 0 ? 0 : 1;
                DataCanbus.PROXY.cmd(2, new int[]{9, value2}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.tianlaigongjue_interior_illumination_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.tianlaigongjue_wiper_speed_sensitivity_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[112];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.tianlaigongjue_intelligent_key_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[113];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterHeadlightsDelaytime() {
        int value = DataCanbus.DATA[111];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("45s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("60s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("90s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("120s");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("150s");
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("180s");
                    break;
            }
        }
    }

    
    public void mUpdaterAutoUnlock() {
        int value = DataCanbus.DATA[113];
        if (((CheckedTextView) findViewById(R.id.tianlaigongjue_intelligent_key_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.tianlaigongjue_intelligent_key_onoff)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterSpeedSensingWiper() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.tianlaigongjue_wiper_speed_sensitivity_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.tianlaigongjue_wiper_speed_sensitivity_onoff)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterHeadlightSensitivity() {
        int value = DataCanbus.DATA[110];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_headlamps_on_sensitivity)) != null) {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_headlamps_on_sensitivity)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void mUpdaterUnlockLighton() {
        int value = DataCanbus.DATA[109];
        if (((CheckedTextView) findViewById(R.id.tianlaigongjue_interior_illumination_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.tianlaigongjue_interior_illumination_onoff)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterSpeedVol() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)).setText(R.string.off);
                    break;
                default:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    }

    
    public void mUpdaterBoseCenterpoint() {
        int value = DataCanbus.DATA[104];
        if (((CheckedTextView) findViewById(R.id.tianlaigongjue_btn_bose_centerpoint_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.tianlaigongjue_btn_bose_centerpoint_onoff)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCarSurroundVol() {
        int value = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_surroundvol)) != null) {
            if ((value & 128) == 128) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_surroundvol)).setText("-" + (256 - value));
                return;
            }
            ((TextView) findViewById(R.id.tianlaigongjue_tv_surroundvol)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void mUpdaterCarEQFad() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_fade)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_fade)).setText("F" + (0 - value));
            } else if (value > 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_fade)).setText("B" + value);
            } else {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_fade)).setText(" 0");
            }
        }
    }

    
    public void mUpdaterCarEQBal() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_balance)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_balance)).setText("L" + (0 - value));
            } else if (value > 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_balance)).setText("R" + value);
            } else {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_balance)).setText(" 0");
            }
        }
    }

    
    public void mUpdaterCarEQTreble() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_treble)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_treble)).setText("-" + (0 - value));
            } else if (value > 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_treble)).setText("+" + value);
            } else {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_treble)).setText(" 0");
            }
        }
    }

    
    public void mUpdaterCarEQBass() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_bass)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_bass)).setText("-" + (0 - value));
            } else if (value > 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_bass)).setText("+" + value);
            } else {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_bass)).setText(" 0");
            }
        }
    }

    
    public void mUpdaterCarVol() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_carvol)) != null) {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_carvol)).setText(new StringBuilder().append(value).toString());
        }
    }
}
