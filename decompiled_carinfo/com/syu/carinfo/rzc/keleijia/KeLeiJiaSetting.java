package com.syu.carinfo.rzc.keleijia;

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

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class KeLeiJiaSetting extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                    KeLeiJiaSetting.this.m71D04();
                    break;
                case 101:
                    KeLeiJiaSetting.this.m71D03();
                    break;
                case 102:
                    KeLeiJiaSetting.this.m71D02();
                    break;
                case 103:
                    KeLeiJiaSetting.this.m71D01();
                    break;
                case 104:
                    KeLeiJiaSetting.this.m71D00();
                    break;
                case 105:
                    KeLeiJiaSetting.this.m71D13();
                    break;
                case 106:
                    KeLeiJiaSetting.this.m71D12();
                    break;
                case 107:
                    KeLeiJiaSetting.this.m71D10();
                    break;
                case 108:
                    KeLeiJiaSetting.this.m71D27();
                    break;
                case 109:
                    KeLeiJiaSetting.this.m71D26();
                    break;
                case 110:
                    KeLeiJiaSetting.this.m71D25();
                    break;
                case 111:
                    KeLeiJiaSetting.this.m71D24();
                    break;
                case 112:
                    KeLeiJiaSetting.this.m71D23();
                    break;
                case 113:
                    KeLeiJiaSetting.this.m71D22();
                    break;
                case 114:
                    KeLeiJiaSetting.this.m71D20();
                    break;
                case 115:
                    KeLeiJiaSetting.this.m71D50();
                    break;
                case 116:
                    KeLeiJiaSetting.this.m71D60();
                    break;
                case 135:
                    KeLeiJiaSetting.this.musercolor();
                    break;
                case 161:
                    KeLeiJiaSetting.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_keleijia_setting);
        init();
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
                KeLeiJiaSetting.this.language_set = position;
                if (KeLeiJiaSetting.this.language_set >= 0 && KeLeiJiaSetting.this.language_set <= KeLeiJiaSetting.this.mLauStylelist.size() && KeLeiJiaSetting.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{13, KeLeiJiaSetting.this.send_lang[KeLeiJiaSetting.this.language_set]}, null, null);
                }
                KeLeiJiaSetting.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[161];
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_instrument));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_3));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_8));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_10));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_11));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_12));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_13));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_14));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_16));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_17));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_19));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_21));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_23));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_24));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_25));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_29));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_34));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_35));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_36));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_38));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.send_lang = new int[]{129, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (KeLeiJiaSetting.this.mLauStyle == null) {
                    KeLeiJiaSetting.this.initLauStyle();
                }
                if (KeLeiJiaSetting.this.mLauStyle != null && KeLeiJiaSetting.this.mPopShowView != null) {
                    KeLeiJiaSetting.this.mLauStyle.showAtLocation(KeLeiJiaSetting.this.mPopShowView, 17, 0, 0);
                    KeLeiJiaSetting.this.updateLauguageSet();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[107] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[107] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[114] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[114] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[100] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[100] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[135] & 255) - 1;
                if (value < 0) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[135] & 255) + 1;
                if (value > 7) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115] & 255;
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[116] & 255;
                if (value2 > 4) {
                    value = value2 - 5;
                } else {
                    value = 100;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[116] & 255;
                if (value2 < 96) {
                    value = value2 + 5;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[103] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[101] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 17;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[102] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 18;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[104] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[105] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[106] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 12;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[109] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 11;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 10;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 9;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
    }

    
    public void musercolor() {
        int temp = DataCanbus.DATA[135] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_background_green);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_background_red);
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_background_blue);
                return;
            }
            if (value == 4) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_pueple_str);
                return;
            }
            if (value == 5) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_orange_str);
                return;
            }
            if (value == 6) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_blue_green_str);
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_7);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_white_str);
            }
        }
    }

    
    public void m71D04() {
        int temp = DataCanbus.DATA[100] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.setting_313_basic31str);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.stop_mode1_str);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.stop_mode2_str);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.stop_mode3_str);
            }
        }
    }

    
    public void m71D50() {
        int temp = DataCanbus.DATA[115] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text5)) != null && value > 0) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.format(String.valueOf(getString(R.string.style_mode_str)) + value, new Object[0]));
        }
    }

    
    public void m71D60() {
        int temp = DataCanbus.DATA[116] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void m71D03() {
        int temp = DataCanbus.DATA[101] & 65535;
        int value = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
    }

    
    public void m71D02() {
        int temp = DataCanbus.DATA[102] & 65535;
        int value = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
    }

    
    public void m71D01() {
        int temp = DataCanbus.DATA[103] & 65535;
        int value = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
    }

    
    public void m71D00() {
        int temp = DataCanbus.DATA[104] & 65535;
        int value = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
    }

    
    public void m71D13() {
        int temp = DataCanbus.DATA[105] & 65535;
        int value = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
    }

    
    public void m71D12() {
        int temp = DataCanbus.DATA[106] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn == 1);
    }

    
    public void m71D10() {
        int temp = DataCanbus.DATA[107] & 65535;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_372_volumestr0);
            } else if (temp == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.rzc_zhenglizi_str);
            } else if (temp == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.rzc_fulizi_str);
            }
        }
    }

    
    public void m71D27() {
        int temp = DataCanbus.DATA[108] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn == 1);
    }

    
    public void m71D26() {
        int temp = DataCanbus.DATA[109] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn == 1);
    }

    
    public void m71D25() {
        int temp = DataCanbus.DATA[110] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(switchOn == 1);
    }

    
    public void m71D24() {
        int temp = DataCanbus.DATA[111] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(switchOn == 1);
    }

    
    public void m71D23() {
        int temp = DataCanbus.DATA[112] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(switchOn == 1);
    }

    
    public void m71D22() {
        int temp = DataCanbus.DATA[113] & 65535;
        int value = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
    }

    
    public void m71D20() {
        int temp = DataCanbus.DATA[114] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 1 || value == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_372_volumestr1);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_372_volumestr2);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_372_volumestr3);
            }
        }
    }
}
