package com.syu.carinfo.hechi.fordexplorer;

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

public class HcFordExplorerSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    HcFordExplorerSetFunc.this.updateText1(val);
                    break;
                case 100:
                    HcFordExplorerSetFunc.this.updateText2(val);
                    break;
                case 101:
                    HcFordExplorerSetFunc.this.updateLauguageSet();
                    break;
                case 102:
                    HcFordExplorerSetFunc.this.updateText4(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_hc_ford_explorer_settings);
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
                HcFordExplorerSetFunc.this.language_set = position;
                if (HcFordExplorerSetFunc.this.language_set >= 0 && HcFordExplorerSetFunc.this.language_set <= HcFordExplorerSetFunc.this.mLauStylelist.size() && HcFordExplorerSetFunc.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{83, HcFordExplorerSetFunc.this.send_lang[HcFordExplorerSetFunc.this.language_set]}, null, null);
                }
                HcFordExplorerSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[101];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{1, 8};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (HcFordExplorerSetFunc.this.mLauStyle == null) {
                    HcFordExplorerSetFunc.this.initLauStyle();
                }
                if (HcFordExplorerSetFunc.this.mLauStyle != null && HcFordExplorerSetFunc.this.mPopShowView != null) {
                    HcFordExplorerSetFunc.this.mLauStyle.showAtLocation(HcFordExplorerSetFunc.this.mPopShowView, 17, 0, 0);
                    HcFordExplorerSetFunc.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value3 = DataCanbus.DATA[99] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(84, value3);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value4 = DataCanbus.DATA[99] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(84, value4);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[100] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(82, value5);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value6 = DataCanbus.DATA[100] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(82, value6);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                if (DataCanbus.DATA[101] == 1) {
                    value2 = 8;
                } else {
                    value2 = 1;
                }
                setCarInfo(83, value2);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                if (DataCanbus.DATA[101] == 8) {
                    value = 1;
                } else {
                    value = 8;
                }
                setCarInfo(83, value);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[102] - 1;
                if (value7 < 1) {
                    value7 = 7;
                }
                setCarInfo(97, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[102] + 1;
                if (value8 > 7) {
                    value8 = 1;
                }
                setCarInfo(97, value8);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_ice_blue);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_orange_str);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_2);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_3);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_4);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_5);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_6);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_ice_blue);
                    break;
            }
        }
    }

    
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Mi");
                    break;
            }
        }
    }

    
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("℃");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("℉");
                    break;
            }
        }
    }
}
