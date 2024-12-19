package com.syu.carinfo.dasauto;

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
public class RZCBmwX1CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.RZCBmwX1CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 52:
                    if (((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)).setText("l/100km");
                                break;
                            case 1:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)).setText("mpg(US)");
                                break;
                            case 2:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)).setText("mpg(UK)");
                                break;
                            case 3:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)).setText("km/l");
                                break;
                        }
                    }
                    break;
                case 53:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text2)).setText("℃");
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text2)).setText("℉");
                            break;
                    }
                case 54:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text3)).setText("km");
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text3)).setText("mls");
                            break;
                    }
                case 55:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_1);
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_0);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0051_rzc_bmw_x1_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.dasauto.RZCBmwX1CarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RZCBmwX1CarSet.this.language_set = position;
                if (RZCBmwX1CarSet.this.language_set >= 0 && RZCBmwX1CarSet.this.language_set <= RZCBmwX1CarSet.this.mLauStylelist.size() && RZCBmwX1CarSet.this.send_lang != null) {
                    int fuelunit = DataCanbus.DATA[52];
                    int tempunit = DataCanbus.DATA[53];
                    int distanceunit = DataCanbus.DATA[54];
                    int timeformat = DataCanbus.DATA[55];
                    int language = RZCBmwX1CarSet.this.send_lang[RZCBmwX1CarSet.this.language_set];
                    int value = ((fuelunit << 6) & 192) | ((tempunit << 5) & 32) | ((distanceunit << 4) & 16) | ((timeformat << 3) & 8) | (language & 7);
                    RZCBmwX1CarSet.this.setCarInfo(value);
                }
                RZCBmwX1CarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_35));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_21));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.RZCBmwX1CarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RZCBmwX1CarSet.this.mLauStyle == null) {
                    RZCBmwX1CarSet.this.initLauStyle();
                }
                if (RZCBmwX1CarSet.this.mLauStyle != null && RZCBmwX1CarSet.this.mPopShowView != null) {
                    RZCBmwX1CarSet.this.mLauStyle.showAtLocation(RZCBmwX1CarSet.this.mPopShowView, 17, 0, 0);
                    RZCBmwX1CarSet.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                int fuelunit = DataCanbus.DATA[52];
                int tempunit = DataCanbus.DATA[53];
                int distanceunit = DataCanbus.DATA[54];
                int timeformat = DataCanbus.DATA[55];
                int language = DataCanbus.DATA[56];
                int fuelunit2 = fuelunit - 1;
                if (fuelunit2 < 0) {
                    fuelunit2 = 3;
                }
                int value = ((fuelunit2 << 6) & 192) | ((tempunit << 5) & 32) | ((distanceunit << 4) & 16) | ((timeformat << 3) & 8) | (language & 7);
                setCarInfo(value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int fuelunit3 = DataCanbus.DATA[52];
                int tempunit2 = DataCanbus.DATA[53];
                int distanceunit2 = DataCanbus.DATA[54];
                int timeformat2 = DataCanbus.DATA[55];
                int language2 = DataCanbus.DATA[56];
                int fuelunit4 = fuelunit3 + 1;
                if (fuelunit4 > 3) {
                    fuelunit4 = 0;
                }
                int value2 = ((fuelunit4 << 6) & 192) | ((tempunit2 << 5) & 32) | ((distanceunit2 << 4) & 16) | ((timeformat2 << 3) & 8) | (language2 & 7);
                setCarInfo(value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int fuelunit5 = DataCanbus.DATA[52];
                int tempunit3 = DataCanbus.DATA[53];
                int distanceunit3 = DataCanbus.DATA[54];
                int timeformat3 = DataCanbus.DATA[55];
                int language3 = DataCanbus.DATA[56];
                int tempunit4 = tempunit3 - 1;
                if (tempunit4 < 0) {
                    tempunit4 = 1;
                }
                int value3 = ((fuelunit5 << 6) & 192) | ((tempunit4 << 5) & 32) | ((distanceunit3 << 4) & 16) | ((timeformat3 << 3) & 8) | (language3 & 7);
                setCarInfo(value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int fuelunit6 = DataCanbus.DATA[52];
                int tempunit5 = DataCanbus.DATA[53];
                int distanceunit4 = DataCanbus.DATA[54];
                int timeformat4 = DataCanbus.DATA[55];
                int language4 = DataCanbus.DATA[56];
                int tempunit6 = tempunit5 + 1;
                if (tempunit6 > 1) {
                    tempunit6 = 0;
                }
                int value4 = ((fuelunit6 << 6) & 192) | ((tempunit6 << 5) & 32) | ((distanceunit4 << 4) & 16) | ((timeformat4 << 3) & 8) | (language4 & 7);
                setCarInfo(value4);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int fuelunit7 = DataCanbus.DATA[52];
                int tempunit7 = DataCanbus.DATA[53];
                int distanceunit5 = DataCanbus.DATA[54];
                int timeformat5 = DataCanbus.DATA[55];
                int language5 = DataCanbus.DATA[56];
                int distanceunit6 = distanceunit5 - 1;
                if (distanceunit6 < 0) {
                    distanceunit6 = 1;
                }
                int value5 = ((fuelunit7 << 6) & 192) | ((tempunit7 << 5) & 32) | ((distanceunit6 << 4) & 16) | ((timeformat5 << 3) & 8) | (language5 & 7);
                setCarInfo(value5);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int fuelunit8 = DataCanbus.DATA[52];
                int tempunit8 = DataCanbus.DATA[53];
                int distanceunit7 = DataCanbus.DATA[54];
                int timeformat6 = DataCanbus.DATA[55];
                int language6 = DataCanbus.DATA[56];
                int distanceunit8 = distanceunit7 + 1;
                if (distanceunit8 > 1) {
                    distanceunit8 = 0;
                }
                int value6 = ((fuelunit8 << 6) & 192) | ((tempunit8 << 5) & 32) | ((distanceunit8 << 4) & 16) | ((timeformat6 << 3) & 8) | (language6 & 7);
                setCarInfo(value6);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int fuelunit9 = DataCanbus.DATA[52];
                int tempunit9 = DataCanbus.DATA[53];
                int distanceunit9 = DataCanbus.DATA[54];
                int timeformat7 = DataCanbus.DATA[55];
                int language7 = DataCanbus.DATA[56];
                int timeformat8 = timeformat7 - 1;
                if (timeformat8 < 0) {
                    timeformat8 = 1;
                }
                int value7 = ((fuelunit9 << 6) & 192) | ((tempunit9 << 5) & 32) | ((distanceunit9 << 4) & 16) | ((timeformat8 << 3) & 8) | (language7 & 7);
                setCarInfo(value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int fuelunit10 = DataCanbus.DATA[52];
                int tempunit10 = DataCanbus.DATA[53];
                int distanceunit10 = DataCanbus.DATA[54];
                int timeformat9 = DataCanbus.DATA[55];
                int language8 = DataCanbus.DATA[56];
                int timeformat10 = timeformat9 + 1;
                if (timeformat10 > 1) {
                    timeformat10 = 0;
                }
                int value8 = ((fuelunit10 << 6) & 192) | ((tempunit10 << 5) & 32) | ((distanceunit10 << 4) & 16) | ((timeformat10 << 3) & 8) | (language8 & 7);
                setCarInfo(value8);
                break;
        }
    }

    public void setCarInfo(int value1) {
        DataCanbus.PROXY.cmd(6, new int[]{value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
    }
}
