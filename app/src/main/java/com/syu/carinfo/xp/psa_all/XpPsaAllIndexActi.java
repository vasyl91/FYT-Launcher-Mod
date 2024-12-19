package com.syu.carinfo.xp.psa_all;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.biaozhi408.BZ408AirControlActi;
import com.syu.carinfo.biaozhi408.BZ408AlarmRecordActi;
import com.syu.carinfo.biaozhi408.BZ408CruisingSpeedActi;
import com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi;
import com.syu.carinfo.biaozhi408.BZ408SpeedLimitActi;
import com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedActi;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XpPsaAllIndexActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 63:
                    XpPsaAllIndexActi.this.uMemSpeed(DataCanbus.DATA[updateCode]);
                    break;
                case 66:
                    XpPsaAllIndexActi.this.mUpdaterValue();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_psa_all_index);
        registerListener();
    }

    public void registerListener() {
        if (DataCanbus.DATA[1000] == 196889) {
            findViewById(R.id.layout_view3).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.xp_psa_all_main_btn_orinal_car_fuc)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, XpPsaAllOrinalCarActivity.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_main_btn_functional_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, XpPsaAllFunctionSettings.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_main_btn_oil_mileage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, BZ408OilMileIndexActi.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_main_btn_air_conditioning_control)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, BZ408AirControlActi.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_main_btn_speed_limit)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, BZ408SpeedLimitActi.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_main_btn_cruising_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, BZ408CruisingSpeedActi.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_index_memspeed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, PsaC4L_MemSpeedActi.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_main_btn_alarm_record)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, BZ408AlarmRecordActi.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] != 281) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, XpPsaAllCarEQSet.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsaAllIndexActi.this, XpPsaAllFactorySetActivity.class);
                    XpPsaAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue() {
        int value = DataCanbus.DATA[66];
        if (findViewById(R.id.xp_psa_all_index_view4) != null) {
            findViewById(R.id.xp_psa_all_index_view4).setVisibility(value == 0 ? 8 : 0);
        }
        if (findViewById(R.id.xp_psa_all_index_view5) != null) {
            findViewById(R.id.xp_psa_all_index_view5).setVisibility(value != 0 ? 0 : 8);
        }
    }

    protected void uMemSpeed(int value) {
        if (findViewById(R.id.xp_psa_all_index_memspeed_view) != null) {
            findViewById(R.id.xp_psa_all_index_memspeed_view).setVisibility(value == 0 ? 8 : 0);
        }
    }
}
