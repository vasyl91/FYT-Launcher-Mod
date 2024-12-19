package com.syu.carinfo.xp.ziyouguang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepLaunchControl extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepLaunchControl.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 329:
                    if (value == 1) {
                        PAJeepLaunchControl.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        ((Button) PAJeepLaunchControl.this.findViewById(R.id.btn_plus2)).setText(R.string.str_cancel_launch_control);
                        ((Button) PAJeepLaunchControl.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                        ((TextView) PAJeepLaunchControl.this.findViewById(R.id.tv_text1)).setText(R.string.str_activate);
                        break;
                    } else {
                        PAJeepLaunchControl.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        ((Button) PAJeepLaunchControl.this.findViewById(R.id.btn_plus2)).setText(R.string.str_activate_launch_control);
                        ((Button) PAJeepLaunchControl.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                        ((TextView) PAJeepLaunchControl.this.findViewById(R.id.tv_text1)).setText(R.string.str_inactive);
                        break;
                    }
                case 330:
                    if (((TextView) PAJeepLaunchControl.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 255) {
                            ((TextView) PAJeepLaunchControl.this.findViewById(R.id.tv_text2)).setText("----");
                            ((ProgressBar) PAJeepLaunchControl.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(0);
                            ((ProgressBar) PAJeepLaunchControl.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                            ((PaJeepLaunchControlView) PAJeepLaunchControl.this.findViewById(R.id.infoView_angle)).setSpeed(0);
                            break;
                        } else {
                            int temp = value * 50;
                            ((TextView) PAJeepLaunchControl.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(temp)).toString());
                            ((PaJeepLaunchControlView) PAJeepLaunchControl.this.findViewById(R.id.infoView_angle)).setSpeed(value);
                            ((ProgressBar) PAJeepLaunchControl.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
                            ((ProgressBar) PAJeepLaunchControl.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_launchcontrol);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepLaunchControl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{9, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepLaunchControl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{9}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepLaunchControl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[329];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(15, new int[]{8}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[]{8, 1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[329].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[330].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[329].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[330].removeNotify(this.mNotifyCanbus);
    }
}
