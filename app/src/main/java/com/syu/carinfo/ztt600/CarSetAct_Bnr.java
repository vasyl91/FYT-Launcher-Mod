package com.syu.carinfo.ztt600;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CarSetAct_Bnr extends BaseActivity {
    private int[] ids = {38};
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ztt600.CarSetAct_Bnr.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 38:
                    CarSetAct_Bnr.this.uTempUnit(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_265_bnr_t600_carset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.notifyCanbus);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.ztt600.CarSetAct_Bnr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ctv_checkedtext1 /* 2131427478 */:
                        CarSetAct_Bnr.this.setCarSet(161, DataCanbus.DATA[38] == 1 ? 0 : 1);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarSet(int cmd, int value) {
        DataCanbus.PROXY.cmd(1, cmd, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTempUnit(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(getResources().getString(val == 1 ? R.string.wc_15ruijie_temp_unit_f_set : R.string.wc_15ruijie_temp_unit_c_set));
        }
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), val == 1);
    }
}
