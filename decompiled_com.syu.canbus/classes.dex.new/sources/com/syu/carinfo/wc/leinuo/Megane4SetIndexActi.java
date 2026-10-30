package com.syu.carinfo.wc.leinuo;

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
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Megane4SetIndexActi extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetIndexActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 184:
                    if (((TextView) Megane4SetIndexActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4SetIndexActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Megane4SetIndexActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Megane4SetIndexActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 192:
                    if (((TextView) Megane4SetIndexActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Megane4SetIndexActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_magane_index_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetIndexActi.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Megane4SetIndexActi.this.language_set = position;
                if (Megane4SetIndexActi.this.language_set >= 0 && Megane4SetIndexActi.this.language_set <= Megane4SetIndexActi.this.mLauStylelist.size() && Megane4SetIndexActi.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(3, new int[]{1, Megane4SetIndexActi.this.send_lang[Megane4SetIndexActi.this.language_set]}, null, null);
                }
                Megane4SetIndexActi.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.mLauStylelist.add("Rome");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add("Slovakia");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_11));
        this.mLauStylelist.add("Flemish");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_17));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_19));
        this.mLauStylelist.add("Persia");
        this.mLauStylelist.add("Latvia");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_25));
        this.mLauStylelist.add("Slovenia");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_36));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 20, 22, 23, 24, 25, 26, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetIndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Megane4SetIndexActi.this.mLauStyle == null) {
                    Megane4SetIndexActi.this.initLauStyle();
                }
                if (Megane4SetIndexActi.this.mLauStyle != null && Megane4SetIndexActi.this.mPopShowView != null) {
                    Megane4SetIndexActi.this.mLauStyle.showAtLocation(Megane4SetIndexActi.this.mPopShowView, 17, 0, 0);
                    Megane4SetIndexActi.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[184] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(91, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[184] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(91, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[192] - 1;
                if (value3 < 1) {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value3, 0}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[192] + 1;
                if (value4 > 3) {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value4, 0}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Megane4ColorLightSetActi.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Megane4ResetSetActi.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, Megane4DriveAssitSetActi.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, Megane4SeatSetActi.class);
                    startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    Intent intent5 = new Intent();
                    intent5.setClass(this, Megane4UserSetActi.class);
                    startActivity(intent5);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                try {
                    Intent intent6 = new Intent();
                    intent6.setClass(this, Megane4HandUpSetActi.class);
                    startActivity(intent6);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                try {
                    Intent intent7 = new Intent();
                    intent7.setClass(this, Megane4ParkSetActi.class);
                    startActivity(intent7);
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                try {
                    Intent intent8 = new Intent();
                    intent8.setClass(this, Megane4AirSetActi.class);
                    startActivity(intent8);
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                try {
                    Intent intent9 = new Intent();
                    intent9.setClass(this, WCLeinuoAMPSetActi.class);
                    startActivity(intent9);
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                try {
                    Intent intent10 = new Intent();
                    intent10.setClass(this, Megane4MutiSenseSetActi.class);
                    startActivity(intent10);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
    }
}
