package com.syu.carinfo.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KlcPannelselectAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 162:
                    KlcPannelselectAct.this.updateSpeedBeiGuangSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_klc_pannel_select);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_pannel_select1_check /* 2131431929 */:
                KlcFunc.C_CAR_PANNEL_SELECT(1);
                break;
            case R.id.klc_btn_pannel_select2_check /* 2131431931 */:
                KlcFunc.C_CAR_PANNEL_SELECT(2);
                break;
            case R.id.klc_btn_pannel_select3_check /* 2131431933 */:
                KlcFunc.C_CAR_PANNEL_SELECT(5);
                break;
            case R.id.klc_btn_pannel_select4_check /* 2131431935 */:
                KlcFunc.C_CAR_PANNEL_SELECT(6);
                break;
            case R.id.klc_btn_pannel_select5_check /* 2131431937 */:
                KlcFunc.C_CAR_PANNEL_SELECT(7);
                break;
            case R.id.klc_btn_pannel_select6_check /* 2131431939 */:
                KlcFunc.C_CAR_PANNEL_SELECT(8);
                break;
            case R.id.klc_btn_pannel_select7_check /* 2131431941 */:
                KlcFunc.C_CAR_PANNEL_SELECT(0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateSpeedBeiGuangSet() {
        int val = DataCanbus.DATA[162];
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
