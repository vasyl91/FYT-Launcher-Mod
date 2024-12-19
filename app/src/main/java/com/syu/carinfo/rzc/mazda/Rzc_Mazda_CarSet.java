package com.syu.carinfo.rzc.mazda;

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
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_Mazda_CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mazda.Rzc_Mazda_CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 8:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 15) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text1)).setText("+" + (30 - value));
                            break;
                        } else if (value < 15) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text1)).setText("-" + (value - 15));
                            break;
                        } else {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 9:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 20) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text3)).setText("+" + (40 - value));
                            break;
                        } else if (value < 20) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text3)).setText("-" + (value - 20));
                            break;
                        } else {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 10:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 2) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text4)).setText("+" + (4 - value));
                            break;
                        } else if (value < 2) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text4)).setText("-" + (value - 2));
                            break;
                        } else {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 11:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_Manual);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 12:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 3) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text5)).setText("+" + (6 - value));
                            break;
                        } else if (value < 3) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text5)).setText("-" + (value - 3));
                            break;
                        } else {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 13:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 14:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 5) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text6)).setText("+" + (10 - value));
                            break;
                        } else if (value < 5) {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text6)).setText("-" + (value - 5));
                            break;
                        } else {
                            ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 15:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_418_relock1);
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_418_relock2);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_418_relock4);
                                break;
                            case 4:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_418_relock3);
                                break;
                            case 5:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text7)).setText("锁定：行车时  解锁：进入驻车");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 16:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text8)).setText("60S");
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text8)).setText("90S");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text8)).setText("30S");
                                break;
                        }
                    }
                    break;
                case 17:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_418_unlock2);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_418_unlock1);
                                break;
                        }
                    }
                    break;
                case 18:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 19:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 20:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 21:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 22:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text12)).setText("30min");
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text12)).setText("60min");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text12)).setText("10min");
                                break;
                        }
                    }
                    break;
                case 23:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text13)).setText("15s");
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text13)).setText("30s");
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text13)).setText("60s");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text13)).setText("7.5s");
                                break;
                        }
                    }
                    break;
                case 24:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 25:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 26:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text15)).setText("30s");
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text15)).setText("60s");
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text15)).setText("90s");
                                break;
                            case 4:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text15)).setText("120s");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text15)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 27:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_3);
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_2);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_1);
                                break;
                            case 4:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_0);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_4);
                                break;
                        }
                    }
                    break;
                case 28:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 29:
                    Rzc_Mazda_CarSet.this.updateLauguageSet();
                    break;
                case 30:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text17)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 31:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text18)).setText("连续");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text18)).setText("自动关闭");
                                break;
                        }
                    }
                    break;
                case 32:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text19)).setText("30s");
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text19)).setText("60s");
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text19)).setText("90s");
                                break;
                            case 4:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text19)).setText("120s");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text19)).setText("0s");
                                break;
                        }
                    }
                    break;
                case 33:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 34:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 35:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 36:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text21)).setText("type2");
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text21)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text21)).setText("type1");
                                break;
                        }
                    }
                    break;
                case 37:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 38:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text22)).setText("30s");
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text22)).setText("60s");
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text22)).setText("90s");
                                break;
                            case 4:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text22)).setText("120s");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text22)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 39:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text23)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text23)).setText(R.string.wc_jianianhua_show__metric_unit_1);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text23)).setText(R.string.wc_jianianhua_show__metric_unit_0);
                                break;
                        }
                    }
                    break;
                case 40:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text24)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text24)).setText("℉");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text24)).setText("℃");
                                break;
                        }
                    }
                    break;
                case 41:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 42:
                    Rzc_Mazda_CarSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 43:
                    if (((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text25)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text25)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_4);
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text25)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_2);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text25)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_0);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSet.this.findViewById(R.id.tv_text25)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_mazda_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.mazda.Rzc_Mazda_CarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Rzc_Mazda_CarSet.this.language_set = position;
                if (Rzc_Mazda_CarSet.this.language_set >= 0 && Rzc_Mazda_CarSet.this.language_set <= Rzc_Mazda_CarSet.this.mLauStylelist.size() && Rzc_Mazda_CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{18, Rzc_Mazda_CarSet.this.send_lang[Rzc_Mazda_CarSet.this.language_set]}, null, null);
                }
                Rzc_Mazda_CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[29];
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
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mazda.Rzc_Mazda_CarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Rzc_Mazda_CarSet.this.mLauStyle == null) {
                    Rzc_Mazda_CarSet.this.initLauStyle();
                }
                if (Rzc_Mazda_CarSet.this.mLauStyle != null && Rzc_Mazda_CarSet.this.mPopShowView != null) {
                    Rzc_Mazda_CarSet.this.mLauStyle.showAtLocation(Rzc_Mazda_CarSet.this.mPopShowView, 17, 0, 0);
                    Rzc_Mazda_CarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
        setSelfClick((Button) findViewById(R.id.btn_minus23), this);
        setSelfClick((Button) findViewById(R.id.btn_plus23), this);
        setSelfClick((Button) findViewById(R.id.btn_minus24), this);
        setSelfClick((Button) findViewById(R.id.btn_plus24), this);
        setSelfClick((Button) findViewById(R.id.btn_minus25), this);
        setSelfClick((Button) findViewById(R.id.btn_plus25), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[23] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(11, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[23] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(11, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[24] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(12, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[24] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(12, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[26] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(13, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[26] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(13, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value7 = DataCanbus.DATA[13];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarHudInfo(6, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[8];
                if (value8 > 0) {
                    value8--;
                }
                setCarHudInfo(1, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[8];
                if (value9 < 30) {
                    value9++;
                }
                setCarHudInfo(1, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[11] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarHudInfo(2, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[11] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarHudInfo(2, value11);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[9];
                if (value12 > 0) {
                    value12--;
                }
                setCarHudInfo(4, value12);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[9];
                if (value13 < 40) {
                    value13++;
                }
                setCarHudInfo(4, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[10];
                if (value14 > 0) {
                    value14--;
                }
                setCarHudInfo(3, value14);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[10];
                if (value15 < 4) {
                    value15++;
                }
                setCarHudInfo(3, value15);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = DataCanbus.DATA[12];
                if (value16 > 0) {
                    value16--;
                }
                setCarHudInfo(5, value16);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = DataCanbus.DATA[12];
                if (value17 < 6) {
                    value17++;
                }
                setCarHudInfo(5, value17);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[14];
                if (value18 > 0) {
                    value18--;
                }
                setCarHudInfo(8, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[14];
                if (value19 < 10) {
                    value19++;
                }
                setCarHudInfo(8, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value20 = DataCanbus.DATA[15] - 1;
                if (value20 < 0) {
                    value20 = 5;
                }
                setCarInfo(1, value20);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value21 = DataCanbus.DATA[15] + 1;
                if (value21 > 5) {
                    value21 = 0;
                }
                setCarInfo(1, value21);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[16] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(2, value22);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[16] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarInfo(2, value23);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = DataCanbus.DATA[17] - 1;
                if (value24 < 0) {
                    value24 = 1;
                }
                setCarInfo(3, value24);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = DataCanbus.DATA[17] + 1;
                if (value25 > 1) {
                    value25 = 0;
                }
                setCarInfo(3, value25);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = DataCanbus.DATA[18] - 1;
                if (value26 < 0) {
                    value26 = 3;
                }
                setCarInfo(4, value26);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = DataCanbus.DATA[18] + 1;
                if (value27 > 3) {
                    value27 = 0;
                }
                setCarInfo(4, value27);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = DataCanbus.DATA[21];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 2;
                } else if (value28 == 2) {
                    value28 = 0;
                }
                setCarInfo(8, value28);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = DataCanbus.DATA[21];
                if (value29 == 0) {
                    value29 = 2;
                } else if (value29 == 2) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(8, value29);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[22] - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarInfo(10, value30);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[22] + 1;
                if (value31 > 2) {
                    value31 = 0;
                }
                setCarInfo(10, value31);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[19];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(5, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[20];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(7, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value34 = DataCanbus.DATA[25];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(14, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value35 = DataCanbus.DATA[28];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(17, value35);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value36 = DataCanbus.DATA[33];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(20, value36);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value37 = DataCanbus.DATA[34];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(24, value37);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value38 = DataCanbus.DATA[37];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(128, value38);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value39 = DataCanbus.DATA[41];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(132, value39);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value40 = DataCanbus.DATA[42];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(133, value40);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value41 = DataCanbus.DATA[31] - 1;
                if (value41 < 0) {
                    value41 = 1;
                }
                setCarInfo(22, value41);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value42 = DataCanbus.DATA[31] + 1;
                if (value42 > 1) {
                    value42 = 0;
                }
                setCarInfo(22, value42);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value43 = DataCanbus.DATA[32] - 1;
                if (value43 < 0) {
                    value43 = 4;
                }
                setCarInfo(23, value43);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value44 = DataCanbus.DATA[32] + 1;
                if (value44 > 4) {
                    value44 = 0;
                }
                setCarInfo(23, value44);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value45 = DataCanbus.DATA[36] - 1;
                if (value45 < 0) {
                    value45 = 2;
                }
                setCarInfo(26, value45);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value46 = DataCanbus.DATA[36] + 1;
                if (value46 > 2) {
                    value46 = 0;
                }
                setCarInfo(26, value46);
                break;
            case R.id.btn_minus22 /* 2131427884 */:
                int value47 = DataCanbus.DATA[38] - 1;
                if (value47 < 0) {
                    value47 = 4;
                }
                setCarInfo(129, value47);
                break;
            case R.id.btn_plus22 /* 2131427885 */:
                int value48 = DataCanbus.DATA[38] + 1;
                if (value48 > 4) {
                    value48 = 0;
                }
                setCarInfo(129, value48);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value49 = DataCanbus.DATA[27] - 1;
                if (value49 < 0) {
                    value49 = 4;
                }
                setCarInfo(15, value49);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value50 = DataCanbus.DATA[27] + 1;
                if (value50 > 4) {
                    value50 = 0;
                }
                setCarInfo(15, value50);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value51 = DataCanbus.DATA[30] - 1;
                if (value51 < 0) {
                    value51 = 2;
                }
                setCarInfo(19, value51);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value52 = DataCanbus.DATA[30] + 1;
                if (value52 > 2) {
                    value52 = 0;
                }
                setCarInfo(19, value52);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value53 = DataCanbus.DATA[35] - 1;
                if (value53 < 0) {
                    value53 = 2;
                }
                setCarInfo(25, value53);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value54 = DataCanbus.DATA[35] + 1;
                if (value54 > 2) {
                    value54 = 0;
                }
                setCarInfo(25, value54);
                break;
            case R.id.btn_plus25 /* 2131427923 */:
                int value55 = DataCanbus.DATA[43] + 1;
                if (value55 > 3) {
                    value55 = 0;
                }
                setCarInfo(134, value55);
                break;
            case R.id.btn_plus24 /* 2131427924 */:
                int value56 = DataCanbus.DATA[40] + 1;
                if (value56 > 1) {
                    value56 = 0;
                }
                setCarInfo(131, value56);
                break;
            case R.id.btn_plus23 /* 2131427928 */:
                int value57 = DataCanbus.DATA[39] + 1;
                if (value57 > 1) {
                    value57 = 0;
                }
                setCarInfo(130, value57);
                break;
            case R.id.btn_minus25 /* 2131428315 */:
                int value58 = DataCanbus.DATA[43] - 1;
                if (value58 < 0) {
                    value58 = 3;
                }
                setCarInfo(134, value58);
                break;
            case R.id.btn_minus23 /* 2131428318 */:
                int value59 = DataCanbus.DATA[39] - 1;
                if (value59 < 0) {
                    value59 = 1;
                }
                setCarInfo(130, value59);
                break;
            case R.id.btn_minus24 /* 2131428319 */:
                int value60 = DataCanbus.DATA[40] - 1;
                if (value60 < 0) {
                    value60 = 1;
                }
                setCarInfo(131, value60);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    public void setCarHudInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{65}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{64}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
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
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mazda.Rzc_Mazda_CarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.mazda.Rzc_Mazda_CarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mazda.Rzc_Mazda_CarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
