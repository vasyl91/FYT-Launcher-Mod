package com.syu.carinfo.xp.ziyouguang;

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

public class Activity_424_FuncSet extends BaseActivity implements View.OnClickListener {
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
                case 105:
                    Activity_424_FuncSet.this.updateLauguageSet();
                    break;
                case 106:
                    Activity_424_FuncSet.this.setCheck((CheckedTextView) Activity_424_FuncSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 155:
                    ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 156:
                    if (value > 10) {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text2)).setText("R" + (value - 10));
                        break;
                    } else if (value < 10) {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text2)).setText("F" + (10 - value));
                        break;
                    } else {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text2)).setText("0");
                        break;
                    }
                case 157:
                    if (value > 10) {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text3)).setText("R" + (value - 10));
                        break;
                    } else if (value < 10) {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text3)).setText("L" + (10 - value));
                        break;
                    } else {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text3)).setText("0");
                        break;
                    }
                case 158:
                    if (value > 10) {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                        break;
                    } else if (value < 10) {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                        break;
                    } else {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    }
                case 159:
                    if (value > 10) {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text5)).setText("+" + (value - 10));
                        break;
                    } else if (value < 10) {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text5)).setText("-" + (10 - value));
                        break;
                    } else {
                        ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    }
                case 160:
                    if (value == 1) {
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view2).setVisibility(0);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view3).setVisibility(0);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view4).setVisibility(0);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view5).setVisibility(0);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view6).setVisibility(0);
                        break;
                    } else {
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view1).setVisibility(8);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view2).setVisibility(8);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view3).setVisibility(8);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view4).setVisibility(8);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view5).setVisibility(8);
                        Activity_424_FuncSet.this.findViewById(R.id.layout_view6).setVisibility(8);
                        break;
                    }
                case 161:
                    switch (value) {
                        case 0:
                            ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_17zhinanzhe_str1);
                            break;
                        case 1:
                            ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_252_sound_distribution0);
                            break;
                        case 2:
                            ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_252_sound_distribution1);
                            break;
                        case 3:
                            ((TextView) Activity_424_FuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_front_on);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0424_xp_renault_settings);
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
                Activity_424_FuncSet.this.language_set = position;
                if (Activity_424_FuncSet.this.language_set >= 0 && Activity_424_FuncSet.this.language_set <= Activity_424_FuncSet.this.mLauStylelist.size() && Activity_424_FuncSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{3, Activity_424_FuncSet.this.send_lang[Activity_424_FuncSet.this.language_set]}, null, null);
                }
                Activity_424_FuncSet.this.mLauStyle.dismiss();
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_36));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Activity_424_FuncSet.this.mLauStyle == null) {
                    Activity_424_FuncSet.this.initLauStyle();
                }
                if (Activity_424_FuncSet.this.mLauStyle != null && Activity_424_FuncSet.this.mPopShowView != null) {
                    Activity_424_FuncSet.this.mLauStyle.showAtLocation(Activity_424_FuncSet.this.mPopShowView, 17, 0, 0);
                    Activity_424_FuncSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setCarAmpInfo(2, 2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setCarAmpInfo(2, 1);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setCarAmpInfo(3, 2);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarAmpInfo(3, 1);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarAmpInfo(4, 2);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarAmpInfo(4, 1);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarAmpInfo(5, 2);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarAmpInfo(5, 1);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarAmpInfo(6, 2);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarAmpInfo(6, 1);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value = DataCanbus.DATA[161] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarAmpInfo(11, value);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value2 = DataCanbus.DATA[161] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarAmpInfo(11, value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value3 = DataCanbus.DATA[106];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(1, value3);
                break;
        }
    }

    void setCarAmpInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
    }

    void setCarInfo(int value0, int value1) {
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
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
    }
}
