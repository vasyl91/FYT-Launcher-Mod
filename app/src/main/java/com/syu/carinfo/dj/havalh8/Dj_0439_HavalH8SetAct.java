package com.syu.carinfo.dj.havalh8;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Dj_0439_HavalH8SetAct extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int value;
            switch (v.getId()) {
                case R.id.btn_minus2 /* 2131427484 */:
                    int value2 = DataCanbus.DATA[34] - 1;
                    if (value2 < 0) {
                        value2 = 3;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(0, value2);
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    int value3 = DataCanbus.DATA[34] + 1;
                    if (value3 > 3) {
                        value3 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(0, value3);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    int value4 = DataCanbus.DATA[35] - 1;
                    if (value4 < 0) {
                        value4 = 3;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(1, value4);
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    int value5 = DataCanbus.DATA[35] + 1;
                    if (value5 > 3) {
                        value5 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(1, value5);
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                    int value6 = DataCanbus.DATA[36] - 1;
                    if (value6 < 0) {
                        value6 = 2;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(2, value6);
                    break;
                case R.id.btn_plus4 /* 2131427494 */:
                    int value7 = DataCanbus.DATA[36] + 1;
                    if (value7 > 2) {
                        value7 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(2, value7);
                    break;
                case R.id.btn_minus5 /* 2131427496 */:
                case R.id.btn_plus5 /* 2131427498 */:
                    int value8 = DataCanbus.DATA[37];
                    if (value8 == 0) {
                        value8 = 1;
                    } else if (value8 == 1) {
                        value8 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(3, value8);
                    break;
                case R.id.btn_minus6 /* 2131427501 */:
                case R.id.btn_plus6 /* 2131427503 */:
                    if (DataCanbus.DATA[39] == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(4, value);
                    break;
                case R.id.btn_minus7 /* 2131427505 */:
                case R.id.btn_plus7 /* 2131427507 */:
                    int value9 = DataCanbus.DATA[41];
                    if (value9 == 1) {
                        value9 = 0;
                    } else if (value9 == 0) {
                        value9 = 1;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(6, value9);
                    break;
                case R.id.btn_minus8 /* 2131427509 */:
                    int value10 = DataCanbus.DATA[42] - 1;
                    if (value10 < 0) {
                        value10 = 3;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(5, value10);
                    break;
                case R.id.btn_plus8 /* 2131427511 */:
                    int value11 = DataCanbus.DATA[42] + 1;
                    if (value11 > 3) {
                        value11 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(5, value11);
                    break;
                case R.id.btn_minus9 /* 2131427513 */:
                case R.id.btn_plus9 /* 2131427515 */:
                    int value12 = DataCanbus.DATA[43];
                    if (value12 == 1) {
                        value12 = 0;
                    } else if (value12 == 0) {
                        value12 = 1;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(8, value12);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 34:
                    Dj_0439_HavalH8SetAct.this.updateDomeDelay();
                    break;
                case 35:
                    Dj_0439_HavalH8SetAct.this.updateFollowHome();
                    break;
                case 36:
                    Dj_0439_HavalH8SetAct.this.updatePowerSave();
                    break;
                case 37:
                    Dj_0439_HavalH8SetAct.this.updateRainFall();
                    break;
                case 38:
                    Dj_0439_HavalH8SetAct.this.updateRearViewAuto();
                    break;
                case 39:
                    Dj_0439_HavalH8SetAct.this.updateFrontLight();
                    break;
                case 40:
                    Dj_0439_HavalH8SetAct.this.mUpdaterSeatmemory();
                    break;
                case 41:
                    Dj_0439_HavalH8SetAct.this.mUpdaterParkset();
                    break;
                case 42:
                    Dj_0439_HavalH8SetAct.this.mUpdaterAntisheftset();
                    break;
                case 43:
                    Dj_0439_HavalH8SetAct.this.mUpdaterDoorlockset();
                    break;
                case 44:
                    Dj_0439_HavalH8SetAct.this.mUpdaterCetaset();
                    break;
                case 45:
                    Dj_0439_HavalH8SetAct.this.mUpdaterCartopset();
                    break;
                case 46:
                    Dj_0439_HavalH8SetAct.this.mUpdaterAllterrainset();
                    break;
                case 47:
                    Dj_0439_HavalH8SetAct.this.updateScreenBright();
                    break;
                case 48:
                    Dj_0439_HavalH8SetAct.this.mUpdaterValue8();
                    break;
                case 69:
                    Dj_0439_HavalH8SetAct.this.mUpdaterCollisionWarn();
                    break;
                case 70:
                    Dj_0439_HavalH8SetAct.this.mUpdaterAutoBrake();
                    break;
                case 72:
                    int value = DataCanbus.DATA[72];
                    if (((CheckedTextView) Dj_0439_HavalH8SetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) Dj_0439_HavalH8SetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_dj_havalh9set);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Dj_0439_HavalH8SetAct.this.language_set = position;
                if (Dj_0439_HavalH8SetAct.this.language_set >= 0 && Dj_0439_HavalH8SetAct.this.language_set <= Dj_0439_HavalH8SetAct.this.mLauStylelist.size() && Dj_0439_HavalH8SetAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{10, Dj_0439_HavalH8SetAct.this.send_lang[Dj_0439_HavalH8SetAct.this.language_set]}, null, null);
                }
                Dj_0439_HavalH8SetAct.this.mLauStyle.dismiss();
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
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Dj_0439_HavalH8SetAct.this.mLauStyle == null) {
                    Dj_0439_HavalH8SetAct.this.initLauStyle();
                }
                if (Dj_0439_HavalH8SetAct.this.mLauStyle != null && Dj_0439_HavalH8SetAct.this.mPopShowView != null) {
                    Dj_0439_HavalH8SetAct.this.mLauStyle.showAtLocation(Dj_0439_HavalH8SetAct.this.mPopShowView, 17, 0, 0);
                    Dj_0439_HavalH8SetAct.this.updateLauguageSet();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_DJ_Haval_H8_H /* 10486199 */:
            case FinalCanbus.CAR_439_DJ_Haval_H9_H /* 15860164 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.5
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Dj_0439_HavalH8SetAct.this, Dj_0439_HavalH8AmpSetAct.class);
                        Dj_0439_HavalH8SetAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus7));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((Button) findViewById(R.id.btn_minus8));
        setonClick((Button) findViewById(R.id.btn_plus8));
        setonClick((Button) findViewById(R.id.btn_minus9));
        setonClick((Button) findViewById(R.id.btn_plus9));
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.6
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
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.7
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[72] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 14;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.8
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[38] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 7;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.9
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[40] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.10
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[44] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 11;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.11
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[45] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 12;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.12
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[46] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 13;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.13
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[69] & 255;
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8SetAct.14
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[70] & 255;
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
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoBrake() {
        int value = DataCanbus.DATA[70];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCollisionWarn() {
        int value = DataCanbus.DATA[69];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAllterrainset() {
        int value = DataCanbus.DATA[46];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCartopset() {
        int value = DataCanbus.DATA[45];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCetaset() {
        int value = DataCanbus.DATA[44];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoorlockset() {
        int value = DataCanbus.DATA[43];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockall_set);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockdriver_set);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockall_set);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAntisheftset() {
        int value = DataCanbus.DATA[42];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("10min");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("20min");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText("30min");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.off);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterParkset() {
        int value = DataCanbus.DATA[41];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatmemory() {
        int value = DataCanbus.DATA[40];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[48] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDomeDelay() {
        String str;
        int domedelay = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (DataCanbus.DATA[1000] == 10420663 || DataCanbus.DATA[1000] == 10486199 || DataCanbus.DATA[1000] == 15794628 || DataCanbus.DATA[1000] == 15860164) {
                switch (domedelay) {
                    case 0:
                        str = "10s";
                        break;
                    case 1:
                        str = "30s";
                        break;
                    case 2:
                        str = "60s";
                        break;
                    case 3:
                        str = "180s";
                        break;
                    default:
                        str = "10s";
                        break;
                }
            } else {
                switch (domedelay) {
                    case 0:
                        str = "3s";
                        break;
                    case 1:
                        str = "10s";
                        break;
                    case 2:
                        str = "20s";
                        break;
                    case 3:
                        str = "30s";
                        break;
                    default:
                        str = "3s";
                        break;
                }
            }
            ((TextView) findViewById(R.id.tv_text2)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFollowHome() {
        String str;
        int followhome = DataCanbus.DATA[35];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (followhome) {
                case 0:
                    str = "30s";
                    break;
                case 1:
                    str = "1min";
                    break;
                case 2:
                    str = "2min";
                    break;
                case 3:
                    str = "3min";
                    break;
                default:
                    str = "30s";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text3)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePowerSave() {
        String str;
        int powersave = DataCanbus.DATA[36];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (powersave) {
                case 0:
                    str = "10min";
                    break;
                case 1:
                    str = "20min";
                    break;
                case 2:
                    str = "30min";
                    break;
                default:
                    str = "10min";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text4)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall1);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[38];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScreenBright() {
        int bright = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (bright <= 26) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_244_screenbright);
            } else if (bright >= 255) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.format("%d", Integer.valueOf(bright)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrontLight() {
        int frontlight = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (frontlight == 0) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight1);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight2);
            }
        }
    }
}
