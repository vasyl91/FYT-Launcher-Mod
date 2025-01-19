package com.syu.carinfo.psa_all;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PSAIndexActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 151:
                    PSAIndexActi.this.mUpdaterValue61();
                    break;
                case 165:
                    PSAIndexActi.this.mUpdaterValue91();
                    break;
                case 195:
                    PSAIndexActi.this.mUpdaterBackCarVol();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_index);
        if (LauncherApplication.getConfiguration() == 1) {
            findViewById(R.id.layout_view6).setVisibility(8);
        } else {
            findViewById(R.id.layout_view6).setVisibility(0);
        }
        findViewById(R.id.layout_view5).setVisibility(DataCanbus.DATA[1000] == 1245436 ? 0 : 8);
        findViewById(R.id.layout_view7).setVisibility(DataCanbus.DATA[1000] != 1245436 ? 0 : 8);
        findViewById(R.id.layout_view3).setVisibility(0);
        registerListener();
    }

    public void registerListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PSAFactorySetActivity.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PSAOrinalCarActivity.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PSAFuncIndexActi.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PSAOilMileIndexActi.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, Air_Activity_All_Toyota_prado_HP.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PSASpeedLimitActi.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PSACruisingSpeedActi.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PsaAllAlarmRecordActi.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PSA508SoundSet.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext11).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PSA4008CarSetActi.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext14).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAIndexActi.this, PSA407CarCDC.class);
                    PSAIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[195];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(102, iArr, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue61() {
        int value = DataCanbus.DATA[151];
        if (value == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }

    
    public void mUpdaterBackCarVol() {
        int value = DataCanbus.DATA[195];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterValue91() {
        int value = DataCanbus.DATA[165];
        if (value == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view2).setVisibility(8);
        }
    }
}
