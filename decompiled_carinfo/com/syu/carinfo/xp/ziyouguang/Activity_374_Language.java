package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity_374_Language extends BaseActivity {
    int language_set = 255;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_index_language);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        if (DataCanbus.DATA[1000] == 1966454 || DataCanbus.DATA[1000] == 2031990 || DataCanbus.DATA[1000] == 2294134 || DataCanbus.DATA[1000] == 2359670 || DataCanbus.DATA[1000] == 2425206 || DataCanbus.DATA[1000] == 2490742 || DataCanbus.DATA[1000] == 2556278 || DataCanbus.DATA[1000] == 5046646 || DataCanbus.DATA[1000] == 5112182 || DataCanbus.DATA[1000] == 2883958 || DataCanbus.DATA[1000] == 3932534 || DataCanbus.DATA[1000] == 2949494 || DataCanbus.DATA[1000] == 3015030 || DataCanbus.DATA[1000] == 3080566 || DataCanbus.DATA[1000] == 3146102 || DataCanbus.DATA[1000] == 3211638 || DataCanbus.DATA[1000] == 3277174 || DataCanbus.DATA[1000] == 3342710 || DataCanbus.DATA[1000] == 3408246 || DataCanbus.DATA[1000] == 3998070 || DataCanbus.DATA[1000] == 3473782 || DataCanbus.DATA[1000] == 3539318 || DataCanbus.DATA[1000] == 3604854 || DataCanbus.DATA[1000] == 3670390 || DataCanbus.DATA[1000] == 3735926 || DataCanbus.DATA[1000] == 3801462 || DataCanbus.DATA[1000] == 3866998 || DataCanbus.DATA[1000] == 4260214 || DataCanbus.DATA[1000] == 4325750 || DataCanbus.DATA[1000] == 4391286 || DataCanbus.DATA[1000] == 4456822 || DataCanbus.DATA[1000] == 4522358 || DataCanbus.DATA[1000] == 4587894 || DataCanbus.DATA[1000] == 4653430 || DataCanbus.DATA[1000] == 4718966 || DataCanbus.DATA[1000] == 4784502 || DataCanbus.DATA[1000] == 4850038 || DataCanbus.DATA[1000] == 4915574 || DataCanbus.DATA[1000] == 4981110) {
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
            this.send_lang = new int[]{1, 2, 4, 10};
        } else {
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_22));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_23));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
            this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        }
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Activity_374_Language.this.mLauStyle == null) {
                    Activity_374_Language.this.initLauStyle();
                }
                if (Activity_374_Language.this.mLauStyle != null && Activity_374_Language.this.mPopShowView != null) {
                    Activity_374_Language.this.mLauStyle.showAtLocation(Activity_374_Language.this.mPopShowView, 17, 0, 0);
                    Activity_374_Language.this.updateLauguageSet();
                }
            }
        });
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
                Activity_374_Language.this.language_set = position;
                if (Activity_374_Language.this.language_set >= 0 && Activity_374_Language.this.language_set <= Activity_374_Language.this.mLauStylelist.size() && Activity_374_Language.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{0, Activity_374_Language.this.send_lang[Activity_374_Language.this.language_set] - 1}, null, null);
                }
                Activity_374_Language.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }
}
