package com.syu.carinfo.wc2.ford;

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
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC2FordLincoinCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    WC2FordLincoinCarSettingsAct.this.updateTempUnit(val);
                    break;
                case 104:
                    WC2FordLincoinCarSettingsAct.this.updateLauguageSet();
                    break;
                case 105:
                    WC2FordLincoinCarSettingsAct.this.updateMeasure(val);
                    break;
                case 106:
                    WC2FordLincoinCarSettingsAct.this.updateAmbientLight(val);
                    break;
                case 107:
                    WC2FordLincoinCarSettingsAct.this.updaterCameraDelay(val);
                    break;
                case 108:
                    WC2FordLincoinCarSettingsAct.this.updaterradarDisplay(val);
                    break;
                case 159:
                    ((CheckedTextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(val != 0);
                    break;
                case 160:
                    ((CheckedTextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(val != 0);
                    break;
                case 161:
                    ((TextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                    break;
                case 162:
                    ((CheckedTextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(val != 0);
                    break;
                case 163:
                    ((CheckedTextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(val != 0);
                    break;
                case 165:
                    ((CheckedTextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(val != 0);
                    if (val == 1) {
                        ((TextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_air_conditioning_board_upgrade);
                        break;
                    } else {
                        ((TextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_protocol_box_upgrade);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_ford_lincoin_car_settings_act);
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
                WC2FordLincoinCarSettingsAct.this.language_set = position;
                if (WC2FordLincoinCarSettingsAct.this.language_set >= 0 && WC2FordLincoinCarSettingsAct.this.language_set <= WC2FordLincoinCarSettingsAct.this.mLauStylelist.size() && WC2FordLincoinCarSettingsAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(7, new int[]{WC2FordLincoinCarSettingsAct.this.send_lang[WC2FordLincoinCarSettingsAct.this.language_set]}, null, null);
                }
                WC2FordLincoinCarSettingsAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[104];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.send_lang = new int[]{1, 2, 5, 7, 27};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (WC2FordLincoinCarSettingsAct.this.mLauStyle == null) {
                    WC2FordLincoinCarSettingsAct.this.initLauStyle();
                }
                if (WC2FordLincoinCarSettingsAct.this.mLauStyle != null && WC2FordLincoinCarSettingsAct.this.mPopShowView != null) {
                    WC2FordLincoinCarSettingsAct.this.mLauStyle.showAtLocation(WC2FordLincoinCarSettingsAct.this.mPopShowView, 17, 0, 0);
                    WC2FordLincoinCarSettingsAct.this.updateLauguageSet();
                }
            }
        });
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext9), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_JMC_Fusun_24 /* 2687420 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                findViewById(R.id.layout_view9).setVisibility(8);
                findViewById(R.id.layout_view10).setVisibility(8);
                findViewById(R.id.layout_view11).setVisibility(8);
                return;
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                return;
            default:
                return;
        }
    }

    @Override
    public void onClick(View v) {
        int data0 = 0;
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        int data4 = 0;
        switch (v.getId()) {
            case R.id.btn_minus2 /* 2131427458 */:
                data0 = 4;
                data1 = 111;
                data2 = 3;
                data3 = DataCanbus.DATA[106] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                data0 = 4;
                data1 = 111;
                data2 = 3;
                data3 = DataCanbus.DATA[106] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                data0 = 4;
                data1 = 111;
                data2 = 2;
                data3 = DataCanbus.DATA[161] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
            case R.id.btn_plus3 /* 2131427463 */:
                data0 = 4;
                data1 = 111;
                data2 = 2;
                data3 = DataCanbus.DATA[161] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                data0 = 2;
                data1 = 242;
                data2 = 6;
                if (DataCanbus.DATA[107] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int data02 = DataCanbus.DATA[108] == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(4, new int[]{data02}, null, null);
                return;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                data0 = 2;
                data1 = 108;
                data2 = 5;
                if (DataCanbus.DATA[105] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                data0 = 2;
                data1 = 109;
                data2 = 4;
                if (DataCanbus.DATA[37] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                data0 = 2;
                data1 = 242;
                data2 = 11;
                if (DataCanbus.DATA[159] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                data0 = 2;
                data1 = 242;
                data2 = 10;
                if (DataCanbus.DATA[160] != 1) {
                    data3 = 1;
                    break;
                } else {
                    data3 = 0;
                    break;
                }
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int data03 = DataCanbus.DATA[162] == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(5, new int[]{23, data03, 255, 255}, null, null);
                return;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int data04 = DataCanbus.DATA[163] == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(5, new int[]{22, data04, 255, 255}, null, null);
                return;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int data05 = DataCanbus.DATA[165] == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(5, new int[]{19, data05, 255, 255}, null, null);
                return;
        }
        if (1 != 0) {
            sendCmd(data0, data1, data2, data3, data4, 0);
        }
    }

    private void sendCmd(int data0, int data1, int data2, int data3, int data4, int data5) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateTempUnit(int value) {
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_15ruijie_temp_unit_c_set);
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_15ruijie_temp_unit_f_set);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    
    public void updateAmbientLight(int value) {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                switch (value) {
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_white_str);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_background_amber);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_blue_green_str);
                        break;
                    case 4:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                        break;
                    case 5:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                        break;
                    case 6:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_background_green);
                        break;
                    case 7:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_lavender_str);
                        break;
                    default:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                        break;
                }
            default:
                switch (value) {
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_ice_blue);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_orange_str);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_2);
                        break;
                    case 4:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                        break;
                    case 5:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_4);
                        break;
                    case 6:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                        break;
                    case 7:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_6);
                        break;
                    default:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                        break;
                }
        }
    }

    
    public void updateMeasure(int value) {
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_format_set1);
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_format_set0);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    
    public void updaterCameraDelay(int value) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }

    
    public void updaterradarDisplay(int value) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }
}
