package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

public class RzcBenzCCarSet extends BaseActivity implements View.OnClickListener {
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
                case 100:
                    RzcBenzCCarSet.this.setCheck((CheckedTextView) RzcBenzCCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 101:
                    RzcBenzCCarSet.this.updateLauguageSet();
                    break;
                case 107:
                    if (((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)).setText("---");
                                break;
                            case 1:
                                ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)).setText("Screen 6.0");
                                break;
                            case 2:
                                ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)).setText("Screen 7.0");
                                break;
                            case 3:
                                ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)).setText("Screen 10.25");
                                break;
                        }
                    }
                    break;
                case 108:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text2)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text2)).setText("Draw");
                            break;
                        default:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text2)).setText("Normal");
                            break;
                    }
                case 109:
                    switch (value) {
                        case 6:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text3)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text3)).setText("1280x720@25Hz");
                            break;
                        default:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text3)).setText("1280x720@30Hz");
                            break;
                    }
                case 110:
                    ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " ℃");
                    break;
                case 111:
                    ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " ℃");
                    break;
                case 112:
                    ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 113:
                    ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " hp");
                    break;
                case 114:
                    ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " lbft");
                    break;
                case 136:
                    ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                    break;
                case 137:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_aux_activation_state0);
                            break;
                        case 2:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_aux_activation_state2);
                            break;
                        case 3:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_aux_activation_state1);
                            break;
                        default:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text10)).setText("");
                            break;
                    }
                case 138:
                    if ((value & 128) != 0) {
                        ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text11)).setText("-" + (256 - value));
                        break;
                    } else {
                        ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 139:
                    if ((value & 128) != 0) {
                        ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text12)).setText("-" + (256 - value));
                        break;
                    } else {
                        ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_rzc_benz_c_settings);
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
                RzcBenzCCarSet.this.language_set = position;
                if (RzcBenzCCarSet.this.language_set >= 0 && RzcBenzCCarSet.this.language_set <= RzcBenzCCarSet.this.mLauStylelist.size() && RzcBenzCCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{1, 1, RzcBenzCCarSet.this.send_lang[RzcBenzCCarSet.this.language_set]}, null, null);
                }
                RzcBenzCCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_42));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_43));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RzcBenzCCarSet.this.mLauStyle == null) {
                    RzcBenzCCarSet.this.initLauStyle();
                }
                if (RzcBenzCCarSet.this.mLauStyle != null && RzcBenzCCarSet.this.mPopShowView != null) {
                    RzcBenzCCarSet.this.mLauStyle.showAtLocation(RzcBenzCCarSet.this.mPopShowView, 17, 0, 0);
                    RzcBenzCCarSet.this.updateLauguageSet();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_RZC_Benz_14ML350 /* 11665847 */:
            case FinalCanbus.CAR_439_RZC_Benz_14ML320 /* 11731383 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_aux_activation_progress1));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{65, 133, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{65, 133}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value2 = DataCanbus.DATA[107] - 1;
                if (value2 < 1) {
                    value2 = 3;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[107] + 1;
                if (value3 > 3) {
                    value3 = 1;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value4 = DataCanbus.DATA[108] - 1;
                if (value4 < 1) {
                    value4 = 2;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value5 = DataCanbus.DATA[108] + 1;
                if (value5 > 2) {
                    value5 = 1;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value6 = DataCanbus.DATA[109] - 1;
                if (value6 < 6) {
                    value6 = 7;
                }
                setCarInfo(6, value6);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value7 = DataCanbus.DATA[109] + 1;
                if (value7 > 7) {
                    value7 = 6;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarInfo(7, 1);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarInfo(7, 2);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarInfo(8, 1);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarInfo(8, 2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[100] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog();
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZCBenzPanelButtonSet.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{65, 128}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{65, 2}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{65, 3}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
    }
}
