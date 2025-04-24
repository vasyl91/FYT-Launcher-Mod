package com.syu.carinfo.ztt600;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CarSetAct_Bnr extends BaseActivity {
    private int[] ids = {37};
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    CarSetAct_Bnr.this.uTempUnit(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_bnr_t600_carset);
        init();
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.notifyCanbus);
        }
    }

    @Override
    public void init() {
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ctv_checkedtext1 /* 2131427525 */:
                        CarSetAct_Bnr.this.setCarSet(161, DataCanbus.DATA[37] == 1 ? 0 : 1);
                        break;
                }
            }
        };
    }

    
    public void setCarSet(int cmd, int value) {
        DataCanbus.PROXY.cmd(1, cmd, value);
    }

    
    public void uTempUnit(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(getResources().getString(val == 1 ? R.string.wc_15ruijie_temp_unit_f_set : R.string.wc_15ruijie_temp_unit_c_set));
        }
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), val == 1);
    }
}
