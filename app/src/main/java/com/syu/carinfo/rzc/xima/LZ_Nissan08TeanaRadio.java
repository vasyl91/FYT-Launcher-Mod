package com.syu.carinfo.rzc.xima;

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
public class LZ_Nissan08TeanaRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LZ_Nissan08TeanaRadio mInit;
    byte unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 129:
                    LZ_Nissan08TeanaRadio.this.updateRadioBand();
                    break;
                case 130:
                    ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                    ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                    ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                    ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                    ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                    ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                    switch (value) {
                        case 1:
                            ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-65536);
                            break;
                        case 2:
                            ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-65536);
                            break;
                        case 3:
                            ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-65536);
                            break;
                        case 4:
                            ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-65536);
                            break;
                        case 5:
                            ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-65536);
                            break;
                        case 6:
                            ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-65536);
                            break;
                    }
                case 131:
                    if (LZ_Nissan08TeanaRadio.this.unit == 1) {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value / 10) + "." + (value % 10));
                        break;
                    }
                case 132:
                    if (LZ_Nissan08TeanaRadio.this.unit == 1) {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 133:
                    if (LZ_Nissan08TeanaRadio.this.unit == 1) {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 134:
                    if (LZ_Nissan08TeanaRadio.this.unit == 1) {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 135:
                    if (LZ_Nissan08TeanaRadio.this.unit == 1) {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 136:
                    if (LZ_Nissan08TeanaRadio.this.unit == 1) {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 137:
                    if (LZ_Nissan08TeanaRadio.this.unit == 1) {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_nissan_08teana_carradio);
        init();
    }

    public void init() {
        mInit = this;
        findViewById(R.id.lexus_radio_toaudio).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaRadio.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZ_Nissan08TeanaRadio.this, LZ_Nissan08TeanaAmpCarSet.class);
                    LZ_Nissan08TeanaRadio.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[129];
        switch (value) {
            case 0:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 1:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 2:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 3:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM3");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 16:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 17:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 18:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}