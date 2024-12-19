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
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCFordEDGECarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.XCFordEDGECarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text1)).setText("℃");
                                break;
                            case 1:
                                ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text1)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 86:
                    XCFordEDGECarSet.this.updateLauguageSet();
                    break;
                case 88:
                    ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                    break;
                case 89:
                    if (val > 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text3)).setText("R" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text3)).setText("L" + (7 - val));
                        break;
                    } else {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text3)).setText("0");
                        break;
                    }
                case 90:
                    if (val > 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text4)).setText("R" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text4)).setText("F" + (7 - val));
                        break;
                    } else {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    }
                case 91:
                    if (val > 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text5)).setText("+" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text5)).setText("-" + (7 - val));
                        break;
                    } else {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    }
                case 92:
                    if (val > 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text6)).setText("+" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text6)).setText("-" + (7 - val));
                        break;
                    } else {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text6)).setText("0");
                        break;
                    }
                case 93:
                    if (val > 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text7)).setText("+" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text7)).setText("-" + (7 - val));
                        break;
                    } else {
                        ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text7)).setText("0");
                        break;
                    }
                case 94:
                    ((TextView) XCFordEDGECarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_xc_ford_edge_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.XCFordEDGECarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                XCFordEDGECarSet.this.language_set = position;
                if (XCFordEDGECarSet.this.language_set >= 0 && XCFordEDGECarSet.this.language_set <= XCFordEDGECarSet.this.mLauStylelist.size() && XCFordEDGECarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{DataCanbus.DATA[37], XCFordEDGECarSet.this.send_lang[XCFordEDGECarSet.this.language_set]}, null, null);
                }
                XCFordEDGECarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[86];
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

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_XC_Ford_EDGE_L /* 16122309 */:
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                break;
            case FinalCanbus.CAR_453_XC_Ford_EDGE_H /* 16187845 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
        }
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.XCFordEDGECarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (XCFordEDGECarSet.this.mLauStyle == null) {
                    XCFordEDGECarSet.this.initLauStyle();
                }
                if (XCFordEDGECarSet.this.mLauStyle != null && XCFordEDGECarSet.this.mPopShowView != null) {
                    XCFordEDGECarSet.this.mLauStyle.showAtLocation(XCFordEDGECarSet.this.mPopShowView, 17, 0, 0);
                    XCFordEDGECarSet.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[37] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value, DataCanbus.DATA[86]}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[37] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value2, DataCanbus.DATA[86]}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[88];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(0, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[89];
                if (value4 < 30) {
                    value4++;
                }
                setCarInfo(0, value4);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value5 = DataCanbus.DATA[89];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(1, value5);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value6 = DataCanbus.DATA[89];
                if (value6 < 14) {
                    value6++;
                }
                setCarInfo(1, value6);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = DataCanbus.DATA[90];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(2, value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = DataCanbus.DATA[90];
                if (value8 < 14) {
                    value8++;
                }
                setCarInfo(2, value8);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value9 = DataCanbus.DATA[91];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(3, value9);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value10 = DataCanbus.DATA[91];
                if (value10 < 14) {
                    value10++;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value11 = DataCanbus.DATA[92];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(4, value11);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value12 = DataCanbus.DATA[92];
                if (value12 < 14) {
                    value12++;
                }
                setCarInfo(4, value12);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value13 = DataCanbus.DATA[93];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(5, value13);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value14 = DataCanbus.DATA[93];
                if (value14 < 14) {
                    value14++;
                }
                setCarInfo(5, value14);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value15 = DataCanbus.DATA[94];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(6, value15);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value16 = DataCanbus.DATA[94];
                if (value16 < 7) {
                    value16++;
                }
                setCarInfo(6, value16);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
    }
}
