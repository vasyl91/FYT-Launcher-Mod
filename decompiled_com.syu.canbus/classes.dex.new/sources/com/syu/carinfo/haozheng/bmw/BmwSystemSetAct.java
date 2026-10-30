package com.syu.carinfo.haozheng.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BmwSystemSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.haozheng.bmw.BmwSystemSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    BmwSystemSetAct.this.updaterjuliUnit();
                    break;
                case 12:
                    BmwSystemSetAct.this.updateroilUnit();
                    break;
                case 13:
                    BmwSystemSetAct.this.updatertempUnit();
                    break;
                case 14:
                    BmwSystemSetAct.this.updatertimeFromat();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_haozheng_bmw_system_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(3, new int[]{4, 0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterjuliUnit() {
        int juliUnitvalue = DataCanbus.DATA[11];
        if (juliUnitvalue == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText("mls");
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(true);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText("km");
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateroilUnit() {
        int oilUnitValue = DataCanbus.DATA[12];
        if (oilUnitValue == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText("l/100km");
            return;
        }
        if (oilUnitValue == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText("mpg(US)");
        } else if (oilUnitValue == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText("mpg(UK)");
        } else if (oilUnitValue == 3) {
            ((TextView) findViewById(R.id.tv_text2)).setText("km/l");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatertempUnit() {
        int TempUnitValue = DataCanbus.DATA[13];
        if (TempUnitValue == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_temp_unit_1);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(true);
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_temp_unit_0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatertimeFromat() {
        int TimeFormatValue = DataCanbus.DATA[14];
        if (TimeFormatValue == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_1);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(true);
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int juliUnitvalue = DataCanbus.DATA[11];
        int oilUnitValue = DataCanbus.DATA[12];
        int TempUnitValue = DataCanbus.DATA[13];
        int TimeFormatValue = DataCanbus.DATA[14];
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                if (oilUnitValue == 0) {
                    BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, 3, TempUnitValue, TimeFormatValue);
                } else if (oilUnitValue == 1) {
                    BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, 0, TempUnitValue, TimeFormatValue);
                } else if (oilUnitValue == 2) {
                    BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, 1, TempUnitValue, TimeFormatValue);
                } else if (oilUnitValue == 3) {
                    BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, 2, TempUnitValue, TimeFormatValue);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                if (oilUnitValue == 0) {
                    BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, 1, TempUnitValue, TimeFormatValue);
                } else if (oilUnitValue == 1) {
                    BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, 2, TempUnitValue, TimeFormatValue);
                } else if (oilUnitValue == 2) {
                    BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, 3, TempUnitValue, TimeFormatValue);
                } else if (oilUnitValue == 3) {
                    BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, 0, TempUnitValue, TimeFormatValue);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                BmwFunc.CAR_SYSTEM_SET(juliUnitvalue != 0 ? 0 : 1, 0, oilUnitValue, TempUnitValue, TimeFormatValue);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, oilUnitValue, TempUnitValue != 0 ? 0 : 1, TimeFormatValue);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                BmwFunc.CAR_SYSTEM_SET(juliUnitvalue, 0, oilUnitValue, TempUnitValue, TimeFormatValue != 0 ? 0 : 1);
                break;
        }
    }
}
