package com.syu.carinfo.wc.tianlaicd;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0443_WC2_08_12Tianlai;
import com.syu.module.canbus.DataCanbus;

public class WC08TianlaiCarRadioAct extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static WC08TianlaiCarRadioAct mInit;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    WC08TianlaiCarRadioAct.this.updateRadioBand();
                    break;
                case 100:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10));
                        break;
                    }
                case 101:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 102:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 103:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 104:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 105:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 106:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 107:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq7)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq7)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 108:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq8)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq8)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 109:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq9)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq9)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 110:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq10)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq10)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 111:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq11)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq11)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 112:
                    if (WC08TianlaiCarRadioAct.this.unit == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq12)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq12)).setText("   " + (value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "  mhz");
                        break;
                    }
                case 113:
                    if (value == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_rds)).setText("RDS ON");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_rds)).setText("RDS Off");
                        break;
                    }
                case 114:
                    if (value == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN ON");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN Off");
                        break;
                    }
                case 115:
                    if (value == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST ON");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST Off");
                        break;
                    }
                case 116:
                    if (value == 1) {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_autop)).setText("AUTO.P ON");
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarRadioAct.this.findViewById(R.id.dj_lexus_radio_autop)).setText("AUTO.P Off");
                        break;
                    }
                case 117:
                case 118:
                    WC08TianlaiCarRadioAct.this.mUpdaterRadioText();
                    break;
                case 152:
                    WC08TianlaiCarRadioAct.this.updateRadioCh();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_08tianlai_carradio);
        mInit = this;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterRadioText() {
        int value = DataCanbus.DATA[117];
        if (value == 1) {
            ((TextView) findViewById(R.id.dj_lexus_radio_state)).setText(Callback_0443_WC2_08_12Tianlai.RadioText);
        } else {
            ((TextView) findViewById(R.id.dj_lexus_radio_state)).setText("");
        }
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[99];
        switch (value) {
            case 0:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 1:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 2:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 3:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 6:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FMAP");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 7:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AMAP");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
        }
    }

    public void updateRadioCh() {
        int value = DataCanbus.DATA[152];
        ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq7)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq8)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq9)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq10)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq11)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq12)).setTextColor(-1);
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
            case 7:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq7)).setTextColor(-65536);
                break;
            case 8:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq8)).setTextColor(-65536);
                break;
            case 9:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq9)).setTextColor(-65536);
                break;
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq10)).setTextColor(-65536);
                break;
            case 17:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq11)).setTextColor(-65536);
                break;
            case 18:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq12)).setTextColor(-65536);
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
