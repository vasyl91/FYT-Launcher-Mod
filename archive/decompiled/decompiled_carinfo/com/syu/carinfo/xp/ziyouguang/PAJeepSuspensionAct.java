package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PAJeepSuspensionAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 232:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_suspension);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{82}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
    }
}
