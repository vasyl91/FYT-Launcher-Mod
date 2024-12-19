package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepESaveAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepESaveAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_pa_jeep_on2;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 227:
                    Button button = (Button) PAJeepESaveAct.this.findViewById(R.id.btn_pa_jeep_onoff1);
                    if (value != 1) {
                        i = 2130840572;
                    }
                    button.setBackgroundResource(i);
                    break;
                case 228:
                    Button button2 = (Button) PAJeepESaveAct.this.findViewById(R.id.btn_pa_jeep_onoff);
                    if (value != 1) {
                        i = 2130840572;
                    }
                    button2.setBackgroundResource(i);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_e_save);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_pa_jeep_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepESaveAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[228];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(11, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(11, new int[]{1, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_pa_jeep_onoff1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepESaveAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[227];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(11, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(11, new int[]{2, 1}, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{83}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
    }
}
