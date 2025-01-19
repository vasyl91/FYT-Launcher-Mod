package com.syu.carinfo.od.mazdall;

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

import java.util.ArrayList;

public class WCSuzukiAllCarSet extends BaseActivity implements View.OnClickListener {
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
                case 137:
                    if (WCSuzukiAllCarSet.this.findViewById(R.id.tv_text1) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_associated_with_door);
                                break;
                            case 2:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_associated_with_lighting_door);
                                break;
                            default:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 138:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 139:
                    if (WCSuzukiAllCarSet.this.findViewById(R.id.tv_text2) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_twice);
                                break;
                            default:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_165_cycle_one);
                                break;
                        }
                    }
                    break;
                case 140:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 141:
                    if (WCSuzukiAllCarSet.this.findViewById(R.id.tv_text3) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.driver_system_standard);
                                break;
                            case 3:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.driver_system_economics);
                                break;
                            default:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 142:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 143:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 144:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 145:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 146:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 147:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 148:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 149:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 150:
                    WCSuzukiAllCarSet.this.setCheck(WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_suzukiall_settings);
        init();
    }

    
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter(new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                WCSuzukiAllCarSet.this.language_set = position;
                if (WCSuzukiAllCarSet.this.language_set >= 0 && WCSuzukiAllCarSet.this.language_set <= WCSuzukiAllCarSet.this.mLauStylelist.size() && WCSuzukiAllCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{WCSuzukiAllCarSet.this.send_lang[WCSuzukiAllCarSet.this.language_set]}, null, null);
                }
                WCSuzukiAllCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.mLauStylelist.add("Rome");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add("Slovakia");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_11));
        this.mLauStylelist.add("Flemish");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_17));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_19));
        this.mLauStylelist.add("Persia");
        this.mLauStylelist.add("Latvia");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_25));
        this.mLauStylelist.add("Slovenia");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_36));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 18, 20, 22, 23, 24, 25, 26, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick(findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (WCSuzukiAllCarSet.this.mLauStyle == null) {
                    WCSuzukiAllCarSet.this.initLauStyle();
                }
                if (WCSuzukiAllCarSet.this.mLauStyle != null && WCSuzukiAllCarSet.this.mPopShowView != null) {
                    WCSuzukiAllCarSet.this.mLauStyle.showAtLocation(WCSuzukiAllCarSet.this.mPopShowView, 17, 0, 0);
                    WCSuzukiAllCarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[137] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[137] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[139] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(17, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[139] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(17, value4, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[141] - 1;
                if (value5 < 1) {
                    value5 = 3;
                }
                setCarInfo(33, value5, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[141] + 1;
                if (value6 > 3) {
                    value6 = 1;
                }
                setCarInfo(33, value6, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[138];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(2, value7, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value8 = DataCanbus.DATA[140];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(18, value8, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value9 = DataCanbus.DATA[142];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(49, value9, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value10 = DataCanbus.DATA[143];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(50, value10, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value11 = DataCanbus.DATA[144];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(51, value11, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value12 = DataCanbus.DATA[145];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(52, value12, 0, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value13 = DataCanbus.DATA[146];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(53, value13, 0, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value14 = DataCanbus.DATA[147];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(54, value14, 0, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value15 = DataCanbus.DATA[148];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(55, value15, 0, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value16 = DataCanbus.DATA[149];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(56, value16, 0, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value17 = DataCanbus.DATA[150];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(65, value17, 0, 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                dialog(R.string.all_settings, 81);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                if (DataCanbus.DATA[142] == 1) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(this, WCSuzukiAlertCarInfo.class);
                        startActivity(intent);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                if (DataCanbus.DATA[150] == 1) {
                    try {
                        Intent intent2 = new Intent();
                        intent2.setClass(this, WCSuzukiWarnCarInfo.class);
                        startActivity(intent2);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2, value3, value4}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm_reset) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        WCSuzukiAllCarSet.this.setCarInfo(i, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        WCSuzukiAllCarSet.this.setCarInfo(i, 0, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
