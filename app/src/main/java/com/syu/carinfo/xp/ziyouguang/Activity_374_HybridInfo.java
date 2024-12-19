package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Activity_374_HybridInfo extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_HybridInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 398:
                    switch (value) {
                        case 0:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("ENGINE POWER （4WD）");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird9);
                            break;
                        case 1:
                        case 9:
                        default:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("BATTERY POWER （2WD）");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird1);
                            break;
                        case 2:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("HYBRID POWER （2WD）");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird2);
                            break;
                        case 3:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("BATTERY CHARGING(ENGINE)");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird3);
                            break;
                        case 4:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("ENGINE POWER （2WD）");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird4);
                            break;
                        case 5:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("AUTO STOP");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird5);
                            break;
                        case 6:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("IDLE");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird6);
                            break;
                        case 7:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("BATTERY POWER （4WD）");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird7);
                            break;
                        case 8:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("BATTERY CHARGING");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird8);
                            break;
                        case 10:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("HYBRID POWER （4WD）");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird10);
                            break;
                        case 11:
                            ((TextView) Activity_374_HybridInfo.this.findViewById(R.id.tv_text1)).setText("ENGINE IDLE");
                            Activity_374_HybridInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_gmc_hybird11);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_gmc_hybird);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[398].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[398].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }
}
