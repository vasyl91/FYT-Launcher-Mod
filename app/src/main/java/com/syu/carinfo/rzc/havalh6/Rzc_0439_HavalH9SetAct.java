package com.syu.carinfo.rzc.havalh6;

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
import com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8AmpSetAct;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_0439_HavalH9SetAct extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int value;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427480 */:
                    int value2 = DataCanbus.DATA[85] - 1;
                    if (value2 < 1) {
                        value2 = 10;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(26, value2);
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    int value3 = DataCanbus.DATA[85] + 1;
                    if (value3 > 10) {
                        value3 = 1;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(26, value3);
                    break;
                case R.id.rzc_havalh6_domedelay_m /* 2131427620 */:
                    int value4 = DataCanbus.DATA[34] - 1;
                    if (value4 < 1) {
                        value4 = 4;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(4, value4);
                    break;
                case R.id.rzc_havalh6_domedelay_p /* 2131427622 */:
                    int value5 = DataCanbus.DATA[34] + 1;
                    if (value5 > 4) {
                        value5 = 1;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(4, value5);
                    break;
                case R.id.rzc_havalh6_followhome_m /* 2131427623 */:
                    int value6 = DataCanbus.DATA[35] - 1;
                    if (value6 < 1) {
                        value6 = 4;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(5, value6);
                    break;
                case R.id.rzc_havalh6_followhome_p /* 2131427625 */:
                    int value7 = DataCanbus.DATA[35] + 1;
                    if (value7 > 4) {
                        value7 = 1;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(5, value7);
                    break;
                case R.id.rzc_havalh6_powersave_m /* 2131427626 */:
                    int value8 = DataCanbus.DATA[36] - 1;
                    if (value8 < 1) {
                        value8 = 3;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(6, value8);
                    break;
                case R.id.rzc_havalh6_powersave_p /* 2131427628 */:
                    int value9 = DataCanbus.DATA[36] + 1;
                    if (value9 > 3) {
                        value9 = 1;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(6, value9);
                    break;
                case R.id.rzc_havalh6_rainfall_m /* 2131427629 */:
                case R.id.rzc_havalh6_rainfall_p /* 2131427631 */:
                    int value10 = DataCanbus.DATA[37];
                    if (value10 == 1) {
                        value10 = 1;
                    } else if (value10 == 0) {
                        value10 = 2;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(7, value10);
                    break;
                case R.id.rzc_oudi_havalh9_frontlight_m /* 2131428410 */:
                case R.id.rzc_oudi_havalh9_frontlight_p /* 2131428412 */:
                    if (DataCanbus.DATA[39] == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(12, value);
                    break;
                case R.id.btn_od_havalh9_park_set_m /* 2131428413 */:
                case R.id.btn_od_havalh9_park_set_p /* 2131428415 */:
                    int value11 = DataCanbus.DATA[41];
                    if (value11 == 1) {
                        value11 = 0;
                    } else if (value11 == 0) {
                        value11 = 1;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(15, value11);
                    break;
                case R.id.btn_od_havalh9_antitheft_set_m /* 2131428416 */:
                    int value12 = DataCanbus.DATA[42] - 1;
                    if (value12 < 0) {
                        value12 = 3;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(14, value12);
                    break;
                case R.id.btn_od_havalh9_antitheft_set_p /* 2131428418 */:
                    int value13 = DataCanbus.DATA[42] + 1;
                    if (value13 > 3) {
                        value13 = 0;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(14, value13);
                    break;
                case R.id.btn_od_havalh9_doorlock_set_m /* 2131428419 */:
                case R.id.btn_od_havalh9_doorlock_set_p /* 2131428421 */:
                    int value14 = DataCanbus.DATA[43];
                    if (value14 == 1) {
                        value14 = 0;
                    } else if (value14 == 0) {
                        value14 = 1;
                    }
                    Rzc_0439_HavalH9SetAct.this.sendCMD(16, value14);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 34:
                    Rzc_0439_HavalH9SetAct.this.updateDomeDelay();
                    break;
                case 35:
                    Rzc_0439_HavalH9SetAct.this.updateFollowHome();
                    break;
                case 36:
                    Rzc_0439_HavalH9SetAct.this.updatePowerSave();
                    break;
                case 37:
                    Rzc_0439_HavalH9SetAct.this.updateRainFall();
                    break;
                case 38:
                    Rzc_0439_HavalH9SetAct.this.updateRearViewAuto();
                    break;
                case 39:
                    Rzc_0439_HavalH9SetAct.this.updateFrontLight();
                    break;
                case 40:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterSeatmemory();
                    break;
                case 41:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterParkset();
                    break;
                case 42:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterAntisheftset();
                    break;
                case 43:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterDoorlockset();
                    break;
                case 44:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterCetaset();
                    break;
                case 45:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterCartopset();
                    break;
                case 46:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterAllterrainset();
                    break;
                case 47:
                    Rzc_0439_HavalH9SetAct.this.updateScreenBright();
                    break;
                case 48:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterValue8();
                    break;
                case 69:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterCollisionWarn();
                    break;
                case 70:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterAutoBrake();
                    break;
                case 85:
                    if (((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_havalh9set);
        init();
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
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Rzc_0439_HavalH9SetAct.this.language_set = position;
                if (Rzc_0439_HavalH9SetAct.this.language_set >= 0 && Rzc_0439_HavalH9SetAct.this.language_set <= Rzc_0439_HavalH9SetAct.this.mLauStylelist.size() && Rzc_0439_HavalH9SetAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{25, Rzc_0439_HavalH9SetAct.this.send_lang[Rzc_0439_HavalH9SetAct.this.language_set]}, null, null);
                }
                Rzc_0439_HavalH9SetAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Rzc_0439_HavalH9SetAct.this.mLauStyle == null) {
                    Rzc_0439_HavalH9SetAct.this.initLauStyle();
                }
                if (Rzc_0439_HavalH9SetAct.this.mLauStyle != null && Rzc_0439_HavalH9SetAct.this.mPopShowView != null) {
                    Rzc_0439_HavalH9SetAct.this.mLauStyle.showAtLocation(Rzc_0439_HavalH9SetAct.this.mPopShowView, 17, 0, 0);
                    Rzc_0439_HavalH9SetAct.this.updateLauguageSet();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.5
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Rzc_0439_HavalH9SetAct.this, Dj_0439_HavalH8AmpSetAct.class);
                        Rzc_0439_HavalH9SetAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setonClick((Button) findViewById(R.id.rzc_havalh6_domedelay_m));
        setonClick((Button) findViewById(R.id.rzc_havalh6_domedelay_p));
        setonClick((Button) findViewById(R.id.rzc_havalh6_followhome_m));
        setonClick((Button) findViewById(R.id.rzc_havalh6_followhome_p));
        setonClick((Button) findViewById(R.id.rzc_havalh6_powersave_m));
        setonClick((Button) findViewById(R.id.rzc_havalh6_powersave_p));
        setonClick((Button) findViewById(R.id.rzc_havalh6_rainfall_m));
        setonClick((Button) findViewById(R.id.rzc_havalh6_rainfall_p));
        setonClick((Button) findViewById(R.id.rzc_oudi_havalh9_frontlight_m));
        setonClick((Button) findViewById(R.id.rzc_oudi_havalh9_frontlight_p));
        setonClick((Button) findViewById(R.id.btn_od_havalh9_park_set_m));
        setonClick((Button) findViewById(R.id.btn_od_havalh9_park_set_p));
        setonClick((Button) findViewById(R.id.btn_od_havalh9_antitheft_set_m));
        setonClick((Button) findViewById(R.id.btn_od_havalh9_antitheft_set_p));
        setonClick((Button) findViewById(R.id.btn_od_havalh9_doorlock_set_m));
        setonClick((Button) findViewById(R.id.btn_od_havalh9_doorlock_set_p));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.6
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[48] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_rearview_auto)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_rearview_auto)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.7
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[38] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_seat_memory)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_seat_memory)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.8
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[40] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 13;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_ceta_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_ceta_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.9
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[44] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 17;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_cartop_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_cartop_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.10
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[45] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 18;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_allterrain_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_allterrain_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.11
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[46] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 19;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_collision_warn_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_collision_warn_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.12
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[69] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 23;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_autobrake_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_autobrake_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.13
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[70] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 24;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoBrake() {
        int value = DataCanbus.DATA[70];
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_autobrake_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_autobrake_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCollisionWarn() {
        int value = DataCanbus.DATA[69];
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_collision_warn_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_collision_warn_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAllterrainset() {
        int value = DataCanbus.DATA[46];
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_allterrain_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_allterrain_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCartopset() {
        int value = DataCanbus.DATA[45];
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_cartop_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_cartop_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCetaset() {
        int value = DataCanbus.DATA[44];
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_ceta_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_ceta_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoorlockset() {
        int value = DataCanbus.DATA[43];
        if (((TextView) findViewById(R.id.tx_od_havalh9_doorlock_set)) != null) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    switch (value) {
                        case 0:
                            ((TextView) findViewById(R.id.tx_od_havalh9_doorlock_set)).setText(R.string.str_unlockdriver_set);
                            break;
                        case 1:
                            ((TextView) findViewById(R.id.tx_od_havalh9_doorlock_set)).setText(R.string.str_unlockall_set);
                            break;
                        default:
                            ((TextView) findViewById(R.id.tx_od_havalh9_doorlock_set)).setText(R.string.str_unlockdriver_set);
                            break;
                    }
                default:
                    switch (value) {
                        case 0:
                            ((TextView) findViewById(R.id.tx_od_havalh9_doorlock_set)).setText(R.string.str_unlockall_set);
                            break;
                        case 1:
                            ((TextView) findViewById(R.id.tx_od_havalh9_doorlock_set)).setText(R.string.str_unlockdriver_set);
                            break;
                        default:
                            ((TextView) findViewById(R.id.tx_od_havalh9_doorlock_set)).setText(R.string.str_unlockall_set);
                            break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAntisheftset() {
        int value = DataCanbus.DATA[42];
        if (((TextView) findViewById(R.id.tx_od_havalh9_antitheft_set)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tx_od_havalh9_antitheft_set)).setText(R.string.crv_source_null);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tx_od_havalh9_antitheft_set)).setText("10min");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tx_od_havalh9_antitheft_set)).setText("20min");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tx_od_havalh9_antitheft_set)).setText("30min");
                    break;
                default:
                    ((TextView) findViewById(R.id.tx_od_havalh9_antitheft_set)).setText(R.string.crv_source_null);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterParkset() {
        int value = DataCanbus.DATA[41];
        if (((TextView) findViewById(R.id.tx_od_havalh9_park_set)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tx_od_havalh9_park_set)).setText(R.string.klc_air_Manual);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tx_od_havalh9_park_set)).setText(R.string.klc_air_auto);
                    break;
                default:
                    ((TextView) findViewById(R.id.tx_od_havalh9_park_set)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatmemory() {
        int value = DataCanbus.DATA[40];
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_seat_memory)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_seat_memory)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[48] & 255;
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDomeDelay() {
        String str;
        int domedelay = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.rzc_havalh6_domedelay_text)) != null) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    switch (domedelay) {
                        case 1:
                            str = "10s";
                            break;
                        case 2:
                            str = "30s";
                            break;
                        case 3:
                            str = "1min";
                            break;
                        case 4:
                            str = "3min";
                            break;
                        default:
                            str = "10s";
                            break;
                    }
                default:
                    switch (domedelay) {
                        case 1:
                            str = "3s";
                            break;
                        case 2:
                            str = "10s";
                            break;
                        case 3:
                            str = "20s";
                            break;
                        case 4:
                            str = "30s";
                            break;
                        default:
                            str = "3s";
                            break;
                    }
            }
            ((TextView) findViewById(R.id.rzc_havalh6_domedelay_text)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFollowHome() {
        String str;
        int followhome = DataCanbus.DATA[35];
        if (((TextView) findViewById(R.id.rzc_havalh6_followhome_text)) != null) {
            switch (followhome) {
                case 1:
                    str = "30s";
                    break;
                case 2:
                    str = "1min";
                    break;
                case 3:
                    str = "2min";
                    break;
                case 4:
                    str = "3min";
                    break;
                default:
                    str = "30s";
                    break;
            }
            ((TextView) findViewById(R.id.rzc_havalh6_followhome_text)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePowerSave() {
        String str;
        int powersave = DataCanbus.DATA[36];
        if (((TextView) findViewById(R.id.rzc_havalh6_powersave_text)) != null) {
            switch (powersave) {
                case 1:
                    str = "10min";
                    break;
                case 2:
                    str = "20min";
                    break;
                case 3:
                    str = "30min";
                    break;
                default:
                    str = "10min";
                    break;
            }
            ((TextView) findViewById(R.id.rzc_havalh6_powersave_text)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.rzc_havalh6_rainfall_text)) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.rzc_havalh6_rainfall_text)).setText(R.string.str_244_rainfall2);
            } else {
                ((TextView) findViewById(R.id.rzc_havalh6_rainfall_text)).setText(R.string.str_244_rainfall1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[38];
        if (((CheckedTextView) findViewById(R.id.ctv_od_havalh9_rearview_auto)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_od_havalh9_rearview_auto)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScreenBright() {
        int bright = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)) != null) {
            if (bright <= 26) {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_244_screenbright);
            } else if (bright >= 255) {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(String.format("%d", Integer.valueOf(bright)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrontLight() {
        int frontlight = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.rzc_oudi_havalh9_frontlight_text)) != null) {
            if (frontlight == 1) {
                ((TextView) findViewById(R.id.rzc_oudi_havalh9_frontlight_text)).setText(R.string.str_244_frontlight1);
            } else {
                ((TextView) findViewById(R.id.rzc_oudi_havalh9_frontlight_text)).setText(R.string.str_244_frontlight2);
            }
        }
    }
}
