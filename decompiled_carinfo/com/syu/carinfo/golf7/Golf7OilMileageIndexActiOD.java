package com.syu.carinfo.golf7;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7OilMileageIndexActiOD extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_oil_index_od);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (findViewById(R.id.golf_msgbox) != null && findViewById(R.id.golf_msgbox).getVisibility() == 0) {
            findViewById(R.id.golf_msgbox).setVisibility(8);
        }
        DataCanbus.PROXY.cmd(98, new int[]{2}, null, null);
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.golf_oil_main_group);
        this.mGroup.setVisibility(8);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSinceStart").setIndicator("tabSinceStart").setContent(new Intent(this, (Class<?>) Golf7OilMileagePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabLongTerm").setIndicator("tabLongTerm").setContent(new Intent(this, (Class<?>) Golf7OilMileagePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSinceRefuelling").setIndicator("tabSinceRefuelling").setContent(new Intent(this, (Class<?>) Golf7OilMileagePage3Acti.class)));
        if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage4").setIndicator("tabPage4").setContent(new Intent(this, (Class<?>) Golf7FunctionalTireActiVW_DZSJ.class)));
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage5").setIndicator("tabPage5").setContent(new Intent(this, (Class<?>) Golf7FunctionalEscSystemActiVW_DZSJ.class)));
        } else {
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage4").setIndicator("tabPage4").setContent(new Intent(this, (Class<?>) Golf7FunctionalTireActiOD.class)));
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage5").setIndicator("tabPage5").setContent(new Intent(this, (Class<?>) Golf7FunctionalEscSystemActiOD.class)));
        }
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.golf_oil_btn_page1 /* 2131431575 */:
                        Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabSinceStart");
                        break;
                    case R.id.golf_oil_btn_page3 /* 2131431576 */:
                        Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabSinceRefuelling");
                        break;
                    case R.id.golf_oil_btn_page2 /* 2131431577 */:
                        Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabLongTerm");
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_oil_page_pre)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox) != null && Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).getVisibility() == 0) {
                    Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).setVisibility(8);
                }
                if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 0) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabPage5");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.str_wc_174008_str6);
                    return;
                }
                if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 1) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabSinceRefuelling");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.vehicle_detail_status_since_refuelling);
                    return;
                }
                if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 2) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabSinceStart");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.vehicle_detail_status_since_start);
                } else if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 3) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabLongTerm");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.vehicle_detail_status_long_term);
                } else if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 4) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabPage4");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.xp_yinglang_car_set_Second_str10);
                }
            }
        });
        ((Button) findViewById(R.id.btn_oil_page_next)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox) != null && Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).getVisibility() == 0) {
                    Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).setVisibility(8);
                }
                if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 0) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabSinceRefuelling");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.vehicle_detail_status_since_refuelling);
                    return;
                }
                if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 2) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabLongTerm");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.vehicle_detail_status_long_term);
                    return;
                }
                if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 1) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabPage4");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.xp_yinglang_car_set_Second_str10);
                } else if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 3) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabPage5");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.str_wc_174008_str6);
                } else if (Golf7OilMileageIndexActiOD.this.mTabHost.getCurrentTab() == 4) {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabSinceStart");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.vehicle_detail_status_since_start);
                }
            }
        });
        ((Button) findViewById(R.id.btn_oil_select)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox) != null) {
                    if (Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).getVisibility() == 8) {
                        Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).setVisibility(0);
                    } else {
                        Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).setVisibility(8);
                    }
                }
            }
        });
        ((Button) findViewById(R.id.btn_oil_media)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(130, null, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_oil_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7OilMileageIndexActiOD.this, Golf7FunctionalActiOD.class);
                    Golf7OilMileageIndexActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) findViewById(R.id.golf_msgbox_0)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabPage5");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.str_wc_174008_str6);
                    Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).setVisibility(8);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) findViewById(R.id.golf_msgbox_1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabPage4");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.xp_yinglang_car_set_Second_str10);
                    Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).setVisibility(8);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) findViewById(R.id.golf_msgbox_2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7OilMileageIndexActiOD.this, Golf7ConvenienceAct.class);
                    Golf7OilMileageIndexActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) findViewById(R.id.golf_msgbox_3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Golf7OilMileageIndexActiOD.this.mTabHost.setCurrentTabByTag("tabSinceStart");
                    ((TextView) Golf7OilMileageIndexActiOD.this.findViewById(R.id.tv_oil_page)).setText(R.string.vehicle_detail_status_since_start);
                    Golf7OilMileageIndexActiOD.this.findViewById(R.id.golf_msgbox).setVisibility(8);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) findViewById(R.id.golf_msgbox_4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7OilMileageIndexActiOD.this, Golf7AlarmRecordAct.class);
                    Golf7OilMileageIndexActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) findViewById(R.id.golf_msgbox_5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7OilMileageIndexActiOD.this, Golf7StartStopAct.class);
                    Golf7OilMileageIndexActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
