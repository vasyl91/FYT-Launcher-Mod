package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepSuspensionAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepSuspensionAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 220:
                    switch (value) {
                        case 0:
                            ((TextView) PAJeepSuspensionAct.this.findViewById(R.id.tv_text1)).setText("AUTO");
                            PAJeepSuspensionAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_suspension0);
                            break;
                        case 1:
                            ((TextView) PAJeepSuspensionAct.this.findViewById(R.id.tv_text1)).setText("Normal");
                            PAJeepSuspensionAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_suspension2);
                            break;
                        case 2:
                            ((TextView) PAJeepSuspensionAct.this.findViewById(R.id.tv_text1)).setText("Entry/Exit");
                            PAJeepSuspensionAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_suspension1);
                            break;
                        case 3:
                            ((TextView) PAJeepSuspensionAct.this.findViewById(R.id.tv_text1)).setText("Aero");
                            PAJeepSuspensionAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_suspension2);
                            break;
                        case 4:
                            ((TextView) PAJeepSuspensionAct.this.findViewById(R.id.tv_text1)).setText("Off Road 1");
                            PAJeepSuspensionAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_suspension3);
                            break;
                        case 5:
                            ((TextView) PAJeepSuspensionAct.this.findViewById(R.id.tv_text1)).setText("Off Road 2");
                            PAJeepSuspensionAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_suspension4);
                            break;
                        case 6:
                            ((TextView) PAJeepSuspensionAct.this.findViewById(R.id.tv_text1)).setText("Rising");
                            PAJeepSuspensionAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_suspension0);
                            break;
                        case 7:
                            ((TextView) PAJeepSuspensionAct.this.findViewById(R.id.tv_text1)).setText("Lowering");
                            PAJeepSuspensionAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_suspension0);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_suspension);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{82}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
    }
}
