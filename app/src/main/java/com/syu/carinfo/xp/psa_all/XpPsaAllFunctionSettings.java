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

public class XpPsaAllFunctionSettings extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 37:
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
                case 107:
                case 159:
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
                case 108:
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
                case 110:
                case 157:
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
                case 111:
                case 162:
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 112:
                case 155:
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
                case 113:
                case 158:
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
                case 118:
                    XpPsaAllFunctionSettings.this.uBigDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 119:
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 129:
                case 161:
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 131:
                    XpPsaAllFunctionSettings.this.mUpdaterValue7();
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 151:
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 152:
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
                case 153:
                    XpPsaAllFunctionSettings.this.mUpdaterValue8();
                    XpPsaAllFunctionSettings.this.mUpdaterValue9();
                    XpPsaAllFunctionSettings.this.mUpdaterValue10();
                    XpPsaAllFunctionSettings.this.mUpdaterValue11();
                    XpPsaAllFunctionSettings.this.mUpdaterValue12();
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 156:
                case 171:
                    XpPsaAllFunctionSettings.this.mUpdaterValue13();
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 183:
                    XpPsaAllFunctionSettings.this.uUnlockBackDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 184:
                    XpPsaAllFunctionSettings.this.uPilao(DataCanbus.DATA[updateCode]);
                    break;
                case 185:
                    XpPsaAllFunctionSettings.this.uPull(DataCanbus.DATA[updateCode]);
                    break;
                case 191:
                    XpPsaAllFunctionSettings.this.uTheme(DataCanbus.DATA[updateCode]);
                    break;
                case 215:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_psa_all_func_set);
        registerListener();
    }

    
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
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
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
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
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_parking_assist)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[108];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[107];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_light_with_me_home_lighting_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.xp_psa_all_btn_light_with_me_home_lighting_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.xp_psa_all_btn_light_welcome_light_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.xp_psa_all_btn_light_welcome_light_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(4, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_mode_settings_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.xp_psa_all_btn_mode_settings_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.xp_psa_all_btn_oil_unit_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.xp_psa_all_btn_oil_unit_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_blind_check)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[153];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(47, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(15, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_door_open)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_engine_start_stop)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[151];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(20, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_psa_all_btn_light_amblance_lighting_value_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.xp_psa_all_btn_light_amblance_lighting_value_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[37] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(66, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[37] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(66, new int[]{12, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_radar_switch)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[171];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_tpms_calibration)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                XpPsaAllFunctionSettings.this.dialog();
            }
        });
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.xp_psa_all_func_btn_pull_control /* 2131433303 */:
                        XpPsaAllFunctionSettings.this.sendCMD(20, DataCanbus.DATA[185] != 1 ? 1 : 0);
                        break;
                    case R.id.xp_psa_all_func_btn_pilao_detect /* 2131433304 */:
                        XpPsaAllFunctionSettings.this.sendCMD(21, DataCanbus.DATA[184] != 1 ? 1 : 0);
                        break;
                    case R.id.xp_psa_all_btn_themecolor_m /* 2131433306 */:
                    case R.id.xp_psa_all_btn_themecolor_p /* 2131433308 */:
                        XpPsaAllFunctionSettings.this.sendCMD(22, DataCanbus.DATA[191] != 1 ? 1 : 0);
                        break;
                    case R.id.xp_psa_all_btn_biglight_delay_m /* 2131433310 */:
                        int val = DataCanbus.DATA[118];
                        XpPsaAllFunctionSettings.this.sendCMD(18, val == 0 ? 3 : val - 1);
                        break;
                    case R.id.xp_psa_all_btn_biglight_delay_p /* 2131433312 */:
                        XpPsaAllFunctionSettings.this.sendCMD(18, (DataCanbus.DATA[118] + 1) % 4);
                        break;
                    case R.id.xp_psa_all_func_only_unlock_backdoor /* 2131433313 */:
                        XpPsaAllFunctionSettings.this.sendCMD(3, DataCanbus.DATA[183] != 1 ? 1 : 0);
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

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(55, new int[]{cmd, val}, null, null);
    }

    @Override
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
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
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
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[108];
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

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[107];
        int value2 = DataCanbus.DATA[159];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping)).setChecked(value != 0);
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_parking_rear_window_wiping_view)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[113];
        int value2 = DataCanbus.DATA[158];
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

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[110];
        int value2 = DataCanbus.DATA[157];
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

    
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[112];
        int value2 = DataCanbus.DATA[155];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light)).setChecked(value != 0);
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_light_daytime_light_view)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[152];
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

    
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[131];
        if (((TextView) findViewById(R.id.xp_psa_all_tv_oil_unit)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_oil_unit)).setText("L/100KM-KM");
            } else {
                ((TextView) findViewById(R.id.xp_psa_all_tv_oil_unit)).setText("KM/L-KM");
            }
        }
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[153];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_blind_check)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_blind_check)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[129];
        int value2 = DataCanbus.DATA[161];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature)).setChecked(value != 0);
        }
        if (((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature_view)) != null) {
            ((RelativeLayout) findViewById(R.id.xp_psa_all_func_btn_light_welcome_feature_view)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[111];
        int value2 = DataCanbus.DATA[162];
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

    
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[151];
        if (((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_engine_start_stop)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_psa_all_func_btn_engine_start_stop)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.xp_psa_all_tv_light_amblance_lighting_value)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_amblance_lighting_value)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.xp_psa_all_tv_light_amblance_lighting_value)).setText(new StringBuilder(String.valueOf(value - 1)).toString());
            }
        }
    }

    
    public void mUpdaterValue13() {
        int value = DataCanbus.DATA[171];
        int value2 = DataCanbus.DATA[156];
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
        builder.setPositiveButton(getResources().getString(R.string.wc_psa_all_confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(13, new int[]{1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.wc_psa_all_cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
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
