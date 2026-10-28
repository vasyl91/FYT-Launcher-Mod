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
public class Activity_0452_PA_Ford_Language extends BaseActivity {
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{1, 2, 4, 10};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Activity_0452_PA_Ford_Language.this.mLauStyle == null) {
                    Activity_0452_PA_Ford_Language.this.initLauStyle();
                }
                if (Activity_0452_PA_Ford_Language.this.mLauStyle != null && Activity_0452_PA_Ford_Language.this.mPopShowView != null) {
                    Activity_0452_PA_Ford_Language.this.mLauStyle.showAtLocation(Activity_0452_PA_Ford_Language.this.mPopShowView, 17, 0, 0);
                    Activity_0452_PA_Ford_Language.this.updateLauguageSet();
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
                Activity_0452_PA_Ford_Language.this.language_set = position;
                if (Activity_0452_PA_Ford_Language.this.language_set >= 0 && Activity_0452_PA_Ford_Language.this.language_set <= Activity_0452_PA_Ford_Language.this.mLauStylelist.size() && Activity_0452_PA_Ford_Language.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{0, Activity_0452_PA_Ford_Language.this.send_lang[Activity_0452_PA_Ford_Language.this.language_set] - 1}, null, null);
                }
                Activity_0452_PA_Ford_Language.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }
}
