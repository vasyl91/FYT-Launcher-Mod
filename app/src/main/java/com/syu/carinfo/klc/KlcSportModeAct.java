package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcSportModeAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcSportModeAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 48:
                    KlcSportModeAct.this.updateSpeedFadongjiSet();
                    break;
                case 49:
                    KlcSportModeAct.this.updateSpeedBeiGuangSet();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_sport_mode_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.klc_sport_mode_Engine_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_sport_mode_Backlit_check)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_sport_mode_Engine_check /* 2131432025 */:
                int valEngie = DataCanbus.DATA[48] & 255;
                KlcFunc.C_CAR_SPORT_MODE(1, valEngie == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_sport_mode_Backlit_check /* 2131432028 */:
                int valBacklit = DataCanbus.DATA[49] & 255;
                KlcFunc.C_CAR_SPORT_MODE(2, valBacklit != 0 ? 0 : 1);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedFadongjiSet() {
        int val = DataCanbus.DATA[48];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.klc_sport_mode_Engine_view).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.klc_sport_mode_Engine_view).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_sport_mode_Engine_check)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.klc_sport_mode_Engine_Tv)).setText(R.string.klc_sport_mode_Engine_Normal);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.klc_sport_mode_Engine_Tv)).setText(R.string.klc_sport_mode_Engine_sport);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedBeiGuangSet() {
        int val = DataCanbus.DATA[49];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.klc_btn_sport_mode_Backlit_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.klc_btn_sport_mode_Backlit_view).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_btn_sport_mode_Backlit_check)).setChecked(switchOn != 0);
        }
    }
}
