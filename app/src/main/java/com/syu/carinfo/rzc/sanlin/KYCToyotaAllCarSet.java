package com.syu.carinfo.rzc.sanlin;

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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

public class KYCToyotaAllCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 99:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 100:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text8)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text8)).setText("15s");
                                break;
                            case 3:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text8)).setText("30s");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text9)).setText("30s");
                                break;
                            case 2:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text9)).setText("60s");
                                break;
                            case 3:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text9)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 102:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 103:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 104:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 105:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 106:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 107:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 108:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 109:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                            case 1:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                        }
                    }
                    break;
                case 110:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 111:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 112:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 113:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 114:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 115:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text13)).setText("30s");
                                break;
                            case 2:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text13)).setText("60s");
                                break;
                            case 3:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text13)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text15)).setText("Partial");
                                break;
                            case 2:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text15)).setText("Full");
                                break;
                        }
                    }
                    break;
                case 117:
                    KYCToyotaAllCarSet.this.updateLauguageSet();
                    break;
                case 118:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 119:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text6)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text6)).setText("F" + (7 - value));
                            break;
                        } else {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 120:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text5)).setText("L" + (7 - value));
                            break;
                        } else {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text2)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text2)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 122:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 123:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 124:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 125:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 126:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 127:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 129:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 130:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 168:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.klc_meter_Speed_Range_Tips_all);
                                break;
                            case 1:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text17)).setText("Front");
                                break;
                            case 2:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text17)).setText("Rear");
                                break;
                            case 3:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text17)).setText("Driver");
                                break;
                        }
                    }
                    break;
                case 169:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 170:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 177:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text18)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text18)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text18)).setText("15s");
                                break;
                            case 3:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text18)).setText("30s");
                                break;
                        }
                    }
                    break;
                case 178:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text19)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text19)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 179:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 180:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            case 1:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 181:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text21)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            case 1:
                                ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text21)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_kyc_toyota_all_settings);
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
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                KYCToyotaAllCarSet.this.language_set = position;
                if (KYCToyotaAllCarSet.this.language_set >= 0 && KYCToyotaAllCarSet.this.language_set <= KYCToyotaAllCarSet.this.mLauStylelist.size() && KYCToyotaAllCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{36, KYCToyotaAllCarSet.this.send_lang[KYCToyotaAllCarSet.this.language_set]}, null, null);
                }
                KYCToyotaAllCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[117];
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
        findViewById(R.id.layout_view16).setVisibility(8);
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (KYCToyotaAllCarSet.this.mLauStyle == null) {
                    KYCToyotaAllCarSet.this.initLauStyle();
                }
                if (KYCToyotaAllCarSet.this.mLauStyle != null && KYCToyotaAllCarSet.this.mPopShowView != null) {
                    KYCToyotaAllCarSet.this.mLauStyle.showAtLocation(KYCToyotaAllCarSet.this.mPopShowView, 17, 0, 0);
                    KYCToyotaAllCarSet.this.updateLauguageSet();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_MO /* 1966534 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_TX /* 2032070 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_MO /* 2097606 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_TX /* 2163142 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_MO /* 2228678 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_TX /* 2294214 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_MO /* 2359750 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_MO /* 6357445 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_TX /* 6422981 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_MO /* 6488517 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_TX /* 6554053 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_MO /* 6619589 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_TX /* 6685125 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_MO /* 6750661 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_TX /* 6816197 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_TX /* 6881733 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO10 /* 6947269 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO13 /* 7012805 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_16_MO /* 7078341 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Hand /* 7143877 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Audo /* 7209413 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_CD /* 7274949 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_DVD /* 7340485 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Hand /* 7406021 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Auto /* 7471557 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Top /* 7537093 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08 /* 7602629 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_TX /* 7668165 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_MO /* 7733701 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15 /* 7799237 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15_Top /* 7864773 */:
                findViewById(R.id.layout_view9).setVisibility(8);
                findViewById(R.id.layout_view10).setVisibility(8);
                findViewById(R.id.layout_view11).setVisibility(8);
                findViewById(R.id.layout_view12).setVisibility(8);
                findViewById(R.id.layout_view13).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(8);
                findViewById(R.id.layout_view15).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                break;
        }
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
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
    }

    @Override
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value2 = DataCanbus.DATA[125];
                if (value2 > 0) {
                    value2--;
                }
                setAmp(7, value2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[125];
                if (value3 < 63) {
                    value3++;
                }
                setAmp(7, value3);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value4 = DataCanbus.DATA[121];
                if (value4 > 2) {
                    value4--;
                }
                setAmp(4, value4);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value5 = DataCanbus.DATA[121];
                if (value5 < 12) {
                    value5++;
                }
                setAmp(4, value5);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value6 = DataCanbus.DATA[123];
                if (value6 > 2) {
                    value6--;
                }
                setAmp(6, value6);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value7 = DataCanbus.DATA[123];
                if (value7 < 12) {
                    value7++;
                }
                setAmp(6, value7);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value8 = DataCanbus.DATA[122];
                if (value8 > 2) {
                    value8--;
                }
                setAmp(5, value8);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value9 = DataCanbus.DATA[122];
                if (value9 < 12) {
                    value9++;
                }
                setAmp(5, value9);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value10 = DataCanbus.DATA[120];
                if (value10 > 0) {
                    value10--;
                }
                setAmp(2, value10);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value11 = DataCanbus.DATA[120];
                if (value11 < 14) {
                    value11++;
                }
                setAmp(2, value11);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value12 = DataCanbus.DATA[119];
                if (value12 > 0) {
                    value12--;
                }
                setAmp(1, value12);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value13 = DataCanbus.DATA[119];
                if (value13 < 14) {
                    value13++;
                }
                setAmp(1, value13);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value14 = DataCanbus.DATA[99];
                if (value14 > 0) {
                    value14--;
                }
                setCarInfo(6, value14);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value15 = DataCanbus.DATA[99];
                if (value15 < 4) {
                    value15++;
                }
                setCarInfo(6, value15);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value16 = DataCanbus.DATA[100];
                if (value16 > 0) {
                    value16--;
                }
                setCarInfo(12, value16);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value17 = DataCanbus.DATA[100];
                if (value17 < 3) {
                    value17++;
                }
                setCarInfo(12, value17);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value18 = DataCanbus.DATA[101];
                if (value18 > 0) {
                    value18--;
                }
                setCarInfo(7, value18);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value19 = DataCanbus.DATA[101];
                if (value19 < 3) {
                    value19++;
                }
                setCarInfo(7, value19);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value20 = DataCanbus.DATA[106];
                if (value20 > 0) {
                    value20--;
                }
                setCarInfo(5, value20);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value21 = DataCanbus.DATA[106];
                if (value21 < 6) {
                    value21++;
                }
                setCarInfo(5, value21);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value22 = DataCanbus.DATA[109];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(15, value22);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value23 = DataCanbus.DATA[109];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(15, value23);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value24 = DataCanbus.DATA[112];
                if (value24 > 0) {
                    value24--;
                }
                setCarInfo(35, value24);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value25 = DataCanbus.DATA[112];
                if (value25 < 4) {
                    value25++;
                }
                setCarInfo(35, value25);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value26 = DataCanbus.DATA[115];
                if (value26 > 0) {
                    value26--;
                }
                setCarInfo(20, value26);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value27 = DataCanbus.DATA[115];
                if (value27 < 3) {
                    value27++;
                }
                setCarInfo(20, value27);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value28 = DataCanbus.DATA[118];
                if (value28 > 0) {
                    value28--;
                }
                setCarInfo(44, value28);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value29 = DataCanbus.DATA[118];
                if (value29 < 6) {
                    value29++;
                }
                setCarInfo(44, value29);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value30 = DataCanbus.DATA[116];
                if (value30 > 0) {
                    value30--;
                }
                setCarInfo(43, value30);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value31 = DataCanbus.DATA[116];
                if (value31 < 2) {
                    value31++;
                }
                setCarInfo(43, value31);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value32 = DataCanbus.DATA[168] - 1;
                if (value32 < 0) {
                    value32 = 3;
                }
                setAmp(12, value32);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value33 = DataCanbus.DATA[168] + 1;
                if (value33 > 3) {
                    value33 = 0;
                }
                setAmp(12, value33);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value34 = DataCanbus.DATA[177] - 1;
                if (value34 < 0) {
                    value34 = 3;
                }
                setCarInfo(45, value34);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value35 = DataCanbus.DATA[177] + 1;
                if (value35 > 3) {
                    value35 = 0;
                }
                setCarInfo(45, value35);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[124] == 1) {
                    value = 8;
                } else {
                    value = 1;
                }
                setAmp(3, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value36 = DataCanbus.DATA[126];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setAmp(9, value36);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value37 = DataCanbus.DATA[98];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(4, value37);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value38 = DataCanbus.DATA[102];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(0, value38);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value39 = DataCanbus.DATA[103];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(1, value39);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value40 = DataCanbus.DATA[104];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(2, value40);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value41 = DataCanbus.DATA[105];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(3, value41);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value42 = DataCanbus.DATA[107];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(13, value42);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value43 = DataCanbus.DATA[108];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(14, value43);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value44 = DataCanbus.DATA[110];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(16, value44);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value45 = DataCanbus.DATA[111];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(17, value45);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value46 = DataCanbus.DATA[113];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(18, value46);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value47 = DataCanbus.DATA[114];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(19, value47);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value48 = DataCanbus.DATA[129];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setAmp(96, value48);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value49 = DataCanbus.DATA[130];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setAmp(97, value49);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                setAmp(98, 1);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                setAmp(99, 1);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                setAmp(100, 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value50 = DataCanbus.DATA[170];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setAmp(8, value50);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value51 = DataCanbus.DATA[169];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setAmp(10, value51);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, KYCToyotaTireAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value52 = DataCanbus.DATA[179];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(22, value52);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
                int value53 = DataCanbus.DATA[178] - 1;
                if (value53 < 0) {
                    value53 = 4;
                }
                setCarInfo(21, value53 + 1);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value54 = DataCanbus.DATA[178] + 1;
                if (value54 > 4) {
                    value54 = 0;
                }
                setCarInfo(21, value54 + 1);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value55 = DataCanbus.DATA[180] - 1;
                if (value55 < 0) {
                    value55 = 1;
                }
                setCarInfo(23, value55);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value56 = DataCanbus.DATA[180] + 1;
                if (value56 > 1) {
                    value56 = 0;
                }
                setCarInfo(23, value56);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value57 = DataCanbus.DATA[181] - 1;
                if (value57 < 0) {
                    value57 = 1;
                }
                setCarInfo(46, value57);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value58 = DataCanbus.DATA[181] + 1;
                if (value58 > 1) {
                    value58 = 0;
                }
                setCarInfo(46, value58);
                break;
        }
    }

    public void setAmp(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
    }
}
