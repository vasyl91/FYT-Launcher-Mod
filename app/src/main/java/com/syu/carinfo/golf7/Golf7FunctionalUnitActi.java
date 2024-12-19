package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.xp.yinglang.YLFunc;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7FunctionalUnitActi extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 66:
                    Golf7FunctionalUnitActi.this.mUpdaterTemperature();
                    break;
                case 67:
                    Golf7FunctionalUnitActi.this.mUpdaterVolume();
                    break;
                case 68:
                    Golf7FunctionalUnitActi.this.mUpdaterConsumption();
                    break;
                case 69:
                    Golf7FunctionalUnitActi.this.mUpdaterPressure();
                    break;
                case 83:
                    Golf7FunctionalUnitActi.this.mUpdaterDistance();
                    break;
                case 84:
                    Golf7FunctionalUnitActi.this.mUpdaterSpeed();
                    break;
                case 276:
                case 343:
                    Golf7FunctionalUnitActi.this.mUpdaterElectricty();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            setContentView(R.layout.layout_golf7_functional_state_unit_od);
        } else {
            setContentView(R.layout.layout_golf7_functional_state_unit);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            ((Button) findViewById(R.id.glf7_btn_car_back_od)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalUnitActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalUnitActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            this.mPopShowView = getWindow().getDecorView();
            this.mLauStylelist = new ArrayList<>();
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
            ((TextView) findViewById(R.id.lauguage_set_curr)).setVisibility(8);
            ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Golf7FunctionalUnitActi.this.mLauStyle == null) {
                        Golf7FunctionalUnitActi.this.initLauStyle();
                    }
                    if (Golf7FunctionalUnitActi.this.mLauStyle != null && Golf7FunctionalUnitActi.this.mPopShowView != null) {
                        Golf7FunctionalUnitActi.this.mLauStyle.showAtLocation(Golf7FunctionalUnitActi.this.mPopShowView, 17, 0, 0);
                    }
                }
            });
        }
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_distance_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[83] & 255;
                if (ConstGolf.isWcGolf()) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_distance_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[83] & 255;
                if (ConstGolf.isWcGolf()) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_speed_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[84] & 255;
                if (ConstGolf.isWcGolf()) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_speed_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[84] & 255;
                if (ConstGolf.isWcGolf()) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_temperature_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[66] & 255;
                if (ConstGolf.isWcGolf()) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(87, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(87, iArr2, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_temperature_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[66] & 255;
                if (ConstGolf.isWcGolf()) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(87, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(87, iArr2, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_volume_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[67] & 255;
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(88, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(88, new int[1], null, null);
                } else if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(88, new int[]{2}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_volume_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[67] & 255;
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(88, new int[1], null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(88, new int[]{2}, null, null);
                } else if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(88, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_consumption_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[68] & 255;
                if (switchOn == 3) {
                    DataCanbus.PROXY.cmd(89, new int[]{2}, null, null);
                    return;
                }
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(89, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(89, new int[1], null, null);
                } else if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(89, new int[]{3}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_consumption_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[68] & 255;
                if (switchOn == 3) {
                    DataCanbus.PROXY.cmd(89, new int[1], null, null);
                    return;
                }
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(89, new int[]{3}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(89, new int[]{2}, null, null);
                } else if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(89, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_pressure_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[69] & 255;
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(90, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(90, new int[1], null, null);
                } else if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(90, new int[]{2}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_pressure_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[69] & 255;
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(90, new int[1], null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(90, new int[]{2}, null, null);
                } else if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(90, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_consumption_electricity_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[276] & 255;
                if (DataCanbus.DATA[1000] == 655520) {
                    int value2 = DataCanbus.DATA[343] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 150;
                    iArr[1] = value2 == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(146, iArr2, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_consumption_electricity_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[276] & 255;
                if (DataCanbus.DATA[1000] == 655520) {
                    int value2 = DataCanbus.DATA[343] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 150;
                    iArr[1] = value2 == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(146, iArr2, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 655520) {
            DataCanbus.NOTIFY_EVENTS[343].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 655520) {
            DataCanbus.NOTIFY_EVENTS[343].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalUnitActi.18
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Golf7FunctionalUnitActi.this.language_set = position + 1;
                YLFunc.C_CAR_LANGUAGE_SETUP(Golf7FunctionalUnitActi.this.language_set);
                Golf7FunctionalUnitActi.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < 17) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(this.language_set));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(this.language_set, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDistance() {
        int value = DataCanbus.DATA[83];
        if (ConstGolf.isWcGolf()) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_distance)).setText(Golf7Data.mDistanceUnitXp[1]);
                return;
            } else {
                if (value == 1) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_unit_distance)).setText(Golf7Data.mDistanceUnitXp[0]);
                    return;
                }
                return;
            }
        }
        if (value > -1 && value < 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_distance)).setText(Golf7Data.mDistanceUnitXp[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeed() {
        int value = DataCanbus.DATA[84];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_speed), enable != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_speed)).setText(Golf7Data.mSpeedUnitXp[1]);
                return;
            } else {
                if (switchOn == 1) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_unit_speed)).setText(Golf7Data.mSpeedUnitXp[0]);
                    return;
                }
                return;
            }
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_unit_speed), true);
        if (value > -1 && value < 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_speed)).setText(Golf7Data.mSpeedUnitXp[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTemperature() {
        int value = DataCanbus.DATA[66];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_temperature), enable != 0);
            if (switchOn > -1 && switchOn < 2) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_temperature)).setText(Golf7Data.mTempUnit[switchOn]);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_unit_temperature), true);
        if (value > -1 && value < 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_temperature)).setText(Golf7Data.mTempUnitXp[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterVolume() {
        int value = DataCanbus.DATA[67];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_volume), enable != 0);
            if (switchOn > -1 && switchOn < 3) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_volume)).setText(Golf7Data.mVolumeUnit[switchOn]);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_unit_volume), true);
        if (value > -1 && value < 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_volume)).setText(Golf7Data.mVolumeUnitXp[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterConsumption() {
        int value = DataCanbus.DATA[68];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_consumption), enable != 0);
            if (switchOn > -1 && switchOn < 4) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_consumption)).setText(Golf7Data.mOilUnit[switchOn]);
                return;
            }
            return;
        }
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_consumption), true);
            if (value > -1 && value < 4) {
                String[] mOilUnitOD = {"mpg(uk)", "mpg(us)", "L/100km", "km/L"};
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_consumption)).setText(mOilUnitOD[value]);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_unit_consumption), true);
        if (value > -1 && value < 4) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_consumption)).setText(Golf7Data.mOilUnitXp[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterPressure() {
        int value = DataCanbus.DATA[69];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_pressure), enable != 0);
            if (switchOn > -1 && switchOn < 3) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_pressure)).setText(Golf7Data.mPressureUnit[switchOn]);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_unit_pressure), true);
        if (value > -1 && value < 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_pressure)).setText(Golf7Data.mPressureUnitXp[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterElectricty() {
        int value = DataCanbus.DATA[276] & 255;
        int enable = (DataCanbus.DATA[276] & 65280) >> 8;
        if (enable != 0 && DataCanbus.DATA[1000] == 655377) {
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_consumption_electricity), true);
        } else if (DataCanbus.DATA[1000] == 655520) {
            value = DataCanbus.DATA[343] & 255;
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_consumption_electricity), false);
        }
        ((TextView) findViewById(R.id.glf7_tv_functional_unit_consumption_electricity)).setText(Golf7Data.mElectricUnit[value]);
    }
}
