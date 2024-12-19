package com.syu.carinfo.xp.ziyouguang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepLineLock extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepLineLock.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 350:
                    if (value == 1) {
                        PAJeepLineLock.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        ((Button) PAJeepLineLock.this.findViewById(R.id.btn_plus1)).setText(R.string.str_cancel_line_lock_control);
                        ((Button) PAJeepLineLock.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                        PAJeepLineLock.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_linelock_red);
                        ((TextView) PAJeepLineLock.this.findViewById(R.id.tv_text1)).setText(R.string.str_activate);
                        break;
                    } else {
                        PAJeepLineLock.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        ((Button) PAJeepLineLock.this.findViewById(R.id.btn_plus1)).setText(R.string.str_activate_line_lock_control);
                        ((Button) PAJeepLineLock.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                        PAJeepLineLock.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_linelock_green);
                        ((TextView) PAJeepLineLock.this.findViewById(R.id.tv_text1)).setText(R.string.str_227_ec180_car_state_1);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_linelock);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepLineLock.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[350];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(15, new int[]{10}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[]{10, 1}, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{89}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[350].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[350].removeNotify(this.mNotifyCanbus);
    }
}
