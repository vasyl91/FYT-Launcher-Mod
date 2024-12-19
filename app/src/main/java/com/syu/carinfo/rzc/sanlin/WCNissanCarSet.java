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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WCNissanCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WCNissanCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 90:
                    if (((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 91:
                    if (((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text1)).setText("R" + value);
                            break;
                        } else if (value < 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text1)).setText("L" + (0 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 92:
                    if (((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text2)).setText("F" + value);
                            break;
                        } else if (value < 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text2)).setText("R" + (0 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 93:
                    if (((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text3)).setText("+" + value);
                            break;
                        } else if (value < 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (0 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 94:
                    if (((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text4)).setText("+" + value);
                            break;
                        } else if (value < 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (0 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 95:
                    if (((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text5)).setText("+" + value);
                            break;
                        } else if (value < 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (0 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 96:
                    WCNissanCarSet.this.setCheck((CheckedTextView) WCNissanCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 97:
                    WCNissanCarSet.this.setCheck((CheckedTextView) WCNissanCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 98:
                    if (((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        if (value > 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text8)).setText("+" + value);
                            break;
                        } else if (value < 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text8)).setText("-" + (0 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) WCNissanCarSet.this.findViewById(R.id.tv_text8)).setText("0");
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
        setContentView(R.layout.layout_0101_wc_nissan_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.WCNissanCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                WCNissanCarSet.this.language_set = position;
                if (WCNissanCarSet.this.language_set >= 0 && WCNissanCarSet.this.language_set <= WCNissanCarSet.this.mLauStylelist.size() && WCNissanCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(3, new int[]{1, WCNissanCarSet.this.send_lang[WCNissanCarSet.this.language_set]}, null, null);
                }
                WCNissanCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 22, 23, 24, 25, 26, 27};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.WCNissanCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WCNissanCarSet.this.mLauStyle == null) {
                    WCNissanCarSet.this.initLauStyle();
                }
                if (WCNissanCarSet.this.mLauStyle != null && WCNissanCarSet.this.mPopShowView != null) {
                    WCNissanCarSet.this.mLauStyle.showAtLocation(WCNissanCarSet.this.mPopShowView, 17, 0, 0);
                    WCNissanCarSet.this.updateLauguageSet();
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
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        if (DataCanbus.DATA[1000] == 983141) {
            findViewById(R.id.layout_text_view1).setVisibility(0);
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
            findViewById(R.id.layout_view9).setVisibility(0);
            findViewById(R.id.layout_view10).setVisibility(0);
            return;
        }
        findViewById(R.id.layout_text_view1).setVisibility(8);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[96];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(10, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setCarInfo(2, 255);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarInfo(2, 1);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarInfo(3, 255);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarInfo(3, 1);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setCarInfo(4, 255);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setCarInfo(4, 1);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setCarInfo(5, 255);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setCarInfo(5, 1);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setCarInfo(6, 255);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setCarInfo(6, 1);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setCarInfo(1, 255);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarInfo(1, 1);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setCarInfo(7, 255);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setCarInfo(7, 1);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                setCarInfo(8, 255);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                setCarInfo(8, 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value2 = DataCanbus.DATA[97];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setCarInfo(9, value2);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }
}
