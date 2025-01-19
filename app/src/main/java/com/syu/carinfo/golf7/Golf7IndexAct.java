package com.syu.carinfo.golf7;

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
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

public class Golf7IndexAct extends BaseActivity {
    int language_set = 255;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_index);
        init();
        DataCanbus.PROXY.cmd(98, new int[]{255}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        switch (DataCanbus.sCanbusId) {
            case 17:
            case FinalCanbus.CAR_WC2_17MaiTeng_DZSJ1 /* 524305 */:
            case FinalCanbus.CAR_WC2_MQB /* 589841 */:
            case FinalCanbus.CAR_WC2_MQB_Hybrid /* 655377 */:
            case FinalCanbus.CAR_WC2_MQB_AllView /* 720913 */:
            case FinalCanbus.CAR_WC2_MQB_Golf_Sportsvan_16 /* 786449 */:
            case FinalCanbus.CAR_WC2_MQB_Passat_17_18 /* 851985 */:
            case FinalCanbus.CAR_WC2_MQB_Passat_19 /* 917521 */:
            case FinalCanbus.CAR_WC2_MQB_Variant_16_18 /* 983057 */:
            case FinalCanbus.CAR_WC2_MQB_Bora_19 /* 1048593 */:
            case FinalCanbus.CAR_WC2_MQB_CC_19 /* 1114129 */:
            case FinalCanbus.CAR_WC2_MQB_Polo_19 /* 1179665 */:
            case FinalCanbus.CAR_WC2_MQB_Jetta_Brazil /* 1245201 */:
            case FinalCanbus.CAR_WC2_MQB_TIGUANL_17_20 /* 1310737 */:
            case FinalCanbus.CAR_WC2_MQB_TIGUANL_17_20_H /* 1376273 */:
            case FinalCanbus.CAR_WC2_MQB_Octavia_13_14 /* 1441809 */:
            case FinalCanbus.CAR_WC2_MQB_Octavia_15_19 /* 1507345 */:
            case FinalCanbus.CAR_WC2_MQB_Superb_16_18 /* 1572881 */:
            case FinalCanbus.CAR_WC2_MQB_KAMIQ_18 /* 1638417 */:
            case FinalCanbus.CAR_WC2_MQB_KAROQ_18_19 /* 1703953 */:
            case FinalCanbus.CAR_WC2_MQB_Caravelle_14_18 /* 1769489 */:
            case FinalCanbus.CAR_WC2_MQB_Jetta_VS5_19 /* 1835025 */:
            case FinalCanbus.CAR_WC2_MQB_Lavida_plus_19 /* 1900561 */:
            case FinalCanbus.CAR_WC2_MQB_Sagitar_19 /* 1966097 */:
            case FinalCanbus.CAR_WC2_MQB_Tharu_19 /* 2031633 */:
            case FinalCanbus.CAR_WC2_MQB_T_Cross_19 /* 2097169 */:
            case FinalCanbus.CAR_WC2_MQB_TouranL_16_18 /* 2162705 */:
            case FinalCanbus.CAR_WC2_MQB_Trek_17_18 /* 2228241 */:
            case FinalCanbus.CAR_WC2_MQB_Tange_19 /* 2293777 */:
            case FinalCanbus.CAR_WC2_MQB_Tayron_19 /* 2359313 */:
            case FinalCanbus.CAR_WC2_MQB_Multivan_19 /* 2424849 */:
            case FinalCanbus.CAR_WC2_MQB_Superb_Turkey /* 2490385 */:
            case FinalCanbus.CAR_WC2_MQB_Huiang_21 /* 2555921 */:
            case FinalCanbus.CAR_WC2_MQB_Viloran_20 /* 2621457 */:
            case FinalCanbus.CAR_WC2_MQB_Jetta_VS7_20 /* 2686993 */:
            case FinalCanbus.CAR_WC2_MQB_Tayron_GTE_20 /* 2752529 */:
            case FinalCanbus.CAR_WC2_MQB_Golf8_21 /* 2818065 */:
                setViewVisible(findViewById(R.id.all_func_btn_lauguage_set_view), true);
                break;
            default:
                if (ConstGolf.isRZCGolf()) {
                    setViewVisible(findViewById(R.id.all_func_btn_lauguage_set_view), true);
                    break;
                } else {
                    setViewVisible(findViewById(R.id.all_func_btn_lauguage_set_view), false);
                    break;
                }
        }
        if (!ConstGolf.isRZCGolf() && DataCanbus.DATA[1000] != 327697 && DataCanbus.DATA[1000] != 589841 && DataCanbus.DATA[1000] != 720913 && DataCanbus.DATA[1000] != 655377 && DataCanbus.DATA[1000] != 786449 && DataCanbus.DATA[1000] != 851985 && DataCanbus.DATA[1000] != 917521 && DataCanbus.DATA[1000] != 983057 && DataCanbus.DATA[1000] != 1048593 && DataCanbus.DATA[1000] != 1114129 && DataCanbus.DATA[1000] != 1179665 && DataCanbus.DATA[1000] != 1245201 && DataCanbus.DATA[1000] != 1310737 && DataCanbus.DATA[1000] != 1376273 && DataCanbus.DATA[1000] != 1441809 && DataCanbus.DATA[1000] != 1507345 && DataCanbus.DATA[1000] != 1572881 && DataCanbus.DATA[1000] != 1638417 && DataCanbus.DATA[1000] != 1703953 && DataCanbus.DATA[1000] != 1769489 && DataCanbus.DATA[1000] != 1835025 && DataCanbus.DATA[1000] != 1900561 && DataCanbus.DATA[1000] != 1966097 && DataCanbus.DATA[1000] != 2031633 && DataCanbus.DATA[1000] != 2097169 && DataCanbus.DATA[1000] != 2162705 && DataCanbus.DATA[1000] != 2228241 && DataCanbus.DATA[1000] != 2293777 && DataCanbus.DATA[1000] != 2359313 && DataCanbus.DATA[1000] != 2424849 && DataCanbus.DATA[1000] != 2490385 && DataCanbus.DATA[1000] != 2555921 && DataCanbus.DATA[1000] != 2621457 && DataCanbus.DATA[1000] != 2686993 && DataCanbus.DATA[1000] != 2752529 && DataCanbus.DATA[1000] != 2818065 && findViewById(R.id.golf_view_tmps) != null) {
            findViewById(R.id.golf_view_tmps).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 196625 || DataCanbus.DATA[1000] == 262161 || DataCanbus.DATA[1000] == 327697 || DataCanbus.DATA[1000] == 196768) {
            findViewById(R.id.layout_air_control).setVisibility(0);
        } else {
            findViewById(R.id.layout_air_control).setVisibility(8);
        }
        DataCanbus.PROXY.cmd(98, new int[]{255}, null, null);
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        if (DataCanbus.DATA[1000] == 17 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065 || DataCanbus.DATA[1000] == 524305) {
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
            this.send_lang = new int[]{2, 1, 1, 3, 4, 5, 6, 7, 8, 9, 11, 1, 1, 16, 1, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
            if (this.send_lang.length != this.mLauStylelist.size()) {
                throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
            }
        } else if (ConstGolf.isRZCGolf()) {
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_23));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
            this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_24));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
            this.mLauStylelist.add("BiH");
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_34));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_24));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_11));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_25));
            this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
            this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 16, 17, 18, 20, 22, 23, 26, 29, 30, 31, 32, 33, 37, 38, 39, 40, 41, 42, 43};
            if (this.send_lang.length != this.mLauStylelist.size()) {
                throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
            }
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Golf7IndexAct.this.mLauStyle == null) {
                    Golf7IndexAct.this.initLauStyle();
                }
                if (Golf7IndexAct.this.mLauStyle != null && Golf7IndexAct.this.mPopShowView != null) {
                    Golf7IndexAct.this.mLauStyle.showAtLocation(Golf7IndexAct.this.mPopShowView, 17, 0, 0);
                    Golf7IndexAct.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_main_btn_functional_state), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7IndexAct.this, Golf7FunctionalActi.class);
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_main_btn_air_control), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 196625 || DataCanbus.DATA[1000] == 262161 || DataCanbus.DATA[1000] == 327697 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
                        intent.setClass(Golf7IndexAct.this, AirControlMQB_WC_Front.class);
                    } else if (DataCanbus.DATA[1000] == 262304 || DataCanbus.DATA[1000] == 721056 || DataCanbus.DATA[1000] == 3473568) {
                        intent.setClass(Golf7IndexAct.this, AirControlMQB_RZC_Front.class);
                    }
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_main_btn_oil_mileage), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7IndexAct.this, Golf7OilMileageIndexActi.class);
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_main_electric_mileage), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7IndexAct.this, Golf7ElectricMileageIndexActi.class);
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 655377) {
            findViewById(R.id.golf_view_main_electric_mileage).setVisibility(0);
        } else {
            findViewById(R.id.golf_view_main_electric_mileage).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_main_electric_information), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 655520 || DataCanbus.DATA[1000] == 3801248) {
                        intent.setClass(Golf7IndexAct.this, Golf7Electric_information_Acti_RZC.class);
                    } else {
                        intent.setClass(Golf7IndexAct.this, Golf7Electric_information_Acti.class);
                    }
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 655520 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 3801248) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7IndexAct.this, Golf7Electric_management_Acti_RZC.class);
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 655520 || DataCanbus.DATA[1000] == 3801248) {
            findViewById(R.id.golf_view_main_electric_information).setVisibility(0);
        } else {
            findViewById(R.id.golf_view_main_electric_information).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.hy_brid_car), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7IndexAct.this, Golf7FunctionalHybridCarActi.class);
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 655377) {
            findViewById(R.id.hy_brid_car_view).setVisibility(0);
        } else {
            findViewById(R.id.hy_brid_car_view).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_main_btn_convenience_consumers), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7IndexAct.this, Golf7ConvenienceAct.class);
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_main_btn_maintenance_information), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7IndexAct.this, Golf7MaintenanceActi.class);
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_main_btn_alarm_record), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7IndexAct.this, Golf7AlarmRecordAct.class);
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_main_btn_start_stop), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7IndexAct.this, Golf7StartStopAct.class);
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_main_btn_tire_pressure), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 196625 || ConstGolf.isRZCGolf()) {
                        intent.setClass(Golf7IndexAct.this, RzcGolfPressureTireAct.class);
                    } else if (DataCanbus.DATA[1000] == 327697 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
                        intent.setClass(Golf7IndexAct.this, GolfTireAct_TuAng_Wc.class);
                    }
                    Golf7IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
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
                Golf7IndexAct.this.language_set = position;
                if (Golf7IndexAct.this.language_set >= 0 && Golf7IndexAct.this.language_set <= Golf7IndexAct.this.mLauStylelist.size() && Golf7IndexAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(96, new int[]{Golf7IndexAct.this.send_lang[Golf7IndexAct.this.language_set]}, null, null);
                }
                Golf7IndexAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }
}
