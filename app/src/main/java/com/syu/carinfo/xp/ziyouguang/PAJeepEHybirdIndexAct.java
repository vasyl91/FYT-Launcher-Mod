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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepEHybirdIndexAct extends TabActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepEHybirdIndexAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        }
    };
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_e_hybird_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPowerFlow").setIndicator("tabPowerFlow").setContent(new Intent(this, (Class<?>) PAJeepPowerFlowAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabDrivingHistory").setIndicator("tabDrivingHistory").setContent(new Intent(this, (Class<?>) PAJeepDrivingHistroyAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabChargingSchedule").setIndicator("tabChargingSchedule").setContent(new Intent(this, (Class<?>) PAJeepChargingScheduleAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEsave").setIndicator("tabEsave").setContent(new Intent(this, (Class<?>) PAJeepESaveAct.class)));
        ((RadioButton) findViewById(R.id.pa_jeep_btn1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepEHybirdIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    PAJeepEHybirdIndexAct.this.mTabHost.setCurrentTabByTag("tabPowerFlow");
                    PAJeepEHybirdIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepEHybirdIndexAct.this.findViewById(R.id.pa_jeep_btn1)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepEHybirdIndexAct.this.findViewById(R.id.pa_jeep_btn1)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepEHybirdIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    PAJeepEHybirdIndexAct.this.mTabHost.setCurrentTabByTag("tabDrivingHistory");
                    PAJeepEHybirdIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepEHybirdIndexAct.this.findViewById(R.id.pa_jeep_btn2)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepEHybirdIndexAct.this.findViewById(R.id.pa_jeep_btn2)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepEHybirdIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    PAJeepEHybirdIndexAct.this.mTabHost.setCurrentTabByTag("tabChargingSchedule");
                    PAJeepEHybirdIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepEHybirdIndexAct.this.findViewById(R.id.pa_jeep_btn3)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepEHybirdIndexAct.this.findViewById(R.id.pa_jeep_btn3)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepEHybirdIndexAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    PAJeepEHybirdIndexAct.this.mTabHost.setCurrentTabByTag("tabEsave");
                    PAJeepEHybirdIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepEHybirdIndexAct.this.findViewById(R.id.pa_jeep_btn4)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepEHybirdIndexAct.this.findViewById(R.id.pa_jeep_btn4)).setTextColor(Color.parseColor("#666666"));
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
    }

    public void removeNotify() {
    }
}
