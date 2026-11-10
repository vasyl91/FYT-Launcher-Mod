package com.syu.carinfo.xp.ziyouguang;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TabHost;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZCJeepOffRoadIndexAct extends TabActivity {
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0373_rzc_jeep_off_road_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabVehicleDynamics").setIndicator("tabVehicleDynamics").setContent(new Intent(this, (Class<?>) RZCJeepVehicleDynamicsAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPitchAndRoll").setIndicator("tabPitchAndRoll").setContent(new Intent(this, (Class<?>) RZCJeepPitchAndRollAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabAccessoryGauges").setIndicator("tabAccessoryGauges").setContent(new Intent(this, (Class<?>) RZCJeepAccessoryGaugesAct.class)));
        ((RadioButton) findViewById(R.id.pa_jeep_btn5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.RZCJeepOffRoadIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    RZCJeepOffRoadIndexAct.this.mTabHost.setCurrentTabByTag("tabPitchAndRoll");
                    RZCJeepOffRoadIndexAct.this.ClearGroup();
                    ((RadioButton) RZCJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn5)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) RZCJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn5)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.RZCJeepOffRoadIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    RZCJeepOffRoadIndexAct.this.mTabHost.setCurrentTabByTag("tabVehicleDynamics");
                    RZCJeepOffRoadIndexAct.this.ClearGroup();
                    ((RadioButton) RZCJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn6)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) RZCJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn6)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.RZCJeepOffRoadIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    RZCJeepOffRoadIndexAct.this.mTabHost.setCurrentTabByTag("tabAccessoryGauges");
                    RZCJeepOffRoadIndexAct.this.ClearGroup();
                    ((RadioButton) RZCJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn8)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) RZCJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn8)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    void ClearGroup() {
        ((RadioButton) findViewById(R.id.pa_jeep_btn5)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn6)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn8)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn5)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn6)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn8)).setTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
