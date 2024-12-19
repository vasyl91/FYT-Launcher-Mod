package com.syu.carinfo.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcPannelselectAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcPannelselectAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 65:
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
        ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select1_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select2_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select3_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select4_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select5_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select6_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select7_check)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_pannel_select1_check /* 2131431979 */:
                KlcFunc.C_CAR_PANNEL_SELECT(1);
                break;
            case R.id.klc_btn_pannel_select2_check /* 2131431981 */:
                KlcFunc.C_CAR_PANNEL_SELECT(2);
                break;
            case R.id.klc_btn_pannel_select3_check /* 2131431983 */:
                KlcFunc.C_CAR_PANNEL_SELECT(5);
                break;
            case R.id.klc_btn_pannel_select4_check /* 2131431985 */:
                KlcFunc.C_CAR_PANNEL_SELECT(6);
                break;
            case R.id.klc_btn_pannel_select5_check /* 2131431987 */:
                KlcFunc.C_CAR_PANNEL_SELECT(7);
                break;
            case R.id.klc_btn_pannel_select6_check /* 2131431989 */:
                KlcFunc.C_CAR_PANNEL_SELECT(8);
                break;
            case R.id.klc_btn_pannel_select7_check /* 2131431991 */:
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
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedBeiGuangSet() {
        int val = DataCanbus.DATA[65];
        int switchOn = val & 255;
        if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select1_check)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select2_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select3_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select4_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select5_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select6_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select7_check)).setChecked(false);
            return;
        }
        if (switchOn == 2) {
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select2_check)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select1_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select3_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select4_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select5_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select6_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select7_check)).setChecked(false);
            return;
        }
        if (switchOn == 5) {
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select3_check)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select1_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select2_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select4_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select5_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select6_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select7_check)).setChecked(false);
            return;
        }
        if (switchOn == 6) {
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select4_check)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select1_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select2_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select3_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select5_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select6_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select7_check)).setChecked(false);
            return;
        }
        if (switchOn == 7) {
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select5_check)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select1_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select2_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select3_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select4_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select6_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select7_check)).setChecked(false);
            return;
        }
        if (switchOn == 8) {
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select6_check)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select1_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select2_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select3_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select4_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select5_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select7_check)).setChecked(false);
            return;
        }
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select7_check)).setChecked(true);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select1_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select2_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select3_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select4_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select5_check)).setChecked(false);
            ((CheckedTextView) findViewById(R.id.klc_btn_pannel_select6_check)).setChecked(false);
        }
    }
}
