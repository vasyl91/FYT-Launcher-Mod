package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class KlcSportModeAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcSportModeAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 145:
                    KlcSportModeAct.this.updateSpeedFadongjiSet();
                    break;
                case 146:
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int valEngie = DataCanbus.DATA[145] & 255;
                KlcFunc.C_CAR_SPORT_MODE(1, valEngie == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int valBacklit = DataCanbus.DATA[146] & 255;
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
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedFadongjiSet() {
        int val = DataCanbus.DATA[145];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view1).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_sport_mode_Engine_Normal);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_sport_mode_Engine_sport);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedBeiGuangSet() {
        int val = DataCanbus.DATA[146];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view2).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
        }
    }
}
