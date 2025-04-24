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
public class RZCXiandaiRohensCarSet extends BaseActivity implements View.OnClickListener {
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
                case 106:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_default);
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_vehicle_variables);
                                break;
                            case 3:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_shift_gears);
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_default);
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.bz408_warning_218);
                                break;
                            case 3:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_shift_gears);
                                break;
                            case 4:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_drivers_door_open);
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_default);
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_default);
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_default);
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                        }
                    }
                    break;
                case 111:
                    RZCXiandaiRohensCarSet.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0362_rzc_rohens_settings);
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
                RZCXiandaiRohensCarSet.this.language_set = position;
                if (RZCXiandaiRohensCarSet.this.language_set >= 0 && RZCXiandaiRohensCarSet.this.language_set <= RZCXiandaiRohensCarSet.this.mLauStylelist.size() && RZCXiandaiRohensCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(8, new int[]{RZCXiandaiRohensCarSet.this.send_lang[RZCXiandaiRohensCarSet.this.language_set]}, null, null);
                }
                RZCXiandaiRohensCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
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
        this.mLauStylelist.add("Francais(US)");
        this.mLauStylelist.add("Espanol(US)");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add("Magyar");
        this.mLauStylelist.add("HINDU");
        this.mLauStylelist.add("BANGLADES");
        this.mLauStylelist.add("TELUGU");
        this.mLauStylelist.add("TAMIL");
        this.mLauStylelist.add("GUJURATI");
        this.mLauStylelist.add("KANNADA");
        this.mLauStylelist.add("ODIA");
        this.mLauStylelist.add("MAYALAM");
        this.mLauStylelist.add("PUNJABI");
        this.mLauStylelist.add("PUNCHABI");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.send_lang = new int[]{0, 1, 2, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23, 24, 28, 31, 39, 40, 41, 42, 43, 44, 45, 46, 47, 129};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RZCXiandaiRohensCarSet.this.mLauStyle == null) {
                    RZCXiandaiRohensCarSet.this.initLauStyle();
                }
                if (RZCXiandaiRohensCarSet.this.mLauStyle != null && RZCXiandaiRohensCarSet.this.mPopShowView != null) {
                    RZCXiandaiRohensCarSet.this.mLauStyle.showAtLocation(RZCXiandaiRohensCarSet.this.mPopShowView, 17, 0, 0);
                    RZCXiandaiRohensCarSet.this.updateLauguageSet();
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[106] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(16, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[106] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(16, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[107] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(17, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[107] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(17, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[108] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(18, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[108] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(18, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[109] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(19, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[109] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(19, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[110] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(20, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[110] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(20, value10);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
    }
}
