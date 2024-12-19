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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZSubaruCarRadioAct extends Activity implements View.OnTouchListener {
    public static LZSubaruCarRadioAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.LZSubaruCarRadioAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 43:
                    LZSubaruCarRadioAct.this.updaterRadioBand();
                    break;
                case 44:
                    LZSubaruCarRadioAct.this.updaterRadioFreq();
                    break;
                case 45:
                    LZSubaruCarRadioAct.this.updaterRadioFreq1();
                    break;
                case 46:
                    LZSubaruCarRadioAct.this.updaterRadioFreq2();
                    break;
                case 47:
                    LZSubaruCarRadioAct.this.updaterRadioFreq3();
                    break;
                case 48:
                    LZSubaruCarRadioAct.this.updaterRadioFreq4();
                    break;
                case 49:
                    LZSubaruCarRadioAct.this.updaterRadioFreq5();
                    break;
                case 50:
                    LZSubaruCarRadioAct.this.updaterRadioFreq6();
                    break;
                case 51:
                    LZSubaruCarRadioAct.this.updaterRadioFreqColor();
                    break;
                case 52:
                    if (value == 1) {
                        ((TextView) LZSubaruCarRadioAct.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST: ON");
                        break;
                    } else {
                        ((TextView) LZSubaruCarRadioAct.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST: OFF");
                        break;
                    }
                case 53:
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_subaru_carradio);
        mInstance = this;
        init();
    }

    public void init() {
        findViewById(R.id.lexus_radio_toaudio).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.LZSubaruCarRadioAct.2
            @Override // android.view.View.OnClickListener
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

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreqColor() {
        int value = DataCanbus.DATA[51];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq6() {
        int value = DataCanbus.DATA[50];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq5() {
        int value = DataCanbus.DATA[49];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq4() {
        int value = DataCanbus.DATA[48];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq3() {
        int value = DataCanbus.DATA[47];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq2() {
        int value = DataCanbus.DATA[46];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq1() {
        int value = DataCanbus.DATA[45];
        switch (this.radioband) {
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value / 100) + "." + (value % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq() {
        int value = DataCanbus.DATA[44];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioBand() {
        this.radioband = DataCanbus.DATA[43];
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
