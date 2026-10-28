package com.syu.carinfo.rzc.ruifengs3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class JhRuiFengR3SetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    JhRuiFengR3SetFunc.this.updateTishiVol(value);
                    break;
                case 111:
                    JhRuiFengR3SetFunc.this.updateOutLightOffTime(value);
                    break;
                case 112:
                    JhRuiFengR3SetFunc.this.updateInterLightOffTime(value);
                    break;
                case 113:
                    JhRuiFengR3SetFunc.this.updateAutoLock(value);
                    break;
                case 114:
                    JhRuiFengR3SetFunc.this.mUpdaterPromptll(value);
                    break;
                case 115:
                    JhRuiFengR3SetFunc.this.mUpdaterLocaLight(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_ruifengr3_setfunc);
        ((Button) findViewById(R.id.ruifengr3_btn_tishivol_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ruifengr3_btn_tishivol_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ruifengr3_btn_outlight_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] - 1;
                if (value < 0) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ruifengr3_btn_outlight_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] + 1;
                if (value > 4) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ruifengr3_btn_interlight_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112] - 1;
                if (value < 0) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ruifengr3_btn_interlight_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112] + 1;
                if (value > 4) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ruifengr3_btn_auolock_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ruifengr3_btn_autolock_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_ruifengr3_shefangtishi)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[114];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_ruifengr3_dingwlight)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
    }

    
    public void updateTishiVol(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_ruifengr3_tishivol)).setText(R.string.klc_air_low);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_ruifengr3_tishivol)).setText(R.string.klc_air_middle);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_ruifengr3_tishivol)).setText(R.string.klc_air_high);
                break;
        }
    }

    
    public void updateOutLightOffTime(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_ruifengr3_outlight)).setText("0");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_ruifengr3_outlight)).setText(R.string.wc_ruiteng_string_time_0);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_ruifengr3_outlight)).setText(R.string.wc_ruiteng_string_time_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_ruifengr3_outlight)).setText(R.string.wc_ruiteng_string_time_2);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_ruifengr3_outlight)).setText(R.string.wc_ruiteng_string_time_3);
                break;
        }
    }

    
    public void updateInterLightOffTime(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_ruifengr3_interlight)).setText("0");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_ruifengr3_interlight)).setText(R.string.wc_ruiteng_string_time_10);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_ruifengr3_interlight)).setText(R.string.wc_ruiteng_string_time_0);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_ruifengr3_interlight)).setText(R.string.wc_ruiteng_string_time_11);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_ruifengr3_interlight)).setText(R.string.wc_ruiteng_string_time_1);
                break;
        }
    }

    
    public void updateAutoLock(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_ruifengr3_autolock)).setText(R.string.jeep_comfortsystems_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_ruifengr3_autolock)).setText(R.string.str_419_auto_lock_when_15);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_ruifengr3_autolock)).setText(R.string.str_419_auto_lock_when_40);
                break;
        }
    }

    
    public void mUpdaterPromptll(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_ruifengr3_shefangtishi)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_ruifengr3_shefangtishi)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterLocaLight(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_ruifengr3_dingwlight)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_ruifengr3_dingwlight)).setChecked(value == 1);
        }
    }
}
