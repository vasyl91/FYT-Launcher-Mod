package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class GA6AirSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    GA6AirSetAct.this.updaterAutoCompressor();
                    break;
                case 99:
                    GA6AirSetAct.this.updaterAutoCycleState();
                    break;
                case 100:
                    GA6AirSetAct.this.updaterComfort();
                    break;
                case 101:
                    GA6AirSetAct.this.mUpdaterValue0();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_257_dongjian_ga6_air_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                if (DataCanbus.DATA[100] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 2);
                    break;
                } else if (DataCanbus.DATA[100] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 0);
                    break;
                } else if (DataCanbus.DATA[100] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 1);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                if (DataCanbus.DATA[100] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 1);
                    break;
                } else if (DataCanbus.DATA[100] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 2);
                    break;
                } else if (DataCanbus.DATA[100] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 0);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                GA6Func.C_CAR_CARINFO_CMD(1, 1, DataCanbus.DATA[98] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                GA6Func.C_CAR_CARINFO_CMD(1, 2, DataCanbus.DATA[99] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                GA6Func.C_CAR_CARINFO_CMD(1, 3, DataCanbus.DATA[101] == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterValue0() {
        int mAnionMode = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mAnionMode != 0);
    }

    
    public void updaterAutoCompressor() {
        int mAutoCompre = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mAutoCompre != 0);
    }

    
    public void updaterAutoCycleState() {
        int mAutoCycle = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mAutoCycle != 0);
    }

    
    public void updaterComfort() {
        int mAirComfort = DataCanbus.DATA[100];
        if (mAirComfort == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_slow);
        } else if (mAirComfort == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_nomol);
        } else if (mAirComfort == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_fast);
        }
    }
}
