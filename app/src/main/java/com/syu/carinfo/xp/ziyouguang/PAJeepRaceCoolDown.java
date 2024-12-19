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
public class PAJeepRaceCoolDown extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRaceCoolDown.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 361:
                    int unit = (value >> 15) & 1;
                    int temp = (value & 32767) - 40;
                    if (unit == 1) {
                        ((TextView) PAJeepRaceCoolDown.this.findViewById(R.id.tv_text1)).setText(String.valueOf(temp) + "℉");
                        break;
                    } else {
                        ((TextView) PAJeepRaceCoolDown.this.findViewById(R.id.tv_text1)).setText(String.valueOf(temp) + "℃");
                        break;
                    }
                case 375:
                    switch (value) {
                        case 0:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus1)).setText("Enable Race Cooldown");
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                            break;
                        case 1:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus1)).setText("Disable Race Cooldown");
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p1);
                            break;
                    }
                case 376:
                    int unit2 = (value >> 8) & 255;
                    int temp2 = value & 255;
                    if (temp2 == 0) {
                        ((TextView) PAJeepRaceCoolDown.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else if (unit2 == 1) {
                        ((TextView) PAJeepRaceCoolDown.this.findViewById(R.id.tv_text2)).setText(String.valueOf(temp2 - 40) + "℉");
                        break;
                    } else {
                        ((TextView) PAJeepRaceCoolDown.this.findViewById(R.id.tv_text2)).setText(String.valueOf(((temp2 * 5) - 400) * 0.1f) + "℃");
                        break;
                    }
                case 383:
                    int unit3 = (value >> 15) & 1;
                    int temp3 = (value & 32767) - 40;
                    if (unit3 == 1) {
                        ((TextView) PAJeepRaceCoolDown.this.findViewById(R.id.tv_text3)).setText(String.valueOf(temp3) + "℉");
                        break;
                    } else {
                        ((TextView) PAJeepRaceCoolDown.this.findViewById(R.id.tv_text3)).setText(String.valueOf(temp3) + "℃");
                        break;
                    }
                case 384:
                    switch (value) {
                        case 0:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                            break;
                        case 1:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p1);
                            break;
                    }
                case 385:
                    switch (value) {
                        case 0:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                            break;
                        case 1:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p1);
                            break;
                    }
                case 386:
                    switch (value) {
                        case 0:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                            break;
                        case 1:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p1);
                            break;
                    }
                case 387:
                    switch (value) {
                        case 0:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                            break;
                        case 1:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p1);
                            break;
                    }
                case 388:
                    switch (value) {
                        case 0:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#ffffff"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                            break;
                        case 1:
                            ((Button) PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#666666"));
                            PAJeepRaceCoolDown.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p1);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_racecooldown);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRaceCoolDown.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{11}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[375].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[361].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[383].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[376].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[384].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[385].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[386].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[387].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[388].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[375].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[361].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[383].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[376].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[384].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[385].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[386].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[387].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[388].removeNotify(this.mNotifyCanbus);
    }
}
