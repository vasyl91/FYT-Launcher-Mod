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

public class RZCXiandaiAmpCarSet extends BaseActivity implements View.OnClickListener {
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
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text5)).setText("F" + (7 - value));
                            break;
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text4)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text4)).setText("L" + (7 - value));
                            break;
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 111:
                    RZCXiandaiAmpCarSet.this.updateLauguageSet();
                    break;
                case 112:
                    ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0362_rzc_xiandai_amp_settings);
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
                RZCXiandaiAmpCarSet.this.language_set = position;
                if (RZCXiandaiAmpCarSet.this.language_set >= 0 && RZCXiandaiAmpCarSet.this.language_set <= RZCXiandaiAmpCarSet.this.mLauStylelist.size() && RZCXiandaiAmpCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(8, new int[]{RZCXiandaiAmpCarSet.this.send_lang[RZCXiandaiAmpCarSet.this.language_set]}, null, null);
                }
                RZCXiandaiAmpCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[111];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_34));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add("Magyar");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.send_lang = new int[]{0, 1, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 23, 24, 28, 129};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RZCXiandaiAmpCarSet.this.mLauStyle == null) {
                    RZCXiandaiAmpCarSet.this.initLauStyle();
                }
                if (RZCXiandaiAmpCarSet.this.mLauStyle != null && RZCXiandaiAmpCarSet.this.mPopShowView != null) {
                    RZCXiandaiAmpCarSet.this.mLauStyle.showAtLocation(RZCXiandaiAmpCarSet.this.mPopShowView, 17, 0, 0);
                    RZCXiandaiAmpCarSet.this.updateLauguageSet();
                }
            }
        });
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC3_XiandaiIX35_H /* 131209 */:
            case FinalCanbus.CAR_RZC3_MingTu_H /* 131225 */:
            case FinalCanbus.CAR_RZC3_SoNaTa9_H /* 131321 */:
            case FinalCanbus.CAR_RZC_16_QiYaKX5_H /* 131465 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_18Sonata9_M /* 262506 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_18Sonata9_H /* 328042 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_All_H /* 524650 */:
            case FinalCanbus.CAR_RZC3_XianDai_Rohens_Coupe_12_H /* 1376618 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                return;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                return;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int bass = DataCanbus.DATA[98];
                int mid = DataCanbus.DATA[99];
                int treb = DataCanbus.DATA[100];
                if (bass > 0) {
                    bass--;
                }
                setCarInfo(bass, mid, treb);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int bass2 = DataCanbus.DATA[98];
                int mid2 = DataCanbus.DATA[99];
                int treb2 = DataCanbus.DATA[100];
                if (bass2 < 20) {
                    bass2++;
                }
                setCarInfo(bass2, mid2, treb2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int bass3 = DataCanbus.DATA[98];
                int mid3 = DataCanbus.DATA[99];
                int treb3 = DataCanbus.DATA[100];
                if (mid3 > 0) {
                    mid3--;
                }
                setCarInfo(bass3, mid3, treb3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int bass4 = DataCanbus.DATA[98];
                int mid4 = DataCanbus.DATA[99];
                int treb4 = DataCanbus.DATA[100];
                if (mid4 < 20) {
                    mid4++;
                }
                setCarInfo(bass4, mid4, treb4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int bass5 = DataCanbus.DATA[98];
                int mid5 = DataCanbus.DATA[99];
                int treb5 = DataCanbus.DATA[100];
                if (treb5 > 0) {
                    treb5--;
                }
                setCarInfo(bass5, mid5, treb5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int bass6 = DataCanbus.DATA[98];
                int mid6 = DataCanbus.DATA[99];
                int treb6 = DataCanbus.DATA[100];
                if (treb6 < 20) {
                    treb6++;
                }
                setCarInfo(bass6, mid6, treb6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int bal = DataCanbus.DATA[102];
                int fad = DataCanbus.DATA[101];
                if (bal > 0) {
                    bal--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{fad, bal}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int bal2 = DataCanbus.DATA[102];
                int fad2 = DataCanbus.DATA[101];
                if (bal2 < 14) {
                    bal2++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{fad2, bal2}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int bal3 = DataCanbus.DATA[102];
                int fad3 = DataCanbus.DATA[101];
                if (fad3 > 0) {
                    fad3--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{fad3, bal3}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int bal4 = DataCanbus.DATA[102];
                int fad4 = DataCanbus.DATA[101];
                if (fad4 < 14) {
                    fad4++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{fad4, bal4}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int vol = DataCanbus.DATA[112];
                if (vol > 0) {
                    vol--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{vol}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int vol2 = DataCanbus.DATA[112];
                if (vol2 < 75) {
                    vol2++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{vol2}, null, null);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }
}
