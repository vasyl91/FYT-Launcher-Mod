package com.syu.carinfo.xp.ziyouguang;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepRaceOptionsIndexAct extends TabActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRaceOptionsIndexAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 347:
                    if (value == 1) {
                        PAJeepRaceOptionsIndexAct.this.mTabHost.setCurrentTabByTag("tabLaunchControl");
                        PAJeepRaceOptionsIndexAct.this.ClearGroup();
                        ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn2)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn2)).setTextColor(Color.parseColor("#666666"));
                        break;
                    }
                case 372:
                    if (value == 1) {
                        PAJeepRaceOptionsIndexAct.this.mTabHost.setCurrentTabByTag("tabShitLight");
                        PAJeepRaceOptionsIndexAct.this.ClearGroup();
                        ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn1)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn1)).setTextColor(Color.parseColor("#666666"));
                        break;
                    }
            }
        }
    };
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_raceoption_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabShitLight").setIndicator("tabShitLight").setContent(new Intent(this, (Class<?>) PAJeepShitLight.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabLaunchControl").setIndicator("tabLaunchControl").setContent(new Intent(this, (Class<?>) PAJeepLaunchControl.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabLineLock").setIndicator("tabLineLock").setContent(new Intent(this, (Class<?>) PAJeepLineLock.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabRaceCooldown").setIndicator("tabRaceCooldown").setContent(new Intent(this, (Class<?>) PAJeepRaceCoolDown.class)));
        ((RadioButton) findViewById(R.id.pa_jeep_btn1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRaceOptionsIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    PAJeepRaceOptionsIndexAct.this.mTabHost.setCurrentTabByTag("tabShitLight");
                    PAJeepRaceOptionsIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn1)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn1)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRaceOptionsIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    PAJeepRaceOptionsIndexAct.this.mTabHost.setCurrentTabByTag("tabLaunchControl");
                    PAJeepRaceOptionsIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn2)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn2)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRaceOptionsIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    PAJeepRaceOptionsIndexAct.this.mTabHost.setCurrentTabByTag("tabLineLock");
                    PAJeepRaceOptionsIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn3)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn3)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRaceOptionsIndexAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    PAJeepRaceOptionsIndexAct.this.mTabHost.setCurrentTabByTag("tabRaceCooldown");
                    PAJeepRaceOptionsIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn4)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepRaceOptionsIndexAct.this.findViewById(R.id.pa_jeep_btn4)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    void ClearGroup() {
        ((RadioButton) findViewById(R.id.pa_jeep_btn1)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn2)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn3)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn4)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn1)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn2)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn3)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn4)).setTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[347].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[372].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[347].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[372].removeNotify(this.mNotifyCanbus);
    }
}