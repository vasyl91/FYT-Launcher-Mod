package com.syu.carinfo.dj.havalh8;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class Dj_0439_HavalH8SetAct extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private final View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            int value;
            switch (v.getId()) {
                case R.id.btn_minus2 /* 2131427458 */:
                    int value2 = DataCanbus.DATA[101] - 1;
                    if (value2 < 0) {
                        value2 = 3;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(0, value2);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int value3 = DataCanbus.DATA[101] + 1;
                    if (value3 > 3) {
                        value3 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(0, value3);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int value4 = DataCanbus.DATA[102] - 1;
                    if (value4 < 0) {
                        value4 = 3;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(1, value4);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int value5 = DataCanbus.DATA[102] + 1;
                    if (value5 > 3) {
                        value5 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(1, value5);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int value6 = DataCanbus.DATA[103] - 1;
                    if (value6 < 0) {
                        value6 = 2;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(2, value6);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int value7 = DataCanbus.DATA[103] + 1;
                    if (value7 > 2) {
                        value7 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(2, value7);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                case R.id.btn_plus5 /* 2131427469 */:
                    int value8 = DataCanbus.DATA[104];
                    if (value8 == 0) {
                        value8 = 1;
                    } else if (value8 == 1) {
                        value8 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(3, value8);
                    break;
                case R.id.btn_minus6 /* 2131427470 */:
                case R.id.btn_plus6 /* 2131427472 */:
                    if (DataCanbus.DATA[106] == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(4, value);
                    break;
                case R.id.btn_minus7 /* 2131427473 */:
                case R.id.btn_plus7 /* 2131427475 */:
                    int value9 = DataCanbus.DATA[108];
                    if (value9 == 1) {
                        value9 = 0;
                    } else if (value9 == 0) {
                        value9 = 1;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(6, value9);
                    break;
                case R.id.btn_minus8 /* 2131427476 */:
                    int value10 = DataCanbus.DATA[109] - 1;
                    if (value10 < 0) {
                        value10 = 3;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(5, value10);
                    break;
                case R.id.btn_plus8 /* 2131427478 */:
                    int value11 = DataCanbus.DATA[109] + 1;
                    if (value11 > 3) {
                        value11 = 0;
                    }
                    Dj_0439_HavalH8SetAct.this.sendCMD(5, value11);
                    break;
                case R.id.btn_minus9 /* 2131427479 */:
                case R.id.btn_plus9 /* 2131427481 */:
                    int value12 = DataCanbus.DATA[110];
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
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    Dj_0439_HavalH8SetAct.this.updateDomeDelay();
                    break;
                case 102:
                    Dj_0439_HavalH8SetAct.this.updateFollowHome();
                    break;
                case 103:
                    Dj_0439_HavalH8SetAct.this.updatePowerSave();
                    break;
                case 104:
                    Dj_0439_HavalH8SetAct.this.updateRainFall();
                    break;
                case 105:
                    Dj_0439_HavalH8SetAct.this.updateRearViewAuto();
                    break;
                case 106:
                    Dj_0439_HavalH8SetAct.this.updateFrontLight();
                    break;
                case 107:
                    Dj_0439_HavalH8SetAct.this.mUpdaterSeatmemory();
                    break;
                case 108:
                    Dj_0439_HavalH8SetAct.this.mUpdaterParkset();
                    break;
                case 109:
                    Dj_0439_HavalH8SetAct.this.mUpdaterAntisheftset();
                    break;
                case 110:
                    Dj_0439_HavalH8SetAct.this.mUpdaterDoorlockset();
                    break;
                case 111:
                    Dj_0439_HavalH8SetAct.this.mUpdaterCetaset();
                    break;
                case 112:
                    Dj_0439_HavalH8SetAct.this.mUpdaterCartopset();
                    break;
                case 113:
                    Dj_0439_HavalH8SetAct.this.mUpdaterAllterrainset();
                    break;
                case 114:
                    Dj_0439_HavalH8SetAct.this.updateScreenBright();
                    break;
                case 115:
                    Dj_0439_HavalH8SetAct.this.mUpdaterValue8();
                    break;
                case 129:
                    Dj_0439_HavalH8SetAct.this.mUpdaterCollisionWarn();
                    break;
                case 130:
                    Dj_0439_HavalH8SetAct.this.mUpdaterAutoBrake();
                    break;
                case 132:
                    int value = DataCanbus.DATA[132];
                    if (Dj_0439_HavalH8SetAct.this.findViewById(R.id.ctv_checkedtext1) != null) {
                        ((CheckedTextView) Dj_0439_HavalH8SetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_dj_havalh9set);
        init();
    }

    
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter(new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick(findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
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
        if (findViewById(R.id.ctv_checkedtext2) != null) {
            findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { 
                @Override
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
        setonClick(findViewById(R.id.btn_minus2));
        setonClick(findViewById(R.id.btn_plus2));
        setonClick(findViewById(R.id.btn_minus3));
        setonClick(findViewById(R.id.btn_plus3));
        setonClick(findViewById(R.id.btn_minus4));
        setonClick(findViewById(R.id.btn_plus4));
        setonClick(findViewById(R.id.btn_minus5));
        setonClick(findViewById(R.id.btn_plus5));
        setonClick(findViewById(R.id.btn_minus6));
        setonClick(findViewById(R.id.btn_plus6));
        setonClick(findViewById(R.id.btn_minus7));
        setonClick(findViewById(R.id.btn_plus7));
        setonClick(findViewById(R.id.btn_minus8));
        setonClick(findViewById(R.id.btn_plus8));
        setonClick(findViewById(R.id.btn_minus9));
        setonClick(findViewById(R.id.btn_plus9));
        if (findViewById(R.id.ctv_checkedtext10) != null) {
            findViewById(R.id.ctv_checkedtext10).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[115] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (findViewById(R.id.ctv_checkedtext1) != null) {
            findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[132] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 14;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (findViewById(R.id.ctv_checkedtext3) != null) {
            findViewById(R.id.ctv_checkedtext3).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[105] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 7;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (findViewById(R.id.ctv_checkedtext4) != null) {
            findViewById(R.id.ctv_checkedtext4).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[107] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (findViewById(R.id.ctv_checkedtext5) != null) {
            findViewById(R.id.ctv_checkedtext5).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[111] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 11;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (findViewById(R.id.ctv_checkedtext6) != null) {
            findViewById(R.id.ctv_checkedtext6).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[112] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 12;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (findViewById(R.id.ctv_checkedtext7) != null) {
            findViewById(R.id.ctv_checkedtext7).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[113] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 13;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (findViewById(R.id.ctv_checkedtext8) != null) {
            findViewById(R.id.ctv_checkedtext8).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[129] & 255;
                }
            });
        }
        if (findViewById(R.id.ctv_checkedtext9) != null) {
            findViewById(R.id.ctv_checkedtext9).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[130] & 255;
                }
            });
        }
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
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
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAutoBrake() {
        int value = DataCanbus.DATA[130];
        if (findViewById(R.id.ctv_checkedtext9) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCollisionWarn() {
        int value = DataCanbus.DATA[129];
        if (findViewById(R.id.ctv_checkedtext8) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterAllterrainset() {
        int value = DataCanbus.DATA[113];
        if (findViewById(R.id.ctv_checkedtext7) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCartopset() {
        int value = DataCanbus.DATA[112];
        if (findViewById(R.id.ctv_checkedtext6) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCetaset() {
        int value = DataCanbus.DATA[111];
        if (findViewById(R.id.ctv_checkedtext5) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterDoorlockset() {
        int value = DataCanbus.DATA[110];
        if (findViewById(R.id.tv_text9) != null) {
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

    
    public void mUpdaterAntisheftset() {
        int value = DataCanbus.DATA[109];
        if (findViewById(R.id.tv_text8) != null) {
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

    
    public void mUpdaterParkset() {
        int value = DataCanbus.DATA[108];
        if (findViewById(R.id.tv_text7) != null) {
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

    
    public void mUpdaterSeatmemory() {
        int value = DataCanbus.DATA[107];
        if (findViewById(R.id.ctv_checkedtext4) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[115] & 255;
        if (findViewById(R.id.ctv_checkedtext10) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
        }
    }

    
    public void updateDomeDelay() {
        String str;
        int domedelay = DataCanbus.DATA[101];
        if (findViewById(R.id.tv_text2) != null) {
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

    
    public void updateFollowHome() {
        String str;
        int followhome = DataCanbus.DATA[102];
        if (findViewById(R.id.tv_text3) != null) {
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

    
    public void updatePowerSave() {
        String str;
        int powersave = DataCanbus.DATA[103];
        if (findViewById(R.id.tv_text4) != null) {
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

    
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[104];
        if (findViewById(R.id.tv_text5) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall1);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall2);
            }
        }
    }

    
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[105];
        if (findViewById(R.id.ctv_checkedtext3) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 0);
        }
    }

    
    public void updateScreenBright() {
        int bright = DataCanbus.DATA[114];
        if (findViewById(R.id.tv_text10) != null) {
            if (bright <= 26) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_244_screenbright);
            } else if (bright >= 255) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.format("%d", Integer.valueOf(bright)));
            }
        }
    }

    
    public void updateFrontLight() {
        int frontlight = DataCanbus.DATA[106];
        if (findViewById(R.id.tv_text6) != null) {
            if (frontlight == 0) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight1);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight2);
            }
        }
    }
}
