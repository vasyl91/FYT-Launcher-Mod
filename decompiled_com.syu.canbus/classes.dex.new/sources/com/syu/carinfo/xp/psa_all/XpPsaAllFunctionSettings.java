package com.syu.carinfo.xp.psa_all;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XpPsaAllFunctionSettings extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus7 /* 2131427474 */:
                case R.id.btn_plus7 /* 2131427476 */:
                    XpPsaAllFunctionSettings.this.sendCMD(22, DataCanbus.DATA[176] != 1 ? 1 : 0);
                    break;
                case R.id.btn_minus8 /* 2131427477 */:
                    int val = DataCanbus.DATA[118];
                    XpPsaAllFunctionSettings.this.sendCMD(18, val == 0 ? 3 : val - 1);
                    break;
                case R.id.btn_plus8 /* 2131427479 */:
                    XpPsaAllFunctionSettings.this.sendCMD(18, (DataCanbus.DATA[118] + 1) % 4);
                    break;
                case R.id.btn_minus10 /* 2131427483 */:
                    int val2 = DataCanbus.DATA[222] - 1;
                    if (val2 < 0) {
                        val2 = 2;
                    }
                    XpPsaAllFunctionSettings.this.sendCMD(28, val2);
                    break;
                case R.id.btn_plus10 /* 2131427485 */:
                    int val3 = DataCanbus.DATA[222] + 1;
                    if (val3 > 2) {
                        val3 = 0;
                    }
                    XpPsaAllFunctionSettings.this.sendCMD(28, val3);
                    break;
                case R.id.ctv_checkedtext10 /* 2131427635 */:
                    XpPsaAllFunctionSettings.this.sendCMD(20, DataCanbus.DATA[170] != 1 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext11 /* 2131427636 */:
                    XpPsaAllFunctionSettings.this.sendCMD(21, DataCanbus.DATA[169] != 1 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext12 /* 2131427637 */:
                    XpPsaAllFunctionSettings.this.sendCMD(3, DataCanbus.DATA[168] != 1 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext13 /* 2131427638 */:
                    XpPsaAllFunctionSettings.this.sendCMD(24, DataCanbus.DATA[218] != 1 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext14 /* 2131427639 */:
                    XpPsaAllFunctionSettings.this.sendCMD(25, DataCanbus.DATA[219] != 1 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext15 /* 2131427640 */:
                    XpPsaAllFunctionSettings.this.sendCMD(26, DataCanbus.DATA[220] != 1 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext16 /* 2131427641 */:
                    XpPsaAllFunctionSettings.this.sendCMD(27, DataCanbus.DATA[221] != 1 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext17 /* 2131427642 */:
                    XpPsaAllFunctionSettings.this.sendCMD(29, DataCanbus.DATA[223] != 1 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext18 /* 2131427764 */:
                    XpPsaAllFunctionSettings.this.sendCMD(30, DataCanbus.DATA[224] != 1 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext19 /* 2131427766 */:
                    XpPsaAllFunctionSettings.this.sendCMD(31, DataCanbus.DATA[225] != 1 ? 1 : 0);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 37:
                    if (((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text1)) != null) {
                        if (DataCanbus.DATA[updateCode] == 1) {
                            ((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text1)).setText("℉");
                        } else {
                            ((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text1)).setText("℃");
                        }
                    }
                    break;
                case 107:
                case 159:
                    XpPsaAllFunctionSettings.this.mUpdaterValue2();
                    break;
                case 108:
                    XpPsaAllFunctionSettings.this.mUpdaterValue1();
                    break;
                case 110:
                case 157:
                    XpPsaAllFunctionSettings.this.mUpdaterValue4();
                    break;
                case 111:
                case 162:
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    break;
                case 112:
                case 155:
                    XpPsaAllFunctionSettings.this.mUpdaterValue5();
                    break;
                case 113:
                case 158:
                    XpPsaAllFunctionSettings.this.mUpdaterValue3();
                    break;
                case 118:
                    XpPsaAllFunctionSettings.this.uBigDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 119:
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    break;
                case 129:
                case 161:
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    break;
                case 131:
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    break;
                case 151:
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    break;
                case 152:
                    XpPsaAllFunctionSettings.this.mUpdaterValue6();
                    break;
                case 153:
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    break;
                case 156:
                case 177:
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    break;
                case 168:
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 169:
                    XpPsaAllFunctionSettings.this.uPilao(DataCanbus.DATA[updateCode]);
                    break;
                case 170:
                    XpPsaAllFunctionSettings.this.uPull(DataCanbus.DATA[updateCode]);
                    break;
                case 176:
                    XpPsaAllFunctionSettings.this.uTheme(DataCanbus.DATA[updateCode]);
                    break;
                case 215:
                    XpPsaAllFunctionSettings.this.updateLauguageSet();
                    break;
                case 218:
                    ((CheckedTextView) XpPsaAllFunctionSettings.this.findViewById(R.id.ctv_checkedtext13)).setChecked(DataCanbus.DATA[updateCode] != 0);
                    break;
                case 219:
                    ((CheckedTextView) XpPsaAllFunctionSettings.this.findViewById(R.id.ctv_checkedtext14)).setChecked(DataCanbus.DATA[updateCode] != 0);
                    break;
                case 220:
                    ((CheckedTextView) XpPsaAllFunctionSettings.this.findViewById(R.id.ctv_checkedtext15)).setChecked(DataCanbus.DATA[updateCode] != 0);
                    break;
                case 221:
                    ((CheckedTextView) XpPsaAllFunctionSettings.this.findViewById(R.id.ctv_checkedtext16)).setChecked(DataCanbus.DATA[updateCode] != 0);
                    break;
                case 222:
                    if (((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text12)) != null) {
                        if (DataCanbus.DATA[updateCode] == 1) {
                            ((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text12)).setText("Normal");
                        } else if (DataCanbus.DATA[updateCode] == 2) {
                            ((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text12)).setText("Distant");
                        } else {
                            ((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text12)).setText("Close");
                        }
                    }
                    break;
                case 223:
                    ((CheckedTextView) XpPsaAllFunctionSettings.this.findViewById(R.id.ctv_checkedtext17)).setChecked(DataCanbus.DATA[updateCode] != 0);
                    break;
                case 224:
                    ((CheckedTextView) XpPsaAllFunctionSettings.this.findViewById(R.id.ctv_checkedtext18)).setChecked(DataCanbus.DATA[updateCode] != 0);
                    break;
                case 225:
                    ((CheckedTextView) XpPsaAllFunctionSettings.this.findViewById(R.id.ctv_checkedtext19)).setChecked(DataCanbus.DATA[updateCode] != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_psa_all_func_set);
        registerListener();
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                XpPsaAllFunctionSettings.this.language_set = position;
                if (XpPsaAllFunctionSettings.this.language_set >= 0 && XpPsaAllFunctionSettings.this.language_set <= XpPsaAllFunctionSettings.this.mLauStylelist.size() && XpPsaAllFunctionSettings.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(67, new int[]{11, XpPsaAllFunctionSettings.this.send_lang[XpPsaAllFunctionSettings.this.language_set]}, null, null);
                }
                XpPsaAllFunctionSettings.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[215];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size()) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    public void registerListener() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (XpPsaAllFunctionSettings.this.mLauStyle == null) {
                    XpPsaAllFunctionSettings.this.initLauStyle();
                }
                if (XpPsaAllFunctionSettings.this.mLauStyle != null && XpPsaAllFunctionSettings.this.mPopShowView != null) {
                    XpPsaAllFunctionSettings.this.mLauStyle.showAtLocation(XpPsaAllFunctionSettings.this.mPopShowView, 17, 0, 0);
                    XpPsaAllFunctionSettings.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[107];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(4, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[153];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(47, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[129];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(15, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XpPsaAllFunctionSettings.this.dialog();
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[151];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(20, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[177];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[37] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(66, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[37] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(66, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[152] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(52, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[152] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(52, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[131];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(51, new int[]{2}, null, null);
                } else if (value == 0) {
                    DataCanbus.PROXY.cmd(51, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(51, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[131];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(51, new int[]{2}, null, null);
                } else if (value == 2) {
                    DataCanbus.PROXY.cmd(51, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(51, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 7) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 7) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(this.mClick);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this.mClick);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this.mClick);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this.mClick);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this.mClick);
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this.mClick);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this.mClick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(55, new int[]{cmd, val}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    protected void uTheme(int i) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            int id = R.string.str_wc_174008_str11;
            if (i == 1) {
                id = R.string.str_wc_174008_str12;
            }
            ((TextView) findViewById(R.id.tv_text8)).setText(id);
        }
    }

    protected void uPull(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(i != 0);
        }
    }

    protected void uPilao(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(i != 0);
        }
    }

    protected void uUnlockBackDoor(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(i != 0);
        }
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            int id = R.string.str_trunk_unlock;
            if (i == 1) {
                id = R.string.str_trunk_lid_locking;
            }
            ((TextView) findViewById(R.id.tv_text10)).setText(id);
        }
    }

    protected void uBigDelay(int i) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            String str = "OFF";
            if (i == 1) {
                str = "15s";
            } else if (i == 2) {
                str = "30s";
            } else if (i == 3) {
                str = "60s";
            }
            ((TextView) findViewById(R.id.tv_text9)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[107];
        int value2 = DataCanbus.DATA[159];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
        if (((RelativeLayout) findViewById(R.id.layout_view1)) != null) {
            ((RelativeLayout) findViewById(R.id.layout_view1)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[113];
        int value2 = DataCanbus.DATA[158];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText("15s");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text2)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
            }
        }
        if (((RelativeLayout) findViewById(R.id.layout_view2)) != null) {
            ((RelativeLayout) findViewById(R.id.layout_view2)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[110];
        int value2 = DataCanbus.DATA[157];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText("15s");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.off);
            }
        }
        if (((RelativeLayout) findViewById(R.id.layout_view3)) != null) {
            ((RelativeLayout) findViewById(R.id.layout_view3)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[112];
        int value2 = DataCanbus.DATA[155];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
        if (((RelativeLayout) findViewById(R.id.layout_view4)) != null) {
            ((RelativeLayout) findViewById(R.id.layout_view4)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[152];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.sound_settings_2_crystal_rhythm);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.sound_settings_3_city);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.sound_settings_4_jungle);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.sound_settings_1_classic);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[131];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText("L/100KM-KM");
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText("KM/L-KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[153];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[129];
        int value2 = DataCanbus.DATA[161];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
        if (((RelativeLayout) findViewById(R.id.layout_view5)) != null) {
            ((RelativeLayout) findViewById(R.id.layout_view5)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[111];
        int value2 = DataCanbus.DATA[162];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_all : R.string.lock_set_unlock_intelligent_door_driver);
        }
        if (((RelativeLayout) findViewById(R.id.layout_view6)) != null) {
            ((RelativeLayout) findViewById(R.id.layout_view6)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[151];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value - 1)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue13() {
        int value = DataCanbus.DATA[177];
        int value2 = DataCanbus.DATA[156];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value == 0);
        }
        if (((RelativeLayout) findViewById(R.id.layout_view7)) != null) {
            ((RelativeLayout) findViewById(R.id.layout_view7)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.wc_psa_all_reset_tpms));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.wc_psa_all_confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.26
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(13, new int[]{1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.wc_psa_all_cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.27
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.27.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(13, new int[1], null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
