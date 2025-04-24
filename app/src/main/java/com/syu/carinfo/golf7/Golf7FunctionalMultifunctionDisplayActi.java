package com.syu.carinfo.golf7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalMultifunctionDisplayActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 153:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterCurConsumption();
                    break;
                case 154:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterAverageConsumption();
                    break;
                case 155:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterConvenience();
                    break;
                case 156:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterEcoTips();
                    break;
                case 157:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterTravellingTime();
                    break;
                case 158:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterDistanceTravelled();
                    break;
                case 159:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterAverageSpeed();
                    break;
                case 160:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterDigitalSpeed();
                    break;
                case 161:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterSpeedWarning();
                    break;
                case 182:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterOil();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            //setContentView(R.layout.layout_golf7_functional_state_multifunction_display_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_state_multifunction_display);
        }
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalMultifunctionDisplayActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalMultifunctionDisplayActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_current_consumption), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[153] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(75, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_consumption), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[154] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(76, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_convenience_consumer), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[155] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(77, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_eco_tips), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[156] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(78, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_travelling_time), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[157] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(79, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_distance_travelled), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[158] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(80, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_speed), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[159] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(81, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_digital_speed_display), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[160] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(82, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_speed_warning), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[161] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(83, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_oil_temp), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[182] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_reset_since_start_drving_data), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalMultifunctionDisplayActi.this.dialog(R.string.reset_long_term_drving_data, 84);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_reset_long_term_drving_data), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalMultifunctionDisplayActi.this.dialog(R.string.reset_long_term_drving_data, 85);
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
                        DataCanbus.PROXY.cmd(i, new int[]{1}, null, null);
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
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible((Button) findViewById(R.id.glf7_btn_car_back_od), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_current_consumption), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_btn_car_back_od), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_current_consumption), value != 0);
    }

    
    public void mUpdaterAverageConsumption() {
        int value = DataCanbus.DATA[154];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_average_consumption), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_consumption), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_average_consumption), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_consumption), value != 0);
    }

    
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[155];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_convenience_consumer), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_convenience_consumer), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_convenience_consumer), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_convenience_consumer), value != 0);
    }

    
    public void mUpdaterEcoTips() {
        int value = DataCanbus.DATA[156];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_eco_tips), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_eco_tips), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_eco_tips), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_eco_tips), value != 0);
    }

    
    public void mUpdaterTravellingTime() {
        int value = DataCanbus.DATA[157];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_travelling_time), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_travelling_time), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_travelling_time), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_travelling_time), value != 0);
    }

    
    public void mUpdaterDistanceTravelled() {
        int value = DataCanbus.DATA[158];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_distance_travelled), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_distance_travelled), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_distance_travelled), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_distance_travelled), value != 0);
    }

    
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[159];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_average_speed), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_speed), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_average_speed), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_average_speed), value != 0);
    }

    
    public void mUpdaterDigitalSpeed() {
        int value = DataCanbus.DATA[160];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_digital_speed_display), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_digital_speed_display), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_digital_speed_display), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_digital_speed_display), value != 0);
    }

    
    public void mUpdaterSpeedWarning() {
        int value = DataCanbus.DATA[161];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_speed_warning), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_speed_warning), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_speed_warning), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_speed_warning), value != 0);
    }

    
    public void mUpdaterOil() {
        int value = DataCanbus.DATA[182];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_oil_temp), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_multifunction_oil_temp), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_multifunction_oil_temp), switchOn != 0);
    }
}
