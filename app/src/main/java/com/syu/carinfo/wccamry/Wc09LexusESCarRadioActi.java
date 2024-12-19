package com.syu.carinfo.wccamry;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc09LexusESCarRadioActi extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static Wc09LexusESCarRadioActi mInit;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.Wc09LexusESCarRadioActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 134:
                case 136:
                    Wc09LexusESCarRadioActi.this.updateRadioBand();
                    break;
                case 135:
                    if (Wc09LexusESCarRadioActi.this.unit == 1) {
                        ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    }
                case 137:
                    if (value == 1) {
                        ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text1)).setText("AMT: ON");
                        break;
                    } else {
                        ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text1)).setText("");
                        break;
                    }
                case 138:
                    if (value == 1) {
                        ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text3)).setText("ST: ON");
                        break;
                    } else {
                        ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text3)).setText("");
                        break;
                    }
                case 139:
                    switch (value) {
                        case 1:
                            ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text2)).setText("SEEK+");
                            break;
                        case 2:
                            ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text2)).setText("SEEK-");
                            break;
                        case 3:
                            ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text2)).setText("Auto seek");
                            break;
                        case 4:
                            ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text2)).setText("Tune+");
                            break;
                        case 5:
                            ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text2)).setText("Tune-");
                            break;
                        case 6:
                            ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text2)).setText("SCAN");
                            break;
                        default:
                            ((TextView) Wc09LexusESCarRadioActi.this.findViewById(R.id.tv_text2)).setText("----");
                            break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0294_wc_toyota_lexus_es_carradio);
        mInit = this;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[134];
        int num = DataCanbus.DATA[136];
        switch (value) {
            case 0:
                this.unit = (byte) 0;
                if (num != 0) {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM-" + num);
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM");
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 1:
                this.unit = (byte) 1;
                if (num != 0) {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM-" + num);
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 2:
                this.unit = (byte) 0;
                if (num != 0) {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM1-" + num);
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM1");
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 3:
                this.unit = (byte) 0;
                if (num != 0) {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM2-" + num);
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM2");
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                this.unit = (byte) 1;
                if (num != 0) {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("MW-" + num);
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("MW");
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 5:
                this.unit = (byte) 1;
                if (num != 0) {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("LW-" + num);
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("LW");
                }
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
