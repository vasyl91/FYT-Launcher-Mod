package com.syu.carinfo.xp.ylford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class YLFordCarSet extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 121:
                    YLFordCarSet.this.mTowsystem();
                    break;
                case 122:
                    YLFordCarSet.this.mInformation();
                    break;
                case 123:
                    YLFordCarSet.this.mWarning();
                    break;
                case 124:
                    YLFordCarSet.this.mBrightness();
                    break;
                case 125:
                    YLFordCarSet.this.mUnit();
                    break;
                case 126:
                    YLFordCarSet.this.mVoicemode();
                    break;
                case 127:
                    YLFordCarSet.this.mTurnlight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_yl_carset);
        ((Button) findViewById(R.id.xp_ylford_brightness_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124] & 255;
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_brightness_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124] & 255;
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_unit_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[125] & 255;
                if (value2 == 0) {
                    value = 15;
                } else {
                    value = 14;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_unit_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[125] & 255;
                if (value2 == 0) {
                    value = 15;
                } else {
                    value = 14;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[121] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[122] & 255;
                if (value2 == 0) {
                    value = 6;
                } else {
                    value = 5;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[123] & 255;
                if (value2 == 0) {
                    value = 8;
                } else {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_turnlight_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[127] & 255;
                if (value2 == 0) {
                    value = 4;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_turnlight_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[127] & 255;
                if (value2 == 0) {
                    value = 4;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_voice_mode_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[126] & 255;
                if (value2 < 4) {
                    value = value2 + 10;
                } else {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_voice_mode_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[126] & 255;
                if (value2 > 0) {
                    value = value2 + 8;
                } else {
                    value = 13;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
    }

    
    public void mTowsystem() {
        int temp = DataCanbus.DATA[121] & 65535;
        if (((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)).setChecked(temp == 1);
        }
    }

    
    public void mInformation() {
        int temp = DataCanbus.DATA[122] & 65535;
        if (((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)).setChecked(temp == 1);
        }
    }

    
    public void mWarning() {
        int temp = DataCanbus.DATA[123] & 65535;
        if (((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)).setChecked(temp == 1);
        }
    }

    
    public void mVoicemode() {
        int temp = DataCanbus.DATA[126] & 65535;
        if (((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.klc_onstar_close);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.xp_ylford_set_voice_mode1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.xp_ylford_set_voice_mode2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.xp_ylford_set_voice_mode3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.klc_air_auto);
                    break;
            }
        }
    }

    
    public void mBrightness() {
        int temp = DataCanbus.DATA[124] & 65535;
        if (((TextView) findViewById(R.id.xp_ylford_brightness_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_brightness_set_show)).setText(R.string.klc_air_Manual);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_brightness_set_show)).setText(R.string.klc_air_auto);
                    break;
            }
        }
    }

    
    public void mTurnlight() {
        int temp = DataCanbus.DATA[127] & 65535;
        if (((TextView) findViewById(R.id.xp_ylford_turnlight_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_turnlight_set_show)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_turnlight_set_show)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                    break;
            }
        }
    }

    
    public void mUnit() {
        int temp = DataCanbus.DATA[125] & 65535;
        if (((TextView) findViewById(R.id.xp_ylford_unit_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_unit_set_show)).setText(R.string.wc_jianianhua_show__metric_unit_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_unit_set_show)).setText(R.string.wc_jianianhua_show__metric_unit_1);
                    break;
            }
        }
    }
}
