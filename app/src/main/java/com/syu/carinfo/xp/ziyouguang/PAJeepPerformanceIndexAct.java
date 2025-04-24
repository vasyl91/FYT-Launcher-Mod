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

@SuppressWarnings({"deprecation", "unchecked"})
public class PAJeepPerformanceIndexAct extends TabActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        }
    };
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_performance_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabGauges").setIndicator("tabGauges").setContent(new Intent(this, (Class<?>) PAJeepGauges.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabDynoEngine").setIndicator("tabDynoEngine").setContent(new Intent(this, (Class<?>) PAJeepDynoEngineAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabGForce").setIndicator("tabGForce").setContent(new Intent(this, (Class<?>) PAJeepGForceAct.class)));
        ((RadioButton) findViewById(R.id.pa_jeep_btn1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    PAJeepPerformanceIndexAct.this.mTabHost.setCurrentTabByTag("tabGauges");
                    PAJeepPerformanceIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepPerformanceIndexAct.this.findViewById(R.id.pa_jeep_btn1)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepPerformanceIndexAct.this.findViewById(R.id.pa_jeep_btn1)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    PAJeepPerformanceIndexAct.this.mTabHost.setCurrentTabByTag("tabDynoEngine");
                    PAJeepPerformanceIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepPerformanceIndexAct.this.findViewById(R.id.pa_jeep_btn2)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepPerformanceIndexAct.this.findViewById(R.id.pa_jeep_btn2)).setTextColor(Color.parseColor("#666666"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((RadioButton) findViewById(R.id.pa_jeep_btn3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    PAJeepPerformanceIndexAct.this.mTabHost.setCurrentTabByTag("tabGForce");
                    PAJeepPerformanceIndexAct.this.ClearGroup();
                    ((RadioButton) PAJeepPerformanceIndexAct.this.findViewById(R.id.pa_jeep_btn3)).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    ((RadioButton) PAJeepPerformanceIndexAct.this.findViewById(R.id.pa_jeep_btn3)).setTextColor(Color.parseColor("#666666"));
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
        ((RadioButton) findViewById(R.id.pa_jeep_btn1)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn2)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.pa_jeep_btn3)).setTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    public void addNotify() {
    }

    public void removeNotify() {
    }
}
