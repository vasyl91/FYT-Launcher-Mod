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

@SuppressWarnings({"deprecation", "unchecked"})
public class PAJeepOffRoadIndexAct extends TabActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 310:
                    if (value == 1) {
                        PAJeepOffRoadIndexAct.this.mTabHost.setCurrentTabByTag("tabVehicleDynamics");
                        PAJeepOffRoadIndexAct.this.ClearGroup();
                        ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn6)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn6)).setTextColor(Color.parseColor("#666666"));
                        break;
                    }
            }
        }
    };
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_off_road_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabVehicleDynamics").setIndicator("tabVehicleDynamics").setContent(new Intent(this, (Class<?>) PAJeepVehicleDynamicsAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPitchAndRoll").setIndicator("tabPitchAndRoll").setContent(new Intent(this, (Class<?>) PAJeepPitchAndRollAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSuspension").setIndicator("tabSuspension").setContent(new Intent(this, (Class<?>) PAJeepSuspensionAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabAccessoryGauges").setIndicator("tabAccessoryGauges").setContent(new Intent(this, (Class<?>) PAJeepAccessoryGaugesAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSelectTerrain").setIndicator("tabSelectTerrain").setContent(new Intent(this, (Class<?>) PAJeepSelectTerrainAct.class)));
        ((RadioButton) findViewById(R.id.pa_jeep_btn5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    PAJeepOffRoadIndexAct.this.mTabHost.setCurrentTabByTag("tabPitchAndRoll");
                    PAJeepOffRoadIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn5)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn5)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    PAJeepOffRoadIndexAct.this.mTabHost.setCurrentTabByTag("tabVehicleDynamics");
                    PAJeepOffRoadIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn6)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn6)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    PAJeepOffRoadIndexAct.this.mTabHost.setCurrentTabByTag("tabSuspension");
                    PAJeepOffRoadIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn7)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn7)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    PAJeepOffRoadIndexAct.this.mTabHost.setCurrentTabByTag("tabAccessoryGauges");
                    PAJeepOffRoadIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn8)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn8)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    PAJeepOffRoadIndexAct.this.mTabHost.setCurrentTabByTag("tabSelectTerrain");
                    PAJeepOffRoadIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn9)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn9)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    PAJeepOffRoadIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn10)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepOffRoadIndexAct.this.findViewById(R.id.pa_jeep_btn10)).setTextColor(Color.parseColor("#666666"));
                    DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    void ClearGroup() {
        ((RadioButton) findViewById(R.id.pa_jeep_btn5)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn6)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn7)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn8)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn9)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn10)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
        ((RadioButton) findViewById(R.id.pa_jeep_btn5)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn6)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn7)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn8)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn9)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn10)).setTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[310].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[310].removeNotify(this.mNotifyCanbus);
    }
}
