package com.syu.carinfo.xbs.yage8;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XBS08YageCarRadioAct extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static XBS08YageCarRadioAct mInit;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    XBS08YageCarRadioAct.this.updateRadioBand();
                    break;
                case 116:
                    XBS08YageCarRadioAct.this.updateRadioNum();
                    break;
                case 117:
                    if (value == 1) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("Normal");
                        break;
                    } else if (value == 2) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("TUNE+");
                        break;
                    } else if (value == 3) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("TUNE-");
                        break;
                    } else if (value == 4) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SEEK+");
                        break;
                    } else if (value == 5) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SEEK-");
                        break;
                    } else if (value == 6) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN");
                        break;
                    } else if (value == 7) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("Auto Search");
                        break;
                    } else {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_scan)).setText("");
                        break;
                    }
                case 118:
                    if (value == 1) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST ON");
                        break;
                    } else {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST Off");
                        break;
                    }
                case 119:
                    if (XBS08YageCarRadioAct.this.unit == 1 || XBS08YageCarRadioAct.this.unit == 3) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(((value - 1) * 9) + 531).toString());
                        break;
                    } else if (XBS08YageCarRadioAct.this.unit == 2) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(((value - 1) * 3) + 153).toString());
                        break;
                    } else {
                        int value2 = ((value - 1) * 5) + 8750;
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value2 / 100) + "." + ((value2 % 100) / 10) + (value2 % 10));
                        break;
                    }
                case 120:
                    if (XBS08YageCarRadioAct.this.unit == 1 || XBS08YageCarRadioAct.this.unit == 3) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (((value - 1) * 9) + 531) + "  khz");
                        break;
                    } else if (XBS08YageCarRadioAct.this.unit == 2) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (((value - 1) * 3) + 153) + "  khz");
                        break;
                    } else {
                        int value3 = ((value - 1) * 5) + 8750;
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value3 / 100) + "." + (value3 % 100) + "  mhz");
                        break;
                    }
                case 121:
                    if (XBS08YageCarRadioAct.this.unit == 1 || XBS08YageCarRadioAct.this.unit == 3) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (((value - 1) * 9) + 531) + "  khz");
                        break;
                    } else if (XBS08YageCarRadioAct.this.unit == 2) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (((value - 1) * 3) + 153) + "  khz");
                        break;
                    } else {
                        int value4 = ((value - 1) * 5) + 8750;
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value4 / 100) + "." + (value4 % 100) + "  mhz");
                        break;
                    }
                case 122:
                    if (XBS08YageCarRadioAct.this.unit == 1 || XBS08YageCarRadioAct.this.unit == 3) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (((value - 1) * 9) + 531) + "  khz");
                        break;
                    } else if (XBS08YageCarRadioAct.this.unit == 2) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (((value - 1) * 3) + 153) + "  khz");
                        break;
                    } else {
                        int value5 = ((value - 1) * 5) + 8750;
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value5 / 100) + "." + (value5 % 100) + "  mhz");
                        break;
                    }
                case 123:
                    if (XBS08YageCarRadioAct.this.unit == 1 || XBS08YageCarRadioAct.this.unit == 3) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (((value - 1) * 9) + 531) + "  khz");
                        break;
                    } else if (XBS08YageCarRadioAct.this.unit == 2) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (((value - 1) * 3) + 153) + "  khz");
                        break;
                    } else {
                        int value6 = ((value - 1) * 5) + 8750;
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value6 / 100) + "." + (value6 % 100) + "  mhz");
                        break;
                    }
                case 124:
                    if (XBS08YageCarRadioAct.this.unit == 1 || XBS08YageCarRadioAct.this.unit == 3) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (((value - 1) * 9) + 531) + "  khz");
                        break;
                    } else if (XBS08YageCarRadioAct.this.unit == 2) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (((value - 1) * 3) + 153) + "  khz");
                        break;
                    } else {
                        int value7 = ((value - 1) * 5) + 8750;
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value7 / 100) + "." + (value7 % 100) + "  mhz");
                        break;
                    }
                case 125:
                    if (XBS08YageCarRadioAct.this.unit == 1 || XBS08YageCarRadioAct.this.unit == 3) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (((value - 1) * 9) + 531) + "  khz");
                        break;
                    } else if (XBS08YageCarRadioAct.this.unit == 2) {
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (((value - 1) * 3) + 153) + "  khz");
                        break;
                    } else {
                        int value8 = ((value - 1) * 5) + 8750;
                        ((TextView) XBS08YageCarRadioAct.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (value8 / 100) + "." + (value8 % 100) + "  mhz");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_yage8_carradio);
        init();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
    }

    public void updateRadioNum() {
        int value = DataCanbus.DATA[116];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-65536);
                break;
        }
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[115];
        switch (value) {
            case 0:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 1:
                break;
            case 2:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                return;
            case 3:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                return;
            case 4:
                this.unit = (byte) 2;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("MW");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                return;
            case 5:
                this.unit = (byte) 3;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("LW");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                return;
            default:
                return;
        }
        this.unit = (byte) 0;
        ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM1");
        ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
    }

    public void init() {
        mInit = this;
        findViewById(R.id.lexus_radio_prev).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_next).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(0, new int[]{3, 1}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(0, new int[]{4, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(0, new int[]{3}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
                    break;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(1, new int[1], null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
