package com.syu.carinfo.rzc.ziyouguang;

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
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Rzc_ZiYouguang_Other extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                case 115:
                    Rzc_ZiYouguang_Other.this.mCompassOffset();
                    break;
                case 116:
                    Rzc_ZiYouguang_Other.this.mFormatSet();
                    break;
                case 122:
                    ((CheckedTextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 130:
                    Rzc_ZiYouguang_Other.this.mSeatAutoHeat();
                    break;
                case 131:
                    Rzc_ZiYouguang_Other.this.mRearViewMirror();
                    break;
                case 140:
                    ((CheckedTextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 151:
                    Rzc_ZiYouguang_Other.this.updateUnitOil(DataCanbus.DATA[updateCode]);
                    break;
                case 152:
                    Rzc_ZiYouguang_Other.this.updateUnitTpms(DataCanbus.DATA[updateCode]);
                    break;
                case 153:
                    Rzc_ZiYouguang_Other.this.updateUnitTemp(DataCanbus.DATA[updateCode]);
                    break;
                case 161:
                    ((CheckedTextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 163:
                    Rzc_ZiYouguang_Other.this.updateUnitMiles(DataCanbus.DATA[updateCode]);
                    break;
                case 164:
                    Rzc_ZiYouguang_Other.this.updateUnitOil_ZhiNanZhe(DataCanbus.DATA[updateCode]);
                    break;
                case 168:
                    Rzc_ZiYouguang_Other.this.updateAutoParkBrake(DataCanbus.DATA[updateCode]);
                    break;
                case 169:
                    Rzc_ZiYouguang_Other.this.updateServerMode(DataCanbus.DATA[updateCode]);
                    break;
                case 185:
                    ((CheckedTextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 186:
                    ((CheckedTextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 205:
                    ((CheckedTextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 253:
                    ((CheckedTextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
                case 254:
                    ((CheckedTextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    break;
                case 255:
                    if (value == 0) {
                        ((TextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.tv_text9)).setText("90km/h");
                    } else if (value == 1) {
                        ((TextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.tv_text9)).setText("95km/h");
                    } else if (value == 2) {
                        ((TextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.tv_text9)).setText("100km/h");
                    } else if (value == 3) {
                        ((TextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.tv_text9)).setText("105km/h");
                    } else if (value == 4) {
                        ((TextView) Rzc_ZiYouguang_Other.this.findViewById(R.id.tv_text9)).setText("110km/h");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_rzc_other);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Rzc_ZiYouguang_Other.this.language_set = position;
                if (Rzc_ZiYouguang_Other.this.language_set >= 0 && Rzc_ZiYouguang_Other.this.language_set <= Rzc_ZiYouguang_Other.this.mLauStylelist.size() && Rzc_ZiYouguang_Other.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(2, new int[]{83, Rzc_ZiYouguang_Other.this.send_lang[Rzc_ZiYouguang_Other.this.language_set]}, null, null);
                }
                Rzc_ZiYouguang_Other.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_25));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Rzc_ZiYouguang_Other.this.mLauStyle == null) {
                    Rzc_ZiYouguang_Other.this.initLauStyle();
                }
                if (Rzc_ZiYouguang_Other.this.mLauStyle != null && Rzc_ZiYouguang_Other.this.mPopShowView != null) {
                    Rzc_ZiYouguang_Other.this.mLauStyle.showAtLocation(Rzc_ZiYouguang_Other.this.mPopShowView, 17, 0, 0);
                    Rzc_ZiYouguang_Other.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FuncMain.tips(Rzc_ZiYouguang_Other.this.getString(R.string.str_372_calibration));
                DataCanbus.PROXY.cmd(2, new int[]{86, 0}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[161];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[131];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{81, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[186];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{134, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[168];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 98;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[169];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 99;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[140];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 96;
                iArr[1] = value == 1 ? 1 : 2;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[185];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 133;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[205];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 138;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[253];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 165;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[254];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 164;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.id_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Rzc_ZiYouguang_Other.this.dialog();
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[115];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{87, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[115];
                if (value < 15) {
                    value++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{87, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[116] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{82, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[116] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{82, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[152] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{113, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[152] + 1;
                if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{113, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[163];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 115;
                iArr[1] = value != 1 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[163];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 115;
                iArr[1] = value != 1 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[164] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{116, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[164] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{116, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[151];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 117;
                iArr[1] = value == 0 ? 2 : 1;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[151];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 117;
                iArr[1] = value == 0 ? 2 : 1;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[153];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 114;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[153];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 114;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[130] + 1) - 1;
                if (value < 1) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{84, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] + 1 + 1;
                if (value > 3) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{84, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[255] - 1;
                if (value < 0) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[255] + 1;
                if (value > 4) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value}, null, null);
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.35
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.35.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{85, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Other.36
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
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
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[254].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnitOil(int value) {
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text6)).setText("KM/h");
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setText("Mph");
        }
    }

    protected void updateServerMode(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(i == 1);
        }
    }

    protected void updateAutoParkBrake(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(i == 1);
        }
    }

    protected void updateUnitOil_ZhiNanZhe(int i) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            String[] strs = {"MPG(US)", "MPG(UK)", "L/100KM", "KM/L"};
            if (i > -1 && i < strs.length) {
                ((TextView) findViewById(R.id.tv_text5)).setText(strs[i]);
            }
        }
    }

    protected void updateUnitMiles(int i) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(i == 0 ? "mi" : "km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnitTpms(int value) {
        if (value == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(CamryData.PRESSURE_UNIT_PSI);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(CamryData.PRESSURE_UNIT_KPA);
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(CamryData.PRESSURE_UNIT_BAR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnitTemp(int value) {
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_15ruijie_temp_unit_f_set);
        } else {
            ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_15ruijie_temp_unit_c_set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSeatAutoHeat() {
        int value = DataCanbus.DATA[130];
        int i = value & 255;
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_comfortsystems_1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_comfortsystems_2);
        } else {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRearViewMirror() {
        int value = DataCanbus.DATA[131];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mCompassOffset() {
        int value = DataCanbus.DATA[115];
        int value1 = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.jeep_rzc_compass_show)) != null) {
            ((TextView) findViewById(R.id.jeep_rzc_compass_show)).setText(new StringBuilder().append(value1).toString());
        }
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mFormatSet() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_unit_us_imperial);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_17zhinanzhe_str1);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_unit_metric);
            }
        }
    }
}
