package com.syu.carinfo.klc;

import android.content.Intent;
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
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.carinfo.xp.yinglang.YLTireAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

public class KlcIndexAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 188:
                    updateTmpsenable();
                    break;
            }
        }

        private void updateTmpsenable() {
            int val = DataCanbus.DATA[188] >> 7;
            if (val == 1) {
                KlcIndexAct.this.findViewById(R.id.wc_yl_tmps_view).setVisibility(0);
            } else {
                KlcIndexAct.this.findViewById(R.id.wc_yl_tmps_view).setVisibility(8);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_klc_index);
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
                KlcIndexAct.this.language_set = position;
                if (KlcIndexAct.this.language_set >= 0 && KlcIndexAct.this.language_set <= KlcIndexAct.this.mLauStylelist.size() && KlcIndexAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(96, new int[]{KlcIndexAct.this.send_lang[KlcIndexAct.this.language_set]}, null, null);
                }
                KlcIndexAct.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add("Thai");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (KlcIndexAct.this.mLauStyle == null) {
                    KlcIndexAct.this.initLauStyle();
                }
                if (KlcIndexAct.this.mLauStyle != null && KlcIndexAct.this.mPopShowView != null) {
                    KlcIndexAct.this.mLauStyle.showAtLocation(KlcIndexAct.this.mPopShowView, 17, 0, 0);
                    KlcIndexAct.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.klc_car_settings_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_air_message_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_comfort_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_onstar_set_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_air_control_set_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_pannel_select_set_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_tmps_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_car_set_basic_info_check)).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 589860) {
            findViewById(R.id.klc_onstar_view).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.klc_air_control_view).setVisibility(8);
            findViewById(R.id.wc_yl_comfornt_view).setVisibility(8);
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.glf7_view_baseinfo).setVisibility(8);
        } else {
            if (LauncherApplication.getConfiguration() == 1) {
                findViewById(R.id.klc_air_control_view).setVisibility(8);
            } else {
                findViewById(R.id.klc_air_control_view).setVisibility(0);
            }
            findViewById(R.id.klc_onstar_view).setVisibility(0);
            findViewById(R.id.wc_yl_comfornt_view).setVisibility(0);
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.glf7_view_baseinfo).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 36) {
            findViewById(R.id.klc_pannel_select).setVisibility(0);
        } else {
            findViewById(R.id.klc_pannel_select).setVisibility(8);
        }
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Intent intent2;
        int id = v.getId();
        switch (id) {
            case R.id.klc_car_settings_check /* 2131431864 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) KlcCarSettingsAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.klc_air_message_check /* 2131431865 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) klcAirMessageAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.klc_comfort_check /* 2131431866 */:
                try {
                    Intent intent5 = new Intent(this, (Class<?>) KlcComfortAct.class);
                    startActivity(intent5);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.klc_tmps_check /* 2131431868 */:
                try {
                    Intent intent6 = new Intent(this, (Class<?>) YLTireAct.class);
                    startActivity(intent6);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.klc_onstar_set_check /* 2131431869 */:
                try {
                    if (DataCanbus.DATA[1000] == 458788) {
                        intent2 = new Intent(this, (Class<?>) KlcOnStarGl6Act.class);
                    } else {
                        intent2 = new Intent(this, (Class<?>) KlcOnStarAct.class);
                    }
                    startActivity(intent2);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.klc_air_control_set_check /* 2131431871 */:
                try {
                    if (DataCanbus.DATA[1000] == 357) {
                        intent = new Intent(this, (Class<?>) MrbAirControlAct.class);
                    } else if (DataCanbus.DATA[1000] == 393252) {
                        intent = new Intent(this, (Class<?>) KlcGl8AirControlAct.class);
                    } else {
                        intent = new Intent(this, (Class<?>) Air_Activity_All_NewAdd_HP.class);
                    }
                    startActivity(intent);
                    break;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case R.id.klc_pannel_select_set_check /* 2131431873 */:
                try {
                    Intent intent7 = new Intent(this, (Class<?>) KlcPannelselectAct.class);
                    startActivity(intent7);
                    break;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
            case R.id.xp_yl_car_set_basic_info_check /* 2131431875 */:
                try {
                    Intent intent8 = new Intent(this, (Class<?>) WcGMBasicInfoAct.class);
                    startActivity(intent8);
                    break;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
        }
    }
}
