package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class GA6CarAccessoryAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    GA6CarAccessoryAct.this.updaterRomoteUnlock();
                    break;
                case 107:
                    GA6CarAccessoryAct.this.updaterSpeedLock();
                    break;
                case 108:
                    GA6CarAccessoryAct.this.updaterAutoUnlock();
                    break;
                case 109:
                    GA6CarAccessoryAct.this.updaterFrontWind();
                    break;
                case 110:
                    GA6CarAccessoryAct.this.updaterFrontYuGua();
                    break;
                case 113:
                    GA6CarAccessoryAct.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_257_dongjian_ga6_car_accessory);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 1, DataCanbus.DATA[106] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 2, DataCanbus.DATA[107] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 3, DataCanbus.DATA[108] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 4, DataCanbus.DATA[109] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 6, DataCanbus.DATA[110] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 5, DataCanbus.DATA[113] != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterValue3() {
        int mAutoFoldOutMirrors = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(mAutoFoldOutMirrors != 0);
    }

    
    public void updaterRomoteUnlock() {
        int mRomoteUnlockInt = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mRomoteUnlockInt != 0);
        if (mRomoteUnlockInt == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else if (mRomoteUnlockInt == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    
    public void updaterSpeedLock() {
        int mSpeedLockInt = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mSpeedLockInt != 0);
    }

    
    public void updaterAutoUnlock() {
        int mAutoLockInt = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mAutoLockInt != 0);
    }

    
    public void updaterFrontWind() {
        int mRomoteFrontWindInt = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mRomoteFrontWindInt != 0);
    }

    
    public void updaterFrontYuGua() {
        int mFrontYuGuaFixInt = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(mFrontYuGuaFixInt != 0);
    }
}
