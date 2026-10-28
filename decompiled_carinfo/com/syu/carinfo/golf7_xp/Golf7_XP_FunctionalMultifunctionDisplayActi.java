package com.syu.carinfo.golf7_xp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7_XP_FunctionalMultifunctionDisplayActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 153:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterCurConsumption();
                    break;
                case 154:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterAverageConsumption();
                    break;
                case 155:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterConvenience();
                    break;
                case 156:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterEcoTips();
                    break;
                case 157:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterTravellingTime();
                    break;
                case 158:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterDistanceTravelled();
                    break;
                case 159:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterAverageSpeed();
                    break;
                case 160:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterDigitalSpeed();
                    break;
                case 161:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterSpeedWarning();
                    break;
                case 182:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterOil();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_multifunction_display);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_current_consumption), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[153] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 128;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_consumption), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[154] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 129;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_convenience_consumer), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[155] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 130;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_eco_tips), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[156] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 131;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_travelling_time), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[157] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 132;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_distance_travelled), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[158] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 133;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_speed), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[159] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 134;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_digital_speed_display), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[160] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 135;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_speed_warning), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[161] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 136;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_oil_temp), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[182] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 137;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_reset_since_start_drving_data), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7_XP_FunctionalMultifunctionDisplayActi.this.dialog(R.string.reset_long_term_drving_data, 138);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_reset_long_term_drving_data), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7_XP_FunctionalMultifunctionDisplayActi.this.dialog(R.string.reset_long_term_drving_data, 139);
            }
        });
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(stringId)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(107, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCurConsumption() {
        int value = DataCanbus.DATA[153];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_current_consumption), value != 0);
    }

    
    public void mUpdaterAverageConsumption() {
        int value = DataCanbus.DATA[154];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_consumption), value != 0);
    }

    
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[155];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_convenience_consumer), value != 0);
    }

    
    public void mUpdaterEcoTips() {
        int value = DataCanbus.DATA[156];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_eco_tips), value != 0);
    }

    
    public void mUpdaterTravellingTime() {
        int value = DataCanbus.DATA[157];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_travelling_time), value != 0);
    }

    
    public void mUpdaterDistanceTravelled() {
        int value = DataCanbus.DATA[158];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_distance_travelled), value != 0);
    }

    
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[159];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_speed), value != 0);
    }

    
    public void mUpdaterDigitalSpeed() {
        int value = DataCanbus.DATA[160];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_digital_speed_display), value != 0);
    }

    
    public void mUpdaterSpeedWarning() {
        int value = DataCanbus.DATA[161];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_speed_warning), value != 0);
    }

    
    public void mUpdaterOil() {
        int switchOn = DataCanbus.DATA[182] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_oil_temp), switchOn != 0);
    }
}
