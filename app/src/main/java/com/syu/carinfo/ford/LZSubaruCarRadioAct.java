package com.syu.carinfo.ford;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZSubaruCarRadioAct extends Activity implements View.OnTouchListener {
    public static LZSubaruCarRadioAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 119:
                    LZSubaruCarRadioAct.this.updaterRadioBand();
                    break;
                case 120:
                    LZSubaruCarRadioAct.this.updaterRadioFreq();
                    break;
                case 121:
                    LZSubaruCarRadioAct.this.updaterRadioFreq1();
                    break;
                case 122:
                    LZSubaruCarRadioAct.this.updaterRadioFreq2();
                    break;
                case 123:
                    LZSubaruCarRadioAct.this.updaterRadioFreq3();
                    break;
                case 124:
                    LZSubaruCarRadioAct.this.updaterRadioFreq4();
                    break;
                case 125:
                    LZSubaruCarRadioAct.this.updaterRadioFreq5();
                    break;
                case 126:
                    LZSubaruCarRadioAct.this.updaterRadioFreq6();
                    break;
                case 127:
                    LZSubaruCarRadioAct.this.updaterRadioFreqColor();
                    break;
                case 128:
                    if (value == 1) {
                        ((TextView) LZSubaruCarRadioAct.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST: ON");
                        break;
                    } else {
                        ((TextView) LZSubaruCarRadioAct.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST: OFF");
                        break;
                    }
                case 129:
                    if (value == 1) {
                        ((TextView) LZSubaruCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN: ON");
                        break;
                    } else {
                        ((TextView) LZSubaruCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN: OFF");
                        break;
                    }
            }
        }
    };
    int radioband = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_subaru_carradio);
        mInstance = this;
        init();
    }

    public void init() {
        findViewById(R.id.lexus_radio_toaudio).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZSubaruCarRadioAct.this, LZSubaruCarSet.class);
                    LZSubaruCarRadioAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterRadioFreqColor() {
        int value = DataCanbus.DATA[127];
        ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-65536);
                break;
        }
    }

    
    public void updaterRadioFreq6() {
        int value = DataCanbus.DATA[126];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq5() {
        int value = DataCanbus.DATA[125];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq4() {
        int value = DataCanbus.DATA[124];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq3() {
        int value = DataCanbus.DATA[123];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq2() {
        int value = DataCanbus.DATA[122];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq1() {
        int value = DataCanbus.DATA[121];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq() {
        int value = DataCanbus.DATA[120];
        switch (this.radioband) {
            case 16:
            case 17:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder(String.valueOf(value)).toString());
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 100) + "." + (value % 100));
                break;
        }
    }

    
    public void updaterRadioBand() {
        this.radioband = DataCanbus.DATA[119];
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
