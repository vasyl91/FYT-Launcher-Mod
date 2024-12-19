package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepSelectTerrainAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepSelectTerrainAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 221:
                    switch (value) {
                        case 0:
                            ((TextView) PAJeepSelectTerrainAct.this.findViewById(R.id.tv_text1)).setText("AUTO");
                            PAJeepSelectTerrainAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_mode0);
                            break;
                        case 1:
                            ((TextView) PAJeepSelectTerrainAct.this.findViewById(R.id.tv_text1)).setText("Normal");
                            PAJeepSelectTerrainAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_mode1);
                            break;
                        case 2:
                            ((TextView) PAJeepSelectTerrainAct.this.findViewById(R.id.tv_text1)).setText("Snow");
                            PAJeepSelectTerrainAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_mode2);
                            break;
                        case 3:
                            ((TextView) PAJeepSelectTerrainAct.this.findViewById(R.id.tv_text1)).setText("Mud");
                            PAJeepSelectTerrainAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_mode3);
                            break;
                        case 4:
                            ((TextView) PAJeepSelectTerrainAct.this.findViewById(R.id.tv_text1)).setText("Sand");
                            PAJeepSelectTerrainAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_mode4);
                            break;
                        case 5:
                            ((TextView) PAJeepSelectTerrainAct.this.findViewById(R.id.tv_text1)).setText("Rock");
                            PAJeepSelectTerrainAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_mode5);
                            break;
                        case 6:
                            ((TextView) PAJeepSelectTerrainAct.this.findViewById(R.id.tv_text1)).setText("Sport");
                            PAJeepSelectTerrainAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_mode6);
                            break;
                        case 7:
                            ((TextView) PAJeepSelectTerrainAct.this.findViewById(R.id.tv_text1)).setText("Eco");
                            PAJeepSelectTerrainAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_mode7);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_select_terrain);
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
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
    }
}
