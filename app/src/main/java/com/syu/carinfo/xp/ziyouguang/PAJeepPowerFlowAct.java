package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PAJeepPowerFlowAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 241:
                    if (((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text1)) != null) {
                        if ((value & 32768) != 0) {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text1)).setText("-" + (65536 - value) + " KW");
                            break;
                        } else {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " KW");
                            break;
                        }
                    }
                    break;
                case 242:
                    if (((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text2)) != null) {
                        if ((value & 32768) != 0) {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text2)).setText("-" + (65536 - value) + " KW");
                            break;
                        } else {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " KW");
                            break;
                        }
                    }
                    break;
                case 243:
                    if (((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text3)) != null) {
                        if ((value & 32768) != 0) {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text3)).setText("-" + (65536 - value) + " KW");
                            break;
                        } else {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " KW");
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_power_flow);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{83}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
    }
}
