package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalParkingAndManoeurvrinActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterActivateAutomaticlly();
                    break;
                case 117:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontVolumn();
                    break;
                case 118:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontTone();
                    break;
                case 119:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearVol();
                    break;
                case 120:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearTone();
                    break;
                case 121:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterParkMode();
                    break;
                case 122:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterRadarVol();
                    break;
                case 216:
                case 327:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateActivateMaticlly();
                    break;
                case 244:
                case 329:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateOutOfParkingAssist();
                    break;
                case 250:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateOffRoadIcon();
                    break;
                case 276:
                case 328:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateParkingBrake();
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
            //setContentView(R.layout.layout_golf7_functional_state_parking_and_manoeurvring_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_state_parking_and_manoeurvring);
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
                        intent.setClass(Golf7FunctionalParkingAndManoeurvrinActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalParkingAndManoeurvrinActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_automaticlly), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[116] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(39, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_maticlly), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[216] & 255;
                if (ConstGolf.isRZCGolf()) {
                    int switchOn2 = DataCanbus.DATA[327] & 255;
                    return;
                }
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(109, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_volumn_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[117] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_volumn_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[117] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(40, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_tone_setting_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[118] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_tone_setting_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[118] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(41, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_volumn_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[119] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(42, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_volumn_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[119] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(42, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_tone_setting_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[120] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(43, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_tone_setting_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[120] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(43, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_parking_mode_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[121] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue == 1 ? 0 : 1;
                remoteModuleProxy.cmd(44, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_parking_mode_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[121] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue == 1 ? 0 : 1;
                remoteModuleProxy.cmd(44, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[122] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue != 0 ? 0 : 1;
                remoteModuleProxy.cmd(30, iArr, null, null);
            }
        });
        if ((DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) && findViewById(R.id.layout_17_out_of_park_assist) != null) {
            findViewById(R.id.layout_17_out_of_park_assist).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_out_of_park_assist), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[244] & 255;
                if (ConstGolf.isRZCGolf()) {
                    int mValue2 = DataCanbus.DATA[329];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 59;
                    iArr[1] = mValue2 == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = mValue != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(110, iArr2, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_parking_brake), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[276] & 255;
                if (ConstGolf.isRZCGolf()) {
                    int mValue2 = DataCanbus.DATA[328];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 58;
                    iArr[1] = mValue2 == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = mValue != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(132, iArr2, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_off_road_icon), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[250] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue != 0 ? 0 : 1;
                remoteModuleProxy.cmd(111, iArr, null, null);
            }
        });
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[327].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[328].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[329].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[330].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[327].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[328].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[329].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[330].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void mUpdaterActivateAutomaticlly() {
        int value = DataCanbus.DATA[116];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_activate_automaticlly), enable != 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_automaticlly)).setChecked(switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_activate_automaticlly), true);
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_automaticlly)).setChecked(value != 0);
    }

    
    public void updateActivateMaticlly() {
        int value = DataCanbus.DATA[116];
        if (ConstGolf.isRZCGolf()) {
            value = DataCanbus.DATA[327];
        }
        if (DataCanbus.DATA[1000] == 437 || ConstGolf.isRZCGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_activate_maticlly), true);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_maticlly)).setChecked(value != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_activate_maticlly), false);
        }
    }

    public void updateOutOfParkingAssist() {
        int value = DataCanbus.DATA[244];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), false);
            } else {
                setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), enable != 0);
            }
            ((CheckedTextView) findViewById(R.id.ctv_17_out_of_park_assist)).setChecked(switchOn != 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 393256) {
            int i = (65280 & value) >> 8;
            int switchOn2 = value & 255;
            setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), true);
            ((CheckedTextView) findViewById(R.id.ctv_17_out_of_park_assist)).setChecked(switchOn2 != 0);
            return;
        }
        if (ConstGolf.isRZCGolf()) {
            int switchOn3 = DataCanbus.DATA[329] & 255;
            setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), true);
            ((CheckedTextView) findViewById(R.id.ctv_17_out_of_park_assist)).setChecked(switchOn3 != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), false);
    }

    public void updateOffRoadIcon() {
        int value = DataCanbus.DATA[250];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_off_road_icon), enable != 0);
            ((CheckedTextView) findViewById(R.id.ctv_17_off_road_icon)).setChecked(switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_off_road_icon), false);
    }

    public void updateParkingBrake() {
        int value = DataCanbus.DATA[276];
        if (ConstGolf.isWcGolf()) {
            int enable = (value & 65280) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_parking_brake), enable != 0);
            ((CheckedTextView) findViewById(R.id.ctv_17_parking_brake)).setChecked(switchOn != 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 393256) {
            int i = (value & 65280) >> 8;
            int switchOn2 = value & 255;
            setViewVisible(findViewById(R.id.layout_17_parking_brake), true);
            ((CheckedTextView) findViewById(R.id.ctv_17_parking_brake)).setChecked(switchOn2 != 0);
            return;
        }
        if (ConstGolf.isRZCGolf()) {
            int switchOn3 = DataCanbus.DATA[328] & 255;
            setViewVisible(findViewById(R.id.layout_17_parking_brake), true);
            ((CheckedTextView) findViewById(R.id.ctv_17_parking_brake)).setChecked(switchOn3 != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_parking_brake), false);
    }

    
    public void mUpdaterFrontVolumn() {
        int value = DataCanbus.DATA[117];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_front_volumn), enable != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_volumn)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_front_volumn), true);
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_volumn)).setText(new StringBuilder().append(value + 1).toString());
    }

    
    public void mUpdaterFrontTone() {
        int value = DataCanbus.DATA[118];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_front_tone_setting), enable != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_tone_setting)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_front_tone_setting), true);
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_tone_setting)).setText(new StringBuilder().append(value + 1).toString());
    }

    
    public void mUpdaterRearVol() {
        int value = DataCanbus.DATA[119];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_Rear_volumn), enable != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_volumn)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_Rear_volumn), true);
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_volumn)).setText(new StringBuilder().append(value + 1).toString());
    }

    
    public void mUpdaterRearTone() {
        int value = DataCanbus.DATA[120];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_Rear_tone_setting), enable != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_tone_setting)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_Rear_tone_setting), true);
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_tone_setting)).setText(new StringBuilder().append(value + 1).toString());
    }

    
    public void mUpdaterParkMode() {
        int value = DataCanbus.DATA[121];
        int enable = (65280 & value) >> 8;
        int mValue = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_parking_mode), enable != 0);
            if (mValue == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_parking_mode)).setText(R.string.storage_parking);
                return;
            } else if (mValue == 2) {
                ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_parking_mode)).setText(R.string.side_parking);
                return;
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_parking_mode)).setText("");
                return;
            }
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_parking_mode), false);
    }

    
    public void mUpdaterRadarVol() {
        int value = DataCanbus.DATA[122];
        int enable = (65280 & value) >> 8;
        int mValue = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_radar_volumn), enable != 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn)).setChecked(mValue != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_radar_volumn), true);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn)).setChecked(mValue != 0);
        }
    }
}
