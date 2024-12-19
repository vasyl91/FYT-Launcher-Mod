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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XpPsaAllFunctionSettings extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                case 62:
                    XpPsaAllFunctionSettings.this.mUpdaterValue2();
                    XpPsaAllFunctionSettings.this.mUpdaterValue3();
                    XpPsaAllFunctionSettings.this.mUpdaterValue4();
                    XpPsaAllFunctionSettings.this.mUpdaterValue5();
                    XpPsaAllFunctionSettings.this.mUpdaterValue6();
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 11:
                    XpPsaAllFunctionSettings.this.mUpdaterValue1();
                    XpPsaAllFunctionSettings.this.mUpdaterValue2();
                    XpPsaAllFunctionSettings.this.mUpdaterValue3();
                    XpPsaAllFunctionSettings.this.mUpdaterValue4();
                    XpPsaAllFunctionSettings.this.mUpdaterValue5();
                    XpPsaAllFunctionSettings.this.mUpdaterValue6();
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 13:
                case 60:
                    XpPsaAllFunctionSettings.this.mUpdaterValue4();
                    XpPsaAllFunctionSettings.this.mUpdaterValue5();
                    XpPsaAllFunctionSettings.this.mUpdaterValue6();
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 14:
                case 65:
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 15:
                case 58:
                    XpPsaAllFunctionSettings.this.mUpdaterValue5();
                    XpPsaAllFunctionSettings.this.mUpdaterValue6();
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 16:
                case 61:
                    XpPsaAllFunctionSettings.this.mUpdaterValue3();
                    XpPsaAllFunctionSettings.this.mUpdaterValue4();
                    XpPsaAllFunctionSettings.this.mUpdaterValue5();
                    XpPsaAllFunctionSettings.this.mUpdaterValue6();
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 21:
                    XpPsaAllFunctionSettings.this.uBigDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 22:
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 32:
                case 64:
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 34:
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 54:
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 55:
                    XpPsaAllFunctionSettings.this.mUpdaterValue6();
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 56:
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 59:
                case 111:
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 84:
                    if (((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text1)) != null) {
                        if (DataCanbus.DATA[updateCode] == 1) {
                            ((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text1)).setText("℉");
                            break;
                        } else {
                            ((TextView) XpPsaAllFunctionSettings.this.findViewById(R.id.tv_text1)).setText("℃");
                            break;
                        }
                    }
                    break;
                case 102:
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 103:
                    XpPsaAllFunctionSettings.this.uPilao(DataCanbus.DATA[updateCode]);
                    break;
                case 104:
                    XpPsaAllFunctionSettings.this.uPull(DataCanbus.DATA[updateCode]);
                    break;
                case 110:
                    XpPsaAllFunctionSettings.this.uTheme(DataCanbus.DATA[updateCode]);
                    break;
                case 149:
                    XpPsaAllFunctionSettings.this.updateLauguageSet();
                    XpPsaAllFunctionSettings.this.mUpdaterValue1();
                    XpPsaAllFunctionSettings.this.mUpdaterValue2();
                    XpPsaAllFunctionSettings.this.mUpdaterValue3();
                    XpPsaAllFunctionSettings.this.mUpdaterValue4();
                    XpPsaAllFunctionSettings.this.mUpdaterValue5();
                    XpPsaAllFunctionSettings.this.mUpdaterValue6();
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.2
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
        int value = DataCanbus.DATA[149];
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
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.3
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
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_parking_assist)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[11];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[10];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_light_with_me_home_lighting_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[16] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_light_with_me_home_lighting_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[16] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_light_welcome_light_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[13] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_light_welcome_light_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[13] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[15];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(4, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_mode_settings_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[55] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(52, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_mode_settings_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[55] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(52, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_oil_unit_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(51, new int[]{2}, null, null);
                } else if (value == 0) {
                    DataCanbus.PROXY.cmd(51, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(51, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_oil_unit_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(51, new int[]{2}, null, null);
                } else if (value == 2) {
                    DataCanbus.PROXY.cmd(51, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(51, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_blind_check)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[56];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(47, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(15, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_door_open)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[14];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_engine_start_stop)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[54];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(20, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_light_amblance_lighting_value_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 7) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_light_amblance_lighting_value_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 7) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[84] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(66, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[84] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(66, new int[]{12, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_radar_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_tpms_calibration)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XpPsaAllFunctionSettings.this.dialog();
            }
        });
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFunctionSettings.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.xp_psa_all_func_btn_pull_control /* 2131433381 */:
                        XpPsaAllFunctionSettings.this.sendCMD(20, DataCanbus.DATA[104] != 1 ? 1 : 0);
                        break;
                    case R.id.xp_psa_all_func_btn_pilao_detect /* 2131433382 */:
                        XpPsaAllFunctionSettings.this.sendCMD(21, DataCanbus.DATA[103] != 1 ? 1 : 0);
                        break;
                    case R.id.xp_psa_all_btn_themecolor_m /* 2131433384 */:
                    case R.id.xp_psa_all_btn_themecolor_p /* 2131433386 */:
                        XpPsaAllFunctionSettings.this.sendCMD(22, DataCanbus.DATA[110] != 1 ? 1 : 0);
                        break;
                    case R.id.xp_psa_all_btn_biglight_delay_m /* 2131433388 */:
                        int val = DataCanbus.DATA[21];
                        XpPsaAllFunctionSettings.this.sendCMD(18, val == 0 ? 3 : val - 1);
                        break;
                    case R.id.xp_psa_all_btn_biglight_delay_p /* 2131433390 */:
                        XpPsaAllFunctionSettings.this.sendCMD(18, (DataCanbus.DATA[21] + 1) % 4);
                        break;
                    case R.id.xp_psa_all_func_only_unlock_backdoor /* 2131433391 */:
                        XpPsaAllFunctionSettings.this.sendCMD(3, DataCanbus.DATA[102] != 1 ? 1 : 0);
                        break;
                }
            }
        };
        setClick((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_pull_control));
        setClick((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_pilao_detect));
        setClick((CheckedTextView) findViewById(R.id.xp_psa_all_func_only_unlock_backdoor));
        setClick((Button) findViewById(R.id.xp_psa_all_btn_themecolor_m));
        setClick((Button) findViewById(R.id.xp_psa_all_btn_themecolor_p));
        setClick((Button) findViewById(R.id.xp_psa_all_btn_biglight_delay_m));
        setClick((Button) findViewById(R.id.xp_psa_all_btn_biglight_delay_p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(55, new int[]{cmd, val}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[11];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_parking_assist)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_parking_assist)).setChecked(value != 0);
        }
    }

    protected void uTheme(int i) {
        if (((TextView) findViewById(R.id.xp_psa_all_btn_themecolor_txt)) != null) {
            int id = R.string.str_wc_174008_str11;
            if (i == 1) {
                id = R.string.str_wc_174008_str12;
            }
            ((TextView) findViewById(R.id.xp_psa_all_btn_themecolor_txt)).setText(id);
        }
    }

    protected void uPull(int i) {
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_pull_control)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_pull_control)).setChecked(i != 0);
        }
    }

    protected void uPilao(int i) {
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_pilao_detect)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_pilao_detect)).setChecked(i != 0);
        }
    }

    protected void uUnlockBackDoor(int i) {
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_only_unlock_backdoor)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_only_unlock_backdoor)).setChecked(i != 0);
        }
        if (((TextView) findViewById(R.id.xp_psa_all_func_only_unlock_backdoor_txt)) != null) {
            int id = R.string.str_trunk_unlock;
            if (i == 1) {
                id = R.string.str_trunk_lid_locking;
            }
            ((TextView) findViewById(R.id.xp_psa_all_func_only_unlock_backdoor_txt)).setText(id);
        }
    }

    protected void uBigDelay(int i) {
        if (((TextView) findViewById(R.id.xp_psa_all_btn_biglight_delay_txt)) != null) {
            String str = "OFF";
            if (i == 1) {
                str = "15s";
            } else if (i == 2) {
                str = "30s";
            } else if (i == 3) {
                str = "60s";
            }
            ((TextView) findViewById(R.id.xp_psa_all_btn_biglight_delay_txt)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[10];
        int value2 = DataCanbus.DATA[62];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping)).setChecked(value != 0);
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping_view)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[16];
        int value2 = DataCanbus.DATA[61];
        if (((TextView) findViewById(R.id.xp_psa_all_tv_light_with_me_home_lighting)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_with_me_home_lighting)).setText("15s");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_with_me_home_lighting)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_with_me_home_lighting)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_with_me_home_lighting)).setText(R.string.off);
            }
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_btn_light_with_me_home_lighting_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_btn_light_with_me_home_lighting_view)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[13];
        int value2 = DataCanbus.DATA[60];
        if (((TextView) findViewById(R.id.xp_psa_all_tv_light_welcome_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_welcome_light)).setText("15s");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_welcome_light)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_welcome_light)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_welcome_light)).setText(R.string.off);
            }
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_btn_light_welcome_light_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_btn_light_welcome_light_view)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[15];
        int value2 = DataCanbus.DATA[58];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light)).setChecked(value != 0);
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light_view)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[55];
        if (((TextView) findViewById(R.id.xp_psa_all_tv_mode_settings)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_mode_settings)).setText(R.string.sound_settings_2_crystal_rhythm);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_mode_settings)).setText(R.string.sound_settings_3_city);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_mode_settings)).setText(R.string.sound_settings_4_jungle);
            } else {
                ((TextView) findViewById(R.id.xp_psa_all_tv_mode_settings)).setText(R.string.sound_settings_1_classic);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.xp_psa_all_tv_oil_unit)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_oil_unit)).setText("MPG");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_oil_unit)).setText("L/100KM-KM");
            } else {
                ((TextView) findViewById(R.id.xp_psa_all_tv_oil_unit)).setText("KM/L-KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[56];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_blind_check)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_blind_check)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[32];
        int value2 = DataCanbus.DATA[64];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature)).setChecked(value != 0);
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature_view)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[14];
        int value2 = DataCanbus.DATA[65];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_door_open)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_door_open)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.xp_psa_all_func_tv_door_open)) != null) {
            ((TextView) findViewById(R.id.xp_psa_all_func_tv_door_open)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_all : R.string.lock_set_unlock_intelligent_door_driver);
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_door_open_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_door_open_view)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[54];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_engine_start_stop)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_engine_start_stop)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.xp_psa_all_tv_light_amblance_lighting_value)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_amblance_lighting_value)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_amblance_lighting_value)).setText(new StringBuilder(String.valueOf(value - 1)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue13() {
        int value = DataCanbus.DATA[111];
        int value2 = DataCanbus.DATA[59];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_radar_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_radar_switch)).setChecked(value == 0);
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_btn_light_amblance_lighting_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_btn_light_amblance_lighting_view)).setVisibility(value2 == 0 ? 8 : 0);
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
