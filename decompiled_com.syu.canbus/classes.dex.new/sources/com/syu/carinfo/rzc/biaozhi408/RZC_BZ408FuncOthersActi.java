package com.syu.carinfo.rzc.biaozhi408;

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
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408FuncOthersActi extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private int mPanelLeft;
    private int mPanelRight;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 56:
                    if (((TextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 132:
                    RZC_BZ408FuncOthersActi.this.mUpdaterValue1();
                    break;
                case 133:
                    RZC_BZ408FuncOthersActi.this.mUpdaterValue2();
                    break;
                case 134:
                    RZC_BZ408FuncOthersActi.this.mUpdateTempUnit();
                    break;
                case 135:
                    RZC_BZ408FuncOthersActi.this.mUpdaterValue3();
                    break;
                case 137:
                    RZC_BZ408FuncOthersActi.this.updateLauguageSet();
                    break;
                case 186:
                    RZC_BZ408FuncOthersActi.this.mUpdaterValue7(DataCanbus.DATA[updateCode]);
                    break;
                case 187:
                    RZC_BZ408FuncOthersActi.this.mUpdaterValue8(DataCanbus.DATA[updateCode]);
                    break;
                case 191:
                    RZC_BZ408FuncOthersActi.this.mUpdaterValue6(DataCanbus.DATA[updateCode]);
                    break;
                case 192:
                    RZC_BZ408FuncOthersActi.this.mUpdaterValue4();
                    break;
                case 193:
                    RZC_BZ408FuncOthersActi.this.mUpdateEmergencyBraking();
                    break;
                case 194:
                    RZC_BZ408FuncOthersActi.this.mUpdateDisableAutoRearviewMirror();
                    break;
                case 195:
                    ((CheckedTextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 196:
                    ((CheckedTextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 197:
                    ((CheckedTextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 198:
                    ((CheckedTextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 203:
                    ((CheckedTextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 204:
                    ((CheckedTextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 209:
                    ((CheckedTextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 276:
                    ((CheckedTextView) RZC_BZ408FuncOthersActi.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
            }
        }
    };
    int[] strPanelSet = {R.string.wc_psa_all_factory_settings_select_models_0, R.string.wc_4008_pannel_str4, R.string.wc_4008_pannel_str6, R.string.wc_4008_pannel_str7, R.string.str_40_od_media, R.string.bsd_klj_str11, R.string.wc_4008_pannel_str1, R.string.wc_4008_pannel_str8, R.string.wc_4008_pannel_str5};
    int[] strThemeColor = {R.string.str_wc_174008_str11, R.string.str_wc_174008_str12};

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_func_others);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RZC_BZ408FuncOthersActi.this.language_set = position;
                if (RZC_BZ408FuncOthersActi.this.language_set >= 0 && RZC_BZ408FuncOthersActi.this.language_set <= RZC_BZ408FuncOthersActi.this.mLauStylelist.size() && RZC_BZ408FuncOthersActi.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(26, new int[]{RZC_BZ408FuncOthersActi.this.send_lang[RZC_BZ408FuncOthersActi.this.language_set]}, null, null);
                }
                RZC_BZ408FuncOthersActi.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[137];
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

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_11));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_12));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add("Vietnam");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.mLauStylelist.add("Persian");
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RZC_BZ408FuncOthersActi.this.mLauStyle == null) {
                    RZC_BZ408FuncOthersActi.this.initLauStyle();
                }
                if (RZC_BZ408FuncOthersActi.this.mLauStyle != null && RZC_BZ408FuncOthersActi.this.mPopShowView != null) {
                    RZC_BZ408FuncOthersActi.this.mLauStyle.showAtLocation(RZC_BZ408FuncOthersActi.this.mPopShowView, 17, 0, 0);
                    RZC_BZ408FuncOthersActi.this.updateLauguageSet();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[56];
                DataCanbus.PROXY.cmd(89, new int[]{value - 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[56];
                DataCanbus.PROXY.cmd(89, new int[]{value + 1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[132];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(21, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[193];
                DataCanbus.PROXY.cmd(84, new int[]{value < 1 ? 3 : value - 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[193];
                DataCanbus.PROXY.cmd(84, new int[]{value >= 3 ? 0 : value + 1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[194];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(85, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[133];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(22, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[133];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(22, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[135] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(24, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[135] + 1;
                if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(24, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[192] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[192] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[134];
                int value2 = value > 0 ? 0 : 1;
                DataCanbus.PROXY.cmd(75, new int[]{value2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[134];
                int value2 = value > 0 ? 0 : 1;
                DataCanbus.PROXY.cmd(75, new int[]{value2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[191];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(79, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[191];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(79, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[186] - 1;
                if (value < 0) {
                    value = 8;
                }
                DataCanbus.PROXY.cmd(82, new int[]{value, RZC_BZ408FuncOthersActi.this.mPanelRight}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[186] + 1;
                if (value > 8) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(82, new int[]{value, RZC_BZ408FuncOthersActi.this.mPanelRight}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[187] - 1;
                if (value < 0) {
                    value = 8;
                }
                DataCanbus.PROXY.cmd(82, new int[]{RZC_BZ408FuncOthersActi.this.mPanelLeft, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[187] + 1;
                if (value > 8) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(82, new int[]{RZC_BZ408FuncOthersActi.this.mPanelLeft, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[195];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(88, new int[]{28, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[196];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(88, new int[]{29, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[197];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(88, new int[]{31, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[198];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(88, new int[]{32, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[203];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(88, new int[]{33, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[204];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(88, new int[]{34, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[209];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(88, new int[]{26, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncOthersActi.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[276];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(88, new int[]{30, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempUnit() {
        int value = DataCanbus.DATA[134];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(getResources().getString(R.string.wc_15ruijie_temp_unit_c_set));
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(getResources().getString(R.string.wc_15ruijie_temp_unit_f_set));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[132];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
        }
    }

    protected void mUpdaterValue7(int i) {
        if (((TextView) findViewById(R.id.tv_text4)) != null && i > -1 && i < this.strPanelSet.length) {
            this.mPanelLeft = i;
            ((TextView) findViewById(R.id.tv_text4)).setText(this.strPanelSet[i]);
        }
    }

    protected void mUpdaterValue8(int i) {
        if (((TextView) findViewById(R.id.tv_text3)) != null && i > -1 && i < this.strPanelSet.length) {
            this.mPanelRight = i;
            ((TextView) findViewById(R.id.tv_text3)).setText(this.strPanelSet[i]);
        }
    }

    protected void mUpdaterValue6(int data) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(this.strThemeColor[data & 1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[133];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text8)).setText(getResources().getString(R.string.rzc_others_oil_warning_0));
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(getResources().getString(R.string.rzc_others_oil_warning_1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[135];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text7)).setText(getResources().getString(R.string.rzc_others_eq_setting_1));
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text7)).setText(getResources().getString(R.string.rzc_others_eq_setting_2));
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text7)).setText(getResources().getString(R.string.rzc_others_eq_setting_3));
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text7)).setText(getResources().getString(R.string.rzc_others_eq_setting_4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[192];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text6)).setText("KM/L-KM");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText("L/100KM-KM");
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateEmergencyBraking() {
        int value = DataCanbus.DATA[193];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text9)).setText(getResources().getString(R.string.rzc_c4l_close));
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text9)).setText(getResources().getString(R.string.jeep_forwardcollisionwarn_0));
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text9)).setText(getResources().getString(R.string.str_sbd_x80_shengchang_0));
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text9)).setText(getResources().getString(R.string.jeep_forwardcollisionwarn_1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDisableAutoRearviewMirror() {
        int value = DataCanbus.DATA[194];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
    }
}
