package com.syu.carinfo.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class KlcPannelselectAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcPannelselectAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 162:
                    KlcPannelselectAct.this.updateSpeedBeiGuangSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_pannel_select);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                KlcFunc.C_CAR_PANNEL_SELECT(1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                KlcFunc.C_CAR_PANNEL_SELECT(6);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                KlcFunc.C_CAR_PANNEL_SELECT(7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                KlcFunc.C_CAR_PANNEL_SELECT(2);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                KlcFunc.C_CAR_PANNEL_SELECT(5);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                KlcFunc.C_CAR_PANNEL_SELECT(8);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                KlcFunc.C_CAR_PANNEL_SELECT(0);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedBeiGuangSet() {
        int val = DataCanbus.DATA[162];
        int switchOn = val & 255;
        if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(false);
            return;
        }
        if (switchOn == 2) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(false);
            return;
        }
        if (switchOn == 5) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(false);
            return;
        }
        if (switchOn == 6) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(false);
            return;
        }
        if (switchOn == 7) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(false);
            return;
        }
        if (switchOn == 8) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(false);
            return;
        }
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
        }
    }
}
