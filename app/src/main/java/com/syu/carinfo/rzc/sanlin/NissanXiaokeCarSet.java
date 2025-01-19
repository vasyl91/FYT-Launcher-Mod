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
import java.util.ArrayList;

public class NissanXiaokeCarSet extends BaseActivity implements View.OnClickListener {
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
                case 146:
                    NissanXiaokeCarSet.this.setCheck((CheckedTextView) NissanXiaokeCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 159:
                case 162:
                    int unit = DataCanbus.DATA[159];
                    int data = DataCanbus.DATA[162];
                    if (((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (unit == 1) {
                            ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(data) + "miles");
                            break;
                        } else {
                            ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(data) + "km");
                            break;
                        }
                    }
                    break;
                case 160:
                case 161:
                    int unit2 = DataCanbus.DATA[160];
                    int data2 = DataCanbus.DATA[161];
                    if (((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (unit2 == 1) {
                            ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(data2) + "miles");
                            break;
                        } else {
                            ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(data2) + "km");
                            break;
                        }
                    }
                    break;
                case 181:
                    if (((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 182:
                    if (((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 187:
                    if (((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text2)).setText("Metric");
                                break;
                            case 1:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text2)).setText("US");
                                break;
                        }
                    }
                    break;
                case 188:
                    if (((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text1)).setText("Type0");
                                break;
                            case 1:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text1)).setText("Type1");
                                break;
                            case 2:
                                ((TextView) NissanXiaokeCarSet.this.findViewById(R.id.tv_text1)).setText("Type2");
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
        //setContentView(R.layout.layout_0190_rzc_nissan_settings);
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
                NissanXiaokeCarSet.this.language_set = position;
                if (NissanXiaokeCarSet.this.language_set >= 0 && NissanXiaokeCarSet.this.language_set <= NissanXiaokeCarSet.this.mLauStylelist.size() && NissanXiaokeCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(2, new int[]{49, NissanXiaokeCarSet.this.send_lang[NissanXiaokeCarSet.this.language_set]}, null, null);
                }
                NissanXiaokeCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_42));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_34));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.send_lang = new int[]{0, 1, 129, 130, 131, 132, 133, 134, 135, 137, 138, 141, 145, 147, 148, 149, 150, 151, 152, 153, 154, 155};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (NissanXiaokeCarSet.this.mLauStyle == null) {
                    NissanXiaokeCarSet.this.initLauStyle();
                }
                if (NissanXiaokeCarSet.this.mLauStyle != null && NissanXiaokeCarSet.this.mPopShowView != null) {
                    NissanXiaokeCarSet.this.mLauStyle.showAtLocation(NissanXiaokeCarSet.this.mPopShowView, 17, 0, 0);
                    NissanXiaokeCarSet.this.updateLauguageSet();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 655550) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[188] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[188] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[187] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{48, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[187] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{48, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[181] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[181] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value6}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[182] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value7}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[182] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value8}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value9 = DataCanbus.DATA[146];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(value9);
                break;
        }
    }

    public void setCarInfo(int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }
}
