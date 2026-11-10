package com.syu.carinfo.rzc.ruifengs3;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class JhRuiFengS3TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    JhRuiFengS3TireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                    JhRuiFengS3TireAct.this.mUpdaterTireFR();
                    break;
                case 100:
                    JhRuiFengS3TireAct.this.mUpdaterTireRL();
                    break;
                case 101:
                    JhRuiFengS3TireAct.this.mUpdaterTireRR();
                    break;
                case 102:
                    JhRuiFengS3TireAct.this.mUpdaterTempFL();
                    break;
                case 103:
                    JhRuiFengS3TireAct.this.mUpdaterTempFR();
                    break;
                case 104:
                    JhRuiFengS3TireAct.this.mUpdaterTempRL();
                    break;
                case 105:
                    JhRuiFengS3TireAct.this.mUpdaterTempRR();
                    break;
                case 106:
                    JhRuiFengS3TireAct.this.mUpdaterWarnFL();
                    break;
                case 107:
                    JhRuiFengS3TireAct.this.mUpdaterWarnFR();
                    break;
                case 108:
                    JhRuiFengS3TireAct.this.mUpdaterWarnRL();
                    break;
                case 109:
                    JhRuiFengS3TireAct.this.mUpdaterWarnRR();
                    break;
                case 116:
                    if (((CheckBox) JhRuiFengS3TireAct.this.findViewById(R.id.check_setwarning_not_to_show)) != null) {
                        ((CheckBox) JhRuiFengS3TireAct.this.findViewById(R.id.check_setwarning_not_to_show)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };
    private final float VALUE = 0.02745f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_ruifengs3);
        init();
    }

    @Override
    public void init() {
        ((CheckBox) findViewById(R.id.check_setwarning_not_to_show)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = DataCanbus.DATA[116] == 1 ? 0 : 1;
                remoteModuleProxy.cmd(6, iArr, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[102];
        float num = 16777215 & value;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_0)).setText(String.format("%d℃", Integer.valueOf((int) (num - 40.0f))));
    }

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[103];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_1)).setText(String.format("%d℃", Integer.valueOf(num - 40)));
    }

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[104];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_2)).setText(String.format("%d℃", Integer.valueOf(num - 40)));
    }

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[105];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_3)).setText(String.format("%d℃", Integer.valueOf(num - 40)));
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        float num = 16777215 & value;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_0)).setText(String.format("%.1fBar", Float.valueOf(0.02745f * num)));
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_1)).setText(String.format("%.1fBar", Float.valueOf(num * 0.02745f)));
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_2)).setText(String.format("%.1fBar", Float.valueOf(num * 0.02745f)));
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_3)).setText(String.format("%.1fBar", Float.valueOf(num * 0.02745f)));
    }

    
    public void mUpdaterWarnFL() {
        int value = DataCanbus.DATA[106];
        if (value != 0) {
            if (value == 1) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn1);
                return;
            } else if (value == 2) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn2);
                return;
            } else {
                if (value == 3) {
                    ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn3);
                    return;
                }
                return;
            }
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
    }

    
    public void mUpdaterWarnFR() {
        int value = DataCanbus.DATA[107];
        if (value != 0) {
            if (value == 1) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn1);
                return;
            } else if (value == 2) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn2);
                return;
            } else {
                if (value == 3) {
                    ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn3);
                    return;
                }
                return;
            }
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
    }

    
    public void mUpdaterWarnRL() {
        int value = DataCanbus.DATA[108];
        if (value != 0) {
            if (value == 1) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn1);
                return;
            } else if (value == 2) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn2);
                return;
            } else {
                if (value == 3) {
                    ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn3);
                    return;
                }
                return;
            }
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
    }

    
    public void mUpdaterWarnRR() {
        int value = DataCanbus.DATA[109];
        if (value != 0) {
            if (value == 1) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn1);
                return;
            } else if (value == 2) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn2);
                return;
            } else {
                if (value == 3) {
                    ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn3);
                    return;
                }
                return;
            }
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
    }
}
