package com.syu.carinfo.qiya.kx7;

import android.app.Activity;
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
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityWCXianDaiAllSet extends Activity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCXianDaiAllSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ActivityWCXianDaiAllSet.this.updateTrackDisplay(value);
                    break;
                case 100:
                    ActivityWCXianDaiAllSet.this.updateRadarDisplay(value);
                    break;
                case 101:
                    ActivityWCXianDaiAllSet.this.updateFrontViewInit(value);
                    break;
                case 102:
                    ActivityWCXianDaiAllSet.this.updateRearViewInit(value);
                    break;
                case 105:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                    }
                    break;
                case 106:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 107:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)).setText("R" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)).setText("L" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 108:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)).setText("F" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 109:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)).setText("+" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)).setText("-" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)).setText("0");
                        }
                    }
                    break;
                case 110:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)).setText("+" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)).setText("-" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)).setText("0");
                        }
                    }
                    break;
                case 111:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)).setText("+" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)).setText("-" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)).setText("0");
                        }
                    }
                    break;
                case 112:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                    }
                    break;
                case 113:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                    }
                    break;
                case 114:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                    }
                    break;
                case 115:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                    }
                    break;
                case 116:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                    }
                    break;
                case 117:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                    }
                    break;
                case 118:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 119:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 120:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                    }
                    break;
                case 121:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                    }
                    break;
                case 173:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                    }
                    break;
                case 174:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text11)).setText("Off");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text11)).setText("Enable on shift");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text11)).setText("Enable on speed");
                                break;
                        }
                    }
                    break;
                case 175:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text12)).setText("Off");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text12)).setText("In shift to P");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text12)).setText("On vehicle off");
                                break;
                        }
                    }
                    break;
                case 176:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext14)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
                    }
                    break;
                case 177:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text13)).setText("fast");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text13)).setText("normal");
                                break;
                        }
                    }
                    break;
                case 178:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext15)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value != 0);
                    }
                    break;
                case 179:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext16)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
                    }
                    break;
                case 182:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext17)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value != 0);
                    }
                    break;
                case 183:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext18)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
                    }
                    break;
                case 184:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext19)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value != 0);
                    }
                    break;
                case 185:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext20)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value != 0);
                    }
                    break;
                case 186:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text14)).setText("Off");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text14)).setText("3 flashes");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text14)).setText("5 flashes");
                                break;
                            case 3:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text14)).setText("6 flashes");
                                break;
                        }
                    }
                    break;
                case 187:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext21)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value != 0);
                    }
                    break;
                case 188:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext22)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value != 0);
                    }
                    break;
                case 189:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext23)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value != 0);
                    }
                    break;
                case 190:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text15)).setText("User");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text15)).setText("Level1");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text15)).setText("Level2");
                                break;
                            case 3:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text15)).setText("Level3");
                                break;
                            case 4:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text15)).setText("Full");
                                break;
                        }
                    }
                    break;
                case 191:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext24)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value != 0);
                    }
                    break;
                case 192:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext25)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext25)).setChecked(value != 0);
                    }
                    break;
                case 193:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 194:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext26)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext26)).setChecked(value != 0);
                    }
                    break;
                case 195:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text17)).setText("A");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text17)).setText("B");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text17)).setText("C");
                                break;
                        }
                    }
                    break;
                case 196:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext27)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext27)).setChecked(value != 0);
                    }
                    break;
                case 197:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext28)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext28)).setChecked(value != 0);
                    }
                    break;
                case 198:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext29)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext29)).setChecked(value != 0);
                    }
                    break;
                case 199:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext30)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext30)).setChecked(value != 0);
                    }
                    break;
                case 200:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text18)).setText("℃");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text18)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 201:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text19)).setText("km/l");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text19)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                        }
                    }
                    break;
                case 202:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text20)).setText("psi");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text20)).setText("kPa");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text20)).setText("bar");
                                break;
                        }
                    }
                    break;
                case 203:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext31)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext31)).setChecked(value != 0);
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_xiandai_all_set);
        setListener();
    }

    private void initLauStyle() {
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCXianDaiAllSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ActivityWCXianDaiAllSet.this.language_set = position;
                if (ActivityWCXianDaiAllSet.this.language_set >= 0 && ActivityWCXianDaiAllSet.this.language_set <= ActivityWCXianDaiAllSet.this.mLauStylelist.size() && ActivityWCXianDaiAllSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(5, new int[]{1, ActivityWCXianDaiAllSet.this.send_lang[ActivityWCXianDaiAllSet.this.language_set]}, null, null);
                }
                ActivityWCXianDaiAllSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    void setListener() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.send_lang = new int[]{1, 2, 3, 5, 7, 9, 10, 15, 16, 17, 18};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda /* 3473851 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_19Shengda_EV /* 4063676 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext28)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext29)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext30)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext31)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[101] - 1;
                if (value < 0) {
                    value = 0;
                }
                setCmd(4, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[101] + 1;
                if (value2 > 3) {
                    value2 = 3;
                }
                setCmd(4, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[102] - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCmd(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[102] + 1;
                if (value4 > 3) {
                    value4 = 3;
                }
                setCmd(5, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[106];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, DataCanbus.DATA[106] + 1}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value6 = DataCanbus.DATA[107];
                if (value6 > 6) {
                    value6--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value6}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value7 = DataCanbus.DATA[107];
                if (value7 < 26) {
                    value7++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value7}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value8 = DataCanbus.DATA[108];
                if (value8 > 6) {
                    value8--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value8}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value9 = DataCanbus.DATA[108];
                if (value9 < 26) {
                    value9++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value9}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value10 = DataCanbus.DATA[109];
                if (value10 > 6) {
                    value10--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value10}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value11 = DataCanbus.DATA[109];
                if (value11 < 26) {
                    value11++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value11}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value12 = DataCanbus.DATA[110];
                if (value12 > 6) {
                    value12--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value12}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value13 = DataCanbus.DATA[110];
                if (value13 < 26) {
                    value13++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value13}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value14 = DataCanbus.DATA[111];
                if (value14 > 6) {
                    value14--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value14}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value15 = DataCanbus.DATA[111];
                if (value15 < 26) {
                    value15++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value15}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value16 = DataCanbus.DATA[118];
                if (value16 > 0) {
                    value16--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{16, value16, 255, 255}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value17 = DataCanbus.DATA[118];
                if (value17 < 10) {
                    value17++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{16, value17, 255, 255}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value18 = DataCanbus.DATA[119];
                if (value18 > 0) {
                    value18--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{17, value18, 255, 255}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value19 = DataCanbus.DATA[119];
                if (value19 < 72) {
                    value19++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{17, value19, 255, 255}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value20 = DataCanbus.DATA[174] - 1;
                if (value20 < 0) {
                    value20 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{19, value20, 255, 255}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value21 = DataCanbus.DATA[174] + 1;
                if (value21 > 2) {
                    value21 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{19, value21, 255, 255}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value22 = DataCanbus.DATA[175] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{20, value22, 255, 255}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value23 = DataCanbus.DATA[175] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{20, value23, 255, 255}, null, null);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value24 = DataCanbus.DATA[177] - 1;
                if (value24 < 0) {
                    value24 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{22, value24, 255, 255}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value25 = DataCanbus.DATA[177] + 1;
                if (value25 > 1) {
                    value25 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{22, value25, 255, 255}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value26 = DataCanbus.DATA[186] - 1;
                if (value26 < 0) {
                    value26 = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{32, value26, 255, 255}, null, null);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value27 = DataCanbus.DATA[186] + 1;
                if (value27 > 3) {
                    value27 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{32, value27, 255, 255}, null, null);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value28 = DataCanbus.DATA[190] - 1;
                if (value28 < 0) {
                    value28 = 4;
                }
                DataCanbus.PROXY.cmd(4, new int[]{49, value28, 255, 255}, null, null);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value29 = DataCanbus.DATA[190] + 1;
                if (value29 > 4) {
                    value29 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{49, value29, 255, 255}, null, null);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value30 = DataCanbus.DATA[193] - 1;
                if (value30 < 1) {
                    value30 = 20;
                }
                DataCanbus.PROXY.cmd(4, new int[]{112, value30, 255, 255}, null, null);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value31 = DataCanbus.DATA[193] + 1;
                if (value31 > 20) {
                    value31 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{112, value31, 255, 255}, null, null);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value32 = DataCanbus.DATA[195] - 1;
                if (value32 < 0) {
                    value32 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{114, value32, 255, 255}, null, null);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value33 = DataCanbus.DATA[195] + 1;
                if (value33 > 2) {
                    value33 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{114, value33, 255, 255}, null, null);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int value34 = DataCanbus.DATA[200] - 1;
                if (value34 < 0) {
                    value34 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{77, value34, 255, 255}, null, null);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int value35 = DataCanbus.DATA[200] + 1;
                if (value35 > 1) {
                    value35 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{77, value35, 255, 255}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCmd(3, DataCanbus.DATA[100] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value36 = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
                iArr[1] = value36 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value37 = DataCanbus.DATA[113];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[4];
                iArr2[0] = 1;
                iArr2[1] = value37 == 0 ? 1 : 0;
                iArr2[2] = 255;
                iArr2[3] = 255;
                remoteModuleProxy2.cmd(4, iArr2, null, null);
                break;
            case R.id.all_func_btn_lauguage_set /* 2131427574 */:
                if (this.mLauStyle == null) {
                    initLauStyle();
                }
                if (this.mLauStyle != null && this.mPopShowView != null) {
                    this.mLauStyle.showAtLocation(this.mPopShowView, 17, 0, 0);
                    updateLauguageSet();
                    break;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCmd(2, DataCanbus.DATA[99] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                DataCanbus.PROXY.cmd(2, DataCanbus.DATA[105] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value38 = DataCanbus.DATA[114];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[4];
                iArr3[0] = 2;
                iArr3[1] = value38 == 0 ? 1 : 0;
                iArr3[2] = 255;
                iArr3[3] = 255;
                remoteModuleProxy3.cmd(4, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value39 = DataCanbus.DATA[115];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[4];
                iArr4[0] = 3;
                iArr4[1] = value39 == 0 ? 1 : 0;
                iArr4[2] = 255;
                iArr4[3] = 255;
                remoteModuleProxy4.cmd(4, iArr4, null, null);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int value40 = DataCanbus.DATA[201] - 1;
                if (value40 < 0) {
                    value40 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{78, value40, 255, 255}, null, null);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int value41 = DataCanbus.DATA[201] + 1;
                if (value41 > 1) {
                    value41 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{78, value41, 255, 255}, null, null);
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int value42 = DataCanbus.DATA[202] - 1;
                if (value42 < 0) {
                    value42 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{79, value42, 255, 255}, null, null);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int value43 = DataCanbus.DATA[202] + 1;
                if (value43 > 2) {
                    value43 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{79, value43, 255, 255}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value44 = DataCanbus.DATA[116];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[4];
                iArr5[0] = 4;
                iArr5[1] = value44 == 0 ? 1 : 0;
                iArr5[2] = 255;
                iArr5[3] = 255;
                remoteModuleProxy5.cmd(4, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value45 = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[4];
                iArr6[0] = 5;
                iArr6[1] = value45 == 0 ? 1 : 0;
                iArr6[2] = 255;
                iArr6[3] = 255;
                remoteModuleProxy6.cmd(4, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value46 = DataCanbus.DATA[120];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[4];
                iArr7[0] = 6;
                iArr7[1] = value46 == 0 ? 1 : 0;
                iArr7[2] = 255;
                iArr7[3] = 255;
                remoteModuleProxy7.cmd(4, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value47 = DataCanbus.DATA[121];
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[4];
                iArr8[0] = 7;
                iArr8[1] = value47 == 0 ? 1 : 0;
                iArr8[2] = 255;
                iArr8[3] = 255;
                remoteModuleProxy8.cmd(4, iArr8, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ActivityWCXianDaiE_InfoAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value48 = DataCanbus.DATA[173];
                RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                int[] iArr9 = new int[4];
                iArr9[0] = 25;
                iArr9[1] = value48 == 0 ? 1 : 0;
                iArr9[2] = 255;
                iArr9[3] = 255;
                remoteModuleProxy9.cmd(4, iArr9, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value49 = DataCanbus.DATA[176];
                RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                int[] iArr10 = new int[4];
                iArr10[0] = 21;
                iArr10[1] = value49 == 0 ? 1 : 0;
                iArr10[2] = 255;
                iArr10[3] = 255;
                remoteModuleProxy10.cmd(4, iArr10, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value50 = DataCanbus.DATA[178];
                RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                int[] iArr11 = new int[4];
                iArr11[0] = 23;
                iArr11[1] = value50 == 0 ? 1 : 0;
                iArr11[2] = 255;
                iArr11[3] = 255;
                remoteModuleProxy11.cmd(4, iArr11, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int value51 = DataCanbus.DATA[179];
                RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                int[] iArr12 = new int[4];
                iArr12[0] = 18;
                iArr12[1] = value51 == 0 ? 1 : 0;
                iArr12[2] = 255;
                iArr12[3] = 255;
                remoteModuleProxy12.cmd(4, iArr12, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value52 = DataCanbus.DATA[182];
                RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                int[] iArr13 = new int[4];
                iArr13[0] = 26;
                iArr13[1] = value52 == 0 ? 1 : 0;
                iArr13[2] = 255;
                iArr13[3] = 255;
                remoteModuleProxy13.cmd(4, iArr13, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value53 = DataCanbus.DATA[183];
                RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                int[] iArr14 = new int[4];
                iArr14[0] = 35;
                iArr14[1] = value53 == 0 ? 1 : 0;
                iArr14[2] = 255;
                iArr14[3] = 255;
                remoteModuleProxy14.cmd(4, iArr14, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value54 = DataCanbus.DATA[184];
                RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                int[] iArr15 = new int[4];
                iArr15[0] = 36;
                iArr15[1] = value54 == 0 ? 1 : 0;
                iArr15[2] = 255;
                iArr15[3] = 255;
                remoteModuleProxy15.cmd(4, iArr15, null, null);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int value55 = DataCanbus.DATA[185];
                RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                int[] iArr16 = new int[4];
                iArr16[0] = 37;
                iArr16[1] = value55 == 0 ? 1 : 0;
                iArr16[2] = 255;
                iArr16[3] = 255;
                remoteModuleProxy16.cmd(4, iArr16, null, null);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int value56 = DataCanbus.DATA[187];
                RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                int[] iArr17 = new int[4];
                iArr17[0] = 33;
                iArr17[1] = value56 == 0 ? 1 : 0;
                iArr17[2] = 255;
                iArr17[3] = 255;
                remoteModuleProxy17.cmd(4, iArr17, null, null);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int value57 = DataCanbus.DATA[188];
                RemoteModuleProxy remoteModuleProxy18 = DataCanbus.PROXY;
                int[] iArr18 = new int[4];
                iArr18[0] = 34;
                iArr18[1] = value57 == 0 ? 1 : 0;
                iArr18[2] = 255;
                iArr18[3] = 255;
                remoteModuleProxy18.cmd(4, iArr18, null, null);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                int value58 = DataCanbus.DATA[189];
                RemoteModuleProxy remoteModuleProxy19 = DataCanbus.PROXY;
                int[] iArr19 = new int[4];
                iArr19[0] = 48;
                iArr19[1] = value58 == 0 ? 1 : 0;
                iArr19[2] = 255;
                iArr19[3] = 255;
                remoteModuleProxy19.cmd(4, iArr19, null, null);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                int value59 = DataCanbus.DATA[191];
                RemoteModuleProxy remoteModuleProxy20 = DataCanbus.PROXY;
                int[] iArr20 = new int[4];
                iArr20[0] = 50;
                iArr20[1] = value59 == 0 ? 1 : 0;
                iArr20[2] = 255;
                iArr20[3] = 255;
                remoteModuleProxy20.cmd(4, iArr20, null, null);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                int value60 = DataCanbus.DATA[192];
                RemoteModuleProxy remoteModuleProxy21 = DataCanbus.PROXY;
                int[] iArr21 = new int[4];
                iArr21[0] = 51;
                iArr21[1] = value60 == 0 ? 1 : 0;
                iArr21[2] = 255;
                iArr21[3] = 255;
                remoteModuleProxy21.cmd(4, iArr21, null, null);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                int value61 = DataCanbus.DATA[194];
                RemoteModuleProxy remoteModuleProxy22 = DataCanbus.PROXY;
                int[] iArr22 = new int[4];
                iArr22[0] = 113;
                iArr22[1] = value61 == 0 ? 1 : 0;
                iArr22[2] = 255;
                iArr22[3] = 255;
                remoteModuleProxy22.cmd(4, iArr22, null, null);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                int value62 = DataCanbus.DATA[196];
                RemoteModuleProxy remoteModuleProxy23 = DataCanbus.PROXY;
                int[] iArr23 = new int[4];
                iArr23[0] = 115;
                iArr23[1] = value62 == 0 ? 1 : 0;
                iArr23[2] = 255;
                iArr23[3] = 255;
                remoteModuleProxy23.cmd(4, iArr23, null, null);
                break;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                int value63 = DataCanbus.DATA[197];
                RemoteModuleProxy remoteModuleProxy24 = DataCanbus.PROXY;
                int[] iArr24 = new int[4];
                iArr24[0] = 116;
                iArr24[1] = value63 == 0 ? 1 : 0;
                iArr24[2] = 255;
                iArr24[3] = 255;
                remoteModuleProxy24.cmd(4, iArr24, null, null);
                break;
            case R.id.ctv_checkedtext29 /* 2131427827 */:
                int value64 = DataCanbus.DATA[198];
                RemoteModuleProxy remoteModuleProxy25 = DataCanbus.PROXY;
                int[] iArr25 = new int[4];
                iArr25[0] = 117;
                iArr25[1] = value64 == 0 ? 1 : 0;
                iArr25[2] = 255;
                iArr25[3] = 255;
                remoteModuleProxy25.cmd(4, iArr25, null, null);
                break;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                int value65 = DataCanbus.DATA[199];
                RemoteModuleProxy remoteModuleProxy26 = DataCanbus.PROXY;
                int[] iArr26 = new int[4];
                iArr26[0] = 120;
                iArr26[1] = value65 == 0 ? 1 : 0;
                iArr26[2] = 255;
                iArr26[3] = 255;
                remoteModuleProxy26.cmd(4, iArr26, null, null);
                break;
            case R.id.ctv_checkedtext31 /* 2131427839 */:
                int value66 = DataCanbus.DATA[203];
                RemoteModuleProxy remoteModuleProxy27 = DataCanbus.PROXY;
                int[] iArr27 = new int[1];
                iArr27[0] = value66 != 0 ? 0 : 1;
                remoteModuleProxy27.cmd(7, iArr27, null, null);
                break;
        }
    }

    private void setCmd(int type, int value) {
        DataCanbus.PROXY.cmd(1, type, value);
    }

    protected void updateTrackDisplay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    protected void updateRadarDisplay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    protected void updateRearViewInit(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_all_view);
                    break;
            }
        }
    }

    protected void updateFrontViewInit(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_all_view);
                    break;
            }
        }
    }
}
