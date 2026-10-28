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

@SuppressWarnings({"deprecation", "unchecked"})
public class LuzBenzC200CarSet extends BaseActivity implements View.OnClickListener {
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
                    LuzBenzC200CarSet.this.setCheck((CheckedTextView) LuzBenzC200CarSet.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 99:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 100:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 101:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 102:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_luz_benz_c00_settings);
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
                LuzBenzC200CarSet.this.language_set = position;
                if (LuzBenzC200CarSet.this.language_set >= 0 && LuzBenzC200CarSet.this.language_set <= LuzBenzC200CarSet.this.mLauStylelist.size() && LuzBenzC200CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{LuzBenzC200CarSet.this.send_lang[LuzBenzC200CarSet.this.language_set]}, null, null);
                }
                LuzBenzC200CarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (LuzBenzC200CarSet.this.mLauStyle == null) {
                    LuzBenzC200CarSet.this.initLauStyle();
                }
                if (LuzBenzC200CarSet.this.mLauStyle != null && LuzBenzC200CarSet.this.mPopShowView != null) {
                    LuzBenzC200CarSet.this.mLauStyle.showAtLocation(LuzBenzC200CarSet.this.mPopShowView, 17, 0, 0);
                    LuzBenzC200CarSet.this.updateLauguageSet();
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int d0_b7 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b70 = DataCanbus.DATA[99];
                int d2_b70 = DataCanbus.DATA[100];
                int d3_b70 = DataCanbus.DATA[101];
                int d4_b70 = DataCanbus.DATA[102];
                int d1_b702 = d1_b70 - 5;
                if (d1_b702 < 0) {
                    d1_b702 = 0;
                }
                setCarInfo((d0_b7 << 7) & 128, d1_b702, d2_b70, d3_b70, d4_b70);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int d0_b72 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b703 = DataCanbus.DATA[99];
                int d2_b702 = DataCanbus.DATA[100];
                int d3_b702 = DataCanbus.DATA[101];
                int d4_b702 = DataCanbus.DATA[102];
                int d1_b704 = d1_b703 + 5;
                if (d1_b704 > 100) {
                    d1_b704 = 100;
                }
                setCarInfo((d0_b72 << 7) & 128, d1_b704, d2_b702, d3_b702, d4_b702);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int d0_b73 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b705 = DataCanbus.DATA[99];
                int d2_b703 = DataCanbus.DATA[100];
                int d3_b703 = DataCanbus.DATA[101];
                int d4_b703 = DataCanbus.DATA[102];
                int d2_b704 = d2_b703 - 10;
                if (d2_b704 < 0) {
                    d2_b704 = 0;
                }
                setCarInfo((d0_b73 << 7) & 128, d1_b705, d2_b704, d3_b703, d4_b703);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int d0_b74 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b706 = DataCanbus.DATA[99];
                int d2_b705 = DataCanbus.DATA[100];
                int d3_b704 = DataCanbus.DATA[101];
                int d4_b704 = DataCanbus.DATA[102];
                int d2_b706 = d2_b705 + 10;
                if (d2_b706 > 255) {
                    d2_b706 = 255;
                }
                setCarInfo((d0_b74 << 7) & 128, d1_b706, d2_b706, d3_b704, d4_b704);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int d0_b75 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b707 = DataCanbus.DATA[99];
                int d2_b707 = DataCanbus.DATA[100];
                int d3_b705 = DataCanbus.DATA[101];
                int d4_b705 = DataCanbus.DATA[102];
                int d3_b706 = d3_b705 - 10;
                if (d3_b706 < 0) {
                    d3_b706 = 0;
                }
                setCarInfo((d0_b75 << 7) & 128, d1_b707, d2_b707, d3_b706, d4_b705);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int d0_b76 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b708 = DataCanbus.DATA[99];
                int d2_b708 = DataCanbus.DATA[100];
                int d3_b707 = DataCanbus.DATA[101];
                int d4_b706 = DataCanbus.DATA[102];
                int d3_b708 = d3_b707 + 10;
                if (d3_b708 > 255) {
                    d3_b708 = 255;
                }
                setCarInfo((d0_b76 << 7) & 128, d1_b708, d2_b708, d3_b708, d4_b706);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int d0_b77 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b709 = DataCanbus.DATA[99];
                int d2_b709 = DataCanbus.DATA[100];
                int d3_b709 = DataCanbus.DATA[101];
                int d4_b707 = DataCanbus.DATA[102] - 10;
                if (d4_b707 < 0) {
                    d4_b707 = 0;
                }
                setCarInfo((d0_b77 << 7) & 128, d1_b709, d2_b709, d3_b709, d4_b707);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int d0_b78 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b7010 = DataCanbus.DATA[99];
                int d2_b7010 = DataCanbus.DATA[100];
                int d3_b7010 = DataCanbus.DATA[101];
                int d4_b708 = DataCanbus.DATA[102] + 10;
                if (d4_b708 > 255) {
                    d4_b708 = 255;
                }
                setCarInfo((d0_b78 << 7) & 128, d1_b7010, d2_b7010, d3_b7010, d4_b708);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int d0_b79 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b7011 = DataCanbus.DATA[99];
                int d2_b7011 = DataCanbus.DATA[100];
                int d3_b7011 = DataCanbus.DATA[101];
                int d4_b709 = DataCanbus.DATA[102];
                if (d0_b79 == 1) {
                    d0_b79 = 0;
                } else if (d0_b79 == 0) {
                    d0_b79 = 1;
                }
                setCarInfo((d0_b79 << 7) & 128, d1_b7011, d2_b7011, d3_b7011, d4_b709);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4, int value5) {
        DataCanbus.PROXY.cmd(7, new int[]{value1, value2, value3, value4, value5}, null, null);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }
}
