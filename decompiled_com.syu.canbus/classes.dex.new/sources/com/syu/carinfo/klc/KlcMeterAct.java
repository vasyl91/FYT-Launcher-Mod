package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KlcMeterAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcMeterAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    KlcMeterAct.this.updateECOZhishiSet();
                    break;
                case 143:
                    KlcMeterAct.this.updateYiBiaoInfoSet();
                    break;
                case 144:
                    KlcMeterAct.this.updateSpeedModeSet();
                    break;
                case 212:
                    if (val == 0) {
                        KlcMeterAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                    } else if (val == 1) {
                        KlcMeterAct.this.findViewById(R.id.layout_view4).setVisibility(0);
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_meter_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int valEcoIns = DataCanbus.DATA[142] & 255;
                KlcFunc.C_CAR_METER(1, valEcoIns == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                KlcFunc.C_CAR_METER(16, 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int valInsInfo = DataCanbus.DATA[143] & 255;
                KlcFunc.C_CAR_METER(2, valInsInfo != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int valSpeed = DataCanbus.DATA[144] & 255;
                KlcFunc.C_CAR_METER(3, valSpeed != 0 ? 0 : 1);
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
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateECOZhishiSet() {
        int val = DataCanbus.DATA[142];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateYiBiaoInfoSet() {
        int val = DataCanbus.DATA[143];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view2).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedModeSet() {
        int val = DataCanbus.DATA[144];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view3).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_meter_Speed_Range_Tips_little);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_meter_Speed_Range_Tips_all);
            }
        }
    }
}
