package com.syu.carinfo.rzc.biaozhi408;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408IndexActi extends BaseActivity {
    private boolean flag = false;
    private int past = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 153:
                    RZC_BZ408IndexActi.this.mUpdaterValue1();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_main);
        this.flag = false;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.rzc_bz408_main_btn_functional_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZC_BZ408IndexActi.this, RZC_BZ408FuncIndexActi.class);
                    RZC_BZ408IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rzc_bz408_main_btn_oil_mileage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZC_BZ408IndexActi.this, RZC_BZ408OilMileIndexActi.class);
                    RZC_BZ408IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 238 || DataCanbus.DATA[1000] == 221 || DataCanbus.DATA[1000] == 1114451 || DataCanbus.DATA[1000] == 1179987 || DataCanbus.DATA[1000] == 1245523 || DataCanbus.DATA[1000] == 439) {
            findViewById(R.id.rzc_bz408_main_air_control).setVisibility(8);
        }
        if (TheApp.getConfiguration() == 1) {
            findViewById(R.id.rzc_bz408_main_air_control).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.rzc_bz408_main_btn_air_conditioning_control)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZC_BZ408IndexActi.this, Air_Activity_All_Toyota_prado_HP.class);
                    RZC_BZ408IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 238) {
            findViewById(R.id.rzc_bz408_speed_limit).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.rzc_bz408_main_btn_speed_limit)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 439) {
                        intent.setClass(RZC_BZ408IndexActi.this, RZC_BZ408SpeedLimitSetActi.class);
                    } else {
                        intent.setClass(RZC_BZ408IndexActi.this, RZC_BZ408SpeedLimitActi.class);
                    }
                    RZC_BZ408IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 238 || DataCanbus.DATA[1000] == 221) {
            findViewById(R.id.rzc_bz408_cruising_speed).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.rzc_bz408_main_btn_cruising_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 439) {
                        intent.setClass(RZC_BZ408IndexActi.this, RZC_BZ408CruisingSpeedSetActi.class);
                    } else {
                        intent.setClass(RZC_BZ408IndexActi.this, RZC_BZ408CruisingSpeedActi.class);
                    }
                    RZC_BZ408IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 238) {
            findViewById(R.id.rzc_bz408_alarm_record).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.rzc_bz408_main_btn_alarm_record)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZC_BZ408IndexActi.this, RZC_BZ408AlarmRecordActi.class);
                    RZC_BZ408IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[153];
        if (this.flag) {
            if (this.past != value) {
                this.past = value;
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZC_BZ408OilMileIndexActi.class);
                    startActivity(intent);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        this.past = value;
        this.flag = true;
    }
}
