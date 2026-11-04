package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class GolfTireAct_TuAng_Wc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.GolfTireAct_TuAng_Wc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 184:
                    GolfTireAct_TuAng_Wc.this.uTireFL(val);
                    break;
                case 185:
                    GolfTireAct_TuAng_Wc.this.uTireFR(val);
                    break;
                case 186:
                    GolfTireAct_TuAng_Wc.this.uTireRL(val);
                    break;
                case 187:
                    GolfTireAct_TuAng_Wc.this.uTireRR(val);
                    break;
                case 251:
                    GolfTireAct_TuAng_Wc.this.uTireDisplay(val);
                    break;
                case 252:
                    GolfTireAct_TuAng_Wc.this.uTireUnit();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf_tire_wc);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.notifyCanbus);
    }

    protected void uTireDisplay(int i) {
        int color = (i & 128) == 0 ? 2131099649 : 2131099658;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setTextColor(getResources().getColor(color));
        }
        int color1 = (i & 64) == 0 ? 2131099649 : 2131099658;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setTextColor(getResources().getColor(color1));
        }
        int color2 = (i & 32) == 0 ? 2131099649 : 2131099658;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setTextColor(getResources().getColor(color2));
        }
        int color3 = (i & 16) == 0 ? 2131099649 : 2131099658;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setTextColor(getResources().getColor(color3));
        }
    }

    protected void uTireUnit() {
        uTireFL(DataCanbus.DATA[184]);
        uTireFR(DataCanbus.DATA[185]);
        uTireRR(DataCanbus.DATA[187]);
        uTireRL(DataCanbus.DATA[186]);
    }

    private String getTireUnit(int i) {
        if (i == 0) {
            return "kpa";
        }
        if (i == 1) {
            return "bar";
        }
        if (i != 2) {
            return "";
        }
        return "psi";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireFL(int val) {
        String str;
        int defVal = (val >> 16) & 65535;
        int curVal = val & 65535;
        if (DataCanbus.DATA[252] == 1) {
            str = String.valueOf(curVal / 10.0f) + "/" + (defVal / 10.0f);
        } else {
            str = String.valueOf(curVal / 10) + "/" + (defVal / 10);
        }
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText("(" + str + ")" + getTireUnit(DataCanbus.DATA[252]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireFR(int val) {
        String str;
        int defVal = (val >> 16) & 65535;
        int curVal = val & 65535;
        if (DataCanbus.DATA[252] == 1) {
            str = String.valueOf(curVal / 10.0f) + "/" + (defVal / 10.0f);
        } else {
            str = String.valueOf(curVal / 10) + "/" + (defVal / 10);
        }
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText("(" + str + ")" + getTireUnit(DataCanbus.DATA[252]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireRL(int val) {
        String str;
        int defVal = (val >> 16) & 65535;
        int curVal = val & 65535;
        if (DataCanbus.DATA[252] == 1) {
            str = String.valueOf(curVal / 10.0f) + "/" + (defVal / 10.0f);
        } else {
            str = String.valueOf(curVal / 10) + "/" + (defVal / 10);
        }
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText("(" + str + ")" + getTireUnit(DataCanbus.DATA[252]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireRR(int val) {
        String str;
        int defVal = (val >> 16) & 65535;
        int curVal = val & 65535;
        if (DataCanbus.DATA[252] == 1) {
            str = String.valueOf(curVal / 10.0f) + "/" + (defVal / 10.0f);
        } else {
            str = String.valueOf(curVal / 10) + "/" + (defVal / 10);
        }
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText("(" + str + ")" + getTireUnit(DataCanbus.DATA[252]));
        }
    }
}
