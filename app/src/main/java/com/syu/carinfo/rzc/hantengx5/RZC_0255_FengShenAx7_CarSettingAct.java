package com.syu.carinfo.rzc.hantengx5;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_0255_FengShenAx7_CarSettingAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                    RZC_0255_FengShenAx7_CarSettingAct.this.updateTurnRightSwitch();
                    break;
                case 104:
                    RZC_0255_FengShenAx7_CarSettingAct.this.updateBlindMonitorSwitch();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0255_rzc_fengshenax7_carsetting);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[105];
                int value = DataCanbus.DATA[103];
                if (value == 1) {
                    switchOn = switchOn2 & 1;
                } else {
                    switchOn = switchOn2 | 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[105] & 255;
                int value = DataCanbus.DATA[104];
                if (value == 1) {
                    switchOn = switchOn2 & 2;
                } else {
                    switchOn = switchOn2 | 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{switchOn}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateTurnRightSwitch() {
        int ambientlight = DataCanbus.DATA[103];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), ambientlight != 0);
    }

    
    public void updateBlindMonitorSwitch() {
        int seatcourtesy = DataCanbus.DATA[104];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), seatcourtesy != 0);
    }
}
