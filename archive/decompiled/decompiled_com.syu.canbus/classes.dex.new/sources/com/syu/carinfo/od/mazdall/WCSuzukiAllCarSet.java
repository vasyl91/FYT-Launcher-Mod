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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCSuzukiAllCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 137:
                    if (((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
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
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 139:
                    if (((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text2)) != null) {
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
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 141:
                    if (((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text3)) != null) {
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
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 143:
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 144:
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 145:
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 146:
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 147:
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 148:
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 149:
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 150:
                    WCSuzukiAllCarSet.this.setCheck((CheckedTextView) WCSuzukiAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 164:
                    if (((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_244_als2);
                                break;
                            default:
                                ((TextView) WCSuzukiAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_244_als1);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_suzukiall_settings);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
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

    @Override // com.syu.canbus.BaseActivity
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllCarSet.3
            @Override // android.view.View.OnClickListener
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[137] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[137] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[139] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(17, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[139] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(17, value4, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[141] - 1;
                if (value5 < 1) {
                    value5 = 3;
                }
                setCarInfo(33, value5, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[141] + 1;
                if (value6 > 3) {
                    value6 = 1;
                }
                setCarInfo(33, value6, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[164] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(97, value7, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[164] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(97, value8, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value9 = DataCanbus.DATA[138];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(2, value9, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value10 = DataCanbus.DATA[143];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(50, value10, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value11 = DataCanbus.DATA[144];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(51, value11, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value12 = DataCanbus.DATA[140];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(18, value12, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value13 = DataCanbus.DATA[142];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(49, value13, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value14 = DataCanbus.DATA[145];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(52, value14, 0, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value15 = DataCanbus.DATA[146];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(53, value15, 0, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value16 = DataCanbus.DATA[147];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(54, value16, 0, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value17 = DataCanbus.DATA[148];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(55, value17, 0, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value18 = DataCanbus.DATA[149];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(56, value18, 0, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value19 = DataCanbus.DATA[150];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(65, value19, 0, 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                dialog(R.string.all_settings, 81);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                if (DataCanbus.DATA[142] == 1) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(this, WCSuzukiAlertCarInfo.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                if (DataCanbus.DATA[150] == 1) {
                    try {
                        Intent intent2 = new Intent();
                        intent2.setClass(this, WCSuzukiWarnCarInfo.class);
                        startActivity(intent2);
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
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
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
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
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllCarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllCarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WCSuzukiAllCarSet.this.setCarInfo(i, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllCarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllCarSet.5.1
                    @Override // java.lang.Runnable
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
