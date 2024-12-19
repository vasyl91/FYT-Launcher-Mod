package com.syu.carinfo.rzc.sanlin;

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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KYCToyotaAllCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.KYCToyotaAllCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 87:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 88:
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
                case 89:
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
                case 90:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 91:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 92:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 93:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 94:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 95:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 96:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 97:
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
                case 98:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 99:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 100:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 101:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 102:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 103:
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
                case 104:
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
                case 105:
                    KYCToyotaAllCarSet.this.updateLauguageSet();
                    break;
                case 106:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 107:
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
                case 108:
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 113:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 114:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 115:
                    if (((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) KYCToyotaAllCarSet.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 116:
                    if (value == 1) {
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view2).setVisibility(0);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view3).setVisibility(0);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view4).setVisibility(0);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view5).setVisibility(0);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view6).setVisibility(0);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view7).setVisibility(0);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view8).setVisibility(0);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view14).setVisibility(0);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_text_view1).setVisibility(0);
                        break;
                    } else {
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view1).setVisibility(8);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view2).setVisibility(8);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view3).setVisibility(8);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view4).setVisibility(8);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view5).setVisibility(8);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view6).setVisibility(8);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view7).setVisibility(8);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view8).setVisibility(8);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_view14).setVisibility(8);
                        KYCToyotaAllCarSet.this.findViewById(R.id.layout_text_view1).setVisibility(8);
                        break;
                    }
                case 117:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 118:
                    KYCToyotaAllCarSet.this.setCheck((CheckedTextView) KYCToyotaAllCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 156:
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
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_kyc_toyota_all_settings);
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
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.KYCToyotaAllCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
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
        int value = DataCanbus.DATA[105];
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
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.KYCToyotaAllCarSet.3
            @Override // android.view.View.OnClickListener
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value2 = DataCanbus.DATA[103];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(20, value2);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value3 = DataCanbus.DATA[103];
                if (value3 < 3) {
                    value3++;
                }
                setCarInfo(20, value3);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value4 = DataCanbus.DATA[106];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(44, value4);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value5 = DataCanbus.DATA[106];
                if (value5 < 6) {
                    value5++;
                }
                setCarInfo(44, value5);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value6 = DataCanbus.DATA[104];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(43, value6);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value7 = DataCanbus.DATA[104];
                if (value7 < 2) {
                    value7++;
                }
                setCarInfo(43, value7);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[112] == 1) {
                    value = 8;
                } else {
                    value = 1;
                }
                setAmp(3, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[113];
                if (value8 > 0) {
                    value8--;
                }
                setAmp(7, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[113];
                if (value9 < 63) {
                    value9++;
                }
                setAmp(7, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[109];
                if (value10 > 2) {
                    value10--;
                }
                setAmp(4, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[109];
                if (value11 < 12) {
                    value11++;
                }
                setAmp(4, value11);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[111];
                if (value12 > 2) {
                    value12--;
                }
                setAmp(6, value12);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[111];
                if (value13 < 12) {
                    value13++;
                }
                setAmp(6, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[110];
                if (value14 > 2) {
                    value14--;
                }
                setAmp(5, value14);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[110];
                if (value15 < 12) {
                    value15++;
                }
                setAmp(5, value15);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = DataCanbus.DATA[108];
                if (value16 > 0) {
                    value16--;
                }
                setAmp(2, value16);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = DataCanbus.DATA[108];
                if (value17 < 14) {
                    value17++;
                }
                setAmp(2, value17);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[107];
                if (value18 > 0) {
                    value18--;
                }
                setAmp(1, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[107];
                if (value19 < 14) {
                    value19++;
                }
                setAmp(1, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value20 = DataCanbus.DATA[87];
                if (value20 > 0) {
                    value20--;
                }
                setCarInfo(6, value20);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value21 = DataCanbus.DATA[87];
                if (value21 < 4) {
                    value21++;
                }
                setCarInfo(6, value21);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[88];
                if (value22 > 0) {
                    value22--;
                }
                setCarInfo(12, value22);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[88];
                if (value23 < 3) {
                    value23++;
                }
                setCarInfo(12, value23);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = DataCanbus.DATA[89];
                if (value24 > 0) {
                    value24--;
                }
                setCarInfo(7, value24);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = DataCanbus.DATA[89];
                if (value25 < 3) {
                    value25++;
                }
                setCarInfo(7, value25);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = DataCanbus.DATA[94];
                if (value26 > 0) {
                    value26--;
                }
                setCarInfo(5, value26);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = DataCanbus.DATA[94];
                if (value27 < 6) {
                    value27++;
                }
                setCarInfo(5, value27);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = DataCanbus.DATA[97];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(15, value28);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = DataCanbus.DATA[97];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(15, value29);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[100];
                if (value30 > 0) {
                    value30--;
                }
                setCarInfo(35, value30);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[100];
                if (value31 < 4) {
                    value31++;
                }
                setCarInfo(35, value31);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[114];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setAmp(9, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[86];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(4, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value34 = DataCanbus.DATA[90];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(0, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value35 = DataCanbus.DATA[91];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(1, value35);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value36 = DataCanbus.DATA[92];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(2, value36);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value37 = DataCanbus.DATA[93];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(3, value37);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value38 = DataCanbus.DATA[95];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(13, value38);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value39 = DataCanbus.DATA[96];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(14, value39);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value40 = DataCanbus.DATA[98];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(16, value40);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value41 = DataCanbus.DATA[99];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(17, value41);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value42 = DataCanbus.DATA[101];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(18, value42);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value43 = DataCanbus.DATA[102];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(19, value43);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value44 = DataCanbus.DATA[117];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setAmp(96, value44);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value45 = DataCanbus.DATA[118];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setAmp(97, value45);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                setAmp(98, 1);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                setAmp(99, 1);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                setAmp(100, 1);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value46 = DataCanbus.DATA[156] - 1;
                if (value46 < 0) {
                    value46 = 3;
                }
                setAmp(12, value46);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value47 = DataCanbus.DATA[156] + 1;
                if (value47 > 3) {
                    value47 = 0;
                }
                setAmp(12, value47);
                break;
        }
    }

    public void setAmp(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
    }
}
